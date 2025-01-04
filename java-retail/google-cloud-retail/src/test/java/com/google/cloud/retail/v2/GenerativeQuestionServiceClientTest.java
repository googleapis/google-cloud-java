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

package com.google.cloud.retail.v2;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
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
public class GenerativeQuestionServiceClientTest {
  private static MockGenerativeQuestionService mockGenerativeQuestionService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private GenerativeQuestionServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockGenerativeQuestionService = new MockGenerativeQuestionService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockGenerativeQuestionService, mockLocations));
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
    GenerativeQuestionServiceSettings settings =
        GenerativeQuestionServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GenerativeQuestionServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void updateGenerativeQuestionsFeatureConfigTest() throws Exception {
    GenerativeQuestionsFeatureConfig expectedResponse =
        GenerativeQuestionsFeatureConfig.newBuilder()
            .setCatalog("catalog555704345")
            .setFeatureEnabled(true)
            .setMinimumProducts(-417095051)
            .build();
    mockGenerativeQuestionService.addResponse(expectedResponse);

    GenerativeQuestionsFeatureConfig generativeQuestionsFeatureConfig =
        GenerativeQuestionsFeatureConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GenerativeQuestionsFeatureConfig actualResponse =
        client.updateGenerativeQuestionsFeatureConfig(generativeQuestionsFeatureConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenerativeQuestionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGenerativeQuestionsFeatureConfigRequest actualRequest =
        ((UpdateGenerativeQuestionsFeatureConfigRequest) actualRequests.get(0));

    Assert.assertEquals(
        generativeQuestionsFeatureConfig, actualRequest.getGenerativeQuestionsFeatureConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGenerativeQuestionsFeatureConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenerativeQuestionService.addException(exception);

    try {
      GenerativeQuestionsFeatureConfig generativeQuestionsFeatureConfig =
          GenerativeQuestionsFeatureConfig.newBuilder().build();
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
    mockGenerativeQuestionService.addResponse(expectedResponse);

    CatalogName catalog = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    GenerativeQuestionsFeatureConfig actualResponse =
        client.getGenerativeQuestionsFeatureConfig(catalog);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenerativeQuestionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGenerativeQuestionsFeatureConfigRequest actualRequest =
        ((GetGenerativeQuestionsFeatureConfigRequest) actualRequests.get(0));

    Assert.assertEquals(catalog.toString(), actualRequest.getCatalog());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGenerativeQuestionsFeatureConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenerativeQuestionService.addException(exception);

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
    mockGenerativeQuestionService.addResponse(expectedResponse);

    String catalog = "catalog555704345";

    GenerativeQuestionsFeatureConfig actualResponse =
        client.getGenerativeQuestionsFeatureConfig(catalog);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenerativeQuestionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGenerativeQuestionsFeatureConfigRequest actualRequest =
        ((GetGenerativeQuestionsFeatureConfigRequest) actualRequests.get(0));

    Assert.assertEquals(catalog, actualRequest.getCatalog());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGenerativeQuestionsFeatureConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenerativeQuestionService.addException(exception);

    try {
      String catalog = "catalog555704345";
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
    mockGenerativeQuestionService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    ListGenerativeQuestionConfigsResponse actualResponse =
        client.listGenerativeQuestionConfigs(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenerativeQuestionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGenerativeQuestionConfigsRequest actualRequest =
        ((ListGenerativeQuestionConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGenerativeQuestionConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenerativeQuestionService.addException(exception);

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
    mockGenerativeQuestionService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGenerativeQuestionConfigsResponse actualResponse =
        client.listGenerativeQuestionConfigs(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenerativeQuestionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGenerativeQuestionConfigsRequest actualRequest =
        ((ListGenerativeQuestionConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGenerativeQuestionConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenerativeQuestionService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockGenerativeQuestionService.addResponse(expectedResponse);

    GenerativeQuestionConfig generativeQuestionConfig =
        GenerativeQuestionConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GenerativeQuestionConfig actualResponse =
        client.updateGenerativeQuestionConfig(generativeQuestionConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenerativeQuestionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGenerativeQuestionConfigRequest actualRequest =
        ((UpdateGenerativeQuestionConfigRequest) actualRequests.get(0));

    Assert.assertEquals(generativeQuestionConfig, actualRequest.getGenerativeQuestionConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGenerativeQuestionConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenerativeQuestionService.addException(exception);

    try {
      GenerativeQuestionConfig generativeQuestionConfig =
          GenerativeQuestionConfig.newBuilder().build();
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
    mockGenerativeQuestionService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
    List<UpdateGenerativeQuestionConfigRequest> requests = new ArrayList<>();

    BatchUpdateGenerativeQuestionConfigsResponse actualResponse =
        client.batchUpdateGenerativeQuestionConfigs(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenerativeQuestionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdateGenerativeQuestionConfigsRequest actualRequest =
        ((BatchUpdateGenerativeQuestionConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchUpdateGenerativeQuestionConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenerativeQuestionService.addException(exception);

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
    mockGenerativeQuestionService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<UpdateGenerativeQuestionConfigRequest> requests = new ArrayList<>();

    BatchUpdateGenerativeQuestionConfigsResponse actualResponse =
        client.batchUpdateGenerativeQuestionConfigs(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGenerativeQuestionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdateGenerativeQuestionConfigsRequest actualRequest =
        ((BatchUpdateGenerativeQuestionConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchUpdateGenerativeQuestionConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGenerativeQuestionService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<UpdateGenerativeQuestionConfigRequest> requests = new ArrayList<>();
      client.batchUpdateGenerativeQuestionConfigs(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
