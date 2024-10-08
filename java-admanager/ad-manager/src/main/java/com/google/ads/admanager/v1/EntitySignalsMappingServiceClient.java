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

import com.google.ads.admanager.v1.stub.EntitySignalsMappingServiceStub;
import com.google.ads.admanager.v1.stub.EntitySignalsMappingServiceStubSettings;
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
 * Service Description: Provides methods for handling `EntitySignalsMapping` objects.
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
 * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
 *     EntitySignalsMappingServiceClient.create()) {
 *   EntitySignalsMappingName name =
 *       EntitySignalsMappingName.of("[NETWORK_CODE]", "[ENTITY_SIGNALS_MAPPING]");
 *   EntitySignalsMapping response =
 *       entitySignalsMappingServiceClient.getEntitySignalsMapping(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the EntitySignalsMappingServiceClient object to clean up
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
 *      <td><p> GetEntitySignalsMapping</td>
 *      <td><p> API to retrieve a `EntitySignalsMapping` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEntitySignalsMapping(GetEntitySignalsMappingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEntitySignalsMapping(EntitySignalsMappingName name)
 *           <li><p> getEntitySignalsMapping(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEntitySignalsMappingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEntitySignalsMappings</td>
 *      <td><p> API to retrieve a list of `EntitySignalsMapping` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEntitySignalsMappings(ListEntitySignalsMappingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEntitySignalsMappings(NetworkName parent)
 *           <li><p> listEntitySignalsMappings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEntitySignalsMappingsPagedCallable()
 *           <li><p> listEntitySignalsMappingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEntitySignalsMapping</td>
 *      <td><p> API to create an `EntitySignalsMapping` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEntitySignalsMapping(CreateEntitySignalsMappingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createEntitySignalsMapping(NetworkName parent, EntitySignalsMapping entitySignalsMapping)
 *           <li><p> createEntitySignalsMapping(String parent, EntitySignalsMapping entitySignalsMapping)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEntitySignalsMappingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEntitySignalsMapping</td>
 *      <td><p> API to update an `EntitySignalsMapping` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEntitySignalsMapping(UpdateEntitySignalsMappingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateEntitySignalsMapping(EntitySignalsMapping entitySignalsMapping, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEntitySignalsMappingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateEntitySignalsMappings</td>
 *      <td><p> API to batch create `EntitySignalsMapping` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateEntitySignalsMappings(NetworkName parent, List&lt;CreateEntitySignalsMappingRequest&gt; requests)
 *           <li><p> batchCreateEntitySignalsMappings(String parent, List&lt;CreateEntitySignalsMappingRequest&gt; requests)
 *           <li><p> batchCreateEntitySignalsMappings(BatchCreateEntitySignalsMappingsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateEntitySignalsMappingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateEntitySignalsMappings</td>
 *      <td><p> API to batch update `EntitySignalsMapping` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateEntitySignalsMappings(NetworkName parent, List&lt;UpdateEntitySignalsMappingRequest&gt; requests)
 *           <li><p> batchUpdateEntitySignalsMappings(String parent, List&lt;UpdateEntitySignalsMappingRequest&gt; requests)
 *           <li><p> batchUpdateEntitySignalsMappings(BatchUpdateEntitySignalsMappingsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateEntitySignalsMappingsCallable()
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
 * EntitySignalsMappingServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EntitySignalsMappingServiceSettings entitySignalsMappingServiceSettings =
 *     EntitySignalsMappingServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
 *     EntitySignalsMappingServiceClient.create(entitySignalsMappingServiceSettings);
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
 * EntitySignalsMappingServiceSettings entitySignalsMappingServiceSettings =
 *     EntitySignalsMappingServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
 *     EntitySignalsMappingServiceClient.create(entitySignalsMappingServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class EntitySignalsMappingServiceClient implements BackgroundResource {
  private final EntitySignalsMappingServiceSettings settings;
  private final EntitySignalsMappingServiceStub stub;

  /** Constructs an instance of EntitySignalsMappingServiceClient with default settings. */
  public static final EntitySignalsMappingServiceClient create() throws IOException {
    return create(EntitySignalsMappingServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EntitySignalsMappingServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final EntitySignalsMappingServiceClient create(
      EntitySignalsMappingServiceSettings settings) throws IOException {
    return new EntitySignalsMappingServiceClient(settings);
  }

  /**
   * Constructs an instance of EntitySignalsMappingServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(EntitySignalsMappingServiceSettings).
   */
  public static final EntitySignalsMappingServiceClient create(
      EntitySignalsMappingServiceStub stub) {
    return new EntitySignalsMappingServiceClient(stub);
  }

  /**
   * Constructs an instance of EntitySignalsMappingServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected EntitySignalsMappingServiceClient(EntitySignalsMappingServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((EntitySignalsMappingServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected EntitySignalsMappingServiceClient(EntitySignalsMappingServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final EntitySignalsMappingServiceSettings getSettings() {
    return settings;
  }

  public EntitySignalsMappingServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `EntitySignalsMapping` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   EntitySignalsMappingName name =
   *       EntitySignalsMappingName.of("[NETWORK_CODE]", "[ENTITY_SIGNALS_MAPPING]");
   *   EntitySignalsMapping response =
   *       entitySignalsMappingServiceClient.getEntitySignalsMapping(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the EntitySignalsMapping. Format:
   *     `networks/{network_code}/entitySignalsMappings/{entity_signals_mapping_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntitySignalsMapping getEntitySignalsMapping(EntitySignalsMappingName name) {
    GetEntitySignalsMappingRequest request =
        GetEntitySignalsMappingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getEntitySignalsMapping(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `EntitySignalsMapping` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   String name =
   *       EntitySignalsMappingName.of("[NETWORK_CODE]", "[ENTITY_SIGNALS_MAPPING]").toString();
   *   EntitySignalsMapping response =
   *       entitySignalsMappingServiceClient.getEntitySignalsMapping(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the EntitySignalsMapping. Format:
   *     `networks/{network_code}/entitySignalsMappings/{entity_signals_mapping_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntitySignalsMapping getEntitySignalsMapping(String name) {
    GetEntitySignalsMappingRequest request =
        GetEntitySignalsMappingRequest.newBuilder().setName(name).build();
    return getEntitySignalsMapping(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `EntitySignalsMapping` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   GetEntitySignalsMappingRequest request =
   *       GetEntitySignalsMappingRequest.newBuilder()
   *           .setName(
   *               EntitySignalsMappingName.of("[NETWORK_CODE]", "[ENTITY_SIGNALS_MAPPING]")
   *                   .toString())
   *           .build();
   *   EntitySignalsMapping response =
   *       entitySignalsMappingServiceClient.getEntitySignalsMapping(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntitySignalsMapping getEntitySignalsMapping(
      GetEntitySignalsMappingRequest request) {
    return getEntitySignalsMappingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `EntitySignalsMapping` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   GetEntitySignalsMappingRequest request =
   *       GetEntitySignalsMappingRequest.newBuilder()
   *           .setName(
   *               EntitySignalsMappingName.of("[NETWORK_CODE]", "[ENTITY_SIGNALS_MAPPING]")
   *                   .toString())
   *           .build();
   *   ApiFuture<EntitySignalsMapping> future =
   *       entitySignalsMappingServiceClient.getEntitySignalsMappingCallable().futureCall(request);
   *   // Do something.
   *   EntitySignalsMapping response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEntitySignalsMappingRequest, EntitySignalsMapping>
      getEntitySignalsMappingCallable() {
    return stub.getEntitySignalsMappingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `EntitySignalsMapping` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (EntitySignalsMapping element :
   *       entitySignalsMappingServiceClient.listEntitySignalsMappings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of EntitySignalsMappings.
   *     Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntitySignalsMappingsPagedResponse listEntitySignalsMappings(
      NetworkName parent) {
    ListEntitySignalsMappingsRequest request =
        ListEntitySignalsMappingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEntitySignalsMappings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `EntitySignalsMapping` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (EntitySignalsMapping element :
   *       entitySignalsMappingServiceClient.listEntitySignalsMappings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of EntitySignalsMappings.
   *     Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntitySignalsMappingsPagedResponse listEntitySignalsMappings(String parent) {
    ListEntitySignalsMappingsRequest request =
        ListEntitySignalsMappingsRequest.newBuilder().setParent(parent).build();
    return listEntitySignalsMappings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `EntitySignalsMapping` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   ListEntitySignalsMappingsRequest request =
   *       ListEntitySignalsMappingsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (EntitySignalsMapping element :
   *       entitySignalsMappingServiceClient.listEntitySignalsMappings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntitySignalsMappingsPagedResponse listEntitySignalsMappings(
      ListEntitySignalsMappingsRequest request) {
    return listEntitySignalsMappingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `EntitySignalsMapping` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   ListEntitySignalsMappingsRequest request =
   *       ListEntitySignalsMappingsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<EntitySignalsMapping> future =
   *       entitySignalsMappingServiceClient
   *           .listEntitySignalsMappingsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (EntitySignalsMapping element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListEntitySignalsMappingsRequest, ListEntitySignalsMappingsPagedResponse>
      listEntitySignalsMappingsPagedCallable() {
    return stub.listEntitySignalsMappingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `EntitySignalsMapping` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   ListEntitySignalsMappingsRequest request =
   *       ListEntitySignalsMappingsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListEntitySignalsMappingsResponse response =
   *         entitySignalsMappingServiceClient.listEntitySignalsMappingsCallable().call(request);
   *     for (EntitySignalsMapping element : response.getEntitySignalsMappingsList()) {
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
  public final UnaryCallable<ListEntitySignalsMappingsRequest, ListEntitySignalsMappingsResponse>
      listEntitySignalsMappingsCallable() {
    return stub.listEntitySignalsMappingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create an `EntitySignalsMapping` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   EntitySignalsMapping entitySignalsMapping = EntitySignalsMapping.newBuilder().build();
   *   EntitySignalsMapping response =
   *       entitySignalsMappingServiceClient.createEntitySignalsMapping(
   *           parent, entitySignalsMapping);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this EntitySignalsMapping will be created.
   *     Format: `networks/{network_code}`
   * @param entitySignalsMapping Required. The EntitySignalsMapping object to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntitySignalsMapping createEntitySignalsMapping(
      NetworkName parent, EntitySignalsMapping entitySignalsMapping) {
    CreateEntitySignalsMappingRequest request =
        CreateEntitySignalsMappingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEntitySignalsMapping(entitySignalsMapping)
            .build();
    return createEntitySignalsMapping(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create an `EntitySignalsMapping` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   EntitySignalsMapping entitySignalsMapping = EntitySignalsMapping.newBuilder().build();
   *   EntitySignalsMapping response =
   *       entitySignalsMappingServiceClient.createEntitySignalsMapping(
   *           parent, entitySignalsMapping);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this EntitySignalsMapping will be created.
   *     Format: `networks/{network_code}`
   * @param entitySignalsMapping Required. The EntitySignalsMapping object to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntitySignalsMapping createEntitySignalsMapping(
      String parent, EntitySignalsMapping entitySignalsMapping) {
    CreateEntitySignalsMappingRequest request =
        CreateEntitySignalsMappingRequest.newBuilder()
            .setParent(parent)
            .setEntitySignalsMapping(entitySignalsMapping)
            .build();
    return createEntitySignalsMapping(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create an `EntitySignalsMapping` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   CreateEntitySignalsMappingRequest request =
   *       CreateEntitySignalsMappingRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setEntitySignalsMapping(EntitySignalsMapping.newBuilder().build())
   *           .build();
   *   EntitySignalsMapping response =
   *       entitySignalsMappingServiceClient.createEntitySignalsMapping(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntitySignalsMapping createEntitySignalsMapping(
      CreateEntitySignalsMappingRequest request) {
    return createEntitySignalsMappingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create an `EntitySignalsMapping` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   CreateEntitySignalsMappingRequest request =
   *       CreateEntitySignalsMappingRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setEntitySignalsMapping(EntitySignalsMapping.newBuilder().build())
   *           .build();
   *   ApiFuture<EntitySignalsMapping> future =
   *       entitySignalsMappingServiceClient
   *           .createEntitySignalsMappingCallable()
   *           .futureCall(request);
   *   // Do something.
   *   EntitySignalsMapping response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEntitySignalsMappingRequest, EntitySignalsMapping>
      createEntitySignalsMappingCallable() {
    return stub.createEntitySignalsMappingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update an `EntitySignalsMapping` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   EntitySignalsMapping entitySignalsMapping = EntitySignalsMapping.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   EntitySignalsMapping response =
   *       entitySignalsMappingServiceClient.updateEntitySignalsMapping(
   *           entitySignalsMapping, updateMask);
   * }
   * }</pre>
   *
   * @param entitySignalsMapping Required. The `EntitySignalsMapping` to update.
   *     <p>The EntitySignalsMapping's name is used to identify the EntitySignalsMapping to update.
   *     Format: `networks/{network_code}/entitySignalsMappings/{entity_signals_mapping}`
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntitySignalsMapping updateEntitySignalsMapping(
      EntitySignalsMapping entitySignalsMapping, FieldMask updateMask) {
    UpdateEntitySignalsMappingRequest request =
        UpdateEntitySignalsMappingRequest.newBuilder()
            .setEntitySignalsMapping(entitySignalsMapping)
            .setUpdateMask(updateMask)
            .build();
    return updateEntitySignalsMapping(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update an `EntitySignalsMapping` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   UpdateEntitySignalsMappingRequest request =
   *       UpdateEntitySignalsMappingRequest.newBuilder()
   *           .setEntitySignalsMapping(EntitySignalsMapping.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   EntitySignalsMapping response =
   *       entitySignalsMappingServiceClient.updateEntitySignalsMapping(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntitySignalsMapping updateEntitySignalsMapping(
      UpdateEntitySignalsMappingRequest request) {
    return updateEntitySignalsMappingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update an `EntitySignalsMapping` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   UpdateEntitySignalsMappingRequest request =
   *       UpdateEntitySignalsMappingRequest.newBuilder()
   *           .setEntitySignalsMapping(EntitySignalsMapping.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<EntitySignalsMapping> future =
   *       entitySignalsMappingServiceClient
   *           .updateEntitySignalsMappingCallable()
   *           .futureCall(request);
   *   // Do something.
   *   EntitySignalsMapping response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEntitySignalsMappingRequest, EntitySignalsMapping>
      updateEntitySignalsMappingCallable() {
    return stub.updateEntitySignalsMappingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `EntitySignalsMapping` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateEntitySignalsMappingRequest> requests = new ArrayList<>();
   *   BatchCreateEntitySignalsMappingsResponse response =
   *       entitySignalsMappingServiceClient.batchCreateEntitySignalsMappings(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `EntitySignalsMappings` will be created.
   *     Format: `networks/{network_code}` The parent field in the CreateEntitySignalsMappingRequest
   *     must match this field.
   * @param requests Required. The `EntitySignalsMapping` objects to create. A maximum of 100
   *     objects can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateEntitySignalsMappingsResponse batchCreateEntitySignalsMappings(
      NetworkName parent, List<CreateEntitySignalsMappingRequest> requests) {
    BatchCreateEntitySignalsMappingsRequest request =
        BatchCreateEntitySignalsMappingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateEntitySignalsMappings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `EntitySignalsMapping` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateEntitySignalsMappingRequest> requests = new ArrayList<>();
   *   BatchCreateEntitySignalsMappingsResponse response =
   *       entitySignalsMappingServiceClient.batchCreateEntitySignalsMappings(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `EntitySignalsMappings` will be created.
   *     Format: `networks/{network_code}` The parent field in the CreateEntitySignalsMappingRequest
   *     must match this field.
   * @param requests Required. The `EntitySignalsMapping` objects to create. A maximum of 100
   *     objects can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateEntitySignalsMappingsResponse batchCreateEntitySignalsMappings(
      String parent, List<CreateEntitySignalsMappingRequest> requests) {
    BatchCreateEntitySignalsMappingsRequest request =
        BatchCreateEntitySignalsMappingsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateEntitySignalsMappings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `EntitySignalsMapping` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   BatchCreateEntitySignalsMappingsRequest request =
   *       BatchCreateEntitySignalsMappingsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateEntitySignalsMappingRequest>())
   *           .build();
   *   BatchCreateEntitySignalsMappingsResponse response =
   *       entitySignalsMappingServiceClient.batchCreateEntitySignalsMappings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateEntitySignalsMappingsResponse batchCreateEntitySignalsMappings(
      BatchCreateEntitySignalsMappingsRequest request) {
    return batchCreateEntitySignalsMappingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `EntitySignalsMapping` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   BatchCreateEntitySignalsMappingsRequest request =
   *       BatchCreateEntitySignalsMappingsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateEntitySignalsMappingRequest>())
   *           .build();
   *   ApiFuture<BatchCreateEntitySignalsMappingsResponse> future =
   *       entitySignalsMappingServiceClient
   *           .batchCreateEntitySignalsMappingsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchCreateEntitySignalsMappingsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchCreateEntitySignalsMappingsRequest, BatchCreateEntitySignalsMappingsResponse>
      batchCreateEntitySignalsMappingsCallable() {
    return stub.batchCreateEntitySignalsMappingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `EntitySignalsMapping` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateEntitySignalsMappingRequest> requests = new ArrayList<>();
   *   BatchUpdateEntitySignalsMappingsResponse response =
   *       entitySignalsMappingServiceClient.batchUpdateEntitySignalsMappings(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `EntitySignalsMappings` will be updated.
   *     Format: `networks/{network_code}` The parent field in the UpdateEntitySignalsMappingRequest
   *     must match this field.
   * @param requests Required. The `EntitySignalsMapping` objects to update. A maximum of 100
   *     objects can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateEntitySignalsMappingsResponse batchUpdateEntitySignalsMappings(
      NetworkName parent, List<UpdateEntitySignalsMappingRequest> requests) {
    BatchUpdateEntitySignalsMappingsRequest request =
        BatchUpdateEntitySignalsMappingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateEntitySignalsMappings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `EntitySignalsMapping` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateEntitySignalsMappingRequest> requests = new ArrayList<>();
   *   BatchUpdateEntitySignalsMappingsResponse response =
   *       entitySignalsMappingServiceClient.batchUpdateEntitySignalsMappings(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `EntitySignalsMappings` will be updated.
   *     Format: `networks/{network_code}` The parent field in the UpdateEntitySignalsMappingRequest
   *     must match this field.
   * @param requests Required. The `EntitySignalsMapping` objects to update. A maximum of 100
   *     objects can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateEntitySignalsMappingsResponse batchUpdateEntitySignalsMappings(
      String parent, List<UpdateEntitySignalsMappingRequest> requests) {
    BatchUpdateEntitySignalsMappingsRequest request =
        BatchUpdateEntitySignalsMappingsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateEntitySignalsMappings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `EntitySignalsMapping` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   BatchUpdateEntitySignalsMappingsRequest request =
   *       BatchUpdateEntitySignalsMappingsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateEntitySignalsMappingRequest>())
   *           .build();
   *   BatchUpdateEntitySignalsMappingsResponse response =
   *       entitySignalsMappingServiceClient.batchUpdateEntitySignalsMappings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateEntitySignalsMappingsResponse batchUpdateEntitySignalsMappings(
      BatchUpdateEntitySignalsMappingsRequest request) {
    return batchUpdateEntitySignalsMappingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `EntitySignalsMapping` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EntitySignalsMappingServiceClient entitySignalsMappingServiceClient =
   *     EntitySignalsMappingServiceClient.create()) {
   *   BatchUpdateEntitySignalsMappingsRequest request =
   *       BatchUpdateEntitySignalsMappingsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateEntitySignalsMappingRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateEntitySignalsMappingsResponse> future =
   *       entitySignalsMappingServiceClient
   *           .batchUpdateEntitySignalsMappingsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchUpdateEntitySignalsMappingsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchUpdateEntitySignalsMappingsRequest, BatchUpdateEntitySignalsMappingsResponse>
      batchUpdateEntitySignalsMappingsCallable() {
    return stub.batchUpdateEntitySignalsMappingsCallable();
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

  public static class ListEntitySignalsMappingsPagedResponse
      extends AbstractPagedListResponse<
          ListEntitySignalsMappingsRequest,
          ListEntitySignalsMappingsResponse,
          EntitySignalsMapping,
          ListEntitySignalsMappingsPage,
          ListEntitySignalsMappingsFixedSizeCollection> {

    public static ApiFuture<ListEntitySignalsMappingsPagedResponse> createAsync(
        PageContext<
                ListEntitySignalsMappingsRequest,
                ListEntitySignalsMappingsResponse,
                EntitySignalsMapping>
            context,
        ApiFuture<ListEntitySignalsMappingsResponse> futureResponse) {
      ApiFuture<ListEntitySignalsMappingsPage> futurePage =
          ListEntitySignalsMappingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEntitySignalsMappingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEntitySignalsMappingsPagedResponse(ListEntitySignalsMappingsPage page) {
      super(page, ListEntitySignalsMappingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEntitySignalsMappingsPage
      extends AbstractPage<
          ListEntitySignalsMappingsRequest,
          ListEntitySignalsMappingsResponse,
          EntitySignalsMapping,
          ListEntitySignalsMappingsPage> {

    private ListEntitySignalsMappingsPage(
        PageContext<
                ListEntitySignalsMappingsRequest,
                ListEntitySignalsMappingsResponse,
                EntitySignalsMapping>
            context,
        ListEntitySignalsMappingsResponse response) {
      super(context, response);
    }

    private static ListEntitySignalsMappingsPage createEmptyPage() {
      return new ListEntitySignalsMappingsPage(null, null);
    }

    @Override
    protected ListEntitySignalsMappingsPage createPage(
        PageContext<
                ListEntitySignalsMappingsRequest,
                ListEntitySignalsMappingsResponse,
                EntitySignalsMapping>
            context,
        ListEntitySignalsMappingsResponse response) {
      return new ListEntitySignalsMappingsPage(context, response);
    }

    @Override
    public ApiFuture<ListEntitySignalsMappingsPage> createPageAsync(
        PageContext<
                ListEntitySignalsMappingsRequest,
                ListEntitySignalsMappingsResponse,
                EntitySignalsMapping>
            context,
        ApiFuture<ListEntitySignalsMappingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEntitySignalsMappingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEntitySignalsMappingsRequest,
          ListEntitySignalsMappingsResponse,
          EntitySignalsMapping,
          ListEntitySignalsMappingsPage,
          ListEntitySignalsMappingsFixedSizeCollection> {

    private ListEntitySignalsMappingsFixedSizeCollection(
        List<ListEntitySignalsMappingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEntitySignalsMappingsFixedSizeCollection createEmptyCollection() {
      return new ListEntitySignalsMappingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEntitySignalsMappingsFixedSizeCollection createCollection(
        List<ListEntitySignalsMappingsPage> pages, int collectionSize) {
      return new ListEntitySignalsMappingsFixedSizeCollection(pages, collectionSize);
    }
  }
}
