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
import com.google.cloud.compute.v1.stub.InterconnectsStub;
import com.google.cloud.compute.v1.stub.InterconnectsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The Interconnects API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
 *   String project = "";
 *   String interconnect = "";
 *   Operation response = interconnectsClient.delete(project, interconnect);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the interconnectsClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of InterconnectsSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * InterconnectsSettings interconnectsSettings =
 *     InterconnectsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InterconnectsClient interconnectsClient =
 *     InterconnectsClient.create(interconnectsSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * InterconnectsSettings interconnectsSettings =
 *     InterconnectsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InterconnectsClient interconnectsClient =
 *     InterconnectsClient.create(interconnectsSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InterconnectsClient implements BackgroundResource {
  private final InterconnectsSettings settings;
  private final InterconnectsStub stub;

  /** Constructs an instance of InterconnectsClient with default settings. */
  public static final InterconnectsClient create() throws IOException {
    return create(InterconnectsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InterconnectsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InterconnectsClient create(InterconnectsSettings settings)
      throws IOException {
    return new InterconnectsClient(settings);
  }

  /**
   * Constructs an instance of InterconnectsClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use InterconnectsSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final InterconnectsClient create(InterconnectsStub stub) {
    return new InterconnectsClient(stub);
  }

  /**
   * Constructs an instance of InterconnectsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected InterconnectsClient(InterconnectsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((InterconnectsStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected InterconnectsClient(InterconnectsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InterconnectsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public InterconnectsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified interconnect.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   String project = "";
   *   String interconnect = "";
   *   Operation response = interconnectsClient.delete(project, interconnect);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param interconnect Name of the interconnect to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String interconnect) {
    DeleteInterconnectRequest request =
        DeleteInterconnectRequest.newBuilder()
            .setProject(project)
            .setInterconnect(interconnect)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified interconnect.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   String interconnect = "";
   *   String project = "";
   *   DeleteInterconnectRequest request = DeleteInterconnectRequest.newBuilder()
   *     .setInterconnect(interconnect)
   *     .setProject(project)
   *     .build();
   *   Operation response = interconnectsClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteInterconnectRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified interconnect.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   String interconnect = "";
   *   String project = "";
   *   DeleteInterconnectRequest request = DeleteInterconnectRequest.newBuilder()
   *     .setInterconnect(interconnect)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = interconnectsClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteInterconnectRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified interconnect. Get a list of available interconnects by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   String project = "";
   *   String interconnect = "";
   *   Interconnect response = interconnectsClient.get(project, interconnect);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param interconnect Name of the interconnect to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Interconnect get(String project, String interconnect) {
    GetInterconnectRequest request =
        GetInterconnectRequest.newBuilder()
            .setProject(project)
            .setInterconnect(interconnect)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified interconnect. Get a list of available interconnects by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   String interconnect = "";
   *   String project = "";
   *   GetInterconnectRequest request = GetInterconnectRequest.newBuilder()
   *     .setInterconnect(interconnect)
   *     .setProject(project)
   *     .build();
   *   Interconnect response = interconnectsClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Interconnect get(GetInterconnectRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified interconnect. Get a list of available interconnects by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   String interconnect = "";
   *   String project = "";
   *   GetInterconnectRequest request = GetInterconnectRequest.newBuilder()
   *     .setInterconnect(interconnect)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Interconnect&gt; future = interconnectsClient.getCallable().futureCall(request);
   *   // Do something
   *   Interconnect response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetInterconnectRequest, Interconnect> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the interconnectDiagnostics for the specified interconnect.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   String project = "";
   *   String interconnect = "";
   *   InterconnectsGetDiagnosticsResponse response = interconnectsClient.getDiagnostics(project, interconnect);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param interconnect Name of the interconnect resource to query.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterconnectsGetDiagnosticsResponse getDiagnostics(
      String project, String interconnect) {
    GetDiagnosticsInterconnectRequest request =
        GetDiagnosticsInterconnectRequest.newBuilder()
            .setProject(project)
            .setInterconnect(interconnect)
            .build();
    return getDiagnostics(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the interconnectDiagnostics for the specified interconnect.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   String interconnect = "";
   *   String project = "";
   *   GetDiagnosticsInterconnectRequest request = GetDiagnosticsInterconnectRequest.newBuilder()
   *     .setInterconnect(interconnect)
   *     .setProject(project)
   *     .build();
   *   InterconnectsGetDiagnosticsResponse response = interconnectsClient.getDiagnostics(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InterconnectsGetDiagnosticsResponse getDiagnostics(
      GetDiagnosticsInterconnectRequest request) {
    return getDiagnosticsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the interconnectDiagnostics for the specified interconnect.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   String interconnect = "";
   *   String project = "";
   *   GetDiagnosticsInterconnectRequest request = GetDiagnosticsInterconnectRequest.newBuilder()
   *     .setInterconnect(interconnect)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;InterconnectsGetDiagnosticsResponse&gt; future = interconnectsClient.getDiagnosticsCallable().futureCall(request);
   *   // Do something
   *   InterconnectsGetDiagnosticsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetDiagnosticsInterconnectRequest, InterconnectsGetDiagnosticsResponse>
      getDiagnosticsCallable() {
    return stub.getDiagnosticsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Interconnect in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   String project = "";
   *   Interconnect interconnectResource = Interconnect.newBuilder().build();
   *   Operation response = interconnectsClient.insert(project, interconnectResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param interconnectResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, Interconnect interconnectResource) {
    InsertInterconnectRequest request =
        InsertInterconnectRequest.newBuilder()
            .setProject(project)
            .setInterconnectResource(interconnectResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Interconnect in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   Interconnect interconnectResource = Interconnect.newBuilder().build();
   *   String project = "";
   *   InsertInterconnectRequest request = InsertInterconnectRequest.newBuilder()
   *     .setInterconnectResource(interconnectResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = interconnectsClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertInterconnectRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a Interconnect in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   Interconnect interconnectResource = Interconnect.newBuilder().build();
   *   String project = "";
   *   InsertInterconnectRequest request = InsertInterconnectRequest.newBuilder()
   *     .setInterconnectResource(interconnectResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = interconnectsClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertInterconnectRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   String project = "";
   *   for (Interconnect element : interconnectsClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListInterconnectsRequest request =
        ListInterconnectsRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   String project = "";
   *   ListInterconnectsRequest request = ListInterconnectsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Interconnect element : interconnectsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListInterconnectsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   String project = "";
   *   ListInterconnectsRequest request = ListInterconnectsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = interconnectsClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (Interconnect element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListInterconnectsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of interconnect available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   String project = "";
   *   ListInterconnectsRequest request = ListInterconnectsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     InterconnectList response = interconnectsClient.listCallable().call(request);
   *     for (Interconnect element : response.getItemsList()) {
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
  public final UnaryCallable<ListInterconnectsRequest, InterconnectList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified interconnect with the data included in the request. This method supports
   * PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   String project = "";
   *   String interconnect = "";
   *   Interconnect interconnectResource = Interconnect.newBuilder().build();
   *   Operation response = interconnectsClient.patch(project, interconnect, interconnectResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param interconnect Name of the interconnect to update.
   * @param interconnectResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
      String project, String interconnect, Interconnect interconnectResource) {
    PatchInterconnectRequest request =
        PatchInterconnectRequest.newBuilder()
            .setProject(project)
            .setInterconnect(interconnect)
            .setInterconnectResource(interconnectResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified interconnect with the data included in the request. This method supports
   * PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   String interconnect = "";
   *   Interconnect interconnectResource = Interconnect.newBuilder().build();
   *   String project = "";
   *   PatchInterconnectRequest request = PatchInterconnectRequest.newBuilder()
   *     .setInterconnect(interconnect)
   *     .setInterconnectResource(interconnectResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = interconnectsClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchInterconnectRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified interconnect with the data included in the request. This method supports
   * PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InterconnectsClient interconnectsClient = InterconnectsClient.create()) {
   *   String interconnect = "";
   *   Interconnect interconnectResource = Interconnect.newBuilder().build();
   *   String project = "";
   *   PatchInterconnectRequest request = PatchInterconnectRequest.newBuilder()
   *     .setInterconnect(interconnect)
   *     .setInterconnectResource(interconnectResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = interconnectsClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchInterconnectRequest, Operation> patchCallable() {
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
          ListInterconnectsRequest,
          InterconnectList,
          Interconnect,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListInterconnectsRequest, InterconnectList, Interconnect> context,
        ApiFuture<InterconnectList> futureResponse) {
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
      extends AbstractPage<ListInterconnectsRequest, InterconnectList, Interconnect, ListPage> {

    private ListPage(
        PageContext<ListInterconnectsRequest, InterconnectList, Interconnect> context,
        InterconnectList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListInterconnectsRequest, InterconnectList, Interconnect> context,
        InterconnectList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListInterconnectsRequest, InterconnectList, Interconnect> context,
        ApiFuture<InterconnectList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInterconnectsRequest,
          InterconnectList,
          Interconnect,
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
