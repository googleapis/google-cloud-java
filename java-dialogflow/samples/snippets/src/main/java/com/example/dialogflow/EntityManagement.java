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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;


/**
 * DialogFlow API Entity sample.
 */
public class EntityManagement {

  // [START dialogflow_list_entities]
  /**
   * List entities
   * @param projectId Project/agent id.
   * @param entityTypeId The id of the entity_type.
   */
  public static void listEntities(String projectId, String entityTypeId) throws Exception {
    // Instantiates a client
    try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
      // Set the entity type name using the projectID (my-project-id) and entityTypeId (KIND_LIST)
      EntityTypeName name = EntityTypeName.of(projectId, entityTypeId);

      // Performs the get entity type request
      EntityType entityType = entityTypesClient.getEntityType(name);
      for (Entity entity : entityType.getEntitiesList()) {
        System.out.format("Entity value: %s\n", entity.getValue());
        System.out.format("Entity synonyms: %s\n", entity.getSynonymsList().toString());
      }
    }
  }
  // [END dialogflow_list_entities]

  // [START dialogflow_create_entity]
  /**
   * Create an entity of the given entity type
   * @param projectId Project/agent id.
   * @param entityTypeId The id of the entity_type.
   * @param entityValue The entity value to be added.
   * @param synonyms The synonyms that will map to the provided entity value.
   */
  public static void createEntity(String projectId, String entityTypeId, String entityValue,
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
          Arrays.asList(entity)).get();
      System.out.println("Entity created: " + response);
    }


  }
  // [END dialogflow_create_entity]

  // [START dialogflow_delete_entity]
  /**
   * Delete entity with the given entity type and entity value
   * @param projectId Project/agent id.
   * @param entityTypeId The id of the entity_type.
   * @param entityValue The value of the entity to delete.
   */
  public static void deleteEntity(String projectId, String entityTypeId, String entityValue)
      throws Exception {
    // Instantiates a client
    try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
      // Set the entity type name using the projectID (my-project-id) and entityTypeId (KINDS_LIST)
      EntityTypeName name = EntityTypeName.of(projectId, entityTypeId);

      // Performs the delete entity type request
      entityTypesClient.batchDeleteEntitiesAsync(name, Arrays.asList(entityValue))
          .getInitialFuture().get();
    }
  }
  // [END dialogflow_delete_entity]

  public static void main(String[] args) throws Exception {
    ArgumentParser parser =
        ArgumentParsers.newFor("EntityManagement")
            .build()
            .defaultHelp(true)
            .description("Create / List / Delete a Entity.");

    Subparsers subparsers = parser.addSubparsers().dest("command").title("Commands");

    Subparser listParser = subparsers.addParser("list")
        .help("mvn exec:java -DEntityManagement -Dexec.args='list --projectId PROJECT_ID "
            + "--entityTypeId ENTITY_TYPE_ID'");
    listParser.addArgument("--projectId").help("Project/Agent Id").required(true);
    listParser.addArgument("--entityTypeId")
        .help("The id of the entityType to which to add an entity.").required(true);

    Subparser createParser = subparsers.addParser("create")
        .help("mvn exec:java -DEntityManagement -Dexec.args='create ENTITY_VALUE "
            + "--projectId PROJECT_ID --entityTypeId ENTITY_TYPE_ID "
            + "--synonyms basement cellar'");
    createParser.addArgument("entityValue")
        .help("The entity value to be added.").required(true);
    createParser.addArgument("--projectId").help("Project/Agent Id").required(true);
    createParser.addArgument("--entityTypeId")
        .help("The id of the entityType to which to add an entity.").required(true);
    createParser.addArgument("--synonyms").nargs("+")
        .help("The synonyms that will map to the provided entity value");

    Subparser deleteParser = subparsers.addParser("delete")
        .help("mvn exec:java -DEntityManagement -Dexec.args='delete ENTITY_VALUE "
            + "--projectId PROJECT_ID  --entityTypeId ENTITY_TYPE_ID'");
    deleteParser.addArgument("entityValue")
        .help("The entity value to be added.").required(true);
    deleteParser.addArgument("--projectId").help("Project/Agent Id").required(true);
    deleteParser.addArgument("--entityTypeId")
        .help("The id of the entityType to delete.").required(true);

    try {
      Namespace namespace = parser.parseArgs(args);

      if (namespace.get("command").equals("list")) {
        listEntities(namespace.get("projectId"), namespace.get("entityTypeId"));
      } else if (namespace.get("command").equals("create")) {
        ArrayList<String> synonyms = new ArrayList<>();
        if (namespace.get("synonyms") == null) {
          synonyms = namespace.get("synonyms");
        }
        createEntity(namespace.get("projectId"), namespace.get("entityTypeId"),
            namespace.get("entityValue"), synonyms);
      } else if (namespace.get("command").equals("delete")) {
        deleteEntity(namespace.get("projectId"), namespace.get("entityTypeId"),
            namespace.get("entityValue"));
      }
    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
