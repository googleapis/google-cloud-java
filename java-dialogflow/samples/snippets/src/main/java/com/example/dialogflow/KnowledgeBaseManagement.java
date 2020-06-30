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
import com.google.cloud.dialogflow.v2beta1.KnowledgeBase;
import com.google.cloud.dialogflow.v2beta1.KnowledgeBasesClient;
import com.google.cloud.dialogflow.v2beta1.ProjectName;
import java.io.IOException;

public class KnowledgeBaseManagement {

  // Create a Knowledge base
  public static KnowledgeBase createKnowledgeBase(String projectId, String displayName)
      throws ApiException, IOException {
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
}
// [END dialogflow_create_knowledge_base]
