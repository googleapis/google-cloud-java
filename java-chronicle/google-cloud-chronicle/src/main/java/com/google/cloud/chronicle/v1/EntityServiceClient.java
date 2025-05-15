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

package com.google.cloud.chronicle.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.stub.EntityServiceStub;
import com.google.cloud.chronicle.v1.stub.EntityServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: EntityService contains apis for finding entities.
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
 * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
 *   WatchlistName name = WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]");
 *   Watchlist response = entityServiceClient.getWatchlist(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the EntityServiceClient object to clean up resources such
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
 *      <td><p> GetWatchlist</td>
 *      <td><p> Gets watchlist details for the given watchlist ID.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getWatchlist(GetWatchlistRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getWatchlist(WatchlistName name)
 *           <li><p> getWatchlist(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getWatchlistCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListWatchlists</td>
 *      <td><p> Lists all watchlists for the given instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listWatchlists(ListWatchlistsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listWatchlists(InstanceName parent)
 *           <li><p> listWatchlists(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listWatchlistsPagedCallable()
 *           <li><p> listWatchlistsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateWatchlist</td>
 *      <td><p> Creates a watchlist for the given instance. Note that there can be at most 200 watchlists per instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createWatchlist(CreateWatchlistRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createWatchlist(InstanceName parent, Watchlist watchlist, String watchlistId)
 *           <li><p> createWatchlist(String parent, Watchlist watchlist, String watchlistId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createWatchlistCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateWatchlist</td>
 *      <td><p> Updates the watchlist for the given instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateWatchlist(UpdateWatchlistRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateWatchlist(Watchlist watchlist, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateWatchlistCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteWatchlist</td>
 *      <td><p> Deletes the watchlist for the given instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteWatchlist(DeleteWatchlistRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteWatchlist(WatchlistName name, boolean force)
 *           <li><p> deleteWatchlist(String name, boolean force)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteWatchlistCallable()
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
 * <p>This class can be customized by passing in a custom instance of EntityServiceSettings to
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
 * EntityServiceSettings entityServiceSettings =
 *     EntityServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EntityServiceClient entityServiceClient = EntityServiceClient.create(entityServiceSettings);
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
 * EntityServiceSettings entityServiceSettings =
 *     EntityServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EntityServiceClient entityServiceClient = EntityServiceClient.create(entityServiceSettings);
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
 * EntityServiceSettings entityServiceSettings =
 *     EntityServiceSettings.newHttpJsonBuilder().build();
 * EntityServiceClient entityServiceClient = EntityServiceClient.create(entityServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class EntityServiceClient implements BackgroundResource {
  private final EntityServiceSettings settings;
  private final EntityServiceStub stub;

  /** Constructs an instance of EntityServiceClient with default settings. */
  public static final EntityServiceClient create() throws IOException {
    return create(EntityServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EntityServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final EntityServiceClient create(EntityServiceSettings settings)
      throws IOException {
    return new EntityServiceClient(settings);
  }

  /**
   * Constructs an instance of EntityServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(EntityServiceSettings).
   */
  public static final EntityServiceClient create(EntityServiceStub stub) {
    return new EntityServiceClient(stub);
  }

  /**
   * Constructs an instance of EntityServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected EntityServiceClient(EntityServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((EntityServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected EntityServiceClient(EntityServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final EntityServiceSettings getSettings() {
    return settings;
  }

  public EntityServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets watchlist details for the given watchlist ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   WatchlistName name = WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]");
   *   Watchlist response = entityServiceClient.getWatchlist(name);
   * }
   * }</pre>
   *
   * @param name Required. The parent, which owns this collection of watchlists. The name of the
   *     watchlist to retrieve. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/watchlists/{watchlist}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Watchlist getWatchlist(WatchlistName name) {
    GetWatchlistRequest request =
        GetWatchlistRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getWatchlist(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets watchlist details for the given watchlist ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   String name =
   *       WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]").toString();
   *   Watchlist response = entityServiceClient.getWatchlist(name);
   * }
   * }</pre>
   *
   * @param name Required. The parent, which owns this collection of watchlists. The name of the
   *     watchlist to retrieve. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/watchlists/{watchlist}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Watchlist getWatchlist(String name) {
    GetWatchlistRequest request = GetWatchlistRequest.newBuilder().setName(name).build();
    return getWatchlist(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets watchlist details for the given watchlist ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   GetWatchlistRequest request =
   *       GetWatchlistRequest.newBuilder()
   *           .setName(
   *               WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]")
   *                   .toString())
   *           .build();
   *   Watchlist response = entityServiceClient.getWatchlist(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Watchlist getWatchlist(GetWatchlistRequest request) {
    return getWatchlistCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets watchlist details for the given watchlist ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   GetWatchlistRequest request =
   *       GetWatchlistRequest.newBuilder()
   *           .setName(
   *               WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Watchlist> future = entityServiceClient.getWatchlistCallable().futureCall(request);
   *   // Do something.
   *   Watchlist response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWatchlistRequest, Watchlist> getWatchlistCallable() {
    return stub.getWatchlistCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all watchlists for the given instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (Watchlist element : entityServiceClient.listWatchlists(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of watchlists. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWatchlistsPagedResponse listWatchlists(InstanceName parent) {
    ListWatchlistsRequest request =
        ListWatchlistsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listWatchlists(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all watchlists for the given instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (Watchlist element : entityServiceClient.listWatchlists(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of watchlists. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWatchlistsPagedResponse listWatchlists(String parent) {
    ListWatchlistsRequest request = ListWatchlistsRequest.newBuilder().setParent(parent).build();
    return listWatchlists(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all watchlists for the given instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   ListWatchlistsRequest request =
   *       ListWatchlistsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Watchlist element : entityServiceClient.listWatchlists(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWatchlistsPagedResponse listWatchlists(ListWatchlistsRequest request) {
    return listWatchlistsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all watchlists for the given instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   ListWatchlistsRequest request =
   *       ListWatchlistsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Watchlist> future =
   *       entityServiceClient.listWatchlistsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Watchlist element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWatchlistsRequest, ListWatchlistsPagedResponse>
      listWatchlistsPagedCallable() {
    return stub.listWatchlistsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all watchlists for the given instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   ListWatchlistsRequest request =
   *       ListWatchlistsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListWatchlistsResponse response =
   *         entityServiceClient.listWatchlistsCallable().call(request);
   *     for (Watchlist element : response.getWatchlistsList()) {
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
  public final UnaryCallable<ListWatchlistsRequest, ListWatchlistsResponse>
      listWatchlistsCallable() {
    return stub.listWatchlistsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a watchlist for the given instance. Note that there can be at most 200 watchlists per
   * instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Watchlist watchlist = Watchlist.newBuilder().build();
   *   String watchlistId = "watchlistId1560983528";
   *   Watchlist response = entityServiceClient.createWatchlist(parent, watchlist, watchlistId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this watchlist will be created. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}`
   * @param watchlist Required. The watchlist to create.
   * @param watchlistId Optional. The ID to use for the watchlist, which will become the final
   *     component of the watchlist's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Watchlist createWatchlist(
      InstanceName parent, Watchlist watchlist, String watchlistId) {
    CreateWatchlistRequest request =
        CreateWatchlistRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setWatchlist(watchlist)
            .setWatchlistId(watchlistId)
            .build();
    return createWatchlist(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a watchlist for the given instance. Note that there can be at most 200 watchlists per
   * instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   Watchlist watchlist = Watchlist.newBuilder().build();
   *   String watchlistId = "watchlistId1560983528";
   *   Watchlist response = entityServiceClient.createWatchlist(parent, watchlist, watchlistId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this watchlist will be created. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}`
   * @param watchlist Required. The watchlist to create.
   * @param watchlistId Optional. The ID to use for the watchlist, which will become the final
   *     component of the watchlist's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are /[a-z][0-9]-/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Watchlist createWatchlist(String parent, Watchlist watchlist, String watchlistId) {
    CreateWatchlistRequest request =
        CreateWatchlistRequest.newBuilder()
            .setParent(parent)
            .setWatchlist(watchlist)
            .setWatchlistId(watchlistId)
            .build();
    return createWatchlist(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a watchlist for the given instance. Note that there can be at most 200 watchlists per
   * instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   CreateWatchlistRequest request =
   *       CreateWatchlistRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setWatchlistId("watchlistId1560983528")
   *           .setWatchlist(Watchlist.newBuilder().build())
   *           .build();
   *   Watchlist response = entityServiceClient.createWatchlist(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Watchlist createWatchlist(CreateWatchlistRequest request) {
    return createWatchlistCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a watchlist for the given instance. Note that there can be at most 200 watchlists per
   * instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   CreateWatchlistRequest request =
   *       CreateWatchlistRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setWatchlistId("watchlistId1560983528")
   *           .setWatchlist(Watchlist.newBuilder().build())
   *           .build();
   *   ApiFuture<Watchlist> future =
   *       entityServiceClient.createWatchlistCallable().futureCall(request);
   *   // Do something.
   *   Watchlist response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateWatchlistRequest, Watchlist> createWatchlistCallable() {
    return stub.createWatchlistCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the watchlist for the given instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   Watchlist watchlist = Watchlist.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Watchlist response = entityServiceClient.updateWatchlist(watchlist, updateMask);
   * }
   * }</pre>
   *
   * @param watchlist Required. The watchlist to update.
   *     <p>The watchlist's `name` field is used to identify the watchlist to update. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/watchlists/{watchlist}`
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Watchlist updateWatchlist(Watchlist watchlist, FieldMask updateMask) {
    UpdateWatchlistRequest request =
        UpdateWatchlistRequest.newBuilder()
            .setWatchlist(watchlist)
            .setUpdateMask(updateMask)
            .build();
    return updateWatchlist(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the watchlist for the given instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   UpdateWatchlistRequest request =
   *       UpdateWatchlistRequest.newBuilder()
   *           .setWatchlist(Watchlist.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Watchlist response = entityServiceClient.updateWatchlist(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Watchlist updateWatchlist(UpdateWatchlistRequest request) {
    return updateWatchlistCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the watchlist for the given instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   UpdateWatchlistRequest request =
   *       UpdateWatchlistRequest.newBuilder()
   *           .setWatchlist(Watchlist.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Watchlist> future =
   *       entityServiceClient.updateWatchlistCallable().futureCall(request);
   *   // Do something.
   *   Watchlist response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateWatchlistRequest, Watchlist> updateWatchlistCallable() {
    return stub.updateWatchlistCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the watchlist for the given instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   WatchlistName name = WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]");
   *   boolean force = true;
   *   entityServiceClient.deleteWatchlist(name, force);
   * }
   * }</pre>
   *
   * @param name Required. The name of the watchlist to delete. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/watchlists/{watchlist}`
   * @param force Optional. If set to true, any entities under this watchlist will also be deleted.
   *     (Otherwise, the request will only work if the watchlist has no entities.)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWatchlist(WatchlistName name, boolean force) {
    DeleteWatchlistRequest request =
        DeleteWatchlistRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setForce(force)
            .build();
    deleteWatchlist(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the watchlist for the given instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   String name =
   *       WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]").toString();
   *   boolean force = true;
   *   entityServiceClient.deleteWatchlist(name, force);
   * }
   * }</pre>
   *
   * @param name Required. The name of the watchlist to delete. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/watchlists/{watchlist}`
   * @param force Optional. If set to true, any entities under this watchlist will also be deleted.
   *     (Otherwise, the request will only work if the watchlist has no entities.)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWatchlist(String name, boolean force) {
    DeleteWatchlistRequest request =
        DeleteWatchlistRequest.newBuilder().setName(name).setForce(force).build();
    deleteWatchlist(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the watchlist for the given instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   DeleteWatchlistRequest request =
   *       DeleteWatchlistRequest.newBuilder()
   *           .setName(
   *               WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   entityServiceClient.deleteWatchlist(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteWatchlist(DeleteWatchlistRequest request) {
    deleteWatchlistCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the watchlist for the given instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntityServiceClient entityServiceClient = EntityServiceClient.create()) {
   *   DeleteWatchlistRequest request =
   *       DeleteWatchlistRequest.newBuilder()
   *           .setName(
   *               WatchlistName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[WATCHLIST]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = entityServiceClient.deleteWatchlistCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteWatchlistRequest, Empty> deleteWatchlistCallable() {
    return stub.deleteWatchlistCallable();
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

  public static class ListWatchlistsPagedResponse
      extends AbstractPagedListResponse<
          ListWatchlistsRequest,
          ListWatchlistsResponse,
          Watchlist,
          ListWatchlistsPage,
          ListWatchlistsFixedSizeCollection> {

    public static ApiFuture<ListWatchlistsPagedResponse> createAsync(
        PageContext<ListWatchlistsRequest, ListWatchlistsResponse, Watchlist> context,
        ApiFuture<ListWatchlistsResponse> futureResponse) {
      ApiFuture<ListWatchlistsPage> futurePage =
          ListWatchlistsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListWatchlistsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListWatchlistsPagedResponse(ListWatchlistsPage page) {
      super(page, ListWatchlistsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListWatchlistsPage
      extends AbstractPage<
          ListWatchlistsRequest, ListWatchlistsResponse, Watchlist, ListWatchlistsPage> {

    private ListWatchlistsPage(
        PageContext<ListWatchlistsRequest, ListWatchlistsResponse, Watchlist> context,
        ListWatchlistsResponse response) {
      super(context, response);
    }

    private static ListWatchlistsPage createEmptyPage() {
      return new ListWatchlistsPage(null, null);
    }

    @Override
    protected ListWatchlistsPage createPage(
        PageContext<ListWatchlistsRequest, ListWatchlistsResponse, Watchlist> context,
        ListWatchlistsResponse response) {
      return new ListWatchlistsPage(context, response);
    }

    @Override
    public ApiFuture<ListWatchlistsPage> createPageAsync(
        PageContext<ListWatchlistsRequest, ListWatchlistsResponse, Watchlist> context,
        ApiFuture<ListWatchlistsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListWatchlistsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListWatchlistsRequest,
          ListWatchlistsResponse,
          Watchlist,
          ListWatchlistsPage,
          ListWatchlistsFixedSizeCollection> {

    private ListWatchlistsFixedSizeCollection(List<ListWatchlistsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListWatchlistsFixedSizeCollection createEmptyCollection() {
      return new ListWatchlistsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListWatchlistsFixedSizeCollection createCollection(
        List<ListWatchlistsPage> pages, int collectionSize) {
      return new ListWatchlistsFixedSizeCollection(pages, collectionSize);
    }
  }
}
