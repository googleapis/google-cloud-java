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

// [START dialogflow_create_knowledge_base]

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.dialogflow.v2.KnowledgeBase;
import com.google.cloud.dialogflow.v2.KnowledgeBasesClient;
import com.google.cloud.dialogflow.v2.LocationName;
import java.io.IOException;

public class KnowledgeBaseManagement {

  public static void main(String[] args) throws ApiException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String location = "my-location";

    // Set display name of the new knowledge base
    String knowledgeBaseDisplayName = "my-knowledge-base-display-name";

    // Create a knowledge base
    createKnowledgeBase(projectId, location, knowledgeBaseDisplayName);
  }

  // Create a Knowledge base
  public static void createKnowledgeBase(String projectId, String location, String displayName)
      throws ApiException, IOException {
    // Instantiates a client
    try (KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create()) {
      KnowledgeBase targetKnowledgeBase =
          KnowledgeBase.newBuilder().setDisplayName(displayName).build();
      LocationName parent = LocationName.of(projectId, location);
      KnowledgeBase createdKnowledgeBase =
          knowledgeBasesClient.createKnowledgeBase(parent, targetKnowledgeBase);
      System.out.println("====================");
      System.out.format("Knowledgebase created:\n");
      System.out.format("Display Name: %s\n", createdKnowledgeBase.getDisplayName());
      System.out.format("Name: %s\n", createdKnowledgeBase.getName());
    }
  }
}
// [END dialogflow_create_knowledge_base]
