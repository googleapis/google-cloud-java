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

import com.google.cloud.dialogflow.v2.EntityType;
import com.google.cloud.dialogflow.v2.EntityType.Entity;
import com.google.cloud.dialogflow.v2.EntityTypeName;
import com.google.cloud.dialogflow.v2.EntityTypesClient;
import com.google.protobuf.Empty;

import java.util.Collections;
import java.util.List;

/**
 * DialogFlow API Entity sample.
 */
public class EntityManagement {
  // [START dialogflow_list_entities]

  /**
   * List entities
   *
   * @param projectId    Project/agent id.
   * @param entityTypeId The id of the entity_type.
   * @return List of found entities.
   */
  public static List<Entity> listEntities(String projectId, String entityTypeId) throws Exception {
    // Instantiates a client
    try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
      // Set the entity type name using the projectID (my-project-id) and entityTypeId (KIND_LIST)
      EntityTypeName name = EntityTypeName.of(projectId, entityTypeId);

      // Performs the get entity type request
      EntityType entityType = entityTypesClient.getEntityType(name);
      List<Entity> entities = entityType.getEntitiesList();
      for (Entity entity : entities) {
        System.out.format("Entity value: %s\n", entity.getValue());
        System.out.format("Entity synonyms: %s\n", entity.getSynonymsList().toString());
      }
      return entities;
    }
  }
  // [END dialogflow_list_entities]

  // [START dialogflow_create_entity]

  /**
   * Create an entity of the given entity type
   *
   * @param projectId    Project/agent id.
   * @param entityTypeId The id of the entity_type.
   * @param entityValue  The entity value to be added.
   * @param synonyms     The synonyms that will map to the provided entity value.
   */
  public static void createEntity(
      String projectId,
      String entityTypeId,
      String entityValue,
      List<String> synonyms) throws Exception {
    // Note: synonyms must be exactly [entityValue] if the
    // entityTypeId's kind is KIND_LIST
    if (synonyms.size() == 0) {
      synonyms.add(entityValue);
    }

    // Instantiates a client
    try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
      // Set the entity type name using the projectID (my-project-id) and entityTypeId (KINDS_LIST)
      EntityTypeName name = EntityTypeName.of(projectId, entityTypeId);

      // Build the entity
      Entity entity = Entity.newBuilder()
          .setValue(entityValue)
          .addAllSynonyms(synonyms)
          .build();

      // Performs the create entity type request
      Empty response = entityTypesClient.batchCreateEntitiesAsync(name,
          Collections.singletonList(entity)).get();
      System.out.println("Entity created: " + response);
    }
  }
  // [END dialogflow_create_entity]

  // [START dialogflow_delete_entity]

  /**
   * Delete entity with the given entity type and entity value
   *
   * @param projectId    Project/agent id.
   * @param entityTypeId The id of the entity_type.
   * @param entityValue  The value of the entity to delete.
   */
  public static void deleteEntity(String projectId, String entityTypeId, String entityValue)
      throws Exception {
    // Instantiates a client
    try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
      // Set the entity type name using the projectID (my-project-id) and entityTypeId (KINDS_LIST)
      EntityTypeName name = EntityTypeName.of(projectId, entityTypeId);

      // Performs the delete entity type request
      entityTypesClient.batchDeleteEntitiesAsync(name, Collections.singletonList(entityValue))
          .getInitialFuture().get();
    }
  }
  // [END dialogflow_delete_entity]
}
