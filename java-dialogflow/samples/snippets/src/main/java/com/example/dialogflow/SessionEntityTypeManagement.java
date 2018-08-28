/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.dialogflow;

// Imports the Google Cloud client library
import com.google.cloud.dialogflow.v2.EntityType.Entity;
import com.google.cloud.dialogflow.v2.SessionEntityType;
import com.google.cloud.dialogflow.v2.SessionEntityType.EntityOverrideMode;
import com.google.cloud.dialogflow.v2.SessionEntityTypeName;
import com.google.cloud.dialogflow.v2.SessionEntityTypesClient;
import com.google.cloud.dialogflow.v2.SessionName;

import java.util.ArrayList;
import java.util.List;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;

/**
 * DialogFlow API SessionEntityType sample.
 */
public class SessionEntityTypeManagement {

  // [START dialogflow_list_session_entity_types]
  /**
   * List session entity types
   * @param projectId Project/Agent Id.
   * @param sessionId Identifier of the DetectIntent session.
   */
  public static void listSessionEntityTypes(String projectId, String sessionId) throws Exception {
    // Instantiates a client
    try (SessionEntityTypesClient sessionEntityTypesClient = SessionEntityTypesClient.create()) {
      // Set the session name using the sessionId (UUID) and projectID (my-project-id)
      SessionName session = SessionName.of(projectId, sessionId);

      System.out.format("SessionEntityTypes for session %s:\n", session.toString());
      // Performs the list session entity types request
      for (SessionEntityType sessionEntityType :
          sessionEntityTypesClient.listSessionEntityTypes(session).iterateAll()) {
        System.out.format("\tSessionEntityType name: %s\n", sessionEntityType.getName());
        System.out.format("\tNumber of entities: %d\n", sessionEntityType.getEntitiesCount());
      }
    }
  }
  // [END dialogflow_list_session_entity_types]

  // [START dialogflow_create_session_entity_type]
  /**
   * Create an entity type with the given display name
   * @param projectId Project/Agent Id.
   * @param sessionId Identifier of the DetectIntent session.
   * @param entityValues The entity values of the session entity type.
   * @param entityTypeDisplayName DISPLAY NAME of the entity type to be overridden in the session.
   * @param entityOverrideMode ENTITY_OVERRIDE_MODE_OVERRIDE (default) or
   *                           ENTITY_OVERRIDE_MODE_SUPPLEMENT
   */
  public static void createSessionEntityType(String projectId, String sessionId,
      List<String> entityValues, String entityTypeDisplayName,int entityOverrideMode)
      throws Exception {
    // Instantiates a client
    try (SessionEntityTypesClient sessionEntityTypesClient = SessionEntityTypesClient.create()) {
      // Set the session name using the sessionId (UUID) and projectID (my-project-id)
      SessionName session = SessionName.of(projectId, sessionId);
      SessionEntityTypeName name = SessionEntityTypeName.of(projectId, sessionId,
          entityTypeDisplayName);

      List<Entity> entities = new ArrayList<>();
      for (String entityValue : entityValues) {
        entities.add(Entity.newBuilder()
            .setValue(entityValue)
            .addSynonyms(entityValue)
            .build());
      }

      // Extends or replaces a developer entity type at the user session level (we refer to the
      // entity types defined at the agent level as "developer entity types").
      SessionEntityType sessionEntityType = SessionEntityType.newBuilder()
          .setName(name.toString())
          .addAllEntities(entities)
          .setEntityOverrideMode(EntityOverrideMode.forNumber(entityOverrideMode))
          .build();

      // Performs the create session entity type request
      SessionEntityType response = sessionEntityTypesClient.createSessionEntityType(session,
          sessionEntityType);

      System.out.format("SessionEntityType created: %s\n", response);
    }
  }
  // [END dialogflow_create_session_entity_type]

  // [START dialogflow_delete_session_entity_type]
  /**
   * Delete entity type with the given entity type name
   * @param projectId Project/Agent Id.
   * @param sessionId Identifier of the DetectIntent session.
   * @param entityTypeDisplayName DISPLAY NAME of the entity type to be overridden in the session.
   */
  public static void deleteSessionEntityType(String projectId, String sessionId,
      String entityTypeDisplayName) throws Exception {
    // Instantiates a client
    try (SessionEntityTypesClient sessionEntityTypesClient = SessionEntityTypesClient.create()) {
      SessionEntityTypeName name = SessionEntityTypeName.of(projectId, sessionId,
          entityTypeDisplayName);

      // Performs the delete session entity type request
      sessionEntityTypesClient.deleteSessionEntityType(name);
    }
  }
  // [END dialogflow_delete_session_entity_type]

  public static void main(String[] args) throws Exception {
    ArgumentParser parser =
        ArgumentParsers.newFor("SessionEntityTypeManagement")
            .build()
            .defaultHelp(true)
            .description("Create / List / Delete a SessionEntityType.");

    Subparsers subparsers = parser.addSubparsers().dest("command").title("Commands");

    Subparser listParser = subparsers.addParser("list")
        .help("mvn exec:java -DSessionEntityTypeManagement -Dexec.args='list "
            + "--projectId PROJECT_ID --sessionId SESSION_ID '");
    listParser.addArgument("--projectId").help("Project/Agent Id").required(true);
    listParser.addArgument("--sessionId")
        .help("Identifier of the DetectIntent session").required(true);

    Subparser createParser = subparsers.addParser("create")
        .help("mvn exec:java -DSessionEntityTypeManagement -Dexec.args='create "
            + "--projectId PROJECT_ID --sessionId SESSION_ID "
            + "--entityTypeDisplayName ENTITY_TYPE_DISPLAY_NAME "
            + "--entityOverrideMode ENTITY_OVERRIDE_MODE_OVERRIDE "
            + "--entityValues C D E F'");
    createParser.addArgument("--projectId").help("Project/Agent Id").required(true);
    createParser.addArgument("--sessionId")
        .help("Identifier of the DetectIntent session").required(true);
    createParser.addArgument("--entityTypeDisplayName")
        .help("The DISPLAY NAME of the entity type to be overridden in the session.t")
        .required(true);
    createParser.addArgument("--entityOverrideMode")
        .help("ENTITY_OVERRIDE_MODE_OVERRIDE (default) or ENTITY_OVERRIDE_MODE_SUPPLEMENT")
        .setDefault(1);
    createParser.addArgument("--entityValues").nargs("+")
        .help("The entity values of the session entity type.");

    Subparser deleteParser = subparsers.addParser("delete")
        .help("mvn exec:java -DSessionEntityTypeManagement -Dexec.args='delete "
            + "--sessionId SESSION_ID --projectId PROJECT_ID --contextId CONTEXT_ID'");
    deleteParser.addArgument("--projectId").help("Project/Agent Id").required(true);
    deleteParser.addArgument("--sessionId")
        .help("Identifier of the DetectIntent session").required(true);
    deleteParser.addArgument("--entityTypeDisplayName")
        .help("The DISPLAY NAME of the entity type to be overridden in the session.t")
        .required(true);

    try {
      Namespace namespace = parser.parseArgs(args);

      if (namespace.get("command").equals("list")) {
        listSessionEntityTypes(namespace.get("projectId"), namespace.get("sessionId"));
      } else if (namespace.get("command").equals("create")) {
        ArrayList<String> entityValues = new ArrayList<>();
        if (namespace.get("entityValues") != null) {
          entityValues = namespace.get("entityValues");
        }
        createSessionEntityType(namespace.get("projectId"), namespace.get("sessionId"),
            entityValues, namespace.get("entityTypeDisplayName"),
            namespace.get("entityOverrideMode"));
      } else if (namespace.get("command").equals("delete")) {
        deleteSessionEntityType(namespace.get("projectId"), namespace.get("sessionId"),
            namespace.get("entityTypeDisplayName"));
      }
    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
