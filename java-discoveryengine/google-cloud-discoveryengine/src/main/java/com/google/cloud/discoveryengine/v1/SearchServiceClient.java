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

package com.google.cloud.discoveryengine.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.stub.SearchServiceStub;
import com.google.cloud.discoveryengine.v1.stub.SearchServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for search.
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
 * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
 *   SearchRequest request =
 *       SearchRequest.newBuilder()
 *           .setServingConfig(
 *               ServingConfigName.ofProjectLocationDataStoreServingConfigName(
 *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
 *                   .toString())
 *           .setBranch(
 *               BranchName.ofProjectLocationDataStoreBranchName(
 *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
 *                   .toString())
 *           .setQuery("query107944136")
 *           .setImageQuery(SearchRequest.ImageQuery.newBuilder().build())
 *           .setPageSize(883849137)
 *           .setPageToken("pageToken873572522")
 *           .setOffset(-1019779949)
 *           .setOneBoxPageSize(1988477988)
 *           .addAllDataStoreSpecs(new ArrayList<SearchRequest.DataStoreSpec>())
 *           .setFilter("filter-1274492040")
 *           .setCanonicalFilter("canonicalFilter-722283124")
 *           .setOrderBy("orderBy-1207110587")
 *           .setUserInfo(UserInfo.newBuilder().build())
 *           .setLanguageCode("languageCode-2092349083")
 *           .addAllFacetSpecs(new ArrayList<SearchRequest.FacetSpec>())
 *           .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
 *           .putAllParams(new HashMap<String, Value>())
 *           .setQueryExpansionSpec(SearchRequest.QueryExpansionSpec.newBuilder().build())
 *           .setSpellCorrectionSpec(SearchRequest.SpellCorrectionSpec.newBuilder().build())
 *           .setUserPseudoId("userPseudoId-1155274652")
 *           .setContentSearchSpec(SearchRequest.ContentSearchSpec.newBuilder().build())
 *           .setSafeSearch(true)
 *           .putAllUserLabels(new HashMap<String, String>())
 *           .setSearchAsYouTypeSpec(SearchRequest.SearchAsYouTypeSpec.newBuilder().build())
 *           .setSession(
 *               SessionName.ofProjectLocationDataStoreSessionName(
 *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
 *                   .toString())
 *           .setSessionSpec(SearchRequest.SessionSpec.newBuilder().build())
 *           .build();
 *   for (SearchResponse.SearchResult element : searchServiceClient.search(request).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SearchServiceClient object to clean up resources such
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
 *      <td><p> Search</td>
 *      <td><p> Performs a search.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> search(SearchRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchPagedCallable()
 *           <li><p> searchCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchLite</td>
 *      <td><p> Performs a search. Similar to the [SearchService.Search][google.cloud.discoveryengine.v1.SearchService.Search] method, but a lite version that allows API key for authentication, where OAuth and IAM checks are not required.
 * <p>  Only public website search is supported by this method. If data stores and engines not associated with public website search are specified, a `FAILED_PRECONDITION` error is returned.
 * <p>  This method can be used for easy onboarding without having to implement an authentication backend. However, it is strongly recommended to use [SearchService.Search][google.cloud.discoveryengine.v1.SearchService.Search] instead with required OAuth and IAM checks to provide better data security.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchLite(SearchRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchLitePagedCallable()
 *           <li><p> searchLiteCallable()
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
 * <p>This class can be customized by passing in a custom instance of SearchServiceSettings to
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
 * SearchServiceSettings searchServiceSettings =
 *     SearchServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SearchServiceClient searchServiceClient = SearchServiceClient.create(searchServiceSettings);
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
 * SearchServiceSettings searchServiceSettings =
 *     SearchServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SearchServiceClient searchServiceClient = SearchServiceClient.create(searchServiceSettings);
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
 * SearchServiceSettings searchServiceSettings =
 *     SearchServiceSettings.newHttpJsonBuilder().build();
 * SearchServiceClient searchServiceClient = SearchServiceClient.create(searchServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SearchServiceClient implements BackgroundResource {
  private final SearchServiceSettings settings;
  private final SearchServiceStub stub;

  /** Constructs an instance of SearchServiceClient with default settings. */
  public static final SearchServiceClient create() throws IOException {
    return create(SearchServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SearchServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SearchServiceClient create(SearchServiceSettings settings)
      throws IOException {
    return new SearchServiceClient(settings);
  }

  /**
   * Constructs an instance of SearchServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SearchServiceSettings).
   */
  public static final SearchServiceClient create(SearchServiceStub stub) {
    return new SearchServiceClient(stub);
  }

  /**
   * Constructs an instance of SearchServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SearchServiceClient(SearchServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SearchServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SearchServiceClient(SearchServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SearchServiceSettings getSettings() {
    return settings;
  }

  public SearchServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs a search.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
   *   SearchRequest request =
   *       SearchRequest.newBuilder()
   *           .setServingConfig(
   *               ServingConfigName.ofProjectLocationDataStoreServingConfigName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .setBranch(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setQuery("query107944136")
   *           .setImageQuery(SearchRequest.ImageQuery.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOffset(-1019779949)
   *           .setOneBoxPageSize(1988477988)
   *           .addAllDataStoreSpecs(new ArrayList<SearchRequest.DataStoreSpec>())
   *           .setFilter("filter-1274492040")
   *           .setCanonicalFilter("canonicalFilter-722283124")
   *           .setOrderBy("orderBy-1207110587")
   *           .setUserInfo(UserInfo.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .addAllFacetSpecs(new ArrayList<SearchRequest.FacetSpec>())
   *           .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
   *           .putAllParams(new HashMap<String, Value>())
   *           .setQueryExpansionSpec(SearchRequest.QueryExpansionSpec.newBuilder().build())
   *           .setSpellCorrectionSpec(SearchRequest.SpellCorrectionSpec.newBuilder().build())
   *           .setUserPseudoId("userPseudoId-1155274652")
   *           .setContentSearchSpec(SearchRequest.ContentSearchSpec.newBuilder().build())
   *           .setSafeSearch(true)
   *           .putAllUserLabels(new HashMap<String, String>())
   *           .setSearchAsYouTypeSpec(SearchRequest.SearchAsYouTypeSpec.newBuilder().build())
   *           .setSession(
   *               SessionName.ofProjectLocationDataStoreSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *                   .toString())
   *           .setSessionSpec(SearchRequest.SessionSpec.newBuilder().build())
   *           .build();
   *   for (SearchResponse.SearchResult element : searchServiceClient.search(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchPagedResponse search(SearchRequest request) {
    return searchPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs a search.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
   *   SearchRequest request =
   *       SearchRequest.newBuilder()
   *           .setServingConfig(
   *               ServingConfigName.ofProjectLocationDataStoreServingConfigName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .setBranch(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setQuery("query107944136")
   *           .setImageQuery(SearchRequest.ImageQuery.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOffset(-1019779949)
   *           .setOneBoxPageSize(1988477988)
   *           .addAllDataStoreSpecs(new ArrayList<SearchRequest.DataStoreSpec>())
   *           .setFilter("filter-1274492040")
   *           .setCanonicalFilter("canonicalFilter-722283124")
   *           .setOrderBy("orderBy-1207110587")
   *           .setUserInfo(UserInfo.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .addAllFacetSpecs(new ArrayList<SearchRequest.FacetSpec>())
   *           .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
   *           .putAllParams(new HashMap<String, Value>())
   *           .setQueryExpansionSpec(SearchRequest.QueryExpansionSpec.newBuilder().build())
   *           .setSpellCorrectionSpec(SearchRequest.SpellCorrectionSpec.newBuilder().build())
   *           .setUserPseudoId("userPseudoId-1155274652")
   *           .setContentSearchSpec(SearchRequest.ContentSearchSpec.newBuilder().build())
   *           .setSafeSearch(true)
   *           .putAllUserLabels(new HashMap<String, String>())
   *           .setSearchAsYouTypeSpec(SearchRequest.SearchAsYouTypeSpec.newBuilder().build())
   *           .setSession(
   *               SessionName.ofProjectLocationDataStoreSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *                   .toString())
   *           .setSessionSpec(SearchRequest.SessionSpec.newBuilder().build())
   *           .build();
   *   ApiFuture<SearchResponse.SearchResult> future =
   *       searchServiceClient.searchPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SearchResponse.SearchResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchRequest, SearchPagedResponse> searchPagedCallable() {
    return stub.searchPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs a search.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
   *   SearchRequest request =
   *       SearchRequest.newBuilder()
   *           .setServingConfig(
   *               ServingConfigName.ofProjectLocationDataStoreServingConfigName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .setBranch(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setQuery("query107944136")
   *           .setImageQuery(SearchRequest.ImageQuery.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOffset(-1019779949)
   *           .setOneBoxPageSize(1988477988)
   *           .addAllDataStoreSpecs(new ArrayList<SearchRequest.DataStoreSpec>())
   *           .setFilter("filter-1274492040")
   *           .setCanonicalFilter("canonicalFilter-722283124")
   *           .setOrderBy("orderBy-1207110587")
   *           .setUserInfo(UserInfo.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .addAllFacetSpecs(new ArrayList<SearchRequest.FacetSpec>())
   *           .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
   *           .putAllParams(new HashMap<String, Value>())
   *           .setQueryExpansionSpec(SearchRequest.QueryExpansionSpec.newBuilder().build())
   *           .setSpellCorrectionSpec(SearchRequest.SpellCorrectionSpec.newBuilder().build())
   *           .setUserPseudoId("userPseudoId-1155274652")
   *           .setContentSearchSpec(SearchRequest.ContentSearchSpec.newBuilder().build())
   *           .setSafeSearch(true)
   *           .putAllUserLabels(new HashMap<String, String>())
   *           .setSearchAsYouTypeSpec(SearchRequest.SearchAsYouTypeSpec.newBuilder().build())
   *           .setSession(
   *               SessionName.ofProjectLocationDataStoreSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *                   .toString())
   *           .setSessionSpec(SearchRequest.SessionSpec.newBuilder().build())
   *           .build();
   *   while (true) {
   *     SearchResponse response = searchServiceClient.searchCallable().call(request);
   *     for (SearchResponse.SearchResult element : response.getResultsList()) {
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
  public final UnaryCallable<SearchRequest, SearchResponse> searchCallable() {
    return stub.searchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs a search. Similar to the
   * [SearchService.Search][google.cloud.discoveryengine.v1.SearchService.Search] method, but a lite
   * version that allows API key for authentication, where OAuth and IAM checks are not required.
   *
   * <p>Only public website search is supported by this method. If data stores and engines not
   * associated with public website search are specified, a `FAILED_PRECONDITION` error is returned.
   *
   * <p>This method can be used for easy onboarding without having to implement an authentication
   * backend. However, it is strongly recommended to use
   * [SearchService.Search][google.cloud.discoveryengine.v1.SearchService.Search] instead with
   * required OAuth and IAM checks to provide better data security.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
   *   SearchRequest request =
   *       SearchRequest.newBuilder()
   *           .setServingConfig(
   *               ServingConfigName.ofProjectLocationDataStoreServingConfigName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .setBranch(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setQuery("query107944136")
   *           .setImageQuery(SearchRequest.ImageQuery.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOffset(-1019779949)
   *           .setOneBoxPageSize(1988477988)
   *           .addAllDataStoreSpecs(new ArrayList<SearchRequest.DataStoreSpec>())
   *           .setFilter("filter-1274492040")
   *           .setCanonicalFilter("canonicalFilter-722283124")
   *           .setOrderBy("orderBy-1207110587")
   *           .setUserInfo(UserInfo.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .addAllFacetSpecs(new ArrayList<SearchRequest.FacetSpec>())
   *           .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
   *           .putAllParams(new HashMap<String, Value>())
   *           .setQueryExpansionSpec(SearchRequest.QueryExpansionSpec.newBuilder().build())
   *           .setSpellCorrectionSpec(SearchRequest.SpellCorrectionSpec.newBuilder().build())
   *           .setUserPseudoId("userPseudoId-1155274652")
   *           .setContentSearchSpec(SearchRequest.ContentSearchSpec.newBuilder().build())
   *           .setSafeSearch(true)
   *           .putAllUserLabels(new HashMap<String, String>())
   *           .setSearchAsYouTypeSpec(SearchRequest.SearchAsYouTypeSpec.newBuilder().build())
   *           .setSession(
   *               SessionName.ofProjectLocationDataStoreSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *                   .toString())
   *           .setSessionSpec(SearchRequest.SessionSpec.newBuilder().build())
   *           .build();
   *   for (SearchResponse.SearchResult element :
   *       searchServiceClient.searchLite(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchLitePagedResponse searchLite(SearchRequest request) {
    return searchLitePagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs a search. Similar to the
   * [SearchService.Search][google.cloud.discoveryengine.v1.SearchService.Search] method, but a lite
   * version that allows API key for authentication, where OAuth and IAM checks are not required.
   *
   * <p>Only public website search is supported by this method. If data stores and engines not
   * associated with public website search are specified, a `FAILED_PRECONDITION` error is returned.
   *
   * <p>This method can be used for easy onboarding without having to implement an authentication
   * backend. However, it is strongly recommended to use
   * [SearchService.Search][google.cloud.discoveryengine.v1.SearchService.Search] instead with
   * required OAuth and IAM checks to provide better data security.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
   *   SearchRequest request =
   *       SearchRequest.newBuilder()
   *           .setServingConfig(
   *               ServingConfigName.ofProjectLocationDataStoreServingConfigName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .setBranch(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setQuery("query107944136")
   *           .setImageQuery(SearchRequest.ImageQuery.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOffset(-1019779949)
   *           .setOneBoxPageSize(1988477988)
   *           .addAllDataStoreSpecs(new ArrayList<SearchRequest.DataStoreSpec>())
   *           .setFilter("filter-1274492040")
   *           .setCanonicalFilter("canonicalFilter-722283124")
   *           .setOrderBy("orderBy-1207110587")
   *           .setUserInfo(UserInfo.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .addAllFacetSpecs(new ArrayList<SearchRequest.FacetSpec>())
   *           .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
   *           .putAllParams(new HashMap<String, Value>())
   *           .setQueryExpansionSpec(SearchRequest.QueryExpansionSpec.newBuilder().build())
   *           .setSpellCorrectionSpec(SearchRequest.SpellCorrectionSpec.newBuilder().build())
   *           .setUserPseudoId("userPseudoId-1155274652")
   *           .setContentSearchSpec(SearchRequest.ContentSearchSpec.newBuilder().build())
   *           .setSafeSearch(true)
   *           .putAllUserLabels(new HashMap<String, String>())
   *           .setSearchAsYouTypeSpec(SearchRequest.SearchAsYouTypeSpec.newBuilder().build())
   *           .setSession(
   *               SessionName.ofProjectLocationDataStoreSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *                   .toString())
   *           .setSessionSpec(SearchRequest.SessionSpec.newBuilder().build())
   *           .build();
   *   ApiFuture<SearchResponse.SearchResult> future =
   *       searchServiceClient.searchLitePagedCallable().futureCall(request);
   *   // Do something.
   *   for (SearchResponse.SearchResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchRequest, SearchLitePagedResponse> searchLitePagedCallable() {
    return stub.searchLitePagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs a search. Similar to the
   * [SearchService.Search][google.cloud.discoveryengine.v1.SearchService.Search] method, but a lite
   * version that allows API key for authentication, where OAuth and IAM checks are not required.
   *
   * <p>Only public website search is supported by this method. If data stores and engines not
   * associated with public website search are specified, a `FAILED_PRECONDITION` error is returned.
   *
   * <p>This method can be used for easy onboarding without having to implement an authentication
   * backend. However, it is strongly recommended to use
   * [SearchService.Search][google.cloud.discoveryengine.v1.SearchService.Search] instead with
   * required OAuth and IAM checks to provide better data security.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchServiceClient searchServiceClient = SearchServiceClient.create()) {
   *   SearchRequest request =
   *       SearchRequest.newBuilder()
   *           .setServingConfig(
   *               ServingConfigName.ofProjectLocationDataStoreServingConfigName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
   *                   .toString())
   *           .setBranch(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setQuery("query107944136")
   *           .setImageQuery(SearchRequest.ImageQuery.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOffset(-1019779949)
   *           .setOneBoxPageSize(1988477988)
   *           .addAllDataStoreSpecs(new ArrayList<SearchRequest.DataStoreSpec>())
   *           .setFilter("filter-1274492040")
   *           .setCanonicalFilter("canonicalFilter-722283124")
   *           .setOrderBy("orderBy-1207110587")
   *           .setUserInfo(UserInfo.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .addAllFacetSpecs(new ArrayList<SearchRequest.FacetSpec>())
   *           .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
   *           .putAllParams(new HashMap<String, Value>())
   *           .setQueryExpansionSpec(SearchRequest.QueryExpansionSpec.newBuilder().build())
   *           .setSpellCorrectionSpec(SearchRequest.SpellCorrectionSpec.newBuilder().build())
   *           .setUserPseudoId("userPseudoId-1155274652")
   *           .setContentSearchSpec(SearchRequest.ContentSearchSpec.newBuilder().build())
   *           .setSafeSearch(true)
   *           .putAllUserLabels(new HashMap<String, String>())
   *           .setSearchAsYouTypeSpec(SearchRequest.SearchAsYouTypeSpec.newBuilder().build())
   *           .setSession(
   *               SessionName.ofProjectLocationDataStoreSessionName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
   *                   .toString())
   *           .setSessionSpec(SearchRequest.SessionSpec.newBuilder().build())
   *           .build();
   *   while (true) {
   *     SearchResponse response = searchServiceClient.searchLiteCallable().call(request);
   *     for (SearchResponse.SearchResult element : response.getResultsList()) {
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
  public final UnaryCallable<SearchRequest, SearchResponse> searchLiteCallable() {
    return stub.searchLiteCallable();
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

  public static class SearchPagedResponse
      extends AbstractPagedListResponse<
          SearchRequest,
          SearchResponse,
          SearchResponse.SearchResult,
          SearchPage,
          SearchFixedSizeCollection> {

    public static ApiFuture<SearchPagedResponse> createAsync(
        PageContext<SearchRequest, SearchResponse, SearchResponse.SearchResult> context,
        ApiFuture<SearchResponse> futureResponse) {
      ApiFuture<SearchPage> futurePage =
          SearchPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new SearchPagedResponse(input), MoreExecutors.directExecutor());
    }

    private SearchPagedResponse(SearchPage page) {
      super(page, SearchFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchPage
      extends AbstractPage<SearchRequest, SearchResponse, SearchResponse.SearchResult, SearchPage> {

    private SearchPage(
        PageContext<SearchRequest, SearchResponse, SearchResponse.SearchResult> context,
        SearchResponse response) {
      super(context, response);
    }

    private static SearchPage createEmptyPage() {
      return new SearchPage(null, null);
    }

    @Override
    protected SearchPage createPage(
        PageContext<SearchRequest, SearchResponse, SearchResponse.SearchResult> context,
        SearchResponse response) {
      return new SearchPage(context, response);
    }

    @Override
    public ApiFuture<SearchPage> createPageAsync(
        PageContext<SearchRequest, SearchResponse, SearchResponse.SearchResult> context,
        ApiFuture<SearchResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchRequest,
          SearchResponse,
          SearchResponse.SearchResult,
          SearchPage,
          SearchFixedSizeCollection> {

    private SearchFixedSizeCollection(List<SearchPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchFixedSizeCollection createEmptyCollection() {
      return new SearchFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchFixedSizeCollection createCollection(
        List<SearchPage> pages, int collectionSize) {
      return new SearchFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchLitePagedResponse
      extends AbstractPagedListResponse<
          SearchRequest,
          SearchResponse,
          SearchResponse.SearchResult,
          SearchLitePage,
          SearchLiteFixedSizeCollection> {

    public static ApiFuture<SearchLitePagedResponse> createAsync(
        PageContext<SearchRequest, SearchResponse, SearchResponse.SearchResult> context,
        ApiFuture<SearchResponse> futureResponse) {
      ApiFuture<SearchLitePage> futurePage =
          SearchLitePage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new SearchLitePagedResponse(input), MoreExecutors.directExecutor());
    }

    private SearchLitePagedResponse(SearchLitePage page) {
      super(page, SearchLiteFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchLitePage
      extends AbstractPage<
          SearchRequest, SearchResponse, SearchResponse.SearchResult, SearchLitePage> {

    private SearchLitePage(
        PageContext<SearchRequest, SearchResponse, SearchResponse.SearchResult> context,
        SearchResponse response) {
      super(context, response);
    }

    private static SearchLitePage createEmptyPage() {
      return new SearchLitePage(null, null);
    }

    @Override
    protected SearchLitePage createPage(
        PageContext<SearchRequest, SearchResponse, SearchResponse.SearchResult> context,
        SearchResponse response) {
      return new SearchLitePage(context, response);
    }

    @Override
    public ApiFuture<SearchLitePage> createPageAsync(
        PageContext<SearchRequest, SearchResponse, SearchResponse.SearchResult> context,
        ApiFuture<SearchResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchLiteFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchRequest,
          SearchResponse,
          SearchResponse.SearchResult,
          SearchLitePage,
          SearchLiteFixedSizeCollection> {

    private SearchLiteFixedSizeCollection(List<SearchLitePage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchLiteFixedSizeCollection createEmptyCollection() {
      return new SearchLiteFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchLiteFixedSizeCollection createCollection(
        List<SearchLitePage> pages, int collectionSize) {
      return new SearchLiteFixedSizeCollection(pages, collectionSize);
    }
  }
}
