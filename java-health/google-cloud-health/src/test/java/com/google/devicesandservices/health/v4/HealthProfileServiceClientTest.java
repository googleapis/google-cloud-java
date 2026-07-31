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

package com.google.devicesandservices.health.v4;

import static com.google.devicesandservices.health.v4.HealthProfileServiceClient.ListPairedDevicesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.type.Date;
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
public class HealthProfileServiceClientTest {
  private static MockHealthProfileService mockHealthProfileService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private HealthProfileServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockHealthProfileService = new MockHealthProfileService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockHealthProfileService));
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
    HealthProfileServiceSettings settings =
        HealthProfileServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = HealthProfileServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getProfileTest() throws Exception {
    Profile expectedResponse =
        Profile.newBuilder()
            .setName(ProfileName.of("[USER]").toString())
            .setAge(96511)
            .setMembershipStartDate(Date.newBuilder().build())
            .setUserConfiguredWalkingStrideLengthMm(-549254618)
            .setUserConfiguredRunningStrideLengthMm(-235827552)
            .setAutoWalkingStrideLengthMm(204417609)
            .setAutoRunningStrideLengthMm(517844675)
            .build();
    mockHealthProfileService.addResponse(expectedResponse);

    ProfileName name = ProfileName.of("[USER]");

    Profile actualResponse = client.getProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHealthProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProfileRequest actualRequest = ((GetProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHealthProfileService.addException(exception);

    try {
      ProfileName name = ProfileName.of("[USER]");
      client.getProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProfileTest2() throws Exception {
    Profile expectedResponse =
        Profile.newBuilder()
            .setName(ProfileName.of("[USER]").toString())
            .setAge(96511)
            .setMembershipStartDate(Date.newBuilder().build())
            .setUserConfiguredWalkingStrideLengthMm(-549254618)
            .setUserConfiguredRunningStrideLengthMm(-235827552)
            .setAutoWalkingStrideLengthMm(204417609)
            .setAutoRunningStrideLengthMm(517844675)
            .build();
    mockHealthProfileService.addResponse(expectedResponse);

    String name = "name3373707";

    Profile actualResponse = client.getProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHealthProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProfileRequest actualRequest = ((GetProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHealthProfileService.addException(exception);

    try {
      String name = "name3373707";
      client.getProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateProfileTest() throws Exception {
    Profile expectedResponse =
        Profile.newBuilder()
            .setName(ProfileName.of("[USER]").toString())
            .setAge(96511)
            .setMembershipStartDate(Date.newBuilder().build())
            .setUserConfiguredWalkingStrideLengthMm(-549254618)
            .setUserConfiguredRunningStrideLengthMm(-235827552)
            .setAutoWalkingStrideLengthMm(204417609)
            .setAutoRunningStrideLengthMm(517844675)
            .build();
    mockHealthProfileService.addResponse(expectedResponse);

    Profile profile = Profile.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Profile actualResponse = client.updateProfile(profile, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHealthProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateProfileRequest actualRequest = ((UpdateProfileRequest) actualRequests.get(0));

    Assert.assertEquals(profile, actualRequest.getProfile());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHealthProfileService.addException(exception);

    try {
      Profile profile = Profile.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateProfile(profile, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSettingsTest() throws Exception {
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(SettingsName.of("[USER]").toString())
            .setAutoStrideEnabled(true)
            .setLanguageLocale("languageLocale-445142062")
            .setUtcOffset(Duration.newBuilder().build())
            .setTimeZone("timeZone-2077180903")
            .setFoodLanguageCode("foodLanguageCode2108624099")
            .build();
    mockHealthProfileService.addResponse(expectedResponse);

    SettingsName name = SettingsName.of("[USER]");

    Settings actualResponse = client.getSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHealthProfileService.getRequests();
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
    mockHealthProfileService.addException(exception);

    try {
      SettingsName name = SettingsName.of("[USER]");
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
            .setName(SettingsName.of("[USER]").toString())
            .setAutoStrideEnabled(true)
            .setLanguageLocale("languageLocale-445142062")
            .setUtcOffset(Duration.newBuilder().build())
            .setTimeZone("timeZone-2077180903")
            .setFoodLanguageCode("foodLanguageCode2108624099")
            .build();
    mockHealthProfileService.addResponse(expectedResponse);

    String name = "name3373707";

    Settings actualResponse = client.getSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHealthProfileService.getRequests();
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
    mockHealthProfileService.addException(exception);

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
            .setName(SettingsName.of("[USER]").toString())
            .setAutoStrideEnabled(true)
            .setLanguageLocale("languageLocale-445142062")
            .setUtcOffset(Duration.newBuilder().build())
            .setTimeZone("timeZone-2077180903")
            .setFoodLanguageCode("foodLanguageCode2108624099")
            .build();
    mockHealthProfileService.addResponse(expectedResponse);

    Settings settings = Settings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Settings actualResponse = client.updateSettings(settings, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHealthProfileService.getRequests();
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
    mockHealthProfileService.addException(exception);

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
  public void getIdentityTest() throws Exception {
    Identity expectedResponse =
        Identity.newBuilder()
            .setName(IdentityName.of("[USER]").toString())
            .setLegacyUserId("legacyUserId958223215")
            .setHealthUserId("healthUserId574154690")
            .build();
    mockHealthProfileService.addResponse(expectedResponse);

    IdentityName name = IdentityName.of("[USER]");

    Identity actualResponse = client.getIdentity(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHealthProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIdentityRequest actualRequest = ((GetIdentityRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIdentityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHealthProfileService.addException(exception);

    try {
      IdentityName name = IdentityName.of("[USER]");
      client.getIdentity(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIdentityTest2() throws Exception {
    Identity expectedResponse =
        Identity.newBuilder()
            .setName(IdentityName.of("[USER]").toString())
            .setLegacyUserId("legacyUserId958223215")
            .setHealthUserId("healthUserId574154690")
            .build();
    mockHealthProfileService.addResponse(expectedResponse);

    String name = "name3373707";

    Identity actualResponse = client.getIdentity(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHealthProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIdentityRequest actualRequest = ((GetIdentityRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIdentityExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHealthProfileService.addException(exception);

    try {
      String name = "name3373707";
      client.getIdentity(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIrnProfileTest() throws Exception {
    IrnProfile expectedResponse =
        IrnProfile.newBuilder()
            .setName(IrnProfileName.of("[USER]").toString())
            .setOnboardingStatus(true)
            .setEnrollmentStatus(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockHealthProfileService.addResponse(expectedResponse);

    IrnProfileName name = IrnProfileName.of("[USER]");

    IrnProfile actualResponse = client.getIrnProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHealthProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIrnProfileRequest actualRequest = ((GetIrnProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIrnProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHealthProfileService.addException(exception);

    try {
      IrnProfileName name = IrnProfileName.of("[USER]");
      client.getIrnProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIrnProfileTest2() throws Exception {
    IrnProfile expectedResponse =
        IrnProfile.newBuilder()
            .setName(IrnProfileName.of("[USER]").toString())
            .setOnboardingStatus(true)
            .setEnrollmentStatus(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockHealthProfileService.addResponse(expectedResponse);

    String name = "name3373707";

    IrnProfile actualResponse = client.getIrnProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHealthProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIrnProfileRequest actualRequest = ((GetIrnProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIrnProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHealthProfileService.addException(exception);

    try {
      String name = "name3373707";
      client.getIrnProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPairedDeviceTest() throws Exception {
    PairedDevice expectedResponse =
        PairedDevice.newBuilder()
            .setName(PairedDeviceName.of("[USER]", "[PAIRED_DEVICE]").toString())
            .setBatteryStatus("batteryStatus-1213535137")
            .setBatteryLevel(-877252910)
            .setLastSyncTime(Timestamp.newBuilder().build())
            .setDeviceVersion("deviceVersion-766907998")
            .setMacAddress("macAddress2081933221")
            .addAllFeatures(new ArrayList<String>())
            .build();
    mockHealthProfileService.addResponse(expectedResponse);

    PairedDeviceName name = PairedDeviceName.of("[USER]", "[PAIRED_DEVICE]");

    PairedDevice actualResponse = client.getPairedDevice(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHealthProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPairedDeviceRequest actualRequest = ((GetPairedDeviceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPairedDeviceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHealthProfileService.addException(exception);

    try {
      PairedDeviceName name = PairedDeviceName.of("[USER]", "[PAIRED_DEVICE]");
      client.getPairedDevice(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPairedDeviceTest2() throws Exception {
    PairedDevice expectedResponse =
        PairedDevice.newBuilder()
            .setName(PairedDeviceName.of("[USER]", "[PAIRED_DEVICE]").toString())
            .setBatteryStatus("batteryStatus-1213535137")
            .setBatteryLevel(-877252910)
            .setLastSyncTime(Timestamp.newBuilder().build())
            .setDeviceVersion("deviceVersion-766907998")
            .setMacAddress("macAddress2081933221")
            .addAllFeatures(new ArrayList<String>())
            .build();
    mockHealthProfileService.addResponse(expectedResponse);

    String name = "name3373707";

    PairedDevice actualResponse = client.getPairedDevice(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHealthProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPairedDeviceRequest actualRequest = ((GetPairedDeviceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPairedDeviceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHealthProfileService.addException(exception);

    try {
      String name = "name3373707";
      client.getPairedDevice(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPairedDevicesTest() throws Exception {
    PairedDevice responsesElement = PairedDevice.newBuilder().build();
    ListPairedDevicesResponse expectedResponse =
        ListPairedDevicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPairedDevices(Arrays.asList(responsesElement))
            .build();
    mockHealthProfileService.addResponse(expectedResponse);

    UserName parent = UserName.of("[USER]");

    ListPairedDevicesPagedResponse pagedListResponse = client.listPairedDevices(parent);

    List<PairedDevice> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPairedDevicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHealthProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPairedDevicesRequest actualRequest = ((ListPairedDevicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPairedDevicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHealthProfileService.addException(exception);

    try {
      UserName parent = UserName.of("[USER]");
      client.listPairedDevices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPairedDevicesTest2() throws Exception {
    PairedDevice responsesElement = PairedDevice.newBuilder().build();
    ListPairedDevicesResponse expectedResponse =
        ListPairedDevicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllPairedDevices(Arrays.asList(responsesElement))
            .build();
    mockHealthProfileService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPairedDevicesPagedResponse pagedListResponse = client.listPairedDevices(parent);

    List<PairedDevice> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPairedDevicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockHealthProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPairedDevicesRequest actualRequest = ((ListPairedDevicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPairedDevicesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHealthProfileService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPairedDevices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
