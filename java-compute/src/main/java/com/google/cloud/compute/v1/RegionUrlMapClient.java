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
import com.google.cloud.compute.v1.stub.RegionUrlMapStub;
import com.google.cloud.compute.v1.stub.RegionUrlMapStubSettings;
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
 * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
 *   ProjectRegionUrlMapName urlMap = ProjectRegionUrlMapName.of("[PROJECT]", "[REGION]", "[URL_MAP]");
 *   String requestId = "";
 *   Operation response = regionUrlMapClient.deleteRegionUrlMap(urlMap, requestId);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionUrlMapClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of RegionUrlMapSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionUrlMapSettings regionUrlMapSettings =
 *     RegionUrlMapSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionUrlMapClient regionUrlMapClient =
 *     RegionUrlMapClient.create(regionUrlMapSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionUrlMapSettings regionUrlMapSettings =
 *     RegionUrlMapSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionUrlMapClient regionUrlMapClient =
 *     RegionUrlMapClient.create(regionUrlMapSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionUrlMapClient implements BackgroundResource {
  private final RegionUrlMapSettings settings;
  private final RegionUrlMapStub stub;

  /** Constructs an instance of RegionUrlMapClient with default settings. */
  public static final RegionUrlMapClient create() throws IOException {
    return create(RegionUrlMapSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionUrlMapClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionUrlMapClient create(RegionUrlMapSettings settings) throws IOException {
    return new RegionUrlMapClient(settings);
  }

  /**
   * Constructs an instance of RegionUrlMapClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use RegionUrlMapSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionUrlMapClient create(RegionUrlMapStub stub) {
    return new RegionUrlMapClient(stub);
  }

  /**
   * Constructs an instance of RegionUrlMapClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RegionUrlMapClient(RegionUrlMapSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionUrlMapStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionUrlMapClient(RegionUrlMapStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionUrlMapSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionUrlMapStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   ProjectRegionUrlMapName urlMap = ProjectRegionUrlMapName.of("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   String requestId = "";
   *   Operation response = regionUrlMapClient.deleteRegionUrlMap(urlMap, requestId);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to delete.
   * @param requestId begin_interface: MixerMutationRequestBuilder Request ID to support
   *     idempotency.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionUrlMap(ProjectRegionUrlMapName urlMap, String requestId) {

    DeleteRegionUrlMapHttpRequest request =
        DeleteRegionUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap == null ? null : urlMap.toString())
            .setRequestId(requestId)
            .build();
    return deleteRegionUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   ProjectRegionUrlMapName urlMap = ProjectRegionUrlMapName.of("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   String requestId = "";
   *   Operation response = regionUrlMapClient.deleteRegionUrlMap(urlMap.toString(), requestId);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to delete.
   * @param requestId begin_interface: MixerMutationRequestBuilder Request ID to support
   *     idempotency.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionUrlMap(String urlMap, String requestId) {

    DeleteRegionUrlMapHttpRequest request =
        DeleteRegionUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap)
            .setRequestId(requestId)
            .build();
    return deleteRegionUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   String formattedUrlMap = ProjectRegionUrlMapName.format("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   String requestId = "";
   *   DeleteRegionUrlMapHttpRequest request = DeleteRegionUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(formattedUrlMap)
   *     .setRequestId(requestId)
   *     .build();
   *   Operation response = regionUrlMapClient.deleteRegionUrlMap(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionUrlMap(DeleteRegionUrlMapHttpRequest request) {
    return deleteRegionUrlMapCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   String formattedUrlMap = ProjectRegionUrlMapName.format("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   String requestId = "";
   *   DeleteRegionUrlMapHttpRequest request = DeleteRegionUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(formattedUrlMap)
   *     .setRequestId(requestId)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionUrlMapClient.deleteRegionUrlMapCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteRegionUrlMapHttpRequest, Operation>
      deleteRegionUrlMapCallable() {
    return stub.deleteRegionUrlMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified UrlMap resource. Gets a list of available URL maps by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   ProjectRegionUrlMapName urlMap = ProjectRegionUrlMapName.of("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   UrlMap response = regionUrlMapClient.getRegionUrlMap(urlMap);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final UrlMap getRegionUrlMap(ProjectRegionUrlMapName urlMap) {

    GetRegionUrlMapHttpRequest request =
        GetRegionUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap == null ? null : urlMap.toString())
            .build();
    return getRegionUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified UrlMap resource. Gets a list of available URL maps by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   ProjectRegionUrlMapName urlMap = ProjectRegionUrlMapName.of("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   UrlMap response = regionUrlMapClient.getRegionUrlMap(urlMap.toString());
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final UrlMap getRegionUrlMap(String urlMap) {

    GetRegionUrlMapHttpRequest request =
        GetRegionUrlMapHttpRequest.newBuilder().setUrlMap(urlMap).build();
    return getRegionUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified UrlMap resource. Gets a list of available URL maps by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   String formattedUrlMap = ProjectRegionUrlMapName.format("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   GetRegionUrlMapHttpRequest request = GetRegionUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(formattedUrlMap)
   *     .build();
   *   UrlMap response = regionUrlMapClient.getRegionUrlMap(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final UrlMap getRegionUrlMap(GetRegionUrlMapHttpRequest request) {
    return getRegionUrlMapCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified UrlMap resource. Gets a list of available URL maps by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   String formattedUrlMap = ProjectRegionUrlMapName.format("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   GetRegionUrlMapHttpRequest request = GetRegionUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(formattedUrlMap)
   *     .build();
   *   ApiFuture&lt;UrlMap&gt; future = regionUrlMapClient.getRegionUrlMapCallable().futureCall(request);
   *   // Do something
   *   UrlMap response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetRegionUrlMapHttpRequest, UrlMap> getRegionUrlMapCallable() {
    return stub.getRegionUrlMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   String requestId = "";
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   Operation response = regionUrlMapClient.insertRegionUrlMap(requestId, region, urlMapResource);
   * }
   * </code></pre>
   *
   * @param requestId begin_interface: MixerMutationRequestBuilder Request ID to support
   *     idempotency.
   * @param region Name of the region scoping this request.
   * @param urlMapResource Represents a URL Map resource.
   *     <p>A URL map resource is a component of certain types of load balancers. This resource
   *     defines mappings from host names and URL paths to either a backend service or a backend
   *     bucket.
   *     <p>To use this resource, the backend service must have a loadBalancingScheme of either
   *     EXTERNAL, INTERNAL_SELF_MANAGED, or INTERNAL_MANAGED For more information, read URL Map
   *     Concepts.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionUrlMap(
      String requestId, ProjectRegionName region, UrlMap urlMapResource) {

    InsertRegionUrlMapHttpRequest request =
        InsertRegionUrlMapHttpRequest.newBuilder()
            .setRequestId(requestId)
            .setRegion(region == null ? null : region.toString())
            .setUrlMapResource(urlMapResource)
            .build();
    return insertRegionUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   String requestId = "";
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   Operation response = regionUrlMapClient.insertRegionUrlMap(requestId, region.toString(), urlMapResource);
   * }
   * </code></pre>
   *
   * @param requestId begin_interface: MixerMutationRequestBuilder Request ID to support
   *     idempotency.
   * @param region Name of the region scoping this request.
   * @param urlMapResource Represents a URL Map resource.
   *     <p>A URL map resource is a component of certain types of load balancers. This resource
   *     defines mappings from host names and URL paths to either a backend service or a backend
   *     bucket.
   *     <p>To use this resource, the backend service must have a loadBalancingScheme of either
   *     EXTERNAL, INTERNAL_SELF_MANAGED, or INTERNAL_MANAGED For more information, read URL Map
   *     Concepts.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionUrlMap(
      String requestId, String region, UrlMap urlMapResource) {

    InsertRegionUrlMapHttpRequest request =
        InsertRegionUrlMapHttpRequest.newBuilder()
            .setRequestId(requestId)
            .setRegion(region)
            .setUrlMapResource(urlMapResource)
            .build();
    return insertRegionUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   String requestId = "";
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   InsertRegionUrlMapHttpRequest request = InsertRegionUrlMapHttpRequest.newBuilder()
   *     .setRequestId(requestId)
   *     .setRegion(formattedRegion)
   *     .setUrlMapResource(urlMapResource)
   *     .build();
   *   Operation response = regionUrlMapClient.insertRegionUrlMap(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionUrlMap(InsertRegionUrlMapHttpRequest request) {
    return insertRegionUrlMapCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   String requestId = "";
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   InsertRegionUrlMapHttpRequest request = InsertRegionUrlMapHttpRequest.newBuilder()
   *     .setRequestId(requestId)
   *     .setRegion(formattedRegion)
   *     .setUrlMapResource(urlMapResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionUrlMapClient.insertRegionUrlMapCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertRegionUrlMapHttpRequest, Operation>
      insertRegionUrlMapCallable() {
    return stub.insertRegionUrlMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of UrlMap resources available to the specified project in the specified
   * region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (UrlMap element : regionUrlMapClient.listRegionUrlMaps(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionUrlMapsPagedResponse listRegionUrlMaps(ProjectRegionName region) {
    ListRegionUrlMapsHttpRequest request =
        ListRegionUrlMapsHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listRegionUrlMaps(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of UrlMap resources available to the specified project in the specified
   * region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (UrlMap element : regionUrlMapClient.listRegionUrlMaps(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionUrlMapsPagedResponse listRegionUrlMaps(String region) {
    ListRegionUrlMapsHttpRequest request =
        ListRegionUrlMapsHttpRequest.newBuilder().setRegion(region).build();
    return listRegionUrlMaps(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of UrlMap resources available to the specified project in the specified
   * region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionUrlMapsHttpRequest request = ListRegionUrlMapsHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   for (UrlMap element : regionUrlMapClient.listRegionUrlMaps(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionUrlMapsPagedResponse listRegionUrlMaps(
      ListRegionUrlMapsHttpRequest request) {
    return listRegionUrlMapsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of UrlMap resources available to the specified project in the specified
   * region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionUrlMapsHttpRequest request = ListRegionUrlMapsHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   ApiFuture&lt;ListRegionUrlMapsPagedResponse&gt; future = regionUrlMapClient.listRegionUrlMapsPagedCallable().futureCall(request);
   *   // Do something
   *   for (UrlMap element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListRegionUrlMapsHttpRequest, ListRegionUrlMapsPagedResponse>
      listRegionUrlMapsPagedCallable() {
    return stub.listRegionUrlMapsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of UrlMap resources available to the specified project in the specified
   * region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionUrlMapsHttpRequest request = ListRegionUrlMapsHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   while (true) {
   *     UrlMapList response = regionUrlMapClient.listRegionUrlMapsCallable().call(request);
   *     for (UrlMap element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionUrlMapsHttpRequest, UrlMapList> listRegionUrlMapsCallable() {
    return stub.listRegionUrlMapsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   ProjectRegionUrlMapName urlMap = ProjectRegionUrlMapName.of("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   String requestId = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = regionUrlMapClient.patchRegionUrlMap(urlMap, requestId, urlMapResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to patch.
   * @param requestId begin_interface: MixerMutationRequestBuilder Request ID to support
   *     idempotency.
   * @param urlMapResource Represents a URL Map resource.
   *     <p>A URL map resource is a component of certain types of load balancers. This resource
   *     defines mappings from host names and URL paths to either a backend service or a backend
   *     bucket.
   *     <p>To use this resource, the backend service must have a loadBalancingScheme of either
   *     EXTERNAL, INTERNAL_SELF_MANAGED, or INTERNAL_MANAGED For more information, read URL Map
   *     Concepts.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchRegionUrlMap(
      ProjectRegionUrlMapName urlMap,
      String requestId,
      UrlMap urlMapResource,
      List<String> fieldMask) {

    PatchRegionUrlMapHttpRequest request =
        PatchRegionUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap == null ? null : urlMap.toString())
            .setRequestId(requestId)
            .setUrlMapResource(urlMapResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchRegionUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   ProjectRegionUrlMapName urlMap = ProjectRegionUrlMapName.of("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   String requestId = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = regionUrlMapClient.patchRegionUrlMap(urlMap.toString(), requestId, urlMapResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to patch.
   * @param requestId begin_interface: MixerMutationRequestBuilder Request ID to support
   *     idempotency.
   * @param urlMapResource Represents a URL Map resource.
   *     <p>A URL map resource is a component of certain types of load balancers. This resource
   *     defines mappings from host names and URL paths to either a backend service or a backend
   *     bucket.
   *     <p>To use this resource, the backend service must have a loadBalancingScheme of either
   *     EXTERNAL, INTERNAL_SELF_MANAGED, or INTERNAL_MANAGED For more information, read URL Map
   *     Concepts.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchRegionUrlMap(
      String urlMap, String requestId, UrlMap urlMapResource, List<String> fieldMask) {

    PatchRegionUrlMapHttpRequest request =
        PatchRegionUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap)
            .setRequestId(requestId)
            .setUrlMapResource(urlMapResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchRegionUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   String formattedUrlMap = ProjectRegionUrlMapName.format("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   String requestId = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchRegionUrlMapHttpRequest request = PatchRegionUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(formattedUrlMap)
   *     .setRequestId(requestId)
   *     .setUrlMapResource(urlMapResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = regionUrlMapClient.patchRegionUrlMap(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchRegionUrlMap(PatchRegionUrlMapHttpRequest request) {
    return patchRegionUrlMapCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   String formattedUrlMap = ProjectRegionUrlMapName.format("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   String requestId = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchRegionUrlMapHttpRequest request = PatchRegionUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(formattedUrlMap)
   *     .setRequestId(requestId)
   *     .setUrlMapResource(urlMapResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionUrlMapClient.patchRegionUrlMapCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchRegionUrlMapHttpRequest, Operation> patchRegionUrlMapCallable() {
    return stub.patchRegionUrlMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   ProjectRegionUrlMapName urlMap = ProjectRegionUrlMapName.of("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   String requestId = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = regionUrlMapClient.updateRegionUrlMap(urlMap, requestId, urlMapResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to update.
   * @param requestId begin_interface: MixerMutationRequestBuilder Request ID to support
   *     idempotency.
   * @param urlMapResource Represents a URL Map resource.
   *     <p>A URL map resource is a component of certain types of load balancers. This resource
   *     defines mappings from host names and URL paths to either a backend service or a backend
   *     bucket.
   *     <p>To use this resource, the backend service must have a loadBalancingScheme of either
   *     EXTERNAL, INTERNAL_SELF_MANAGED, or INTERNAL_MANAGED For more information, read URL Map
   *     Concepts.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateRegionUrlMap(
      ProjectRegionUrlMapName urlMap,
      String requestId,
      UrlMap urlMapResource,
      List<String> fieldMask) {

    UpdateRegionUrlMapHttpRequest request =
        UpdateRegionUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap == null ? null : urlMap.toString())
            .setRequestId(requestId)
            .setUrlMapResource(urlMapResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateRegionUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   ProjectRegionUrlMapName urlMap = ProjectRegionUrlMapName.of("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   String requestId = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = regionUrlMapClient.updateRegionUrlMap(urlMap.toString(), requestId, urlMapResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to update.
   * @param requestId begin_interface: MixerMutationRequestBuilder Request ID to support
   *     idempotency.
   * @param urlMapResource Represents a URL Map resource.
   *     <p>A URL map resource is a component of certain types of load balancers. This resource
   *     defines mappings from host names and URL paths to either a backend service or a backend
   *     bucket.
   *     <p>To use this resource, the backend service must have a loadBalancingScheme of either
   *     EXTERNAL, INTERNAL_SELF_MANAGED, or INTERNAL_MANAGED For more information, read URL Map
   *     Concepts.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateRegionUrlMap(
      String urlMap, String requestId, UrlMap urlMapResource, List<String> fieldMask) {

    UpdateRegionUrlMapHttpRequest request =
        UpdateRegionUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap)
            .setRequestId(requestId)
            .setUrlMapResource(urlMapResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateRegionUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   String formattedUrlMap = ProjectRegionUrlMapName.format("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   String requestId = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateRegionUrlMapHttpRequest request = UpdateRegionUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(formattedUrlMap)
   *     .setRequestId(requestId)
   *     .setUrlMapResource(urlMapResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = regionUrlMapClient.updateRegionUrlMap(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateRegionUrlMap(UpdateRegionUrlMapHttpRequest request) {
    return updateRegionUrlMapCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   String formattedUrlMap = ProjectRegionUrlMapName.format("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   String requestId = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateRegionUrlMapHttpRequest request = UpdateRegionUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(formattedUrlMap)
   *     .setRequestId(requestId)
   *     .setUrlMapResource(urlMapResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionUrlMapClient.updateRegionUrlMapCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<UpdateRegionUrlMapHttpRequest, Operation>
      updateRegionUrlMapCallable() {
    return stub.updateRegionUrlMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be
   * run. Calling this method does NOT create the UrlMap.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   ProjectRegionUrlMapName urlMap = ProjectRegionUrlMapName.of("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   RegionUrlMapsValidateRequest regionUrlMapsValidateRequestResource = RegionUrlMapsValidateRequest.newBuilder().build();
   *   UrlMapsValidateResponse response = regionUrlMapClient.validateRegionUrlMap(urlMap, regionUrlMapsValidateRequestResource);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to be validated as.
   * @param regionUrlMapsValidateRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final UrlMapsValidateResponse validateRegionUrlMap(
      ProjectRegionUrlMapName urlMap,
      RegionUrlMapsValidateRequest regionUrlMapsValidateRequestResource) {

    ValidateRegionUrlMapHttpRequest request =
        ValidateRegionUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap == null ? null : urlMap.toString())
            .setRegionUrlMapsValidateRequestResource(regionUrlMapsValidateRequestResource)
            .build();
    return validateRegionUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be
   * run. Calling this method does NOT create the UrlMap.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   ProjectRegionUrlMapName urlMap = ProjectRegionUrlMapName.of("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   RegionUrlMapsValidateRequest regionUrlMapsValidateRequestResource = RegionUrlMapsValidateRequest.newBuilder().build();
   *   UrlMapsValidateResponse response = regionUrlMapClient.validateRegionUrlMap(urlMap.toString(), regionUrlMapsValidateRequestResource);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to be validated as.
   * @param regionUrlMapsValidateRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final UrlMapsValidateResponse validateRegionUrlMap(
      String urlMap, RegionUrlMapsValidateRequest regionUrlMapsValidateRequestResource) {

    ValidateRegionUrlMapHttpRequest request =
        ValidateRegionUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap)
            .setRegionUrlMapsValidateRequestResource(regionUrlMapsValidateRequestResource)
            .build();
    return validateRegionUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be
   * run. Calling this method does NOT create the UrlMap.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   String formattedUrlMap = ProjectRegionUrlMapName.format("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   RegionUrlMapsValidateRequest regionUrlMapsValidateRequestResource = RegionUrlMapsValidateRequest.newBuilder().build();
   *   ValidateRegionUrlMapHttpRequest request = ValidateRegionUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(formattedUrlMap)
   *     .setRegionUrlMapsValidateRequestResource(regionUrlMapsValidateRequestResource)
   *     .build();
   *   UrlMapsValidateResponse response = regionUrlMapClient.validateRegionUrlMap(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final UrlMapsValidateResponse validateRegionUrlMap(
      ValidateRegionUrlMapHttpRequest request) {
    return validateRegionUrlMapCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be
   * run. Calling this method does NOT create the UrlMap.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapClient regionUrlMapClient = RegionUrlMapClient.create()) {
   *   String formattedUrlMap = ProjectRegionUrlMapName.format("[PROJECT]", "[REGION]", "[URL_MAP]");
   *   RegionUrlMapsValidateRequest regionUrlMapsValidateRequestResource = RegionUrlMapsValidateRequest.newBuilder().build();
   *   ValidateRegionUrlMapHttpRequest request = ValidateRegionUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(formattedUrlMap)
   *     .setRegionUrlMapsValidateRequestResource(regionUrlMapsValidateRequestResource)
   *     .build();
   *   ApiFuture&lt;UrlMapsValidateResponse&gt; future = regionUrlMapClient.validateRegionUrlMapCallable().futureCall(request);
   *   // Do something
   *   UrlMapsValidateResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ValidateRegionUrlMapHttpRequest, UrlMapsValidateResponse>
      validateRegionUrlMapCallable() {
    return stub.validateRegionUrlMapCallable();
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

  public static class ListRegionUrlMapsPagedResponse
      extends AbstractPagedListResponse<
          ListRegionUrlMapsHttpRequest,
          UrlMapList,
          UrlMap,
          ListRegionUrlMapsPage,
          ListRegionUrlMapsFixedSizeCollection> {

    public static ApiFuture<ListRegionUrlMapsPagedResponse> createAsync(
        PageContext<ListRegionUrlMapsHttpRequest, UrlMapList, UrlMap> context,
        ApiFuture<UrlMapList> futureResponse) {
      ApiFuture<ListRegionUrlMapsPage> futurePage =
          ListRegionUrlMapsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListRegionUrlMapsPage, ListRegionUrlMapsPagedResponse>() {
            @Override
            public ListRegionUrlMapsPagedResponse apply(ListRegionUrlMapsPage input) {
              return new ListRegionUrlMapsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListRegionUrlMapsPagedResponse(ListRegionUrlMapsPage page) {
      super(page, ListRegionUrlMapsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegionUrlMapsPage
      extends AbstractPage<
          ListRegionUrlMapsHttpRequest, UrlMapList, UrlMap, ListRegionUrlMapsPage> {

    private ListRegionUrlMapsPage(
        PageContext<ListRegionUrlMapsHttpRequest, UrlMapList, UrlMap> context,
        UrlMapList response) {
      super(context, response);
    }

    private static ListRegionUrlMapsPage createEmptyPage() {
      return new ListRegionUrlMapsPage(null, null);
    }

    @Override
    protected ListRegionUrlMapsPage createPage(
        PageContext<ListRegionUrlMapsHttpRequest, UrlMapList, UrlMap> context,
        UrlMapList response) {
      return new ListRegionUrlMapsPage(context, response);
    }

    @Override
    public ApiFuture<ListRegionUrlMapsPage> createPageAsync(
        PageContext<ListRegionUrlMapsHttpRequest, UrlMapList, UrlMap> context,
        ApiFuture<UrlMapList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegionUrlMapsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionUrlMapsHttpRequest,
          UrlMapList,
          UrlMap,
          ListRegionUrlMapsPage,
          ListRegionUrlMapsFixedSizeCollection> {

    private ListRegionUrlMapsFixedSizeCollection(
        List<ListRegionUrlMapsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegionUrlMapsFixedSizeCollection createEmptyCollection() {
      return new ListRegionUrlMapsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegionUrlMapsFixedSizeCollection createCollection(
        List<ListRegionUrlMapsPage> pages, int collectionSize) {
      return new ListRegionUrlMapsFixedSizeCollection(pages, collectionSize);
    }
  }
}
