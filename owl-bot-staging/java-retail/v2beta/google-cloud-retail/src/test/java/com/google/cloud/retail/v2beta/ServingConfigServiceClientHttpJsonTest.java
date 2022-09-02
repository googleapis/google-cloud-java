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

import static com.google.cloud.retail.v2beta.ServingConfigServiceClient.ListServingConfigsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.retail.v2beta.stub.HttpJsonServingConfigServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class ServingConfigServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ServingConfigServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonServingConfigServiceStub.getMethodDescriptors(),
            ServingConfigServiceSettings.getDefaultEndpoint());
    ServingConfigServiceSettings settings =
        ServingConfigServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ServingConfigServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ServingConfigServiceClient.create(settings);
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
  public void createServingConfigTest() throws Exception {
    ServingConfig expectedResponse =
        ServingConfig.newBuilder()
            .setName(
                ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setModelId("modelId1226956324")
            .setPriceRerankingLevel("priceRerankingLevel-1925548982")
            .addAllFacetControlIds(new ArrayList<String>())
            .setDynamicFacetSpec(SearchRequest.DynamicFacetSpec.newBuilder().build())
            .addAllBoostControlIds(new ArrayList<String>())
            .addAllFilterControlIds(new ArrayList<String>())
            .addAllRedirectControlIds(new ArrayList<String>())
            .addAllTwowaySynonymsControlIds(new ArrayList<String>())
            .addAllOnewaySynonymsControlIds(new ArrayList<String>())
            .addAllDoNotAssociateControlIds(new ArrayList<String>())
            .addAllReplacementControlIds(new ArrayList<String>())
            .addAllIgnoreControlIds(new ArrayList<String>())
            .setDiversityLevel("diversityLevel578206123")
            .setEnableCategoryFilterLevel("enableCategoryFilterLevel-1232535413")
            .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .build();
    mockService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
    ServingConfig servingConfig = ServingConfig.newBuilder().build();
    String servingConfigId = "servingConfigId-831052759";

    ServingConfig actualResponse =
        client.createServingConfig(parent, servingConfig, servingConfigId);
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
  public void createServingConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      ServingConfig servingConfig = ServingConfig.newBuilder().build();
      String servingConfigId = "servingConfigId-831052759";
      client.createServingConfig(parent, servingConfig, servingConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createServingConfigTest2() throws Exception {
    ServingConfig expectedResponse =
        ServingConfig.newBuilder()
            .setName(
                ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setModelId("modelId1226956324")
            .setPriceRerankingLevel("priceRerankingLevel-1925548982")
            .addAllFacetControlIds(new ArrayList<String>())
            .setDynamicFacetSpec(SearchRequest.DynamicFacetSpec.newBuilder().build())
            .addAllBoostControlIds(new ArrayList<String>())
            .addAllFilterControlIds(new ArrayList<String>())
            .addAllRedirectControlIds(new ArrayList<String>())
            .addAllTwowaySynonymsControlIds(new ArrayList<String>())
            .addAllOnewaySynonymsControlIds(new ArrayList<String>())
            .addAllDoNotAssociateControlIds(new ArrayList<String>())
            .addAllReplacementControlIds(new ArrayList<String>())
            .addAllIgnoreControlIds(new ArrayList<String>())
            .setDiversityLevel("diversityLevel578206123")
            .setEnableCategoryFilterLevel("enableCategoryFilterLevel-1232535413")
            .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";
    ServingConfig servingConfig = ServingConfig.newBuilder().build();
    String servingConfigId = "servingConfigId-831052759";

    ServingConfig actualResponse =
        client.createServingConfig(parent, servingConfig, servingConfigId);
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
  public void createServingConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";
      ServingConfig servingConfig = ServingConfig.newBuilder().build();
      String servingConfigId = "servingConfigId-831052759";
      client.createServingConfig(parent, servingConfig, servingConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteServingConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ServingConfigName name =
        ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]");

    client.deleteServingConfig(name);

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
  public void deleteServingConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServingConfigName name =
          ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]");
      client.deleteServingConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteServingConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4507/locations/location-4507/catalogs/catalog-4507/servingConfigs/servingConfig-4507";

    client.deleteServingConfig(name);

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
  public void deleteServingConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4507/locations/location-4507/catalogs/catalog-4507/servingConfigs/servingConfig-4507";
      client.deleteServingConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateServingConfigTest() throws Exception {
    ServingConfig expectedResponse =
        ServingConfig.newBuilder()
            .setName(
                ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setModelId("modelId1226956324")
            .setPriceRerankingLevel("priceRerankingLevel-1925548982")
            .addAllFacetControlIds(new ArrayList<String>())
            .setDynamicFacetSpec(SearchRequest.DynamicFacetSpec.newBuilder().build())
            .addAllBoostControlIds(new ArrayList<String>())
            .addAllFilterControlIds(new ArrayList<String>())
            .addAllRedirectControlIds(new ArrayList<String>())
            .addAllTwowaySynonymsControlIds(new ArrayList<String>())
            .addAllOnewaySynonymsControlIds(new ArrayList<String>())
            .addAllDoNotAssociateControlIds(new ArrayList<String>())
            .addAllReplacementControlIds(new ArrayList<String>())
            .addAllIgnoreControlIds(new ArrayList<String>())
            .setDiversityLevel("diversityLevel578206123")
            .setEnableCategoryFilterLevel("enableCategoryFilterLevel-1232535413")
            .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .build();
    mockService.addResponse(expectedResponse);

    ServingConfig servingConfig =
        ServingConfig.newBuilder()
            .setName(
                ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setModelId("modelId1226956324")
            .setPriceRerankingLevel("priceRerankingLevel-1925548982")
            .addAllFacetControlIds(new ArrayList<String>())
            .setDynamicFacetSpec(SearchRequest.DynamicFacetSpec.newBuilder().build())
            .addAllBoostControlIds(new ArrayList<String>())
            .addAllFilterControlIds(new ArrayList<String>())
            .addAllRedirectControlIds(new ArrayList<String>())
            .addAllTwowaySynonymsControlIds(new ArrayList<String>())
            .addAllOnewaySynonymsControlIds(new ArrayList<String>())
            .addAllDoNotAssociateControlIds(new ArrayList<String>())
            .addAllReplacementControlIds(new ArrayList<String>())
            .addAllIgnoreControlIds(new ArrayList<String>())
            .setDiversityLevel("diversityLevel578206123")
            .setEnableCategoryFilterLevel("enableCategoryFilterLevel-1232535413")
            .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ServingConfig actualResponse = client.updateServingConfig(servingConfig, updateMask);
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
  public void updateServingConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServingConfig servingConfig =
          ServingConfig.newBuilder()
              .setName(
                  ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setModelId("modelId1226956324")
              .setPriceRerankingLevel("priceRerankingLevel-1925548982")
              .addAllFacetControlIds(new ArrayList<String>())
              .setDynamicFacetSpec(SearchRequest.DynamicFacetSpec.newBuilder().build())
              .addAllBoostControlIds(new ArrayList<String>())
              .addAllFilterControlIds(new ArrayList<String>())
              .addAllRedirectControlIds(new ArrayList<String>())
              .addAllTwowaySynonymsControlIds(new ArrayList<String>())
              .addAllOnewaySynonymsControlIds(new ArrayList<String>())
              .addAllDoNotAssociateControlIds(new ArrayList<String>())
              .addAllReplacementControlIds(new ArrayList<String>())
              .addAllIgnoreControlIds(new ArrayList<String>())
              .setDiversityLevel("diversityLevel578206123")
              .setEnableCategoryFilterLevel("enableCategoryFilterLevel-1232535413")
              .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
              .addAllSolutionTypes(new ArrayList<SolutionType>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateServingConfig(servingConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServingConfigTest() throws Exception {
    ServingConfig expectedResponse =
        ServingConfig.newBuilder()
            .setName(
                ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setModelId("modelId1226956324")
            .setPriceRerankingLevel("priceRerankingLevel-1925548982")
            .addAllFacetControlIds(new ArrayList<String>())
            .setDynamicFacetSpec(SearchRequest.DynamicFacetSpec.newBuilder().build())
            .addAllBoostControlIds(new ArrayList<String>())
            .addAllFilterControlIds(new ArrayList<String>())
            .addAllRedirectControlIds(new ArrayList<String>())
            .addAllTwowaySynonymsControlIds(new ArrayList<String>())
            .addAllOnewaySynonymsControlIds(new ArrayList<String>())
            .addAllDoNotAssociateControlIds(new ArrayList<String>())
            .addAllReplacementControlIds(new ArrayList<String>())
            .addAllIgnoreControlIds(new ArrayList<String>())
            .setDiversityLevel("diversityLevel578206123")
            .setEnableCategoryFilterLevel("enableCategoryFilterLevel-1232535413")
            .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .build();
    mockService.addResponse(expectedResponse);

    ServingConfigName name =
        ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]");

    ServingConfig actualResponse = client.getServingConfig(name);
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
  public void getServingConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServingConfigName name =
          ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]");
      client.getServingConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServingConfigTest2() throws Exception {
    ServingConfig expectedResponse =
        ServingConfig.newBuilder()
            .setName(
                ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setModelId("modelId1226956324")
            .setPriceRerankingLevel("priceRerankingLevel-1925548982")
            .addAllFacetControlIds(new ArrayList<String>())
            .setDynamicFacetSpec(SearchRequest.DynamicFacetSpec.newBuilder().build())
            .addAllBoostControlIds(new ArrayList<String>())
            .addAllFilterControlIds(new ArrayList<String>())
            .addAllRedirectControlIds(new ArrayList<String>())
            .addAllTwowaySynonymsControlIds(new ArrayList<String>())
            .addAllOnewaySynonymsControlIds(new ArrayList<String>())
            .addAllDoNotAssociateControlIds(new ArrayList<String>())
            .addAllReplacementControlIds(new ArrayList<String>())
            .addAllIgnoreControlIds(new ArrayList<String>())
            .setDiversityLevel("diversityLevel578206123")
            .setEnableCategoryFilterLevel("enableCategoryFilterLevel-1232535413")
            .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4507/locations/location-4507/catalogs/catalog-4507/servingConfigs/servingConfig-4507";

    ServingConfig actualResponse = client.getServingConfig(name);
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
  public void getServingConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4507/locations/location-4507/catalogs/catalog-4507/servingConfigs/servingConfig-4507";
      client.getServingConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServingConfigsTest() throws Exception {
    ServingConfig responsesElement = ServingConfig.newBuilder().build();
    ListServingConfigsResponse expectedResponse =
        ListServingConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllServingConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    ListServingConfigsPagedResponse pagedListResponse = client.listServingConfigs(parent);

    List<ServingConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServingConfigsList().get(0), resources.get(0));

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
  public void listServingConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      client.listServingConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listServingConfigsTest2() throws Exception {
    ServingConfig responsesElement = ServingConfig.newBuilder().build();
    ListServingConfigsResponse expectedResponse =
        ListServingConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllServingConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";

    ListServingConfigsPagedResponse pagedListResponse = client.listServingConfigs(parent);

    List<ServingConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServingConfigsList().get(0), resources.get(0));

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
  public void listServingConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";
      client.listServingConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addControlTest() throws Exception {
    ServingConfig expectedResponse =
        ServingConfig.newBuilder()
            .setName(
                ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setModelId("modelId1226956324")
            .setPriceRerankingLevel("priceRerankingLevel-1925548982")
            .addAllFacetControlIds(new ArrayList<String>())
            .setDynamicFacetSpec(SearchRequest.DynamicFacetSpec.newBuilder().build())
            .addAllBoostControlIds(new ArrayList<String>())
            .addAllFilterControlIds(new ArrayList<String>())
            .addAllRedirectControlIds(new ArrayList<String>())
            .addAllTwowaySynonymsControlIds(new ArrayList<String>())
            .addAllOnewaySynonymsControlIds(new ArrayList<String>())
            .addAllDoNotAssociateControlIds(new ArrayList<String>())
            .addAllReplacementControlIds(new ArrayList<String>())
            .addAllIgnoreControlIds(new ArrayList<String>())
            .setDiversityLevel("diversityLevel578206123")
            .setEnableCategoryFilterLevel("enableCategoryFilterLevel-1232535413")
            .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .build();
    mockService.addResponse(expectedResponse);

    ServingConfigName servingConfig =
        ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]");

    ServingConfig actualResponse = client.addControl(servingConfig);
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
  public void addControlExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServingConfigName servingConfig =
          ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]");
      client.addControl(servingConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addControlTest2() throws Exception {
    ServingConfig expectedResponse =
        ServingConfig.newBuilder()
            .setName(
                ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setModelId("modelId1226956324")
            .setPriceRerankingLevel("priceRerankingLevel-1925548982")
            .addAllFacetControlIds(new ArrayList<String>())
            .setDynamicFacetSpec(SearchRequest.DynamicFacetSpec.newBuilder().build())
            .addAllBoostControlIds(new ArrayList<String>())
            .addAllFilterControlIds(new ArrayList<String>())
            .addAllRedirectControlIds(new ArrayList<String>())
            .addAllTwowaySynonymsControlIds(new ArrayList<String>())
            .addAllOnewaySynonymsControlIds(new ArrayList<String>())
            .addAllDoNotAssociateControlIds(new ArrayList<String>())
            .addAllReplacementControlIds(new ArrayList<String>())
            .addAllIgnoreControlIds(new ArrayList<String>())
            .setDiversityLevel("diversityLevel578206123")
            .setEnableCategoryFilterLevel("enableCategoryFilterLevel-1232535413")
            .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .build();
    mockService.addResponse(expectedResponse);

    String servingConfig =
        "projects/project-1064/locations/location-1064/catalogs/catalog-1064/servingConfigs/servingConfig-1064";

    ServingConfig actualResponse = client.addControl(servingConfig);
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
  public void addControlExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String servingConfig =
          "projects/project-1064/locations/location-1064/catalogs/catalog-1064/servingConfigs/servingConfig-1064";
      client.addControl(servingConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeControlTest() throws Exception {
    ServingConfig expectedResponse =
        ServingConfig.newBuilder()
            .setName(
                ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setModelId("modelId1226956324")
            .setPriceRerankingLevel("priceRerankingLevel-1925548982")
            .addAllFacetControlIds(new ArrayList<String>())
            .setDynamicFacetSpec(SearchRequest.DynamicFacetSpec.newBuilder().build())
            .addAllBoostControlIds(new ArrayList<String>())
            .addAllFilterControlIds(new ArrayList<String>())
            .addAllRedirectControlIds(new ArrayList<String>())
            .addAllTwowaySynonymsControlIds(new ArrayList<String>())
            .addAllOnewaySynonymsControlIds(new ArrayList<String>())
            .addAllDoNotAssociateControlIds(new ArrayList<String>())
            .addAllReplacementControlIds(new ArrayList<String>())
            .addAllIgnoreControlIds(new ArrayList<String>())
            .setDiversityLevel("diversityLevel578206123")
            .setEnableCategoryFilterLevel("enableCategoryFilterLevel-1232535413")
            .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .build();
    mockService.addResponse(expectedResponse);

    ServingConfigName servingConfig =
        ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]");

    ServingConfig actualResponse = client.removeControl(servingConfig);
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
  public void removeControlExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ServingConfigName servingConfig =
          ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]");
      client.removeControl(servingConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeControlTest2() throws Exception {
    ServingConfig expectedResponse =
        ServingConfig.newBuilder()
            .setName(
                ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setModelId("modelId1226956324")
            .setPriceRerankingLevel("priceRerankingLevel-1925548982")
            .addAllFacetControlIds(new ArrayList<String>())
            .setDynamicFacetSpec(SearchRequest.DynamicFacetSpec.newBuilder().build())
            .addAllBoostControlIds(new ArrayList<String>())
            .addAllFilterControlIds(new ArrayList<String>())
            .addAllRedirectControlIds(new ArrayList<String>())
            .addAllTwowaySynonymsControlIds(new ArrayList<String>())
            .addAllOnewaySynonymsControlIds(new ArrayList<String>())
            .addAllDoNotAssociateControlIds(new ArrayList<String>())
            .addAllReplacementControlIds(new ArrayList<String>())
            .addAllIgnoreControlIds(new ArrayList<String>())
            .setDiversityLevel("diversityLevel578206123")
            .setEnableCategoryFilterLevel("enableCategoryFilterLevel-1232535413")
            .setPersonalizationSpec(SearchRequest.PersonalizationSpec.newBuilder().build())
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .build();
    mockService.addResponse(expectedResponse);

    String servingConfig =
        "projects/project-1064/locations/location-1064/catalogs/catalog-1064/servingConfigs/servingConfig-1064";

    ServingConfig actualResponse = client.removeControl(servingConfig);
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
  public void removeControlExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String servingConfig =
          "projects/project-1064/locations/location-1064/catalogs/catalog-1064/servingConfigs/servingConfig-1064";
      client.removeControl(servingConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
