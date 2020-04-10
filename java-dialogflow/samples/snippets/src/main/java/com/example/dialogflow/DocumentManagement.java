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

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest;
import com.google.cloud.dialogflow.v2beta1.Document;
import com.google.cloud.dialogflow.v2beta1.Document.KnowledgeType;
import com.google.cloud.dialogflow.v2beta1.DocumentsClient;
import com.google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata;
import java.util.concurrent.TimeUnit;

public class DocumentManagement {
  // [START dialogflow_create_document]

  /**
   * @param knowledgeBaseName Knowledge Base id.
   * @param displayName       display name of the Document.
   * @param mimeType          MIME type of the Document. e.g. text/csv, text/html
   * @param knowledgeType     Knowledge Type of the Document. e.g. FAQ, EXTRACTIVE_QA
   * @param contentUri        Uri of the Document. e.g. gs://path/mydoc.csv, http://mypage.com/faq.html
   * @return The created document.
   */
  public static Document createDocument(
      String knowledgeBaseName,
      String displayName,
      String mimeType,
      String knowledgeType,
      String contentUri)
      throws Exception {
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
      System.out.format(" - Knowledge ID: %s\n", createdDocument.getName());
      System.out.format(" - MIME Type: %s\n", createdDocument.getMimeType());
      System.out.format(" - Knowledge Types:\n");
      for (KnowledgeType knowledgeTypeId : document.getKnowledgeTypesList()) {
        System.out.format("  - %s \n", knowledgeTypeId.getValueDescriptor());
      }
      System.out.format(" - Source: %s \n", document.getContentUri());
      return createdDocument;
    }
  }
  // [END dialogflow_create_document]
}
