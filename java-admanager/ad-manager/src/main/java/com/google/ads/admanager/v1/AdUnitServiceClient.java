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

import com.google.ads.admanager.v1.stub.AdUnitServiceStub;
import com.google.ads.admanager.v1.stub.AdUnitServiceStubSettings;
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
 * Service Description: Provides methods for handling AdUnit objects.
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
 * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
 *   AdUnitName name = AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]");
 *   AdUnit response = adUnitServiceClient.getAdUnit(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AdUnitServiceClient object to clean up resources such
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
 *      <td><p> GetAdUnit</td>
 *      <td><p> API to retrieve an AdUnit object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAdUnit(GetAdUnitRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAdUnit(AdUnitName name)
 *           <li><p> getAdUnit(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAdUnitCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAdUnits</td>
 *      <td><p> API to retrieve a list of AdUnit objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAdUnits(ListAdUnitsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAdUnits(NetworkName parent)
 *           <li><p> listAdUnits(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAdUnitsPagedCallable()
 *           <li><p> listAdUnitsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAdUnitSizes</td>
 *      <td><p> API to retrieve a list of AdUnitSize objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAdUnitSizes(ListAdUnitSizesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAdUnitSizes(NetworkName parent)
 *           <li><p> listAdUnitSizes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAdUnitSizesPagedCallable()
 *           <li><p> listAdUnitSizesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAdUnit</td>
 *      <td><p> API to create an `AdUnit` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAdUnit(CreateAdUnitRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAdUnit(NetworkName parent, AdUnit adUnit)
 *           <li><p> createAdUnit(String parent, AdUnit adUnit)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAdUnitCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAdUnit</td>
 *      <td><p> API to update an `AdUnit` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAdUnit(UpdateAdUnitRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAdUnit(AdUnit adUnit, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAdUnitCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateAdUnits</td>
 *      <td><p> API to batch create `AdUnit` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateAdUnits(NetworkName parent, List&lt;CreateAdUnitRequest&gt; requests)
 *           <li><p> batchCreateAdUnits(String parent, List&lt;CreateAdUnitRequest&gt; requests)
 *           <li><p> batchCreateAdUnits(BatchCreateAdUnitsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateAdUnitsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateAdUnits</td>
 *      <td><p> API to batch update `AdUnit` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateAdUnits(NetworkName parent, List&lt;UpdateAdUnitRequest&gt; requests)
 *           <li><p> batchUpdateAdUnits(String parent, List&lt;UpdateAdUnitRequest&gt; requests)
 *           <li><p> batchUpdateAdUnits(BatchUpdateAdUnitsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateAdUnitsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchActivateAdUnits</td>
 *      <td><p> API to batch activate `AdUnit` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchActivateAdUnits(BatchActivateAdUnitsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchActivateAdUnits(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchActivateAdUnits(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchActivateAdUnitsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeactivateAdUnits</td>
 *      <td><p> Deactivates a list of `AdUnit` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeactivateAdUnits(BatchDeactivateAdUnitsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDeactivateAdUnits(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchDeactivateAdUnits(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeactivateAdUnitsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchArchiveAdUnits</td>
 *      <td><p> Archives a list of `AdUnit` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchArchiveAdUnits(BatchArchiveAdUnitsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchArchiveAdUnits(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchArchiveAdUnits(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchArchiveAdUnitsCallable()
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
 * <p>This class can be customized by passing in a custom instance of AdUnitServiceSettings to
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
 * AdUnitServiceSettings adUnitServiceSettings =
 *     AdUnitServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create(adUnitServiceSettings);
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
 * AdUnitServiceSettings adUnitServiceSettings =
 *     AdUnitServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create(adUnitServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AdUnitServiceClient implements BackgroundResource {
  private final AdUnitServiceSettings settings;
  private final AdUnitServiceStub stub;

  /** Constructs an instance of AdUnitServiceClient with default settings. */
  public static final AdUnitServiceClient create() throws IOException {
    return create(AdUnitServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AdUnitServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AdUnitServiceClient create(AdUnitServiceSettings settings)
      throws IOException {
    return new AdUnitServiceClient(settings);
  }

  /**
   * Constructs an instance of AdUnitServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(AdUnitServiceSettings).
   */
  public static final AdUnitServiceClient create(AdUnitServiceStub stub) {
    return new AdUnitServiceClient(stub);
  }

  /**
   * Constructs an instance of AdUnitServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AdUnitServiceClient(AdUnitServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AdUnitServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AdUnitServiceClient(AdUnitServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AdUnitServiceSettings getSettings() {
    return settings;
  }

  public AdUnitServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an AdUnit object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   AdUnitName name = AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]");
   *   AdUnit response = adUnitServiceClient.getAdUnit(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AdUnit. Format:
   *     `networks/{network_code}/adUnits/{ad_unit_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdUnit getAdUnit(AdUnitName name) {
    GetAdUnitRequest request =
        GetAdUnitRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAdUnit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an AdUnit object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   String name = AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]").toString();
   *   AdUnit response = adUnitServiceClient.getAdUnit(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AdUnit. Format:
   *     `networks/{network_code}/adUnits/{ad_unit_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdUnit getAdUnit(String name) {
    GetAdUnitRequest request = GetAdUnitRequest.newBuilder().setName(name).build();
    return getAdUnit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an AdUnit object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   GetAdUnitRequest request =
   *       GetAdUnitRequest.newBuilder()
   *           .setName(AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]").toString())
   *           .build();
   *   AdUnit response = adUnitServiceClient.getAdUnit(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdUnit getAdUnit(GetAdUnitRequest request) {
    return getAdUnitCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an AdUnit object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   GetAdUnitRequest request =
   *       GetAdUnitRequest.newBuilder()
   *           .setName(AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]").toString())
   *           .build();
   *   ApiFuture<AdUnit> future = adUnitServiceClient.getAdUnitCallable().futureCall(request);
   *   // Do something.
   *   AdUnit response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAdUnitRequest, AdUnit> getAdUnitCallable() {
    return stub.getAdUnitCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdUnit objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (AdUnit element : adUnitServiceClient.listAdUnits(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdUnits. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdUnitsPagedResponse listAdUnits(NetworkName parent) {
    ListAdUnitsRequest request =
        ListAdUnitsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAdUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdUnit objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (AdUnit element : adUnitServiceClient.listAdUnits(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdUnits. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdUnitsPagedResponse listAdUnits(String parent) {
    ListAdUnitsRequest request = ListAdUnitsRequest.newBuilder().setParent(parent).build();
    return listAdUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdUnit objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   ListAdUnitsRequest request =
   *       ListAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (AdUnit element : adUnitServiceClient.listAdUnits(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdUnitsPagedResponse listAdUnits(ListAdUnitsRequest request) {
    return listAdUnitsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdUnit objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   ListAdUnitsRequest request =
   *       ListAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<AdUnit> future = adUnitServiceClient.listAdUnitsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AdUnit element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAdUnitsRequest, ListAdUnitsPagedResponse>
      listAdUnitsPagedCallable() {
    return stub.listAdUnitsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdUnit objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   ListAdUnitsRequest request =
   *       ListAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListAdUnitsResponse response = adUnitServiceClient.listAdUnitsCallable().call(request);
   *     for (AdUnit element : response.getAdUnitsList()) {
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
  public final UnaryCallable<ListAdUnitsRequest, ListAdUnitsResponse> listAdUnitsCallable() {
    return stub.listAdUnitsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdUnitSize objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (AdUnitSize element : adUnitServiceClient.listAdUnitSizes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdUnitSizes. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdUnitSizesPagedResponse listAdUnitSizes(NetworkName parent) {
    ListAdUnitSizesRequest request =
        ListAdUnitSizesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAdUnitSizes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdUnitSize objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (AdUnitSize element : adUnitServiceClient.listAdUnitSizes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdUnitSizes. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdUnitSizesPagedResponse listAdUnitSizes(String parent) {
    ListAdUnitSizesRequest request = ListAdUnitSizesRequest.newBuilder().setParent(parent).build();
    return listAdUnitSizes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdUnitSize objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   ListAdUnitSizesRequest request =
   *       ListAdUnitSizesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (AdUnitSize element : adUnitServiceClient.listAdUnitSizes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdUnitSizesPagedResponse listAdUnitSizes(ListAdUnitSizesRequest request) {
    return listAdUnitSizesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdUnitSize objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   ListAdUnitSizesRequest request =
   *       ListAdUnitSizesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<AdUnitSize> future =
   *       adUnitServiceClient.listAdUnitSizesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AdUnitSize element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAdUnitSizesRequest, ListAdUnitSizesPagedResponse>
      listAdUnitSizesPagedCallable() {
    return stub.listAdUnitSizesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of AdUnitSize objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   ListAdUnitSizesRequest request =
   *       ListAdUnitSizesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListAdUnitSizesResponse response =
   *         adUnitServiceClient.listAdUnitSizesCallable().call(request);
   *     for (AdUnitSize element : response.getAdUnitSizesList()) {
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
  public final UnaryCallable<ListAdUnitSizesRequest, ListAdUnitSizesResponse>
      listAdUnitSizesCallable() {
    return stub.listAdUnitSizesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create an `AdUnit` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   AdUnit adUnit = AdUnit.newBuilder().build();
   *   AdUnit response = adUnitServiceClient.createAdUnit(parent, adUnit);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `AdUnit` will be created. Format:
   *     `networks/{network_code}`
   * @param adUnit Required. The `AdUnit` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdUnit createAdUnit(NetworkName parent, AdUnit adUnit) {
    CreateAdUnitRequest request =
        CreateAdUnitRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAdUnit(adUnit)
            .build();
    return createAdUnit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create an `AdUnit` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   AdUnit adUnit = AdUnit.newBuilder().build();
   *   AdUnit response = adUnitServiceClient.createAdUnit(parent, adUnit);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `AdUnit` will be created. Format:
   *     `networks/{network_code}`
   * @param adUnit Required. The `AdUnit` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdUnit createAdUnit(String parent, AdUnit adUnit) {
    CreateAdUnitRequest request =
        CreateAdUnitRequest.newBuilder().setParent(parent).setAdUnit(adUnit).build();
    return createAdUnit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create an `AdUnit` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   CreateAdUnitRequest request =
   *       CreateAdUnitRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setAdUnit(AdUnit.newBuilder().build())
   *           .build();
   *   AdUnit response = adUnitServiceClient.createAdUnit(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdUnit createAdUnit(CreateAdUnitRequest request) {
    return createAdUnitCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create an `AdUnit` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   CreateAdUnitRequest request =
   *       CreateAdUnitRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setAdUnit(AdUnit.newBuilder().build())
   *           .build();
   *   ApiFuture<AdUnit> future = adUnitServiceClient.createAdUnitCallable().futureCall(request);
   *   // Do something.
   *   AdUnit response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAdUnitRequest, AdUnit> createAdUnitCallable() {
    return stub.createAdUnitCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update an `AdUnit` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   AdUnit adUnit = AdUnit.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AdUnit response = adUnitServiceClient.updateAdUnit(adUnit, updateMask);
   * }
   * }</pre>
   *
   * @param adUnit Required. The `AdUnit` to update.
   *     <p>The `AdUnit`'s name is used to identify the `AdUnit` to update. Format:
   *     `networks/{network_code}/adUnits/{ad_unit_id}`
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdUnit updateAdUnit(AdUnit adUnit, FieldMask updateMask) {
    UpdateAdUnitRequest request =
        UpdateAdUnitRequest.newBuilder().setAdUnit(adUnit).setUpdateMask(updateMask).build();
    return updateAdUnit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update an `AdUnit` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   UpdateAdUnitRequest request =
   *       UpdateAdUnitRequest.newBuilder()
   *           .setAdUnit(AdUnit.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AdUnit response = adUnitServiceClient.updateAdUnit(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdUnit updateAdUnit(UpdateAdUnitRequest request) {
    return updateAdUnitCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update an `AdUnit` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   UpdateAdUnitRequest request =
   *       UpdateAdUnitRequest.newBuilder()
   *           .setAdUnit(AdUnit.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AdUnit> future = adUnitServiceClient.updateAdUnitCallable().futureCall(request);
   *   // Do something.
   *   AdUnit response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAdUnitRequest, AdUnit> updateAdUnitCallable() {
    return stub.updateAdUnitCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateAdUnitRequest> requests = new ArrayList<>();
   *   BatchCreateAdUnitsResponse response =
   *       adUnitServiceClient.batchCreateAdUnits(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `AdUnits` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateAdUnitRequest must match this
   *     field.
   * @param requests Required. The `AdUnit` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateAdUnitsResponse batchCreateAdUnits(
      NetworkName parent, List<CreateAdUnitRequest> requests) {
    BatchCreateAdUnitsRequest request =
        BatchCreateAdUnitsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateAdUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateAdUnitRequest> requests = new ArrayList<>();
   *   BatchCreateAdUnitsResponse response =
   *       adUnitServiceClient.batchCreateAdUnits(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `AdUnits` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateAdUnitRequest must match this
   *     field.
   * @param requests Required. The `AdUnit` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateAdUnitsResponse batchCreateAdUnits(
      String parent, List<CreateAdUnitRequest> requests) {
    BatchCreateAdUnitsRequest request =
        BatchCreateAdUnitsRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchCreateAdUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   BatchCreateAdUnitsRequest request =
   *       BatchCreateAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateAdUnitRequest>())
   *           .build();
   *   BatchCreateAdUnitsResponse response = adUnitServiceClient.batchCreateAdUnits(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateAdUnitsResponse batchCreateAdUnits(BatchCreateAdUnitsRequest request) {
    return batchCreateAdUnitsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch create `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   BatchCreateAdUnitsRequest request =
   *       BatchCreateAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateAdUnitRequest>())
   *           .build();
   *   ApiFuture<BatchCreateAdUnitsResponse> future =
   *       adUnitServiceClient.batchCreateAdUnitsCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateAdUnitsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateAdUnitsRequest, BatchCreateAdUnitsResponse>
      batchCreateAdUnitsCallable() {
    return stub.batchCreateAdUnitsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateAdUnitRequest> requests = new ArrayList<>();
   *   BatchUpdateAdUnitsResponse response =
   *       adUnitServiceClient.batchUpdateAdUnits(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `AdUnits` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateAdUnitRequest must match this
   *     field.
   * @param requests Required. The `AdUnit` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateAdUnitsResponse batchUpdateAdUnits(
      NetworkName parent, List<UpdateAdUnitRequest> requests) {
    BatchUpdateAdUnitsRequest request =
        BatchUpdateAdUnitsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateAdUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateAdUnitRequest> requests = new ArrayList<>();
   *   BatchUpdateAdUnitsResponse response =
   *       adUnitServiceClient.batchUpdateAdUnits(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `AdUnits` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateAdUnitRequest must match this
   *     field.
   * @param requests Required. The `AdUnit` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateAdUnitsResponse batchUpdateAdUnits(
      String parent, List<UpdateAdUnitRequest> requests) {
    BatchUpdateAdUnitsRequest request =
        BatchUpdateAdUnitsRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchUpdateAdUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   BatchUpdateAdUnitsRequest request =
   *       BatchUpdateAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateAdUnitRequest>())
   *           .build();
   *   BatchUpdateAdUnitsResponse response = adUnitServiceClient.batchUpdateAdUnits(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateAdUnitsResponse batchUpdateAdUnits(BatchUpdateAdUnitsRequest request) {
    return batchUpdateAdUnitsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch update `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   BatchUpdateAdUnitsRequest request =
   *       BatchUpdateAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateAdUnitRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateAdUnitsResponse> future =
   *       adUnitServiceClient.batchUpdateAdUnitsCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateAdUnitsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateAdUnitsRequest, BatchUpdateAdUnitsResponse>
      batchUpdateAdUnitsCallable() {
    return stub.batchUpdateAdUnitsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch activate `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchActivateAdUnitsResponse response =
   *       adUnitServiceClient.batchActivateAdUnits(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `AdUnit`s to activate. Format:
   *     `networks/{network_code}/adUnits/{ad_unit_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateAdUnitsResponse batchActivateAdUnits(
      NetworkName parent, List<String> names) {
    BatchActivateAdUnitsRequest request =
        BatchActivateAdUnitsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchActivateAdUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch activate `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchActivateAdUnitsResponse response =
   *       adUnitServiceClient.batchActivateAdUnits(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `AdUnit`s to activate. Format:
   *     `networks/{network_code}/adUnits/{ad_unit_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateAdUnitsResponse batchActivateAdUnits(
      String parent, List<String> names) {
    BatchActivateAdUnitsRequest request =
        BatchActivateAdUnitsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchActivateAdUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch activate `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   BatchActivateAdUnitsRequest request =
   *       BatchActivateAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchActivateAdUnitsResponse response = adUnitServiceClient.batchActivateAdUnits(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateAdUnitsResponse batchActivateAdUnits(
      BatchActivateAdUnitsRequest request) {
    return batchActivateAdUnitsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch activate `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   BatchActivateAdUnitsRequest request =
   *       BatchActivateAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchActivateAdUnitsResponse> future =
   *       adUnitServiceClient.batchActivateAdUnitsCallable().futureCall(request);
   *   // Do something.
   *   BatchActivateAdUnitsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchActivateAdUnitsRequest, BatchActivateAdUnitsResponse>
      batchActivateAdUnitsCallable() {
    return stub.batchActivateAdUnitsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateAdUnitsResponse response =
   *       adUnitServiceClient.batchDeactivateAdUnits(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `AdUnit`s to deactivate. Format:
   *     `networks/{network_code}/adUnits/{ad_unit_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateAdUnitsResponse batchDeactivateAdUnits(
      NetworkName parent, List<String> names) {
    BatchDeactivateAdUnitsRequest request =
        BatchDeactivateAdUnitsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchDeactivateAdUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchDeactivateAdUnitsResponse response =
   *       adUnitServiceClient.batchDeactivateAdUnits(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `AdUnit`s to deactivate. Format:
   *     `networks/{network_code}/adUnits/{ad_unit_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateAdUnitsResponse batchDeactivateAdUnits(
      String parent, List<String> names) {
    BatchDeactivateAdUnitsRequest request =
        BatchDeactivateAdUnitsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchDeactivateAdUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   BatchDeactivateAdUnitsRequest request =
   *       BatchDeactivateAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchDeactivateAdUnitsResponse response = adUnitServiceClient.batchDeactivateAdUnits(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDeactivateAdUnitsResponse batchDeactivateAdUnits(
      BatchDeactivateAdUnitsRequest request) {
    return batchDeactivateAdUnitsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deactivates a list of `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   BatchDeactivateAdUnitsRequest request =
   *       BatchDeactivateAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchDeactivateAdUnitsResponse> future =
   *       adUnitServiceClient.batchDeactivateAdUnitsCallable().futureCall(request);
   *   // Do something.
   *   BatchDeactivateAdUnitsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeactivateAdUnitsRequest, BatchDeactivateAdUnitsResponse>
      batchDeactivateAdUnitsCallable() {
    return stub.batchDeactivateAdUnitsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchArchiveAdUnitsResponse response = adUnitServiceClient.batchArchiveAdUnits(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `AdUnit`s to archive. Format:
   *     `networks/{network_code}/adUnits/{ad_unit_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveAdUnitsResponse batchArchiveAdUnits(
      NetworkName parent, List<String> names) {
    BatchArchiveAdUnitsRequest request =
        BatchArchiveAdUnitsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchArchiveAdUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchArchiveAdUnitsResponse response = adUnitServiceClient.batchArchiveAdUnits(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `AdUnit`s to archive. Format:
   *     `networks/{network_code}/adUnits/{ad_unit_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveAdUnitsResponse batchArchiveAdUnits(String parent, List<String> names) {
    BatchArchiveAdUnitsRequest request =
        BatchArchiveAdUnitsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchArchiveAdUnits(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   BatchArchiveAdUnitsRequest request =
   *       BatchArchiveAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchArchiveAdUnitsResponse response = adUnitServiceClient.batchArchiveAdUnits(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveAdUnitsResponse batchArchiveAdUnits(BatchArchiveAdUnitsRequest request) {
    return batchArchiveAdUnitsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives a list of `AdUnit` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
   *   BatchArchiveAdUnitsRequest request =
   *       BatchArchiveAdUnitsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchArchiveAdUnitsResponse> future =
   *       adUnitServiceClient.batchArchiveAdUnitsCallable().futureCall(request);
   *   // Do something.
   *   BatchArchiveAdUnitsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchArchiveAdUnitsRequest, BatchArchiveAdUnitsResponse>
      batchArchiveAdUnitsCallable() {
    return stub.batchArchiveAdUnitsCallable();
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

  public static class ListAdUnitsPagedResponse
      extends AbstractPagedListResponse<
          ListAdUnitsRequest,
          ListAdUnitsResponse,
          AdUnit,
          ListAdUnitsPage,
          ListAdUnitsFixedSizeCollection> {

    public static ApiFuture<ListAdUnitsPagedResponse> createAsync(
        PageContext<ListAdUnitsRequest, ListAdUnitsResponse, AdUnit> context,
        ApiFuture<ListAdUnitsResponse> futureResponse) {
      ApiFuture<ListAdUnitsPage> futurePage =
          ListAdUnitsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListAdUnitsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListAdUnitsPagedResponse(ListAdUnitsPage page) {
      super(page, ListAdUnitsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAdUnitsPage
      extends AbstractPage<ListAdUnitsRequest, ListAdUnitsResponse, AdUnit, ListAdUnitsPage> {

    private ListAdUnitsPage(
        PageContext<ListAdUnitsRequest, ListAdUnitsResponse, AdUnit> context,
        ListAdUnitsResponse response) {
      super(context, response);
    }

    private static ListAdUnitsPage createEmptyPage() {
      return new ListAdUnitsPage(null, null);
    }

    @Override
    protected ListAdUnitsPage createPage(
        PageContext<ListAdUnitsRequest, ListAdUnitsResponse, AdUnit> context,
        ListAdUnitsResponse response) {
      return new ListAdUnitsPage(context, response);
    }

    @Override
    public ApiFuture<ListAdUnitsPage> createPageAsync(
        PageContext<ListAdUnitsRequest, ListAdUnitsResponse, AdUnit> context,
        ApiFuture<ListAdUnitsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAdUnitsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAdUnitsRequest,
          ListAdUnitsResponse,
          AdUnit,
          ListAdUnitsPage,
          ListAdUnitsFixedSizeCollection> {

    private ListAdUnitsFixedSizeCollection(List<ListAdUnitsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAdUnitsFixedSizeCollection createEmptyCollection() {
      return new ListAdUnitsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAdUnitsFixedSizeCollection createCollection(
        List<ListAdUnitsPage> pages, int collectionSize) {
      return new ListAdUnitsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAdUnitSizesPagedResponse
      extends AbstractPagedListResponse<
          ListAdUnitSizesRequest,
          ListAdUnitSizesResponse,
          AdUnitSize,
          ListAdUnitSizesPage,
          ListAdUnitSizesFixedSizeCollection> {

    public static ApiFuture<ListAdUnitSizesPagedResponse> createAsync(
        PageContext<ListAdUnitSizesRequest, ListAdUnitSizesResponse, AdUnitSize> context,
        ApiFuture<ListAdUnitSizesResponse> futureResponse) {
      ApiFuture<ListAdUnitSizesPage> futurePage =
          ListAdUnitSizesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAdUnitSizesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAdUnitSizesPagedResponse(ListAdUnitSizesPage page) {
      super(page, ListAdUnitSizesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAdUnitSizesPage
      extends AbstractPage<
          ListAdUnitSizesRequest, ListAdUnitSizesResponse, AdUnitSize, ListAdUnitSizesPage> {

    private ListAdUnitSizesPage(
        PageContext<ListAdUnitSizesRequest, ListAdUnitSizesResponse, AdUnitSize> context,
        ListAdUnitSizesResponse response) {
      super(context, response);
    }

    private static ListAdUnitSizesPage createEmptyPage() {
      return new ListAdUnitSizesPage(null, null);
    }

    @Override
    protected ListAdUnitSizesPage createPage(
        PageContext<ListAdUnitSizesRequest, ListAdUnitSizesResponse, AdUnitSize> context,
        ListAdUnitSizesResponse response) {
      return new ListAdUnitSizesPage(context, response);
    }

    @Override
    public ApiFuture<ListAdUnitSizesPage> createPageAsync(
        PageContext<ListAdUnitSizesRequest, ListAdUnitSizesResponse, AdUnitSize> context,
        ApiFuture<ListAdUnitSizesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAdUnitSizesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAdUnitSizesRequest,
          ListAdUnitSizesResponse,
          AdUnitSize,
          ListAdUnitSizesPage,
          ListAdUnitSizesFixedSizeCollection> {

    private ListAdUnitSizesFixedSizeCollection(
        List<ListAdUnitSizesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAdUnitSizesFixedSizeCollection createEmptyCollection() {
      return new ListAdUnitSizesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAdUnitSizesFixedSizeCollection createCollection(
        List<ListAdUnitSizesPage> pages, int collectionSize) {
      return new ListAdUnitSizesFixedSizeCollection(pages, collectionSize);
    }
  }
}
