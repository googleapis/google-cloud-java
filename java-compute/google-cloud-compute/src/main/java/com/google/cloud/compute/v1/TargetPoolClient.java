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
import com.google.cloud.compute.v1.stub.TargetPoolStub;
import com.google.cloud.compute.v1.stub.TargetPoolStubSettings;
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
 * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
 *   ProjectRegionTargetPoolName targetPool = ProjectRegionTargetPoolName.of("[PROJECT]", "[REGION]", "[TARGET_POOL]");
 *   TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource = TargetPoolsAddHealthCheckRequest.newBuilder().build();
 *   Operation response = targetPoolClient.addHealthCheckTargetPool(targetPool, targetPoolsAddHealthCheckRequestResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the targetPoolClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of TargetPoolSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * TargetPoolSettings targetPoolSettings =
 *     TargetPoolSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TargetPoolClient targetPoolClient =
 *     TargetPoolClient.create(targetPoolSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * TargetPoolSettings targetPoolSettings =
 *     TargetPoolSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TargetPoolClient targetPoolClient =
 *     TargetPoolClient.create(targetPoolSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class TargetPoolClient implements BackgroundResource {
  private final TargetPoolSettings settings;
  private final TargetPoolStub stub;

  /** Constructs an instance of TargetPoolClient with default settings. */
  public static final TargetPoolClient create() throws IOException {
    return create(TargetPoolSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TargetPoolClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TargetPoolClient create(TargetPoolSettings settings) throws IOException {
    return new TargetPoolClient(settings);
  }

  /**
   * Constructs an instance of TargetPoolClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use TargetPoolSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final TargetPoolClient create(TargetPoolStub stub) {
    return new TargetPoolClient(stub);
  }

  /**
   * Constructs an instance of TargetPoolClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected TargetPoolClient(TargetPoolSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TargetPoolStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected TargetPoolClient(TargetPoolStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TargetPoolSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TargetPoolStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds health check URLs to a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionTargetPoolName targetPool = ProjectRegionTargetPoolName.of("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource = TargetPoolsAddHealthCheckRequest.newBuilder().build();
   *   Operation response = targetPoolClient.addHealthCheckTargetPool(targetPool, targetPoolsAddHealthCheckRequestResource);
   * }
   * </code></pre>
   *
   * @param targetPool Name of the target pool to add a health check to.
   * @param targetPoolsAddHealthCheckRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addHealthCheckTargetPool(
      ProjectRegionTargetPoolName targetPool,
      TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource) {

    AddHealthCheckTargetPoolHttpRequest request =
        AddHealthCheckTargetPoolHttpRequest.newBuilder()
            .setTargetPool(targetPool == null ? null : targetPool.toString())
            .setTargetPoolsAddHealthCheckRequestResource(targetPoolsAddHealthCheckRequestResource)
            .build();
    return addHealthCheckTargetPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds health check URLs to a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionTargetPoolName targetPool = ProjectRegionTargetPoolName.of("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource = TargetPoolsAddHealthCheckRequest.newBuilder().build();
   *   Operation response = targetPoolClient.addHealthCheckTargetPool(targetPool.toString(), targetPoolsAddHealthCheckRequestResource);
   * }
   * </code></pre>
   *
   * @param targetPool Name of the target pool to add a health check to.
   * @param targetPoolsAddHealthCheckRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addHealthCheckTargetPool(
      String targetPool,
      TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource) {

    AddHealthCheckTargetPoolHttpRequest request =
        AddHealthCheckTargetPoolHttpRequest.newBuilder()
            .setTargetPool(targetPool)
            .setTargetPoolsAddHealthCheckRequestResource(targetPoolsAddHealthCheckRequestResource)
            .build();
    return addHealthCheckTargetPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds health check URLs to a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedTargetPool = ProjectRegionTargetPoolName.format("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource = TargetPoolsAddHealthCheckRequest.newBuilder().build();
   *   AddHealthCheckTargetPoolHttpRequest request = AddHealthCheckTargetPoolHttpRequest.newBuilder()
   *     .setTargetPool(formattedTargetPool)
   *     .setTargetPoolsAddHealthCheckRequestResource(targetPoolsAddHealthCheckRequestResource)
   *     .build();
   *   Operation response = targetPoolClient.addHealthCheckTargetPool(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addHealthCheckTargetPool(AddHealthCheckTargetPoolHttpRequest request) {
    return addHealthCheckTargetPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds health check URLs to a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedTargetPool = ProjectRegionTargetPoolName.format("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource = TargetPoolsAddHealthCheckRequest.newBuilder().build();
   *   AddHealthCheckTargetPoolHttpRequest request = AddHealthCheckTargetPoolHttpRequest.newBuilder()
   *     .setTargetPool(formattedTargetPool)
   *     .setTargetPoolsAddHealthCheckRequestResource(targetPoolsAddHealthCheckRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetPoolClient.addHealthCheckTargetPoolCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<AddHealthCheckTargetPoolHttpRequest, Operation>
      addHealthCheckTargetPoolCallable() {
    return stub.addHealthCheckTargetPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an instance to a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionTargetPoolName targetPool = ProjectRegionTargetPoolName.of("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   TargetPoolsAddInstanceRequest targetPoolsAddInstanceRequestResource = TargetPoolsAddInstanceRequest.newBuilder().build();
   *   Operation response = targetPoolClient.addInstanceTargetPool(targetPool, targetPoolsAddInstanceRequestResource);
   * }
   * </code></pre>
   *
   * @param targetPool Name of the TargetPool resource to add instances to.
   * @param targetPoolsAddInstanceRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addInstanceTargetPool(
      ProjectRegionTargetPoolName targetPool,
      TargetPoolsAddInstanceRequest targetPoolsAddInstanceRequestResource) {

    AddInstanceTargetPoolHttpRequest request =
        AddInstanceTargetPoolHttpRequest.newBuilder()
            .setTargetPool(targetPool == null ? null : targetPool.toString())
            .setTargetPoolsAddInstanceRequestResource(targetPoolsAddInstanceRequestResource)
            .build();
    return addInstanceTargetPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an instance to a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionTargetPoolName targetPool = ProjectRegionTargetPoolName.of("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   TargetPoolsAddInstanceRequest targetPoolsAddInstanceRequestResource = TargetPoolsAddInstanceRequest.newBuilder().build();
   *   Operation response = targetPoolClient.addInstanceTargetPool(targetPool.toString(), targetPoolsAddInstanceRequestResource);
   * }
   * </code></pre>
   *
   * @param targetPool Name of the TargetPool resource to add instances to.
   * @param targetPoolsAddInstanceRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addInstanceTargetPool(
      String targetPool, TargetPoolsAddInstanceRequest targetPoolsAddInstanceRequestResource) {

    AddInstanceTargetPoolHttpRequest request =
        AddInstanceTargetPoolHttpRequest.newBuilder()
            .setTargetPool(targetPool)
            .setTargetPoolsAddInstanceRequestResource(targetPoolsAddInstanceRequestResource)
            .build();
    return addInstanceTargetPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an instance to a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedTargetPool = ProjectRegionTargetPoolName.format("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   TargetPoolsAddInstanceRequest targetPoolsAddInstanceRequestResource = TargetPoolsAddInstanceRequest.newBuilder().build();
   *   AddInstanceTargetPoolHttpRequest request = AddInstanceTargetPoolHttpRequest.newBuilder()
   *     .setTargetPool(formattedTargetPool)
   *     .setTargetPoolsAddInstanceRequestResource(targetPoolsAddInstanceRequestResource)
   *     .build();
   *   Operation response = targetPoolClient.addInstanceTargetPool(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addInstanceTargetPool(AddInstanceTargetPoolHttpRequest request) {
    return addInstanceTargetPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an instance to a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedTargetPool = ProjectRegionTargetPoolName.format("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   TargetPoolsAddInstanceRequest targetPoolsAddInstanceRequestResource = TargetPoolsAddInstanceRequest.newBuilder().build();
   *   AddInstanceTargetPoolHttpRequest request = AddInstanceTargetPoolHttpRequest.newBuilder()
   *     .setTargetPool(formattedTargetPool)
   *     .setTargetPoolsAddInstanceRequestResource(targetPoolsAddInstanceRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetPoolClient.addInstanceTargetPoolCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<AddInstanceTargetPoolHttpRequest, Operation>
      addInstanceTargetPoolCallable() {
    return stub.addInstanceTargetPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target pools.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (TargetPoolsScopedList element : targetPoolClient.aggregatedListTargetPools(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListTargetPoolsPagedResponse aggregatedListTargetPools(
      ProjectName project) {
    AggregatedListTargetPoolsHttpRequest request =
        AggregatedListTargetPoolsHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListTargetPools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target pools.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (TargetPoolsScopedList element : targetPoolClient.aggregatedListTargetPools(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListTargetPoolsPagedResponse aggregatedListTargetPools(String project) {
    AggregatedListTargetPoolsHttpRequest request =
        AggregatedListTargetPoolsHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListTargetPools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target pools.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListTargetPoolsHttpRequest request = AggregatedListTargetPoolsHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   for (TargetPoolsScopedList element : targetPoolClient.aggregatedListTargetPools(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListTargetPoolsPagedResponse aggregatedListTargetPools(
      AggregatedListTargetPoolsHttpRequest request) {
    return aggregatedListTargetPoolsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target pools.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListTargetPoolsHttpRequest request = AggregatedListTargetPoolsHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   ApiFuture&lt;AggregatedListTargetPoolsPagedResponse&gt; future = targetPoolClient.aggregatedListTargetPoolsPagedCallable().futureCall(request);
   *   // Do something
   *   for (TargetPoolsScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListTargetPoolsHttpRequest, AggregatedListTargetPoolsPagedResponse>
      aggregatedListTargetPoolsPagedCallable() {
    return stub.aggregatedListTargetPoolsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target pools.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListTargetPoolsHttpRequest request = AggregatedListTargetPoolsHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   while (true) {
   *     TargetPoolAggregatedList response = targetPoolClient.aggregatedListTargetPoolsCallable().call(request);
   *     for (TargetPoolsScopedList element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListTargetPoolsHttpRequest, TargetPoolAggregatedList>
      aggregatedListTargetPoolsCallable() {
    return stub.aggregatedListTargetPoolsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionTargetPoolName targetPool = ProjectRegionTargetPoolName.of("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   Operation response = targetPoolClient.deleteTargetPool(targetPool);
   * }
   * </code></pre>
   *
   * @param targetPool Name of the TargetPool resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteTargetPool(ProjectRegionTargetPoolName targetPool) {

    DeleteTargetPoolHttpRequest request =
        DeleteTargetPoolHttpRequest.newBuilder()
            .setTargetPool(targetPool == null ? null : targetPool.toString())
            .build();
    return deleteTargetPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionTargetPoolName targetPool = ProjectRegionTargetPoolName.of("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   Operation response = targetPoolClient.deleteTargetPool(targetPool.toString());
   * }
   * </code></pre>
   *
   * @param targetPool Name of the TargetPool resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteTargetPool(String targetPool) {

    DeleteTargetPoolHttpRequest request =
        DeleteTargetPoolHttpRequest.newBuilder().setTargetPool(targetPool).build();
    return deleteTargetPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedTargetPool = ProjectRegionTargetPoolName.format("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   DeleteTargetPoolHttpRequest request = DeleteTargetPoolHttpRequest.newBuilder()
   *     .setTargetPool(formattedTargetPool)
   *     .build();
   *   Operation response = targetPoolClient.deleteTargetPool(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteTargetPool(DeleteTargetPoolHttpRequest request) {
    return deleteTargetPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedTargetPool = ProjectRegionTargetPoolName.format("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   DeleteTargetPoolHttpRequest request = DeleteTargetPoolHttpRequest.newBuilder()
   *     .setTargetPool(formattedTargetPool)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetPoolClient.deleteTargetPoolCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteTargetPoolHttpRequest, Operation> deleteTargetPoolCallable() {
    return stub.deleteTargetPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified target pool. Gets a list of available target pools by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionTargetPoolName targetPool = ProjectRegionTargetPoolName.of("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   TargetPool response = targetPoolClient.getTargetPool(targetPool);
   * }
   * </code></pre>
   *
   * @param targetPool Name of the TargetPool resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetPool getTargetPool(ProjectRegionTargetPoolName targetPool) {

    GetTargetPoolHttpRequest request =
        GetTargetPoolHttpRequest.newBuilder()
            .setTargetPool(targetPool == null ? null : targetPool.toString())
            .build();
    return getTargetPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified target pool. Gets a list of available target pools by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionTargetPoolName targetPool = ProjectRegionTargetPoolName.of("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   TargetPool response = targetPoolClient.getTargetPool(targetPool.toString());
   * }
   * </code></pre>
   *
   * @param targetPool Name of the TargetPool resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetPool getTargetPool(String targetPool) {

    GetTargetPoolHttpRequest request =
        GetTargetPoolHttpRequest.newBuilder().setTargetPool(targetPool).build();
    return getTargetPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified target pool. Gets a list of available target pools by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedTargetPool = ProjectRegionTargetPoolName.format("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   GetTargetPoolHttpRequest request = GetTargetPoolHttpRequest.newBuilder()
   *     .setTargetPool(formattedTargetPool)
   *     .build();
   *   TargetPool response = targetPoolClient.getTargetPool(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetPool getTargetPool(GetTargetPoolHttpRequest request) {
    return getTargetPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified target pool. Gets a list of available target pools by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedTargetPool = ProjectRegionTargetPoolName.format("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   GetTargetPoolHttpRequest request = GetTargetPoolHttpRequest.newBuilder()
   *     .setTargetPool(formattedTargetPool)
   *     .build();
   *   ApiFuture&lt;TargetPool&gt; future = targetPoolClient.getTargetPoolCallable().futureCall(request);
   *   // Do something
   *   TargetPool response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetTargetPoolHttpRequest, TargetPool> getTargetPoolCallable() {
    return stub.getTargetPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the most recent health check results for each IP for the instance that is referenced by
   * the given target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionTargetPoolName targetPool = ProjectRegionTargetPoolName.of("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   InstanceReference instanceReferenceResource = InstanceReference.newBuilder().build();
   *   TargetPoolInstanceHealth response = targetPoolClient.getHealthTargetPool(targetPool, instanceReferenceResource);
   * }
   * </code></pre>
   *
   * @param targetPool Name of the TargetPool resource to which the queried instance belongs.
   * @param instanceReferenceResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetPoolInstanceHealth getHealthTargetPool(
      ProjectRegionTargetPoolName targetPool, InstanceReference instanceReferenceResource) {

    GetHealthTargetPoolHttpRequest request =
        GetHealthTargetPoolHttpRequest.newBuilder()
            .setTargetPool(targetPool == null ? null : targetPool.toString())
            .setInstanceReferenceResource(instanceReferenceResource)
            .build();
    return getHealthTargetPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the most recent health check results for each IP for the instance that is referenced by
   * the given target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionTargetPoolName targetPool = ProjectRegionTargetPoolName.of("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   InstanceReference instanceReferenceResource = InstanceReference.newBuilder().build();
   *   TargetPoolInstanceHealth response = targetPoolClient.getHealthTargetPool(targetPool.toString(), instanceReferenceResource);
   * }
   * </code></pre>
   *
   * @param targetPool Name of the TargetPool resource to which the queried instance belongs.
   * @param instanceReferenceResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetPoolInstanceHealth getHealthTargetPool(
      String targetPool, InstanceReference instanceReferenceResource) {

    GetHealthTargetPoolHttpRequest request =
        GetHealthTargetPoolHttpRequest.newBuilder()
            .setTargetPool(targetPool)
            .setInstanceReferenceResource(instanceReferenceResource)
            .build();
    return getHealthTargetPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the most recent health check results for each IP for the instance that is referenced by
   * the given target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedTargetPool = ProjectRegionTargetPoolName.format("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   InstanceReference instanceReferenceResource = InstanceReference.newBuilder().build();
   *   GetHealthTargetPoolHttpRequest request = GetHealthTargetPoolHttpRequest.newBuilder()
   *     .setTargetPool(formattedTargetPool)
   *     .setInstanceReferenceResource(instanceReferenceResource)
   *     .build();
   *   TargetPoolInstanceHealth response = targetPoolClient.getHealthTargetPool(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetPoolInstanceHealth getHealthTargetPool(
      GetHealthTargetPoolHttpRequest request) {
    return getHealthTargetPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the most recent health check results for each IP for the instance that is referenced by
   * the given target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedTargetPool = ProjectRegionTargetPoolName.format("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   InstanceReference instanceReferenceResource = InstanceReference.newBuilder().build();
   *   GetHealthTargetPoolHttpRequest request = GetHealthTargetPoolHttpRequest.newBuilder()
   *     .setTargetPool(formattedTargetPool)
   *     .setInstanceReferenceResource(instanceReferenceResource)
   *     .build();
   *   ApiFuture&lt;TargetPoolInstanceHealth&gt; future = targetPoolClient.getHealthTargetPoolCallable().futureCall(request);
   *   // Do something
   *   TargetPoolInstanceHealth response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetHealthTargetPoolHttpRequest, TargetPoolInstanceHealth>
      getHealthTargetPoolCallable() {
    return stub.getHealthTargetPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a target pool in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   TargetPool targetPoolResource = TargetPool.newBuilder().build();
   *   Operation response = targetPoolClient.insertTargetPool(region, targetPoolResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param targetPoolResource A TargetPool resource. This resource defines a pool of instances, an
   *     associated HttpHealthCheck resource, and the fallback target pool. (== resource_for
   *     beta.targetPools ==) (== resource_for v1.targetPools ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertTargetPool(ProjectRegionName region, TargetPool targetPoolResource) {

    InsertTargetPoolHttpRequest request =
        InsertTargetPoolHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setTargetPoolResource(targetPoolResource)
            .build();
    return insertTargetPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a target pool in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   TargetPool targetPoolResource = TargetPool.newBuilder().build();
   *   Operation response = targetPoolClient.insertTargetPool(region.toString(), targetPoolResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param targetPoolResource A TargetPool resource. This resource defines a pool of instances, an
   *     associated HttpHealthCheck resource, and the fallback target pool. (== resource_for
   *     beta.targetPools ==) (== resource_for v1.targetPools ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertTargetPool(String region, TargetPool targetPoolResource) {

    InsertTargetPoolHttpRequest request =
        InsertTargetPoolHttpRequest.newBuilder()
            .setRegion(region)
            .setTargetPoolResource(targetPoolResource)
            .build();
    return insertTargetPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a target pool in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   TargetPool targetPoolResource = TargetPool.newBuilder().build();
   *   InsertTargetPoolHttpRequest request = InsertTargetPoolHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setTargetPoolResource(targetPoolResource)
   *     .build();
   *   Operation response = targetPoolClient.insertTargetPool(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertTargetPool(InsertTargetPoolHttpRequest request) {
    return insertTargetPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a target pool in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   TargetPool targetPoolResource = TargetPool.newBuilder().build();
   *   InsertTargetPoolHttpRequest request = InsertTargetPoolHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setTargetPoolResource(targetPoolResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetPoolClient.insertTargetPoolCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertTargetPoolHttpRequest, Operation> insertTargetPoolCallable() {
    return stub.insertTargetPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of target pools available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (TargetPool element : targetPoolClient.listTargetPools(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListTargetPoolsPagedResponse listTargetPools(ProjectRegionName region) {
    ListTargetPoolsHttpRequest request =
        ListTargetPoolsHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listTargetPools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of target pools available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (TargetPool element : targetPoolClient.listTargetPools(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListTargetPoolsPagedResponse listTargetPools(String region) {
    ListTargetPoolsHttpRequest request =
        ListTargetPoolsHttpRequest.newBuilder().setRegion(region).build();
    return listTargetPools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of target pools available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListTargetPoolsHttpRequest request = ListTargetPoolsHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   for (TargetPool element : targetPoolClient.listTargetPools(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListTargetPoolsPagedResponse listTargetPools(ListTargetPoolsHttpRequest request) {
    return listTargetPoolsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of target pools available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListTargetPoolsHttpRequest request = ListTargetPoolsHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   ApiFuture&lt;ListTargetPoolsPagedResponse&gt; future = targetPoolClient.listTargetPoolsPagedCallable().futureCall(request);
   *   // Do something
   *   for (TargetPool element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListTargetPoolsHttpRequest, ListTargetPoolsPagedResponse>
      listTargetPoolsPagedCallable() {
    return stub.listTargetPoolsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of target pools available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListTargetPoolsHttpRequest request = ListTargetPoolsHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   while (true) {
   *     TargetPoolList response = targetPoolClient.listTargetPoolsCallable().call(request);
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
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListTargetPoolsHttpRequest, TargetPoolList> listTargetPoolsCallable() {
    return stub.listTargetPoolsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes health check URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionTargetPoolName targetPool = ProjectRegionTargetPoolName.of("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   TargetPoolsRemoveHealthCheckRequest targetPoolsRemoveHealthCheckRequestResource = TargetPoolsRemoveHealthCheckRequest.newBuilder().build();
   *   Operation response = targetPoolClient.removeHealthCheckTargetPool(targetPool, targetPoolsRemoveHealthCheckRequestResource);
   * }
   * </code></pre>
   *
   * @param targetPool Name of the target pool to remove health checks from.
   * @param targetPoolsRemoveHealthCheckRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation removeHealthCheckTargetPool(
      ProjectRegionTargetPoolName targetPool,
      TargetPoolsRemoveHealthCheckRequest targetPoolsRemoveHealthCheckRequestResource) {

    RemoveHealthCheckTargetPoolHttpRequest request =
        RemoveHealthCheckTargetPoolHttpRequest.newBuilder()
            .setTargetPool(targetPool == null ? null : targetPool.toString())
            .setTargetPoolsRemoveHealthCheckRequestResource(
                targetPoolsRemoveHealthCheckRequestResource)
            .build();
    return removeHealthCheckTargetPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes health check URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionTargetPoolName targetPool = ProjectRegionTargetPoolName.of("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   TargetPoolsRemoveHealthCheckRequest targetPoolsRemoveHealthCheckRequestResource = TargetPoolsRemoveHealthCheckRequest.newBuilder().build();
   *   Operation response = targetPoolClient.removeHealthCheckTargetPool(targetPool.toString(), targetPoolsRemoveHealthCheckRequestResource);
   * }
   * </code></pre>
   *
   * @param targetPool Name of the target pool to remove health checks from.
   * @param targetPoolsRemoveHealthCheckRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation removeHealthCheckTargetPool(
      String targetPool,
      TargetPoolsRemoveHealthCheckRequest targetPoolsRemoveHealthCheckRequestResource) {

    RemoveHealthCheckTargetPoolHttpRequest request =
        RemoveHealthCheckTargetPoolHttpRequest.newBuilder()
            .setTargetPool(targetPool)
            .setTargetPoolsRemoveHealthCheckRequestResource(
                targetPoolsRemoveHealthCheckRequestResource)
            .build();
    return removeHealthCheckTargetPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes health check URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedTargetPool = ProjectRegionTargetPoolName.format("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   TargetPoolsRemoveHealthCheckRequest targetPoolsRemoveHealthCheckRequestResource = TargetPoolsRemoveHealthCheckRequest.newBuilder().build();
   *   RemoveHealthCheckTargetPoolHttpRequest request = RemoveHealthCheckTargetPoolHttpRequest.newBuilder()
   *     .setTargetPool(formattedTargetPool)
   *     .setTargetPoolsRemoveHealthCheckRequestResource(targetPoolsRemoveHealthCheckRequestResource)
   *     .build();
   *   Operation response = targetPoolClient.removeHealthCheckTargetPool(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation removeHealthCheckTargetPool(
      RemoveHealthCheckTargetPoolHttpRequest request) {
    return removeHealthCheckTargetPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes health check URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedTargetPool = ProjectRegionTargetPoolName.format("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   TargetPoolsRemoveHealthCheckRequest targetPoolsRemoveHealthCheckRequestResource = TargetPoolsRemoveHealthCheckRequest.newBuilder().build();
   *   RemoveHealthCheckTargetPoolHttpRequest request = RemoveHealthCheckTargetPoolHttpRequest.newBuilder()
   *     .setTargetPool(formattedTargetPool)
   *     .setTargetPoolsRemoveHealthCheckRequestResource(targetPoolsRemoveHealthCheckRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetPoolClient.removeHealthCheckTargetPoolCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<RemoveHealthCheckTargetPoolHttpRequest, Operation>
      removeHealthCheckTargetPoolCallable() {
    return stub.removeHealthCheckTargetPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes instance URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionTargetPoolName targetPool = ProjectRegionTargetPoolName.of("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   TargetPoolsRemoveInstanceRequest targetPoolsRemoveInstanceRequestResource = TargetPoolsRemoveInstanceRequest.newBuilder().build();
   *   Operation response = targetPoolClient.removeInstanceTargetPool(targetPool, targetPoolsRemoveInstanceRequestResource);
   * }
   * </code></pre>
   *
   * @param targetPool Name of the TargetPool resource to remove instances from.
   * @param targetPoolsRemoveInstanceRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation removeInstanceTargetPool(
      ProjectRegionTargetPoolName targetPool,
      TargetPoolsRemoveInstanceRequest targetPoolsRemoveInstanceRequestResource) {

    RemoveInstanceTargetPoolHttpRequest request =
        RemoveInstanceTargetPoolHttpRequest.newBuilder()
            .setTargetPool(targetPool == null ? null : targetPool.toString())
            .setTargetPoolsRemoveInstanceRequestResource(targetPoolsRemoveInstanceRequestResource)
            .build();
    return removeInstanceTargetPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes instance URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionTargetPoolName targetPool = ProjectRegionTargetPoolName.of("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   TargetPoolsRemoveInstanceRequest targetPoolsRemoveInstanceRequestResource = TargetPoolsRemoveInstanceRequest.newBuilder().build();
   *   Operation response = targetPoolClient.removeInstanceTargetPool(targetPool.toString(), targetPoolsRemoveInstanceRequestResource);
   * }
   * </code></pre>
   *
   * @param targetPool Name of the TargetPool resource to remove instances from.
   * @param targetPoolsRemoveInstanceRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation removeInstanceTargetPool(
      String targetPool,
      TargetPoolsRemoveInstanceRequest targetPoolsRemoveInstanceRequestResource) {

    RemoveInstanceTargetPoolHttpRequest request =
        RemoveInstanceTargetPoolHttpRequest.newBuilder()
            .setTargetPool(targetPool)
            .setTargetPoolsRemoveInstanceRequestResource(targetPoolsRemoveInstanceRequestResource)
            .build();
    return removeInstanceTargetPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes instance URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedTargetPool = ProjectRegionTargetPoolName.format("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   TargetPoolsRemoveInstanceRequest targetPoolsRemoveInstanceRequestResource = TargetPoolsRemoveInstanceRequest.newBuilder().build();
   *   RemoveInstanceTargetPoolHttpRequest request = RemoveInstanceTargetPoolHttpRequest.newBuilder()
   *     .setTargetPool(formattedTargetPool)
   *     .setTargetPoolsRemoveInstanceRequestResource(targetPoolsRemoveInstanceRequestResource)
   *     .build();
   *   Operation response = targetPoolClient.removeInstanceTargetPool(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation removeInstanceTargetPool(RemoveInstanceTargetPoolHttpRequest request) {
    return removeInstanceTargetPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes instance URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedTargetPool = ProjectRegionTargetPoolName.format("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   TargetPoolsRemoveInstanceRequest targetPoolsRemoveInstanceRequestResource = TargetPoolsRemoveInstanceRequest.newBuilder().build();
   *   RemoveInstanceTargetPoolHttpRequest request = RemoveInstanceTargetPoolHttpRequest.newBuilder()
   *     .setTargetPool(formattedTargetPool)
   *     .setTargetPoolsRemoveInstanceRequestResource(targetPoolsRemoveInstanceRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetPoolClient.removeInstanceTargetPoolCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<RemoveInstanceTargetPoolHttpRequest, Operation>
      removeInstanceTargetPoolCallable() {
    return stub.removeInstanceTargetPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes a backup target pool's configurations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionTargetPoolName targetPool = ProjectRegionTargetPoolName.of("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   Float failoverRatio = 0;
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   Operation response = targetPoolClient.setBackupTargetPool(targetPool, failoverRatio, targetReferenceResource);
   * }
   * </code></pre>
   *
   * @param targetPool Name of the TargetPool resource to set a backup pool for.
   * @param failoverRatio New failoverRatio value for the target pool.
   * @param targetReferenceResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setBackupTargetPool(
      ProjectRegionTargetPoolName targetPool,
      Float failoverRatio,
      TargetReference targetReferenceResource) {

    SetBackupTargetPoolHttpRequest request =
        SetBackupTargetPoolHttpRequest.newBuilder()
            .setTargetPool(targetPool == null ? null : targetPool.toString())
            .setFailoverRatio(failoverRatio)
            .setTargetReferenceResource(targetReferenceResource)
            .build();
    return setBackupTargetPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes a backup target pool's configurations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   ProjectRegionTargetPoolName targetPool = ProjectRegionTargetPoolName.of("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   Float failoverRatio = 0;
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   Operation response = targetPoolClient.setBackupTargetPool(targetPool.toString(), failoverRatio, targetReferenceResource);
   * }
   * </code></pre>
   *
   * @param targetPool Name of the TargetPool resource to set a backup pool for.
   * @param failoverRatio New failoverRatio value for the target pool.
   * @param targetReferenceResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setBackupTargetPool(
      String targetPool, Float failoverRatio, TargetReference targetReferenceResource) {

    SetBackupTargetPoolHttpRequest request =
        SetBackupTargetPoolHttpRequest.newBuilder()
            .setTargetPool(targetPool)
            .setFailoverRatio(failoverRatio)
            .setTargetReferenceResource(targetReferenceResource)
            .build();
    return setBackupTargetPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes a backup target pool's configurations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedTargetPool = ProjectRegionTargetPoolName.format("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   Float failoverRatio = 0;
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   SetBackupTargetPoolHttpRequest request = SetBackupTargetPoolHttpRequest.newBuilder()
   *     .setTargetPool(formattedTargetPool)
   *     .setFailoverRatio(failoverRatio)
   *     .setTargetReferenceResource(targetReferenceResource)
   *     .build();
   *   Operation response = targetPoolClient.setBackupTargetPool(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setBackupTargetPool(SetBackupTargetPoolHttpRequest request) {
    return setBackupTargetPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes a backup target pool's configurations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolClient targetPoolClient = TargetPoolClient.create()) {
   *   String formattedTargetPool = ProjectRegionTargetPoolName.format("[PROJECT]", "[REGION]", "[TARGET_POOL]");
   *   Float failoverRatio = 0;
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   SetBackupTargetPoolHttpRequest request = SetBackupTargetPoolHttpRequest.newBuilder()
   *     .setTargetPool(formattedTargetPool)
   *     .setFailoverRatio(failoverRatio)
   *     .setTargetReferenceResource(targetReferenceResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetPoolClient.setBackupTargetPoolCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetBackupTargetPoolHttpRequest, Operation>
      setBackupTargetPoolCallable() {
    return stub.setBackupTargetPoolCallable();
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

  public static class AggregatedListTargetPoolsPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListTargetPoolsHttpRequest,
          TargetPoolAggregatedList,
          TargetPoolsScopedList,
          AggregatedListTargetPoolsPage,
          AggregatedListTargetPoolsFixedSizeCollection> {

    public static ApiFuture<AggregatedListTargetPoolsPagedResponse> createAsync(
        PageContext<
                AggregatedListTargetPoolsHttpRequest,
                TargetPoolAggregatedList,
                TargetPoolsScopedList>
            context,
        ApiFuture<TargetPoolAggregatedList> futureResponse) {
      ApiFuture<AggregatedListTargetPoolsPage> futurePage =
          AggregatedListTargetPoolsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListTargetPoolsPage, AggregatedListTargetPoolsPagedResponse>() {
            @Override
            public AggregatedListTargetPoolsPagedResponse apply(
                AggregatedListTargetPoolsPage input) {
              return new AggregatedListTargetPoolsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListTargetPoolsPagedResponse(AggregatedListTargetPoolsPage page) {
      super(page, AggregatedListTargetPoolsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListTargetPoolsPage
      extends AbstractPage<
          AggregatedListTargetPoolsHttpRequest,
          TargetPoolAggregatedList,
          TargetPoolsScopedList,
          AggregatedListTargetPoolsPage> {

    private AggregatedListTargetPoolsPage(
        PageContext<
                AggregatedListTargetPoolsHttpRequest,
                TargetPoolAggregatedList,
                TargetPoolsScopedList>
            context,
        TargetPoolAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListTargetPoolsPage createEmptyPage() {
      return new AggregatedListTargetPoolsPage(null, null);
    }

    @Override
    protected AggregatedListTargetPoolsPage createPage(
        PageContext<
                AggregatedListTargetPoolsHttpRequest,
                TargetPoolAggregatedList,
                TargetPoolsScopedList>
            context,
        TargetPoolAggregatedList response) {
      return new AggregatedListTargetPoolsPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListTargetPoolsPage> createPageAsync(
        PageContext<
                AggregatedListTargetPoolsHttpRequest,
                TargetPoolAggregatedList,
                TargetPoolsScopedList>
            context,
        ApiFuture<TargetPoolAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListTargetPoolsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListTargetPoolsHttpRequest,
          TargetPoolAggregatedList,
          TargetPoolsScopedList,
          AggregatedListTargetPoolsPage,
          AggregatedListTargetPoolsFixedSizeCollection> {

    private AggregatedListTargetPoolsFixedSizeCollection(
        List<AggregatedListTargetPoolsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListTargetPoolsFixedSizeCollection createEmptyCollection() {
      return new AggregatedListTargetPoolsFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListTargetPoolsFixedSizeCollection createCollection(
        List<AggregatedListTargetPoolsPage> pages, int collectionSize) {
      return new AggregatedListTargetPoolsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTargetPoolsPagedResponse
      extends AbstractPagedListResponse<
          ListTargetPoolsHttpRequest,
          TargetPoolList,
          TargetPool,
          ListTargetPoolsPage,
          ListTargetPoolsFixedSizeCollection> {

    public static ApiFuture<ListTargetPoolsPagedResponse> createAsync(
        PageContext<ListTargetPoolsHttpRequest, TargetPoolList, TargetPool> context,
        ApiFuture<TargetPoolList> futureResponse) {
      ApiFuture<ListTargetPoolsPage> futurePage =
          ListTargetPoolsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTargetPoolsPage, ListTargetPoolsPagedResponse>() {
            @Override
            public ListTargetPoolsPagedResponse apply(ListTargetPoolsPage input) {
              return new ListTargetPoolsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListTargetPoolsPagedResponse(ListTargetPoolsPage page) {
      super(page, ListTargetPoolsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTargetPoolsPage
      extends AbstractPage<
          ListTargetPoolsHttpRequest, TargetPoolList, TargetPool, ListTargetPoolsPage> {

    private ListTargetPoolsPage(
        PageContext<ListTargetPoolsHttpRequest, TargetPoolList, TargetPool> context,
        TargetPoolList response) {
      super(context, response);
    }

    private static ListTargetPoolsPage createEmptyPage() {
      return new ListTargetPoolsPage(null, null);
    }

    @Override
    protected ListTargetPoolsPage createPage(
        PageContext<ListTargetPoolsHttpRequest, TargetPoolList, TargetPool> context,
        TargetPoolList response) {
      return new ListTargetPoolsPage(context, response);
    }

    @Override
    public ApiFuture<ListTargetPoolsPage> createPageAsync(
        PageContext<ListTargetPoolsHttpRequest, TargetPoolList, TargetPool> context,
        ApiFuture<TargetPoolList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTargetPoolsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetPoolsHttpRequest,
          TargetPoolList,
          TargetPool,
          ListTargetPoolsPage,
          ListTargetPoolsFixedSizeCollection> {

    private ListTargetPoolsFixedSizeCollection(
        List<ListTargetPoolsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTargetPoolsFixedSizeCollection createEmptyCollection() {
      return new ListTargetPoolsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTargetPoolsFixedSizeCollection createCollection(
        List<ListTargetPoolsPage> pages, int collectionSize) {
      return new ListTargetPoolsFixedSizeCollection(pages, collectionSize);
    }
  }
}
