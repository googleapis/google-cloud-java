/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.discoveryengine.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class WidgetConfigServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockWidgetConfigService mockWidgetConfigService;
  private LocalChannelProvider channelProvider;
  private WidgetConfigServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockWidgetConfigService = new MockWidgetConfigService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockWidgetConfigService, mockLocations));
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
    WidgetConfigServiceSettings settings =
        WidgetConfigServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WidgetConfigServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getWidgetConfigTest() throws Exception {
    WidgetConfig expectedResponse =
        WidgetConfig.newBuilder()
            .setName(
                WidgetConfigName.ofProjectLocationDataStoreWidgetConfigName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[WIDGET_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setConfigId("configId-580140035")
            .setSolutionType(SolutionType.forNumber(0))
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .setLlmEnabled(true)
            .setEnableResultScore(true)
            .setMinimumDataTermAccepted(true)
            .addAllCollectionComponents(new ArrayList<WidgetConfig.CollectionComponent>())
            .setUiSettings(WidgetConfig.UiSettings.newBuilder().build())
            .setAccessSettings(WidgetConfig.AccessSettings.newBuilder().build())
            .setUiBranding(WidgetConfig.UiBrandingSettings.newBuilder().build())
            .setHomepageSetting(WidgetConfig.HomepageSetting.newBuilder().build())
            .setAssistantSettings(WidgetConfig.AssistantSettings.newBuilder().build())
            .setCustomerProvidedConfig(WidgetConfig.CustomerProvidedConfig.newBuilder().build())
            .setEnablePrivateKnowledgeGraph(true)
            .setGeminiBundle(true)
            .addAllBatchAuthStatuses(new ArrayList<WidgetConfig.BatchAuthStatus>())
            .addAllNodes(new ArrayList<WidgetConfig.Node>())
            .build();
    mockWidgetConfigService.addResponse(expectedResponse);

    WidgetConfigName name =
        WidgetConfigName.ofProjectLocationDataStoreWidgetConfigName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[WIDGET_CONFIG]");

    WidgetConfig actualResponse = client.getWidgetConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWidgetConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWidgetConfigRequest actualRequest = ((GetWidgetConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWidgetConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWidgetConfigService.addException(exception);

    try {
      WidgetConfigName name =
          WidgetConfigName.ofProjectLocationDataStoreWidgetConfigName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[WIDGET_CONFIG]");
      client.getWidgetConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWidgetConfigTest2() throws Exception {
    WidgetConfig expectedResponse =
        WidgetConfig.newBuilder()
            .setName(
                WidgetConfigName.ofProjectLocationDataStoreWidgetConfigName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[WIDGET_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setConfigId("configId-580140035")
            .setSolutionType(SolutionType.forNumber(0))
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .setLlmEnabled(true)
            .setEnableResultScore(true)
            .setMinimumDataTermAccepted(true)
            .addAllCollectionComponents(new ArrayList<WidgetConfig.CollectionComponent>())
            .setUiSettings(WidgetConfig.UiSettings.newBuilder().build())
            .setAccessSettings(WidgetConfig.AccessSettings.newBuilder().build())
            .setUiBranding(WidgetConfig.UiBrandingSettings.newBuilder().build())
            .setHomepageSetting(WidgetConfig.HomepageSetting.newBuilder().build())
            .setAssistantSettings(WidgetConfig.AssistantSettings.newBuilder().build())
            .setCustomerProvidedConfig(WidgetConfig.CustomerProvidedConfig.newBuilder().build())
            .setEnablePrivateKnowledgeGraph(true)
            .setGeminiBundle(true)
            .addAllBatchAuthStatuses(new ArrayList<WidgetConfig.BatchAuthStatus>())
            .addAllNodes(new ArrayList<WidgetConfig.Node>())
            .build();
    mockWidgetConfigService.addResponse(expectedResponse);

    String name = "name3373707";

    WidgetConfig actualResponse = client.getWidgetConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWidgetConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWidgetConfigRequest actualRequest = ((GetWidgetConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWidgetConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWidgetConfigService.addException(exception);

    try {
      String name = "name3373707";
      client.getWidgetConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateWidgetConfigTest() throws Exception {
    WidgetConfig expectedResponse =
        WidgetConfig.newBuilder()
            .setName(
                WidgetConfigName.ofProjectLocationDataStoreWidgetConfigName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[WIDGET_CONFIG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setConfigId("configId-580140035")
            .setSolutionType(SolutionType.forNumber(0))
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .setLlmEnabled(true)
            .setEnableResultScore(true)
            .setMinimumDataTermAccepted(true)
            .addAllCollectionComponents(new ArrayList<WidgetConfig.CollectionComponent>())
            .setUiSettings(WidgetConfig.UiSettings.newBuilder().build())
            .setAccessSettings(WidgetConfig.AccessSettings.newBuilder().build())
            .setUiBranding(WidgetConfig.UiBrandingSettings.newBuilder().build())
            .setHomepageSetting(WidgetConfig.HomepageSetting.newBuilder().build())
            .setAssistantSettings(WidgetConfig.AssistantSettings.newBuilder().build())
            .setCustomerProvidedConfig(WidgetConfig.CustomerProvidedConfig.newBuilder().build())
            .setEnablePrivateKnowledgeGraph(true)
            .setGeminiBundle(true)
            .addAllBatchAuthStatuses(new ArrayList<WidgetConfig.BatchAuthStatus>())
            .addAllNodes(new ArrayList<WidgetConfig.Node>())
            .build();
    mockWidgetConfigService.addResponse(expectedResponse);

    WidgetConfig widgetConfig = WidgetConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    WidgetConfig actualResponse = client.updateWidgetConfig(widgetConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWidgetConfigService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateWidgetConfigRequest actualRequest = ((UpdateWidgetConfigRequest) actualRequests.get(0));

    Assert.assertEquals(widgetConfig, actualRequest.getWidgetConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateWidgetConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWidgetConfigService.addException(exception);

    try {
      WidgetConfig widgetConfig = WidgetConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWidgetConfig(widgetConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
