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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
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
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class RegistryClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockRegistry mockRegistry;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private RegistryClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockRegistry = new MockRegistry();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockRegistry, mockLocations, mockIAMPolicy));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    RegistrySettings settings =
        RegistrySettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RegistryClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listApisTest() throws Exception {
    Api responsesElement = Api.newBuilder().build();
    ListApisResponse expectedResponse =
        ListApisResponse.newBuilder()
            .setNextPageToken("")
            .addAllApis(Arrays.asList(responsesElement))
            .build();
    mockRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListApisPagedResponse pagedListResponse = client.listApis(parent);

    List<Api> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApisList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApisRequest actualRequest = ((ListApisRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApisExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListApisPagedResponse pagedListResponse = client.listApis(parent);

    List<Api> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApisList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApisRequest actualRequest = ((ListApisRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApisExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockRegistry.addResponse(expectedResponse);

    ApiName name = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");

    Api actualResponse = client.getApi(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApiRequest actualRequest = ((GetApiRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApiExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    Api actualResponse = client.getApi(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApiRequest actualRequest = ((GetApiRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApiExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String name = "name3373707";
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
    mockRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Api api = Api.newBuilder().build();
    String apiId = "apiId93021397";

    Api actualResponse = client.createApi(parent, api, apiId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateApiRequest actualRequest = ((CreateApiRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(api, actualRequest.getApi());
    Assert.assertEquals(apiId, actualRequest.getApiId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createApiExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Api api = Api.newBuilder().build();
    String apiId = "apiId93021397";

    Api actualResponse = client.createApi(parent, api, apiId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateApiRequest actualRequest = ((CreateApiRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(api, actualRequest.getApi());
    Assert.assertEquals(apiId, actualRequest.getApiId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createApiExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockRegistry.addResponse(expectedResponse);

    Api api = Api.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Api actualResponse = client.updateApi(api, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateApiRequest actualRequest = ((UpdateApiRequest) actualRequests.get(0));

    Assert.assertEquals(api, actualRequest.getApi());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateApiExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      Api api = Api.newBuilder().build();
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
    mockRegistry.addResponse(expectedResponse);

    ApiName name = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");

    client.deleteApi(name);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApiRequest actualRequest = ((DeleteApiRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApiExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteApi(name);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApiRequest actualRequest = ((DeleteApiRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApiExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String name = "name3373707";
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
    mockRegistry.addResponse(expectedResponse);

    ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");

    ListApiVersionsPagedResponse pagedListResponse = client.listApiVersions(parent);

    List<ApiVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApiVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApiVersionsRequest actualRequest = ((ListApiVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApiVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListApiVersionsPagedResponse pagedListResponse = client.listApiVersions(parent);

    List<ApiVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApiVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApiVersionsRequest actualRequest = ((ListApiVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApiVersionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockRegistry.addResponse(expectedResponse);

    ApiVersionName name = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");

    ApiVersion actualResponse = client.getApiVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApiVersionRequest actualRequest = ((GetApiVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApiVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    ApiVersion actualResponse = client.getApiVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApiVersionRequest actualRequest = ((GetApiVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApiVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String name = "name3373707";
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
    mockRegistry.addResponse(expectedResponse);

    ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
    ApiVersion apiVersion = ApiVersion.newBuilder().build();
    String apiVersionId = "apiVersionId1678816025";

    ApiVersion actualResponse = client.createApiVersion(parent, apiVersion, apiVersionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateApiVersionRequest actualRequest = ((CreateApiVersionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(apiVersion, actualRequest.getApiVersion());
    Assert.assertEquals(apiVersionId, actualRequest.getApiVersionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createApiVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ApiVersion apiVersion = ApiVersion.newBuilder().build();
    String apiVersionId = "apiVersionId1678816025";

    ApiVersion actualResponse = client.createApiVersion(parent, apiVersion, apiVersionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateApiVersionRequest actualRequest = ((CreateApiVersionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(apiVersion, actualRequest.getApiVersion());
    Assert.assertEquals(apiVersionId, actualRequest.getApiVersionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createApiVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockRegistry.addResponse(expectedResponse);

    ApiVersion apiVersion = ApiVersion.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ApiVersion actualResponse = client.updateApiVersion(apiVersion, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateApiVersionRequest actualRequest = ((UpdateApiVersionRequest) actualRequests.get(0));

    Assert.assertEquals(apiVersion, actualRequest.getApiVersion());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateApiVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      ApiVersion apiVersion = ApiVersion.newBuilder().build();
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
    mockRegistry.addResponse(expectedResponse);

    ApiVersionName name = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");

    client.deleteApiVersion(name);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApiVersionRequest actualRequest = ((DeleteApiVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApiVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteApiVersion(name);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApiVersionRequest actualRequest = ((DeleteApiVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApiVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String name = "name3373707";
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
    mockRegistry.addResponse(expectedResponse);

    ApiVersionName parent = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");

    ListApiSpecsPagedResponse pagedListResponse = client.listApiSpecs(parent);

    List<ApiSpec> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApiSpecsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApiSpecsRequest actualRequest = ((ListApiSpecsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApiSpecsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListApiSpecsPagedResponse pagedListResponse = client.listApiSpecs(parent);

    List<ApiSpec> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApiSpecsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApiSpecsRequest actualRequest = ((ListApiSpecsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApiSpecsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockRegistry.addResponse(expectedResponse);

    ApiSpecName name = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");

    ApiSpec actualResponse = client.getApiSpec(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApiSpecRequest actualRequest = ((GetApiSpecRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApiSpecExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    ApiSpec actualResponse = client.getApiSpec(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApiSpecRequest actualRequest = ((GetApiSpecRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApiSpecExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String name = "name3373707";
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
    mockRegistry.addResponse(expectedResponse);

    ApiSpecName name = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");

    HttpBody actualResponse = client.getApiSpecContents(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApiSpecContentsRequest actualRequest = ((GetApiSpecContentsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApiSpecContentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    HttpBody actualResponse = client.getApiSpecContents(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApiSpecContentsRequest actualRequest = ((GetApiSpecContentsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApiSpecContentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String name = "name3373707";
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
    mockRegistry.addResponse(expectedResponse);

    ApiVersionName parent = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
    ApiSpec apiSpec = ApiSpec.newBuilder().build();
    String apiSpecId = "apiSpecId-421795600";

    ApiSpec actualResponse = client.createApiSpec(parent, apiSpec, apiSpecId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateApiSpecRequest actualRequest = ((CreateApiSpecRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(apiSpec, actualRequest.getApiSpec());
    Assert.assertEquals(apiSpecId, actualRequest.getApiSpecId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createApiSpecExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ApiSpec apiSpec = ApiSpec.newBuilder().build();
    String apiSpecId = "apiSpecId-421795600";

    ApiSpec actualResponse = client.createApiSpec(parent, apiSpec, apiSpecId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateApiSpecRequest actualRequest = ((CreateApiSpecRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(apiSpec, actualRequest.getApiSpec());
    Assert.assertEquals(apiSpecId, actualRequest.getApiSpecId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createApiSpecExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockRegistry.addResponse(expectedResponse);

    ApiSpec apiSpec = ApiSpec.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ApiSpec actualResponse = client.updateApiSpec(apiSpec, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateApiSpecRequest actualRequest = ((UpdateApiSpecRequest) actualRequests.get(0));

    Assert.assertEquals(apiSpec, actualRequest.getApiSpec());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateApiSpecExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      ApiSpec apiSpec = ApiSpec.newBuilder().build();
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
    mockRegistry.addResponse(expectedResponse);

    ApiSpecName name = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");

    client.deleteApiSpec(name);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApiSpecRequest actualRequest = ((DeleteApiSpecRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApiSpecExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteApiSpec(name);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApiSpecRequest actualRequest = ((DeleteApiSpecRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApiSpecExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String name = "name3373707";
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
    mockRegistry.addResponse(expectedResponse);

    TagApiSpecRevisionRequest request =
        TagApiSpecRevisionRequest.newBuilder()
            .setName(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setTag("tag114586")
            .build();

    ApiSpec actualResponse = client.tagApiSpecRevision(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TagApiSpecRevisionRequest actualRequest = ((TagApiSpecRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getTag(), actualRequest.getTag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void tagApiSpecRevisionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

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

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApiSpecRevisionsRequest actualRequest =
        ((ListApiSpecRevisionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApiSpecRevisionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    RollbackApiSpecRequest request =
        RollbackApiSpecRequest.newBuilder()
            .setName(
                ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]")
                    .toString())
            .setRevisionId("revisionId-1507445162")
            .build();

    ApiSpec actualResponse = client.rollbackApiSpec(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RollbackApiSpecRequest actualRequest = ((RollbackApiSpecRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getRevisionId(), actualRequest.getRevisionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rollbackApiSpecExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    ApiSpecName name = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");

    ApiSpec actualResponse = client.deleteApiSpecRevision(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApiSpecRevisionRequest actualRequest =
        ((DeleteApiSpecRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApiSpecRevisionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    ApiSpec actualResponse = client.deleteApiSpecRevision(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApiSpecRevisionRequest actualRequest =
        ((DeleteApiSpecRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApiSpecRevisionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String name = "name3373707";
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
    mockRegistry.addResponse(expectedResponse);

    ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");

    ListApiDeploymentsPagedResponse pagedListResponse = client.listApiDeployments(parent);

    List<ApiDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApiDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApiDeploymentsRequest actualRequest = ((ListApiDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApiDeploymentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListApiDeploymentsPagedResponse pagedListResponse = client.listApiDeployments(parent);

    List<ApiDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApiDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApiDeploymentsRequest actualRequest = ((ListApiDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApiDeploymentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockRegistry.addResponse(expectedResponse);

    ApiDeploymentName name =
        ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");

    ApiDeployment actualResponse = client.getApiDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApiDeploymentRequest actualRequest = ((GetApiDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApiDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    ApiDeployment actualResponse = client.getApiDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApiDeploymentRequest actualRequest = ((GetApiDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApiDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String name = "name3373707";
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
    mockRegistry.addResponse(expectedResponse);

    ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
    ApiDeployment apiDeployment = ApiDeployment.newBuilder().build();
    String apiDeploymentId = "apiDeploymentId-1299472902";

    ApiDeployment actualResponse =
        client.createApiDeployment(parent, apiDeployment, apiDeploymentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateApiDeploymentRequest actualRequest = ((CreateApiDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(apiDeployment, actualRequest.getApiDeployment());
    Assert.assertEquals(apiDeploymentId, actualRequest.getApiDeploymentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createApiDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ApiDeployment apiDeployment = ApiDeployment.newBuilder().build();
    String apiDeploymentId = "apiDeploymentId-1299472902";

    ApiDeployment actualResponse =
        client.createApiDeployment(parent, apiDeployment, apiDeploymentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateApiDeploymentRequest actualRequest = ((CreateApiDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(apiDeployment, actualRequest.getApiDeployment());
    Assert.assertEquals(apiDeploymentId, actualRequest.getApiDeploymentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createApiDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockRegistry.addResponse(expectedResponse);

    ApiDeployment apiDeployment = ApiDeployment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ApiDeployment actualResponse = client.updateApiDeployment(apiDeployment, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateApiDeploymentRequest actualRequest = ((UpdateApiDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(apiDeployment, actualRequest.getApiDeployment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateApiDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      ApiDeployment apiDeployment = ApiDeployment.newBuilder().build();
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
    mockRegistry.addResponse(expectedResponse);

    ApiDeploymentName name =
        ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");

    client.deleteApiDeployment(name);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApiDeploymentRequest actualRequest = ((DeleteApiDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApiDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteApiDeployment(name);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApiDeploymentRequest actualRequest = ((DeleteApiDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApiDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String name = "name3373707";
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
    mockRegistry.addResponse(expectedResponse);

    TagApiDeploymentRevisionRequest request =
        TagApiDeploymentRevisionRequest.newBuilder()
            .setName(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .setTag("tag114586")
            .build();

    ApiDeployment actualResponse = client.tagApiDeploymentRevision(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TagApiDeploymentRevisionRequest actualRequest =
        ((TagApiDeploymentRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getTag(), actualRequest.getTag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void tagApiDeploymentRevisionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

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

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApiDeploymentRevisionsRequest actualRequest =
        ((ListApiDeploymentRevisionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApiDeploymentRevisionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    RollbackApiDeploymentRequest request =
        RollbackApiDeploymentRequest.newBuilder()
            .setName(
                ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]").toString())
            .setRevisionId("revisionId-1507445162")
            .build();

    ApiDeployment actualResponse = client.rollbackApiDeployment(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RollbackApiDeploymentRequest actualRequest =
        ((RollbackApiDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getRevisionId(), actualRequest.getRevisionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rollbackApiDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    ApiDeploymentName name =
        ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");

    ApiDeployment actualResponse = client.deleteApiDeploymentRevision(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApiDeploymentRevisionRequest actualRequest =
        ((DeleteApiDeploymentRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApiDeploymentRevisionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    ApiDeployment actualResponse = client.deleteApiDeploymentRevision(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteApiDeploymentRevisionRequest actualRequest =
        ((DeleteApiDeploymentRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteApiDeploymentRevisionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String name = "name3373707";
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
    mockRegistry.addResponse(expectedResponse);

    ApiDeploymentName parent =
        ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");

    ListArtifactsPagedResponse pagedListResponse = client.listArtifacts(parent);

    List<Artifact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getArtifactsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListArtifactsRequest actualRequest = ((ListArtifactsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listArtifactsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");

    ListArtifactsPagedResponse pagedListResponse = client.listArtifacts(parent);

    List<Artifact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getArtifactsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListArtifactsRequest actualRequest = ((ListArtifactsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listArtifactsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    ApiSpecName parent = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");

    ListArtifactsPagedResponse pagedListResponse = client.listArtifacts(parent);

    List<Artifact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getArtifactsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListArtifactsRequest actualRequest = ((ListArtifactsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listArtifactsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    ApiVersionName parent = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");

    ListArtifactsPagedResponse pagedListResponse = client.listArtifacts(parent);

    List<Artifact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getArtifactsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListArtifactsRequest actualRequest = ((ListArtifactsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listArtifactsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListArtifactsPagedResponse pagedListResponse = client.listArtifacts(parent);

    List<Artifact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getArtifactsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListArtifactsRequest actualRequest = ((ListArtifactsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listArtifactsExceptionTest5() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListArtifactsPagedResponse pagedListResponse = client.listArtifacts(parent);

    List<Artifact> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getArtifactsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListArtifactsRequest actualRequest = ((ListArtifactsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listArtifactsExceptionTest6() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockRegistry.addResponse(expectedResponse);

    ArtifactName name =
        ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]");

    Artifact actualResponse = client.getArtifact(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetArtifactRequest actualRequest = ((GetArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getArtifactExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    Artifact actualResponse = client.getArtifact(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetArtifactRequest actualRequest = ((GetArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getArtifactExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String name = "name3373707";
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
    mockRegistry.addResponse(expectedResponse);

    ArtifactName name =
        ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]");

    HttpBody actualResponse = client.getArtifactContents(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetArtifactContentsRequest actualRequest = ((GetArtifactContentsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getArtifactContentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    HttpBody actualResponse = client.getArtifactContents(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetArtifactContentsRequest actualRequest = ((GetArtifactContentsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getArtifactContentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String name = "name3373707";
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
    mockRegistry.addResponse(expectedResponse);

    ApiDeploymentName parent =
        ApiDeploymentName.of("[PROJECT]", "[LOCATION]", "[API]", "[DEPLOYMENT]");
    Artifact artifact = Artifact.newBuilder().build();
    String artifactId = "artifactId240640653";

    Artifact actualResponse = client.createArtifact(parent, artifact, artifactId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateArtifactRequest actualRequest = ((CreateArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(artifact, actualRequest.getArtifact());
    Assert.assertEquals(artifactId, actualRequest.getArtifactId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createArtifactExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
    Artifact artifact = Artifact.newBuilder().build();
    String artifactId = "artifactId240640653";

    Artifact actualResponse = client.createArtifact(parent, artifact, artifactId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateArtifactRequest actualRequest = ((CreateArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(artifact, actualRequest.getArtifact());
    Assert.assertEquals(artifactId, actualRequest.getArtifactId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createArtifactExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    ApiSpecName parent = ApiSpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
    Artifact artifact = Artifact.newBuilder().build();
    String artifactId = "artifactId240640653";

    Artifact actualResponse = client.createArtifact(parent, artifact, artifactId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateArtifactRequest actualRequest = ((CreateArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(artifact, actualRequest.getArtifact());
    Assert.assertEquals(artifactId, actualRequest.getArtifactId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createArtifactExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    ApiVersionName parent = ApiVersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
    Artifact artifact = Artifact.newBuilder().build();
    String artifactId = "artifactId240640653";

    Artifact actualResponse = client.createArtifact(parent, artifact, artifactId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateArtifactRequest actualRequest = ((CreateArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(artifact, actualRequest.getArtifact());
    Assert.assertEquals(artifactId, actualRequest.getArtifactId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createArtifactExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Artifact artifact = Artifact.newBuilder().build();
    String artifactId = "artifactId240640653";

    Artifact actualResponse = client.createArtifact(parent, artifact, artifactId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateArtifactRequest actualRequest = ((CreateArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(artifact, actualRequest.getArtifact());
    Assert.assertEquals(artifactId, actualRequest.getArtifactId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createArtifactExceptionTest5() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Artifact artifact = Artifact.newBuilder().build();
    String artifactId = "artifactId240640653";

    Artifact actualResponse = client.createArtifact(parent, artifact, artifactId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateArtifactRequest actualRequest = ((CreateArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(artifact, actualRequest.getArtifact());
    Assert.assertEquals(artifactId, actualRequest.getArtifactId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createArtifactExceptionTest6() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockRegistry.addResponse(expectedResponse);

    Artifact artifact = Artifact.newBuilder().build();

    Artifact actualResponse = client.replaceArtifact(artifact);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReplaceArtifactRequest actualRequest = ((ReplaceArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(artifact, actualRequest.getArtifact());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void replaceArtifactExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      Artifact artifact = Artifact.newBuilder().build();
      client.replaceArtifact(artifact);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteArtifactTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockRegistry.addResponse(expectedResponse);

    ArtifactName name =
        ArtifactName.ofProjectLocationArtifactName("[PROJECT]", "[LOCATION]", "[ARTIFACT]");

    client.deleteArtifact(name);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteArtifactRequest actualRequest = ((DeleteArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteArtifactExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

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
    mockRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteArtifact(name);

    List<AbstractMessage> actualRequests = mockRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteArtifactRequest actualRequest = ((DeleteArtifactRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteArtifactExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRegistry.addException(exception);

    try {
      String name = "name3373707";
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
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
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
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
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
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

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
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

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
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

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
