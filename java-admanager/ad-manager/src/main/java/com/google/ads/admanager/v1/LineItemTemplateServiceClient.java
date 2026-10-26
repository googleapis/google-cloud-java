/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.LineItemTemplateServiceStub;
import com.google.ads.admanager.v1.stub.LineItemTemplateServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `LineItemTemplate` objects.
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
 * try (LineItemTemplateServiceClient lineItemTemplateServiceClient =
 *     LineItemTemplateServiceClient.create()) {
 *   LineItemTemplateName name = LineItemTemplateName.of("[NETWORK_CODE]", "[LINE_ITEM_TEMPLATE]");
 *   LineItemTemplate response = lineItemTemplateServiceClient.getLineItemTemplate(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LineItemTemplateServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetLineItemTemplate</td>
 *      <td><p> Retrieves a `LineItemTemplate` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLineItemTemplate(GetLineItemTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLineItemTemplate(LineItemTemplateName name)
 *           <li><p> getLineItemTemplate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLineItemTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLineItemTemplates</td>
 *      <td><p> Lists `LineItemTemplate` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLineItemTemplates(ListLineItemTemplatesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLineItemTemplates(NetworkName parent)
 *           <li><p> listLineItemTemplates(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLineItemTemplatesPagedCallable()
 *           <li><p> listLineItemTemplatesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of
 * LineItemTemplateServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LineItemTemplateServiceSettings lineItemTemplateServiceSettings =
 *     LineItemTemplateServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LineItemTemplateServiceClient lineItemTemplateServiceClient =
 *     LineItemTemplateServiceClient.create(lineItemTemplateServiceSettings);
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
 * LineItemTemplateServiceSettings lineItemTemplateServiceSettings =
 *     LineItemTemplateServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LineItemTemplateServiceClient lineItemTemplateServiceClient =
 *     LineItemTemplateServiceClient.create(lineItemTemplateServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class LineItemTemplateServiceClient implements BackgroundResource {
  private final @Nullable LineItemTemplateServiceSettings settings;
  private final LineItemTemplateServiceStub stub;

  /** Constructs an instance of LineItemTemplateServiceClient with default settings. */
  public static final LineItemTemplateServiceClient create() throws IOException {
    return create(LineItemTemplateServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LineItemTemplateServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LineItemTemplateServiceClient create(LineItemTemplateServiceSettings settings)
      throws IOException {
    return new LineItemTemplateServiceClient(settings);
  }

  /**
   * Constructs an instance of LineItemTemplateServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(LineItemTemplateServiceSettings).
   */
  public static final LineItemTemplateServiceClient create(LineItemTemplateServiceStub stub) {
    return new LineItemTemplateServiceClient(stub);
  }

  /**
   * Constructs an instance of LineItemTemplateServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected LineItemTemplateServiceClient(LineItemTemplateServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((LineItemTemplateServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LineItemTemplateServiceClient(LineItemTemplateServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable LineItemTemplateServiceSettings getSettings() {
    return settings;
  }

  public LineItemTemplateServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `LineItemTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemTemplateServiceClient lineItemTemplateServiceClient =
   *     LineItemTemplateServiceClient.create()) {
   *   LineItemTemplateName name = LineItemTemplateName.of("[NETWORK_CODE]", "[LINE_ITEM_TEMPLATE]");
   *   LineItemTemplate response = lineItemTemplateServiceClient.getLineItemTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the LineItemTemplate. Format:
   *     `networks/{network_code}/lineItemTemplates/{line_item_template_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItemTemplate getLineItemTemplate(@Nullable LineItemTemplateName name) {
    GetLineItemTemplateRequest request =
        GetLineItemTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getLineItemTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `LineItemTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemTemplateServiceClient lineItemTemplateServiceClient =
   *     LineItemTemplateServiceClient.create()) {
   *   String name = LineItemTemplateName.of("[NETWORK_CODE]", "[LINE_ITEM_TEMPLATE]").toString();
   *   LineItemTemplate response = lineItemTemplateServiceClient.getLineItemTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the LineItemTemplate. Format:
   *     `networks/{network_code}/lineItemTemplates/{line_item_template_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItemTemplate getLineItemTemplate(String name) {
    GetLineItemTemplateRequest request =
        GetLineItemTemplateRequest.newBuilder().setName(name).build();
    return getLineItemTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `LineItemTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemTemplateServiceClient lineItemTemplateServiceClient =
   *     LineItemTemplateServiceClient.create()) {
   *   GetLineItemTemplateRequest request =
   *       GetLineItemTemplateRequest.newBuilder()
   *           .setName(LineItemTemplateName.of("[NETWORK_CODE]", "[LINE_ITEM_TEMPLATE]").toString())
   *           .build();
   *   LineItemTemplate response = lineItemTemplateServiceClient.getLineItemTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LineItemTemplate getLineItemTemplate(GetLineItemTemplateRequest request) {
    return getLineItemTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `LineItemTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemTemplateServiceClient lineItemTemplateServiceClient =
   *     LineItemTemplateServiceClient.create()) {
   *   GetLineItemTemplateRequest request =
   *       GetLineItemTemplateRequest.newBuilder()
   *           .setName(LineItemTemplateName.of("[NETWORK_CODE]", "[LINE_ITEM_TEMPLATE]").toString())
   *           .build();
   *   ApiFuture<LineItemTemplate> future =
   *       lineItemTemplateServiceClient.getLineItemTemplateCallable().futureCall(request);
   *   // Do something.
   *   LineItemTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLineItemTemplateRequest, LineItemTemplate>
      getLineItemTemplateCallable() {
    return stub.getLineItemTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LineItemTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemTemplateServiceClient lineItemTemplateServiceClient =
   *     LineItemTemplateServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (LineItemTemplate element :
   *       lineItemTemplateServiceClient.listLineItemTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of LineItemTemplates. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLineItemTemplatesPagedResponse listLineItemTemplates(
      @Nullable NetworkName parent) {
    ListLineItemTemplatesRequest request =
        ListLineItemTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLineItemTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LineItemTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemTemplateServiceClient lineItemTemplateServiceClient =
   *     LineItemTemplateServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (LineItemTemplate element :
   *       lineItemTemplateServiceClient.listLineItemTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of LineItemTemplates. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLineItemTemplatesPagedResponse listLineItemTemplates(String parent) {
    ListLineItemTemplatesRequest request =
        ListLineItemTemplatesRequest.newBuilder().setParent(parent).build();
    return listLineItemTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LineItemTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemTemplateServiceClient lineItemTemplateServiceClient =
   *     LineItemTemplateServiceClient.create()) {
   *   ListLineItemTemplatesRequest request =
   *       ListLineItemTemplatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (LineItemTemplate element :
   *       lineItemTemplateServiceClient.listLineItemTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLineItemTemplatesPagedResponse listLineItemTemplates(
      ListLineItemTemplatesRequest request) {
    return listLineItemTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LineItemTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemTemplateServiceClient lineItemTemplateServiceClient =
   *     LineItemTemplateServiceClient.create()) {
   *   ListLineItemTemplatesRequest request =
   *       ListLineItemTemplatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<LineItemTemplate> future =
   *       lineItemTemplateServiceClient.listLineItemTemplatesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LineItemTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLineItemTemplatesRequest, ListLineItemTemplatesPagedResponse>
      listLineItemTemplatesPagedCallable() {
    return stub.listLineItemTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LineItemTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LineItemTemplateServiceClient lineItemTemplateServiceClient =
   *     LineItemTemplateServiceClient.create()) {
   *   ListLineItemTemplatesRequest request =
   *       ListLineItemTemplatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListLineItemTemplatesResponse response =
   *         lineItemTemplateServiceClient.listLineItemTemplatesCallable().call(request);
   *     for (LineItemTemplate element : response.getLineItemTemplatesList()) {
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
  public final UnaryCallable<ListLineItemTemplatesRequest, ListLineItemTemplatesResponse>
      listLineItemTemplatesCallable() {
    return stub.listLineItemTemplatesCallable();
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

  public static class ListLineItemTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListLineItemTemplatesRequest,
          ListLineItemTemplatesResponse,
          LineItemTemplate,
          ListLineItemTemplatesPage,
          ListLineItemTemplatesFixedSizeCollection> {

    public static ApiFuture<ListLineItemTemplatesPagedResponse> createAsync(
        PageContext<ListLineItemTemplatesRequest, ListLineItemTemplatesResponse, LineItemTemplate>
            context,
        ApiFuture<ListLineItemTemplatesResponse> futureResponse) {
      ApiFuture<ListLineItemTemplatesPage> futurePage =
          ListLineItemTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLineItemTemplatesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLineItemTemplatesPagedResponse(ListLineItemTemplatesPage page) {
      super(page, ListLineItemTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLineItemTemplatesPage
      extends AbstractPage<
          ListLineItemTemplatesRequest,
          ListLineItemTemplatesResponse,
          LineItemTemplate,
          ListLineItemTemplatesPage> {

    private ListLineItemTemplatesPage(
        @Nullable
            PageContext<
                ListLineItemTemplatesRequest, ListLineItemTemplatesResponse, LineItemTemplate>
            context,
        @Nullable ListLineItemTemplatesResponse response) {
      super(context, response);
    }

    private static ListLineItemTemplatesPage createEmptyPage() {
      return new ListLineItemTemplatesPage(null, null);
    }

    @Override
    protected ListLineItemTemplatesPage createPage(
        @Nullable
            PageContext<
                ListLineItemTemplatesRequest, ListLineItemTemplatesResponse, LineItemTemplate>
            context,
        @Nullable ListLineItemTemplatesResponse response) {
      return new ListLineItemTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<ListLineItemTemplatesPage> createPageAsync(
        @Nullable
            PageContext<
                ListLineItemTemplatesRequest, ListLineItemTemplatesResponse, LineItemTemplate>
            context,
        ApiFuture<ListLineItemTemplatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLineItemTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLineItemTemplatesRequest,
          ListLineItemTemplatesResponse,
          LineItemTemplate,
          ListLineItemTemplatesPage,
          ListLineItemTemplatesFixedSizeCollection> {

    private ListLineItemTemplatesFixedSizeCollection(
        @Nullable List<ListLineItemTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLineItemTemplatesFixedSizeCollection createEmptyCollection() {
      return new ListLineItemTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLineItemTemplatesFixedSizeCollection createCollection(
        @Nullable List<ListLineItemTemplatesPage> pages, int collectionSize) {
      return new ListLineItemTemplatesFixedSizeCollection(pages, collectionSize);
    }
  }
}
