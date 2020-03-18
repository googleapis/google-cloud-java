/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
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
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class SecurityCenterSettingsServiceClientTest {
  private static MockSecurityCenterSettingsService mockSecurityCenterSettingsService;
  private static MockServiceHelper serviceHelper;
  private SecurityCenterSettingsServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockSecurityCenterSettingsService = new MockSecurityCenterSettingsService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSecurityCenterSettingsService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
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
  @SuppressWarnings("all")
  public void getServiceAccountTest() {
    ServiceAccountName name2 = ServiceAccountName.of("[ORGANIZATION]");
    String serviceAccount = "serviceAccount-1948028253";
    ServiceAccount expectedResponse =
        ServiceAccount.newBuilder()
            .setName(name2.toString())
            .setServiceAccount(serviceAccount)
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    ServiceAccountName name = ServiceAccountName.of("[ORGANIZATION]");

    ServiceAccount actualResponse = client.getServiceAccount(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetServiceAccountRequest actualRequest = (GetServiceAccountRequest) actualRequests.get(0);

    Assert.assertEquals(name, ServiceAccountName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getServiceAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      ServiceAccountName name = ServiceAccountName.of("[ORGANIZATION]");

      client.getServiceAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getSettingsTest() {
    SettingsName name2 = SettingsName.ofOrganizationName("[ORGANIZATION]");
    String orgServiceAccount = "orgServiceAccount1798582088";
    String etag = "etag3123477";
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(name2.toString())
            .setOrgServiceAccount(orgServiceAccount)
            .setEtag(etag)
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    SettingsName name = SettingsName.ofOrganizationName("[ORGANIZATION]");

    Settings actualResponse = client.getSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSettingsRequest actualRequest = (GetSettingsRequest) actualRequests.get(0);

    Assert.assertEquals(name, SettingsName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      SettingsName name = SettingsName.ofOrganizationName("[ORGANIZATION]");

      client.getSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateSettingsTest() {
    SettingsName name = SettingsName.ofOrganizationName("[ORGANIZATION]");
    String orgServiceAccount = "orgServiceAccount1798582088";
    String etag = "etag3123477";
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(name.toString())
            .setOrgServiceAccount(orgServiceAccount)
            .setEtag(etag)
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    Settings settings = Settings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Settings actualResponse = client.updateSettings(settings, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSettingsRequest actualRequest = (UpdateSettingsRequest) actualRequests.get(0);

    Assert.assertEquals(settings, actualRequest.getSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      Settings settings = Settings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateSettings(settings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void resetSettingsTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    SettingsName name = SettingsName.ofOrganizationName("[ORGANIZATION]");
    ResetSettingsRequest request =
        ResetSettingsRequest.newBuilder().setName(name.toString()).build();

    client.resetSettings(request);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetSettingsRequest actualRequest = (ResetSettingsRequest) actualRequests.get(0);

    Assert.assertEquals(name, SettingsName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void resetSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      SettingsName name = SettingsName.ofOrganizationName("[ORGANIZATION]");
      ResetSettingsRequest request =
          ResetSettingsRequest.newBuilder().setName(name.toString()).build();

      client.resetSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchGetSettingsTest() {
    BatchGetSettingsResponse expectedResponse = BatchGetSettingsResponse.newBuilder().build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    BatchGetSettingsRequest request =
        BatchGetSettingsRequest.newBuilder().setParent(parent.toString()).build();

    BatchGetSettingsResponse actualResponse = client.batchGetSettings(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchGetSettingsRequest actualRequest = (BatchGetSettingsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchGetSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      BatchGetSettingsRequest request =
          BatchGetSettingsRequest.newBuilder().setParent(parent.toString()).build();

      client.batchGetSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void calculateEffectiveSettingsTest() {
    SettingsName name2 = SettingsName.ofOrganizationName("[ORGANIZATION]");
    String orgServiceAccount = "orgServiceAccount1798582088";
    String etag = "etag3123477";
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(name2.toString())
            .setOrgServiceAccount(orgServiceAccount)
            .setEtag(etag)
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    SettingsName name = SettingsName.ofOrganizationName("[ORGANIZATION]");

    Settings actualResponse = client.calculateEffectiveSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CalculateEffectiveSettingsRequest actualRequest =
        (CalculateEffectiveSettingsRequest) actualRequests.get(0);

    Assert.assertEquals(name, SettingsName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void calculateEffectiveSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      SettingsName name = SettingsName.ofOrganizationName("[ORGANIZATION]");

      client.calculateEffectiveSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchCalculateEffectiveSettingsTest() {
    BatchCalculateEffectiveSettingsResponse expectedResponse =
        BatchCalculateEffectiveSettingsResponse.newBuilder().build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    BatchCalculateEffectiveSettingsRequest request =
        BatchCalculateEffectiveSettingsRequest.newBuilder().setParent(parent.toString()).build();

    BatchCalculateEffectiveSettingsResponse actualResponse =
        client.batchCalculateEffectiveSettings(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCalculateEffectiveSettingsRequest actualRequest =
        (BatchCalculateEffectiveSettingsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchCalculateEffectiveSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      BatchCalculateEffectiveSettingsRequest request =
          BatchCalculateEffectiveSettingsRequest.newBuilder().setParent(parent.toString()).build();

      client.batchCalculateEffectiveSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getComponentSettingsTest() {
    ComponentSettingsName name2 =
        ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]");
    String projectServiceAccount = "projectServiceAccount-1288322691";
    String etag = "etag3123477";
    ComponentSettings expectedResponse =
        ComponentSettings.newBuilder()
            .setName(name2.toString())
            .setProjectServiceAccount(projectServiceAccount)
            .setEtag(etag)
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    ComponentSettingsName name =
        ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]");

    ComponentSettings actualResponse = client.getComponentSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetComponentSettingsRequest actualRequest = (GetComponentSettingsRequest) actualRequests.get(0);

    Assert.assertEquals(name, ComponentSettingsName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getComponentSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      ComponentSettingsName name =
          ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]");

      client.getComponentSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateComponentSettingsTest() {
    ComponentSettingsName name =
        ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]");
    String projectServiceAccount = "projectServiceAccount-1288322691";
    String etag = "etag3123477";
    ComponentSettings expectedResponse =
        ComponentSettings.newBuilder()
            .setName(name.toString())
            .setProjectServiceAccount(projectServiceAccount)
            .setEtag(etag)
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
        (UpdateComponentSettingsRequest) actualRequests.get(0);

    Assert.assertEquals(componentSettings, actualRequest.getComponentSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateComponentSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      ComponentSettings componentSettings = ComponentSettings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateComponentSettings(componentSettings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void resetComponentSettingsTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    ComponentSettingsName name =
        ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]");
    ResetComponentSettingsRequest request =
        ResetComponentSettingsRequest.newBuilder().setName(name.toString()).build();

    client.resetComponentSettings(request);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetComponentSettingsRequest actualRequest =
        (ResetComponentSettingsRequest) actualRequests.get(0);

    Assert.assertEquals(name, ComponentSettingsName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void resetComponentSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      ComponentSettingsName name =
          ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]");
      ResetComponentSettingsRequest request =
          ResetComponentSettingsRequest.newBuilder().setName(name.toString()).build();

      client.resetComponentSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void calculateEffectiveComponentSettingsTest() {
    ComponentSettingsName name2 =
        ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]");
    String projectServiceAccount = "projectServiceAccount-1288322691";
    String etag = "etag3123477";
    ComponentSettings expectedResponse =
        ComponentSettings.newBuilder()
            .setName(name2.toString())
            .setProjectServiceAccount(projectServiceAccount)
            .setEtag(etag)
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    ComponentSettingsName name =
        ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]");

    ComponentSettings actualResponse = client.calculateEffectiveComponentSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CalculateEffectiveComponentSettingsRequest actualRequest =
        (CalculateEffectiveComponentSettingsRequest) actualRequests.get(0);

    Assert.assertEquals(name, ComponentSettingsName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void calculateEffectiveComponentSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      ComponentSettingsName name =
          ComponentSettingsName.ofOrganizationComponentName("[ORGANIZATION]", "[COMPONENT]");

      client.calculateEffectiveComponentSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listDetectorsTest() {
    String nextPageToken = "";
    Detector detectorsElement = Detector.newBuilder().build();
    List<Detector> detectors = Arrays.asList(detectorsElement);
    ListDetectorsResponse expectedResponse =
        ListDetectorsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllDetectors(detectors)
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListDetectorsPagedResponse pagedListResponse = client.listDetectors(parent);

    List<Detector> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDetectorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDetectorsRequest actualRequest = (ListDetectorsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listDetectorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

      client.listDetectors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listComponentsTest() {
    String nextPageToken = "";
    String componentsElement = "componentsElement1031131859";
    List<String> components = Arrays.asList(componentsElement);
    ListComponentsResponse expectedResponse =
        ListComponentsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllComponents(components)
            .build();
    mockSecurityCenterSettingsService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListComponentsPagedResponse pagedListResponse = client.listComponents(parent);

    List<String> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getComponentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenterSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListComponentsRequest actualRequest = (ListComponentsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, OrganizationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listComponentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockSecurityCenterSettingsService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

      client.listComponents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
