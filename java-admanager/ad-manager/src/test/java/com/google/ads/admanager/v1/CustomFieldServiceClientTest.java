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

import static com.google.ads.admanager.v1.CustomFieldServiceClient.ListCustomFieldsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonCustomFieldServiceStub;
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
public class CustomFieldServiceClientTest {
  private static MockHttpService mockService;
  private static CustomFieldServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCustomFieldServiceStub.getMethodDescriptors(),
            CustomFieldServiceSettings.getDefaultEndpoint());
    CustomFieldServiceSettings settings =
        CustomFieldServiceSettings.newBuilder()
            .setTransportChannelProvider(
                CustomFieldServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CustomFieldServiceClient.create(settings);
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
  public void getCustomFieldTest() throws Exception {
    CustomField expectedResponse =
        CustomField.newBuilder()
            .setName(CustomFieldName.of("[NETWORK_CODE]", "[CUSTOM_FIELD]").toString())
            .setCustomFieldId(-66688114)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllOptions(new ArrayList<CustomFieldOption>())
            .build();
    mockService.addResponse(expectedResponse);

    CustomFieldName name = CustomFieldName.of("[NETWORK_CODE]", "[CUSTOM_FIELD]");

    CustomField actualResponse = client.getCustomField(name);
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
  public void getCustomFieldExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomFieldName name = CustomFieldName.of("[NETWORK_CODE]", "[CUSTOM_FIELD]");
      client.getCustomField(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomFieldTest2() throws Exception {
    CustomField expectedResponse =
        CustomField.newBuilder()
            .setName(CustomFieldName.of("[NETWORK_CODE]", "[CUSTOM_FIELD]").toString())
            .setCustomFieldId(-66688114)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllOptions(new ArrayList<CustomFieldOption>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-1479/customFields/customField-1479";

    CustomField actualResponse = client.getCustomField(name);
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
  public void getCustomFieldExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-1479/customFields/customField-1479";
      client.getCustomField(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomFieldsTest() throws Exception {
    CustomField responsesElement = CustomField.newBuilder().build();
    ListCustomFieldsResponse expectedResponse =
        ListCustomFieldsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomFields(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListCustomFieldsPagedResponse pagedListResponse = client.listCustomFields(parent);

    List<CustomField> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomFieldsList().get(0), resources.get(0));

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
  public void listCustomFieldsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listCustomFields(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomFieldsTest2() throws Exception {
    CustomField responsesElement = CustomField.newBuilder().build();
    ListCustomFieldsResponse expectedResponse =
        ListCustomFieldsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomFields(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListCustomFieldsPagedResponse pagedListResponse = client.listCustomFields(parent);

    List<CustomField> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomFieldsList().get(0), resources.get(0));

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
  public void listCustomFieldsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listCustomFields(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
