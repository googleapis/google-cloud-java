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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.DaiAuthenticationKeyServiceClient.ListDaiAuthenticationKeysPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonDaiAuthenticationKeyServiceStub;
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
public class DaiAuthenticationKeyServiceClientTest {
  private static MockHttpService mockService;
  private static DaiAuthenticationKeyServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDaiAuthenticationKeyServiceStub.getMethodDescriptors(),
            DaiAuthenticationKeyServiceSettings.getDefaultEndpoint());
    DaiAuthenticationKeyServiceSettings settings =
        DaiAuthenticationKeyServiceSettings.newBuilder()
            .setTransportChannelProvider(
                DaiAuthenticationKeyServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DaiAuthenticationKeyServiceClient.create(settings);
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
  public void getDaiAuthenticationKeyTest() throws Exception {
    DaiAuthenticationKey expectedResponse =
        DaiAuthenticationKey.newBuilder()
            .setName(
                DaiAuthenticationKeyName.of("[NETWORK_CODE]", "[DAI_AUTHENTICATION_KEY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    DaiAuthenticationKeyName name =
        DaiAuthenticationKeyName.of("[NETWORK_CODE]", "[DAI_AUTHENTICATION_KEY]");

    DaiAuthenticationKey actualResponse = client.getDaiAuthenticationKey(name);
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
  public void getDaiAuthenticationKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DaiAuthenticationKeyName name =
          DaiAuthenticationKeyName.of("[NETWORK_CODE]", "[DAI_AUTHENTICATION_KEY]");
      client.getDaiAuthenticationKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDaiAuthenticationKeyTest2() throws Exception {
    DaiAuthenticationKey expectedResponse =
        DaiAuthenticationKey.newBuilder()
            .setName(
                DaiAuthenticationKeyName.of("[NETWORK_CODE]", "[DAI_AUTHENTICATION_KEY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-4161/daiAuthenticationKeys/daiAuthenticationKey-4161";

    DaiAuthenticationKey actualResponse = client.getDaiAuthenticationKey(name);
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
  public void getDaiAuthenticationKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-4161/daiAuthenticationKeys/daiAuthenticationKey-4161";
      client.getDaiAuthenticationKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDaiAuthenticationKeysTest() throws Exception {
    DaiAuthenticationKey responsesElement = DaiAuthenticationKey.newBuilder().build();
    ListDaiAuthenticationKeysResponse expectedResponse =
        ListDaiAuthenticationKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllDaiAuthenticationKeys(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListDaiAuthenticationKeysPagedResponse pagedListResponse =
        client.listDaiAuthenticationKeys(parent);

    List<DaiAuthenticationKey> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDaiAuthenticationKeysList().get(0), resources.get(0));

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
  public void listDaiAuthenticationKeysExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listDaiAuthenticationKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDaiAuthenticationKeysTest2() throws Exception {
    DaiAuthenticationKey responsesElement = DaiAuthenticationKey.newBuilder().build();
    ListDaiAuthenticationKeysResponse expectedResponse =
        ListDaiAuthenticationKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllDaiAuthenticationKeys(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListDaiAuthenticationKeysPagedResponse pagedListResponse =
        client.listDaiAuthenticationKeys(parent);

    List<DaiAuthenticationKey> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDaiAuthenticationKeysList().get(0), resources.get(0));

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
  public void listDaiAuthenticationKeysExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listDaiAuthenticationKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDaiAuthenticationKeyTest() throws Exception {
    DaiAuthenticationKey expectedResponse =
        DaiAuthenticationKey.newBuilder()
            .setName(
                DaiAuthenticationKeyName.of("[NETWORK_CODE]", "[DAI_AUTHENTICATION_KEY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    DaiAuthenticationKey daiAuthenticationKey = DaiAuthenticationKey.newBuilder().build();

    DaiAuthenticationKey actualResponse =
        client.createDaiAuthenticationKey(parent, daiAuthenticationKey);
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
  public void createDaiAuthenticationKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      DaiAuthenticationKey daiAuthenticationKey = DaiAuthenticationKey.newBuilder().build();
      client.createDaiAuthenticationKey(parent, daiAuthenticationKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDaiAuthenticationKeyTest2() throws Exception {
    DaiAuthenticationKey expectedResponse =
        DaiAuthenticationKey.newBuilder()
            .setName(
                DaiAuthenticationKeyName.of("[NETWORK_CODE]", "[DAI_AUTHENTICATION_KEY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    DaiAuthenticationKey daiAuthenticationKey = DaiAuthenticationKey.newBuilder().build();

    DaiAuthenticationKey actualResponse =
        client.createDaiAuthenticationKey(parent, daiAuthenticationKey);
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
  public void createDaiAuthenticationKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      DaiAuthenticationKey daiAuthenticationKey = DaiAuthenticationKey.newBuilder().build();
      client.createDaiAuthenticationKey(parent, daiAuthenticationKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateDaiAuthenticationKeysTest() throws Exception {
    BatchCreateDaiAuthenticationKeysResponse expectedResponse =
        BatchCreateDaiAuthenticationKeysResponse.newBuilder()
            .addAllDaiAuthenticationKeys(new ArrayList<DaiAuthenticationKey>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<CreateDaiAuthenticationKeyRequest> requests = new ArrayList<>();

    BatchCreateDaiAuthenticationKeysResponse actualResponse =
        client.batchCreateDaiAuthenticationKeys(parent, requests);
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
  public void batchCreateDaiAuthenticationKeysExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<CreateDaiAuthenticationKeyRequest> requests = new ArrayList<>();
      client.batchCreateDaiAuthenticationKeys(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateDaiAuthenticationKeysTest2() throws Exception {
    BatchCreateDaiAuthenticationKeysResponse expectedResponse =
        BatchCreateDaiAuthenticationKeysResponse.newBuilder()
            .addAllDaiAuthenticationKeys(new ArrayList<DaiAuthenticationKey>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<CreateDaiAuthenticationKeyRequest> requests = new ArrayList<>();

    BatchCreateDaiAuthenticationKeysResponse actualResponse =
        client.batchCreateDaiAuthenticationKeys(parent, requests);
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
  public void batchCreateDaiAuthenticationKeysExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<CreateDaiAuthenticationKeyRequest> requests = new ArrayList<>();
      client.batchCreateDaiAuthenticationKeys(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDaiAuthenticationKeyTest() throws Exception {
    DaiAuthenticationKey expectedResponse =
        DaiAuthenticationKey.newBuilder()
            .setName(
                DaiAuthenticationKeyName.of("[NETWORK_CODE]", "[DAI_AUTHENTICATION_KEY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    DaiAuthenticationKey daiAuthenticationKey =
        DaiAuthenticationKey.newBuilder()
            .setName(
                DaiAuthenticationKeyName.of("[NETWORK_CODE]", "[DAI_AUTHENTICATION_KEY]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DaiAuthenticationKey actualResponse =
        client.updateDaiAuthenticationKey(daiAuthenticationKey, updateMask);
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
  public void updateDaiAuthenticationKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DaiAuthenticationKey daiAuthenticationKey =
          DaiAuthenticationKey.newBuilder()
              .setName(
                  DaiAuthenticationKeyName.of("[NETWORK_CODE]", "[DAI_AUTHENTICATION_KEY]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDaiAuthenticationKey(daiAuthenticationKey, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateDaiAuthenticationKeysTest() throws Exception {
    BatchUpdateDaiAuthenticationKeysResponse expectedResponse =
        BatchUpdateDaiAuthenticationKeysResponse.newBuilder()
            .addAllDaiAuthenticationKeys(new ArrayList<DaiAuthenticationKey>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<UpdateDaiAuthenticationKeyRequest> requests = new ArrayList<>();

    BatchUpdateDaiAuthenticationKeysResponse actualResponse =
        client.batchUpdateDaiAuthenticationKeys(parent, requests);
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
  public void batchUpdateDaiAuthenticationKeysExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<UpdateDaiAuthenticationKeyRequest> requests = new ArrayList<>();
      client.batchUpdateDaiAuthenticationKeys(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateDaiAuthenticationKeysTest2() throws Exception {
    BatchUpdateDaiAuthenticationKeysResponse expectedResponse =
        BatchUpdateDaiAuthenticationKeysResponse.newBuilder()
            .addAllDaiAuthenticationKeys(new ArrayList<DaiAuthenticationKey>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<UpdateDaiAuthenticationKeyRequest> requests = new ArrayList<>();

    BatchUpdateDaiAuthenticationKeysResponse actualResponse =
        client.batchUpdateDaiAuthenticationKeys(parent, requests);
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
  public void batchUpdateDaiAuthenticationKeysExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<UpdateDaiAuthenticationKeyRequest> requests = new ArrayList<>();
      client.batchUpdateDaiAuthenticationKeys(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchActivateDaiAuthenticationKeysTest() throws Exception {
    BatchActivateDaiAuthenticationKeysResponse expectedResponse =
        BatchActivateDaiAuthenticationKeysResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchActivateDaiAuthenticationKeysResponse actualResponse =
        client.batchActivateDaiAuthenticationKeys(parent, names);
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
  public void batchActivateDaiAuthenticationKeysExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchActivateDaiAuthenticationKeys(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchActivateDaiAuthenticationKeysTest2() throws Exception {
    BatchActivateDaiAuthenticationKeysResponse expectedResponse =
        BatchActivateDaiAuthenticationKeysResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchActivateDaiAuthenticationKeysResponse actualResponse =
        client.batchActivateDaiAuthenticationKeys(parent, names);
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
  public void batchActivateDaiAuthenticationKeysExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchActivateDaiAuthenticationKeys(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeactivateDaiAuthenticationKeysTest() throws Exception {
    BatchDeactivateDaiAuthenticationKeysResponse expectedResponse =
        BatchDeactivateDaiAuthenticationKeysResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<String> names = new ArrayList<>();

    BatchDeactivateDaiAuthenticationKeysResponse actualResponse =
        client.batchDeactivateDaiAuthenticationKeys(parent, names);
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
  public void batchDeactivateDaiAuthenticationKeysExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<String> names = new ArrayList<>();
      client.batchDeactivateDaiAuthenticationKeys(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeactivateDaiAuthenticationKeysTest2() throws Exception {
    BatchDeactivateDaiAuthenticationKeysResponse expectedResponse =
        BatchDeactivateDaiAuthenticationKeysResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<String> names = new ArrayList<>();

    BatchDeactivateDaiAuthenticationKeysResponse actualResponse =
        client.batchDeactivateDaiAuthenticationKeys(parent, names);
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
  public void batchDeactivateDaiAuthenticationKeysExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<String> names = new ArrayList<>();
      client.batchDeactivateDaiAuthenticationKeys(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
