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

package com.google.cloud.resourcesettings.v1;

import static com.google.cloud.resourcesettings.v1.ResourceSettingsServiceClient.ListSettingsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ResourceSettingsServiceClientTest {
  private static MockResourceSettingsService mockResourceSettingsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ResourceSettingsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockResourceSettingsService = new MockResourceSettingsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockResourceSettingsService));
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
    ResourceSettingsServiceSettings settings =
        ResourceSettingsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ResourceSettingsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listSettingsTest() throws Exception {
    Setting responsesElement = Setting.newBuilder().build();
    ListSettingsResponse expectedResponse =
        ListSettingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSettings(Arrays.asList(responsesElement))
            .build();
    mockResourceSettingsService.addResponse(expectedResponse);

    ResourceName parent =
        new ResourceName() {
          @Override
          public Map<String, String> getFieldValuesMap() {
            Map<String, String> fieldValuesMap = new HashMap<>();
            fieldValuesMap.put("parent", "organizations/organization-8287");
            return fieldValuesMap;
          }

          @Override
          public String getFieldValue(String fieldName) {
            return getFieldValuesMap().get(fieldName);
          }

          @Override
          public String toString() {
            return "organizations/organization-8287";
          }
        };

    ListSettingsPagedResponse pagedListResponse = client.listSettings(parent);

    List<Setting> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSettingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockResourceSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSettingsRequest actualRequest = ((ListSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockResourceSettingsService.addException(exception);

    try {
      ResourceName parent =
          new ResourceName() {
            @Override
            public Map<String, String> getFieldValuesMap() {
              Map<String, String> fieldValuesMap = new HashMap<>();
              fieldValuesMap.put("parent", "organizations/organization-8287");
              return fieldValuesMap;
            }

            @Override
            public String getFieldValue(String fieldName) {
              return getFieldValuesMap().get(fieldName);
            }

            @Override
            public String toString() {
              return "organizations/organization-8287";
            }
          };
      client.listSettings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSettingsTest2() throws Exception {
    Setting responsesElement = Setting.newBuilder().build();
    ListSettingsResponse expectedResponse =
        ListSettingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSettings(Arrays.asList(responsesElement))
            .build();
    mockResourceSettingsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSettingsPagedResponse pagedListResponse = client.listSettings(parent);

    List<Setting> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSettingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockResourceSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSettingsRequest actualRequest = ((ListSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockResourceSettingsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSettings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSettingTest() throws Exception {
    Setting expectedResponse =
        Setting.newBuilder()
            .setName(
                SettingName.ofOrganizationSettingNameName("[ORGANIZATION]", "[SETTING_NAME]")
                    .toString())
            .setMetadata(SettingMetadata.newBuilder().build())
            .setLocalValue(Value.newBuilder().build())
            .setEffectiveValue(Value.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockResourceSettingsService.addResponse(expectedResponse);

    SettingName name =
        SettingName.ofOrganizationSettingNameName("[ORGANIZATION]", "[SETTING_NAME]");

    Setting actualResponse = client.getSetting(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockResourceSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSettingRequest actualRequest = ((GetSettingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSettingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockResourceSettingsService.addException(exception);

    try {
      SettingName name =
          SettingName.ofOrganizationSettingNameName("[ORGANIZATION]", "[SETTING_NAME]");
      client.getSetting(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSettingTest2() throws Exception {
    Setting expectedResponse =
        Setting.newBuilder()
            .setName(
                SettingName.ofOrganizationSettingNameName("[ORGANIZATION]", "[SETTING_NAME]")
                    .toString())
            .setMetadata(SettingMetadata.newBuilder().build())
            .setLocalValue(Value.newBuilder().build())
            .setEffectiveValue(Value.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockResourceSettingsService.addResponse(expectedResponse);

    String name = "name3373707";

    Setting actualResponse = client.getSetting(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockResourceSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSettingRequest actualRequest = ((GetSettingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSettingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockResourceSettingsService.addException(exception);

    try {
      String name = "name3373707";
      client.getSetting(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSettingTest() throws Exception {
    Setting expectedResponse =
        Setting.newBuilder()
            .setName(
                SettingName.ofOrganizationSettingNameName("[ORGANIZATION]", "[SETTING_NAME]")
                    .toString())
            .setMetadata(SettingMetadata.newBuilder().build())
            .setLocalValue(Value.newBuilder().build())
            .setEffectiveValue(Value.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockResourceSettingsService.addResponse(expectedResponse);

    UpdateSettingRequest request =
        UpdateSettingRequest.newBuilder().setSetting(Setting.newBuilder().build()).build();

    Setting actualResponse = client.updateSetting(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockResourceSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSettingRequest actualRequest = ((UpdateSettingRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSetting(), actualRequest.getSetting());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSettingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockResourceSettingsService.addException(exception);

    try {
      UpdateSettingRequest request =
          UpdateSettingRequest.newBuilder().setSetting(Setting.newBuilder().build()).build();
      client.updateSetting(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
