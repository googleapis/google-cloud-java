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

package com.google.cloud.retail.v2beta;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.retail.v2beta.stub.HttpJsonGenerativeQuestionServiceStub;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class GenerativeQuestionServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static GenerativeQuestionServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonGenerativeQuestionServiceStub.getMethodDescriptors(),
            GenerativeQuestionServiceSettings.getDefaultEndpoint());
    GenerativeQuestionServiceSettings settings =
        GenerativeQuestionServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                GenerativeQuestionServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GenerativeQuestionServiceClient.create(settings);
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
  public void updateGenerativeQuestionsFeatureConfigTest() throws Exception {
    GenerativeQuestionsFeatureConfig expectedResponse =
        GenerativeQuestionsFeatureConfig.newBuilder()
            .setCatalog("catalog555704345")
            .setFeatureEnabled(true)
            .setMinimumProducts(-417095051)
            .build();
    mockService.addResponse(expectedResponse);

    GenerativeQuestionsFeatureConfig generativeQuestionsFeatureConfig =
        GenerativeQuestionsFeatureConfig.newBuilder()
            .setCatalog("projects/project-6372/locations/location-6372/catalogs/catalog-6372")
            .setFeatureEnabled(true)
            .setMinimumProducts(-417095051)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GenerativeQuestionsFeatureConfig actualResponse =
        client.updateGenerativeQuestionsFeatureConfig(generativeQuestionsFeatureConfig, updateMask);
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
  public void updateGenerativeQuestionsFeatureConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GenerativeQuestionsFeatureConfig generativeQuestionsFeatureConfig =
          GenerativeQuestionsFeatureConfig.newBuilder()
              .setCatalog("projects/project-6372/locations/location-6372/catalogs/catalog-6372")
              .setFeatureEnabled(true)
              .setMinimumProducts(-417095051)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGenerativeQuestionsFeatureConfig(generativeQuestionsFeatureConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGenerativeQuestionsFeatureConfigTest() throws Exception {
    GenerativeQuestionsFeatureConfig expectedResponse =
        GenerativeQuestionsFeatureConfig.newBuilder()
            .setCatalog("catalog555704345")
            .setFeatureEnabled(true)
            .setMinimumProducts(-417095051)
            .build();
    mockService.addResponse(expectedResponse);

    CatalogName catalog = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    GenerativeQuestionsFeatureConfig actualResponse =
        client.getGenerativeQuestionsFeatureConfig(catalog);
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
  public void getGenerativeQuestionsFeatureConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName catalog = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      client.getGenerativeQuestionsFeatureConfig(catalog);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGenerativeQuestionsFeatureConfigTest2() throws Exception {
    GenerativeQuestionsFeatureConfig expectedResponse =
        GenerativeQuestionsFeatureConfig.newBuilder()
            .setCatalog("catalog555704345")
            .setFeatureEnabled(true)
            .setMinimumProducts(-417095051)
            .build();
    mockService.addResponse(expectedResponse);

    String catalog = "projects/project-6372/locations/location-6372/catalogs/catalog-6372";

    GenerativeQuestionsFeatureConfig actualResponse =
        client.getGenerativeQuestionsFeatureConfig(catalog);
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
  public void getGenerativeQuestionsFeatureConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String catalog = "projects/project-6372/locations/location-6372/catalogs/catalog-6372";
      client.getGenerativeQuestionsFeatureConfig(catalog);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGenerativeQuestionConfigsTest() throws Exception {
    ListGenerativeQuestionConfigsResponse expectedResponse =
        ListGenerativeQuestionConfigsResponse.newBuilder()
            .addAllGenerativeQuestionConfigs(new ArrayList<GenerativeQuestionConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    ListGenerativeQuestionConfigsResponse actualResponse =
        client.listGenerativeQuestionConfigs(parent);
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
  public void listGenerativeQuestionConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      client.listGenerativeQuestionConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGenerativeQuestionConfigsTest2() throws Exception {
    ListGenerativeQuestionConfigsResponse expectedResponse =
        ListGenerativeQuestionConfigsResponse.newBuilder()
            .addAllGenerativeQuestionConfigs(new ArrayList<GenerativeQuestionConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";

    ListGenerativeQuestionConfigsResponse actualResponse =
        client.listGenerativeQuestionConfigs(parent);
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
  public void listGenerativeQuestionConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";
      client.listGenerativeQuestionConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateGenerativeQuestionConfigTest() throws Exception {
    GenerativeQuestionConfig expectedResponse =
        GenerativeQuestionConfig.newBuilder()
            .setCatalog("catalog555704345")
            .setFacet("facet97187255")
            .setGeneratedQuestion("generatedQuestion-838321515")
            .setFinalQuestion("finalQuestion90540924")
            .addAllExampleValues(new ArrayList<String>())
            .setFrequency(-70023844)
            .setAllowedInConversation(true)
            .build();
    mockService.addResponse(expectedResponse);

    GenerativeQuestionConfig generativeQuestionConfig =
        GenerativeQuestionConfig.newBuilder()
            .setCatalog("projects/project-6372/locations/location-6372/catalogs/catalog-6372")
            .setFacet("facet97187255")
            .setGeneratedQuestion("generatedQuestion-838321515")
            .setFinalQuestion("finalQuestion90540924")
            .addAllExampleValues(new ArrayList<String>())
            .setFrequency(-70023844)
            .setAllowedInConversation(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GenerativeQuestionConfig actualResponse =
        client.updateGenerativeQuestionConfig(generativeQuestionConfig, updateMask);
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
  public void updateGenerativeQuestionConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GenerativeQuestionConfig generativeQuestionConfig =
          GenerativeQuestionConfig.newBuilder()
              .setCatalog("projects/project-6372/locations/location-6372/catalogs/catalog-6372")
              .setFacet("facet97187255")
              .setGeneratedQuestion("generatedQuestion-838321515")
              .setFinalQuestion("finalQuestion90540924")
              .addAllExampleValues(new ArrayList<String>())
              .setFrequency(-70023844)
              .setAllowedInConversation(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGenerativeQuestionConfig(generativeQuestionConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateGenerativeQuestionConfigsTest() throws Exception {
    BatchUpdateGenerativeQuestionConfigsResponse expectedResponse =
        BatchUpdateGenerativeQuestionConfigsResponse.newBuilder()
            .addAllGenerativeQuestionConfigs(new ArrayList<GenerativeQuestionConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
    List<UpdateGenerativeQuestionConfigRequest> requests = new ArrayList<>();

    BatchUpdateGenerativeQuestionConfigsResponse actualResponse =
        client.batchUpdateGenerativeQuestionConfigs(parent, requests);
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
  public void batchUpdateGenerativeQuestionConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      List<UpdateGenerativeQuestionConfigRequest> requests = new ArrayList<>();
      client.batchUpdateGenerativeQuestionConfigs(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateGenerativeQuestionConfigsTest2() throws Exception {
    BatchUpdateGenerativeQuestionConfigsResponse expectedResponse =
        BatchUpdateGenerativeQuestionConfigsResponse.newBuilder()
            .addAllGenerativeQuestionConfigs(new ArrayList<GenerativeQuestionConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";
    List<UpdateGenerativeQuestionConfigRequest> requests = new ArrayList<>();

    BatchUpdateGenerativeQuestionConfigsResponse actualResponse =
        client.batchUpdateGenerativeQuestionConfigs(parent, requests);
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
  public void batchUpdateGenerativeQuestionConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";
      List<UpdateGenerativeQuestionConfigRequest> requests = new ArrayList<>();
      client.batchUpdateGenerativeQuestionConfigs(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
