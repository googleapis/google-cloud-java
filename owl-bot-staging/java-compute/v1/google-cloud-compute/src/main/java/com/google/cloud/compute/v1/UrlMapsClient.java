/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.compute.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.UrlMapsStub;
import com.google.cloud.compute.v1.stub.UrlMapsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The UrlMaps API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
 *   String project = "project-309310695";
 *   String urlMap = "urlMap-836780691";
 *   UrlMap response = urlMapsClient.get(project, urlMap);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the UrlMapsClient object to clean up resources such as
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
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * UrlMapsSettings urlMapsSettings =
 *     UrlMapsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * UrlMapsClient urlMapsClient = UrlMapsClient.create(urlMapsSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * UrlMapsSettings urlMapsSettings = UrlMapsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * UrlMapsClient urlMapsClient = UrlMapsClient.create(urlMapsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
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
   * advanced usage - prefer using create(UrlMapsSettings).
   */
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

  protected UrlMapsClient(UrlMapsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final UrlMapsSettings getSettings() {
    return settings;
  }

  public UrlMapsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all UrlMap resources, regional and global, available to the specified
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, UrlMapsScopedList> element :
   *       urlMapsClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Name of the project scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListUrlMapsRequest request =
        AggregatedListUrlMapsRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all UrlMap resources, regional and global, available to the specified
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   AggregatedListUrlMapsRequest request =
   *       AggregatedListUrlMapsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Map.Entry<String, UrlMapsScopedList> element :
   *       urlMapsClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(AggregatedListUrlMapsRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all UrlMap resources, regional and global, available to the specified
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   AggregatedListUrlMapsRequest request =
   *       AggregatedListUrlMapsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Map.Entry<String, UrlMapsScopedList>> future =
   *       urlMapsClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, UrlMapsScopedList> element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<AggregatedListUrlMapsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all UrlMap resources, regional and global, available to the specified
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   AggregatedListUrlMapsRequest request =
   *       AggregatedListUrlMapsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     UrlMapsAggregatedList response = urlMapsClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, UrlMapsScopedList> element : response.getItemsList()) {
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
   * }</pre>
   */
  public final UnaryCallable<AggregatedListUrlMapsRequest, UrlMapsAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "project-309310695";
   *   String urlMap = "urlMap-836780691";
   *   Operation response = urlMapsClient.deleteAsync(project, urlMap).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param urlMap Name of the UrlMap resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(String project, String urlMap) {
    DeleteUrlMapRequest request =
        DeleteUrlMapRequest.newBuilder().setProject(project).setUrlMap(urlMap).build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   DeleteUrlMapRequest request =
   *       DeleteUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .build();
   *   Operation response = urlMapsClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(DeleteUrlMapRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   DeleteUrlMapRequest request =
   *       DeleteUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       urlMapsClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteUrlMapRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified UrlMap resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   DeleteUrlMapRequest request =
   *       DeleteUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .build();
   *   ApiFuture<Operation> future = urlMapsClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteUrlMapRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified UrlMap resource. Gets a list of available URL maps by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "project-309310695";
   *   String urlMap = "urlMap-836780691";
   *   UrlMap response = urlMapsClient.get(project, urlMap);
   * }
   * }</pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified UrlMap resource. Gets a list of available URL maps by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   GetUrlMapRequest request =
   *       GetUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setUrlMap("urlMap-836780691")
   *           .build();
   *   UrlMap response = urlMapsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UrlMap get(GetUrlMapRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified UrlMap resource. Gets a list of available URL maps by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   GetUrlMapRequest request =
   *       GetUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setUrlMap("urlMap-836780691")
   *           .build();
   *   ApiFuture<UrlMap> future = urlMapsClient.getCallable().futureCall(request);
   *   // Do something.
   *   UrlMap response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetUrlMapRequest, UrlMap> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "project-309310695";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   Operation response = urlMapsClient.insertAsync(project, urlMapResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param urlMapResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, UrlMap urlMapResource) {
    InsertUrlMapRequest request =
        InsertUrlMapRequest.newBuilder()
            .setProject(project)
            .setUrlMapResource(urlMapResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   InsertUrlMapRequest request =
   *       InsertUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUrlMapResource(UrlMap.newBuilder().build())
   *           .build();
   *   Operation response = urlMapsClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(InsertUrlMapRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   InsertUrlMapRequest request =
   *       InsertUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUrlMapResource(UrlMap.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       urlMapsClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertUrlMapRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a UrlMap resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   InsertUrlMapRequest request =
   *       InsertUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUrlMapResource(UrlMap.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = urlMapsClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertUrlMapRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a cache invalidation operation, invalidating the specified path, scoped to the
   * specified UrlMap. For more information, see [Invalidating cached
   * content](/cdn/docs/invalidating-cached-content).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "project-309310695";
   *   String urlMap = "urlMap-836780691";
   *   CacheInvalidationRule cacheInvalidationRuleResource =
   *       CacheInvalidationRule.newBuilder().build();
   *   Operation response =
   *       urlMapsClient.invalidateCacheAsync(project, urlMap, cacheInvalidationRuleResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param urlMap Name of the UrlMap scoping this request.
   * @param cacheInvalidationRuleResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> invalidateCacheAsync(
      String project, String urlMap, CacheInvalidationRule cacheInvalidationRuleResource) {
    InvalidateCacheUrlMapRequest request =
        InvalidateCacheUrlMapRequest.newBuilder()
            .setProject(project)
            .setUrlMap(urlMap)
            .setCacheInvalidationRuleResource(cacheInvalidationRuleResource)
            .build();
    return invalidateCacheAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a cache invalidation operation, invalidating the specified path, scoped to the
   * specified UrlMap. For more information, see [Invalidating cached
   * content](/cdn/docs/invalidating-cached-content).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   InvalidateCacheUrlMapRequest request =
   *       InvalidateCacheUrlMapRequest.newBuilder()
   *           .setCacheInvalidationRuleResource(CacheInvalidationRule.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .build();
   *   Operation response = urlMapsClient.invalidateCacheAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> invalidateCacheAsync(
      InvalidateCacheUrlMapRequest request) {
    return invalidateCacheOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a cache invalidation operation, invalidating the specified path, scoped to the
   * specified UrlMap. For more information, see [Invalidating cached
   * content](/cdn/docs/invalidating-cached-content).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   InvalidateCacheUrlMapRequest request =
   *       InvalidateCacheUrlMapRequest.newBuilder()
   *           .setCacheInvalidationRuleResource(CacheInvalidationRule.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       urlMapsClient.invalidateCacheOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InvalidateCacheUrlMapRequest, Operation, Operation>
      invalidateCacheOperationCallable() {
    return stub.invalidateCacheOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a cache invalidation operation, invalidating the specified path, scoped to the
   * specified UrlMap. For more information, see [Invalidating cached
   * content](/cdn/docs/invalidating-cached-content).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   InvalidateCacheUrlMapRequest request =
   *       InvalidateCacheUrlMapRequest.newBuilder()
   *           .setCacheInvalidationRuleResource(CacheInvalidationRule.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .build();
   *   ApiFuture<Operation> future = urlMapsClient.invalidateCacheCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InvalidateCacheUrlMapRequest, Operation> invalidateCacheCallable() {
    return stub.invalidateCacheCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of UrlMap resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "project-309310695";
   *   for (UrlMap element : urlMapsClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListUrlMapsRequest request = ListUrlMapsRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of UrlMap resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   ListUrlMapsRequest request =
   *       ListUrlMapsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (UrlMap element : urlMapsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListUrlMapsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of UrlMap resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   ListUrlMapsRequest request =
   *       ListUrlMapsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<UrlMap> future = urlMapsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (UrlMap element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUrlMapsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of UrlMap resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   ListUrlMapsRequest request =
   *       ListUrlMapsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
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
   * }</pre>
   */
  public final UnaryCallable<ListUrlMapsRequest, UrlMapList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "project-309310695";
   *   String urlMap = "urlMap-836780691";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   Operation response = urlMapsClient.patchAsync(project, urlMap, urlMapResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param urlMap Name of the UrlMap resource to patch.
   * @param urlMapResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String urlMap, UrlMap urlMapResource) {
    PatchUrlMapRequest request =
        PatchUrlMapRequest.newBuilder()
            .setProject(project)
            .setUrlMap(urlMap)
            .setUrlMapResource(urlMapResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   PatchUrlMapRequest request =
   *       PatchUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .setUrlMapResource(UrlMap.newBuilder().build())
   *           .build();
   *   Operation response = urlMapsClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(PatchUrlMapRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   PatchUrlMapRequest request =
   *       PatchUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .setUrlMapResource(UrlMap.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       urlMapsClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchUrlMapRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified UrlMap resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   PatchUrlMapRequest request =
   *       PatchUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .setUrlMapResource(UrlMap.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = urlMapsClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchUrlMapRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "project-309310695";
   *   String urlMap = "urlMap-836780691";
   *   UrlMap urlMapResource = UrlMap.newBuilder().build();
   *   Operation response = urlMapsClient.updateAsync(project, urlMap, urlMapResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param urlMap Name of the UrlMap resource to update.
   * @param urlMapResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateAsync(
      String project, String urlMap, UrlMap urlMapResource) {
    UpdateUrlMapRequest request =
        UpdateUrlMapRequest.newBuilder()
            .setProject(project)
            .setUrlMap(urlMap)
            .setUrlMapResource(urlMapResource)
            .build();
    return updateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   UpdateUrlMapRequest request =
   *       UpdateUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .setUrlMapResource(UrlMap.newBuilder().build())
   *           .build();
   *   Operation response = urlMapsClient.updateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> updateAsync(UpdateUrlMapRequest request) {
    return updateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   UpdateUrlMapRequest request =
   *       UpdateUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .setUrlMapResource(UrlMap.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       urlMapsClient.updateOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateUrlMapRequest, Operation, Operation>
      updateOperationCallable() {
    return stub.updateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified UrlMap resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   UpdateUrlMapRequest request =
   *       UpdateUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUrlMap("urlMap-836780691")
   *           .setUrlMapResource(UrlMap.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = urlMapsClient.updateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateUrlMapRequest, Operation> updateCallable() {
    return stub.updateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be
   * run. Calling this method does NOT create the UrlMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   String project = "project-309310695";
   *   String urlMap = "urlMap-836780691";
   *   UrlMapsValidateRequest urlMapsValidateRequestResource =
   *       UrlMapsValidateRequest.newBuilder().build();
   *   UrlMapsValidateResponse response =
   *       urlMapsClient.validate(project, urlMap, urlMapsValidateRequestResource);
   * }
   * }</pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be
   * run. Calling this method does NOT create the UrlMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   ValidateUrlMapRequest request =
   *       ValidateUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setUrlMap("urlMap-836780691")
   *           .setUrlMapsValidateRequestResource(UrlMapsValidateRequest.newBuilder().build())
   *           .build();
   *   UrlMapsValidateResponse response = urlMapsClient.validate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UrlMapsValidateResponse validate(ValidateUrlMapRequest request) {
    return validateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be
   * run. Calling this method does NOT create the UrlMap.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
   *   ValidateUrlMapRequest request =
   *       ValidateUrlMapRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setUrlMap("urlMap-836780691")
   *           .setUrlMapsValidateRequestResource(UrlMapsValidateRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<UrlMapsValidateResponse> future =
   *       urlMapsClient.validateCallable().futureCall(request);
   *   // Do something.
   *   UrlMapsValidateResponse response = future.get();
   * }
   * }</pre>
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
          Map.Entry<String, UrlMapsScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListUrlMapsRequest,
                UrlMapsAggregatedList,
                Map.Entry<String, UrlMapsScopedList>>
            context,
        ApiFuture<UrlMapsAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new AggregatedListPagedResponse(input),
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
          Map.Entry<String, UrlMapsScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListUrlMapsRequest,
                UrlMapsAggregatedList,
                Map.Entry<String, UrlMapsScopedList>>
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
                Map.Entry<String, UrlMapsScopedList>>
            context,
        UrlMapsAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListUrlMapsRequest,
                UrlMapsAggregatedList,
                Map.Entry<String, UrlMapsScopedList>>
            context,
        ApiFuture<UrlMapsAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListUrlMapsRequest,
          UrlMapsAggregatedList,
          Map.Entry<String, UrlMapsScopedList>,
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
          futurePage, input -> new ListPagedResponse(input), MoreExecutors.directExecutor());
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
