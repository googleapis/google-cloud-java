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
import com.google.cloud.compute.v1.stub.RegionTargetHttpProxyStub;
import com.google.cloud.compute.v1.stub.RegionTargetHttpProxyStubSettings;
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
 * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
 *   ProjectRegionTargetHttpProxyName targetHttpProxy = ProjectRegionTargetHttpProxyName.of("[PROJECT]", "[REGION]", "[TARGET_HTTP_PROXY]");
 *   Operation response = regionTargetHttpProxyClient.deleteRegionTargetHttpProxy(targetHttpProxy);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionTargetHttpProxyClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of RegionTargetHttpProxySettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionTargetHttpProxySettings regionTargetHttpProxySettings =
 *     RegionTargetHttpProxySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionTargetHttpProxyClient regionTargetHttpProxyClient =
 *     RegionTargetHttpProxyClient.create(regionTargetHttpProxySettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionTargetHttpProxySettings regionTargetHttpProxySettings =
 *     RegionTargetHttpProxySettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionTargetHttpProxyClient regionTargetHttpProxyClient =
 *     RegionTargetHttpProxyClient.create(regionTargetHttpProxySettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionTargetHttpProxyClient implements BackgroundResource {
  private final RegionTargetHttpProxySettings settings;
  private final RegionTargetHttpProxyStub stub;

  /** Constructs an instance of RegionTargetHttpProxyClient with default settings. */
  public static final RegionTargetHttpProxyClient create() throws IOException {
    return create(RegionTargetHttpProxySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionTargetHttpProxyClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionTargetHttpProxyClient create(RegionTargetHttpProxySettings settings)
      throws IOException {
    return new RegionTargetHttpProxyClient(settings);
  }

  /**
   * Constructs an instance of RegionTargetHttpProxyClient, using the given stub for making calls.
   * This is for advanced usage - prefer to use RegionTargetHttpProxySettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionTargetHttpProxyClient create(RegionTargetHttpProxyStub stub) {
    return new RegionTargetHttpProxyClient(stub);
  }

  /**
   * Constructs an instance of RegionTargetHttpProxyClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionTargetHttpProxyClient(RegionTargetHttpProxySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionTargetHttpProxyStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionTargetHttpProxyClient(RegionTargetHttpProxyStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionTargetHttpProxySettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionTargetHttpProxyStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetHttpProxy resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   ProjectRegionTargetHttpProxyName targetHttpProxy = ProjectRegionTargetHttpProxyName.of("[PROJECT]", "[REGION]", "[TARGET_HTTP_PROXY]");
   *   Operation response = regionTargetHttpProxyClient.deleteRegionTargetHttpProxy(targetHttpProxy);
   * }
   * </code></pre>
   *
   * @param targetHttpProxy Name of the TargetHttpProxy resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionTargetHttpProxy(
      ProjectRegionTargetHttpProxyName targetHttpProxy) {

    DeleteRegionTargetHttpProxyHttpRequest request =
        DeleteRegionTargetHttpProxyHttpRequest.newBuilder()
            .setTargetHttpProxy(targetHttpProxy == null ? null : targetHttpProxy.toString())
            .build();
    return deleteRegionTargetHttpProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetHttpProxy resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   ProjectRegionTargetHttpProxyName targetHttpProxy = ProjectRegionTargetHttpProxyName.of("[PROJECT]", "[REGION]", "[TARGET_HTTP_PROXY]");
   *   Operation response = regionTargetHttpProxyClient.deleteRegionTargetHttpProxy(targetHttpProxy.toString());
   * }
   * </code></pre>
   *
   * @param targetHttpProxy Name of the TargetHttpProxy resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionTargetHttpProxy(String targetHttpProxy) {

    DeleteRegionTargetHttpProxyHttpRequest request =
        DeleteRegionTargetHttpProxyHttpRequest.newBuilder()
            .setTargetHttpProxy(targetHttpProxy)
            .build();
    return deleteRegionTargetHttpProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetHttpProxy resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   String formattedTargetHttpProxy = ProjectRegionTargetHttpProxyName.format("[PROJECT]", "[REGION]", "[TARGET_HTTP_PROXY]");
   *   DeleteRegionTargetHttpProxyHttpRequest request = DeleteRegionTargetHttpProxyHttpRequest.newBuilder()
   *     .setTargetHttpProxy(formattedTargetHttpProxy)
   *     .build();
   *   Operation response = regionTargetHttpProxyClient.deleteRegionTargetHttpProxy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionTargetHttpProxy(
      DeleteRegionTargetHttpProxyHttpRequest request) {
    return deleteRegionTargetHttpProxyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetHttpProxy resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   String formattedTargetHttpProxy = ProjectRegionTargetHttpProxyName.format("[PROJECT]", "[REGION]", "[TARGET_HTTP_PROXY]");
   *   DeleteRegionTargetHttpProxyHttpRequest request = DeleteRegionTargetHttpProxyHttpRequest.newBuilder()
   *     .setTargetHttpProxy(formattedTargetHttpProxy)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionTargetHttpProxyClient.deleteRegionTargetHttpProxyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteRegionTargetHttpProxyHttpRequest, Operation>
      deleteRegionTargetHttpProxyCallable() {
    return stub.deleteRegionTargetHttpProxyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetHttpProxy resource in the specified region. Gets a list of
   * available target HTTP proxies by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   ProjectRegionTargetHttpProxyName targetHttpProxy = ProjectRegionTargetHttpProxyName.of("[PROJECT]", "[REGION]", "[TARGET_HTTP_PROXY]");
   *   TargetHttpProxy response = regionTargetHttpProxyClient.getRegionTargetHttpProxy(targetHttpProxy);
   * }
   * </code></pre>
   *
   * @param targetHttpProxy Name of the TargetHttpProxy resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetHttpProxy getRegionTargetHttpProxy(
      ProjectRegionTargetHttpProxyName targetHttpProxy) {

    GetRegionTargetHttpProxyHttpRequest request =
        GetRegionTargetHttpProxyHttpRequest.newBuilder()
            .setTargetHttpProxy(targetHttpProxy == null ? null : targetHttpProxy.toString())
            .build();
    return getRegionTargetHttpProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetHttpProxy resource in the specified region. Gets a list of
   * available target HTTP proxies by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   ProjectRegionTargetHttpProxyName targetHttpProxy = ProjectRegionTargetHttpProxyName.of("[PROJECT]", "[REGION]", "[TARGET_HTTP_PROXY]");
   *   TargetHttpProxy response = regionTargetHttpProxyClient.getRegionTargetHttpProxy(targetHttpProxy.toString());
   * }
   * </code></pre>
   *
   * @param targetHttpProxy Name of the TargetHttpProxy resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetHttpProxy getRegionTargetHttpProxy(String targetHttpProxy) {

    GetRegionTargetHttpProxyHttpRequest request =
        GetRegionTargetHttpProxyHttpRequest.newBuilder()
            .setTargetHttpProxy(targetHttpProxy)
            .build();
    return getRegionTargetHttpProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetHttpProxy resource in the specified region. Gets a list of
   * available target HTTP proxies by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   String formattedTargetHttpProxy = ProjectRegionTargetHttpProxyName.format("[PROJECT]", "[REGION]", "[TARGET_HTTP_PROXY]");
   *   GetRegionTargetHttpProxyHttpRequest request = GetRegionTargetHttpProxyHttpRequest.newBuilder()
   *     .setTargetHttpProxy(formattedTargetHttpProxy)
   *     .build();
   *   TargetHttpProxy response = regionTargetHttpProxyClient.getRegionTargetHttpProxy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetHttpProxy getRegionTargetHttpProxy(
      GetRegionTargetHttpProxyHttpRequest request) {
    return getRegionTargetHttpProxyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetHttpProxy resource in the specified region. Gets a list of
   * available target HTTP proxies by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   String formattedTargetHttpProxy = ProjectRegionTargetHttpProxyName.format("[PROJECT]", "[REGION]", "[TARGET_HTTP_PROXY]");
   *   GetRegionTargetHttpProxyHttpRequest request = GetRegionTargetHttpProxyHttpRequest.newBuilder()
   *     .setTargetHttpProxy(formattedTargetHttpProxy)
   *     .build();
   *   ApiFuture&lt;TargetHttpProxy&gt; future = regionTargetHttpProxyClient.getRegionTargetHttpProxyCallable().futureCall(request);
   *   // Do something
   *   TargetHttpProxy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetRegionTargetHttpProxyHttpRequest, TargetHttpProxy>
      getRegionTargetHttpProxyCallable() {
    return stub.getRegionTargetHttpProxyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetHttpProxy resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   TargetHttpProxy targetHttpProxyResource = TargetHttpProxy.newBuilder().build();
   *   Operation response = regionTargetHttpProxyClient.insertRegionTargetHttpProxy(region, targetHttpProxyResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param targetHttpProxyResource Represents a Target HTTP Proxy resource.
   *     <p>A target HTTP proxy is a component of certain types of load balancers. Global forwarding
   *     rules reference a target HTTP proxy, and the target proxy then references a URL map. For
   *     more information, read Using Target Proxies. (== resource_for beta.targetHttpProxies ==)
   *     (== resource_for v1.targetHttpProxies ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionTargetHttpProxy(
      ProjectRegionName region, TargetHttpProxy targetHttpProxyResource) {

    InsertRegionTargetHttpProxyHttpRequest request =
        InsertRegionTargetHttpProxyHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setTargetHttpProxyResource(targetHttpProxyResource)
            .build();
    return insertRegionTargetHttpProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetHttpProxy resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   TargetHttpProxy targetHttpProxyResource = TargetHttpProxy.newBuilder().build();
   *   Operation response = regionTargetHttpProxyClient.insertRegionTargetHttpProxy(region.toString(), targetHttpProxyResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param targetHttpProxyResource Represents a Target HTTP Proxy resource.
   *     <p>A target HTTP proxy is a component of certain types of load balancers. Global forwarding
   *     rules reference a target HTTP proxy, and the target proxy then references a URL map. For
   *     more information, read Using Target Proxies. (== resource_for beta.targetHttpProxies ==)
   *     (== resource_for v1.targetHttpProxies ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionTargetHttpProxy(
      String region, TargetHttpProxy targetHttpProxyResource) {

    InsertRegionTargetHttpProxyHttpRequest request =
        InsertRegionTargetHttpProxyHttpRequest.newBuilder()
            .setRegion(region)
            .setTargetHttpProxyResource(targetHttpProxyResource)
            .build();
    return insertRegionTargetHttpProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetHttpProxy resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   TargetHttpProxy targetHttpProxyResource = TargetHttpProxy.newBuilder().build();
   *   InsertRegionTargetHttpProxyHttpRequest request = InsertRegionTargetHttpProxyHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setTargetHttpProxyResource(targetHttpProxyResource)
   *     .build();
   *   Operation response = regionTargetHttpProxyClient.insertRegionTargetHttpProxy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionTargetHttpProxy(
      InsertRegionTargetHttpProxyHttpRequest request) {
    return insertRegionTargetHttpProxyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetHttpProxy resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   TargetHttpProxy targetHttpProxyResource = TargetHttpProxy.newBuilder().build();
   *   InsertRegionTargetHttpProxyHttpRequest request = InsertRegionTargetHttpProxyHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setTargetHttpProxyResource(targetHttpProxyResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionTargetHttpProxyClient.insertRegionTargetHttpProxyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertRegionTargetHttpProxyHttpRequest, Operation>
      insertRegionTargetHttpProxyCallable() {
    return stub.insertRegionTargetHttpProxyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of TargetHttpProxy resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (TargetHttpProxy element : regionTargetHttpProxyClient.listRegionTargetHttpProxies(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionTargetHttpProxiesPagedResponse listRegionTargetHttpProxies(
      ProjectRegionName region) {
    ListRegionTargetHttpProxiesHttpRequest request =
        ListRegionTargetHttpProxiesHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listRegionTargetHttpProxies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of TargetHttpProxy resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (TargetHttpProxy element : regionTargetHttpProxyClient.listRegionTargetHttpProxies(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionTargetHttpProxiesPagedResponse listRegionTargetHttpProxies(String region) {
    ListRegionTargetHttpProxiesHttpRequest request =
        ListRegionTargetHttpProxiesHttpRequest.newBuilder().setRegion(region).build();
    return listRegionTargetHttpProxies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of TargetHttpProxy resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionTargetHttpProxiesHttpRequest request = ListRegionTargetHttpProxiesHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   for (TargetHttpProxy element : regionTargetHttpProxyClient.listRegionTargetHttpProxies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionTargetHttpProxiesPagedResponse listRegionTargetHttpProxies(
      ListRegionTargetHttpProxiesHttpRequest request) {
    return listRegionTargetHttpProxiesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of TargetHttpProxy resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionTargetHttpProxiesHttpRequest request = ListRegionTargetHttpProxiesHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   ApiFuture&lt;ListRegionTargetHttpProxiesPagedResponse&gt; future = regionTargetHttpProxyClient.listRegionTargetHttpProxiesPagedCallable().futureCall(request);
   *   // Do something
   *   for (TargetHttpProxy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListRegionTargetHttpProxiesHttpRequest, ListRegionTargetHttpProxiesPagedResponse>
      listRegionTargetHttpProxiesPagedCallable() {
    return stub.listRegionTargetHttpProxiesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of TargetHttpProxy resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionTargetHttpProxiesHttpRequest request = ListRegionTargetHttpProxiesHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   while (true) {
   *     TargetHttpProxyList response = regionTargetHttpProxyClient.listRegionTargetHttpProxiesCallable().call(request);
   *     for (TargetHttpProxy element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionTargetHttpProxiesHttpRequest, TargetHttpProxyList>
      listRegionTargetHttpProxiesCallable() {
    return stub.listRegionTargetHttpProxiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the URL map for TargetHttpProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   ProjectRegionTargetHttpProxyName targetHttpProxy = ProjectRegionTargetHttpProxyName.of("[PROJECT]", "[REGION]", "[TARGET_HTTP_PROXY]");
   *   UrlMapReference urlMapReferenceResource = UrlMapReference.newBuilder().build();
   *   Operation response = regionTargetHttpProxyClient.setUrlMapRegionTargetHttpProxy(targetHttpProxy, urlMapReferenceResource);
   * }
   * </code></pre>
   *
   * @param targetHttpProxy Name of the TargetHttpProxy to set a URL map for.
   * @param urlMapReferenceResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setUrlMapRegionTargetHttpProxy(
      ProjectRegionTargetHttpProxyName targetHttpProxy, UrlMapReference urlMapReferenceResource) {

    SetUrlMapRegionTargetHttpProxyHttpRequest request =
        SetUrlMapRegionTargetHttpProxyHttpRequest.newBuilder()
            .setTargetHttpProxy(targetHttpProxy == null ? null : targetHttpProxy.toString())
            .setUrlMapReferenceResource(urlMapReferenceResource)
            .build();
    return setUrlMapRegionTargetHttpProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the URL map for TargetHttpProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   ProjectRegionTargetHttpProxyName targetHttpProxy = ProjectRegionTargetHttpProxyName.of("[PROJECT]", "[REGION]", "[TARGET_HTTP_PROXY]");
   *   UrlMapReference urlMapReferenceResource = UrlMapReference.newBuilder().build();
   *   Operation response = regionTargetHttpProxyClient.setUrlMapRegionTargetHttpProxy(targetHttpProxy.toString(), urlMapReferenceResource);
   * }
   * </code></pre>
   *
   * @param targetHttpProxy Name of the TargetHttpProxy to set a URL map for.
   * @param urlMapReferenceResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setUrlMapRegionTargetHttpProxy(
      String targetHttpProxy, UrlMapReference urlMapReferenceResource) {

    SetUrlMapRegionTargetHttpProxyHttpRequest request =
        SetUrlMapRegionTargetHttpProxyHttpRequest.newBuilder()
            .setTargetHttpProxy(targetHttpProxy)
            .setUrlMapReferenceResource(urlMapReferenceResource)
            .build();
    return setUrlMapRegionTargetHttpProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the URL map for TargetHttpProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   String formattedTargetHttpProxy = ProjectRegionTargetHttpProxyName.format("[PROJECT]", "[REGION]", "[TARGET_HTTP_PROXY]");
   *   UrlMapReference urlMapReferenceResource = UrlMapReference.newBuilder().build();
   *   SetUrlMapRegionTargetHttpProxyHttpRequest request = SetUrlMapRegionTargetHttpProxyHttpRequest.newBuilder()
   *     .setTargetHttpProxy(formattedTargetHttpProxy)
   *     .setUrlMapReferenceResource(urlMapReferenceResource)
   *     .build();
   *   Operation response = regionTargetHttpProxyClient.setUrlMapRegionTargetHttpProxy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setUrlMapRegionTargetHttpProxy(
      SetUrlMapRegionTargetHttpProxyHttpRequest request) {
    return setUrlMapRegionTargetHttpProxyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the URL map for TargetHttpProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpProxyClient regionTargetHttpProxyClient = RegionTargetHttpProxyClient.create()) {
   *   String formattedTargetHttpProxy = ProjectRegionTargetHttpProxyName.format("[PROJECT]", "[REGION]", "[TARGET_HTTP_PROXY]");
   *   UrlMapReference urlMapReferenceResource = UrlMapReference.newBuilder().build();
   *   SetUrlMapRegionTargetHttpProxyHttpRequest request = SetUrlMapRegionTargetHttpProxyHttpRequest.newBuilder()
   *     .setTargetHttpProxy(formattedTargetHttpProxy)
   *     .setUrlMapReferenceResource(urlMapReferenceResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionTargetHttpProxyClient.setUrlMapRegionTargetHttpProxyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetUrlMapRegionTargetHttpProxyHttpRequest, Operation>
      setUrlMapRegionTargetHttpProxyCallable() {
    return stub.setUrlMapRegionTargetHttpProxyCallable();
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

  public static class ListRegionTargetHttpProxiesPagedResponse
      extends AbstractPagedListResponse<
          ListRegionTargetHttpProxiesHttpRequest,
          TargetHttpProxyList,
          TargetHttpProxy,
          ListRegionTargetHttpProxiesPage,
          ListRegionTargetHttpProxiesFixedSizeCollection> {

    public static ApiFuture<ListRegionTargetHttpProxiesPagedResponse> createAsync(
        PageContext<ListRegionTargetHttpProxiesHttpRequest, TargetHttpProxyList, TargetHttpProxy>
            context,
        ApiFuture<TargetHttpProxyList> futureResponse) {
      ApiFuture<ListRegionTargetHttpProxiesPage> futurePage =
          ListRegionTargetHttpProxiesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListRegionTargetHttpProxiesPage, ListRegionTargetHttpProxiesPagedResponse>() {
            @Override
            public ListRegionTargetHttpProxiesPagedResponse apply(
                ListRegionTargetHttpProxiesPage input) {
              return new ListRegionTargetHttpProxiesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListRegionTargetHttpProxiesPagedResponse(ListRegionTargetHttpProxiesPage page) {
      super(page, ListRegionTargetHttpProxiesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegionTargetHttpProxiesPage
      extends AbstractPage<
          ListRegionTargetHttpProxiesHttpRequest,
          TargetHttpProxyList,
          TargetHttpProxy,
          ListRegionTargetHttpProxiesPage> {

    private ListRegionTargetHttpProxiesPage(
        PageContext<ListRegionTargetHttpProxiesHttpRequest, TargetHttpProxyList, TargetHttpProxy>
            context,
        TargetHttpProxyList response) {
      super(context, response);
    }

    private static ListRegionTargetHttpProxiesPage createEmptyPage() {
      return new ListRegionTargetHttpProxiesPage(null, null);
    }

    @Override
    protected ListRegionTargetHttpProxiesPage createPage(
        PageContext<ListRegionTargetHttpProxiesHttpRequest, TargetHttpProxyList, TargetHttpProxy>
            context,
        TargetHttpProxyList response) {
      return new ListRegionTargetHttpProxiesPage(context, response);
    }

    @Override
    public ApiFuture<ListRegionTargetHttpProxiesPage> createPageAsync(
        PageContext<ListRegionTargetHttpProxiesHttpRequest, TargetHttpProxyList, TargetHttpProxy>
            context,
        ApiFuture<TargetHttpProxyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegionTargetHttpProxiesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionTargetHttpProxiesHttpRequest,
          TargetHttpProxyList,
          TargetHttpProxy,
          ListRegionTargetHttpProxiesPage,
          ListRegionTargetHttpProxiesFixedSizeCollection> {

    private ListRegionTargetHttpProxiesFixedSizeCollection(
        List<ListRegionTargetHttpProxiesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegionTargetHttpProxiesFixedSizeCollection createEmptyCollection() {
      return new ListRegionTargetHttpProxiesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegionTargetHttpProxiesFixedSizeCollection createCollection(
        List<ListRegionTargetHttpProxiesPage> pages, int collectionSize) {
      return new ListRegionTargetHttpProxiesFixedSizeCollection(pages, collectionSize);
    }
  }
}
