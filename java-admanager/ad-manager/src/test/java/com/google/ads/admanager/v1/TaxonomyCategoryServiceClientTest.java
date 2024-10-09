/*
 * Copyright 2024 Google LLC
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

import static com.google.ads.admanager.v1.TaxonomyCategoryServiceClient.ListTaxonomyCategoriesPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonTaxonomyCategoryServiceStub;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class TaxonomyCategoryServiceClientTest {
  private static MockHttpService mockService;
  private static TaxonomyCategoryServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonTaxonomyCategoryServiceStub.getMethodDescriptors(),
            TaxonomyCategoryServiceSettings.getDefaultEndpoint());
    TaxonomyCategoryServiceSettings settings =
        TaxonomyCategoryServiceSettings.newBuilder()
            .setTransportChannelProvider(
                TaxonomyCategoryServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TaxonomyCategoryServiceClient.create(settings);
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
  public void getTaxonomyCategoryTest() throws Exception {
    TaxonomyCategory expectedResponse =
        TaxonomyCategory.newBuilder()
            .setName(TaxonomyCategoryName.of("[NETWORK_CODE]", "[TAXONOMY_CATEGORY]").toString())
            .setTaxonomyCategoryId(28298254)
            .setDisplayName("displayName1714148973")
            .setGroupingOnly(true)
            .setParentTaxonomyCategoryId(-1790260093)
            .addAllAncestorNames(new ArrayList<String>())
            .addAllAncestorTaxonomyCategoryIds(new ArrayList<Long>())
            .build();
    mockService.addResponse(expectedResponse);

    TaxonomyCategoryName name = TaxonomyCategoryName.of("[NETWORK_CODE]", "[TAXONOMY_CATEGORY]");

    TaxonomyCategory actualResponse = client.getTaxonomyCategory(name);
    Assert.assertEquals(expectedResponse, actualResponse);

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
  public void getTaxonomyCategoryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TaxonomyCategoryName name = TaxonomyCategoryName.of("[NETWORK_CODE]", "[TAXONOMY_CATEGORY]");
      client.getTaxonomyCategory(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTaxonomyCategoryTest2() throws Exception {
    TaxonomyCategory expectedResponse =
        TaxonomyCategory.newBuilder()
            .setName(TaxonomyCategoryName.of("[NETWORK_CODE]", "[TAXONOMY_CATEGORY]").toString())
            .setTaxonomyCategoryId(28298254)
            .setDisplayName("displayName1714148973")
            .setGroupingOnly(true)
            .setParentTaxonomyCategoryId(-1790260093)
            .addAllAncestorNames(new ArrayList<String>())
            .addAllAncestorTaxonomyCategoryIds(new ArrayList<Long>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-3684/taxonomyCategories/taxonomyCategorie-3684";

    TaxonomyCategory actualResponse = client.getTaxonomyCategory(name);
    Assert.assertEquals(expectedResponse, actualResponse);

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
  public void getTaxonomyCategoryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-3684/taxonomyCategories/taxonomyCategorie-3684";
      client.getTaxonomyCategory(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTaxonomyCategoriesTest() throws Exception {
    TaxonomyCategory responsesElement = TaxonomyCategory.newBuilder().build();
    ListTaxonomyCategoriesResponse expectedResponse =
        ListTaxonomyCategoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTaxonomyCategories(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListTaxonomyCategoriesPagedResponse pagedListResponse = client.listTaxonomyCategories(parent);

    List<TaxonomyCategory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTaxonomyCategoriesList().get(0), resources.get(0));

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
  public void listTaxonomyCategoriesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listTaxonomyCategories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTaxonomyCategoriesTest2() throws Exception {
    TaxonomyCategory responsesElement = TaxonomyCategory.newBuilder().build();
    ListTaxonomyCategoriesResponse expectedResponse =
        ListTaxonomyCategoriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTaxonomyCategories(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListTaxonomyCategoriesPagedResponse pagedListResponse = client.listTaxonomyCategories(parent);

    List<TaxonomyCategory> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTaxonomyCategoriesList().get(0), resources.get(0));

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
  public void listTaxonomyCategoriesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listTaxonomyCategories(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
