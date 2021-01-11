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
import com.google.cloud.compute.v1.stub.RegionUrlMapsStub;
import com.google.cloud.compute.v1.stub.RegionUrlMapsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The RegionUrlMaps API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String urlMap = "";
 *   Operation response = regionUrlMapsClient.delete(project, region, urlMap);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionUrlMapsClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of RegionUrlMapsSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionUrlMapsSettings regionUrlMapsSettings =
 *     RegionUrlMapsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionUrlMapsClient regionUrlMapsClient =
 *     RegionUrlMapsClient.create(regionUrlMapsSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionUrlMapsSettings regionUrlMapsSettings =
 *     RegionUrlMapsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionUrlMapsClient regionUrlMapsClient =
 *     RegionUrlMapsClient.create(regionUrlMapsSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionUrlMapsClient implements BackgroundResource {
  private final RegionUrlMapsSettings settings;
  private final RegionUrlMapsStub stub;

  /** Constructs an instance of RegionUrlMapsClient with default settings. */
  public static final RegionUrlMapsClient create() throws IOException {
    return create(RegionUrlMapsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionUrlMapsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionUrlMapsClient create(RegionUrlMapsSettings settings)
      throws IOException {
    return new RegionUrlMapsClient(settings);
  }

  /**
   * Constructs an instance of RegionUrlMapsClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use RegionUrlMapsSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionUrlMapsClient create(RegionUrlMapsStub stub) {
    return new RegionUrlMapsClient(stub);
  }

  /**
   * Constructs an instance of RegionUrlMapsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RegionUrlMapsClient(RegionUrlMapsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionUrlMapsStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionUrlMapsClient(RegionUrlMapsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionUrlMapsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionUrlMapsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String urlMap = "";
   *   Operation response = regionUrlMapsClient.delete(project, region, urlMap);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param urlMap Name of the UrlMap resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String urlMap) {
    DeleteRegionUrlMapRequest request =
        DeleteRegionUrlMapRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setUrlMap(urlMap)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String urlMap = "";
   *   DeleteRegionUrlMapRequest request = DeleteRegionUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setUrlMap(urlMap)
   *     .build();
   *   Operation response = regionUrlMapsClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteRegionUrlMapRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String urlMap = "";
   *   DeleteRegionUrlMapRequest request = DeleteRegionUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setUrlMap(urlMap)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionUrlMapsClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteRegionUrlMapRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified UrlMap resource. Gets a list of available URL maps by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String urlMap = "";
   *   UrlMap response = regionUrlMapsClient.get(project, region, urlMap);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param urlMap Name of the UrlMap resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UrlMap get(String project, String region, String urlMap) {
    GetRegionUrlMapRequest request =
        GetRegionUrlMapRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setUrlMap(urlMap)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified UrlMap resource. Gets a list of available URL maps by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String urlMap = "";
   *   GetRegionUrlMapRequest request = GetRegionUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setUrlMap(urlMap)
   *     .build();
   *   UrlMap response = regionUrlMapsClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UrlMap get(GetRegionUrlMapRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified UrlMap resource. Gets a list of available URL maps by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String urlMap = "";
   *   GetRegionUrlMapRequest request = GetRegionUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setUrlMap(urlMap)
   *     .build();
   *   ApiFuture&lt;UrlMap&gt; future = regionUrlMapsClient.getCallable().futureCall(request);
   *   // Do something
   *   UrlMap response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetRegionUrlMapRequest, UrlMap> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   Operation response = regionUrlMapsClient.insert(project, region, urlMapResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param urlMapResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, String region, UrlMap urlMapResource) {
    InsertRegionUrlMapRequest request =
        InsertRegionUrlMapRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setUrlMapResource(urlMapResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   InsertRegionUrlMapRequest request = InsertRegionUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setUrlMapResource(urlMapResource)
   *     .build();
   *   Operation response = regionUrlMapsClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertRegionUrlMapRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   InsertRegionUrlMapRequest request = InsertRegionUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setUrlMapResource(urlMapResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionUrlMapsClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertRegionUrlMapRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of UrlMap resources available to the specified project in the specified
   * region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (UrlMap element : regionUrlMapsClient.list(project, region).iterateAll()) {
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
    ListRegionUrlMapsRequest request =
        ListRegionUrlMapsRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of UrlMap resources available to the specified project in the specified
   * region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionUrlMapsRequest request = ListRegionUrlMapsRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (UrlMap element : regionUrlMapsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionUrlMapsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of UrlMap resources available to the specified project in the specified
   * region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionUrlMapsRequest request = ListRegionUrlMapsRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = regionUrlMapsClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (UrlMap element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListRegionUrlMapsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of UrlMap resources available to the specified project in the specified
   * region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListRegionUrlMapsRequest request = ListRegionUrlMapsRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     UrlMapList response = regionUrlMapsClient.listCallable().call(request);
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
  public final UnaryCallable<ListRegionUrlMapsRequest, UrlMapList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String urlMap = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   Operation response = regionUrlMapsClient.patch(project, region, urlMap, urlMapResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param urlMap Name of the UrlMap resource to patch.
   * @param urlMapResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
      String project, String region, String urlMap, UrlMap urlMapResource) {
    PatchRegionUrlMapRequest request =
        PatchRegionUrlMapRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setUrlMap(urlMap)
            .setUrlMapResource(urlMapResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String urlMap = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   PatchRegionUrlMapRequest request = PatchRegionUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setUrlMap(urlMap)
   *     .setUrlMapResource(urlMapResource)
   *     .build();
   *   Operation response = regionUrlMapsClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchRegionUrlMapRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String urlMap = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   PatchRegionUrlMapRequest request = PatchRegionUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setUrlMap(urlMap)
   *     .setUrlMapResource(urlMapResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionUrlMapsClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchRegionUrlMapRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String urlMap = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   Operation response = regionUrlMapsClient.update(project, region, urlMap, urlMapResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param urlMap Name of the UrlMap resource to update.
   * @param urlMapResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(
      String project, String region, String urlMap, UrlMap urlMapResource) {
    UpdateRegionUrlMapRequest request =
        UpdateRegionUrlMapRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setUrlMap(urlMap)
            .setUrlMapResource(urlMapResource)
            .build();
    return update(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String urlMap = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   UpdateRegionUrlMapRequest request = UpdateRegionUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setUrlMap(urlMap)
   *     .setUrlMapResource(urlMapResource)
   *     .build();
   *   Operation response = regionUrlMapsClient.update(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(UpdateRegionUrlMapRequest request) {
    return updateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String urlMap = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   UpdateRegionUrlMapRequest request = UpdateRegionUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setUrlMap(urlMap)
   *     .setUrlMapResource(urlMapResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionUrlMapsClient.updateCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateRegionUrlMapRequest, Operation> updateCallable() {
    return stub.updateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be
   * run. Calling this method does NOT create the UrlMap.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String urlMap = "";
   *   RegionUrlMapsValidateRequest regionUrlMapsValidateRequestResource = RegionUrlMapsValidateRequest.newBuilder().build();
   *   UrlMapsValidateResponse response = regionUrlMapsClient.validate(project, region, urlMap, regionUrlMapsValidateRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region scoping this request.
   * @param urlMap Name of the UrlMap resource to be validated as.
   * @param regionUrlMapsValidateRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UrlMapsValidateResponse validate(
      String project,
      String region,
      String urlMap,
      RegionUrlMapsValidateRequest regionUrlMapsValidateRequestResource) {
    ValidateRegionUrlMapRequest request =
        ValidateRegionUrlMapRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setUrlMap(urlMap)
            .setRegionUrlMapsValidateRequestResource(regionUrlMapsValidateRequestResource)
            .build();
    return validate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be
   * run. Calling this method does NOT create the UrlMap.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   RegionUrlMapsValidateRequest regionUrlMapsValidateRequestResource = RegionUrlMapsValidateRequest.newBuilder().build();
   *   String urlMap = "";
   *   ValidateRegionUrlMapRequest request = ValidateRegionUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionUrlMapsValidateRequestResource(regionUrlMapsValidateRequestResource)
   *     .setUrlMap(urlMap)
   *     .build();
   *   UrlMapsValidateResponse response = regionUrlMapsClient.validate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UrlMapsValidateResponse validate(ValidateRegionUrlMapRequest request) {
    return validateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be
   * run. Calling this method does NOT create the UrlMap.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionUrlMapsClient regionUrlMapsClient = RegionUrlMapsClient.create()) {
   *   String project = "";
   *   String region = "";
   *   RegionUrlMapsValidateRequest regionUrlMapsValidateRequestResource = RegionUrlMapsValidateRequest.newBuilder().build();
   *   String urlMap = "";
   *   ValidateRegionUrlMapRequest request = ValidateRegionUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionUrlMapsValidateRequestResource(regionUrlMapsValidateRequestResource)
   *     .setUrlMap(urlMap)
   *     .build();
   *   ApiFuture&lt;UrlMapsValidateResponse&gt; future = regionUrlMapsClient.validateCallable().futureCall(request);
   *   // Do something
   *   UrlMapsValidateResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ValidateRegionUrlMapRequest, UrlMapsValidateResponse>
      validateCallable() {
    return stub.validateCallable();
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
          ListRegionUrlMapsRequest, UrlMapList, UrlMap, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRegionUrlMapsRequest, UrlMapList, UrlMap> context,
        ApiFuture<UrlMapList> futureResponse) {
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
      extends AbstractPage<ListRegionUrlMapsRequest, UrlMapList, UrlMap, ListPage> {

    private ListPage(
        PageContext<ListRegionUrlMapsRequest, UrlMapList, UrlMap> context, UrlMapList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRegionUrlMapsRequest, UrlMapList, UrlMap> context, UrlMapList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRegionUrlMapsRequest, UrlMapList, UrlMap> context,
        ApiFuture<UrlMapList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionUrlMapsRequest, UrlMapList, UrlMap, ListPage, ListFixedSizeCollection> {

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
