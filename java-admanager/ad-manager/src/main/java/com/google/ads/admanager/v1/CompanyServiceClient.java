/*
 * Copyright 2024 Google LLC
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

import com.google.ads.admanager.v1.stub.CompanyServiceStub;
import com.google.ads.admanager.v1.stub.CompanyServiceStubSettings;
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
 * Service Description: Provides methods for handling `Company` objects.
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
 * try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
 *   CompanyName name = CompanyName.of("[NETWORK_CODE]", "[COMPANY]");
 *   Company response = companyServiceClient.getCompany(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CompanyServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetCompany</td>
 *      <td><p> API to retrieve a `Company` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCompany(GetCompanyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCompany(CompanyName name)
 *           <li><p> getCompany(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCompanyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCompanies</td>
 *      <td><p> API to retrieve a list of `Company` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCompanies(ListCompaniesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCompanies(NetworkName parent)
 *           <li><p> listCompanies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCompaniesPagedCallable()
 *           <li><p> listCompaniesCallable()
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
 * <p>This class can be customized by passing in a custom instance of CompanyServiceSettings to
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
 * CompanyServiceSettings companyServiceSettings =
 *     CompanyServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CompanyServiceClient companyServiceClient = CompanyServiceClient.create(companyServiceSettings);
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
 * CompanyServiceSettings companyServiceSettings =
 *     CompanyServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CompanyServiceClient companyServiceClient = CompanyServiceClient.create(companyServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CompanyServiceClient implements BackgroundResource {
  private final CompanyServiceSettings settings;
  private final CompanyServiceStub stub;

  /** Constructs an instance of CompanyServiceClient with default settings. */
  public static final CompanyServiceClient create() throws IOException {
    return create(CompanyServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CompanyServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CompanyServiceClient create(CompanyServiceSettings settings)
      throws IOException {
    return new CompanyServiceClient(settings);
  }

  /**
   * Constructs an instance of CompanyServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(CompanyServiceSettings).
   */
  public static final CompanyServiceClient create(CompanyServiceStub stub) {
    return new CompanyServiceClient(stub);
  }

  /**
   * Constructs an instance of CompanyServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CompanyServiceClient(CompanyServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CompanyServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CompanyServiceClient(CompanyServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CompanyServiceSettings getSettings() {
    return settings;
  }

  public CompanyServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Company` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
   *   CompanyName name = CompanyName.of("[NETWORK_CODE]", "[COMPANY]");
   *   Company response = companyServiceClient.getCompany(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Company. Format:
   *     `networks/{network_code}/companies/{company_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Company getCompany(CompanyName name) {
    GetCompanyRequest request =
        GetCompanyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCompany(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Company` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
   *   String name = CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString();
   *   Company response = companyServiceClient.getCompany(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Company. Format:
   *     `networks/{network_code}/companies/{company_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Company getCompany(String name) {
    GetCompanyRequest request = GetCompanyRequest.newBuilder().setName(name).build();
    return getCompany(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Company` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
   *   GetCompanyRequest request =
   *       GetCompanyRequest.newBuilder()
   *           .setName(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
   *           .build();
   *   Company response = companyServiceClient.getCompany(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Company getCompany(GetCompanyRequest request) {
    return getCompanyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Company` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
   *   GetCompanyRequest request =
   *       GetCompanyRequest.newBuilder()
   *           .setName(CompanyName.of("[NETWORK_CODE]", "[COMPANY]").toString())
   *           .build();
   *   ApiFuture<Company> future = companyServiceClient.getCompanyCallable().futureCall(request);
   *   // Do something.
   *   Company response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCompanyRequest, Company> getCompanyCallable() {
    return stub.getCompanyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Company` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (Company element : companyServiceClient.listCompanies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Companies. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCompaniesPagedResponse listCompanies(NetworkName parent) {
    ListCompaniesRequest request =
        ListCompaniesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCompanies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Company` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (Company element : companyServiceClient.listCompanies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Companies. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCompaniesPagedResponse listCompanies(String parent) {
    ListCompaniesRequest request = ListCompaniesRequest.newBuilder().setParent(parent).build();
    return listCompanies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Company` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
   *   ListCompaniesRequest request =
   *       ListCompaniesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (Company element : companyServiceClient.listCompanies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCompaniesPagedResponse listCompanies(ListCompaniesRequest request) {
    return listCompaniesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Company` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
   *   ListCompaniesRequest request =
   *       ListCompaniesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<Company> future =
   *       companyServiceClient.listCompaniesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Company element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCompaniesRequest, ListCompaniesPagedResponse>
      listCompaniesPagedCallable() {
    return stub.listCompaniesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Company` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
   *   ListCompaniesRequest request =
   *       ListCompaniesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListCompaniesResponse response = companyServiceClient.listCompaniesCallable().call(request);
   *     for (Company element : response.getCompaniesList()) {
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
  public final UnaryCallable<ListCompaniesRequest, ListCompaniesResponse> listCompaniesCallable() {
    return stub.listCompaniesCallable();
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

  public static class ListCompaniesPagedResponse
      extends AbstractPagedListResponse<
          ListCompaniesRequest,
          ListCompaniesResponse,
          Company,
          ListCompaniesPage,
          ListCompaniesFixedSizeCollection> {

    public static ApiFuture<ListCompaniesPagedResponse> createAsync(
        PageContext<ListCompaniesRequest, ListCompaniesResponse, Company> context,
        ApiFuture<ListCompaniesResponse> futureResponse) {
      ApiFuture<ListCompaniesPage> futurePage =
          ListCompaniesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCompaniesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCompaniesPagedResponse(ListCompaniesPage page) {
      super(page, ListCompaniesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCompaniesPage
      extends AbstractPage<
          ListCompaniesRequest, ListCompaniesResponse, Company, ListCompaniesPage> {

    private ListCompaniesPage(
        PageContext<ListCompaniesRequest, ListCompaniesResponse, Company> context,
        ListCompaniesResponse response) {
      super(context, response);
    }

    private static ListCompaniesPage createEmptyPage() {
      return new ListCompaniesPage(null, null);
    }

    @Override
    protected ListCompaniesPage createPage(
        PageContext<ListCompaniesRequest, ListCompaniesResponse, Company> context,
        ListCompaniesResponse response) {
      return new ListCompaniesPage(context, response);
    }

    @Override
    public ApiFuture<ListCompaniesPage> createPageAsync(
        PageContext<ListCompaniesRequest, ListCompaniesResponse, Company> context,
        ApiFuture<ListCompaniesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCompaniesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCompaniesRequest,
          ListCompaniesResponse,
          Company,
          ListCompaniesPage,
          ListCompaniesFixedSizeCollection> {

    private ListCompaniesFixedSizeCollection(List<ListCompaniesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCompaniesFixedSizeCollection createEmptyCollection() {
      return new ListCompaniesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCompaniesFixedSizeCollection createCollection(
        List<ListCompaniesPage> pages, int collectionSize) {
      return new ListCompaniesFixedSizeCollection(pages, collectionSize);
    }
  }
}
