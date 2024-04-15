/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.advisorynotifications.v1;

import static com.google.cloud.advisorynotifications.v1.AdvisoryNotificationsServiceClient.ListNotificationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.advisorynotifications.v1.stub.HttpJsonAdvisoryNotificationsServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class AdvisoryNotificationsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AdvisoryNotificationsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAdvisoryNotificationsServiceStub.getMethodDescriptors(),
            AdvisoryNotificationsServiceSettings.getDefaultEndpoint());
    AdvisoryNotificationsServiceSettings settings =
        AdvisoryNotificationsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AdvisoryNotificationsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AdvisoryNotificationsServiceClient.create(settings);
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
  public void listNotificationsTest() throws Exception {
    Notification responsesElement = Notification.newBuilder().build();
    ListNotificationsResponse expectedResponse =
        ListNotificationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotifications(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]");

    ListNotificationsPagedResponse pagedListResponse = client.listNotifications(parent);

    List<Notification> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotificationsList().get(0), resources.get(0));

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
  public void listNotificationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]");
      client.listNotifications(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationsTest2() throws Exception {
    Notification responsesElement = Notification.newBuilder().build();
    ListNotificationsResponse expectedResponse =
        ListNotificationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotifications(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "organizations/organization-9365/locations/location-9365";

    ListNotificationsPagedResponse pagedListResponse = client.listNotifications(parent);

    List<Notification> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotificationsList().get(0), resources.get(0));

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
  public void listNotificationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "organizations/organization-9365/locations/location-9365";
      client.listNotifications(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNotificationTest() throws Exception {
    Notification expectedResponse =
        Notification.newBuilder()
            .setName(
                NotificationName.ofOrganizationLocationNotificationName(
                        "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION]")
                    .toString())
            .setSubject(Subject.newBuilder().build())
            .addAllMessages(new ArrayList<Message>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setNotificationType(NotificationType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    NotificationName name =
        NotificationName.ofOrganizationLocationNotificationName(
            "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION]");

    Notification actualResponse = client.getNotification(name);
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
  public void getNotificationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NotificationName name =
          NotificationName.ofOrganizationLocationNotificationName(
              "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION]");
      client.getNotification(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNotificationTest2() throws Exception {
    Notification expectedResponse =
        Notification.newBuilder()
            .setName(
                NotificationName.ofOrganizationLocationNotificationName(
                        "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION]")
                    .toString())
            .setSubject(Subject.newBuilder().build())
            .addAllMessages(new ArrayList<Message>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setNotificationType(NotificationType.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "organizations/organization-2434/locations/location-2434/notifications/notification-2434";

    Notification actualResponse = client.getNotification(name);
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
  public void getNotificationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "organizations/organization-2434/locations/location-2434/notifications/notification-2434";
      client.getNotification(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSettingsTest() throws Exception {
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(
                SettingsName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]").toString())
            .putAllNotificationSettings(new HashMap<String, NotificationSettings>())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    SettingsName name = SettingsName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]");

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
      SettingsName name = SettingsName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]");
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
            .setName(
                SettingsName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]").toString())
            .putAllNotificationSettings(new HashMap<String, NotificationSettings>())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-2136/locations/location-2136/settings";

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
      String name = "organizations/organization-2136/locations/location-2136/settings";
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
            .setName(
                SettingsName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]").toString())
            .putAllNotificationSettings(new HashMap<String, NotificationSettings>())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    Settings settings =
        Settings.newBuilder()
            .setName(
                SettingsName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]").toString())
            .putAllNotificationSettings(new HashMap<String, NotificationSettings>())
            .setEtag("etag3123477")
            .build();

    Settings actualResponse = client.updateSettings(settings);
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
              .setName(
                  SettingsName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]")
                      .toString())
              .putAllNotificationSettings(new HashMap<String, NotificationSettings>())
              .setEtag("etag3123477")
              .build();
      client.updateSettings(settings);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
