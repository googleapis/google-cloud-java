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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.devicesandservices.health.v4.stub.HttpJsonHealthProfileServiceStub;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.type.Date;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class HealthProfileServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static HealthProfileServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonHealthProfileServiceStub.getMethodDescriptors(),
            HealthProfileServiceSettings.getDefaultEndpoint());
    HealthProfileServiceSettings settings =
        HealthProfileServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                HealthProfileServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = HealthProfileServiceClient.create(settings);
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
    mockService.addResponse(expectedResponse);

    ProfileName name = ProfileName.of("[USER]");

    Profile actualResponse = client.getProfile(name);
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
  public void getProfileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "users/user-1522/profile";

    Profile actualResponse = client.getProfile(name);
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
  public void getProfileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "users/user-1522/profile";
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
    mockService.addResponse(expectedResponse);

    Profile profile =
        Profile.newBuilder()
            .setName(ProfileName.of("[USER]").toString())
            .setAge(96511)
            .setMembershipStartDate(Date.newBuilder().build())
            .setUserConfiguredWalkingStrideLengthMm(-549254618)
            .setUserConfiguredRunningStrideLengthMm(-235827552)
            .setAutoWalkingStrideLengthMm(204417609)
            .setAutoRunningStrideLengthMm(517844675)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Profile actualResponse = client.updateProfile(profile, updateMask);
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
  public void updateProfileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Profile profile =
          Profile.newBuilder()
              .setName(ProfileName.of("[USER]").toString())
              .setAge(96511)
              .setMembershipStartDate(Date.newBuilder().build())
              .setUserConfiguredWalkingStrideLengthMm(-549254618)
              .setUserConfiguredRunningStrideLengthMm(-235827552)
              .setAutoWalkingStrideLengthMm(204417609)
              .setAutoRunningStrideLengthMm(517844675)
              .build();
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
    mockService.addResponse(expectedResponse);

    SettingsName name = SettingsName.of("[USER]");

    Settings actualResponse = client.getSettings(name);
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
  public void getSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "users/user-9114/settings";

    Settings actualResponse = client.getSettings(name);
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
  public void getSettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "users/user-9114/settings";
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
    mockService.addResponse(expectedResponse);

    Settings settings =
        Settings.newBuilder()
            .setName(SettingsName.of("[USER]").toString())
            .setAutoStrideEnabled(true)
            .setLanguageLocale("languageLocale-445142062")
            .setUtcOffset(Duration.newBuilder().build())
            .setTimeZone("timeZone-2077180903")
            .setFoodLanguageCode("foodLanguageCode2108624099")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Settings actualResponse = client.updateSettings(settings, updateMask);
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
  public void updateSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Settings settings =
          Settings.newBuilder()
              .setName(SettingsName.of("[USER]").toString())
              .setAutoStrideEnabled(true)
              .setLanguageLocale("languageLocale-445142062")
              .setUtcOffset(Duration.newBuilder().build())
              .setTimeZone("timeZone-2077180903")
              .setFoodLanguageCode("foodLanguageCode2108624099")
              .build();
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
    mockService.addResponse(expectedResponse);

    IdentityName name = IdentityName.of("[USER]");

    Identity actualResponse = client.getIdentity(name);
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
  public void getIdentityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "users/user-3819/identity";

    Identity actualResponse = client.getIdentity(name);
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
  public void getIdentityExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "users/user-3819/identity";
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
    mockService.addResponse(expectedResponse);

    IrnProfileName name = IrnProfileName.of("[USER]");

    IrnProfile actualResponse = client.getIrnProfile(name);
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
  public void getIrnProfileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "users/user-9035/irnProfile";

    IrnProfile actualResponse = client.getIrnProfile(name);
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
  public void getIrnProfileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "users/user-9035/irnProfile";
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
    mockService.addResponse(expectedResponse);

    PairedDeviceName name = PairedDeviceName.of("[USER]", "[PAIRED_DEVICE]");

    PairedDevice actualResponse = client.getPairedDevice(name);
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
  public void getPairedDeviceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "users/user-5848/pairedDevices/pairedDevice-5848";

    PairedDevice actualResponse = client.getPairedDevice(name);
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
  public void getPairedDeviceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "users/user-5848/pairedDevices/pairedDevice-5848";
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
    mockService.addResponse(expectedResponse);

    UserName parent = UserName.of("[USER]");

    ListPairedDevicesPagedResponse pagedListResponse = client.listPairedDevices(parent);

    List<PairedDevice> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPairedDevicesList().get(0), resources.get(0));

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
  public void listPairedDevicesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "users/user-1015";

    ListPairedDevicesPagedResponse pagedListResponse = client.listPairedDevices(parent);

    List<PairedDevice> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPairedDevicesList().get(0), resources.get(0));

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
  public void listPairedDevicesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "users/user-1015";
      client.listPairedDevices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
