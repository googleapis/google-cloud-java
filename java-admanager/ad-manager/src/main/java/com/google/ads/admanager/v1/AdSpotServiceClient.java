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

import com.google.ads.admanager.v1.stub.AdSpotServiceStub;
import com.google.ads.admanager.v1.stub.AdSpotServiceStubSettings;
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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `AdSpot` objects.
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
 * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
 *   AdSpotName name = AdSpotName.of("[NETWORK_CODE]", "[AD_SPOT]");
 *   AdSpot response = adSpotServiceClient.getAdSpot(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AdSpotServiceClient object to clean up resources such
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
 *      <td><p> GetAdSpot</td>
 *      <td><p> Retrieves an `AdSpot` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAdSpot(GetAdSpotRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAdSpot(AdSpotName name)
 *           <li><p> getAdSpot(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAdSpotCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAdSpots</td>
 *      <td><p> Lists `AdSpot` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAdSpots(ListAdSpotsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAdSpots(NetworkName parent)
 *           <li><p> listAdSpots(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAdSpotsPagedCallable()
 *           <li><p> listAdSpotsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAdSpot</td>
 *      <td><p> Creates an `AdSpot` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAdSpot(CreateAdSpotRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAdSpot(NetworkName parent, AdSpot adSpot)
 *           <li><p> createAdSpot(String parent, AdSpot adSpot)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAdSpotCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateAdSpots</td>
 *      <td><p> Batch creates `AdSpot` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateAdSpots(NetworkName parent, List&lt;CreateAdSpotRequest&gt; requests)
 *           <li><p> batchCreateAdSpots(String parent, List&lt;CreateAdSpotRequest&gt; requests)
 *           <li><p> batchCreateAdSpots(BatchCreateAdSpotsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateAdSpotsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAdSpot</td>
 *      <td><p> Updates an `AdSpot` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAdSpot(UpdateAdSpotRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAdSpot(AdSpot adSpot, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAdSpotCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateAdSpots</td>
 *      <td><p> Batch updates `AdSpot` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateAdSpots(NetworkName parent, List&lt;UpdateAdSpotRequest&gt; requests)
 *           <li><p> batchUpdateAdSpots(String parent, List&lt;UpdateAdSpotRequest&gt; requests)
 *           <li><p> batchUpdateAdSpots(BatchUpdateAdSpotsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateAdSpotsCallable()
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
 * <p>This class can be customized by passing in a custom instance of AdSpotServiceSettings to
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
 * AdSpotServiceSettings adSpotServiceSettings =
 *     AdSpotServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create(adSpotServiceSettings);
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
 * AdSpotServiceSettings adSpotServiceSettings =
 *     AdSpotServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create(adSpotServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class AdSpotServiceClient implements BackgroundResource {
  private final @Nullable AdSpotServiceSettings settings;
  private final AdSpotServiceStub stub;

  /** Constructs an instance of AdSpotServiceClient with default settings. */
  public static final AdSpotServiceClient create() throws IOException {
    return create(AdSpotServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AdSpotServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AdSpotServiceClient create(AdSpotServiceSettings settings)
      throws IOException {
    return new AdSpotServiceClient(settings);
  }

  /**
   * Constructs an instance of AdSpotServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(AdSpotServiceSettings).
   */
  public static final AdSpotServiceClient create(AdSpotServiceStub stub) {
    return new AdSpotServiceClient(stub);
  }

  /**
   * Constructs an instance of AdSpotServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AdSpotServiceClient(AdSpotServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AdSpotServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AdSpotServiceClient(AdSpotServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable AdSpotServiceSettings getSettings() {
    return settings;
  }

  public AdSpotServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an `AdSpot` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   AdSpotName name = AdSpotName.of("[NETWORK_CODE]", "[AD_SPOT]");
   *   AdSpot response = adSpotServiceClient.getAdSpot(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AdSpot. Format:
   *     `networks/{network_code}/adSpots/{ad_spot_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdSpot getAdSpot(@Nullable AdSpotName name) {
    GetAdSpotRequest request =
        GetAdSpotRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAdSpot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an `AdSpot` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   String name = AdSpotName.of("[NETWORK_CODE]", "[AD_SPOT]").toString();
   *   AdSpot response = adSpotServiceClient.getAdSpot(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AdSpot. Format:
   *     `networks/{network_code}/adSpots/{ad_spot_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdSpot getAdSpot(String name) {
    GetAdSpotRequest request = GetAdSpotRequest.newBuilder().setName(name).build();
    return getAdSpot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an `AdSpot` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   GetAdSpotRequest request =
   *       GetAdSpotRequest.newBuilder()
   *           .setName(AdSpotName.of("[NETWORK_CODE]", "[AD_SPOT]").toString())
   *           .build();
   *   AdSpot response = adSpotServiceClient.getAdSpot(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdSpot getAdSpot(GetAdSpotRequest request) {
    return getAdSpotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an `AdSpot` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   GetAdSpotRequest request =
   *       GetAdSpotRequest.newBuilder()
   *           .setName(AdSpotName.of("[NETWORK_CODE]", "[AD_SPOT]").toString())
   *           .build();
   *   ApiFuture<AdSpot> future = adSpotServiceClient.getAdSpotCallable().futureCall(request);
   *   // Do something.
   *   AdSpot response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAdSpotRequest, AdSpot> getAdSpotCallable() {
    return stub.getAdSpotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `AdSpot` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (AdSpot element : adSpotServiceClient.listAdSpots(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdSpots. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdSpotsPagedResponse listAdSpots(@Nullable NetworkName parent) {
    ListAdSpotsRequest request =
        ListAdSpotsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAdSpots(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `AdSpot` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (AdSpot element : adSpotServiceClient.listAdSpots(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdSpots. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdSpotsPagedResponse listAdSpots(String parent) {
    ListAdSpotsRequest request = ListAdSpotsRequest.newBuilder().setParent(parent).build();
    return listAdSpots(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `AdSpot` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   ListAdSpotsRequest request =
   *       ListAdSpotsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (AdSpot element : adSpotServiceClient.listAdSpots(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdSpotsPagedResponse listAdSpots(ListAdSpotsRequest request) {
    return listAdSpotsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `AdSpot` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   ListAdSpotsRequest request =
   *       ListAdSpotsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<AdSpot> future = adSpotServiceClient.listAdSpotsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AdSpot element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAdSpotsRequest, ListAdSpotsPagedResponse>
      listAdSpotsPagedCallable() {
    return stub.listAdSpotsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `AdSpot` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   ListAdSpotsRequest request =
   *       ListAdSpotsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListAdSpotsResponse response = adSpotServiceClient.listAdSpotsCallable().call(request);
   *     for (AdSpot element : response.getAdSpotsList()) {
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
  public final UnaryCallable<ListAdSpotsRequest, ListAdSpotsResponse> listAdSpotsCallable() {
    return stub.listAdSpotsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an `AdSpot` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   AdSpot adSpot = AdSpot.newBuilder().build();
   *   AdSpot response = adSpotServiceClient.createAdSpot(parent, adSpot);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `AdSpot` will be created. Format:
   *     `networks/{network_code}`
   * @param adSpot Required. The `AdSpot` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdSpot createAdSpot(@Nullable NetworkName parent, AdSpot adSpot) {
    CreateAdSpotRequest request =
        CreateAdSpotRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAdSpot(adSpot)
            .build();
    return createAdSpot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an `AdSpot` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   AdSpot adSpot = AdSpot.newBuilder().build();
   *   AdSpot response = adSpotServiceClient.createAdSpot(parent, adSpot);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `AdSpot` will be created. Format:
   *     `networks/{network_code}`
   * @param adSpot Required. The `AdSpot` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdSpot createAdSpot(String parent, AdSpot adSpot) {
    CreateAdSpotRequest request =
        CreateAdSpotRequest.newBuilder().setParent(parent).setAdSpot(adSpot).build();
    return createAdSpot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an `AdSpot` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   CreateAdSpotRequest request =
   *       CreateAdSpotRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setAdSpot(AdSpot.newBuilder().build())
   *           .build();
   *   AdSpot response = adSpotServiceClient.createAdSpot(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdSpot createAdSpot(CreateAdSpotRequest request) {
    return createAdSpotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an `AdSpot` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   CreateAdSpotRequest request =
   *       CreateAdSpotRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setAdSpot(AdSpot.newBuilder().build())
   *           .build();
   *   ApiFuture<AdSpot> future = adSpotServiceClient.createAdSpotCallable().futureCall(request);
   *   // Do something.
   *   AdSpot response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAdSpotRequest, AdSpot> createAdSpotCallable() {
    return stub.createAdSpotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `AdSpot` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateAdSpotRequest> requests = new ArrayList<>();
   *   BatchCreateAdSpotsResponse response =
   *       adSpotServiceClient.batchCreateAdSpots(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `AdSpots` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateAdSpotRequest must match this
   *     field.
   * @param requests Required. The `AdSpot` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateAdSpotsResponse batchCreateAdSpots(
      @Nullable NetworkName parent, List<CreateAdSpotRequest> requests) {
    BatchCreateAdSpotsRequest request =
        BatchCreateAdSpotsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateAdSpots(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `AdSpot` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateAdSpotRequest> requests = new ArrayList<>();
   *   BatchCreateAdSpotsResponse response =
   *       adSpotServiceClient.batchCreateAdSpots(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `AdSpots` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateAdSpotRequest must match this
   *     field.
   * @param requests Required. The `AdSpot` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateAdSpotsResponse batchCreateAdSpots(
      String parent, List<CreateAdSpotRequest> requests) {
    BatchCreateAdSpotsRequest request =
        BatchCreateAdSpotsRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchCreateAdSpots(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `AdSpot` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   BatchCreateAdSpotsRequest request =
   *       BatchCreateAdSpotsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateAdSpotRequest>())
   *           .build();
   *   BatchCreateAdSpotsResponse response = adSpotServiceClient.batchCreateAdSpots(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateAdSpotsResponse batchCreateAdSpots(BatchCreateAdSpotsRequest request) {
    return batchCreateAdSpotsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `AdSpot` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   BatchCreateAdSpotsRequest request =
   *       BatchCreateAdSpotsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateAdSpotRequest>())
   *           .build();
   *   ApiFuture<BatchCreateAdSpotsResponse> future =
   *       adSpotServiceClient.batchCreateAdSpotsCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateAdSpotsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateAdSpotsRequest, BatchCreateAdSpotsResponse>
      batchCreateAdSpotsCallable() {
    return stub.batchCreateAdSpotsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an `AdSpot` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   AdSpot adSpot = AdSpot.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AdSpot response = adSpotServiceClient.updateAdSpot(adSpot, updateMask);
   * }
   * }</pre>
   *
   * @param adSpot Required. The `AdSpot` to update.
   *     <p>The `AdSpot`'s `name` is used to identify the `AdSpot` to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdSpot updateAdSpot(AdSpot adSpot, FieldMask updateMask) {
    UpdateAdSpotRequest request =
        UpdateAdSpotRequest.newBuilder().setAdSpot(adSpot).setUpdateMask(updateMask).build();
    return updateAdSpot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an `AdSpot` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   UpdateAdSpotRequest request =
   *       UpdateAdSpotRequest.newBuilder()
   *           .setAdSpot(AdSpot.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AdSpot response = adSpotServiceClient.updateAdSpot(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdSpot updateAdSpot(UpdateAdSpotRequest request) {
    return updateAdSpotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an `AdSpot` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   UpdateAdSpotRequest request =
   *       UpdateAdSpotRequest.newBuilder()
   *           .setAdSpot(AdSpot.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AdSpot> future = adSpotServiceClient.updateAdSpotCallable().futureCall(request);
   *   // Do something.
   *   AdSpot response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAdSpotRequest, AdSpot> updateAdSpotCallable() {
    return stub.updateAdSpotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `AdSpot` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateAdSpotRequest> requests = new ArrayList<>();
   *   BatchUpdateAdSpotsResponse response =
   *       adSpotServiceClient.batchUpdateAdSpots(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `AdSpots` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateAdSpotRequest must match this
   *     field.
   * @param requests Required. The `AdSpot` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateAdSpotsResponse batchUpdateAdSpots(
      @Nullable NetworkName parent, List<UpdateAdSpotRequest> requests) {
    BatchUpdateAdSpotsRequest request =
        BatchUpdateAdSpotsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateAdSpots(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `AdSpot` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateAdSpotRequest> requests = new ArrayList<>();
   *   BatchUpdateAdSpotsResponse response =
   *       adSpotServiceClient.batchUpdateAdSpots(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `AdSpots` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateAdSpotRequest must match this
   *     field.
   * @param requests Required. The `AdSpot` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateAdSpotsResponse batchUpdateAdSpots(
      String parent, List<UpdateAdSpotRequest> requests) {
    BatchUpdateAdSpotsRequest request =
        BatchUpdateAdSpotsRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchUpdateAdSpots(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `AdSpot` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   BatchUpdateAdSpotsRequest request =
   *       BatchUpdateAdSpotsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateAdSpotRequest>())
   *           .build();
   *   BatchUpdateAdSpotsResponse response = adSpotServiceClient.batchUpdateAdSpots(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateAdSpotsResponse batchUpdateAdSpots(BatchUpdateAdSpotsRequest request) {
    return batchUpdateAdSpotsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `AdSpot` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdSpotServiceClient adSpotServiceClient = AdSpotServiceClient.create()) {
   *   BatchUpdateAdSpotsRequest request =
   *       BatchUpdateAdSpotsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateAdSpotRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateAdSpotsResponse> future =
   *       adSpotServiceClient.batchUpdateAdSpotsCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateAdSpotsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateAdSpotsRequest, BatchUpdateAdSpotsResponse>
      batchUpdateAdSpotsCallable() {
    return stub.batchUpdateAdSpotsCallable();
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

  public static class ListAdSpotsPagedResponse
      extends AbstractPagedListResponse<
          ListAdSpotsRequest,
          ListAdSpotsResponse,
          AdSpot,
          ListAdSpotsPage,
          ListAdSpotsFixedSizeCollection> {

    public static ApiFuture<ListAdSpotsPagedResponse> createAsync(
        PageContext<ListAdSpotsRequest, ListAdSpotsResponse, AdSpot> context,
        ApiFuture<ListAdSpotsResponse> futureResponse) {
      ApiFuture<ListAdSpotsPage> futurePage =
          ListAdSpotsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListAdSpotsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListAdSpotsPagedResponse(ListAdSpotsPage page) {
      super(page, ListAdSpotsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAdSpotsPage
      extends AbstractPage<ListAdSpotsRequest, ListAdSpotsResponse, AdSpot, ListAdSpotsPage> {

    private ListAdSpotsPage(
        @Nullable PageContext<ListAdSpotsRequest, ListAdSpotsResponse, AdSpot> context,
        @Nullable ListAdSpotsResponse response) {
      super(context, response);
    }

    private static ListAdSpotsPage createEmptyPage() {
      return new ListAdSpotsPage(null, null);
    }

    @Override
    protected ListAdSpotsPage createPage(
        @Nullable PageContext<ListAdSpotsRequest, ListAdSpotsResponse, AdSpot> context,
        @Nullable ListAdSpotsResponse response) {
      return new ListAdSpotsPage(context, response);
    }

    @Override
    public ApiFuture<ListAdSpotsPage> createPageAsync(
        @Nullable PageContext<ListAdSpotsRequest, ListAdSpotsResponse, AdSpot> context,
        ApiFuture<ListAdSpotsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAdSpotsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAdSpotsRequest,
          ListAdSpotsResponse,
          AdSpot,
          ListAdSpotsPage,
          ListAdSpotsFixedSizeCollection> {

    private ListAdSpotsFixedSizeCollection(
        @Nullable List<ListAdSpotsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAdSpotsFixedSizeCollection createEmptyCollection() {
      return new ListAdSpotsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAdSpotsFixedSizeCollection createCollection(
        @Nullable List<ListAdSpotsPage> pages, int collectionSize) {
      return new ListAdSpotsFixedSizeCollection(pages, collectionSize);
    }
  }
}
