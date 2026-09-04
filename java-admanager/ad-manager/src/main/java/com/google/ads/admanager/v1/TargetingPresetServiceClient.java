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

import com.google.ads.admanager.v1.stub.TargetingPresetServiceStub;
import com.google.ads.admanager.v1.stub.TargetingPresetServiceStubSettings;
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
 * Service Description: Provides methods for handling `TargetingPreset` objects.
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
 * try (TargetingPresetServiceClient targetingPresetServiceClient =
 *     TargetingPresetServiceClient.create()) {
 *   TargetingPresetName name = TargetingPresetName.of("[NETWORK_CODE]", "[TARGETING_PRESET]");
 *   TargetingPreset response = targetingPresetServiceClient.getTargetingPreset(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TargetingPresetServiceClient object to clean up
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
 *      <td><p> GetTargetingPreset</td>
 *      <td><p> Retrieves a `TargetingPreset` object. Note: Deactivated targeting presets are "logically deleted" (filtered out) by the get logic in the manager layer, so they will not be returned by the `GetTargetingPreset` RPC.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTargetingPreset(GetTargetingPresetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTargetingPreset(TargetingPresetName name)
 *           <li><p> getTargetingPreset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTargetingPresetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTargetingPresets</td>
 *      <td><p> Lists `TargetingPreset` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTargetingPresets(ListTargetingPresetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTargetingPresets(NetworkName parent)
 *           <li><p> listTargetingPresets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTargetingPresetsPagedCallable()
 *           <li><p> listTargetingPresetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTargetingPreset</td>
 *      <td><p> Creates a `TargetingPreset` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTargetingPreset(CreateTargetingPresetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTargetingPreset(NetworkName parent, TargetingPreset targetingPreset)
 *           <li><p> createTargetingPreset(String parent, TargetingPreset targetingPreset)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTargetingPresetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateTargetingPresets</td>
 *      <td><p> Creates `TargetingPreset` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateTargetingPresets(NetworkName parent, List&lt;CreateTargetingPresetRequest&gt; requests)
 *           <li><p> batchCreateTargetingPresets(String parent, List&lt;CreateTargetingPresetRequest&gt; requests)
 *           <li><p> batchCreateTargetingPresets(BatchCreateTargetingPresetsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateTargetingPresetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTargetingPreset</td>
 *      <td><p> Updates a `TargetingPreset` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTargetingPreset(UpdateTargetingPresetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateTargetingPreset(TargetingPreset targetingPreset, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTargetingPresetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateTargetingPresets</td>
 *      <td><p> Batch updates `TargetingPreset` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateTargetingPresets(NetworkName parent, List&lt;UpdateTargetingPresetRequest&gt; requests)
 *           <li><p> batchUpdateTargetingPresets(String parent, List&lt;UpdateTargetingPresetRequest&gt; requests)
 *           <li><p> batchUpdateTargetingPresets(BatchUpdateTargetingPresetsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateTargetingPresetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeactivateTargetingPresets</td>
 *      <td><p> Batch deactivates `TargetingPreset` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeactivateTargetingPresets(NetworkName parent, List&lt;DeactivateTargetingPresetRequest&gt; requests)
 *           <li><p> batchDeactivateTargetingPresets(String parent, List&lt;DeactivateTargetingPresetRequest&gt; requests)
 *           <li><p> batchDeactivateTargetingPresets(BatchDeactivateTargetingPresetsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeactivateTargetingPresetsCallable()
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
 * <p>This class can be customized by passing in a custom instance of TargetingPresetServiceSettings
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
 * TargetingPresetServiceSettings targetingPresetServiceSettings =
 *     TargetingPresetServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TargetingPresetServiceClient targetingPresetServiceClient =
 *     TargetingPresetServiceClient.create(targetingPresetServiceSettings);
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
 * TargetingPresetServiceSettings targetingPresetServiceSettings =
 *     TargetingPresetServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TargetingPresetServiceClient targetingPresetServiceClient =
 *     TargetingPresetServiceClient.create(targetingPresetServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class TargetingPresetServiceClient implements BackgroundResource {
  private final @Nullable TargetingPresetServiceSettings settings;
  private final TargetingPresetServiceStub stub;

  /** Constructs an instance of TargetingPresetServiceClient with default settings. */
  public static final TargetingPresetServiceClient create() throws IOException {
    return create(TargetingPresetServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TargetingPresetServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TargetingPresetServiceClient create(TargetingPresetServiceSettings settings)
      throws IOException {
    return new TargetingPresetServiceClient(settings);
  }

  /**
   * Constructs an instance of TargetingPresetServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(TargetingPresetServiceSettings).
   */
  public static final TargetingPresetServiceClient create(TargetingPresetServiceStub stub) {
    return new TargetingPresetServiceClient(stub);
  }

  /**
   * Constructs an instance of TargetingPresetServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected TargetingPresetServiceClient(TargetingPresetServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((TargetingPresetServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected TargetingPresetServiceClient(TargetingPresetServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable TargetingPresetServiceSettings getSettings() {
    return settings;
  }

  public TargetingPresetServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `TargetingPreset` object. Note: Deactivated targeting presets are "logically
   * deleted" (filtered out) by the get logic in the manager layer, so they will not be returned by
   * the `GetTargetingPreset` RPC.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   TargetingPresetName name = TargetingPresetName.of("[NETWORK_CODE]", "[TARGETING_PRESET]");
   *   TargetingPreset response = targetingPresetServiceClient.getTargetingPreset(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the TargetingPreset. Format:
   *     `networks/{network_code}/targetingPresets/{targeting_preset_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetingPreset getTargetingPreset(@Nullable TargetingPresetName name) {
    GetTargetingPresetRequest request =
        GetTargetingPresetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTargetingPreset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `TargetingPreset` object. Note: Deactivated targeting presets are "logically
   * deleted" (filtered out) by the get logic in the manager layer, so they will not be returned by
   * the `GetTargetingPreset` RPC.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   String name = TargetingPresetName.of("[NETWORK_CODE]", "[TARGETING_PRESET]").toString();
   *   TargetingPreset response = targetingPresetServiceClient.getTargetingPreset(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the TargetingPreset. Format:
   *     `networks/{network_code}/targetingPresets/{targeting_preset_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetingPreset getTargetingPreset(String name) {
    GetTargetingPresetRequest request =
        GetTargetingPresetRequest.newBuilder().setName(name).build();
    return getTargetingPreset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `TargetingPreset` object. Note: Deactivated targeting presets are "logically
   * deleted" (filtered out) by the get logic in the manager layer, so they will not be returned by
   * the `GetTargetingPreset` RPC.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   GetTargetingPresetRequest request =
   *       GetTargetingPresetRequest.newBuilder()
   *           .setName(TargetingPresetName.of("[NETWORK_CODE]", "[TARGETING_PRESET]").toString())
   *           .build();
   *   TargetingPreset response = targetingPresetServiceClient.getTargetingPreset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetingPreset getTargetingPreset(GetTargetingPresetRequest request) {
    return getTargetingPresetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `TargetingPreset` object. Note: Deactivated targeting presets are "logically
   * deleted" (filtered out) by the get logic in the manager layer, so they will not be returned by
   * the `GetTargetingPreset` RPC.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   GetTargetingPresetRequest request =
   *       GetTargetingPresetRequest.newBuilder()
   *           .setName(TargetingPresetName.of("[NETWORK_CODE]", "[TARGETING_PRESET]").toString())
   *           .build();
   *   ApiFuture<TargetingPreset> future =
   *       targetingPresetServiceClient.getTargetingPresetCallable().futureCall(request);
   *   // Do something.
   *   TargetingPreset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTargetingPresetRequest, TargetingPreset>
      getTargetingPresetCallable() {
    return stub.getTargetingPresetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `TargetingPreset` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (TargetingPreset element :
   *       targetingPresetServiceClient.listTargetingPresets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of TargetingPresets. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTargetingPresetsPagedResponse listTargetingPresets(
      @Nullable NetworkName parent) {
    ListTargetingPresetsRequest request =
        ListTargetingPresetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTargetingPresets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `TargetingPreset` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (TargetingPreset element :
   *       targetingPresetServiceClient.listTargetingPresets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of TargetingPresets. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTargetingPresetsPagedResponse listTargetingPresets(String parent) {
    ListTargetingPresetsRequest request =
        ListTargetingPresetsRequest.newBuilder().setParent(parent).build();
    return listTargetingPresets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `TargetingPreset` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   ListTargetingPresetsRequest request =
   *       ListTargetingPresetsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (TargetingPreset element :
   *       targetingPresetServiceClient.listTargetingPresets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTargetingPresetsPagedResponse listTargetingPresets(
      ListTargetingPresetsRequest request) {
    return listTargetingPresetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `TargetingPreset` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   ListTargetingPresetsRequest request =
   *       ListTargetingPresetsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<TargetingPreset> future =
   *       targetingPresetServiceClient.listTargetingPresetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TargetingPreset element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTargetingPresetsRequest, ListTargetingPresetsPagedResponse>
      listTargetingPresetsPagedCallable() {
    return stub.listTargetingPresetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `TargetingPreset` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   ListTargetingPresetsRequest request =
   *       ListTargetingPresetsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListTargetingPresetsResponse response =
   *         targetingPresetServiceClient.listTargetingPresetsCallable().call(request);
   *     for (TargetingPreset element : response.getTargetingPresetsList()) {
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
  public final UnaryCallable<ListTargetingPresetsRequest, ListTargetingPresetsResponse>
      listTargetingPresetsCallable() {
    return stub.listTargetingPresetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `TargetingPreset` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   TargetingPreset targetingPreset = TargetingPreset.newBuilder().build();
   *   TargetingPreset response =
   *       targetingPresetServiceClient.createTargetingPreset(parent, targetingPreset);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `TargetingPreset` will be created.
   *     Format: `networks/{network_code}`
   * @param targetingPreset Required. The `TargetingPreset` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetingPreset createTargetingPreset(
      @Nullable NetworkName parent, TargetingPreset targetingPreset) {
    CreateTargetingPresetRequest request =
        CreateTargetingPresetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTargetingPreset(targetingPreset)
            .build();
    return createTargetingPreset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `TargetingPreset` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   TargetingPreset targetingPreset = TargetingPreset.newBuilder().build();
   *   TargetingPreset response =
   *       targetingPresetServiceClient.createTargetingPreset(parent, targetingPreset);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `TargetingPreset` will be created.
   *     Format: `networks/{network_code}`
   * @param targetingPreset Required. The `TargetingPreset` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetingPreset createTargetingPreset(
      String parent, TargetingPreset targetingPreset) {
    CreateTargetingPresetRequest request =
        CreateTargetingPresetRequest.newBuilder()
            .setParent(parent)
            .setTargetingPreset(targetingPreset)
            .build();
    return createTargetingPreset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `TargetingPreset` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   CreateTargetingPresetRequest request =
   *       CreateTargetingPresetRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setTargetingPreset(TargetingPreset.newBuilder().build())
   *           .build();
   *   TargetingPreset response = targetingPresetServiceClient.createTargetingPreset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetingPreset createTargetingPreset(CreateTargetingPresetRequest request) {
    return createTargetingPresetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `TargetingPreset` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   CreateTargetingPresetRequest request =
   *       CreateTargetingPresetRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setTargetingPreset(TargetingPreset.newBuilder().build())
   *           .build();
   *   ApiFuture<TargetingPreset> future =
   *       targetingPresetServiceClient.createTargetingPresetCallable().futureCall(request);
   *   // Do something.
   *   TargetingPreset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTargetingPresetRequest, TargetingPreset>
      createTargetingPresetCallable() {
    return stub.createTargetingPresetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `TargetingPreset` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateTargetingPresetRequest> requests = new ArrayList<>();
   *   BatchCreateTargetingPresetsResponse response =
   *       targetingPresetServiceClient.batchCreateTargetingPresets(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `TargetingPresets` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateTargetingPresetRequest must match
   *     this field.
   * @param requests Required. The `TargetingPreset` objects to create. A maximum of 100 objects can
   *     be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateTargetingPresetsResponse batchCreateTargetingPresets(
      @Nullable NetworkName parent, List<CreateTargetingPresetRequest> requests) {
    BatchCreateTargetingPresetsRequest request =
        BatchCreateTargetingPresetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateTargetingPresets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `TargetingPreset` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateTargetingPresetRequest> requests = new ArrayList<>();
   *   BatchCreateTargetingPresetsResponse response =
   *       targetingPresetServiceClient.batchCreateTargetingPresets(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `TargetingPresets` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateTargetingPresetRequest must match
   *     this field.
   * @param requests Required. The `TargetingPreset` objects to create. A maximum of 100 objects can
   *     be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateTargetingPresetsResponse batchCreateTargetingPresets(
      String parent, List<CreateTargetingPresetRequest> requests) {
    BatchCreateTargetingPresetsRequest request =
        BatchCreateTargetingPresetsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateTargetingPresets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `TargetingPreset` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   BatchCreateTargetingPresetsRequest request =
   *       BatchCreateTargetingPresetsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateTargetingPresetRequest>())
   *           .build();
   *   BatchCreateTargetingPresetsResponse response =
   *       targetingPresetServiceClient.batchCreateTargetingPresets(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateTargetingPresetsResponse batchCreateTargetingPresets(
      BatchCreateTargetingPresetsRequest request) {
    return batchCreateTargetingPresetsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `TargetingPreset` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   BatchCreateTargetingPresetsRequest request =
   *       BatchCreateTargetingPresetsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateTargetingPresetRequest>())
   *           .build();
   *   ApiFuture<BatchCreateTargetingPresetsResponse> future =
   *       targetingPresetServiceClient.batchCreateTargetingPresetsCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateTargetingPresetsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchCreateTargetingPresetsRequest, BatchCreateTargetingPresetsResponse>
      batchCreateTargetingPresetsCallable() {
    return stub.batchCreateTargetingPresetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `TargetingPreset` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   TargetingPreset targetingPreset = TargetingPreset.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TargetingPreset response =
   *       targetingPresetServiceClient.updateTargetingPreset(targetingPreset, updateMask);
   * }
   * }</pre>
   *
   * @param targetingPreset Required. The `TargetingPreset` to update.
   *     <p>The `TargetingPreset`'s `name` is used to identify the `TargetingPreset` to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetingPreset updateTargetingPreset(
      TargetingPreset targetingPreset, FieldMask updateMask) {
    UpdateTargetingPresetRequest request =
        UpdateTargetingPresetRequest.newBuilder()
            .setTargetingPreset(targetingPreset)
            .setUpdateMask(updateMask)
            .build();
    return updateTargetingPreset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `TargetingPreset` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   UpdateTargetingPresetRequest request =
   *       UpdateTargetingPresetRequest.newBuilder()
   *           .setTargetingPreset(TargetingPreset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   TargetingPreset response = targetingPresetServiceClient.updateTargetingPreset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TargetingPreset updateTargetingPreset(UpdateTargetingPresetRequest request) {
    return updateTargetingPresetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `TargetingPreset` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   UpdateTargetingPresetRequest request =
   *       UpdateTargetingPresetRequest.newBuilder()
   *           .setTargetingPreset(TargetingPreset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<TargetingPreset> future =
   *       targetingPresetServiceClient.updateTargetingPresetCallable().futureCall(request);
   *   // Do something.
   *   TargetingPreset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTargetingPresetRequest, TargetingPreset>
      updateTargetingPresetCallable() {
    return stub.updateTargetingPresetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `TargetingPreset` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateTargetingPresetRequest> requests = new ArrayList<>();
   *   BatchUpdateTargetingPresetsResponse response =
   *       targetingPresetServiceClient.batchUpdateTargetingPresets(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `TargetingPresets` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateTargetingPresetRequest must match
   *     this field.
   * @param requests Required. The `TargetingPreset` objects to update. A maximum of 100 objects can
   *     be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateTargetingPresetsResponse batchUpdateTargetingPresets(
      @Nullable NetworkName parent, List<UpdateTargetingPresetRequest> requests) {
    BatchUpdateTargetingPresetsRequest request =
        BatchUpdateTargetingPresetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateTargetingPresets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `TargetingPreset` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateTargetingPresetRequest> requests = new ArrayList<>();
   *   BatchUpdateTargetingPresetsResponse response =
   *       targetingPresetServiceClient.batchUpdateTargetingPresets(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `TargetingPresets` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateTargetingPresetRequest must match
   *     this field.
   * @param requests Required. The `TargetingPreset` objects to update. A maximum of 100 objects can
   *     be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateTargetingPresetsResponse batchUpdateTargetingPresets(
      String parent, List<UpdateTargetingPresetRequest> requests) {
    BatchUpdateTargetingPresetsRequest request =
        BatchUpdateTargetingPresetsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateTargetingPresets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `TargetingPreset` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   BatchUpdateTargetingPresetsRequest request =
   *       BatchUpdateTargetingPresetsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateTargetingPresetRequest>())
   *           .build();
   *   BatchUpdateTargetingPresetsResponse response =
   *       targetingPresetServiceClient.batchUpdateTargetingPresets(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateTargetingPresetsResponse batchUpdateTargetingPresets(
      BatchUpdateTargetingPresetsRequest request) {
    return batchUpdateTargetingPresetsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `TargetingPreset` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   BatchUpdateTargetingPresetsRequest request =
   *       BatchUpdateTargetingPresetsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateTargetingPresetRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateTargetingPresetsResponse> future =
   *       targetingPresetServiceClient.batchUpdateTargetingPresetsCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateTargetingPresetsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchUpdateTargetingPresetsRequest, BatchUpdateTargetingPresetsResponse>
      batchUpdateTargetingPresetsCallable() {
    return stub.batchUpdateTargetingPresetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch deactivates `TargetingPreset` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<DeactivateTargetingPresetRequest> requests = new ArrayList<>();
   *   BatchDeactivateTargetingPresetsResponse response =
   *       targetingPresetServiceClient.batchDeactivateTargetingPresets(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param requests Required. The `TargetingPreset` objects to deactivate.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateTargetingPresetsResponse batchDeactivateTargetingPresets(
      @Nullable NetworkName parent, List<DeactivateTargetingPresetRequest> requests) {
    BatchDeactivateTargetingPresetsRequest request =
        BatchDeactivateTargetingPresetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchDeactivateTargetingPresets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch deactivates `TargetingPreset` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<DeactivateTargetingPresetRequest> requests = new ArrayList<>();
   *   BatchDeactivateTargetingPresetsResponse response =
   *       targetingPresetServiceClient.batchDeactivateTargetingPresets(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param requests Required. The `TargetingPreset` objects to deactivate.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateTargetingPresetsResponse batchDeactivateTargetingPresets(
      String parent, List<DeactivateTargetingPresetRequest> requests) {
    BatchDeactivateTargetingPresetsRequest request =
        BatchDeactivateTargetingPresetsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchDeactivateTargetingPresets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch deactivates `TargetingPreset` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   BatchDeactivateTargetingPresetsRequest request =
   *       BatchDeactivateTargetingPresetsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<DeactivateTargetingPresetRequest>())
   *           .build();
   *   BatchDeactivateTargetingPresetsResponse response =
   *       targetingPresetServiceClient.batchDeactivateTargetingPresets(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateTargetingPresetsResponse batchDeactivateTargetingPresets(
      BatchDeactivateTargetingPresetsRequest request) {
    return batchDeactivateTargetingPresetsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch deactivates `TargetingPreset` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TargetingPresetServiceClient targetingPresetServiceClient =
   *     TargetingPresetServiceClient.create()) {
   *   BatchDeactivateTargetingPresetsRequest request =
   *       BatchDeactivateTargetingPresetsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<DeactivateTargetingPresetRequest>())
   *           .build();
   *   ApiFuture<BatchDeactivateTargetingPresetsResponse> future =
   *       targetingPresetServiceClient
   *           .batchDeactivateTargetingPresetsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchDeactivateTargetingPresetsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchDeactivateTargetingPresetsRequest, BatchDeactivateTargetingPresetsResponse>
      batchDeactivateTargetingPresetsCallable() {
    return stub.batchDeactivateTargetingPresetsCallable();
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

  public static class ListTargetingPresetsPagedResponse
      extends AbstractPagedListResponse<
          ListTargetingPresetsRequest,
          ListTargetingPresetsResponse,
          TargetingPreset,
          ListTargetingPresetsPage,
          ListTargetingPresetsFixedSizeCollection> {

    public static ApiFuture<ListTargetingPresetsPagedResponse> createAsync(
        PageContext<ListTargetingPresetsRequest, ListTargetingPresetsResponse, TargetingPreset>
            context,
        ApiFuture<ListTargetingPresetsResponse> futureResponse) {
      ApiFuture<ListTargetingPresetsPage> futurePage =
          ListTargetingPresetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTargetingPresetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTargetingPresetsPagedResponse(ListTargetingPresetsPage page) {
      super(page, ListTargetingPresetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTargetingPresetsPage
      extends AbstractPage<
          ListTargetingPresetsRequest,
          ListTargetingPresetsResponse,
          TargetingPreset,
          ListTargetingPresetsPage> {

    private ListTargetingPresetsPage(
        @Nullable
            PageContext<ListTargetingPresetsRequest, ListTargetingPresetsResponse, TargetingPreset>
            context,
        @Nullable ListTargetingPresetsResponse response) {
      super(context, response);
    }

    private static ListTargetingPresetsPage createEmptyPage() {
      return new ListTargetingPresetsPage(null, null);
    }

    @Override
    protected ListTargetingPresetsPage createPage(
        @Nullable
            PageContext<ListTargetingPresetsRequest, ListTargetingPresetsResponse, TargetingPreset>
            context,
        @Nullable ListTargetingPresetsResponse response) {
      return new ListTargetingPresetsPage(context, response);
    }

    @Override
    public ApiFuture<ListTargetingPresetsPage> createPageAsync(
        @Nullable
            PageContext<ListTargetingPresetsRequest, ListTargetingPresetsResponse, TargetingPreset>
            context,
        ApiFuture<ListTargetingPresetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTargetingPresetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetingPresetsRequest,
          ListTargetingPresetsResponse,
          TargetingPreset,
          ListTargetingPresetsPage,
          ListTargetingPresetsFixedSizeCollection> {

    private ListTargetingPresetsFixedSizeCollection(
        @Nullable List<ListTargetingPresetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTargetingPresetsFixedSizeCollection createEmptyCollection() {
      return new ListTargetingPresetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTargetingPresetsFixedSizeCollection createCollection(
        @Nullable List<ListTargetingPresetsPage> pages, int collectionSize) {
      return new ListTargetingPresetsFixedSizeCollection(pages, collectionSize);
    }
  }
}
