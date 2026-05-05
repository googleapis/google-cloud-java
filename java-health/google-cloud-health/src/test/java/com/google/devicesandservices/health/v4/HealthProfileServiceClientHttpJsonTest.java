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

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.devicesandservices.health.v4.stub.HttpJsonHealthProfileServiceStub;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import com.google.type.Date;
import java.io.IOException;
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
            .build();
    mockService.addResponse(expectedResponse);

    Settings settings =
        Settings.newBuilder()
            .setName(SettingsName.of("[USER]").toString())
            .setAutoStrideEnabled(true)
            .setLanguageLocale("languageLocale-445142062")
            .setUtcOffset(Duration.newBuilder().build())
            .setTimeZone("timeZone-2077180903")
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
}
