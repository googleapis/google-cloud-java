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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class CatalogServiceClientTest {
  private static MockCatalogService mockCatalogService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CatalogServiceClient client;

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
  public void listCatalogsTest() throws Exception {
    Catalog responsesElement = Catalog.newBuilder().build();
    ListCatalogsResponse expectedResponse =
        ListCatalogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCatalogs(Arrays.asList(responsesElement))
            .build();
    mockCatalogService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCatalogsPagedResponse pagedListResponse = client.listCatalogs(parent);

    List<Catalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCatalogsRequest actualRequest = ((ListCatalogsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCatalogsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

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
    mockCatalogService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCatalogsPagedResponse pagedListResponse = client.listCatalogs(parent);

    List<Catalog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCatalogsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCatalogsRequest actualRequest = ((ListCatalogsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCatalogsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockCatalogService.addResponse(expectedResponse);

    Catalog catalog = Catalog.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Catalog actualResponse = client.updateCatalog(catalog, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCatalogRequest actualRequest = ((UpdateCatalogRequest) actualRequests.get(0));

    Assert.assertEquals(catalog, actualRequest.getCatalog());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCatalogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      Catalog catalog = Catalog.newBuilder().build();
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
    mockCatalogService.addResponse(expectedResponse);

    CatalogName catalog = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    client.setDefaultBranch(catalog);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetDefaultBranchRequest actualRequest = ((SetDefaultBranchRequest) actualRequests.get(0));

    Assert.assertEquals(catalog.toString(), actualRequest.getCatalog());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setDefaultBranchExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

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
    mockCatalogService.addResponse(expectedResponse);

    String catalog = "catalog555704345";

    client.setDefaultBranch(catalog);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetDefaultBranchRequest actualRequest = ((SetDefaultBranchRequest) actualRequests.get(0));

    Assert.assertEquals(catalog, actualRequest.getCatalog());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setDefaultBranchExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String catalog = "catalog555704345";
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
    mockCatalogService.addResponse(expectedResponse);

    CatalogName catalog = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    GetDefaultBranchResponse actualResponse = client.getDefaultBranch(catalog);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDefaultBranchRequest actualRequest = ((GetDefaultBranchRequest) actualRequests.get(0));

    Assert.assertEquals(catalog.toString(), actualRequest.getCatalog());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDefaultBranchExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

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
    mockCatalogService.addResponse(expectedResponse);

    String catalog = "catalog555704345";

    GetDefaultBranchResponse actualResponse = client.getDefaultBranch(catalog);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDefaultBranchRequest actualRequest = ((GetDefaultBranchRequest) actualRequests.get(0));

    Assert.assertEquals(catalog, actualRequest.getCatalog());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDefaultBranchExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String catalog = "catalog555704345";
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
    mockCatalogService.addResponse(expectedResponse);

    CompletionConfigName name = CompletionConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    CompletionConfig actualResponse = client.getCompletionConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCompletionConfigRequest actualRequest = ((GetCompletionConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCompletionConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

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
    mockCatalogService.addResponse(expectedResponse);

    String name = "name3373707";

    CompletionConfig actualResponse = client.getCompletionConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCompletionConfigRequest actualRequest = ((GetCompletionConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCompletionConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String name = "name3373707";
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
    mockCatalogService.addResponse(expectedResponse);

    CompletionConfig completionConfig = CompletionConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CompletionConfig actualResponse = client.updateCompletionConfig(completionConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCompletionConfigRequest actualRequest =
        ((UpdateCompletionConfigRequest) actualRequests.get(0));

    Assert.assertEquals(completionConfig, actualRequest.getCompletionConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCompletionConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      CompletionConfig completionConfig = CompletionConfig.newBuilder().build();
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
    mockCatalogService.addResponse(expectedResponse);

    AttributesConfigName name = AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    AttributesConfig actualResponse = client.getAttributesConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAttributesConfigRequest actualRequest = ((GetAttributesConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAttributesConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

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
    mockCatalogService.addResponse(expectedResponse);

    String name = "name3373707";

    AttributesConfig actualResponse = client.getAttributesConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAttributesConfigRequest actualRequest = ((GetAttributesConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAttributesConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String name = "name3373707";
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
    mockCatalogService.addResponse(expectedResponse);

    AttributesConfig attributesConfig = AttributesConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AttributesConfig actualResponse = client.updateAttributesConfig(attributesConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAttributesConfigRequest actualRequest =
        ((UpdateAttributesConfigRequest) actualRequests.get(0));

    Assert.assertEquals(attributesConfig, actualRequest.getAttributesConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAttributesConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      AttributesConfig attributesConfig = AttributesConfig.newBuilder().build();
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
    mockCatalogService.addResponse(expectedResponse);

    AddCatalogAttributeRequest request =
        AddCatalogAttributeRequest.newBuilder()
            .setAttributesConfig(
                AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setCatalogAttribute(CatalogAttribute.newBuilder().build())
            .build();

    AttributesConfig actualResponse = client.addCatalogAttribute(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddCatalogAttributeRequest actualRequest = ((AddCatalogAttributeRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAttributesConfig(), actualRequest.getAttributesConfig());
    Assert.assertEquals(request.getCatalogAttribute(), actualRequest.getCatalogAttribute());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addCatalogAttributeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

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
    mockCatalogService.addResponse(expectedResponse);

    RemoveCatalogAttributeRequest request =
        RemoveCatalogAttributeRequest.newBuilder()
            .setAttributesConfig(
                AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setKey("key106079")
            .build();

    AttributesConfig actualResponse = client.removeCatalogAttribute(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveCatalogAttributeRequest actualRequest =
        ((RemoveCatalogAttributeRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAttributesConfig(), actualRequest.getAttributesConfig());
    Assert.assertEquals(request.getKey(), actualRequest.getKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeCatalogAttributeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

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
  public void replaceCatalogAttributeTest() throws Exception {
    AttributesConfig expectedResponse =
        AttributesConfig.newBuilder()
            .setName(AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .putAllCatalogAttributes(new HashMap<String, CatalogAttribute>())
            .setAttributeConfigLevel(AttributeConfigLevel.forNumber(0))
            .build();
    mockCatalogService.addResponse(expectedResponse);

    ReplaceCatalogAttributeRequest request =
        ReplaceCatalogAttributeRequest.newBuilder()
            .setAttributesConfig(
                AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setCatalogAttribute(CatalogAttribute.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    AttributesConfig actualResponse = client.replaceCatalogAttribute(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReplaceCatalogAttributeRequest actualRequest =
        ((ReplaceCatalogAttributeRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAttributesConfig(), actualRequest.getAttributesConfig());
    Assert.assertEquals(request.getCatalogAttribute(), actualRequest.getCatalogAttribute());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void replaceCatalogAttributeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

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
