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
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class ServingConfigServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockServingConfigService mockServingConfigService;
  private LocalChannelProvider channelProvider;
  private ServingConfigServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockServingConfigService = new MockServingConfigService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockServingConfigService));
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
    ServingConfigServiceSettings settings =
        ServingConfigServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ServingConfigServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockServingConfigService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
    ServingConfig servingConfig = ServingConfig.newBuilder().build();
    String servingConfigId = "servingConfigId-831052759";

    ServingConfig actualResponse =
        client.createServingConfig(parent, servingConfig, servingConfigId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServingConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServingConfigRequest actualRequest = ((CreateServingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(servingConfig, actualRequest.getServingConfig());
    Assert.assertEquals(servingConfigId, actualRequest.getServingConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServingConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServingConfigService.addException(exception);

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
    mockServingConfigService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ServingConfig servingConfig = ServingConfig.newBuilder().build();
    String servingConfigId = "servingConfigId-831052759";

    ServingConfig actualResponse =
        client.createServingConfig(parent, servingConfig, servingConfigId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServingConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateServingConfigRequest actualRequest = ((CreateServingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(servingConfig, actualRequest.getServingConfig());
    Assert.assertEquals(servingConfigId, actualRequest.getServingConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createServingConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServingConfigService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockServingConfigService.addResponse(expectedResponse);

    ServingConfigName name =
        ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]");

    client.deleteServingConfig(name);

    List<AbstractMessage> actualRequests = mockServingConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServingConfigRequest actualRequest = ((DeleteServingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServingConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServingConfigService.addException(exception);

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
    mockServingConfigService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteServingConfig(name);

    List<AbstractMessage> actualRequests = mockServingConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteServingConfigRequest actualRequest = ((DeleteServingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteServingConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServingConfigService.addException(exception);

    try {
      String name = "name3373707";
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
    mockServingConfigService.addResponse(expectedResponse);

    ServingConfig servingConfig = ServingConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ServingConfig actualResponse = client.updateServingConfig(servingConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServingConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateServingConfigRequest actualRequest = ((UpdateServingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(servingConfig, actualRequest.getServingConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateServingConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServingConfigService.addException(exception);

    try {
      ServingConfig servingConfig = ServingConfig.newBuilder().build();
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
    mockServingConfigService.addResponse(expectedResponse);

    ServingConfigName name =
        ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]");

    ServingConfig actualResponse = client.getServingConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServingConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServingConfigRequest actualRequest = ((GetServingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServingConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServingConfigService.addException(exception);

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
    mockServingConfigService.addResponse(expectedResponse);

    String name = "name3373707";

    ServingConfig actualResponse = client.getServingConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServingConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServingConfigRequest actualRequest = ((GetServingConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServingConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServingConfigService.addException(exception);

    try {
      String name = "name3373707";
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
    mockServingConfigService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    ListServingConfigsPagedResponse pagedListResponse = client.listServingConfigs(parent);

    List<ServingConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServingConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServingConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServingConfigsRequest actualRequest = ((ListServingConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServingConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServingConfigService.addException(exception);

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
    mockServingConfigService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListServingConfigsPagedResponse pagedListResponse = client.listServingConfigs(parent);

    List<ServingConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getServingConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockServingConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListServingConfigsRequest actualRequest = ((ListServingConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listServingConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServingConfigService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockServingConfigService.addResponse(expectedResponse);

    ServingConfigName servingConfig =
        ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]");

    ServingConfig actualResponse = client.addControl(servingConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServingConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddControlRequest actualRequest = ((AddControlRequest) actualRequests.get(0));

    Assert.assertEquals(servingConfig.toString(), actualRequest.getServingConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addControlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServingConfigService.addException(exception);

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
    mockServingConfigService.addResponse(expectedResponse);

    String servingConfig = "servingConfig1237122670";

    ServingConfig actualResponse = client.addControl(servingConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServingConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddControlRequest actualRequest = ((AddControlRequest) actualRequests.get(0));

    Assert.assertEquals(servingConfig, actualRequest.getServingConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addControlExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServingConfigService.addException(exception);

    try {
      String servingConfig = "servingConfig1237122670";
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
    mockServingConfigService.addResponse(expectedResponse);

    ServingConfigName servingConfig =
        ServingConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[SERVING_CONFIG]");

    ServingConfig actualResponse = client.removeControl(servingConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServingConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveControlRequest actualRequest = ((RemoveControlRequest) actualRequests.get(0));

    Assert.assertEquals(servingConfig.toString(), actualRequest.getServingConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeControlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServingConfigService.addException(exception);

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
    mockServingConfigService.addResponse(expectedResponse);

    String servingConfig = "servingConfig1237122670";

    ServingConfig actualResponse = client.removeControl(servingConfig);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockServingConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveControlRequest actualRequest = ((RemoveControlRequest) actualRequests.get(0));

    Assert.assertEquals(servingConfig, actualRequest.getServingConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeControlExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockServingConfigService.addException(exception);

    try {
      String servingConfig = "servingConfig1237122670";
      client.removeControl(servingConfig);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
