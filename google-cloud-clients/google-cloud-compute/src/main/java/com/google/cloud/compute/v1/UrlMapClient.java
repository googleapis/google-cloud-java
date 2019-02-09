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
import com.google.cloud.compute.v1.stub.UrlMapStub;
import com.google.cloud.compute.v1.stub.UrlMapStubSettings;
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
 * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
 *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
 *   Operation response = urlMapClient.deleteUrlMap(urlMap);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the urlMapClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of UrlMapSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * UrlMapSettings urlMapSettings =
 *     UrlMapSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * UrlMapClient urlMapClient =
 *     UrlMapClient.create(urlMapSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * UrlMapSettings urlMapSettings =
 *     UrlMapSettings.newBuilder().setEndpoint(myEndpoint).build();
 * UrlMapClient urlMapClient =
 *     UrlMapClient.create(urlMapSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class UrlMapClient implements BackgroundResource {
  private final UrlMapSettings settings;
  private final UrlMapStub stub;

  /** Constructs an instance of UrlMapClient with default settings. */
  public static final UrlMapClient create() throws IOException {
    return create(UrlMapSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of UrlMapClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final UrlMapClient create(UrlMapSettings settings) throws IOException {
    return new UrlMapClient(settings);
  }

  /**
   * Constructs an instance of UrlMapClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use UrlMapSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final UrlMapClient create(UrlMapStub stub) {
    return new UrlMapClient(stub);
  }

  /**
   * Constructs an instance of UrlMapClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected UrlMapClient(UrlMapSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((UrlMapStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected UrlMapClient(UrlMapStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final UrlMapSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public UrlMapStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   Operation response = urlMapClient.deleteUrlMap(urlMap);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteUrlMap(ProjectGlobalUrlMapName urlMap) {

    DeleteUrlMapHttpRequest request =
        DeleteUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap == null ? null : urlMap.toString())
            .build();
    return deleteUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   Operation response = urlMapClient.deleteUrlMap(urlMap.toString());
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteUrlMap(String urlMap) {

    DeleteUrlMapHttpRequest request =
        DeleteUrlMapHttpRequest.newBuilder().setUrlMap(urlMap).build();
    return deleteUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   DeleteUrlMapHttpRequest request = DeleteUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(urlMap.toString())
   *     .build();
   *   Operation response = urlMapClient.deleteUrlMap(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteUrlMap(DeleteUrlMapHttpRequest request) {
    return deleteUrlMapCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   DeleteUrlMapHttpRequest request = DeleteUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(urlMap.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = urlMapClient.deleteUrlMapCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteUrlMapHttpRequest, Operation> deleteUrlMapCallable() {
    return stub.deleteUrlMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified UrlMap resource. Gets a list of available URL maps by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   UrlMap response = urlMapClient.getUrlMap(urlMap);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final UrlMap getUrlMap(ProjectGlobalUrlMapName urlMap) {

    GetUrlMapHttpRequest request =
        GetUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap == null ? null : urlMap.toString())
            .build();
    return getUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified UrlMap resource. Gets a list of available URL maps by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   UrlMap response = urlMapClient.getUrlMap(urlMap.toString());
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final UrlMap getUrlMap(String urlMap) {

    GetUrlMapHttpRequest request = GetUrlMapHttpRequest.newBuilder().setUrlMap(urlMap).build();
    return getUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified UrlMap resource. Gets a list of available URL maps by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   GetUrlMapHttpRequest request = GetUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(urlMap.toString())
   *     .build();
   *   UrlMap response = urlMapClient.getUrlMap(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final UrlMap getUrlMap(GetUrlMapHttpRequest request) {
    return getUrlMapCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified UrlMap resource. Gets a list of available URL maps by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   GetUrlMapHttpRequest request = GetUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(urlMap.toString())
   *     .build();
   *   ApiFuture&lt;UrlMap&gt; future = urlMapClient.getUrlMapCallable().futureCall(request);
   *   // Do something
   *   UrlMap response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetUrlMapHttpRequest, UrlMap> getUrlMapCallable() {
    return stub.getUrlMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   Operation response = urlMapClient.insertUrlMap(project, urlMapResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param urlMapResource A UrlMap resource. This resource defines the mapping from URL to the
   *     BackendService resource, based on the "longest-match" of the URL's host and path.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertUrlMap(ProjectName project, UrlMap urlMapResource) {

    InsertUrlMapHttpRequest request =
        InsertUrlMapHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setUrlMapResource(urlMapResource)
            .build();
    return insertUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   Operation response = urlMapClient.insertUrlMap(project.toString(), urlMapResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param urlMapResource A UrlMap resource. This resource defines the mapping from URL to the
   *     BackendService resource, based on the "longest-match" of the URL's host and path.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertUrlMap(String project, UrlMap urlMapResource) {

    InsertUrlMapHttpRequest request =
        InsertUrlMapHttpRequest.newBuilder()
            .setProject(project)
            .setUrlMapResource(urlMapResource)
            .build();
    return insertUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   InsertUrlMapHttpRequest request = InsertUrlMapHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setUrlMapResource(urlMapResource)
   *     .build();
   *   Operation response = urlMapClient.insertUrlMap(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertUrlMap(InsertUrlMapHttpRequest request) {
    return insertUrlMapCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   InsertUrlMapHttpRequest request = InsertUrlMapHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setUrlMapResource(urlMapResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = urlMapClient.insertUrlMapCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertUrlMapHttpRequest, Operation> insertUrlMapCallable() {
    return stub.insertUrlMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Initiates a cache invalidation operation, invalidating the specified path, scoped to the
   * specified UrlMap.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   CacheInvalidationRule cacheInvalidationRuleResource = CacheInvalidationRule.newBuilder().build();
   *   Operation response = urlMapClient.invalidateCacheUrlMap(urlMap, cacheInvalidationRuleResource);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap scoping this request.
   * @param cacheInvalidationRuleResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation invalidateCacheUrlMap(
      ProjectGlobalUrlMapName urlMap, CacheInvalidationRule cacheInvalidationRuleResource) {

    InvalidateCacheUrlMapHttpRequest request =
        InvalidateCacheUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap == null ? null : urlMap.toString())
            .setCacheInvalidationRuleResource(cacheInvalidationRuleResource)
            .build();
    return invalidateCacheUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Initiates a cache invalidation operation, invalidating the specified path, scoped to the
   * specified UrlMap.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   CacheInvalidationRule cacheInvalidationRuleResource = CacheInvalidationRule.newBuilder().build();
   *   Operation response = urlMapClient.invalidateCacheUrlMap(urlMap.toString(), cacheInvalidationRuleResource);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap scoping this request.
   * @param cacheInvalidationRuleResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation invalidateCacheUrlMap(
      String urlMap, CacheInvalidationRule cacheInvalidationRuleResource) {

    InvalidateCacheUrlMapHttpRequest request =
        InvalidateCacheUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap)
            .setCacheInvalidationRuleResource(cacheInvalidationRuleResource)
            .build();
    return invalidateCacheUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Initiates a cache invalidation operation, invalidating the specified path, scoped to the
   * specified UrlMap.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   CacheInvalidationRule cacheInvalidationRuleResource = CacheInvalidationRule.newBuilder().build();
   *   InvalidateCacheUrlMapHttpRequest request = InvalidateCacheUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(urlMap.toString())
   *     .setCacheInvalidationRuleResource(cacheInvalidationRuleResource)
   *     .build();
   *   Operation response = urlMapClient.invalidateCacheUrlMap(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation invalidateCacheUrlMap(InvalidateCacheUrlMapHttpRequest request) {
    return invalidateCacheUrlMapCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Initiates a cache invalidation operation, invalidating the specified path, scoped to the
   * specified UrlMap.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   CacheInvalidationRule cacheInvalidationRuleResource = CacheInvalidationRule.newBuilder().build();
   *   InvalidateCacheUrlMapHttpRequest request = InvalidateCacheUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(urlMap.toString())
   *     .setCacheInvalidationRuleResource(cacheInvalidationRuleResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = urlMapClient.invalidateCacheUrlMapCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InvalidateCacheUrlMapHttpRequest, Operation>
      invalidateCacheUrlMapCallable() {
    return stub.invalidateCacheUrlMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of UrlMap resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (UrlMap element : urlMapClient.listUrlMaps(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListUrlMapsPagedResponse listUrlMaps(ProjectName project) {
    ListUrlMapsHttpRequest request =
        ListUrlMapsHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listUrlMaps(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of UrlMap resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (UrlMap element : urlMapClient.listUrlMaps(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListUrlMapsPagedResponse listUrlMaps(String project) {
    ListUrlMapsHttpRequest request =
        ListUrlMapsHttpRequest.newBuilder().setProject(project).build();
    return listUrlMaps(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of UrlMap resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListUrlMapsHttpRequest request = ListUrlMapsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (UrlMap element : urlMapClient.listUrlMaps(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListUrlMapsPagedResponse listUrlMaps(ListUrlMapsHttpRequest request) {
    return listUrlMapsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of UrlMap resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListUrlMapsHttpRequest request = ListUrlMapsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;ListUrlMapsPagedResponse&gt; future = urlMapClient.listUrlMapsPagedCallable().futureCall(request);
   *   // Do something
   *   for (UrlMap element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListUrlMapsHttpRequest, ListUrlMapsPagedResponse>
      listUrlMapsPagedCallable() {
    return stub.listUrlMapsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of UrlMap resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListUrlMapsHttpRequest request = ListUrlMapsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     UrlMapList response = urlMapClient.listUrlMapsCallable().call(request);
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
  public final UnaryCallable<ListUrlMapsHttpRequest, UrlMapList> listUrlMapsCallable() {
    return stub.listUrlMapsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = urlMapClient.patchUrlMap(urlMap, urlMapResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to patch.
   * @param urlMapResource A UrlMap resource. This resource defines the mapping from URL to the
   *     BackendService resource, based on the "longest-match" of the URL's host and path.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchUrlMap(
      ProjectGlobalUrlMapName urlMap, UrlMap urlMapResource, List<String> fieldMask) {

    PatchUrlMapHttpRequest request =
        PatchUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap == null ? null : urlMap.toString())
            .setUrlMapResource(urlMapResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = urlMapClient.patchUrlMap(urlMap.toString(), urlMapResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to patch.
   * @param urlMapResource A UrlMap resource. This resource defines the mapping from URL to the
   *     BackendService resource, based on the "longest-match" of the URL's host and path.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchUrlMap(String urlMap, UrlMap urlMapResource, List<String> fieldMask) {

    PatchUrlMapHttpRequest request =
        PatchUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap)
            .setUrlMapResource(urlMapResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchUrlMapHttpRequest request = PatchUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(urlMap.toString())
   *     .setUrlMapResource(urlMapResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = urlMapClient.patchUrlMap(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchUrlMap(PatchUrlMapHttpRequest request) {
    return patchUrlMapCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchUrlMapHttpRequest request = PatchUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(urlMap.toString())
   *     .setUrlMapResource(urlMapResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = urlMapClient.patchUrlMapCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchUrlMapHttpRequest, Operation> patchUrlMapCallable() {
    return stub.patchUrlMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = urlMapClient.updateUrlMap(urlMap, urlMapResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to update.
   * @param urlMapResource A UrlMap resource. This resource defines the mapping from URL to the
   *     BackendService resource, based on the "longest-match" of the URL's host and path.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateUrlMap(
      ProjectGlobalUrlMapName urlMap, UrlMap urlMapResource, List<String> fieldMask) {

    UpdateUrlMapHttpRequest request =
        UpdateUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap == null ? null : urlMap.toString())
            .setUrlMapResource(urlMapResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = urlMapClient.updateUrlMap(urlMap.toString(), urlMapResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to update.
   * @param urlMapResource A UrlMap resource. This resource defines the mapping from URL to the
   *     BackendService resource, based on the "longest-match" of the URL's host and path.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateUrlMap(
      String urlMap, UrlMap urlMapResource, List<String> fieldMask) {

    UpdateUrlMapHttpRequest request =
        UpdateUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap)
            .setUrlMapResource(urlMapResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateUrlMapHttpRequest request = UpdateUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(urlMap.toString())
   *     .setUrlMapResource(urlMapResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = urlMapClient.updateUrlMap(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateUrlMap(UpdateUrlMapHttpRequest request) {
    return updateUrlMapCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateUrlMapHttpRequest request = UpdateUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(urlMap.toString())
   *     .setUrlMapResource(urlMapResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = urlMapClient.updateUrlMapCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<UpdateUrlMapHttpRequest, Operation> updateUrlMapCallable() {
    return stub.updateUrlMapCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be
   * run. Calling this method does NOT create the UrlMap.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   UrlMapsValidateRequest urlMapsValidateRequestResource = UrlMapsValidateRequest.newBuilder().build();
   *   UrlMapsValidateResponse response = urlMapClient.validateUrlMap(urlMap, urlMapsValidateRequestResource);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to be validated as.
   * @param urlMapsValidateRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final UrlMapsValidateResponse validateUrlMap(
      ProjectGlobalUrlMapName urlMap, UrlMapsValidateRequest urlMapsValidateRequestResource) {

    ValidateUrlMapHttpRequest request =
        ValidateUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap == null ? null : urlMap.toString())
            .setUrlMapsValidateRequestResource(urlMapsValidateRequestResource)
            .build();
    return validateUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be
   * run. Calling this method does NOT create the UrlMap.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   UrlMapsValidateRequest urlMapsValidateRequestResource = UrlMapsValidateRequest.newBuilder().build();
   *   UrlMapsValidateResponse response = urlMapClient.validateUrlMap(urlMap.toString(), urlMapsValidateRequestResource);
   * }
   * </code></pre>
   *
   * @param urlMap Name of the UrlMap resource to be validated as.
   * @param urlMapsValidateRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final UrlMapsValidateResponse validateUrlMap(
      String urlMap, UrlMapsValidateRequest urlMapsValidateRequestResource) {

    ValidateUrlMapHttpRequest request =
        ValidateUrlMapHttpRequest.newBuilder()
            .setUrlMap(urlMap)
            .setUrlMapsValidateRequestResource(urlMapsValidateRequestResource)
            .build();
    return validateUrlMap(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be
   * run. Calling this method does NOT create the UrlMap.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   UrlMapsValidateRequest urlMapsValidateRequestResource = UrlMapsValidateRequest.newBuilder().build();
   *   ValidateUrlMapHttpRequest request = ValidateUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(urlMap.toString())
   *     .setUrlMapsValidateRequestResource(urlMapsValidateRequestResource)
   *     .build();
   *   UrlMapsValidateResponse response = urlMapClient.validateUrlMap(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final UrlMapsValidateResponse validateUrlMap(ValidateUrlMapHttpRequest request) {
    return validateUrlMapCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be
   * run. Calling this method does NOT create the UrlMap.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UrlMapClient urlMapClient = UrlMapClient.create()) {
   *   ProjectGlobalUrlMapName urlMap = ProjectGlobalUrlMapName.of("[PROJECT]", "[URL_MAP]");
   *   UrlMapsValidateRequest urlMapsValidateRequestResource = UrlMapsValidateRequest.newBuilder().build();
   *   ValidateUrlMapHttpRequest request = ValidateUrlMapHttpRequest.newBuilder()
   *     .setUrlMap(urlMap.toString())
   *     .setUrlMapsValidateRequestResource(urlMapsValidateRequestResource)
   *     .build();
   *   ApiFuture&lt;UrlMapsValidateResponse&gt; future = urlMapClient.validateUrlMapCallable().futureCall(request);
   *   // Do something
   *   UrlMapsValidateResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ValidateUrlMapHttpRequest, UrlMapsValidateResponse>
      validateUrlMapCallable() {
    return stub.validateUrlMapCallable();
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

  public static class ListUrlMapsPagedResponse
      extends AbstractPagedListResponse<
          ListUrlMapsHttpRequest,
          UrlMapList,
          UrlMap,
          ListUrlMapsPage,
          ListUrlMapsFixedSizeCollection> {

    public static ApiFuture<ListUrlMapsPagedResponse> createAsync(
        PageContext<ListUrlMapsHttpRequest, UrlMapList, UrlMap> context,
        ApiFuture<UrlMapList> futureResponse) {
      ApiFuture<ListUrlMapsPage> futurePage =
          ListUrlMapsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListUrlMapsPage, ListUrlMapsPagedResponse>() {
            @Override
            public ListUrlMapsPagedResponse apply(ListUrlMapsPage input) {
              return new ListUrlMapsPagedResponse(input);
            }
          });
    }

    private ListUrlMapsPagedResponse(ListUrlMapsPage page) {
      super(page, ListUrlMapsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUrlMapsPage
      extends AbstractPage<ListUrlMapsHttpRequest, UrlMapList, UrlMap, ListUrlMapsPage> {

    private ListUrlMapsPage(
        PageContext<ListUrlMapsHttpRequest, UrlMapList, UrlMap> context, UrlMapList response) {
      super(context, response);
    }

    private static ListUrlMapsPage createEmptyPage() {
      return new ListUrlMapsPage(null, null);
    }

    @Override
    protected ListUrlMapsPage createPage(
        PageContext<ListUrlMapsHttpRequest, UrlMapList, UrlMap> context, UrlMapList response) {
      return new ListUrlMapsPage(context, response);
    }

    @Override
    public ApiFuture<ListUrlMapsPage> createPageAsync(
        PageContext<ListUrlMapsHttpRequest, UrlMapList, UrlMap> context,
        ApiFuture<UrlMapList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUrlMapsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUrlMapsHttpRequest,
          UrlMapList,
          UrlMap,
          ListUrlMapsPage,
          ListUrlMapsFixedSizeCollection> {

    private ListUrlMapsFixedSizeCollection(List<ListUrlMapsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUrlMapsFixedSizeCollection createEmptyCollection() {
      return new ListUrlMapsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUrlMapsFixedSizeCollection createCollection(
        List<ListUrlMapsPage> pages, int collectionSize) {
      return new ListUrlMapsFixedSizeCollection(pages, collectionSize);
    }
  }
}
