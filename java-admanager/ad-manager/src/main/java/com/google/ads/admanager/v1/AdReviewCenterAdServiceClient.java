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

import com.google.ads.admanager.v1.stub.AdReviewCenterAdServiceStub;
import com.google.ads.admanager.v1.stub.AdReviewCenterAdServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling AdReviewCenterAd objects.
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
 * try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
 *     AdReviewCenterAdServiceClient.create()) {
 *   WebPropertyName parent = WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]");
 *   for (AdReviewCenterAd element :
 *       adReviewCenterAdServiceClient.searchAdReviewCenterAds(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AdReviewCenterAdServiceClient object to clean up
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
 *      <td><p> SearchAdReviewCenterAds</td>
 *      <td><p> API to search for AdReviewCenterAds.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchAdReviewCenterAds(SearchAdReviewCenterAdsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchAdReviewCenterAds(WebPropertyName parent)
 *           <li><p> searchAdReviewCenterAds(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchAdReviewCenterAdsPagedCallable()
 *           <li><p> searchAdReviewCenterAdsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchAllowAdReviewCenterAds</td>
 *      <td><p> API to batch allow AdReviewCenterAds. This method supports partial success. Some operations may succeed while others fail. Callers should check the failedRequests field in the response to determine which operations failed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchAllowAdReviewCenterAdsAsync(BatchAllowAdReviewCenterAdsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> batchAllowAdReviewCenterAdsAsync(WebPropertyName parent)
 *           <li><p> batchAllowAdReviewCenterAdsAsync(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchAllowAdReviewCenterAdsOperationCallable()
 *           <li><p> batchAllowAdReviewCenterAdsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchBlockAdReviewCenterAds</td>
 *      <td><p> API to batch block AdReviewCenterAds. This method supports partial success. Some operations may succeed while others fail. Callers should check the failedRequests field in the response to determine which operations failed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchBlockAdReviewCenterAdsAsync(BatchBlockAdReviewCenterAdsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> batchBlockAdReviewCenterAdsAsync(WebPropertyName parent)
 *           <li><p> batchBlockAdReviewCenterAdsAsync(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchBlockAdReviewCenterAdsOperationCallable()
 *           <li><p> batchBlockAdReviewCenterAdsCallable()
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
 * AdReviewCenterAdServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AdReviewCenterAdServiceSettings adReviewCenterAdServiceSettings =
 *     AdReviewCenterAdServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
 *     AdReviewCenterAdServiceClient.create(adReviewCenterAdServiceSettings);
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
 * AdReviewCenterAdServiceSettings adReviewCenterAdServiceSettings =
 *     AdReviewCenterAdServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
 *     AdReviewCenterAdServiceClient.create(adReviewCenterAdServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AdReviewCenterAdServiceClient implements BackgroundResource {
  private final AdReviewCenterAdServiceSettings settings;
  private final AdReviewCenterAdServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;

  /** Constructs an instance of AdReviewCenterAdServiceClient with default settings. */
  public static final AdReviewCenterAdServiceClient create() throws IOException {
    return create(AdReviewCenterAdServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AdReviewCenterAdServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AdReviewCenterAdServiceClient create(AdReviewCenterAdServiceSettings settings)
      throws IOException {
    return new AdReviewCenterAdServiceClient(settings);
  }

  /**
   * Constructs an instance of AdReviewCenterAdServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(AdReviewCenterAdServiceSettings).
   */
  public static final AdReviewCenterAdServiceClient create(AdReviewCenterAdServiceStub stub) {
    return new AdReviewCenterAdServiceClient(stub);
  }

  /**
   * Constructs an instance of AdReviewCenterAdServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AdReviewCenterAdServiceClient(AdReviewCenterAdServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((AdReviewCenterAdServiceStubSettings) settings.getStubSettings()).createStub();
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected AdReviewCenterAdServiceClient(AdReviewCenterAdServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final AdReviewCenterAdServiceSettings getSettings() {
    return settings;
  }

  public AdReviewCenterAdServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to search for AdReviewCenterAds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
   *     AdReviewCenterAdServiceClient.create()) {
   *   WebPropertyName parent = WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]");
   *   for (AdReviewCenterAd element :
   *       adReviewCenterAdServiceClient.searchAdReviewCenterAds(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdReviewCenterAds. Format:
   *     networks/{network_code}/webProperties/{web_property_code}
   *     <p>Since a network can only have a single web property of each
   *     `ExchangeSyndicationProduct`, you can use the `ExchangeSyndicationProduct` as an alias for
   *     the web property code:
   *     <p>`networks/{network_code}/webProperties/display`
   *     <p>`networks/{network_code}/webProperties/videoAndAudio`
   *     <p>`networks/{network_code}/webProperties/mobileApp`
   *     <p>`networks/{network_code}/webProperties/games`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAdReviewCenterAdsPagedResponse searchAdReviewCenterAds(
      WebPropertyName parent) {
    SearchAdReviewCenterAdsRequest request =
        SearchAdReviewCenterAdsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return searchAdReviewCenterAds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to search for AdReviewCenterAds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
   *     AdReviewCenterAdServiceClient.create()) {
   *   String parent = WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]").toString();
   *   for (AdReviewCenterAd element :
   *       adReviewCenterAdServiceClient.searchAdReviewCenterAds(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdReviewCenterAds. Format:
   *     networks/{network_code}/webProperties/{web_property_code}
   *     <p>Since a network can only have a single web property of each
   *     `ExchangeSyndicationProduct`, you can use the `ExchangeSyndicationProduct` as an alias for
   *     the web property code:
   *     <p>`networks/{network_code}/webProperties/display`
   *     <p>`networks/{network_code}/webProperties/videoAndAudio`
   *     <p>`networks/{network_code}/webProperties/mobileApp`
   *     <p>`networks/{network_code}/webProperties/games`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAdReviewCenterAdsPagedResponse searchAdReviewCenterAds(String parent) {
    SearchAdReviewCenterAdsRequest request =
        SearchAdReviewCenterAdsRequest.newBuilder().setParent(parent).build();
    return searchAdReviewCenterAds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to search for AdReviewCenterAds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
   *     AdReviewCenterAdServiceClient.create()) {
   *   SearchAdReviewCenterAdsRequest request =
   *       SearchAdReviewCenterAdsRequest.newBuilder()
   *           .setParent(WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .addAllAdReviewCenterAdId(new ArrayList<String>())
   *           .setDateTimeRange(Interval.newBuilder().build())
   *           .addAllSearchText(new ArrayList<String>())
   *           .addAllBuyerAccountId(new ArrayList<Long>())
   *           .build();
   *   for (AdReviewCenterAd element :
   *       adReviewCenterAdServiceClient.searchAdReviewCenterAds(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAdReviewCenterAdsPagedResponse searchAdReviewCenterAds(
      SearchAdReviewCenterAdsRequest request) {
    return searchAdReviewCenterAdsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to search for AdReviewCenterAds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
   *     AdReviewCenterAdServiceClient.create()) {
   *   SearchAdReviewCenterAdsRequest request =
   *       SearchAdReviewCenterAdsRequest.newBuilder()
   *           .setParent(WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .addAllAdReviewCenterAdId(new ArrayList<String>())
   *           .setDateTimeRange(Interval.newBuilder().build())
   *           .addAllSearchText(new ArrayList<String>())
   *           .addAllBuyerAccountId(new ArrayList<Long>())
   *           .build();
   *   ApiFuture<AdReviewCenterAd> future =
   *       adReviewCenterAdServiceClient.searchAdReviewCenterAdsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AdReviewCenterAd element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsPagedResponse>
      searchAdReviewCenterAdsPagedCallable() {
    return stub.searchAdReviewCenterAdsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to search for AdReviewCenterAds.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
   *     AdReviewCenterAdServiceClient.create()) {
   *   SearchAdReviewCenterAdsRequest request =
   *       SearchAdReviewCenterAdsRequest.newBuilder()
   *           .setParent(WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .addAllAdReviewCenterAdId(new ArrayList<String>())
   *           .setDateTimeRange(Interval.newBuilder().build())
   *           .addAllSearchText(new ArrayList<String>())
   *           .addAllBuyerAccountId(new ArrayList<Long>())
   *           .build();
   *   while (true) {
   *     SearchAdReviewCenterAdsResponse response =
   *         adReviewCenterAdServiceClient.searchAdReviewCenterAdsCallable().call(request);
   *     for (AdReviewCenterAd element : response.getAdReviewCenterAdsList()) {
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
  public final UnaryCallable<SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsResponse>
      searchAdReviewCenterAdsCallable() {
    return stub.searchAdReviewCenterAdsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch allow AdReviewCenterAds. This method supports partial success. Some operations may
   * succeed while others fail. Callers should check the failedRequests field in the response to
   * determine which operations failed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
   *     AdReviewCenterAdServiceClient.create()) {
   *   WebPropertyName parent = WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]");
   *   BatchAllowAdReviewCenterAdsResponse response =
   *       adReviewCenterAdServiceClient.batchAllowAdReviewCenterAdsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdReviewCenterAds. Format:
   *     networks/{network_code}/webProperties/{web_property_code}
   *     <p>Since a network can only have a single web property of each
   *     `ExchangeSyndicationProduct`, you can use the `ExchangeSyndicationProduct` as an alias for
   *     the web property code:
   *     <p>`networks/{network_code}/webProperties/display`
   *     <p>`networks/{network_code}/webProperties/videoAndAudio`
   *     <p>`networks/{network_code}/webProperties/mobileApp`
   *     <p>`networks/{network_code}/webProperties/games`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          BatchAllowAdReviewCenterAdsResponse, BatchAdReviewCenterAdsOperationMetadata>
      batchAllowAdReviewCenterAdsAsync(WebPropertyName parent) {
    BatchAllowAdReviewCenterAdsRequest request =
        BatchAllowAdReviewCenterAdsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return batchAllowAdReviewCenterAdsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch allow AdReviewCenterAds. This method supports partial success. Some operations may
   * succeed while others fail. Callers should check the failedRequests field in the response to
   * determine which operations failed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
   *     AdReviewCenterAdServiceClient.create()) {
   *   String parent = WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]").toString();
   *   BatchAllowAdReviewCenterAdsResponse response =
   *       adReviewCenterAdServiceClient.batchAllowAdReviewCenterAdsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdReviewCenterAds. Format:
   *     networks/{network_code}/webProperties/{web_property_code}
   *     <p>Since a network can only have a single web property of each
   *     `ExchangeSyndicationProduct`, you can use the `ExchangeSyndicationProduct` as an alias for
   *     the web property code:
   *     <p>`networks/{network_code}/webProperties/display`
   *     <p>`networks/{network_code}/webProperties/videoAndAudio`
   *     <p>`networks/{network_code}/webProperties/mobileApp`
   *     <p>`networks/{network_code}/webProperties/games`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          BatchAllowAdReviewCenterAdsResponse, BatchAdReviewCenterAdsOperationMetadata>
      batchAllowAdReviewCenterAdsAsync(String parent) {
    BatchAllowAdReviewCenterAdsRequest request =
        BatchAllowAdReviewCenterAdsRequest.newBuilder().setParent(parent).build();
    return batchAllowAdReviewCenterAdsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch allow AdReviewCenterAds. This method supports partial success. Some operations may
   * succeed while others fail. Callers should check the failedRequests field in the response to
   * determine which operations failed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
   *     AdReviewCenterAdServiceClient.create()) {
   *   BatchAllowAdReviewCenterAdsRequest request =
   *       BatchAllowAdReviewCenterAdsRequest.newBuilder()
   *           .setParent(WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchAllowAdReviewCenterAdsResponse response =
   *       adReviewCenterAdServiceClient.batchAllowAdReviewCenterAdsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          BatchAllowAdReviewCenterAdsResponse, BatchAdReviewCenterAdsOperationMetadata>
      batchAllowAdReviewCenterAdsAsync(BatchAllowAdReviewCenterAdsRequest request) {
    return batchAllowAdReviewCenterAdsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch allow AdReviewCenterAds. This method supports partial success. Some operations may
   * succeed while others fail. Callers should check the failedRequests field in the response to
   * determine which operations failed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
   *     AdReviewCenterAdServiceClient.create()) {
   *   BatchAllowAdReviewCenterAdsRequest request =
   *       BatchAllowAdReviewCenterAdsRequest.newBuilder()
   *           .setParent(WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   OperationFuture<BatchAllowAdReviewCenterAdsResponse, BatchAdReviewCenterAdsOperationMetadata>
   *       future =
   *           adReviewCenterAdServiceClient
   *               .batchAllowAdReviewCenterAdsOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   BatchAllowAdReviewCenterAdsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchAllowAdReviewCenterAdsRequest,
          BatchAllowAdReviewCenterAdsResponse,
          BatchAdReviewCenterAdsOperationMetadata>
      batchAllowAdReviewCenterAdsOperationCallable() {
    return stub.batchAllowAdReviewCenterAdsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch allow AdReviewCenterAds. This method supports partial success. Some operations may
   * succeed while others fail. Callers should check the failedRequests field in the response to
   * determine which operations failed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
   *     AdReviewCenterAdServiceClient.create()) {
   *   BatchAllowAdReviewCenterAdsRequest request =
   *       BatchAllowAdReviewCenterAdsRequest.newBuilder()
   *           .setParent(WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       adReviewCenterAdServiceClient.batchAllowAdReviewCenterAdsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchAllowAdReviewCenterAdsRequest, Operation>
      batchAllowAdReviewCenterAdsCallable() {
    return stub.batchAllowAdReviewCenterAdsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch block AdReviewCenterAds. This method supports partial success. Some operations may
   * succeed while others fail. Callers should check the failedRequests field in the response to
   * determine which operations failed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
   *     AdReviewCenterAdServiceClient.create()) {
   *   WebPropertyName parent = WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]");
   *   BatchBlockAdReviewCenterAdsResponse response =
   *       adReviewCenterAdServiceClient.batchBlockAdReviewCenterAdsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdReviewCenterAds. Format:
   *     networks/{network_code}/webProperties/{web_property_code}
   *     <p>Since a network can only have a single web property of each
   *     `ExchangeSyndicationProduct`, you can use the `ExchangeSyndicationProduct` as an alias for
   *     the web property code:
   *     <p>`networks/{network_code}/webProperties/display`
   *     <p>`networks/{network_code}/webProperties/videoAndAudio`
   *     <p>`networks/{network_code}/webProperties/mobileApp`
   *     <p>`networks/{network_code}/webProperties/games`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          BatchBlockAdReviewCenterAdsResponse, BatchAdReviewCenterAdsOperationMetadata>
      batchBlockAdReviewCenterAdsAsync(WebPropertyName parent) {
    BatchBlockAdReviewCenterAdsRequest request =
        BatchBlockAdReviewCenterAdsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return batchBlockAdReviewCenterAdsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch block AdReviewCenterAds. This method supports partial success. Some operations may
   * succeed while others fail. Callers should check the failedRequests field in the response to
   * determine which operations failed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
   *     AdReviewCenterAdServiceClient.create()) {
   *   String parent = WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]").toString();
   *   BatchBlockAdReviewCenterAdsResponse response =
   *       adReviewCenterAdServiceClient.batchBlockAdReviewCenterAdsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of AdReviewCenterAds. Format:
   *     networks/{network_code}/webProperties/{web_property_code}
   *     <p>Since a network can only have a single web property of each
   *     `ExchangeSyndicationProduct`, you can use the `ExchangeSyndicationProduct` as an alias for
   *     the web property code:
   *     <p>`networks/{network_code}/webProperties/display`
   *     <p>`networks/{network_code}/webProperties/videoAndAudio`
   *     <p>`networks/{network_code}/webProperties/mobileApp`
   *     <p>`networks/{network_code}/webProperties/games`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          BatchBlockAdReviewCenterAdsResponse, BatchAdReviewCenterAdsOperationMetadata>
      batchBlockAdReviewCenterAdsAsync(String parent) {
    BatchBlockAdReviewCenterAdsRequest request =
        BatchBlockAdReviewCenterAdsRequest.newBuilder().setParent(parent).build();
    return batchBlockAdReviewCenterAdsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch block AdReviewCenterAds. This method supports partial success. Some operations may
   * succeed while others fail. Callers should check the failedRequests field in the response to
   * determine which operations failed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
   *     AdReviewCenterAdServiceClient.create()) {
   *   BatchBlockAdReviewCenterAdsRequest request =
   *       BatchBlockAdReviewCenterAdsRequest.newBuilder()
   *           .setParent(WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchBlockAdReviewCenterAdsResponse response =
   *       adReviewCenterAdServiceClient.batchBlockAdReviewCenterAdsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          BatchBlockAdReviewCenterAdsResponse, BatchAdReviewCenterAdsOperationMetadata>
      batchBlockAdReviewCenterAdsAsync(BatchBlockAdReviewCenterAdsRequest request) {
    return batchBlockAdReviewCenterAdsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch block AdReviewCenterAds. This method supports partial success. Some operations may
   * succeed while others fail. Callers should check the failedRequests field in the response to
   * determine which operations failed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
   *     AdReviewCenterAdServiceClient.create()) {
   *   BatchBlockAdReviewCenterAdsRequest request =
   *       BatchBlockAdReviewCenterAdsRequest.newBuilder()
   *           .setParent(WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   OperationFuture<BatchBlockAdReviewCenterAdsResponse, BatchAdReviewCenterAdsOperationMetadata>
   *       future =
   *           adReviewCenterAdServiceClient
   *               .batchBlockAdReviewCenterAdsOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   BatchBlockAdReviewCenterAdsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchBlockAdReviewCenterAdsRequest,
          BatchBlockAdReviewCenterAdsResponse,
          BatchAdReviewCenterAdsOperationMetadata>
      batchBlockAdReviewCenterAdsOperationCallable() {
    return stub.batchBlockAdReviewCenterAdsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to batch block AdReviewCenterAds. This method supports partial success. Some operations may
   * succeed while others fail. Callers should check the failedRequests field in the response to
   * determine which operations failed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
   *     AdReviewCenterAdServiceClient.create()) {
   *   BatchBlockAdReviewCenterAdsRequest request =
   *       BatchBlockAdReviewCenterAdsRequest.newBuilder()
   *           .setParent(WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       adReviewCenterAdServiceClient.batchBlockAdReviewCenterAdsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchBlockAdReviewCenterAdsRequest, Operation>
      batchBlockAdReviewCenterAdsCallable() {
    return stub.batchBlockAdReviewCenterAdsCallable();
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

  public static class SearchAdReviewCenterAdsPagedResponse
      extends AbstractPagedListResponse<
          SearchAdReviewCenterAdsRequest,
          SearchAdReviewCenterAdsResponse,
          AdReviewCenterAd,
          SearchAdReviewCenterAdsPage,
          SearchAdReviewCenterAdsFixedSizeCollection> {

    public static ApiFuture<SearchAdReviewCenterAdsPagedResponse> createAsync(
        PageContext<
                SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsResponse, AdReviewCenterAd>
            context,
        ApiFuture<SearchAdReviewCenterAdsResponse> futureResponse) {
      ApiFuture<SearchAdReviewCenterAdsPage> futurePage =
          SearchAdReviewCenterAdsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchAdReviewCenterAdsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchAdReviewCenterAdsPagedResponse(SearchAdReviewCenterAdsPage page) {
      super(page, SearchAdReviewCenterAdsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchAdReviewCenterAdsPage
      extends AbstractPage<
          SearchAdReviewCenterAdsRequest,
          SearchAdReviewCenterAdsResponse,
          AdReviewCenterAd,
          SearchAdReviewCenterAdsPage> {

    private SearchAdReviewCenterAdsPage(
        PageContext<
                SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsResponse, AdReviewCenterAd>
            context,
        SearchAdReviewCenterAdsResponse response) {
      super(context, response);
    }

    private static SearchAdReviewCenterAdsPage createEmptyPage() {
      return new SearchAdReviewCenterAdsPage(null, null);
    }

    @Override
    protected SearchAdReviewCenterAdsPage createPage(
        PageContext<
                SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsResponse, AdReviewCenterAd>
            context,
        SearchAdReviewCenterAdsResponse response) {
      return new SearchAdReviewCenterAdsPage(context, response);
    }

    @Override
    public ApiFuture<SearchAdReviewCenterAdsPage> createPageAsync(
        PageContext<
                SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsResponse, AdReviewCenterAd>
            context,
        ApiFuture<SearchAdReviewCenterAdsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchAdReviewCenterAdsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchAdReviewCenterAdsRequest,
          SearchAdReviewCenterAdsResponse,
          AdReviewCenterAd,
          SearchAdReviewCenterAdsPage,
          SearchAdReviewCenterAdsFixedSizeCollection> {

    private SearchAdReviewCenterAdsFixedSizeCollection(
        List<SearchAdReviewCenterAdsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchAdReviewCenterAdsFixedSizeCollection createEmptyCollection() {
      return new SearchAdReviewCenterAdsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchAdReviewCenterAdsFixedSizeCollection createCollection(
        List<SearchAdReviewCenterAdsPage> pages, int collectionSize) {
      return new SearchAdReviewCenterAdsFixedSizeCollection(pages, collectionSize);
    }
  }
}
