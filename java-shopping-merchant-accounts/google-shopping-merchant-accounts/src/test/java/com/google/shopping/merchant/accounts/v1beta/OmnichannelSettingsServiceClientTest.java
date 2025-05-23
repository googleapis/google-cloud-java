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

package com.google.shopping.merchant.accounts.v1beta;

import static com.google.shopping.merchant.accounts.v1beta.OmnichannelSettingsServiceClient.ListOmnichannelSettingsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class OmnichannelSettingsServiceClientTest {
  private static MockOmnichannelSettingsService mockOmnichannelSettingsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private OmnichannelSettingsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockOmnichannelSettingsService = new MockOmnichannelSettingsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockOmnichannelSettingsService));
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
    OmnichannelSettingsServiceSettings settings =
        OmnichannelSettingsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OmnichannelSettingsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getOmnichannelSettingTest() throws Exception {
    OmnichannelSetting expectedResponse =
        OmnichannelSetting.newBuilder()
            .setName(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
            .setRegionCode("regionCode-1991004415")
            .setInStock(InStock.newBuilder().build())
            .setPickup(Pickup.newBuilder().build())
            .setLfpLink(LfpLink.newBuilder().build())
            .setOdo(OnDisplayToOrder.newBuilder().build())
            .setAbout(About.newBuilder().build())
            .setInventoryVerification(InventoryVerification.newBuilder().build())
            .build();
    mockOmnichannelSettingsService.addResponse(expectedResponse);

    OmnichannelSettingName name = OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]");

    OmnichannelSetting actualResponse = client.getOmnichannelSetting(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOmnichannelSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOmnichannelSettingRequest actualRequest =
        ((GetOmnichannelSettingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOmnichannelSettingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOmnichannelSettingsService.addException(exception);

    try {
      OmnichannelSettingName name = OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]");
      client.getOmnichannelSetting(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOmnichannelSettingTest2() throws Exception {
    OmnichannelSetting expectedResponse =
        OmnichannelSetting.newBuilder()
            .setName(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
            .setRegionCode("regionCode-1991004415")
            .setInStock(InStock.newBuilder().build())
            .setPickup(Pickup.newBuilder().build())
            .setLfpLink(LfpLink.newBuilder().build())
            .setOdo(OnDisplayToOrder.newBuilder().build())
            .setAbout(About.newBuilder().build())
            .setInventoryVerification(InventoryVerification.newBuilder().build())
            .build();
    mockOmnichannelSettingsService.addResponse(expectedResponse);

    String name = "name3373707";

    OmnichannelSetting actualResponse = client.getOmnichannelSetting(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOmnichannelSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetOmnichannelSettingRequest actualRequest =
        ((GetOmnichannelSettingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getOmnichannelSettingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOmnichannelSettingsService.addException(exception);

    try {
      String name = "name3373707";
      client.getOmnichannelSetting(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOmnichannelSettingsTest() throws Exception {
    OmnichannelSetting responsesElement = OmnichannelSetting.newBuilder().build();
    ListOmnichannelSettingsResponse expectedResponse =
        ListOmnichannelSettingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOmnichannelSettings(Arrays.asList(responsesElement))
            .build();
    mockOmnichannelSettingsService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListOmnichannelSettingsPagedResponse pagedListResponse = client.listOmnichannelSettings(parent);

    List<OmnichannelSetting> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOmnichannelSettingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOmnichannelSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOmnichannelSettingsRequest actualRequest =
        ((ListOmnichannelSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOmnichannelSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOmnichannelSettingsService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listOmnichannelSettings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOmnichannelSettingsTest2() throws Exception {
    OmnichannelSetting responsesElement = OmnichannelSetting.newBuilder().build();
    ListOmnichannelSettingsResponse expectedResponse =
        ListOmnichannelSettingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllOmnichannelSettings(Arrays.asList(responsesElement))
            .build();
    mockOmnichannelSettingsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListOmnichannelSettingsPagedResponse pagedListResponse = client.listOmnichannelSettings(parent);

    List<OmnichannelSetting> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getOmnichannelSettingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOmnichannelSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOmnichannelSettingsRequest actualRequest =
        ((ListOmnichannelSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOmnichannelSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOmnichannelSettingsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listOmnichannelSettings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createOmnichannelSettingTest() throws Exception {
    OmnichannelSetting expectedResponse =
        OmnichannelSetting.newBuilder()
            .setName(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
            .setRegionCode("regionCode-1991004415")
            .setInStock(InStock.newBuilder().build())
            .setPickup(Pickup.newBuilder().build())
            .setLfpLink(LfpLink.newBuilder().build())
            .setOdo(OnDisplayToOrder.newBuilder().build())
            .setAbout(About.newBuilder().build())
            .setInventoryVerification(InventoryVerification.newBuilder().build())
            .build();
    mockOmnichannelSettingsService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    OmnichannelSetting omnichannelSetting = OmnichannelSetting.newBuilder().build();

    OmnichannelSetting actualResponse = client.createOmnichannelSetting(parent, omnichannelSetting);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOmnichannelSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOmnichannelSettingRequest actualRequest =
        ((CreateOmnichannelSettingRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(omnichannelSetting, actualRequest.getOmnichannelSetting());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createOmnichannelSettingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOmnichannelSettingsService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      OmnichannelSetting omnichannelSetting = OmnichannelSetting.newBuilder().build();
      client.createOmnichannelSetting(parent, omnichannelSetting);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createOmnichannelSettingTest2() throws Exception {
    OmnichannelSetting expectedResponse =
        OmnichannelSetting.newBuilder()
            .setName(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
            .setRegionCode("regionCode-1991004415")
            .setInStock(InStock.newBuilder().build())
            .setPickup(Pickup.newBuilder().build())
            .setLfpLink(LfpLink.newBuilder().build())
            .setOdo(OnDisplayToOrder.newBuilder().build())
            .setAbout(About.newBuilder().build())
            .setInventoryVerification(InventoryVerification.newBuilder().build())
            .build();
    mockOmnichannelSettingsService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    OmnichannelSetting omnichannelSetting = OmnichannelSetting.newBuilder().build();

    OmnichannelSetting actualResponse = client.createOmnichannelSetting(parent, omnichannelSetting);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOmnichannelSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOmnichannelSettingRequest actualRequest =
        ((CreateOmnichannelSettingRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(omnichannelSetting, actualRequest.getOmnichannelSetting());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createOmnichannelSettingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOmnichannelSettingsService.addException(exception);

    try {
      String parent = "parent-995424086";
      OmnichannelSetting omnichannelSetting = OmnichannelSetting.newBuilder().build();
      client.createOmnichannelSetting(parent, omnichannelSetting);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateOmnichannelSettingTest() throws Exception {
    OmnichannelSetting expectedResponse =
        OmnichannelSetting.newBuilder()
            .setName(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
            .setRegionCode("regionCode-1991004415")
            .setInStock(InStock.newBuilder().build())
            .setPickup(Pickup.newBuilder().build())
            .setLfpLink(LfpLink.newBuilder().build())
            .setOdo(OnDisplayToOrder.newBuilder().build())
            .setAbout(About.newBuilder().build())
            .setInventoryVerification(InventoryVerification.newBuilder().build())
            .build();
    mockOmnichannelSettingsService.addResponse(expectedResponse);

    OmnichannelSetting omnichannelSetting = OmnichannelSetting.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    OmnichannelSetting actualResponse =
        client.updateOmnichannelSetting(omnichannelSetting, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOmnichannelSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateOmnichannelSettingRequest actualRequest =
        ((UpdateOmnichannelSettingRequest) actualRequests.get(0));

    Assert.assertEquals(omnichannelSetting, actualRequest.getOmnichannelSetting());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateOmnichannelSettingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOmnichannelSettingsService.addException(exception);

    try {
      OmnichannelSetting omnichannelSetting = OmnichannelSetting.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateOmnichannelSetting(omnichannelSetting, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void requestInventoryVerificationTest() throws Exception {
    RequestInventoryVerificationResponse expectedResponse =
        RequestInventoryVerificationResponse.newBuilder()
            .setOmnichannelSetting(OmnichannelSetting.newBuilder().build())
            .build();
    mockOmnichannelSettingsService.addResponse(expectedResponse);

    OmnichannelSettingName name = OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]");

    RequestInventoryVerificationResponse actualResponse = client.requestInventoryVerification(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOmnichannelSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RequestInventoryVerificationRequest actualRequest =
        ((RequestInventoryVerificationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void requestInventoryVerificationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOmnichannelSettingsService.addException(exception);

    try {
      OmnichannelSettingName name = OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]");
      client.requestInventoryVerification(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void requestInventoryVerificationTest2() throws Exception {
    RequestInventoryVerificationResponse expectedResponse =
        RequestInventoryVerificationResponse.newBuilder()
            .setOmnichannelSetting(OmnichannelSetting.newBuilder().build())
            .build();
    mockOmnichannelSettingsService.addResponse(expectedResponse);

    String name = "name3373707";

    RequestInventoryVerificationResponse actualResponse = client.requestInventoryVerification(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOmnichannelSettingsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RequestInventoryVerificationRequest actualRequest =
        ((RequestInventoryVerificationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void requestInventoryVerificationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOmnichannelSettingsService.addException(exception);

    try {
      String name = "name3373707";
      client.requestInventoryVerification(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
