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

import com.google.ads.admanager.v1.stub.PrivateAuctionServiceStub;
import com.google.ads.admanager.v1.stub.PrivateAuctionServiceStubSettings;
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
 * Service Description: Provides methods for handling `PrivateAuction` objects.
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
 * try (PrivateAuctionServiceClient privateAuctionServiceClient =
 *     PrivateAuctionServiceClient.create()) {
 *   PrivateAuctionName name = PrivateAuctionName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION]");
 *   PrivateAuction response = privateAuctionServiceClient.getPrivateAuction(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PrivateAuctionServiceClient object to clean up
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
 *      <td><p> GetPrivateAuction</td>
 *      <td><p> API to retrieve a `PrivateAuction` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPrivateAuction(GetPrivateAuctionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPrivateAuction(PrivateAuctionName name)
 *           <li><p> getPrivateAuction(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPrivateAuctionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPrivateAuctions</td>
 *      <td><p> API to retrieve a list of `PrivateAuction` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPrivateAuctions(ListPrivateAuctionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPrivateAuctions(NetworkName parent)
 *           <li><p> listPrivateAuctions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPrivateAuctionsPagedCallable()
 *           <li><p> listPrivateAuctionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePrivateAuction</td>
 *      <td><p> API to create a `PrivateAuction` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPrivateAuction(CreatePrivateAuctionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createPrivateAuction(NetworkName parent, PrivateAuction privateAuction)
 *           <li><p> createPrivateAuction(String parent, PrivateAuction privateAuction)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPrivateAuctionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePrivateAuction</td>
 *      <td><p> API to update a `PrivateAuction` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePrivateAuction(UpdatePrivateAuctionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updatePrivateAuction(PrivateAuction privateAuction, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePrivateAuctionCallable()
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
 * <p>This class can be customized by passing in a custom instance of PrivateAuctionServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PrivateAuctionServiceSettings privateAuctionServiceSettings =
 *     PrivateAuctionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PrivateAuctionServiceClient privateAuctionServiceClient =
 *     PrivateAuctionServiceClient.create(privateAuctionServiceSettings);
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
 * PrivateAuctionServiceSettings privateAuctionServiceSettings =
 *     PrivateAuctionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PrivateAuctionServiceClient privateAuctionServiceClient =
 *     PrivateAuctionServiceClient.create(privateAuctionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class PrivateAuctionServiceClient implements BackgroundResource {
  private final PrivateAuctionServiceSettings settings;
  private final PrivateAuctionServiceStub stub;

  /** Constructs an instance of PrivateAuctionServiceClient with default settings. */
  public static final PrivateAuctionServiceClient create() throws IOException {
    return create(PrivateAuctionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PrivateAuctionServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PrivateAuctionServiceClient create(PrivateAuctionServiceSettings settings)
      throws IOException {
    return new PrivateAuctionServiceClient(settings);
  }

  /**
   * Constructs an instance of PrivateAuctionServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(PrivateAuctionServiceSettings).
   */
  public static final PrivateAuctionServiceClient create(PrivateAuctionServiceStub stub) {
    return new PrivateAuctionServiceClient(stub);
  }

  /**
   * Constructs an instance of PrivateAuctionServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected PrivateAuctionServiceClient(PrivateAuctionServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PrivateAuctionServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected PrivateAuctionServiceClient(PrivateAuctionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PrivateAuctionServiceSettings getSettings() {
    return settings;
  }

  public PrivateAuctionServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `PrivateAuction` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionServiceClient privateAuctionServiceClient =
   *     PrivateAuctionServiceClient.create()) {
   *   PrivateAuctionName name = PrivateAuctionName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION]");
   *   PrivateAuction response = privateAuctionServiceClient.getPrivateAuction(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the PrivateAuction. Format:
   *     `networks/{network_code}/privateAuctions/{private_auction_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateAuction getPrivateAuction(PrivateAuctionName name) {
    GetPrivateAuctionRequest request =
        GetPrivateAuctionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPrivateAuction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `PrivateAuction` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionServiceClient privateAuctionServiceClient =
   *     PrivateAuctionServiceClient.create()) {
   *   String name = PrivateAuctionName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION]").toString();
   *   PrivateAuction response = privateAuctionServiceClient.getPrivateAuction(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the PrivateAuction. Format:
   *     `networks/{network_code}/privateAuctions/{private_auction_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateAuction getPrivateAuction(String name) {
    GetPrivateAuctionRequest request = GetPrivateAuctionRequest.newBuilder().setName(name).build();
    return getPrivateAuction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `PrivateAuction` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionServiceClient privateAuctionServiceClient =
   *     PrivateAuctionServiceClient.create()) {
   *   GetPrivateAuctionRequest request =
   *       GetPrivateAuctionRequest.newBuilder()
   *           .setName(PrivateAuctionName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION]").toString())
   *           .build();
   *   PrivateAuction response = privateAuctionServiceClient.getPrivateAuction(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateAuction getPrivateAuction(GetPrivateAuctionRequest request) {
    return getPrivateAuctionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `PrivateAuction` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionServiceClient privateAuctionServiceClient =
   *     PrivateAuctionServiceClient.create()) {
   *   GetPrivateAuctionRequest request =
   *       GetPrivateAuctionRequest.newBuilder()
   *           .setName(PrivateAuctionName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION]").toString())
   *           .build();
   *   ApiFuture<PrivateAuction> future =
   *       privateAuctionServiceClient.getPrivateAuctionCallable().futureCall(request);
   *   // Do something.
   *   PrivateAuction response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPrivateAuctionRequest, PrivateAuction> getPrivateAuctionCallable() {
    return stub.getPrivateAuctionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `PrivateAuction` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionServiceClient privateAuctionServiceClient =
   *     PrivateAuctionServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (PrivateAuction element :
   *       privateAuctionServiceClient.listPrivateAuctions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of PrivateAuctions. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateAuctionsPagedResponse listPrivateAuctions(NetworkName parent) {
    ListPrivateAuctionsRequest request =
        ListPrivateAuctionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPrivateAuctions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `PrivateAuction` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionServiceClient privateAuctionServiceClient =
   *     PrivateAuctionServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (PrivateAuction element :
   *       privateAuctionServiceClient.listPrivateAuctions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of PrivateAuctions. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateAuctionsPagedResponse listPrivateAuctions(String parent) {
    ListPrivateAuctionsRequest request =
        ListPrivateAuctionsRequest.newBuilder().setParent(parent).build();
    return listPrivateAuctions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `PrivateAuction` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionServiceClient privateAuctionServiceClient =
   *     PrivateAuctionServiceClient.create()) {
   *   ListPrivateAuctionsRequest request =
   *       ListPrivateAuctionsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (PrivateAuction element :
   *       privateAuctionServiceClient.listPrivateAuctions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPrivateAuctionsPagedResponse listPrivateAuctions(
      ListPrivateAuctionsRequest request) {
    return listPrivateAuctionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `PrivateAuction` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionServiceClient privateAuctionServiceClient =
   *     PrivateAuctionServiceClient.create()) {
   *   ListPrivateAuctionsRequest request =
   *       ListPrivateAuctionsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<PrivateAuction> future =
   *       privateAuctionServiceClient.listPrivateAuctionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PrivateAuction element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPrivateAuctionsRequest, ListPrivateAuctionsPagedResponse>
      listPrivateAuctionsPagedCallable() {
    return stub.listPrivateAuctionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `PrivateAuction` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionServiceClient privateAuctionServiceClient =
   *     PrivateAuctionServiceClient.create()) {
   *   ListPrivateAuctionsRequest request =
   *       ListPrivateAuctionsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListPrivateAuctionsResponse response =
   *         privateAuctionServiceClient.listPrivateAuctionsCallable().call(request);
   *     for (PrivateAuction element : response.getPrivateAuctionsList()) {
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
  public final UnaryCallable<ListPrivateAuctionsRequest, ListPrivateAuctionsResponse>
      listPrivateAuctionsCallable() {
    return stub.listPrivateAuctionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `PrivateAuction` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionServiceClient privateAuctionServiceClient =
   *     PrivateAuctionServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   PrivateAuction privateAuction = PrivateAuction.newBuilder().build();
   *   PrivateAuction response =
   *       privateAuctionServiceClient.createPrivateAuction(parent, privateAuction);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `PrivateAuction` will be created.
   *     Format: `networks/{network_code}`
   * @param privateAuction Required. The `PrivateAuction` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateAuction createPrivateAuction(
      NetworkName parent, PrivateAuction privateAuction) {
    CreatePrivateAuctionRequest request =
        CreatePrivateAuctionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPrivateAuction(privateAuction)
            .build();
    return createPrivateAuction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `PrivateAuction` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionServiceClient privateAuctionServiceClient =
   *     PrivateAuctionServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   PrivateAuction privateAuction = PrivateAuction.newBuilder().build();
   *   PrivateAuction response =
   *       privateAuctionServiceClient.createPrivateAuction(parent, privateAuction);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `PrivateAuction` will be created.
   *     Format: `networks/{network_code}`
   * @param privateAuction Required. The `PrivateAuction` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateAuction createPrivateAuction(String parent, PrivateAuction privateAuction) {
    CreatePrivateAuctionRequest request =
        CreatePrivateAuctionRequest.newBuilder()
            .setParent(parent)
            .setPrivateAuction(privateAuction)
            .build();
    return createPrivateAuction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `PrivateAuction` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionServiceClient privateAuctionServiceClient =
   *     PrivateAuctionServiceClient.create()) {
   *   CreatePrivateAuctionRequest request =
   *       CreatePrivateAuctionRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPrivateAuction(PrivateAuction.newBuilder().build())
   *           .build();
   *   PrivateAuction response = privateAuctionServiceClient.createPrivateAuction(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateAuction createPrivateAuction(CreatePrivateAuctionRequest request) {
    return createPrivateAuctionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `PrivateAuction` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionServiceClient privateAuctionServiceClient =
   *     PrivateAuctionServiceClient.create()) {
   *   CreatePrivateAuctionRequest request =
   *       CreatePrivateAuctionRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPrivateAuction(PrivateAuction.newBuilder().build())
   *           .build();
   *   ApiFuture<PrivateAuction> future =
   *       privateAuctionServiceClient.createPrivateAuctionCallable().futureCall(request);
   *   // Do something.
   *   PrivateAuction response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePrivateAuctionRequest, PrivateAuction>
      createPrivateAuctionCallable() {
    return stub.createPrivateAuctionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `PrivateAuction` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionServiceClient privateAuctionServiceClient =
   *     PrivateAuctionServiceClient.create()) {
   *   PrivateAuction privateAuction = PrivateAuction.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PrivateAuction response =
   *       privateAuctionServiceClient.updatePrivateAuction(privateAuction, updateMask);
   * }
   * }</pre>
   *
   * @param privateAuction Required. The `PrivateAuction` to update.
   *     <p>The `PrivateAuction`'s `name` is used to identify the `PrivateAuction` to update.
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateAuction updatePrivateAuction(
      PrivateAuction privateAuction, FieldMask updateMask) {
    UpdatePrivateAuctionRequest request =
        UpdatePrivateAuctionRequest.newBuilder()
            .setPrivateAuction(privateAuction)
            .setUpdateMask(updateMask)
            .build();
    return updatePrivateAuction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `PrivateAuction` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionServiceClient privateAuctionServiceClient =
   *     PrivateAuctionServiceClient.create()) {
   *   UpdatePrivateAuctionRequest request =
   *       UpdatePrivateAuctionRequest.newBuilder()
   *           .setPrivateAuction(PrivateAuction.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   PrivateAuction response = privateAuctionServiceClient.updatePrivateAuction(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PrivateAuction updatePrivateAuction(UpdatePrivateAuctionRequest request) {
    return updatePrivateAuctionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `PrivateAuction` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PrivateAuctionServiceClient privateAuctionServiceClient =
   *     PrivateAuctionServiceClient.create()) {
   *   UpdatePrivateAuctionRequest request =
   *       UpdatePrivateAuctionRequest.newBuilder()
   *           .setPrivateAuction(PrivateAuction.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<PrivateAuction> future =
   *       privateAuctionServiceClient.updatePrivateAuctionCallable().futureCall(request);
   *   // Do something.
   *   PrivateAuction response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePrivateAuctionRequest, PrivateAuction>
      updatePrivateAuctionCallable() {
    return stub.updatePrivateAuctionCallable();
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

  public static class ListPrivateAuctionsPagedResponse
      extends AbstractPagedListResponse<
          ListPrivateAuctionsRequest,
          ListPrivateAuctionsResponse,
          PrivateAuction,
          ListPrivateAuctionsPage,
          ListPrivateAuctionsFixedSizeCollection> {

    public static ApiFuture<ListPrivateAuctionsPagedResponse> createAsync(
        PageContext<ListPrivateAuctionsRequest, ListPrivateAuctionsResponse, PrivateAuction>
            context,
        ApiFuture<ListPrivateAuctionsResponse> futureResponse) {
      ApiFuture<ListPrivateAuctionsPage> futurePage =
          ListPrivateAuctionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPrivateAuctionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPrivateAuctionsPagedResponse(ListPrivateAuctionsPage page) {
      super(page, ListPrivateAuctionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPrivateAuctionsPage
      extends AbstractPage<
          ListPrivateAuctionsRequest,
          ListPrivateAuctionsResponse,
          PrivateAuction,
          ListPrivateAuctionsPage> {

    private ListPrivateAuctionsPage(
        PageContext<ListPrivateAuctionsRequest, ListPrivateAuctionsResponse, PrivateAuction>
            context,
        ListPrivateAuctionsResponse response) {
      super(context, response);
    }

    private static ListPrivateAuctionsPage createEmptyPage() {
      return new ListPrivateAuctionsPage(null, null);
    }

    @Override
    protected ListPrivateAuctionsPage createPage(
        PageContext<ListPrivateAuctionsRequest, ListPrivateAuctionsResponse, PrivateAuction>
            context,
        ListPrivateAuctionsResponse response) {
      return new ListPrivateAuctionsPage(context, response);
    }

    @Override
    public ApiFuture<ListPrivateAuctionsPage> createPageAsync(
        PageContext<ListPrivateAuctionsRequest, ListPrivateAuctionsResponse, PrivateAuction>
            context,
        ApiFuture<ListPrivateAuctionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPrivateAuctionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPrivateAuctionsRequest,
          ListPrivateAuctionsResponse,
          PrivateAuction,
          ListPrivateAuctionsPage,
          ListPrivateAuctionsFixedSizeCollection> {

    private ListPrivateAuctionsFixedSizeCollection(
        List<ListPrivateAuctionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPrivateAuctionsFixedSizeCollection createEmptyCollection() {
      return new ListPrivateAuctionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPrivateAuctionsFixedSizeCollection createCollection(
        List<ListPrivateAuctionsPage> pages, int collectionSize) {
      return new ListPrivateAuctionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
