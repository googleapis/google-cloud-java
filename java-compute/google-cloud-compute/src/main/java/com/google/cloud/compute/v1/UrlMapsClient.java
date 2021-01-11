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
import com.google.cloud.compute.v1.stub.UrlMapsStub;
import com.google.cloud.compute.v1.stub.UrlMapsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The UrlMaps API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
 *   String project = "";
 *   String urlMap = "";
 *   Operation response = urlMapsClient.delete(project, urlMap);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the urlMapsClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of UrlMapsSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * UrlMapsSettings urlMapsSettings =
 *     UrlMapsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * UrlMapsClient urlMapsClient =
 *     UrlMapsClient.create(urlMapsSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * UrlMapsSettings urlMapsSettings =
 *     UrlMapsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * UrlMapsClient urlMapsClient =
 *     UrlMapsClient.create(urlMapsSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class UrlMapsClient implements BackgroundResource {
  private final UrlMapsSettings settings;
  private final UrlMapsStub stub;

  /** Constructs an instance of UrlMapsClient with default settings. */
  public static final UrlMapsClient create() throws IOException {
    return create(UrlMapsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of UrlMapsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final UrlMapsClient create(UrlMapsSettings settings) throws IOException {
    return new UrlMapsClient(settings);
  }

  /**
   * Constructs an instance of UrlMapsClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use UrlMapsSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final UrlMapsClient create(UrlMapsStub stub) {
    return new UrlMapsClient(stub);
  }

  /**
   * Constructs an instance of UrlMapsClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected UrlMapsClient(UrlMapsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((UrlMapsStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected UrlMapsClient(UrlMapsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final UrlMapsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public UrlMapsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of all UrlMap resources, regional and global, available to the specified
   * project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, UrlMapsScopedList&gt; element : urlMapsClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Name of the project scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListUrlMapsRequest request =
        AggregatedListUrlMapsRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of all UrlMap resources, regional and global, available to the specified
   * project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   AggregatedListUrlMapsRequest request = AggregatedListUrlMapsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, UrlMapsScopedList&gt; element : urlMapsClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(AggregatedListUrlMapsRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of all UrlMap resources, regional and global, available to the specified
   * project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   AggregatedListUrlMapsRequest request = AggregatedListUrlMapsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = urlMapsClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, UrlMapsScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListUrlMapsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of all UrlMap resources, regional and global, available to the specified
   * project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   AggregatedListUrlMapsRequest request = AggregatedListUrlMapsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     UrlMapsAggregatedList response = urlMapsClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, UrlMapsScopedList&gt; element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListUrlMapsRequest, UrlMapsAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   String urlMap = "";
   *   Operation response = urlMapsClient.delete(project, urlMap);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param urlMap Name of the UrlMap resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String urlMap) {
    DeleteUrlMapRequest request =
        DeleteUrlMapRequest.newBuilder().setProject(project).setUrlMap(urlMap).build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   String urlMap = "";
   *   DeleteUrlMapRequest request = DeleteUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setUrlMap(urlMap)
   *     .build();
   *   Operation response = urlMapsClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteUrlMapRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   String urlMap = "";
   *   DeleteUrlMapRequest request = DeleteUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setUrlMap(urlMap)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = urlMapsClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteUrlMapRequest, Operation> deleteCallable() {
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
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   String urlMap = "";
   *   UrlMap response = urlMapsClient.get(project, urlMap);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param urlMap Name of the UrlMap resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UrlMap get(String project, String urlMap) {
    GetUrlMapRequest request =
        GetUrlMapRequest.newBuilder().setProject(project).setUrlMap(urlMap).build();
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
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   String urlMap = "";
   *   GetUrlMapRequest request = GetUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setUrlMap(urlMap)
   *     .build();
   *   UrlMap response = urlMapsClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UrlMap get(GetUrlMapRequest request) {
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
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   String urlMap = "";
   *   GetUrlMapRequest request = GetUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setUrlMap(urlMap)
   *     .build();
   *   ApiFuture&lt;UrlMap&gt; future = urlMapsClient.getCallable().futureCall(request);
   *   // Do something
   *   UrlMap response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetUrlMapRequest, UrlMap> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   Operation response = urlMapsClient.insert(project, urlMapResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param urlMapResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, UrlMap urlMapResource) {
    InsertUrlMapRequest request =
        InsertUrlMapRequest.newBuilder()
            .setProject(project)
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
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   InsertUrlMapRequest request = InsertUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setUrlMapResource(urlMapResource)
   *     .build();
   *   Operation response = urlMapsClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertUrlMapRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   InsertUrlMapRequest request = InsertUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setUrlMapResource(urlMapResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = urlMapsClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertUrlMapRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Initiates a cache invalidation operation, invalidating the specified path, scoped to the
   * specified UrlMap.
   *
   * <p>For more information, see [Invalidating cached
   * content](/cdn/docs/invalidating-cached-content).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   String urlMap = "";
   *   CacheInvalidationRule cacheInvalidationRuleResource = CacheInvalidationRule.newBuilder().build();
   *   Operation response = urlMapsClient.invalidateCache(project, urlMap, cacheInvalidationRuleResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param urlMap Name of the UrlMap scoping this request.
   * @param cacheInvalidationRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation invalidateCache(
      String project, String urlMap, CacheInvalidationRule cacheInvalidationRuleResource) {
    InvalidateCacheUrlMapRequest request =
        InvalidateCacheUrlMapRequest.newBuilder()
            .setProject(project)
            .setUrlMap(urlMap)
            .setCacheInvalidationRuleResource(cacheInvalidationRuleResource)
            .build();
    return invalidateCache(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Initiates a cache invalidation operation, invalidating the specified path, scoped to the
   * specified UrlMap.
   *
   * <p>For more information, see [Invalidating cached
   * content](/cdn/docs/invalidating-cached-content).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   CacheInvalidationRule cacheInvalidationRuleResource = CacheInvalidationRule.newBuilder().build();
   *   String project = "";
   *   String urlMap = "";
   *   InvalidateCacheUrlMapRequest request = InvalidateCacheUrlMapRequest.newBuilder()
   *     .setCacheInvalidationRuleResource(cacheInvalidationRuleResource)
   *     .setProject(project)
   *     .setUrlMap(urlMap)
   *     .build();
   *   Operation response = urlMapsClient.invalidateCache(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation invalidateCache(InvalidateCacheUrlMapRequest request) {
    return invalidateCacheCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Initiates a cache invalidation operation, invalidating the specified path, scoped to the
   * specified UrlMap.
   *
   * <p>For more information, see [Invalidating cached
   * content](/cdn/docs/invalidating-cached-content).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   CacheInvalidationRule cacheInvalidationRuleResource = CacheInvalidationRule.newBuilder().build();
   *   String project = "";
   *   String urlMap = "";
   *   InvalidateCacheUrlMapRequest request = InvalidateCacheUrlMapRequest.newBuilder()
   *     .setCacheInvalidationRuleResource(cacheInvalidationRuleResource)
   *     .setProject(project)
   *     .setUrlMap(urlMap)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = urlMapsClient.invalidateCacheCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InvalidateCacheUrlMapRequest, Operation> invalidateCacheCallable() {
    return stub.invalidateCacheCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of UrlMap resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   for (UrlMap element : urlMapsClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListUrlMapsRequest request = ListUrlMapsRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of UrlMap resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   ListUrlMapsRequest request = ListUrlMapsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (UrlMap element : urlMapsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListUrlMapsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of UrlMap resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   ListUrlMapsRequest request = ListUrlMapsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = urlMapsClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (UrlMap element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListUrlMapsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of UrlMap resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   ListUrlMapsRequest request = ListUrlMapsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     UrlMapList response = urlMapsClient.listCallable().call(request);
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
  public final UnaryCallable<ListUrlMapsRequest, UrlMapList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   String urlMap = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   Operation response = urlMapsClient.patch(project, urlMap, urlMapResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param urlMap Name of the UrlMap resource to patch.
   * @param urlMapResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(String project, String urlMap, UrlMap urlMapResource) {
    PatchUrlMapRequest request =
        PatchUrlMapRequest.newBuilder()
            .setProject(project)
            .setUrlMap(urlMap)
            .setUrlMapResource(urlMapResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   String urlMap = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   PatchUrlMapRequest request = PatchUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setUrlMap(urlMap)
   *     .setUrlMapResource(urlMapResource)
   *     .build();
   *   Operation response = urlMapsClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchUrlMapRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   String urlMap = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   PatchUrlMapRequest request = PatchUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setUrlMap(urlMap)
   *     .setUrlMapResource(urlMapResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = urlMapsClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchUrlMapRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   String urlMap = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   Operation response = urlMapsClient.update(project, urlMap, urlMapResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param urlMap Name of the UrlMap resource to update.
   * @param urlMapResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(String project, String urlMap, UrlMap urlMapResource) {
    UpdateUrlMapRequest request =
        UpdateUrlMapRequest.newBuilder()
            .setProject(project)
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
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   String urlMap = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   UpdateUrlMapRequest request = UpdateUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setUrlMap(urlMap)
   *     .setUrlMapResource(urlMapResource)
   *     .build();
   *   Operation response = urlMapsClient.update(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(UpdateUrlMapRequest request) {
    return updateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   String urlMap = "";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   UpdateUrlMapRequest request = UpdateUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setUrlMap(urlMap)
   *     .setUrlMapResource(urlMapResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = urlMapsClient.updateCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateUrlMapRequest, Operation> updateCallable() {
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
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   String urlMap = "";
   *   UrlMapsValidateRequest urlMapsValidateRequestResource = UrlMapsValidateRequest.newBuilder().build();
   *   UrlMapsValidateResponse response = urlMapsClient.validate(project, urlMap, urlMapsValidateRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param urlMap Name of the UrlMap resource to be validated as.
   * @param urlMapsValidateRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UrlMapsValidateResponse validate(
      String project, String urlMap, UrlMapsValidateRequest urlMapsValidateRequestResource) {
    ValidateUrlMapRequest request =
        ValidateUrlMapRequest.newBuilder()
            .setProject(project)
            .setUrlMap(urlMap)
            .setUrlMapsValidateRequestResource(urlMapsValidateRequestResource)
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
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   String urlMap = "";
   *   UrlMapsValidateRequest urlMapsValidateRequestResource = UrlMapsValidateRequest.newBuilder().build();
   *   ValidateUrlMapRequest request = ValidateUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setUrlMap(urlMap)
   *     .setUrlMapsValidateRequestResource(urlMapsValidateRequestResource)
   *     .build();
   *   UrlMapsValidateResponse response = urlMapsClient.validate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UrlMapsValidateResponse validate(ValidateUrlMapRequest request) {
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
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "";
   *   String urlMap = "";
   *   UrlMapsValidateRequest urlMapsValidateRequestResource = UrlMapsValidateRequest.newBuilder().build();
   *   ValidateUrlMapRequest request = ValidateUrlMapRequest.newBuilder()
   *     .setProject(project)
   *     .setUrlMap(urlMap)
   *     .setUrlMapsValidateRequestResource(urlMapsValidateRequestResource)
   *     .build();
   *   ApiFuture&lt;UrlMapsValidateResponse&gt; future = urlMapsClient.validateCallable().futureCall(request);
   *   // Do something
   *   UrlMapsValidateResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ValidateUrlMapRequest, UrlMapsValidateResponse> validateCallable() {
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

  public static class AggregatedListPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListUrlMapsRequest,
          UrlMapsAggregatedList,
          Entry<String, UrlMapsScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListUrlMapsRequest,
                UrlMapsAggregatedList,
                Entry<String, UrlMapsScopedList>>
            context,
        ApiFuture<UrlMapsAggregatedList> futureResponse) {
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
          AggregatedListUrlMapsRequest,
          UrlMapsAggregatedList,
          Entry<String, UrlMapsScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListUrlMapsRequest,
                UrlMapsAggregatedList,
                Entry<String, UrlMapsScopedList>>
            context,
        UrlMapsAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListUrlMapsRequest,
                UrlMapsAggregatedList,
                Entry<String, UrlMapsScopedList>>
            context,
        UrlMapsAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListUrlMapsRequest,
                UrlMapsAggregatedList,
                Entry<String, UrlMapsScopedList>>
            context,
        ApiFuture<UrlMapsAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListUrlMapsRequest,
          UrlMapsAggregatedList,
          Entry<String, UrlMapsScopedList>,
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
          ListUrlMapsRequest, UrlMapList, UrlMap, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListUrlMapsRequest, UrlMapList, UrlMap> context,
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
      extends AbstractPage<ListUrlMapsRequest, UrlMapList, UrlMap, ListPage> {

    private ListPage(
        PageContext<ListUrlMapsRequest, UrlMapList, UrlMap> context, UrlMapList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListUrlMapsRequest, UrlMapList, UrlMap> context, UrlMapList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListUrlMapsRequest, UrlMapList, UrlMap> context,
        ApiFuture<UrlMapList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUrlMapsRequest, UrlMapList, UrlMap, ListPage, ListFixedSizeCollection> {

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
