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

package com.google.cloud.retail.v2alpha;

import static com.google.cloud.retail.v2alpha.CatalogServiceClient.ListCatalogsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.retail.v2alpha.stub.HttpJsonCatalogServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class CatalogServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CatalogServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCatalogServiceStub.getMethodDescriptors(),
            CatalogServiceSettings.getDefaultEndpoint());
    CatalogServiceSettings settings =
        CatalogServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CatalogServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CatalogServiceClient.create(settings);
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
  public void listCatalogsTest() throws Exception {
    Catalog responsesElement = Catalog.newBuilder().build();
    ListCatalogsResponse expectedResponse =
        ListCatalogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCatalogsPagedResponse pagedListResponse = client.listCatalogs(parent);

    List<Catalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogsList().get(0), resources.get(0));

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
  public void listCatalogsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCatalogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCatalogsTest2() throws Exception {
    Catalog responsesElement = Catalog.newBuilder().build();
    ListCatalogsResponse expectedResponse =
        ListCatalogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListCatalogsPagedResponse pagedListResponse = client.listCatalogs(parent);

    List<Catalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogsList().get(0), resources.get(0));

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
  public void listCatalogsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listCatalogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCatalogTest() throws Exception {
    Catalog expectedResponse =
        Catalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setDisplayName("displayName1714148973")
            .setProductLevelConfig(ProductLevelConfig.newBuilder().build())
            .setMerchantCenterLinkingConfig(MerchantCenterLinkingConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Catalog catalog =
        Catalog.newBuilder()
            .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setDisplayName("displayName1714148973")
            .setProductLevelConfig(ProductLevelConfig.newBuilder().build())
            .setMerchantCenterLinkingConfig(MerchantCenterLinkingConfig.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Catalog actualResponse = client.updateCatalog(catalog, updateMask);
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
  public void updateCatalogExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Catalog catalog =
          Catalog.newBuilder()
              .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setDisplayName("displayName1714148973")
              .setProductLevelConfig(ProductLevelConfig.newBuilder().build())
              .setMerchantCenterLinkingConfig(MerchantCenterLinkingConfig.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCatalog(catalog, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setDefaultBranchTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    CatalogName catalog = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    client.setDefaultBranch(catalog);

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
  public void setDefaultBranchExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName catalog = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      client.setDefaultBranch(catalog);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setDefaultBranchTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String catalog = "projects/project-6372/locations/location-6372/catalogs/catalog-6372";

    client.setDefaultBranch(catalog);

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
  public void setDefaultBranchExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String catalog = "projects/project-6372/locations/location-6372/catalogs/catalog-6372";
      client.setDefaultBranch(catalog);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDefaultBranchTest() throws Exception {
    GetDefaultBranchResponse expectedResponse =
        GetDefaultBranchResponse.newBuilder()
            .setBranch(BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
            .setSetTime(Timestamp.newBuilder().build())
            .setNote("note3387378")
            .build();
    mockService.addResponse(expectedResponse);

    CatalogName catalog = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    GetDefaultBranchResponse actualResponse = client.getDefaultBranch(catalog);
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
  public void getDefaultBranchExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName catalog = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      client.getDefaultBranch(catalog);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDefaultBranchTest2() throws Exception {
    GetDefaultBranchResponse expectedResponse =
        GetDefaultBranchResponse.newBuilder()
            .setBranch(BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
            .setSetTime(Timestamp.newBuilder().build())
            .setNote("note3387378")
            .build();
    mockService.addResponse(expectedResponse);

    String catalog = "projects/project-6372/locations/location-6372/catalogs/catalog-6372";

    GetDefaultBranchResponse actualResponse = client.getDefaultBranch(catalog);
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
  public void getDefaultBranchExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String catalog = "projects/project-6372/locations/location-6372/catalogs/catalog-6372";
      client.getDefaultBranch(catalog);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCompletionConfigTest() throws Exception {
    CompletionConfig expectedResponse =
        CompletionConfig.newBuilder()
            .setName(CompletionConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setMatchingOrder("matchingOrder-1366761135")
            .setMaxSuggestions(618824852)
            .setMinPrefixLength(96853510)
            .setAutoLearning(true)
            .setSuggestionsInputConfig(CompletionDataInputConfig.newBuilder().build())
            .setLastSuggestionsImportOperation("lastSuggestionsImportOperation-245829751")
            .setDenylistInputConfig(CompletionDataInputConfig.newBuilder().build())
            .setLastDenylistImportOperation("lastDenylistImportOperation1262341570")
            .setAllowlistInputConfig(CompletionDataInputConfig.newBuilder().build())
            .setLastAllowlistImportOperation("lastAllowlistImportOperation1624716689")
            .build();
    mockService.addResponse(expectedResponse);

    CompletionConfigName name = CompletionConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    CompletionConfig actualResponse = client.getCompletionConfig(name);
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
  public void getCompletionConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CompletionConfigName name = CompletionConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      client.getCompletionConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCompletionConfigTest2() throws Exception {
    CompletionConfig expectedResponse =
        CompletionConfig.newBuilder()
            .setName(CompletionConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setMatchingOrder("matchingOrder-1366761135")
            .setMaxSuggestions(618824852)
            .setMinPrefixLength(96853510)
            .setAutoLearning(true)
            .setSuggestionsInputConfig(CompletionDataInputConfig.newBuilder().build())
            .setLastSuggestionsImportOperation("lastSuggestionsImportOperation-245829751")
            .setDenylistInputConfig(CompletionDataInputConfig.newBuilder().build())
            .setLastDenylistImportOperation("lastDenylistImportOperation1262341570")
            .setAllowlistInputConfig(CompletionDataInputConfig.newBuilder().build())
            .setLastAllowlistImportOperation("lastAllowlistImportOperation1624716689")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6627/locations/location-6627/catalogs/catalog-6627/completionConfig";

    CompletionConfig actualResponse = client.getCompletionConfig(name);
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
  public void getCompletionConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6627/locations/location-6627/catalogs/catalog-6627/completionConfig";
      client.getCompletionConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCompletionConfigTest() throws Exception {
    CompletionConfig expectedResponse =
        CompletionConfig.newBuilder()
            .setName(CompletionConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setMatchingOrder("matchingOrder-1366761135")
            .setMaxSuggestions(618824852)
            .setMinPrefixLength(96853510)
            .setAutoLearning(true)
            .setSuggestionsInputConfig(CompletionDataInputConfig.newBuilder().build())
            .setLastSuggestionsImportOperation("lastSuggestionsImportOperation-245829751")
            .setDenylistInputConfig(CompletionDataInputConfig.newBuilder().build())
            .setLastDenylistImportOperation("lastDenylistImportOperation1262341570")
            .setAllowlistInputConfig(CompletionDataInputConfig.newBuilder().build())
            .setLastAllowlistImportOperation("lastAllowlistImportOperation1624716689")
            .build();
    mockService.addResponse(expectedResponse);

    CompletionConfig completionConfig =
        CompletionConfig.newBuilder()
            .setName(CompletionConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setMatchingOrder("matchingOrder-1366761135")
            .setMaxSuggestions(618824852)
            .setMinPrefixLength(96853510)
            .setAutoLearning(true)
            .setSuggestionsInputConfig(CompletionDataInputConfig.newBuilder().build())
            .setLastSuggestionsImportOperation("lastSuggestionsImportOperation-245829751")
            .setDenylistInputConfig(CompletionDataInputConfig.newBuilder().build())
            .setLastDenylistImportOperation("lastDenylistImportOperation1262341570")
            .setAllowlistInputConfig(CompletionDataInputConfig.newBuilder().build())
            .setLastAllowlistImportOperation("lastAllowlistImportOperation1624716689")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CompletionConfig actualResponse = client.updateCompletionConfig(completionConfig, updateMask);
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
  public void updateCompletionConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CompletionConfig completionConfig =
          CompletionConfig.newBuilder()
              .setName(CompletionConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setMatchingOrder("matchingOrder-1366761135")
              .setMaxSuggestions(618824852)
              .setMinPrefixLength(96853510)
              .setAutoLearning(true)
              .setSuggestionsInputConfig(CompletionDataInputConfig.newBuilder().build())
              .setLastSuggestionsImportOperation("lastSuggestionsImportOperation-245829751")
              .setDenylistInputConfig(CompletionDataInputConfig.newBuilder().build())
              .setLastDenylistImportOperation("lastDenylistImportOperation1262341570")
              .setAllowlistInputConfig(CompletionDataInputConfig.newBuilder().build())
              .setLastAllowlistImportOperation("lastAllowlistImportOperation1624716689")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCompletionConfig(completionConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttributesConfigTest() throws Exception {
    AttributesConfig expectedResponse =
        AttributesConfig.newBuilder()
            .setName(AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .putAllCatalogAttributes(new HashMap<String, CatalogAttribute>())
            .setAttributeConfigLevel(AttributeConfigLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    AttributesConfigName name = AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    AttributesConfig actualResponse = client.getAttributesConfig(name);
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
  public void getAttributesConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AttributesConfigName name = AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      client.getAttributesConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttributesConfigTest2() throws Exception {
    AttributesConfig expectedResponse =
        AttributesConfig.newBuilder()
            .setName(AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .putAllCatalogAttributes(new HashMap<String, CatalogAttribute>())
            .setAttributeConfigLevel(AttributeConfigLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9790/locations/location-9790/catalogs/catalog-9790/attributesConfig";

    AttributesConfig actualResponse = client.getAttributesConfig(name);
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
  public void getAttributesConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9790/locations/location-9790/catalogs/catalog-9790/attributesConfig";
      client.getAttributesConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAttributesConfigTest() throws Exception {
    AttributesConfig expectedResponse =
        AttributesConfig.newBuilder()
            .setName(AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .putAllCatalogAttributes(new HashMap<String, CatalogAttribute>())
            .setAttributeConfigLevel(AttributeConfigLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    AttributesConfig attributesConfig =
        AttributesConfig.newBuilder()
            .setName(AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .putAllCatalogAttributes(new HashMap<String, CatalogAttribute>())
            .setAttributeConfigLevel(AttributeConfigLevel.forNumber(0))
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AttributesConfig actualResponse = client.updateAttributesConfig(attributesConfig, updateMask);
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
  public void updateAttributesConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AttributesConfig attributesConfig =
          AttributesConfig.newBuilder()
              .setName(AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .putAllCatalogAttributes(new HashMap<String, CatalogAttribute>())
              .setAttributeConfigLevel(AttributeConfigLevel.forNumber(0))
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAttributesConfig(attributesConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addCatalogAttributeTest() throws Exception {
    AttributesConfig expectedResponse =
        AttributesConfig.newBuilder()
            .setName(AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .putAllCatalogAttributes(new HashMap<String, CatalogAttribute>())
            .setAttributeConfigLevel(AttributeConfigLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    AddCatalogAttributeRequest request =
        AddCatalogAttributeRequest.newBuilder()
            .setAttributesConfig(
                AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setCatalogAttribute(CatalogAttribute.newBuilder().build())
            .build();

    AttributesConfig actualResponse = client.addCatalogAttribute(request);
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
  public void addCatalogAttributeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AddCatalogAttributeRequest request =
          AddCatalogAttributeRequest.newBuilder()
              .setAttributesConfig(
                  AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setCatalogAttribute(CatalogAttribute.newBuilder().build())
              .build();
      client.addCatalogAttribute(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeCatalogAttributeTest() throws Exception {
    AttributesConfig expectedResponse =
        AttributesConfig.newBuilder()
            .setName(AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .putAllCatalogAttributes(new HashMap<String, CatalogAttribute>())
            .setAttributeConfigLevel(AttributeConfigLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    RemoveCatalogAttributeRequest request =
        RemoveCatalogAttributeRequest.newBuilder()
            .setAttributesConfig(
                AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setKey("key106079")
            .build();

    AttributesConfig actualResponse = client.removeCatalogAttribute(request);
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
  public void removeCatalogAttributeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RemoveCatalogAttributeRequest request =
          RemoveCatalogAttributeRequest.newBuilder()
              .setAttributesConfig(
                  AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setKey("key106079")
              .build();
      client.removeCatalogAttribute(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchRemoveCatalogAttributesTest() throws Exception {
    BatchRemoveCatalogAttributesResponse expectedResponse =
        BatchRemoveCatalogAttributesResponse.newBuilder()
            .addAllDeletedCatalogAttributes(new ArrayList<String>())
            .addAllResetCatalogAttributes(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    BatchRemoveCatalogAttributesRequest request =
        BatchRemoveCatalogAttributesRequest.newBuilder()
            .setAttributesConfig(
                AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .addAllAttributeKeys(new ArrayList<String>())
            .build();

    BatchRemoveCatalogAttributesResponse actualResponse =
        client.batchRemoveCatalogAttributes(request);
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
  public void batchRemoveCatalogAttributesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BatchRemoveCatalogAttributesRequest request =
          BatchRemoveCatalogAttributesRequest.newBuilder()
              .setAttributesConfig(
                  AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .addAllAttributeKeys(new ArrayList<String>())
              .build();
      client.batchRemoveCatalogAttributes(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void replaceCatalogAttributeTest() throws Exception {
    AttributesConfig expectedResponse =
        AttributesConfig.newBuilder()
            .setName(AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .putAllCatalogAttributes(new HashMap<String, CatalogAttribute>())
            .setAttributeConfigLevel(AttributeConfigLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    ReplaceCatalogAttributeRequest request =
        ReplaceCatalogAttributeRequest.newBuilder()
            .setAttributesConfig(
                AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setCatalogAttribute(CatalogAttribute.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    AttributesConfig actualResponse = client.replaceCatalogAttribute(request);
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
  public void replaceCatalogAttributeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReplaceCatalogAttributeRequest request =
          ReplaceCatalogAttributeRequest.newBuilder()
              .setAttributesConfig(
                  AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setCatalogAttribute(CatalogAttribute.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.replaceCatalogAttribute(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
