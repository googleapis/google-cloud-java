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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.CustomTargetingValueServiceClient.ListCustomTargetingValuesPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonCustomTargetingValueServiceStub;
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
public class CustomTargetingValueServiceClientTest {
  private static MockHttpService mockService;
  private static CustomTargetingValueServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCustomTargetingValueServiceStub.getMethodDescriptors(),
            CustomTargetingValueServiceSettings.getDefaultEndpoint());
    CustomTargetingValueServiceSettings settings =
        CustomTargetingValueServiceSettings.newBuilder()
            .setTransportChannelProvider(
                CustomTargetingValueServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CustomTargetingValueServiceClient.create(settings);
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
  public void getCustomTargetingValueTest() throws Exception {
    CustomTargetingValue expectedResponse =
        CustomTargetingValue.newBuilder()
            .setName(
                CustomTargetingValueName.of(
                        "[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]", "[CUSTOM_TARGETING_VALUE]")
                    .toString())
            .setAdTagName("adTagName-926580830")
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    CustomTargetingValueName name =
        CustomTargetingValueName.of(
            "[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]", "[CUSTOM_TARGETING_VALUE]");

    CustomTargetingValue actualResponse = client.getCustomTargetingValue(name);
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
  public void getCustomTargetingValueExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomTargetingValueName name =
          CustomTargetingValueName.of(
              "[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]", "[CUSTOM_TARGETING_VALUE]");
      client.getCustomTargetingValue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomTargetingValueTest2() throws Exception {
    CustomTargetingValue expectedResponse =
        CustomTargetingValue.newBuilder()
            .setName(
                CustomTargetingValueName.of(
                        "[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]", "[CUSTOM_TARGETING_VALUE]")
                    .toString())
            .setAdTagName("adTagName-926580830")
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "networks/network-4153/customTargetingKeys/customTargetingKey-4153/customTargetingValues/customTargetingValue-4153";

    CustomTargetingValue actualResponse = client.getCustomTargetingValue(name);
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
  public void getCustomTargetingValueExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "networks/network-4153/customTargetingKeys/customTargetingKey-4153/customTargetingValues/customTargetingValue-4153";
      client.getCustomTargetingValue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomTargetingValuesTest() throws Exception {
    CustomTargetingValue responsesElement = CustomTargetingValue.newBuilder().build();
    ListCustomTargetingValuesResponse expectedResponse =
        ListCustomTargetingValuesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomTargetingValues(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CustomTargetingKeyName parent =
        CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]");

    ListCustomTargetingValuesPagedResponse pagedListResponse =
        client.listCustomTargetingValues(parent);

    List<CustomTargetingValue> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomTargetingValuesList().get(0), resources.get(0));

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
  public void listCustomTargetingValuesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomTargetingKeyName parent =
          CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]");
      client.listCustomTargetingValues(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomTargetingValuesTest2() throws Exception {
    CustomTargetingValue responsesElement = CustomTargetingValue.newBuilder().build();
    ListCustomTargetingValuesResponse expectedResponse =
        ListCustomTargetingValuesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomTargetingValues(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-3002/customTargetingKeys/customTargetingKey-3002";

    ListCustomTargetingValuesPagedResponse pagedListResponse =
        client.listCustomTargetingValues(parent);

    List<CustomTargetingValue> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomTargetingValuesList().get(0), resources.get(0));

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
  public void listCustomTargetingValuesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-3002/customTargetingKeys/customTargetingKey-3002";
      client.listCustomTargetingValues(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
