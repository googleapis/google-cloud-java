/*
 * Copyright 2020 Google LLC
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
import com.google.protobuf.FieldMask;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class CatalogServiceClientTest {
  private static MockCatalogService mockCatalogService;
  private static MockServiceHelper mockServiceHelper;
  private CatalogServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockCatalogService = new MockCatalogService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCatalogService));
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
    mockCatalogService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
    CatalogItem catalogItem = CatalogItem.newBuilder().build();

    CatalogItem actualResponse = client.createCatalogItem(parent, catalogItem);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCatalogItemRequest actualRequest = ((CreateCatalogItemRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(catalogItem, actualRequest.getCatalogItem());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCatalogItemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

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
    mockCatalogService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    CatalogItem catalogItem = CatalogItem.newBuilder().build();

    CatalogItem actualResponse = client.createCatalogItem(parent, catalogItem);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCatalogItemRequest actualRequest = ((CreateCatalogItemRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(catalogItem, actualRequest.getCatalogItem());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCatalogItemExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockCatalogService.addResponse(expectedResponse);

    CatalogItemPathName name =
        CatalogItemPathName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");

    CatalogItem actualResponse = client.getCatalogItem(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCatalogItemRequest actualRequest = ((GetCatalogItemRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCatalogItemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

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
    mockCatalogService.addResponse(expectedResponse);

    String name = "name3373707";

    CatalogItem actualResponse = client.getCatalogItem(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCatalogItemRequest actualRequest = ((GetCatalogItemRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCatalogItemExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String name = "name3373707";
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
    mockCatalogService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
    String filter = "filter-1274492040";

    ListCatalogItemsPagedResponse pagedListResponse = client.listCatalogItems(parent, filter);

    List<CatalogItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogItemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCatalogItemsRequest actualRequest = ((ListCatalogItemsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCatalogItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

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
    mockCatalogService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";

    ListCatalogItemsPagedResponse pagedListResponse = client.listCatalogItems(parent, filter);

    List<CatalogItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogItemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCatalogItemsRequest actualRequest = ((ListCatalogItemsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCatalogItemsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockCatalogService.addResponse(expectedResponse);

    CatalogItemPathName name =
        CatalogItemPathName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");
    CatalogItem catalogItem = CatalogItem.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CatalogItem actualResponse = client.updateCatalogItem(name, catalogItem, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCatalogItemRequest actualRequest = ((UpdateCatalogItemRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(catalogItem, actualRequest.getCatalogItem());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCatalogItemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

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
    mockCatalogService.addResponse(expectedResponse);

    String name = "name3373707";
    CatalogItem catalogItem = CatalogItem.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CatalogItem actualResponse = client.updateCatalogItem(name, catalogItem, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCatalogItemRequest actualRequest = ((UpdateCatalogItemRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(catalogItem, actualRequest.getCatalogItem());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCatalogItemExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String name = "name3373707";
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
    mockCatalogService.addResponse(expectedResponse);

    CatalogItemPathName name =
        CatalogItemPathName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");

    client.deleteCatalogItem(name);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCatalogItemRequest actualRequest = ((DeleteCatalogItemRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCatalogItemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

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
    mockCatalogService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteCatalogItem(name);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCatalogItemRequest actualRequest = ((DeleteCatalogItemRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCatalogItemExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String name = "name3373707";
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
    mockCatalogService.addResponse(resultOperation);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
    String requestId = "requestId693933066";
    InputConfig inputConfig = InputConfig.newBuilder().build();
    ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();

    ImportCatalogItemsResponse actualResponse =
        client.importCatalogItemsAsync(parent, requestId, inputConfig, errorsConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportCatalogItemsRequest actualRequest = ((ImportCatalogItemsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(requestId, actualRequest.getRequestId());
    Assert.assertEquals(inputConfig, actualRequest.getInputConfig());
    Assert.assertEquals(errorsConfig, actualRequest.getErrorsConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importCatalogItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      String requestId = "requestId693933066";
      InputConfig inputConfig = InputConfig.newBuilder().build();
      ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();
      client.importCatalogItemsAsync(parent, requestId, inputConfig, errorsConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockCatalogService.addResponse(resultOperation);

    String parent = "parent-995424086";
    String requestId = "requestId693933066";
    InputConfig inputConfig = InputConfig.newBuilder().build();
    ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();

    ImportCatalogItemsResponse actualResponse =
        client.importCatalogItemsAsync(parent, requestId, inputConfig, errorsConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportCatalogItemsRequest actualRequest = ((ImportCatalogItemsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(requestId, actualRequest.getRequestId());
    Assert.assertEquals(inputConfig, actualRequest.getInputConfig());
    Assert.assertEquals(errorsConfig, actualRequest.getErrorsConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importCatalogItemsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String parent = "parent-995424086";
      String requestId = "requestId693933066";
      InputConfig inputConfig = InputConfig.newBuilder().build();
      ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();
      client.importCatalogItemsAsync(parent, requestId, inputConfig, errorsConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
