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

import com.google.cloud.dialogflow.v2beta1.KnowledgeBase;
import com.google.cloud.dialogflow.v2beta1.KnowledgeBaseName;
import com.google.cloud.dialogflow.v2beta1.KnowledgeBasesClient;
import com.google.cloud.dialogflow.v2beta1.ProjectName;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;

public class KnowledgeBaseManagement {

  // [START dialogflow_list_knowledge_base]
  /**
   * List Knowledge bases
   *
   * @param projectId Project/agent id.
   */
  public static void listKnowledgeBases(String projectId) throws Exception {
    // Instantiates a client
    try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
      // Set the entity type name using the projectID (my-project-id) and entityTypeId (KIND_LIST)
      ProjectName projectName = ProjectName.of(projectId);
      for (KnowledgeBase knowledgeBase :
          knowledgeBasesClient.listKnowledgeBases(projectName).iterateAll()) {
        System.out.format(" - Display Name: %s\n", knowledgeBase.getDisplayName());
        System.out.format(" - Knowledge ID: %s\n", knowledgeBase.getName());
      }
    }
  }
  // [END dialogflow_list_knowledge_base]

  // [START dialogflow_create_knowledge_base]
  /**
   * Create a Knowledge base
   *
   * @param projectId Project/agent id.
   * @param displayName Name of the knowledge base.
   */
  public static void createKnowledgeBase(String projectId, String displayName) throws Exception {
    // Instantiates a client
    try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {

      KnowledgeBase knowledgeBase = KnowledgeBase.newBuilder().setDisplayName(displayName).build();
      ProjectName projectName = ProjectName.of(projectId);
      KnowledgeBase response = knowledgeBasesClient.createKnowledgeBase(projectName, knowledgeBase);
      System.out.format("Knowledgebase created:\n");
      System.out.format("Display Name: %s \n", response.getDisplayName());
      System.out.format("Knowledge ID: %s \n", response.getName());
    }
  }
  // [END dialogflow_create_knowledge_base]

  // [START dialogflow_get_knowledge_base]

  /**
   * @param knowledgeBaseId Knowledge base id.
   * @param projectId Project/agent id.
   */
  public static void getKnowledgeBase(String projectId, String knowledgeBaseId) throws Exception {

    // Instantiates a client
    try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
      KnowledgeBaseName knowledgeBaseName = KnowledgeBaseName.of(projectId, knowledgeBaseId);
      KnowledgeBase response = knowledgeBasesClient.getKnowledgeBase(knowledgeBaseName);
      System.out.format("Got Knowledge Base:\n");
      System.out.format(" - Display Name: %s\n", response.getDisplayName());
      System.out.format(" - Knowledge ID: %s\n", response.getName());
    }
  }
  // [END dialogflow_get_knowledge_base]
  // [START dialogflow_delete_knowledge_base]

  /**
   * @param knowledgeBaseId Knowledge base id.
   * @param projectId Project/agent id.
   */
  public static void deleteKnowledgeBase(String projectId, String knowledgeBaseId)
      throws Exception {
    // Instantiates a client
    try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
      KnowledgeBaseName knowledgeBaseName = KnowledgeBaseName.of(projectId, knowledgeBaseId);
      knowledgeBasesClient.deleteKnowledgeBase(knowledgeBaseName);
      System.out.format("KnowledgeBase has been deleted.\n");
    }
  }
  // [END dialogflow_delete_knowledge_base]


  public static void main(String[] args) throws Exception {
    ArgumentParser parser =
        ArgumentParsers.newFor("KnowledgeBaseManagement")
            .build()
            .defaultHelp(true)
            .description("Create / List / Delete a Knowledge Base.");

    Subparsers subparsers = parser.addSubparsers().dest("command").title("Commands");

    Subparser listParser = subparsers.addParser("list")
        .help("mvn exec:java -DKnowledgeManagement -Dexec.args='list --projectId PROJECT_ID'");
    listParser.addArgument("--projectId").help("Project/Agent Id").required(true);

    Subparser createParser = subparsers.addParser("create")
        .help("mvn exec:java -DKnowledgeManagement -Dexec.args='create DISPLAY_NAME "
            + "--projectId PROJECT_ID'");
    createParser.addArgument("displayName")
        .help("The display name of the Document").required(true);
    createParser.addArgument("--projectId").help("Project/Agent Id").required(true);

    Subparser getParser = subparsers.addParser("get")
        .help("mvn exec:java -DKnowledgeManagement -Dexec.args='get KNOWLEDGE_BASE_ID "
            + "--projectId PROJECT_ID'");
    getParser.addArgument("knowledgeBaseId")
        .help("The ID of the Knowledge Base to list the Documents").required(true);
    getParser.addArgument("--projectId").help("Project/Agent Id").required(true);

    Subparser deleteParser = subparsers.addParser("delete")
        .help("mvn exec:java -DKnowledgeManagement -Dexec.args='delete KNOWLEDGE_BASE_ID "
            + "--projectId PROJECT_ID'");
    deleteParser.addArgument("--projectId").help("Project/Agent Id").required(true);
    deleteParser.addArgument("--knowledgeBaseId")
        .help("The ID of the Knowledge Base to list the Documents").required(true);

    try {
      Namespace namespace = parser.parseArgs(args);

      if (namespace.get("command").equals("list")) {
        listKnowledgeBases(namespace.get("projectId"));
      } else if (namespace.get("command").equals("create")) {
        createKnowledgeBase(namespace.get("projectId"), namespace.get("displayName"));
      } else if (namespace.get("command").equals("get")) {
        getKnowledgeBase(namespace.get("projectId"), namespace.get("knowledgeBaseId"));
      } else if (namespace.get("command").equals("delete")) {
        deleteKnowledgeBase(namespace.get("projectId"), namespace.get("knowledgeBaseId"));
      }
    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
