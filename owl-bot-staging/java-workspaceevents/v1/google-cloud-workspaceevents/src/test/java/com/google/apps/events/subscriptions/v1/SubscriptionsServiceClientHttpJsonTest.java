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

package com.google.apps.events.subscriptions.v1;

import static com.google.apps.events.subscriptions.v1.SubscriptionsServiceClient.ListSubscriptionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.apps.events.subscriptions.v1.stub.HttpJsonSubscriptionsServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SubscriptionsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SubscriptionsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSubscriptionsServiceStub.getMethodDescriptors(),
            SubscriptionsServiceSettings.getDefaultEndpoint());
    SubscriptionsServiceSettings settings =
        SubscriptionsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SubscriptionsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SubscriptionsServiceClient.create(settings);
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
  public void createSubscriptionTest() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
            .setUid("uid115792")
            .setTargetResource("targetResource-1933150017")
            .addAllEventTypes(new ArrayList<String>())
            .setPayloadOptions(PayloadOptions.newBuilder().build())
            .setNotificationEndpoint(NotificationEndpoint.newBuilder().build())
            .setAuthority("authority1475610435")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSubscriptionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Subscription subscription = Subscription.newBuilder().build();

    Subscription actualResponse = client.createSubscriptionAsync(subscription).get();
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
  public void createSubscriptionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Subscription subscription = Subscription.newBuilder().build();
      client.createSubscriptionAsync(subscription).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteSubscriptionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSubscriptionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SubscriptionName name = SubscriptionName.of("[SUBSCRIPTION]");

    client.deleteSubscriptionAsync(name).get();

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
  public void deleteSubscriptionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SubscriptionName name = SubscriptionName.of("[SUBSCRIPTION]");
      client.deleteSubscriptionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteSubscriptionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSubscriptionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "subscriptions/subscription-922";

    client.deleteSubscriptionAsync(name).get();

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
  public void deleteSubscriptionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "subscriptions/subscription-922";
      client.deleteSubscriptionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getSubscriptionTest() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
            .setUid("uid115792")
            .setTargetResource("targetResource-1933150017")
            .addAllEventTypes(new ArrayList<String>())
            .setPayloadOptions(PayloadOptions.newBuilder().build())
            .setNotificationEndpoint(NotificationEndpoint.newBuilder().build())
            .setAuthority("authority1475610435")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    SubscriptionName name = SubscriptionName.of("[SUBSCRIPTION]");

    Subscription actualResponse = client.getSubscription(name);
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
  public void getSubscriptionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SubscriptionName name = SubscriptionName.of("[SUBSCRIPTION]");
      client.getSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSubscriptionTest2() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
            .setUid("uid115792")
            .setTargetResource("targetResource-1933150017")
            .addAllEventTypes(new ArrayList<String>())
            .setPayloadOptions(PayloadOptions.newBuilder().build())
            .setNotificationEndpoint(NotificationEndpoint.newBuilder().build())
            .setAuthority("authority1475610435")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "subscriptions/subscription-922";

    Subscription actualResponse = client.getSubscription(name);
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
  public void getSubscriptionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "subscriptions/subscription-922";
      client.getSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSubscriptionsTest() throws Exception {
    Subscription responsesElement = Subscription.newBuilder().build();
    ListSubscriptionsResponse expectedResponse =
        ListSubscriptionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubscriptions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String filter = "filter-1274492040";

    ListSubscriptionsPagedResponse pagedListResponse = client.listSubscriptions(filter);

    List<Subscription> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubscriptionsList().get(0), resources.get(0));

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
  public void listSubscriptionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String filter = "filter-1274492040";
      client.listSubscriptions(filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSubscriptionTest() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
            .setUid("uid115792")
            .setTargetResource("targetResource-1933150017")
            .addAllEventTypes(new ArrayList<String>())
            .setPayloadOptions(PayloadOptions.newBuilder().build())
            .setNotificationEndpoint(NotificationEndpoint.newBuilder().build())
            .setAuthority("authority1475610435")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSubscriptionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Subscription subscription =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
            .setUid("uid115792")
            .setTargetResource("targetResource-1933150017")
            .addAllEventTypes(new ArrayList<String>())
            .setPayloadOptions(PayloadOptions.newBuilder().build())
            .setNotificationEndpoint(NotificationEndpoint.newBuilder().build())
            .setAuthority("authority1475610435")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Subscription actualResponse = client.updateSubscriptionAsync(subscription, updateMask).get();
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
  public void updateSubscriptionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Subscription subscription =
          Subscription.newBuilder()
              .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
              .setUid("uid115792")
              .setTargetResource("targetResource-1933150017")
              .addAllEventTypes(new ArrayList<String>())
              .setPayloadOptions(PayloadOptions.newBuilder().build())
              .setNotificationEndpoint(NotificationEndpoint.newBuilder().build())
              .setAuthority("authority1475610435")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setReconciling(true)
              .setEtag("etag3123477")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSubscriptionAsync(subscription, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void reactivateSubscriptionTest() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
            .setUid("uid115792")
            .setTargetResource("targetResource-1933150017")
            .addAllEventTypes(new ArrayList<String>())
            .setPayloadOptions(PayloadOptions.newBuilder().build())
            .setNotificationEndpoint(NotificationEndpoint.newBuilder().build())
            .setAuthority("authority1475610435")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reactivateSubscriptionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SubscriptionName name = SubscriptionName.of("[SUBSCRIPTION]");

    Subscription actualResponse = client.reactivateSubscriptionAsync(name).get();
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
  public void reactivateSubscriptionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SubscriptionName name = SubscriptionName.of("[SUBSCRIPTION]");
      client.reactivateSubscriptionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void reactivateSubscriptionTest2() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[SUBSCRIPTION]").toString())
            .setUid("uid115792")
            .setTargetResource("targetResource-1933150017")
            .addAllEventTypes(new ArrayList<String>())
            .setPayloadOptions(PayloadOptions.newBuilder().build())
            .setNotificationEndpoint(NotificationEndpoint.newBuilder().build())
            .setAuthority("authority1475610435")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setReconciling(true)
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reactivateSubscriptionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "subscriptions/subscription-922";

    Subscription actualResponse = client.reactivateSubscriptionAsync(name).get();
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
  public void reactivateSubscriptionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "subscriptions/subscription-922";
      client.reactivateSubscriptionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
