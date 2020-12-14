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

package com.google.cloud.dialogflow.cx.v3;

import static com.google.cloud.dialogflow.cx.v3.SecuritySettingsServiceClient.ListSecuritySettingsPagedResponse;

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
public class SecuritySettingsServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private SecuritySettingsServiceClient client;
  private static MockSecuritySettingsService mockSecuritySettingsService;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockSecuritySettingsService = new MockSecuritySettingsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSecuritySettingsService));
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
    SecuritySettingsServiceSettings settings =
        SecuritySettingsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SecuritySettingsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createSecuritySettingsTest() throws Exception {
    SecuritySettings expectedResponse =
        SecuritySettings.newBuilder()
            .setName(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setInspectTemplate("inspectTemplate-2053620050")
            .addAllPurgeDataTypes(new ArrayList<SecuritySettings.PurgeDataType>())
            .build();
    mockSecuritySettingsService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    SecuritySettings securitySettings = SecuritySettings.newBuilder().build();

    SecuritySettings actualResponse = client.createSecuritySettings(parent, securitySettings);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecuritySettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSecuritySettingsRequest actualRequest =
        ((CreateSecuritySettingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(securitySettings, actualRequest.getSecuritySettings());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSecuritySettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecuritySettingsService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      SecuritySettings securitySettings = SecuritySettings.newBuilder().build();
      client.createSecuritySettings(parent, securitySettings);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSecuritySettingsTest2() throws Exception {
    SecuritySettings expectedResponse =
        SecuritySettings.newBuilder()
            .setName(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setInspectTemplate("inspectTemplate-2053620050")
            .addAllPurgeDataTypes(new ArrayList<SecuritySettings.PurgeDataType>())
            .build();
    mockSecuritySettingsService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    SecuritySettings securitySettings = SecuritySettings.newBuilder().build();

    SecuritySettings actualResponse = client.createSecuritySettings(parent, securitySettings);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecuritySettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSecuritySettingsRequest actualRequest =
        ((CreateSecuritySettingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(securitySettings, actualRequest.getSecuritySettings());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSecuritySettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecuritySettingsService.addException(exception);

    try {
      String parent = "parent-995424086";
      SecuritySettings securitySettings = SecuritySettings.newBuilder().build();
      client.createSecuritySettings(parent, securitySettings);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSecuritySettingsTest() throws Exception {
    SecuritySettings expectedResponse =
        SecuritySettings.newBuilder()
            .setName(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setInspectTemplate("inspectTemplate-2053620050")
            .addAllPurgeDataTypes(new ArrayList<SecuritySettings.PurgeDataType>())
            .build();
    mockSecuritySettingsService.addResponse(expectedResponse);

    SecuritySettingsName name =
        SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]");

    SecuritySettings actualResponse = client.getSecuritySettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecuritySettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSecuritySettingsRequest actualRequest = ((GetSecuritySettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSecuritySettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecuritySettingsService.addException(exception);

    try {
      SecuritySettingsName name =
          SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]");
      client.getSecuritySettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSecuritySettingsTest2() throws Exception {
    SecuritySettings expectedResponse =
        SecuritySettings.newBuilder()
            .setName(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setInspectTemplate("inspectTemplate-2053620050")
            .addAllPurgeDataTypes(new ArrayList<SecuritySettings.PurgeDataType>())
            .build();
    mockSecuritySettingsService.addResponse(expectedResponse);

    String name = "name3373707";

    SecuritySettings actualResponse = client.getSecuritySettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecuritySettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSecuritySettingsRequest actualRequest = ((GetSecuritySettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSecuritySettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecuritySettingsService.addException(exception);

    try {
      String name = "name3373707";
      client.getSecuritySettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSecuritySettingsTest() throws Exception {
    SecuritySettings expectedResponse =
        SecuritySettings.newBuilder()
            .setName(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setInspectTemplate("inspectTemplate-2053620050")
            .addAllPurgeDataTypes(new ArrayList<SecuritySettings.PurgeDataType>())
            .build();
    mockSecuritySettingsService.addResponse(expectedResponse);

    SecuritySettings securitySettings = SecuritySettings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SecuritySettings actualResponse = client.updateSecuritySettings(securitySettings, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecuritySettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSecuritySettingsRequest actualRequest =
        ((UpdateSecuritySettingsRequest) actualRequests.get(0));

    Assert.assertEquals(securitySettings, actualRequest.getSecuritySettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSecuritySettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecuritySettingsService.addException(exception);

    try {
      SecuritySettings securitySettings = SecuritySettings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSecuritySettings(securitySettings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSecuritySettingsTest() throws Exception {
    SecuritySettings responsesElement = SecuritySettings.newBuilder().build();
    ListSecuritySettingsResponse expectedResponse =
        ListSecuritySettingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecuritySettings(Arrays.asList(responsesElement))
            .build();
    mockSecuritySettingsService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSecuritySettingsPagedResponse pagedListResponse = client.listSecuritySettings(parent);

    List<SecuritySettings> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSecuritySettingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecuritySettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSecuritySettingsRequest actualRequest =
        ((ListSecuritySettingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSecuritySettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecuritySettingsService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSecuritySettings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSecuritySettingsTest2() throws Exception {
    SecuritySettings responsesElement = SecuritySettings.newBuilder().build();
    ListSecuritySettingsResponse expectedResponse =
        ListSecuritySettingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSecuritySettings(Arrays.asList(responsesElement))
            .build();
    mockSecuritySettingsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSecuritySettingsPagedResponse pagedListResponse = client.listSecuritySettings(parent);

    List<SecuritySettings> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSecuritySettingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecuritySettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSecuritySettingsRequest actualRequest =
        ((ListSecuritySettingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSecuritySettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecuritySettingsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSecuritySettings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSecuritySettingsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecuritySettingsService.addResponse(expectedResponse);

    SecuritySettingsName name =
        SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]");

    client.deleteSecuritySettings(name);

    List<AbstractMessage> actualRequests = mockSecuritySettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSecuritySettingsRequest actualRequest =
        ((DeleteSecuritySettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSecuritySettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecuritySettingsService.addException(exception);

    try {
      SecuritySettingsName name =
          SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]");
      client.deleteSecuritySettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSecuritySettingsTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecuritySettingsService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteSecuritySettings(name);

    List<AbstractMessage> actualRequests = mockSecuritySettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSecuritySettingsRequest actualRequest =
        ((DeleteSecuritySettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSecuritySettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecuritySettingsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSecuritySettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
