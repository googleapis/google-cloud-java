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

package com.google.cloud.dialogflow.cx.v3;

import static com.google.cloud.dialogflow.cx.v3.AgentsClient.ListAgentsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.AgentsClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dialogflow.cx.v3.stub.HttpJsonAgentsStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class AgentsClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AgentsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAgentsStub.getMethodDescriptors(), AgentsSettings.getDefaultEndpoint());
    AgentsSettings settings =
        AgentsSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AgentsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AgentsClient.create(settings);
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
  public void listAgentsTest() throws Exception {
    Agent responsesElement = Agent.newBuilder().build();
    ListAgentsResponse expectedResponse =
        ListAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAgents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

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
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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

    String parent = "projects/project-5833/locations/location-5833";

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
      String parent = "projects/project-5833/locations/location-5833";
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
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLanguageCode("defaultLanguageCode2069633606")
            .addAllSupportedLanguageCodes(new ArrayList<String>())
            .setTimeZone("timeZone-2077180903")
            .setDescription("description-1724546052")
            .setAvatarUri("avatarUri-428646061")
            .setSpeechToTextSettings(SpeechToTextSettings.newBuilder().build())
            .setStartFlow(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
            .setSecuritySettings(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setEnableStackdriverLogging(true)
            .setEnableSpellCorrection(true)
            .setLocked(true)
            .setAdvancedSettings(AdvancedSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");

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
      AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
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
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLanguageCode("defaultLanguageCode2069633606")
            .addAllSupportedLanguageCodes(new ArrayList<String>())
            .setTimeZone("timeZone-2077180903")
            .setDescription("description-1724546052")
            .setAvatarUri("avatarUri-428646061")
            .setSpeechToTextSettings(SpeechToTextSettings.newBuilder().build())
            .setStartFlow(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
            .setSecuritySettings(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setEnableStackdriverLogging(true)
            .setEnableSpellCorrection(true)
            .setLocked(true)
            .setAdvancedSettings(AdvancedSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2930/locations/location-2930/agents/agent-2930";

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
      String name = "projects/project-2930/locations/location-2930/agents/agent-2930";
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
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLanguageCode("defaultLanguageCode2069633606")
            .addAllSupportedLanguageCodes(new ArrayList<String>())
            .setTimeZone("timeZone-2077180903")
            .setDescription("description-1724546052")
            .setAvatarUri("avatarUri-428646061")
            .setSpeechToTextSettings(SpeechToTextSettings.newBuilder().build())
            .setStartFlow(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
            .setSecuritySettings(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setEnableStackdriverLogging(true)
            .setEnableSpellCorrection(true)
            .setLocked(true)
            .setAdvancedSettings(AdvancedSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLanguageCode("defaultLanguageCode2069633606")
            .addAllSupportedLanguageCodes(new ArrayList<String>())
            .setTimeZone("timeZone-2077180903")
            .setDescription("description-1724546052")
            .setAvatarUri("avatarUri-428646061")
            .setSpeechToTextSettings(SpeechToTextSettings.newBuilder().build())
            .setStartFlow(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
            .setSecuritySettings(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setEnableStackdriverLogging(true)
            .setEnableSpellCorrection(true)
            .setLocked(true)
            .setAdvancedSettings(AdvancedSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
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
      String parent = "projects/project-5833/locations/location-5833";
      Agent agent = Agent.newBuilder().build();
      client.createAgent(parent, agent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAgentTest() throws Exception {
    Agent expectedResponse =
        Agent.newBuilder()
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLanguageCode("defaultLanguageCode2069633606")
            .addAllSupportedLanguageCodes(new ArrayList<String>())
            .setTimeZone("timeZone-2077180903")
            .setDescription("description-1724546052")
            .setAvatarUri("avatarUri-428646061")
            .setSpeechToTextSettings(SpeechToTextSettings.newBuilder().build())
            .setStartFlow(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
            .setSecuritySettings(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setEnableStackdriverLogging(true)
            .setEnableSpellCorrection(true)
            .setLocked(true)
            .setAdvancedSettings(AdvancedSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Agent agent =
        Agent.newBuilder()
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLanguageCode("defaultLanguageCode2069633606")
            .addAllSupportedLanguageCodes(new ArrayList<String>())
            .setTimeZone("timeZone-2077180903")
            .setDescription("description-1724546052")
            .setAvatarUri("avatarUri-428646061")
            .setSpeechToTextSettings(SpeechToTextSettings.newBuilder().build())
            .setStartFlow(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
            .setSecuritySettings(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setEnableStackdriverLogging(true)
            .setEnableSpellCorrection(true)
            .setLocked(true)
            .setAdvancedSettings(AdvancedSettings.newBuilder().build())
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
              .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
              .setDisplayName("displayName1714148973")
              .setDefaultLanguageCode("defaultLanguageCode2069633606")
              .addAllSupportedLanguageCodes(new ArrayList<String>())
              .setTimeZone("timeZone-2077180903")
              .setDescription("description-1724546052")
              .setAvatarUri("avatarUri-428646061")
              .setSpeechToTextSettings(SpeechToTextSettings.newBuilder().build())
              .setStartFlow(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
              .setSecuritySettings(
                  SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                      .toString())
              .setEnableStackdriverLogging(true)
              .setEnableSpellCorrection(true)
              .setLocked(true)
              .setAdvancedSettings(AdvancedSettings.newBuilder().build())
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

    AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");

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
      AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
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

    String name = "projects/project-2930/locations/location-2930/agents/agent-2930";

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
      String name = "projects/project-2930/locations/location-2930/agents/agent-2930";
      client.deleteAgent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void exportAgentTest() throws Exception {
    ExportAgentResponse expectedResponse = ExportAgentResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ExportAgentRequest request =
        ExportAgentRequest.newBuilder()
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .setAgentUri("agentUri1469149223")
            .setEnvironment(
                EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
                    .toString())
            .build();

    ExportAgentResponse actualResponse = client.exportAgentAsync(request).get();
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
  public void exportAgentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ExportAgentRequest request =
          ExportAgentRequest.newBuilder()
              .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
              .setAgentUri("agentUri1469149223")
              .setEnvironment(
                  EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
                      .toString())
              .build();
      client.exportAgentAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void restoreAgentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreAgentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RestoreAgentRequest request =
        RestoreAgentRequest.newBuilder()
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .build();

    client.restoreAgentAsync(request).get();

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
  public void restoreAgentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RestoreAgentRequest request =
          RestoreAgentRequest.newBuilder()
              .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
              .build();
      client.restoreAgentAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void validateAgentTest() throws Exception {
    AgentValidationResult expectedResponse =
        AgentValidationResult.newBuilder()
            .setName(AgentValidationResultName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .addAllFlowValidationResults(new ArrayList<FlowValidationResult>())
            .build();
    mockService.addResponse(expectedResponse);

    ValidateAgentRequest request =
        ValidateAgentRequest.newBuilder()
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .setLanguageCode("languageCode-2092349083")
            .build();

    AgentValidationResult actualResponse = client.validateAgent(request);
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
  public void validateAgentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ValidateAgentRequest request =
          ValidateAgentRequest.newBuilder()
              .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
              .setLanguageCode("languageCode-2092349083")
              .build();
      client.validateAgent(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAgentValidationResultTest() throws Exception {
    AgentValidationResult expectedResponse =
        AgentValidationResult.newBuilder()
            .setName(AgentValidationResultName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .addAllFlowValidationResults(new ArrayList<FlowValidationResult>())
            .build();
    mockService.addResponse(expectedResponse);

    AgentValidationResultName name =
        AgentValidationResultName.of("[PROJECT]", "[LOCATION]", "[AGENT]");

    AgentValidationResult actualResponse = client.getAgentValidationResult(name);
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
  public void getAgentValidationResultExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AgentValidationResultName name =
          AgentValidationResultName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      client.getAgentValidationResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAgentValidationResultTest2() throws Exception {
    AgentValidationResult expectedResponse =
        AgentValidationResult.newBuilder()
            .setName(AgentValidationResultName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .addAllFlowValidationResults(new ArrayList<FlowValidationResult>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7481/locations/location-7481/agents/agent-7481/validationResult";

    AgentValidationResult actualResponse = client.getAgentValidationResult(name);
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
  public void getAgentValidationResultExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7481/locations/location-7481/agents/agent-7481/validationResult";
      client.getAgentValidationResult(name);
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
