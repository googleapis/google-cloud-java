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

import com.google.ads.admanager.v1.stub.ThirdPartyCompanyServiceStub;
import com.google.ads.admanager.v1.stub.ThirdPartyCompanyServiceStubSettings;
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
 * Service Description: Service to retrieve and list recognized third-party companies in Google Ad
 * Manager.
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
 * try (ThirdPartyCompanyServiceClient thirdPartyCompanyServiceClient =
 *     ThirdPartyCompanyServiceClient.create()) {
 *   ThirdPartyCompanyName name =
 *       ThirdPartyCompanyName.of("[NETWORK_CODE]", "[THIRD_PARTY_COMPANY]");
 *   ThirdPartyCompany response = thirdPartyCompanyServiceClient.getThirdPartyCompany(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ThirdPartyCompanyServiceClient object to clean up
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
 *      <td><p> GetThirdPartyCompany</td>
 *      <td><p> Retrieves a `ThirdPartyCompany` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getThirdPartyCompany(GetThirdPartyCompanyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getThirdPartyCompany(ThirdPartyCompanyName name)
 *           <li><p> getThirdPartyCompany(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getThirdPartyCompanyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListThirdPartyCompanies</td>
 *      <td><p> Lists `ThirdPartyCompany` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listThirdPartyCompanies(ListThirdPartyCompaniesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listThirdPartyCompanies(NetworkName parent)
 *           <li><p> listThirdPartyCompanies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listThirdPartyCompaniesPagedCallable()
 *           <li><p> listThirdPartyCompaniesCallable()
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
 * ThirdPartyCompanyServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ThirdPartyCompanyServiceSettings thirdPartyCompanyServiceSettings =
 *     ThirdPartyCompanyServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ThirdPartyCompanyServiceClient thirdPartyCompanyServiceClient =
 *     ThirdPartyCompanyServiceClient.create(thirdPartyCompanyServiceSettings);
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
 * ThirdPartyCompanyServiceSettings thirdPartyCompanyServiceSettings =
 *     ThirdPartyCompanyServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ThirdPartyCompanyServiceClient thirdPartyCompanyServiceClient =
 *     ThirdPartyCompanyServiceClient.create(thirdPartyCompanyServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ThirdPartyCompanyServiceClient implements BackgroundResource {
  private final @Nullable ThirdPartyCompanyServiceSettings settings;
  private final ThirdPartyCompanyServiceStub stub;

  /** Constructs an instance of ThirdPartyCompanyServiceClient with default settings. */
  public static final ThirdPartyCompanyServiceClient create() throws IOException {
    return create(ThirdPartyCompanyServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ThirdPartyCompanyServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final ThirdPartyCompanyServiceClient create(
      ThirdPartyCompanyServiceSettings settings) throws IOException {
    return new ThirdPartyCompanyServiceClient(settings);
  }

  /**
   * Constructs an instance of ThirdPartyCompanyServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(ThirdPartyCompanyServiceSettings).
   */
  public static final ThirdPartyCompanyServiceClient create(ThirdPartyCompanyServiceStub stub) {
    return new ThirdPartyCompanyServiceClient(stub);
  }

  /**
   * Constructs an instance of ThirdPartyCompanyServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ThirdPartyCompanyServiceClient(ThirdPartyCompanyServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ThirdPartyCompanyServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ThirdPartyCompanyServiceClient(ThirdPartyCompanyServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable ThirdPartyCompanyServiceSettings getSettings() {
    return settings;
  }

  public ThirdPartyCompanyServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `ThirdPartyCompany` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ThirdPartyCompanyServiceClient thirdPartyCompanyServiceClient =
   *     ThirdPartyCompanyServiceClient.create()) {
   *   ThirdPartyCompanyName name =
   *       ThirdPartyCompanyName.of("[NETWORK_CODE]", "[THIRD_PARTY_COMPANY]");
   *   ThirdPartyCompany response = thirdPartyCompanyServiceClient.getThirdPartyCompany(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ThirdPartyCompany. Format:
   *     `networks/{network_code}/thirdPartyCompanies/{third_party_company_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ThirdPartyCompany getThirdPartyCompany(@Nullable ThirdPartyCompanyName name) {
    GetThirdPartyCompanyRequest request =
        GetThirdPartyCompanyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getThirdPartyCompany(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `ThirdPartyCompany` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ThirdPartyCompanyServiceClient thirdPartyCompanyServiceClient =
   *     ThirdPartyCompanyServiceClient.create()) {
   *   String name = ThirdPartyCompanyName.of("[NETWORK_CODE]", "[THIRD_PARTY_COMPANY]").toString();
   *   ThirdPartyCompany response = thirdPartyCompanyServiceClient.getThirdPartyCompany(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ThirdPartyCompany. Format:
   *     `networks/{network_code}/thirdPartyCompanies/{third_party_company_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ThirdPartyCompany getThirdPartyCompany(String name) {
    GetThirdPartyCompanyRequest request =
        GetThirdPartyCompanyRequest.newBuilder().setName(name).build();
    return getThirdPartyCompany(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `ThirdPartyCompany` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ThirdPartyCompanyServiceClient thirdPartyCompanyServiceClient =
   *     ThirdPartyCompanyServiceClient.create()) {
   *   GetThirdPartyCompanyRequest request =
   *       GetThirdPartyCompanyRequest.newBuilder()
   *           .setName(
   *               ThirdPartyCompanyName.of("[NETWORK_CODE]", "[THIRD_PARTY_COMPANY]").toString())
   *           .build();
   *   ThirdPartyCompany response = thirdPartyCompanyServiceClient.getThirdPartyCompany(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ThirdPartyCompany getThirdPartyCompany(GetThirdPartyCompanyRequest request) {
    return getThirdPartyCompanyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `ThirdPartyCompany` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ThirdPartyCompanyServiceClient thirdPartyCompanyServiceClient =
   *     ThirdPartyCompanyServiceClient.create()) {
   *   GetThirdPartyCompanyRequest request =
   *       GetThirdPartyCompanyRequest.newBuilder()
   *           .setName(
   *               ThirdPartyCompanyName.of("[NETWORK_CODE]", "[THIRD_PARTY_COMPANY]").toString())
   *           .build();
   *   ApiFuture<ThirdPartyCompany> future =
   *       thirdPartyCompanyServiceClient.getThirdPartyCompanyCallable().futureCall(request);
   *   // Do something.
   *   ThirdPartyCompany response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetThirdPartyCompanyRequest, ThirdPartyCompany>
      getThirdPartyCompanyCallable() {
    return stub.getThirdPartyCompanyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ThirdPartyCompany` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ThirdPartyCompanyServiceClient thirdPartyCompanyServiceClient =
   *     ThirdPartyCompanyServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (ThirdPartyCompany element :
   *       thirdPartyCompanyServiceClient.listThirdPartyCompanies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of ThirdPartyCompanies. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListThirdPartyCompaniesPagedResponse listThirdPartyCompanies(
      @Nullable NetworkName parent) {
    ListThirdPartyCompaniesRequest request =
        ListThirdPartyCompaniesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listThirdPartyCompanies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ThirdPartyCompany` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ThirdPartyCompanyServiceClient thirdPartyCompanyServiceClient =
   *     ThirdPartyCompanyServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (ThirdPartyCompany element :
   *       thirdPartyCompanyServiceClient.listThirdPartyCompanies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of ThirdPartyCompanies. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListThirdPartyCompaniesPagedResponse listThirdPartyCompanies(String parent) {
    ListThirdPartyCompaniesRequest request =
        ListThirdPartyCompaniesRequest.newBuilder().setParent(parent).build();
    return listThirdPartyCompanies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ThirdPartyCompany` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ThirdPartyCompanyServiceClient thirdPartyCompanyServiceClient =
   *     ThirdPartyCompanyServiceClient.create()) {
   *   ListThirdPartyCompaniesRequest request =
   *       ListThirdPartyCompaniesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (ThirdPartyCompany element :
   *       thirdPartyCompanyServiceClient.listThirdPartyCompanies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListThirdPartyCompaniesPagedResponse listThirdPartyCompanies(
      ListThirdPartyCompaniesRequest request) {
    return listThirdPartyCompaniesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ThirdPartyCompany` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ThirdPartyCompanyServiceClient thirdPartyCompanyServiceClient =
   *     ThirdPartyCompanyServiceClient.create()) {
   *   ListThirdPartyCompaniesRequest request =
   *       ListThirdPartyCompaniesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<ThirdPartyCompany> future =
   *       thirdPartyCompanyServiceClient.listThirdPartyCompaniesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ThirdPartyCompany element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListThirdPartyCompaniesRequest, ListThirdPartyCompaniesPagedResponse>
      listThirdPartyCompaniesPagedCallable() {
    return stub.listThirdPartyCompaniesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `ThirdPartyCompany` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ThirdPartyCompanyServiceClient thirdPartyCompanyServiceClient =
   *     ThirdPartyCompanyServiceClient.create()) {
   *   ListThirdPartyCompaniesRequest request =
   *       ListThirdPartyCompaniesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListThirdPartyCompaniesResponse response =
   *         thirdPartyCompanyServiceClient.listThirdPartyCompaniesCallable().call(request);
   *     for (ThirdPartyCompany element : response.getThirdPartyCompaniesList()) {
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
  public final UnaryCallable<ListThirdPartyCompaniesRequest, ListThirdPartyCompaniesResponse>
      listThirdPartyCompaniesCallable() {
    return stub.listThirdPartyCompaniesCallable();
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

  public static class ListThirdPartyCompaniesPagedResponse
      extends AbstractPagedListResponse<
          ListThirdPartyCompaniesRequest,
          ListThirdPartyCompaniesResponse,
          ThirdPartyCompany,
          ListThirdPartyCompaniesPage,
          ListThirdPartyCompaniesFixedSizeCollection> {

    public static ApiFuture<ListThirdPartyCompaniesPagedResponse> createAsync(
        PageContext<
                ListThirdPartyCompaniesRequest, ListThirdPartyCompaniesResponse, ThirdPartyCompany>
            context,
        ApiFuture<ListThirdPartyCompaniesResponse> futureResponse) {
      ApiFuture<ListThirdPartyCompaniesPage> futurePage =
          ListThirdPartyCompaniesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListThirdPartyCompaniesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListThirdPartyCompaniesPagedResponse(ListThirdPartyCompaniesPage page) {
      super(page, ListThirdPartyCompaniesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListThirdPartyCompaniesPage
      extends AbstractPage<
          ListThirdPartyCompaniesRequest,
          ListThirdPartyCompaniesResponse,
          ThirdPartyCompany,
          ListThirdPartyCompaniesPage> {

    private ListThirdPartyCompaniesPage(
        @Nullable
            PageContext<
                ListThirdPartyCompaniesRequest, ListThirdPartyCompaniesResponse, ThirdPartyCompany>
            context,
        @Nullable ListThirdPartyCompaniesResponse response) {
      super(context, response);
    }

    private static ListThirdPartyCompaniesPage createEmptyPage() {
      return new ListThirdPartyCompaniesPage(null, null);
    }

    @Override
    protected ListThirdPartyCompaniesPage createPage(
        @Nullable
            PageContext<
                ListThirdPartyCompaniesRequest, ListThirdPartyCompaniesResponse, ThirdPartyCompany>
            context,
        @Nullable ListThirdPartyCompaniesResponse response) {
      return new ListThirdPartyCompaniesPage(context, response);
    }

    @Override
    public ApiFuture<ListThirdPartyCompaniesPage> createPageAsync(
        @Nullable
            PageContext<
                ListThirdPartyCompaniesRequest, ListThirdPartyCompaniesResponse, ThirdPartyCompany>
            context,
        ApiFuture<ListThirdPartyCompaniesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListThirdPartyCompaniesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListThirdPartyCompaniesRequest,
          ListThirdPartyCompaniesResponse,
          ThirdPartyCompany,
          ListThirdPartyCompaniesPage,
          ListThirdPartyCompaniesFixedSizeCollection> {

    private ListThirdPartyCompaniesFixedSizeCollection(
        @Nullable List<ListThirdPartyCompaniesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListThirdPartyCompaniesFixedSizeCollection createEmptyCollection() {
      return new ListThirdPartyCompaniesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListThirdPartyCompaniesFixedSizeCollection createCollection(
        @Nullable List<ListThirdPartyCompaniesPage> pages, int collectionSize) {
      return new ListThirdPartyCompaniesFixedSizeCollection(pages, collectionSize);
    }
  }
}
