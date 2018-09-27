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
import com.google.common.collect.Lists;

import java.util.List;

public class DocumentManagement {
  //  [START dialogflow_list_document]

  /**
   * @param knowledgeBaseName Knowledge Base id.
   */
  public static List<Document> listDocuments(String knowledgeBaseName) throws Exception {
    List<Document> documents = Lists.newArrayList();
    // Instantiates a client
    try (DocumentsClient documentsClient = DocumentsClient.create()) {
      for (Document document : documentsClient.listDocuments(knowledgeBaseName).iterateAll()) {
        System.out.format(" - Display Name: %s\n", document.getDisplayName());
        System.out.format(" - Knowledge ID: %s\n", document.getName());
        System.out.format(" - MIME Type: %s\n", document.getMimeType());
        System.out.format(" - Knowledge Types:\n");
        for (KnowledgeType knowledgeTypeId : document.getKnowledgeTypesList()) {
          System.out.format("  - %s \n", knowledgeTypeId.getValueDescriptor());
        }
        System.out.format(" - Source: %s \n", document.getContentUri());

        documents.add(document);
      }
    }
    return documents;
  }
  //  [END dialogflow_list_document]

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
      Document createdDocument = response.get();
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

  // [START dialogflow_get_document]

  /**
   * @param documentName Document Id.
   * @return The requested document.
   */
  public static Document getDocument(String documentName) throws Exception {
    // Instantiates a client
    try (DocumentsClient documentsClient = DocumentsClient.create()) {
      Document response = documentsClient.getDocument(documentName);
      System.out.format("Got Document: \n");
      System.out.format(" - Display Name: %s\n", response.getDisplayName());
      System.out.format(" - Knowledge ID: %s\n", response.getName());
      System.out.format(" - MIME Type: %s\n", response.getMimeType());
      System.out.format(" - Knowledge Types:\n");
      for (KnowledgeType knowledgeTypeId : response.getKnowledgeTypesList()) {
        System.out.format("  - %s \n", knowledgeTypeId.getValueDescriptor());
      }
      System.out.format(" - Source: %s \n", response.getContentUri());

      return response;
    }
  }
  // [END dialogflow_get_document]

  // [START dialogflow_delete_document]

  /**
   * @param documentName Document Id.
   */
  public static void deleteDocument(String documentName) throws Exception {
    // Instantiates a client
    try (DocumentsClient documentsClient = DocumentsClient.create()) {
      documentsClient.deleteDocumentAsync(documentName).getInitialFuture().get();
      System.out.format("The document has been deleted.");
    }
  }
}
