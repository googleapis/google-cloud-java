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

package com.google.cloud.discoveryengine.v1beta;

import static com.google.cloud.discoveryengine.v1beta.SearchServiceClient.SearchLitePagedResponse;
import static com.google.cloud.discoveryengine.v1beta.SearchServiceClient.SearchPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Value;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SearchServiceClientTest {
  private static MockLocations mockLocations;
  private static MockSearchService mockSearchService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private SearchServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSearchService = new MockSearchService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSearchService, mockLocations));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    SearchServiceSettings settings =
        SearchServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SearchServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void searchTest() throws Exception {
    SearchResponse.SearchResult responsesElement = SearchResponse.SearchResult.newBuilder().build();
    SearchResponse expectedResponse =
        SearchResponse.newBuilder()
            .setNextPageToken("")
            .addAllResults(Arrays.asList(responsesElement))
            .build();
    mockSearchService.addResponse(expectedResponse);

    SearchRequest request =
        SearchRequest.newBuilder()
            .setServingConfig(
                ServingConfigName.ofProjectLocationDataStoreServingConfigName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
                    .toString())
            .setBranch(
                BranchName.ofProjectLocationDataStoreBranchName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
                    .toString())
            .setQuery("query107944136")
            .setImageQuery(SearchRequest.ImageQuery.newBuilder().build())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setOffset(-1019779949)
            .setOneBoxPageSize(1988477988)
            .addAllDataStoreSpecs(new ArrayList<SearchRequest.DataStoreSpec>())
            .setFilter("filter-1274492040")
            .setCanonicalFilter("canonicalFilter-722283124")
            .setOrderBy("orderBy-1207110587")
            .setUserInfo(UserInfo.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setRegionCode("regionCode-1991004415")
            .addAllFacetSpecs(new ArrayList<SearchRequest.FacetSpec>())
            .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
            .putAllParams(new HashMap<String, Value>())
            .setQueryExpansionSpec(SearchRequest.QueryExpansionSpec.newBuilder().build())
            .setSpellCorrectionSpec(SearchRequest.SpellCorrectionSpec.newBuilder().build())
            .setUserPseudoId("userPseudoId-1155274652")
            .setContentSearchSpec(SearchRequest.ContentSearchSpec.newBuilder().build())
            .setEmbeddingSpec(SearchRequest.EmbeddingSpec.newBuilder().build())
            .setRankingExpression("rankingExpression2110320494")
            .setSafeSearch(true)
            .putAllUserLabels(new HashMap<String, String>())
            .setNaturalLanguageQueryUnderstandingSpec(
                SearchRequest.NaturalLanguageQueryUnderstandingSpec.newBuilder().build())
            .setSearchAsYouTypeSpec(SearchRequest.SearchAsYouTypeSpec.newBuilder().build())
            .setSession(
                SessionName.ofProjectLocationDataStoreSessionName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                    .toString())
            .setSessionSpec(SearchRequest.SessionSpec.newBuilder().build())
            .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
            .build();

    SearchPagedResponse pagedListResponse = client.search(request);

    List<SearchResponse.SearchResult> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSearchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchRequest actualRequest = ((SearchRequest) actualRequests.get(0));

    Assert.assertEquals(request.getServingConfig(), actualRequest.getServingConfig());
    Assert.assertEquals(request.getBranch(), actualRequest.getBranch());
    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertEquals(request.getImageQuery(), actualRequest.getImageQuery());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getOffset(), actualRequest.getOffset());
    Assert.assertEquals(request.getOneBoxPageSize(), actualRequest.getOneBoxPageSize());
    Assert.assertEquals(request.getDataStoreSpecsList(), actualRequest.getDataStoreSpecsList());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getCanonicalFilter(), actualRequest.getCanonicalFilter());
    Assert.assertEquals(request.getOrderBy(), actualRequest.getOrderBy());
    Assert.assertEquals(request.getUserInfo(), actualRequest.getUserInfo());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertEquals(request.getRegionCode(), actualRequest.getRegionCode());
    Assert.assertEquals(request.getFacetSpecsList(), actualRequest.getFacetSpecsList());
    Assert.assertEquals(request.getBoostSpec(), actualRequest.getBoostSpec());
    Assert.assertEquals(request.getParamsMap(), actualRequest.getParamsMap());
    Assert.assertEquals(request.getQueryExpansionSpec(), actualRequest.getQueryExpansionSpec());
    Assert.assertEquals(request.getSpellCorrectionSpec(), actualRequest.getSpellCorrectionSpec());
    Assert.assertEquals(request.getUserPseudoId(), actualRequest.getUserPseudoId());
    Assert.assertEquals(request.getContentSearchSpec(), actualRequest.getContentSearchSpec());
    Assert.assertEquals(request.getEmbeddingSpec(), actualRequest.getEmbeddingSpec());
    Assert.assertEquals(request.getRankingExpression(), actualRequest.getRankingExpression());
    Assert.assertEquals(
        request.getRankingExpressionBackend(), actualRequest.getRankingExpressionBackend());
    Assert.assertEquals(request.getSafeSearch(), actualRequest.getSafeSearch());
    Assert.assertEquals(request.getUserLabelsMap(), actualRequest.getUserLabelsMap());
    Assert.assertEquals(
        request.getNaturalLanguageQueryUnderstandingSpec(),
        actualRequest.getNaturalLanguageQueryUnderstandingSpec());
    Assert.assertEquals(request.getSearchAsYouTypeSpec(), actualRequest.getSearchAsYouTypeSpec());
    Assert.assertEquals(request.getSession(), actualRequest.getSession());
    Assert.assertEquals(request.getSessionSpec(), actualRequest.getSessionSpec());
    Assert.assertEquals(request.getRelevanceThreshold(), actualRequest.getRelevanceThreshold());
    Assert.assertEquals(request.getPersonalizationSpec(), actualRequest.getPersonalizationSpec());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSearchService.addException(exception);

    try {
      SearchRequest request =
          SearchRequest.newBuilder()
              .setServingConfig(
                  ServingConfigName.ofProjectLocationDataStoreServingConfigName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
                      .toString())
              .setBranch(
                  BranchName.ofProjectLocationDataStoreBranchName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
                      .toString())
              .setQuery("query107944136")
              .setImageQuery(SearchRequest.ImageQuery.newBuilder().build())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setOffset(-1019779949)
              .setOneBoxPageSize(1988477988)
              .addAllDataStoreSpecs(new ArrayList<SearchRequest.DataStoreSpec>())
              .setFilter("filter-1274492040")
              .setCanonicalFilter("canonicalFilter-722283124")
              .setOrderBy("orderBy-1207110587")
              .setUserInfo(UserInfo.newBuilder().build())
              .setLanguageCode("languageCode-2092349083")
              .setRegionCode("regionCode-1991004415")
              .addAllFacetSpecs(new ArrayList<SearchRequest.FacetSpec>())
              .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
              .putAllParams(new HashMap<String, Value>())
              .setQueryExpansionSpec(SearchRequest.QueryExpansionSpec.newBuilder().build())
              .setSpellCorrectionSpec(SearchRequest.SpellCorrectionSpec.newBuilder().build())
              .setUserPseudoId("userPseudoId-1155274652")
              .setContentSearchSpec(SearchRequest.ContentSearchSpec.newBuilder().build())
              .setEmbeddingSpec(SearchRequest.EmbeddingSpec.newBuilder().build())
              .setRankingExpression("rankingExpression2110320494")
              .setSafeSearch(true)
              .putAllUserLabels(new HashMap<String, String>())
              .setNaturalLanguageQueryUnderstandingSpec(
                  SearchRequest.NaturalLanguageQueryUnderstandingSpec.newBuilder().build())
              .setSearchAsYouTypeSpec(SearchRequest.SearchAsYouTypeSpec.newBuilder().build())
              .setSession(
                  SessionName.ofProjectLocationDataStoreSessionName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                      .toString())
              .setSessionSpec(SearchRequest.SessionSpec.newBuilder().build())
              .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
              .build();
      client.search(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchLiteTest() throws Exception {
    SearchResponse.SearchResult responsesElement = SearchResponse.SearchResult.newBuilder().build();
    SearchResponse expectedResponse =
        SearchResponse.newBuilder()
            .setNextPageToken("")
            .addAllResults(Arrays.asList(responsesElement))
            .build();
    mockSearchService.addResponse(expectedResponse);

    SearchRequest request =
        SearchRequest.newBuilder()
            .setServingConfig(
                ServingConfigName.ofProjectLocationDataStoreServingConfigName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
                    .toString())
            .setBranch(
                BranchName.ofProjectLocationDataStoreBranchName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
                    .toString())
            .setQuery("query107944136")
            .setImageQuery(SearchRequest.ImageQuery.newBuilder().build())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setOffset(-1019779949)
            .setOneBoxPageSize(1988477988)
            .addAllDataStoreSpecs(new ArrayList<SearchRequest.DataStoreSpec>())
            .setFilter("filter-1274492040")
            .setCanonicalFilter("canonicalFilter-722283124")
            .setOrderBy("orderBy-1207110587")
            .setUserInfo(UserInfo.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setRegionCode("regionCode-1991004415")
            .addAllFacetSpecs(new ArrayList<SearchRequest.FacetSpec>())
            .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
            .putAllParams(new HashMap<String, Value>())
            .setQueryExpansionSpec(SearchRequest.QueryExpansionSpec.newBuilder().build())
            .setSpellCorrectionSpec(SearchRequest.SpellCorrectionSpec.newBuilder().build())
            .setUserPseudoId("userPseudoId-1155274652")
            .setContentSearchSpec(SearchRequest.ContentSearchSpec.newBuilder().build())
            .setEmbeddingSpec(SearchRequest.EmbeddingSpec.newBuilder().build())
            .setRankingExpression("rankingExpression2110320494")
            .setSafeSearch(true)
            .putAllUserLabels(new HashMap<String, String>())
            .setNaturalLanguageQueryUnderstandingSpec(
                SearchRequest.NaturalLanguageQueryUnderstandingSpec.newBuilder().build())
            .setSearchAsYouTypeSpec(SearchRequest.SearchAsYouTypeSpec.newBuilder().build())
            .setSession(
                SessionName.ofProjectLocationDataStoreSessionName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                    .toString())
            .setSessionSpec(SearchRequest.SessionSpec.newBuilder().build())
            .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
            .build();

    SearchLitePagedResponse pagedListResponse = client.searchLite(request);

    List<SearchResponse.SearchResult> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSearchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchRequest actualRequest = ((SearchRequest) actualRequests.get(0));

    Assert.assertEquals(request.getServingConfig(), actualRequest.getServingConfig());
    Assert.assertEquals(request.getBranch(), actualRequest.getBranch());
    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertEquals(request.getImageQuery(), actualRequest.getImageQuery());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getOffset(), actualRequest.getOffset());
    Assert.assertEquals(request.getOneBoxPageSize(), actualRequest.getOneBoxPageSize());
    Assert.assertEquals(request.getDataStoreSpecsList(), actualRequest.getDataStoreSpecsList());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getCanonicalFilter(), actualRequest.getCanonicalFilter());
    Assert.assertEquals(request.getOrderBy(), actualRequest.getOrderBy());
    Assert.assertEquals(request.getUserInfo(), actualRequest.getUserInfo());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertEquals(request.getRegionCode(), actualRequest.getRegionCode());
    Assert.assertEquals(request.getFacetSpecsList(), actualRequest.getFacetSpecsList());
    Assert.assertEquals(request.getBoostSpec(), actualRequest.getBoostSpec());
    Assert.assertEquals(request.getParamsMap(), actualRequest.getParamsMap());
    Assert.assertEquals(request.getQueryExpansionSpec(), actualRequest.getQueryExpansionSpec());
    Assert.assertEquals(request.getSpellCorrectionSpec(), actualRequest.getSpellCorrectionSpec());
    Assert.assertEquals(request.getUserPseudoId(), actualRequest.getUserPseudoId());
    Assert.assertEquals(request.getContentSearchSpec(), actualRequest.getContentSearchSpec());
    Assert.assertEquals(request.getEmbeddingSpec(), actualRequest.getEmbeddingSpec());
    Assert.assertEquals(request.getRankingExpression(), actualRequest.getRankingExpression());
    Assert.assertEquals(
        request.getRankingExpressionBackend(), actualRequest.getRankingExpressionBackend());
    Assert.assertEquals(request.getSafeSearch(), actualRequest.getSafeSearch());
    Assert.assertEquals(request.getUserLabelsMap(), actualRequest.getUserLabelsMap());
    Assert.assertEquals(
        request.getNaturalLanguageQueryUnderstandingSpec(),
        actualRequest.getNaturalLanguageQueryUnderstandingSpec());
    Assert.assertEquals(request.getSearchAsYouTypeSpec(), actualRequest.getSearchAsYouTypeSpec());
    Assert.assertEquals(request.getSession(), actualRequest.getSession());
    Assert.assertEquals(request.getSessionSpec(), actualRequest.getSessionSpec());
    Assert.assertEquals(request.getRelevanceThreshold(), actualRequest.getRelevanceThreshold());
    Assert.assertEquals(request.getPersonalizationSpec(), actualRequest.getPersonalizationSpec());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchLiteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSearchService.addException(exception);

    try {
      SearchRequest request =
          SearchRequest.newBuilder()
              .setServingConfig(
                  ServingConfigName.ofProjectLocationDataStoreServingConfigName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
                      .toString())
              .setBranch(
                  BranchName.ofProjectLocationDataStoreBranchName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
                      .toString())
              .setQuery("query107944136")
              .setImageQuery(SearchRequest.ImageQuery.newBuilder().build())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setOffset(-1019779949)
              .setOneBoxPageSize(1988477988)
              .addAllDataStoreSpecs(new ArrayList<SearchRequest.DataStoreSpec>())
              .setFilter("filter-1274492040")
              .setCanonicalFilter("canonicalFilter-722283124")
              .setOrderBy("orderBy-1207110587")
              .setUserInfo(UserInfo.newBuilder().build())
              .setLanguageCode("languageCode-2092349083")
              .setRegionCode("regionCode-1991004415")
              .addAllFacetSpecs(new ArrayList<SearchRequest.FacetSpec>())
              .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
              .putAllParams(new HashMap<String, Value>())
              .setQueryExpansionSpec(SearchRequest.QueryExpansionSpec.newBuilder().build())
              .setSpellCorrectionSpec(SearchRequest.SpellCorrectionSpec.newBuilder().build())
              .setUserPseudoId("userPseudoId-1155274652")
              .setContentSearchSpec(SearchRequest.ContentSearchSpec.newBuilder().build())
              .setEmbeddingSpec(SearchRequest.EmbeddingSpec.newBuilder().build())
              .setRankingExpression("rankingExpression2110320494")
              .setSafeSearch(true)
              .putAllUserLabels(new HashMap<String, String>())
              .setNaturalLanguageQueryUnderstandingSpec(
                  SearchRequest.NaturalLanguageQueryUnderstandingSpec.newBuilder().build())
              .setSearchAsYouTypeSpec(SearchRequest.SearchAsYouTypeSpec.newBuilder().build())
              .setSession(
                  SessionName.ofProjectLocationDataStoreSessionName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                      .toString())
              .setSessionSpec(SearchRequest.SessionSpec.newBuilder().build())
              .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
              .build();
      client.searchLite(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
