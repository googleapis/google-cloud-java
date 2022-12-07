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

package com.google.cloud.apigeeregistry.v1;

import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiDeploymentRevisionsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiDeploymentsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiSpecRevisionsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiSpecsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiVersionsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApisPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListArtifactsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListLocationsPagedResponse;

import com.google.api.HttpBody;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.apigeeregistry.v1.stub.HttpJsonRegistryStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class RegistryClientHttpJsonTest {
  private static MockHttpService mockService;
  private static RegistryClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonRegistryStub.getMethodDescriptors(), RegistrySettings.getDefaultEndpoint());
    RegistrySettings settings =
        RegistrySettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                RegistrySettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RegistryClient.create(settings);
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
            .setName(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAvailability("availability1997542747")
            .setRecommendedVersion(
                ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .setRecommendedDeployment(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ApiName name = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");

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
      ApiName name = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
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
            .setName(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAvailability("availability1997542747")
            .setRecommendedVersion(
                ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .setRecommendedDeployment(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
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
            .setName(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAvailability("availability1997542747")
            .setRecommendedVersion(
                ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .setRecommendedDeployment(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Api api = Api.newBuilder().build();
    String apiId = "apiId93021397";

    Api actualResponse = client.createApi(parent, api, apiId);
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
      client.createApi(parent, api, apiId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createApiTest2() throws Exception {
    Api expectedResponse =
        Api.newBuilder()
            .setName(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAvailability("availability1997542747")
            .setRecommendedVersion(
                ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .setRecommendedDeployment(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    Api api = Api.newBuilder().build();
    String apiId = "apiId93021397";

    Api actualResponse = client.createApi(parent, api, apiId);
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
      client.createApi(parent, api, apiId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateApiTest() throws Exception {
    Api expectedResponse =
        Api.newBuilder()
            .setName(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAvailability("availability1997542747")
            .setRecommendedVersion(
                ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .setRecommendedDeployment(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    Api api =
        Api.newBuilder()
            .setName(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAvailability("availability1997542747")
            .setRecommendedVersion(
                ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .setRecommendedDeployment(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Api actualResponse = client.updateApi(api, updateMask);
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
              .setName(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setAvailability("availability1997542747")
              .setRecommendedVersion(
                  ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
              .setRecommendedDeployment(
                  ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]")
                      .toString())
              .putAllLabels(new HashMap<String, String>())
              .putAllAnnotations(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateApi(api, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApiTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ApiName name = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");

    client.deleteApi(name);

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
      ApiName name = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
      client.deleteApi(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApiTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3607/locations/location-3607/apis/api-3607";

    client.deleteApi(name);

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
      client.deleteApi(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApiVersionsTest() throws Exception {
    ApiVersion responsesElement = ApiVersion.newBuilder().build();
    ListApiVersionsResponse expectedResponse =
        ListApiVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApiVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");

    ListApiVersionsPagedResponse pagedListResponse = client.listApiVersions(parent);

    List<ApiVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApiVersionsList().get(0), resources.get(0));

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
  public void listApiVersionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
      client.listApiVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApiVersionsTest2() throws Exception {
    ApiVersion responsesElement = ApiVersion.newBuilder().build();
    ListApiVersionsResponse expectedResponse =
        ListApiVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApiVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7414/locations/location-7414/apis/api-7414";

    ListApiVersionsPagedResponse pagedListResponse = client.listApiVersions(parent);

    List<ApiVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApiVersionsList().get(0), resources.get(0));

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
  public void listApiVersionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7414/locations/location-7414/apis/api-7414";
      client.listApiVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApiVersionTest() throws Exception {
    ApiVersion expectedResponse =
        ApiVersion.newBuilder()
            .setName(ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setState("state109757585")
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ApiVersionName name = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");

    ApiVersion actualResponse = client.getApiVersion(name);
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
  public void getApiVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiVersionName name = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
      client.getApiVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApiVersionTest2() throws Exception {
    ApiVersion expectedResponse =
        ApiVersion.newBuilder()
            .setName(ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setState("state109757585")
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6412/locations/location-6412/apis/api-6412/versions/version-6412";

    ApiVersion actualResponse = client.getApiVersion(name);
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
  public void getApiVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6412/locations/location-6412/apis/api-6412/versions/version-6412";
      client.getApiVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createApiVersionTest() throws Exception {
    ApiVersion expectedResponse =
        ApiVersion.newBuilder()
            .setName(ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setState("state109757585")
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
    ApiVersion apiVersion = ApiVersion.newBuilder().build();
    String apiVersionId = "apiVersionId1678816025";

    ApiVersion actualResponse = client.createApiVersion(parent, apiVersion, apiVersionId);
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
  public void createApiVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
      ApiVersion apiVersion = ApiVersion.newBuilder().build();
      String apiVersionId = "apiVersionId1678816025";
      client.createApiVersion(parent, apiVersion, apiVersionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createApiVersionTest2() throws Exception {
    ApiVersion expectedResponse =
        ApiVersion.newBuilder()
            .setName(ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setState("state109757585")
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7414/locations/location-7414/apis/api-7414";
    ApiVersion apiVersion = ApiVersion.newBuilder().build();
    String apiVersionId = "apiVersionId1678816025";

    ApiVersion actualResponse = client.createApiVersion(parent, apiVersion, apiVersionId);
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
  public void createApiVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7414/locations/location-7414/apis/api-7414";
      ApiVersion apiVersion = ApiVersion.newBuilder().build();
      String apiVersionId = "apiVersionId1678816025";
      client.createApiVersion(parent, apiVersion, apiVersionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateApiVersionTest() throws Exception {
    ApiVersion expectedResponse =
        ApiVersion.newBuilder()
            .setName(ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setState("state109757585")
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ApiVersion apiVersion =
        ApiVersion.newBuilder()
            .setName(ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setState("state109757585")
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ApiVersion actualResponse = client.updateApiVersion(apiVersion, updateMask);
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
  public void updateApiVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiVersion apiVersion =
          ApiVersion.newBuilder()
              .setName(
                  ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setState("state109757585")
              .putAllLabels(new HashMap<String, String>())
              .putAllAnnotations(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateApiVersion(apiVersion, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApiVersionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ApiVersionName name = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");

    client.deleteApiVersion(name);

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
  public void deleteApiVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiVersionName name = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
      client.deleteApiVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApiVersionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6412/locations/location-6412/apis/api-6412/versions/version-6412";

    client.deleteApiVersion(name);

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
  public void deleteApiVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6412/locations/location-6412/apis/api-6412/versions/version-6412";
      client.deleteApiVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApiSpecsTest() throws Exception {
    ApiSpec responsesElement = ApiSpec.newBuilder().build();
    ListApiSpecsResponse expectedResponse =
        ListApiSpecsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApiSpecs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ApiVersionName parent = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");

    ListApiSpecsPagedResponse pagedListResponse = client.listApiSpecs(parent);

    List<ApiSpec> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApiSpecsList().get(0), resources.get(0));

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
  public void listApiSpecsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiVersionName parent = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
      client.listApiSpecs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApiSpecsTest2() throws Exception {
    ApiSpec responsesElement = ApiSpec.newBuilder().build();
    ListApiSpecsResponse expectedResponse =
        ListApiSpecsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApiSpecs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-1179/locations/location-1179/apis/api-1179/versions/version-1179";

    ListApiSpecsPagedResponse pagedListResponse = client.listApiSpecs(parent);

    List<ApiSpec> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApiSpecsList().get(0), resources.get(0));

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
  public void listApiSpecsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1179/locations/location-1179/apis/api-1179/versions/version-1179";
      client.listApiSpecs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApiSpecTest() throws Exception {
    ApiSpec expectedResponse =
        ApiSpec.newBuilder()
            .setName(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setFilename("filename-734768633")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setSourceUri("sourceUri-1698419887")
            .setContents(ByteString.EMPTY)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ApiSpecName name = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");

    ApiSpec actualResponse = client.getApiSpec(name);
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
  public void getApiSpecExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiSpecName name = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
      client.getApiSpec(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApiSpecTest2() throws Exception {
    ApiSpec expectedResponse =
        ApiSpec.newBuilder()
            .setName(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setFilename("filename-734768633")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setSourceUri("sourceUri-1698419887")
            .setContents(ByteString.EMPTY)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1520/locations/location-1520/apis/api-1520/versions/version-1520/specs/spec-1520";

    ApiSpec actualResponse = client.getApiSpec(name);
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
  public void getApiSpecExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1520/locations/location-1520/apis/api-1520/versions/version-1520/specs/spec-1520";
      client.getApiSpec(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApiSpecContentsTest() throws Exception {
    HttpBody expectedResponse =
        HttpBody.newBuilder()
            .setContentType("contentType-389131437")
            .setData(ByteString.EMPTY)
            .addAllExtensions(new ArrayList<Any>())
            .build();
    mockService.addResponse(expectedResponse);

    ApiSpecName name = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");

    HttpBody actualResponse = client.getApiSpecContents(name);
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
  public void getApiSpecContentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiSpecName name = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
      client.getApiSpecContents(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApiSpecContentsTest2() throws Exception {
    HttpBody expectedResponse =
        HttpBody.newBuilder()
            .setContentType("contentType-389131437")
            .setData(ByteString.EMPTY)
            .addAllExtensions(new ArrayList<Any>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1520/locations/location-1520/apis/api-1520/versions/version-1520/specs/spec-1520";

    HttpBody actualResponse = client.getApiSpecContents(name);
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
  public void getApiSpecContentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1520/locations/location-1520/apis/api-1520/versions/version-1520/specs/spec-1520";
      client.getApiSpecContents(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createApiSpecTest() throws Exception {
    ApiSpec expectedResponse =
        ApiSpec.newBuilder()
            .setName(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setFilename("filename-734768633")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setSourceUri("sourceUri-1698419887")
            .setContents(ByteString.EMPTY)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ApiVersionName parent = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
    ApiSpec apiSpec = ApiSpec.newBuilder().build();
    String apiSpecId = "apiSpecId-421795600";

    ApiSpec actualResponse = client.createApiSpec(parent, apiSpec, apiSpecId);
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
  public void createApiSpecExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiVersionName parent = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
      ApiSpec apiSpec = ApiSpec.newBuilder().build();
      String apiSpecId = "apiSpecId-421795600";
      client.createApiSpec(parent, apiSpec, apiSpecId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createApiSpecTest2() throws Exception {
    ApiSpec expectedResponse =
        ApiSpec.newBuilder()
            .setName(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setFilename("filename-734768633")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setSourceUri("sourceUri-1698419887")
            .setContents(ByteString.EMPTY)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-1179/locations/location-1179/apis/api-1179/versions/version-1179";
    ApiSpec apiSpec = ApiSpec.newBuilder().build();
    String apiSpecId = "apiSpecId-421795600";

    ApiSpec actualResponse = client.createApiSpec(parent, apiSpec, apiSpecId);
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
  public void createApiSpecExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1179/locations/location-1179/apis/api-1179/versions/version-1179";
      ApiSpec apiSpec = ApiSpec.newBuilder().build();
      String apiSpecId = "apiSpecId-421795600";
      client.createApiSpec(parent, apiSpec, apiSpecId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateApiSpecTest() throws Exception {
    ApiSpec expectedResponse =
        ApiSpec.newBuilder()
            .setName(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setFilename("filename-734768633")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setSourceUri("sourceUri-1698419887")
            .setContents(ByteString.EMPTY)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ApiSpec apiSpec =
        ApiSpec.newBuilder()
            .setName(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setFilename("filename-734768633")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setSourceUri("sourceUri-1698419887")
            .setContents(ByteString.EMPTY)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ApiSpec actualResponse = client.updateApiSpec(apiSpec, updateMask);
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
  public void updateApiSpecExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiSpec apiSpec =
          ApiSpec.newBuilder()
              .setName(
                  ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                      .toString())
              .setFilename("filename-734768633")
              .setDescription("description-1724546052")
              .setRevisionId("revisionId-1507445162")
              .setCreateTime(Timestamp.newBuilder().build())
              .setRevisionCreateTime(Timestamp.newBuilder().build())
              .setRevisionUpdateTime(Timestamp.newBuilder().build())
              .setMimeType("mimeType-1392120434")
              .setSizeBytes(-1796325715)
              .setHash("hash3195150")
              .setSourceUri("sourceUri-1698419887")
              .setContents(ByteString.EMPTY)
              .putAllLabels(new HashMap<String, String>())
              .putAllAnnotations(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateApiSpec(apiSpec, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApiSpecTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ApiSpecName name = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");

    client.deleteApiSpec(name);

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
  public void deleteApiSpecExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiSpecName name = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
      client.deleteApiSpec(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApiSpecTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1520/locations/location-1520/apis/api-1520/versions/version-1520/specs/spec-1520";

    client.deleteApiSpec(name);

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
  public void deleteApiSpecExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1520/locations/location-1520/apis/api-1520/versions/version-1520/specs/spec-1520";
      client.deleteApiSpec(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void tagApiSpecRevisionTest() throws Exception {
    ApiSpec expectedResponse =
        ApiSpec.newBuilder()
            .setName(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setFilename("filename-734768633")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setSourceUri("sourceUri-1698419887")
            .setContents(ByteString.EMPTY)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    TagApiSpecRevisionRequest request =
        TagApiSpecRevisionRequest.newBuilder()
            .setName(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setTag("tag114586")
            .build();

    ApiSpec actualResponse = client.tagApiSpecRevision(request);
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
  public void tagApiSpecRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TagApiSpecRevisionRequest request =
          TagApiSpecRevisionRequest.newBuilder()
              .setName(
                  ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                      .toString())
              .setTag("tag114586")
              .build();
      client.tagApiSpecRevision(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApiSpecRevisionsTest() throws Exception {
    ApiSpec responsesElement = ApiSpec.newBuilder().build();
    ListApiSpecRevisionsResponse expectedResponse =
        ListApiSpecRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApiSpecs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListApiSpecRevisionsRequest request =
        ListApiSpecRevisionsRequest.newBuilder()
            .setName(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListApiSpecRevisionsPagedResponse pagedListResponse = client.listApiSpecRevisions(request);

    List<ApiSpec> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApiSpecsList().get(0), resources.get(0));

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
  public void listApiSpecRevisionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListApiSpecRevisionsRequest request =
          ListApiSpecRevisionsRequest.newBuilder()
              .setName(
                  ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listApiSpecRevisions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rollbackApiSpecTest() throws Exception {
    ApiSpec expectedResponse =
        ApiSpec.newBuilder()
            .setName(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setFilename("filename-734768633")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setSourceUri("sourceUri-1698419887")
            .setContents(ByteString.EMPTY)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    RollbackApiSpecRequest request =
        RollbackApiSpecRequest.newBuilder()
            .setName(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .build();

    ApiSpec actualResponse = client.rollbackApiSpec(request);
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
  public void rollbackApiSpecExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RollbackApiSpecRequest request =
          RollbackApiSpecRequest.newBuilder()
              .setName(
                  ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                      .toString())
              .setRevisionId("revisionId-1507445162")
              .build();
      client.rollbackApiSpec(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApiSpecRevisionTest() throws Exception {
    ApiSpec expectedResponse =
        ApiSpec.newBuilder()
            .setName(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setFilename("filename-734768633")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setSourceUri("sourceUri-1698419887")
            .setContents(ByteString.EMPTY)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ApiSpecName name = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");

    ApiSpec actualResponse = client.deleteApiSpecRevision(name);
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
  public void deleteApiSpecRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiSpecName name = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
      client.deleteApiSpecRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApiSpecRevisionTest2() throws Exception {
    ApiSpec expectedResponse =
        ApiSpec.newBuilder()
            .setName(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setFilename("filename-734768633")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setSourceUri("sourceUri-1698419887")
            .setContents(ByteString.EMPTY)
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1520/locations/location-1520/apis/api-1520/versions/version-1520/specs/spec-1520";

    ApiSpec actualResponse = client.deleteApiSpecRevision(name);
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
  public void deleteApiSpecRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1520/locations/location-1520/apis/api-1520/versions/version-1520/specs/spec-1520";
      client.deleteApiSpecRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApiDeploymentsTest() throws Exception {
    ApiDeployment responsesElement = ApiDeployment.newBuilder().build();
    ListApiDeploymentsResponse expectedResponse =
        ListApiDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApiDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");

    ListApiDeploymentsPagedResponse pagedListResponse = client.listApiDeployments(parent);

    List<ApiDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApiDeploymentsList().get(0), resources.get(0));

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
  public void listApiDeploymentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
      client.listApiDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApiDeploymentsTest2() throws Exception {
    ApiDeployment responsesElement = ApiDeployment.newBuilder().build();
    ListApiDeploymentsResponse expectedResponse =
        ListApiDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApiDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7414/locations/location-7414/apis/api-7414";

    ListApiDeploymentsPagedResponse pagedListResponse = client.listApiDeployments(parent);

    List<ApiDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApiDeploymentsList().get(0), resources.get(0));

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
  public void listApiDeploymentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7414/locations/location-7414/apis/api-7414";
      client.listApiDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApiDeploymentTest() throws Exception {
    ApiDeployment expectedResponse =
        ApiDeployment.newBuilder()
            .setName(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setApiSpecRevision(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setEndpointUri("endpointUri-1135817833")
            .setExternalChannelUri("externalChannelUri-697349228")
            .setIntendedAudience("intendedAudience-1800551601")
            .setAccessGuidance("accessGuidance-1763286820")
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ApiDeploymentName name =
        ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");

    ApiDeployment actualResponse = client.getApiDeployment(name);
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
  public void getApiDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiDeploymentName name =
          ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");
      client.getApiDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApiDeploymentTest2() throws Exception {
    ApiDeployment expectedResponse =
        ApiDeployment.newBuilder()
            .setName(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setApiSpecRevision(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setEndpointUri("endpointUri-1135817833")
            .setExternalChannelUri("externalChannelUri-697349228")
            .setIntendedAudience("intendedAudience-1800551601")
            .setAccessGuidance("accessGuidance-1763286820")
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6163/locations/location-6163/apis/api-6163/deployments/deployment-6163";

    ApiDeployment actualResponse = client.getApiDeployment(name);
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
  public void getApiDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6163/locations/location-6163/apis/api-6163/deployments/deployment-6163";
      client.getApiDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createApiDeploymentTest() throws Exception {
    ApiDeployment expectedResponse =
        ApiDeployment.newBuilder()
            .setName(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setApiSpecRevision(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setEndpointUri("endpointUri-1135817833")
            .setExternalChannelUri("externalChannelUri-697349228")
            .setIntendedAudience("intendedAudience-1800551601")
            .setAccessGuidance("accessGuidance-1763286820")
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
    ApiDeployment apiDeployment = ApiDeployment.newBuilder().build();
    String apiDeploymentId = "apiDeploymentId-1299472902";

    ApiDeployment actualResponse =
        client.createApiDeployment(parent, apiDeployment, apiDeploymentId);
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
  public void createApiDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
      ApiDeployment apiDeployment = ApiDeployment.newBuilder().build();
      String apiDeploymentId = "apiDeploymentId-1299472902";
      client.createApiDeployment(parent, apiDeployment, apiDeploymentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createApiDeploymentTest2() throws Exception {
    ApiDeployment expectedResponse =
        ApiDeployment.newBuilder()
            .setName(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setApiSpecRevision(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setEndpointUri("endpointUri-1135817833")
            .setExternalChannelUri("externalChannelUri-697349228")
            .setIntendedAudience("intendedAudience-1800551601")
            .setAccessGuidance("accessGuidance-1763286820")
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7414/locations/location-7414/apis/api-7414";
    ApiDeployment apiDeployment = ApiDeployment.newBuilder().build();
    String apiDeploymentId = "apiDeploymentId-1299472902";

    ApiDeployment actualResponse =
        client.createApiDeployment(parent, apiDeployment, apiDeploymentId);
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
  public void createApiDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7414/locations/location-7414/apis/api-7414";
      ApiDeployment apiDeployment = ApiDeployment.newBuilder().build();
      String apiDeploymentId = "apiDeploymentId-1299472902";
      client.createApiDeployment(parent, apiDeployment, apiDeploymentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateApiDeploymentTest() throws Exception {
    ApiDeployment expectedResponse =
        ApiDeployment.newBuilder()
            .setName(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setApiSpecRevision(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setEndpointUri("endpointUri-1135817833")
            .setExternalChannelUri("externalChannelUri-697349228")
            .setIntendedAudience("intendedAudience-1800551601")
            .setAccessGuidance("accessGuidance-1763286820")
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ApiDeployment apiDeployment =
        ApiDeployment.newBuilder()
            .setName(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setApiSpecRevision(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setEndpointUri("endpointUri-1135817833")
            .setExternalChannelUri("externalChannelUri-697349228")
            .setIntendedAudience("intendedAudience-1800551601")
            .setAccessGuidance("accessGuidance-1763286820")
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ApiDeployment actualResponse = client.updateApiDeployment(apiDeployment, updateMask);
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
  public void updateApiDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiDeployment apiDeployment =
          ApiDeployment.newBuilder()
              .setName(
                  ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setRevisionId("revisionId-1507445162")
              .setCreateTime(Timestamp.newBuilder().build())
              .setRevisionCreateTime(Timestamp.newBuilder().build())
              .setRevisionUpdateTime(Timestamp.newBuilder().build())
              .setApiSpecRevision(
                  ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                      .toString())
              .setEndpointUri("endpointUri-1135817833")
              .setExternalChannelUri("externalChannelUri-697349228")
              .setIntendedAudience("intendedAudience-1800551601")
              .setAccessGuidance("accessGuidance-1763286820")
              .putAllLabels(new HashMap<String, String>())
              .putAllAnnotations(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateApiDeployment(apiDeployment, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApiDeploymentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ApiDeploymentName name =
        ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");

    client.deleteApiDeployment(name);

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
  public void deleteApiDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiDeploymentName name =
          ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");
      client.deleteApiDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApiDeploymentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6163/locations/location-6163/apis/api-6163/deployments/deployment-6163";

    client.deleteApiDeployment(name);

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
  public void deleteApiDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6163/locations/location-6163/apis/api-6163/deployments/deployment-6163";
      client.deleteApiDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void tagApiDeploymentRevisionTest() throws Exception {
    ApiDeployment expectedResponse =
        ApiDeployment.newBuilder()
            .setName(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setApiSpecRevision(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setEndpointUri("endpointUri-1135817833")
            .setExternalChannelUri("externalChannelUri-697349228")
            .setIntendedAudience("intendedAudience-1800551601")
            .setAccessGuidance("accessGuidance-1763286820")
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    TagApiDeploymentRevisionRequest request =
        TagApiDeploymentRevisionRequest.newBuilder()
            .setName(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .setTag("tag114586")
            .build();

    ApiDeployment actualResponse = client.tagApiDeploymentRevision(request);
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
  public void tagApiDeploymentRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TagApiDeploymentRevisionRequest request =
          TagApiDeploymentRevisionRequest.newBuilder()
              .setName(
                  ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]")
                      .toString())
              .setTag("tag114586")
              .build();
      client.tagApiDeploymentRevision(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApiDeploymentRevisionsTest() throws Exception {
    ApiDeployment responsesElement = ApiDeployment.newBuilder().build();
    ListApiDeploymentRevisionsResponse expectedResponse =
        ListApiDeploymentRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApiDeployments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListApiDeploymentRevisionsRequest request =
        ListApiDeploymentRevisionsRequest.newBuilder()
            .setName(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListApiDeploymentRevisionsPagedResponse pagedListResponse =
        client.listApiDeploymentRevisions(request);

    List<ApiDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApiDeploymentsList().get(0), resources.get(0));

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
  public void listApiDeploymentRevisionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListApiDeploymentRevisionsRequest request =
          ListApiDeploymentRevisionsRequest.newBuilder()
              .setName(
                  ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listApiDeploymentRevisions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rollbackApiDeploymentTest() throws Exception {
    ApiDeployment expectedResponse =
        ApiDeployment.newBuilder()
            .setName(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setApiSpecRevision(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setEndpointUri("endpointUri-1135817833")
            .setExternalChannelUri("externalChannelUri-697349228")
            .setIntendedAudience("intendedAudience-1800551601")
            .setAccessGuidance("accessGuidance-1763286820")
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    RollbackApiDeploymentRequest request =
        RollbackApiDeploymentRequest.newBuilder()
            .setName(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .setRevisionId("revisionId-1507445162")
            .build();

    ApiDeployment actualResponse = client.rollbackApiDeployment(request);
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
  public void rollbackApiDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RollbackApiDeploymentRequest request =
          RollbackApiDeploymentRequest.newBuilder()
              .setName(
                  ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]")
                      .toString())
              .setRevisionId("revisionId-1507445162")
              .build();
      client.rollbackApiDeployment(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApiDeploymentRevisionTest() throws Exception {
    ApiDeployment expectedResponse =
        ApiDeployment.newBuilder()
            .setName(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setApiSpecRevision(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setEndpointUri("endpointUri-1135817833")
            .setExternalChannelUri("externalChannelUri-697349228")
            .setIntendedAudience("intendedAudience-1800551601")
            .setAccessGuidance("accessGuidance-1763286820")
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ApiDeploymentName name =
        ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");

    ApiDeployment actualResponse = client.deleteApiDeploymentRevision(name);
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
  public void deleteApiDeploymentRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiDeploymentName name =
          ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");
      client.deleteApiDeploymentRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteApiDeploymentRevisionTest2() throws Exception {
    ApiDeployment expectedResponse =
        ApiDeployment.newBuilder()
            .setName(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setRevisionId("revisionId-1507445162")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setRevisionUpdateTime(Timestamp.newBuilder().build())
            .setApiSpecRevision(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setEndpointUri("endpointUri-1135817833")
            .setExternalChannelUri("externalChannelUri-697349228")
            .setIntendedAudience("intendedAudience-1800551601")
            .setAccessGuidance("accessGuidance-1763286820")
            .putAllLabels(new HashMap<String, String>())
            .putAllAnnotations(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6163/locations/location-6163/apis/api-6163/deployments/deployment-6163";

    ApiDeployment actualResponse = client.deleteApiDeploymentRevision(name);
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
  public void deleteApiDeploymentRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6163/locations/location-6163/apis/api-6163/deployments/deployment-6163";
      client.deleteApiDeploymentRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listArtifactsTest() throws Exception {
    Artifact responsesElement = Artifact.newBuilder().build();
    ListArtifactsResponse expectedResponse =
        ListArtifactsResponse.newBuilder()
            .setNextPageToken("")
            .addAllArtifacts(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ApiDeploymentName parent =
        ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");

    ListArtifactsPagedResponse pagedListResponse = client.listArtifacts(parent);

    List<Artifact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getArtifactsList().get(0), resources.get(0));

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
  public void listArtifactsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiDeploymentName parent =
          ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");
      client.listArtifacts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listArtifactsTest2() throws Exception {
    Artifact responsesElement = Artifact.newBuilder().build();
    ListArtifactsResponse expectedResponse =
        ListArtifactsResponse.newBuilder()
            .setNextPageToken("")
            .addAllArtifacts(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");

    ListArtifactsPagedResponse pagedListResponse = client.listArtifacts(parent);

    List<Artifact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getArtifactsList().get(0), resources.get(0));

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
  public void listArtifactsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
      client.listArtifacts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listArtifactsTest3() throws Exception {
    Artifact responsesElement = Artifact.newBuilder().build();
    ListArtifactsResponse expectedResponse =
        ListArtifactsResponse.newBuilder()
            .setNextPageToken("")
            .addAllArtifacts(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ApiSpecName parent = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");

    ListArtifactsPagedResponse pagedListResponse = client.listArtifacts(parent);

    List<Artifact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getArtifactsList().get(0), resources.get(0));

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
  public void listArtifactsExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiSpecName parent =
          ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
      client.listArtifacts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listArtifactsTest4() throws Exception {
    Artifact responsesElement = Artifact.newBuilder().build();
    ListArtifactsResponse expectedResponse =
        ListArtifactsResponse.newBuilder()
            .setNextPageToken("")
            .addAllArtifacts(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ApiVersionName parent = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");

    ListArtifactsPagedResponse pagedListResponse = client.listArtifacts(parent);

    List<Artifact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getArtifactsList().get(0), resources.get(0));

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
  public void listArtifactsExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiVersionName parent = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
      client.listArtifacts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listArtifactsTest5() throws Exception {
    Artifact responsesElement = Artifact.newBuilder().build();
    ListArtifactsResponse expectedResponse =
        ListArtifactsResponse.newBuilder()
            .setNextPageToken("")
            .addAllArtifacts(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListArtifactsPagedResponse pagedListResponse = client.listArtifacts(parent);

    List<Artifact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getArtifactsList().get(0), resources.get(0));

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
  public void listArtifactsExceptionTest5() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listArtifacts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listArtifactsTest6() throws Exception {
    Artifact responsesElement = Artifact.newBuilder().build();
    ListArtifactsResponse expectedResponse =
        ListArtifactsResponse.newBuilder()
            .setNextPageToken("")
            .addAllArtifacts(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListArtifactsPagedResponse pagedListResponse = client.listArtifacts(parent);

    List<Artifact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getArtifactsList().get(0), resources.get(0));

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
  public void listArtifactsExceptionTest6() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listArtifacts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getArtifactTest() throws Exception {
    Artifact expectedResponse =
        Artifact.newBuilder()
            .setName(
                ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setContents(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    ArtifactName name =
        ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]");

    Artifact actualResponse = client.getArtifact(name);
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
  public void getArtifactExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ArtifactName name =
          ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]");
      client.getArtifact(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getArtifactTest2() throws Exception {
    Artifact expectedResponse =
        Artifact.newBuilder()
            .setName(
                ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setContents(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1719/locations/location-1719/artifacts/artifact-1719";

    Artifact actualResponse = client.getArtifact(name);
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
  public void getArtifactExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1719/locations/location-1719/artifacts/artifact-1719";
      client.getArtifact(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getArtifactContentsTest() throws Exception {
    HttpBody expectedResponse =
        HttpBody.newBuilder()
            .setContentType("contentType-389131437")
            .setData(ByteString.EMPTY)
            .addAllExtensions(new ArrayList<Any>())
            .build();
    mockService.addResponse(expectedResponse);

    ArtifactName name =
        ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]");

    HttpBody actualResponse = client.getArtifactContents(name);
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
  public void getArtifactContentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ArtifactName name =
          ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]");
      client.getArtifactContents(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getArtifactContentsTest2() throws Exception {
    HttpBody expectedResponse =
        HttpBody.newBuilder()
            .setContentType("contentType-389131437")
            .setData(ByteString.EMPTY)
            .addAllExtensions(new ArrayList<Any>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1719/locations/location-1719/artifacts/artifact-1719";

    HttpBody actualResponse = client.getArtifactContents(name);
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
  public void getArtifactContentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1719/locations/location-1719/artifacts/artifact-1719";
      client.getArtifactContents(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createArtifactTest() throws Exception {
    Artifact expectedResponse =
        Artifact.newBuilder()
            .setName(
                ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setContents(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    ApiDeploymentName parent =
        ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");
    Artifact artifact = Artifact.newBuilder().build();
    String artifactId = "artifactId240640653";

    Artifact actualResponse = client.createArtifact(parent, artifact, artifactId);
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
  public void createArtifactExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiDeploymentName parent =
          ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");
      Artifact artifact = Artifact.newBuilder().build();
      String artifactId = "artifactId240640653";
      client.createArtifact(parent, artifact, artifactId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createArtifactTest2() throws Exception {
    Artifact expectedResponse =
        Artifact.newBuilder()
            .setName(
                ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setContents(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
    Artifact artifact = Artifact.newBuilder().build();
    String artifactId = "artifactId240640653";

    Artifact actualResponse = client.createArtifact(parent, artifact, artifactId);
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
  public void createArtifactExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
      Artifact artifact = Artifact.newBuilder().build();
      String artifactId = "artifactId240640653";
      client.createArtifact(parent, artifact, artifactId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createArtifactTest3() throws Exception {
    Artifact expectedResponse =
        Artifact.newBuilder()
            .setName(
                ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setContents(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    ApiSpecName parent = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
    Artifact artifact = Artifact.newBuilder().build();
    String artifactId = "artifactId240640653";

    Artifact actualResponse = client.createArtifact(parent, artifact, artifactId);
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
  public void createArtifactExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiSpecName parent =
          ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
      Artifact artifact = Artifact.newBuilder().build();
      String artifactId = "artifactId240640653";
      client.createArtifact(parent, artifact, artifactId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createArtifactTest4() throws Exception {
    Artifact expectedResponse =
        Artifact.newBuilder()
            .setName(
                ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setContents(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    ApiVersionName parent = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
    Artifact artifact = Artifact.newBuilder().build();
    String artifactId = "artifactId240640653";

    Artifact actualResponse = client.createArtifact(parent, artifact, artifactId);
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
  public void createArtifactExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ApiVersionName parent = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
      Artifact artifact = Artifact.newBuilder().build();
      String artifactId = "artifactId240640653";
      client.createArtifact(parent, artifact, artifactId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createArtifactTest5() throws Exception {
    Artifact expectedResponse =
        Artifact.newBuilder()
            .setName(
                ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setContents(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Artifact artifact = Artifact.newBuilder().build();
    String artifactId = "artifactId240640653";

    Artifact actualResponse = client.createArtifact(parent, artifact, artifactId);
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
  public void createArtifactExceptionTest5() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Artifact artifact = Artifact.newBuilder().build();
      String artifactId = "artifactId240640653";
      client.createArtifact(parent, artifact, artifactId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createArtifactTest6() throws Exception {
    Artifact expectedResponse =
        Artifact.newBuilder()
            .setName(
                ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setContents(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    Artifact artifact = Artifact.newBuilder().build();
    String artifactId = "artifactId240640653";

    Artifact actualResponse = client.createArtifact(parent, artifact, artifactId);
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
  public void createArtifactExceptionTest6() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Artifact artifact = Artifact.newBuilder().build();
      String artifactId = "artifactId240640653";
      client.createArtifact(parent, artifact, artifactId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void replaceArtifactTest() throws Exception {
    Artifact expectedResponse =
        Artifact.newBuilder()
            .setName(
                ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setContents(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    Artifact artifact =
        Artifact.newBuilder()
            .setName(
                ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .setHash("hash3195150")
            .setContents(ByteString.EMPTY)
            .build();

    Artifact actualResponse = client.replaceArtifact(artifact);
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
  public void replaceArtifactExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Artifact artifact =
          Artifact.newBuilder()
              .setName(
                  ArtifactName.ofProjectLocationArtifactName(
                          "[PROJECT]", "[LOCATION]", "[ARTIFACT]")
                      .toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setMimeType("mimeType-1392120434")
              .setSizeBytes(-1796325715)
              .setHash("hash3195150")
              .setContents(ByteString.EMPTY)
              .build();
      client.replaceArtifact(artifact);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteArtifactTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ArtifactName name =
        ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]");

    client.deleteArtifact(name);

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
  public void deleteArtifactExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ArtifactName name =
          ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]");
      client.deleteArtifact(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteArtifactTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1719/locations/location-1719/artifacts/artifact-1719";

    client.deleteArtifact(name);

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
  public void deleteArtifactExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1719/locations/location-1719/artifacts/artifact-1719";
      client.deleteArtifact(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

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
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
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
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
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
  public void setIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
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
  public void getIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
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
  public void testIamPermissionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
