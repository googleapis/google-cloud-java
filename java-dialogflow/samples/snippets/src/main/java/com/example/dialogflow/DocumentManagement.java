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

// [START dialogflow_create_document]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.dialogflow.v2.CreateDocumentRequest;
import com.google.cloud.dialogflow.v2.Document;
import com.google.cloud.dialogflow.v2.Document.KnowledgeType;
import com.google.cloud.dialogflow.v2.DocumentsClient;
import com.google.cloud.dialogflow.v2.KnowledgeOperationMetadata;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class DocumentManagement {

  public static void createDocument(
      String knowledgeBaseName,
      String displayName,
      String mimeType,
      String knowledgeType,
      String contentUri)
      throws IOException, ApiException, InterruptedException, ExecutionException, TimeoutException {
    // Instantiates a client
    try (DocumentsClient documentsClient = DocumentsClient.create()) {
      Document document =
          Document.newBuilder()
              .setDisplayName(displayName)
              .setContentUri(contentUri)
              .setMimeType(mimeType)
              .addKnowledgeTypes(KnowledgeType.valueOf(knowledgeType))
              .build();
      CreateDocumentRequest createDocumentRequest =
          CreateDocumentRequest.newBuilder()
              .setDocument(document)
              .setParent(knowledgeBaseName)
              .build();
      OperationFuture<Document, KnowledgeOperationMetadata> response =
          documentsClient.createDocumentAsync(createDocumentRequest);
      Document createdDocument = response.get(180, TimeUnit.SECONDS);
      System.out.format("Created Document:\n");
      System.out.format(" - Display Name: %s\n", createdDocument.getDisplayName());
      System.out.format(" - Document Name: %s\n", createdDocument.getName());
      System.out.format(" - MIME Type: %s\n", createdDocument.getMimeType());
      System.out.format(" - Knowledge Types:\n");
      for (KnowledgeType knowledgeTypeId : document.getKnowledgeTypesList()) {
        System.out.format("  - %s \n", knowledgeTypeId.getValueDescriptor());
      }
      System.out.format(" - Source: %s \n", document.getContentUri());
    }
  }
}
// [END dialogflow_create_document]
