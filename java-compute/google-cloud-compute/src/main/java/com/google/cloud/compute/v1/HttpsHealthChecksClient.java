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
import com.google.cloud.compute.v1.stub.HttpsHealthChecksStub;
import com.google.cloud.compute.v1.stub.HttpsHealthChecksStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The HttpsHealthChecks API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
 *   String project = "";
 *   String httpsHealthCheck = "";
 *   Operation response = httpsHealthChecksClient.delete(project, httpsHealthCheck);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the httpsHealthChecksClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of HttpsHealthChecksSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * HttpsHealthChecksSettings httpsHealthChecksSettings =
 *     HttpsHealthChecksSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * HttpsHealthChecksClient httpsHealthChecksClient =
 *     HttpsHealthChecksClient.create(httpsHealthChecksSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * HttpsHealthChecksSettings httpsHealthChecksSettings =
 *     HttpsHealthChecksSettings.newBuilder().setEndpoint(myEndpoint).build();
 * HttpsHealthChecksClient httpsHealthChecksClient =
 *     HttpsHealthChecksClient.create(httpsHealthChecksSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class HttpsHealthChecksClient implements BackgroundResource {
  private final HttpsHealthChecksSettings settings;
  private final HttpsHealthChecksStub stub;

  /** Constructs an instance of HttpsHealthChecksClient with default settings. */
  public static final HttpsHealthChecksClient create() throws IOException {
    return create(HttpsHealthChecksSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of HttpsHealthChecksClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final HttpsHealthChecksClient create(HttpsHealthChecksSettings settings)
      throws IOException {
    return new HttpsHealthChecksClient(settings);
  }

  /**
   * Constructs an instance of HttpsHealthChecksClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use HttpsHealthChecksSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final HttpsHealthChecksClient create(HttpsHealthChecksStub stub) {
    return new HttpsHealthChecksClient(stub);
  }

  /**
   * Constructs an instance of HttpsHealthChecksClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpsHealthChecksClient(HttpsHealthChecksSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((HttpsHealthChecksStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected HttpsHealthChecksClient(HttpsHealthChecksStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final HttpsHealthChecksSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public HttpsHealthChecksStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HttpsHealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String project = "";
   *   String httpsHealthCheck = "";
   *   Operation response = httpsHealthChecksClient.delete(project, httpsHealthCheck);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String httpsHealthCheck) {
    DeleteHttpsHealthCheckRequest request =
        DeleteHttpsHealthCheckRequest.newBuilder()
            .setProject(project)
            .setHttpsHealthCheck(httpsHealthCheck)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HttpsHealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String httpsHealthCheck = "";
   *   String project = "";
   *   DeleteHttpsHealthCheckRequest request = DeleteHttpsHealthCheckRequest.newBuilder()
   *     .setHttpsHealthCheck(httpsHealthCheck)
   *     .setProject(project)
   *     .build();
   *   Operation response = httpsHealthChecksClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteHttpsHealthCheckRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified HttpsHealthCheck resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String httpsHealthCheck = "";
   *   String project = "";
   *   DeleteHttpsHealthCheckRequest request = DeleteHttpsHealthCheckRequest.newBuilder()
   *     .setHttpsHealthCheck(httpsHealthCheck)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpsHealthChecksClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteHttpsHealthCheckRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HttpsHealthCheck resource. Gets a list of available HTTPS health checks
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String project = "";
   *   String httpsHealthCheck = "";
   *   HttpsHealthCheck response = httpsHealthChecksClient.get(project, httpsHealthCheck);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpsHealthCheck get(String project, String httpsHealthCheck) {
    GetHttpsHealthCheckRequest request =
        GetHttpsHealthCheckRequest.newBuilder()
            .setProject(project)
            .setHttpsHealthCheck(httpsHealthCheck)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HttpsHealthCheck resource. Gets a list of available HTTPS health checks
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String httpsHealthCheck = "";
   *   String project = "";
   *   GetHttpsHealthCheckRequest request = GetHttpsHealthCheckRequest.newBuilder()
   *     .setHttpsHealthCheck(httpsHealthCheck)
   *     .setProject(project)
   *     .build();
   *   HttpsHealthCheck response = httpsHealthChecksClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpsHealthCheck get(GetHttpsHealthCheckRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified HttpsHealthCheck resource. Gets a list of available HTTPS health checks
   * by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String httpsHealthCheck = "";
   *   String project = "";
   *   GetHttpsHealthCheckRequest request = GetHttpsHealthCheckRequest.newBuilder()
   *     .setHttpsHealthCheck(httpsHealthCheck)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;HttpsHealthCheck&gt; future = httpsHealthChecksClient.getCallable().futureCall(request);
   *   // Do something
   *   HttpsHealthCheck response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetHttpsHealthCheckRequest, HttpsHealthCheck> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HttpsHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String project = "";
   *   HttpsHealthCheck httpsHealthCheckResource = HttpsHealthCheck.newBuilder().build();
   *   Operation response = httpsHealthChecksClient.insert(project, httpsHealthCheckResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param httpsHealthCheckResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, HttpsHealthCheck httpsHealthCheckResource) {
    InsertHttpsHealthCheckRequest request =
        InsertHttpsHealthCheckRequest.newBuilder()
            .setProject(project)
            .setHttpsHealthCheckResource(httpsHealthCheckResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HttpsHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String project = "";
   *   InsertHttpsHealthCheckRequest request = InsertHttpsHealthCheckRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   Operation response = httpsHealthChecksClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertHttpsHealthCheckRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a HttpsHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String project = "";
   *   InsertHttpsHealthCheckRequest request = InsertHttpsHealthCheckRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpsHealthChecksClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertHttpsHealthCheckRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpsHealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String project = "";
   *   for (HttpsHealthCheck element : httpsHealthChecksClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListHttpsHealthChecksRequest request =
        ListHttpsHealthChecksRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpsHealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String project = "";
   *   ListHttpsHealthChecksRequest request = ListHttpsHealthChecksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (HttpsHealthCheck element : httpsHealthChecksClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListHttpsHealthChecksRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpsHealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String project = "";
   *   ListHttpsHealthChecksRequest request = ListHttpsHealthChecksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = httpsHealthChecksClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (HttpsHealthCheck element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListHttpsHealthChecksRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of HttpsHealthCheck resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String project = "";
   *   ListHttpsHealthChecksRequest request = ListHttpsHealthChecksRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     HttpsHealthCheckList response = httpsHealthChecksClient.listCallable().call(request);
   *     for (HttpsHealthCheck element : response.getItemsList()) {
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
  public final UnaryCallable<ListHttpsHealthChecksRequest, HttpsHealthCheckList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String project = "";
   *   String httpsHealthCheck = "";
   *   HttpsHealthCheck httpsHealthCheckResource = HttpsHealthCheck.newBuilder().build();
   *   Operation response = httpsHealthChecksClient.patch(project, httpsHealthCheck, httpsHealthCheckResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to patch.
   * @param httpsHealthCheckResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
      String project, String httpsHealthCheck, HttpsHealthCheck httpsHealthCheckResource) {
    PatchHttpsHealthCheckRequest request =
        PatchHttpsHealthCheckRequest.newBuilder()
            .setProject(project)
            .setHttpsHealthCheck(httpsHealthCheck)
            .setHttpsHealthCheckResource(httpsHealthCheckResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String httpsHealthCheck = "";
   *   String project = "";
   *   PatchHttpsHealthCheckRequest request = PatchHttpsHealthCheckRequest.newBuilder()
   *     .setHttpsHealthCheck(httpsHealthCheck)
   *     .setProject(project)
   *     .build();
   *   Operation response = httpsHealthChecksClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchHttpsHealthCheckRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the
   * request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String httpsHealthCheck = "";
   *   String project = "";
   *   PatchHttpsHealthCheckRequest request = PatchHttpsHealthCheckRequest.newBuilder()
   *     .setHttpsHealthCheck(httpsHealthCheck)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpsHealthChecksClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchHttpsHealthCheckRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String project = "";
   *   String httpsHealthCheck = "";
   *   HttpsHealthCheck httpsHealthCheckResource = HttpsHealthCheck.newBuilder().build();
   *   Operation response = httpsHealthChecksClient.update(project, httpsHealthCheck, httpsHealthCheckResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param httpsHealthCheck Name of the HttpsHealthCheck resource to update.
   * @param httpsHealthCheckResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(
      String project, String httpsHealthCheck, HttpsHealthCheck httpsHealthCheckResource) {
    UpdateHttpsHealthCheckRequest request =
        UpdateHttpsHealthCheckRequest.newBuilder()
            .setProject(project)
            .setHttpsHealthCheck(httpsHealthCheck)
            .setHttpsHealthCheckResource(httpsHealthCheckResource)
            .build();
    return update(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String httpsHealthCheck = "";
   *   String project = "";
   *   UpdateHttpsHealthCheckRequest request = UpdateHttpsHealthCheckRequest.newBuilder()
   *     .setHttpsHealthCheck(httpsHealthCheck)
   *     .setProject(project)
   *     .build();
   *   Operation response = httpsHealthChecksClient.update(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(UpdateHttpsHealthCheckRequest request) {
    return updateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a HttpsHealthCheck resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (HttpsHealthChecksClient httpsHealthChecksClient = HttpsHealthChecksClient.create()) {
   *   String httpsHealthCheck = "";
   *   String project = "";
   *   UpdateHttpsHealthCheckRequest request = UpdateHttpsHealthCheckRequest.newBuilder()
   *     .setHttpsHealthCheck(httpsHealthCheck)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = httpsHealthChecksClient.updateCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateHttpsHealthCheckRequest, Operation> updateCallable() {
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
          ListHttpsHealthChecksRequest,
          HttpsHealthCheckList,
          HttpsHealthCheck,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListHttpsHealthChecksRequest, HttpsHealthCheckList, HttpsHealthCheck> context,
        ApiFuture<HttpsHealthCheckList> futureResponse) {
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
          ListHttpsHealthChecksRequest, HttpsHealthCheckList, HttpsHealthCheck, ListPage> {

    private ListPage(
        PageContext<ListHttpsHealthChecksRequest, HttpsHealthCheckList, HttpsHealthCheck> context,
        HttpsHealthCheckList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListHttpsHealthChecksRequest, HttpsHealthCheckList, HttpsHealthCheck> context,
        HttpsHealthCheckList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListHttpsHealthChecksRequest, HttpsHealthCheckList, HttpsHealthCheck> context,
        ApiFuture<HttpsHealthCheckList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHttpsHealthChecksRequest,
          HttpsHealthCheckList,
          HttpsHealthCheck,
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
