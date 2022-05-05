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

package com.google.cloud.securitycenter.settings.v1beta1;

import static com.google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsServiceClient.ListComponentsPagedResponse;
import static com.google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsServiceClient.ListDetectorsPagedResponse;

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
public class SecurityCenterSettingsServiceClientTest {
  private static MockSecurityCenterSettingsService mockSecurityCenterSettingsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private SecurityCenterSettingsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSecurityCenterSettingsService = new MockSecurityCenterSettingsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSecurityCenterSettingsService));
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
    SecurityCenterSettingsServiceSettings settings =
        SecurityCenterSettingsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SecurityCenterSettingsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getServiceAccountTest() throws Exception {
    ServiceAccount expectedResponse =
        ServiceAccount.newBuilder()
            .setName(ServiceAccountName.of("[ORGANIZATION]").toString())
            .setServiceAccount("serviceAccount1079137720")
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[ORGANIZATION]");

    ServiceAccount actualResponse = client.getServiceAccount(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceAccountRequest actualRequest = ((GetServiceAccountRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      ServiceAccountName name = ServiceAccountName.of("[ORGANIZATION]");
      client.getServiceAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getServiceAccountTest2() throws Exception {
    ServiceAccount expectedResponse =
        ServiceAccount.newBuilder()
            .setName(ServiceAccountName.of("[ORGANIZATION]").toString())
            .setServiceAccount("serviceAccount1079137720")
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    String name = "name3373707";

    ServiceAccount actualResponse = client.getServiceAccount(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceAccountRequest actualRequest = ((GetServiceAccountRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getServiceAccountExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      String name = "name3373707";
      client.getServiceAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSettingsTest() throws Exception {
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(SettingsName.ofOrganizationName("[ORGANIZATION]").toString())
            .setBillingSettings(BillingSettings.newBuilder().build())
            .setOrgServiceAccount("orgServiceAccount-1736642116")
            .setSinkSettings(SinkSettings.newBuilder().build())
            .putAllComponentSettings(new HashMap<String, ComponentSettings>())
            .putAllDetectorGroupSettings(new HashMap<String, Settings.DetectorGroupSettings>())
            .setEtag("etag3123477")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    SettingsName name = SettingsName.ofOrganizationName("[ORGANIZATION]");

    Settings actualResponse = client.getSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSettingsRequest actualRequest = ((GetSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      SettingsName name = SettingsName.ofOrganizationName("[ORGANIZATION]");
      client.getSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSettingsTest2() throws Exception {
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(SettingsName.ofOrganizationName("[ORGANIZATION]").toString())
            .setBillingSettings(BillingSettings.newBuilder().build())
            .setOrgServiceAccount("orgServiceAccount-1736642116")
            .setSinkSettings(SinkSettings.newBuilder().build())
            .putAllComponentSettings(new HashMap<String, ComponentSettings>())
            .putAllDetectorGroupSettings(new HashMap<String, Settings.DetectorGroupSettings>())
            .setEtag("etag3123477")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    String name = "name3373707";

    Settings actualResponse = client.getSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSettingsRequest actualRequest = ((GetSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      String name = "name3373707";
      client.getSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSettingsTest() throws Exception {
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(SettingsName.ofOrganizationName("[ORGANIZATION]").toString())
            .setBillingSettings(BillingSettings.newBuilder().build())
            .setOrgServiceAccount("orgServiceAccount-1736642116")
            .setSinkSettings(SinkSettings.newBuilder().build())
            .putAllComponentSettings(new HashMap<String, ComponentSettings>())
            .putAllDetectorGroupSettings(new HashMap<String, Settings.DetectorGroupSettings>())
            .setEtag("etag3123477")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    Settings settings = Settings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Settings actualResponse = client.updateSettings(settings, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSettingsRequest actualRequest = ((UpdateSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(settings, actualRequest.getSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      Settings settings = Settings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSettings(settings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resetSettingsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    ResetSettingsRequest request =
        ResetSettingsRequest.newBuilder()
            .setName(SettingsName.ofOrganizationName("[ORGANIZATION]").toString())
            .setEtag("etag3123477")
            .build();

    client.resetSettings(request);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetSettingsRequest actualRequest = ((ResetSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getEtag(), actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resetSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      ResetSettingsRequest request =
          ResetSettingsRequest.newBuilder()
              .setName(SettingsName.ofOrganizationName("[ORGANIZATION]").toString())
              .setEtag("etag3123477")
              .build();
      client.resetSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchGetSettingsTest() throws Exception {
    BatchGetSettingsResponse expectedResponse =
        BatchGetSettingsResponse.newBuilder().addAllSettings(new ArrayList<Settings>()).build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    BatchGetSettingsRequest request =
        BatchGetSettingsRequest.newBuilder()
            .setParent(OrganizationName.of("[ORGANIZATION]").toString())
            .addAllNames(new ArrayList<String>())
            .build();

    BatchGetSettingsResponse actualResponse = client.batchGetSettings(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchGetSettingsRequest actualRequest = ((BatchGetSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getNamesList(), actualRequest.getNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchGetSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      BatchGetSettingsRequest request =
          BatchGetSettingsRequest.newBuilder()
              .setParent(OrganizationName.of("[ORGANIZATION]").toString())
              .addAllNames(new ArrayList<String>())
              .build();
      client.batchGetSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void calculateEffectiveSettingsTest() throws Exception {
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(SettingsName.ofOrganizationName("[ORGANIZATION]").toString())
            .setBillingSettings(BillingSettings.newBuilder().build())
            .setOrgServiceAccount("orgServiceAccount-1736642116")
            .setSinkSettings(SinkSettings.newBuilder().build())
            .putAllComponentSettings(new HashMap<String, ComponentSettings>())
            .putAllDetectorGroupSettings(new HashMap<String, Settings.DetectorGroupSettings>())
            .setEtag("etag3123477")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    SettingsName name = SettingsName.ofOrganizationName("[ORGANIZATION]");

    Settings actualResponse = client.calculateEffectiveSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CalculateEffectiveSettingsRequest actualRequest =
        ((CalculateEffectiveSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void calculateEffectiveSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      SettingsName name = SettingsName.ofOrganizationName("[ORGANIZATION]");
      client.calculateEffectiveSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void calculateEffectiveSettingsTest2() throws Exception {
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(SettingsName.ofOrganizationName("[ORGANIZATION]").toString())
            .setBillingSettings(BillingSettings.newBuilder().build())
            .setOrgServiceAccount("orgServiceAccount-1736642116")
            .setSinkSettings(SinkSettings.newBuilder().build())
            .putAllComponentSettings(new HashMap<String, ComponentSettings>())
            .putAllDetectorGroupSettings(new HashMap<String, Settings.DetectorGroupSettings>())
            .setEtag("etag3123477")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    String name = "name3373707";

    Settings actualResponse = client.calculateEffectiveSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CalculateEffectiveSettingsRequest actualRequest =
        ((CalculateEffectiveSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void calculateEffectiveSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      String name = "name3373707";
      client.calculateEffectiveSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCalculateEffectiveSettingsTest() throws Exception {
    BatchCalculateEffectiveSettingsResponse expectedResponse =
        BatchCalculateEffectiveSettingsResponse.newBuilder()
            .addAllSettings(new ArrayList<Settings>())
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    BatchCalculateEffectiveSettingsRequest request =
        BatchCalculateEffectiveSettingsRequest.newBuilder()
            .setParent(OrganizationName.of("[ORGANIZATION]").toString())
            .addAllRequests(new ArrayList<CalculateEffectiveSettingsRequest>())
            .build();

    BatchCalculateEffectiveSettingsResponse actualResponse =
        client.batchCalculateEffectiveSettings(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCalculateEffectiveSettingsRequest actualRequest =
        ((BatchCalculateEffectiveSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRequestsList(), actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCalculateEffectiveSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      BatchCalculateEffectiveSettingsRequest request =
          BatchCalculateEffectiveSettingsRequest.newBuilder()
              .setParent(OrganizationName.of("[ORGANIZATION]").toString())
              .addAllRequests(new ArrayList<CalculateEffectiveSettingsRequest>())
              .build();
      client.batchCalculateEffectiveSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getComponentSettingsTest() throws Exception {
    ComponentSettings expectedResponse =
        ComponentSettings.newBuilder()
            .setName(
                ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]")
                    .toString())
            .setState(ComponentEnablementState.forNumber(0))
            .setProjectServiceAccount("projectServiceAccount79138097")
            .putAllDetectorSettings(new HashMap<String, ComponentSettings.DetectorSettings>())
            .setEtag("etag3123477")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    ComponentSettingsName name =
        ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]");

    ComponentSettings actualResponse = client.getComponentSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetComponentSettingsRequest actualRequest =
        ((GetComponentSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getComponentSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      ComponentSettingsName name =
          ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]");
      client.getComponentSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getComponentSettingsTest2() throws Exception {
    ComponentSettings expectedResponse =
        ComponentSettings.newBuilder()
            .setName(
                ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]")
                    .toString())
            .setState(ComponentEnablementState.forNumber(0))
            .setProjectServiceAccount("projectServiceAccount79138097")
            .putAllDetectorSettings(new HashMap<String, ComponentSettings.DetectorSettings>())
            .setEtag("etag3123477")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    String name = "name3373707";

    ComponentSettings actualResponse = client.getComponentSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetComponentSettingsRequest actualRequest =
        ((GetComponentSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getComponentSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      String name = "name3373707";
      client.getComponentSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateComponentSettingsTest() throws Exception {
    ComponentSettings expectedResponse =
        ComponentSettings.newBuilder()
            .setName(
                ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]")
                    .toString())
            .setState(ComponentEnablementState.forNumber(0))
            .setProjectServiceAccount("projectServiceAccount79138097")
            .putAllDetectorSettings(new HashMap<String, ComponentSettings.DetectorSettings>())
            .setEtag("etag3123477")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    ComponentSettings componentSettings = ComponentSettings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ComponentSettings actualResponse =
        client.updateComponentSettings(componentSettings, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateComponentSettingsRequest actualRequest =
        ((UpdateComponentSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(componentSettings, actualRequest.getComponentSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateComponentSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      ComponentSettings componentSettings = ComponentSettings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateComponentSettings(componentSettings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resetComponentSettingsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    ResetComponentSettingsRequest request =
        ResetComponentSettingsRequest.newBuilder()
            .setName(
                ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]")
                    .toString())
            .setEtag("etag3123477")
            .build();

    client.resetComponentSettings(request);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetComponentSettingsRequest actualRequest =
        ((ResetComponentSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getEtag(), actualRequest.getEtag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resetComponentSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      ResetComponentSettingsRequest request =
          ResetComponentSettingsRequest.newBuilder()
              .setName(
                  ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]")
                      .toString())
              .setEtag("etag3123477")
              .build();
      client.resetComponentSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void calculateEffectiveComponentSettingsTest() throws Exception {
    ComponentSettings expectedResponse =
        ComponentSettings.newBuilder()
            .setName(
                ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]")
                    .toString())
            .setState(ComponentEnablementState.forNumber(0))
            .setProjectServiceAccount("projectServiceAccount79138097")
            .putAllDetectorSettings(new HashMap<String, ComponentSettings.DetectorSettings>())
            .setEtag("etag3123477")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    ComponentSettingsName name =
        ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]");

    ComponentSettings actualResponse = client.calculateEffectiveComponentSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CalculateEffectiveComponentSettingsRequest actualRequest =
        ((CalculateEffectiveComponentSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void calculateEffectiveComponentSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      ComponentSettingsName name =
          ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]");
      client.calculateEffectiveComponentSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void calculateEffectiveComponentSettingsTest2() throws Exception {
    ComponentSettings expectedResponse =
        ComponentSettings.newBuilder()
            .setName(
                ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]")
                    .toString())
            .setState(ComponentEnablementState.forNumber(0))
            .setProjectServiceAccount("projectServiceAccount79138097")
            .putAllDetectorSettings(new HashMap<String, ComponentSettings.DetectorSettings>())
            .setEtag("etag3123477")
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    String name = "name3373707";

    ComponentSettings actualResponse = client.calculateEffectiveComponentSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CalculateEffectiveComponentSettingsRequest actualRequest =
        ((CalculateEffectiveComponentSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void calculateEffectiveComponentSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      String name = "name3373707";
      client.calculateEffectiveComponentSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDetectorsTest() throws Exception {
    Detector responsesElement = Detector.newBuilder().build();
    ListDetectorsResponse expectedResponse =
        ListDetectorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDetectors(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListDetectorsPagedResponse pagedListResponse = client.listDetectors(parent);

    List<Detector> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDetectorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDetectorsRequest actualRequest = ((ListDetectorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDetectorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listDetectors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDetectorsTest2() throws Exception {
    Detector responsesElement = Detector.newBuilder().build();
    ListDetectorsResponse expectedResponse =
        ListDetectorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDetectors(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDetectorsPagedResponse pagedListResponse = client.listDetectors(parent);

    List<Detector> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDetectorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDetectorsRequest actualRequest = ((ListDetectorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDetectorsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDetectors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listComponentsTest() throws Exception {
    String responsesElement = "responsesElement-318365110";
    ListComponentsResponse expectedResponse =
        ListComponentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllComponents(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListComponentsPagedResponse pagedListResponse = client.listComponents(parent);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getComponentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListComponentsRequest actualRequest = ((ListComponentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listComponentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listComponents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listComponentsTest2() throws Exception {
    String responsesElement = "responsesElement-318365110";
    ListComponentsResponse expectedResponse =
        ListComponentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllComponents(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListComponentsPagedResponse pagedListResponse = client.listComponents(parent);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getComponentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListComponentsRequest actualRequest = ((ListComponentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listComponentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listComponents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
