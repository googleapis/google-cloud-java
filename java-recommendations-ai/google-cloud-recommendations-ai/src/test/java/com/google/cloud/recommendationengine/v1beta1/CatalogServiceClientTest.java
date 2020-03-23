/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class CatalogServiceClientTest {
  private static MockCatalogService mockCatalogService;
  private static MockPredictionApiKeyRegistry mockPredictionApiKeyRegistry;
  private static MockPredictionService mockPredictionService;
  private static MockUserEventService mockUserEventService;
  private static MockServiceHelper serviceHelper;
  private CatalogServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockCatalogService = new MockCatalogService();
    mockPredictionApiKeyRegistry = new MockPredictionApiKeyRegistry();
    mockPredictionService = new MockPredictionService();
    mockUserEventService = new MockUserEventService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockCatalogService,
                mockPredictionApiKeyRegistry,
                mockPredictionService,
                mockUserEventService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    CatalogServiceSettings settings =
        CatalogServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CatalogServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createCatalogItemTest() {
    String id = "id3355";
    String title = "title110371416";
    String description = "description-1724546052";
    String languageCode = "languageCode-412800396";
    String itemGroupId = "itemGroupId894431879";
    CatalogItem expectedResponse =
        CatalogItem.newBuilder()
            .setId(id)
            .setTitle(title)
            .setDescription(description)
            .setLanguageCode(languageCode)
            .setItemGroupId(itemGroupId)
            .build();
    mockCatalogService.addResponse(expectedResponse);

    String formattedParent =
        CatalogServiceClient.formatCatalogName("[PROJECT]", "[LOCATION]", "[CATALOG]");
    CatalogItem catalogItem = CatalogItem.newBuilder().build();

    CatalogItem actualResponse = client.createCatalogItem(formattedParent, catalogItem);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCatalogItemRequest actualRequest = (CreateCatalogItemRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(catalogItem, actualRequest.getCatalogItem());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createCatalogItemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String formattedParent =
          CatalogServiceClient.formatCatalogName("[PROJECT]", "[LOCATION]", "[CATALOG]");
      CatalogItem catalogItem = CatalogItem.newBuilder().build();

      client.createCatalogItem(formattedParent, catalogItem);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getCatalogItemTest() {
    String id = "id3355";
    String title = "title110371416";
    String description = "description-1724546052";
    String languageCode = "languageCode-412800396";
    String itemGroupId = "itemGroupId894431879";
    CatalogItem expectedResponse =
        CatalogItem.newBuilder()
            .setId(id)
            .setTitle(title)
            .setDescription(description)
            .setLanguageCode(languageCode)
            .setItemGroupId(itemGroupId)
            .build();
    mockCatalogService.addResponse(expectedResponse);

    String formattedName =
        CatalogServiceClient.formatCatalogItemPathName(
            "[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");

    CatalogItem actualResponse = client.getCatalogItem(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCatalogItemRequest actualRequest = (GetCatalogItemRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getCatalogItemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String formattedName =
          CatalogServiceClient.formatCatalogItemPathName(
              "[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");

      client.getCatalogItem(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listCatalogItemsTest() {
    String nextPageToken = "";
    CatalogItem catalogItemsElement = CatalogItem.newBuilder().build();
    List<CatalogItem> catalogItems = Arrays.asList(catalogItemsElement);
    ListCatalogItemsResponse expectedResponse =
        ListCatalogItemsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllCatalogItems(catalogItems)
            .build();
    mockCatalogService.addResponse(expectedResponse);

    String formattedParent =
        CatalogServiceClient.formatCatalogName("[PROJECT]", "[LOCATION]", "[CATALOG]");
    String filter = "filter-1274492040";

    ListCatalogItemsPagedResponse pagedListResponse =
        client.listCatalogItems(formattedParent, filter);

    List<CatalogItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogItemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCatalogItemsRequest actualRequest = (ListCatalogItemsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listCatalogItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String formattedParent =
          CatalogServiceClient.formatCatalogName("[PROJECT]", "[LOCATION]", "[CATALOG]");
      String filter = "filter-1274492040";

      client.listCatalogItems(formattedParent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateCatalogItemTest() {
    String id = "id3355";
    String title = "title110371416";
    String description = "description-1724546052";
    String languageCode = "languageCode-412800396";
    String itemGroupId = "itemGroupId894431879";
    CatalogItem expectedResponse =
        CatalogItem.newBuilder()
            .setId(id)
            .setTitle(title)
            .setDescription(description)
            .setLanguageCode(languageCode)
            .setItemGroupId(itemGroupId)
            .build();
    mockCatalogService.addResponse(expectedResponse);

    String formattedName =
        CatalogServiceClient.formatCatalogItemPathName(
            "[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");
    CatalogItem catalogItem = CatalogItem.newBuilder().build();

    CatalogItem actualResponse = client.updateCatalogItem(formattedName, catalogItem);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCatalogItemRequest actualRequest = (UpdateCatalogItemRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(catalogItem, actualRequest.getCatalogItem());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateCatalogItemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String formattedName =
          CatalogServiceClient.formatCatalogItemPathName(
              "[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");
      CatalogItem catalogItem = CatalogItem.newBuilder().build();

      client.updateCatalogItem(formattedName, catalogItem);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteCatalogItemTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockCatalogService.addResponse(expectedResponse);

    String formattedName =
        CatalogServiceClient.formatCatalogItemPathName(
            "[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");

    client.deleteCatalogItem(formattedName);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCatalogItemRequest actualRequest = (DeleteCatalogItemRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteCatalogItemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String formattedName =
          CatalogServiceClient.formatCatalogItemPathName(
              "[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");

      client.deleteCatalogItem(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void importCatalogItemsTest() throws Exception {
    ImportCatalogItemsResponse expectedResponse = ImportCatalogItemsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importCatalogItemsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCatalogService.addResponse(resultOperation);

    String formattedParent =
        CatalogServiceClient.formatCatalogName("[PROJECT]", "[LOCATION]", "[CATALOG]");
    String requestId = "requestId37109963";
    InputConfig inputConfig = InputConfig.newBuilder().build();
    ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();

    ImportCatalogItemsResponse actualResponse =
        client.importCatalogItemsAsync(formattedParent, requestId, inputConfig, errorsConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportCatalogItemsRequest actualRequest = (ImportCatalogItemsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(requestId, actualRequest.getRequestId());
    Assert.assertEquals(inputConfig, actualRequest.getInputConfig());
    Assert.assertEquals(errorsConfig, actualRequest.getErrorsConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void importCatalogItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String formattedParent =
          CatalogServiceClient.formatCatalogName("[PROJECT]", "[LOCATION]", "[CATALOG]");
      String requestId = "requestId37109963";
      InputConfig inputConfig = InputConfig.newBuilder().build();
      ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();

      client.importCatalogItemsAsync(formattedParent, requestId, inputConfig, errorsConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
