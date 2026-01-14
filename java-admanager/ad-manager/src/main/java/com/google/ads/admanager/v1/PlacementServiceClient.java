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

import com.google.ads.admanager.v1.stub.PlacementServiceStub;
import com.google.ads.admanager.v1.stub.PlacementServiceStubSettings;
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
 * Service Description: Provides methods for handling `Placement` objects.
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
 * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
 *   PlacementName name = PlacementName.of("[NETWORK_CODE]", "[PLACEMENT]");
 *   Placement response = placementServiceClient.getPlacement(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PlacementServiceClient object to clean up resources
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
 *      <td><p> GetPlacement</td>
 *      <td><p> API to retrieve a `Placement` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPlacement(GetPlacementRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPlacement(PlacementName name)
 *           <li><p> getPlacement(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPlacementCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPlacements</td>
 *      <td><p> API to retrieve a list of `Placement` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPlacements(ListPlacementsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPlacements(NetworkName parent)
 *           <li><p> listPlacements(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPlacementsPagedCallable()
 *           <li><p> listPlacementsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreatePlacement</td>
 *      <td><p> API to create an `Placement` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPlacement(CreatePlacementRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createPlacement(NetworkName parent, Placement placement)
 *           <li><p> createPlacement(String parent, Placement placement)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPlacementCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePlacement</td>
 *      <td><p> API to update an `Placement` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePlacement(UpdatePlacementRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updatePlacement(Placement placement, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePlacementCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreatePlacements</td>
 *      <td><p> API to batch create `Placement` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreatePlacements(NetworkName parent, List&lt;CreatePlacementRequest&gt; requests)
 *           <li><p> batchCreatePlacements(String parent, List&lt;CreatePlacementRequest&gt; requests)
 *           <li><p> batchCreatePlacements(BatchCreatePlacementsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreatePlacementsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdatePlacements</td>
 *      <td><p> API to batch update `Placement` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdatePlacements(NetworkName parent, List&lt;UpdatePlacementRequest&gt; requests)
 *           <li><p> batchUpdatePlacements(String parent, List&lt;UpdatePlacementRequest&gt; requests)
 *           <li><p> batchUpdatePlacements(BatchUpdatePlacementsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdatePlacementsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchActivatePlacements</td>
 *      <td><p> Activates a list of `Placement` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchActivatePlacements(BatchActivatePlacementsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchActivatePlacements(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchActivatePlacements(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchActivatePlacementsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeactivatePlacements</td>
 *      <td><p> Deactivates a list of `Placement` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeactivatePlacements(BatchDeactivatePlacementsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDeactivatePlacements(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchDeactivatePlacements(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeactivatePlacementsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchArchivePlacements</td>
 *      <td><p> Archives a list of `Placement` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchArchivePlacements(BatchArchivePlacementsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchArchivePlacements(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchArchivePlacements(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchArchivePlacementsCallable()
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
 * <p>This class can be customized by passing in a custom instance of PlacementServiceSettings to
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
 * PlacementServiceSettings placementServiceSettings =
 *     PlacementServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PlacementServiceClient placementServiceClient =
 *     PlacementServiceClient.create(placementServiceSettings);
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
 * PlacementServiceSettings placementServiceSettings =
 *     PlacementServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PlacementServiceClient placementServiceClient =
 *     PlacementServiceClient.create(placementServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class PlacementServiceClient implements BackgroundResource {
  private final PlacementServiceSettings settings;
  private final PlacementServiceStub stub;

  /** Constructs an instance of PlacementServiceClient with default settings. */
  public static final PlacementServiceClient create() throws IOException {
    return create(PlacementServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PlacementServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PlacementServiceClient create(PlacementServiceSettings settings)
      throws IOException {
    return new PlacementServiceClient(settings);
  }

  /**
   * Constructs an instance of PlacementServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(PlacementServiceSettings).
   */
  public static final PlacementServiceClient create(PlacementServiceStub stub) {
    return new PlacementServiceClient(stub);
  }

  /**
   * Constructs an instance of PlacementServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PlacementServiceClient(PlacementServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PlacementServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected PlacementServiceClient(PlacementServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PlacementServiceSettings getSettings() {
    return settings;
  }

  public PlacementServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Placement` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   PlacementName name = PlacementName.of("[NETWORK_CODE]", "[PLACEMENT]");
   *   Placement response = placementServiceClient.getPlacement(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Placement. Format:
   *     `networks/{network_code}/placements/{placement_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Placement getPlacement(PlacementName name) {
    GetPlacementRequest request =
        GetPlacementRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPlacement(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Placement` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   String name = PlacementName.of("[NETWORK_CODE]", "[PLACEMENT]").toString();
   *   Placement response = placementServiceClient.getPlacement(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Placement. Format:
   *     `networks/{network_code}/placements/{placement_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Placement getPlacement(String name) {
    GetPlacementRequest request = GetPlacementRequest.newBuilder().setName(name).build();
    return getPlacement(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Placement` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   GetPlacementRequest request =
   *       GetPlacementRequest.newBuilder()
   *           .setName(PlacementName.of("[NETWORK_CODE]", "[PLACEMENT]").toString())
   *           .build();
   *   Placement response = placementServiceClient.getPlacement(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Placement getPlacement(GetPlacementRequest request) {
    return getPlacementCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Placement` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   GetPlacementRequest request =
   *       GetPlacementRequest.newBuilder()
   *           .setName(PlacementName.of("[NETWORK_CODE]", "[PLACEMENT]").toString())
   *           .build();
   *   ApiFuture<Placement> future =
   *       placementServiceClient.getPlacementCallable().futureCall(request);
   *   // Do something.
   *   Placement response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPlacementRequest, Placement> getPlacementCallable() {
    return stub.getPlacementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (Placement element : placementServiceClient.listPlacements(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Placements. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPlacementsPagedResponse listPlacements(NetworkName parent) {
    ListPlacementsRequest request =
        ListPlacementsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPlacements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (Placement element : placementServiceClient.listPlacements(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Placements. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPlacementsPagedResponse listPlacements(String parent) {
    ListPlacementsRequest request = ListPlacementsRequest.newBuilder().setParent(parent).build();
    return listPlacements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   ListPlacementsRequest request =
   *       ListPlacementsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (Placement element : placementServiceClient.listPlacements(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPlacementsPagedResponse listPlacements(ListPlacementsRequest request) {
    return listPlacementsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   ListPlacementsRequest request =
   *       ListPlacementsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<Placement> future =
   *       placementServiceClient.listPlacementsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Placement element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPlacementsRequest, ListPlacementsPagedResponse>
      listPlacementsPagedCallable() {
    return stub.listPlacementsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   ListPlacementsRequest request =
   *       ListPlacementsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListPlacementsResponse response =
   *         placementServiceClient.listPlacementsCallable().call(request);
   *     for (Placement element : response.getPlacementsList()) {
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
  public final UnaryCallable<ListPlacementsRequest, ListPlacementsResponse>
      listPlacementsCallable() {
    return stub.listPlacementsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create an `Placement` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   Placement placement = Placement.newBuilder().build();
   *   Placement response = placementServiceClient.createPlacement(parent, placement);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `Placement` will be created. Format:
   *     `networks/{network_code}`
   * @param placement Required. The `Placement` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Placement createPlacement(NetworkName parent, Placement placement) {
    CreatePlacementRequest request =
        CreatePlacementRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPlacement(placement)
            .build();
    return createPlacement(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create an `Placement` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   Placement placement = Placement.newBuilder().build();
   *   Placement response = placementServiceClient.createPlacement(parent, placement);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `Placement` will be created. Format:
   *     `networks/{network_code}`
   * @param placement Required. The `Placement` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Placement createPlacement(String parent, Placement placement) {
    CreatePlacementRequest request =
        CreatePlacementRequest.newBuilder().setParent(parent).setPlacement(placement).build();
    return createPlacement(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create an `Placement` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   CreatePlacementRequest request =
   *       CreatePlacementRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPlacement(Placement.newBuilder().build())
   *           .build();
   *   Placement response = placementServiceClient.createPlacement(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Placement createPlacement(CreatePlacementRequest request) {
    return createPlacementCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create an `Placement` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   CreatePlacementRequest request =
   *       CreatePlacementRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPlacement(Placement.newBuilder().build())
   *           .build();
   *   ApiFuture<Placement> future =
   *       placementServiceClient.createPlacementCallable().futureCall(request);
   *   // Do something.
   *   Placement response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePlacementRequest, Placement> createPlacementCallable() {
    return stub.createPlacementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update an `Placement` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   Placement placement = Placement.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Placement response = placementServiceClient.updatePlacement(placement, updateMask);
   * }
   * }</pre>
   *
   * @param placement Required. The `Placement` to update.
   *     <p>The `Placement`'s name is used to identify the `Placement` to update. Format:
   *     `networks/{network_code}/placements/{placement_id}`
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Placement updatePlacement(Placement placement, FieldMask updateMask) {
    UpdatePlacementRequest request =
        UpdatePlacementRequest.newBuilder()
            .setPlacement(placement)
            .setUpdateMask(updateMask)
            .build();
    return updatePlacement(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update an `Placement` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   UpdatePlacementRequest request =
   *       UpdatePlacementRequest.newBuilder()
   *           .setPlacement(Placement.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Placement response = placementServiceClient.updatePlacement(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Placement updatePlacement(UpdatePlacementRequest request) {
    return updatePlacementCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update an `Placement` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   UpdatePlacementRequest request =
   *       UpdatePlacementRequest.newBuilder()
   *           .setPlacement(Placement.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Placement> future =
   *       placementServiceClient.updatePlacementCallable().futureCall(request);
   *   // Do something.
   *   Placement response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePlacementRequest, Placement> updatePlacementCallable() {
    return stub.updatePlacementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreatePlacementRequest> requests = new ArrayList<>();
   *   BatchCreatePlacementsResponse response =
   *       placementServiceClient.batchCreatePlacements(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the `Placement`s will be created. Format:
   *     `networks/{network_code}` The parent field in the CreatePlacementRequest messages match
   *     this field.
   * @param requests Required. The `Placement` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreatePlacementsResponse batchCreatePlacements(
      NetworkName parent, List<CreatePlacementRequest> requests) {
    BatchCreatePlacementsRequest request =
        BatchCreatePlacementsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreatePlacements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreatePlacementRequest> requests = new ArrayList<>();
   *   BatchCreatePlacementsResponse response =
   *       placementServiceClient.batchCreatePlacements(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the `Placement`s will be created. Format:
   *     `networks/{network_code}` The parent field in the CreatePlacementRequest messages match
   *     this field.
   * @param requests Required. The `Placement` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreatePlacementsResponse batchCreatePlacements(
      String parent, List<CreatePlacementRequest> requests) {
    BatchCreatePlacementsRequest request =
        BatchCreatePlacementsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreatePlacements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   BatchCreatePlacementsRequest request =
   *       BatchCreatePlacementsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreatePlacementRequest>())
   *           .build();
   *   BatchCreatePlacementsResponse response =
   *       placementServiceClient.batchCreatePlacements(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreatePlacementsResponse batchCreatePlacements(
      BatchCreatePlacementsRequest request) {
    return batchCreatePlacementsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   BatchCreatePlacementsRequest request =
   *       BatchCreatePlacementsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreatePlacementRequest>())
   *           .build();
   *   ApiFuture<BatchCreatePlacementsResponse> future =
   *       placementServiceClient.batchCreatePlacementsCallable().futureCall(request);
   *   // Do something.
   *   BatchCreatePlacementsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreatePlacementsRequest, BatchCreatePlacementsResponse>
      batchCreatePlacementsCallable() {
    return stub.batchCreatePlacementsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdatePlacementRequest> requests = new ArrayList<>();
   *   BatchUpdatePlacementsResponse response =
   *       placementServiceClient.batchUpdatePlacements(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Placements` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdatePlacementsRequest must match this
   *     field.
   * @param requests Required. The `Placement` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdatePlacementsResponse batchUpdatePlacements(
      NetworkName parent, List<UpdatePlacementRequest> requests) {
    BatchUpdatePlacementsRequest request =
        BatchUpdatePlacementsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdatePlacements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdatePlacementRequest> requests = new ArrayList<>();
   *   BatchUpdatePlacementsResponse response =
   *       placementServiceClient.batchUpdatePlacements(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Placements` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdatePlacementsRequest must match this
   *     field.
   * @param requests Required. The `Placement` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdatePlacementsResponse batchUpdatePlacements(
      String parent, List<UpdatePlacementRequest> requests) {
    BatchUpdatePlacementsRequest request =
        BatchUpdatePlacementsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdatePlacements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   BatchUpdatePlacementsRequest request =
   *       BatchUpdatePlacementsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdatePlacementRequest>())
   *           .build();
   *   BatchUpdatePlacementsResponse response =
   *       placementServiceClient.batchUpdatePlacements(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdatePlacementsResponse batchUpdatePlacements(
      BatchUpdatePlacementsRequest request) {
    return batchUpdatePlacementsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   BatchUpdatePlacementsRequest request =
   *       BatchUpdatePlacementsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdatePlacementRequest>())
   *           .build();
   *   ApiFuture<BatchUpdatePlacementsResponse> future =
   *       placementServiceClient.batchUpdatePlacementsCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdatePlacementsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdatePlacementsRequest, BatchUpdatePlacementsResponse>
      batchUpdatePlacementsCallable() {
    return stub.batchUpdatePlacementsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchActivatePlacementsResponse response =
   *       placementServiceClient.batchActivatePlacements(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The names of the `Placement` objects to activate. Format:
   *     `networks/{network_code}/placements/{placement_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivatePlacementsResponse batchActivatePlacements(
      NetworkName parent, List<String> names) {
    BatchActivatePlacementsRequest request =
        BatchActivatePlacementsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchActivatePlacements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchActivatePlacementsResponse response =
   *       placementServiceClient.batchActivatePlacements(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The names of the `Placement` objects to activate. Format:
   *     `networks/{network_code}/placements/{placement_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivatePlacementsResponse batchActivatePlacements(
      String parent, List<String> names) {
    BatchActivatePlacementsRequest request =
        BatchActivatePlacementsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchActivatePlacements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   BatchActivatePlacementsRequest request =
   *       BatchActivatePlacementsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchActivatePlacementsResponse response =
   *       placementServiceClient.batchActivatePlacements(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivatePlacementsResponse batchActivatePlacements(
      BatchActivatePlacementsRequest request) {
    return batchActivatePlacementsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   BatchActivatePlacementsRequest request =
   *       BatchActivatePlacementsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchActivatePlacementsResponse> future =
   *       placementServiceClient.batchActivatePlacementsCallable().futureCall(request);
   *   // Do something.
   *   BatchActivatePlacementsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchActivatePlacementsRequest, BatchActivatePlacementsResponse>
      batchActivatePlacementsCallable() {
    return stub.batchActivatePlacementsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivatePlacementsResponse response =
   *       placementServiceClient.batchDeactivatePlacements(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The names of the `Placement` objects to deactivate. Format:
   *     `networks/{network_code}/placements/{placement_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivatePlacementsResponse batchDeactivatePlacements(
      NetworkName parent, List<String> names) {
    BatchDeactivatePlacementsRequest request =
        BatchDeactivatePlacementsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchDeactivatePlacements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivatePlacementsResponse response =
   *       placementServiceClient.batchDeactivatePlacements(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The names of the `Placement` objects to deactivate. Format:
   *     `networks/{network_code}/placements/{placement_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivatePlacementsResponse batchDeactivatePlacements(
      String parent, List<String> names) {
    BatchDeactivatePlacementsRequest request =
        BatchDeactivatePlacementsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchDeactivatePlacements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   BatchDeactivatePlacementsRequest request =
   *       BatchDeactivatePlacementsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchDeactivatePlacementsResponse response =
   *       placementServiceClient.batchDeactivatePlacements(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivatePlacementsResponse batchDeactivatePlacements(
      BatchDeactivatePlacementsRequest request) {
    return batchDeactivatePlacementsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   BatchDeactivatePlacementsRequest request =
   *       BatchDeactivatePlacementsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchDeactivatePlacementsResponse> future =
   *       placementServiceClient.batchDeactivatePlacementsCallable().futureCall(request);
   *   // Do something.
   *   BatchDeactivatePlacementsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeactivatePlacementsRequest, BatchDeactivatePlacementsResponse>
      batchDeactivatePlacementsCallable() {
    return stub.batchDeactivatePlacementsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchArchivePlacementsResponse response =
   *       placementServiceClient.batchArchivePlacements(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The names of the `Placement` objects to archive. Format:
   *     `networks/{network_code}/placements/{placement_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchivePlacementsResponse batchArchivePlacements(
      NetworkName parent, List<String> names) {
    BatchArchivePlacementsRequest request =
        BatchArchivePlacementsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchArchivePlacements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchArchivePlacementsResponse response =
   *       placementServiceClient.batchArchivePlacements(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The names of the `Placement` objects to archive. Format:
   *     `networks/{network_code}/placements/{placement_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchivePlacementsResponse batchArchivePlacements(
      String parent, List<String> names) {
    BatchArchivePlacementsRequest request =
        BatchArchivePlacementsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchArchivePlacements(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   BatchArchivePlacementsRequest request =
   *       BatchArchivePlacementsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchArchivePlacementsResponse response =
   *       placementServiceClient.batchArchivePlacements(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchivePlacementsResponse batchArchivePlacements(
      BatchArchivePlacementsRequest request) {
    return batchArchivePlacementsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `Placement` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PlacementServiceClient placementServiceClient = PlacementServiceClient.create()) {
   *   BatchArchivePlacementsRequest request =
   *       BatchArchivePlacementsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchArchivePlacementsResponse> future =
   *       placementServiceClient.batchArchivePlacementsCallable().futureCall(request);
   *   // Do something.
   *   BatchArchivePlacementsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchArchivePlacementsRequest, BatchArchivePlacementsResponse>
      batchArchivePlacementsCallable() {
    return stub.batchArchivePlacementsCallable();
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

  public static class ListPlacementsPagedResponse
      extends AbstractPagedListResponse<
          ListPlacementsRequest,
          ListPlacementsResponse,
          Placement,
          ListPlacementsPage,
          ListPlacementsFixedSizeCollection> {

    public static ApiFuture<ListPlacementsPagedResponse> createAsync(
        PageContext<ListPlacementsRequest, ListPlacementsResponse, Placement> context,
        ApiFuture<ListPlacementsResponse> futureResponse) {
      ApiFuture<ListPlacementsPage> futurePage =
          ListPlacementsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPlacementsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPlacementsPagedResponse(ListPlacementsPage page) {
      super(page, ListPlacementsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPlacementsPage
      extends AbstractPage<
          ListPlacementsRequest, ListPlacementsResponse, Placement, ListPlacementsPage> {

    private ListPlacementsPage(
        PageContext<ListPlacementsRequest, ListPlacementsResponse, Placement> context,
        ListPlacementsResponse response) {
      super(context, response);
    }

    private static ListPlacementsPage createEmptyPage() {
      return new ListPlacementsPage(null, null);
    }

    @Override
    protected ListPlacementsPage createPage(
        PageContext<ListPlacementsRequest, ListPlacementsResponse, Placement> context,
        ListPlacementsResponse response) {
      return new ListPlacementsPage(context, response);
    }

    @Override
    public ApiFuture<ListPlacementsPage> createPageAsync(
        PageContext<ListPlacementsRequest, ListPlacementsResponse, Placement> context,
        ApiFuture<ListPlacementsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPlacementsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPlacementsRequest,
          ListPlacementsResponse,
          Placement,
          ListPlacementsPage,
          ListPlacementsFixedSizeCollection> {

    private ListPlacementsFixedSizeCollection(List<ListPlacementsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPlacementsFixedSizeCollection createEmptyCollection() {
      return new ListPlacementsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPlacementsFixedSizeCollection createCollection(
        List<ListPlacementsPage> pages, int collectionSize) {
      return new ListPlacementsFixedSizeCollection(pages, collectionSize);
    }
  }
}
