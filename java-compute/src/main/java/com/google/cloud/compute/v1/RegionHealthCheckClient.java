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
import com.google.cloud.compute.v1.stub.RegionHealthCheckStub;
import com.google.cloud.compute.v1.stub.RegionHealthCheckStubSettings;
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
 * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
 *   ProjectRegionHealthCheckName healthCheck = ProjectRegionHealthCheckName.of("[PROJECT]", "[REGION]", "[HEALTH_CHECK]");
 *   Operation response = regionHealthCheckClient.deleteRegionHealthCheck(healthCheck);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionHealthCheckClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of RegionHealthCheckSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionHealthCheckSettings regionHealthCheckSettings =
 *     RegionHealthCheckSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionHealthCheckClient regionHealthCheckClient =
 *     RegionHealthCheckClient.create(regionHealthCheckSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionHealthCheckSettings regionHealthCheckSettings =
 *     RegionHealthCheckSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionHealthCheckClient regionHealthCheckClient =
 *     RegionHealthCheckClient.create(regionHealthCheckSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionHealthCheckClient implements BackgroundResource {
  private final RegionHealthCheckSettings settings;
  private final RegionHealthCheckStub stub;

  /** Constructs an instance of RegionHealthCheckClient with default settings. */
  public static final RegionHealthCheckClient create() throws IOException {
    return create(RegionHealthCheckSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionHealthCheckClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionHealthCheckClient create(RegionHealthCheckSettings settings)
      throws IOException {
    return new RegionHealthCheckClient(settings);
  }

  /**
   * Constructs an instance of RegionHealthCheckClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use RegionHealthCheckSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionHealthCheckClient create(RegionHealthCheckStub stub) {
    return new RegionHealthCheckClient(stub);
  }

  /**
   * Constructs an instance of RegionHealthCheckClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RegionHealthCheckClient(RegionHealthCheckSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionHealthCheckStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionHealthCheckClient(RegionHealthCheckStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionHealthCheckSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionHealthCheckStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   ProjectRegionHealthCheckName healthCheck = ProjectRegionHealthCheckName.of("[PROJECT]", "[REGION]", "[HEALTH_CHECK]");
   *   Operation response = regionHealthCheckClient.deleteRegionHealthCheck(healthCheck);
   * }
   * </code></pre>
   *
   * @param healthCheck Name of the HealthCheck resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionHealthCheck(ProjectRegionHealthCheckName healthCheck) {

    DeleteRegionHealthCheckHttpRequest request =
        DeleteRegionHealthCheckHttpRequest.newBuilder()
            .setHealthCheck(healthCheck == null ? null : healthCheck.toString())
            .build();
    return deleteRegionHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   ProjectRegionHealthCheckName healthCheck = ProjectRegionHealthCheckName.of("[PROJECT]", "[REGION]", "[HEALTH_CHECK]");
   *   Operation response = regionHealthCheckClient.deleteRegionHealthCheck(healthCheck.toString());
   * }
   * </code></pre>
   *
   * @param healthCheck Name of the HealthCheck resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionHealthCheck(String healthCheck) {

    DeleteRegionHealthCheckHttpRequest request =
        DeleteRegionHealthCheckHttpRequest.newBuilder().setHealthCheck(healthCheck).build();
    return deleteRegionHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   String formattedHealthCheck = ProjectRegionHealthCheckName.format("[PROJECT]", "[REGION]", "[HEALTH_CHECK]");
   *   DeleteRegionHealthCheckHttpRequest request = DeleteRegionHealthCheckHttpRequest.newBuilder()
   *     .setHealthCheck(formattedHealthCheck)
   *     .build();
   *   Operation response = regionHealthCheckClient.deleteRegionHealthCheck(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionHealthCheck(DeleteRegionHealthCheckHttpRequest request) {
    return deleteRegionHealthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   String formattedHealthCheck = ProjectRegionHealthCheckName.format("[PROJECT]", "[REGION]", "[HEALTH_CHECK]");
   *   DeleteRegionHealthCheckHttpRequest request = DeleteRegionHealthCheckHttpRequest.newBuilder()
   *     .setHealthCheck(formattedHealthCheck)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionHealthCheckClient.deleteRegionHealthCheckCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteRegionHealthCheckHttpRequest, Operation>
      deleteRegionHealthCheckCallable() {
    return stub.deleteRegionHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HealthCheck resource. Gets a list of available health checks by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   ProjectRegionHealthCheckName healthCheck = ProjectRegionHealthCheckName.of("[PROJECT]", "[REGION]", "[HEALTH_CHECK]");
   *   HealthCheck response = regionHealthCheckClient.getRegionHealthCheck(healthCheck);
   * }
   * </code></pre>
   *
   * @param healthCheck Name of the HealthCheck resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final HealthCheck getRegionHealthCheck(ProjectRegionHealthCheckName healthCheck) {

    GetRegionHealthCheckHttpRequest request =
        GetRegionHealthCheckHttpRequest.newBuilder()
            .setHealthCheck(healthCheck == null ? null : healthCheck.toString())
            .build();
    return getRegionHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HealthCheck resource. Gets a list of available health checks by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   ProjectRegionHealthCheckName healthCheck = ProjectRegionHealthCheckName.of("[PROJECT]", "[REGION]", "[HEALTH_CHECK]");
   *   HealthCheck response = regionHealthCheckClient.getRegionHealthCheck(healthCheck.toString());
   * }
   * </code></pre>
   *
   * @param healthCheck Name of the HealthCheck resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final HealthCheck getRegionHealthCheck(String healthCheck) {

    GetRegionHealthCheckHttpRequest request =
        GetRegionHealthCheckHttpRequest.newBuilder().setHealthCheck(healthCheck).build();
    return getRegionHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HealthCheck resource. Gets a list of available health checks by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   String formattedHealthCheck = ProjectRegionHealthCheckName.format("[PROJECT]", "[REGION]", "[HEALTH_CHECK]");
   *   GetRegionHealthCheckHttpRequest request = GetRegionHealthCheckHttpRequest.newBuilder()
   *     .setHealthCheck(formattedHealthCheck)
   *     .build();
   *   HealthCheck response = regionHealthCheckClient.getRegionHealthCheck(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final HealthCheck getRegionHealthCheck(GetRegionHealthCheckHttpRequest request) {
    return getRegionHealthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HealthCheck resource. Gets a list of available health checks by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   String formattedHealthCheck = ProjectRegionHealthCheckName.format("[PROJECT]", "[REGION]", "[HEALTH_CHECK]");
   *   GetRegionHealthCheckHttpRequest request = GetRegionHealthCheckHttpRequest.newBuilder()
   *     .setHealthCheck(formattedHealthCheck)
   *     .build();
   *   ApiFuture&lt;HealthCheck&gt; future = regionHealthCheckClient.getRegionHealthCheckCallable().futureCall(request);
   *   // Do something
   *   HealthCheck response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetRegionHealthCheckHttpRequest, HealthCheck>
      getRegionHealthCheckCallable() {
    return stub.getRegionHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   Operation response = regionHealthCheckClient.insertRegionHealthCheck(region, healthCheckResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param healthCheckResource Represents a Health Check resource.
   *     <p>Health checks are used for most GCP load balancers and managed instance group
   *     auto-healing. For more information, read Health Check Concepts.
   *     <p>To perform health checks on network load balancers, you must use either httpHealthChecks
   *     or httpsHealthChecks.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionHealthCheck(
      ProjectRegionName region, HealthCheck healthCheckResource) {

    InsertRegionHealthCheckHttpRequest request =
        InsertRegionHealthCheckHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setHealthCheckResource(healthCheckResource)
            .build();
    return insertRegionHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   Operation response = regionHealthCheckClient.insertRegionHealthCheck(region.toString(), healthCheckResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param healthCheckResource Represents a Health Check resource.
   *     <p>Health checks are used for most GCP load balancers and managed instance group
   *     auto-healing. For more information, read Health Check Concepts.
   *     <p>To perform health checks on network load balancers, you must use either httpHealthChecks
   *     or httpsHealthChecks.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionHealthCheck(String region, HealthCheck healthCheckResource) {

    InsertRegionHealthCheckHttpRequest request =
        InsertRegionHealthCheckHttpRequest.newBuilder()
            .setRegion(region)
            .setHealthCheckResource(healthCheckResource)
            .build();
    return insertRegionHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   InsertRegionHealthCheckHttpRequest request = InsertRegionHealthCheckHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setHealthCheckResource(healthCheckResource)
   *     .build();
   *   Operation response = regionHealthCheckClient.insertRegionHealthCheck(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionHealthCheck(InsertRegionHealthCheckHttpRequest request) {
    return insertRegionHealthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   InsertRegionHealthCheckHttpRequest request = InsertRegionHealthCheckHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setHealthCheckResource(healthCheckResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionHealthCheckClient.insertRegionHealthCheckCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertRegionHealthCheckHttpRequest, Operation>
      insertRegionHealthCheckCallable() {
    return stub.insertRegionHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (HealthCheck element : regionHealthCheckClient.listRegionHealthChecks(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionHealthChecksPagedResponse listRegionHealthChecks(
      ProjectRegionName region) {
    ListRegionHealthChecksHttpRequest request =
        ListRegionHealthChecksHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listRegionHealthChecks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (HealthCheck element : regionHealthCheckClient.listRegionHealthChecks(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionHealthChecksPagedResponse listRegionHealthChecks(String region) {
    ListRegionHealthChecksHttpRequest request =
        ListRegionHealthChecksHttpRequest.newBuilder().setRegion(region).build();
    return listRegionHealthChecks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionHealthChecksHttpRequest request = ListRegionHealthChecksHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   for (HealthCheck element : regionHealthCheckClient.listRegionHealthChecks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionHealthChecksPagedResponse listRegionHealthChecks(
      ListRegionHealthChecksHttpRequest request) {
    return listRegionHealthChecksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionHealthChecksHttpRequest request = ListRegionHealthChecksHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   ApiFuture&lt;ListRegionHealthChecksPagedResponse&gt; future = regionHealthCheckClient.listRegionHealthChecksPagedCallable().futureCall(request);
   *   // Do something
   *   for (HealthCheck element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListRegionHealthChecksHttpRequest, ListRegionHealthChecksPagedResponse>
      listRegionHealthChecksPagedCallable() {
    return stub.listRegionHealthChecksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionHealthChecksHttpRequest request = ListRegionHealthChecksHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   while (true) {
   *     HealthCheckList response = regionHealthCheckClient.listRegionHealthChecksCallable().call(request);
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
  @BetaApi
  public final UnaryCallable<ListRegionHealthChecksHttpRequest, HealthCheckList>
      listRegionHealthChecksCallable() {
    return stub.listRegionHealthChecksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   * This method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   ProjectRegionHealthCheckName healthCheck = ProjectRegionHealthCheckName.of("[PROJECT]", "[REGION]", "[HEALTH_CHECK]");
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = regionHealthCheckClient.patchRegionHealthCheck(healthCheck, healthCheckResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param healthCheck Name of the HealthCheck resource to patch.
   * @param healthCheckResource Represents a Health Check resource.
   *     <p>Health checks are used for most GCP load balancers and managed instance group
   *     auto-healing. For more information, read Health Check Concepts.
   *     <p>To perform health checks on network load balancers, you must use either httpHealthChecks
   *     or httpsHealthChecks.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchRegionHealthCheck(
      ProjectRegionHealthCheckName healthCheck,
      HealthCheck healthCheckResource,
      List<String> fieldMask) {

    PatchRegionHealthCheckHttpRequest request =
        PatchRegionHealthCheckHttpRequest.newBuilder()
            .setHealthCheck(healthCheck == null ? null : healthCheck.toString())
            .setHealthCheckResource(healthCheckResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchRegionHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   * This method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   ProjectRegionHealthCheckName healthCheck = ProjectRegionHealthCheckName.of("[PROJECT]", "[REGION]", "[HEALTH_CHECK]");
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = regionHealthCheckClient.patchRegionHealthCheck(healthCheck.toString(), healthCheckResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param healthCheck Name of the HealthCheck resource to patch.
   * @param healthCheckResource Represents a Health Check resource.
   *     <p>Health checks are used for most GCP load balancers and managed instance group
   *     auto-healing. For more information, read Health Check Concepts.
   *     <p>To perform health checks on network load balancers, you must use either httpHealthChecks
   *     or httpsHealthChecks.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchRegionHealthCheck(
      String healthCheck, HealthCheck healthCheckResource, List<String> fieldMask) {

    PatchRegionHealthCheckHttpRequest request =
        PatchRegionHealthCheckHttpRequest.newBuilder()
            .setHealthCheck(healthCheck)
            .setHealthCheckResource(healthCheckResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchRegionHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   * This method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   String formattedHealthCheck = ProjectRegionHealthCheckName.format("[PROJECT]", "[REGION]", "[HEALTH_CHECK]");
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchRegionHealthCheckHttpRequest request = PatchRegionHealthCheckHttpRequest.newBuilder()
   *     .setHealthCheck(formattedHealthCheck)
   *     .setHealthCheckResource(healthCheckResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = regionHealthCheckClient.patchRegionHealthCheck(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchRegionHealthCheck(PatchRegionHealthCheckHttpRequest request) {
    return patchRegionHealthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   * This method supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   String formattedHealthCheck = ProjectRegionHealthCheckName.format("[PROJECT]", "[REGION]", "[HEALTH_CHECK]");
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchRegionHealthCheckHttpRequest request = PatchRegionHealthCheckHttpRequest.newBuilder()
   *     .setHealthCheck(formattedHealthCheck)
   *     .setHealthCheckResource(healthCheckResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionHealthCheckClient.patchRegionHealthCheckCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchRegionHealthCheckHttpRequest, Operation>
      patchRegionHealthCheckCallable() {
    return stub.patchRegionHealthCheckCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   ProjectRegionHealthCheckName healthCheck = ProjectRegionHealthCheckName.of("[PROJECT]", "[REGION]", "[HEALTH_CHECK]");
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = regionHealthCheckClient.updateRegionHealthCheck(healthCheck, healthCheckResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param healthCheck Name of the HealthCheck resource to update.
   * @param healthCheckResource Represents a Health Check resource.
   *     <p>Health checks are used for most GCP load balancers and managed instance group
   *     auto-healing. For more information, read Health Check Concepts.
   *     <p>To perform health checks on network load balancers, you must use either httpHealthChecks
   *     or httpsHealthChecks.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateRegionHealthCheck(
      ProjectRegionHealthCheckName healthCheck,
      HealthCheck healthCheckResource,
      List<String> fieldMask) {

    UpdateRegionHealthCheckHttpRequest request =
        UpdateRegionHealthCheckHttpRequest.newBuilder()
            .setHealthCheck(healthCheck == null ? null : healthCheck.toString())
            .setHealthCheckResource(healthCheckResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateRegionHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   ProjectRegionHealthCheckName healthCheck = ProjectRegionHealthCheckName.of("[PROJECT]", "[REGION]", "[HEALTH_CHECK]");
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = regionHealthCheckClient.updateRegionHealthCheck(healthCheck.toString(), healthCheckResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param healthCheck Name of the HealthCheck resource to update.
   * @param healthCheckResource Represents a Health Check resource.
   *     <p>Health checks are used for most GCP load balancers and managed instance group
   *     auto-healing. For more information, read Health Check Concepts.
   *     <p>To perform health checks on network load balancers, you must use either httpHealthChecks
   *     or httpsHealthChecks.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateRegionHealthCheck(
      String healthCheck, HealthCheck healthCheckResource, List<String> fieldMask) {

    UpdateRegionHealthCheckHttpRequest request =
        UpdateRegionHealthCheckHttpRequest.newBuilder()
            .setHealthCheck(healthCheck)
            .setHealthCheckResource(healthCheckResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateRegionHealthCheck(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   String formattedHealthCheck = ProjectRegionHealthCheckName.format("[PROJECT]", "[REGION]", "[HEALTH_CHECK]");
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateRegionHealthCheckHttpRequest request = UpdateRegionHealthCheckHttpRequest.newBuilder()
   *     .setHealthCheck(formattedHealthCheck)
   *     .setHealthCheckResource(healthCheckResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = regionHealthCheckClient.updateRegionHealthCheck(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateRegionHealthCheck(UpdateRegionHealthCheckHttpRequest request) {
    return updateRegionHealthCheckCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HealthCheck resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckClient regionHealthCheckClient = RegionHealthCheckClient.create()) {
   *   String formattedHealthCheck = ProjectRegionHealthCheckName.format("[PROJECT]", "[REGION]", "[HEALTH_CHECK]");
   *   HealthCheck healthCheckResource = HealthCheck.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateRegionHealthCheckHttpRequest request = UpdateRegionHealthCheckHttpRequest.newBuilder()
   *     .setHealthCheck(formattedHealthCheck)
   *     .setHealthCheckResource(healthCheckResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionHealthCheckClient.updateRegionHealthCheckCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<UpdateRegionHealthCheckHttpRequest, Operation>
      updateRegionHealthCheckCallable() {
    return stub.updateRegionHealthCheckCallable();
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

  public static class ListRegionHealthChecksPagedResponse
      extends AbstractPagedListResponse<
          ListRegionHealthChecksHttpRequest,
          HealthCheckList,
          HealthCheck,
          ListRegionHealthChecksPage,
          ListRegionHealthChecksFixedSizeCollection> {

    public static ApiFuture<ListRegionHealthChecksPagedResponse> createAsync(
        PageContext<ListRegionHealthChecksHttpRequest, HealthCheckList, HealthCheck> context,
        ApiFuture<HealthCheckList> futureResponse) {
      ApiFuture<ListRegionHealthChecksPage> futurePage =
          ListRegionHealthChecksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListRegionHealthChecksPage, ListRegionHealthChecksPagedResponse>() {
            @Override
            public ListRegionHealthChecksPagedResponse apply(ListRegionHealthChecksPage input) {
              return new ListRegionHealthChecksPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListRegionHealthChecksPagedResponse(ListRegionHealthChecksPage page) {
      super(page, ListRegionHealthChecksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegionHealthChecksPage
      extends AbstractPage<
          ListRegionHealthChecksHttpRequest,
          HealthCheckList,
          HealthCheck,
          ListRegionHealthChecksPage> {

    private ListRegionHealthChecksPage(
        PageContext<ListRegionHealthChecksHttpRequest, HealthCheckList, HealthCheck> context,
        HealthCheckList response) {
      super(context, response);
    }

    private static ListRegionHealthChecksPage createEmptyPage() {
      return new ListRegionHealthChecksPage(null, null);
    }

    @Override
    protected ListRegionHealthChecksPage createPage(
        PageContext<ListRegionHealthChecksHttpRequest, HealthCheckList, HealthCheck> context,
        HealthCheckList response) {
      return new ListRegionHealthChecksPage(context, response);
    }

    @Override
    public ApiFuture<ListRegionHealthChecksPage> createPageAsync(
        PageContext<ListRegionHealthChecksHttpRequest, HealthCheckList, HealthCheck> context,
        ApiFuture<HealthCheckList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegionHealthChecksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionHealthChecksHttpRequest,
          HealthCheckList,
          HealthCheck,
          ListRegionHealthChecksPage,
          ListRegionHealthChecksFixedSizeCollection> {

    private ListRegionHealthChecksFixedSizeCollection(
        List<ListRegionHealthChecksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegionHealthChecksFixedSizeCollection createEmptyCollection() {
      return new ListRegionHealthChecksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegionHealthChecksFixedSizeCollection createCollection(
        List<ListRegionHealthChecksPage> pages, int collectionSize) {
      return new ListRegionHealthChecksFixedSizeCollection(pages, collectionSize);
    }
  }
}
