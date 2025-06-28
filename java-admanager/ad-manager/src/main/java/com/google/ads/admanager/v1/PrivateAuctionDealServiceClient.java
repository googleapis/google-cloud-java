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

import com.google.ads.admanager.v1.stub.PrivateAuctionDealServiceStub;
import com.google.ads.admanager.v1.stub.PrivateAuctionDealServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `PrivateAuctionDeal` objects.
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
 * try (PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
 *     PrivateAuctionDealServiceClient.create()) {
 *   PrivateAuctionDealName name =
 *       PrivateAuctionDealName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION_DEAL]");
 *   PrivateAuctionDeal response = privateAuctionDealServiceClient.getPrivateAuctionDeal(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PrivateAuctionDealServiceClient object to clean up
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
 *      <td><p> GetPrivateAuctionDeal</td>
 *      <td><p> API to retrieve a `PrivateAuctionDeal` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPrivateAuctionDeal(GetPrivateAuctionDealRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPrivateAuctionDeal(PrivateAuctionDealName name)
 *           <li><p> getPrivateAuctionDeal(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPrivateAuctionDealCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPrivateAuctionDeals</td>
 *      <td><p> API to retrieve a list of `PrivateAuctionDeal` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPrivateAuctionDeals(ListPrivateAuctionDealsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPrivateAuctionDeals(NetworkName parent)
 *           <li><p> listPrivateAuctionDeals(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPrivateAuctionDealsPagedCallable()
 *           <li><p> listPrivateAuctionDealsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePrivateAuctionDeal</td>
 *      <td><p> API to create a `PrivateAuctionDeal` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPrivateAuctionDeal(CreatePrivateAuctionDealRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createPrivateAuctionDeal(NetworkName parent, PrivateAuctionDeal privateAuctionDeal)
 *           <li><p> createPrivateAuctionDeal(String parent, PrivateAuctionDeal privateAuctionDeal)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPrivateAuctionDealCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePrivateAuctionDeal</td>
 *      <td><p> API to update a `PrivateAuctionDeal` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePrivateAuctionDeal(UpdatePrivateAuctionDealRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updatePrivateAuctionDeal(PrivateAuctionDeal privateAuctionDeal, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePrivateAuctionDealCallable()
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
 * PrivateAuctionDealServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PrivateAuctionDealServiceSettings privateAuctionDealServiceSettings =
 *     PrivateAuctionDealServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
 *     PrivateAuctionDealServiceClient.create(privateAuctionDealServiceSettings);
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
 * PrivateAuctionDealServiceSettings privateAuctionDealServiceSettings =
 *     PrivateAuctionDealServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
 *     PrivateAuctionDealServiceClient.create(privateAuctionDealServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class PrivateAuctionDealServiceClient implements BackgroundResource {
  private final PrivateAuctionDealServiceSettings settings;
  private final PrivateAuctionDealServiceStub stub;

  /** Constructs an instance of PrivateAuctionDealServiceClient with default settings. */
  public static final PrivateAuctionDealServiceClient create() throws IOException {
    return create(PrivateAuctionDealServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PrivateAuctionDealServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final PrivateAuctionDealServiceClient create(
      PrivateAuctionDealServiceSettings settings) throws IOException {
    return new PrivateAuctionDealServiceClient(settings);
  }

  /**
   * Constructs an instance of PrivateAuctionDealServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(PrivateAuctionDealServiceSettings).
   */
  public static final PrivateAuctionDealServiceClient create(PrivateAuctionDealServiceStub stub) {
    return new PrivateAuctionDealServiceClient(stub);
  }

  /**
   * Constructs an instance of PrivateAuctionDealServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected PrivateAuctionDealServiceClient(PrivateAuctionDealServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((PrivateAuctionDealServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected PrivateAuctionDealServiceClient(PrivateAuctionDealServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PrivateAuctionDealServiceSettings getSettings() {
    return settings;
  }

  public PrivateAuctionDealServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `PrivateAuctionDeal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
   *     PrivateAuctionDealServiceClient.create()) {
   *   PrivateAuctionDealName name =
   *       PrivateAuctionDealName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION_DEAL]");
   *   PrivateAuctionDeal response = privateAuctionDealServiceClient.getPrivateAuctionDeal(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the PrivateAuctionDeal. Format:
   *     `networks/{network_code}/privateAuctionDeals/{private_auction_deal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateAuctionDeal getPrivateAuctionDeal(PrivateAuctionDealName name) {
    GetPrivateAuctionDealRequest request =
        GetPrivateAuctionDealRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPrivateAuctionDeal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `PrivateAuctionDeal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
   *     PrivateAuctionDealServiceClient.create()) {
   *   String name =
   *       PrivateAuctionDealName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION_DEAL]").toString();
   *   PrivateAuctionDeal response = privateAuctionDealServiceClient.getPrivateAuctionDeal(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the PrivateAuctionDeal. Format:
   *     `networks/{network_code}/privateAuctionDeals/{private_auction_deal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateAuctionDeal getPrivateAuctionDeal(String name) {
    GetPrivateAuctionDealRequest request =
        GetPrivateAuctionDealRequest.newBuilder().setName(name).build();
    return getPrivateAuctionDeal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `PrivateAuctionDeal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
   *     PrivateAuctionDealServiceClient.create()) {
   *   GetPrivateAuctionDealRequest request =
   *       GetPrivateAuctionDealRequest.newBuilder()
   *           .setName(
   *               PrivateAuctionDealName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION_DEAL]").toString())
   *           .build();
   *   PrivateAuctionDeal response = privateAuctionDealServiceClient.getPrivateAuctionDeal(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateAuctionDeal getPrivateAuctionDeal(GetPrivateAuctionDealRequest request) {
    return getPrivateAuctionDealCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `PrivateAuctionDeal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
   *     PrivateAuctionDealServiceClient.create()) {
   *   GetPrivateAuctionDealRequest request =
   *       GetPrivateAuctionDealRequest.newBuilder()
   *           .setName(
   *               PrivateAuctionDealName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION_DEAL]").toString())
   *           .build();
   *   ApiFuture<PrivateAuctionDeal> future =
   *       privateAuctionDealServiceClient.getPrivateAuctionDealCallable().futureCall(request);
   *   // Do something.
   *   PrivateAuctionDeal response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPrivateAuctionDealRequest, PrivateAuctionDeal>
      getPrivateAuctionDealCallable() {
    return stub.getPrivateAuctionDealCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `PrivateAuctionDeal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
   *     PrivateAuctionDealServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (PrivateAuctionDeal element :
   *       privateAuctionDealServiceClient.listPrivateAuctionDeals(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of PrivateAuctionDeals. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateAuctionDealsPagedResponse listPrivateAuctionDeals(NetworkName parent) {
    ListPrivateAuctionDealsRequest request =
        ListPrivateAuctionDealsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPrivateAuctionDeals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `PrivateAuctionDeal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
   *     PrivateAuctionDealServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (PrivateAuctionDeal element :
   *       privateAuctionDealServiceClient.listPrivateAuctionDeals(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of PrivateAuctionDeals. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateAuctionDealsPagedResponse listPrivateAuctionDeals(String parent) {
    ListPrivateAuctionDealsRequest request =
        ListPrivateAuctionDealsRequest.newBuilder().setParent(parent).build();
    return listPrivateAuctionDeals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `PrivateAuctionDeal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
   *     PrivateAuctionDealServiceClient.create()) {
   *   ListPrivateAuctionDealsRequest request =
   *       ListPrivateAuctionDealsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (PrivateAuctionDeal element :
   *       privateAuctionDealServiceClient.listPrivateAuctionDeals(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateAuctionDealsPagedResponse listPrivateAuctionDeals(
      ListPrivateAuctionDealsRequest request) {
    return listPrivateAuctionDealsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `PrivateAuctionDeal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
   *     PrivateAuctionDealServiceClient.create()) {
   *   ListPrivateAuctionDealsRequest request =
   *       ListPrivateAuctionDealsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<PrivateAuctionDeal> future =
   *       privateAuctionDealServiceClient
   *           .listPrivateAuctionDealsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (PrivateAuctionDeal element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPrivateAuctionDealsRequest, ListPrivateAuctionDealsPagedResponse>
      listPrivateAuctionDealsPagedCallable() {
    return stub.listPrivateAuctionDealsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `PrivateAuctionDeal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
   *     PrivateAuctionDealServiceClient.create()) {
   *   ListPrivateAuctionDealsRequest request =
   *       ListPrivateAuctionDealsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListPrivateAuctionDealsResponse response =
   *         privateAuctionDealServiceClient.listPrivateAuctionDealsCallable().call(request);
   *     for (PrivateAuctionDeal element : response.getPrivateAuctionDealsList()) {
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
  public final UnaryCallable<ListPrivateAuctionDealsRequest, ListPrivateAuctionDealsResponse>
      listPrivateAuctionDealsCallable() {
    return stub.listPrivateAuctionDealsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `PrivateAuctionDeal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
   *     PrivateAuctionDealServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   PrivateAuctionDeal privateAuctionDeal = PrivateAuctionDeal.newBuilder().build();
   *   PrivateAuctionDeal response =
   *       privateAuctionDealServiceClient.createPrivateAuctionDeal(parent, privateAuctionDeal);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `PrivateAuctionDeal` will be created.
   *     Format: `networks/{network_code}`
   * @param privateAuctionDeal Required. The `PrivateAuctionDeal` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateAuctionDeal createPrivateAuctionDeal(
      NetworkName parent, PrivateAuctionDeal privateAuctionDeal) {
    CreatePrivateAuctionDealRequest request =
        CreatePrivateAuctionDealRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPrivateAuctionDeal(privateAuctionDeal)
            .build();
    return createPrivateAuctionDeal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `PrivateAuctionDeal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
   *     PrivateAuctionDealServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   PrivateAuctionDeal privateAuctionDeal = PrivateAuctionDeal.newBuilder().build();
   *   PrivateAuctionDeal response =
   *       privateAuctionDealServiceClient.createPrivateAuctionDeal(parent, privateAuctionDeal);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `PrivateAuctionDeal` will be created.
   *     Format: `networks/{network_code}`
   * @param privateAuctionDeal Required. The `PrivateAuctionDeal` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateAuctionDeal createPrivateAuctionDeal(
      String parent, PrivateAuctionDeal privateAuctionDeal) {
    CreatePrivateAuctionDealRequest request =
        CreatePrivateAuctionDealRequest.newBuilder()
            .setParent(parent)
            .setPrivateAuctionDeal(privateAuctionDeal)
            .build();
    return createPrivateAuctionDeal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `PrivateAuctionDeal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
   *     PrivateAuctionDealServiceClient.create()) {
   *   CreatePrivateAuctionDealRequest request =
   *       CreatePrivateAuctionDealRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPrivateAuctionDeal(PrivateAuctionDeal.newBuilder().build())
   *           .build();
   *   PrivateAuctionDeal response =
   *       privateAuctionDealServiceClient.createPrivateAuctionDeal(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateAuctionDeal createPrivateAuctionDeal(
      CreatePrivateAuctionDealRequest request) {
    return createPrivateAuctionDealCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `PrivateAuctionDeal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
   *     PrivateAuctionDealServiceClient.create()) {
   *   CreatePrivateAuctionDealRequest request =
   *       CreatePrivateAuctionDealRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPrivateAuctionDeal(PrivateAuctionDeal.newBuilder().build())
   *           .build();
   *   ApiFuture<PrivateAuctionDeal> future =
   *       privateAuctionDealServiceClient.createPrivateAuctionDealCallable().futureCall(request);
   *   // Do something.
   *   PrivateAuctionDeal response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePrivateAuctionDealRequest, PrivateAuctionDeal>
      createPrivateAuctionDealCallable() {
    return stub.createPrivateAuctionDealCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `PrivateAuctionDeal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
   *     PrivateAuctionDealServiceClient.create()) {
   *   PrivateAuctionDeal privateAuctionDeal = PrivateAuctionDeal.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PrivateAuctionDeal response =
   *       privateAuctionDealServiceClient.updatePrivateAuctionDeal(privateAuctionDeal, updateMask);
   * }
   * }</pre>
   *
   * @param privateAuctionDeal Required. The `PrivateAuctionDeal` to update.
   *     <p>The `PrivateAuctionDeal`'s `name` is used to identify the `PrivateAuctionDeal` to
   *     update.
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateAuctionDeal updatePrivateAuctionDeal(
      PrivateAuctionDeal privateAuctionDeal, FieldMask updateMask) {
    UpdatePrivateAuctionDealRequest request =
        UpdatePrivateAuctionDealRequest.newBuilder()
            .setPrivateAuctionDeal(privateAuctionDeal)
            .setUpdateMask(updateMask)
            .build();
    return updatePrivateAuctionDeal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `PrivateAuctionDeal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
   *     PrivateAuctionDealServiceClient.create()) {
   *   UpdatePrivateAuctionDealRequest request =
   *       UpdatePrivateAuctionDealRequest.newBuilder()
   *           .setPrivateAuctionDeal(PrivateAuctionDeal.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   PrivateAuctionDeal response =
   *       privateAuctionDealServiceClient.updatePrivateAuctionDeal(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateAuctionDeal updatePrivateAuctionDeal(
      UpdatePrivateAuctionDealRequest request) {
    return updatePrivateAuctionDealCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `PrivateAuctionDeal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionDealServiceClient privateAuctionDealServiceClient =
   *     PrivateAuctionDealServiceClient.create()) {
   *   UpdatePrivateAuctionDealRequest request =
   *       UpdatePrivateAuctionDealRequest.newBuilder()
   *           .setPrivateAuctionDeal(PrivateAuctionDeal.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<PrivateAuctionDeal> future =
   *       privateAuctionDealServiceClient.updatePrivateAuctionDealCallable().futureCall(request);
   *   // Do something.
   *   PrivateAuctionDeal response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePrivateAuctionDealRequest, PrivateAuctionDeal>
      updatePrivateAuctionDealCallable() {
    return stub.updatePrivateAuctionDealCallable();
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

  public static class ListPrivateAuctionDealsPagedResponse
      extends AbstractPagedListResponse<
          ListPrivateAuctionDealsRequest,
          ListPrivateAuctionDealsResponse,
          PrivateAuctionDeal,
          ListPrivateAuctionDealsPage,
          ListPrivateAuctionDealsFixedSizeCollection> {

    public static ApiFuture<ListPrivateAuctionDealsPagedResponse> createAsync(
        PageContext<
                ListPrivateAuctionDealsRequest, ListPrivateAuctionDealsResponse, PrivateAuctionDeal>
            context,
        ApiFuture<ListPrivateAuctionDealsResponse> futureResponse) {
      ApiFuture<ListPrivateAuctionDealsPage> futurePage =
          ListPrivateAuctionDealsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPrivateAuctionDealsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPrivateAuctionDealsPagedResponse(ListPrivateAuctionDealsPage page) {
      super(page, ListPrivateAuctionDealsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPrivateAuctionDealsPage
      extends AbstractPage<
          ListPrivateAuctionDealsRequest,
          ListPrivateAuctionDealsResponse,
          PrivateAuctionDeal,
          ListPrivateAuctionDealsPage> {

    private ListPrivateAuctionDealsPage(
        PageContext<
                ListPrivateAuctionDealsRequest, ListPrivateAuctionDealsResponse, PrivateAuctionDeal>
            context,
        ListPrivateAuctionDealsResponse response) {
      super(context, response);
    }

    private static ListPrivateAuctionDealsPage createEmptyPage() {
      return new ListPrivateAuctionDealsPage(null, null);
    }

    @Override
    protected ListPrivateAuctionDealsPage createPage(
        PageContext<
                ListPrivateAuctionDealsRequest, ListPrivateAuctionDealsResponse, PrivateAuctionDeal>
            context,
        ListPrivateAuctionDealsResponse response) {
      return new ListPrivateAuctionDealsPage(context, response);
    }

    @Override
    public ApiFuture<ListPrivateAuctionDealsPage> createPageAsync(
        PageContext<
                ListPrivateAuctionDealsRequest, ListPrivateAuctionDealsResponse, PrivateAuctionDeal>
            context,
        ApiFuture<ListPrivateAuctionDealsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPrivateAuctionDealsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPrivateAuctionDealsRequest,
          ListPrivateAuctionDealsResponse,
          PrivateAuctionDeal,
          ListPrivateAuctionDealsPage,
          ListPrivateAuctionDealsFixedSizeCollection> {

    private ListPrivateAuctionDealsFixedSizeCollection(
        List<ListPrivateAuctionDealsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPrivateAuctionDealsFixedSizeCollection createEmptyCollection() {
      return new ListPrivateAuctionDealsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPrivateAuctionDealsFixedSizeCollection createCollection(
        List<ListPrivateAuctionDealsPage> pages, int collectionSize) {
      return new ListPrivateAuctionDealsFixedSizeCollection(pages, collectionSize);
    }
  }
}
