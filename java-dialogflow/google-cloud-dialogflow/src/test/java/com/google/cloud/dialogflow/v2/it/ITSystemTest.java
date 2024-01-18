/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.dialogflow.v2.it;

import static org.junit.Assert.assertEquals;

import com.google.cloud.ServiceOptions;
import com.google.cloud.dialogflow.v2.Agent;
import com.google.cloud.dialogflow.v2.AgentsClient;
import com.google.cloud.dialogflow.v2.Context;
import com.google.cloud.dialogflow.v2.ContextName;
import com.google.cloud.dialogflow.v2.ContextsClient;
import com.google.cloud.dialogflow.v2.CreateContextRequest;
import com.google.cloud.dialogflow.v2.CreateEntityTypeRequest;
import com.google.cloud.dialogflow.v2.CreateIntentRequest;
import com.google.cloud.dialogflow.v2.DeleteContextRequest;
import com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest;
import com.google.cloud.dialogflow.v2.DeleteIntentRequest;
import com.google.cloud.dialogflow.v2.DetectIntentRequest;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.EntityType;
import com.google.cloud.dialogflow.v2.EntityTypeName;
import com.google.cloud.dialogflow.v2.EntityTypesClient;
import com.google.cloud.dialogflow.v2.EventInput;
import com.google.cloud.dialogflow.v2.GetAgentRequest;
import com.google.cloud.dialogflow.v2.GetContextRequest;
import com.google.cloud.dialogflow.v2.GetIntentRequest;
import com.google.cloud.dialogflow.v2.Intent;
import com.google.cloud.dialogflow.v2.IntentName;
import com.google.cloud.dialogflow.v2.IntentsClient;
import com.google.cloud.dialogflow.v2.ListContextsRequest;
import com.google.cloud.dialogflow.v2.ListEntityTypesRequest;
import com.google.cloud.dialogflow.v2.ListIntentsRequest;
import com.google.cloud.dialogflow.v2.ProjectAgentName;
import com.google.cloud.dialogflow.v2.ProjectName;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.cloud.dialogflow.v2.SearchAgentsRequest;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import java.io.IOException;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {
  private static AgentsClient agentsClient;
  private static ContextsClient contextsClient;
  private static Context context;
  private static EntityTypesClient entityTypesClient;
  private static EntityType entityType;
  private static String entityName;
  private static EntityTypeName entityTypeName;
  private static IntentsClient intentsClient;
  private static Intent intent;
  private static String intentId;
  private static IntentName intentName;
  private static SessionsClient sessionsClient;
  private static final String ID = UUID.randomUUID().toString().substring(0, 8);
  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final ProjectName PROJECT_NAME = ProjectName.of(PROJECT_ID);
  private static final ProjectAgentName PROJECT_AGENT_NAME = ProjectAgentName.of(PROJECT_ID);
  private static final String DEFAULT_DISPLAY_NAME = "google-cloud-java-tests";
  private static final String LEGACY_AGENT_ENV_NAME = "dialogflow.agent";
  private static final String AGENT_ENV_NAME = "DIALOGFLOW_AGENT";
  private static final String DISPLAY_NAME = getDialogFlowAgentDisplayName();
  private static final String TIME_ZONE = "America/Los_Angeles";
  private static final String DEFAULT_LANGUAGE_CODE = "en";
  private static final String ENTITY_NAME = "test-entity-" + ID;
  private static final EntityType.Entity ENTITY =
      EntityType.Entity.newBuilder().addSynonyms("test-entity").setValue("test-entity").build();
  private static final String INTENT_NAME = "test-intent-" + ID;
  private static final String EVENT_NAME = "test-event-" + UUID.randomUUID().toString();
  private static final String ACTION_NAME = "test-action";
  private static final String SESSION_ID = UUID.randomUUID().toString();
  private static final SessionName SESSION_NAME = SessionName.of(PROJECT_ID, SESSION_ID);
  private static final String CONTEXT_ID = "test-context-" + ID;
  private static final ContextName CONTEXT_NAME =
      ContextName.of(PROJECT_ID, SESSION_ID, CONTEXT_ID);
  private static final Integer LIFE_SPAN_COUNT = 10;

  @BeforeClass
  public static void setUp() throws IOException {

    agentsClient = AgentsClient.create();

    /* create entity */
    entityTypesClient = EntityTypesClient.create();
    EntityType createEntityType =
        EntityType.newBuilder()
            .setDisplayName(ENTITY_NAME)
            .setKind(EntityType.Kind.KIND_LIST)
            .addEntities(ENTITY)
            .build();
    CreateEntityTypeRequest entityTypeRequest =
        CreateEntityTypeRequest.newBuilder()
            .setParent(PROJECT_AGENT_NAME.toString())
            .setEntityType(createEntityType)
            .build();
    entityType = entityTypesClient.createEntityType(entityTypeRequest);
    entityName =
        entityType.getName().substring(entityType.getName().lastIndexOf("/")).replace("/", "");
    entityTypeName = EntityTypeName.of(PROJECT_ID, entityName);

    /* create intents */
    intentsClient = IntentsClient.create();
    Intent createIntent =
        Intent.newBuilder()
            .setDisplayName(INTENT_NAME)
            .addEvents(EVENT_NAME)
            .setAction(ACTION_NAME)
            .build();
    CreateIntentRequest intentRequest =
        CreateIntentRequest.newBuilder()
            .setParent(PROJECT_AGENT_NAME.toString())
            .setIntent(createIntent)
            .build();
    intent = intentsClient.createIntent(intentRequest);
    intentId = intent.getName().substring(intent.getName().lastIndexOf("/")).replace("/", "");
    intentName = IntentName.of(PROJECT_ID, intentId);

    /* create session */
    sessionsClient = SessionsClient.create();

    /* create context */
    contextsClient = ContextsClient.create();
    Context createContext =
        Context.newBuilder()
            .setName(CONTEXT_NAME.toString())
            .setLifespanCount(LIFE_SPAN_COUNT)
            .build();
    CreateContextRequest request =
        CreateContextRequest.newBuilder()
            .setParent(SESSION_NAME.toString())
            .setContext(createContext)
            .build();
    context = contextsClient.createContext(request);
  }

  @AfterClass
  public static void tearDown() {

    /* delete context */
    DeleteContextRequest deleteContextRequest =
        DeleteContextRequest.newBuilder().setName(CONTEXT_NAME.toString()).build();
    contextsClient.deleteContext(deleteContextRequest);
    contextsClient.close();

    /* delete session */
    sessionsClient.close();

    /* delete intents */
    DeleteIntentRequest deleteIntentRequest =
        DeleteIntentRequest.newBuilder().setName(intentName.toString()).build();
    intentsClient.deleteIntent(deleteIntentRequest);
    intentsClient.close();

    /* delete entity */
    DeleteEntityTypeRequest deleteEntityTypeRequest =
        DeleteEntityTypeRequest.newBuilder().setName(entityTypeName.toString()).build();
    entityTypesClient.deleteEntityType(deleteEntityTypeRequest);
    entityTypesClient.close();

    agentsClient.close();
  }

  @Test
  public void searchAgentsTest() {
    SearchAgentsRequest request =
        SearchAgentsRequest.newBuilder().setParent(PROJECT_NAME.toString()).build();
    for (Agent actualAgent : agentsClient.searchAgents(request).iterateAll()) {
      assertEquals(PROJECT_NAME.toString(), actualAgent.getParent());
      assertEquals(DISPLAY_NAME, actualAgent.getDisplayName());
      assertEquals(DEFAULT_LANGUAGE_CODE, actualAgent.getDefaultLanguageCode());
      assertEquals(TIME_ZONE, actualAgent.getTimeZone());
      assertEquals(Agent.MatchMode.MATCH_MODE_HYBRID, actualAgent.getMatchMode());
      assertEquals(Agent.ApiVersion.API_VERSION_V2, actualAgent.getApiVersion());
      assertEquals(Agent.Tier.TIER_STANDARD, actualAgent.getTier());
    }
  }

  @Test
  public void getAgentTest() {
    GetAgentRequest request =
        GetAgentRequest.newBuilder().setParent(PROJECT_NAME.toString()).build();
    Agent actualAgent = agentsClient.getAgent(request);
    assertEquals(PROJECT_NAME.toString(), actualAgent.getParent());
    assertEquals(DISPLAY_NAME, actualAgent.getDisplayName());
    assertEquals(DEFAULT_LANGUAGE_CODE, actualAgent.getDefaultLanguageCode());
    assertEquals(TIME_ZONE, actualAgent.getTimeZone());
    assertEquals(Agent.MatchMode.MATCH_MODE_HYBRID, actualAgent.getMatchMode());
    assertEquals(Agent.ApiVersion.API_VERSION_V2, actualAgent.getApiVersion());
    assertEquals(Agent.Tier.TIER_STANDARD, actualAgent.getTier());
  }

  @Test
  public void listEntityTypesTest() {
    ListEntityTypesRequest request =
        ListEntityTypesRequest.newBuilder().setParent(PROJECT_AGENT_NAME.toString()).build();
    for (EntityType actualEntity : entityTypesClient.listEntityTypes(request).iterateAll()) {
      if (entityType.getName().equals(actualEntity.getName())) {
        assertEquals(entityType.getName(), actualEntity.getName());
        assertEquals(ENTITY_NAME, actualEntity.getDisplayName());
        assertEquals(entityType.getEntities(0), actualEntity.getEntities(0));
        assertEquals(1, actualEntity.getEntitiesCount());
      }
    }
  }

  @Test
  public void getEntityTypeTest() {
    EntityType actualEntity = entityTypesClient.getEntityType(entityTypeName);
    assertEquals(entityType.getName(), actualEntity.getName());
    assertEquals(ENTITY_NAME, actualEntity.getDisplayName());
    assertEquals(entityType.getEntities(0), actualEntity.getEntities(0));
    assertEquals(1, actualEntity.getEntitiesCount());
  }

  @Test
  public void listIntentsTest() {
    ListIntentsRequest request =
        ListIntentsRequest.newBuilder().setParent(PROJECT_AGENT_NAME.toString()).build();
    for (Intent actualIntent : intentsClient.listIntents(request).iterateAll()) {
      if (intent.getName().equals(actualIntent.getName())) {
        assertEquals(intent.getDisplayName(), actualIntent.getDisplayName());
        assertEquals(intent.getAction(), actualIntent.getAction());
        assertEquals(intent.getEvents(0), actualIntent.getEvents(0));
        assertEquals(intent.getEventsCount(), actualIntent.getEventsCount());
      }
    }
  }

  @Test
  public void getIntentTest() {
    GetIntentRequest request = GetIntentRequest.newBuilder().setName(intentName.toString()).build();
    Intent actualIntent = intentsClient.getIntent(request);
    assertEquals(intent.getName(), actualIntent.getName());
    assertEquals(intent.getDisplayName(), actualIntent.getDisplayName());
    assertEquals(intent.getAction(), actualIntent.getAction());
    assertEquals(intent.getEvents(0), actualIntent.getEvents(0));
    assertEquals(intent.getEventsCount(), actualIntent.getEventsCount());
  }

  @Test
  public void detectIntentTest() {
    QueryInput queryInput =
        QueryInput.newBuilder()
            .setEvent(
                EventInput.newBuilder()
                    .setName(EVENT_NAME)
                    .setParameters(
                        Struct.newBuilder()
                            .putFields(
                                "action", Value.newBuilder().setStringValue(ACTION_NAME).build())
                            .build())
                    .setLanguageCode(DEFAULT_LANGUAGE_CODE)
                    .build())
            .build();
    DetectIntentRequest request =
        DetectIntentRequest.newBuilder()
            .setSession(SESSION_NAME.toString())
            .setQueryInput(queryInput)
            .build();
    DetectIntentResponse response = sessionsClient.detectIntent(request);
    QueryResult result = response.getQueryResult();
    assertEquals(EVENT_NAME, result.getQueryText());
    assertEquals(ACTION_NAME, result.getAction());
    assertEquals(DEFAULT_LANGUAGE_CODE, result.getLanguageCode());
    assertEquals(intent.getDisplayName(), result.getIntent().getDisplayName());
  }

  @Test
  public void listContextsTest() {
    ListContextsRequest request =
        ListContextsRequest.newBuilder().setParent(SESSION_NAME.toString()).build();
    for (Context actualContext : contextsClient.listContexts(request).iterateAll()) {
      assertEquals(context.getName(), actualContext.getName());
    }
  }

  @Test
  public void getContextTest() {
    GetContextRequest request =
        GetContextRequest.newBuilder().setName(CONTEXT_NAME.toString()).build();
    Context actualContext = contextsClient.getContext(request);
    assertEquals(context.getName(), actualContext.getName());
  }

  private static String getDialogFlowAgentDisplayName() {
    String name = System.getProperty(AGENT_ENV_NAME, System.getenv(AGENT_ENV_NAME));
    if (name != null) return name;

    name = System.getProperty(LEGACY_AGENT_ENV_NAME, System.getenv(LEGACY_AGENT_ENV_NAME));
    if (name != null) return name;

    return DEFAULT_DISPLAY_NAME;
  }
}
