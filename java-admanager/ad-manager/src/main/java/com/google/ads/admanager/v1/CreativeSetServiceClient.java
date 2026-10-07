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

import com.google.ads.admanager.v1.stub.CreativeSetServiceStub;
import com.google.ads.admanager.v1.stub.CreativeSetServiceStubSettings;
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
 * Service Description: Provides methods for handling `CreativeSet` objects.
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
 * try (CreativeSetServiceClient creativeSetServiceClient = CreativeSetServiceClient.create()) {
 *   CreativeSetName name = CreativeSetName.of("[NETWORK_CODE]", "[CREATIVE_SET]");
 *   CreativeSet response = creativeSetServiceClient.getCreativeSet(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CreativeSetServiceClient object to clean up resources
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
 *      <td><p> GetCreativeSet</td>
 *      <td><p> Retrieves a `CreativeSet` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCreativeSet(GetCreativeSetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCreativeSet(CreativeSetName name)
 *           <li><p> getCreativeSet(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCreativeSetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCreativeSets</td>
 *      <td><p> Lists `CreativeSet` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCreativeSets(ListCreativeSetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCreativeSets(NetworkName parent)
 *           <li><p> listCreativeSets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCreativeSetsPagedCallable()
 *           <li><p> listCreativeSetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCreativeSet</td>
 *      <td><p> Creates a `CreativeSet` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCreativeSet(CreateCreativeSetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createCreativeSet(NetworkName parent, CreativeSet creativeSet)
 *           <li><p> createCreativeSet(String parent, CreativeSet creativeSet)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCreativeSetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCreativeSet</td>
 *      <td><p> Updates a `CreativeSet` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCreativeSet(UpdateCreativeSetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateCreativeSet(CreativeSet creativeSet, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCreativeSetCallable()
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
 * <p>This class can be customized by passing in a custom instance of CreativeSetServiceSettings to
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
 * CreativeSetServiceSettings creativeSetServiceSettings =
 *     CreativeSetServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CreativeSetServiceClient creativeSetServiceClient =
 *     CreativeSetServiceClient.create(creativeSetServiceSettings);
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
 * CreativeSetServiceSettings creativeSetServiceSettings =
 *     CreativeSetServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CreativeSetServiceClient creativeSetServiceClient =
 *     CreativeSetServiceClient.create(creativeSetServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class CreativeSetServiceClient implements BackgroundResource {
  private final @Nullable CreativeSetServiceSettings settings;
  private final CreativeSetServiceStub stub;

  /** Constructs an instance of CreativeSetServiceClient with default settings. */
  public static final CreativeSetServiceClient create() throws IOException {
    return create(CreativeSetServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CreativeSetServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CreativeSetServiceClient create(CreativeSetServiceSettings settings)
      throws IOException {
    return new CreativeSetServiceClient(settings);
  }

  /**
   * Constructs an instance of CreativeSetServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(CreativeSetServiceSettings).
   */
  public static final CreativeSetServiceClient create(CreativeSetServiceStub stub) {
    return new CreativeSetServiceClient(stub);
  }

  /**
   * Constructs an instance of CreativeSetServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CreativeSetServiceClient(CreativeSetServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CreativeSetServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CreativeSetServiceClient(CreativeSetServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable CreativeSetServiceSettings getSettings() {
    return settings;
  }

  public CreativeSetServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `CreativeSet` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeSetServiceClient creativeSetServiceClient = CreativeSetServiceClient.create()) {
   *   CreativeSetName name = CreativeSetName.of("[NETWORK_CODE]", "[CREATIVE_SET]");
   *   CreativeSet response = creativeSetServiceClient.getCreativeSet(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CreativeSet. Format:
   *     `networks/{network_code}/creativeSets/{creative_set_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeSet getCreativeSet(@Nullable CreativeSetName name) {
    GetCreativeSetRequest request =
        GetCreativeSetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCreativeSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `CreativeSet` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeSetServiceClient creativeSetServiceClient = CreativeSetServiceClient.create()) {
   *   String name = CreativeSetName.of("[NETWORK_CODE]", "[CREATIVE_SET]").toString();
   *   CreativeSet response = creativeSetServiceClient.getCreativeSet(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CreativeSet. Format:
   *     `networks/{network_code}/creativeSets/{creative_set_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeSet getCreativeSet(String name) {
    GetCreativeSetRequest request = GetCreativeSetRequest.newBuilder().setName(name).build();
    return getCreativeSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `CreativeSet` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeSetServiceClient creativeSetServiceClient = CreativeSetServiceClient.create()) {
   *   GetCreativeSetRequest request =
   *       GetCreativeSetRequest.newBuilder()
   *           .setName(CreativeSetName.of("[NETWORK_CODE]", "[CREATIVE_SET]").toString())
   *           .build();
   *   CreativeSet response = creativeSetServiceClient.getCreativeSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeSet getCreativeSet(GetCreativeSetRequest request) {
    return getCreativeSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `CreativeSet` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeSetServiceClient creativeSetServiceClient = CreativeSetServiceClient.create()) {
   *   GetCreativeSetRequest request =
   *       GetCreativeSetRequest.newBuilder()
   *           .setName(CreativeSetName.of("[NETWORK_CODE]", "[CREATIVE_SET]").toString())
   *           .build();
   *   ApiFuture<CreativeSet> future =
   *       creativeSetServiceClient.getCreativeSetCallable().futureCall(request);
   *   // Do something.
   *   CreativeSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCreativeSetRequest, CreativeSet> getCreativeSetCallable() {
    return stub.getCreativeSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CreativeSet` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeSetServiceClient creativeSetServiceClient = CreativeSetServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (CreativeSet element : creativeSetServiceClient.listCreativeSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CreativeSets. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCreativeSetsPagedResponse listCreativeSets(@Nullable NetworkName parent) {
    ListCreativeSetsRequest request =
        ListCreativeSetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCreativeSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CreativeSet` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeSetServiceClient creativeSetServiceClient = CreativeSetServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (CreativeSet element : creativeSetServiceClient.listCreativeSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CreativeSets. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCreativeSetsPagedResponse listCreativeSets(String parent) {
    ListCreativeSetsRequest request =
        ListCreativeSetsRequest.newBuilder().setParent(parent).build();
    return listCreativeSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CreativeSet` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeSetServiceClient creativeSetServiceClient = CreativeSetServiceClient.create()) {
   *   ListCreativeSetsRequest request =
   *       ListCreativeSetsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (CreativeSet element : creativeSetServiceClient.listCreativeSets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCreativeSetsPagedResponse listCreativeSets(ListCreativeSetsRequest request) {
    return listCreativeSetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CreativeSet` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeSetServiceClient creativeSetServiceClient = CreativeSetServiceClient.create()) {
   *   ListCreativeSetsRequest request =
   *       ListCreativeSetsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<CreativeSet> future =
   *       creativeSetServiceClient.listCreativeSetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CreativeSet element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCreativeSetsRequest, ListCreativeSetsPagedResponse>
      listCreativeSetsPagedCallable() {
    return stub.listCreativeSetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CreativeSet` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeSetServiceClient creativeSetServiceClient = CreativeSetServiceClient.create()) {
   *   ListCreativeSetsRequest request =
   *       ListCreativeSetsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListCreativeSetsResponse response =
   *         creativeSetServiceClient.listCreativeSetsCallable().call(request);
   *     for (CreativeSet element : response.getCreativeSetsList()) {
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
  public final UnaryCallable<ListCreativeSetsRequest, ListCreativeSetsResponse>
      listCreativeSetsCallable() {
    return stub.listCreativeSetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `CreativeSet` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeSetServiceClient creativeSetServiceClient = CreativeSetServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   CreativeSet creativeSet = CreativeSet.newBuilder().build();
   *   CreativeSet response = creativeSetServiceClient.createCreativeSet(parent, creativeSet);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `CreativeSet` will be created. Format:
   *     `networks/{network_code}`
   * @param creativeSet Required. The `CreativeSet` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeSet createCreativeSet(
      @Nullable NetworkName parent, CreativeSet creativeSet) {
    CreateCreativeSetRequest request =
        CreateCreativeSetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCreativeSet(creativeSet)
            .build();
    return createCreativeSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `CreativeSet` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeSetServiceClient creativeSetServiceClient = CreativeSetServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   CreativeSet creativeSet = CreativeSet.newBuilder().build();
   *   CreativeSet response = creativeSetServiceClient.createCreativeSet(parent, creativeSet);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `CreativeSet` will be created. Format:
   *     `networks/{network_code}`
   * @param creativeSet Required. The `CreativeSet` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeSet createCreativeSet(String parent, CreativeSet creativeSet) {
    CreateCreativeSetRequest request =
        CreateCreativeSetRequest.newBuilder().setParent(parent).setCreativeSet(creativeSet).build();
    return createCreativeSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `CreativeSet` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeSetServiceClient creativeSetServiceClient = CreativeSetServiceClient.create()) {
   *   CreateCreativeSetRequest request =
   *       CreateCreativeSetRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setCreativeSet(CreativeSet.newBuilder().build())
   *           .build();
   *   CreativeSet response = creativeSetServiceClient.createCreativeSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeSet createCreativeSet(CreateCreativeSetRequest request) {
    return createCreativeSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `CreativeSet` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeSetServiceClient creativeSetServiceClient = CreativeSetServiceClient.create()) {
   *   CreateCreativeSetRequest request =
   *       CreateCreativeSetRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setCreativeSet(CreativeSet.newBuilder().build())
   *           .build();
   *   ApiFuture<CreativeSet> future =
   *       creativeSetServiceClient.createCreativeSetCallable().futureCall(request);
   *   // Do something.
   *   CreativeSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCreativeSetRequest, CreativeSet> createCreativeSetCallable() {
    return stub.createCreativeSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `CreativeSet` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeSetServiceClient creativeSetServiceClient = CreativeSetServiceClient.create()) {
   *   CreativeSet creativeSet = CreativeSet.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CreativeSet response = creativeSetServiceClient.updateCreativeSet(creativeSet, updateMask);
   * }
   * }</pre>
   *
   * @param creativeSet Required. The `CreativeSet` to update.
   *     <p>The `CreativeSet`'s `name` is used to identify the `CreativeSet` to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeSet updateCreativeSet(CreativeSet creativeSet, FieldMask updateMask) {
    UpdateCreativeSetRequest request =
        UpdateCreativeSetRequest.newBuilder()
            .setCreativeSet(creativeSet)
            .setUpdateMask(updateMask)
            .build();
    return updateCreativeSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `CreativeSet` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeSetServiceClient creativeSetServiceClient = CreativeSetServiceClient.create()) {
   *   UpdateCreativeSetRequest request =
   *       UpdateCreativeSetRequest.newBuilder()
   *           .setCreativeSet(CreativeSet.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CreativeSet response = creativeSetServiceClient.updateCreativeSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeSet updateCreativeSet(UpdateCreativeSetRequest request) {
    return updateCreativeSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `CreativeSet` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeSetServiceClient creativeSetServiceClient = CreativeSetServiceClient.create()) {
   *   UpdateCreativeSetRequest request =
   *       UpdateCreativeSetRequest.newBuilder()
   *           .setCreativeSet(CreativeSet.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CreativeSet> future =
   *       creativeSetServiceClient.updateCreativeSetCallable().futureCall(request);
   *   // Do something.
   *   CreativeSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCreativeSetRequest, CreativeSet> updateCreativeSetCallable() {
    return stub.updateCreativeSetCallable();
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

  public static class ListCreativeSetsPagedResponse
      extends AbstractPagedListResponse<
          ListCreativeSetsRequest,
          ListCreativeSetsResponse,
          CreativeSet,
          ListCreativeSetsPage,
          ListCreativeSetsFixedSizeCollection> {

    public static ApiFuture<ListCreativeSetsPagedResponse> createAsync(
        PageContext<ListCreativeSetsRequest, ListCreativeSetsResponse, CreativeSet> context,
        ApiFuture<ListCreativeSetsResponse> futureResponse) {
      ApiFuture<ListCreativeSetsPage> futurePage =
          ListCreativeSetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCreativeSetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCreativeSetsPagedResponse(ListCreativeSetsPage page) {
      super(page, ListCreativeSetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCreativeSetsPage
      extends AbstractPage<
          ListCreativeSetsRequest, ListCreativeSetsResponse, CreativeSet, ListCreativeSetsPage> {

    private ListCreativeSetsPage(
        @Nullable PageContext<ListCreativeSetsRequest, ListCreativeSetsResponse, CreativeSet>
            context,
        @Nullable ListCreativeSetsResponse response) {
      super(context, response);
    }

    private static ListCreativeSetsPage createEmptyPage() {
      return new ListCreativeSetsPage(null, null);
    }

    @Override
    protected ListCreativeSetsPage createPage(
        @Nullable PageContext<ListCreativeSetsRequest, ListCreativeSetsResponse, CreativeSet>
            context,
        @Nullable ListCreativeSetsResponse response) {
      return new ListCreativeSetsPage(context, response);
    }

    @Override
    public ApiFuture<ListCreativeSetsPage> createPageAsync(
        @Nullable PageContext<ListCreativeSetsRequest, ListCreativeSetsResponse, CreativeSet>
            context,
        ApiFuture<ListCreativeSetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCreativeSetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCreativeSetsRequest,
          ListCreativeSetsResponse,
          CreativeSet,
          ListCreativeSetsPage,
          ListCreativeSetsFixedSizeCollection> {

    private ListCreativeSetsFixedSizeCollection(
        @Nullable List<ListCreativeSetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCreativeSetsFixedSizeCollection createEmptyCollection() {
      return new ListCreativeSetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCreativeSetsFixedSizeCollection createCollection(
        @Nullable List<ListCreativeSetsPage> pages, int collectionSize) {
      return new ListCreativeSetsFixedSizeCollection(pages, collectionSize);
    }
  }
}
