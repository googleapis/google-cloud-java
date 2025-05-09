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

package com.google.shopping.merchant.notifications.v1beta;

import static com.google.shopping.merchant.notifications.v1beta.NotificationsApiServiceClient.ListNotificationSubscriptionsPagedResponse;

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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.notifications.v1beta.stub.HttpJsonNotificationsApiServiceStub;
import java.io.IOException;
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
public class NotificationsApiServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static NotificationsApiServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonNotificationsApiServiceStub.getMethodDescriptors(),
            NotificationsApiServiceSettings.getDefaultEndpoint());
    NotificationsApiServiceSettings settings =
        NotificationsApiServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                NotificationsApiServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = NotificationsApiServiceClient.create(settings);
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
  public void getNotificationSubscriptionTest() throws Exception {
    NotificationSubscription expectedResponse =
        NotificationSubscription.newBuilder()
            .setName(
                NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]")
                    .toString())
            .setCallBackUri("callBackUri-760667449")
            .build();
    mockService.addResponse(expectedResponse);

    NotificationSubscriptionName name =
        NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]");

    NotificationSubscription actualResponse = client.getNotificationSubscription(name);
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
  public void getNotificationSubscriptionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NotificationSubscriptionName name =
          NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]");
      client.getNotificationSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNotificationSubscriptionTest2() throws Exception {
    NotificationSubscription expectedResponse =
        NotificationSubscription.newBuilder()
            .setName(
                NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]")
                    .toString())
            .setCallBackUri("callBackUri-760667449")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-7245/notificationsubscriptions/notificationsubscription-7245";

    NotificationSubscription actualResponse = client.getNotificationSubscription(name);
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
  public void getNotificationSubscriptionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-7245/notificationsubscriptions/notificationsubscription-7245";
      client.getNotificationSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNotificationSubscriptionTest() throws Exception {
    NotificationSubscription expectedResponse =
        NotificationSubscription.newBuilder()
            .setName(
                NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]")
                    .toString())
            .setCallBackUri("callBackUri-760667449")
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    NotificationSubscription notificationSubscription =
        NotificationSubscription.newBuilder().build();

    NotificationSubscription actualResponse =
        client.createNotificationSubscription(parent, notificationSubscription);
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
  public void createNotificationSubscriptionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      NotificationSubscription notificationSubscription =
          NotificationSubscription.newBuilder().build();
      client.createNotificationSubscription(parent, notificationSubscription);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNotificationSubscriptionTest2() throws Exception {
    NotificationSubscription expectedResponse =
        NotificationSubscription.newBuilder()
            .setName(
                NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]")
                    .toString())
            .setCallBackUri("callBackUri-760667449")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";
    NotificationSubscription notificationSubscription =
        NotificationSubscription.newBuilder().build();

    NotificationSubscription actualResponse =
        client.createNotificationSubscription(parent, notificationSubscription);
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
  public void createNotificationSubscriptionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      NotificationSubscription notificationSubscription =
          NotificationSubscription.newBuilder().build();
      client.createNotificationSubscription(parent, notificationSubscription);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateNotificationSubscriptionTest() throws Exception {
    NotificationSubscription expectedResponse =
        NotificationSubscription.newBuilder()
            .setName(
                NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]")
                    .toString())
            .setCallBackUri("callBackUri-760667449")
            .build();
    mockService.addResponse(expectedResponse);

    NotificationSubscription notificationSubscription =
        NotificationSubscription.newBuilder()
            .setName(
                NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]")
                    .toString())
            .setCallBackUri("callBackUri-760667449")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    NotificationSubscription actualResponse =
        client.updateNotificationSubscription(notificationSubscription, updateMask);
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
  public void updateNotificationSubscriptionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NotificationSubscription notificationSubscription =
          NotificationSubscription.newBuilder()
              .setName(
                  NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]")
                      .toString())
              .setCallBackUri("callBackUri-760667449")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNotificationSubscription(notificationSubscription, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNotificationSubscriptionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NotificationSubscriptionName name =
        NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]");

    client.deleteNotificationSubscription(name);

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
  public void deleteNotificationSubscriptionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NotificationSubscriptionName name =
          NotificationSubscriptionName.of("[ACCOUNT]", "[NOTIFICATION_SUBSCRIPTION]");
      client.deleteNotificationSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNotificationSubscriptionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-7245/notificationsubscriptions/notificationsubscription-7245";

    client.deleteNotificationSubscription(name);

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
  public void deleteNotificationSubscriptionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-7245/notificationsubscriptions/notificationsubscription-7245";
      client.deleteNotificationSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationSubscriptionsTest() throws Exception {
    NotificationSubscription responsesElement = NotificationSubscription.newBuilder().build();
    ListNotificationSubscriptionsResponse expectedResponse =
        ListNotificationSubscriptionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotificationSubscriptions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListNotificationSubscriptionsPagedResponse pagedListResponse =
        client.listNotificationSubscriptions(parent);

    List<NotificationSubscription> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getNotificationSubscriptionsList().get(0), resources.get(0));

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
  public void listNotificationSubscriptionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listNotificationSubscriptions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationSubscriptionsTest2() throws Exception {
    NotificationSubscription responsesElement = NotificationSubscription.newBuilder().build();
    ListNotificationSubscriptionsResponse expectedResponse =
        ListNotificationSubscriptionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotificationSubscriptions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";

    ListNotificationSubscriptionsPagedResponse pagedListResponse =
        client.listNotificationSubscriptions(parent);

    List<NotificationSubscription> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getNotificationSubscriptionsList().get(0), resources.get(0));

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
  public void listNotificationSubscriptionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      client.listNotificationSubscriptions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
