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

package com.google.cloud.ces.v1;

import static com.google.cloud.ces.v1.AgentServiceClient.ListAgentsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListAppVersionsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListAppsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListChangelogsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListConversationsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListDeploymentsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListExamplesPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListGuardrailsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListToolsPagedResponse;
import static com.google.cloud.ces.v1.AgentServiceClient.ListToolsetsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Struct;
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
public class AgentServiceClientTest {
  private static MockAgentService mockAgentService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AgentServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAgentService = new MockAgentService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAgentService, mockLocations));
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
    AgentServiceSettings settings =
        AgentServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AgentServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listAppsTest() throws Exception {
    App responsesElement = App.newBuilder().build();
    ListAppsResponse expectedResponse =
        ListAppsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApps(Arrays.asList(responsesElement))
            .build();
    mockAgentService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAppsPagedResponse pagedListResponse = client.listApps(parent);

    List<App> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAppsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAppsRequest actualRequest = ((ListAppsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAppsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listApps(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAppsTest2() throws Exception {
    App responsesElement = App.newBuilder().build();
    ListAppsResponse expectedResponse =
        ListAppsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApps(Arrays.asList(responsesElement))
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAppsPagedResponse pagedListResponse = client.listApps(parent);

    List<App> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAppsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAppsRequest actualRequest = ((ListAppsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAppsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listApps(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAppTest() throws Exception {
    App expectedResponse =
        App.newBuilder()
            .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPinned(true)
            .setRootAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .setLanguageSettings(LanguageSettings.newBuilder().build())
            .setTimeZoneSettings(TimeZoneSettings.newBuilder().build())
            .setAudioProcessingConfig(AudioProcessingConfig.newBuilder().build())
            .setLoggingSettings(LoggingSettings.newBuilder().build())
            .setModelSettings(ModelSettings.newBuilder().build())
            .setEvaluationMetricsThresholds(EvaluationMetricsThresholds.newBuilder().build())
            .addAllVariableDeclarations(new ArrayList<App.VariableDeclaration>())
            .addAllPredefinedVariableDeclarations(new ArrayList<App.VariableDeclaration>())
            .setGlobalInstruction("globalInstruction518388971")
            .addAllGuardrails(new ArrayList<String>())
            .setDataStoreSettings(DataStoreSettings.newBuilder().build())
            .setDefaultChannelProfile(ChannelProfile.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setDeploymentCount(2081851157)
            .setClientCertificateSettings(ClientCertificateSettings.newBuilder().build())
            .setLocked(true)
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    App actualResponse = client.getApp(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAppRequest actualRequest = ((GetAppRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAppExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.getApp(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAppTest2() throws Exception {
    App expectedResponse =
        App.newBuilder()
            .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPinned(true)
            .setRootAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .setLanguageSettings(LanguageSettings.newBuilder().build())
            .setTimeZoneSettings(TimeZoneSettings.newBuilder().build())
            .setAudioProcessingConfig(AudioProcessingConfig.newBuilder().build())
            .setLoggingSettings(LoggingSettings.newBuilder().build())
            .setModelSettings(ModelSettings.newBuilder().build())
            .setEvaluationMetricsThresholds(EvaluationMetricsThresholds.newBuilder().build())
            .addAllVariableDeclarations(new ArrayList<App.VariableDeclaration>())
            .addAllPredefinedVariableDeclarations(new ArrayList<App.VariableDeclaration>())
            .setGlobalInstruction("globalInstruction518388971")
            .addAllGuardrails(new ArrayList<String>())
            .setDataStoreSettings(DataStoreSettings.newBuilder().build())
            .setDefaultChannelProfile(ChannelProfile.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setDeploymentCount(2081851157)
            .setClientCertificateSettings(ClientCertificateSettings.newBuilder().build())
            .setLocked(true)
            .build();
    mockAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    App actualResponse = client.getApp(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAppRequest actualRequest = ((GetAppRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAppExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.getApp(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAppTest() throws Exception {
    App expectedResponse =
        App.newBuilder()
            .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPinned(true)
            .setRootAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .setLanguageSettings(LanguageSettings.newBuilder().build())
            .setTimeZoneSettings(TimeZoneSettings.newBuilder().build())
            .setAudioProcessingConfig(AudioProcessingConfig.newBuilder().build())
            .setLoggingSettings(LoggingSettings.newBuilder().build())
            .setModelSettings(ModelSettings.newBuilder().build())
            .setEvaluationMetricsThresholds(EvaluationMetricsThresholds.newBuilder().build())
            .addAllVariableDeclarations(new ArrayList<App.VariableDeclaration>())
            .addAllPredefinedVariableDeclarations(new ArrayList<App.VariableDeclaration>())
            .setGlobalInstruction("globalInstruction518388971")
            .addAllGuardrails(new ArrayList<String>())
            .setDataStoreSettings(DataStoreSettings.newBuilder().build())
            .setDefaultChannelProfile(ChannelProfile.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setDeploymentCount(2081851157)
            .setClientCertificateSettings(ClientCertificateSettings.newBuilder().build())
            .setLocked(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAppTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    App app = App.newBuilder().build();

    App actualResponse = client.createAppAsync(parent, app).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAppRequest actualRequest = ((CreateAppRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(app, actualRequest.getApp());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAppExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      App app = App.newBuilder().build();
      client.createAppAsync(parent, app).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAppTest2() throws Exception {
    App expectedResponse =
        App.newBuilder()
            .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPinned(true)
            .setRootAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .setLanguageSettings(LanguageSettings.newBuilder().build())
            .setTimeZoneSettings(TimeZoneSettings.newBuilder().build())
            .setAudioProcessingConfig(AudioProcessingConfig.newBuilder().build())
            .setLoggingSettings(LoggingSettings.newBuilder().build())
            .setModelSettings(ModelSettings.newBuilder().build())
            .setEvaluationMetricsThresholds(EvaluationMetricsThresholds.newBuilder().build())
            .addAllVariableDeclarations(new ArrayList<App.VariableDeclaration>())
            .addAllPredefinedVariableDeclarations(new ArrayList<App.VariableDeclaration>())
            .setGlobalInstruction("globalInstruction518388971")
            .addAllGuardrails(new ArrayList<String>())
            .setDataStoreSettings(DataStoreSettings.newBuilder().build())
            .setDefaultChannelProfile(ChannelProfile.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setDeploymentCount(2081851157)
            .setClientCertificateSettings(ClientCertificateSettings.newBuilder().build())
            .setLocked(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAppTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentService.addResponse(resultOperation);

    String parent = "parent-995424086";
    App app = App.newBuilder().build();

    App actualResponse = client.createAppAsync(parent, app).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAppRequest actualRequest = ((CreateAppRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(app, actualRequest.getApp());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAppExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      App app = App.newBuilder().build();
      client.createAppAsync(parent, app).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAppTest3() throws Exception {
    App expectedResponse =
        App.newBuilder()
            .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPinned(true)
            .setRootAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .setLanguageSettings(LanguageSettings.newBuilder().build())
            .setTimeZoneSettings(TimeZoneSettings.newBuilder().build())
            .setAudioProcessingConfig(AudioProcessingConfig.newBuilder().build())
            .setLoggingSettings(LoggingSettings.newBuilder().build())
            .setModelSettings(ModelSettings.newBuilder().build())
            .setEvaluationMetricsThresholds(EvaluationMetricsThresholds.newBuilder().build())
            .addAllVariableDeclarations(new ArrayList<App.VariableDeclaration>())
            .addAllPredefinedVariableDeclarations(new ArrayList<App.VariableDeclaration>())
            .setGlobalInstruction("globalInstruction518388971")
            .addAllGuardrails(new ArrayList<String>())
            .setDataStoreSettings(DataStoreSettings.newBuilder().build())
            .setDefaultChannelProfile(ChannelProfile.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setDeploymentCount(2081851157)
            .setClientCertificateSettings(ClientCertificateSettings.newBuilder().build())
            .setLocked(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAppTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    App app = App.newBuilder().build();
    String appId = "appId93028124";

    App actualResponse = client.createAppAsync(parent, app, appId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAppRequest actualRequest = ((CreateAppRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(app, actualRequest.getApp());
    Assert.assertEquals(appId, actualRequest.getAppId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAppExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      App app = App.newBuilder().build();
      String appId = "appId93028124";
      client.createAppAsync(parent, app, appId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAppTest4() throws Exception {
    App expectedResponse =
        App.newBuilder()
            .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPinned(true)
            .setRootAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .setLanguageSettings(LanguageSettings.newBuilder().build())
            .setTimeZoneSettings(TimeZoneSettings.newBuilder().build())
            .setAudioProcessingConfig(AudioProcessingConfig.newBuilder().build())
            .setLoggingSettings(LoggingSettings.newBuilder().build())
            .setModelSettings(ModelSettings.newBuilder().build())
            .setEvaluationMetricsThresholds(EvaluationMetricsThresholds.newBuilder().build())
            .addAllVariableDeclarations(new ArrayList<App.VariableDeclaration>())
            .addAllPredefinedVariableDeclarations(new ArrayList<App.VariableDeclaration>())
            .setGlobalInstruction("globalInstruction518388971")
            .addAllGuardrails(new ArrayList<String>())
            .setDataStoreSettings(DataStoreSettings.newBuilder().build())
            .setDefaultChannelProfile(ChannelProfile.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setDeploymentCount(2081851157)
            .setClientCertificateSettings(ClientCertificateSettings.newBuilder().build())
            .setLocked(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAppTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentService.addResponse(resultOperation);

    String parent = "parent-995424086";
    App app = App.newBuilder().build();
    String appId = "appId93028124";

    App actualResponse = client.createAppAsync(parent, app, appId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAppRequest actualRequest = ((CreateAppRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(app, actualRequest.getApp());
    Assert.assertEquals(appId, actualRequest.getAppId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAppExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      App app = App.newBuilder().build();
      String appId = "appId93028124";
      client.createAppAsync(parent, app, appId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateAppTest() throws Exception {
    App expectedResponse =
        App.newBuilder()
            .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPinned(true)
            .setRootAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .setLanguageSettings(LanguageSettings.newBuilder().build())
            .setTimeZoneSettings(TimeZoneSettings.newBuilder().build())
            .setAudioProcessingConfig(AudioProcessingConfig.newBuilder().build())
            .setLoggingSettings(LoggingSettings.newBuilder().build())
            .setModelSettings(ModelSettings.newBuilder().build())
            .setEvaluationMetricsThresholds(EvaluationMetricsThresholds.newBuilder().build())
            .addAllVariableDeclarations(new ArrayList<App.VariableDeclaration>())
            .addAllPredefinedVariableDeclarations(new ArrayList<App.VariableDeclaration>())
            .setGlobalInstruction("globalInstruction518388971")
            .addAllGuardrails(new ArrayList<String>())
            .setDataStoreSettings(DataStoreSettings.newBuilder().build())
            .setDefaultChannelProfile(ChannelProfile.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setDeploymentCount(2081851157)
            .setClientCertificateSettings(ClientCertificateSettings.newBuilder().build())
            .setLocked(true)
            .build();
    mockAgentService.addResponse(expectedResponse);

    App app = App.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    App actualResponse = client.updateApp(app, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAppRequest actualRequest = ((UpdateAppRequest) actualRequests.get(0));

    Assert.assertEquals(app, actualRequest.getApp());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAppExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      App app = App.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateApp(app, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAppTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAppTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentService.addResponse(resultOperation);

    AppName name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    client.deleteAppAsync(name).get();

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAppRequest actualRequest = ((DeleteAppRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAppExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.deleteAppAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAppTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAppTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAppAsync(name).get();

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAppRequest actualRequest = ((DeleteAppRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAppExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAppAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportAppTest() throws Exception {
    ExportAppResponse expectedResponse = ExportAppResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportAppTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentService.addResponse(resultOperation);

    AppName name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ExportAppResponse actualResponse = client.exportAppAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportAppRequest actualRequest = ((ExportAppRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportAppExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.exportAppAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportAppTest2() throws Exception {
    ExportAppResponse expectedResponse = ExportAppResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportAppTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentService.addResponse(resultOperation);

    String name = "name3373707";

    ExportAppResponse actualResponse = client.exportAppAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportAppRequest actualRequest = ((ExportAppRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportAppExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.exportAppAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importAppTest() throws Exception {
    ImportAppResponse expectedResponse =
        ImportAppResponse.newBuilder()
            .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
            .addAllWarnings(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importAppTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String displayName = "displayName1714148973";
    String appId = "appId93028124";

    ImportAppResponse actualResponse = client.importAppAsync(parent, displayName, appId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportAppRequest actualRequest = ((ImportAppRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(displayName, actualRequest.getDisplayName());
    Assert.assertEquals(appId, actualRequest.getAppId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importAppExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String displayName = "displayName1714148973";
      String appId = "appId93028124";
      client.importAppAsync(parent, displayName, appId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importAppTest2() throws Exception {
    ImportAppResponse expectedResponse =
        ImportAppResponse.newBuilder()
            .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
            .addAllWarnings(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importAppTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentService.addResponse(resultOperation);

    String parent = "parent-995424086";
    String displayName = "displayName1714148973";
    String appId = "appId93028124";

    ImportAppResponse actualResponse = client.importAppAsync(parent, displayName, appId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportAppRequest actualRequest = ((ImportAppRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(displayName, actualRequest.getDisplayName());
    Assert.assertEquals(appId, actualRequest.getAppId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importAppExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      String displayName = "displayName1714148973";
      String appId = "appId93028124";
      client.importAppAsync(parent, displayName, appId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listAgentsTest() throws Exception {
    Agent responsesElement = Agent.newBuilder().build();
    ListAgentsResponse expectedResponse =
        ListAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAgents(Arrays.asList(responsesElement))
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListAgentsPagedResponse pagedListResponse = client.listAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAgentsRequest actualRequest = ((ListAgentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAgentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.listAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAgentsTest2() throws Exception {
    Agent responsesElement = Agent.newBuilder().build();
    ListAgentsResponse expectedResponse =
        ListAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAgents(Arrays.asList(responsesElement))
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAgentsPagedResponse pagedListResponse = client.listAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAgentsRequest actualRequest = ((ListAgentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAgentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAgents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAgentTest() throws Exception {
    Agent expectedResponse =
        Agent.newBuilder()
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setModelSettings(ModelSettings.newBuilder().build())
            .setInstruction("instruction301526158")
            .addAllTools(new ArrayList<String>())
            .addAllChildAgents(new ArrayList<String>())
            .addAllBeforeAgentCallbacks(new ArrayList<Callback>())
            .addAllAfterAgentCallbacks(new ArrayList<Callback>())
            .addAllBeforeModelCallbacks(new ArrayList<Callback>())
            .addAllAfterModelCallbacks(new ArrayList<Callback>())
            .addAllBeforeToolCallbacks(new ArrayList<Callback>())
            .addAllAfterToolCallbacks(new ArrayList<Callback>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllGuardrails(new ArrayList<String>())
            .setEtag("etag3123477")
            .addAllToolsets(new ArrayList<Agent.AgentToolset>())
            .setGeneratedSummary("generatedSummary-323053801")
            .addAllTransferRules(new ArrayList<TransferRule>())
            .build();
    mockAgentService.addResponse(expectedResponse);

    AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]");

    Agent actualResponse = client.getAgent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAgentRequest actualRequest = ((GetAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]");
      client.getAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAgentTest2() throws Exception {
    Agent expectedResponse =
        Agent.newBuilder()
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setModelSettings(ModelSettings.newBuilder().build())
            .setInstruction("instruction301526158")
            .addAllTools(new ArrayList<String>())
            .addAllChildAgents(new ArrayList<String>())
            .addAllBeforeAgentCallbacks(new ArrayList<Callback>())
            .addAllAfterAgentCallbacks(new ArrayList<Callback>())
            .addAllBeforeModelCallbacks(new ArrayList<Callback>())
            .addAllAfterModelCallbacks(new ArrayList<Callback>())
            .addAllBeforeToolCallbacks(new ArrayList<Callback>())
            .addAllAfterToolCallbacks(new ArrayList<Callback>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllGuardrails(new ArrayList<String>())
            .setEtag("etag3123477")
            .addAllToolsets(new ArrayList<Agent.AgentToolset>())
            .setGeneratedSummary("generatedSummary-323053801")
            .addAllTransferRules(new ArrayList<TransferRule>())
            .build();
    mockAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    Agent actualResponse = client.getAgent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAgentRequest actualRequest = ((GetAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAgentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.getAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAgentTest() throws Exception {
    Agent expectedResponse =
        Agent.newBuilder()
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setModelSettings(ModelSettings.newBuilder().build())
            .setInstruction("instruction301526158")
            .addAllTools(new ArrayList<String>())
            .addAllChildAgents(new ArrayList<String>())
            .addAllBeforeAgentCallbacks(new ArrayList<Callback>())
            .addAllAfterAgentCallbacks(new ArrayList<Callback>())
            .addAllBeforeModelCallbacks(new ArrayList<Callback>())
            .addAllAfterModelCallbacks(new ArrayList<Callback>())
            .addAllBeforeToolCallbacks(new ArrayList<Callback>())
            .addAllAfterToolCallbacks(new ArrayList<Callback>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllGuardrails(new ArrayList<String>())
            .setEtag("etag3123477")
            .addAllToolsets(new ArrayList<Agent.AgentToolset>())
            .setGeneratedSummary("generatedSummary-323053801")
            .addAllTransferRules(new ArrayList<TransferRule>())
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Agent agent = Agent.newBuilder().build();

    Agent actualResponse = client.createAgent(parent, agent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAgentRequest actualRequest = ((CreateAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(agent, actualRequest.getAgent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      Agent agent = Agent.newBuilder().build();
      client.createAgent(parent, agent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAgentTest2() throws Exception {
    Agent expectedResponse =
        Agent.newBuilder()
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setModelSettings(ModelSettings.newBuilder().build())
            .setInstruction("instruction301526158")
            .addAllTools(new ArrayList<String>())
            .addAllChildAgents(new ArrayList<String>())
            .addAllBeforeAgentCallbacks(new ArrayList<Callback>())
            .addAllAfterAgentCallbacks(new ArrayList<Callback>())
            .addAllBeforeModelCallbacks(new ArrayList<Callback>())
            .addAllAfterModelCallbacks(new ArrayList<Callback>())
            .addAllBeforeToolCallbacks(new ArrayList<Callback>())
            .addAllAfterToolCallbacks(new ArrayList<Callback>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllGuardrails(new ArrayList<String>())
            .setEtag("etag3123477")
            .addAllToolsets(new ArrayList<Agent.AgentToolset>())
            .setGeneratedSummary("generatedSummary-323053801")
            .addAllTransferRules(new ArrayList<TransferRule>())
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Agent agent = Agent.newBuilder().build();

    Agent actualResponse = client.createAgent(parent, agent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAgentRequest actualRequest = ((CreateAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(agent, actualRequest.getAgent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAgentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      Agent agent = Agent.newBuilder().build();
      client.createAgent(parent, agent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAgentTest3() throws Exception {
    Agent expectedResponse =
        Agent.newBuilder()
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setModelSettings(ModelSettings.newBuilder().build())
            .setInstruction("instruction301526158")
            .addAllTools(new ArrayList<String>())
            .addAllChildAgents(new ArrayList<String>())
            .addAllBeforeAgentCallbacks(new ArrayList<Callback>())
            .addAllAfterAgentCallbacks(new ArrayList<Callback>())
            .addAllBeforeModelCallbacks(new ArrayList<Callback>())
            .addAllAfterModelCallbacks(new ArrayList<Callback>())
            .addAllBeforeToolCallbacks(new ArrayList<Callback>())
            .addAllAfterToolCallbacks(new ArrayList<Callback>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllGuardrails(new ArrayList<String>())
            .setEtag("etag3123477")
            .addAllToolsets(new ArrayList<Agent.AgentToolset>())
            .setGeneratedSummary("generatedSummary-323053801")
            .addAllTransferRules(new ArrayList<TransferRule>())
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Agent agent = Agent.newBuilder().build();
    String agentId = "agentId-1060987136";

    Agent actualResponse = client.createAgent(parent, agent, agentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAgentRequest actualRequest = ((CreateAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(agent, actualRequest.getAgent());
    Assert.assertEquals(agentId, actualRequest.getAgentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAgentExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      Agent agent = Agent.newBuilder().build();
      String agentId = "agentId-1060987136";
      client.createAgent(parent, agent, agentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAgentTest4() throws Exception {
    Agent expectedResponse =
        Agent.newBuilder()
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setModelSettings(ModelSettings.newBuilder().build())
            .setInstruction("instruction301526158")
            .addAllTools(new ArrayList<String>())
            .addAllChildAgents(new ArrayList<String>())
            .addAllBeforeAgentCallbacks(new ArrayList<Callback>())
            .addAllAfterAgentCallbacks(new ArrayList<Callback>())
            .addAllBeforeModelCallbacks(new ArrayList<Callback>())
            .addAllAfterModelCallbacks(new ArrayList<Callback>())
            .addAllBeforeToolCallbacks(new ArrayList<Callback>())
            .addAllAfterToolCallbacks(new ArrayList<Callback>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllGuardrails(new ArrayList<String>())
            .setEtag("etag3123477")
            .addAllToolsets(new ArrayList<Agent.AgentToolset>())
            .setGeneratedSummary("generatedSummary-323053801")
            .addAllTransferRules(new ArrayList<TransferRule>())
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Agent agent = Agent.newBuilder().build();
    String agentId = "agentId-1060987136";

    Agent actualResponse = client.createAgent(parent, agent, agentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAgentRequest actualRequest = ((CreateAgentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(agent, actualRequest.getAgent());
    Assert.assertEquals(agentId, actualRequest.getAgentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAgentExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      Agent agent = Agent.newBuilder().build();
      String agentId = "agentId-1060987136";
      client.createAgent(parent, agent, agentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAgentTest() throws Exception {
    Agent expectedResponse =
        Agent.newBuilder()
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setModelSettings(ModelSettings.newBuilder().build())
            .setInstruction("instruction301526158")
            .addAllTools(new ArrayList<String>())
            .addAllChildAgents(new ArrayList<String>())
            .addAllBeforeAgentCallbacks(new ArrayList<Callback>())
            .addAllAfterAgentCallbacks(new ArrayList<Callback>())
            .addAllBeforeModelCallbacks(new ArrayList<Callback>())
            .addAllAfterModelCallbacks(new ArrayList<Callback>())
            .addAllBeforeToolCallbacks(new ArrayList<Callback>())
            .addAllAfterToolCallbacks(new ArrayList<Callback>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllGuardrails(new ArrayList<String>())
            .setEtag("etag3123477")
            .addAllToolsets(new ArrayList<Agent.AgentToolset>())
            .setGeneratedSummary("generatedSummary-323053801")
            .addAllTransferRules(new ArrayList<TransferRule>())
            .build();
    mockAgentService.addResponse(expectedResponse);

    Agent agent = Agent.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Agent actualResponse = client.updateAgent(agent, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAgentRequest actualRequest = ((UpdateAgentRequest) actualRequests.get(0));

    Assert.assertEquals(agent, actualRequest.getAgent());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      Agent agent = Agent.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAgent(agent, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAgentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAgentService.addResponse(expectedResponse);

    AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]");

    client.deleteAgent(name);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAgentRequest actualRequest = ((DeleteAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]");
      client.deleteAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAgentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAgent(name);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAgentRequest actualRequest = ((DeleteAgentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAgentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExamplesTest() throws Exception {
    Example responsesElement = Example.newBuilder().build();
    ListExamplesResponse expectedResponse =
        ListExamplesResponse.newBuilder()
            .setNextPageToken("")
            .addAllExamples(Arrays.asList(responsesElement))
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListExamplesPagedResponse pagedListResponse = client.listExamples(parent);

    List<Example> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExamplesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExamplesRequest actualRequest = ((ListExamplesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExamplesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.listExamples(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExamplesTest2() throws Exception {
    Example responsesElement = Example.newBuilder().build();
    ListExamplesResponse expectedResponse =
        ListExamplesResponse.newBuilder()
            .setNextPageToken("")
            .addAllExamples(Arrays.asList(responsesElement))
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListExamplesPagedResponse pagedListResponse = client.listExamples(parent);

    List<Example> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExamplesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExamplesRequest actualRequest = ((ListExamplesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExamplesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listExamples(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExampleTest() throws Exception {
    Example expectedResponse =
        Example.newBuilder()
            .setName(ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEntryAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .addAllMessages(new ArrayList<Message>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInvalid(true)
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    ExampleName name = ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]");

    Example actualResponse = client.getExample(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExampleRequest actualRequest = ((GetExampleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExampleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      ExampleName name = ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]");
      client.getExample(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExampleTest2() throws Exception {
    Example expectedResponse =
        Example.newBuilder()
            .setName(ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEntryAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .addAllMessages(new ArrayList<Message>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInvalid(true)
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    Example actualResponse = client.getExample(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExampleRequest actualRequest = ((GetExampleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExampleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.getExample(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExampleTest() throws Exception {
    Example expectedResponse =
        Example.newBuilder()
            .setName(ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEntryAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .addAllMessages(new ArrayList<Message>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInvalid(true)
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Example example = Example.newBuilder().build();

    Example actualResponse = client.createExample(parent, example);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExampleRequest actualRequest = ((CreateExampleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(example, actualRequest.getExample());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExampleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      Example example = Example.newBuilder().build();
      client.createExample(parent, example);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExampleTest2() throws Exception {
    Example expectedResponse =
        Example.newBuilder()
            .setName(ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEntryAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .addAllMessages(new ArrayList<Message>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInvalid(true)
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Example example = Example.newBuilder().build();

    Example actualResponse = client.createExample(parent, example);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExampleRequest actualRequest = ((CreateExampleRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(example, actualRequest.getExample());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExampleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      Example example = Example.newBuilder().build();
      client.createExample(parent, example);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExampleTest3() throws Exception {
    Example expectedResponse =
        Example.newBuilder()
            .setName(ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEntryAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .addAllMessages(new ArrayList<Message>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInvalid(true)
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Example example = Example.newBuilder().build();
    String exampleId = "exampleId-64591835";

    Example actualResponse = client.createExample(parent, example, exampleId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExampleRequest actualRequest = ((CreateExampleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(example, actualRequest.getExample());
    Assert.assertEquals(exampleId, actualRequest.getExampleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExampleExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      Example example = Example.newBuilder().build();
      String exampleId = "exampleId-64591835";
      client.createExample(parent, example, exampleId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExampleTest4() throws Exception {
    Example expectedResponse =
        Example.newBuilder()
            .setName(ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEntryAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .addAllMessages(new ArrayList<Message>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInvalid(true)
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Example example = Example.newBuilder().build();
    String exampleId = "exampleId-64591835";

    Example actualResponse = client.createExample(parent, example, exampleId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExampleRequest actualRequest = ((CreateExampleRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(example, actualRequest.getExample());
    Assert.assertEquals(exampleId, actualRequest.getExampleId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExampleExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      Example example = Example.newBuilder().build();
      String exampleId = "exampleId-64591835";
      client.createExample(parent, example, exampleId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateExampleTest() throws Exception {
    Example expectedResponse =
        Example.newBuilder()
            .setName(ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEntryAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .addAllMessages(new ArrayList<Message>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setInvalid(true)
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    Example example = Example.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Example actualResponse = client.updateExample(example, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateExampleRequest actualRequest = ((UpdateExampleRequest) actualRequests.get(0));

    Assert.assertEquals(example, actualRequest.getExample());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateExampleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      Example example = Example.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateExample(example, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteExampleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAgentService.addResponse(expectedResponse);

    ExampleName name = ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]");

    client.deleteExample(name);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExampleRequest actualRequest = ((DeleteExampleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExampleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      ExampleName name = ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]");
      client.deleteExample(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteExampleTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteExample(name);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExampleRequest actualRequest = ((DeleteExampleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExampleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteExample(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listToolsTest() throws Exception {
    Tool responsesElement = Tool.newBuilder().build();
    ListToolsResponse expectedResponse =
        ListToolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTools(Arrays.asList(responsesElement))
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListToolsPagedResponse pagedListResponse = client.listTools(parent);

    List<Tool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getToolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListToolsRequest actualRequest = ((ListToolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listToolsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.listTools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listToolsTest2() throws Exception {
    Tool responsesElement = Tool.newBuilder().build();
    ListToolsResponse expectedResponse =
        ListToolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTools(Arrays.asList(responsesElement))
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListToolsPagedResponse pagedListResponse = client.listTools(parent);

    List<Tool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getToolsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListToolsRequest actualRequest = ((ListToolsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listToolsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getToolTest() throws Exception {
    Tool expectedResponse =
        Tool.newBuilder()
            .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]").toString())
            .setDisplayName("displayName1714148973")
            .setExecutionType(ExecutionType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setGeneratedSummary("generatedSummary-323053801")
            .setToolFakeConfig(ToolFakeConfig.newBuilder().build())
            .build();
    mockAgentService.addResponse(expectedResponse);

    ToolName name = ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]");

    Tool actualResponse = client.getTool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetToolRequest actualRequest = ((GetToolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getToolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      ToolName name = ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]");
      client.getTool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getToolTest2() throws Exception {
    Tool expectedResponse =
        Tool.newBuilder()
            .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]").toString())
            .setDisplayName("displayName1714148973")
            .setExecutionType(ExecutionType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setGeneratedSummary("generatedSummary-323053801")
            .setToolFakeConfig(ToolFakeConfig.newBuilder().build())
            .build();
    mockAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    Tool actualResponse = client.getTool(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetToolRequest actualRequest = ((GetToolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getToolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.getTool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConversationsTest() throws Exception {
    Conversation responsesElement = Conversation.newBuilder().build();
    ListConversationsResponse expectedResponse =
        ListConversationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversations(Arrays.asList(responsesElement))
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListConversationsPagedResponse pagedListResponse = client.listConversations(parent);

    List<Conversation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConversationsRequest actualRequest = ((ListConversationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConversationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.listConversations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConversationsTest2() throws Exception {
    Conversation responsesElement = Conversation.newBuilder().build();
    ListConversationsResponse expectedResponse =
        ListConversationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversations(Arrays.asList(responsesElement))
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConversationsPagedResponse pagedListResponse = client.listConversations(parent);

    List<Conversation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConversationsRequest actualRequest = ((ListConversationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConversationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConversations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConversationTest() throws Exception {
    Conversation expectedResponse =
        Conversation.newBuilder()
            .setName(
                ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]")
                    .toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .addAllTurns(new ArrayList<Conversation.Turn>())
            .setTurnCount(428155597)
            .addAllInputTypes(new ArrayList<Conversation.InputType>())
            .setEntryAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .setDeployment(
                DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]").toString())
            .setAppVersion(
                AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setLanguageCode("languageCode-2092349083")
            .addAllMessages(new ArrayList<Message>())
            .build();
    mockAgentService.addResponse(expectedResponse);

    ConversationName name =
        ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]");

    Conversation actualResponse = client.getConversation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConversationRequest actualRequest = ((GetConversationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConversationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      ConversationName name =
          ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]");
      client.getConversation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConversationTest2() throws Exception {
    Conversation expectedResponse =
        Conversation.newBuilder()
            .setName(
                ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]")
                    .toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .addAllTurns(new ArrayList<Conversation.Turn>())
            .setTurnCount(428155597)
            .addAllInputTypes(new ArrayList<Conversation.InputType>())
            .setEntryAgent(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
            .setDeployment(
                DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]").toString())
            .setAppVersion(
                AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setLanguageCode("languageCode-2092349083")
            .addAllMessages(new ArrayList<Message>())
            .build();
    mockAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    Conversation actualResponse = client.getConversation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConversationRequest actualRequest = ((GetConversationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConversationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.getConversation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConversationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAgentService.addResponse(expectedResponse);

    ConversationName name =
        ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]");

    client.deleteConversation(name);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConversationRequest actualRequest = ((DeleteConversationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConversationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      ConversationName name =
          ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]");
      client.deleteConversation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConversationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteConversation(name);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConversationRequest actualRequest = ((DeleteConversationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConversationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteConversation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeleteConversationsTest() throws Exception {
    BatchDeleteConversationsResponse expectedResponse =
        BatchDeleteConversationsResponse.newBuilder()
            .addAllDeletedConversations(new ArrayList<String>())
            .addAllFailedConversations(new ArrayList<String>())
            .addAllErrorMessages(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchDeleteConversationsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentService.addResponse(resultOperation);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    BatchDeleteConversationsResponse actualResponse =
        client.batchDeleteConversationsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteConversationsRequest actualRequest =
        ((BatchDeleteConversationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchDeleteConversationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.batchDeleteConversationsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchDeleteConversationsTest2() throws Exception {
    BatchDeleteConversationsResponse expectedResponse =
        BatchDeleteConversationsResponse.newBuilder()
            .addAllDeletedConversations(new ArrayList<String>())
            .addAllFailedConversations(new ArrayList<String>())
            .addAllErrorMessages(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchDeleteConversationsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentService.addResponse(resultOperation);

    String parent = "parent-995424086";

    BatchDeleteConversationsResponse actualResponse =
        client.batchDeleteConversationsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteConversationsRequest actualRequest =
        ((BatchDeleteConversationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchDeleteConversationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.batchDeleteConversationsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createToolTest() throws Exception {
    Tool expectedResponse =
        Tool.newBuilder()
            .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]").toString())
            .setDisplayName("displayName1714148973")
            .setExecutionType(ExecutionType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setGeneratedSummary("generatedSummary-323053801")
            .setToolFakeConfig(ToolFakeConfig.newBuilder().build())
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Tool tool = Tool.newBuilder().build();

    Tool actualResponse = client.createTool(parent, tool);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateToolRequest actualRequest = ((CreateToolRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tool, actualRequest.getTool());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createToolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      Tool tool = Tool.newBuilder().build();
      client.createTool(parent, tool);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createToolTest2() throws Exception {
    Tool expectedResponse =
        Tool.newBuilder()
            .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]").toString())
            .setDisplayName("displayName1714148973")
            .setExecutionType(ExecutionType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setGeneratedSummary("generatedSummary-323053801")
            .setToolFakeConfig(ToolFakeConfig.newBuilder().build())
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Tool tool = Tool.newBuilder().build();

    Tool actualResponse = client.createTool(parent, tool);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateToolRequest actualRequest = ((CreateToolRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tool, actualRequest.getTool());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createToolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      Tool tool = Tool.newBuilder().build();
      client.createTool(parent, tool);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createToolTest3() throws Exception {
    Tool expectedResponse =
        Tool.newBuilder()
            .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]").toString())
            .setDisplayName("displayName1714148973")
            .setExecutionType(ExecutionType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setGeneratedSummary("generatedSummary-323053801")
            .setToolFakeConfig(ToolFakeConfig.newBuilder().build())
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Tool tool = Tool.newBuilder().build();
    String toolId = "toolId-868061997";

    Tool actualResponse = client.createTool(parent, tool, toolId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateToolRequest actualRequest = ((CreateToolRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(tool, actualRequest.getTool());
    Assert.assertEquals(toolId, actualRequest.getToolId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createToolExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      Tool tool = Tool.newBuilder().build();
      String toolId = "toolId-868061997";
      client.createTool(parent, tool, toolId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createToolTest4() throws Exception {
    Tool expectedResponse =
        Tool.newBuilder()
            .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]").toString())
            .setDisplayName("displayName1714148973")
            .setExecutionType(ExecutionType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setGeneratedSummary("generatedSummary-323053801")
            .setToolFakeConfig(ToolFakeConfig.newBuilder().build())
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Tool tool = Tool.newBuilder().build();
    String toolId = "toolId-868061997";

    Tool actualResponse = client.createTool(parent, tool, toolId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateToolRequest actualRequest = ((CreateToolRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(tool, actualRequest.getTool());
    Assert.assertEquals(toolId, actualRequest.getToolId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createToolExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      Tool tool = Tool.newBuilder().build();
      String toolId = "toolId-868061997";
      client.createTool(parent, tool, toolId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateToolTest() throws Exception {
    Tool expectedResponse =
        Tool.newBuilder()
            .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]").toString())
            .setDisplayName("displayName1714148973")
            .setExecutionType(ExecutionType.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setGeneratedSummary("generatedSummary-323053801")
            .setToolFakeConfig(ToolFakeConfig.newBuilder().build())
            .build();
    mockAgentService.addResponse(expectedResponse);

    Tool tool = Tool.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Tool actualResponse = client.updateTool(tool, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateToolRequest actualRequest = ((UpdateToolRequest) actualRequests.get(0));

    Assert.assertEquals(tool, actualRequest.getTool());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateToolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      Tool tool = Tool.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTool(tool, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteToolTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAgentService.addResponse(expectedResponse);

    ToolName name = ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]");

    client.deleteTool(name);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteToolRequest actualRequest = ((DeleteToolRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteToolExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      ToolName name = ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]");
      client.deleteTool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteToolTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteTool(name);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteToolRequest actualRequest = ((DeleteToolRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteToolExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGuardrailsTest() throws Exception {
    Guardrail responsesElement = Guardrail.newBuilder().build();
    ListGuardrailsResponse expectedResponse =
        ListGuardrailsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGuardrails(Arrays.asList(responsesElement))
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListGuardrailsPagedResponse pagedListResponse = client.listGuardrails(parent);

    List<Guardrail> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGuardrailsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGuardrailsRequest actualRequest = ((ListGuardrailsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGuardrailsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.listGuardrails(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGuardrailsTest2() throws Exception {
    Guardrail responsesElement = Guardrail.newBuilder().build();
    ListGuardrailsResponse expectedResponse =
        ListGuardrailsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGuardrails(Arrays.asList(responsesElement))
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGuardrailsPagedResponse pagedListResponse = client.listGuardrails(parent);

    List<Guardrail> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGuardrailsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGuardrailsRequest actualRequest = ((ListGuardrailsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGuardrailsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGuardrails(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGuardrailTest() throws Exception {
    Guardrail expectedResponse =
        Guardrail.newBuilder()
            .setName(GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEnabled(true)
            .setAction(TriggerAction.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    GuardrailName name = GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]");

    Guardrail actualResponse = client.getGuardrail(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGuardrailRequest actualRequest = ((GetGuardrailRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGuardrailExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      GuardrailName name = GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]");
      client.getGuardrail(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGuardrailTest2() throws Exception {
    Guardrail expectedResponse =
        Guardrail.newBuilder()
            .setName(GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEnabled(true)
            .setAction(TriggerAction.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    Guardrail actualResponse = client.getGuardrail(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGuardrailRequest actualRequest = ((GetGuardrailRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGuardrailExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.getGuardrail(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGuardrailTest() throws Exception {
    Guardrail expectedResponse =
        Guardrail.newBuilder()
            .setName(GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEnabled(true)
            .setAction(TriggerAction.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Guardrail guardrail = Guardrail.newBuilder().build();

    Guardrail actualResponse = client.createGuardrail(parent, guardrail);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGuardrailRequest actualRequest = ((CreateGuardrailRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(guardrail, actualRequest.getGuardrail());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGuardrailExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      Guardrail guardrail = Guardrail.newBuilder().build();
      client.createGuardrail(parent, guardrail);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGuardrailTest2() throws Exception {
    Guardrail expectedResponse =
        Guardrail.newBuilder()
            .setName(GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEnabled(true)
            .setAction(TriggerAction.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Guardrail guardrail = Guardrail.newBuilder().build();

    Guardrail actualResponse = client.createGuardrail(parent, guardrail);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGuardrailRequest actualRequest = ((CreateGuardrailRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(guardrail, actualRequest.getGuardrail());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGuardrailExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      Guardrail guardrail = Guardrail.newBuilder().build();
      client.createGuardrail(parent, guardrail);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGuardrailTest3() throws Exception {
    Guardrail expectedResponse =
        Guardrail.newBuilder()
            .setName(GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEnabled(true)
            .setAction(TriggerAction.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Guardrail guardrail = Guardrail.newBuilder().build();
    String guardrailId = "guardrailId1875412786";

    Guardrail actualResponse = client.createGuardrail(parent, guardrail, guardrailId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGuardrailRequest actualRequest = ((CreateGuardrailRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(guardrail, actualRequest.getGuardrail());
    Assert.assertEquals(guardrailId, actualRequest.getGuardrailId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGuardrailExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      Guardrail guardrail = Guardrail.newBuilder().build();
      String guardrailId = "guardrailId1875412786";
      client.createGuardrail(parent, guardrail, guardrailId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGuardrailTest4() throws Exception {
    Guardrail expectedResponse =
        Guardrail.newBuilder()
            .setName(GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEnabled(true)
            .setAction(TriggerAction.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Guardrail guardrail = Guardrail.newBuilder().build();
    String guardrailId = "guardrailId1875412786";

    Guardrail actualResponse = client.createGuardrail(parent, guardrail, guardrailId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGuardrailRequest actualRequest = ((CreateGuardrailRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(guardrail, actualRequest.getGuardrail());
    Assert.assertEquals(guardrailId, actualRequest.getGuardrailId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGuardrailExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      Guardrail guardrail = Guardrail.newBuilder().build();
      String guardrailId = "guardrailId1875412786";
      client.createGuardrail(parent, guardrail, guardrailId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateGuardrailTest() throws Exception {
    Guardrail expectedResponse =
        Guardrail.newBuilder()
            .setName(GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setEnabled(true)
            .setAction(TriggerAction.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    Guardrail guardrail = Guardrail.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Guardrail actualResponse = client.updateGuardrail(guardrail, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGuardrailRequest actualRequest = ((UpdateGuardrailRequest) actualRequests.get(0));

    Assert.assertEquals(guardrail, actualRequest.getGuardrail());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGuardrailExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      Guardrail guardrail = Guardrail.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGuardrail(guardrail, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGuardrailTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAgentService.addResponse(expectedResponse);

    GuardrailName name = GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]");

    client.deleteGuardrail(name);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGuardrailRequest actualRequest = ((DeleteGuardrailRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGuardrailExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      GuardrailName name = GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]");
      client.deleteGuardrail(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGuardrailTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteGuardrail(name);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGuardrailRequest actualRequest = ((DeleteGuardrailRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGuardrailExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteGuardrail(name);
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
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListDeploymentsPagedResponse pagedListResponse = client.listDeployments(parent);

    List<Deployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
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
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
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
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDeploymentsPagedResponse pagedListResponse = client.listDeployments(parent);

    List<Deployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
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
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(
                DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setAppVersion(
                AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setChannelProfile(ChannelProfile.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]");

    Deployment actualResponse = client.getDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
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
    mockAgentService.addException(exception);

    try {
      DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]");
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
            .setName(
                DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setAppVersion(
                AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setChannelProfile(ChannelProfile.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    Deployment actualResponse = client.getDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
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
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.getDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(
                DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setAppVersion(
                AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setChannelProfile(ChannelProfile.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Deployment deployment = Deployment.newBuilder().build();

    Deployment actualResponse = client.createDeployment(parent, deployment);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeploymentRequest actualRequest = ((CreateDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(deployment, actualRequest.getDeployment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      Deployment deployment = Deployment.newBuilder().build();
      client.createDeployment(parent, deployment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeploymentTest2() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(
                DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setAppVersion(
                AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setChannelProfile(ChannelProfile.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Deployment deployment = Deployment.newBuilder().build();

    Deployment actualResponse = client.createDeployment(parent, deployment);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeploymentRequest actualRequest = ((CreateDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(deployment, actualRequest.getDeployment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      Deployment deployment = Deployment.newBuilder().build();
      client.createDeployment(parent, deployment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeploymentTest3() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(
                DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setAppVersion(
                AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setChannelProfile(ChannelProfile.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Deployment deployment = Deployment.newBuilder().build();
    String deploymentId = "deploymentId-136894784";

    Deployment actualResponse = client.createDeployment(parent, deployment, deploymentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
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
  public void createDeploymentExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      Deployment deployment = Deployment.newBuilder().build();
      String deploymentId = "deploymentId-136894784";
      client.createDeployment(parent, deployment, deploymentId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeploymentTest4() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(
                DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setAppVersion(
                AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setChannelProfile(ChannelProfile.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Deployment deployment = Deployment.newBuilder().build();
    String deploymentId = "deploymentId-136894784";

    Deployment actualResponse = client.createDeployment(parent, deployment, deploymentId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
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
  public void createDeploymentExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

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
  public void updateDeploymentTest() throws Exception {
    Deployment expectedResponse =
        Deployment.newBuilder()
            .setName(
                DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setAppVersion(
                AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setChannelProfile(ChannelProfile.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    Deployment deployment = Deployment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Deployment actualResponse = client.updateDeployment(deployment, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
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
    mockAgentService.addException(exception);

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
    mockAgentService.addResponse(expectedResponse);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]");

    client.deleteDeployment(name);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
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
    mockAgentService.addException(exception);

    try {
      DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]");
      client.deleteDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDeploymentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDeployment(name);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
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
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listToolsetsTest() throws Exception {
    Toolset responsesElement = Toolset.newBuilder().build();
    ListToolsetsResponse expectedResponse =
        ListToolsetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllToolsets(Arrays.asList(responsesElement))
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListToolsetsPagedResponse pagedListResponse = client.listToolsets(parent);

    List<Toolset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getToolsetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListToolsetsRequest actualRequest = ((ListToolsetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listToolsetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.listToolsets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listToolsetsTest2() throws Exception {
    Toolset responsesElement = Toolset.newBuilder().build();
    ListToolsetsResponse expectedResponse =
        ListToolsetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllToolsets(Arrays.asList(responsesElement))
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListToolsetsPagedResponse pagedListResponse = client.listToolsets(parent);

    List<Toolset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getToolsetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListToolsetsRequest actualRequest = ((ListToolsetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listToolsetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listToolsets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getToolsetTest() throws Exception {
    Toolset expectedResponse =
        Toolset.newBuilder()
            .setName(ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setExecutionType(ExecutionType.forNumber(0))
            .setToolFakeConfig(ToolFakeConfig.newBuilder().build())
            .build();
    mockAgentService.addResponse(expectedResponse);

    ToolsetName name = ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]");

    Toolset actualResponse = client.getToolset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetToolsetRequest actualRequest = ((GetToolsetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getToolsetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      ToolsetName name = ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]");
      client.getToolset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getToolsetTest2() throws Exception {
    Toolset expectedResponse =
        Toolset.newBuilder()
            .setName(ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setExecutionType(ExecutionType.forNumber(0))
            .setToolFakeConfig(ToolFakeConfig.newBuilder().build())
            .build();
    mockAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    Toolset actualResponse = client.getToolset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetToolsetRequest actualRequest = ((GetToolsetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getToolsetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.getToolset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createToolsetTest() throws Exception {
    Toolset expectedResponse =
        Toolset.newBuilder()
            .setName(ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setExecutionType(ExecutionType.forNumber(0))
            .setToolFakeConfig(ToolFakeConfig.newBuilder().build())
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Toolset toolset = Toolset.newBuilder().build();

    Toolset actualResponse = client.createToolset(parent, toolset);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateToolsetRequest actualRequest = ((CreateToolsetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(toolset, actualRequest.getToolset());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createToolsetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      Toolset toolset = Toolset.newBuilder().build();
      client.createToolset(parent, toolset);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createToolsetTest2() throws Exception {
    Toolset expectedResponse =
        Toolset.newBuilder()
            .setName(ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setExecutionType(ExecutionType.forNumber(0))
            .setToolFakeConfig(ToolFakeConfig.newBuilder().build())
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Toolset toolset = Toolset.newBuilder().build();

    Toolset actualResponse = client.createToolset(parent, toolset);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateToolsetRequest actualRequest = ((CreateToolsetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(toolset, actualRequest.getToolset());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createToolsetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      Toolset toolset = Toolset.newBuilder().build();
      client.createToolset(parent, toolset);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createToolsetTest3() throws Exception {
    Toolset expectedResponse =
        Toolset.newBuilder()
            .setName(ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setExecutionType(ExecutionType.forNumber(0))
            .setToolFakeConfig(ToolFakeConfig.newBuilder().build())
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Toolset toolset = Toolset.newBuilder().build();
    String toolsetId = "toolsetId-397931899";

    Toolset actualResponse = client.createToolset(parent, toolset, toolsetId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateToolsetRequest actualRequest = ((CreateToolsetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(toolset, actualRequest.getToolset());
    Assert.assertEquals(toolsetId, actualRequest.getToolsetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createToolsetExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      Toolset toolset = Toolset.newBuilder().build();
      String toolsetId = "toolsetId-397931899";
      client.createToolset(parent, toolset, toolsetId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createToolsetTest4() throws Exception {
    Toolset expectedResponse =
        Toolset.newBuilder()
            .setName(ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setExecutionType(ExecutionType.forNumber(0))
            .setToolFakeConfig(ToolFakeConfig.newBuilder().build())
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Toolset toolset = Toolset.newBuilder().build();
    String toolsetId = "toolsetId-397931899";

    Toolset actualResponse = client.createToolset(parent, toolset, toolsetId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateToolsetRequest actualRequest = ((CreateToolsetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(toolset, actualRequest.getToolset());
    Assert.assertEquals(toolsetId, actualRequest.getToolsetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createToolsetExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      Toolset toolset = Toolset.newBuilder().build();
      String toolsetId = "toolsetId-397931899";
      client.createToolset(parent, toolset, toolsetId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateToolsetTest() throws Exception {
    Toolset expectedResponse =
        Toolset.newBuilder()
            .setName(ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setExecutionType(ExecutionType.forNumber(0))
            .setToolFakeConfig(ToolFakeConfig.newBuilder().build())
            .build();
    mockAgentService.addResponse(expectedResponse);

    Toolset toolset = Toolset.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Toolset actualResponse = client.updateToolset(toolset, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateToolsetRequest actualRequest = ((UpdateToolsetRequest) actualRequests.get(0));

    Assert.assertEquals(toolset, actualRequest.getToolset());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateToolsetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      Toolset toolset = Toolset.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateToolset(toolset, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteToolsetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAgentService.addResponse(expectedResponse);

    ToolsetName name = ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]");

    client.deleteToolset(name);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteToolsetRequest actualRequest = ((DeleteToolsetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteToolsetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      ToolsetName name = ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]");
      client.deleteToolset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteToolsetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteToolset(name);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteToolsetRequest actualRequest = ((DeleteToolsetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteToolsetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteToolset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAppVersionsTest() throws Exception {
    AppVersion responsesElement = AppVersion.newBuilder().build();
    ListAppVersionsResponse expectedResponse =
        ListAppVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAppVersions(Arrays.asList(responsesElement))
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListAppVersionsPagedResponse pagedListResponse = client.listAppVersions(parent);

    List<AppVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAppVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAppVersionsRequest actualRequest = ((ListAppVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAppVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.listAppVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAppVersionsTest2() throws Exception {
    AppVersion responsesElement = AppVersion.newBuilder().build();
    ListAppVersionsResponse expectedResponse =
        ListAppVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAppVersions(Arrays.asList(responsesElement))
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAppVersionsPagedResponse pagedListResponse = client.listAppVersions(parent);

    List<AppVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAppVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAppVersionsRequest actualRequest = ((ListAppVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAppVersionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAppVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAppVersionTest() throws Exception {
    AppVersion expectedResponse =
        AppVersion.newBuilder()
            .setName(AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreator("creator1028554796")
            .setCreateTime(Timestamp.newBuilder().build())
            .setSnapshot(AppSnapshot.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppVersionName name = AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]");

    AppVersion actualResponse = client.getAppVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAppVersionRequest actualRequest = ((GetAppVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAppVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppVersionName name = AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]");
      client.getAppVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAppVersionTest2() throws Exception {
    AppVersion expectedResponse =
        AppVersion.newBuilder()
            .setName(AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreator("creator1028554796")
            .setCreateTime(Timestamp.newBuilder().build())
            .setSnapshot(AppSnapshot.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    AppVersion actualResponse = client.getAppVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAppVersionRequest actualRequest = ((GetAppVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAppVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.getAppVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAppVersionTest() throws Exception {
    AppVersion expectedResponse =
        AppVersion.newBuilder()
            .setName(AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreator("creator1028554796")
            .setCreateTime(Timestamp.newBuilder().build())
            .setSnapshot(AppSnapshot.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    AppVersion appVersion = AppVersion.newBuilder().build();

    AppVersion actualResponse = client.createAppVersion(parent, appVersion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAppVersionRequest actualRequest = ((CreateAppVersionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(appVersion, actualRequest.getAppVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAppVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      AppVersion appVersion = AppVersion.newBuilder().build();
      client.createAppVersion(parent, appVersion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAppVersionTest2() throws Exception {
    AppVersion expectedResponse =
        AppVersion.newBuilder()
            .setName(AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreator("creator1028554796")
            .setCreateTime(Timestamp.newBuilder().build())
            .setSnapshot(AppSnapshot.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    AppVersion appVersion = AppVersion.newBuilder().build();

    AppVersion actualResponse = client.createAppVersion(parent, appVersion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAppVersionRequest actualRequest = ((CreateAppVersionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(appVersion, actualRequest.getAppVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAppVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      AppVersion appVersion = AppVersion.newBuilder().build();
      client.createAppVersion(parent, appVersion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAppVersionTest3() throws Exception {
    AppVersion expectedResponse =
        AppVersion.newBuilder()
            .setName(AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreator("creator1028554796")
            .setCreateTime(Timestamp.newBuilder().build())
            .setSnapshot(AppSnapshot.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    AppVersion appVersion = AppVersion.newBuilder().build();
    String appVersionId = "appVersionId303221490";

    AppVersion actualResponse = client.createAppVersion(parent, appVersion, appVersionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAppVersionRequest actualRequest = ((CreateAppVersionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(appVersion, actualRequest.getAppVersion());
    Assert.assertEquals(appVersionId, actualRequest.getAppVersionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAppVersionExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      AppVersion appVersion = AppVersion.newBuilder().build();
      String appVersionId = "appVersionId303221490";
      client.createAppVersion(parent, appVersion, appVersionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAppVersionTest4() throws Exception {
    AppVersion expectedResponse =
        AppVersion.newBuilder()
            .setName(AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreator("creator1028554796")
            .setCreateTime(Timestamp.newBuilder().build())
            .setSnapshot(AppSnapshot.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    AppVersion appVersion = AppVersion.newBuilder().build();
    String appVersionId = "appVersionId303221490";

    AppVersion actualResponse = client.createAppVersion(parent, appVersion, appVersionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAppVersionRequest actualRequest = ((CreateAppVersionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(appVersion, actualRequest.getAppVersion());
    Assert.assertEquals(appVersionId, actualRequest.getAppVersionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAppVersionExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      AppVersion appVersion = AppVersion.newBuilder().build();
      String appVersionId = "appVersionId303221490";
      client.createAppVersion(parent, appVersion, appVersionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAppVersionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAgentService.addResponse(expectedResponse);

    AppVersionName name = AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]");

    client.deleteAppVersion(name);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAppVersionRequest actualRequest = ((DeleteAppVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAppVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppVersionName name = AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]");
      client.deleteAppVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAppVersionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAppVersion(name);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAppVersionRequest actualRequest = ((DeleteAppVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAppVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAppVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void restoreAppVersionTest() throws Exception {
    RestoreAppVersionResponse expectedResponse = RestoreAppVersionResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreAppVersionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentService.addResponse(resultOperation);

    AppVersionName name = AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]");

    RestoreAppVersionResponse actualResponse = client.restoreAppVersionAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreAppVersionRequest actualRequest = ((RestoreAppVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restoreAppVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppVersionName name = AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]");
      client.restoreAppVersionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void restoreAppVersionTest2() throws Exception {
    RestoreAppVersionResponse expectedResponse = RestoreAppVersionResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreAppVersionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockAgentService.addResponse(resultOperation);

    String name = "name3373707";

    RestoreAppVersionResponse actualResponse = client.restoreAppVersionAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreAppVersionRequest actualRequest = ((RestoreAppVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restoreAppVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.restoreAppVersionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listChangelogsTest() throws Exception {
    Changelog responsesElement = Changelog.newBuilder().build();
    ListChangelogsResponse expectedResponse =
        ListChangelogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllChangelogs(Arrays.asList(responsesElement))
            .build();
    mockAgentService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListChangelogsPagedResponse pagedListResponse = client.listChangelogs(parent);

    List<Changelog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChangelogsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListChangelogsRequest actualRequest = ((ListChangelogsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listChangelogsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.listChangelogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listChangelogsTest2() throws Exception {
    Changelog responsesElement = Changelog.newBuilder().build();
    ListChangelogsResponse expectedResponse =
        ListChangelogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllChangelogs(Arrays.asList(responsesElement))
            .build();
    mockAgentService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListChangelogsPagedResponse pagedListResponse = client.listChangelogs(parent);

    List<Changelog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChangelogsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListChangelogsRequest actualRequest = ((ListChangelogsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listChangelogsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listChangelogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getChangelogTest() throws Exception {
    Changelog expectedResponse =
        Changelog.newBuilder()
            .setName(ChangelogName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CHANGELOG]").toString())
            .setAuthor("author-1406328437")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setResource("resource-341064690")
            .setResourceType("resourceType-384364440")
            .setAction("action-1422950858")
            .setOriginalResource(Struct.newBuilder().build())
            .setNewResource(Struct.newBuilder().build())
            .addAllDependentResources(new ArrayList<Struct>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSequenceNumber(-1309190777)
            .build();
    mockAgentService.addResponse(expectedResponse);

    ChangelogName name = ChangelogName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CHANGELOG]");

    Changelog actualResponse = client.getChangelog(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetChangelogRequest actualRequest = ((GetChangelogRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getChangelogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      ChangelogName name = ChangelogName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CHANGELOG]");
      client.getChangelog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getChangelogTest2() throws Exception {
    Changelog expectedResponse =
        Changelog.newBuilder()
            .setName(ChangelogName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CHANGELOG]").toString())
            .setAuthor("author-1406328437")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setResource("resource-341064690")
            .setResourceType("resourceType-384364440")
            .setAction("action-1422950858")
            .setOriginalResource(Struct.newBuilder().build())
            .setNewResource(Struct.newBuilder().build())
            .addAllDependentResources(new ArrayList<Struct>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSequenceNumber(-1309190777)
            .build();
    mockAgentService.addResponse(expectedResponse);

    String name = "name3373707";

    Changelog actualResponse = client.getChangelog(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgentService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetChangelogRequest actualRequest = ((GetChangelogRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getChangelogExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgentService.addException(exception);

    try {
      String name = "name3373707";
      client.getChangelog(name);
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
