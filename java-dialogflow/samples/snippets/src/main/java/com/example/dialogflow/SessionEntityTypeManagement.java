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
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * DialogFlow API SessionEntityType sample.
 */
public class SessionEntityTypeManagement {
  // [START dialogflow_list_session_entity_types]

  /**
   * List session entity types
   *
   * @param projectId Project/Agent Id.
   * @param sessionId Identifier of the DetectIntent session.
   * @return SessionEntityTypes found.
   */
  public static List<SessionEntityType> listSessionEntityTypes(String projectId, String sessionId)
      throws Exception {
    List<SessionEntityType> sessionEntityTypes = Lists.newArrayList();
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

        sessionEntityTypes.add(sessionEntityType);
      }
    }
    return sessionEntityTypes;
  }
  // [END dialogflow_list_session_entity_types]

  // [START dialogflow_create_session_entity_type]

  /**
   * Create an entity type with the given display name
   *
   * @param projectId             Project/Agent Id.
   * @param sessionId             Identifier of the DetectIntent session.
   * @param entityValues          The entity values of the session entity type.
   * @param entityTypeDisplayName DISPLAY NAME of the entity type to be overridden in the session.
   * @param entityOverrideMode    ENTITY_OVERRIDE_MODE_OVERRIDE (default) or
   *                              ENTITY_OVERRIDE_MODE_SUPPLEMENT
   * @return Created SessionEntityType.
   */
  public static SessionEntityType createSessionEntityType(
      String projectId,
      String sessionId,
      List<String> entityValues,
      String entityTypeDisplayName,
      int entityOverrideMode) throws Exception {
    // Instantiates a client
    try (SessionEntityTypesClient sessionEntityTypesClient = SessionEntityTypesClient.create()) {
      // Set the session name using the sessionId (UUID) and projectID (my-project-id)
      SessionName session = SessionName.of(projectId, sessionId);
      SessionEntityTypeName name = SessionEntityTypeName.of(
          projectId, sessionId, entityTypeDisplayName);

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

      return response;
    }
  }
  // [END dialogflow_create_session_entity_type]

  // [START dialogflow_delete_session_entity_type]

  /**
   * Delete entity type with the given entity type name
   *
   * @param projectId             Project/Agent Id.
   * @param sessionId             Identifier of the DetectIntent session.
   * @param entityTypeDisplayName DISPLAY NAME of the entity type to be overridden in the session.
   */
  public static void deleteSessionEntityType(
      String projectId,
      String sessionId,
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
}
