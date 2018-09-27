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
import com.google.cloud.dialogflow.v2beta1.KnowledgeBasesClient;
import com.google.cloud.dialogflow.v2beta1.ProjectName;
import com.google.common.collect.Lists;

import java.util.List;

public class KnowledgeBaseManagement {
  // [START dialogflow_list_knowledge_base]

  /**
   * List Knowledge bases
   *
   * @param projectId Project/agent id.
   * @return The KnowledgeBases found in projectId.
   */
  public static List<KnowledgeBase> listKnowledgeBases(String projectId) throws Exception {
    List<KnowledgeBase> knowledgeBases = Lists.newArrayList();
    // Instantiates a client
    try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
      // Set the entity type name using the projectID (my-project-id) and entityTypeId (KIND_LIST)
      ProjectName projectName = ProjectName.of(projectId);
      for (KnowledgeBase knowledgeBase :
          knowledgeBasesClient.listKnowledgeBases(projectName).iterateAll()) {
        System.out.format(" - Display Name: %s\n", knowledgeBase.getDisplayName());
        System.out.format(" - Knowledge ID: %s\n", knowledgeBase.getName());
        knowledgeBases.add(knowledgeBase);
      }
    }
    return knowledgeBases;
  }
  // [END dialogflow_list_knowledge_base]

  // [START dialogflow_create_knowledge_base]

  /**
   * Create a Knowledge base
   *
   * @param projectId   Project/agent id.
   * @param displayName Name of the knowledge base.
   * @return The created KnowledgeBase.
   */
  public static KnowledgeBase createKnowledgeBase(String projectId, String displayName)
      throws Exception {
    // Instantiates a client
    try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
      KnowledgeBase knowledgeBase = KnowledgeBase.newBuilder().setDisplayName(displayName).build();
      ProjectName projectName = ProjectName.of(projectId);
      KnowledgeBase response = knowledgeBasesClient.createKnowledgeBase(projectName, knowledgeBase);
      System.out.format("Knowledgebase created:\n");
      System.out.format("Display Name: %s \n", response.getDisplayName());
      System.out.format("Knowledge ID: %s \n", response.getName());

      return response;
    }
  }
  // [END dialogflow_create_knowledge_base]

  // [START dialogflow_get_knowledge_base]

  /**
   * @param knowledgeBaseName Knowledge base id.
   * @return The retrieved KnowledgeBase.
   */
  public static KnowledgeBase getKnowledgeBase(String knowledgeBaseName) throws Exception {
    // Instantiates a client
    try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
      KnowledgeBase response = knowledgeBasesClient.getKnowledgeBase(knowledgeBaseName);
      System.out.format("Got Knowledge Base:\n");
      System.out.format(" - Display Name: %s\n", response.getDisplayName());
      System.out.format(" - Knowledge ID: %s\n", response.getName());
      return response;
    }
  }
  // [END dialogflow_get_knowledge_base]

  // [START dialogflow_delete_knowledge_base]

  /**
   * @param knowledgeBaseName Knowledge base id.
   */
  public static void deleteKnowledgeBase(String knowledgeBaseName) throws Exception {
    // Instantiates a client
    try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
      knowledgeBasesClient.deleteKnowledgeBase(knowledgeBaseName);
      System.out.format("KnowledgeBase has been deleted.\n");
    }
  }
  // [END dialogflow_delete_knowledge_base]
}
