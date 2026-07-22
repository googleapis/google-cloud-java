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

import com.google.ads.admanager.v1.stub.CustomTargetingValueServiceStub;
import com.google.ads.admanager.v1.stub.CustomTargetingValueServiceStubSettings;
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
 * Service Description: Provides methods for handling `CustomTargetingValue` objects.
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
 * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
 *     CustomTargetingValueServiceClient.create()) {
 *   CustomTargetingValueName name =
 *       CustomTargetingValueName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_VALUE]");
 *   CustomTargetingValue response =
 *       customTargetingValueServiceClient.getCustomTargetingValue(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CustomTargetingValueServiceClient object to clean up
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
 *      <td><p> GetCustomTargetingValue</td>
 *      <td><p> Retrieves a `CustomTargetingValue` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCustomTargetingValue(GetCustomTargetingValueRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCustomTargetingValue(CustomTargetingValueName name)
 *           <li><p> getCustomTargetingValue(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCustomTargetingValueCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCustomTargetingValues</td>
 *      <td><p> Lists `CustomTargetingValue` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCustomTargetingValues(ListCustomTargetingValuesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCustomTargetingValues(NetworkName parent)
 *           <li><p> listCustomTargetingValues(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCustomTargetingValuesPagedCallable()
 *           <li><p> listCustomTargetingValuesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCustomTargetingValue</td>
 *      <td><p> Creates a `CustomTargetingValue` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCustomTargetingValue(CreateCustomTargetingValueRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createCustomTargetingValue(NetworkName parent, CustomTargetingValue customTargetingValue)
 *           <li><p> createCustomTargetingValue(String parent, CustomTargetingValue customTargetingValue)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCustomTargetingValueCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateCustomTargetingValues</td>
 *      <td><p> Creates `CustomTargetingValue` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateCustomTargetingValues(NetworkName parent, List&lt;CreateCustomTargetingValueRequest&gt; requests)
 *           <li><p> batchCreateCustomTargetingValues(String parent, List&lt;CreateCustomTargetingValueRequest&gt; requests)
 *           <li><p> batchCreateCustomTargetingValues(BatchCreateCustomTargetingValuesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateCustomTargetingValuesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCustomTargetingValue</td>
 *      <td><p> Updates a `CustomTargetingValue` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCustomTargetingValue(UpdateCustomTargetingValueRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateCustomTargetingValue(CustomTargetingValue customTargetingValue, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCustomTargetingValueCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateCustomTargetingValues</td>
 *      <td><p> Batch updates `CustomTargetingValue` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateCustomTargetingValues(NetworkName parent, List&lt;UpdateCustomTargetingValueRequest&gt; requests)
 *           <li><p> batchUpdateCustomTargetingValues(String parent, List&lt;UpdateCustomTargetingValueRequest&gt; requests)
 *           <li><p> batchUpdateCustomTargetingValues(BatchUpdateCustomTargetingValuesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateCustomTargetingValuesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchActivateCustomTargetingValues</td>
 *      <td><p> Batch activates `CustomTargetingValue` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchActivateCustomTargetingValues(NetworkName parent, List&lt;ActivateCustomTargetingValueRequest&gt; requests)
 *           <li><p> batchActivateCustomTargetingValues(String parent, List&lt;ActivateCustomTargetingValueRequest&gt; requests)
 *           <li><p> batchActivateCustomTargetingValues(BatchActivateCustomTargetingValuesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchActivateCustomTargetingValuesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeactivateCustomTargetingValues</td>
 *      <td><p> Deactivates a list of `CustomTargetingValue` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeactivateCustomTargetingValues(NetworkName parent, List&lt;DeactivateCustomTargetingValueRequest&gt; requests)
 *           <li><p> batchDeactivateCustomTargetingValues(String parent, List&lt;DeactivateCustomTargetingValueRequest&gt; requests)
 *           <li><p> batchDeactivateCustomTargetingValues(BatchDeactivateCustomTargetingValuesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeactivateCustomTargetingValuesCallable()
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
 * CustomTargetingValueServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CustomTargetingValueServiceSettings customTargetingValueServiceSettings =
 *     CustomTargetingValueServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CustomTargetingValueServiceClient customTargetingValueServiceClient =
 *     CustomTargetingValueServiceClient.create(customTargetingValueServiceSettings);
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
 * CustomTargetingValueServiceSettings customTargetingValueServiceSettings =
 *     CustomTargetingValueServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CustomTargetingValueServiceClient customTargetingValueServiceClient =
 *     CustomTargetingValueServiceClient.create(customTargetingValueServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class CustomTargetingValueServiceClient implements BackgroundResource {
  private final @Nullable CustomTargetingValueServiceSettings settings;
  private final CustomTargetingValueServiceStub stub;

  /** Constructs an instance of CustomTargetingValueServiceClient with default settings. */
  public static final CustomTargetingValueServiceClient create() throws IOException {
    return create(CustomTargetingValueServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CustomTargetingValueServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final CustomTargetingValueServiceClient create(
      CustomTargetingValueServiceSettings settings) throws IOException {
    return new CustomTargetingValueServiceClient(settings);
  }

  /**
   * Constructs an instance of CustomTargetingValueServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(CustomTargetingValueServiceSettings).
   */
  public static final CustomTargetingValueServiceClient create(
      CustomTargetingValueServiceStub stub) {
    return new CustomTargetingValueServiceClient(stub);
  }

  /**
   * Constructs an instance of CustomTargetingValueServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CustomTargetingValueServiceClient(CustomTargetingValueServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((CustomTargetingValueServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CustomTargetingValueServiceClient(CustomTargetingValueServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable CustomTargetingValueServiceSettings getSettings() {
    return settings;
  }

  public CustomTargetingValueServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `CustomTargetingValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   CustomTargetingValueName name =
   *       CustomTargetingValueName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_VALUE]");
   *   CustomTargetingValue response =
   *       customTargetingValueServiceClient.getCustomTargetingValue(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomTargetingValue. Format:
   *     `networks/{network_code}/customTargetingValues/{custom_targeting_value_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingValue getCustomTargetingValue(
      @Nullable CustomTargetingValueName name) {
    GetCustomTargetingValueRequest request =
        GetCustomTargetingValueRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCustomTargetingValue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `CustomTargetingValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   String name =
   *       CustomTargetingValueName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_VALUE]").toString();
   *   CustomTargetingValue response =
   *       customTargetingValueServiceClient.getCustomTargetingValue(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomTargetingValue. Format:
   *     `networks/{network_code}/customTargetingValues/{custom_targeting_value_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingValue getCustomTargetingValue(String name) {
    GetCustomTargetingValueRequest request =
        GetCustomTargetingValueRequest.newBuilder().setName(name).build();
    return getCustomTargetingValue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `CustomTargetingValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   GetCustomTargetingValueRequest request =
   *       GetCustomTargetingValueRequest.newBuilder()
   *           .setName(
   *               CustomTargetingValueName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_VALUE]")
   *                   .toString())
   *           .build();
   *   CustomTargetingValue response =
   *       customTargetingValueServiceClient.getCustomTargetingValue(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingValue getCustomTargetingValue(
      GetCustomTargetingValueRequest request) {
    return getCustomTargetingValueCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `CustomTargetingValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   GetCustomTargetingValueRequest request =
   *       GetCustomTargetingValueRequest.newBuilder()
   *           .setName(
   *               CustomTargetingValueName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_VALUE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CustomTargetingValue> future =
   *       customTargetingValueServiceClient.getCustomTargetingValueCallable().futureCall(request);
   *   // Do something.
   *   CustomTargetingValue response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCustomTargetingValueRequest, CustomTargetingValue>
      getCustomTargetingValueCallable() {
    return stub.getCustomTargetingValueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (CustomTargetingValue element :
   *       customTargetingValueServiceClient.listCustomTargetingValues(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomTargetingValues.
   *     Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomTargetingValuesPagedResponse listCustomTargetingValues(
      @Nullable NetworkName parent) {
    ListCustomTargetingValuesRequest request =
        ListCustomTargetingValuesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCustomTargetingValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (CustomTargetingValue element :
   *       customTargetingValueServiceClient.listCustomTargetingValues(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomTargetingValues.
   *     Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomTargetingValuesPagedResponse listCustomTargetingValues(String parent) {
    ListCustomTargetingValuesRequest request =
        ListCustomTargetingValuesRequest.newBuilder().setParent(parent).build();
    return listCustomTargetingValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   ListCustomTargetingValuesRequest request =
   *       ListCustomTargetingValuesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (CustomTargetingValue element :
   *       customTargetingValueServiceClient.listCustomTargetingValues(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomTargetingValuesPagedResponse listCustomTargetingValues(
      ListCustomTargetingValuesRequest request) {
    return listCustomTargetingValuesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   ListCustomTargetingValuesRequest request =
   *       ListCustomTargetingValuesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<CustomTargetingValue> future =
   *       customTargetingValueServiceClient
   *           .listCustomTargetingValuesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (CustomTargetingValue element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListCustomTargetingValuesRequest, ListCustomTargetingValuesPagedResponse>
      listCustomTargetingValuesPagedCallable() {
    return stub.listCustomTargetingValuesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   ListCustomTargetingValuesRequest request =
   *       ListCustomTargetingValuesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListCustomTargetingValuesResponse response =
   *         customTargetingValueServiceClient.listCustomTargetingValuesCallable().call(request);
   *     for (CustomTargetingValue element : response.getCustomTargetingValuesList()) {
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
  public final UnaryCallable<ListCustomTargetingValuesRequest, ListCustomTargetingValuesResponse>
      listCustomTargetingValuesCallable() {
    return stub.listCustomTargetingValuesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `CustomTargetingValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   CustomTargetingValue customTargetingValue = CustomTargetingValue.newBuilder().build();
   *   CustomTargetingValue response =
   *       customTargetingValueServiceClient.createCustomTargetingValue(
   *           parent, customTargetingValue);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomTargetingValues.
   *     Format: `networks/{network_code}`
   * @param customTargetingValue Required. The `CustomTargetingValue` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingValue createCustomTargetingValue(
      @Nullable NetworkName parent, CustomTargetingValue customTargetingValue) {
    CreateCustomTargetingValueRequest request =
        CreateCustomTargetingValueRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCustomTargetingValue(customTargetingValue)
            .build();
    return createCustomTargetingValue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `CustomTargetingValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   CustomTargetingValue customTargetingValue = CustomTargetingValue.newBuilder().build();
   *   CustomTargetingValue response =
   *       customTargetingValueServiceClient.createCustomTargetingValue(
   *           parent, customTargetingValue);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomTargetingValues.
   *     Format: `networks/{network_code}`
   * @param customTargetingValue Required. The `CustomTargetingValue` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingValue createCustomTargetingValue(
      String parent, CustomTargetingValue customTargetingValue) {
    CreateCustomTargetingValueRequest request =
        CreateCustomTargetingValueRequest.newBuilder()
            .setParent(parent)
            .setCustomTargetingValue(customTargetingValue)
            .build();
    return createCustomTargetingValue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `CustomTargetingValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   CreateCustomTargetingValueRequest request =
   *       CreateCustomTargetingValueRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setCustomTargetingValue(CustomTargetingValue.newBuilder().build())
   *           .build();
   *   CustomTargetingValue response =
   *       customTargetingValueServiceClient.createCustomTargetingValue(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingValue createCustomTargetingValue(
      CreateCustomTargetingValueRequest request) {
    return createCustomTargetingValueCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `CustomTargetingValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   CreateCustomTargetingValueRequest request =
   *       CreateCustomTargetingValueRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setCustomTargetingValue(CustomTargetingValue.newBuilder().build())
   *           .build();
   *   ApiFuture<CustomTargetingValue> future =
   *       customTargetingValueServiceClient
   *           .createCustomTargetingValueCallable()
   *           .futureCall(request);
   *   // Do something.
   *   CustomTargetingValue response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCustomTargetingValueRequest, CustomTargetingValue>
      createCustomTargetingValueCallable() {
    return stub.createCustomTargetingValueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateCustomTargetingValueRequest> requests = new ArrayList<>();
   *   BatchCreateCustomTargetingValuesResponse response =
   *       customTargetingValueServiceClient.batchCreateCustomTargetingValues(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomTargetingValues.
   *     Format: `networks/{network_code}`
   * @param requests Required. The `CustomTargetingValue` objects to create. A maximum of 100
   *     objects can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateCustomTargetingValuesResponse batchCreateCustomTargetingValues(
      @Nullable NetworkName parent, List<CreateCustomTargetingValueRequest> requests) {
    BatchCreateCustomTargetingValuesRequest request =
        BatchCreateCustomTargetingValuesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateCustomTargetingValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateCustomTargetingValueRequest> requests = new ArrayList<>();
   *   BatchCreateCustomTargetingValuesResponse response =
   *       customTargetingValueServiceClient.batchCreateCustomTargetingValues(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomTargetingValues.
   *     Format: `networks/{network_code}`
   * @param requests Required. The `CustomTargetingValue` objects to create. A maximum of 100
   *     objects can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateCustomTargetingValuesResponse batchCreateCustomTargetingValues(
      String parent, List<CreateCustomTargetingValueRequest> requests) {
    BatchCreateCustomTargetingValuesRequest request =
        BatchCreateCustomTargetingValuesRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateCustomTargetingValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   BatchCreateCustomTargetingValuesRequest request =
   *       BatchCreateCustomTargetingValuesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateCustomTargetingValueRequest>())
   *           .build();
   *   BatchCreateCustomTargetingValuesResponse response =
   *       customTargetingValueServiceClient.batchCreateCustomTargetingValues(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateCustomTargetingValuesResponse batchCreateCustomTargetingValues(
      BatchCreateCustomTargetingValuesRequest request) {
    return batchCreateCustomTargetingValuesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   BatchCreateCustomTargetingValuesRequest request =
   *       BatchCreateCustomTargetingValuesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateCustomTargetingValueRequest>())
   *           .build();
   *   ApiFuture<BatchCreateCustomTargetingValuesResponse> future =
   *       customTargetingValueServiceClient
   *           .batchCreateCustomTargetingValuesCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchCreateCustomTargetingValuesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchCreateCustomTargetingValuesRequest, BatchCreateCustomTargetingValuesResponse>
      batchCreateCustomTargetingValuesCallable() {
    return stub.batchCreateCustomTargetingValuesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `CustomTargetingValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   CustomTargetingValue customTargetingValue = CustomTargetingValue.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CustomTargetingValue response =
   *       customTargetingValueServiceClient.updateCustomTargetingValue(
   *           customTargetingValue, updateMask);
   * }
   * }</pre>
   *
   * @param customTargetingValue Required. The `CustomTargetingValue` to update.
   *     <p>The `CustomTargetingValue`'s `name` is used to identify the `CustomTargetingValue` to
   *     update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingValue updateCustomTargetingValue(
      CustomTargetingValue customTargetingValue, FieldMask updateMask) {
    UpdateCustomTargetingValueRequest request =
        UpdateCustomTargetingValueRequest.newBuilder()
            .setCustomTargetingValue(customTargetingValue)
            .setUpdateMask(updateMask)
            .build();
    return updateCustomTargetingValue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `CustomTargetingValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   UpdateCustomTargetingValueRequest request =
   *       UpdateCustomTargetingValueRequest.newBuilder()
   *           .setCustomTargetingValue(CustomTargetingValue.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CustomTargetingValue response =
   *       customTargetingValueServiceClient.updateCustomTargetingValue(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomTargetingValue updateCustomTargetingValue(
      UpdateCustomTargetingValueRequest request) {
    return updateCustomTargetingValueCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `CustomTargetingValue` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   UpdateCustomTargetingValueRequest request =
   *       UpdateCustomTargetingValueRequest.newBuilder()
   *           .setCustomTargetingValue(CustomTargetingValue.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CustomTargetingValue> future =
   *       customTargetingValueServiceClient
   *           .updateCustomTargetingValueCallable()
   *           .futureCall(request);
   *   // Do something.
   *   CustomTargetingValue response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCustomTargetingValueRequest, CustomTargetingValue>
      updateCustomTargetingValueCallable() {
    return stub.updateCustomTargetingValueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateCustomTargetingValueRequest> requests = new ArrayList<>();
   *   BatchUpdateCustomTargetingValuesResponse response =
   *       customTargetingValueServiceClient.batchUpdateCustomTargetingValues(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomTargetingValues.
   *     Format: `networks/{network_code}`
   * @param requests Required. The `CustomTargetingValue` objects to update. A maximum of 100
   *     objects can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateCustomTargetingValuesResponse batchUpdateCustomTargetingValues(
      @Nullable NetworkName parent, List<UpdateCustomTargetingValueRequest> requests) {
    BatchUpdateCustomTargetingValuesRequest request =
        BatchUpdateCustomTargetingValuesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateCustomTargetingValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateCustomTargetingValueRequest> requests = new ArrayList<>();
   *   BatchUpdateCustomTargetingValuesResponse response =
   *       customTargetingValueServiceClient.batchUpdateCustomTargetingValues(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomTargetingValues.
   *     Format: `networks/{network_code}`
   * @param requests Required. The `CustomTargetingValue` objects to update. A maximum of 100
   *     objects can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateCustomTargetingValuesResponse batchUpdateCustomTargetingValues(
      String parent, List<UpdateCustomTargetingValueRequest> requests) {
    BatchUpdateCustomTargetingValuesRequest request =
        BatchUpdateCustomTargetingValuesRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateCustomTargetingValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   BatchUpdateCustomTargetingValuesRequest request =
   *       BatchUpdateCustomTargetingValuesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateCustomTargetingValueRequest>())
   *           .build();
   *   BatchUpdateCustomTargetingValuesResponse response =
   *       customTargetingValueServiceClient.batchUpdateCustomTargetingValues(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateCustomTargetingValuesResponse batchUpdateCustomTargetingValues(
      BatchUpdateCustomTargetingValuesRequest request) {
    return batchUpdateCustomTargetingValuesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   BatchUpdateCustomTargetingValuesRequest request =
   *       BatchUpdateCustomTargetingValuesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateCustomTargetingValueRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateCustomTargetingValuesResponse> future =
   *       customTargetingValueServiceClient
   *           .batchUpdateCustomTargetingValuesCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchUpdateCustomTargetingValuesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchUpdateCustomTargetingValuesRequest, BatchUpdateCustomTargetingValuesResponse>
      batchUpdateCustomTargetingValuesCallable() {
    return stub.batchUpdateCustomTargetingValuesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<ActivateCustomTargetingValueRequest> requests = new ArrayList<>();
   *   BatchActivateCustomTargetingValuesResponse response =
   *       customTargetingValueServiceClient.batchActivateCustomTargetingValues(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomTargetingValues.
   *     Format: `networks/{network_code}`
   * @param requests Required. The `CustomTargetingValue` objects to activate. A maximum of 100
   *     objects can be activated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateCustomTargetingValuesResponse batchActivateCustomTargetingValues(
      @Nullable NetworkName parent, List<ActivateCustomTargetingValueRequest> requests) {
    BatchActivateCustomTargetingValuesRequest request =
        BatchActivateCustomTargetingValuesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchActivateCustomTargetingValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<ActivateCustomTargetingValueRequest> requests = new ArrayList<>();
   *   BatchActivateCustomTargetingValuesResponse response =
   *       customTargetingValueServiceClient.batchActivateCustomTargetingValues(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomTargetingValues.
   *     Format: `networks/{network_code}`
   * @param requests Required. The `CustomTargetingValue` objects to activate. A maximum of 100
   *     objects can be activated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateCustomTargetingValuesResponse batchActivateCustomTargetingValues(
      String parent, List<ActivateCustomTargetingValueRequest> requests) {
    BatchActivateCustomTargetingValuesRequest request =
        BatchActivateCustomTargetingValuesRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchActivateCustomTargetingValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   BatchActivateCustomTargetingValuesRequest request =
   *       BatchActivateCustomTargetingValuesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<ActivateCustomTargetingValueRequest>())
   *           .build();
   *   BatchActivateCustomTargetingValuesResponse response =
   *       customTargetingValueServiceClient.batchActivateCustomTargetingValues(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateCustomTargetingValuesResponse batchActivateCustomTargetingValues(
      BatchActivateCustomTargetingValuesRequest request) {
    return batchActivateCustomTargetingValuesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   BatchActivateCustomTargetingValuesRequest request =
   *       BatchActivateCustomTargetingValuesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<ActivateCustomTargetingValueRequest>())
   *           .build();
   *   ApiFuture<BatchActivateCustomTargetingValuesResponse> future =
   *       customTargetingValueServiceClient
   *           .batchActivateCustomTargetingValuesCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchActivateCustomTargetingValuesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchActivateCustomTargetingValuesRequest, BatchActivateCustomTargetingValuesResponse>
      batchActivateCustomTargetingValuesCallable() {
    return stub.batchActivateCustomTargetingValuesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<DeactivateCustomTargetingValueRequest> requests = new ArrayList<>();
   *   BatchDeactivateCustomTargetingValuesResponse response =
   *       customTargetingValueServiceClient.batchDeactivateCustomTargetingValues(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomTargetingValues.
   *     Format: `networks/{network_code}/`
   * @param requests Required. The `CustomTargetingValue` objects to deactivate.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateCustomTargetingValuesResponse batchDeactivateCustomTargetingValues(
      @Nullable NetworkName parent, List<DeactivateCustomTargetingValueRequest> requests) {
    BatchDeactivateCustomTargetingValuesRequest request =
        BatchDeactivateCustomTargetingValuesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchDeactivateCustomTargetingValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<DeactivateCustomTargetingValueRequest> requests = new ArrayList<>();
   *   BatchDeactivateCustomTargetingValuesResponse response =
   *       customTargetingValueServiceClient.batchDeactivateCustomTargetingValues(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CustomTargetingValues.
   *     Format: `networks/{network_code}/`
   * @param requests Required. The `CustomTargetingValue` objects to deactivate.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateCustomTargetingValuesResponse batchDeactivateCustomTargetingValues(
      String parent, List<DeactivateCustomTargetingValueRequest> requests) {
    BatchDeactivateCustomTargetingValuesRequest request =
        BatchDeactivateCustomTargetingValuesRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchDeactivateCustomTargetingValues(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   BatchDeactivateCustomTargetingValuesRequest request =
   *       BatchDeactivateCustomTargetingValuesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<DeactivateCustomTargetingValueRequest>())
   *           .build();
   *   BatchDeactivateCustomTargetingValuesResponse response =
   *       customTargetingValueServiceClient.batchDeactivateCustomTargetingValues(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateCustomTargetingValuesResponse batchDeactivateCustomTargetingValues(
      BatchDeactivateCustomTargetingValuesRequest request) {
    return batchDeactivateCustomTargetingValuesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `CustomTargetingValue` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CustomTargetingValueServiceClient customTargetingValueServiceClient =
   *     CustomTargetingValueServiceClient.create()) {
   *   BatchDeactivateCustomTargetingValuesRequest request =
   *       BatchDeactivateCustomTargetingValuesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<DeactivateCustomTargetingValueRequest>())
   *           .build();
   *   ApiFuture<BatchDeactivateCustomTargetingValuesResponse> future =
   *       customTargetingValueServiceClient
   *           .batchDeactivateCustomTargetingValuesCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchDeactivateCustomTargetingValuesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchDeactivateCustomTargetingValuesRequest, BatchDeactivateCustomTargetingValuesResponse>
      batchDeactivateCustomTargetingValuesCallable() {
    return stub.batchDeactivateCustomTargetingValuesCallable();
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

  public static class ListCustomTargetingValuesPagedResponse
      extends AbstractPagedListResponse<
          ListCustomTargetingValuesRequest,
          ListCustomTargetingValuesResponse,
          CustomTargetingValue,
          ListCustomTargetingValuesPage,
          ListCustomTargetingValuesFixedSizeCollection> {

    public static ApiFuture<ListCustomTargetingValuesPagedResponse> createAsync(
        PageContext<
                ListCustomTargetingValuesRequest,
                ListCustomTargetingValuesResponse,
                CustomTargetingValue>
            context,
        ApiFuture<ListCustomTargetingValuesResponse> futureResponse) {
      ApiFuture<ListCustomTargetingValuesPage> futurePage =
          ListCustomTargetingValuesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCustomTargetingValuesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCustomTargetingValuesPagedResponse(ListCustomTargetingValuesPage page) {
      super(page, ListCustomTargetingValuesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCustomTargetingValuesPage
      extends AbstractPage<
          ListCustomTargetingValuesRequest,
          ListCustomTargetingValuesResponse,
          CustomTargetingValue,
          ListCustomTargetingValuesPage> {

    private ListCustomTargetingValuesPage(
        @Nullable
            PageContext<
                ListCustomTargetingValuesRequest,
                ListCustomTargetingValuesResponse,
                CustomTargetingValue>
            context,
        @Nullable ListCustomTargetingValuesResponse response) {
      super(context, response);
    }

    private static ListCustomTargetingValuesPage createEmptyPage() {
      return new ListCustomTargetingValuesPage(null, null);
    }

    @Override
    protected ListCustomTargetingValuesPage createPage(
        @Nullable
            PageContext<
                ListCustomTargetingValuesRequest,
                ListCustomTargetingValuesResponse,
                CustomTargetingValue>
            context,
        @Nullable ListCustomTargetingValuesResponse response) {
      return new ListCustomTargetingValuesPage(context, response);
    }

    @Override
    public ApiFuture<ListCustomTargetingValuesPage> createPageAsync(
        @Nullable
            PageContext<
                ListCustomTargetingValuesRequest,
                ListCustomTargetingValuesResponse,
                CustomTargetingValue>
            context,
        ApiFuture<ListCustomTargetingValuesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCustomTargetingValuesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCustomTargetingValuesRequest,
          ListCustomTargetingValuesResponse,
          CustomTargetingValue,
          ListCustomTargetingValuesPage,
          ListCustomTargetingValuesFixedSizeCollection> {

    private ListCustomTargetingValuesFixedSizeCollection(
        @Nullable List<ListCustomTargetingValuesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCustomTargetingValuesFixedSizeCollection createEmptyCollection() {
      return new ListCustomTargetingValuesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCustomTargetingValuesFixedSizeCollection createCollection(
        @Nullable List<ListCustomTargetingValuesPage> pages, int collectionSize) {
      return new ListCustomTargetingValuesFixedSizeCollection(pages, collectionSize);
    }
  }
}
