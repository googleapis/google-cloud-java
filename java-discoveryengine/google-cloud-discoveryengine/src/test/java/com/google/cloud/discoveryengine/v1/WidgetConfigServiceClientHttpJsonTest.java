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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1.stub.HttpJsonWidgetConfigServiceStub;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class WidgetConfigServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static WidgetConfigServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonWidgetConfigServiceStub.getMethodDescriptors(),
            WidgetConfigServiceSettings.getDefaultEndpoint());
    WidgetConfigServiceSettings settings =
        WidgetConfigServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                WidgetConfigServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WidgetConfigServiceClient.create(settings);
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
    mockService.addResponse(expectedResponse);

    WidgetConfigName name =
        WidgetConfigName.ofProjectLocationDataStoreWidgetConfigName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[WIDGET_CONFIG]");

    WidgetConfig actualResponse = client.getWidgetConfig(name);
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
  public void getWidgetConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9787/locations/location-9787/dataStores/dataStore-9787/widgetConfigs/widgetConfig-9787";

    WidgetConfig actualResponse = client.getWidgetConfig(name);
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
  public void getWidgetConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9787/locations/location-9787/dataStores/dataStore-9787/widgetConfigs/widgetConfig-9787";
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
    mockService.addResponse(expectedResponse);

    WidgetConfig widgetConfig =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    WidgetConfig actualResponse = client.updateWidgetConfig(widgetConfig, updateMask);
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
  public void updateWidgetConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      WidgetConfig widgetConfig =
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateWidgetConfig(widgetConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
