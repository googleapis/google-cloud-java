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

import com.google.ads.admanager.v1.stub.AdBreakServiceStub;
import com.google.ads.admanager.v1.stub.AdBreakServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `AdBreak` objects.
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
 * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
 *   AdBreakName name = AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]");
 *   AdBreak response = adBreakServiceClient.getAdBreak(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AdBreakServiceClient object to clean up resources such
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
 *      <td><p> GetAdBreak</td>
 *      <td><p> API to retrieve an `AdBreak` object.
 * <p>  Query an ad break by its resource name or custom asset key. Check the resource's `breakState` field to determine its state.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAdBreak(GetAdBreakRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAdBreak(AdBreakName name)
 *           <li><p> getAdBreak(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAdBreakCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAdBreaks</td>
 *      <td><p> API to retrieve a list of `AdBreak` objects.
 * <p>  By default, when no `orderBy` query parameter is specified, ad breaks are ordered reverse chronologically. However, ad breaks with a 'breakState' of 'SCHEDULED' or 'DECISIONED' are prioritized and appear first.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAdBreaks(ListAdBreaksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAdBreaks(LiveStreamEventName parent)
 *           <li><p> listAdBreaks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAdBreaksPagedCallable()
 *           <li><p> listAdBreaksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAdBreak</td>
 *      <td><p> API to create an `AdBreak` object.
 * <p>  Informs DAI of an upcoming ad break for a live stream event, with an optional expected start time. DAI will begin decisioning ads for the break shortly before the expected start time, if provided. Each live stream event can only have one incomplete ad break at any given time. The next ad break can be scheduled after the previous ad break has started serving, indicated by its state being [`COMPLETE`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.COMPLETE], or it has been deleted.
 * <p>  This method cannot be used if the `LiveStreamEvent` has [prefetching ad breaks enabled](https://developers.google.com/ad-manager/api/reference/latest/LiveStreamEventService.LiveStreamEvent#prefetchenabled) or the event is not active. If a `LiveStreamEvent` is deactivated after creating an ad break and before the ad break is complete, the ad break is discarded.
 * <p>  An ad break's state is complete when the following occurs:  - Full service DAI: after a matching ad break shows in the  `LiveStreamEvent` manifest only when the ad break has started decisioning.  - Pod Serving: after the ad break is requested using the ad break ID or  break sequence.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAdBreak(CreateAdBreakRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAdBreak(LiveStreamEventName parent, AdBreak adBreak)
 *           <li><p> createAdBreak(String parent, AdBreak adBreak)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAdBreakCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAdBreak</td>
 *      <td><p> API to update an `AdBreak` object.
 * <p>  Modify an ad break when its state is [`SCHEDULED`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.SCHEDULED].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAdBreak(UpdateAdBreakRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAdBreak(AdBreak adBreak, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAdBreakCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAdBreak</td>
 *      <td><p> API to delete an `AdBreak` object.
 * <p>  Deletes and cancels an incomplete ad break, mitigating the need to wait for the current break to serve before recreating an ad break. You can delete an ad break that has not started serving or seen in manifests, indicated by its state being [`SCHEDULED`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.SCHEDULED] or [`DECISIONED`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.DECISIONED].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAdBreak(DeleteAdBreakRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAdBreak(AdBreakName name)
 *           <li><p> deleteAdBreak(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAdBreakCallable()
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
 * <p>This class can be customized by passing in a custom instance of AdBreakServiceSettings to
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
 * AdBreakServiceSettings adBreakServiceSettings =
 *     AdBreakServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create(adBreakServiceSettings);
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
 * AdBreakServiceSettings adBreakServiceSettings =
 *     AdBreakServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create(adBreakServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AdBreakServiceClient implements BackgroundResource {
  private final AdBreakServiceSettings settings;
  private final AdBreakServiceStub stub;

  /** Constructs an instance of AdBreakServiceClient with default settings. */
  public static final AdBreakServiceClient create() throws IOException {
    return create(AdBreakServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AdBreakServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AdBreakServiceClient create(AdBreakServiceSettings settings)
      throws IOException {
    return new AdBreakServiceClient(settings);
  }

  /**
   * Constructs an instance of AdBreakServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(AdBreakServiceSettings).
   */
  public static final AdBreakServiceClient create(AdBreakServiceStub stub) {
    return new AdBreakServiceClient(stub);
  }

  /**
   * Constructs an instance of AdBreakServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AdBreakServiceClient(AdBreakServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AdBreakServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AdBreakServiceClient(AdBreakServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AdBreakServiceSettings getSettings() {
    return settings;
  }

  public AdBreakServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an `AdBreak` object.
   *
   * <p>Query an ad break by its resource name or custom asset key. Check the resource's
   * `breakState` field to determine its state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   AdBreakName name = AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]");
   *   AdBreak response = adBreakServiceClient.getAdBreak(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AdBreak using the asset key or custom asset key.
   *     <p>Format:
   *     `networks/{network_code}/liveStreamEventsByAssetKey/{asset_key}/adBreaks/{ad_break_id}`
   *     `networks/{network_code}/liveStreamEventsByCustomAssetKey/{custom_asset_key}/adBreaks/{ad_break_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdBreak getAdBreak(AdBreakName name) {
    GetAdBreakRequest request =
        GetAdBreakRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAdBreak(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an `AdBreak` object.
   *
   * <p>Query an ad break by its resource name or custom asset key. Check the resource's
   * `breakState` field to determine its state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   String name = AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]").toString();
   *   AdBreak response = adBreakServiceClient.getAdBreak(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AdBreak using the asset key or custom asset key.
   *     <p>Format:
   *     `networks/{network_code}/liveStreamEventsByAssetKey/{asset_key}/adBreaks/{ad_break_id}`
   *     `networks/{network_code}/liveStreamEventsByCustomAssetKey/{custom_asset_key}/adBreaks/{ad_break_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdBreak getAdBreak(String name) {
    GetAdBreakRequest request = GetAdBreakRequest.newBuilder().setName(name).build();
    return getAdBreak(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an `AdBreak` object.
   *
   * <p>Query an ad break by its resource name or custom asset key. Check the resource's
   * `breakState` field to determine its state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   GetAdBreakRequest request =
   *       GetAdBreakRequest.newBuilder()
   *           .setName(AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]").toString())
   *           .build();
   *   AdBreak response = adBreakServiceClient.getAdBreak(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdBreak getAdBreak(GetAdBreakRequest request) {
    return getAdBreakCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an `AdBreak` object.
   *
   * <p>Query an ad break by its resource name or custom asset key. Check the resource's
   * `breakState` field to determine its state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   GetAdBreakRequest request =
   *       GetAdBreakRequest.newBuilder()
   *           .setName(AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]").toString())
   *           .build();
   *   ApiFuture<AdBreak> future = adBreakServiceClient.getAdBreakCallable().futureCall(request);
   *   // Do something.
   *   AdBreak response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAdBreakRequest, AdBreak> getAdBreakCallable() {
    return stub.getAdBreakCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `AdBreak` objects.
   *
   * <p>By default, when no `orderBy` query parameter is specified, ad breaks are ordered reverse
   * chronologically. However, ad breaks with a 'breakState' of 'SCHEDULED' or 'DECISIONED' are
   * prioritized and appear first.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   LiveStreamEventName parent = LiveStreamEventName.of("[NETWORK_CODE]", "[LIVE_STREAM_EVENT]");
   *   for (AdBreak element : adBreakServiceClient.listAdBreaks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdBreaks.
   *     <p>Formats: `networks/{network_code}/liveStreamEventsByAssetKey/{asset_key}`
   *     `networks/{network_code}/liveStreamEventsByCustomAssetKey/{custom_asset_key}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdBreaksPagedResponse listAdBreaks(LiveStreamEventName parent) {
    ListAdBreaksRequest request =
        ListAdBreaksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAdBreaks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `AdBreak` objects.
   *
   * <p>By default, when no `orderBy` query parameter is specified, ad breaks are ordered reverse
   * chronologically. However, ad breaks with a 'breakState' of 'SCHEDULED' or 'DECISIONED' are
   * prioritized and appear first.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   String parent = LiveStreamEventName.of("[NETWORK_CODE]", "[LIVE_STREAM_EVENT]").toString();
   *   for (AdBreak element : adBreakServiceClient.listAdBreaks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdBreaks.
   *     <p>Formats: `networks/{network_code}/liveStreamEventsByAssetKey/{asset_key}`
   *     `networks/{network_code}/liveStreamEventsByCustomAssetKey/{custom_asset_key}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdBreaksPagedResponse listAdBreaks(String parent) {
    ListAdBreaksRequest request = ListAdBreaksRequest.newBuilder().setParent(parent).build();
    return listAdBreaks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `AdBreak` objects.
   *
   * <p>By default, when no `orderBy` query parameter is specified, ad breaks are ordered reverse
   * chronologically. However, ad breaks with a 'breakState' of 'SCHEDULED' or 'DECISIONED' are
   * prioritized and appear first.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   ListAdBreaksRequest request =
   *       ListAdBreaksRequest.newBuilder()
   *           .setParent(LiveStreamEventName.of("[NETWORK_CODE]", "[LIVE_STREAM_EVENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (AdBreak element : adBreakServiceClient.listAdBreaks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAdBreaksPagedResponse listAdBreaks(ListAdBreaksRequest request) {
    return listAdBreaksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `AdBreak` objects.
   *
   * <p>By default, when no `orderBy` query parameter is specified, ad breaks are ordered reverse
   * chronologically. However, ad breaks with a 'breakState' of 'SCHEDULED' or 'DECISIONED' are
   * prioritized and appear first.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   ListAdBreaksRequest request =
   *       ListAdBreaksRequest.newBuilder()
   *           .setParent(LiveStreamEventName.of("[NETWORK_CODE]", "[LIVE_STREAM_EVENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<AdBreak> future =
   *       adBreakServiceClient.listAdBreaksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AdBreak element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAdBreaksRequest, ListAdBreaksPagedResponse>
      listAdBreaksPagedCallable() {
    return stub.listAdBreaksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `AdBreak` objects.
   *
   * <p>By default, when no `orderBy` query parameter is specified, ad breaks are ordered reverse
   * chronologically. However, ad breaks with a 'breakState' of 'SCHEDULED' or 'DECISIONED' are
   * prioritized and appear first.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   ListAdBreaksRequest request =
   *       ListAdBreaksRequest.newBuilder()
   *           .setParent(LiveStreamEventName.of("[NETWORK_CODE]", "[LIVE_STREAM_EVENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListAdBreaksResponse response = adBreakServiceClient.listAdBreaksCallable().call(request);
   *     for (AdBreak element : response.getAdBreaksList()) {
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
  public final UnaryCallable<ListAdBreaksRequest, ListAdBreaksResponse> listAdBreaksCallable() {
    return stub.listAdBreaksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create an `AdBreak` object.
   *
   * <p>Informs DAI of an upcoming ad break for a live stream event, with an optional expected start
   * time. DAI will begin decisioning ads for the break shortly before the expected start time, if
   * provided. Each live stream event can only have one incomplete ad break at any given time. The
   * next ad break can be scheduled after the previous ad break has started serving, indicated by
   * its state being [`COMPLETE`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.COMPLETE],
   * or it has been deleted.
   *
   * <p>This method cannot be used if the `LiveStreamEvent` has [prefetching ad breaks
   * enabled](https://developers.google.com/ad-manager/api/reference/latest/LiveStreamEventService.LiveStreamEvent#prefetchenabled)
   * or the event is not active. If a `LiveStreamEvent` is deactivated after creating an ad break
   * and before the ad break is complete, the ad break is discarded.
   *
   * <p>An ad break's state is complete when the following occurs: - Full service DAI: after a
   * matching ad break shows in the `LiveStreamEvent` manifest only when the ad break has started
   * decisioning. - Pod Serving: after the ad break is requested using the ad break ID or break
   * sequence.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   LiveStreamEventName parent = LiveStreamEventName.of("[NETWORK_CODE]", "[LIVE_STREAM_EVENT]");
   *   AdBreak adBreak = AdBreak.newBuilder().build();
   *   AdBreak response = adBreakServiceClient.createAdBreak(parent, adBreak);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `AdBreak` will be created identified by
   *     an asset key or custom asset key.
   *     <p>Formats: `networks/{network_code}/liveStreamEventsByAssetKey/{asset_key}`
   *     `networks/{network_code}/liveStreamEventsByCustomAssetKey/{custom_asset_key}`
   * @param adBreak Required. The `AdBreak` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdBreak createAdBreak(LiveStreamEventName parent, AdBreak adBreak) {
    CreateAdBreakRequest request =
        CreateAdBreakRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAdBreak(adBreak)
            .build();
    return createAdBreak(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create an `AdBreak` object.
   *
   * <p>Informs DAI of an upcoming ad break for a live stream event, with an optional expected start
   * time. DAI will begin decisioning ads for the break shortly before the expected start time, if
   * provided. Each live stream event can only have one incomplete ad break at any given time. The
   * next ad break can be scheduled after the previous ad break has started serving, indicated by
   * its state being [`COMPLETE`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.COMPLETE],
   * or it has been deleted.
   *
   * <p>This method cannot be used if the `LiveStreamEvent` has [prefetching ad breaks
   * enabled](https://developers.google.com/ad-manager/api/reference/latest/LiveStreamEventService.LiveStreamEvent#prefetchenabled)
   * or the event is not active. If a `LiveStreamEvent` is deactivated after creating an ad break
   * and before the ad break is complete, the ad break is discarded.
   *
   * <p>An ad break's state is complete when the following occurs: - Full service DAI: after a
   * matching ad break shows in the `LiveStreamEvent` manifest only when the ad break has started
   * decisioning. - Pod Serving: after the ad break is requested using the ad break ID or break
   * sequence.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   String parent = LiveStreamEventName.of("[NETWORK_CODE]", "[LIVE_STREAM_EVENT]").toString();
   *   AdBreak adBreak = AdBreak.newBuilder().build();
   *   AdBreak response = adBreakServiceClient.createAdBreak(parent, adBreak);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `AdBreak` will be created identified by
   *     an asset key or custom asset key.
   *     <p>Formats: `networks/{network_code}/liveStreamEventsByAssetKey/{asset_key}`
   *     `networks/{network_code}/liveStreamEventsByCustomAssetKey/{custom_asset_key}`
   * @param adBreak Required. The `AdBreak` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdBreak createAdBreak(String parent, AdBreak adBreak) {
    CreateAdBreakRequest request =
        CreateAdBreakRequest.newBuilder().setParent(parent).setAdBreak(adBreak).build();
    return createAdBreak(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create an `AdBreak` object.
   *
   * <p>Informs DAI of an upcoming ad break for a live stream event, with an optional expected start
   * time. DAI will begin decisioning ads for the break shortly before the expected start time, if
   * provided. Each live stream event can only have one incomplete ad break at any given time. The
   * next ad break can be scheduled after the previous ad break has started serving, indicated by
   * its state being [`COMPLETE`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.COMPLETE],
   * or it has been deleted.
   *
   * <p>This method cannot be used if the `LiveStreamEvent` has [prefetching ad breaks
   * enabled](https://developers.google.com/ad-manager/api/reference/latest/LiveStreamEventService.LiveStreamEvent#prefetchenabled)
   * or the event is not active. If a `LiveStreamEvent` is deactivated after creating an ad break
   * and before the ad break is complete, the ad break is discarded.
   *
   * <p>An ad break's state is complete when the following occurs: - Full service DAI: after a
   * matching ad break shows in the `LiveStreamEvent` manifest only when the ad break has started
   * decisioning. - Pod Serving: after the ad break is requested using the ad break ID or break
   * sequence.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   CreateAdBreakRequest request =
   *       CreateAdBreakRequest.newBuilder()
   *           .setParent(LiveStreamEventName.of("[NETWORK_CODE]", "[LIVE_STREAM_EVENT]").toString())
   *           .setAdBreak(AdBreak.newBuilder().build())
   *           .build();
   *   AdBreak response = adBreakServiceClient.createAdBreak(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdBreak createAdBreak(CreateAdBreakRequest request) {
    return createAdBreakCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create an `AdBreak` object.
   *
   * <p>Informs DAI of an upcoming ad break for a live stream event, with an optional expected start
   * time. DAI will begin decisioning ads for the break shortly before the expected start time, if
   * provided. Each live stream event can only have one incomplete ad break at any given time. The
   * next ad break can be scheduled after the previous ad break has started serving, indicated by
   * its state being [`COMPLETE`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.COMPLETE],
   * or it has been deleted.
   *
   * <p>This method cannot be used if the `LiveStreamEvent` has [prefetching ad breaks
   * enabled](https://developers.google.com/ad-manager/api/reference/latest/LiveStreamEventService.LiveStreamEvent#prefetchenabled)
   * or the event is not active. If a `LiveStreamEvent` is deactivated after creating an ad break
   * and before the ad break is complete, the ad break is discarded.
   *
   * <p>An ad break's state is complete when the following occurs: - Full service DAI: after a
   * matching ad break shows in the `LiveStreamEvent` manifest only when the ad break has started
   * decisioning. - Pod Serving: after the ad break is requested using the ad break ID or break
   * sequence.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   CreateAdBreakRequest request =
   *       CreateAdBreakRequest.newBuilder()
   *           .setParent(LiveStreamEventName.of("[NETWORK_CODE]", "[LIVE_STREAM_EVENT]").toString())
   *           .setAdBreak(AdBreak.newBuilder().build())
   *           .build();
   *   ApiFuture<AdBreak> future = adBreakServiceClient.createAdBreakCallable().futureCall(request);
   *   // Do something.
   *   AdBreak response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAdBreakRequest, AdBreak> createAdBreakCallable() {
    return stub.createAdBreakCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update an `AdBreak` object.
   *
   * <p>Modify an ad break when its state is
   * [`SCHEDULED`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.SCHEDULED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   AdBreak adBreak = AdBreak.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AdBreak response = adBreakServiceClient.updateAdBreak(adBreak, updateMask);
   * }
   * }</pre>
   *
   * @param adBreak Required. The `AdBreak` to update.
   *     <p>The `AdBreak`'s `name` is used to identify the `AdBreak` to update.
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdBreak updateAdBreak(AdBreak adBreak, FieldMask updateMask) {
    UpdateAdBreakRequest request =
        UpdateAdBreakRequest.newBuilder().setAdBreak(adBreak).setUpdateMask(updateMask).build();
    return updateAdBreak(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update an `AdBreak` object.
   *
   * <p>Modify an ad break when its state is
   * [`SCHEDULED`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.SCHEDULED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   UpdateAdBreakRequest request =
   *       UpdateAdBreakRequest.newBuilder()
   *           .setAdBreak(AdBreak.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AdBreak response = adBreakServiceClient.updateAdBreak(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AdBreak updateAdBreak(UpdateAdBreakRequest request) {
    return updateAdBreakCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update an `AdBreak` object.
   *
   * <p>Modify an ad break when its state is
   * [`SCHEDULED`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.SCHEDULED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   UpdateAdBreakRequest request =
   *       UpdateAdBreakRequest.newBuilder()
   *           .setAdBreak(AdBreak.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AdBreak> future = adBreakServiceClient.updateAdBreakCallable().futureCall(request);
   *   // Do something.
   *   AdBreak response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAdBreakRequest, AdBreak> updateAdBreakCallable() {
    return stub.updateAdBreakCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to delete an `AdBreak` object.
   *
   * <p>Deletes and cancels an incomplete ad break, mitigating the need to wait for the current
   * break to serve before recreating an ad break. You can delete an ad break that has not started
   * serving or seen in manifests, indicated by its state being
   * [`SCHEDULED`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.SCHEDULED] or
   * [`DECISIONED`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.DECISIONED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   AdBreakName name = AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]");
   *   adBreakServiceClient.deleteAdBreak(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ad break to delete.
   *     <p>Format:
   *     `networks/{network_code}/liveStreamEventsByAssetKey/{asset_key}/adBreaks/{ad_break}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAdBreak(AdBreakName name) {
    DeleteAdBreakRequest request =
        DeleteAdBreakRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteAdBreak(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to delete an `AdBreak` object.
   *
   * <p>Deletes and cancels an incomplete ad break, mitigating the need to wait for the current
   * break to serve before recreating an ad break. You can delete an ad break that has not started
   * serving or seen in manifests, indicated by its state being
   * [`SCHEDULED`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.SCHEDULED] or
   * [`DECISIONED`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.DECISIONED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   String name = AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]").toString();
   *   adBreakServiceClient.deleteAdBreak(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ad break to delete.
   *     <p>Format:
   *     `networks/{network_code}/liveStreamEventsByAssetKey/{asset_key}/adBreaks/{ad_break}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAdBreak(String name) {
    DeleteAdBreakRequest request = DeleteAdBreakRequest.newBuilder().setName(name).build();
    deleteAdBreak(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to delete an `AdBreak` object.
   *
   * <p>Deletes and cancels an incomplete ad break, mitigating the need to wait for the current
   * break to serve before recreating an ad break. You can delete an ad break that has not started
   * serving or seen in manifests, indicated by its state being
   * [`SCHEDULED`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.SCHEDULED] or
   * [`DECISIONED`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.DECISIONED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   DeleteAdBreakRequest request =
   *       DeleteAdBreakRequest.newBuilder()
   *           .setName(AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]").toString())
   *           .build();
   *   adBreakServiceClient.deleteAdBreak(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAdBreak(DeleteAdBreakRequest request) {
    deleteAdBreakCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to delete an `AdBreak` object.
   *
   * <p>Deletes and cancels an incomplete ad break, mitigating the need to wait for the current
   * break to serve before recreating an ad break. You can delete an ad break that has not started
   * serving or seen in manifests, indicated by its state being
   * [`SCHEDULED`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.SCHEDULED] or
   * [`DECISIONED`][google.ads.admanager.v1.AdBreakStateEnum.AdBreakState.DECISIONED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
   *   DeleteAdBreakRequest request =
   *       DeleteAdBreakRequest.newBuilder()
   *           .setName(AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]").toString())
   *           .build();
   *   ApiFuture<Empty> future = adBreakServiceClient.deleteAdBreakCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAdBreakRequest, Empty> deleteAdBreakCallable() {
    return stub.deleteAdBreakCallable();
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

  public static class ListAdBreaksPagedResponse
      extends AbstractPagedListResponse<
          ListAdBreaksRequest,
          ListAdBreaksResponse,
          AdBreak,
          ListAdBreaksPage,
          ListAdBreaksFixedSizeCollection> {

    public static ApiFuture<ListAdBreaksPagedResponse> createAsync(
        PageContext<ListAdBreaksRequest, ListAdBreaksResponse, AdBreak> context,
        ApiFuture<ListAdBreaksResponse> futureResponse) {
      ApiFuture<ListAdBreaksPage> futurePage =
          ListAdBreaksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAdBreaksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAdBreaksPagedResponse(ListAdBreaksPage page) {
      super(page, ListAdBreaksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAdBreaksPage
      extends AbstractPage<ListAdBreaksRequest, ListAdBreaksResponse, AdBreak, ListAdBreaksPage> {

    private ListAdBreaksPage(
        PageContext<ListAdBreaksRequest, ListAdBreaksResponse, AdBreak> context,
        ListAdBreaksResponse response) {
      super(context, response);
    }

    private static ListAdBreaksPage createEmptyPage() {
      return new ListAdBreaksPage(null, null);
    }

    @Override
    protected ListAdBreaksPage createPage(
        PageContext<ListAdBreaksRequest, ListAdBreaksResponse, AdBreak> context,
        ListAdBreaksResponse response) {
      return new ListAdBreaksPage(context, response);
    }

    @Override
    public ApiFuture<ListAdBreaksPage> createPageAsync(
        PageContext<ListAdBreaksRequest, ListAdBreaksResponse, AdBreak> context,
        ApiFuture<ListAdBreaksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAdBreaksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAdBreaksRequest,
          ListAdBreaksResponse,
          AdBreak,
          ListAdBreaksPage,
          ListAdBreaksFixedSizeCollection> {

    private ListAdBreaksFixedSizeCollection(List<ListAdBreaksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAdBreaksFixedSizeCollection createEmptyCollection() {
      return new ListAdBreaksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAdBreaksFixedSizeCollection createCollection(
        List<ListAdBreaksPage> pages, int collectionSize) {
      return new ListAdBreaksFixedSizeCollection(pages, collectionSize);
    }
  }
}
