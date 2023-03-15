/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.retail.v2beta;

import static com.google.cloud.retail.v2beta.SearchServiceClient.SearchPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
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
  private static MockSearchService mockSearchService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private SearchServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSearchService = new MockSearchService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockSearchService));
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
            .setPlacement("placement1792938725")
            .setBranch(BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
            .setQuery("query107944136")
            .setVisitorId("visitorId1880545833")
            .setUserInfo(UserInfo.newBuilder().build())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setOffset(-1019779949)
            .setFilter("filter-1274492040")
            .setCanonicalFilter("canonicalFilter-722283124")
            .setOrderBy("orderBy-1207110587")
            .addAllFacetSpecs(new ArrayList<SearchRequest.FacetSpec>())
            .setDynamicFacetSpec(SearchRequest.DynamicFacetSpec.newBuilder().build())
            .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
            .setQueryExpansionSpec(SearchRequest.QueryExpansionSpec.newBuilder().build())
            .addAllVariantRollupKeys(new ArrayList<String>())
            .addAllPageCategories(new ArrayList<String>())
            .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSpellCorrectionSpec(SearchRequest.SpellCorrectionSpec.newBuilder().build())
            .build();

    SearchPagedResponse pagedListResponse = client.search(request);

    List<SearchResponse.SearchResult> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSearchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchRequest actualRequest = ((SearchRequest) actualRequests.get(0));

    Assert.assertEquals(request.getPlacement(), actualRequest.getPlacement());
    Assert.assertEquals(request.getBranch(), actualRequest.getBranch());
    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertEquals(request.getVisitorId(), actualRequest.getVisitorId());
    Assert.assertEquals(request.getUserInfo(), actualRequest.getUserInfo());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getOffset(), actualRequest.getOffset());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getCanonicalFilter(), actualRequest.getCanonicalFilter());
    Assert.assertEquals(request.getOrderBy(), actualRequest.getOrderBy());
    Assert.assertEquals(request.getFacetSpecsList(), actualRequest.getFacetSpecsList());
    Assert.assertEquals(request.getDynamicFacetSpec(), actualRequest.getDynamicFacetSpec());
    Assert.assertEquals(request.getBoostSpec(), actualRequest.getBoostSpec());
    Assert.assertEquals(request.getQueryExpansionSpec(), actualRequest.getQueryExpansionSpec());
    Assert.assertEquals(
        request.getVariantRollupKeysList(), actualRequest.getVariantRollupKeysList());
    Assert.assertEquals(request.getPageCategoriesList(), actualRequest.getPageCategoriesList());
    Assert.assertEquals(request.getSearchMode(), actualRequest.getSearchMode());
    Assert.assertEquals(request.getPersonalizationSpec(), actualRequest.getPersonalizationSpec());
    Assert.assertEquals(request.getLabelsMap(), actualRequest.getLabelsMap());
    Assert.assertEquals(request.getSpellCorrectionSpec(), actualRequest.getSpellCorrectionSpec());
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
              .setPlacement("placement1792938725")
              .setBranch(
                  BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
              .setQuery("query107944136")
              .setVisitorId("visitorId1880545833")
              .setUserInfo(UserInfo.newBuilder().build())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setOffset(-1019779949)
              .setFilter("filter-1274492040")
              .setCanonicalFilter("canonicalFilter-722283124")
              .setOrderBy("orderBy-1207110587")
              .addAllFacetSpecs(new ArrayList<SearchRequest.FacetSpec>())
              .setDynamicFacetSpec(SearchRequest.DynamicFacetSpec.newBuilder().build())
              .setBoostSpec(SearchRequest.BoostSpec.newBuilder().build())
              .setQueryExpansionSpec(SearchRequest.QueryExpansionSpec.newBuilder().build())
              .addAllVariantRollupKeys(new ArrayList<String>())
              .addAllPageCategories(new ArrayList<String>())
              .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setSpellCorrectionSpec(SearchRequest.SpellCorrectionSpec.newBuilder().build())
              .build();
      client.search(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
