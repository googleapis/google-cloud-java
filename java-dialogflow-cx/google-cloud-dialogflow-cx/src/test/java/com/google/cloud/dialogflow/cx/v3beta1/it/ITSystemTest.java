/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dialogflow.cx.v3beta1.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.ServiceOptions;
import com.google.cloud.dialogflow.cx.v3beta1.Agent;
import com.google.cloud.dialogflow.cx.v3beta1.AgentsClient;
import com.google.cloud.dialogflow.cx.v3beta1.CreateEntityTypeRequest;
import com.google.cloud.dialogflow.cx.v3beta1.CreateFlowRequest;
import com.google.cloud.dialogflow.cx.v3beta1.CreateIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.CreatePageRequest;
import com.google.cloud.dialogflow.cx.v3beta1.CreateTransitionRouteGroupRequest;
import com.google.cloud.dialogflow.cx.v3beta1.CreateVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteAgentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteEntityTypeRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteFlowRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeletePageRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteTransitionRouteGroupRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DetectIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DetectIntentResponse;
import com.google.cloud.dialogflow.cx.v3beta1.EntityType;
import com.google.cloud.dialogflow.cx.v3beta1.EntityTypesClient;
import com.google.cloud.dialogflow.cx.v3beta1.ExportAgentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ExportAgentResponse;
import com.google.cloud.dialogflow.cx.v3beta1.Flow;
import com.google.cloud.dialogflow.cx.v3beta1.FlowsClient;
import com.google.cloud.dialogflow.cx.v3beta1.Form;
import com.google.cloud.dialogflow.cx.v3beta1.GetAgentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetEntityTypeRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetFlowRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetPageRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetTransitionRouteGroupRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.Intent;
import com.google.cloud.dialogflow.cx.v3beta1.IntentsClient;
import com.google.cloud.dialogflow.cx.v3beta1.ListAgentsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListEntityTypesRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListFlowsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListIntentsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListPagesRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListTransitionRouteGroupsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListVersionsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.LocationName;
import com.google.cloud.dialogflow.cx.v3beta1.MatchIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse;
import com.google.cloud.dialogflow.cx.v3beta1.NluSettings;
import com.google.cloud.dialogflow.cx.v3beta1.Page;
import com.google.cloud.dialogflow.cx.v3beta1.PagesClient;
import com.google.cloud.dialogflow.cx.v3beta1.QueryInput;
import com.google.cloud.dialogflow.cx.v3beta1.RestoreAgentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.SessionsClient;
import com.google.cloud.dialogflow.cx.v3beta1.TextInput;
import com.google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroup;
import com.google.cloud.dialogflow.cx.v3beta1.TransitionRouteGroupsClient;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateEntityTypeRequest;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateTransitionRouteGroupRequest;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.Version;
import com.google.cloud.dialogflow.cx.v3beta1.VersionsClient;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {
  private static AgentsClient agentsClient;
  private static EntityTypesClient entityTypesClient;
  private static FlowsClient flowsClient;
  private static IntentsClient intentsClient;
  private static PagesClient pagesClient;
  private static SessionsClient sessionsClient;
  private static TransitionRouteGroupsClient transitionRouteGroupsClient;
  private static VersionsClient versionsClient;
  private static String agentName;
  private static String entityTypesName;
  private static String flowName;
  private static String intentsName;
  private static String pageName;
  private static String transitionRouteGroupName;
  private static String versionName;

  private static final String PROJECT = ServiceOptions.getDefaultProjectId();
  private static final String ID = UUID.randomUUID().toString();
  private static final String LOCATION = "global";
  private static final String DISPLAY_NAME = "test-" + ID.substring(0, 8);
  private static final String AGENT_TIME_ZONE = "America/Los_Angeles";
  private static final String DEFAULT_LANGUAGE_CODE = "en";
  private static final String DESCRIPTION = "description-test-" + ID;
  private static final String TEXT = "hello";
  private static final QueryInput QUERY_INPUT =
      QueryInput.newBuilder()
          .setText(TextInput.newBuilder().setText(TEXT).build())
          .setLanguageCode(DEFAULT_LANGUAGE_CODE)
          .build();
  private static final LocationName PARENT = LocationName.of(PROJECT, LOCATION);
  private static NluSettings NLUSETTINGS =
      NluSettings.newBuilder()
          .setModelType(NluSettings.ModelType.MODEL_TYPE_STANDARD)
          .setClassificationThreshold(0.3f)
          .setModelTrainingModeValue(1)
          .build();

  @BeforeClass
  public static void setUp() throws IOException, ExecutionException, InterruptedException {
    /* create agents */
    agentsClient = AgentsClient.create();
    Agent agent =
        Agent.newBuilder()
            .setDisplayName(DISPLAY_NAME)
            .setDescription(DESCRIPTION)
            .setTimeZone(AGENT_TIME_ZONE)
            .setDefaultLanguageCode(DEFAULT_LANGUAGE_CODE)
            .setStartFlow(ID)
            .setEnableStackdriverLogging(true)
            .build();
    Agent response = agentsClient.createAgent(PARENT, agent);
    agentName = response.getName();

    /* create entity types */
    entityTypesClient = EntityTypesClient.create();
    EntityType entityType =
        EntityType.newBuilder()
            .setAutoExpansionMode(EntityType.AutoExpansionMode.AUTO_EXPANSION_MODE_DEFAULT)
            .setAutoExpansionModeValue(1)
            .setDisplayName(DISPLAY_NAME)
            .setEnableFuzzyExtraction(true)
            .setKind(EntityType.Kind.KIND_LIST)
            .build();
    CreateEntityTypeRequest request =
        CreateEntityTypeRequest.newBuilder().setParent(agentName).setEntityType(entityType).build();
    EntityType entityTypeResponse = entityTypesClient.createEntityType(request);
    entityTypesName = entityTypeResponse.getName();

    /* create flows */
    flowsClient = FlowsClient.create();
    Flow flow =
        Flow.newBuilder()
            .setNluSettings(NLUSETTINGS)
            .setDisplayName(DISPLAY_NAME)
            .setDescription(DESCRIPTION)
            .build();
    CreateFlowRequest createFlowRequest =
        CreateFlowRequest.newBuilder().setParent(agentName).setFlow(flow).build();
    Flow flowResponse = flowsClient.createFlow(createFlowRequest);
    flowName = flowResponse.getName();

    /* create intents */
    intentsClient = IntentsClient.create();
    Intent intent = Intent.newBuilder().setDisplayName(DISPLAY_NAME).setPriority(1).build();
    CreateIntentRequest createIntentRequest =
        CreateIntentRequest.newBuilder().setIntent(intent).setParent(agentName).build();
    Intent intentResponse = intentsClient.createIntent(createIntentRequest);
    intentsName = intentResponse.getName();

    /* create pages */
    pagesClient = PagesClient.create();
    Page page = Page.newBuilder().setDisplayName(DISPLAY_NAME).build();
    CreatePageRequest createPageRequest =
        CreatePageRequest.newBuilder().setPage(page).setParent(flowName).build();
    Page pageResponse = pagesClient.createPage(createPageRequest);
    pageName = pageResponse.getName();

    /* create session */
    sessionsClient = SessionsClient.create();

    /* create transition route groups */
    transitionRouteGroupsClient = TransitionRouteGroupsClient.create();
    TransitionRouteGroup transitionRouteGroup =
        TransitionRouteGroup.newBuilder().setDisplayName(DISPLAY_NAME).build();
    CreateTransitionRouteGroupRequest transitionRouteGroupRequest =
        CreateTransitionRouteGroupRequest.newBuilder()
            .setParent(flowName)
            .setTransitionRouteGroup(transitionRouteGroup)
            .build();
    TransitionRouteGroup transitionRouteGroupResponse =
        transitionRouteGroupsClient.createTransitionRouteGroup(transitionRouteGroupRequest);
    transitionRouteGroupName = transitionRouteGroupResponse.getName();

    /* create version */
    versionsClient = VersionsClient.create();
    Version version = Version.newBuilder().setStateValue(2).setDisplayName(DISPLAY_NAME).build();
    CreateVersionRequest createVersionRequest =
        CreateVersionRequest.newBuilder().setParent(flowName).setVersion(version).build();
    Version versionResponse = versionsClient.createVersionAsync(createVersionRequest).get();
    versionName = versionResponse.getName();
  }

  @AfterClass
  public static void tearDown() {
    /* delete version */
    DeleteVersionRequest deleteVersionRequest =
        DeleteVersionRequest.newBuilder().setName(versionName).build();
    versionsClient.deleteVersion(deleteVersionRequest);
    versionsClient.close();

    /* delete transition route groups */
    DeleteTransitionRouteGroupRequest deleteTransitionRouteGroupRequest =
        DeleteTransitionRouteGroupRequest.newBuilder().setName(transitionRouteGroupName).build();
    transitionRouteGroupsClient.deleteTransitionRouteGroup(deleteTransitionRouteGroupRequest);
    transitionRouteGroupsClient.close();

    /* delete session */
    sessionsClient.close();

    /* delete pages */
    DeletePageRequest deletePageRequest = DeletePageRequest.newBuilder().setName(pageName).build();
    pagesClient.deletePage(deletePageRequest);
    pagesClient.close();

    /* delete intents */
    DeleteIntentRequest deleteIntentRequest =
        DeleteIntentRequest.newBuilder().setName(intentsName).build();
    intentsClient.deleteIntent(deleteIntentRequest);
    intentsClient.close();

    /* delete flows */
    DeleteFlowRequest deleteFlowRequest = DeleteFlowRequest.newBuilder().setName(flowName).build();
    flowsClient.deleteFlow(deleteFlowRequest);
    flowsClient.close();

    /* delete entity types */
    DeleteEntityTypeRequest deleteEntityTypeRequest =
        DeleteEntityTypeRequest.newBuilder().setName(entityTypesName).build();
    entityTypesClient.deleteEntityType(deleteEntityTypeRequest);
    entityTypesClient.close();

    /* delete agents */
    DeleteAgentRequest deleteAgentRequest =
        DeleteAgentRequest.newBuilder().setName(agentName).build();
    agentsClient.deleteAgent(deleteAgentRequest);
    agentsClient.close();
  }

  @Test
  public void getAgentTest() {
    GetAgentRequest request = GetAgentRequest.newBuilder().setName(agentName).build();
    Agent agent = agentsClient.getAgent(request);
    assertAgentDetails(agent);
  }

  @Test
  public void listAgentsTest() {
    ListAgentsRequest request = ListAgentsRequest.newBuilder().setParent(PARENT.toString()).build();
    Iterable<Agent> agents = agentsClient.listAgents(request).iterateAll();
    boolean isAgentExists = false;
    for (Agent agent : agents) {
      if (agentName.equals(agent.getName())) {
        assertAgentDetails(agent);
        isAgentExists = true;
      }
    }
    assertTrue(isAgentExists);
  }

  @Test
  public void exportAgentTest() throws ExecutionException, InterruptedException {
    ExportAgentRequest request = ExportAgentRequest.newBuilder().setName(agentName).build();
    ExportAgentResponse exportAgentResponse = agentsClient.exportAgentAsync(request).get();
    assertNotNull(exportAgentResponse.getAgentContent());
    assertTrue(exportAgentResponse.getAgentContent().toStringUtf8().contains(agentName));
  }

  @Test
  public void restoreAgentTest() throws ExecutionException, InterruptedException {
    Agent agent =
        Agent.newBuilder()
            .setDisplayName("test_agent_" + UUID.randomUUID().toString())
            .setDescription(DESCRIPTION)
            .setTimeZone(AGENT_TIME_ZONE)
            .setDefaultLanguageCode(DEFAULT_LANGUAGE_CODE)
            .setEnableStackdriverLogging(true)
            .setEnableSpellCorrection(true)
            .build();
    Agent response = agentsClient.createAgent(PARENT, agent);
    String agentName = response.getName();
    try {
      /* Replaces the current agent with a new one. Note that all existing resources in agent (e.g.
       * intents, entity types, flows) will be removed
       */
      RestoreAgentRequest restoreAgentRequest =
          RestoreAgentRequest.newBuilder().setName(agentName).build();
      OperationFuture<Empty, Struct> operationFuture =
          agentsClient.restoreAgentAsync(restoreAgentRequest);
      assertNotEquals(agentName, operationFuture.getName());
    } finally {
      DeleteAgentRequest deleteAgentRequest =
          DeleteAgentRequest.newBuilder().setName(agentName).build();
      agentsClient.deleteAgent(deleteAgentRequest);
    }
  }

  @Test
  public void getEntityTypeTest() {
    GetEntityTypeRequest request =
        GetEntityTypeRequest.newBuilder().setName(entityTypesName).build();
    EntityType entityType = entityTypesClient.getEntityType(request);
    assertEntityTypesDetails(entityType);
  }

  @Test
  public void listEntityTypesTest() {
    ListEntityTypesRequest request =
        ListEntityTypesRequest.newBuilder().setParent(agentName).build();
    Iterable<EntityType> entityTypes = entityTypesClient.listEntityTypes(request).iterateAll();
    boolean isEntityTypeExists = false;
    for (EntityType entityType : entityTypes) {
      if (entityTypesName.equals(entityType.getName())) {
        assertEntityTypesDetails(entityType);
        isEntityTypeExists = true;
      }
    }
    assertTrue(isEntityTypeExists);
  }

  @Test
  public void updateEntityTypeTest() {
    EntityType entityType =
        EntityType.newBuilder()
            .setName(entityTypesName)
            .setKind(EntityType.Kind.KIND_LIST)
            .setDisplayName(DISPLAY_NAME)
            .setKindValue(2)
            .build();
    UpdateEntityTypeRequest updateEntityTypeRequest =
        UpdateEntityTypeRequest.newBuilder().setEntityType(entityType).build();
    EntityType response = entityTypesClient.updateEntityType(updateEntityTypeRequest);
    assertEquals(2, response.getKindValue());
  }

  @Test
  public void getFlowTest() {
    GetFlowRequest request = GetFlowRequest.newBuilder().setName(flowName).build();
    Flow flow = flowsClient.getFlow(request);
    assertFlowDetails(flow);
  }

  @Test
  public void listFlowsTest() {
    ListFlowsRequest request = ListFlowsRequest.newBuilder().setParent(agentName).build();
    FlowsClient.ListFlowsPagedResponse pagedListResponse = flowsClient.listFlows(request);
    List<Flow> flows = Lists.newArrayList(pagedListResponse.iterateAll());
    boolean isFlowExists = false;
    for (Flow flow : flows) {
      if (flow.getName().equals(flowName)) {
        assertFlowDetails(flow);
        isFlowExists = true;
      }
    }
    assertTrue(isFlowExists);
  }

  @Test
  public void trainFlowTest() throws ExecutionException, InterruptedException {
    Empty expectedResponse = Empty.newBuilder().build();
    Empty response = flowsClient.trainFlowAsync(flowName).get();
    assertEquals(expectedResponse, response);
  }

  @Test
  public void getIntentsTest() {
    GetIntentRequest request = GetIntentRequest.newBuilder().setName(intentsName).build();
    Intent intent = intentsClient.getIntent(request);
    assertIntentDetails(intent);
  }

  @Test
  public void listIntentsTest() {
    ListIntentsRequest request = ListIntentsRequest.newBuilder().setParent(agentName).build();
    IntentsClient.ListIntentsPagedResponse pagedListResponse = intentsClient.listIntents(request);
    List<Intent> intents = Lists.newArrayList(pagedListResponse.iterateAll());
    boolean isIntentExists = false;
    for (Intent intent : intents) {
      if (intent.getName().equals(intentsName)) {
        assertIntentDetails(intent);
        isIntentExists = true;
      }
    }
    assertTrue(isIntentExists);
  }

  @Test
  public void updateIntentTest() {
    Intent intent =
        Intent.newBuilder()
            .setName(intentsName)
            .setDisplayName(DISPLAY_NAME)
            .setPriority(50)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();
    Intent intentResponse = intentsClient.updateIntent(intent, updateMask);
    assertEquals(50, intentResponse.getPriority());
  }

  @Test
  public void getPageTest() {
    GetPageRequest request = GetPageRequest.newBuilder().setName(pageName).build();
    Page page = pagesClient.getPage(request);
    assertPageDetails(page);
  }

  @Test
  public void listPagesTest() {
    ListPagesRequest request = ListPagesRequest.newBuilder().setParent(flowName).build();
    PagesClient.ListPagesPagedResponse pagedListResponse = pagesClient.listPages(request);
    List<Page> pages = Lists.newArrayList(pagedListResponse.iterateAll());
    boolean isPageExists = false;
    for (Page page : pages) {
      if (page.getName().equals(pageName)) {
        assertPageDetails(page);
        isPageExists = true;
      }
    }
    assertTrue(isPageExists);
  }

  @Test
  public void updatePageTest() {
    Page page =
        Page.newBuilder()
            .setName(pageName)
            .setForm(Form.getDefaultInstance())
            .setDisplayName(DISPLAY_NAME)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();
    Page updatedPage = pagesClient.updatePage(page, updateMask);
    assertPageDetails(updatedPage);
  }

  @Test
  public void detectIntentTest() {
    String session = String.format("%s/sessions/%s", agentName, ID);
    DetectIntentRequest request =
        DetectIntentRequest.newBuilder().setSession(session).setQueryInput(QUERY_INPUT).build();
    DetectIntentResponse detectIntent = sessionsClient.detectIntent(request);
    assertTrue(detectIntent.getQueryResult().getText().contains(TEXT));
  }

  @Test
  public void matchIntentTest() {
    String session = String.format("%s/sessions/%s", agentName, ID);
    MatchIntentRequest request =
        MatchIntentRequest.newBuilder().setSession(session).setQueryInput(QUERY_INPUT).build();
    MatchIntentResponse matchIntentResponse = sessionsClient.matchIntent(request);
    assertTrue(matchIntentResponse.getMatchesList().size() > 0);
    assertEquals(TEXT, matchIntentResponse.getText());
  }

  @Test
  public void getTransitionRouteGroupTest() {
    GetTransitionRouteGroupRequest routeGroupRequest =
        GetTransitionRouteGroupRequest.newBuilder().setName(transitionRouteGroupName).build();
    TransitionRouteGroup transitionRouteGroup =
        transitionRouteGroupsClient.getTransitionRouteGroup(routeGroupRequest);
    assertTransitionRouteGroupsDetails(transitionRouteGroup);
  }

  @Test
  public void listTransitionRouteGroupsTest() {
    ListTransitionRouteGroupsRequest routeGroupsRequest =
        ListTransitionRouteGroupsRequest.newBuilder().setParent(flowName).build();
    TransitionRouteGroupsClient.ListTransitionRouteGroupsPagedResponse pagedListResponse =
        transitionRouteGroupsClient.listTransitionRouteGroups(routeGroupsRequest);
    List<TransitionRouteGroup> routeGroups = Lists.newArrayList(pagedListResponse.iterateAll());
    boolean isTransitionRouteGroupNameExists = false;
    for (TransitionRouteGroup routeGroup : routeGroups) {
      if (routeGroup.getName().equals(transitionRouteGroupName)) {
        assertTransitionRouteGroupsDetails(routeGroup);
        isTransitionRouteGroupNameExists = true;
      }
    }
    assertTrue(isTransitionRouteGroupNameExists);
  }

  @Test
  public void updateTransitionRouteGroupTest() {
    String updatedDisplayName = DISPLAY_NAME + "-" + ID;
    TransitionRouteGroup transitionRouteGroup =
        TransitionRouteGroup.newBuilder()
            .setName(transitionRouteGroupName)
            .setDisplayName(updatedDisplayName)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();
    UpdateTransitionRouteGroupRequest routeGroupRequest =
        UpdateTransitionRouteGroupRequest.newBuilder()
            .setTransitionRouteGroup(transitionRouteGroup)
            .setUpdateMask(updateMask)
            .build();
    TransitionRouteGroup updatedTransitionRouteGroup =
        transitionRouteGroupsClient.updateTransitionRouteGroup(routeGroupRequest);
    assertEquals(updatedDisplayName, updatedTransitionRouteGroup.getDisplayName());
  }

  @Test
  public void getVersionTest() {
    GetVersionRequest versionRequest = GetVersionRequest.newBuilder().setName(versionName).build();
    Version version = versionsClient.getVersion(versionRequest);
    assertVersionDetails(version);
  }

  @Test
  public void listVersionsTest() {
    ListVersionsRequest versionsRequest =
        ListVersionsRequest.newBuilder().setParent(flowName).build();
    VersionsClient.ListVersionsPagedResponse pagedListResponse =
        versionsClient.listVersions(versionsRequest);
    List<Version> versions = Lists.newArrayList(pagedListResponse.iterateAll());
    boolean isVersionNameExists = false;
    for (Version version : versions) {
      if (version.getName().equals(versionName)) {
        assertVersionDetails(version);
        isVersionNameExists = true;
      }
    }
    assertTrue(isVersionNameExists);
  }

  @Test
  public void updateVersionTest() {
    Version version =
        Version.newBuilder()
            .setName(versionName)
            .setDisplayName(DISPLAY_NAME)
            .setState(Version.State.SUCCEEDED)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();
    UpdateVersionRequest versionRequest =
        UpdateVersionRequest.newBuilder().setVersion(version).setUpdateMask(updateMask).build();
    Version updatedVersion = versionsClient.updateVersion(versionRequest);
    assertEquals(Version.State.SUCCEEDED, updatedVersion.getState());
  }

  @Test
  public void loadVersionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Empty actualResponse = versionsClient.loadVersionAsync(versionName).get();
    assertEquals(expectedResponse, actualResponse);
  }

  private void assertAgentDetails(Agent agent) {
    assertEquals(agentName, agent.getName());
    assertEquals(DISPLAY_NAME, agent.getDisplayName());
    assertEquals(DEFAULT_LANGUAGE_CODE, agent.getDefaultLanguageCode());
    assertEquals(AGENT_TIME_ZONE, agent.getTimeZone());
    assertEquals(DESCRIPTION, agent.getDescription());
    assertTrue(agent.getEnableStackdriverLogging());
  }

  private void assertEntityTypesDetails(EntityType entityType) {
    assertEquals(entityTypesName, entityType.getName());
    assertEquals(
        EntityType.AutoExpansionMode.AUTO_EXPANSION_MODE_DEFAULT,
        entityType.getAutoExpansionMode());
    assertEquals(1, entityType.getAutoExpansionModeValue());
    assertEquals(DISPLAY_NAME, entityType.getDisplayName());
    assertEquals(EntityType.Kind.KIND_LIST, entityType.getKind());
    assertTrue(entityType.getEnableFuzzyExtraction());
  }

  private void assertFlowDetails(Flow flow) {
    assertEquals(flowName, flow.getName());
    assertEquals(DISPLAY_NAME, flow.getDisplayName());
    assertEquals(DESCRIPTION, flow.getDescription());
    assertEquals(NLUSETTINGS.getModelType(), flow.getNluSettings().getModelType());
    assertEquals(
        NLUSETTINGS.getClassificationThreshold(),
        flow.getNluSettings().getClassificationThreshold(),
        0);
    assertEquals(NLUSETTINGS.getModelTrainingMode(), flow.getNluSettings().getModelTrainingMode());
  }

  private void assertIntentDetails(Intent intent) {
    assertEquals(intentsName, intent.getName());
    assertEquals(DISPLAY_NAME, intent.getDisplayName());
    assertEquals(1, intent.getPriority());
  }

  private void assertPageDetails(Page page) {
    assertEquals(pageName, page.getName());
    assertEquals(DISPLAY_NAME, page.getDisplayName());
  }

  private void assertTransitionRouteGroupsDetails(TransitionRouteGroup transitionRouteGroup) {
    assertEquals(transitionRouteGroupName, transitionRouteGroup.getName());
    assertTrue(transitionRouteGroup.getDisplayName().contains(DISPLAY_NAME));
  }

  private void assertVersionDetails(Version version) {
    assertEquals(versionName, version.getName());
    assertEquals(DISPLAY_NAME, version.getDisplayName());
    assertEquals(NLUSETTINGS.getModelType(), version.getNluSettings().getModelType());
    assertEquals(
        NLUSETTINGS.getClassificationThreshold(),
        version.getNluSettings().getClassificationThreshold(),
        0);
    assertEquals(
        NLUSETTINGS.getModelTrainingMode(), version.getNluSettings().getModelTrainingMode());
    assertEquals(2, version.getStateValue());
  }
}
