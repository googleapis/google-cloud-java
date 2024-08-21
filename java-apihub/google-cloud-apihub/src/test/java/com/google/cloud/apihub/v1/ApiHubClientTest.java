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

package com.google.cloud.apihub.v1;

import static com.google.cloud.apihub.v1.ApiHubClient.ListApiOperationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListApisPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListAttributesPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListDeploymentsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListExternalApisPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListLocationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListSpecsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListVersionsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.SearchResourcesPagedResponse;

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
public class ApiHubClientTest {
  private static MockApiHub mockApiHub;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ApiHubClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockApiHub = new MockApiHub();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockApiHub, mockLocations));
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
    ApiHubSettings settings =
        ApiHubSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ApiHubClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createApiTest() throws Exception {
    Api expectedResponse =
        Api.newBuilder()
            .setName(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDocumentation(Documentation.newBuilder().build())
            .setOwner(Owner.newBuilder().build())
            .addAllVersions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTargetUser(AttributeValues.newBuilder().build())
            .setTeam(AttributeValues.newBuilder().build())
            .setBusinessUnit(AttributeValues.newBuilder().build())
            .setMaturityLevel(AttributeValues.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setApiStyle(AttributeValues.newBuilder().build())
            .setSelectedVersion(
                VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .build();
    mockApiHub.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Api api = Api.newBuilder().build();
    String apiId = "apiId93021397";

    Api actualResponse = client.createApi(parent, api, apiId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
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
    mockApiHub.addException(exception);

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
            .setDocumentation(Documentation.newBuilder().build())
            .setOwner(Owner.newBuilder().build())
            .addAllVersions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTargetUser(AttributeValues.newBuilder().build())
            .setTeam(AttributeValues.newBuilder().build())
            .setBusinessUnit(AttributeValues.newBuilder().build())
            .setMaturityLevel(AttributeValues.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setApiStyle(AttributeValues.newBuilder().build())
            .setSelectedVersion(
                VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .build();
    mockApiHub.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Api api = Api.newBuilder().build();
    String apiId = "apiId93021397";

    Api actualResponse = client.createApi(parent, api, apiId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
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
    mockApiHub.addException(exception);

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
  public void getApiTest() throws Exception {
    Api expectedResponse =
        Api.newBuilder()
            .setName(ApiName.of("[PROJECT]", "[LOCATION]", "[API]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDocumentation(Documentation.newBuilder().build())
            .setOwner(Owner.newBuilder().build())
            .addAllVersions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTargetUser(AttributeValues.newBuilder().build())
            .setTeam(AttributeValues.newBuilder().build())
            .setBusinessUnit(AttributeValues.newBuilder().build())
            .setMaturityLevel(AttributeValues.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setApiStyle(AttributeValues.newBuilder().build())
            .setSelectedVersion(
                VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .build();
    mockApiHub.addResponse(expectedResponse);

    ApiName name = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");

    Api actualResponse = client.getApi(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
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
    mockApiHub.addException(exception);

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
            .setDocumentation(Documentation.newBuilder().build())
            .setOwner(Owner.newBuilder().build())
            .addAllVersions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTargetUser(AttributeValues.newBuilder().build())
            .setTeam(AttributeValues.newBuilder().build())
            .setBusinessUnit(AttributeValues.newBuilder().build())
            .setMaturityLevel(AttributeValues.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setApiStyle(AttributeValues.newBuilder().build())
            .setSelectedVersion(
                VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .build();
    mockApiHub.addResponse(expectedResponse);

    String name = "name3373707";

    Api actualResponse = client.getApi(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
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
    mockApiHub.addException(exception);

    try {
      String name = "name3373707";
      client.getApi(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
    mockApiHub.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListApisPagedResponse pagedListResponse = client.listApis(parent);

    List<Api> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApisList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
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
    mockApiHub.addException(exception);

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
    mockApiHub.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListApisPagedResponse pagedListResponse = client.listApis(parent);

    List<Api> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApisList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
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
    mockApiHub.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listApis(parent);
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
            .setDocumentation(Documentation.newBuilder().build())
            .setOwner(Owner.newBuilder().build())
            .addAllVersions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTargetUser(AttributeValues.newBuilder().build())
            .setTeam(AttributeValues.newBuilder().build())
            .setBusinessUnit(AttributeValues.newBuilder().build())
            .setMaturityLevel(AttributeValues.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setApiStyle(AttributeValues.newBuilder().build())
            .setSelectedVersion(
                VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .build();
    mockApiHub.addResponse(expectedResponse);

    Api api = Api.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Api actualResponse = client.updateApi(api, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
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
    mockApiHub.addException(exception);

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
    mockApiHub.addResponse(expectedResponse);

    ApiName name = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");

    client.deleteApi(name);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
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
    mockApiHub.addException(exception);

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
    mockApiHub.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteApi(name);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
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
    mockApiHub.addException(exception);

    try {
      String name = "name3373707";
      client.deleteApi(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createVersionTest() throws Exception {
    Version expectedResponse =
        Version.newBuilder()
            .setName(VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDocumentation(Documentation.newBuilder().build())
            .addAllSpecs(new ArrayList<String>())
            .addAllApiOperations(new ArrayList<String>())
            .addAllDefinitions(new ArrayList<String>())
            .addAllDeployments(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLifecycle(AttributeValues.newBuilder().build())
            .setCompliance(AttributeValues.newBuilder().build())
            .setAccreditation(AttributeValues.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setSelectedDeployment(
                DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .build();
    mockApiHub.addResponse(expectedResponse);

    ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
    Version version = Version.newBuilder().build();
    String versionId = "versionId-1407102957";

    Version actualResponse = client.createVersion(parent, version, versionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVersionRequest actualRequest = ((CreateVersionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(version, actualRequest.getVersion());
    Assert.assertEquals(versionId, actualRequest.getVersionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
      Version version = Version.newBuilder().build();
      String versionId = "versionId-1407102957";
      client.createVersion(parent, version, versionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createVersionTest2() throws Exception {
    Version expectedResponse =
        Version.newBuilder()
            .setName(VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDocumentation(Documentation.newBuilder().build())
            .addAllSpecs(new ArrayList<String>())
            .addAllApiOperations(new ArrayList<String>())
            .addAllDefinitions(new ArrayList<String>())
            .addAllDeployments(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLifecycle(AttributeValues.newBuilder().build())
            .setCompliance(AttributeValues.newBuilder().build())
            .setAccreditation(AttributeValues.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setSelectedDeployment(
                DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .build();
    mockApiHub.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Version version = Version.newBuilder().build();
    String versionId = "versionId-1407102957";

    Version actualResponse = client.createVersion(parent, version, versionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVersionRequest actualRequest = ((CreateVersionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(version, actualRequest.getVersion());
    Assert.assertEquals(versionId, actualRequest.getVersionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String parent = "parent-995424086";
      Version version = Version.newBuilder().build();
      String versionId = "versionId-1407102957";
      client.createVersion(parent, version, versionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVersionTest() throws Exception {
    Version expectedResponse =
        Version.newBuilder()
            .setName(VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDocumentation(Documentation.newBuilder().build())
            .addAllSpecs(new ArrayList<String>())
            .addAllApiOperations(new ArrayList<String>())
            .addAllDefinitions(new ArrayList<String>())
            .addAllDeployments(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLifecycle(AttributeValues.newBuilder().build())
            .setCompliance(AttributeValues.newBuilder().build())
            .setAccreditation(AttributeValues.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setSelectedDeployment(
                DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .build();
    mockApiHub.addResponse(expectedResponse);

    VersionName name = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");

    Version actualResponse = client.getVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVersionRequest actualRequest = ((GetVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      VersionName name = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
      client.getVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVersionTest2() throws Exception {
    Version expectedResponse =
        Version.newBuilder()
            .setName(VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDocumentation(Documentation.newBuilder().build())
            .addAllSpecs(new ArrayList<String>())
            .addAllApiOperations(new ArrayList<String>())
            .addAllDefinitions(new ArrayList<String>())
            .addAllDeployments(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLifecycle(AttributeValues.newBuilder().build())
            .setCompliance(AttributeValues.newBuilder().build())
            .setAccreditation(AttributeValues.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setSelectedDeployment(
                DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .build();
    mockApiHub.addResponse(expectedResponse);

    String name = "name3373707";

    Version actualResponse = client.getVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVersionRequest actualRequest = ((GetVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String name = "name3373707";
      client.getVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVersionsTest() throws Exception {
    Version responsesElement = Version.newBuilder().build();
    ListVersionsResponse expectedResponse =
        ListVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVersions(Arrays.asList(responsesElement))
            .build();
    mockApiHub.addResponse(expectedResponse);

    ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");

    ListVersionsPagedResponse pagedListResponse = client.listVersions(parent);

    List<Version> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVersionsRequest actualRequest = ((ListVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      ApiName parent = ApiName.of("[PROJECT]", "[LOCATION]", "[API]");
      client.listVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listVersionsTest2() throws Exception {
    Version responsesElement = Version.newBuilder().build();
    ListVersionsResponse expectedResponse =
        ListVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVersions(Arrays.asList(responsesElement))
            .build();
    mockApiHub.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListVersionsPagedResponse pagedListResponse = client.listVersions(parent);

    List<Version> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVersionsRequest actualRequest = ((ListVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVersionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateVersionTest() throws Exception {
    Version expectedResponse =
        Version.newBuilder()
            .setName(VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDocumentation(Documentation.newBuilder().build())
            .addAllSpecs(new ArrayList<String>())
            .addAllApiOperations(new ArrayList<String>())
            .addAllDefinitions(new ArrayList<String>())
            .addAllDeployments(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLifecycle(AttributeValues.newBuilder().build())
            .setCompliance(AttributeValues.newBuilder().build())
            .setAccreditation(AttributeValues.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setSelectedDeployment(
                DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .build();
    mockApiHub.addResponse(expectedResponse);

    Version version = Version.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Version actualResponse = client.updateVersion(version, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateVersionRequest actualRequest = ((UpdateVersionRequest) actualRequests.get(0));

    Assert.assertEquals(version, actualRequest.getVersion());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      Version version = Version.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateVersion(version, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteVersionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockApiHub.addResponse(expectedResponse);

    VersionName name = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");

    client.deleteVersion(name);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteVersionRequest actualRequest = ((DeleteVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      VersionName name = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
      client.deleteVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteVersionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockApiHub.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteVersion(name);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteVersionRequest actualRequest = ((DeleteVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String name = "name3373707";
      client.deleteVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSpecTest() throws Exception {
    Spec expectedResponse =
        Spec.newBuilder()
            .setName(
                SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
            .setDisplayName("displayName1714148973")
            .setSpecType(AttributeValues.newBuilder().build())
            .setContents(SpecContents.newBuilder().build())
            .setDetails(SpecDetails.newBuilder().build())
            .setSourceUri("sourceUri-1698419887")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLintResponse(LintResponse.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setDocumentation(Documentation.newBuilder().build())
            .build();
    mockApiHub.addResponse(expectedResponse);

    VersionName parent = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
    Spec spec = Spec.newBuilder().build();
    String specId = "specId-896074186";

    Spec actualResponse = client.createSpec(parent, spec, specId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSpecRequest actualRequest = ((CreateSpecRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(spec, actualRequest.getSpec());
    Assert.assertEquals(specId, actualRequest.getSpecId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSpecExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      VersionName parent = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
      Spec spec = Spec.newBuilder().build();
      String specId = "specId-896074186";
      client.createSpec(parent, spec, specId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSpecTest2() throws Exception {
    Spec expectedResponse =
        Spec.newBuilder()
            .setName(
                SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
            .setDisplayName("displayName1714148973")
            .setSpecType(AttributeValues.newBuilder().build())
            .setContents(SpecContents.newBuilder().build())
            .setDetails(SpecDetails.newBuilder().build())
            .setSourceUri("sourceUri-1698419887")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLintResponse(LintResponse.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setDocumentation(Documentation.newBuilder().build())
            .build();
    mockApiHub.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Spec spec = Spec.newBuilder().build();
    String specId = "specId-896074186";

    Spec actualResponse = client.createSpec(parent, spec, specId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSpecRequest actualRequest = ((CreateSpecRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(spec, actualRequest.getSpec());
    Assert.assertEquals(specId, actualRequest.getSpecId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSpecExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String parent = "parent-995424086";
      Spec spec = Spec.newBuilder().build();
      String specId = "specId-896074186";
      client.createSpec(parent, spec, specId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSpecTest() throws Exception {
    Spec expectedResponse =
        Spec.newBuilder()
            .setName(
                SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
            .setDisplayName("displayName1714148973")
            .setSpecType(AttributeValues.newBuilder().build())
            .setContents(SpecContents.newBuilder().build())
            .setDetails(SpecDetails.newBuilder().build())
            .setSourceUri("sourceUri-1698419887")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLintResponse(LintResponse.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setDocumentation(Documentation.newBuilder().build())
            .build();
    mockApiHub.addResponse(expectedResponse);

    SpecName name = SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");

    Spec actualResponse = client.getSpec(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSpecRequest actualRequest = ((GetSpecRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSpecExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      SpecName name = SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
      client.getSpec(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSpecTest2() throws Exception {
    Spec expectedResponse =
        Spec.newBuilder()
            .setName(
                SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
            .setDisplayName("displayName1714148973")
            .setSpecType(AttributeValues.newBuilder().build())
            .setContents(SpecContents.newBuilder().build())
            .setDetails(SpecDetails.newBuilder().build())
            .setSourceUri("sourceUri-1698419887")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLintResponse(LintResponse.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setDocumentation(Documentation.newBuilder().build())
            .build();
    mockApiHub.addResponse(expectedResponse);

    String name = "name3373707";

    Spec actualResponse = client.getSpec(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSpecRequest actualRequest = ((GetSpecRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSpecExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String name = "name3373707";
      client.getSpec(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSpecContentsTest() throws Exception {
    SpecContents expectedResponse =
        SpecContents.newBuilder()
            .setContents(ByteString.EMPTY)
            .setMimeType("mimeType-1392120434")
            .build();
    mockApiHub.addResponse(expectedResponse);

    SpecName name = SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");

    SpecContents actualResponse = client.getSpecContents(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSpecContentsRequest actualRequest = ((GetSpecContentsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSpecContentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      SpecName name = SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
      client.getSpecContents(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSpecContentsTest2() throws Exception {
    SpecContents expectedResponse =
        SpecContents.newBuilder()
            .setContents(ByteString.EMPTY)
            .setMimeType("mimeType-1392120434")
            .build();
    mockApiHub.addResponse(expectedResponse);

    String name = "name3373707";

    SpecContents actualResponse = client.getSpecContents(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSpecContentsRequest actualRequest = ((GetSpecContentsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSpecContentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String name = "name3373707";
      client.getSpecContents(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSpecsTest() throws Exception {
    Spec responsesElement = Spec.newBuilder().build();
    ListSpecsResponse expectedResponse =
        ListSpecsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSpecs(Arrays.asList(responsesElement))
            .build();
    mockApiHub.addResponse(expectedResponse);

    VersionName parent = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");

    ListSpecsPagedResponse pagedListResponse = client.listSpecs(parent);

    List<Spec> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSpecsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSpecsRequest actualRequest = ((ListSpecsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSpecsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      VersionName parent = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
      client.listSpecs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSpecsTest2() throws Exception {
    Spec responsesElement = Spec.newBuilder().build();
    ListSpecsResponse expectedResponse =
        ListSpecsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSpecs(Arrays.asList(responsesElement))
            .build();
    mockApiHub.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSpecsPagedResponse pagedListResponse = client.listSpecs(parent);

    List<Spec> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSpecsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSpecsRequest actualRequest = ((ListSpecsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSpecsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSpecs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSpecTest() throws Exception {
    Spec expectedResponse =
        Spec.newBuilder()
            .setName(
                SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
            .setDisplayName("displayName1714148973")
            .setSpecType(AttributeValues.newBuilder().build())
            .setContents(SpecContents.newBuilder().build())
            .setDetails(SpecDetails.newBuilder().build())
            .setSourceUri("sourceUri-1698419887")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLintResponse(LintResponse.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setDocumentation(Documentation.newBuilder().build())
            .build();
    mockApiHub.addResponse(expectedResponse);

    Spec spec = Spec.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Spec actualResponse = client.updateSpec(spec, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSpecRequest actualRequest = ((UpdateSpecRequest) actualRequests.get(0));

    Assert.assertEquals(spec, actualRequest.getSpec());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSpecExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      Spec spec = Spec.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSpec(spec, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSpecTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockApiHub.addResponse(expectedResponse);

    SpecName name = SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");

    client.deleteSpec(name);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSpecRequest actualRequest = ((DeleteSpecRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSpecExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      SpecName name = SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]");
      client.deleteSpec(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSpecTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockApiHub.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteSpec(name);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSpecRequest actualRequest = ((DeleteSpecRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSpecExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSpec(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApiOperationTest() throws Exception {
    ApiOperation expectedResponse =
        ApiOperation.newBuilder()
            .setName(
                ApiOperationName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[OPERATION]")
                    .toString())
            .setSpec(
                SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
            .setDetails(OperationDetails.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .build();
    mockApiHub.addResponse(expectedResponse);

    ApiOperationName name =
        ApiOperationName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[OPERATION]");

    ApiOperation actualResponse = client.getApiOperation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApiOperationRequest actualRequest = ((GetApiOperationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApiOperationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      ApiOperationName name =
          ApiOperationName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[OPERATION]");
      client.getApiOperation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getApiOperationTest2() throws Exception {
    ApiOperation expectedResponse =
        ApiOperation.newBuilder()
            .setName(
                ApiOperationName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[OPERATION]")
                    .toString())
            .setSpec(
                SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
            .setDetails(OperationDetails.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .build();
    mockApiHub.addResponse(expectedResponse);

    String name = "name3373707";

    ApiOperation actualResponse = client.getApiOperation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetApiOperationRequest actualRequest = ((GetApiOperationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getApiOperationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String name = "name3373707";
      client.getApiOperation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApiOperationsTest() throws Exception {
    ApiOperation responsesElement = ApiOperation.newBuilder().build();
    ListApiOperationsResponse expectedResponse =
        ListApiOperationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApiOperations(Arrays.asList(responsesElement))
            .build();
    mockApiHub.addResponse(expectedResponse);

    VersionName parent = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");

    ListApiOperationsPagedResponse pagedListResponse = client.listApiOperations(parent);

    List<ApiOperation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApiOperationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApiOperationsRequest actualRequest = ((ListApiOperationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApiOperationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      VersionName parent = VersionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]");
      client.listApiOperations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listApiOperationsTest2() throws Exception {
    ApiOperation responsesElement = ApiOperation.newBuilder().build();
    ListApiOperationsResponse expectedResponse =
        ListApiOperationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApiOperations(Arrays.asList(responsesElement))
            .build();
    mockApiHub.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListApiOperationsPagedResponse pagedListResponse = client.listApiOperations(parent);

    List<ApiOperation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getApiOperationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListApiOperationsRequest actualRequest = ((ListApiOperationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listApiOperationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listApiOperations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDefinitionTest() throws Exception {
    Definition expectedResponse =
        Definition.newBuilder()
            .setName(
                DefinitionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[DEFINITION]")
                    .toString())
            .setSpec(
                SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .build();
    mockApiHub.addResponse(expectedResponse);

    DefinitionName name =
        DefinitionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[DEFINITION]");

    Definition actualResponse = client.getDefinition(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDefinitionRequest actualRequest = ((GetDefinitionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDefinitionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      DefinitionName name =
          DefinitionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[DEFINITION]");
      client.getDefinition(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDefinitionTest2() throws Exception {
    Definition expectedResponse =
        Definition.newBuilder()
            .setName(
                DefinitionName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[DEFINITION]")
                    .toString())
            .setSpec(
                SpecName.of("[PROJECT]", "[LOCATION]", "[API]", "[VERSION]", "[SPEC]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .build();
    mockApiHub.addResponse(expectedResponse);

    String name = "name3373707";

    Definition actualResponse = client.getDefinition(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDefinitionRequest actualRequest = ((GetDefinitionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDefinitionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String name = "name3373707";
      client.getDefinition(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDocumentation(Documentation.newBuilder().build())
            .setDeploymentType(AttributeValues.newBuilder().build())
            .setResourceUri("resourceUri1234527870")
            .addAllEndpoints(new ArrayList<String>())
            .addAllApiVersions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSlo(AttributeValues.newBuilder().build())
            .setEnvironment(AttributeValues.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .build();
    mockApiHub.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Deployment deployment = Deployment.newBuilder().build();
    String deploymentId = "deploymentId-136894784";

    Deployment actualResponse = client.createDeployment(parent, deployment, deploymentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeploymentRequest actualRequest = ((CreateDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(deployment, actualRequest.getDeployment());
    Assert.assertEquals(deploymentId, actualRequest.getDeploymentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Deployment deployment = Deployment.newBuilder().build();
      String deploymentId = "deploymentId-136894784";
      client.createDeployment(parent, deployment, deploymentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeploymentTest2() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDocumentation(Documentation.newBuilder().build())
            .setDeploymentType(AttributeValues.newBuilder().build())
            .setResourceUri("resourceUri1234527870")
            .addAllEndpoints(new ArrayList<String>())
            .addAllApiVersions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSlo(AttributeValues.newBuilder().build())
            .setEnvironment(AttributeValues.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .build();
    mockApiHub.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Deployment deployment = Deployment.newBuilder().build();
    String deploymentId = "deploymentId-136894784";

    Deployment actualResponse = client.createDeployment(parent, deployment, deploymentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeploymentRequest actualRequest = ((CreateDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(deployment, actualRequest.getDeployment());
    Assert.assertEquals(deploymentId, actualRequest.getDeploymentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String parent = "parent-995424086";
      Deployment deployment = Deployment.newBuilder().build();
      String deploymentId = "deploymentId-136894784";
      client.createDeployment(parent, deployment, deploymentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDocumentation(Documentation.newBuilder().build())
            .setDeploymentType(AttributeValues.newBuilder().build())
            .setResourceUri("resourceUri1234527870")
            .addAllEndpoints(new ArrayList<String>())
            .addAllApiVersions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSlo(AttributeValues.newBuilder().build())
            .setEnvironment(AttributeValues.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .build();
    mockApiHub.addResponse(expectedResponse);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    Deployment actualResponse = client.getDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeploymentRequest actualRequest = ((GetDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      client.getDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeploymentTest2() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDocumentation(Documentation.newBuilder().build())
            .setDeploymentType(AttributeValues.newBuilder().build())
            .setResourceUri("resourceUri1234527870")
            .addAllEndpoints(new ArrayList<String>())
            .addAllApiVersions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSlo(AttributeValues.newBuilder().build())
            .setEnvironment(AttributeValues.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .build();
    mockApiHub.addResponse(expectedResponse);

    String name = "name3373707";

    Deployment actualResponse = client.getDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeploymentRequest actualRequest = ((GetDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String name = "name3373707";
      client.getDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeploymentsTest() throws Exception {
    Deployment responsesElement = Deployment.newBuilder().build();
    ListDeploymentsResponse expectedResponse =
        ListDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeployments(Arrays.asList(responsesElement))
            .build();
    mockApiHub.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDeploymentsPagedResponse pagedListResponse = client.listDeployments(parent);

    List<Deployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeploymentsRequest actualRequest = ((ListDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDeploymentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeploymentsTest2() throws Exception {
    Deployment responsesElement = Deployment.newBuilder().build();
    ListDeploymentsResponse expectedResponse =
        ListDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeployments(Arrays.asList(responsesElement))
            .build();
    mockApiHub.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDeploymentsPagedResponse pagedListResponse = client.listDeployments(parent);

    List<Deployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeploymentsRequest actualRequest = ((ListDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDeploymentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDocumentation(Documentation.newBuilder().build())
            .setDeploymentType(AttributeValues.newBuilder().build())
            .setResourceUri("resourceUri1234527870")
            .addAllEndpoints(new ArrayList<String>())
            .addAllApiVersions(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSlo(AttributeValues.newBuilder().build())
            .setEnvironment(AttributeValues.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .build();
    mockApiHub.addResponse(expectedResponse);

    Deployment deployment = Deployment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Deployment actualResponse = client.updateDeployment(deployment, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDeploymentRequest actualRequest = ((UpdateDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(deployment, actualRequest.getDeployment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      Deployment deployment = Deployment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDeployment(deployment, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDeploymentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockApiHub.addResponse(expectedResponse);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    client.deleteDeployment(name);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDeploymentRequest actualRequest = ((DeleteDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      client.deleteDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDeploymentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockApiHub.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDeployment(name);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDeploymentRequest actualRequest = ((DeleteDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAttributeTest() throws Exception {
    Attribute expectedResponse =
        Attribute.newBuilder()
            .setName(AttributeName.of("[PROJECT]", "[LOCATION]", "[ATTRIBUTE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllAllowedValues(new ArrayList<Attribute.AllowedValue>())
            .setCardinality(845213070)
            .setMandatory(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockApiHub.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Attribute attribute = Attribute.newBuilder().build();
    String attributeId = "attributeId-309887785";

    Attribute actualResponse = client.createAttribute(parent, attribute, attributeId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAttributeRequest actualRequest = ((CreateAttributeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(attribute, actualRequest.getAttribute());
    Assert.assertEquals(attributeId, actualRequest.getAttributeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAttributeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Attribute attribute = Attribute.newBuilder().build();
      String attributeId = "attributeId-309887785";
      client.createAttribute(parent, attribute, attributeId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAttributeTest2() throws Exception {
    Attribute expectedResponse =
        Attribute.newBuilder()
            .setName(AttributeName.of("[PROJECT]", "[LOCATION]", "[ATTRIBUTE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllAllowedValues(new ArrayList<Attribute.AllowedValue>())
            .setCardinality(845213070)
            .setMandatory(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockApiHub.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Attribute attribute = Attribute.newBuilder().build();
    String attributeId = "attributeId-309887785";

    Attribute actualResponse = client.createAttribute(parent, attribute, attributeId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAttributeRequest actualRequest = ((CreateAttributeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(attribute, actualRequest.getAttribute());
    Assert.assertEquals(attributeId, actualRequest.getAttributeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAttributeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String parent = "parent-995424086";
      Attribute attribute = Attribute.newBuilder().build();
      String attributeId = "attributeId-309887785";
      client.createAttribute(parent, attribute, attributeId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttributeTest() throws Exception {
    Attribute expectedResponse =
        Attribute.newBuilder()
            .setName(AttributeName.of("[PROJECT]", "[LOCATION]", "[ATTRIBUTE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllAllowedValues(new ArrayList<Attribute.AllowedValue>())
            .setCardinality(845213070)
            .setMandatory(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockApiHub.addResponse(expectedResponse);

    AttributeName name = AttributeName.of("[PROJECT]", "[LOCATION]", "[ATTRIBUTE]");

    Attribute actualResponse = client.getAttribute(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAttributeRequest actualRequest = ((GetAttributeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAttributeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      AttributeName name = AttributeName.of("[PROJECT]", "[LOCATION]", "[ATTRIBUTE]");
      client.getAttribute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttributeTest2() throws Exception {
    Attribute expectedResponse =
        Attribute.newBuilder()
            .setName(AttributeName.of("[PROJECT]", "[LOCATION]", "[ATTRIBUTE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllAllowedValues(new ArrayList<Attribute.AllowedValue>())
            .setCardinality(845213070)
            .setMandatory(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockApiHub.addResponse(expectedResponse);

    String name = "name3373707";

    Attribute actualResponse = client.getAttribute(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAttributeRequest actualRequest = ((GetAttributeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAttributeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String name = "name3373707";
      client.getAttribute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAttributeTest() throws Exception {
    Attribute expectedResponse =
        Attribute.newBuilder()
            .setName(AttributeName.of("[PROJECT]", "[LOCATION]", "[ATTRIBUTE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllAllowedValues(new ArrayList<Attribute.AllowedValue>())
            .setCardinality(845213070)
            .setMandatory(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockApiHub.addResponse(expectedResponse);

    Attribute attribute = Attribute.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Attribute actualResponse = client.updateAttribute(attribute, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAttributeRequest actualRequest = ((UpdateAttributeRequest) actualRequests.get(0));

    Assert.assertEquals(attribute, actualRequest.getAttribute());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAttributeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      Attribute attribute = Attribute.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAttribute(attribute, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAttributeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockApiHub.addResponse(expectedResponse);

    AttributeName name = AttributeName.of("[PROJECT]", "[LOCATION]", "[ATTRIBUTE]");

    client.deleteAttribute(name);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAttributeRequest actualRequest = ((DeleteAttributeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAttributeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      AttributeName name = AttributeName.of("[PROJECT]", "[LOCATION]", "[ATTRIBUTE]");
      client.deleteAttribute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAttributeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockApiHub.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAttribute(name);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAttributeRequest actualRequest = ((DeleteAttributeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAttributeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAttribute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAttributesTest() throws Exception {
    Attribute responsesElement = Attribute.newBuilder().build();
    ListAttributesResponse expectedResponse =
        ListAttributesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAttributes(Arrays.asList(responsesElement))
            .build();
    mockApiHub.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAttributesPagedResponse pagedListResponse = client.listAttributes(parent);

    List<Attribute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAttributesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAttributesRequest actualRequest = ((ListAttributesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAttributesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAttributes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAttributesTest2() throws Exception {
    Attribute responsesElement = Attribute.newBuilder().build();
    ListAttributesResponse expectedResponse =
        ListAttributesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAttributes(Arrays.asList(responsesElement))
            .build();
    mockApiHub.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAttributesPagedResponse pagedListResponse = client.listAttributes(parent);

    List<Attribute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAttributesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAttributesRequest actualRequest = ((ListAttributesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAttributesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAttributes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchResourcesTest() throws Exception {
    SearchResult responsesElement = SearchResult.newBuilder().build();
    SearchResourcesResponse expectedResponse =
        SearchResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSearchResults(Arrays.asList(responsesElement))
            .build();
    mockApiHub.addResponse(expectedResponse);

    LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
    String query = "query107944136";

    SearchResourcesPagedResponse pagedListResponse = client.searchResources(location, query);

    List<SearchResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchResourcesRequest actualRequest = ((SearchResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(location.toString(), actualRequest.getLocation());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchResourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
      String query = "query107944136";
      client.searchResources(location, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchResourcesTest2() throws Exception {
    SearchResult responsesElement = SearchResult.newBuilder().build();
    SearchResourcesResponse expectedResponse =
        SearchResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSearchResults(Arrays.asList(responsesElement))
            .build();
    mockApiHub.addResponse(expectedResponse);

    String location = "location1901043637";
    String query = "query107944136";

    SearchResourcesPagedResponse pagedListResponse = client.searchResources(location, query);

    List<SearchResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchResourcesRequest actualRequest = ((SearchResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(location, actualRequest.getLocation());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchResourcesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String location = "location1901043637";
      String query = "query107944136";
      client.searchResources(location, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExternalApiTest() throws Exception {
    ExternalApi expectedResponse =
        ExternalApi.newBuilder()
            .setName(ExternalApiName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_API]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllEndpoints(new ArrayList<String>())
            .addAllPaths(new ArrayList<String>())
            .setDocumentation(Documentation.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockApiHub.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ExternalApi externalApi = ExternalApi.newBuilder().build();
    String externalApiId = "externalApiId-31672374";

    ExternalApi actualResponse = client.createExternalApi(parent, externalApi, externalApiId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExternalApiRequest actualRequest = ((CreateExternalApiRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(externalApi, actualRequest.getExternalApi());
    Assert.assertEquals(externalApiId, actualRequest.getExternalApiId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExternalApiExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ExternalApi externalApi = ExternalApi.newBuilder().build();
      String externalApiId = "externalApiId-31672374";
      client.createExternalApi(parent, externalApi, externalApiId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExternalApiTest2() throws Exception {
    ExternalApi expectedResponse =
        ExternalApi.newBuilder()
            .setName(ExternalApiName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_API]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllEndpoints(new ArrayList<String>())
            .addAllPaths(new ArrayList<String>())
            .setDocumentation(Documentation.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockApiHub.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ExternalApi externalApi = ExternalApi.newBuilder().build();
    String externalApiId = "externalApiId-31672374";

    ExternalApi actualResponse = client.createExternalApi(parent, externalApi, externalApiId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExternalApiRequest actualRequest = ((CreateExternalApiRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(externalApi, actualRequest.getExternalApi());
    Assert.assertEquals(externalApiId, actualRequest.getExternalApiId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExternalApiExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String parent = "parent-995424086";
      ExternalApi externalApi = ExternalApi.newBuilder().build();
      String externalApiId = "externalApiId-31672374";
      client.createExternalApi(parent, externalApi, externalApiId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExternalApiTest() throws Exception {
    ExternalApi expectedResponse =
        ExternalApi.newBuilder()
            .setName(ExternalApiName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_API]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllEndpoints(new ArrayList<String>())
            .addAllPaths(new ArrayList<String>())
            .setDocumentation(Documentation.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockApiHub.addResponse(expectedResponse);

    ExternalApiName name = ExternalApiName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_API]");

    ExternalApi actualResponse = client.getExternalApi(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExternalApiRequest actualRequest = ((GetExternalApiRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExternalApiExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      ExternalApiName name = ExternalApiName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_API]");
      client.getExternalApi(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExternalApiTest2() throws Exception {
    ExternalApi expectedResponse =
        ExternalApi.newBuilder()
            .setName(ExternalApiName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_API]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllEndpoints(new ArrayList<String>())
            .addAllPaths(new ArrayList<String>())
            .setDocumentation(Documentation.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockApiHub.addResponse(expectedResponse);

    String name = "name3373707";

    ExternalApi actualResponse = client.getExternalApi(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExternalApiRequest actualRequest = ((GetExternalApiRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExternalApiExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String name = "name3373707";
      client.getExternalApi(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateExternalApiTest() throws Exception {
    ExternalApi expectedResponse =
        ExternalApi.newBuilder()
            .setName(ExternalApiName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_API]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllEndpoints(new ArrayList<String>())
            .addAllPaths(new ArrayList<String>())
            .setDocumentation(Documentation.newBuilder().build())
            .putAllAttributes(new HashMap<String, AttributeValues>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockApiHub.addResponse(expectedResponse);

    ExternalApi externalApi = ExternalApi.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ExternalApi actualResponse = client.updateExternalApi(externalApi, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateExternalApiRequest actualRequest = ((UpdateExternalApiRequest) actualRequests.get(0));

    Assert.assertEquals(externalApi, actualRequest.getExternalApi());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateExternalApiExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      ExternalApi externalApi = ExternalApi.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateExternalApi(externalApi, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteExternalApiTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockApiHub.addResponse(expectedResponse);

    ExternalApiName name = ExternalApiName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_API]");

    client.deleteExternalApi(name);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExternalApiRequest actualRequest = ((DeleteExternalApiRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExternalApiExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      ExternalApiName name = ExternalApiName.of("[PROJECT]", "[LOCATION]", "[EXTERNAL_API]");
      client.deleteExternalApi(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteExternalApiTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockApiHub.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteExternalApi(name);

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExternalApiRequest actualRequest = ((DeleteExternalApiRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExternalApiExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String name = "name3373707";
      client.deleteExternalApi(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExternalApisTest() throws Exception {
    ExternalApi responsesElement = ExternalApi.newBuilder().build();
    ListExternalApisResponse expectedResponse =
        ListExternalApisResponse.newBuilder()
            .setNextPageToken("")
            .addAllExternalApis(Arrays.asList(responsesElement))
            .build();
    mockApiHub.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListExternalApisPagedResponse pagedListResponse = client.listExternalApis(parent);

    List<ExternalApi> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExternalApisList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExternalApisRequest actualRequest = ((ListExternalApisRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExternalApisExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listExternalApis(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExternalApisTest2() throws Exception {
    ExternalApi responsesElement = ExternalApi.newBuilder().build();
    ListExternalApisResponse expectedResponse =
        ListExternalApisResponse.newBuilder()
            .setNextPageToken("")
            .addAllExternalApis(Arrays.asList(responsesElement))
            .build();
    mockApiHub.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListExternalApisPagedResponse pagedListResponse = client.listExternalApis(parent);

    List<ExternalApi> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExternalApisList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockApiHub.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExternalApisRequest actualRequest = ((ListExternalApisRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExternalApisExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockApiHub.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listExternalApis(parent);
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
}
