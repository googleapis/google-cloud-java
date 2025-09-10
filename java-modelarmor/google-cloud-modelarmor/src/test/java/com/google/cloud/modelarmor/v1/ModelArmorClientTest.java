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

package com.google.cloud.modelarmor.v1;

import static com.google.cloud.modelarmor.v1.ModelArmorClient.ListLocationsPagedResponse;
import static com.google.cloud.modelarmor.v1.ModelArmorClient.ListTemplatesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class ModelArmorClientTest {
  private static MockLocations mockLocations;
  private static MockModelArmor mockModelArmor;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ModelArmorClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockModelArmor = new MockModelArmor();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockModelArmor, mockLocations));
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
    ModelArmorSettings settings =
        ModelArmorSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ModelArmorClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listTemplatesTest() throws Exception {
    Template responsesElement = Template.newBuilder().build();
    ListTemplatesResponse expectedResponse =
        ListTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTemplates(Arrays.asList(responsesElement))
            .build();
    mockModelArmor.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTemplatesPagedResponse pagedListResponse = client.listTemplates(parent);

    List<Template> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTemplatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelArmor.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTemplatesRequest actualRequest = ((ListTemplatesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTemplatesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelArmor.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTemplatesTest2() throws Exception {
    Template responsesElement = Template.newBuilder().build();
    ListTemplatesResponse expectedResponse =
        ListTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTemplates(Arrays.asList(responsesElement))
            .build();
    mockModelArmor.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTemplatesPagedResponse pagedListResponse = client.listTemplates(parent);

    List<Template> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTemplatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelArmor.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTemplatesRequest actualRequest = ((ListTemplatesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTemplatesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelArmor.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTemplateTest() throws Exception {
    Template expectedResponse =
        Template.newBuilder()
            .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFilterConfig(FilterConfig.newBuilder().build())
            .setTemplateMetadata(Template.TemplateMetadata.newBuilder().build())
            .build();
    mockModelArmor.addResponse(expectedResponse);

    TemplateName name = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");

    Template actualResponse = client.getTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelArmor.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTemplateRequest actualRequest = ((GetTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelArmor.addException(exception);

    try {
      TemplateName name = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");
      client.getTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTemplateTest2() throws Exception {
    Template expectedResponse =
        Template.newBuilder()
            .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFilterConfig(FilterConfig.newBuilder().build())
            .setTemplateMetadata(Template.TemplateMetadata.newBuilder().build())
            .build();
    mockModelArmor.addResponse(expectedResponse);

    String name = "name3373707";

    Template actualResponse = client.getTemplate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelArmor.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTemplateRequest actualRequest = ((GetTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelArmor.addException(exception);

    try {
      String name = "name3373707";
      client.getTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTemplateTest() throws Exception {
    Template expectedResponse =
        Template.newBuilder()
            .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFilterConfig(FilterConfig.newBuilder().build())
            .setTemplateMetadata(Template.TemplateMetadata.newBuilder().build())
            .build();
    mockModelArmor.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Template template = Template.newBuilder().build();
    String templateId = "templateId1304010549";

    Template actualResponse = client.createTemplate(parent, template, templateId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelArmor.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTemplateRequest actualRequest = ((CreateTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(template, actualRequest.getTemplate());
    Assert.assertEquals(templateId, actualRequest.getTemplateId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelArmor.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Template template = Template.newBuilder().build();
      String templateId = "templateId1304010549";
      client.createTemplate(parent, template, templateId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTemplateTest2() throws Exception {
    Template expectedResponse =
        Template.newBuilder()
            .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFilterConfig(FilterConfig.newBuilder().build())
            .setTemplateMetadata(Template.TemplateMetadata.newBuilder().build())
            .build();
    mockModelArmor.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Template template = Template.newBuilder().build();
    String templateId = "templateId1304010549";

    Template actualResponse = client.createTemplate(parent, template, templateId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelArmor.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTemplateRequest actualRequest = ((CreateTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(template, actualRequest.getTemplate());
    Assert.assertEquals(templateId, actualRequest.getTemplateId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelArmor.addException(exception);

    try {
      String parent = "parent-995424086";
      Template template = Template.newBuilder().build();
      String templateId = "templateId1304010549";
      client.createTemplate(parent, template, templateId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTemplateTest() throws Exception {
    Template expectedResponse =
        Template.newBuilder()
            .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setFilterConfig(FilterConfig.newBuilder().build())
            .setTemplateMetadata(Template.TemplateMetadata.newBuilder().build())
            .build();
    mockModelArmor.addResponse(expectedResponse);

    Template template = Template.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Template actualResponse = client.updateTemplate(template, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelArmor.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTemplateRequest actualRequest = ((UpdateTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(template, actualRequest.getTemplate());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelArmor.addException(exception);

    try {
      Template template = Template.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTemplate(template, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTemplateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockModelArmor.addResponse(expectedResponse);

    TemplateName name = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");

    client.deleteTemplate(name);

    List<AbstractMessage> actualRequests = mockModelArmor.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTemplateRequest actualRequest = ((DeleteTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelArmor.addException(exception);

    try {
      TemplateName name = TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]");
      client.deleteTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTemplateTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockModelArmor.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteTemplate(name);

    List<AbstractMessage> actualRequests = mockModelArmor.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTemplateRequest actualRequest = ((DeleteTemplateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTemplateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelArmor.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFloorSettingTest() throws Exception {
    FloorSetting expectedResponse =
        FloorSetting.newBuilder()
            .setName(FloorSettingName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFilterConfig(FilterConfig.newBuilder().build())
            .setEnableFloorSettingEnforcement(true)
            .addAllIntegratedServices(new ArrayList<FloorSetting.IntegratedService>())
            .setAiPlatformFloorSetting(AiPlatformFloorSetting.newBuilder().build())
            .setFloorSettingMetadata(FloorSetting.FloorSettingMetadata.newBuilder().build())
            .build();
    mockModelArmor.addResponse(expectedResponse);

    FloorSettingName name = FloorSettingName.ofProjectLocationName("[PROJECT]", "[LOCATION]");

    FloorSetting actualResponse = client.getFloorSetting(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelArmor.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFloorSettingRequest actualRequest = ((GetFloorSettingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFloorSettingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelArmor.addException(exception);

    try {
      FloorSettingName name = FloorSettingName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
      client.getFloorSetting(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFloorSettingTest2() throws Exception {
    FloorSetting expectedResponse =
        FloorSetting.newBuilder()
            .setName(FloorSettingName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFilterConfig(FilterConfig.newBuilder().build())
            .setEnableFloorSettingEnforcement(true)
            .addAllIntegratedServices(new ArrayList<FloorSetting.IntegratedService>())
            .setAiPlatformFloorSetting(AiPlatformFloorSetting.newBuilder().build())
            .setFloorSettingMetadata(FloorSetting.FloorSettingMetadata.newBuilder().build())
            .build();
    mockModelArmor.addResponse(expectedResponse);

    String name = "name3373707";

    FloorSetting actualResponse = client.getFloorSetting(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelArmor.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFloorSettingRequest actualRequest = ((GetFloorSettingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFloorSettingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelArmor.addException(exception);

    try {
      String name = "name3373707";
      client.getFloorSetting(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFloorSettingTest() throws Exception {
    FloorSetting expectedResponse =
        FloorSetting.newBuilder()
            .setName(FloorSettingName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFilterConfig(FilterConfig.newBuilder().build())
            .setEnableFloorSettingEnforcement(true)
            .addAllIntegratedServices(new ArrayList<FloorSetting.IntegratedService>())
            .setAiPlatformFloorSetting(AiPlatformFloorSetting.newBuilder().build())
            .setFloorSettingMetadata(FloorSetting.FloorSettingMetadata.newBuilder().build())
            .build();
    mockModelArmor.addResponse(expectedResponse);

    FloorSetting floorSetting = FloorSetting.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    FloorSetting actualResponse = client.updateFloorSetting(floorSetting, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelArmor.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFloorSettingRequest actualRequest = ((UpdateFloorSettingRequest) actualRequests.get(0));

    Assert.assertEquals(floorSetting, actualRequest.getFloorSetting());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFloorSettingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelArmor.addException(exception);

    try {
      FloorSetting floorSetting = FloorSetting.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFloorSetting(floorSetting, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void sanitizeUserPromptTest() throws Exception {
    SanitizeUserPromptResponse expectedResponse =
        SanitizeUserPromptResponse.newBuilder()
            .setSanitizationResult(SanitizationResult.newBuilder().build())
            .build();
    mockModelArmor.addResponse(expectedResponse);

    SanitizeUserPromptRequest request =
        SanitizeUserPromptRequest.newBuilder()
            .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .setUserPromptData(DataItem.newBuilder().build())
            .setMultiLanguageDetectionMetadata(MultiLanguageDetectionMetadata.newBuilder().build())
            .build();

    SanitizeUserPromptResponse actualResponse = client.sanitizeUserPrompt(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelArmor.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SanitizeUserPromptRequest actualRequest = ((SanitizeUserPromptRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getUserPromptData(), actualRequest.getUserPromptData());
    Assert.assertEquals(
        request.getMultiLanguageDetectionMetadata(),
        actualRequest.getMultiLanguageDetectionMetadata());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void sanitizeUserPromptExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelArmor.addException(exception);

    try {
      SanitizeUserPromptRequest request =
          SanitizeUserPromptRequest.newBuilder()
              .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
              .setUserPromptData(DataItem.newBuilder().build())
              .setMultiLanguageDetectionMetadata(
                  MultiLanguageDetectionMetadata.newBuilder().build())
              .build();
      client.sanitizeUserPrompt(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void sanitizeModelResponseTest() throws Exception {
    SanitizeModelResponseResponse expectedResponse =
        SanitizeModelResponseResponse.newBuilder()
            .setSanitizationResult(SanitizationResult.newBuilder().build())
            .build();
    mockModelArmor.addResponse(expectedResponse);

    SanitizeModelResponseRequest request =
        SanitizeModelResponseRequest.newBuilder()
            .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .setModelResponseData(DataItem.newBuilder().build())
            .setUserPrompt("userPrompt1504308495")
            .setMultiLanguageDetectionMetadata(MultiLanguageDetectionMetadata.newBuilder().build())
            .build();

    SanitizeModelResponseResponse actualResponse = client.sanitizeModelResponse(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelArmor.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SanitizeModelResponseRequest actualRequest =
        ((SanitizeModelResponseRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getModelResponseData(), actualRequest.getModelResponseData());
    Assert.assertEquals(request.getUserPrompt(), actualRequest.getUserPrompt());
    Assert.assertEquals(
        request.getMultiLanguageDetectionMetadata(),
        actualRequest.getMultiLanguageDetectionMetadata());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void sanitizeModelResponseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelArmor.addException(exception);

    try {
      SanitizeModelResponseRequest request =
          SanitizeModelResponseRequest.newBuilder()
              .setName(TemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
              .setModelResponseData(DataItem.newBuilder().build())
              .setUserPrompt("userPrompt1504308495")
              .setMultiLanguageDetectionMetadata(
                  MultiLanguageDetectionMetadata.newBuilder().build())
              .build();
      client.sanitizeModelResponse(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
