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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
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
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class VersionsClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockVersions mockVersions;
  private LocalChannelProvider channelProvider;
  private VersionsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockVersions = new MockVersions();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockVersions));
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
    VersionsSettings settings =
        VersionsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = VersionsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listVersionsTest() throws Exception {
    Version responsesElement = Version.newBuilder().build();
    ListVersionsResponse expectedResponse =
        ListVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllVersions(Arrays.asList(responsesElement))
            .build();
    mockVersions.addResponse(expectedResponse);

    ListVersionsRequest request =
        ListVersionsRequest.newBuilder()
            .setParent("parent-995424086")
            .setView(VersionView.forNumber(0))
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListVersionsPagedResponse pagedListResponse = client.listVersions(request);

    List<Version> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVersions.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListVersionsRequest actualRequest = ((ListVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVersions.addException(exception);

    try {
      ListVersionsRequest request =
          ListVersionsRequest.newBuilder()
              .setParent("parent-995424086")
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
    mockVersions.addResponse(expectedResponse);

    GetVersionRequest request =
        GetVersionRequest.newBuilder()
            .setName("name3373707")
            .setView(VersionView.forNumber(0))
            .build();

    Version actualResponse = client.getVersion(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVersions.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVersionRequest actualRequest = ((GetVersionRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVersions.addException(exception);

    try {
      GetVersionRequest request =
          GetVersionRequest.newBuilder()
              .setName("name3373707")
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
    mockVersions.addResponse(resultOperation);

    CreateVersionRequest request =
        CreateVersionRequest.newBuilder()
            .setParent("parent-995424086")
            .setVersion(Version.newBuilder().build())
            .build();

    Version actualResponse = client.createVersionAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVersions.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateVersionRequest actualRequest = ((CreateVersionRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getVersion(), actualRequest.getVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVersions.addException(exception);

    try {
      CreateVersionRequest request =
          CreateVersionRequest.newBuilder()
              .setParent("parent-995424086")
              .setVersion(Version.newBuilder().build())
              .build();
      client.createVersionAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockVersions.addResponse(resultOperation);

    UpdateVersionRequest request =
        UpdateVersionRequest.newBuilder()
            .setName("name3373707")
            .setVersion(Version.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Version actualResponse = client.updateVersionAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVersions.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateVersionRequest actualRequest = ((UpdateVersionRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getVersion(), actualRequest.getVersion());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVersions.addException(exception);

    try {
      UpdateVersionRequest request =
          UpdateVersionRequest.newBuilder()
              .setName("name3373707")
              .setVersion(Version.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateVersionAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockVersions.addResponse(resultOperation);

    DeleteVersionRequest request = DeleteVersionRequest.newBuilder().setName("name3373707").build();

    client.deleteVersionAsync(request).get();

    List<AbstractMessage> actualRequests = mockVersions.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteVersionRequest actualRequest = ((DeleteVersionRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVersions.addException(exception);

    try {
      DeleteVersionRequest request =
          DeleteVersionRequest.newBuilder().setName("name3373707").build();
      client.deleteVersionAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
