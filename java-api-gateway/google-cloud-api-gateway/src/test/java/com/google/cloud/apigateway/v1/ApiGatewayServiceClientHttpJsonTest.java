/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.apigateway.v1;

import static com.google.cloud.apigateway.v1.ApiGatewayServiceClient.ListApiConfigsPagedResponse;
import static com.google.cloud.apigateway.v1.ApiGatewayServiceClient.ListApisPagedResponse;
import static com.google.cloud.apigateway.v1.ApiGatewayServiceClient.ListGatewaysPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.apigateway.v1.stub.HttpJsonApiGatewayServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class ApiGatewayServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ApiGatewayServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonApiGatewayServiceStub.getMethodDescriptors(),
            ApiGatewayServiceSettings.getDefaultEndpoint());
    ApiGatewayServiceSettings settings =
        ApiGatewayServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ApiGatewayServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ApiGatewayServiceClient.create(settings);
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
  public void listGatewaysTest() throws Exception {
    Gateway responsesElement = Gateway.newBuilder().build();
    ListGatewaysResponse expectedResponse =
        ListGatewaysResponse.newBuilder()
            .setNextPageToken("")
            .addAllGateways(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListGatewaysPagedResponse pagedListResponse = client.listGateways(parent);

    List<Gateway> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGatewaysList().get(0), resources.get(0));

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
  public void listGatewaysExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listGateways(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGatewaysTest2() throws Exception {
    Gateway responsesElement = Gateway.newBuilder().build();
    ListGatewaysResponse expectedResponse =
        ListGatewaysResponse.newBuilder()
            .setNextPageToken("")
            .addAllGateways(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListGatewaysPagedResponse pagedListResponse = client.listGateways(parent);

    List<Gateway> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGatewaysList().get(0), resources.get(0));

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
  public void listGatewaysExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listGateways(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGatewayTest() throws Exception {
    Gateway expectedResponse =
        Gateway.newBuilder()
            .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setApiConfig(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
            .setDefaultHostname("defaultHostname1698284948")
            .build();
    mockService.addResponse(expectedResponse);

    GatewayName name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]");

    Gateway actualResponse = client.getGateway(name);
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
  public void getGatewayExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GatewayName name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]");
      client.getGateway(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGatewayTest2() throws Exception {
    Gateway expectedResponse =
        Gateway.newBuilder()
            .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setApiConfig(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
            .setDefaultHostname("defaultHostname1698284948")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4351/locations/location-4351/gateways/gateway-4351";

    Gateway actualResponse = client.getGateway(name);
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
  public void getGatewayExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4351/locations/location-4351/gateways/gateway-4351";
      client.getGateway(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGatewayTest() throws Exception {
    Gateway expectedResponse =
        Gateway.newBuilder()
            .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setApiConfig(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
            .setDefaultHostname("defaultHostname1698284948")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGatewayTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Gateway gateway = Gateway.newBuilder().build();
    String gatewayId = "gatewayId-1354641793";

    Gateway actualResponse = client.createGatewayAsync(parent, gateway, gatewayId).get();
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
  public void createGatewayExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Gateway gateway = Gateway.newBuilder().build();
      String gatewayId = "gatewayId-1354641793";
      client.createGatewayAsync(parent, gateway, gatewayId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createGatewayTest2() throws Exception {
    Gateway expectedResponse =
        Gateway.newBuilder()
            .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setApiConfig(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
            .setDefaultHostname("defaultHostname1698284948")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGatewayTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Gateway gateway = Gateway.newBuilder().build();
    String gatewayId = "gatewayId-1354641793";

    Gateway actualResponse = client.createGatewayAsync(parent, gateway, gatewayId).get();
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
  public void createGatewayExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Gateway gateway = Gateway.newBuilder().build();
      String gatewayId = "gatewayId-1354641793";
      client.createGatewayAsync(parent, gateway, gatewayId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateGatewayTest() throws Exception {
    Gateway expectedResponse =
        Gateway.newBuilder()
            .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setApiConfig(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
            .setDefaultHostname("defaultHostname1698284948")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateGatewayTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Gateway gateway =
        Gateway.newBuilder()
            .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setApiConfig(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
            .setDefaultHostname("defaultHostname1698284948")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Gateway actualResponse = client.updateGatewayAsync(gateway, updateMask).get();
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
  public void updateGatewayExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Gateway gateway =
          Gateway.newBuilder()
              .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setDisplayName("displayName1714148973")
              .setApiConfig(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
              .setDefaultHostname("defaultHostname1698284948")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGatewayAsync(gateway, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteGatewayTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGatewayTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    GatewayName name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]");

    client.deleteGatewayAsync(name).get();

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
  public void deleteGatewayExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GatewayName name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]");
      client.deleteGatewayAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteGatewayTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGatewayTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-4351/locations/location-4351/gateways/gateway-4351";

    client.deleteGatewayAsync(name).get();

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
  public void deleteGatewayExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4351/locations/location-4351/gateways/gateway-4351";
      client.deleteGatewayAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listApisTest() throws Exception {
    Api responsesElement = Api.newBuilder().build();
    ListApisResponse expectedResponse =
        ListApisResponse.newBuilder()
            .setNextPageToken("")
            .addAllApis(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListApisPagedResponse pagedListResponse = client.listApis(parent);

    List<Api> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApisList().get(0), resources.get(0));

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
  public void listApisExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listApis(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApisTest2() throws Exception {
    Api responsesElement = Api.newBuilder().build();
    ListApisResponse expectedResponse =
        ListApisResponse.newBuilder()
            .setNextPageToken("")
            .addAllApis(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListApisPagedResponse pagedListResponse = client.listApis(parent);

    List<Api> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApisList().get(0), resources.get(0));

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
  public void listApisExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listApis(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApiTest() throws Exception {
    Api expectedResponse =
        Api.newBuilder()
            .setName(ApiName.of("[PROJECT]", "[API]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setManagedService("managedService2047823382")
            .build();
    mockService.addResponse(expectedResponse);

    ApiName name = ApiName.of("[PROJECT]", "[API]");

    Api actualResponse = client.getApi(name);
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
  public void getApiExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiName name = ApiName.of("[PROJECT]", "[API]");
      client.getApi(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApiTest2() throws Exception {
    Api expectedResponse =
        Api.newBuilder()
            .setName(ApiName.of("[PROJECT]", "[API]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setManagedService("managedService2047823382")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3607/locations/location-3607/apis/api-3607";

    Api actualResponse = client.getApi(name);
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
  public void getApiExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3607/locations/location-3607/apis/api-3607";
      client.getApi(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createApiTest() throws Exception {
    Api expectedResponse =
        Api.newBuilder()
            .setName(ApiName.of("[PROJECT]", "[API]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setManagedService("managedService2047823382")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createApiTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Api api = Api.newBuilder().build();
    String apiId = "apiId93021397";

    Api actualResponse = client.createApiAsync(parent, api, apiId).get();
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
  public void createApiExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Api api = Api.newBuilder().build();
      String apiId = "apiId93021397";
      client.createApiAsync(parent, api, apiId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createApiTest2() throws Exception {
    Api expectedResponse =
        Api.newBuilder()
            .setName(ApiName.of("[PROJECT]", "[API]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setManagedService("managedService2047823382")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createApiTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Api api = Api.newBuilder().build();
    String apiId = "apiId93021397";

    Api actualResponse = client.createApiAsync(parent, api, apiId).get();
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
  public void createApiExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Api api = Api.newBuilder().build();
      String apiId = "apiId93021397";
      client.createApiAsync(parent, api, apiId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateApiTest() throws Exception {
    Api expectedResponse =
        Api.newBuilder()
            .setName(ApiName.of("[PROJECT]", "[API]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setManagedService("managedService2047823382")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateApiTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Api api =
        Api.newBuilder()
            .setName(ApiName.of("[PROJECT]", "[API]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setManagedService("managedService2047823382")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Api actualResponse = client.updateApiAsync(api, updateMask).get();
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
  public void updateApiExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Api api =
          Api.newBuilder()
              .setName(ApiName.of("[PROJECT]", "[API]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setDisplayName("displayName1714148973")
              .setManagedService("managedService2047823382")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateApiAsync(api, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteApiTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteApiTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ApiName name = ApiName.of("[PROJECT]", "[API]");

    client.deleteApiAsync(name).get();

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
  public void deleteApiExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiName name = ApiName.of("[PROJECT]", "[API]");
      client.deleteApiAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteApiTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteApiTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-3607/locations/location-3607/apis/api-3607";

    client.deleteApiAsync(name).get();

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
  public void deleteApiExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3607/locations/location-3607/apis/api-3607";
      client.deleteApiAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listApiConfigsTest() throws Exception {
    ApiConfig responsesElement = ApiConfig.newBuilder().build();
    ListApiConfigsResponse expectedResponse =
        ListApiConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApiConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ApiName parent = ApiName.of("[PROJECT]", "[API]");

    ListApiConfigsPagedResponse pagedListResponse = client.listApiConfigs(parent);

    List<ApiConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApiConfigsList().get(0), resources.get(0));

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
  public void listApiConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiName parent = ApiName.of("[PROJECT]", "[API]");
      client.listApiConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApiConfigsTest2() throws Exception {
    ApiConfig responsesElement = ApiConfig.newBuilder().build();
    ListApiConfigsResponse expectedResponse =
        ListApiConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApiConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7414/locations/location-7414/apis/api-7414";

    ListApiConfigsPagedResponse pagedListResponse = client.listApiConfigs(parent);

    List<ApiConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApiConfigsList().get(0), resources.get(0));

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
  public void listApiConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7414/locations/location-7414/apis/api-7414";
      client.listApiConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApiConfigTest() throws Exception {
    ApiConfig expectedResponse =
        ApiConfig.newBuilder()
            .setName(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setGatewayServiceAccount("gatewayServiceAccount153690396")
            .setServiceConfigId("serviceConfigId650537426")
            .addAllOpenapiDocuments(new ArrayList<ApiConfig.OpenApiDocument>())
            .addAllGrpcServices(new ArrayList<ApiConfig.GrpcServiceDefinition>())
            .addAllManagedServiceConfigs(new ArrayList<ApiConfig.File>())
            .build();
    mockService.addResponse(expectedResponse);

    ApiConfigName name = ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]");

    ApiConfig actualResponse = client.getApiConfig(name);
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
  public void getApiConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiConfigName name = ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]");
      client.getApiConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApiConfigTest2() throws Exception {
    ApiConfig expectedResponse =
        ApiConfig.newBuilder()
            .setName(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setGatewayServiceAccount("gatewayServiceAccount153690396")
            .setServiceConfigId("serviceConfigId650537426")
            .addAllOpenapiDocuments(new ArrayList<ApiConfig.OpenApiDocument>())
            .addAllGrpcServices(new ArrayList<ApiConfig.GrpcServiceDefinition>())
            .addAllManagedServiceConfigs(new ArrayList<ApiConfig.File>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7242/locations/location-7242/apis/api-7242/configs/config-7242";

    ApiConfig actualResponse = client.getApiConfig(name);
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
  public void getApiConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7242/locations/location-7242/apis/api-7242/configs/config-7242";
      client.getApiConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createApiConfigTest() throws Exception {
    ApiConfig expectedResponse =
        ApiConfig.newBuilder()
            .setName(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setGatewayServiceAccount("gatewayServiceAccount153690396")
            .setServiceConfigId("serviceConfigId650537426")
            .addAllOpenapiDocuments(new ArrayList<ApiConfig.OpenApiDocument>())
            .addAllGrpcServices(new ArrayList<ApiConfig.GrpcServiceDefinition>())
            .addAllManagedServiceConfigs(new ArrayList<ApiConfig.File>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createApiConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ApiName parent = ApiName.of("[PROJECT]", "[API]");
    ApiConfig apiConfig = ApiConfig.newBuilder().build();
    String apiConfigId = "apiConfigId-64952265";

    ApiConfig actualResponse = client.createApiConfigAsync(parent, apiConfig, apiConfigId).get();
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
  public void createApiConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiName parent = ApiName.of("[PROJECT]", "[API]");
      ApiConfig apiConfig = ApiConfig.newBuilder().build();
      String apiConfigId = "apiConfigId-64952265";
      client.createApiConfigAsync(parent, apiConfig, apiConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createApiConfigTest2() throws Exception {
    ApiConfig expectedResponse =
        ApiConfig.newBuilder()
            .setName(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setGatewayServiceAccount("gatewayServiceAccount153690396")
            .setServiceConfigId("serviceConfigId650537426")
            .addAllOpenapiDocuments(new ArrayList<ApiConfig.OpenApiDocument>())
            .addAllGrpcServices(new ArrayList<ApiConfig.GrpcServiceDefinition>())
            .addAllManagedServiceConfigs(new ArrayList<ApiConfig.File>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createApiConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-7414/locations/location-7414/apis/api-7414";
    ApiConfig apiConfig = ApiConfig.newBuilder().build();
    String apiConfigId = "apiConfigId-64952265";

    ApiConfig actualResponse = client.createApiConfigAsync(parent, apiConfig, apiConfigId).get();
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
  public void createApiConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7414/locations/location-7414/apis/api-7414";
      ApiConfig apiConfig = ApiConfig.newBuilder().build();
      String apiConfigId = "apiConfigId-64952265";
      client.createApiConfigAsync(parent, apiConfig, apiConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateApiConfigTest() throws Exception {
    ApiConfig expectedResponse =
        ApiConfig.newBuilder()
            .setName(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setGatewayServiceAccount("gatewayServiceAccount153690396")
            .setServiceConfigId("serviceConfigId650537426")
            .addAllOpenapiDocuments(new ArrayList<ApiConfig.OpenApiDocument>())
            .addAllGrpcServices(new ArrayList<ApiConfig.GrpcServiceDefinition>())
            .addAllManagedServiceConfigs(new ArrayList<ApiConfig.File>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateApiConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ApiConfig apiConfig =
        ApiConfig.newBuilder()
            .setName(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setGatewayServiceAccount("gatewayServiceAccount153690396")
            .setServiceConfigId("serviceConfigId650537426")
            .addAllOpenapiDocuments(new ArrayList<ApiConfig.OpenApiDocument>())
            .addAllGrpcServices(new ArrayList<ApiConfig.GrpcServiceDefinition>())
            .addAllManagedServiceConfigs(new ArrayList<ApiConfig.File>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ApiConfig actualResponse = client.updateApiConfigAsync(apiConfig, updateMask).get();
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
  public void updateApiConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiConfig apiConfig =
          ApiConfig.newBuilder()
              .setName(ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setDisplayName("displayName1714148973")
              .setGatewayServiceAccount("gatewayServiceAccount153690396")
              .setServiceConfigId("serviceConfigId650537426")
              .addAllOpenapiDocuments(new ArrayList<ApiConfig.OpenApiDocument>())
              .addAllGrpcServices(new ArrayList<ApiConfig.GrpcServiceDefinition>())
              .addAllManagedServiceConfigs(new ArrayList<ApiConfig.File>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateApiConfigAsync(apiConfig, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteApiConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteApiConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ApiConfigName name = ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]");

    client.deleteApiConfigAsync(name).get();

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
  public void deleteApiConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiConfigName name = ApiConfigName.of("[PROJECT]", "[API]", "[API_CONFIG]");
      client.deleteApiConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteApiConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteApiConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-7242/locations/location-7242/apis/api-7242/configs/config-7242";

    client.deleteApiConfigAsync(name).get();

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
  public void deleteApiConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7242/locations/location-7242/apis/api-7242/configs/config-7242";
      client.deleteApiConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
