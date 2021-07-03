/*
 * Copyright 2021 Google LLC
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
import com.google.cloud.compute.v1.stub.PublicAdvertisedPrefixesStub;
import com.google.cloud.compute.v1.stub.PublicAdvertisedPrefixesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The PublicAdvertisedPrefixes API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
 *     PublicAdvertisedPrefixesClient.create()) {
 *   String project = "project-309310695";
 *   String publicAdvertisedPrefix = "publicAdvertisedPrefix1506440856";
 *   Operation response = publicAdvertisedPrefixesClient.delete(project, publicAdvertisedPrefix);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PublicAdvertisedPrefixesClient object to clean up
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
 * PublicAdvertisedPrefixesSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * PublicAdvertisedPrefixesSettings publicAdvertisedPrefixesSettings =
 *     PublicAdvertisedPrefixesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
 *     PublicAdvertisedPrefixesClient.create(publicAdvertisedPrefixesSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * PublicAdvertisedPrefixesSettings publicAdvertisedPrefixesSettings =
 *     PublicAdvertisedPrefixesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
 *     PublicAdvertisedPrefixesClient.create(publicAdvertisedPrefixesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class PublicAdvertisedPrefixesClient implements BackgroundResource {
  private final PublicAdvertisedPrefixesSettings settings;
  private final PublicAdvertisedPrefixesStub stub;

  /** Constructs an instance of PublicAdvertisedPrefixesClient with default settings. */
  public static final PublicAdvertisedPrefixesClient create() throws IOException {
    return create(PublicAdvertisedPrefixesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PublicAdvertisedPrefixesClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final PublicAdvertisedPrefixesClient create(
      PublicAdvertisedPrefixesSettings settings) throws IOException {
    return new PublicAdvertisedPrefixesClient(settings);
  }

  /**
   * Constructs an instance of PublicAdvertisedPrefixesClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(PublicAdvertisedPrefixesSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final PublicAdvertisedPrefixesClient create(PublicAdvertisedPrefixesStub stub) {
    return new PublicAdvertisedPrefixesClient(stub);
  }

  /**
   * Constructs an instance of PublicAdvertisedPrefixesClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected PublicAdvertisedPrefixesClient(PublicAdvertisedPrefixesSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((PublicAdvertisedPrefixesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected PublicAdvertisedPrefixesClient(PublicAdvertisedPrefixesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PublicAdvertisedPrefixesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public PublicAdvertisedPrefixesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified PublicAdvertisedPrefix
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
   *     PublicAdvertisedPrefixesClient.create()) {
   *   String project = "project-309310695";
   *   String publicAdvertisedPrefix = "publicAdvertisedPrefix1506440856";
   *   Operation response = publicAdvertisedPrefixesClient.delete(project, publicAdvertisedPrefix);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param publicAdvertisedPrefix Name of the PublicAdvertisedPrefix resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String publicAdvertisedPrefix) {
    DeletePublicAdvertisedPrefixeRequest request =
        DeletePublicAdvertisedPrefixeRequest.newBuilder()
            .setProject(project)
            .setPublicAdvertisedPrefix(publicAdvertisedPrefix)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified PublicAdvertisedPrefix
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
   *     PublicAdvertisedPrefixesClient.create()) {
   *   DeletePublicAdvertisedPrefixeRequest request =
   *       DeletePublicAdvertisedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicAdvertisedPrefix("publicAdvertisedPrefix1506440856")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = publicAdvertisedPrefixesClient.delete(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeletePublicAdvertisedPrefixeRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified PublicAdvertisedPrefix
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
   *     PublicAdvertisedPrefixesClient.create()) {
   *   DeletePublicAdvertisedPrefixeRequest request =
   *       DeletePublicAdvertisedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicAdvertisedPrefix("publicAdvertisedPrefix1506440856")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       publicAdvertisedPrefixesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePublicAdvertisedPrefixeRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified PublicAdvertisedPrefix resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
   *     PublicAdvertisedPrefixesClient.create()) {
   *   String project = "project-309310695";
   *   String publicAdvertisedPrefix = "publicAdvertisedPrefix1506440856";
   *   PublicAdvertisedPrefix response =
   *       publicAdvertisedPrefixesClient.get(project, publicAdvertisedPrefix);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param publicAdvertisedPrefix Name of the PublicAdvertisedPrefix resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublicAdvertisedPrefix get(String project, String publicAdvertisedPrefix) {
    GetPublicAdvertisedPrefixeRequest request =
        GetPublicAdvertisedPrefixeRequest.newBuilder()
            .setProject(project)
            .setPublicAdvertisedPrefix(publicAdvertisedPrefix)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified PublicAdvertisedPrefix resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
   *     PublicAdvertisedPrefixesClient.create()) {
   *   GetPublicAdvertisedPrefixeRequest request =
   *       GetPublicAdvertisedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicAdvertisedPrefix("publicAdvertisedPrefix1506440856")
   *           .build();
   *   PublicAdvertisedPrefix response = publicAdvertisedPrefixesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublicAdvertisedPrefix get(GetPublicAdvertisedPrefixeRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified PublicAdvertisedPrefix resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
   *     PublicAdvertisedPrefixesClient.create()) {
   *   GetPublicAdvertisedPrefixeRequest request =
   *       GetPublicAdvertisedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicAdvertisedPrefix("publicAdvertisedPrefix1506440856")
   *           .build();
   *   ApiFuture<PublicAdvertisedPrefix> future =
   *       publicAdvertisedPrefixesClient.getCallable().futureCall(request);
   *   // Do something.
   *   PublicAdvertisedPrefix response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPublicAdvertisedPrefixeRequest, PublicAdvertisedPrefix>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a PublicAdvertisedPrefix in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
   *     PublicAdvertisedPrefixesClient.create()) {
   *   String project = "project-309310695";
   *   PublicAdvertisedPrefix publicAdvertisedPrefixResource =
   *       PublicAdvertisedPrefix.newBuilder().build();
   *   Operation response =
   *       publicAdvertisedPrefixesClient.insert(project, publicAdvertisedPrefixResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param publicAdvertisedPrefixResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(
      String project, PublicAdvertisedPrefix publicAdvertisedPrefixResource) {
    InsertPublicAdvertisedPrefixeRequest request =
        InsertPublicAdvertisedPrefixeRequest.newBuilder()
            .setProject(project)
            .setPublicAdvertisedPrefixResource(publicAdvertisedPrefixResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a PublicAdvertisedPrefix in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
   *     PublicAdvertisedPrefixesClient.create()) {
   *   InsertPublicAdvertisedPrefixeRequest request =
   *       InsertPublicAdvertisedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicAdvertisedPrefixResource(PublicAdvertisedPrefix.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = publicAdvertisedPrefixesClient.insert(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertPublicAdvertisedPrefixeRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a PublicAdvertisedPrefix in the specified project using the parameters that are
   * included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
   *     PublicAdvertisedPrefixesClient.create()) {
   *   InsertPublicAdvertisedPrefixeRequest request =
   *       InsertPublicAdvertisedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicAdvertisedPrefixResource(PublicAdvertisedPrefix.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       publicAdvertisedPrefixesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertPublicAdvertisedPrefixeRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the PublicAdvertisedPrefixes for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
   *     PublicAdvertisedPrefixesClient.create()) {
   *   String project = "project-309310695";
   *   for (PublicAdvertisedPrefix element :
   *       publicAdvertisedPrefixesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListPublicAdvertisedPrefixesRequest request =
        ListPublicAdvertisedPrefixesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the PublicAdvertisedPrefixes for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
   *     PublicAdvertisedPrefixesClient.create()) {
   *   ListPublicAdvertisedPrefixesRequest request =
   *       ListPublicAdvertisedPrefixesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (PublicAdvertisedPrefix element :
   *       publicAdvertisedPrefixesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListPublicAdvertisedPrefixesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the PublicAdvertisedPrefixes for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
   *     PublicAdvertisedPrefixesClient.create()) {
   *   ListPublicAdvertisedPrefixesRequest request =
   *       ListPublicAdvertisedPrefixesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<PublicAdvertisedPrefix> future =
   *       publicAdvertisedPrefixesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PublicAdvertisedPrefix element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPublicAdvertisedPrefixesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the PublicAdvertisedPrefixes for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
   *     PublicAdvertisedPrefixesClient.create()) {
   *   ListPublicAdvertisedPrefixesRequest request =
   *       ListPublicAdvertisedPrefixesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     PublicAdvertisedPrefixList response =
   *         publicAdvertisedPrefixesClient.listCallable().call(request);
   *     for (PublicAdvertisedPrefix element : response.getResponsesList()) {
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
  public final UnaryCallable<ListPublicAdvertisedPrefixesRequest, PublicAdvertisedPrefixList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified Router resource with the data included in the request. This method
   * supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
   *     PublicAdvertisedPrefixesClient.create()) {
   *   String project = "project-309310695";
   *   String publicAdvertisedPrefix = "publicAdvertisedPrefix1506440856";
   *   PublicAdvertisedPrefix publicAdvertisedPrefixResource =
   *       PublicAdvertisedPrefix.newBuilder().build();
   *   Operation response =
   *       publicAdvertisedPrefixesClient.patch(
   *           project, publicAdvertisedPrefix, publicAdvertisedPrefixResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param publicAdvertisedPrefix Name of the PublicAdvertisedPrefix resource to patch.
   * @param publicAdvertisedPrefixResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(
      String project,
      String publicAdvertisedPrefix,
      PublicAdvertisedPrefix publicAdvertisedPrefixResource) {
    PatchPublicAdvertisedPrefixeRequest request =
        PatchPublicAdvertisedPrefixeRequest.newBuilder()
            .setProject(project)
            .setPublicAdvertisedPrefix(publicAdvertisedPrefix)
            .setPublicAdvertisedPrefixResource(publicAdvertisedPrefixResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified Router resource with the data included in the request. This method
   * supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
   *     PublicAdvertisedPrefixesClient.create()) {
   *   PatchPublicAdvertisedPrefixeRequest request =
   *       PatchPublicAdvertisedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicAdvertisedPrefix("publicAdvertisedPrefix1506440856")
   *           .setPublicAdvertisedPrefixResource(PublicAdvertisedPrefix.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = publicAdvertisedPrefixesClient.patch(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchPublicAdvertisedPrefixeRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the specified Router resource with the data included in the request. This method
   * supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PublicAdvertisedPrefixesClient publicAdvertisedPrefixesClient =
   *     PublicAdvertisedPrefixesClient.create()) {
   *   PatchPublicAdvertisedPrefixeRequest request =
   *       PatchPublicAdvertisedPrefixeRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setPublicAdvertisedPrefix("publicAdvertisedPrefix1506440856")
   *           .setPublicAdvertisedPrefixResource(PublicAdvertisedPrefix.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       publicAdvertisedPrefixesClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchPublicAdvertisedPrefixeRequest, Operation> patchCallable() {
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
          ListPublicAdvertisedPrefixesRequest,
          PublicAdvertisedPrefixList,
          PublicAdvertisedPrefix,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListPublicAdvertisedPrefixesRequest,
                PublicAdvertisedPrefixList,
                PublicAdvertisedPrefix>
            context,
        ApiFuture<PublicAdvertisedPrefixList> futureResponse) {
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
          ListPublicAdvertisedPrefixesRequest,
          PublicAdvertisedPrefixList,
          PublicAdvertisedPrefix,
          ListPage> {

    private ListPage(
        PageContext<
                ListPublicAdvertisedPrefixesRequest,
                PublicAdvertisedPrefixList,
                PublicAdvertisedPrefix>
            context,
        PublicAdvertisedPrefixList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListPublicAdvertisedPrefixesRequest,
                PublicAdvertisedPrefixList,
                PublicAdvertisedPrefix>
            context,
        PublicAdvertisedPrefixList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListPublicAdvertisedPrefixesRequest,
                PublicAdvertisedPrefixList,
                PublicAdvertisedPrefix>
            context,
        ApiFuture<PublicAdvertisedPrefixList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPublicAdvertisedPrefixesRequest,
          PublicAdvertisedPrefixList,
          PublicAdvertisedPrefix,
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
