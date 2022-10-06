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

package com.google.appengine.v1;

import static com.google.appengine.v1.VersionsClient.ListVersionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.appengine.v1.stub.HttpJsonVersionsStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
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
public class VersionsClientHttpJsonTest {
  private static MockHttpService mockService;
  private static VersionsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonVersionsStub.getMethodDescriptors(), VersionsSettings.getDefaultEndpoint());
    VersionsSettings settings =
        VersionsSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                VersionsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = VersionsClient.create(settings);
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
  public void listVersionsTest() throws Exception {
    Version responsesElement = Version.newBuilder().build();
    ListVersionsResponse expectedResponse =
        ListVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListVersionsRequest request =
        ListVersionsRequest.newBuilder()
            .setParent("apps/app-4783/services/service-4783")
            .setView(VersionView.forNumber(0))
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListVersionsPagedResponse pagedListResponse = client.listVersions(request);

    List<Version> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVersionsList().get(0), resources.get(0));

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
  public void listVersionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListVersionsRequest request =
          ListVersionsRequest.newBuilder()
              .setParent("apps/app-4783/services/service-4783")
              .setView(VersionView.forNumber(0))
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listVersions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVersionTest() throws Exception {
    Version expectedResponse =
        Version.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .addAllInboundServices(new ArrayList<InboundServiceType>())
            .setInstanceClass("instanceClass-1408583197")
            .setNetwork(Network.newBuilder().build())
            .addAllZones(new ArrayList<String>())
            .setResources(Resources.newBuilder().build())
            .setRuntime("runtime1550962648")
            .setRuntimeChannel("runtimeChannel989413899")
            .setThreadsafe(true)
            .setVm(true)
            .setAppEngineApis(true)
            .putAllBetaSettings(new HashMap<String, String>())
            .setEnv("env100589")
            .setServingStatus(ServingStatus.forNumber(0))
            .setCreatedBy("createdBy598371679")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDiskUsageBytes(1139084459)
            .setRuntimeApiVersion("runtimeApiVersion-925808810")
            .setRuntimeMainExecutablePath("runtimeMainExecutablePath454707104")
            .setServiceAccount("serviceAccount1079137720")
            .addAllHandlers(new ArrayList<UrlMap>())
            .addAllErrorHandlers(new ArrayList<ErrorHandler>())
            .addAllLibraries(new ArrayList<Library>())
            .setApiConfig(ApiConfigHandler.newBuilder().build())
            .putAllEnvVariables(new HashMap<String, String>())
            .putAllBuildEnvVariables(new HashMap<String, String>())
            .setDefaultExpiration(Duration.newBuilder().build())
            .setHealthCheck(HealthCheck.newBuilder().build())
            .setReadinessCheck(ReadinessCheck.newBuilder().build())
            .setLivenessCheck(LivenessCheck.newBuilder().build())
            .setNobuildFilesRegex("nobuildFilesRegex1787347261")
            .setDeployment(Deployment.newBuilder().build())
            .setVersionUrl("versionUrl-670506633")
            .setEndpointsApiService(EndpointsApiService.newBuilder().build())
            .setEntrypoint(Entrypoint.newBuilder().build())
            .setVpcAccessConnector(VpcAccessConnector.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GetVersionRequest request =
        GetVersionRequest.newBuilder()
            .setName("apps/app-69/services/service-69/versions/version-69")
            .setView(VersionView.forNumber(0))
            .build();

    Version actualResponse = client.getVersion(request);
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
  public void getVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetVersionRequest request =
          GetVersionRequest.newBuilder()
              .setName("apps/app-69/services/service-69/versions/version-69")
              .setView(VersionView.forNumber(0))
              .build();
      client.getVersion(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createVersionTest() throws Exception {
    Version expectedResponse =
        Version.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .addAllInboundServices(new ArrayList<InboundServiceType>())
            .setInstanceClass("instanceClass-1408583197")
            .setNetwork(Network.newBuilder().build())
            .addAllZones(new ArrayList<String>())
            .setResources(Resources.newBuilder().build())
            .setRuntime("runtime1550962648")
            .setRuntimeChannel("runtimeChannel989413899")
            .setThreadsafe(true)
            .setVm(true)
            .setAppEngineApis(true)
            .putAllBetaSettings(new HashMap<String, String>())
            .setEnv("env100589")
            .setServingStatus(ServingStatus.forNumber(0))
            .setCreatedBy("createdBy598371679")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDiskUsageBytes(1139084459)
            .setRuntimeApiVersion("runtimeApiVersion-925808810")
            .setRuntimeMainExecutablePath("runtimeMainExecutablePath454707104")
            .setServiceAccount("serviceAccount1079137720")
            .addAllHandlers(new ArrayList<UrlMap>())
            .addAllErrorHandlers(new ArrayList<ErrorHandler>())
            .addAllLibraries(new ArrayList<Library>())
            .setApiConfig(ApiConfigHandler.newBuilder().build())
            .putAllEnvVariables(new HashMap<String, String>())
            .putAllBuildEnvVariables(new HashMap<String, String>())
            .setDefaultExpiration(Duration.newBuilder().build())
            .setHealthCheck(HealthCheck.newBuilder().build())
            .setReadinessCheck(ReadinessCheck.newBuilder().build())
            .setLivenessCheck(LivenessCheck.newBuilder().build())
            .setNobuildFilesRegex("nobuildFilesRegex1787347261")
            .setDeployment(Deployment.newBuilder().build())
            .setVersionUrl("versionUrl-670506633")
            .setEndpointsApiService(EndpointsApiService.newBuilder().build())
            .setEntrypoint(Entrypoint.newBuilder().build())
            .setVpcAccessConnector(VpcAccessConnector.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createVersionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CreateVersionRequest request =
        CreateVersionRequest.newBuilder()
            .setParent("apps/app-4783/services/service-4783")
            .setVersion(Version.newBuilder().build())
            .build();

    Version actualResponse = client.createVersionAsync(request).get();
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
  public void createVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateVersionRequest request =
          CreateVersionRequest.newBuilder()
              .setParent("apps/app-4783/services/service-4783")
              .setVersion(Version.newBuilder().build())
              .build();
      client.createVersionAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateVersionTest() throws Exception {
    Version expectedResponse =
        Version.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .addAllInboundServices(new ArrayList<InboundServiceType>())
            .setInstanceClass("instanceClass-1408583197")
            .setNetwork(Network.newBuilder().build())
            .addAllZones(new ArrayList<String>())
            .setResources(Resources.newBuilder().build())
            .setRuntime("runtime1550962648")
            .setRuntimeChannel("runtimeChannel989413899")
            .setThreadsafe(true)
            .setVm(true)
            .setAppEngineApis(true)
            .putAllBetaSettings(new HashMap<String, String>())
            .setEnv("env100589")
            .setServingStatus(ServingStatus.forNumber(0))
            .setCreatedBy("createdBy598371679")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDiskUsageBytes(1139084459)
            .setRuntimeApiVersion("runtimeApiVersion-925808810")
            .setRuntimeMainExecutablePath("runtimeMainExecutablePath454707104")
            .setServiceAccount("serviceAccount1079137720")
            .addAllHandlers(new ArrayList<UrlMap>())
            .addAllErrorHandlers(new ArrayList<ErrorHandler>())
            .addAllLibraries(new ArrayList<Library>())
            .setApiConfig(ApiConfigHandler.newBuilder().build())
            .putAllEnvVariables(new HashMap<String, String>())
            .putAllBuildEnvVariables(new HashMap<String, String>())
            .setDefaultExpiration(Duration.newBuilder().build())
            .setHealthCheck(HealthCheck.newBuilder().build())
            .setReadinessCheck(ReadinessCheck.newBuilder().build())
            .setLivenessCheck(LivenessCheck.newBuilder().build())
            .setNobuildFilesRegex("nobuildFilesRegex1787347261")
            .setDeployment(Deployment.newBuilder().build())
            .setVersionUrl("versionUrl-670506633")
            .setEndpointsApiService(EndpointsApiService.newBuilder().build())
            .setEntrypoint(Entrypoint.newBuilder().build())
            .setVpcAccessConnector(VpcAccessConnector.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateVersionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    UpdateVersionRequest request =
        UpdateVersionRequest.newBuilder()
            .setName("apps/app-69/services/service-69/versions/version-69")
            .setVersion(Version.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Version actualResponse = client.updateVersionAsync(request).get();
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
  public void updateVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateVersionRequest request =
          UpdateVersionRequest.newBuilder()
              .setName("apps/app-69/services/service-69/versions/version-69")
              .setVersion(Version.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateVersionAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteVersionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteVersionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DeleteVersionRequest request =
        DeleteVersionRequest.newBuilder()
            .setName("apps/app-69/services/service-69/versions/version-69")
            .build();

    client.deleteVersionAsync(request).get();

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
  public void deleteVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeleteVersionRequest request =
          DeleteVersionRequest.newBuilder()
              .setName("apps/app-69/services/service-69/versions/version-69")
              .build();
      client.deleteVersionAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
