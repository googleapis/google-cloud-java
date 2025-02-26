/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.dialogflow.cx.v3beta1;

import static com.google.cloud.dialogflow.cx.v3beta1.AgentsClient.ListAgentsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.AgentsClient.ListLocationsPagedResponse;

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
public class AgentsClientTest {
  private static MockAgents mockAgents;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AgentsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAgents = new MockAgents();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAgents, mockLocations));
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
    AgentsSettings settings =
        AgentsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AgentsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listAgentsTest() throws Exception {
    Agent responsesElement = Agent.newBuilder().build();
    ListAgentsResponse expectedResponse =
        ListAgentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAgents(Arrays.asList(responsesElement))
            .build();
    mockAgents.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAgentsPagedResponse pagedListResponse = client.listAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
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
    mockAgents.addException(exception);

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
    mockAgents.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAgentsPagedResponse pagedListResponse = client.listAgents(parent);

    List<Agent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAgentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
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
    mockAgents.addException(exception);

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
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLanguageCode("defaultLanguageCode2069633606")
            .addAllSupportedLanguageCodes(new ArrayList<String>())
            .setTimeZone("timeZone-2077180903")
            .setDescription("description-1724546052")
            .setAvatarUri("avatarUri-428646061")
            .setSpeechToTextSettings(SpeechToTextSettings.newBuilder().build())
            .setSecuritySettings(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setEnableStackdriverLogging(true)
            .setEnableSpellCorrection(true)
            .setEnableMultiLanguageTraining(true)
            .setLocked(true)
            .setAdvancedSettings(AdvancedSettings.newBuilder().build())
            .setGitIntegrationSettings(Agent.GitIntegrationSettings.newBuilder().build())
            .setBigqueryExportSettings(BigQueryExportSettings.newBuilder().build())
            .setTextToSpeechSettings(TextToSpeechSettings.newBuilder().build())
            .setGenAppBuilderSettings(Agent.GenAppBuilderSettings.newBuilder().build())
            .setAnswerFeedbackSettings(Agent.AnswerFeedbackSettings.newBuilder().build())
            .setPersonalizationSettings(Agent.PersonalizationSettings.newBuilder().build())
            .setClientCertificateSettings(Agent.ClientCertificateSettings.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .build();
    mockAgents.addResponse(expectedResponse);

    AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");

    Agent actualResponse = client.getAgent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
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
    mockAgents.addException(exception);

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
            .setSecuritySettings(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setEnableStackdriverLogging(true)
            .setEnableSpellCorrection(true)
            .setEnableMultiLanguageTraining(true)
            .setLocked(true)
            .setAdvancedSettings(AdvancedSettings.newBuilder().build())
            .setGitIntegrationSettings(Agent.GitIntegrationSettings.newBuilder().build())
            .setBigqueryExportSettings(BigQueryExportSettings.newBuilder().build())
            .setTextToSpeechSettings(TextToSpeechSettings.newBuilder().build())
            .setGenAppBuilderSettings(Agent.GenAppBuilderSettings.newBuilder().build())
            .setAnswerFeedbackSettings(Agent.AnswerFeedbackSettings.newBuilder().build())
            .setPersonalizationSettings(Agent.PersonalizationSettings.newBuilder().build())
            .setClientCertificateSettings(Agent.ClientCertificateSettings.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .build();
    mockAgents.addResponse(expectedResponse);

    String name = "name3373707";

    Agent actualResponse = client.getAgent(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
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
    mockAgents.addException(exception);

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
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLanguageCode("defaultLanguageCode2069633606")
            .addAllSupportedLanguageCodes(new ArrayList<String>())
            .setTimeZone("timeZone-2077180903")
            .setDescription("description-1724546052")
            .setAvatarUri("avatarUri-428646061")
            .setSpeechToTextSettings(SpeechToTextSettings.newBuilder().build())
            .setSecuritySettings(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setEnableStackdriverLogging(true)
            .setEnableSpellCorrection(true)
            .setEnableMultiLanguageTraining(true)
            .setLocked(true)
            .setAdvancedSettings(AdvancedSettings.newBuilder().build())
            .setGitIntegrationSettings(Agent.GitIntegrationSettings.newBuilder().build())
            .setBigqueryExportSettings(BigQueryExportSettings.newBuilder().build())
            .setTextToSpeechSettings(TextToSpeechSettings.newBuilder().build())
            .setGenAppBuilderSettings(Agent.GenAppBuilderSettings.newBuilder().build())
            .setAnswerFeedbackSettings(Agent.AnswerFeedbackSettings.newBuilder().build())
            .setPersonalizationSettings(Agent.PersonalizationSettings.newBuilder().build())
            .setClientCertificateSettings(Agent.ClientCertificateSettings.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .build();
    mockAgents.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Agent agent = Agent.newBuilder().build();

    Agent actualResponse = client.createAgent(parent, agent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
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
    mockAgents.addException(exception);

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
            .setSecuritySettings(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setEnableStackdriverLogging(true)
            .setEnableSpellCorrection(true)
            .setEnableMultiLanguageTraining(true)
            .setLocked(true)
            .setAdvancedSettings(AdvancedSettings.newBuilder().build())
            .setGitIntegrationSettings(Agent.GitIntegrationSettings.newBuilder().build())
            .setBigqueryExportSettings(BigQueryExportSettings.newBuilder().build())
            .setTextToSpeechSettings(TextToSpeechSettings.newBuilder().build())
            .setGenAppBuilderSettings(Agent.GenAppBuilderSettings.newBuilder().build())
            .setAnswerFeedbackSettings(Agent.AnswerFeedbackSettings.newBuilder().build())
            .setPersonalizationSettings(Agent.PersonalizationSettings.newBuilder().build())
            .setClientCertificateSettings(Agent.ClientCertificateSettings.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .build();
    mockAgents.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Agent agent = Agent.newBuilder().build();

    Agent actualResponse = client.createAgent(parent, agent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
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
    mockAgents.addException(exception);

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
            .setSecuritySettings(
                SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
                    .toString())
            .setEnableStackdriverLogging(true)
            .setEnableSpellCorrection(true)
            .setEnableMultiLanguageTraining(true)
            .setLocked(true)
            .setAdvancedSettings(AdvancedSettings.newBuilder().build())
            .setGitIntegrationSettings(Agent.GitIntegrationSettings.newBuilder().build())
            .setBigqueryExportSettings(BigQueryExportSettings.newBuilder().build())
            .setTextToSpeechSettings(TextToSpeechSettings.newBuilder().build())
            .setGenAppBuilderSettings(Agent.GenAppBuilderSettings.newBuilder().build())
            .setAnswerFeedbackSettings(Agent.AnswerFeedbackSettings.newBuilder().build())
            .setPersonalizationSettings(Agent.PersonalizationSettings.newBuilder().build())
            .setClientCertificateSettings(Agent.ClientCertificateSettings.newBuilder().build())
            .setSatisfiesPzs(true)
            .setSatisfiesPzi(true)
            .build();
    mockAgents.addResponse(expectedResponse);

    Agent agent = Agent.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Agent actualResponse = client.updateAgent(agent, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
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
    mockAgents.addException(exception);

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
    mockAgents.addResponse(expectedResponse);

    AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");

    client.deleteAgent(name);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
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
    mockAgents.addException(exception);

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
    mockAgents.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAgent(name);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
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
    mockAgents.addException(exception);

    try {
      String name = "name3373707";
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
    mockAgents.addResponse(resultOperation);

    ExportAgentRequest request =
        ExportAgentRequest.newBuilder()
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .setAgentUri("agentUri1469149223")
            .setEnvironment(
                EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
                    .toString())
            .setGitDestination(ExportAgentRequest.GitDestination.newBuilder().build())
            .setIncludeBigqueryExportSettings(true)
            .build();

    ExportAgentResponse actualResponse = client.exportAgentAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportAgentRequest actualRequest = ((ExportAgentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getAgentUri(), actualRequest.getAgentUri());
    Assert.assertEquals(request.getDataFormat(), actualRequest.getDataFormat());
    Assert.assertEquals(request.getEnvironment(), actualRequest.getEnvironment());
    Assert.assertEquals(request.getGitDestination(), actualRequest.getGitDestination());
    Assert.assertEquals(
        request.getIncludeBigqueryExportSettings(),
        actualRequest.getIncludeBigqueryExportSettings());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      ExportAgentRequest request =
          ExportAgentRequest.newBuilder()
              .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
              .setAgentUri("agentUri1469149223")
              .setEnvironment(
                  EnvironmentName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[ENVIRONMENT]")
                      .toString())
              .setGitDestination(ExportAgentRequest.GitDestination.newBuilder().build())
              .setIncludeBigqueryExportSettings(true)
              .build();
      client.exportAgentAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockAgents.addResponse(resultOperation);

    RestoreAgentRequest request =
        RestoreAgentRequest.newBuilder()
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .build();

    client.restoreAgentAsync(request).get();

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreAgentRequest actualRequest = ((RestoreAgentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getAgentUri(), actualRequest.getAgentUri());
    Assert.assertEquals(request.getAgentContent(), actualRequest.getAgentContent());
    Assert.assertEquals(request.getGitSource(), actualRequest.getGitSource());
    Assert.assertEquals(request.getRestoreOption(), actualRequest.getRestoreOption());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restoreAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      RestoreAgentRequest request =
          RestoreAgentRequest.newBuilder()
              .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
              .build();
      client.restoreAgentAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void validateAgentTest() throws Exception {
    AgentValidationResult expectedResponse =
        AgentValidationResult.newBuilder()
            .setName(AgentValidationResultName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .addAllFlowValidationResults(new ArrayList<FlowValidationResult>())
            .build();
    mockAgents.addResponse(expectedResponse);

    ValidateAgentRequest request =
        ValidateAgentRequest.newBuilder()
            .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .setLanguageCode("languageCode-2092349083")
            .build();

    AgentValidationResult actualResponse = client.validateAgent(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ValidateAgentRequest actualRequest = ((ValidateAgentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getLanguageCode(), actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void validateAgentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

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
    mockAgents.addResponse(expectedResponse);

    AgentValidationResultName name =
        AgentValidationResultName.of("[PROJECT]", "[LOCATION]", "[AGENT]");

    AgentValidationResult actualResponse = client.getAgentValidationResult(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAgentValidationResultRequest actualRequest =
        ((GetAgentValidationResultRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAgentValidationResultExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

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
    mockAgents.addResponse(expectedResponse);

    String name = "name3373707";

    AgentValidationResult actualResponse = client.getAgentValidationResult(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAgentValidationResultRequest actualRequest =
        ((GetAgentValidationResultRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAgentValidationResultExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      String name = "name3373707";
      client.getAgentValidationResult(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGenerativeSettingsTest() throws Exception {
    GenerativeSettings expectedResponse =
        GenerativeSettings.newBuilder()
            .setName(
                AgentGenerativeSettingsName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .setFallbackSettings(GenerativeSettings.FallbackSettings.newBuilder().build())
            .setGenerativeSafetySettings(SafetySettings.newBuilder().build())
            .setKnowledgeConnectorSettings(
                GenerativeSettings.KnowledgeConnectorSettings.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setLlmModelSettings(LlmModelSettings.newBuilder().build())
            .build();
    mockAgents.addResponse(expectedResponse);

    AgentGenerativeSettingsName name =
        AgentGenerativeSettingsName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
    String languageCode = "languageCode-2092349083";

    GenerativeSettings actualResponse = client.getGenerativeSettings(name, languageCode);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGenerativeSettingsRequest actualRequest =
        ((GetGenerativeSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(languageCode, actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGenerativeSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      AgentGenerativeSettingsName name =
          AgentGenerativeSettingsName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      String languageCode = "languageCode-2092349083";
      client.getGenerativeSettings(name, languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGenerativeSettingsTest2() throws Exception {
    GenerativeSettings expectedResponse =
        GenerativeSettings.newBuilder()
            .setName(
                AgentGenerativeSettingsName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .setFallbackSettings(GenerativeSettings.FallbackSettings.newBuilder().build())
            .setGenerativeSafetySettings(SafetySettings.newBuilder().build())
            .setKnowledgeConnectorSettings(
                GenerativeSettings.KnowledgeConnectorSettings.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setLlmModelSettings(LlmModelSettings.newBuilder().build())
            .build();
    mockAgents.addResponse(expectedResponse);

    String name = "name3373707";
    String languageCode = "languageCode-2092349083";

    GenerativeSettings actualResponse = client.getGenerativeSettings(name, languageCode);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGenerativeSettingsRequest actualRequest =
        ((GetGenerativeSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(languageCode, actualRequest.getLanguageCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGenerativeSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      String name = "name3373707";
      String languageCode = "languageCode-2092349083";
      client.getGenerativeSettings(name, languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateGenerativeSettingsTest() throws Exception {
    GenerativeSettings expectedResponse =
        GenerativeSettings.newBuilder()
            .setName(
                AgentGenerativeSettingsName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
            .setFallbackSettings(GenerativeSettings.FallbackSettings.newBuilder().build())
            .setGenerativeSafetySettings(SafetySettings.newBuilder().build())
            .setKnowledgeConnectorSettings(
                GenerativeSettings.KnowledgeConnectorSettings.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setLlmModelSettings(LlmModelSettings.newBuilder().build())
            .build();
    mockAgents.addResponse(expectedResponse);

    GenerativeSettings generativeSettings = GenerativeSettings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GenerativeSettings actualResponse =
        client.updateGenerativeSettings(generativeSettings, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAgents.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGenerativeSettingsRequest actualRequest =
        ((UpdateGenerativeSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(generativeSettings, actualRequest.getGenerativeSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGenerativeSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAgents.addException(exception);

    try {
      GenerativeSettings generativeSettings = GenerativeSettings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGenerativeSettings(generativeSettings, updateMask);
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
