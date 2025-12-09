/*
 * Copyright 2025 Google LLC
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

import com.google.ads.admanager.v1.stub.ContentLabelServiceStub;
import com.google.ads.admanager.v1.stub.ContentLabelServiceStubSettings;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `ContentLabel` objects.
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
 * try (ContentLabelServiceClient contentLabelServiceClient = ContentLabelServiceClient.create()) {
 *   ContentLabelName name = ContentLabelName.of("[NETWORK_CODE]", "[CONTENT_LABEL]");
 *   ContentLabel response = contentLabelServiceClient.getContentLabel(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ContentLabelServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetContentLabel</td>
 *      <td><p> API to retrieve a `ContentLabel` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getContentLabel(GetContentLabelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getContentLabel(ContentLabelName name)
 *           <li><p> getContentLabel(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getContentLabelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListContentLabels</td>
 *      <td><p> API to retrieve a list of `ContentLabel` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listContentLabels(ListContentLabelsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listContentLabels(NetworkName parent)
 *           <li><p> listContentLabels(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listContentLabelsPagedCallable()
 *           <li><p> listContentLabelsCallable()
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
 * <p>This class can be customized by passing in a custom instance of ContentLabelServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ContentLabelServiceSettings contentLabelServiceSettings =
 *     ContentLabelServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ContentLabelServiceClient contentLabelServiceClient =
 *     ContentLabelServiceClient.create(contentLabelServiceSettings);
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
 * ContentLabelServiceSettings contentLabelServiceSettings =
 *     ContentLabelServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ContentLabelServiceClient contentLabelServiceClient =
 *     ContentLabelServiceClient.create(contentLabelServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ContentLabelServiceClient implements BackgroundResource {
  private final ContentLabelServiceSettings settings;
  private final ContentLabelServiceStub stub;

  /** Constructs an instance of ContentLabelServiceClient with default settings. */
  public static final ContentLabelServiceClient create() throws IOException {
    return create(ContentLabelServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ContentLabelServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ContentLabelServiceClient create(ContentLabelServiceSettings settings)
      throws IOException {
    return new ContentLabelServiceClient(settings);
  }

  /**
   * Constructs an instance of ContentLabelServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ContentLabelServiceSettings).
   */
  public static final ContentLabelServiceClient create(ContentLabelServiceStub stub) {
    return new ContentLabelServiceClient(stub);
  }

  /**
   * Constructs an instance of ContentLabelServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ContentLabelServiceClient(ContentLabelServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ContentLabelServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ContentLabelServiceClient(ContentLabelServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ContentLabelServiceSettings getSettings() {
    return settings;
  }

  public ContentLabelServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `ContentLabel` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentLabelServiceClient contentLabelServiceClient = ContentLabelServiceClient.create()) {
   *   ContentLabelName name = ContentLabelName.of("[NETWORK_CODE]", "[CONTENT_LABEL]");
   *   ContentLabel response = contentLabelServiceClient.getContentLabel(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ContentLabel. Format:
   *     `networks/{network_code}/contentLabels/{content_label_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ContentLabel getContentLabel(ContentLabelName name) {
    GetContentLabelRequest request =
        GetContentLabelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getContentLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `ContentLabel` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentLabelServiceClient contentLabelServiceClient = ContentLabelServiceClient.create()) {
   *   String name = ContentLabelName.of("[NETWORK_CODE]", "[CONTENT_LABEL]").toString();
   *   ContentLabel response = contentLabelServiceClient.getContentLabel(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ContentLabel. Format:
   *     `networks/{network_code}/contentLabels/{content_label_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ContentLabel getContentLabel(String name) {
    GetContentLabelRequest request = GetContentLabelRequest.newBuilder().setName(name).build();
    return getContentLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `ContentLabel` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentLabelServiceClient contentLabelServiceClient = ContentLabelServiceClient.create()) {
   *   GetContentLabelRequest request =
   *       GetContentLabelRequest.newBuilder()
   *           .setName(ContentLabelName.of("[NETWORK_CODE]", "[CONTENT_LABEL]").toString())
   *           .build();
   *   ContentLabel response = contentLabelServiceClient.getContentLabel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ContentLabel getContentLabel(GetContentLabelRequest request) {
    return getContentLabelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `ContentLabel` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentLabelServiceClient contentLabelServiceClient = ContentLabelServiceClient.create()) {
   *   GetContentLabelRequest request =
   *       GetContentLabelRequest.newBuilder()
   *           .setName(ContentLabelName.of("[NETWORK_CODE]", "[CONTENT_LABEL]").toString())
   *           .build();
   *   ApiFuture<ContentLabel> future =
   *       contentLabelServiceClient.getContentLabelCallable().futureCall(request);
   *   // Do something.
   *   ContentLabel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetContentLabelRequest, ContentLabel> getContentLabelCallable() {
    return stub.getContentLabelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `ContentLabel` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentLabelServiceClient contentLabelServiceClient = ContentLabelServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (ContentLabel element :
   *       contentLabelServiceClient.listContentLabels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of ContentLabels. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContentLabelsPagedResponse listContentLabels(NetworkName parent) {
    ListContentLabelsRequest request =
        ListContentLabelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listContentLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `ContentLabel` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentLabelServiceClient contentLabelServiceClient = ContentLabelServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (ContentLabel element :
   *       contentLabelServiceClient.listContentLabels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of ContentLabels. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContentLabelsPagedResponse listContentLabels(String parent) {
    ListContentLabelsRequest request =
        ListContentLabelsRequest.newBuilder().setParent(parent).build();
    return listContentLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `ContentLabel` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentLabelServiceClient contentLabelServiceClient = ContentLabelServiceClient.create()) {
   *   ListContentLabelsRequest request =
   *       ListContentLabelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (ContentLabel element :
   *       contentLabelServiceClient.listContentLabels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContentLabelsPagedResponse listContentLabels(ListContentLabelsRequest request) {
    return listContentLabelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `ContentLabel` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentLabelServiceClient contentLabelServiceClient = ContentLabelServiceClient.create()) {
   *   ListContentLabelsRequest request =
   *       ListContentLabelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<ContentLabel> future =
   *       contentLabelServiceClient.listContentLabelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ContentLabel element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListContentLabelsRequest, ListContentLabelsPagedResponse>
      listContentLabelsPagedCallable() {
    return stub.listContentLabelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `ContentLabel` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContentLabelServiceClient contentLabelServiceClient = ContentLabelServiceClient.create()) {
   *   ListContentLabelsRequest request =
   *       ListContentLabelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListContentLabelsResponse response =
   *         contentLabelServiceClient.listContentLabelsCallable().call(request);
   *     for (ContentLabel element : response.getContentLabelsList()) {
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
  public final UnaryCallable<ListContentLabelsRequest, ListContentLabelsResponse>
      listContentLabelsCallable() {
    return stub.listContentLabelsCallable();
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

  public static class ListContentLabelsPagedResponse
      extends AbstractPagedListResponse<
          ListContentLabelsRequest,
          ListContentLabelsResponse,
          ContentLabel,
          ListContentLabelsPage,
          ListContentLabelsFixedSizeCollection> {

    public static ApiFuture<ListContentLabelsPagedResponse> createAsync(
        PageContext<ListContentLabelsRequest, ListContentLabelsResponse, ContentLabel> context,
        ApiFuture<ListContentLabelsResponse> futureResponse) {
      ApiFuture<ListContentLabelsPage> futurePage =
          ListContentLabelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListContentLabelsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListContentLabelsPagedResponse(ListContentLabelsPage page) {
      super(page, ListContentLabelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListContentLabelsPage
      extends AbstractPage<
          ListContentLabelsRequest,
          ListContentLabelsResponse,
          ContentLabel,
          ListContentLabelsPage> {

    private ListContentLabelsPage(
        PageContext<ListContentLabelsRequest, ListContentLabelsResponse, ContentLabel> context,
        ListContentLabelsResponse response) {
      super(context, response);
    }

    private static ListContentLabelsPage createEmptyPage() {
      return new ListContentLabelsPage(null, null);
    }

    @Override
    protected ListContentLabelsPage createPage(
        PageContext<ListContentLabelsRequest, ListContentLabelsResponse, ContentLabel> context,
        ListContentLabelsResponse response) {
      return new ListContentLabelsPage(context, response);
    }

    @Override
    public ApiFuture<ListContentLabelsPage> createPageAsync(
        PageContext<ListContentLabelsRequest, ListContentLabelsResponse, ContentLabel> context,
        ApiFuture<ListContentLabelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListContentLabelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListContentLabelsRequest,
          ListContentLabelsResponse,
          ContentLabel,
          ListContentLabelsPage,
          ListContentLabelsFixedSizeCollection> {

    private ListContentLabelsFixedSizeCollection(
        List<ListContentLabelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListContentLabelsFixedSizeCollection createEmptyCollection() {
      return new ListContentLabelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListContentLabelsFixedSizeCollection createCollection(
        List<ListContentLabelsPage> pages, int collectionSize) {
      return new ListContentLabelsFixedSizeCollection(pages, collectionSize);
    }
  }
}
