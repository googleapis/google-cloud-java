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

package com.google.cloud.retail.v2;

import static com.google.cloud.retail.v2.SearchServiceClient.SearchPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.retail.v2.stub.HttpJsonSearchServiceStub;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SearchServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SearchServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSearchServiceStub.getMethodDescriptors(),
            SearchServiceSettings.getDefaultEndpoint());
    SearchServiceSettings settings =
        SearchServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SearchServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SearchServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void searchTest() throws Exception {
    SearchResponse.SearchResult responsesElement = SearchResponse.SearchResult.newBuilder().build();
    SearchResponse expectedResponse =
        SearchResponse.newBuilder()
            .setNextPageToken("")
            .addAllResults(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SearchRequest request =
        SearchRequest.newBuilder()
            .setPlacement(
                "projects/project-9512/locations/location-9512/catalogs/catalog-9512/placements/placement-9512")
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

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void searchExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchRequest request =
          SearchRequest.newBuilder()
              .setPlacement(
                  "projects/project-9512/locations/location-9512/catalogs/catalog-9512/placements/placement-9512")
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
