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
import com.google.cloud.dialogflow.v2.EntityType.Kind;
import com.google.cloud.dialogflow.v2.EntityTypeName;
import com.google.cloud.dialogflow.v2.EntityTypesClient;
import com.google.cloud.dialogflow.v2.ProjectAgentName;

import java.util.ArrayList;
import java.util.List;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;


/**
 * DialogFlow API EntityType sample.
 */
public class EntityTypeManagement {

  // [START dialogflow_list_entity_types]
  /**
   * List entity types
   * @param projectId Project/agent id.
   */
  public static void listEntityTypes(String projectId) throws Exception {
    // Instantiates a client
    try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
      // Set the project agent name using the projectID (my-project-id)
      ProjectAgentName parent = ProjectAgentName.of(projectId);

      // Performs the list entity types request
      for (EntityType entityType : entityTypesClient.listEntityTypes(parent).iterateAll()) {
        System.out.format("Entity type name %s\n", entityType.getName());
        System.out.format("Entity type display name: %s\n", entityType.getDisplayName());
        System.out.format("Number of entities: %d\n", entityType.getEntitiesCount());
      }
    }
  }
  // [END dialogflow_list_entity_types]

  // [START dialogflow_create_entity_type]
  /**
   * Create an entity type with the given display name
   * @param displayName The display name of the entity.
   * @param projectId Project/agent id.
   * @param kind The kind of entity.  KIND_MAP (default) or KIND_LIST.
   */
  public static void createEntityType(String displayName, String projectId, String kind)
      throws Exception {
    // Instantiates a client
    try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
      // Set the project agent name using the projectID (my-project-id)
      ProjectAgentName parent = ProjectAgentName.of(projectId);

      // Entity types serve as a tool for extracting parameter values from natural language queries.
      EntityType entityType = EntityType.newBuilder()
          .setDisplayName(displayName)
          .setKind(Kind.valueOf(kind))
          .build();

      // Performs the create entity type request
      EntityType response = entityTypesClient.createEntityType(parent, entityType);
      System.out.println("Entity type created: " + response);
    }
  }
  // [END dialogflow_create_entity_type]

  // [START dialogflow_delete_entity_type]
  /**
   * Delete entity type with the given entity type name
   * @param entityTypeId The id of the entity_type.
   * @param projectId Project/agent id.
   */
  public static void deleteEntityType(String entityTypeId, String projectId) throws Exception {
    // Instantiates a client
    try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
      // Set the entity type name using the projectID (my-project-id) and entityTypeId (KIND_LIST)
      EntityTypeName name = EntityTypeName.of(projectId, entityTypeId);

      // Performs the delete entity type request
      entityTypesClient.deleteEntityType(name);
    }
  }
  // [END dialogflow_delete_entity_type]

  /**
   * Helper method for testing to get entityTypeId from displayName.
   */
  public static List<String> getEntityTypeIds(String displayName, String projectId)
      throws Exception {
    List<String> entityTypesIds = new ArrayList<>();

    try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
      ProjectAgentName parent = ProjectAgentName.of(projectId);
      // Performs the list entity types request
      for (EntityType entityType : entityTypesClient.listEntityTypes(parent).iterateAll()) {
        if (entityType.getDisplayName().equals(displayName)) {
          String[] splitName = entityType.getName().split("/");
          entityTypesIds.add(splitName[splitName.length - 1]);
        }
      }
    }
    return entityTypesIds;
  }


  public static void main(String[] args) throws Exception {
    ArgumentParser parser =
        ArgumentParsers.newFor("EntityTypeManagement")
            .build()
            .defaultHelp(true)
            .description("Create / List / Delete a Entity Type.");

    Subparsers subparsers = parser.addSubparsers().dest("command").title("Commands");

    Subparser listParser = subparsers.addParser("list")
        .help("mvn exec:java -DEntityTypeManagement -Dexec.args='list --projectId PROJECT_ID'");
    listParser.addArgument("--projectId").help("Project/Agent Id").required(true);

    Subparser createParser = subparsers.addParser("create")
        .help("mvn exec:java -DEntityTypeManagement -Dexec.args='create DISPLAY_NAME "
            + "--projectId PROJECT_ID --entityTypeId ENTITY_TYPE_ID "
            + "--synonyms basement cellar'");
    createParser.addArgument("displayName")
        .help("The display name of the entity.").required(true);
    createParser.addArgument("--projectId").help("Project/Agent Id").required(true);
    createParser.addArgument("--kind")
        .help("The kind of entity. KIND_MAP (default) or KIND_LIST.").setDefault("KIND_MAP");

    Subparser deleteParser = subparsers.addParser("delete")
        .help("mvn exec:java -DEntityTypeManagement -Dexec.args='delete ENTITY_TYPE_ID "
            + "--projectId PROJECT_ID'");
    deleteParser.addArgument("entityTypeId")
        .help("The id of the entityType to delete.").required(true);
    deleteParser.addArgument("--projectId").help("Project/Agent Id").required(true);


    try {
      Namespace namespace = parser.parseArgs(args);

      if (namespace.get("command").equals("list")) {
        listEntityTypes(namespace.get("projectId"));
      } else if (namespace.get("command").equals("create")) {
        createEntityType(namespace.get("displayName"), namespace.get("projectId"),
            namespace.get("kind"));
      } else if (namespace.get("command").equals("delete")) {
        deleteEntityType(namespace.get("entityTypeId"), namespace.get("projectId"));
      }
    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
