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
import com.google.cloud.compute.v1.stub.RegionHealthCheckServiceStub;
import com.google.cloud.compute.v1.stub.RegionHealthCheckServiceStubSettings;
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
 * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
 *   ProjectRegionHealthCheckServiceName healthCheckService = ProjectRegionHealthCheckServiceName.of("[PROJECT]", "[REGION]", "[HEALTH_CHECK_SERVICE]");
 *   Operation response = regionHealthCheckServiceClient.deleteRegionHealthCheckService(healthCheckService);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionHealthCheckServiceClient object to clean up
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
 * RegionHealthCheckServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionHealthCheckServiceSettings regionHealthCheckServiceSettings =
 *     RegionHealthCheckServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionHealthCheckServiceClient regionHealthCheckServiceClient =
 *     RegionHealthCheckServiceClient.create(regionHealthCheckServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionHealthCheckServiceSettings regionHealthCheckServiceSettings =
 *     RegionHealthCheckServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionHealthCheckServiceClient regionHealthCheckServiceClient =
 *     RegionHealthCheckServiceClient.create(regionHealthCheckServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionHealthCheckServiceClient implements BackgroundResource {
  private final RegionHealthCheckServiceSettings settings;
  private final RegionHealthCheckServiceStub stub;

  /** Constructs an instance of RegionHealthCheckServiceClient with default settings. */
  public static final RegionHealthCheckServiceClient create() throws IOException {
    return create(RegionHealthCheckServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionHealthCheckServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RegionHealthCheckServiceClient create(
      RegionHealthCheckServiceSettings settings) throws IOException {
    return new RegionHealthCheckServiceClient(settings);
  }

  /**
   * Constructs an instance of RegionHealthCheckServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer to use RegionHealthCheckServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionHealthCheckServiceClient create(RegionHealthCheckServiceStub stub) {
    return new RegionHealthCheckServiceClient(stub);
  }

  /**
   * Constructs an instance of RegionHealthCheckServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionHealthCheckServiceClient(RegionHealthCheckServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionHealthCheckServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionHealthCheckServiceClient(RegionHealthCheckServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionHealthCheckServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionHealthCheckServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified regional HealthCheckService.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   ProjectRegionHealthCheckServiceName healthCheckService = ProjectRegionHealthCheckServiceName.of("[PROJECT]", "[REGION]", "[HEALTH_CHECK_SERVICE]");
   *   Operation response = regionHealthCheckServiceClient.deleteRegionHealthCheckService(healthCheckService);
   * }
   * </code></pre>
   *
   * @param healthCheckService Name of the HealthCheckService to delete. The name must be 1-63
   *     characters long, and comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionHealthCheckService(
      ProjectRegionHealthCheckServiceName healthCheckService) {
    DeleteRegionHealthCheckServiceHttpRequest request =
        DeleteRegionHealthCheckServiceHttpRequest.newBuilder()
            .setHealthCheckService(
                healthCheckService == null ? null : healthCheckService.toString())
            .build();
    return deleteRegionHealthCheckService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified regional HealthCheckService.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   ProjectRegionHealthCheckServiceName healthCheckService = ProjectRegionHealthCheckServiceName.of("[PROJECT]", "[REGION]", "[HEALTH_CHECK_SERVICE]");
   *   Operation response = regionHealthCheckServiceClient.deleteRegionHealthCheckService(healthCheckService.toString());
   * }
   * </code></pre>
   *
   * @param healthCheckService Name of the HealthCheckService to delete. The name must be 1-63
   *     characters long, and comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionHealthCheckService(String healthCheckService) {
    DeleteRegionHealthCheckServiceHttpRequest request =
        DeleteRegionHealthCheckServiceHttpRequest.newBuilder()
            .setHealthCheckService(healthCheckService)
            .build();
    return deleteRegionHealthCheckService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified regional HealthCheckService.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   String formattedHealthCheckService = ProjectRegionHealthCheckServiceName.format("[PROJECT]", "[REGION]", "[HEALTH_CHECK_SERVICE]");
   *   DeleteRegionHealthCheckServiceHttpRequest request = DeleteRegionHealthCheckServiceHttpRequest.newBuilder()
   *     .setHealthCheckService(formattedHealthCheckService)
   *     .build();
   *   Operation response = regionHealthCheckServiceClient.deleteRegionHealthCheckService(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionHealthCheckService(
      DeleteRegionHealthCheckServiceHttpRequest request) {
    return deleteRegionHealthCheckServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified regional HealthCheckService.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   String formattedHealthCheckService = ProjectRegionHealthCheckServiceName.format("[PROJECT]", "[REGION]", "[HEALTH_CHECK_SERVICE]");
   *   DeleteRegionHealthCheckServiceHttpRequest request = DeleteRegionHealthCheckServiceHttpRequest.newBuilder()
   *     .setHealthCheckService(formattedHealthCheckService)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionHealthCheckServiceClient.deleteRegionHealthCheckServiceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteRegionHealthCheckServiceHttpRequest, Operation>
      deleteRegionHealthCheckServiceCallable() {
    return stub.deleteRegionHealthCheckServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified regional HealthCheckService resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   ProjectRegionHealthCheckServiceName healthCheckService = ProjectRegionHealthCheckServiceName.of("[PROJECT]", "[REGION]", "[HEALTH_CHECK_SERVICE]");
   *   HealthCheckService response = regionHealthCheckServiceClient.getRegionHealthCheckService(healthCheckService);
   * }
   * </code></pre>
   *
   * @param healthCheckService Name of the HealthCheckService to update. The name must be 1-63
   *     characters long, and comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final HealthCheckService getRegionHealthCheckService(
      ProjectRegionHealthCheckServiceName healthCheckService) {
    GetRegionHealthCheckServiceHttpRequest request =
        GetRegionHealthCheckServiceHttpRequest.newBuilder()
            .setHealthCheckService(
                healthCheckService == null ? null : healthCheckService.toString())
            .build();
    return getRegionHealthCheckService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified regional HealthCheckService resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   ProjectRegionHealthCheckServiceName healthCheckService = ProjectRegionHealthCheckServiceName.of("[PROJECT]", "[REGION]", "[HEALTH_CHECK_SERVICE]");
   *   HealthCheckService response = regionHealthCheckServiceClient.getRegionHealthCheckService(healthCheckService.toString());
   * }
   * </code></pre>
   *
   * @param healthCheckService Name of the HealthCheckService to update. The name must be 1-63
   *     characters long, and comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final HealthCheckService getRegionHealthCheckService(String healthCheckService) {
    GetRegionHealthCheckServiceHttpRequest request =
        GetRegionHealthCheckServiceHttpRequest.newBuilder()
            .setHealthCheckService(healthCheckService)
            .build();
    return getRegionHealthCheckService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified regional HealthCheckService resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   String formattedHealthCheckService = ProjectRegionHealthCheckServiceName.format("[PROJECT]", "[REGION]", "[HEALTH_CHECK_SERVICE]");
   *   GetRegionHealthCheckServiceHttpRequest request = GetRegionHealthCheckServiceHttpRequest.newBuilder()
   *     .setHealthCheckService(formattedHealthCheckService)
   *     .build();
   *   HealthCheckService response = regionHealthCheckServiceClient.getRegionHealthCheckService(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final HealthCheckService getRegionHealthCheckService(
      GetRegionHealthCheckServiceHttpRequest request) {
    return getRegionHealthCheckServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified regional HealthCheckService resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   String formattedHealthCheckService = ProjectRegionHealthCheckServiceName.format("[PROJECT]", "[REGION]", "[HEALTH_CHECK_SERVICE]");
   *   GetRegionHealthCheckServiceHttpRequest request = GetRegionHealthCheckServiceHttpRequest.newBuilder()
   *     .setHealthCheckService(formattedHealthCheckService)
   *     .build();
   *   ApiFuture&lt;HealthCheckService&gt; future = regionHealthCheckServiceClient.getRegionHealthCheckServiceCallable().futureCall(request);
   *   // Do something
   *   HealthCheckService response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetRegionHealthCheckServiceHttpRequest, HealthCheckService>
      getRegionHealthCheckServiceCallable() {
    return stub.getRegionHealthCheckServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a regional HealthCheckService resource in the specified project and region using the
   * data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   HealthCheckService healthCheckServiceResource = HealthCheckService.newBuilder().build();
   *   Operation response = regionHealthCheckServiceClient.insertRegionHealthCheckService(region, healthCheckServiceResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param healthCheckServiceResource Represents a Health-Check as a Service resource.
   *     <p>(== resource_for {$api_version}.regionHealthCheckServices ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionHealthCheckService(
      ProjectRegionName region, HealthCheckService healthCheckServiceResource) {
    InsertRegionHealthCheckServiceHttpRequest request =
        InsertRegionHealthCheckServiceHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setHealthCheckServiceResource(healthCheckServiceResource)
            .build();
    return insertRegionHealthCheckService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a regional HealthCheckService resource in the specified project and region using the
   * data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   HealthCheckService healthCheckServiceResource = HealthCheckService.newBuilder().build();
   *   Operation response = regionHealthCheckServiceClient.insertRegionHealthCheckService(region.toString(), healthCheckServiceResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param healthCheckServiceResource Represents a Health-Check as a Service resource.
   *     <p>(== resource_for {$api_version}.regionHealthCheckServices ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionHealthCheckService(
      String region, HealthCheckService healthCheckServiceResource) {
    InsertRegionHealthCheckServiceHttpRequest request =
        InsertRegionHealthCheckServiceHttpRequest.newBuilder()
            .setRegion(region)
            .setHealthCheckServiceResource(healthCheckServiceResource)
            .build();
    return insertRegionHealthCheckService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a regional HealthCheckService resource in the specified project and region using the
   * data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   HealthCheckService healthCheckServiceResource = HealthCheckService.newBuilder().build();
   *   InsertRegionHealthCheckServiceHttpRequest request = InsertRegionHealthCheckServiceHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setHealthCheckServiceResource(healthCheckServiceResource)
   *     .build();
   *   Operation response = regionHealthCheckServiceClient.insertRegionHealthCheckService(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionHealthCheckService(
      InsertRegionHealthCheckServiceHttpRequest request) {
    return insertRegionHealthCheckServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a regional HealthCheckService resource in the specified project and region using the
   * data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   HealthCheckService healthCheckServiceResource = HealthCheckService.newBuilder().build();
   *   InsertRegionHealthCheckServiceHttpRequest request = InsertRegionHealthCheckServiceHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setHealthCheckServiceResource(healthCheckServiceResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionHealthCheckServiceClient.insertRegionHealthCheckServiceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertRegionHealthCheckServiceHttpRequest, Operation>
      insertRegionHealthCheckServiceCallable() {
    return stub.insertRegionHealthCheckServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the HealthCheckService resources that have been configured for the specified project
   * in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (HealthCheckService element : regionHealthCheckServiceClient.listRegionHealthCheckServices(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionHealthCheckServicesPagedResponse listRegionHealthCheckServices(
      ProjectRegionName region) {
    ListRegionHealthCheckServicesHttpRequest request =
        ListRegionHealthCheckServicesHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listRegionHealthCheckServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the HealthCheckService resources that have been configured for the specified project
   * in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (HealthCheckService element : regionHealthCheckServiceClient.listRegionHealthCheckServices(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionHealthCheckServicesPagedResponse listRegionHealthCheckServices(
      String region) {
    ListRegionHealthCheckServicesHttpRequest request =
        ListRegionHealthCheckServicesHttpRequest.newBuilder().setRegion(region).build();
    return listRegionHealthCheckServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the HealthCheckService resources that have been configured for the specified project
   * in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionHealthCheckServicesHttpRequest request = ListRegionHealthCheckServicesHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   for (HealthCheckService element : regionHealthCheckServiceClient.listRegionHealthCheckServices(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionHealthCheckServicesPagedResponse listRegionHealthCheckServices(
      ListRegionHealthCheckServicesHttpRequest request) {
    return listRegionHealthCheckServicesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the HealthCheckService resources that have been configured for the specified project
   * in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionHealthCheckServicesHttpRequest request = ListRegionHealthCheckServicesHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   ApiFuture&lt;ListRegionHealthCheckServicesPagedResponse&gt; future = regionHealthCheckServiceClient.listRegionHealthCheckServicesPagedCallable().futureCall(request);
   *   // Do something
   *   for (HealthCheckService element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListRegionHealthCheckServicesHttpRequest, ListRegionHealthCheckServicesPagedResponse>
      listRegionHealthCheckServicesPagedCallable() {
    return stub.listRegionHealthCheckServicesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the HealthCheckService resources that have been configured for the specified project
   * in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionHealthCheckServicesHttpRequest request = ListRegionHealthCheckServicesHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   while (true) {
   *     HealthCheckServicesList response = regionHealthCheckServiceClient.listRegionHealthCheckServicesCallable().call(request);
   *     for (HealthCheckService element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionHealthCheckServicesHttpRequest, HealthCheckServicesList>
      listRegionHealthCheckServicesCallable() {
    return stub.listRegionHealthCheckServicesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified regional HealthCheckService resource with the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   ProjectRegionHealthCheckServiceName healthCheckService = ProjectRegionHealthCheckServiceName.of("[PROJECT]", "[REGION]", "[HEALTH_CHECK_SERVICE]");
   *   HealthCheckService healthCheckServiceResource = HealthCheckService.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = regionHealthCheckServiceClient.patchRegionHealthCheckService(healthCheckService, healthCheckServiceResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param healthCheckService Name of the HealthCheckService to update. The name must be 1-63
   *     characters long, and comply with RFC1035.
   * @param healthCheckServiceResource Represents a Health-Check as a Service resource.
   *     <p>(== resource_for {$api_version}.regionHealthCheckServices ==)
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchRegionHealthCheckService(
      ProjectRegionHealthCheckServiceName healthCheckService,
      HealthCheckService healthCheckServiceResource,
      List<String> fieldMask) {
    PatchRegionHealthCheckServiceHttpRequest request =
        PatchRegionHealthCheckServiceHttpRequest.newBuilder()
            .setHealthCheckService(
                healthCheckService == null ? null : healthCheckService.toString())
            .setHealthCheckServiceResource(healthCheckServiceResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchRegionHealthCheckService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified regional HealthCheckService resource with the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   ProjectRegionHealthCheckServiceName healthCheckService = ProjectRegionHealthCheckServiceName.of("[PROJECT]", "[REGION]", "[HEALTH_CHECK_SERVICE]");
   *   HealthCheckService healthCheckServiceResource = HealthCheckService.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = regionHealthCheckServiceClient.patchRegionHealthCheckService(healthCheckService.toString(), healthCheckServiceResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param healthCheckService Name of the HealthCheckService to update. The name must be 1-63
   *     characters long, and comply with RFC1035.
   * @param healthCheckServiceResource Represents a Health-Check as a Service resource.
   *     <p>(== resource_for {$api_version}.regionHealthCheckServices ==)
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchRegionHealthCheckService(
      String healthCheckService,
      HealthCheckService healthCheckServiceResource,
      List<String> fieldMask) {
    PatchRegionHealthCheckServiceHttpRequest request =
        PatchRegionHealthCheckServiceHttpRequest.newBuilder()
            .setHealthCheckService(healthCheckService)
            .setHealthCheckServiceResource(healthCheckServiceResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchRegionHealthCheckService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified regional HealthCheckService resource with the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   String formattedHealthCheckService = ProjectRegionHealthCheckServiceName.format("[PROJECT]", "[REGION]", "[HEALTH_CHECK_SERVICE]");
   *   HealthCheckService healthCheckServiceResource = HealthCheckService.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchRegionHealthCheckServiceHttpRequest request = PatchRegionHealthCheckServiceHttpRequest.newBuilder()
   *     .setHealthCheckService(formattedHealthCheckService)
   *     .setHealthCheckServiceResource(healthCheckServiceResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = regionHealthCheckServiceClient.patchRegionHealthCheckService(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchRegionHealthCheckService(
      PatchRegionHealthCheckServiceHttpRequest request) {
    return patchRegionHealthCheckServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified regional HealthCheckService resource with the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionHealthCheckServiceClient regionHealthCheckServiceClient = RegionHealthCheckServiceClient.create()) {
   *   String formattedHealthCheckService = ProjectRegionHealthCheckServiceName.format("[PROJECT]", "[REGION]", "[HEALTH_CHECK_SERVICE]");
   *   HealthCheckService healthCheckServiceResource = HealthCheckService.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchRegionHealthCheckServiceHttpRequest request = PatchRegionHealthCheckServiceHttpRequest.newBuilder()
   *     .setHealthCheckService(formattedHealthCheckService)
   *     .setHealthCheckServiceResource(healthCheckServiceResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionHealthCheckServiceClient.patchRegionHealthCheckServiceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchRegionHealthCheckServiceHttpRequest, Operation>
      patchRegionHealthCheckServiceCallable() {
    return stub.patchRegionHealthCheckServiceCallable();
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

  public static class ListRegionHealthCheckServicesPagedResponse
      extends AbstractPagedListResponse<
          ListRegionHealthCheckServicesHttpRequest,
          HealthCheckServicesList,
          HealthCheckService,
          ListRegionHealthCheckServicesPage,
          ListRegionHealthCheckServicesFixedSizeCollection> {

    public static ApiFuture<ListRegionHealthCheckServicesPagedResponse> createAsync(
        PageContext<
                ListRegionHealthCheckServicesHttpRequest,
                HealthCheckServicesList,
                HealthCheckService>
            context,
        ApiFuture<HealthCheckServicesList> futureResponse) {
      ApiFuture<ListRegionHealthCheckServicesPage> futurePage =
          ListRegionHealthCheckServicesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListRegionHealthCheckServicesPage, ListRegionHealthCheckServicesPagedResponse>() {
            @Override
            public ListRegionHealthCheckServicesPagedResponse apply(
                ListRegionHealthCheckServicesPage input) {
              return new ListRegionHealthCheckServicesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListRegionHealthCheckServicesPagedResponse(ListRegionHealthCheckServicesPage page) {
      super(page, ListRegionHealthCheckServicesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegionHealthCheckServicesPage
      extends AbstractPage<
          ListRegionHealthCheckServicesHttpRequest,
          HealthCheckServicesList,
          HealthCheckService,
          ListRegionHealthCheckServicesPage> {

    private ListRegionHealthCheckServicesPage(
        PageContext<
                ListRegionHealthCheckServicesHttpRequest,
                HealthCheckServicesList,
                HealthCheckService>
            context,
        HealthCheckServicesList response) {
      super(context, response);
    }

    private static ListRegionHealthCheckServicesPage createEmptyPage() {
      return new ListRegionHealthCheckServicesPage(null, null);
    }

    @Override
    protected ListRegionHealthCheckServicesPage createPage(
        PageContext<
                ListRegionHealthCheckServicesHttpRequest,
                HealthCheckServicesList,
                HealthCheckService>
            context,
        HealthCheckServicesList response) {
      return new ListRegionHealthCheckServicesPage(context, response);
    }

    @Override
    public ApiFuture<ListRegionHealthCheckServicesPage> createPageAsync(
        PageContext<
                ListRegionHealthCheckServicesHttpRequest,
                HealthCheckServicesList,
                HealthCheckService>
            context,
        ApiFuture<HealthCheckServicesList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegionHealthCheckServicesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionHealthCheckServicesHttpRequest,
          HealthCheckServicesList,
          HealthCheckService,
          ListRegionHealthCheckServicesPage,
          ListRegionHealthCheckServicesFixedSizeCollection> {

    private ListRegionHealthCheckServicesFixedSizeCollection(
        List<ListRegionHealthCheckServicesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegionHealthCheckServicesFixedSizeCollection createEmptyCollection() {
      return new ListRegionHealthCheckServicesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegionHealthCheckServicesFixedSizeCollection createCollection(
        List<ListRegionHealthCheckServicesPage> pages, int collectionSize) {
      return new ListRegionHealthCheckServicesFixedSizeCollection(pages, collectionSize);
    }
  }
}
