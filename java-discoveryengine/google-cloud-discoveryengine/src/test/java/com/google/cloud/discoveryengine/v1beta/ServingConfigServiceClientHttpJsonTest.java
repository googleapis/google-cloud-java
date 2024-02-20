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

package com.google.cloud.discoveryengine.v1beta;

import static com.google.cloud.discoveryengine.v1beta.ServingConfigServiceClient.ListServingConfigsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1beta.stub.HttpJsonServingConfigServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
  public void updateServingConfigTest() throws Exception {
    ServingConfig expectedResponse =
        ServingConfig.newBuilder()
            .setName(
                ServingConfigName.ofProjectLocationDataStoreServingConfigName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setSolutionType(SolutionType.forNumber(0))
            .setModelId("modelId1226956324")
            .setDiversityLevel("diversityLevel578206123")
            .setEmbeddingConfig(EmbeddingConfig.newBuilder().build())
            .setRankingExpression("rankingExpression2110320494")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllFilterControlIds(new ArrayList<String>())
            .addAllBoostControlIds(new ArrayList<String>())
            .addAllRedirectControlIds(new ArrayList<String>())
            .addAllSynonymsControlIds(new ArrayList<String>())
            .addAllOnewaySynonymsControlIds(new ArrayList<String>())
            .addAllDissociateControlIds(new ArrayList<String>())
            .addAllReplacementControlIds(new ArrayList<String>())
            .addAllIgnoreControlIds(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    ServingConfig servingConfig =
        ServingConfig.newBuilder()
            .setName(
                ServingConfigName.ofProjectLocationDataStoreServingConfigName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setSolutionType(SolutionType.forNumber(0))
            .setModelId("modelId1226956324")
            .setDiversityLevel("diversityLevel578206123")
            .setEmbeddingConfig(EmbeddingConfig.newBuilder().build())
            .setRankingExpression("rankingExpression2110320494")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllFilterControlIds(new ArrayList<String>())
            .addAllBoostControlIds(new ArrayList<String>())
            .addAllRedirectControlIds(new ArrayList<String>())
            .addAllSynonymsControlIds(new ArrayList<String>())
            .addAllOnewaySynonymsControlIds(new ArrayList<String>())
            .addAllDissociateControlIds(new ArrayList<String>())
            .addAllReplacementControlIds(new ArrayList<String>())
            .addAllIgnoreControlIds(new ArrayList<String>())
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
                  ServingConfigName.ofProjectLocationDataStoreServingConfigName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setSolutionType(SolutionType.forNumber(0))
              .setModelId("modelId1226956324")
              .setDiversityLevel("diversityLevel578206123")
              .setEmbeddingConfig(EmbeddingConfig.newBuilder().build())
              .setRankingExpression("rankingExpression2110320494")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .addAllFilterControlIds(new ArrayList<String>())
              .addAllBoostControlIds(new ArrayList<String>())
              .addAllRedirectControlIds(new ArrayList<String>())
              .addAllSynonymsControlIds(new ArrayList<String>())
              .addAllOnewaySynonymsControlIds(new ArrayList<String>())
              .addAllDissociateControlIds(new ArrayList<String>())
              .addAllReplacementControlIds(new ArrayList<String>())
              .addAllIgnoreControlIds(new ArrayList<String>())
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
                ServingConfigName.ofProjectLocationDataStoreServingConfigName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setSolutionType(SolutionType.forNumber(0))
            .setModelId("modelId1226956324")
            .setDiversityLevel("diversityLevel578206123")
            .setEmbeddingConfig(EmbeddingConfig.newBuilder().build())
            .setRankingExpression("rankingExpression2110320494")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllFilterControlIds(new ArrayList<String>())
            .addAllBoostControlIds(new ArrayList<String>())
            .addAllRedirectControlIds(new ArrayList<String>())
            .addAllSynonymsControlIds(new ArrayList<String>())
            .addAllOnewaySynonymsControlIds(new ArrayList<String>())
            .addAllDissociateControlIds(new ArrayList<String>())
            .addAllReplacementControlIds(new ArrayList<String>())
            .addAllIgnoreControlIds(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    ServingConfigName name =
        ServingConfigName.ofProjectLocationDataStoreServingConfigName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]");

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
          ServingConfigName.ofProjectLocationDataStoreServingConfigName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]");
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
                ServingConfigName.ofProjectLocationDataStoreServingConfigName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setSolutionType(SolutionType.forNumber(0))
            .setModelId("modelId1226956324")
            .setDiversityLevel("diversityLevel578206123")
            .setEmbeddingConfig(EmbeddingConfig.newBuilder().build())
            .setRankingExpression("rankingExpression2110320494")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllFilterControlIds(new ArrayList<String>())
            .addAllBoostControlIds(new ArrayList<String>())
            .addAllRedirectControlIds(new ArrayList<String>())
            .addAllSynonymsControlIds(new ArrayList<String>())
            .addAllOnewaySynonymsControlIds(new ArrayList<String>())
            .addAllDissociateControlIds(new ArrayList<String>())
            .addAllReplacementControlIds(new ArrayList<String>())
            .addAllIgnoreControlIds(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-387/locations/location-387/dataStores/dataStore-387/servingConfigs/servingConfig-387";

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
          "projects/project-387/locations/location-387/dataStores/dataStore-387/servingConfigs/servingConfig-387";
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

    DataStoreName parent =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");

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
      DataStoreName parent =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
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

    String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";

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
      String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";
      client.listServingConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
