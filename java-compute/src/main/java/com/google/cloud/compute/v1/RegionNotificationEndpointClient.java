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
import com.google.cloud.compute.v1.stub.RegionNotificationEndpointStub;
import com.google.cloud.compute.v1.stub.RegionNotificationEndpointStubSettings;
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
 * try (RegionNotificationEndpointClient regionNotificationEndpointClient = RegionNotificationEndpointClient.create()) {
 *   ProjectRegionNotificationEndpointName notificationEndpoint = ProjectRegionNotificationEndpointName.of("[PROJECT]", "[REGION]", "[NOTIFICATION_ENDPOINT]");
 *   Operation response = regionNotificationEndpointClient.deleteRegionNotificationEndpoint(notificationEndpoint);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionNotificationEndpointClient object to clean up
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
 * RegionNotificationEndpointSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionNotificationEndpointSettings regionNotificationEndpointSettings =
 *     RegionNotificationEndpointSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionNotificationEndpointClient regionNotificationEndpointClient =
 *     RegionNotificationEndpointClient.create(regionNotificationEndpointSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionNotificationEndpointSettings regionNotificationEndpointSettings =
 *     RegionNotificationEndpointSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionNotificationEndpointClient regionNotificationEndpointClient =
 *     RegionNotificationEndpointClient.create(regionNotificationEndpointSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionNotificationEndpointClient implements BackgroundResource {
  private final RegionNotificationEndpointSettings settings;
  private final RegionNotificationEndpointStub stub;

  /** Constructs an instance of RegionNotificationEndpointClient with default settings. */
  public static final RegionNotificationEndpointClient create() throws IOException {
    return create(RegionNotificationEndpointSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionNotificationEndpointClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RegionNotificationEndpointClient create(
      RegionNotificationEndpointSettings settings) throws IOException {
    return new RegionNotificationEndpointClient(settings);
  }

  /**
   * Constructs an instance of RegionNotificationEndpointClient, using the given stub for making
   * calls. This is for advanced usage - prefer to use RegionNotificationEndpointSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionNotificationEndpointClient create(RegionNotificationEndpointStub stub) {
    return new RegionNotificationEndpointClient(stub);
  }

  /**
   * Constructs an instance of RegionNotificationEndpointClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionNotificationEndpointClient(RegionNotificationEndpointSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionNotificationEndpointStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionNotificationEndpointClient(RegionNotificationEndpointStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionNotificationEndpointSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionNotificationEndpointStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified NotificationEndpoint in the given region
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointClient regionNotificationEndpointClient = RegionNotificationEndpointClient.create()) {
   *   ProjectRegionNotificationEndpointName notificationEndpoint = ProjectRegionNotificationEndpointName.of("[PROJECT]", "[REGION]", "[NOTIFICATION_ENDPOINT]");
   *   Operation response = regionNotificationEndpointClient.deleteRegionNotificationEndpoint(notificationEndpoint);
   * }
   * </code></pre>
   *
   * @param notificationEndpoint Name of the NotificationEndpoint resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionNotificationEndpoint(
      ProjectRegionNotificationEndpointName notificationEndpoint) {
    DeleteRegionNotificationEndpointHttpRequest request =
        DeleteRegionNotificationEndpointHttpRequest.newBuilder()
            .setNotificationEndpoint(
                notificationEndpoint == null ? null : notificationEndpoint.toString())
            .build();
    return deleteRegionNotificationEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified NotificationEndpoint in the given region
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointClient regionNotificationEndpointClient = RegionNotificationEndpointClient.create()) {
   *   ProjectRegionNotificationEndpointName notificationEndpoint = ProjectRegionNotificationEndpointName.of("[PROJECT]", "[REGION]", "[NOTIFICATION_ENDPOINT]");
   *   Operation response = regionNotificationEndpointClient.deleteRegionNotificationEndpoint(notificationEndpoint.toString());
   * }
   * </code></pre>
   *
   * @param notificationEndpoint Name of the NotificationEndpoint resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionNotificationEndpoint(String notificationEndpoint) {
    DeleteRegionNotificationEndpointHttpRequest request =
        DeleteRegionNotificationEndpointHttpRequest.newBuilder()
            .setNotificationEndpoint(notificationEndpoint)
            .build();
    return deleteRegionNotificationEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified NotificationEndpoint in the given region
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointClient regionNotificationEndpointClient = RegionNotificationEndpointClient.create()) {
   *   String formattedNotificationEndpoint = ProjectRegionNotificationEndpointName.format("[PROJECT]", "[REGION]", "[NOTIFICATION_ENDPOINT]");
   *   DeleteRegionNotificationEndpointHttpRequest request = DeleteRegionNotificationEndpointHttpRequest.newBuilder()
   *     .setNotificationEndpoint(formattedNotificationEndpoint)
   *     .build();
   *   Operation response = regionNotificationEndpointClient.deleteRegionNotificationEndpoint(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionNotificationEndpoint(
      DeleteRegionNotificationEndpointHttpRequest request) {
    return deleteRegionNotificationEndpointCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified NotificationEndpoint in the given region
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointClient regionNotificationEndpointClient = RegionNotificationEndpointClient.create()) {
   *   String formattedNotificationEndpoint = ProjectRegionNotificationEndpointName.format("[PROJECT]", "[REGION]", "[NOTIFICATION_ENDPOINT]");
   *   DeleteRegionNotificationEndpointHttpRequest request = DeleteRegionNotificationEndpointHttpRequest.newBuilder()
   *     .setNotificationEndpoint(formattedNotificationEndpoint)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionNotificationEndpointClient.deleteRegionNotificationEndpointCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteRegionNotificationEndpointHttpRequest, Operation>
      deleteRegionNotificationEndpointCallable() {
    return stub.deleteRegionNotificationEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified NotificationEndpoint resource in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointClient regionNotificationEndpointClient = RegionNotificationEndpointClient.create()) {
   *   ProjectRegionNotificationEndpointName notificationEndpoint = ProjectRegionNotificationEndpointName.of("[PROJECT]", "[REGION]", "[NOTIFICATION_ENDPOINT]");
   *   NotificationEndpoint response = regionNotificationEndpointClient.getRegionNotificationEndpoint(notificationEndpoint);
   * }
   * </code></pre>
   *
   * @param notificationEndpoint Name of the NotificationEndpoint resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NotificationEndpoint getRegionNotificationEndpoint(
      ProjectRegionNotificationEndpointName notificationEndpoint) {
    GetRegionNotificationEndpointHttpRequest request =
        GetRegionNotificationEndpointHttpRequest.newBuilder()
            .setNotificationEndpoint(
                notificationEndpoint == null ? null : notificationEndpoint.toString())
            .build();
    return getRegionNotificationEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified NotificationEndpoint resource in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointClient regionNotificationEndpointClient = RegionNotificationEndpointClient.create()) {
   *   ProjectRegionNotificationEndpointName notificationEndpoint = ProjectRegionNotificationEndpointName.of("[PROJECT]", "[REGION]", "[NOTIFICATION_ENDPOINT]");
   *   NotificationEndpoint response = regionNotificationEndpointClient.getRegionNotificationEndpoint(notificationEndpoint.toString());
   * }
   * </code></pre>
   *
   * @param notificationEndpoint Name of the NotificationEndpoint resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NotificationEndpoint getRegionNotificationEndpoint(String notificationEndpoint) {
    GetRegionNotificationEndpointHttpRequest request =
        GetRegionNotificationEndpointHttpRequest.newBuilder()
            .setNotificationEndpoint(notificationEndpoint)
            .build();
    return getRegionNotificationEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified NotificationEndpoint resource in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointClient regionNotificationEndpointClient = RegionNotificationEndpointClient.create()) {
   *   String formattedNotificationEndpoint = ProjectRegionNotificationEndpointName.format("[PROJECT]", "[REGION]", "[NOTIFICATION_ENDPOINT]");
   *   GetRegionNotificationEndpointHttpRequest request = GetRegionNotificationEndpointHttpRequest.newBuilder()
   *     .setNotificationEndpoint(formattedNotificationEndpoint)
   *     .build();
   *   NotificationEndpoint response = regionNotificationEndpointClient.getRegionNotificationEndpoint(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NotificationEndpoint getRegionNotificationEndpoint(
      GetRegionNotificationEndpointHttpRequest request) {
    return getRegionNotificationEndpointCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified NotificationEndpoint resource in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointClient regionNotificationEndpointClient = RegionNotificationEndpointClient.create()) {
   *   String formattedNotificationEndpoint = ProjectRegionNotificationEndpointName.format("[PROJECT]", "[REGION]", "[NOTIFICATION_ENDPOINT]");
   *   GetRegionNotificationEndpointHttpRequest request = GetRegionNotificationEndpointHttpRequest.newBuilder()
   *     .setNotificationEndpoint(formattedNotificationEndpoint)
   *     .build();
   *   ApiFuture&lt;NotificationEndpoint&gt; future = regionNotificationEndpointClient.getRegionNotificationEndpointCallable().futureCall(request);
   *   // Do something
   *   NotificationEndpoint response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetRegionNotificationEndpointHttpRequest, NotificationEndpoint>
      getRegionNotificationEndpointCallable() {
    return stub.getRegionNotificationEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a NotificationEndpoint in the specified project in the given region using the parameters
   * that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointClient regionNotificationEndpointClient = RegionNotificationEndpointClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   NotificationEndpoint notificationEndpointResource = NotificationEndpoint.newBuilder().build();
   *   Operation response = regionNotificationEndpointClient.insertRegionNotificationEndpoint(region, notificationEndpointResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param notificationEndpointResource Represents a notification endpoint.
   *     <p>A notification endpoint resource defines an endpoint to receive notifications when there
   *     are status changes detected by the associated health check service.
   *     <p>For more information, see Health checks overview. (== resource_for
   *     {$api_version}.notificationEndpoint ==) (== resource_for
   *     {$api_version}.regionNotificationEndpoints ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionNotificationEndpoint(
      ProjectRegionName region, NotificationEndpoint notificationEndpointResource) {
    InsertRegionNotificationEndpointHttpRequest request =
        InsertRegionNotificationEndpointHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setNotificationEndpointResource(notificationEndpointResource)
            .build();
    return insertRegionNotificationEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a NotificationEndpoint in the specified project in the given region using the parameters
   * that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointClient regionNotificationEndpointClient = RegionNotificationEndpointClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   NotificationEndpoint notificationEndpointResource = NotificationEndpoint.newBuilder().build();
   *   Operation response = regionNotificationEndpointClient.insertRegionNotificationEndpoint(region.toString(), notificationEndpointResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param notificationEndpointResource Represents a notification endpoint.
   *     <p>A notification endpoint resource defines an endpoint to receive notifications when there
   *     are status changes detected by the associated health check service.
   *     <p>For more information, see Health checks overview. (== resource_for
   *     {$api_version}.notificationEndpoint ==) (== resource_for
   *     {$api_version}.regionNotificationEndpoints ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionNotificationEndpoint(
      String region, NotificationEndpoint notificationEndpointResource) {
    InsertRegionNotificationEndpointHttpRequest request =
        InsertRegionNotificationEndpointHttpRequest.newBuilder()
            .setRegion(region)
            .setNotificationEndpointResource(notificationEndpointResource)
            .build();
    return insertRegionNotificationEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a NotificationEndpoint in the specified project in the given region using the parameters
   * that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointClient regionNotificationEndpointClient = RegionNotificationEndpointClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   NotificationEndpoint notificationEndpointResource = NotificationEndpoint.newBuilder().build();
   *   InsertRegionNotificationEndpointHttpRequest request = InsertRegionNotificationEndpointHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setNotificationEndpointResource(notificationEndpointResource)
   *     .build();
   *   Operation response = regionNotificationEndpointClient.insertRegionNotificationEndpoint(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionNotificationEndpoint(
      InsertRegionNotificationEndpointHttpRequest request) {
    return insertRegionNotificationEndpointCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a NotificationEndpoint in the specified project in the given region using the parameters
   * that are included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointClient regionNotificationEndpointClient = RegionNotificationEndpointClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   NotificationEndpoint notificationEndpointResource = NotificationEndpoint.newBuilder().build();
   *   InsertRegionNotificationEndpointHttpRequest request = InsertRegionNotificationEndpointHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setNotificationEndpointResource(notificationEndpointResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionNotificationEndpointClient.insertRegionNotificationEndpointCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertRegionNotificationEndpointHttpRequest, Operation>
      insertRegionNotificationEndpointCallable() {
    return stub.insertRegionNotificationEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the NotificationEndpoints for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointClient regionNotificationEndpointClient = RegionNotificationEndpointClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (NotificationEndpoint element : regionNotificationEndpointClient.listRegionNotificationEndpoints(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionNotificationEndpointsPagedResponse listRegionNotificationEndpoints(
      ProjectRegionName region) {
    ListRegionNotificationEndpointsHttpRequest request =
        ListRegionNotificationEndpointsHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listRegionNotificationEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the NotificationEndpoints for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointClient regionNotificationEndpointClient = RegionNotificationEndpointClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (NotificationEndpoint element : regionNotificationEndpointClient.listRegionNotificationEndpoints(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionNotificationEndpointsPagedResponse listRegionNotificationEndpoints(
      String region) {
    ListRegionNotificationEndpointsHttpRequest request =
        ListRegionNotificationEndpointsHttpRequest.newBuilder().setRegion(region).build();
    return listRegionNotificationEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the NotificationEndpoints for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointClient regionNotificationEndpointClient = RegionNotificationEndpointClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionNotificationEndpointsHttpRequest request = ListRegionNotificationEndpointsHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   for (NotificationEndpoint element : regionNotificationEndpointClient.listRegionNotificationEndpoints(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionNotificationEndpointsPagedResponse listRegionNotificationEndpoints(
      ListRegionNotificationEndpointsHttpRequest request) {
    return listRegionNotificationEndpointsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the NotificationEndpoints for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointClient regionNotificationEndpointClient = RegionNotificationEndpointClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionNotificationEndpointsHttpRequest request = ListRegionNotificationEndpointsHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   ApiFuture&lt;ListRegionNotificationEndpointsPagedResponse&gt; future = regionNotificationEndpointClient.listRegionNotificationEndpointsPagedCallable().futureCall(request);
   *   // Do something
   *   for (NotificationEndpoint element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListRegionNotificationEndpointsHttpRequest, ListRegionNotificationEndpointsPagedResponse>
      listRegionNotificationEndpointsPagedCallable() {
    return stub.listRegionNotificationEndpointsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the NotificationEndpoints for a project in the given region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionNotificationEndpointClient regionNotificationEndpointClient = RegionNotificationEndpointClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionNotificationEndpointsHttpRequest request = ListRegionNotificationEndpointsHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   while (true) {
   *     NotificationEndpointList response = regionNotificationEndpointClient.listRegionNotificationEndpointsCallable().call(request);
   *     for (NotificationEndpoint element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionNotificationEndpointsHttpRequest, NotificationEndpointList>
      listRegionNotificationEndpointsCallable() {
    return stub.listRegionNotificationEndpointsCallable();
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

  public static class ListRegionNotificationEndpointsPagedResponse
      extends AbstractPagedListResponse<
          ListRegionNotificationEndpointsHttpRequest,
          NotificationEndpointList,
          NotificationEndpoint,
          ListRegionNotificationEndpointsPage,
          ListRegionNotificationEndpointsFixedSizeCollection> {

    public static ApiFuture<ListRegionNotificationEndpointsPagedResponse> createAsync(
        PageContext<
                ListRegionNotificationEndpointsHttpRequest,
                NotificationEndpointList,
                NotificationEndpoint>
            context,
        ApiFuture<NotificationEndpointList> futureResponse) {
      ApiFuture<ListRegionNotificationEndpointsPage> futurePage =
          ListRegionNotificationEndpointsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListRegionNotificationEndpointsPage, ListRegionNotificationEndpointsPagedResponse>() {
            @Override
            public ListRegionNotificationEndpointsPagedResponse apply(
                ListRegionNotificationEndpointsPage input) {
              return new ListRegionNotificationEndpointsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListRegionNotificationEndpointsPagedResponse(ListRegionNotificationEndpointsPage page) {
      super(page, ListRegionNotificationEndpointsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegionNotificationEndpointsPage
      extends AbstractPage<
          ListRegionNotificationEndpointsHttpRequest,
          NotificationEndpointList,
          NotificationEndpoint,
          ListRegionNotificationEndpointsPage> {

    private ListRegionNotificationEndpointsPage(
        PageContext<
                ListRegionNotificationEndpointsHttpRequest,
                NotificationEndpointList,
                NotificationEndpoint>
            context,
        NotificationEndpointList response) {
      super(context, response);
    }

    private static ListRegionNotificationEndpointsPage createEmptyPage() {
      return new ListRegionNotificationEndpointsPage(null, null);
    }

    @Override
    protected ListRegionNotificationEndpointsPage createPage(
        PageContext<
                ListRegionNotificationEndpointsHttpRequest,
                NotificationEndpointList,
                NotificationEndpoint>
            context,
        NotificationEndpointList response) {
      return new ListRegionNotificationEndpointsPage(context, response);
    }

    @Override
    public ApiFuture<ListRegionNotificationEndpointsPage> createPageAsync(
        PageContext<
                ListRegionNotificationEndpointsHttpRequest,
                NotificationEndpointList,
                NotificationEndpoint>
            context,
        ApiFuture<NotificationEndpointList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegionNotificationEndpointsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionNotificationEndpointsHttpRequest,
          NotificationEndpointList,
          NotificationEndpoint,
          ListRegionNotificationEndpointsPage,
          ListRegionNotificationEndpointsFixedSizeCollection> {

    private ListRegionNotificationEndpointsFixedSizeCollection(
        List<ListRegionNotificationEndpointsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegionNotificationEndpointsFixedSizeCollection createEmptyCollection() {
      return new ListRegionNotificationEndpointsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegionNotificationEndpointsFixedSizeCollection createCollection(
        List<ListRegionNotificationEndpointsPage> pages, int collectionSize) {
      return new ListRegionNotificationEndpointsFixedSizeCollection(pages, collectionSize);
    }
  }
}
