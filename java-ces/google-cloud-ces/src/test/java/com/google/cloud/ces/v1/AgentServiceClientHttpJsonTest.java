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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.ces.v1.stub.HttpJsonAgentServiceStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Struct;
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
public class AgentServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AgentServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAgentServiceStub.getMethodDescriptors(),
            AgentServiceSettings.getDefaultEndpoint());
    AgentServiceSettings settings =
        AgentServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AgentServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AgentServiceClient.create(settings);
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
  public void listAppsTest() throws Exception {
    App responsesElement = App.newBuilder().build();
    ListAppsResponse expectedResponse =
        ListAppsResponse.newBuilder()
            .setNextPageToken("")
            .addAllApps(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAppsPagedResponse pagedListResponse = client.listApps(parent);

    List<App> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAppsList().get(0), resources.get(0));

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
  public void listAppsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAppsPagedResponse pagedListResponse = client.listApps(parent);

    List<App> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAppsList().get(0), resources.get(0));

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
  public void listAppsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    AppName name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    App actualResponse = client.getApp(name);
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
  public void getAppExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5070/locations/location-5070/apps/app-5070";

    App actualResponse = client.getApp(name);
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
  public void getAppExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5070/locations/location-5070/apps/app-5070";
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    App app = App.newBuilder().build();

    App actualResponse = client.createAppAsync(parent, app).get();
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
  public void createAppExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      App app = App.newBuilder().build();
      client.createAppAsync(parent, app).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    App app = App.newBuilder().build();

    App actualResponse = client.createAppAsync(parent, app).get();
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
  public void createAppExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      App app = App.newBuilder().build();
      client.createAppAsync(parent, app).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    App app = App.newBuilder().build();
    String appId = "appId93028124";

    App actualResponse = client.createAppAsync(parent, app, appId).get();
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
  public void createAppExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      App app = App.newBuilder().build();
      String appId = "appId93028124";
      client.createAppAsync(parent, app, appId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    App app = App.newBuilder().build();
    String appId = "appId93028124";

    App actualResponse = client.createAppAsync(parent, app, appId).get();
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
  public void createAppExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      App app = App.newBuilder().build();
      String appId = "appId93028124";
      client.createAppAsync(parent, app, appId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    App app =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    App actualResponse = client.updateApp(app, updateMask);
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
  public void updateAppExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      App app =
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
    mockService.addResponse(resultOperation);

    AppName name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    client.deleteAppAsync(name).get();

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
  public void deleteAppExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AppName name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.deleteAppAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-5070/locations/location-5070/apps/app-5070";

    client.deleteAppAsync(name).get();

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
  public void deleteAppExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5070/locations/location-5070/apps/app-5070";
      client.deleteAppAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    AppName name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ExportAppResponse actualResponse = client.exportAppAsync(name).get();
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
  public void exportAppExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AppName name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.exportAppAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-5070/locations/location-5070/apps/app-5070";

    ExportAppResponse actualResponse = client.exportAppAsync(name).get();
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
  public void exportAppExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5070/locations/location-5070/apps/app-5070";
      client.exportAppAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String displayName = "displayName1714148973";
    String appId = "appId93028124";

    ImportAppResponse actualResponse = client.importAppAsync(parent, displayName, appId).get();
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
  public void importAppExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String displayName = "displayName1714148973";
      String appId = "appId93028124";
      client.importAppAsync(parent, displayName, appId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    String displayName = "displayName1714148973";
    String appId = "appId93028124";

    ImportAppResponse actualResponse = client.importAppAsync(parent, displayName, appId).get();
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
  public void importAppExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      String displayName = "displayName1714148973";
      String appId = "appId93028124";
      client.importAppAsync(parent, displayName, appId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListAgentsPagedResponse pagedListResponse = client.listAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

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
  public void listAgentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";

    ListAgentsPagedResponse pagedListResponse = client.listAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

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
  public void listAgentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]");

    Agent actualResponse = client.getAgent(name);
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
  public void getAgentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5446/locations/location-5446/apps/app-5446/agents/agent-5446";

    Agent actualResponse = client.getAgent(name);
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
  public void getAgentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5446/locations/location-5446/apps/app-5446/agents/agent-5446";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Agent agent = Agent.newBuilder().build();

    Agent actualResponse = client.createAgent(parent, agent);
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
  public void createAgentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    Agent agent = Agent.newBuilder().build();

    Agent actualResponse = client.createAgent(parent, agent);
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
  public void createAgentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Agent agent = Agent.newBuilder().build();
    String agentId = "agentId-1060987136";

    Agent actualResponse = client.createAgent(parent, agent, agentId);
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
  public void createAgentExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    Agent agent = Agent.newBuilder().build();
    String agentId = "agentId-1060987136";

    Agent actualResponse = client.createAgent(parent, agent, agentId);
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
  public void createAgentExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    Agent agent =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Agent actualResponse = client.updateAgent(agent, updateMask);
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
  public void updateAgentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Agent agent =
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
    mockService.addResponse(expectedResponse);

    AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]");

    client.deleteAgent(name);

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
  public void deleteAgentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5446/locations/location-5446/apps/app-5446/agents/agent-5446";

    client.deleteAgent(name);

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
  public void deleteAgentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5446/locations/location-5446/apps/app-5446/agents/agent-5446";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListExamplesPagedResponse pagedListResponse = client.listExamples(parent);

    List<Example> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExamplesList().get(0), resources.get(0));

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
  public void listExamplesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";

    ListExamplesPagedResponse pagedListResponse = client.listExamples(parent);

    List<Example> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExamplesList().get(0), resources.get(0));

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
  public void listExamplesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    ExampleName name = ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]");

    Example actualResponse = client.getExample(name);
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
  public void getExampleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-991/locations/location-991/apps/app-991/examples/example-991";

    Example actualResponse = client.getExample(name);
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
  public void getExampleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-991/locations/location-991/apps/app-991/examples/example-991";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Example example = Example.newBuilder().build();

    Example actualResponse = client.createExample(parent, example);
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
  public void createExampleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    Example example = Example.newBuilder().build();

    Example actualResponse = client.createExample(parent, example);
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
  public void createExampleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Example example = Example.newBuilder().build();
    String exampleId = "exampleId-64591835";

    Example actualResponse = client.createExample(parent, example, exampleId);
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
  public void createExampleExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    Example example = Example.newBuilder().build();
    String exampleId = "exampleId-64591835";

    Example actualResponse = client.createExample(parent, example, exampleId);
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
  public void createExampleExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    Example example =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Example actualResponse = client.updateExample(example, updateMask);
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
  public void updateExampleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Example example =
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
    mockService.addResponse(expectedResponse);

    ExampleName name = ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]");

    client.deleteExample(name);

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
  public void deleteExampleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-991/locations/location-991/apps/app-991/examples/example-991";

    client.deleteExample(name);

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
  public void deleteExampleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-991/locations/location-991/apps/app-991/examples/example-991";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListToolsPagedResponse pagedListResponse = client.listTools(parent);

    List<Tool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getToolsList().get(0), resources.get(0));

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
  public void listToolsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";

    ListToolsPagedResponse pagedListResponse = client.listTools(parent);

    List<Tool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getToolsList().get(0), resources.get(0));

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
  public void listToolsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    ToolName name = ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]");

    Tool actualResponse = client.getTool(name);
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
  public void getToolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4311/locations/location-4311/apps/app-4311/tools/tool-4311";

    Tool actualResponse = client.getTool(name);
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
  public void getToolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4311/locations/location-4311/apps/app-4311/tools/tool-4311";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListConversationsPagedResponse pagedListResponse = client.listConversations(parent);

    List<Conversation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationsList().get(0), resources.get(0));

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
  public void listConversationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";

    ListConversationsPagedResponse pagedListResponse = client.listConversations(parent);

    List<Conversation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationsList().get(0), resources.get(0));

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
  public void listConversationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    ConversationName name =
        ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]");

    Conversation actualResponse = client.getConversation(name);
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
  public void getConversationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5806/locations/location-5806/apps/app-5806/conversations/conversation-5806";

    Conversation actualResponse = client.getConversation(name);
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
  public void getConversationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5806/locations/location-5806/apps/app-5806/conversations/conversation-5806";
      client.getConversation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConversationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ConversationName name =
        ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]");

    client.deleteConversation(name);

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
  public void deleteConversationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5806/locations/location-5806/apps/app-5806/conversations/conversation-5806";

    client.deleteConversation(name);

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
  public void deleteConversationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5806/locations/location-5806/apps/app-5806/conversations/conversation-5806";
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
    mockService.addResponse(resultOperation);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    BatchDeleteConversationsResponse actualResponse =
        client.batchDeleteConversationsAsync(parent).get();
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
  public void batchDeleteConversationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
      client.batchDeleteConversationsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";

    BatchDeleteConversationsResponse actualResponse =
        client.batchDeleteConversationsAsync(parent).get();
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
  public void batchDeleteConversationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
      client.batchDeleteConversationsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Tool tool = Tool.newBuilder().build();

    Tool actualResponse = client.createTool(parent, tool);
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
  public void createToolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    Tool tool = Tool.newBuilder().build();

    Tool actualResponse = client.createTool(parent, tool);
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
  public void createToolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Tool tool = Tool.newBuilder().build();
    String toolId = "toolId-868061997";

    Tool actualResponse = client.createTool(parent, tool, toolId);
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
  public void createToolExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    Tool tool = Tool.newBuilder().build();
    String toolId = "toolId-868061997";

    Tool actualResponse = client.createTool(parent, tool, toolId);
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
  public void createToolExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    Tool tool =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Tool actualResponse = client.updateTool(tool, updateMask);
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
  public void updateToolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Tool tool =
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
    mockService.addResponse(expectedResponse);

    ToolName name = ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]");

    client.deleteTool(name);

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
  public void deleteToolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4311/locations/location-4311/apps/app-4311/tools/tool-4311";

    client.deleteTool(name);

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
  public void deleteToolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4311/locations/location-4311/apps/app-4311/tools/tool-4311";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListGuardrailsPagedResponse pagedListResponse = client.listGuardrails(parent);

    List<Guardrail> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGuardrailsList().get(0), resources.get(0));

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
  public void listGuardrailsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";

    ListGuardrailsPagedResponse pagedListResponse = client.listGuardrails(parent);

    List<Guardrail> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGuardrailsList().get(0), resources.get(0));

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
  public void listGuardrailsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    GuardrailName name = GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]");

    Guardrail actualResponse = client.getGuardrail(name);
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
  public void getGuardrailExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6724/locations/location-6724/apps/app-6724/guardrails/guardrail-6724";

    Guardrail actualResponse = client.getGuardrail(name);
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
  public void getGuardrailExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6724/locations/location-6724/apps/app-6724/guardrails/guardrail-6724";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Guardrail guardrail = Guardrail.newBuilder().build();

    Guardrail actualResponse = client.createGuardrail(parent, guardrail);
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
  public void createGuardrailExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    Guardrail guardrail = Guardrail.newBuilder().build();

    Guardrail actualResponse = client.createGuardrail(parent, guardrail);
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
  public void createGuardrailExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Guardrail guardrail = Guardrail.newBuilder().build();
    String guardrailId = "guardrailId1875412786";

    Guardrail actualResponse = client.createGuardrail(parent, guardrail, guardrailId);
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
  public void createGuardrailExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    Guardrail guardrail = Guardrail.newBuilder().build();
    String guardrailId = "guardrailId1875412786";

    Guardrail actualResponse = client.createGuardrail(parent, guardrail, guardrailId);
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
  public void createGuardrailExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    Guardrail guardrail =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Guardrail actualResponse = client.updateGuardrail(guardrail, updateMask);
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
  public void updateGuardrailExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Guardrail guardrail =
          Guardrail.newBuilder()
              .setName(
                  GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]").toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setEnabled(true)
              .setAction(TriggerAction.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setEtag("etag3123477")
              .build();
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
    mockService.addResponse(expectedResponse);

    GuardrailName name = GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]");

    client.deleteGuardrail(name);

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
  public void deleteGuardrailExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6724/locations/location-6724/apps/app-6724/guardrails/guardrail-6724";

    client.deleteGuardrail(name);

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
  public void deleteGuardrailExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6724/locations/location-6724/apps/app-6724/guardrails/guardrail-6724";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListDeploymentsPagedResponse pagedListResponse = client.listDeployments(parent);

    List<Deployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentsList().get(0), resources.get(0));

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
  public void listDeploymentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";

    ListDeploymentsPagedResponse pagedListResponse = client.listDeployments(parent);

    List<Deployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeploymentsList().get(0), resources.get(0));

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
  public void listDeploymentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]");

    Deployment actualResponse = client.getDeployment(name);
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
  public void getDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3012/locations/location-3012/apps/app-3012/deployments/deployment-3012";

    Deployment actualResponse = client.getDeployment(name);
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
  public void getDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3012/locations/location-3012/apps/app-3012/deployments/deployment-3012";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Deployment deployment = Deployment.newBuilder().build();

    Deployment actualResponse = client.createDeployment(parent, deployment);
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
  public void createDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    Deployment deployment = Deployment.newBuilder().build();

    Deployment actualResponse = client.createDeployment(parent, deployment);
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
  public void createDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Deployment deployment = Deployment.newBuilder().build();
    String deploymentId = "deploymentId-136894784";

    Deployment actualResponse = client.createDeployment(parent, deployment, deploymentId);
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
  public void createDeploymentExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    Deployment deployment = Deployment.newBuilder().build();
    String deploymentId = "deploymentId-136894784";

    Deployment actualResponse = client.createDeployment(parent, deployment, deploymentId);
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
  public void createDeploymentExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    Deployment deployment =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Deployment actualResponse = client.updateDeployment(deployment, updateMask);
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
  public void updateDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Deployment deployment =
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
    mockService.addResponse(expectedResponse);

    DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]");

    client.deleteDeployment(name);

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
  public void deleteDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3012/locations/location-3012/apps/app-3012/deployments/deployment-3012";

    client.deleteDeployment(name);

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
  public void deleteDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3012/locations/location-3012/apps/app-3012/deployments/deployment-3012";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListToolsetsPagedResponse pagedListResponse = client.listToolsets(parent);

    List<Toolset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getToolsetsList().get(0), resources.get(0));

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
  public void listToolsetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";

    ListToolsetsPagedResponse pagedListResponse = client.listToolsets(parent);

    List<Toolset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getToolsetsList().get(0), resources.get(0));

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
  public void listToolsetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    ToolsetName name = ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]");

    Toolset actualResponse = client.getToolset(name);
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
  public void getToolsetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8913/locations/location-8913/apps/app-8913/toolsets/toolset-8913";

    Toolset actualResponse = client.getToolset(name);
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
  public void getToolsetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8913/locations/location-8913/apps/app-8913/toolsets/toolset-8913";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Toolset toolset = Toolset.newBuilder().build();

    Toolset actualResponse = client.createToolset(parent, toolset);
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
  public void createToolsetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    Toolset toolset = Toolset.newBuilder().build();

    Toolset actualResponse = client.createToolset(parent, toolset);
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
  public void createToolsetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    Toolset toolset = Toolset.newBuilder().build();
    String toolsetId = "toolsetId-397931899";

    Toolset actualResponse = client.createToolset(parent, toolset, toolsetId);
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
  public void createToolsetExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    Toolset toolset = Toolset.newBuilder().build();
    String toolsetId = "toolsetId-397931899";

    Toolset actualResponse = client.createToolset(parent, toolset, toolsetId);
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
  public void createToolsetExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    Toolset toolset =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Toolset actualResponse = client.updateToolset(toolset, updateMask);
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
  public void updateToolsetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Toolset toolset =
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
    mockService.addResponse(expectedResponse);

    ToolsetName name = ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]");

    client.deleteToolset(name);

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
  public void deleteToolsetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8913/locations/location-8913/apps/app-8913/toolsets/toolset-8913";

    client.deleteToolset(name);

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
  public void deleteToolsetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8913/locations/location-8913/apps/app-8913/toolsets/toolset-8913";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListAppVersionsPagedResponse pagedListResponse = client.listAppVersions(parent);

    List<AppVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAppVersionsList().get(0), resources.get(0));

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
  public void listAppVersionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";

    ListAppVersionsPagedResponse pagedListResponse = client.listAppVersions(parent);

    List<AppVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAppVersionsList().get(0), resources.get(0));

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
  public void listAppVersionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    AppVersionName name = AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]");

    AppVersion actualResponse = client.getAppVersion(name);
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
  public void getAppVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2813/locations/location-2813/apps/app-2813/versions/version-2813";

    AppVersion actualResponse = client.getAppVersion(name);
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
  public void getAppVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2813/locations/location-2813/apps/app-2813/versions/version-2813";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    AppVersion appVersion = AppVersion.newBuilder().build();

    AppVersion actualResponse = client.createAppVersion(parent, appVersion);
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
  public void createAppVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    AppVersion appVersion = AppVersion.newBuilder().build();

    AppVersion actualResponse = client.createAppVersion(parent, appVersion);
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
  public void createAppVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
    AppVersion appVersion = AppVersion.newBuilder().build();
    String appVersionId = "appVersionId303221490";

    AppVersion actualResponse = client.createAppVersion(parent, appVersion, appVersionId);
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
  public void createAppVersionExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
    AppVersion appVersion = AppVersion.newBuilder().build();
    String appVersionId = "appVersionId303221490";

    AppVersion actualResponse = client.createAppVersion(parent, appVersion, appVersionId);
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
  public void createAppVersionExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    AppVersionName name = AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]");

    client.deleteAppVersion(name);

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
  public void deleteAppVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2813/locations/location-2813/apps/app-2813/versions/version-2813";

    client.deleteAppVersion(name);

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
  public void deleteAppVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2813/locations/location-2813/apps/app-2813/versions/version-2813";
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
    mockService.addResponse(resultOperation);

    AppVersionName name = AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]");

    RestoreAppVersionResponse actualResponse = client.restoreAppVersionAsync(name).get();
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
  public void restoreAppVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AppVersionName name = AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]");
      client.restoreAppVersionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-2813/locations/location-2813/apps/app-2813/versions/version-2813";

    RestoreAppVersionResponse actualResponse = client.restoreAppVersionAsync(name).get();
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
  public void restoreAppVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2813/locations/location-2813/apps/app-2813/versions/version-2813";
      client.restoreAppVersionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");

    ListChangelogsPagedResponse pagedListResponse = client.listChangelogs(parent);

    List<Changelog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChangelogsList().get(0), resources.get(0));

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
  public void listChangelogsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8877/locations/location-8877/apps/app-8877";

    ListChangelogsPagedResponse pagedListResponse = client.listChangelogs(parent);

    List<Changelog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChangelogsList().get(0), resources.get(0));

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
  public void listChangelogsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8877/locations/location-8877/apps/app-8877";
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
    mockService.addResponse(expectedResponse);

    ChangelogName name = ChangelogName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CHANGELOG]");

    Changelog actualResponse = client.getChangelog(name);
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
  public void getChangelogExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6425/locations/location-6425/apps/app-6425/changelogs/changelog-6425";

    Changelog actualResponse = client.getChangelog(name);
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
  public void getChangelogExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6425/locations/location-6425/apps/app-6425/changelogs/changelog-6425";
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
}
