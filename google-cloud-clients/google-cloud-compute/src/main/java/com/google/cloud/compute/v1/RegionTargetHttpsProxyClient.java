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
import com.google.cloud.compute.v1.stub.RegionTargetHttpsProxyStub;
import com.google.cloud.compute.v1.stub.RegionTargetHttpsProxyStubSettings;
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
 * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
 *   ProjectRegionTargetHttpsProxyName targetHttpsProxy = ProjectRegionTargetHttpsProxyName.of("[PROJECT]", "[REGION]", "[TARGET_HTTPS_PROXY]");
 *   Operation response = regionTargetHttpsProxyClient.deleteRegionTargetHttpsProxy(targetHttpsProxy);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionTargetHttpsProxyClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of RegionTargetHttpsProxySettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionTargetHttpsProxySettings regionTargetHttpsProxySettings =
 *     RegionTargetHttpsProxySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionTargetHttpsProxyClient regionTargetHttpsProxyClient =
 *     RegionTargetHttpsProxyClient.create(regionTargetHttpsProxySettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionTargetHttpsProxySettings regionTargetHttpsProxySettings =
 *     RegionTargetHttpsProxySettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionTargetHttpsProxyClient regionTargetHttpsProxyClient =
 *     RegionTargetHttpsProxyClient.create(regionTargetHttpsProxySettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionTargetHttpsProxyClient implements BackgroundResource {
  private final RegionTargetHttpsProxySettings settings;
  private final RegionTargetHttpsProxyStub stub;

  /** Constructs an instance of RegionTargetHttpsProxyClient with default settings. */
  public static final RegionTargetHttpsProxyClient create() throws IOException {
    return create(RegionTargetHttpsProxySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionTargetHttpsProxyClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionTargetHttpsProxyClient create(RegionTargetHttpsProxySettings settings)
      throws IOException {
    return new RegionTargetHttpsProxyClient(settings);
  }

  /**
   * Constructs an instance of RegionTargetHttpsProxyClient, using the given stub for making calls.
   * This is for advanced usage - prefer to use RegionTargetHttpsProxySettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionTargetHttpsProxyClient create(RegionTargetHttpsProxyStub stub) {
    return new RegionTargetHttpsProxyClient(stub);
  }

  /**
   * Constructs an instance of RegionTargetHttpsProxyClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionTargetHttpsProxyClient(RegionTargetHttpsProxySettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionTargetHttpsProxyStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionTargetHttpsProxyClient(RegionTargetHttpsProxyStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionTargetHttpsProxySettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionTargetHttpsProxyStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetHttpsProxy resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   ProjectRegionTargetHttpsProxyName targetHttpsProxy = ProjectRegionTargetHttpsProxyName.of("[PROJECT]", "[REGION]", "[TARGET_HTTPS_PROXY]");
   *   Operation response = regionTargetHttpsProxyClient.deleteRegionTargetHttpsProxy(targetHttpsProxy);
   * }
   * </code></pre>
   *
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionTargetHttpsProxy(
      ProjectRegionTargetHttpsProxyName targetHttpsProxy) {

    DeleteRegionTargetHttpsProxyHttpRequest request =
        DeleteRegionTargetHttpsProxyHttpRequest.newBuilder()
            .setTargetHttpsProxy(targetHttpsProxy == null ? null : targetHttpsProxy.toString())
            .build();
    return deleteRegionTargetHttpsProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetHttpsProxy resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   ProjectRegionTargetHttpsProxyName targetHttpsProxy = ProjectRegionTargetHttpsProxyName.of("[PROJECT]", "[REGION]", "[TARGET_HTTPS_PROXY]");
   *   Operation response = regionTargetHttpsProxyClient.deleteRegionTargetHttpsProxy(targetHttpsProxy.toString());
   * }
   * </code></pre>
   *
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionTargetHttpsProxy(String targetHttpsProxy) {

    DeleteRegionTargetHttpsProxyHttpRequest request =
        DeleteRegionTargetHttpsProxyHttpRequest.newBuilder()
            .setTargetHttpsProxy(targetHttpsProxy)
            .build();
    return deleteRegionTargetHttpsProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetHttpsProxy resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   String formattedTargetHttpsProxy = ProjectRegionTargetHttpsProxyName.format("[PROJECT]", "[REGION]", "[TARGET_HTTPS_PROXY]");
   *   DeleteRegionTargetHttpsProxyHttpRequest request = DeleteRegionTargetHttpsProxyHttpRequest.newBuilder()
   *     .setTargetHttpsProxy(formattedTargetHttpsProxy)
   *     .build();
   *   Operation response = regionTargetHttpsProxyClient.deleteRegionTargetHttpsProxy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionTargetHttpsProxy(
      DeleteRegionTargetHttpsProxyHttpRequest request) {
    return deleteRegionTargetHttpsProxyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetHttpsProxy resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   String formattedTargetHttpsProxy = ProjectRegionTargetHttpsProxyName.format("[PROJECT]", "[REGION]", "[TARGET_HTTPS_PROXY]");
   *   DeleteRegionTargetHttpsProxyHttpRequest request = DeleteRegionTargetHttpsProxyHttpRequest.newBuilder()
   *     .setTargetHttpsProxy(formattedTargetHttpsProxy)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionTargetHttpsProxyClient.deleteRegionTargetHttpsProxyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteRegionTargetHttpsProxyHttpRequest, Operation>
      deleteRegionTargetHttpsProxyCallable() {
    return stub.deleteRegionTargetHttpsProxyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetHttpsProxy resource in the specified region. Gets a list of
   * available target HTTP proxies by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   ProjectRegionTargetHttpsProxyName targetHttpsProxy = ProjectRegionTargetHttpsProxyName.of("[PROJECT]", "[REGION]", "[TARGET_HTTPS_PROXY]");
   *   TargetHttpsProxy response = regionTargetHttpsProxyClient.getRegionTargetHttpsProxy(targetHttpsProxy);
   * }
   * </code></pre>
   *
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetHttpsProxy getRegionTargetHttpsProxy(
      ProjectRegionTargetHttpsProxyName targetHttpsProxy) {

    GetRegionTargetHttpsProxyHttpRequest request =
        GetRegionTargetHttpsProxyHttpRequest.newBuilder()
            .setTargetHttpsProxy(targetHttpsProxy == null ? null : targetHttpsProxy.toString())
            .build();
    return getRegionTargetHttpsProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetHttpsProxy resource in the specified region. Gets a list of
   * available target HTTP proxies by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   ProjectRegionTargetHttpsProxyName targetHttpsProxy = ProjectRegionTargetHttpsProxyName.of("[PROJECT]", "[REGION]", "[TARGET_HTTPS_PROXY]");
   *   TargetHttpsProxy response = regionTargetHttpsProxyClient.getRegionTargetHttpsProxy(targetHttpsProxy.toString());
   * }
   * </code></pre>
   *
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetHttpsProxy getRegionTargetHttpsProxy(String targetHttpsProxy) {

    GetRegionTargetHttpsProxyHttpRequest request =
        GetRegionTargetHttpsProxyHttpRequest.newBuilder()
            .setTargetHttpsProxy(targetHttpsProxy)
            .build();
    return getRegionTargetHttpsProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetHttpsProxy resource in the specified region. Gets a list of
   * available target HTTP proxies by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   String formattedTargetHttpsProxy = ProjectRegionTargetHttpsProxyName.format("[PROJECT]", "[REGION]", "[TARGET_HTTPS_PROXY]");
   *   GetRegionTargetHttpsProxyHttpRequest request = GetRegionTargetHttpsProxyHttpRequest.newBuilder()
   *     .setTargetHttpsProxy(formattedTargetHttpsProxy)
   *     .build();
   *   TargetHttpsProxy response = regionTargetHttpsProxyClient.getRegionTargetHttpsProxy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetHttpsProxy getRegionTargetHttpsProxy(
      GetRegionTargetHttpsProxyHttpRequest request) {
    return getRegionTargetHttpsProxyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetHttpsProxy resource in the specified region. Gets a list of
   * available target HTTP proxies by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   String formattedTargetHttpsProxy = ProjectRegionTargetHttpsProxyName.format("[PROJECT]", "[REGION]", "[TARGET_HTTPS_PROXY]");
   *   GetRegionTargetHttpsProxyHttpRequest request = GetRegionTargetHttpsProxyHttpRequest.newBuilder()
   *     .setTargetHttpsProxy(formattedTargetHttpsProxy)
   *     .build();
   *   ApiFuture&lt;TargetHttpsProxy&gt; future = regionTargetHttpsProxyClient.getRegionTargetHttpsProxyCallable().futureCall(request);
   *   // Do something
   *   TargetHttpsProxy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetRegionTargetHttpsProxyHttpRequest, TargetHttpsProxy>
      getRegionTargetHttpsProxyCallable() {
    return stub.getRegionTargetHttpsProxyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetHttpsProxy resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   TargetHttpsProxy targetHttpsProxyResource = TargetHttpsProxy.newBuilder().build();
   *   Operation response = regionTargetHttpsProxyClient.insertRegionTargetHttpsProxy(region, targetHttpsProxyResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param targetHttpsProxyResource Represents a Target HTTPS Proxy resource.
   *     <p>A target HTTPS proxy is a component of certain types of load balancers. Global
   *     forwarding rules reference a target HTTPS proxy, and the target proxy then references a URL
   *     map. For more information, read Using Target Proxies. (== resource_for
   *     beta.targetHttpsProxies ==) (== resource_for v1.targetHttpsProxies ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionTargetHttpsProxy(
      ProjectRegionName region, TargetHttpsProxy targetHttpsProxyResource) {

    InsertRegionTargetHttpsProxyHttpRequest request =
        InsertRegionTargetHttpsProxyHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setTargetHttpsProxyResource(targetHttpsProxyResource)
            .build();
    return insertRegionTargetHttpsProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetHttpsProxy resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   TargetHttpsProxy targetHttpsProxyResource = TargetHttpsProxy.newBuilder().build();
   *   Operation response = regionTargetHttpsProxyClient.insertRegionTargetHttpsProxy(region.toString(), targetHttpsProxyResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param targetHttpsProxyResource Represents a Target HTTPS Proxy resource.
   *     <p>A target HTTPS proxy is a component of certain types of load balancers. Global
   *     forwarding rules reference a target HTTPS proxy, and the target proxy then references a URL
   *     map. For more information, read Using Target Proxies. (== resource_for
   *     beta.targetHttpsProxies ==) (== resource_for v1.targetHttpsProxies ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionTargetHttpsProxy(
      String region, TargetHttpsProxy targetHttpsProxyResource) {

    InsertRegionTargetHttpsProxyHttpRequest request =
        InsertRegionTargetHttpsProxyHttpRequest.newBuilder()
            .setRegion(region)
            .setTargetHttpsProxyResource(targetHttpsProxyResource)
            .build();
    return insertRegionTargetHttpsProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetHttpsProxy resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   TargetHttpsProxy targetHttpsProxyResource = TargetHttpsProxy.newBuilder().build();
   *   InsertRegionTargetHttpsProxyHttpRequest request = InsertRegionTargetHttpsProxyHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setTargetHttpsProxyResource(targetHttpsProxyResource)
   *     .build();
   *   Operation response = regionTargetHttpsProxyClient.insertRegionTargetHttpsProxy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionTargetHttpsProxy(
      InsertRegionTargetHttpsProxyHttpRequest request) {
    return insertRegionTargetHttpsProxyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetHttpsProxy resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   TargetHttpsProxy targetHttpsProxyResource = TargetHttpsProxy.newBuilder().build();
   *   InsertRegionTargetHttpsProxyHttpRequest request = InsertRegionTargetHttpsProxyHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setTargetHttpsProxyResource(targetHttpsProxyResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionTargetHttpsProxyClient.insertRegionTargetHttpsProxyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertRegionTargetHttpsProxyHttpRequest, Operation>
      insertRegionTargetHttpsProxyCallable() {
    return stub.insertRegionTargetHttpsProxyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of TargetHttpsProxy resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (TargetHttpsProxy element : regionTargetHttpsProxyClient.listRegionTargetHttpsProxies(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionTargetHttpsProxiesPagedResponse listRegionTargetHttpsProxies(
      ProjectRegionName region) {
    ListRegionTargetHttpsProxiesHttpRequest request =
        ListRegionTargetHttpsProxiesHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listRegionTargetHttpsProxies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of TargetHttpsProxy resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (TargetHttpsProxy element : regionTargetHttpsProxyClient.listRegionTargetHttpsProxies(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionTargetHttpsProxiesPagedResponse listRegionTargetHttpsProxies(
      String region) {
    ListRegionTargetHttpsProxiesHttpRequest request =
        ListRegionTargetHttpsProxiesHttpRequest.newBuilder().setRegion(region).build();
    return listRegionTargetHttpsProxies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of TargetHttpsProxy resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionTargetHttpsProxiesHttpRequest request = ListRegionTargetHttpsProxiesHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   for (TargetHttpsProxy element : regionTargetHttpsProxyClient.listRegionTargetHttpsProxies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionTargetHttpsProxiesPagedResponse listRegionTargetHttpsProxies(
      ListRegionTargetHttpsProxiesHttpRequest request) {
    return listRegionTargetHttpsProxiesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of TargetHttpsProxy resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionTargetHttpsProxiesHttpRequest request = ListRegionTargetHttpsProxiesHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   ApiFuture&lt;ListRegionTargetHttpsProxiesPagedResponse&gt; future = regionTargetHttpsProxyClient.listRegionTargetHttpsProxiesPagedCallable().futureCall(request);
   *   // Do something
   *   for (TargetHttpsProxy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListRegionTargetHttpsProxiesHttpRequest, ListRegionTargetHttpsProxiesPagedResponse>
      listRegionTargetHttpsProxiesPagedCallable() {
    return stub.listRegionTargetHttpsProxiesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of TargetHttpsProxy resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionTargetHttpsProxiesHttpRequest request = ListRegionTargetHttpsProxiesHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   while (true) {
   *     TargetHttpsProxyList response = regionTargetHttpsProxyClient.listRegionTargetHttpsProxiesCallable().call(request);
   *     for (TargetHttpsProxy element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionTargetHttpsProxiesHttpRequest, TargetHttpsProxyList>
      listRegionTargetHttpsProxiesCallable() {
    return stub.listRegionTargetHttpsProxiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Replaces SslCertificates for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   ProjectRegionTargetHttpsProxyName targetHttpsProxy = ProjectRegionTargetHttpsProxyName.of("[PROJECT]", "[REGION]", "[TARGET_HTTPS_PROXY]");
   *   RegionTargetHttpsProxiesSetSslCertificatesRequest regionTargetHttpsProxiesSetSslCertificatesRequestResource = RegionTargetHttpsProxiesSetSslCertificatesRequest.newBuilder().build();
   *   Operation response = regionTargetHttpsProxyClient.setSslCertificatesRegionTargetHttpsProxy(targetHttpsProxy, regionTargetHttpsProxiesSetSslCertificatesRequestResource);
   * }
   * </code></pre>
   *
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource to set an SslCertificates
   *     resource for.
   * @param regionTargetHttpsProxiesSetSslCertificatesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setSslCertificatesRegionTargetHttpsProxy(
      ProjectRegionTargetHttpsProxyName targetHttpsProxy,
      RegionTargetHttpsProxiesSetSslCertificatesRequest
          regionTargetHttpsProxiesSetSslCertificatesRequestResource) {

    SetSslCertificatesRegionTargetHttpsProxyHttpRequest request =
        SetSslCertificatesRegionTargetHttpsProxyHttpRequest.newBuilder()
            .setTargetHttpsProxy(targetHttpsProxy == null ? null : targetHttpsProxy.toString())
            .setRegionTargetHttpsProxiesSetSslCertificatesRequestResource(
                regionTargetHttpsProxiesSetSslCertificatesRequestResource)
            .build();
    return setSslCertificatesRegionTargetHttpsProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Replaces SslCertificates for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   ProjectRegionTargetHttpsProxyName targetHttpsProxy = ProjectRegionTargetHttpsProxyName.of("[PROJECT]", "[REGION]", "[TARGET_HTTPS_PROXY]");
   *   RegionTargetHttpsProxiesSetSslCertificatesRequest regionTargetHttpsProxiesSetSslCertificatesRequestResource = RegionTargetHttpsProxiesSetSslCertificatesRequest.newBuilder().build();
   *   Operation response = regionTargetHttpsProxyClient.setSslCertificatesRegionTargetHttpsProxy(targetHttpsProxy.toString(), regionTargetHttpsProxiesSetSslCertificatesRequestResource);
   * }
   * </code></pre>
   *
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource to set an SslCertificates
   *     resource for.
   * @param regionTargetHttpsProxiesSetSslCertificatesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setSslCertificatesRegionTargetHttpsProxy(
      String targetHttpsProxy,
      RegionTargetHttpsProxiesSetSslCertificatesRequest
          regionTargetHttpsProxiesSetSslCertificatesRequestResource) {

    SetSslCertificatesRegionTargetHttpsProxyHttpRequest request =
        SetSslCertificatesRegionTargetHttpsProxyHttpRequest.newBuilder()
            .setTargetHttpsProxy(targetHttpsProxy)
            .setRegionTargetHttpsProxiesSetSslCertificatesRequestResource(
                regionTargetHttpsProxiesSetSslCertificatesRequestResource)
            .build();
    return setSslCertificatesRegionTargetHttpsProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Replaces SslCertificates for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   String formattedTargetHttpsProxy = ProjectRegionTargetHttpsProxyName.format("[PROJECT]", "[REGION]", "[TARGET_HTTPS_PROXY]");
   *   RegionTargetHttpsProxiesSetSslCertificatesRequest regionTargetHttpsProxiesSetSslCertificatesRequestResource = RegionTargetHttpsProxiesSetSslCertificatesRequest.newBuilder().build();
   *   SetSslCertificatesRegionTargetHttpsProxyHttpRequest request = SetSslCertificatesRegionTargetHttpsProxyHttpRequest.newBuilder()
   *     .setTargetHttpsProxy(formattedTargetHttpsProxy)
   *     .setRegionTargetHttpsProxiesSetSslCertificatesRequestResource(regionTargetHttpsProxiesSetSslCertificatesRequestResource)
   *     .build();
   *   Operation response = regionTargetHttpsProxyClient.setSslCertificatesRegionTargetHttpsProxy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setSslCertificatesRegionTargetHttpsProxy(
      SetSslCertificatesRegionTargetHttpsProxyHttpRequest request) {
    return setSslCertificatesRegionTargetHttpsProxyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Replaces SslCertificates for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   String formattedTargetHttpsProxy = ProjectRegionTargetHttpsProxyName.format("[PROJECT]", "[REGION]", "[TARGET_HTTPS_PROXY]");
   *   RegionTargetHttpsProxiesSetSslCertificatesRequest regionTargetHttpsProxiesSetSslCertificatesRequestResource = RegionTargetHttpsProxiesSetSslCertificatesRequest.newBuilder().build();
   *   SetSslCertificatesRegionTargetHttpsProxyHttpRequest request = SetSslCertificatesRegionTargetHttpsProxyHttpRequest.newBuilder()
   *     .setTargetHttpsProxy(formattedTargetHttpsProxy)
   *     .setRegionTargetHttpsProxiesSetSslCertificatesRequestResource(regionTargetHttpsProxiesSetSslCertificatesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionTargetHttpsProxyClient.setSslCertificatesRegionTargetHttpsProxyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetSslCertificatesRegionTargetHttpsProxyHttpRequest, Operation>
      setSslCertificatesRegionTargetHttpsProxyCallable() {
    return stub.setSslCertificatesRegionTargetHttpsProxyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the URL map for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   ProjectRegionTargetHttpsProxyName targetHttpsProxy = ProjectRegionTargetHttpsProxyName.of("[PROJECT]", "[REGION]", "[TARGET_HTTPS_PROXY]");
   *   UrlMapReference urlMapReferenceResource = UrlMapReference.newBuilder().build();
   *   Operation response = regionTargetHttpsProxyClient.setUrlMapRegionTargetHttpsProxy(targetHttpsProxy, urlMapReferenceResource);
   * }
   * </code></pre>
   *
   * @param targetHttpsProxy Name of the TargetHttpsProxy to set a URL map for.
   * @param urlMapReferenceResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setUrlMapRegionTargetHttpsProxy(
      ProjectRegionTargetHttpsProxyName targetHttpsProxy, UrlMapReference urlMapReferenceResource) {

    SetUrlMapRegionTargetHttpsProxyHttpRequest request =
        SetUrlMapRegionTargetHttpsProxyHttpRequest.newBuilder()
            .setTargetHttpsProxy(targetHttpsProxy == null ? null : targetHttpsProxy.toString())
            .setUrlMapReferenceResource(urlMapReferenceResource)
            .build();
    return setUrlMapRegionTargetHttpsProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the URL map for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   ProjectRegionTargetHttpsProxyName targetHttpsProxy = ProjectRegionTargetHttpsProxyName.of("[PROJECT]", "[REGION]", "[TARGET_HTTPS_PROXY]");
   *   UrlMapReference urlMapReferenceResource = UrlMapReference.newBuilder().build();
   *   Operation response = regionTargetHttpsProxyClient.setUrlMapRegionTargetHttpsProxy(targetHttpsProxy.toString(), urlMapReferenceResource);
   * }
   * </code></pre>
   *
   * @param targetHttpsProxy Name of the TargetHttpsProxy to set a URL map for.
   * @param urlMapReferenceResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setUrlMapRegionTargetHttpsProxy(
      String targetHttpsProxy, UrlMapReference urlMapReferenceResource) {

    SetUrlMapRegionTargetHttpsProxyHttpRequest request =
        SetUrlMapRegionTargetHttpsProxyHttpRequest.newBuilder()
            .setTargetHttpsProxy(targetHttpsProxy)
            .setUrlMapReferenceResource(urlMapReferenceResource)
            .build();
    return setUrlMapRegionTargetHttpsProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the URL map for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   String formattedTargetHttpsProxy = ProjectRegionTargetHttpsProxyName.format("[PROJECT]", "[REGION]", "[TARGET_HTTPS_PROXY]");
   *   UrlMapReference urlMapReferenceResource = UrlMapReference.newBuilder().build();
   *   SetUrlMapRegionTargetHttpsProxyHttpRequest request = SetUrlMapRegionTargetHttpsProxyHttpRequest.newBuilder()
   *     .setTargetHttpsProxy(formattedTargetHttpsProxy)
   *     .setUrlMapReferenceResource(urlMapReferenceResource)
   *     .build();
   *   Operation response = regionTargetHttpsProxyClient.setUrlMapRegionTargetHttpsProxy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setUrlMapRegionTargetHttpsProxy(
      SetUrlMapRegionTargetHttpsProxyHttpRequest request) {
    return setUrlMapRegionTargetHttpsProxyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the URL map for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxyClient regionTargetHttpsProxyClient = RegionTargetHttpsProxyClient.create()) {
   *   String formattedTargetHttpsProxy = ProjectRegionTargetHttpsProxyName.format("[PROJECT]", "[REGION]", "[TARGET_HTTPS_PROXY]");
   *   UrlMapReference urlMapReferenceResource = UrlMapReference.newBuilder().build();
   *   SetUrlMapRegionTargetHttpsProxyHttpRequest request = SetUrlMapRegionTargetHttpsProxyHttpRequest.newBuilder()
   *     .setTargetHttpsProxy(formattedTargetHttpsProxy)
   *     .setUrlMapReferenceResource(urlMapReferenceResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionTargetHttpsProxyClient.setUrlMapRegionTargetHttpsProxyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetUrlMapRegionTargetHttpsProxyHttpRequest, Operation>
      setUrlMapRegionTargetHttpsProxyCallable() {
    return stub.setUrlMapRegionTargetHttpsProxyCallable();
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

  public static class ListRegionTargetHttpsProxiesPagedResponse
      extends AbstractPagedListResponse<
          ListRegionTargetHttpsProxiesHttpRequest,
          TargetHttpsProxyList,
          TargetHttpsProxy,
          ListRegionTargetHttpsProxiesPage,
          ListRegionTargetHttpsProxiesFixedSizeCollection> {

    public static ApiFuture<ListRegionTargetHttpsProxiesPagedResponse> createAsync(
        PageContext<ListRegionTargetHttpsProxiesHttpRequest, TargetHttpsProxyList, TargetHttpsProxy>
            context,
        ApiFuture<TargetHttpsProxyList> futureResponse) {
      ApiFuture<ListRegionTargetHttpsProxiesPage> futurePage =
          ListRegionTargetHttpsProxiesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListRegionTargetHttpsProxiesPage, ListRegionTargetHttpsProxiesPagedResponse>() {
            @Override
            public ListRegionTargetHttpsProxiesPagedResponse apply(
                ListRegionTargetHttpsProxiesPage input) {
              return new ListRegionTargetHttpsProxiesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListRegionTargetHttpsProxiesPagedResponse(ListRegionTargetHttpsProxiesPage page) {
      super(page, ListRegionTargetHttpsProxiesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegionTargetHttpsProxiesPage
      extends AbstractPage<
          ListRegionTargetHttpsProxiesHttpRequest,
          TargetHttpsProxyList,
          TargetHttpsProxy,
          ListRegionTargetHttpsProxiesPage> {

    private ListRegionTargetHttpsProxiesPage(
        PageContext<ListRegionTargetHttpsProxiesHttpRequest, TargetHttpsProxyList, TargetHttpsProxy>
            context,
        TargetHttpsProxyList response) {
      super(context, response);
    }

    private static ListRegionTargetHttpsProxiesPage createEmptyPage() {
      return new ListRegionTargetHttpsProxiesPage(null, null);
    }

    @Override
    protected ListRegionTargetHttpsProxiesPage createPage(
        PageContext<ListRegionTargetHttpsProxiesHttpRequest, TargetHttpsProxyList, TargetHttpsProxy>
            context,
        TargetHttpsProxyList response) {
      return new ListRegionTargetHttpsProxiesPage(context, response);
    }

    @Override
    public ApiFuture<ListRegionTargetHttpsProxiesPage> createPageAsync(
        PageContext<ListRegionTargetHttpsProxiesHttpRequest, TargetHttpsProxyList, TargetHttpsProxy>
            context,
        ApiFuture<TargetHttpsProxyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegionTargetHttpsProxiesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionTargetHttpsProxiesHttpRequest,
          TargetHttpsProxyList,
          TargetHttpsProxy,
          ListRegionTargetHttpsProxiesPage,
          ListRegionTargetHttpsProxiesFixedSizeCollection> {

    private ListRegionTargetHttpsProxiesFixedSizeCollection(
        List<ListRegionTargetHttpsProxiesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegionTargetHttpsProxiesFixedSizeCollection createEmptyCollection() {
      return new ListRegionTargetHttpsProxiesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegionTargetHttpsProxiesFixedSizeCollection createCollection(
        List<ListRegionTargetHttpsProxiesPage> pages, int collectionSize) {
      return new ListRegionTargetHttpsProxiesFixedSizeCollection(pages, collectionSize);
    }
  }
}
