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

import com.google.ads.admanager.v1.stub.ProgrammaticBuyerServiceStub;
import com.google.ads.admanager.v1.stub.ProgrammaticBuyerServiceStubSettings;
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
 * Service Description: Provides methods for handling `ProgrammaticBuyer` objects.
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
 * try (ProgrammaticBuyerServiceClient programmaticBuyerServiceClient =
 *     ProgrammaticBuyerServiceClient.create()) {
 *   ProgrammaticBuyerName name =
 *       ProgrammaticBuyerName.of("[NETWORK_CODE]", "[PROGRAMMATIC_BUYER]");
 *   ProgrammaticBuyer response = programmaticBuyerServiceClient.getProgrammaticBuyer(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ProgrammaticBuyerServiceClient object to clean up
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
 *      <td><p> GetProgrammaticBuyer</td>
 *      <td><p> API to retrieve a `ProgrammaticBuyer` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getProgrammaticBuyer(GetProgrammaticBuyerRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getProgrammaticBuyer(ProgrammaticBuyerName name)
 *           <li><p> getProgrammaticBuyer(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getProgrammaticBuyerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListProgrammaticBuyers</td>
 *      <td><p> API to retrieve a list of `ProgrammaticBuyer` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listProgrammaticBuyers(ListProgrammaticBuyersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listProgrammaticBuyers(NetworkName parent)
 *           <li><p> listProgrammaticBuyers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listProgrammaticBuyersPagedCallable()
 *           <li><p> listProgrammaticBuyersCallable()
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
 * ProgrammaticBuyerServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ProgrammaticBuyerServiceSettings programmaticBuyerServiceSettings =
 *     ProgrammaticBuyerServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ProgrammaticBuyerServiceClient programmaticBuyerServiceClient =
 *     ProgrammaticBuyerServiceClient.create(programmaticBuyerServiceSettings);
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
 * ProgrammaticBuyerServiceSettings programmaticBuyerServiceSettings =
 *     ProgrammaticBuyerServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProgrammaticBuyerServiceClient programmaticBuyerServiceClient =
 *     ProgrammaticBuyerServiceClient.create(programmaticBuyerServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ProgrammaticBuyerServiceClient implements BackgroundResource {
  private final ProgrammaticBuyerServiceSettings settings;
  private final ProgrammaticBuyerServiceStub stub;

  /** Constructs an instance of ProgrammaticBuyerServiceClient with default settings. */
  public static final ProgrammaticBuyerServiceClient create() throws IOException {
    return create(ProgrammaticBuyerServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ProgrammaticBuyerServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final ProgrammaticBuyerServiceClient create(
      ProgrammaticBuyerServiceSettings settings) throws IOException {
    return new ProgrammaticBuyerServiceClient(settings);
  }

  /**
   * Constructs an instance of ProgrammaticBuyerServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(ProgrammaticBuyerServiceSettings).
   */
  public static final ProgrammaticBuyerServiceClient create(ProgrammaticBuyerServiceStub stub) {
    return new ProgrammaticBuyerServiceClient(stub);
  }

  /**
   * Constructs an instance of ProgrammaticBuyerServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ProgrammaticBuyerServiceClient(ProgrammaticBuyerServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ProgrammaticBuyerServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ProgrammaticBuyerServiceClient(ProgrammaticBuyerServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ProgrammaticBuyerServiceSettings getSettings() {
    return settings;
  }

  public ProgrammaticBuyerServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `ProgrammaticBuyer` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgrammaticBuyerServiceClient programmaticBuyerServiceClient =
   *     ProgrammaticBuyerServiceClient.create()) {
   *   ProgrammaticBuyerName name =
   *       ProgrammaticBuyerName.of("[NETWORK_CODE]", "[PROGRAMMATIC_BUYER]");
   *   ProgrammaticBuyer response = programmaticBuyerServiceClient.getProgrammaticBuyer(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ProgrammaticBuyer. Format:
   *     `networks/{network_code}/programmaticBuyers/{buyer_account_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProgrammaticBuyer getProgrammaticBuyer(ProgrammaticBuyerName name) {
    GetProgrammaticBuyerRequest request =
        GetProgrammaticBuyerRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getProgrammaticBuyer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `ProgrammaticBuyer` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgrammaticBuyerServiceClient programmaticBuyerServiceClient =
   *     ProgrammaticBuyerServiceClient.create()) {
   *   String name = ProgrammaticBuyerName.of("[NETWORK_CODE]", "[PROGRAMMATIC_BUYER]").toString();
   *   ProgrammaticBuyer response = programmaticBuyerServiceClient.getProgrammaticBuyer(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ProgrammaticBuyer. Format:
   *     `networks/{network_code}/programmaticBuyers/{buyer_account_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProgrammaticBuyer getProgrammaticBuyer(String name) {
    GetProgrammaticBuyerRequest request =
        GetProgrammaticBuyerRequest.newBuilder().setName(name).build();
    return getProgrammaticBuyer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `ProgrammaticBuyer` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgrammaticBuyerServiceClient programmaticBuyerServiceClient =
   *     ProgrammaticBuyerServiceClient.create()) {
   *   GetProgrammaticBuyerRequest request =
   *       GetProgrammaticBuyerRequest.newBuilder()
   *           .setName(
   *               ProgrammaticBuyerName.of("[NETWORK_CODE]", "[PROGRAMMATIC_BUYER]").toString())
   *           .build();
   *   ProgrammaticBuyer response = programmaticBuyerServiceClient.getProgrammaticBuyer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProgrammaticBuyer getProgrammaticBuyer(GetProgrammaticBuyerRequest request) {
    return getProgrammaticBuyerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `ProgrammaticBuyer` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgrammaticBuyerServiceClient programmaticBuyerServiceClient =
   *     ProgrammaticBuyerServiceClient.create()) {
   *   GetProgrammaticBuyerRequest request =
   *       GetProgrammaticBuyerRequest.newBuilder()
   *           .setName(
   *               ProgrammaticBuyerName.of("[NETWORK_CODE]", "[PROGRAMMATIC_BUYER]").toString())
   *           .build();
   *   ApiFuture<ProgrammaticBuyer> future =
   *       programmaticBuyerServiceClient.getProgrammaticBuyerCallable().futureCall(request);
   *   // Do something.
   *   ProgrammaticBuyer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProgrammaticBuyerRequest, ProgrammaticBuyer>
      getProgrammaticBuyerCallable() {
    return stub.getProgrammaticBuyerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `ProgrammaticBuyer` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgrammaticBuyerServiceClient programmaticBuyerServiceClient =
   *     ProgrammaticBuyerServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (ProgrammaticBuyer element :
   *       programmaticBuyerServiceClient.listProgrammaticBuyers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of ProgrammaticBuyers. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProgrammaticBuyersPagedResponse listProgrammaticBuyers(NetworkName parent) {
    ListProgrammaticBuyersRequest request =
        ListProgrammaticBuyersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProgrammaticBuyers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `ProgrammaticBuyer` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgrammaticBuyerServiceClient programmaticBuyerServiceClient =
   *     ProgrammaticBuyerServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (ProgrammaticBuyer element :
   *       programmaticBuyerServiceClient.listProgrammaticBuyers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of ProgrammaticBuyers. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProgrammaticBuyersPagedResponse listProgrammaticBuyers(String parent) {
    ListProgrammaticBuyersRequest request =
        ListProgrammaticBuyersRequest.newBuilder().setParent(parent).build();
    return listProgrammaticBuyers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `ProgrammaticBuyer` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgrammaticBuyerServiceClient programmaticBuyerServiceClient =
   *     ProgrammaticBuyerServiceClient.create()) {
   *   ListProgrammaticBuyersRequest request =
   *       ListProgrammaticBuyersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (ProgrammaticBuyer element :
   *       programmaticBuyerServiceClient.listProgrammaticBuyers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProgrammaticBuyersPagedResponse listProgrammaticBuyers(
      ListProgrammaticBuyersRequest request) {
    return listProgrammaticBuyersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `ProgrammaticBuyer` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgrammaticBuyerServiceClient programmaticBuyerServiceClient =
   *     ProgrammaticBuyerServiceClient.create()) {
   *   ListProgrammaticBuyersRequest request =
   *       ListProgrammaticBuyersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<ProgrammaticBuyer> future =
   *       programmaticBuyerServiceClient.listProgrammaticBuyersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ProgrammaticBuyer element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProgrammaticBuyersRequest, ListProgrammaticBuyersPagedResponse>
      listProgrammaticBuyersPagedCallable() {
    return stub.listProgrammaticBuyersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `ProgrammaticBuyer` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgrammaticBuyerServiceClient programmaticBuyerServiceClient =
   *     ProgrammaticBuyerServiceClient.create()) {
   *   ListProgrammaticBuyersRequest request =
   *       ListProgrammaticBuyersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListProgrammaticBuyersResponse response =
   *         programmaticBuyerServiceClient.listProgrammaticBuyersCallable().call(request);
   *     for (ProgrammaticBuyer element : response.getProgrammaticBuyersList()) {
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
  public final UnaryCallable<ListProgrammaticBuyersRequest, ListProgrammaticBuyersResponse>
      listProgrammaticBuyersCallable() {
    return stub.listProgrammaticBuyersCallable();
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

  public static class ListProgrammaticBuyersPagedResponse
      extends AbstractPagedListResponse<
          ListProgrammaticBuyersRequest,
          ListProgrammaticBuyersResponse,
          ProgrammaticBuyer,
          ListProgrammaticBuyersPage,
          ListProgrammaticBuyersFixedSizeCollection> {

    public static ApiFuture<ListProgrammaticBuyersPagedResponse> createAsync(
        PageContext<
                ListProgrammaticBuyersRequest, ListProgrammaticBuyersResponse, ProgrammaticBuyer>
            context,
        ApiFuture<ListProgrammaticBuyersResponse> futureResponse) {
      ApiFuture<ListProgrammaticBuyersPage> futurePage =
          ListProgrammaticBuyersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListProgrammaticBuyersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListProgrammaticBuyersPagedResponse(ListProgrammaticBuyersPage page) {
      super(page, ListProgrammaticBuyersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProgrammaticBuyersPage
      extends AbstractPage<
          ListProgrammaticBuyersRequest,
          ListProgrammaticBuyersResponse,
          ProgrammaticBuyer,
          ListProgrammaticBuyersPage> {

    private ListProgrammaticBuyersPage(
        PageContext<
                ListProgrammaticBuyersRequest, ListProgrammaticBuyersResponse, ProgrammaticBuyer>
            context,
        ListProgrammaticBuyersResponse response) {
      super(context, response);
    }

    private static ListProgrammaticBuyersPage createEmptyPage() {
      return new ListProgrammaticBuyersPage(null, null);
    }

    @Override
    protected ListProgrammaticBuyersPage createPage(
        PageContext<
                ListProgrammaticBuyersRequest, ListProgrammaticBuyersResponse, ProgrammaticBuyer>
            context,
        ListProgrammaticBuyersResponse response) {
      return new ListProgrammaticBuyersPage(context, response);
    }

    @Override
    public ApiFuture<ListProgrammaticBuyersPage> createPageAsync(
        PageContext<
                ListProgrammaticBuyersRequest, ListProgrammaticBuyersResponse, ProgrammaticBuyer>
            context,
        ApiFuture<ListProgrammaticBuyersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProgrammaticBuyersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProgrammaticBuyersRequest,
          ListProgrammaticBuyersResponse,
          ProgrammaticBuyer,
          ListProgrammaticBuyersPage,
          ListProgrammaticBuyersFixedSizeCollection> {

    private ListProgrammaticBuyersFixedSizeCollection(
        List<ListProgrammaticBuyersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProgrammaticBuyersFixedSizeCollection createEmptyCollection() {
      return new ListProgrammaticBuyersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProgrammaticBuyersFixedSizeCollection createCollection(
        List<ListProgrammaticBuyersPage> pages, int collectionSize) {
      return new ListProgrammaticBuyersFixedSizeCollection(pages, collectionSize);
    }
  }
}
