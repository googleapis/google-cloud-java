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

import com.google.ads.admanager.v1.stub.CustomTargetingKeyServiceStub;
import com.google.ads.admanager.v1.stub.CustomTargetingKeyServiceStubSettings;
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
 * Service Description: Provides methods for handling `CustomTargetingKey` objects.
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
 * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
 *     CustomTargetingKeyServiceClient.create()) {
 *   CustomTargetingKeyName name =
 *       CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]");
 *   CustomTargetingKey response = customTargetingKeyServiceClient.getCustomTargetingKey(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CustomTargetingKeyServiceClient object to clean up
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
 *      <td><p> GetCustomTargetingKey</td>
 *      <td><p> API to retrieve a `CustomTargetingKey` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCustomTargetingKey(GetCustomTargetingKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCustomTargetingKey(CustomTargetingKeyName name)
 *           <li><p> getCustomTargetingKey(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCustomTargetingKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCustomTargetingKeys</td>
 *      <td><p> API to retrieve a list of `CustomTargetingKey` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCustomTargetingKeys(ListCustomTargetingKeysRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCustomTargetingKeys(NetworkName parent)
 *           <li><p> listCustomTargetingKeys(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCustomTargetingKeysPagedCallable()
 *           <li><p> listCustomTargetingKeysCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCustomTargetingKey</td>
 *      <td><p> API to create a `CustomTargetingKey` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCustomTargetingKey(CreateCustomTargetingKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createCustomTargetingKey(NetworkName parent, CustomTargetingKey customTargetingKey)
 *           <li><p> createCustomTargetingKey(String parent, CustomTargetingKey customTargetingKey)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCustomTargetingKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateCustomTargetingKeys</td>
 *      <td><p> API to batch create `CustomTargetingKey` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateCustomTargetingKeys(NetworkName parent, List&lt;CreateCustomTargetingKeyRequest&gt; requests)
 *           <li><p> batchCreateCustomTargetingKeys(String parent, List&lt;CreateCustomTargetingKeyRequest&gt; requests)
 *           <li><p> batchCreateCustomTargetingKeys(BatchCreateCustomTargetingKeysRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateCustomTargetingKeysCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCustomTargetingKey</td>
 *      <td><p> API to update a `CustomTargetingKey` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCustomTargetingKey(UpdateCustomTargetingKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateCustomTargetingKey(CustomTargetingKey customTargetingKey, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCustomTargetingKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateCustomTargetingKeys</td>
 *      <td><p> API to batch update `CustomTargetingKey` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateCustomTargetingKeys(NetworkName parent, List&lt;UpdateCustomTargetingKeyRequest&gt; requests)
 *           <li><p> batchUpdateCustomTargetingKeys(String parent, List&lt;UpdateCustomTargetingKeyRequest&gt; requests)
 *           <li><p> batchUpdateCustomTargetingKeys(BatchUpdateCustomTargetingKeysRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateCustomTargetingKeysCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchActivateCustomTargetingKeys</td>
 *      <td><p> API to batch activate `CustomTargetingKey` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchActivateCustomTargetingKeys(BatchActivateCustomTargetingKeysRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchActivateCustomTargetingKeys(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchActivateCustomTargetingKeys(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchActivateCustomTargetingKeysCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeactivateCustomTargetingKeys</td>
 *      <td><p> Deactivates a list of `CustomTargetingKey` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeactivateCustomTargetingKeys(BatchDeactivateCustomTargetingKeysRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDeactivateCustomTargetingKeys(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchDeactivateCustomTargetingKeys(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeactivateCustomTargetingKeysCallable()
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
 * CustomTargetingKeyServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CustomTargetingKeyServiceSettings customTargetingKeyServiceSettings =
 *     CustomTargetingKeyServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
 *     CustomTargetingKeyServiceClient.create(customTargetingKeyServiceSettings);
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
 * CustomTargetingKeyServiceSettings customTargetingKeyServiceSettings =
 *     CustomTargetingKeyServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
 *     CustomTargetingKeyServiceClient.create(customTargetingKeyServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CustomTargetingKeyServiceClient implements BackgroundResource {
  private final CustomTargetingKeyServiceSettings settings;
  private final CustomTargetingKeyServiceStub stub;

  /** Constructs an instance of CustomTargetingKeyServiceClient with default settings. */
  public static final CustomTargetingKeyServiceClient create() throws IOException {
    return create(CustomTargetingKeyServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CustomTargetingKeyServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final CustomTargetingKeyServiceClient create(
      CustomTargetingKeyServiceSettings settings) throws IOException {
    return new CustomTargetingKeyServiceClient(settings);
  }

  /**
   * Constructs an instance of CustomTargetingKeyServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(CustomTargetingKeyServiceSettings).
   */
  public static final CustomTargetingKeyServiceClient create(CustomTargetingKeyServiceStub stub) {
    return new CustomTargetingKeyServiceClient(stub);
  }

  /**
   * Constructs an instance of CustomTargetingKeyServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CustomTargetingKeyServiceClient(CustomTargetingKeyServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((CustomTargetingKeyServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CustomTargetingKeyServiceClient(CustomTargetingKeyServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CustomTargetingKeyServiceSettings getSettings() {
    return settings;
  }

  public CustomTargetingKeyServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CustomTargetingKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   CustomTargetingKeyName name =
   *       CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]");
   *   CustomTargetingKey response = customTargetingKeyServiceClient.getCustomTargetingKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomTargetingKey. Format:
   *     `networks/{network_code}/customTargetingKeys/{custom_targeting_key_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingKey getCustomTargetingKey(CustomTargetingKeyName name) {
    GetCustomTargetingKeyRequest request =
        GetCustomTargetingKeyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCustomTargetingKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CustomTargetingKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   String name =
   *       CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]").toString();
   *   CustomTargetingKey response = customTargetingKeyServiceClient.getCustomTargetingKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomTargetingKey. Format:
   *     `networks/{network_code}/customTargetingKeys/{custom_targeting_key_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingKey getCustomTargetingKey(String name) {
    GetCustomTargetingKeyRequest request =
        GetCustomTargetingKeyRequest.newBuilder().setName(name).build();
    return getCustomTargetingKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CustomTargetingKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   GetCustomTargetingKeyRequest request =
   *       GetCustomTargetingKeyRequest.newBuilder()
   *           .setName(
   *               CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]").toString())
   *           .build();
   *   CustomTargetingKey response = customTargetingKeyServiceClient.getCustomTargetingKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingKey getCustomTargetingKey(GetCustomTargetingKeyRequest request) {
    return getCustomTargetingKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CustomTargetingKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   GetCustomTargetingKeyRequest request =
   *       GetCustomTargetingKeyRequest.newBuilder()
   *           .setName(
   *               CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]").toString())
   *           .build();
   *   ApiFuture<CustomTargetingKey> future =
   *       customTargetingKeyServiceClient.getCustomTargetingKeyCallable().futureCall(request);
   *   // Do something.
   *   CustomTargetingKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCustomTargetingKeyRequest, CustomTargetingKey>
      getCustomTargetingKeyCallable() {
    return stub.getCustomTargetingKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (CustomTargetingKey element :
   *       customTargetingKeyServiceClient.listCustomTargetingKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomTargetingKeys. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomTargetingKeysPagedResponse listCustomTargetingKeys(NetworkName parent) {
    ListCustomTargetingKeysRequest request =
        ListCustomTargetingKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCustomTargetingKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (CustomTargetingKey element :
   *       customTargetingKeyServiceClient.listCustomTargetingKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomTargetingKeys. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomTargetingKeysPagedResponse listCustomTargetingKeys(String parent) {
    ListCustomTargetingKeysRequest request =
        ListCustomTargetingKeysRequest.newBuilder().setParent(parent).build();
    return listCustomTargetingKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   ListCustomTargetingKeysRequest request =
   *       ListCustomTargetingKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (CustomTargetingKey element :
   *       customTargetingKeyServiceClient.listCustomTargetingKeys(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomTargetingKeysPagedResponse listCustomTargetingKeys(
      ListCustomTargetingKeysRequest request) {
    return listCustomTargetingKeysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   ListCustomTargetingKeysRequest request =
   *       ListCustomTargetingKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<CustomTargetingKey> future =
   *       customTargetingKeyServiceClient
   *           .listCustomTargetingKeysPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (CustomTargetingKey element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCustomTargetingKeysRequest, ListCustomTargetingKeysPagedResponse>
      listCustomTargetingKeysPagedCallable() {
    return stub.listCustomTargetingKeysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   ListCustomTargetingKeysRequest request =
   *       ListCustomTargetingKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListCustomTargetingKeysResponse response =
   *         customTargetingKeyServiceClient.listCustomTargetingKeysCallable().call(request);
   *     for (CustomTargetingKey element : response.getCustomTargetingKeysList()) {
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
  public final UnaryCallable<ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse>
      listCustomTargetingKeysCallable() {
    return stub.listCustomTargetingKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `CustomTargetingKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   CustomTargetingKey customTargetingKey = CustomTargetingKey.newBuilder().build();
   *   CustomTargetingKey response =
   *       customTargetingKeyServiceClient.createCustomTargetingKey(parent, customTargetingKey);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `CustomTargetingKey` will be created.
   *     Format: `networks/{network_code}`
   * @param customTargetingKey Required. The `CustomTargetingKey` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingKey createCustomTargetingKey(
      NetworkName parent, CustomTargetingKey customTargetingKey) {
    CreateCustomTargetingKeyRequest request =
        CreateCustomTargetingKeyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCustomTargetingKey(customTargetingKey)
            .build();
    return createCustomTargetingKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `CustomTargetingKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   CustomTargetingKey customTargetingKey = CustomTargetingKey.newBuilder().build();
   *   CustomTargetingKey response =
   *       customTargetingKeyServiceClient.createCustomTargetingKey(parent, customTargetingKey);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `CustomTargetingKey` will be created.
   *     Format: `networks/{network_code}`
   * @param customTargetingKey Required. The `CustomTargetingKey` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingKey createCustomTargetingKey(
      String parent, CustomTargetingKey customTargetingKey) {
    CreateCustomTargetingKeyRequest request =
        CreateCustomTargetingKeyRequest.newBuilder()
            .setParent(parent)
            .setCustomTargetingKey(customTargetingKey)
            .build();
    return createCustomTargetingKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `CustomTargetingKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   CreateCustomTargetingKeyRequest request =
   *       CreateCustomTargetingKeyRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setCustomTargetingKey(CustomTargetingKey.newBuilder().build())
   *           .build();
   *   CustomTargetingKey response =
   *       customTargetingKeyServiceClient.createCustomTargetingKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingKey createCustomTargetingKey(
      CreateCustomTargetingKeyRequest request) {
    return createCustomTargetingKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `CustomTargetingKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   CreateCustomTargetingKeyRequest request =
   *       CreateCustomTargetingKeyRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setCustomTargetingKey(CustomTargetingKey.newBuilder().build())
   *           .build();
   *   ApiFuture<CustomTargetingKey> future =
   *       customTargetingKeyServiceClient.createCustomTargetingKeyCallable().futureCall(request);
   *   // Do something.
   *   CustomTargetingKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCustomTargetingKeyRequest, CustomTargetingKey>
      createCustomTargetingKeyCallable() {
    return stub.createCustomTargetingKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateCustomTargetingKeyRequest> requests = new ArrayList<>();
   *   BatchCreateCustomTargetingKeysResponse response =
   *       customTargetingKeyServiceClient.batchCreateCustomTargetingKeys(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `CustomTargetingKeys` will be created.
   *     Format: `networks/{network_code}` The parent field in the CreateCustomTargetingKeyRequest
   *     must match this field.
   * @param requests Required. The `CustomTargetingKey` objects to create. A maximum of 100 objects
   *     can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateCustomTargetingKeysResponse batchCreateCustomTargetingKeys(
      NetworkName parent, List<CreateCustomTargetingKeyRequest> requests) {
    BatchCreateCustomTargetingKeysRequest request =
        BatchCreateCustomTargetingKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateCustomTargetingKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateCustomTargetingKeyRequest> requests = new ArrayList<>();
   *   BatchCreateCustomTargetingKeysResponse response =
   *       customTargetingKeyServiceClient.batchCreateCustomTargetingKeys(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `CustomTargetingKeys` will be created.
   *     Format: `networks/{network_code}` The parent field in the CreateCustomTargetingKeyRequest
   *     must match this field.
   * @param requests Required. The `CustomTargetingKey` objects to create. A maximum of 100 objects
   *     can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateCustomTargetingKeysResponse batchCreateCustomTargetingKeys(
      String parent, List<CreateCustomTargetingKeyRequest> requests) {
    BatchCreateCustomTargetingKeysRequest request =
        BatchCreateCustomTargetingKeysRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateCustomTargetingKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   BatchCreateCustomTargetingKeysRequest request =
   *       BatchCreateCustomTargetingKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateCustomTargetingKeyRequest>())
   *           .build();
   *   BatchCreateCustomTargetingKeysResponse response =
   *       customTargetingKeyServiceClient.batchCreateCustomTargetingKeys(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateCustomTargetingKeysResponse batchCreateCustomTargetingKeys(
      BatchCreateCustomTargetingKeysRequest request) {
    return batchCreateCustomTargetingKeysCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   BatchCreateCustomTargetingKeysRequest request =
   *       BatchCreateCustomTargetingKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateCustomTargetingKeyRequest>())
   *           .build();
   *   ApiFuture<BatchCreateCustomTargetingKeysResponse> future =
   *       customTargetingKeyServiceClient
   *           .batchCreateCustomTargetingKeysCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchCreateCustomTargetingKeysResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchCreateCustomTargetingKeysRequest, BatchCreateCustomTargetingKeysResponse>
      batchCreateCustomTargetingKeysCallable() {
    return stub.batchCreateCustomTargetingKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `CustomTargetingKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   CustomTargetingKey customTargetingKey = CustomTargetingKey.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CustomTargetingKey response =
   *       customTargetingKeyServiceClient.updateCustomTargetingKey(customTargetingKey, updateMask);
   * }
   * }</pre>
   *
   * @param customTargetingKey Required. The `CustomTargetingKey` to update.
   *     <p>The `CustomTargetingKey`'s `name` is used to identify the `CustomTargetingKey` to
   *     update.
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingKey updateCustomTargetingKey(
      CustomTargetingKey customTargetingKey, FieldMask updateMask) {
    UpdateCustomTargetingKeyRequest request =
        UpdateCustomTargetingKeyRequest.newBuilder()
            .setCustomTargetingKey(customTargetingKey)
            .setUpdateMask(updateMask)
            .build();
    return updateCustomTargetingKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `CustomTargetingKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   UpdateCustomTargetingKeyRequest request =
   *       UpdateCustomTargetingKeyRequest.newBuilder()
   *           .setCustomTargetingKey(CustomTargetingKey.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CustomTargetingKey response =
   *       customTargetingKeyServiceClient.updateCustomTargetingKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingKey updateCustomTargetingKey(
      UpdateCustomTargetingKeyRequest request) {
    return updateCustomTargetingKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `CustomTargetingKey` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   UpdateCustomTargetingKeyRequest request =
   *       UpdateCustomTargetingKeyRequest.newBuilder()
   *           .setCustomTargetingKey(CustomTargetingKey.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CustomTargetingKey> future =
   *       customTargetingKeyServiceClient.updateCustomTargetingKeyCallable().futureCall(request);
   *   // Do something.
   *   CustomTargetingKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCustomTargetingKeyRequest, CustomTargetingKey>
      updateCustomTargetingKeyCallable() {
    return stub.updateCustomTargetingKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateCustomTargetingKeyRequest> requests = new ArrayList<>();
   *   BatchUpdateCustomTargetingKeysResponse response =
   *       customTargetingKeyServiceClient.batchUpdateCustomTargetingKeys(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `CustomTargetingKeys` will be updated.
   *     Format: `networks/{network_code}` The parent field in the UpdateCustomTargetingKeyRequest
   *     must match this field.
   * @param requests Required. The `CustomTargetingKey` objects to update. A maximum of 100 objects
   *     can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateCustomTargetingKeysResponse batchUpdateCustomTargetingKeys(
      NetworkName parent, List<UpdateCustomTargetingKeyRequest> requests) {
    BatchUpdateCustomTargetingKeysRequest request =
        BatchUpdateCustomTargetingKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateCustomTargetingKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateCustomTargetingKeyRequest> requests = new ArrayList<>();
   *   BatchUpdateCustomTargetingKeysResponse response =
   *       customTargetingKeyServiceClient.batchUpdateCustomTargetingKeys(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `CustomTargetingKeys` will be updated.
   *     Format: `networks/{network_code}` The parent field in the UpdateCustomTargetingKeyRequest
   *     must match this field.
   * @param requests Required. The `CustomTargetingKey` objects to update. A maximum of 100 objects
   *     can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateCustomTargetingKeysResponse batchUpdateCustomTargetingKeys(
      String parent, List<UpdateCustomTargetingKeyRequest> requests) {
    BatchUpdateCustomTargetingKeysRequest request =
        BatchUpdateCustomTargetingKeysRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateCustomTargetingKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   BatchUpdateCustomTargetingKeysRequest request =
   *       BatchUpdateCustomTargetingKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateCustomTargetingKeyRequest>())
   *           .build();
   *   BatchUpdateCustomTargetingKeysResponse response =
   *       customTargetingKeyServiceClient.batchUpdateCustomTargetingKeys(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateCustomTargetingKeysResponse batchUpdateCustomTargetingKeys(
      BatchUpdateCustomTargetingKeysRequest request) {
    return batchUpdateCustomTargetingKeysCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   BatchUpdateCustomTargetingKeysRequest request =
   *       BatchUpdateCustomTargetingKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateCustomTargetingKeyRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateCustomTargetingKeysResponse> future =
   *       customTargetingKeyServiceClient
   *           .batchUpdateCustomTargetingKeysCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchUpdateCustomTargetingKeysResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchUpdateCustomTargetingKeysRequest, BatchUpdateCustomTargetingKeysResponse>
      batchUpdateCustomTargetingKeysCallable() {
    return stub.batchUpdateCustomTargetingKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch activate `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchActivateCustomTargetingKeysResponse response =
   *       customTargetingKeyServiceClient.batchActivateCustomTargetingKeys(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `CustomTargetingKey`s to activate. Format:
   *     `networks/{network_code}/customTargetingKeys/{custom_targeting_key_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateCustomTargetingKeysResponse batchActivateCustomTargetingKeys(
      NetworkName parent, List<String> names) {
    BatchActivateCustomTargetingKeysRequest request =
        BatchActivateCustomTargetingKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchActivateCustomTargetingKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch activate `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchActivateCustomTargetingKeysResponse response =
   *       customTargetingKeyServiceClient.batchActivateCustomTargetingKeys(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `CustomTargetingKey`s to activate. Format:
   *     `networks/{network_code}/customTargetingKeys/{custom_targeting_key_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateCustomTargetingKeysResponse batchActivateCustomTargetingKeys(
      String parent, List<String> names) {
    BatchActivateCustomTargetingKeysRequest request =
        BatchActivateCustomTargetingKeysRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchActivateCustomTargetingKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch activate `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   BatchActivateCustomTargetingKeysRequest request =
   *       BatchActivateCustomTargetingKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchActivateCustomTargetingKeysResponse response =
   *       customTargetingKeyServiceClient.batchActivateCustomTargetingKeys(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateCustomTargetingKeysResponse batchActivateCustomTargetingKeys(
      BatchActivateCustomTargetingKeysRequest request) {
    return batchActivateCustomTargetingKeysCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch activate `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   BatchActivateCustomTargetingKeysRequest request =
   *       BatchActivateCustomTargetingKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchActivateCustomTargetingKeysResponse> future =
   *       customTargetingKeyServiceClient
   *           .batchActivateCustomTargetingKeysCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchActivateCustomTargetingKeysResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchActivateCustomTargetingKeysRequest, BatchActivateCustomTargetingKeysResponse>
      batchActivateCustomTargetingKeysCallable() {
    return stub.batchActivateCustomTargetingKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateCustomTargetingKeysResponse response =
   *       customTargetingKeyServiceClient.batchDeactivateCustomTargetingKeys(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `CustomTargetingKey`s to deactivate. Format:
   *     `networks/{network_code}/customTargetingKeys/{custom_targeting_key_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateCustomTargetingKeysResponse batchDeactivateCustomTargetingKeys(
      NetworkName parent, List<String> names) {
    BatchDeactivateCustomTargetingKeysRequest request =
        BatchDeactivateCustomTargetingKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchDeactivateCustomTargetingKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateCustomTargetingKeysResponse response =
   *       customTargetingKeyServiceClient.batchDeactivateCustomTargetingKeys(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `CustomTargetingKey`s to deactivate. Format:
   *     `networks/{network_code}/customTargetingKeys/{custom_targeting_key_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateCustomTargetingKeysResponse batchDeactivateCustomTargetingKeys(
      String parent, List<String> names) {
    BatchDeactivateCustomTargetingKeysRequest request =
        BatchDeactivateCustomTargetingKeysRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchDeactivateCustomTargetingKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   BatchDeactivateCustomTargetingKeysRequest request =
   *       BatchDeactivateCustomTargetingKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchDeactivateCustomTargetingKeysResponse response =
   *       customTargetingKeyServiceClient.batchDeactivateCustomTargetingKeys(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateCustomTargetingKeysResponse batchDeactivateCustomTargetingKeys(
      BatchDeactivateCustomTargetingKeysRequest request) {
    return batchDeactivateCustomTargetingKeysCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `CustomTargetingKey` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingKeyServiceClient customTargetingKeyServiceClient =
   *     CustomTargetingKeyServiceClient.create()) {
   *   BatchDeactivateCustomTargetingKeysRequest request =
   *       BatchDeactivateCustomTargetingKeysRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchDeactivateCustomTargetingKeysResponse> future =
   *       customTargetingKeyServiceClient
   *           .batchDeactivateCustomTargetingKeysCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchDeactivateCustomTargetingKeysResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchDeactivateCustomTargetingKeysRequest, BatchDeactivateCustomTargetingKeysResponse>
      batchDeactivateCustomTargetingKeysCallable() {
    return stub.batchDeactivateCustomTargetingKeysCallable();
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

  public static class ListCustomTargetingKeysPagedResponse
      extends AbstractPagedListResponse<
          ListCustomTargetingKeysRequest,
          ListCustomTargetingKeysResponse,
          CustomTargetingKey,
          ListCustomTargetingKeysPage,
          ListCustomTargetingKeysFixedSizeCollection> {

    public static ApiFuture<ListCustomTargetingKeysPagedResponse> createAsync(
        PageContext<
                ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse, CustomTargetingKey>
            context,
        ApiFuture<ListCustomTargetingKeysResponse> futureResponse) {
      ApiFuture<ListCustomTargetingKeysPage> futurePage =
          ListCustomTargetingKeysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCustomTargetingKeysPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCustomTargetingKeysPagedResponse(ListCustomTargetingKeysPage page) {
      super(page, ListCustomTargetingKeysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCustomTargetingKeysPage
      extends AbstractPage<
          ListCustomTargetingKeysRequest,
          ListCustomTargetingKeysResponse,
          CustomTargetingKey,
          ListCustomTargetingKeysPage> {

    private ListCustomTargetingKeysPage(
        PageContext<
                ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse, CustomTargetingKey>
            context,
        ListCustomTargetingKeysResponse response) {
      super(context, response);
    }

    private static ListCustomTargetingKeysPage createEmptyPage() {
      return new ListCustomTargetingKeysPage(null, null);
    }

    @Override
    protected ListCustomTargetingKeysPage createPage(
        PageContext<
                ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse, CustomTargetingKey>
            context,
        ListCustomTargetingKeysResponse response) {
      return new ListCustomTargetingKeysPage(context, response);
    }

    @Override
    public ApiFuture<ListCustomTargetingKeysPage> createPageAsync(
        PageContext<
                ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse, CustomTargetingKey>
            context,
        ApiFuture<ListCustomTargetingKeysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCustomTargetingKeysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCustomTargetingKeysRequest,
          ListCustomTargetingKeysResponse,
          CustomTargetingKey,
          ListCustomTargetingKeysPage,
          ListCustomTargetingKeysFixedSizeCollection> {

    private ListCustomTargetingKeysFixedSizeCollection(
        List<ListCustomTargetingKeysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCustomTargetingKeysFixedSizeCollection createEmptyCollection() {
      return new ListCustomTargetingKeysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCustomTargetingKeysFixedSizeCollection createCollection(
        List<ListCustomTargetingKeysPage> pages, int collectionSize) {
      return new ListCustomTargetingKeysFixedSizeCollection(pages, collectionSize);
    }
  }
}
