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
import com.google.cloud.compute.v1.stub.HttpHealthChecksStub;
import com.google.cloud.compute.v1.stub.HttpHealthChecksStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The HttpHealthChecks API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
 *   String project = "";
 *   String httpHealthCheck = "";
 *   Operation response = httpHealthChecksClient.delete(project, httpHealthCheck);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the httpHealthChecksClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of HttpHealthChecksSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * HttpHealthChecksSettings httpHealthChecksSettings =
 *     HttpHealthChecksSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * HttpHealthChecksClient httpHealthChecksClient =
 *     HttpHealthChecksClient.create(httpHealthChecksSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * HttpHealthChecksSettings httpHealthChecksSettings =
 *     HttpHealthChecksSettings.newBuilder().setEndpoint(myEndpoint).build();
 * HttpHealthChecksClient httpHealthChecksClient =
 *     HttpHealthChecksClient.create(httpHealthChecksSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class HttpHealthChecksClient implements BackgroundResource {
  private final HttpHealthChecksSettings settings;
  private final HttpHealthChecksStub stub;

  /** Constructs an instance of HttpHealthChecksClient with default settings. */
  public static final HttpHealthChecksClient create() throws IOException {
    return create(HttpHealthChecksSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of HttpHealthChecksClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final HttpHealthChecksClient create(HttpHealthChecksSettings settings)
      throws IOException {
    return new HttpHealthChecksClient(settings);
  }

  /**
   * Constructs an instance of HttpHealthChecksClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use HttpHealthChecksSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final HttpHealthChecksClient create(HttpHealthChecksStub stub) {
    return new HttpHealthChecksClient(stub);
  }

  /**
   * Constructs an instance of HttpHealthChecksClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpHealthChecksClient(HttpHealthChecksSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((HttpHealthChecksStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected HttpHealthChecksClient(HttpHealthChecksStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final HttpHealthChecksSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public HttpHealthChecksStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HttpHealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String project = "";
   *   String httpHealthCheck = "";
   *   Operation response = httpHealthChecksClient.delete(project, httpHealthCheck);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param httpHealthCheck Name of the HttpHealthCheck resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String httpHealthCheck) {
    DeleteHttpHealthCheckRequest request =
        DeleteHttpHealthCheckRequest.newBuilder()
            .setProject(project)
            .setHttpHealthCheck(httpHealthCheck)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HttpHealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String httpHealthCheck = "";
   *   String project = "";
   *   DeleteHttpHealthCheckRequest request = DeleteHttpHealthCheckRequest.newBuilder()
   *     .setHttpHealthCheck(httpHealthCheck)
   *     .setProject(project)
   *     .build();
   *   Operation response = httpHealthChecksClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteHttpHealthCheckRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HttpHealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String httpHealthCheck = "";
   *   String project = "";
   *   DeleteHttpHealthCheckRequest request = DeleteHttpHealthCheckRequest.newBuilder()
   *     .setHttpHealthCheck(httpHealthCheck)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpHealthChecksClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteHttpHealthCheckRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HttpHealthCheck resource. Gets a list of available HTTP health checks by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String project = "";
   *   String httpHealthCheck = "";
   *   HttpHealthCheck response = httpHealthChecksClient.get(project, httpHealthCheck);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param httpHealthCheck Name of the HttpHealthCheck resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpHealthCheck get(String project, String httpHealthCheck) {
    GetHttpHealthCheckRequest request =
        GetHttpHealthCheckRequest.newBuilder()
            .setProject(project)
            .setHttpHealthCheck(httpHealthCheck)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HttpHealthCheck resource. Gets a list of available HTTP health checks by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String httpHealthCheck = "";
   *   String project = "";
   *   GetHttpHealthCheckRequest request = GetHttpHealthCheckRequest.newBuilder()
   *     .setHttpHealthCheck(httpHealthCheck)
   *     .setProject(project)
   *     .build();
   *   HttpHealthCheck response = httpHealthChecksClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpHealthCheck get(GetHttpHealthCheckRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HttpHealthCheck resource. Gets a list of available HTTP health checks by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String httpHealthCheck = "";
   *   String project = "";
   *   GetHttpHealthCheckRequest request = GetHttpHealthCheckRequest.newBuilder()
   *     .setHttpHealthCheck(httpHealthCheck)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;HttpHealthCheck&gt; future = httpHealthChecksClient.getCallable().futureCall(request);
   *   // Do something
   *   HttpHealthCheck response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetHttpHealthCheckRequest, HttpHealthCheck> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HttpHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String project = "";
   *   HttpHealthCheck httpHealthCheckResource = HttpHealthCheck.newBuilder().build();
   *   Operation response = httpHealthChecksClient.insert(project, httpHealthCheckResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param httpHealthCheckResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, HttpHealthCheck httpHealthCheckResource) {
    InsertHttpHealthCheckRequest request =
        InsertHttpHealthCheckRequest.newBuilder()
            .setProject(project)
            .setHttpHealthCheckResource(httpHealthCheckResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HttpHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String project = "";
   *   InsertHttpHealthCheckRequest request = InsertHttpHealthCheckRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   Operation response = httpHealthChecksClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertHttpHealthCheckRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HttpHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String project = "";
   *   InsertHttpHealthCheckRequest request = InsertHttpHealthCheckRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpHealthChecksClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertHttpHealthCheckRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpHealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String project = "";
   *   for (HttpHealthCheck element : httpHealthChecksClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListHttpHealthChecksRequest request =
        ListHttpHealthChecksRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpHealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String project = "";
   *   ListHttpHealthChecksRequest request = ListHttpHealthChecksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (HttpHealthCheck element : httpHealthChecksClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListHttpHealthChecksRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpHealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String project = "";
   *   ListHttpHealthChecksRequest request = ListHttpHealthChecksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = httpHealthChecksClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (HttpHealthCheck element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListHttpHealthChecksRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpHealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String project = "";
   *   ListHttpHealthChecksRequest request = ListHttpHealthChecksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     HttpHealthCheckList response = httpHealthChecksClient.listCallable().call(request);
   *     for (HttpHealthCheck element : response.getItemsList()) {
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
  public final UnaryCallable<ListHttpHealthChecksRequest, HttpHealthCheckList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpHealthCheck resource in the specified project using the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String project = "";
   *   String httpHealthCheck = "";
   *   HttpHealthCheck httpHealthCheckResource = HttpHealthCheck.newBuilder().build();
   *   Operation response = httpHealthChecksClient.patch(project, httpHealthCheck, httpHealthCheckResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param httpHealthCheck Name of the HttpHealthCheck resource to patch.
   * @param httpHealthCheckResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
      String project, String httpHealthCheck, HttpHealthCheck httpHealthCheckResource) {
    PatchHttpHealthCheckRequest request =
        PatchHttpHealthCheckRequest.newBuilder()
            .setProject(project)
            .setHttpHealthCheck(httpHealthCheck)
            .setHttpHealthCheckResource(httpHealthCheckResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpHealthCheck resource in the specified project using the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String httpHealthCheck = "";
   *   String project = "";
   *   PatchHttpHealthCheckRequest request = PatchHttpHealthCheckRequest.newBuilder()
   *     .setHttpHealthCheck(httpHealthCheck)
   *     .setProject(project)
   *     .build();
   *   Operation response = httpHealthChecksClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchHttpHealthCheckRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpHealthCheck resource in the specified project using the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String httpHealthCheck = "";
   *   String project = "";
   *   PatchHttpHealthCheckRequest request = PatchHttpHealthCheckRequest.newBuilder()
   *     .setHttpHealthCheck(httpHealthCheck)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpHealthChecksClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchHttpHealthCheckRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String project = "";
   *   String httpHealthCheck = "";
   *   HttpHealthCheck httpHealthCheckResource = HttpHealthCheck.newBuilder().build();
   *   Operation response = httpHealthChecksClient.update(project, httpHealthCheck, httpHealthCheckResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param httpHealthCheck Name of the HttpHealthCheck resource to update.
   * @param httpHealthCheckResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(
      String project, String httpHealthCheck, HttpHealthCheck httpHealthCheckResource) {
    UpdateHttpHealthCheckRequest request =
        UpdateHttpHealthCheckRequest.newBuilder()
            .setProject(project)
            .setHttpHealthCheck(httpHealthCheck)
            .setHttpHealthCheckResource(httpHealthCheckResource)
            .build();
    return update(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String httpHealthCheck = "";
   *   String project = "";
   *   UpdateHttpHealthCheckRequest request = UpdateHttpHealthCheckRequest.newBuilder()
   *     .setHttpHealthCheck(httpHealthCheck)
   *     .setProject(project)
   *     .build();
   *   Operation response = httpHealthChecksClient.update(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(UpdateHttpHealthCheckRequest request) {
    return updateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpHealthChecksClient httpHealthChecksClient = HttpHealthChecksClient.create()) {
   *   String httpHealthCheck = "";
   *   String project = "";
   *   UpdateHttpHealthCheckRequest request = UpdateHttpHealthCheckRequest.newBuilder()
   *     .setHttpHealthCheck(httpHealthCheck)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpHealthChecksClient.updateCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateHttpHealthCheckRequest, Operation> updateCallable() {
    return stub.updateCallable();
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
          ListHttpHealthChecksRequest,
          HttpHealthCheckList,
          HttpHealthCheck,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListHttpHealthChecksRequest, HttpHealthCheckList, HttpHealthCheck> context,
        ApiFuture<HttpHealthCheckList> futureResponse) {
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
          ListHttpHealthChecksRequest, HttpHealthCheckList, HttpHealthCheck, ListPage> {

    private ListPage(
        PageContext<ListHttpHealthChecksRequest, HttpHealthCheckList, HttpHealthCheck> context,
        HttpHealthCheckList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListHttpHealthChecksRequest, HttpHealthCheckList, HttpHealthCheck> context,
        HttpHealthCheckList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListHttpHealthChecksRequest, HttpHealthCheckList, HttpHealthCheck> context,
        ApiFuture<HttpHealthCheckList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHttpHealthChecksRequest,
          HttpHealthCheckList,
          HttpHealthCheck,
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
