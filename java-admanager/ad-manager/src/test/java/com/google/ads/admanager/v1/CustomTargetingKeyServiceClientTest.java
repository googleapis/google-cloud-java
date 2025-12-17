/*
 * Copyright 2025 Google LLC
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

import static com.google.ads.admanager.v1.CustomTargetingKeyServiceClient.ListCustomTargetingKeysPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonCustomTargetingKeyServiceStub;
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
import com.google.protobuf.FieldMask;
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
public class CustomTargetingKeyServiceClientTest {
  private static MockHttpService mockService;
  private static CustomTargetingKeyServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCustomTargetingKeyServiceStub.getMethodDescriptors(),
            CustomTargetingKeyServiceSettings.getDefaultEndpoint());
    CustomTargetingKeyServiceSettings settings =
        CustomTargetingKeyServiceSettings.newBuilder()
            .setTransportChannelProvider(
                CustomTargetingKeyServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CustomTargetingKeyServiceClient.create(settings);
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
  public void getCustomTargetingKeyTest() throws Exception {
    CustomTargetingKey expectedResponse =
        CustomTargetingKey.newBuilder()
            .setName(
                CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]").toString())
            .setCustomTargetingKeyId(-138683049)
            .setAdTagName("adTagName-926580830")
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    CustomTargetingKeyName name =
        CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]");

    CustomTargetingKey actualResponse = client.getCustomTargetingKey(name);
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
  public void getCustomTargetingKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomTargetingKeyName name =
          CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]");
      client.getCustomTargetingKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomTargetingKeyTest2() throws Exception {
    CustomTargetingKey expectedResponse =
        CustomTargetingKey.newBuilder()
            .setName(
                CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]").toString())
            .setCustomTargetingKeyId(-138683049)
            .setAdTagName("adTagName-926580830")
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-9211/customTargetingKeys/customTargetingKey-9211";

    CustomTargetingKey actualResponse = client.getCustomTargetingKey(name);
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
  public void getCustomTargetingKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-9211/customTargetingKeys/customTargetingKey-9211";
      client.getCustomTargetingKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomTargetingKeysTest() throws Exception {
    CustomTargetingKey responsesElement = CustomTargetingKey.newBuilder().build();
    ListCustomTargetingKeysResponse expectedResponse =
        ListCustomTargetingKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomTargetingKeys(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListCustomTargetingKeysPagedResponse pagedListResponse = client.listCustomTargetingKeys(parent);

    List<CustomTargetingKey> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomTargetingKeysList().get(0), resources.get(0));

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
  public void listCustomTargetingKeysExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listCustomTargetingKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomTargetingKeysTest2() throws Exception {
    CustomTargetingKey responsesElement = CustomTargetingKey.newBuilder().build();
    ListCustomTargetingKeysResponse expectedResponse =
        ListCustomTargetingKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomTargetingKeys(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListCustomTargetingKeysPagedResponse pagedListResponse = client.listCustomTargetingKeys(parent);

    List<CustomTargetingKey> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomTargetingKeysList().get(0), resources.get(0));

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
  public void listCustomTargetingKeysExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listCustomTargetingKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCustomTargetingKeyTest() throws Exception {
    CustomTargetingKey expectedResponse =
        CustomTargetingKey.newBuilder()
            .setName(
                CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]").toString())
            .setCustomTargetingKeyId(-138683049)
            .setAdTagName("adTagName-926580830")
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    CustomTargetingKey customTargetingKey = CustomTargetingKey.newBuilder().build();

    CustomTargetingKey actualResponse = client.createCustomTargetingKey(parent, customTargetingKey);
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
  public void createCustomTargetingKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      CustomTargetingKey customTargetingKey = CustomTargetingKey.newBuilder().build();
      client.createCustomTargetingKey(parent, customTargetingKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCustomTargetingKeyTest2() throws Exception {
    CustomTargetingKey expectedResponse =
        CustomTargetingKey.newBuilder()
            .setName(
                CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]").toString())
            .setCustomTargetingKeyId(-138683049)
            .setAdTagName("adTagName-926580830")
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    CustomTargetingKey customTargetingKey = CustomTargetingKey.newBuilder().build();

    CustomTargetingKey actualResponse = client.createCustomTargetingKey(parent, customTargetingKey);
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
  public void createCustomTargetingKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      CustomTargetingKey customTargetingKey = CustomTargetingKey.newBuilder().build();
      client.createCustomTargetingKey(parent, customTargetingKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateCustomTargetingKeysTest() throws Exception {
    BatchCreateCustomTargetingKeysResponse expectedResponse =
        BatchCreateCustomTargetingKeysResponse.newBuilder()
            .addAllCustomTargetingKeys(new ArrayList<CustomTargetingKey>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<CreateCustomTargetingKeyRequest> requests = new ArrayList<>();

    BatchCreateCustomTargetingKeysResponse actualResponse =
        client.batchCreateCustomTargetingKeys(parent, requests);
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
  public void batchCreateCustomTargetingKeysExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<CreateCustomTargetingKeyRequest> requests = new ArrayList<>();
      client.batchCreateCustomTargetingKeys(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateCustomTargetingKeysTest2() throws Exception {
    BatchCreateCustomTargetingKeysResponse expectedResponse =
        BatchCreateCustomTargetingKeysResponse.newBuilder()
            .addAllCustomTargetingKeys(new ArrayList<CustomTargetingKey>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<CreateCustomTargetingKeyRequest> requests = new ArrayList<>();

    BatchCreateCustomTargetingKeysResponse actualResponse =
        client.batchCreateCustomTargetingKeys(parent, requests);
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
  public void batchCreateCustomTargetingKeysExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<CreateCustomTargetingKeyRequest> requests = new ArrayList<>();
      client.batchCreateCustomTargetingKeys(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCustomTargetingKeyTest() throws Exception {
    CustomTargetingKey expectedResponse =
        CustomTargetingKey.newBuilder()
            .setName(
                CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]").toString())
            .setCustomTargetingKeyId(-138683049)
            .setAdTagName("adTagName-926580830")
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    CustomTargetingKey customTargetingKey =
        CustomTargetingKey.newBuilder()
            .setName(
                CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]").toString())
            .setCustomTargetingKeyId(-138683049)
            .setAdTagName("adTagName-926580830")
            .setDisplayName("displayName1714148973")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CustomTargetingKey actualResponse =
        client.updateCustomTargetingKey(customTargetingKey, updateMask);
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
  public void updateCustomTargetingKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CustomTargetingKey customTargetingKey =
          CustomTargetingKey.newBuilder()
              .setName(
                  CustomTargetingKeyName.of("[NETWORK_CODE]", "[CUSTOM_TARGETING_KEY]").toString())
              .setCustomTargetingKeyId(-138683049)
              .setAdTagName("adTagName-926580830")
              .setDisplayName("displayName1714148973")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCustomTargetingKey(customTargetingKey, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateCustomTargetingKeysTest() throws Exception {
    BatchUpdateCustomTargetingKeysResponse expectedResponse =
        BatchUpdateCustomTargetingKeysResponse.newBuilder()
            .addAllCustomTargetingKeys(new ArrayList<CustomTargetingKey>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<UpdateCustomTargetingKeyRequest> requests = new ArrayList<>();

    BatchUpdateCustomTargetingKeysResponse actualResponse =
        client.batchUpdateCustomTargetingKeys(parent, requests);
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
  public void batchUpdateCustomTargetingKeysExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<UpdateCustomTargetingKeyRequest> requests = new ArrayList<>();
      client.batchUpdateCustomTargetingKeys(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateCustomTargetingKeysTest2() throws Exception {
    BatchUpdateCustomTargetingKeysResponse expectedResponse =
        BatchUpdateCustomTargetingKeysResponse.newBuilder()
            .addAllCustomTargetingKeys(new ArrayList<CustomTargetingKey>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<UpdateCustomTargetingKeyRequest> requests = new ArrayList<>();

    BatchUpdateCustomTargetingKeysResponse actualResponse =
        client.batchUpdateCustomTargetingKeys(parent, requests);
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
  public void batchUpdateCustomTargetingKeysExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<UpdateCustomTargetingKeyRequest> requests = new ArrayList<>();
      client.batchUpdateCustomTargetingKeys(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchActivateCustomTargetingKeysTest() throws Exception {
    BatchActivateCustomTargetingKeysResponse expectedResponse =
        BatchActivateCustomTargetingKeysResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchActivateCustomTargetingKeysResponse actualResponse =
        client.batchActivateCustomTargetingKeys(parent, names);
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
  public void batchActivateCustomTargetingKeysExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchActivateCustomTargetingKeys(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchActivateCustomTargetingKeysTest2() throws Exception {
    BatchActivateCustomTargetingKeysResponse expectedResponse =
        BatchActivateCustomTargetingKeysResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchActivateCustomTargetingKeysResponse actualResponse =
        client.batchActivateCustomTargetingKeys(parent, names);
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
  public void batchActivateCustomTargetingKeysExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchActivateCustomTargetingKeys(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeactivateCustomTargetingKeysTest() throws Exception {
    BatchDeactivateCustomTargetingKeysResponse expectedResponse =
        BatchDeactivateCustomTargetingKeysResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchDeactivateCustomTargetingKeysResponse actualResponse =
        client.batchDeactivateCustomTargetingKeys(parent, names);
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
  public void batchDeactivateCustomTargetingKeysExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchDeactivateCustomTargetingKeys(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeactivateCustomTargetingKeysTest2() throws Exception {
    BatchDeactivateCustomTargetingKeysResponse expectedResponse =
        BatchDeactivateCustomTargetingKeysResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchDeactivateCustomTargetingKeysResponse actualResponse =
        client.batchDeactivateCustomTargetingKeys(parent, names);
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
  public void batchDeactivateCustomTargetingKeysExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchDeactivateCustomTargetingKeys(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
