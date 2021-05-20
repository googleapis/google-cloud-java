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
import com.google.cloud.compute.v1.stub.GlobalPublicDelegatedPrefixesStub;
import com.google.cloud.compute.v1.stub.GlobalPublicDelegatedPrefixesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The GlobalPublicDelegatedPrefixes API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient = GlobalPublicDelegatedPrefixesClient.create()) {
 *   String project = "";
 *   String publicDelegatedPrefix = "";
 *   Operation response = globalPublicDelegatedPrefixesClient.delete(project, publicDelegatedPrefix);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the globalPublicDelegatedPrefixesClient object to clean up
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
 * GlobalPublicDelegatedPrefixesSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * GlobalPublicDelegatedPrefixesSettings globalPublicDelegatedPrefixesSettings =
 *     GlobalPublicDelegatedPrefixesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
 *     GlobalPublicDelegatedPrefixesClient.create(globalPublicDelegatedPrefixesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * GlobalPublicDelegatedPrefixesSettings globalPublicDelegatedPrefixesSettings =
 *     GlobalPublicDelegatedPrefixesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient =
 *     GlobalPublicDelegatedPrefixesClient.create(globalPublicDelegatedPrefixesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class GlobalPublicDelegatedPrefixesClient implements BackgroundResource {
  private final GlobalPublicDelegatedPrefixesSettings settings;
  private final GlobalPublicDelegatedPrefixesStub stub;

  /** Constructs an instance of GlobalPublicDelegatedPrefixesClient with default settings. */
  public static final GlobalPublicDelegatedPrefixesClient create() throws IOException {
    return create(GlobalPublicDelegatedPrefixesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GlobalPublicDelegatedPrefixesClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final GlobalPublicDelegatedPrefixesClient create(
      GlobalPublicDelegatedPrefixesSettings settings) throws IOException {
    return new GlobalPublicDelegatedPrefixesClient(settings);
  }

  /**
   * Constructs an instance of GlobalPublicDelegatedPrefixesClient, using the given stub for making
   * calls. This is for advanced usage - prefer to use GlobalPublicDelegatedPrefixesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final GlobalPublicDelegatedPrefixesClient create(
      GlobalPublicDelegatedPrefixesStub stub) {
    return new GlobalPublicDelegatedPrefixesClient(stub);
  }

  /**
   * Constructs an instance of GlobalPublicDelegatedPrefixesClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GlobalPublicDelegatedPrefixesClient(GlobalPublicDelegatedPrefixesSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((GlobalPublicDelegatedPrefixesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected GlobalPublicDelegatedPrefixesClient(GlobalPublicDelegatedPrefixesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GlobalPublicDelegatedPrefixesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public GlobalPublicDelegatedPrefixesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified global PublicDelegatedPrefix.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient = GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "";
   *   String publicDelegatedPrefix = "";
   *   Operation response = globalPublicDelegatedPrefixesClient.delete(project, publicDelegatedPrefix);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param publicDelegatedPrefix Name of the PublicDelegatedPrefix resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String publicDelegatedPrefix) {
    DeleteGlobalPublicDelegatedPrefixeRequest request =
        DeleteGlobalPublicDelegatedPrefixeRequest.newBuilder()
            .setProject(project)
            .setPublicDelegatedPrefix(publicDelegatedPrefix)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified global PublicDelegatedPrefix.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient = GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "";
   *   String publicDelegatedPrefix = "";
   *   DeleteGlobalPublicDelegatedPrefixeRequest request = DeleteGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *     .setProject(project)
   *     .setPublicDelegatedPrefix(publicDelegatedPrefix)
   *     .build();
   *   Operation response = globalPublicDelegatedPrefixesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteGlobalPublicDelegatedPrefixeRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified global PublicDelegatedPrefix.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient = GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "";
   *   String publicDelegatedPrefix = "";
   *   DeleteGlobalPublicDelegatedPrefixeRequest request = DeleteGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *     .setProject(project)
   *     .setPublicDelegatedPrefix(publicDelegatedPrefix)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = globalPublicDelegatedPrefixesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteGlobalPublicDelegatedPrefixeRequest, Operation>
      deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified global PublicDelegatedPrefix resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient = GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "";
   *   String publicDelegatedPrefix = "";
   *   PublicDelegatedPrefix response = globalPublicDelegatedPrefixesClient.get(project, publicDelegatedPrefix);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param publicDelegatedPrefix Name of the PublicDelegatedPrefix resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublicDelegatedPrefix get(String project, String publicDelegatedPrefix) {
    GetGlobalPublicDelegatedPrefixeRequest request =
        GetGlobalPublicDelegatedPrefixeRequest.newBuilder()
            .setProject(project)
            .setPublicDelegatedPrefix(publicDelegatedPrefix)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified global PublicDelegatedPrefix resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient = GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "";
   *   String publicDelegatedPrefix = "";
   *   GetGlobalPublicDelegatedPrefixeRequest request = GetGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *     .setProject(project)
   *     .setPublicDelegatedPrefix(publicDelegatedPrefix)
   *     .build();
   *   PublicDelegatedPrefix response = globalPublicDelegatedPrefixesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublicDelegatedPrefix get(GetGlobalPublicDelegatedPrefixeRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified global PublicDelegatedPrefix resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient = GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "";
   *   String publicDelegatedPrefix = "";
   *   GetGlobalPublicDelegatedPrefixeRequest request = GetGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *     .setProject(project)
   *     .setPublicDelegatedPrefix(publicDelegatedPrefix)
   *     .build();
   *   ApiFuture&lt;PublicDelegatedPrefix&gt; future = globalPublicDelegatedPrefixesClient.getCallable().futureCall(request);
   *   // Do something
   *   PublicDelegatedPrefix response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetGlobalPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a global PublicDelegatedPrefix in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient = GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "";
   *   PublicDelegatedPrefix publicDelegatedPrefixResource = PublicDelegatedPrefix.newBuilder().build();
   *   Operation response = globalPublicDelegatedPrefixesClient.insert(project, publicDelegatedPrefixResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param publicDelegatedPrefixResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(
      String project, PublicDelegatedPrefix publicDelegatedPrefixResource) {
    InsertGlobalPublicDelegatedPrefixeRequest request =
        InsertGlobalPublicDelegatedPrefixeRequest.newBuilder()
            .setProject(project)
            .setPublicDelegatedPrefixResource(publicDelegatedPrefixResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a global PublicDelegatedPrefix in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient = GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "";
   *   PublicDelegatedPrefix publicDelegatedPrefixResource = PublicDelegatedPrefix.newBuilder().build();
   *   InsertGlobalPublicDelegatedPrefixeRequest request = InsertGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *     .setProject(project)
   *     .setPublicDelegatedPrefixResource(publicDelegatedPrefixResource)
   *     .build();
   *   Operation response = globalPublicDelegatedPrefixesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertGlobalPublicDelegatedPrefixeRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a global PublicDelegatedPrefix in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient = GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "";
   *   PublicDelegatedPrefix publicDelegatedPrefixResource = PublicDelegatedPrefix.newBuilder().build();
   *   InsertGlobalPublicDelegatedPrefixeRequest request = InsertGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *     .setProject(project)
   *     .setPublicDelegatedPrefixResource(publicDelegatedPrefixResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = globalPublicDelegatedPrefixesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertGlobalPublicDelegatedPrefixeRequest, Operation>
      insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the global PublicDelegatedPrefixes for a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient = GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "";
   *   for (PublicDelegatedPrefix element : globalPublicDelegatedPrefixesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListGlobalPublicDelegatedPrefixesRequest request =
        ListGlobalPublicDelegatedPrefixesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the global PublicDelegatedPrefixes for a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient = GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "";
   *   ListGlobalPublicDelegatedPrefixesRequest request = ListGlobalPublicDelegatedPrefixesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (PublicDelegatedPrefix element : globalPublicDelegatedPrefixesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListGlobalPublicDelegatedPrefixesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the global PublicDelegatedPrefixes for a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient = GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "";
   *   ListGlobalPublicDelegatedPrefixesRequest request = ListGlobalPublicDelegatedPrefixesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = globalPublicDelegatedPrefixesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (PublicDelegatedPrefix element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListGlobalPublicDelegatedPrefixesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the global PublicDelegatedPrefixes for a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient = GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "";
   *   ListGlobalPublicDelegatedPrefixesRequest request = ListGlobalPublicDelegatedPrefixesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     PublicDelegatedPrefixList response = globalPublicDelegatedPrefixesClient.listCallable().call(request);
   *     for (PublicDelegatedPrefix element : response.getItemsList()) {
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
  public final UnaryCallable<ListGlobalPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified global PublicDelegatedPrefix resource with the data included in the
   * request. This method supports PATCH semantics and uses JSON merge patch format and processing
   * rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient = GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "";
   *   String publicDelegatedPrefix = "";
   *   PublicDelegatedPrefix publicDelegatedPrefixResource = PublicDelegatedPrefix.newBuilder().build();
   *   Operation response = globalPublicDelegatedPrefixesClient.patch(project, publicDelegatedPrefix, publicDelegatedPrefixResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param publicDelegatedPrefix Name of the PublicDelegatedPrefix resource to patch.
   * @param publicDelegatedPrefixResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
      String project,
      String publicDelegatedPrefix,
      PublicDelegatedPrefix publicDelegatedPrefixResource) {
    PatchGlobalPublicDelegatedPrefixeRequest request =
        PatchGlobalPublicDelegatedPrefixeRequest.newBuilder()
            .setProject(project)
            .setPublicDelegatedPrefix(publicDelegatedPrefix)
            .setPublicDelegatedPrefixResource(publicDelegatedPrefixResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified global PublicDelegatedPrefix resource with the data included in the
   * request. This method supports PATCH semantics and uses JSON merge patch format and processing
   * rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient = GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "";
   *   String publicDelegatedPrefix = "";
   *   PublicDelegatedPrefix publicDelegatedPrefixResource = PublicDelegatedPrefix.newBuilder().build();
   *   PatchGlobalPublicDelegatedPrefixeRequest request = PatchGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *     .setProject(project)
   *     .setPublicDelegatedPrefix(publicDelegatedPrefix)
   *     .setPublicDelegatedPrefixResource(publicDelegatedPrefixResource)
   *     .build();
   *   Operation response = globalPublicDelegatedPrefixesClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchGlobalPublicDelegatedPrefixeRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified global PublicDelegatedPrefix resource with the data included in the
   * request. This method supports PATCH semantics and uses JSON merge patch format and processing
   * rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (GlobalPublicDelegatedPrefixesClient globalPublicDelegatedPrefixesClient = GlobalPublicDelegatedPrefixesClient.create()) {
   *   String project = "";
   *   String publicDelegatedPrefix = "";
   *   PublicDelegatedPrefix publicDelegatedPrefixResource = PublicDelegatedPrefix.newBuilder().build();
   *   PatchGlobalPublicDelegatedPrefixeRequest request = PatchGlobalPublicDelegatedPrefixeRequest.newBuilder()
   *     .setProject(project)
   *     .setPublicDelegatedPrefix(publicDelegatedPrefix)
   *     .setPublicDelegatedPrefixResource(publicDelegatedPrefixResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = globalPublicDelegatedPrefixesClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchGlobalPublicDelegatedPrefixeRequest, Operation> patchCallable() {
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
          ListGlobalPublicDelegatedPrefixesRequest,
          PublicDelegatedPrefixList,
          PublicDelegatedPrefix,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListGlobalPublicDelegatedPrefixesRequest,
                PublicDelegatedPrefixList,
                PublicDelegatedPrefix>
            context,
        ApiFuture<PublicDelegatedPrefixList> futureResponse) {
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
          ListGlobalPublicDelegatedPrefixesRequest,
          PublicDelegatedPrefixList,
          PublicDelegatedPrefix,
          ListPage> {

    private ListPage(
        PageContext<
                ListGlobalPublicDelegatedPrefixesRequest,
                PublicDelegatedPrefixList,
                PublicDelegatedPrefix>
            context,
        PublicDelegatedPrefixList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListGlobalPublicDelegatedPrefixesRequest,
                PublicDelegatedPrefixList,
                PublicDelegatedPrefix>
            context,
        PublicDelegatedPrefixList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListGlobalPublicDelegatedPrefixesRequest,
                PublicDelegatedPrefixList,
                PublicDelegatedPrefix>
            context,
        ApiFuture<PublicDelegatedPrefixList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGlobalPublicDelegatedPrefixesRequest,
          PublicDelegatedPrefixList,
          PublicDelegatedPrefix,
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
