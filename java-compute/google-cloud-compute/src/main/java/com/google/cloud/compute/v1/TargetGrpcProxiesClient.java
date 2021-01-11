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
import com.google.cloud.compute.v1.stub.TargetGrpcProxiesStub;
import com.google.cloud.compute.v1.stub.TargetGrpcProxiesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The TargetGrpcProxies API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
 *   String project = "";
 *   String targetGrpcProxy = "";
 *   Operation response = targetGrpcProxiesClient.delete(project, targetGrpcProxy);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the targetGrpcProxiesClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of TargetGrpcProxiesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * TargetGrpcProxiesSettings targetGrpcProxiesSettings =
 *     TargetGrpcProxiesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TargetGrpcProxiesClient targetGrpcProxiesClient =
 *     TargetGrpcProxiesClient.create(targetGrpcProxiesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * TargetGrpcProxiesSettings targetGrpcProxiesSettings =
 *     TargetGrpcProxiesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TargetGrpcProxiesClient targetGrpcProxiesClient =
 *     TargetGrpcProxiesClient.create(targetGrpcProxiesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class TargetGrpcProxiesClient implements BackgroundResource {
  private final TargetGrpcProxiesSettings settings;
  private final TargetGrpcProxiesStub stub;

  /** Constructs an instance of TargetGrpcProxiesClient with default settings. */
  public static final TargetGrpcProxiesClient create() throws IOException {
    return create(TargetGrpcProxiesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TargetGrpcProxiesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TargetGrpcProxiesClient create(TargetGrpcProxiesSettings settings)
      throws IOException {
    return new TargetGrpcProxiesClient(settings);
  }

  /**
   * Constructs an instance of TargetGrpcProxiesClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use TargetGrpcProxiesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final TargetGrpcProxiesClient create(TargetGrpcProxiesStub stub) {
    return new TargetGrpcProxiesClient(stub);
  }

  /**
   * Constructs an instance of TargetGrpcProxiesClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TargetGrpcProxiesClient(TargetGrpcProxiesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TargetGrpcProxiesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected TargetGrpcProxiesClient(TargetGrpcProxiesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TargetGrpcProxiesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TargetGrpcProxiesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetGrpcProxy in the given scope
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "";
   *   String targetGrpcProxy = "";
   *   Operation response = targetGrpcProxiesClient.delete(project, targetGrpcProxy);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param targetGrpcProxy Name of the TargetGrpcProxy resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String targetGrpcProxy) {
    DeleteTargetGrpcProxyRequest request =
        DeleteTargetGrpcProxyRequest.newBuilder()
            .setProject(project)
            .setTargetGrpcProxy(targetGrpcProxy)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetGrpcProxy in the given scope
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "";
   *   String targetGrpcProxy = "";
   *   DeleteTargetGrpcProxyRequest request = DeleteTargetGrpcProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetGrpcProxy(targetGrpcProxy)
   *     .build();
   *   Operation response = targetGrpcProxiesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteTargetGrpcProxyRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetGrpcProxy in the given scope
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "";
   *   String targetGrpcProxy = "";
   *   DeleteTargetGrpcProxyRequest request = DeleteTargetGrpcProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetGrpcProxy(targetGrpcProxy)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetGrpcProxiesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteTargetGrpcProxyRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetGrpcProxy resource in the given scope.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "";
   *   String targetGrpcProxy = "";
   *   TargetGrpcProxy response = targetGrpcProxiesClient.get(project, targetGrpcProxy);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param targetGrpcProxy Name of the TargetGrpcProxy resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetGrpcProxy get(String project, String targetGrpcProxy) {
    GetTargetGrpcProxyRequest request =
        GetTargetGrpcProxyRequest.newBuilder()
            .setProject(project)
            .setTargetGrpcProxy(targetGrpcProxy)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetGrpcProxy resource in the given scope.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "";
   *   String targetGrpcProxy = "";
   *   GetTargetGrpcProxyRequest request = GetTargetGrpcProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetGrpcProxy(targetGrpcProxy)
   *     .build();
   *   TargetGrpcProxy response = targetGrpcProxiesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetGrpcProxy get(GetTargetGrpcProxyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetGrpcProxy resource in the given scope.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "";
   *   String targetGrpcProxy = "";
   *   GetTargetGrpcProxyRequest request = GetTargetGrpcProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetGrpcProxy(targetGrpcProxy)
   *     .build();
   *   ApiFuture&lt;TargetGrpcProxy&gt; future = targetGrpcProxiesClient.getCallable().futureCall(request);
   *   // Do something
   *   TargetGrpcProxy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetTargetGrpcProxyRequest, TargetGrpcProxy> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetGrpcProxy in the specified project in the given scope using the parameters that
   * are included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "";
   *   TargetGrpcProxy targetGrpcProxyResource = TargetGrpcProxy.newBuilder().build();
   *   Operation response = targetGrpcProxiesClient.insert(project, targetGrpcProxyResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param targetGrpcProxyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, TargetGrpcProxy targetGrpcProxyResource) {
    InsertTargetGrpcProxyRequest request =
        InsertTargetGrpcProxyRequest.newBuilder()
            .setProject(project)
            .setTargetGrpcProxyResource(targetGrpcProxyResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetGrpcProxy in the specified project in the given scope using the parameters that
   * are included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "";
   *   TargetGrpcProxy targetGrpcProxyResource = TargetGrpcProxy.newBuilder().build();
   *   InsertTargetGrpcProxyRequest request = InsertTargetGrpcProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetGrpcProxyResource(targetGrpcProxyResource)
   *     .build();
   *   Operation response = targetGrpcProxiesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertTargetGrpcProxyRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetGrpcProxy in the specified project in the given scope using the parameters that
   * are included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "";
   *   TargetGrpcProxy targetGrpcProxyResource = TargetGrpcProxy.newBuilder().build();
   *   InsertTargetGrpcProxyRequest request = InsertTargetGrpcProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetGrpcProxyResource(targetGrpcProxyResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetGrpcProxiesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertTargetGrpcProxyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the TargetGrpcProxies for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "";
   *   for (TargetGrpcProxy element : targetGrpcProxiesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListTargetGrpcProxiesRequest request =
        ListTargetGrpcProxiesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the TargetGrpcProxies for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "";
   *   ListTargetGrpcProxiesRequest request = ListTargetGrpcProxiesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (TargetGrpcProxy element : targetGrpcProxiesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListTargetGrpcProxiesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the TargetGrpcProxies for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "";
   *   ListTargetGrpcProxiesRequest request = ListTargetGrpcProxiesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = targetGrpcProxiesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (TargetGrpcProxy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListTargetGrpcProxiesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the TargetGrpcProxies for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "";
   *   ListTargetGrpcProxiesRequest request = ListTargetGrpcProxiesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     TargetGrpcProxyList response = targetGrpcProxiesClient.listCallable().call(request);
   *     for (TargetGrpcProxy element : response.getItemsList()) {
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
  public final UnaryCallable<ListTargetGrpcProxiesRequest, TargetGrpcProxyList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified TargetGrpcProxy resource with the data included in the request. This
   * method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "";
   *   String targetGrpcProxy = "";
   *   TargetGrpcProxy targetGrpcProxyResource = TargetGrpcProxy.newBuilder().build();
   *   Operation response = targetGrpcProxiesClient.patch(project, targetGrpcProxy, targetGrpcProxyResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param targetGrpcProxy Name of the TargetGrpcProxy resource to patch.
   * @param targetGrpcProxyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
      String project, String targetGrpcProxy, TargetGrpcProxy targetGrpcProxyResource) {
    PatchTargetGrpcProxyRequest request =
        PatchTargetGrpcProxyRequest.newBuilder()
            .setProject(project)
            .setTargetGrpcProxy(targetGrpcProxy)
            .setTargetGrpcProxyResource(targetGrpcProxyResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified TargetGrpcProxy resource with the data included in the request. This
   * method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "";
   *   String targetGrpcProxy = "";
   *   TargetGrpcProxy targetGrpcProxyResource = TargetGrpcProxy.newBuilder().build();
   *   PatchTargetGrpcProxyRequest request = PatchTargetGrpcProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetGrpcProxy(targetGrpcProxy)
   *     .setTargetGrpcProxyResource(targetGrpcProxyResource)
   *     .build();
   *   Operation response = targetGrpcProxiesClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchTargetGrpcProxyRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified TargetGrpcProxy resource with the data included in the request. This
   * method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxiesClient targetGrpcProxiesClient = TargetGrpcProxiesClient.create()) {
   *   String project = "";
   *   String targetGrpcProxy = "";
   *   TargetGrpcProxy targetGrpcProxyResource = TargetGrpcProxy.newBuilder().build();
   *   PatchTargetGrpcProxyRequest request = PatchTargetGrpcProxyRequest.newBuilder()
   *     .setProject(project)
   *     .setTargetGrpcProxy(targetGrpcProxy)
   *     .setTargetGrpcProxyResource(targetGrpcProxyResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetGrpcProxiesClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchTargetGrpcProxyRequest, Operation> patchCallable() {
    return stub.patchCallable();
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
          ListTargetGrpcProxiesRequest,
          TargetGrpcProxyList,
          TargetGrpcProxy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListTargetGrpcProxiesRequest, TargetGrpcProxyList, TargetGrpcProxy> context,
        ApiFuture<TargetGrpcProxyList> futureResponse) {
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
          ListTargetGrpcProxiesRequest, TargetGrpcProxyList, TargetGrpcProxy, ListPage> {

    private ListPage(
        PageContext<ListTargetGrpcProxiesRequest, TargetGrpcProxyList, TargetGrpcProxy> context,
        TargetGrpcProxyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListTargetGrpcProxiesRequest, TargetGrpcProxyList, TargetGrpcProxy> context,
        TargetGrpcProxyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListTargetGrpcProxiesRequest, TargetGrpcProxyList, TargetGrpcProxy> context,
        ApiFuture<TargetGrpcProxyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetGrpcProxiesRequest,
          TargetGrpcProxyList,
          TargetGrpcProxy,
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
