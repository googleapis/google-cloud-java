/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.dialogflow.cx.v3beta1;

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
import com.google.cloud.dialogflow.cx.v3beta1.stub.PagesStub;
import com.google.cloud.dialogflow.cx.v3beta1.stub.PagesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing [Pages][google.cloud.dialogflow.cx.v3beta1.Page].
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the PagesClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of PagesSettings to create(). For
 * example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * PagesSettings pagesSettings =
 *     PagesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PagesClient pagesClient = PagesClient.create(pagesSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * PagesSettings pagesSettings = PagesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PagesClient pagesClient = PagesClient.create(pagesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PagesClient implements BackgroundResource {
  private final PagesSettings settings;
  private final PagesStub stub;

  /** Constructs an instance of PagesClient with default settings. */
  public static final PagesClient create() throws IOException {
    return create(PagesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PagesClient, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PagesClient create(PagesSettings settings) throws IOException {
    return new PagesClient(settings);
  }

  /**
   * Constructs an instance of PagesClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(PagesSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final PagesClient create(PagesStub stub) {
    return new PagesClient(stub);
  }

  /**
   * Constructs an instance of PagesClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected PagesClient(PagesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PagesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected PagesClient(PagesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PagesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public PagesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all pages in the specified flow.
   *
   * @param parent Required. The flow to list all pages for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/flows/&lt;Flow ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagesPagedResponse listPages(FlowName parent) {
    ListPagesRequest request =
        ListPagesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listPages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all pages in the specified flow.
   *
   * @param parent Required. The flow to list all pages for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/flows/&lt;Flow ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagesPagedResponse listPages(String parent) {
    ListPagesRequest request = ListPagesRequest.newBuilder().setParent(parent).build();
    return listPages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all pages in the specified flow.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagesPagedResponse listPages(ListPagesRequest request) {
    return listPagesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all pages in the specified flow.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListPagesRequest, ListPagesPagedResponse> listPagesPagedCallable() {
    return stub.listPagesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all pages in the specified flow.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListPagesRequest, ListPagesResponse> listPagesCallable() {
    return stub.listPagesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified page.
   *
   * @param name Required. The name of the page. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/flows/&lt;Flow
   *     ID&gt;/pages/&lt;Page ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Page getPage(PageName name) {
    GetPageRequest request =
        GetPageRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified page.
   *
   * @param name Required. The name of the page. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/flows/&lt;Flow
   *     ID&gt;/pages/&lt;Page ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Page getPage(String name) {
    GetPageRequest request = GetPageRequest.newBuilder().setName(name).build();
    return getPage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified page.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Page getPage(GetPageRequest request) {
    return getPageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified page.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetPageRequest, Page> getPageCallable() {
    return stub.getPageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a page in the specified flow.
   *
   * @param parent Required. The flow to create a page for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/flows/&lt;Flow ID&gt;`.
   * @param page Required. The page to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Page createPage(FlowName parent, Page page) {
    CreatePageRequest request =
        CreatePageRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPage(page)
            .build();
    return createPage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a page in the specified flow.
   *
   * @param parent Required. The flow to create a page for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/flows/&lt;Flow ID&gt;`.
   * @param page Required. The page to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Page createPage(String parent, Page page) {
    CreatePageRequest request =
        CreatePageRequest.newBuilder().setParent(parent).setPage(page).build();
    return createPage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a page in the specified flow.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Page createPage(CreatePageRequest request) {
    return createPageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a page in the specified flow.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreatePageRequest, Page> createPageCallable() {
    return stub.createPageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified page.
   *
   * @param page Required. The page to update.
   * @param updateMask The mask to control which fields get updated. If the mask is not present, all
   *     fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Page updatePage(Page page, FieldMask updateMask) {
    UpdatePageRequest request =
        UpdatePageRequest.newBuilder().setPage(page).setUpdateMask(updateMask).build();
    return updatePage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified page.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Page updatePage(UpdatePageRequest request) {
    return updatePageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified page.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdatePageRequest, Page> updatePageCallable() {
    return stub.updatePageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified page.
   *
   * @param name Required. The name of the page to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/Flows/&lt;flow
   *     ID&gt;/pages/&lt;Page ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePage(PageName name) {
    DeletePageRequest request =
        DeletePageRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deletePage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified page.
   *
   * @param name Required. The name of the page to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/Flows/&lt;flow
   *     ID&gt;/pages/&lt;Page ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePage(String name) {
    DeletePageRequest request = DeletePageRequest.newBuilder().setName(name).build();
    deletePage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified page.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePage(DeletePageRequest request) {
    deletePageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified page.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeletePageRequest, Empty> deletePageCallable() {
    return stub.deletePageCallable();
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

  public static class ListPagesPagedResponse
      extends AbstractPagedListResponse<
          ListPagesRequest, ListPagesResponse, Page, ListPagesPage, ListPagesFixedSizeCollection> {

    public static ApiFuture<ListPagesPagedResponse> createAsync(
        PageContext<ListPagesRequest, ListPagesResponse, Page> context,
        ApiFuture<ListPagesResponse> futureResponse) {
      ApiFuture<ListPagesPage> futurePage =
          ListPagesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListPagesPage, ListPagesPagedResponse>() {
            @Override
            public ListPagesPagedResponse apply(ListPagesPage input) {
              return new ListPagesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListPagesPagedResponse(ListPagesPage page) {
      super(page, ListPagesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPagesPage
      extends AbstractPage<ListPagesRequest, ListPagesResponse, Page, ListPagesPage> {

    private ListPagesPage(
        PageContext<ListPagesRequest, ListPagesResponse, Page> context,
        ListPagesResponse response) {
      super(context, response);
    }

    private static ListPagesPage createEmptyPage() {
      return new ListPagesPage(null, null);
    }

    @Override
    protected ListPagesPage createPage(
        PageContext<ListPagesRequest, ListPagesResponse, Page> context,
        ListPagesResponse response) {
      return new ListPagesPage(context, response);
    }

    @Override
    public ApiFuture<ListPagesPage> createPageAsync(
        PageContext<ListPagesRequest, ListPagesResponse, Page> context,
        ApiFuture<ListPagesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPagesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPagesRequest, ListPagesResponse, Page, ListPagesPage, ListPagesFixedSizeCollection> {

    private ListPagesFixedSizeCollection(List<ListPagesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPagesFixedSizeCollection createEmptyCollection() {
      return new ListPagesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPagesFixedSizeCollection createCollection(
        List<ListPagesPage> pages, int collectionSize) {
      return new ListPagesFixedSizeCollection(pages, collectionSize);
    }
  }
}
