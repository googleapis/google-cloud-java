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
import com.google.cloud.compute.v1.stub.HealthChecksStub;
import com.google.cloud.compute.v1.stub.HealthChecksStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The HealthChecks API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
 *   String project = "";
 *   String healthCheck = "";
 *   Operation response = healthChecksClient.delete(project, healthCheck);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the healthChecksClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of HealthChecksSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * HealthChecksSettings healthChecksSettings =
 *     HealthChecksSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * HealthChecksClient healthChecksClient =
 *     HealthChecksClient.create(healthChecksSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * HealthChecksSettings healthChecksSettings =
 *     HealthChecksSettings.newBuilder().setEndpoint(myEndpoint).build();
 * HealthChecksClient healthChecksClient =
 *     HealthChecksClient.create(healthChecksSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class HealthChecksClient implements BackgroundResource {
  private final HealthChecksSettings settings;
  private final HealthChecksStub stub;

  /** Constructs an instance of HealthChecksClient with default settings. */
  public static final HealthChecksClient create() throws IOException {
    return create(HealthChecksSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of HealthChecksClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final HealthChecksClient create(HealthChecksSettings settings) throws IOException {
    return new HealthChecksClient(settings);
  }

  /**
   * Constructs an instance of HealthChecksClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use HealthChecksSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final HealthChecksClient create(HealthChecksStub stub) {
    return new HealthChecksClient(stub);
  }

  /**
   * Constructs an instance of HealthChecksClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HealthChecksClient(HealthChecksSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((HealthChecksStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected HealthChecksClient(HealthChecksStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final HealthChecksSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public HealthChecksStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of all HealthCheck resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, HealthChecksScopedList&gt; element : healthChecksClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Name of the project scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListHealthChecksRequest request =
        AggregatedListHealthChecksRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of all HealthCheck resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String project = "";
   *   AggregatedListHealthChecksRequest request = AggregatedListHealthChecksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, HealthChecksScopedList&gt; element : healthChecksClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListHealthChecksRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of all HealthCheck resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String project = "";
   *   AggregatedListHealthChecksRequest request = AggregatedListHealthChecksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = healthChecksClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, HealthChecksScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListHealthChecksRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of all HealthCheck resources, regional and global, available to the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String project = "";
   *   AggregatedListHealthChecksRequest request = AggregatedListHealthChecksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     HealthChecksAggregatedList response = healthChecksClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, HealthChecksScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListHealthChecksRequest, HealthChecksAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String project = "";
   *   String healthCheck = "";
   *   Operation response = healthChecksClient.delete(project, healthCheck);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param healthCheck Name of the HealthCheck resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String healthCheck) {
    DeleteHealthCheckRequest request =
        DeleteHealthCheckRequest.newBuilder()
            .setProject(project)
            .setHealthCheck(healthCheck)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String healthCheck = "";
   *   String project = "";
   *   DeleteHealthCheckRequest request = DeleteHealthCheckRequest.newBuilder()
   *     .setHealthCheck(healthCheck)
   *     .setProject(project)
   *     .build();
   *   Operation response = healthChecksClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteHealthCheckRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String healthCheck = "";
   *   String project = "";
   *   DeleteHealthCheckRequest request = DeleteHealthCheckRequest.newBuilder()
   *     .setHealthCheck(healthCheck)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = healthChecksClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteHealthCheckRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HealthCheck resource. Gets a list of available health checks by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String project = "";
   *   String healthCheck = "";
   *   HealthCheck response = healthChecksClient.get(project, healthCheck);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param healthCheck Name of the HealthCheck resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HealthCheck get(String project, String healthCheck) {
    GetHealthCheckRequest request =
        GetHealthCheckRequest.newBuilder().setProject(project).setHealthCheck(healthCheck).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HealthCheck resource. Gets a list of available health checks by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String healthCheck = "";
   *   String project = "";
   *   GetHealthCheckRequest request = GetHealthCheckRequest.newBuilder()
   *     .setHealthCheck(healthCheck)
   *     .setProject(project)
   *     .build();
   *   HealthCheck response = healthChecksClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HealthCheck get(GetHealthCheckRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HealthCheck resource. Gets a list of available health checks by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String healthCheck = "";
   *   String project = "";
   *   GetHealthCheckRequest request = GetHealthCheckRequest.newBuilder()
   *     .setHealthCheck(healthCheck)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;HealthCheck&gt; future = healthChecksClient.getCallable().futureCall(request);
   *   // Do something
   *   HealthCheck response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetHealthCheckRequest, HealthCheck> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String project = "";
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   Operation response = healthChecksClient.insert(project, healthCheckResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param healthCheckResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, HealthCheck healthCheckResource) {
    InsertHealthCheckRequest request =
        InsertHealthCheckRequest.newBuilder()
            .setProject(project)
            .setHealthCheckResource(healthCheckResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   String project = "";
   *   InsertHealthCheckRequest request = InsertHealthCheckRequest.newBuilder()
   *     .setHealthCheckResource(healthCheckResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = healthChecksClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertHealthCheckRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   String project = "";
   *   InsertHealthCheckRequest request = InsertHealthCheckRequest.newBuilder()
   *     .setHealthCheckResource(healthCheckResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = healthChecksClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertHealthCheckRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String project = "";
   *   for (HealthCheck element : healthChecksClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListHealthChecksRequest request =
        ListHealthChecksRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String project = "";
   *   ListHealthChecksRequest request = ListHealthChecksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (HealthCheck element : healthChecksClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListHealthChecksRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String project = "";
   *   ListHealthChecksRequest request = ListHealthChecksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = healthChecksClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (HealthCheck element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListHealthChecksRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String project = "";
   *   ListHealthChecksRequest request = ListHealthChecksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     HealthCheckList response = healthChecksClient.listCallable().call(request);
   *     for (HealthCheck element : response.getItemsList()) {
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
  public final UnaryCallable<ListHealthChecksRequest, HealthCheckList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   * This method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String project = "";
   *   String healthCheck = "";
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   Operation response = healthChecksClient.patch(project, healthCheck, healthCheckResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param healthCheck Name of the HealthCheck resource to patch.
   * @param healthCheckResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
      String project, String healthCheck, HealthCheck healthCheckResource) {
    PatchHealthCheckRequest request =
        PatchHealthCheckRequest.newBuilder()
            .setProject(project)
            .setHealthCheck(healthCheck)
            .setHealthCheckResource(healthCheckResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   * This method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String healthCheck = "";
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   String project = "";
   *   PatchHealthCheckRequest request = PatchHealthCheckRequest.newBuilder()
   *     .setHealthCheck(healthCheck)
   *     .setHealthCheckResource(healthCheckResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = healthChecksClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchHealthCheckRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   * This method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String healthCheck = "";
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   String project = "";
   *   PatchHealthCheckRequest request = PatchHealthCheckRequest.newBuilder()
   *     .setHealthCheck(healthCheck)
   *     .setHealthCheckResource(healthCheckResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = healthChecksClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchHealthCheckRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String project = "";
   *   String healthCheck = "";
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   Operation response = healthChecksClient.update(project, healthCheck, healthCheckResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param healthCheck Name of the HealthCheck resource to update.
   * @param healthCheckResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(
      String project, String healthCheck, HealthCheck healthCheckResource) {
    UpdateHealthCheckRequest request =
        UpdateHealthCheckRequest.newBuilder()
            .setProject(project)
            .setHealthCheck(healthCheck)
            .setHealthCheckResource(healthCheckResource)
            .build();
    return update(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String healthCheck = "";
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   String project = "";
   *   UpdateHealthCheckRequest request = UpdateHealthCheckRequest.newBuilder()
   *     .setHealthCheck(healthCheck)
   *     .setHealthCheckResource(healthCheckResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = healthChecksClient.update(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(UpdateHealthCheckRequest request) {
    return updateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HealthChecksClient healthChecksClient = HealthChecksClient.create()) {
   *   String healthCheck = "";
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   String project = "";
   *   UpdateHealthCheckRequest request = UpdateHealthCheckRequest.newBuilder()
   *     .setHealthCheck(healthCheck)
   *     .setHealthCheckResource(healthCheckResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = healthChecksClient.updateCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateHealthCheckRequest, Operation> updateCallable() {
    return stub.updateCallable();
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
          AggregatedListHealthChecksRequest,
          HealthChecksAggregatedList,
          Entry<String, HealthChecksScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListHealthChecksRequest,
                HealthChecksAggregatedList,
                Entry<String, HealthChecksScopedList>>
            context,
        ApiFuture<HealthChecksAggregatedList> futureResponse) {
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
          AggregatedListHealthChecksRequest,
          HealthChecksAggregatedList,
          Entry<String, HealthChecksScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListHealthChecksRequest,
                HealthChecksAggregatedList,
                Entry<String, HealthChecksScopedList>>
            context,
        HealthChecksAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListHealthChecksRequest,
                HealthChecksAggregatedList,
                Entry<String, HealthChecksScopedList>>
            context,
        HealthChecksAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListHealthChecksRequest,
                HealthChecksAggregatedList,
                Entry<String, HealthChecksScopedList>>
            context,
        ApiFuture<HealthChecksAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListHealthChecksRequest,
          HealthChecksAggregatedList,
          Entry<String, HealthChecksScopedList>,
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
          ListHealthChecksRequest,
          HealthCheckList,
          HealthCheck,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListHealthChecksRequest, HealthCheckList, HealthCheck> context,
        ApiFuture<HealthCheckList> futureResponse) {
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
      extends AbstractPage<ListHealthChecksRequest, HealthCheckList, HealthCheck, ListPage> {

    private ListPage(
        PageContext<ListHealthChecksRequest, HealthCheckList, HealthCheck> context,
        HealthCheckList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListHealthChecksRequest, HealthCheckList, HealthCheck> context,
        HealthCheckList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListHealthChecksRequest, HealthCheckList, HealthCheck> context,
        ApiFuture<HealthCheckList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHealthChecksRequest,
          HealthCheckList,
          HealthCheck,
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
