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

package com.google.cloud.recommendationengine.v1beta1;

import static com.google.cloud.recommendationengine.v1beta1.CatalogServiceClient.ListCatalogItemsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.recommendationengine.v1beta1.stub.HttpJsonCatalogServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
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
  public void createCatalogItemTest() throws Exception {
    CatalogItem expectedResponse =
        CatalogItem.newBuilder()
            .setId("id3355")
            .addAllCategoryHierarchies(new ArrayList<CatalogItem.CategoryHierarchy>())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .setItemAttributes(FeatureMap.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .addAllTags(new ArrayList<String>())
            .setItemGroupId("itemGroupId-240489113")
            .build();
    mockService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
    CatalogItem catalogItem = CatalogItem.newBuilder().build();

    CatalogItem actualResponse = client.createCatalogItem(parent, catalogItem);
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
  public void createCatalogItemExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      CatalogItem catalogItem = CatalogItem.newBuilder().build();
      client.createCatalogItem(parent, catalogItem);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCatalogItemTest2() throws Exception {
    CatalogItem expectedResponse =
        CatalogItem.newBuilder()
            .setId("id3355")
            .addAllCategoryHierarchies(new ArrayList<CatalogItem.CategoryHierarchy>())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .setItemAttributes(FeatureMap.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .addAllTags(new ArrayList<String>())
            .setItemGroupId("itemGroupId-240489113")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";
    CatalogItem catalogItem = CatalogItem.newBuilder().build();

    CatalogItem actualResponse = client.createCatalogItem(parent, catalogItem);
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
  public void createCatalogItemExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";
      CatalogItem catalogItem = CatalogItem.newBuilder().build();
      client.createCatalogItem(parent, catalogItem);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCatalogItemTest() throws Exception {
    CatalogItem expectedResponse =
        CatalogItem.newBuilder()
            .setId("id3355")
            .addAllCategoryHierarchies(new ArrayList<CatalogItem.CategoryHierarchy>())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .setItemAttributes(FeatureMap.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .addAllTags(new ArrayList<String>())
            .setItemGroupId("itemGroupId-240489113")
            .build();
    mockService.addResponse(expectedResponse);

    CatalogItemPathName name =
        CatalogItemPathName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");

    CatalogItem actualResponse = client.getCatalogItem(name);
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
  public void getCatalogItemExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogItemPathName name =
          CatalogItemPathName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");
      client.getCatalogItem(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCatalogItemTest2() throws Exception {
    CatalogItem expectedResponse =
        CatalogItem.newBuilder()
            .setId("id3355")
            .addAllCategoryHierarchies(new ArrayList<CatalogItem.CategoryHierarchy>())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .setItemAttributes(FeatureMap.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .addAllTags(new ArrayList<String>())
            .setItemGroupId("itemGroupId-240489113")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1923/locations/location-1923/catalogs/catalog-1923/catalogItems/catalogItem-1923";

    CatalogItem actualResponse = client.getCatalogItem(name);
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
  public void getCatalogItemExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1923/locations/location-1923/catalogs/catalog-1923/catalogItems/catalogItem-1923";
      client.getCatalogItem(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCatalogItemsTest() throws Exception {
    CatalogItem responsesElement = CatalogItem.newBuilder().build();
    ListCatalogItemsResponse expectedResponse =
        ListCatalogItemsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogItems(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
    String filter = "filter-1274492040";

    ListCatalogItemsPagedResponse pagedListResponse = client.listCatalogItems(parent, filter);

    List<CatalogItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogItemsList().get(0), resources.get(0));

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
  public void listCatalogItemsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      String filter = "filter-1274492040";
      client.listCatalogItems(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCatalogItemsTest2() throws Exception {
    CatalogItem responsesElement = CatalogItem.newBuilder().build();
    ListCatalogItemsResponse expectedResponse =
        ListCatalogItemsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogItems(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";
    String filter = "filter-1274492040";

    ListCatalogItemsPagedResponse pagedListResponse = client.listCatalogItems(parent, filter);

    List<CatalogItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogItemsList().get(0), resources.get(0));

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
  public void listCatalogItemsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";
      String filter = "filter-1274492040";
      client.listCatalogItems(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCatalogItemTest() throws Exception {
    CatalogItem expectedResponse =
        CatalogItem.newBuilder()
            .setId("id3355")
            .addAllCategoryHierarchies(new ArrayList<CatalogItem.CategoryHierarchy>())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .setItemAttributes(FeatureMap.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .addAllTags(new ArrayList<String>())
            .setItemGroupId("itemGroupId-240489113")
            .build();
    mockService.addResponse(expectedResponse);

    CatalogItemPathName name =
        CatalogItemPathName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");
    CatalogItem catalogItem = CatalogItem.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CatalogItem actualResponse = client.updateCatalogItem(name, catalogItem, updateMask);
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
  public void updateCatalogItemExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogItemPathName name =
          CatalogItemPathName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");
      CatalogItem catalogItem = CatalogItem.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCatalogItem(name, catalogItem, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCatalogItemTest2() throws Exception {
    CatalogItem expectedResponse =
        CatalogItem.newBuilder()
            .setId("id3355")
            .addAllCategoryHierarchies(new ArrayList<CatalogItem.CategoryHierarchy>())
            .setTitle("title110371416")
            .setDescription("description-1724546052")
            .setItemAttributes(FeatureMap.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .addAllTags(new ArrayList<String>())
            .setItemGroupId("itemGroupId-240489113")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1923/locations/location-1923/catalogs/catalog-1923/catalogItems/catalogItem-1923";
    CatalogItem catalogItem = CatalogItem.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CatalogItem actualResponse = client.updateCatalogItem(name, catalogItem, updateMask);
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
  public void updateCatalogItemExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1923/locations/location-1923/catalogs/catalog-1923/catalogItems/catalogItem-1923";
      CatalogItem catalogItem = CatalogItem.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCatalogItem(name, catalogItem, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCatalogItemTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    CatalogItemPathName name =
        CatalogItemPathName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");

    client.deleteCatalogItem(name);

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
  public void deleteCatalogItemExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogItemPathName name =
          CatalogItemPathName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");
      client.deleteCatalogItem(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCatalogItemTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1923/locations/location-1923/catalogs/catalog-1923/catalogItems/catalogItem-1923";

    client.deleteCatalogItem(name);

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
  public void deleteCatalogItemExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1923/locations/location-1923/catalogs/catalog-1923/catalogItems/catalogItem-1923";
      client.deleteCatalogItem(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importCatalogItemsTest() throws Exception {
    ImportCatalogItemsResponse expectedResponse =
        ImportCatalogItemsResponse.newBuilder()
            .addAllErrorSamples(new ArrayList<Status>())
            .setErrorsConfig(ImportErrorsConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importCatalogItemsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
    String requestId = "requestId693933066";
    InputConfig inputConfig = InputConfig.newBuilder().build();
    ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();

    ImportCatalogItemsResponse actualResponse =
        client.importCatalogItemsAsync(parent, requestId, inputConfig, errorsConfig).get();
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
  public void importCatalogItemsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      String requestId = "requestId693933066";
      InputConfig inputConfig = InputConfig.newBuilder().build();
      ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();
      client.importCatalogItemsAsync(parent, requestId, inputConfig, errorsConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void importCatalogItemsTest2() throws Exception {
    ImportCatalogItemsResponse expectedResponse =
        ImportCatalogItemsResponse.newBuilder()
            .addAllErrorSamples(new ArrayList<Status>())
            .setErrorsConfig(ImportErrorsConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importCatalogItemsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";
    String requestId = "requestId693933066";
    InputConfig inputConfig = InputConfig.newBuilder().build();
    ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();

    ImportCatalogItemsResponse actualResponse =
        client.importCatalogItemsAsync(parent, requestId, inputConfig, errorsConfig).get();
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
  public void importCatalogItemsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";
      String requestId = "requestId693933066";
      InputConfig inputConfig = InputConfig.newBuilder().build();
      ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();
      client.importCatalogItemsAsync(parent, requestId, inputConfig, errorsConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
