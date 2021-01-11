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
import com.google.cloud.compute.v1.stub.RegionTargetHttpsProxiesStub;
import com.google.cloud.compute.v1.stub.RegionTargetHttpsProxiesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The RegionTargetHttpsProxies API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String targetHttpsProxy = "";
 *   Operation response = regionTargetHttpsProxiesClient.delete(project, region, targetHttpsProxy);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionTargetHttpsProxiesClient object to clean up
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
 * RegionTargetHttpsProxiesSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionTargetHttpsProxiesSettings regionTargetHttpsProxiesSettings =
 *     RegionTargetHttpsProxiesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
 *     RegionTargetHttpsProxiesClient.create(regionTargetHttpsProxiesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionTargetHttpsProxiesSettings regionTargetHttpsProxiesSettings =
 *     RegionTargetHttpsProxiesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient =
 *     RegionTargetHttpsProxiesClient.create(regionTargetHttpsProxiesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionTargetHttpsProxiesClient implements BackgroundResource {
  private final RegionTargetHttpsProxiesSettings settings;
  private final RegionTargetHttpsProxiesStub stub;

  /** Constructs an instance of RegionTargetHttpsProxiesClient with default settings. */
  public static final RegionTargetHttpsProxiesClient create() throws IOException {
    return create(RegionTargetHttpsProxiesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionTargetHttpsProxiesClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RegionTargetHttpsProxiesClient create(
      RegionTargetHttpsProxiesSettings settings) throws IOException {
    return new RegionTargetHttpsProxiesClient(settings);
  }

  /**
   * Constructs an instance of RegionTargetHttpsProxiesClient, using the given stub for making
   * calls. This is for advanced usage - prefer to use RegionTargetHttpsProxiesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionTargetHttpsProxiesClient create(RegionTargetHttpsProxiesStub stub) {
    return new RegionTargetHttpsProxiesClient(stub);
  }

  /**
   * Constructs an instance of RegionTargetHttpsProxiesClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionTargetHttpsProxiesClient(RegionTargetHttpsProxiesSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionTargetHttpsProxiesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionTargetHttpsProxiesClient(RegionTargetHttpsProxiesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionTargetHttpsProxiesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionTargetHttpsProxiesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetHttpsProxy resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetHttpsProxy = "";
   *   Operation response = regionTargetHttpsProxiesClient.delete(project, region, targetHttpsProxy);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String targetHttpsProxy) {
    DeleteRegionTargetHttpsProxyRequest request =
        DeleteRegionTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetHttpsProxy(targetHttpsProxy)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetHttpsProxy resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetHttpsProxy = "";
   *   DeleteRegionTargetHttpsProxyRequest request = DeleteRegionTargetHttpsProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetHttpsProxy(targetHttpsProxy)
   *     .build();
   *   Operation response = regionTargetHttpsProxiesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteRegionTargetHttpsProxyRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetHttpsProxy resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetHttpsProxy = "";
   *   DeleteRegionTargetHttpsProxyRequest request = DeleteRegionTargetHttpsProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetHttpsProxy(targetHttpsProxy)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionTargetHttpsProxiesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteRegionTargetHttpsProxyRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetHttpsProxy resource in the specified region. Gets a list of
   * available target HTTP proxies by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetHttpsProxy = "";
   *   TargetHttpsProxy response = regionTargetHttpsProxiesClient.get(project, region, targetHttpsProxy);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetHttpsProxy get(String project, String region, String targetHttpsProxy) {
    GetRegionTargetHttpsProxyRequest request =
        GetRegionTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetHttpsProxy(targetHttpsProxy)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetHttpsProxy resource in the specified region. Gets a list of
   * available target HTTP proxies by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetHttpsProxy = "";
   *   GetRegionTargetHttpsProxyRequest request = GetRegionTargetHttpsProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetHttpsProxy(targetHttpsProxy)
   *     .build();
   *   TargetHttpsProxy response = regionTargetHttpsProxiesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetHttpsProxy get(GetRegionTargetHttpsProxyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetHttpsProxy resource in the specified region. Gets a list of
   * available target HTTP proxies by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetHttpsProxy = "";
   *   GetRegionTargetHttpsProxyRequest request = GetRegionTargetHttpsProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetHttpsProxy(targetHttpsProxy)
   *     .build();
   *   ApiFuture&lt;TargetHttpsProxy&gt; future = regionTargetHttpsProxiesClient.getCallable().futureCall(request);
   *   // Do something
   *   TargetHttpsProxy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetRegionTargetHttpsProxyRequest, TargetHttpsProxy> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetHttpsProxy resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   TargetHttpsProxy targetHttpsProxyResource = TargetHttpsProxy.newBuilder().build();
   *   Operation response = regionTargetHttpsProxiesClient.insert(project, region, targetHttpsProxyResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetHttpsProxyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(
      String project, String region, TargetHttpsProxy targetHttpsProxyResource) {
    InsertRegionTargetHttpsProxyRequest request =
        InsertRegionTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetHttpsProxyResource(targetHttpsProxyResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetHttpsProxy resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   TargetHttpsProxy targetHttpsProxyResource = TargetHttpsProxy.newBuilder().build();
   *   InsertRegionTargetHttpsProxyRequest request = InsertRegionTargetHttpsProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetHttpsProxyResource(targetHttpsProxyResource)
   *     .build();
   *   Operation response = regionTargetHttpsProxiesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertRegionTargetHttpsProxyRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetHttpsProxy resource in the specified project and region using the data included
   * in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   TargetHttpsProxy targetHttpsProxyResource = TargetHttpsProxy.newBuilder().build();
   *   InsertRegionTargetHttpsProxyRequest request = InsertRegionTargetHttpsProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetHttpsProxyResource(targetHttpsProxyResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionTargetHttpsProxiesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertRegionTargetHttpsProxyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of TargetHttpsProxy resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (TargetHttpsProxy element : regionTargetHttpsProxiesClient.list(project, region).iterateAll()) {
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
    ListRegionTargetHttpsProxiesRequest request =
        ListRegionTargetHttpsProxiesRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of TargetHttpsProxy resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionTargetHttpsProxiesRequest request = ListRegionTargetHttpsProxiesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (TargetHttpsProxy element : regionTargetHttpsProxiesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionTargetHttpsProxiesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of TargetHttpsProxy resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionTargetHttpsProxiesRequest request = ListRegionTargetHttpsProxiesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = regionTargetHttpsProxiesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (TargetHttpsProxy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListRegionTargetHttpsProxiesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of TargetHttpsProxy resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionTargetHttpsProxiesRequest request = ListRegionTargetHttpsProxiesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     TargetHttpsProxyList response = regionTargetHttpsProxiesClient.listCallable().call(request);
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
  public final UnaryCallable<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Replaces SslCertificates for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetHttpsProxy = "";
   *   RegionTargetHttpsProxiesSetSslCertificatesRequest regionTargetHttpsProxiesSetSslCertificatesRequestResource = RegionTargetHttpsProxiesSetSslCertificatesRequest.newBuilder().build();
   *   Operation response = regionTargetHttpsProxiesClient.setSslCertificates(project, region, targetHttpsProxy, regionTargetHttpsProxiesSetSslCertificatesRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetHttpsProxy Name of the TargetHttpsProxy resource to set an SslCertificates
   *     resource for.
   * @param regionTargetHttpsProxiesSetSslCertificatesRequestResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setSslCertificates(
      String project,
      String region,
      String targetHttpsProxy,
      RegionTargetHttpsProxiesSetSslCertificatesRequest
          regionTargetHttpsProxiesSetSslCertificatesRequestResource) {
    SetSslCertificatesRegionTargetHttpsProxyRequest request =
        SetSslCertificatesRegionTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetHttpsProxy(targetHttpsProxy)
            .setRegionTargetHttpsProxiesSetSslCertificatesRequestResource(
                regionTargetHttpsProxiesSetSslCertificatesRequestResource)
            .build();
    return setSslCertificates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Replaces SslCertificates for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   RegionTargetHttpsProxiesSetSslCertificatesRequest regionTargetHttpsProxiesSetSslCertificatesRequestResource = RegionTargetHttpsProxiesSetSslCertificatesRequest.newBuilder().build();
   *   String targetHttpsProxy = "";
   *   SetSslCertificatesRegionTargetHttpsProxyRequest request = SetSslCertificatesRegionTargetHttpsProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionTargetHttpsProxiesSetSslCertificatesRequestResource(regionTargetHttpsProxiesSetSslCertificatesRequestResource)
   *     .setTargetHttpsProxy(targetHttpsProxy)
   *     .build();
   *   Operation response = regionTargetHttpsProxiesClient.setSslCertificates(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setSslCertificates(
      SetSslCertificatesRegionTargetHttpsProxyRequest request) {
    return setSslCertificatesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Replaces SslCertificates for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   RegionTargetHttpsProxiesSetSslCertificatesRequest regionTargetHttpsProxiesSetSslCertificatesRequestResource = RegionTargetHttpsProxiesSetSslCertificatesRequest.newBuilder().build();
   *   String targetHttpsProxy = "";
   *   SetSslCertificatesRegionTargetHttpsProxyRequest request = SetSslCertificatesRegionTargetHttpsProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionTargetHttpsProxiesSetSslCertificatesRequestResource(regionTargetHttpsProxiesSetSslCertificatesRequestResource)
   *     .setTargetHttpsProxy(targetHttpsProxy)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionTargetHttpsProxiesClient.setSslCertificatesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetSslCertificatesRegionTargetHttpsProxyRequest, Operation>
      setSslCertificatesCallable() {
    return stub.setSslCertificatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the URL map for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetHttpsProxy = "";
   *   UrlMapReference urlMapReferenceResource = UrlMapReference.newBuilder().build();
   *   Operation response = regionTargetHttpsProxiesClient.setUrlMap(project, region, targetHttpsProxy, urlMapReferenceResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param targetHttpsProxy Name of the TargetHttpsProxy to set a URL map for.
   * @param urlMapReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setUrlMap(
      String project,
      String region,
      String targetHttpsProxy,
      UrlMapReference urlMapReferenceResource) {
    SetUrlMapRegionTargetHttpsProxyRequest request =
        SetUrlMapRegionTargetHttpsProxyRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setTargetHttpsProxy(targetHttpsProxy)
            .setUrlMapReferenceResource(urlMapReferenceResource)
            .build();
    return setUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the URL map for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetHttpsProxy = "";
   *   UrlMapReference urlMapReferenceResource = UrlMapReference.newBuilder().build();
   *   SetUrlMapRegionTargetHttpsProxyRequest request = SetUrlMapRegionTargetHttpsProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetHttpsProxy(targetHttpsProxy)
   *     .setUrlMapReferenceResource(urlMapReferenceResource)
   *     .build();
   *   Operation response = regionTargetHttpsProxiesClient.setUrlMap(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation setUrlMap(SetUrlMapRegionTargetHttpsProxyRequest request) {
    return setUrlMapCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the URL map for TargetHttpsProxy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionTargetHttpsProxiesClient regionTargetHttpsProxiesClient = RegionTargetHttpsProxiesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String targetHttpsProxy = "";
   *   UrlMapReference urlMapReferenceResource = UrlMapReference.newBuilder().build();
   *   SetUrlMapRegionTargetHttpsProxyRequest request = SetUrlMapRegionTargetHttpsProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setTargetHttpsProxy(targetHttpsProxy)
   *     .setUrlMapReferenceResource(urlMapReferenceResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionTargetHttpsProxiesClient.setUrlMapCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetUrlMapRegionTargetHttpsProxyRequest, Operation>
      setUrlMapCallable() {
    return stub.setUrlMapCallable();
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
          ListRegionTargetHttpsProxiesRequest,
          TargetHttpsProxyList,
          TargetHttpsProxy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList, TargetHttpsProxy>
            context,
        ApiFuture<TargetHttpsProxyList> futureResponse) {
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
      extends AbstractPage<
          ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList, TargetHttpsProxy, ListPage> {

    private ListPage(
        PageContext<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList, TargetHttpsProxy>
            context,
        TargetHttpsProxyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList, TargetHttpsProxy>
            context,
        TargetHttpsProxyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList, TargetHttpsProxy>
            context,
        ApiFuture<TargetHttpsProxyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionTargetHttpsProxiesRequest,
          TargetHttpsProxyList,
          TargetHttpsProxy,
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
