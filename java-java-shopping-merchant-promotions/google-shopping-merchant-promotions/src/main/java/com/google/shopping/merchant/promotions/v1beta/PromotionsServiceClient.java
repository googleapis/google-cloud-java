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

package com.google.shopping.merchant.promotions.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.shopping.merchant.promotions.v1beta.stub.PromotionsServiceStub;
import com.google.shopping.merchant.promotions.v1beta.stub.PromotionsServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to manage promotions for products.
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
 * try (PromotionsServiceClient promotionsServiceClient = PromotionsServiceClient.create()) {
 *   InsertPromotionRequest request =
 *       InsertPromotionRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setPromotion(Promotion.newBuilder().build())
 *           .setDataSource("dataSource1272470629")
 *           .build();
 *   Promotion response = promotionsServiceClient.insertPromotion(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PromotionsServiceClient object to clean up resources
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
 *      <td><p> InsertPromotion</td>
 *      <td><p> Inserts a promotion for your Merchant Center account. If the promotion already exists, then it updates the promotion instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertPromotion(InsertPromotionRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertPromotionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPromotion</td>
 *      <td><p> Retrieves the promotion from your Merchant Center account.
 * <p>  After inserting or updating a promotion input, it may take several minutes before the updated promotion can be retrieved.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPromotion(GetPromotionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPromotion(PromotionName name)
 *           <li><p> getPromotion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPromotionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPromotions</td>
 *      <td><p> Lists the promotions in your Merchant Center account. The response might contain fewer items than specified by `pageSize`. Rely on `pageToken` to determine if there are more items to be requested.
 * <p>  After inserting or updating a promotion, it may take several minutes before the updated processed promotion can be retrieved.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPromotions(ListPromotionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPromotions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPromotionsPagedCallable()
 *           <li><p> listPromotionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of PromotionsServiceSettings to
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
 * PromotionsServiceSettings promotionsServiceSettings =
 *     PromotionsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PromotionsServiceClient promotionsServiceClient =
 *     PromotionsServiceClient.create(promotionsServiceSettings);
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
 * PromotionsServiceSettings promotionsServiceSettings =
 *     PromotionsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PromotionsServiceClient promotionsServiceClient =
 *     PromotionsServiceClient.create(promotionsServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PromotionsServiceSettings promotionsServiceSettings =
 *     PromotionsServiceSettings.newHttpJsonBuilder().build();
 * PromotionsServiceClient promotionsServiceClient =
 *     PromotionsServiceClient.create(promotionsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PromotionsServiceClient implements BackgroundResource {
  private final PromotionsServiceSettings settings;
  private final PromotionsServiceStub stub;

  /** Constructs an instance of PromotionsServiceClient with default settings. */
  public static final PromotionsServiceClient create() throws IOException {
    return create(PromotionsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PromotionsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PromotionsServiceClient create(PromotionsServiceSettings settings)
      throws IOException {
    return new PromotionsServiceClient(settings);
  }

  /**
   * Constructs an instance of PromotionsServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(PromotionsServiceSettings).
   */
  public static final PromotionsServiceClient create(PromotionsServiceStub stub) {
    return new PromotionsServiceClient(stub);
  }

  /**
   * Constructs an instance of PromotionsServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PromotionsServiceClient(PromotionsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PromotionsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected PromotionsServiceClient(PromotionsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PromotionsServiceSettings getSettings() {
    return settings;
  }

  public PromotionsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a promotion for your Merchant Center account. If the promotion already exists, then it
   * updates the promotion instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PromotionsServiceClient promotionsServiceClient = PromotionsServiceClient.create()) {
   *   InsertPromotionRequest request =
   *       InsertPromotionRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPromotion(Promotion.newBuilder().build())
   *           .setDataSource("dataSource1272470629")
   *           .build();
   *   Promotion response = promotionsServiceClient.insertPromotion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Promotion insertPromotion(InsertPromotionRequest request) {
    return insertPromotionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a promotion for your Merchant Center account. If the promotion already exists, then it
   * updates the promotion instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PromotionsServiceClient promotionsServiceClient = PromotionsServiceClient.create()) {
   *   InsertPromotionRequest request =
   *       InsertPromotionRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPromotion(Promotion.newBuilder().build())
   *           .setDataSource("dataSource1272470629")
   *           .build();
   *   ApiFuture<Promotion> future =
   *       promotionsServiceClient.insertPromotionCallable().futureCall(request);
   *   // Do something.
   *   Promotion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertPromotionRequest, Promotion> insertPromotionCallable() {
    return stub.insertPromotionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the promotion from your Merchant Center account.
   *
   * <p>After inserting or updating a promotion input, it may take several minutes before the
   * updated promotion can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PromotionsServiceClient promotionsServiceClient = PromotionsServiceClient.create()) {
   *   PromotionName name = PromotionName.of("[ACCOUNT]", "[PROMOTION]");
   *   Promotion response = promotionsServiceClient.getPromotion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the promotion to retrieve. Format:
   *     `accounts/{account}/promotions/{promotions}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Promotion getPromotion(PromotionName name) {
    GetPromotionRequest request =
        GetPromotionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPromotion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the promotion from your Merchant Center account.
   *
   * <p>After inserting or updating a promotion input, it may take several minutes before the
   * updated promotion can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PromotionsServiceClient promotionsServiceClient = PromotionsServiceClient.create()) {
   *   String name = PromotionName.of("[ACCOUNT]", "[PROMOTION]").toString();
   *   Promotion response = promotionsServiceClient.getPromotion(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the promotion to retrieve. Format:
   *     `accounts/{account}/promotions/{promotions}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Promotion getPromotion(String name) {
    GetPromotionRequest request = GetPromotionRequest.newBuilder().setName(name).build();
    return getPromotion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the promotion from your Merchant Center account.
   *
   * <p>After inserting or updating a promotion input, it may take several minutes before the
   * updated promotion can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PromotionsServiceClient promotionsServiceClient = PromotionsServiceClient.create()) {
   *   GetPromotionRequest request =
   *       GetPromotionRequest.newBuilder()
   *           .setName(PromotionName.of("[ACCOUNT]", "[PROMOTION]").toString())
   *           .build();
   *   Promotion response = promotionsServiceClient.getPromotion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Promotion getPromotion(GetPromotionRequest request) {
    return getPromotionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the promotion from your Merchant Center account.
   *
   * <p>After inserting or updating a promotion input, it may take several minutes before the
   * updated promotion can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PromotionsServiceClient promotionsServiceClient = PromotionsServiceClient.create()) {
   *   GetPromotionRequest request =
   *       GetPromotionRequest.newBuilder()
   *           .setName(PromotionName.of("[ACCOUNT]", "[PROMOTION]").toString())
   *           .build();
   *   ApiFuture<Promotion> future =
   *       promotionsServiceClient.getPromotionCallable().futureCall(request);
   *   // Do something.
   *   Promotion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPromotionRequest, Promotion> getPromotionCallable() {
    return stub.getPromotionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the promotions in your Merchant Center account. The response might contain fewer items
   * than specified by `pageSize`. Rely on `pageToken` to determine if there are more items to be
   * requested.
   *
   * <p>After inserting or updating a promotion, it may take several minutes before the updated
   * processed promotion can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PromotionsServiceClient promotionsServiceClient = PromotionsServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   for (Promotion element : promotionsServiceClient.listPromotions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account to list processed promotions for. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPromotionsPagedResponse listPromotions(String parent) {
    ListPromotionsRequest request = ListPromotionsRequest.newBuilder().setParent(parent).build();
    return listPromotions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the promotions in your Merchant Center account. The response might contain fewer items
   * than specified by `pageSize`. Rely on `pageToken` to determine if there are more items to be
   * requested.
   *
   * <p>After inserting or updating a promotion, it may take several minutes before the updated
   * processed promotion can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PromotionsServiceClient promotionsServiceClient = PromotionsServiceClient.create()) {
   *   ListPromotionsRequest request =
   *       ListPromotionsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Promotion element : promotionsServiceClient.listPromotions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPromotionsPagedResponse listPromotions(ListPromotionsRequest request) {
    return listPromotionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the promotions in your Merchant Center account. The response might contain fewer items
   * than specified by `pageSize`. Rely on `pageToken` to determine if there are more items to be
   * requested.
   *
   * <p>After inserting or updating a promotion, it may take several minutes before the updated
   * processed promotion can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PromotionsServiceClient promotionsServiceClient = PromotionsServiceClient.create()) {
   *   ListPromotionsRequest request =
   *       ListPromotionsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Promotion> future =
   *       promotionsServiceClient.listPromotionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Promotion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPromotionsRequest, ListPromotionsPagedResponse>
      listPromotionsPagedCallable() {
    return stub.listPromotionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the promotions in your Merchant Center account. The response might contain fewer items
   * than specified by `pageSize`. Rely on `pageToken` to determine if there are more items to be
   * requested.
   *
   * <p>After inserting or updating a promotion, it may take several minutes before the updated
   * processed promotion can be retrieved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PromotionsServiceClient promotionsServiceClient = PromotionsServiceClient.create()) {
   *   ListPromotionsRequest request =
   *       ListPromotionsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPromotionsResponse response =
   *         promotionsServiceClient.listPromotionsCallable().call(request);
   *     for (Promotion element : response.getPromotionsList()) {
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
  public final UnaryCallable<ListPromotionsRequest, ListPromotionsResponse>
      listPromotionsCallable() {
    return stub.listPromotionsCallable();
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

  public static class ListPromotionsPagedResponse
      extends AbstractPagedListResponse<
          ListPromotionsRequest,
          ListPromotionsResponse,
          Promotion,
          ListPromotionsPage,
          ListPromotionsFixedSizeCollection> {

    public static ApiFuture<ListPromotionsPagedResponse> createAsync(
        PageContext<ListPromotionsRequest, ListPromotionsResponse, Promotion> context,
        ApiFuture<ListPromotionsResponse> futureResponse) {
      ApiFuture<ListPromotionsPage> futurePage =
          ListPromotionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPromotionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPromotionsPagedResponse(ListPromotionsPage page) {
      super(page, ListPromotionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPromotionsPage
      extends AbstractPage<
          ListPromotionsRequest, ListPromotionsResponse, Promotion, ListPromotionsPage> {

    private ListPromotionsPage(
        PageContext<ListPromotionsRequest, ListPromotionsResponse, Promotion> context,
        ListPromotionsResponse response) {
      super(context, response);
    }

    private static ListPromotionsPage createEmptyPage() {
      return new ListPromotionsPage(null, null);
    }

    @Override
    protected ListPromotionsPage createPage(
        PageContext<ListPromotionsRequest, ListPromotionsResponse, Promotion> context,
        ListPromotionsResponse response) {
      return new ListPromotionsPage(context, response);
    }

    @Override
    public ApiFuture<ListPromotionsPage> createPageAsync(
        PageContext<ListPromotionsRequest, ListPromotionsResponse, Promotion> context,
        ApiFuture<ListPromotionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPromotionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPromotionsRequest,
          ListPromotionsResponse,
          Promotion,
          ListPromotionsPage,
          ListPromotionsFixedSizeCollection> {

    private ListPromotionsFixedSizeCollection(List<ListPromotionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPromotionsFixedSizeCollection createEmptyCollection() {
      return new ListPromotionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPromotionsFixedSizeCollection createCollection(
        List<ListPromotionsPage> pages, int collectionSize) {
      return new ListPromotionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
