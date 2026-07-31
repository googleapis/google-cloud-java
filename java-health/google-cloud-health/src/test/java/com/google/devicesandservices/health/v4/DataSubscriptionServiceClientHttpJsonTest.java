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

import static com.google.devicesandservices.health.v4.DataSubscriptionServiceClient.ListSubscribersPagedResponse;
import static com.google.devicesandservices.health.v4.DataSubscriptionServiceClient.ListSubscriptionsPagedResponse;

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
import com.google.devicesandservices.health.v4.stub.HttpJsonDataSubscriptionServiceStub;
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
public class DataSubscriptionServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DataSubscriptionServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDataSubscriptionServiceStub.getMethodDescriptors(),
            DataSubscriptionServiceSettings.getDefaultEndpoint());
    DataSubscriptionServiceSettings settings =
        DataSubscriptionServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DataSubscriptionServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataSubscriptionServiceClient.create(settings);
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
  public void createSubscriberTest() throws Exception {
    Subscriber expectedResponse =
        Subscriber.newBuilder()
            .setName(SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString())
            .setEndpointUri("endpointUri-1135817833")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllSubscriberConfigs(new ArrayList<SubscriberConfig>())
            .setEndpointAuthorization(EndpointAuthorization.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSubscriberTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ProjectName parent = ProjectName.of("[PROJECT]");
    CreateSubscriberPayload subscriber = CreateSubscriberPayload.newBuilder().build();
    String subscriberId = "subscriberId327834531";

    Subscriber actualResponse =
        client.createSubscriberAsync(parent, subscriber, subscriberId).get();
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
  public void createSubscriberExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      CreateSubscriberPayload subscriber = CreateSubscriberPayload.newBuilder().build();
      String subscriberId = "subscriberId327834531";
      client.createSubscriberAsync(parent, subscriber, subscriberId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createSubscriberTest2() throws Exception {
    Subscriber expectedResponse =
        Subscriber.newBuilder()
            .setName(SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString())
            .setEndpointUri("endpointUri-1135817833")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllSubscriberConfigs(new ArrayList<SubscriberConfig>())
            .setEndpointAuthorization(EndpointAuthorization.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSubscriberTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-2353";
    CreateSubscriberPayload subscriber = CreateSubscriberPayload.newBuilder().build();
    String subscriberId = "subscriberId327834531";

    Subscriber actualResponse =
        client.createSubscriberAsync(parent, subscriber, subscriberId).get();
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
  public void createSubscriberExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      CreateSubscriberPayload subscriber = CreateSubscriberPayload.newBuilder().build();
      String subscriberId = "subscriberId327834531";
      client.createSubscriberAsync(parent, subscriber, subscriberId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listSubscribersTest() throws Exception {
    Subscriber responsesElement = Subscriber.newBuilder().build();
    ListSubscribersResponse expectedResponse =
        ListSubscribersResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubscribers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListSubscribersPagedResponse pagedListResponse = client.listSubscribers(parent);

    List<Subscriber> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubscribersList().get(0), resources.get(0));

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
  public void listSubscribersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listSubscribers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSubscribersTest2() throws Exception {
    Subscriber responsesElement = Subscriber.newBuilder().build();
    ListSubscribersResponse expectedResponse =
        ListSubscribersResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubscribers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";

    ListSubscribersPagedResponse pagedListResponse = client.listSubscribers(parent);

    List<Subscriber> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSubscribersList().get(0), resources.get(0));

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
  public void listSubscribersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      client.listSubscribers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSubscriberTest() throws Exception {
    Subscriber expectedResponse =
        Subscriber.newBuilder()
            .setName(SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString())
            .setEndpointUri("endpointUri-1135817833")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllSubscriberConfigs(new ArrayList<SubscriberConfig>())
            .setEndpointAuthorization(EndpointAuthorization.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSubscriberTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Subscriber subscriber =
        Subscriber.newBuilder()
            .setName(SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString())
            .setEndpointUri("endpointUri-1135817833")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllSubscriberConfigs(new ArrayList<SubscriberConfig>())
            .setEndpointAuthorization(EndpointAuthorization.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Subscriber actualResponse = client.updateSubscriberAsync(subscriber, updateMask).get();
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
  public void updateSubscriberExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Subscriber subscriber =
          Subscriber.newBuilder()
              .setName(SubscriberName.of("[PROJECT]", "[SUBSCRIBER]").toString())
              .setEndpointUri("endpointUri-1135817833")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .addAllSubscriberConfigs(new ArrayList<SubscriberConfig>())
              .setEndpointAuthorization(EndpointAuthorization.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSubscriberAsync(subscriber, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteSubscriberTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSubscriberTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SubscriberName name = SubscriberName.of("[PROJECT]", "[SUBSCRIBER]");

    client.deleteSubscriberAsync(name).get();

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
  public void deleteSubscriberExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SubscriberName name = SubscriberName.of("[PROJECT]", "[SUBSCRIBER]");
      client.deleteSubscriberAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteSubscriberTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSubscriberTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-1623/subscribers/subscriber-1623";

    client.deleteSubscriberAsync(name).get();

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
  public void deleteSubscriberExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1623/subscribers/subscriber-1623";
      client.deleteSubscriberAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createSubscriptionTest() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[PROJECT]", "[SUBSCRIBER]", "[SUBSCRIPTION]").toString())
            .addAllDataTypes(new ArrayList<String>())
            .setUser(UserName.of("[USER]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    SubscriberName parent = SubscriberName.of("[PROJECT]", "[SUBSCRIBER]");
    CreateSubscriptionPayload subscription = CreateSubscriptionPayload.newBuilder().build();
    String subscriptionId = "subscriptionId1478790936";

    Subscription actualResponse = client.createSubscription(parent, subscription, subscriptionId);
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
      SubscriberName parent = SubscriberName.of("[PROJECT]", "[SUBSCRIBER]");
      CreateSubscriptionPayload subscription = CreateSubscriptionPayload.newBuilder().build();
      String subscriptionId = "subscriptionId1478790936";
      client.createSubscription(parent, subscription, subscriptionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSubscriptionTest2() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[PROJECT]", "[SUBSCRIBER]", "[SUBSCRIPTION]").toString())
            .addAllDataTypes(new ArrayList<String>())
            .setUser(UserName.of("[USER]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-954/subscribers/subscriber-954";
    CreateSubscriptionPayload subscription = CreateSubscriptionPayload.newBuilder().build();
    String subscriptionId = "subscriptionId1478790936";

    Subscription actualResponse = client.createSubscription(parent, subscription, subscriptionId);
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
  public void createSubscriptionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-954/subscribers/subscriber-954";
      CreateSubscriptionPayload subscription = CreateSubscriptionPayload.newBuilder().build();
      String subscriptionId = "subscriptionId1478790936";
      client.createSubscription(parent, subscription, subscriptionId);
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

    SubscriberName parent = SubscriberName.of("[PROJECT]", "[SUBSCRIBER]");

    ListSubscriptionsPagedResponse pagedListResponse = client.listSubscriptions(parent);

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
      SubscriberName parent = SubscriberName.of("[PROJECT]", "[SUBSCRIBER]");
      client.listSubscriptions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSubscriptionsTest2() throws Exception {
    Subscription responsesElement = Subscription.newBuilder().build();
    ListSubscriptionsResponse expectedResponse =
        ListSubscriptionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSubscriptions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-954/subscribers/subscriber-954";

    ListSubscriptionsPagedResponse pagedListResponse = client.listSubscriptions(parent);

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
  public void listSubscriptionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-954/subscribers/subscriber-954";
      client.listSubscriptions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSubscriptionTest() throws Exception {
    Subscription expectedResponse =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[PROJECT]", "[SUBSCRIBER]", "[SUBSCRIPTION]").toString())
            .addAllDataTypes(new ArrayList<String>())
            .setUser(UserName.of("[USER]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    Subscription subscription =
        Subscription.newBuilder()
            .setName(SubscriptionName.of("[PROJECT]", "[SUBSCRIBER]", "[SUBSCRIPTION]").toString())
            .addAllDataTypes(new ArrayList<String>())
            .setUser(UserName.of("[USER]").toString())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Subscription actualResponse = client.updateSubscription(subscription, updateMask);
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
              .setName(
                  SubscriptionName.of("[PROJECT]", "[SUBSCRIBER]", "[SUBSCRIPTION]").toString())
              .addAllDataTypes(new ArrayList<String>())
              .setUser(UserName.of("[USER]").toString())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSubscription(subscription, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSubscriptionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SubscriptionName name = SubscriptionName.of("[PROJECT]", "[SUBSCRIBER]", "[SUBSCRIPTION]");

    client.deleteSubscription(name);

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
      SubscriptionName name = SubscriptionName.of("[PROJECT]", "[SUBSCRIBER]", "[SUBSCRIPTION]");
      client.deleteSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSubscriptionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-217/subscribers/subscriber-217/subscriptions/subscription-217";

    client.deleteSubscription(name);

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
      String name =
          "projects/project-217/subscribers/subscriber-217/subscriptions/subscription-217";
      client.deleteSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
