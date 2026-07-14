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

import com.google.ads.admanager.v1.stub.RichMediaAdsCompanyServiceStub;
import com.google.ads.admanager.v1.stub.RichMediaAdsCompanyServiceStubSettings;
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
 * Service Description: Provides methods for handling `RichMediaAdsCompany` objects.
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
 * try (RichMediaAdsCompanyServiceClient richMediaAdsCompanyServiceClient =
 *     RichMediaAdsCompanyServiceClient.create()) {
 *   RichMediaAdsCompanyName name =
 *       RichMediaAdsCompanyName.of("[NETWORK_CODE]", "[RICH_MEDIA_ADS_COMPANY]");
 *   RichMediaAdsCompany response = richMediaAdsCompanyServiceClient.getRichMediaAdsCompany(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RichMediaAdsCompanyServiceClient object to clean up
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
 *      <td><p> GetRichMediaAdsCompany</td>
 *      <td><p> API to retrieve a `RichMediaAdsCompany` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRichMediaAdsCompany(GetRichMediaAdsCompanyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRichMediaAdsCompany(RichMediaAdsCompanyName name)
 *           <li><p> getRichMediaAdsCompany(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRichMediaAdsCompanyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRichMediaAdsCompanies</td>
 *      <td><p> API to retrieve a list of `RichMediaAdsCompany` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRichMediaAdsCompanies(ListRichMediaAdsCompaniesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRichMediaAdsCompanies(NetworkName parent)
 *           <li><p> listRichMediaAdsCompanies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRichMediaAdsCompaniesPagedCallable()
 *           <li><p> listRichMediaAdsCompaniesCallable()
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
 * RichMediaAdsCompanyServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RichMediaAdsCompanyServiceSettings richMediaAdsCompanyServiceSettings =
 *     RichMediaAdsCompanyServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RichMediaAdsCompanyServiceClient richMediaAdsCompanyServiceClient =
 *     RichMediaAdsCompanyServiceClient.create(richMediaAdsCompanyServiceSettings);
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
 * RichMediaAdsCompanyServiceSettings richMediaAdsCompanyServiceSettings =
 *     RichMediaAdsCompanyServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RichMediaAdsCompanyServiceClient richMediaAdsCompanyServiceClient =
 *     RichMediaAdsCompanyServiceClient.create(richMediaAdsCompanyServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class RichMediaAdsCompanyServiceClient implements BackgroundResource {
  private final @Nullable RichMediaAdsCompanyServiceSettings settings;
  private final RichMediaAdsCompanyServiceStub stub;

  /** Constructs an instance of RichMediaAdsCompanyServiceClient with default settings. */
  public static final RichMediaAdsCompanyServiceClient create() throws IOException {
    return create(RichMediaAdsCompanyServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RichMediaAdsCompanyServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final RichMediaAdsCompanyServiceClient create(
      RichMediaAdsCompanyServiceSettings settings) throws IOException {
    return new RichMediaAdsCompanyServiceClient(settings);
  }

  /**
   * Constructs an instance of RichMediaAdsCompanyServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(RichMediaAdsCompanyServiceSettings).
   */
  public static final RichMediaAdsCompanyServiceClient create(RichMediaAdsCompanyServiceStub stub) {
    return new RichMediaAdsCompanyServiceClient(stub);
  }

  /**
   * Constructs an instance of RichMediaAdsCompanyServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RichMediaAdsCompanyServiceClient(RichMediaAdsCompanyServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RichMediaAdsCompanyServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected RichMediaAdsCompanyServiceClient(RichMediaAdsCompanyServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable RichMediaAdsCompanyServiceSettings getSettings() {
    return settings;
  }

  public RichMediaAdsCompanyServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `RichMediaAdsCompany` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RichMediaAdsCompanyServiceClient richMediaAdsCompanyServiceClient =
   *     RichMediaAdsCompanyServiceClient.create()) {
   *   RichMediaAdsCompanyName name =
   *       RichMediaAdsCompanyName.of("[NETWORK_CODE]", "[RICH_MEDIA_ADS_COMPANY]");
   *   RichMediaAdsCompany response = richMediaAdsCompanyServiceClient.getRichMediaAdsCompany(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the RichMediaAdsCompany. Format:
   *     `networks/{network_code}/richMediaAdsCompanies/{rich_media_ads_company_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RichMediaAdsCompany getRichMediaAdsCompany(@Nullable RichMediaAdsCompanyName name) {
    GetRichMediaAdsCompanyRequest request =
        GetRichMediaAdsCompanyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getRichMediaAdsCompany(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `RichMediaAdsCompany` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RichMediaAdsCompanyServiceClient richMediaAdsCompanyServiceClient =
   *     RichMediaAdsCompanyServiceClient.create()) {
   *   String name =
   *       RichMediaAdsCompanyName.of("[NETWORK_CODE]", "[RICH_MEDIA_ADS_COMPANY]").toString();
   *   RichMediaAdsCompany response = richMediaAdsCompanyServiceClient.getRichMediaAdsCompany(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the RichMediaAdsCompany. Format:
   *     `networks/{network_code}/richMediaAdsCompanies/{rich_media_ads_company_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RichMediaAdsCompany getRichMediaAdsCompany(String name) {
    GetRichMediaAdsCompanyRequest request =
        GetRichMediaAdsCompanyRequest.newBuilder().setName(name).build();
    return getRichMediaAdsCompany(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `RichMediaAdsCompany` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RichMediaAdsCompanyServiceClient richMediaAdsCompanyServiceClient =
   *     RichMediaAdsCompanyServiceClient.create()) {
   *   GetRichMediaAdsCompanyRequest request =
   *       GetRichMediaAdsCompanyRequest.newBuilder()
   *           .setName(
   *               RichMediaAdsCompanyName.of("[NETWORK_CODE]", "[RICH_MEDIA_ADS_COMPANY]")
   *                   .toString())
   *           .build();
   *   RichMediaAdsCompany response =
   *       richMediaAdsCompanyServiceClient.getRichMediaAdsCompany(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RichMediaAdsCompany getRichMediaAdsCompany(GetRichMediaAdsCompanyRequest request) {
    return getRichMediaAdsCompanyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `RichMediaAdsCompany` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RichMediaAdsCompanyServiceClient richMediaAdsCompanyServiceClient =
   *     RichMediaAdsCompanyServiceClient.create()) {
   *   GetRichMediaAdsCompanyRequest request =
   *       GetRichMediaAdsCompanyRequest.newBuilder()
   *           .setName(
   *               RichMediaAdsCompanyName.of("[NETWORK_CODE]", "[RICH_MEDIA_ADS_COMPANY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<RichMediaAdsCompany> future =
   *       richMediaAdsCompanyServiceClient.getRichMediaAdsCompanyCallable().futureCall(request);
   *   // Do something.
   *   RichMediaAdsCompany response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRichMediaAdsCompanyRequest, RichMediaAdsCompany>
      getRichMediaAdsCompanyCallable() {
    return stub.getRichMediaAdsCompanyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `RichMediaAdsCompany` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RichMediaAdsCompanyServiceClient richMediaAdsCompanyServiceClient =
   *     RichMediaAdsCompanyServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (RichMediaAdsCompany element :
   *       richMediaAdsCompanyServiceClient.listRichMediaAdsCompanies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of RichMediaAdsCompanies.
   *     Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRichMediaAdsCompaniesPagedResponse listRichMediaAdsCompanies(
      @Nullable NetworkName parent) {
    ListRichMediaAdsCompaniesRequest request =
        ListRichMediaAdsCompaniesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRichMediaAdsCompanies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `RichMediaAdsCompany` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RichMediaAdsCompanyServiceClient richMediaAdsCompanyServiceClient =
   *     RichMediaAdsCompanyServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (RichMediaAdsCompany element :
   *       richMediaAdsCompanyServiceClient.listRichMediaAdsCompanies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of RichMediaAdsCompanies.
   *     Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRichMediaAdsCompaniesPagedResponse listRichMediaAdsCompanies(String parent) {
    ListRichMediaAdsCompaniesRequest request =
        ListRichMediaAdsCompaniesRequest.newBuilder().setParent(parent).build();
    return listRichMediaAdsCompanies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `RichMediaAdsCompany` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RichMediaAdsCompanyServiceClient richMediaAdsCompanyServiceClient =
   *     RichMediaAdsCompanyServiceClient.create()) {
   *   ListRichMediaAdsCompaniesRequest request =
   *       ListRichMediaAdsCompaniesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (RichMediaAdsCompany element :
   *       richMediaAdsCompanyServiceClient.listRichMediaAdsCompanies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRichMediaAdsCompaniesPagedResponse listRichMediaAdsCompanies(
      ListRichMediaAdsCompaniesRequest request) {
    return listRichMediaAdsCompaniesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `RichMediaAdsCompany` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RichMediaAdsCompanyServiceClient richMediaAdsCompanyServiceClient =
   *     RichMediaAdsCompanyServiceClient.create()) {
   *   ListRichMediaAdsCompaniesRequest request =
   *       ListRichMediaAdsCompaniesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<RichMediaAdsCompany> future =
   *       richMediaAdsCompanyServiceClient
   *           .listRichMediaAdsCompaniesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (RichMediaAdsCompany element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListRichMediaAdsCompaniesRequest, ListRichMediaAdsCompaniesPagedResponse>
      listRichMediaAdsCompaniesPagedCallable() {
    return stub.listRichMediaAdsCompaniesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `RichMediaAdsCompany` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RichMediaAdsCompanyServiceClient richMediaAdsCompanyServiceClient =
   *     RichMediaAdsCompanyServiceClient.create()) {
   *   ListRichMediaAdsCompaniesRequest request =
   *       ListRichMediaAdsCompaniesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListRichMediaAdsCompaniesResponse response =
   *         richMediaAdsCompanyServiceClient.listRichMediaAdsCompaniesCallable().call(request);
   *     for (RichMediaAdsCompany element : response.getRichMediaAdsCompaniesList()) {
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
  public final UnaryCallable<ListRichMediaAdsCompaniesRequest, ListRichMediaAdsCompaniesResponse>
      listRichMediaAdsCompaniesCallable() {
    return stub.listRichMediaAdsCompaniesCallable();
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

  public static class ListRichMediaAdsCompaniesPagedResponse
      extends AbstractPagedListResponse<
          ListRichMediaAdsCompaniesRequest,
          ListRichMediaAdsCompaniesResponse,
          RichMediaAdsCompany,
          ListRichMediaAdsCompaniesPage,
          ListRichMediaAdsCompaniesFixedSizeCollection> {

    public static ApiFuture<ListRichMediaAdsCompaniesPagedResponse> createAsync(
        PageContext<
                ListRichMediaAdsCompaniesRequest,
                ListRichMediaAdsCompaniesResponse,
                RichMediaAdsCompany>
            context,
        ApiFuture<ListRichMediaAdsCompaniesResponse> futureResponse) {
      ApiFuture<ListRichMediaAdsCompaniesPage> futurePage =
          ListRichMediaAdsCompaniesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRichMediaAdsCompaniesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRichMediaAdsCompaniesPagedResponse(ListRichMediaAdsCompaniesPage page) {
      super(page, ListRichMediaAdsCompaniesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRichMediaAdsCompaniesPage
      extends AbstractPage<
          ListRichMediaAdsCompaniesRequest,
          ListRichMediaAdsCompaniesResponse,
          RichMediaAdsCompany,
          ListRichMediaAdsCompaniesPage> {

    private ListRichMediaAdsCompaniesPage(
        @Nullable
            PageContext<
                ListRichMediaAdsCompaniesRequest,
                ListRichMediaAdsCompaniesResponse,
                RichMediaAdsCompany>
            context,
        @Nullable ListRichMediaAdsCompaniesResponse response) {
      super(context, response);
    }

    private static ListRichMediaAdsCompaniesPage createEmptyPage() {
      return new ListRichMediaAdsCompaniesPage(null, null);
    }

    @Override
    protected ListRichMediaAdsCompaniesPage createPage(
        @Nullable
            PageContext<
                ListRichMediaAdsCompaniesRequest,
                ListRichMediaAdsCompaniesResponse,
                RichMediaAdsCompany>
            context,
        @Nullable ListRichMediaAdsCompaniesResponse response) {
      return new ListRichMediaAdsCompaniesPage(context, response);
    }

    @Override
    public ApiFuture<ListRichMediaAdsCompaniesPage> createPageAsync(
        @Nullable
            PageContext<
                ListRichMediaAdsCompaniesRequest,
                ListRichMediaAdsCompaniesResponse,
                RichMediaAdsCompany>
            context,
        ApiFuture<ListRichMediaAdsCompaniesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRichMediaAdsCompaniesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRichMediaAdsCompaniesRequest,
          ListRichMediaAdsCompaniesResponse,
          RichMediaAdsCompany,
          ListRichMediaAdsCompaniesPage,
          ListRichMediaAdsCompaniesFixedSizeCollection> {

    private ListRichMediaAdsCompaniesFixedSizeCollection(
        @Nullable List<ListRichMediaAdsCompaniesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRichMediaAdsCompaniesFixedSizeCollection createEmptyCollection() {
      return new ListRichMediaAdsCompaniesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRichMediaAdsCompaniesFixedSizeCollection createCollection(
        @Nullable List<ListRichMediaAdsCompaniesPage> pages, int collectionSize) {
      return new ListRichMediaAdsCompaniesFixedSizeCollection(pages, collectionSize);
    }
  }
}
