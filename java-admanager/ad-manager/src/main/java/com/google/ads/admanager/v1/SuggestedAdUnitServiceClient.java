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

import com.google.ads.admanager.v1.stub.SuggestedAdUnitServiceStub;
import com.google.ads.admanager.v1.stub.SuggestedAdUnitServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `SuggestedAdUnit` objects.
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
 * try (SuggestedAdUnitServiceClient suggestedAdUnitServiceClient =
 *     SuggestedAdUnitServiceClient.create()) {
 *   SuggestedAdUnitName name = SuggestedAdUnitName.of("[NETWORK_CODE]", "[SUGGESTED_AD_UNIT]");
 *   SuggestedAdUnit response = suggestedAdUnitServiceClient.getSuggestedAdUnit(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SuggestedAdUnitServiceClient object to clean up
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
 *      <td><p> GetSuggestedAdUnit</td>
 *      <td><p> Get a `SuggestedAdUnit` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSuggestedAdUnit(GetSuggestedAdUnitRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSuggestedAdUnit(SuggestedAdUnitName name)
 *           <li><p> getSuggestedAdUnit(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSuggestedAdUnitCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSuggestedAdUnits</td>
 *      <td><p> Retrieve a list of `SuggestedAdUnit` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSuggestedAdUnits(ListSuggestedAdUnitsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSuggestedAdUnits(NetworkName parent)
 *           <li><p> listSuggestedAdUnits(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSuggestedAdUnitsPagedCallable()
 *           <li><p> listSuggestedAdUnitsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchApproveSuggestedAdUnits</td>
 *      <td><p> Bulk approve `SuggestedAdUnit` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchApproveSuggestedAdUnits(BatchApproveSuggestedAdUnitsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchApproveSuggestedAdUnits(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchApproveSuggestedAdUnits(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchApproveSuggestedAdUnitsCallable()
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
 * <p>This class can be customized by passing in a custom instance of SuggestedAdUnitServiceSettings
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
 * SuggestedAdUnitServiceSettings suggestedAdUnitServiceSettings =
 *     SuggestedAdUnitServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SuggestedAdUnitServiceClient suggestedAdUnitServiceClient =
 *     SuggestedAdUnitServiceClient.create(suggestedAdUnitServiceSettings);
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
 * SuggestedAdUnitServiceSettings suggestedAdUnitServiceSettings =
 *     SuggestedAdUnitServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SuggestedAdUnitServiceClient suggestedAdUnitServiceClient =
 *     SuggestedAdUnitServiceClient.create(suggestedAdUnitServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class SuggestedAdUnitServiceClient implements BackgroundResource {
  private final @Nullable SuggestedAdUnitServiceSettings settings;
  private final SuggestedAdUnitServiceStub stub;

  /** Constructs an instance of SuggestedAdUnitServiceClient with default settings. */
  public static final SuggestedAdUnitServiceClient create() throws IOException {
    return create(SuggestedAdUnitServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SuggestedAdUnitServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SuggestedAdUnitServiceClient create(SuggestedAdUnitServiceSettings settings)
      throws IOException {
    return new SuggestedAdUnitServiceClient(settings);
  }

  /**
   * Constructs an instance of SuggestedAdUnitServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(SuggestedAdUnitServiceSettings).
   */
  public static final SuggestedAdUnitServiceClient create(SuggestedAdUnitServiceStub stub) {
    return new SuggestedAdUnitServiceClient(stub);
  }

  /**
   * Constructs an instance of SuggestedAdUnitServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SuggestedAdUnitServiceClient(SuggestedAdUnitServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((SuggestedAdUnitServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SuggestedAdUnitServiceClient(SuggestedAdUnitServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable SuggestedAdUnitServiceSettings getSettings() {
    return settings;
  }

  public SuggestedAdUnitServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a `SuggestedAdUnit` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SuggestedAdUnitServiceClient suggestedAdUnitServiceClient =
   *     SuggestedAdUnitServiceClient.create()) {
   *   SuggestedAdUnitName name = SuggestedAdUnitName.of("[NETWORK_CODE]", "[SUGGESTED_AD_UNIT]");
   *   SuggestedAdUnit response = suggestedAdUnitServiceClient.getSuggestedAdUnit(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the `SuggestedAdUnit`. Format:
   *     `networks/{network_code}/suggestedAdUnits/{suggested_ad_unit_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SuggestedAdUnit getSuggestedAdUnit(@Nullable SuggestedAdUnitName name) {
    GetSuggestedAdUnitRequest request =
        GetSuggestedAdUnitRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSuggestedAdUnit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a `SuggestedAdUnit` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SuggestedAdUnitServiceClient suggestedAdUnitServiceClient =
   *     SuggestedAdUnitServiceClient.create()) {
   *   String name = SuggestedAdUnitName.of("[NETWORK_CODE]", "[SUGGESTED_AD_UNIT]").toString();
   *   SuggestedAdUnit response = suggestedAdUnitServiceClient.getSuggestedAdUnit(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the `SuggestedAdUnit`. Format:
   *     `networks/{network_code}/suggestedAdUnits/{suggested_ad_unit_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SuggestedAdUnit getSuggestedAdUnit(String name) {
    GetSuggestedAdUnitRequest request =
        GetSuggestedAdUnitRequest.newBuilder().setName(name).build();
    return getSuggestedAdUnit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a `SuggestedAdUnit` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SuggestedAdUnitServiceClient suggestedAdUnitServiceClient =
   *     SuggestedAdUnitServiceClient.create()) {
   *   GetSuggestedAdUnitRequest request =
   *       GetSuggestedAdUnitRequest.newBuilder()
   *           .setName(SuggestedAdUnitName.of("[NETWORK_CODE]", "[SUGGESTED_AD_UNIT]").toString())
   *           .build();
   *   SuggestedAdUnit response = suggestedAdUnitServiceClient.getSuggestedAdUnit(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SuggestedAdUnit getSuggestedAdUnit(GetSuggestedAdUnitRequest request) {
    return getSuggestedAdUnitCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a `SuggestedAdUnit` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SuggestedAdUnitServiceClient suggestedAdUnitServiceClient =
   *     SuggestedAdUnitServiceClient.create()) {
   *   GetSuggestedAdUnitRequest request =
   *       GetSuggestedAdUnitRequest.newBuilder()
   *           .setName(SuggestedAdUnitName.of("[NETWORK_CODE]", "[SUGGESTED_AD_UNIT]").toString())
   *           .build();
   *   ApiFuture<SuggestedAdUnit> future =
   *       suggestedAdUnitServiceClient.getSuggestedAdUnitCallable().futureCall(request);
   *   // Do something.
   *   SuggestedAdUnit response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSuggestedAdUnitRequest, SuggestedAdUnit>
      getSuggestedAdUnitCallable() {
    return stub.getSuggestedAdUnitCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a list of `SuggestedAdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SuggestedAdUnitServiceClient suggestedAdUnitServiceClient =
   *     SuggestedAdUnitServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (SuggestedAdUnit element :
   *       suggestedAdUnitServiceClient.listSuggestedAdUnits(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of SuggestedAdUnits. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSuggestedAdUnitsPagedResponse listSuggestedAdUnits(
      @Nullable NetworkName parent) {
    ListSuggestedAdUnitsRequest request =
        ListSuggestedAdUnitsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSuggestedAdUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a list of `SuggestedAdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SuggestedAdUnitServiceClient suggestedAdUnitServiceClient =
   *     SuggestedAdUnitServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (SuggestedAdUnit element :
   *       suggestedAdUnitServiceClient.listSuggestedAdUnits(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of SuggestedAdUnits. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSuggestedAdUnitsPagedResponse listSuggestedAdUnits(String parent) {
    ListSuggestedAdUnitsRequest request =
        ListSuggestedAdUnitsRequest.newBuilder().setParent(parent).build();
    return listSuggestedAdUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a list of `SuggestedAdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SuggestedAdUnitServiceClient suggestedAdUnitServiceClient =
   *     SuggestedAdUnitServiceClient.create()) {
   *   ListSuggestedAdUnitsRequest request =
   *       ListSuggestedAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (SuggestedAdUnit element :
   *       suggestedAdUnitServiceClient.listSuggestedAdUnits(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSuggestedAdUnitsPagedResponse listSuggestedAdUnits(
      ListSuggestedAdUnitsRequest request) {
    return listSuggestedAdUnitsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a list of `SuggestedAdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SuggestedAdUnitServiceClient suggestedAdUnitServiceClient =
   *     SuggestedAdUnitServiceClient.create()) {
   *   ListSuggestedAdUnitsRequest request =
   *       ListSuggestedAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<SuggestedAdUnit> future =
   *       suggestedAdUnitServiceClient.listSuggestedAdUnitsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SuggestedAdUnit element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsPagedResponse>
      listSuggestedAdUnitsPagedCallable() {
    return stub.listSuggestedAdUnitsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a list of `SuggestedAdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SuggestedAdUnitServiceClient suggestedAdUnitServiceClient =
   *     SuggestedAdUnitServiceClient.create()) {
   *   ListSuggestedAdUnitsRequest request =
   *       ListSuggestedAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListSuggestedAdUnitsResponse response =
   *         suggestedAdUnitServiceClient.listSuggestedAdUnitsCallable().call(request);
   *     for (SuggestedAdUnit element : response.getSuggestedAdUnitsList()) {
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
  public final UnaryCallable<ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsResponse>
      listSuggestedAdUnitsCallable() {
    return stub.listSuggestedAdUnitsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk approve `SuggestedAdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SuggestedAdUnitServiceClient suggestedAdUnitServiceClient =
   *     SuggestedAdUnitServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchApproveSuggestedAdUnitsResponse response =
   *       suggestedAdUnitServiceClient.batchApproveSuggestedAdUnits(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the `SuggestedAdUnit` objects to approve. Format:
   *     `networks/{network_code}/suggestedAdUnits/{suggested_ad_unit_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchApproveSuggestedAdUnitsResponse batchApproveSuggestedAdUnits(
      @Nullable NetworkName parent, List<String> names) {
    BatchApproveSuggestedAdUnitsRequest request =
        BatchApproveSuggestedAdUnitsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchApproveSuggestedAdUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk approve `SuggestedAdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SuggestedAdUnitServiceClient suggestedAdUnitServiceClient =
   *     SuggestedAdUnitServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchApproveSuggestedAdUnitsResponse response =
   *       suggestedAdUnitServiceClient.batchApproveSuggestedAdUnits(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. Resource names for the `SuggestedAdUnit` objects to approve. Format:
   *     `networks/{network_code}/suggestedAdUnits/{suggested_ad_unit_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchApproveSuggestedAdUnitsResponse batchApproveSuggestedAdUnits(
      String parent, List<String> names) {
    BatchApproveSuggestedAdUnitsRequest request =
        BatchApproveSuggestedAdUnitsRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchApproveSuggestedAdUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk approve `SuggestedAdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SuggestedAdUnitServiceClient suggestedAdUnitServiceClient =
   *     SuggestedAdUnitServiceClient.create()) {
   *   BatchApproveSuggestedAdUnitsRequest request =
   *       BatchApproveSuggestedAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchApproveSuggestedAdUnitsResponse response =
   *       suggestedAdUnitServiceClient.batchApproveSuggestedAdUnits(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchApproveSuggestedAdUnitsResponse batchApproveSuggestedAdUnits(
      BatchApproveSuggestedAdUnitsRequest request) {
    return batchApproveSuggestedAdUnitsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk approve `SuggestedAdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SuggestedAdUnitServiceClient suggestedAdUnitServiceClient =
   *     SuggestedAdUnitServiceClient.create()) {
   *   BatchApproveSuggestedAdUnitsRequest request =
   *       BatchApproveSuggestedAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchApproveSuggestedAdUnitsResponse> future =
   *       suggestedAdUnitServiceClient.batchApproveSuggestedAdUnitsCallable().futureCall(request);
   *   // Do something.
   *   BatchApproveSuggestedAdUnitsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchApproveSuggestedAdUnitsRequest, BatchApproveSuggestedAdUnitsResponse>
      batchApproveSuggestedAdUnitsCallable() {
    return stub.batchApproveSuggestedAdUnitsCallable();
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

  public static class ListSuggestedAdUnitsPagedResponse
      extends AbstractPagedListResponse<
          ListSuggestedAdUnitsRequest,
          ListSuggestedAdUnitsResponse,
          SuggestedAdUnit,
          ListSuggestedAdUnitsPage,
          ListSuggestedAdUnitsFixedSizeCollection> {

    public static ApiFuture<ListSuggestedAdUnitsPagedResponse> createAsync(
        PageContext<ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsResponse, SuggestedAdUnit>
            context,
        ApiFuture<ListSuggestedAdUnitsResponse> futureResponse) {
      ApiFuture<ListSuggestedAdUnitsPage> futurePage =
          ListSuggestedAdUnitsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSuggestedAdUnitsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSuggestedAdUnitsPagedResponse(ListSuggestedAdUnitsPage page) {
      super(page, ListSuggestedAdUnitsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSuggestedAdUnitsPage
      extends AbstractPage<
          ListSuggestedAdUnitsRequest,
          ListSuggestedAdUnitsResponse,
          SuggestedAdUnit,
          ListSuggestedAdUnitsPage> {

    private ListSuggestedAdUnitsPage(
        @Nullable
            PageContext<ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsResponse, SuggestedAdUnit>
            context,
        @Nullable ListSuggestedAdUnitsResponse response) {
      super(context, response);
    }

    private static ListSuggestedAdUnitsPage createEmptyPage() {
      return new ListSuggestedAdUnitsPage(null, null);
    }

    @Override
    protected ListSuggestedAdUnitsPage createPage(
        @Nullable
            PageContext<ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsResponse, SuggestedAdUnit>
            context,
        @Nullable ListSuggestedAdUnitsResponse response) {
      return new ListSuggestedAdUnitsPage(context, response);
    }

    @Override
    public ApiFuture<ListSuggestedAdUnitsPage> createPageAsync(
        @Nullable
            PageContext<ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsResponse, SuggestedAdUnit>
            context,
        ApiFuture<ListSuggestedAdUnitsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSuggestedAdUnitsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSuggestedAdUnitsRequest,
          ListSuggestedAdUnitsResponse,
          SuggestedAdUnit,
          ListSuggestedAdUnitsPage,
          ListSuggestedAdUnitsFixedSizeCollection> {

    private ListSuggestedAdUnitsFixedSizeCollection(
        @Nullable List<ListSuggestedAdUnitsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSuggestedAdUnitsFixedSizeCollection createEmptyCollection() {
      return new ListSuggestedAdUnitsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSuggestedAdUnitsFixedSizeCollection createCollection(
        @Nullable List<ListSuggestedAdUnitsPage> pages, int collectionSize) {
      return new ListSuggestedAdUnitsFixedSizeCollection(pages, collectionSize);
    }
  }
}
