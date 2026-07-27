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

package com.google.cloud.support.v2;

import static com.google.cloud.support.v2.SupportEventSubscriptionServiceClient.ListSupportEventSubscriptionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.support.v2.stub.HttpJsonSupportEventSubscriptionServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class SupportEventSubscriptionServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SupportEventSubscriptionServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSupportEventSubscriptionServiceStub.getMethodDescriptors(),
            SupportEventSubscriptionServiceSettings.getDefaultEndpoint());
    SupportEventSubscriptionServiceSettings settings =
        SupportEventSubscriptionServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SupportEventSubscriptionServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SupportEventSubscriptionServiceClient.create(settings);
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
  public void createSupportEventSubscriptionTest() throws Exception {
    SupportEventSubscription expectedResponse =
        SupportEventSubscription.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .setPubSubTopic("pubSubTopic320524524")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    SupportEventSubscription supportEventSubscription =
        SupportEventSubscription.newBuilder().build();

    SupportEventSubscription actualResponse =
        client.createSupportEventSubscription(parent, supportEventSubscription);
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
  public void createSupportEventSubscriptionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      SupportEventSubscription supportEventSubscription =
          SupportEventSubscription.newBuilder().build();
      client.createSupportEventSubscription(parent, supportEventSubscription);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSupportEventSubscriptionTest2() throws Exception {
    SupportEventSubscription expectedResponse =
        SupportEventSubscription.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .setPubSubTopic("pubSubTopic320524524")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "parent-4715/parent-4715";
    SupportEventSubscription supportEventSubscription =
        SupportEventSubscription.newBuilder().build();

    SupportEventSubscription actualResponse =
        client.createSupportEventSubscription(parent, supportEventSubscription);
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
  public void createSupportEventSubscriptionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "parent-4715/parent-4715";
      SupportEventSubscription supportEventSubscription =
          SupportEventSubscription.newBuilder().build();
      client.createSupportEventSubscription(parent, supportEventSubscription);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSupportEventSubscriptionTest() throws Exception {
    SupportEventSubscription expectedResponse =
        SupportEventSubscription.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .setPubSubTopic("pubSubTopic320524524")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SupportEventSubscriptionName name =
        SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]");

    SupportEventSubscription actualResponse = client.getSupportEventSubscription(name);
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
  public void getSupportEventSubscriptionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SupportEventSubscriptionName name =
          SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]");
      client.getSupportEventSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSupportEventSubscriptionTest2() throws Exception {
    SupportEventSubscription expectedResponse =
        SupportEventSubscription.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .setPubSubTopic("pubSubTopic320524524")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "name-3007/name-3007/supportEventSubscriptions/supportEventSubscription-3007";

    SupportEventSubscription actualResponse = client.getSupportEventSubscription(name);
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
  public void getSupportEventSubscriptionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "name-3007/name-3007/supportEventSubscriptions/supportEventSubscription-3007";
      client.getSupportEventSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSupportEventSubscriptionsTest() throws Exception {
    SupportEventSubscription responsesElement = SupportEventSubscription.newBuilder().build();
    ListSupportEventSubscriptionsResponse expectedResponse =
        ListSupportEventSubscriptionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSupportEventSubscriptions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListSupportEventSubscriptionsPagedResponse pagedListResponse =
        client.listSupportEventSubscriptions(parent);

    List<SupportEventSubscription> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSupportEventSubscriptionsList().get(0), resources.get(0));

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
  public void listSupportEventSubscriptionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listSupportEventSubscriptions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSupportEventSubscriptionsTest2() throws Exception {
    SupportEventSubscription responsesElement = SupportEventSubscription.newBuilder().build();
    ListSupportEventSubscriptionsResponse expectedResponse =
        ListSupportEventSubscriptionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSupportEventSubscriptions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "parent-4715/parent-4715";

    ListSupportEventSubscriptionsPagedResponse pagedListResponse =
        client.listSupportEventSubscriptions(parent);

    List<SupportEventSubscription> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getSupportEventSubscriptionsList().get(0), resources.get(0));

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
  public void listSupportEventSubscriptionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "parent-4715/parent-4715";
      client.listSupportEventSubscriptions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSupportEventSubscriptionTest() throws Exception {
    SupportEventSubscription expectedResponse =
        SupportEventSubscription.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .setPubSubTopic("pubSubTopic320524524")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SupportEventSubscription supportEventSubscription =
        SupportEventSubscription.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .setPubSubTopic("pubSubTopic320524524")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SupportEventSubscription actualResponse =
        client.updateSupportEventSubscription(supportEventSubscription, updateMask);
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
  public void updateSupportEventSubscriptionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SupportEventSubscription supportEventSubscription =
          SupportEventSubscription.newBuilder()
              .setName(
                  SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                      .toString())
              .setPubSubTopic("pubSubTopic320524524")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setPurgeTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSupportEventSubscription(supportEventSubscription, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSupportEventSubscriptionTest() throws Exception {
    SupportEventSubscription expectedResponse =
        SupportEventSubscription.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .setPubSubTopic("pubSubTopic320524524")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SupportEventSubscriptionName name =
        SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]");

    SupportEventSubscription actualResponse = client.deleteSupportEventSubscription(name);
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
  public void deleteSupportEventSubscriptionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SupportEventSubscriptionName name =
          SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]");
      client.deleteSupportEventSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSupportEventSubscriptionTest2() throws Exception {
    SupportEventSubscription expectedResponse =
        SupportEventSubscription.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .setPubSubTopic("pubSubTopic320524524")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "name-3007/name-3007/supportEventSubscriptions/supportEventSubscription-3007";

    SupportEventSubscription actualResponse = client.deleteSupportEventSubscription(name);
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
  public void deleteSupportEventSubscriptionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "name-3007/name-3007/supportEventSubscriptions/supportEventSubscription-3007";
      client.deleteSupportEventSubscription(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void undeleteSupportEventSubscriptionTest() throws Exception {
    SupportEventSubscription expectedResponse =
        SupportEventSubscription.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .setPubSubTopic("pubSubTopic320524524")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    UndeleteSupportEventSubscriptionRequest request =
        UndeleteSupportEventSubscriptionRequest.newBuilder()
            .setName(
                SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                    .toString())
            .build();

    SupportEventSubscription actualResponse = client.undeleteSupportEventSubscription(request);
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
  public void undeleteSupportEventSubscriptionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UndeleteSupportEventSubscriptionRequest request =
          UndeleteSupportEventSubscriptionRequest.newBuilder()
              .setName(
                  SupportEventSubscriptionName.of("[ORGANIZATION]", "[SUPPORT_EVENT_SUBSCRIPTION]")
                      .toString())
              .build();
      client.undeleteSupportEventSubscription(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
