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

import com.google.ads.admanager.v1.stub.AudienceSegmentCategoryServiceStub;
import com.google.ads.admanager.v1.stub.AudienceSegmentCategoryServiceStubSettings;
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
 * Service Description: Provides methods for handling `AudienceSegmentCategory` objects.
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
 * try (AudienceSegmentCategoryServiceClient audienceSegmentCategoryServiceClient =
 *     AudienceSegmentCategoryServiceClient.create()) {
 *   AudienceSegmentCategoryName name =
 *       AudienceSegmentCategoryName.of("[NETWORK_CODE]", "[AUDIENCE_SEGMENT_CATEGORY]");
 *   AudienceSegmentCategory response =
 *       audienceSegmentCategoryServiceClient.getAudienceSegmentCategory(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AudienceSegmentCategoryServiceClient object to clean
 * up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetAudienceSegmentCategory</td>
 *      <td><p> Retrieves a `AudienceSegmentCategory` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAudienceSegmentCategory(GetAudienceSegmentCategoryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAudienceSegmentCategory(AudienceSegmentCategoryName name)
 *           <li><p> getAudienceSegmentCategory(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAudienceSegmentCategoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAudienceSegmentCategories</td>
 *      <td><p> Lists `AudienceSegmentCategory` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAudienceSegmentCategories(ListAudienceSegmentCategoriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAudienceSegmentCategories(NetworkName parent)
 *           <li><p> listAudienceSegmentCategories(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAudienceSegmentCategoriesPagedCallable()
 *           <li><p> listAudienceSegmentCategoriesCallable()
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
 * AudienceSegmentCategoryServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AudienceSegmentCategoryServiceSettings audienceSegmentCategoryServiceSettings =
 *     AudienceSegmentCategoryServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AudienceSegmentCategoryServiceClient audienceSegmentCategoryServiceClient =
 *     AudienceSegmentCategoryServiceClient.create(audienceSegmentCategoryServiceSettings);
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
 * AudienceSegmentCategoryServiceSettings audienceSegmentCategoryServiceSettings =
 *     AudienceSegmentCategoryServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AudienceSegmentCategoryServiceClient audienceSegmentCategoryServiceClient =
 *     AudienceSegmentCategoryServiceClient.create(audienceSegmentCategoryServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class AudienceSegmentCategoryServiceClient implements BackgroundResource {
  private final @Nullable AudienceSegmentCategoryServiceSettings settings;
  private final AudienceSegmentCategoryServiceStub stub;

  /** Constructs an instance of AudienceSegmentCategoryServiceClient with default settings. */
  public static final AudienceSegmentCategoryServiceClient create() throws IOException {
    return create(AudienceSegmentCategoryServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AudienceSegmentCategoryServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final AudienceSegmentCategoryServiceClient create(
      AudienceSegmentCategoryServiceSettings settings) throws IOException {
    return new AudienceSegmentCategoryServiceClient(settings);
  }

  /**
   * Constructs an instance of AudienceSegmentCategoryServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using
   * create(AudienceSegmentCategoryServiceSettings).
   */
  public static final AudienceSegmentCategoryServiceClient create(
      AudienceSegmentCategoryServiceStub stub) {
    return new AudienceSegmentCategoryServiceClient(stub);
  }

  /**
   * Constructs an instance of AudienceSegmentCategoryServiceClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AudienceSegmentCategoryServiceClient(AudienceSegmentCategoryServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((AudienceSegmentCategoryServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AudienceSegmentCategoryServiceClient(AudienceSegmentCategoryServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable AudienceSegmentCategoryServiceSettings getSettings() {
    return settings;
  }

  public AudienceSegmentCategoryServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `AudienceSegmentCategory` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AudienceSegmentCategoryServiceClient audienceSegmentCategoryServiceClient =
   *     AudienceSegmentCategoryServiceClient.create()) {
   *   AudienceSegmentCategoryName name =
   *       AudienceSegmentCategoryName.of("[NETWORK_CODE]", "[AUDIENCE_SEGMENT_CATEGORY]");
   *   AudienceSegmentCategory response =
   *       audienceSegmentCategoryServiceClient.getAudienceSegmentCategory(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AudienceSegmentCategory. Format:
   *     `networks/{network_code}/audienceSegmentCategories/{audience_segment_category_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AudienceSegmentCategory getAudienceSegmentCategory(
      @Nullable AudienceSegmentCategoryName name) {
    GetAudienceSegmentCategoryRequest request =
        GetAudienceSegmentCategoryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAudienceSegmentCategory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `AudienceSegmentCategory` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AudienceSegmentCategoryServiceClient audienceSegmentCategoryServiceClient =
   *     AudienceSegmentCategoryServiceClient.create()) {
   *   String name =
   *       AudienceSegmentCategoryName.of("[NETWORK_CODE]", "[AUDIENCE_SEGMENT_CATEGORY]")
   *           .toString();
   *   AudienceSegmentCategory response =
   *       audienceSegmentCategoryServiceClient.getAudienceSegmentCategory(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AudienceSegmentCategory. Format:
   *     `networks/{network_code}/audienceSegmentCategories/{audience_segment_category_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AudienceSegmentCategory getAudienceSegmentCategory(String name) {
    GetAudienceSegmentCategoryRequest request =
        GetAudienceSegmentCategoryRequest.newBuilder().setName(name).build();
    return getAudienceSegmentCategory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `AudienceSegmentCategory` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AudienceSegmentCategoryServiceClient audienceSegmentCategoryServiceClient =
   *     AudienceSegmentCategoryServiceClient.create()) {
   *   GetAudienceSegmentCategoryRequest request =
   *       GetAudienceSegmentCategoryRequest.newBuilder()
   *           .setName(
   *               AudienceSegmentCategoryName.of("[NETWORK_CODE]", "[AUDIENCE_SEGMENT_CATEGORY]")
   *                   .toString())
   *           .build();
   *   AudienceSegmentCategory response =
   *       audienceSegmentCategoryServiceClient.getAudienceSegmentCategory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AudienceSegmentCategory getAudienceSegmentCategory(
      GetAudienceSegmentCategoryRequest request) {
    return getAudienceSegmentCategoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `AudienceSegmentCategory` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AudienceSegmentCategoryServiceClient audienceSegmentCategoryServiceClient =
   *     AudienceSegmentCategoryServiceClient.create()) {
   *   GetAudienceSegmentCategoryRequest request =
   *       GetAudienceSegmentCategoryRequest.newBuilder()
   *           .setName(
   *               AudienceSegmentCategoryName.of("[NETWORK_CODE]", "[AUDIENCE_SEGMENT_CATEGORY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AudienceSegmentCategory> future =
   *       audienceSegmentCategoryServiceClient
   *           .getAudienceSegmentCategoryCallable()
   *           .futureCall(request);
   *   // Do something.
   *   AudienceSegmentCategory response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAudienceSegmentCategoryRequest, AudienceSegmentCategory>
      getAudienceSegmentCategoryCallable() {
    return stub.getAudienceSegmentCategoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `AudienceSegmentCategory` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AudienceSegmentCategoryServiceClient audienceSegmentCategoryServiceClient =
   *     AudienceSegmentCategoryServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (AudienceSegmentCategory element :
   *       audienceSegmentCategoryServiceClient.listAudienceSegmentCategories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AudienceSegmentCategories.
   *     Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAudienceSegmentCategoriesPagedResponse listAudienceSegmentCategories(
      @Nullable NetworkName parent) {
    ListAudienceSegmentCategoriesRequest request =
        ListAudienceSegmentCategoriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAudienceSegmentCategories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `AudienceSegmentCategory` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AudienceSegmentCategoryServiceClient audienceSegmentCategoryServiceClient =
   *     AudienceSegmentCategoryServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (AudienceSegmentCategory element :
   *       audienceSegmentCategoryServiceClient.listAudienceSegmentCategories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AudienceSegmentCategories.
   *     Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAudienceSegmentCategoriesPagedResponse listAudienceSegmentCategories(
      String parent) {
    ListAudienceSegmentCategoriesRequest request =
        ListAudienceSegmentCategoriesRequest.newBuilder().setParent(parent).build();
    return listAudienceSegmentCategories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `AudienceSegmentCategory` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AudienceSegmentCategoryServiceClient audienceSegmentCategoryServiceClient =
   *     AudienceSegmentCategoryServiceClient.create()) {
   *   ListAudienceSegmentCategoriesRequest request =
   *       ListAudienceSegmentCategoriesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (AudienceSegmentCategory element :
   *       audienceSegmentCategoryServiceClient
   *           .listAudienceSegmentCategories(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAudienceSegmentCategoriesPagedResponse listAudienceSegmentCategories(
      ListAudienceSegmentCategoriesRequest request) {
    return listAudienceSegmentCategoriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `AudienceSegmentCategory` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AudienceSegmentCategoryServiceClient audienceSegmentCategoryServiceClient =
   *     AudienceSegmentCategoryServiceClient.create()) {
   *   ListAudienceSegmentCategoriesRequest request =
   *       ListAudienceSegmentCategoriesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<AudienceSegmentCategory> future =
   *       audienceSegmentCategoryServiceClient
   *           .listAudienceSegmentCategoriesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (AudienceSegmentCategory element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListAudienceSegmentCategoriesRequest, ListAudienceSegmentCategoriesPagedResponse>
      listAudienceSegmentCategoriesPagedCallable() {
    return stub.listAudienceSegmentCategoriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `AudienceSegmentCategory` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AudienceSegmentCategoryServiceClient audienceSegmentCategoryServiceClient =
   *     AudienceSegmentCategoryServiceClient.create()) {
   *   ListAudienceSegmentCategoriesRequest request =
   *       ListAudienceSegmentCategoriesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListAudienceSegmentCategoriesResponse response =
   *         audienceSegmentCategoryServiceClient
   *             .listAudienceSegmentCategoriesCallable()
   *             .call(request);
   *     for (AudienceSegmentCategory element : response.getAudienceSegmentCategoriesList()) {
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
  public final UnaryCallable<
          ListAudienceSegmentCategoriesRequest, ListAudienceSegmentCategoriesResponse>
      listAudienceSegmentCategoriesCallable() {
    return stub.listAudienceSegmentCategoriesCallable();
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

  public static class ListAudienceSegmentCategoriesPagedResponse
      extends AbstractPagedListResponse<
          ListAudienceSegmentCategoriesRequest,
          ListAudienceSegmentCategoriesResponse,
          AudienceSegmentCategory,
          ListAudienceSegmentCategoriesPage,
          ListAudienceSegmentCategoriesFixedSizeCollection> {

    public static ApiFuture<ListAudienceSegmentCategoriesPagedResponse> createAsync(
        PageContext<
                ListAudienceSegmentCategoriesRequest,
                ListAudienceSegmentCategoriesResponse,
                AudienceSegmentCategory>
            context,
        ApiFuture<ListAudienceSegmentCategoriesResponse> futureResponse) {
      ApiFuture<ListAudienceSegmentCategoriesPage> futurePage =
          ListAudienceSegmentCategoriesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAudienceSegmentCategoriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAudienceSegmentCategoriesPagedResponse(ListAudienceSegmentCategoriesPage page) {
      super(page, ListAudienceSegmentCategoriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAudienceSegmentCategoriesPage
      extends AbstractPage<
          ListAudienceSegmentCategoriesRequest,
          ListAudienceSegmentCategoriesResponse,
          AudienceSegmentCategory,
          ListAudienceSegmentCategoriesPage> {

    private ListAudienceSegmentCategoriesPage(
        @Nullable
            PageContext<
                ListAudienceSegmentCategoriesRequest,
                ListAudienceSegmentCategoriesResponse,
                AudienceSegmentCategory>
            context,
        @Nullable ListAudienceSegmentCategoriesResponse response) {
      super(context, response);
    }

    private static ListAudienceSegmentCategoriesPage createEmptyPage() {
      return new ListAudienceSegmentCategoriesPage(null, null);
    }

    @Override
    protected ListAudienceSegmentCategoriesPage createPage(
        @Nullable
            PageContext<
                ListAudienceSegmentCategoriesRequest,
                ListAudienceSegmentCategoriesResponse,
                AudienceSegmentCategory>
            context,
        @Nullable ListAudienceSegmentCategoriesResponse response) {
      return new ListAudienceSegmentCategoriesPage(context, response);
    }

    @Override
    public ApiFuture<ListAudienceSegmentCategoriesPage> createPageAsync(
        @Nullable
            PageContext<
                ListAudienceSegmentCategoriesRequest,
                ListAudienceSegmentCategoriesResponse,
                AudienceSegmentCategory>
            context,
        ApiFuture<ListAudienceSegmentCategoriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAudienceSegmentCategoriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAudienceSegmentCategoriesRequest,
          ListAudienceSegmentCategoriesResponse,
          AudienceSegmentCategory,
          ListAudienceSegmentCategoriesPage,
          ListAudienceSegmentCategoriesFixedSizeCollection> {

    private ListAudienceSegmentCategoriesFixedSizeCollection(
        @Nullable List<ListAudienceSegmentCategoriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAudienceSegmentCategoriesFixedSizeCollection createEmptyCollection() {
      return new ListAudienceSegmentCategoriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAudienceSegmentCategoriesFixedSizeCollection createCollection(
        @Nullable List<ListAudienceSegmentCategoriesPage> pages, int collectionSize) {
      return new ListAudienceSegmentCategoriesFixedSizeCollection(pages, collectionSize);
    }
  }
}
