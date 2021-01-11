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
import com.google.cloud.compute.v1.stub.TargetPoolsStub;
import com.google.cloud.compute.v1.stub.TargetPoolsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The TargetPools API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String targetPool = "";
 *   TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource = TargetPoolsAddHealthCheckRequest.newBuilder().build();
 *   Operation response = targetPoolsClient.addHealthCheck(project, region, targetPool, targetPoolsAddHealthCheckRequestResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the targetPoolsClient object to clean up resources such as
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
 * <pre>
 * <code>
 * TargetPoolsSettings targetPoolsSettings =
 *     TargetPoolsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TargetPoolsClient targetPoolsClient =
 *     TargetPoolsClient.create(targetPoolsSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * TargetPoolsSettings targetPoolsSettings =
 *     TargetPoolsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TargetPoolsClient targetPoolsClient =
 *     TargetPoolsClient.create(targetPoolsSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
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
   * advanced usage - prefer to use TargetPoolsSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected TargetPoolsClient(TargetPoolsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TargetPoolsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TargetPoolsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds health check URLs to a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource = TargetPoolsAddHealthCheckRequest.newBuilder().build();
   *   Operation response = targetPoolsClient.addHealthCheck(project, region, targetPool, targetPoolsAddHealthCheckRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetPool Name of the target pool to add a health check to.
   * @param targetPoolsAddHealthCheckRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addHealthCheck(
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
    return addHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds health check URLs to a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource = TargetPoolsAddHealthCheckRequest.newBuilder().build();
   *   AddHealthCheckTargetPoolRequest request = AddHealthCheckTargetPoolRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetPool(targetPool)
   *     .setTargetPoolsAddHealthCheckRequestResource(targetPoolsAddHealthCheckRequestResource)
   *     .build();
   *   Operation response = targetPoolsClient.addHealthCheck(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addHealthCheck(AddHealthCheckTargetPoolRequest request) {
    return addHealthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds health check URLs to a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   TargetPoolsAddHealthCheckRequest targetPoolsAddHealthCheckRequestResource = TargetPoolsAddHealthCheckRequest.newBuilder().build();
   *   AddHealthCheckTargetPoolRequest request = AddHealthCheckTargetPoolRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetPool(targetPool)
   *     .setTargetPoolsAddHealthCheckRequestResource(targetPoolsAddHealthCheckRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetPoolsClient.addHealthCheckCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AddHealthCheckTargetPoolRequest, Operation> addHealthCheckCallable() {
    return stub.addHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an instance to a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   TargetPoolsAddInstanceRequest targetPoolsAddInstanceRequestResource = TargetPoolsAddInstanceRequest.newBuilder().build();
   *   Operation response = targetPoolsClient.addInstance(project, region, targetPool, targetPoolsAddInstanceRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetPool Name of the TargetPool resource to add instances to.
   * @param targetPoolsAddInstanceRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addInstance(
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
    return addInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an instance to a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   TargetPoolsAddInstanceRequest targetPoolsAddInstanceRequestResource = TargetPoolsAddInstanceRequest.newBuilder().build();
   *   AddInstanceTargetPoolRequest request = AddInstanceTargetPoolRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetPool(targetPool)
   *     .setTargetPoolsAddInstanceRequestResource(targetPoolsAddInstanceRequestResource)
   *     .build();
   *   Operation response = targetPoolsClient.addInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation addInstance(AddInstanceTargetPoolRequest request) {
    return addInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an instance to a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   TargetPoolsAddInstanceRequest targetPoolsAddInstanceRequestResource = TargetPoolsAddInstanceRequest.newBuilder().build();
   *   AddInstanceTargetPoolRequest request = AddInstanceTargetPoolRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetPool(targetPool)
   *     .setTargetPoolsAddInstanceRequestResource(targetPoolsAddInstanceRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetPoolsClient.addInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AddInstanceTargetPoolRequest, Operation> addInstanceCallable() {
    return stub.addInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target pools.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, TargetPoolsScopedList&gt; element : targetPoolsClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListTargetPoolsRequest request =
        AggregatedListTargetPoolsRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target pools.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   AggregatedListTargetPoolsRequest request = AggregatedListTargetPoolsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, TargetPoolsScopedList&gt; element : targetPoolsClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListTargetPoolsRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target pools.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   AggregatedListTargetPoolsRequest request = AggregatedListTargetPoolsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = targetPoolsClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, TargetPoolsScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListTargetPoolsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of target pools.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   AggregatedListTargetPoolsRequest request = AggregatedListTargetPoolsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     TargetPoolAggregatedList response = targetPoolsClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, TargetPoolsScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListTargetPoolsRequest, TargetPoolAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   Operation response = targetPoolsClient.delete(project, region, targetPool);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetPool Name of the TargetPool resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String targetPool) {
    DeleteTargetPoolRequest request =
        DeleteTargetPoolRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetPool(targetPool)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   DeleteTargetPoolRequest request = DeleteTargetPoolRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetPool(targetPool)
   *     .build();
   *   Operation response = targetPoolsClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteTargetPoolRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   DeleteTargetPoolRequest request = DeleteTargetPoolRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetPool(targetPool)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetPoolsClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteTargetPoolRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified target pool. Gets a list of available target pools by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   TargetPool response = targetPoolsClient.get(project, region, targetPool);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified target pool. Gets a list of available target pools by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   GetTargetPoolRequest request = GetTargetPoolRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetPool(targetPool)
   *     .build();
   *   TargetPool response = targetPoolsClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetPool get(GetTargetPoolRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified target pool. Gets a list of available target pools by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   GetTargetPoolRequest request = GetTargetPoolRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetPool(targetPool)
   *     .build();
   *   ApiFuture&lt;TargetPool&gt; future = targetPoolsClient.getCallable().futureCall(request);
   *   // Do something
   *   TargetPool response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetTargetPoolRequest, TargetPool> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the most recent health check results for each IP for the instance that is referenced by
   * the given target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   InstanceReference instanceReferenceResource = InstanceReference.newBuilder().build();
   *   TargetPoolInstanceHealth response = targetPoolsClient.getHealth(project, region, targetPool, instanceReferenceResource);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the most recent health check results for each IP for the instance that is referenced by
   * the given target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   InstanceReference instanceReferenceResource = InstanceReference.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   GetHealthTargetPoolRequest request = GetHealthTargetPoolRequest.newBuilder()
   *     .setInstanceReferenceResource(instanceReferenceResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetPool(targetPool)
   *     .build();
   *   TargetPoolInstanceHealth response = targetPoolsClient.getHealth(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetPoolInstanceHealth getHealth(GetHealthTargetPoolRequest request) {
    return getHealthCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the most recent health check results for each IP for the instance that is referenced by
   * the given target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   InstanceReference instanceReferenceResource = InstanceReference.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   GetHealthTargetPoolRequest request = GetHealthTargetPoolRequest.newBuilder()
   *     .setInstanceReferenceResource(instanceReferenceResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetPool(targetPool)
   *     .build();
   *   ApiFuture&lt;TargetPoolInstanceHealth&gt; future = targetPoolsClient.getHealthCallable().futureCall(request);
   *   // Do something
   *   TargetPoolInstanceHealth response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetHealthTargetPoolRequest, TargetPoolInstanceHealth>
      getHealthCallable() {
    return stub.getHealthCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a target pool in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   TargetPool targetPoolResource = TargetPool.newBuilder().build();
   *   Operation response = targetPoolsClient.insert(project, region, targetPoolResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetPoolResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, String region, TargetPool targetPoolResource) {
    InsertTargetPoolRequest request =
        InsertTargetPoolRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetPoolResource(targetPoolResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a target pool in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   TargetPool targetPoolResource = TargetPool.newBuilder().build();
   *   InsertTargetPoolRequest request = InsertTargetPoolRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetPoolResource(targetPoolResource)
   *     .build();
   *   Operation response = targetPoolsClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertTargetPoolRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a target pool in the specified project and region using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   TargetPool targetPoolResource = TargetPool.newBuilder().build();
   *   InsertTargetPoolRequest request = InsertTargetPoolRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetPoolResource(targetPoolResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetPoolsClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertTargetPoolRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of target pools available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (TargetPool element : targetPoolsClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of target pools available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListTargetPoolsRequest request = ListTargetPoolsRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (TargetPool element : targetPoolsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListTargetPoolsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of target pools available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListTargetPoolsRequest request = ListTargetPoolsRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = targetPoolsClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (TargetPool element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListTargetPoolsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of target pools available to the specified project and region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListTargetPoolsRequest request = ListTargetPoolsRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
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
   * </code></pre>
   */
  public final UnaryCallable<ListTargetPoolsRequest, TargetPoolList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes health check URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   TargetPoolsRemoveHealthCheckRequest targetPoolsRemoveHealthCheckRequestResource = TargetPoolsRemoveHealthCheckRequest.newBuilder().build();
   *   Operation response = targetPoolsClient.removeHealthCheck(project, region, targetPool, targetPoolsRemoveHealthCheckRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param targetPool Name of the target pool to remove health checks from.
   * @param targetPoolsRemoveHealthCheckRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removeHealthCheck(
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
    return removeHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes health check URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   TargetPoolsRemoveHealthCheckRequest targetPoolsRemoveHealthCheckRequestResource = TargetPoolsRemoveHealthCheckRequest.newBuilder().build();
   *   RemoveHealthCheckTargetPoolRequest request = RemoveHealthCheckTargetPoolRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetPool(targetPool)
   *     .setTargetPoolsRemoveHealthCheckRequestResource(targetPoolsRemoveHealthCheckRequestResource)
   *     .build();
   *   Operation response = targetPoolsClient.removeHealthCheck(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removeHealthCheck(RemoveHealthCheckTargetPoolRequest request) {
    return removeHealthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes health check URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   TargetPoolsRemoveHealthCheckRequest targetPoolsRemoveHealthCheckRequestResource = TargetPoolsRemoveHealthCheckRequest.newBuilder().build();
   *   RemoveHealthCheckTargetPoolRequest request = RemoveHealthCheckTargetPoolRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetPool(targetPool)
   *     .setTargetPoolsRemoveHealthCheckRequestResource(targetPoolsRemoveHealthCheckRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetPoolsClient.removeHealthCheckCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RemoveHealthCheckTargetPoolRequest, Operation>
      removeHealthCheckCallable() {
    return stub.removeHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes instance URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   TargetPoolsRemoveInstanceRequest targetPoolsRemoveInstanceRequestResource = TargetPoolsRemoveInstanceRequest.newBuilder().build();
   *   Operation response = targetPoolsClient.removeInstance(project, region, targetPool, targetPoolsRemoveInstanceRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetPool Name of the TargetPool resource to remove instances from.
   * @param targetPoolsRemoveInstanceRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removeInstance(
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
    return removeInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes instance URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   TargetPoolsRemoveInstanceRequest targetPoolsRemoveInstanceRequestResource = TargetPoolsRemoveInstanceRequest.newBuilder().build();
   *   RemoveInstanceTargetPoolRequest request = RemoveInstanceTargetPoolRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetPool(targetPool)
   *     .setTargetPoolsRemoveInstanceRequestResource(targetPoolsRemoveInstanceRequestResource)
   *     .build();
   *   Operation response = targetPoolsClient.removeInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation removeInstance(RemoveInstanceTargetPoolRequest request) {
    return removeInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes instance URL from a target pool.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   TargetPoolsRemoveInstanceRequest targetPoolsRemoveInstanceRequestResource = TargetPoolsRemoveInstanceRequest.newBuilder().build();
   *   RemoveInstanceTargetPoolRequest request = RemoveInstanceTargetPoolRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetPool(targetPool)
   *     .setTargetPoolsRemoveInstanceRequestResource(targetPoolsRemoveInstanceRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetPoolsClient.removeInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RemoveInstanceTargetPoolRequest, Operation> removeInstanceCallable() {
    return stub.removeInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes a backup target pool's configurations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   Operation response = targetPoolsClient.setBackup(project, region, targetPool, targetReferenceResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetPool Name of the TargetPool resource to set a backup pool for.
   * @param targetReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setBackup(
      String project, String region, String targetPool, TargetReference targetReferenceResource) {
    SetBackupTargetPoolRequest request =
        SetBackupTargetPoolRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetPool(targetPool)
            .setTargetReferenceResource(targetReferenceResource)
            .build();
    return setBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes a backup target pool's configurations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   SetBackupTargetPoolRequest request = SetBackupTargetPoolRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetPool(targetPool)
   *     .setTargetReferenceResource(targetReferenceResource)
   *     .build();
   *   Operation response = targetPoolsClient.setBackup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setBackup(SetBackupTargetPoolRequest request) {
    return setBackupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes a backup target pool's configurations.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetPoolsClient targetPoolsClient = TargetPoolsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetPool = "";
   *   TargetReference targetReferenceResource = TargetReference.newBuilder().build();
   *   SetBackupTargetPoolRequest request = SetBackupTargetPoolRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetPool(targetPool)
   *     .setTargetReferenceResource(targetReferenceResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetPoolsClient.setBackupCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
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
          Entry<String, TargetPoolsScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListTargetPoolsRequest,
                TargetPoolAggregatedList,
                Entry<String, TargetPoolsScopedList>>
            context,
        ApiFuture<TargetPoolAggregatedList> futureResponse) {
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
          AggregatedListTargetPoolsRequest,
          TargetPoolAggregatedList,
          Entry<String, TargetPoolsScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListTargetPoolsRequest,
                TargetPoolAggregatedList,
                Entry<String, TargetPoolsScopedList>>
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
                Entry<String, TargetPoolsScopedList>>
            context,
        TargetPoolAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListTargetPoolsRequest,
                TargetPoolAggregatedList,
                Entry<String, TargetPoolsScopedList>>
            context,
        ApiFuture<TargetPoolAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListTargetPoolsRequest,
          TargetPoolAggregatedList,
          Entry<String, TargetPoolsScopedList>,
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
