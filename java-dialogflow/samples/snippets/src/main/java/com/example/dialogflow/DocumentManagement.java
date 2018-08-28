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
import com.google.cloud.dialogflow.v2beta1.DocumentName;
import com.google.cloud.dialogflow.v2beta1.DocumentsClient;
import com.google.cloud.dialogflow.v2beta1.KnowledgeBaseName;
import com.google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;

public class DocumentManagement {

  //  [START dialogflow_list_document]
  /**
   * @param projectId Project/Agent id.
   * @param knowledgeBaseId Knowledge Base id.
   */
  public static void listDocuments(String projectId, String knowledgeBaseId) throws Exception {
    // Instantiates a client
    try (DocumentsClient documentsClient = DocumentsClient.create()) {
      KnowledgeBaseName knowledgeBaseName = KnowledgeBaseName.of(projectId, knowledgeBaseId);
      for (Document document : documentsClient.listDocuments(knowledgeBaseName).iterateAll()) {
        System.out.format(" - Display Name: %s\n", document.getDisplayName());
        System.out.format(" - Knowledge ID: %s\n", document.getName());
        System.out.format(" - MIME Type: %s\n", document.getMimeType());
        System.out.format(" - Knowledge Types:\n");
        for (KnowledgeType knowledgeTypeId : document.getKnowledgeTypesList()) {
          System.out.format("  - %s \n", knowledgeTypeId.getValueDescriptor());
        }
        System.out.format(" - Source: %s \n", document.getContentUri());
      }
    }
  }
  //  [END dialogflow_list_document]

  // [START dialogflow_create_document]
  /**
   * @param projectId Project/Agent id.
   * @param knowledgeBaseId Knowledge Base id.
   * @param displayName display name of the Document.
   * @param mimeType MIME type of the Document. e.g. text/csv, text/html
   * @param knowledgeType Knowledge Type of the Document. e.g. FAQ, EXTRACTIVE_QA
   * @param contentUri Uri of the Document. e.g. gs://path/mydoc.csv, http://mypage.com/faq.html
   */
  public static void createDocument(
      String projectId,
      String knowledgeBaseId,
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
      KnowledgeBaseName parent = KnowledgeBaseName.of(projectId, knowledgeBaseId);
      CreateDocumentRequest createDocumentRequest =
          CreateDocumentRequest.newBuilder()
              .setDocument(document)
              .setParent(parent.toString())
              .build();
      OperationFuture<Document, KnowledgeOperationMetadata> response =
          documentsClient.createDocumentAsync(createDocumentRequest);
      System.out.format("Created Document:\n");
      System.out.format(" - Display Name: %s\n", response.get().getDisplayName());
      System.out.format(" - Knowledge ID: %s\n", response.get().getName());
      System.out.format(" - MIME Type: %s\n", response.get().getMimeType());
      System.out.format(" - Knowledge Types:\n");
      for (KnowledgeType knowledgeTypeId : document.getKnowledgeTypesList()) {
        System.out.format("  - %s \n", knowledgeTypeId.getValueDescriptor());
      }
      System.out.format(" - Source: %s \n", document.getContentUri());
    }
  }
  // [END dialogflow_create_document]

  // [START dialogflow_get_document]
  /**
   * @param projectId Project/Agent id.
   * @param knowledgeBaseId Knowledge Base id.
   * @param documentId Document Id.
   */
  public static void getDocument(String projectId, String knowledgeBaseId, String documentId)
      throws Exception {
    // Instantiates a client
    try (DocumentsClient documentsClient = DocumentsClient.create()) {
      DocumentName documentName = DocumentName.of(projectId, knowledgeBaseId, documentId);
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
    }
  }
  // [END dialogflow_get_document]

  // [START dialogflow_delete_document]
  /**
   * @param projectId Project/Agent id.
   * @param knowledgeBaseId Knowledge Base id.
   * @param documentId Document Id.
   */
  public static void deleteDocument(String projectId, String knowledgeBaseId, String documentId)
      throws Exception {
    // Instantiates a client
    try (DocumentsClient documentsClient = DocumentsClient.create()) {
      DocumentName documentName = DocumentName.of(projectId, knowledgeBaseId, documentId);
      documentsClient.deleteDocumentAsync(documentName).getInitialFuture().get();
      System.out.format("The document has been deleted.");
    }
  }

  public static void main(String[] args) throws Exception {
    ArgumentParser parser =
        ArgumentParsers.newFor("DocumentManagement")
            .build()
            .defaultHelp(true)
            .description("Create / List / Delete a Document.");

    Subparsers subparsers = parser.addSubparsers().dest("command").title("Commands");

    Subparser listParser = subparsers.addParser("list")
        .help("mvn exec:java -DDocumentManagement -Dexec.args='list --projectId PROJECT_ID "
            + "--knowledgeBaseId KNOWLEDGE_BASE_ID'");
    listParser.addArgument("--projectId").help("Project/Agent Id").required(true);
    listParser.addArgument("--knowledgeBaseId")
        .help("The id of the Knowledge Base to list the Documents").required(true);

    Subparser createParser = subparsers.addParser("create")
        .help("mvn exec:java -DDocumentManagement -Dexec.args='create --projectId PROJECT_ID "
                + "--knowledgeBaseId KNOWLEDGE_BASE_ID --displayName DISPLAY_NAME "
                + "--mimeType text/html --knowledgeType FAQ "
                + "--contentUri https://cloud.google.com/storage/docs/faq'");
    createParser.addArgument("--projectId").help("Project/Agent Id").required(true);
    createParser.addArgument("--knowledgeBaseId")
        .help("The ID of the Knowledge Base to list the Documents").required(true);
    createParser.addArgument("--displayName")
        .help("The display name of the Document").required(true);
    createParser.addArgument("--mimeType")
        .help("The mime-type of the Document, e.g. text/csv, text/html, text/plain, text/pdf etc.")
        .required(true);
    createParser.addArgument("--knowledgeType")
        .help("The knowledge-type of the Document, e.g. FAQ, EXTRACTIVE_QA.").required(true);
    createParser.addArgument("--contentUri")
        .help("The uri of the Document, e.g. gs://path/mydoc.csv, http://mypage.com/faq.html")
        .required(true);

    Subparser getParser = subparsers.addParser("get")
        .help("mvn exec:java -DDocumentManagement -Dexec.args='get --projectId PROJECT_ID "
            + "--knowledgeBaseId KNOWLEDGE_BASE_ID --documentId DOCUMENT_ID'");
    getParser.addArgument("--projectId").help("Project/Agent Id").required(true);
    getParser.addArgument("--knowledgeBaseId")
        .help("The ID of the Knowledge Base to list the Documents").required(true);
    getParser.addArgument("--documentId")
        .help("The ID of the Document you want to delete").required(true);

    Subparser deleteParser = subparsers.addParser("delete")
        .help("mvn exec:java -DDocumentManagement -Dexec.args='delete --projectId PROJECT_ID "
            + "--knowledgeBaseId KNOWLEDGE_BASE_ID --documentId DOCUMENT_ID'");
    deleteParser.addArgument("--projectId").help("Project/Agent Id").required(true);
    deleteParser.addArgument("--knowledgeBaseId")
        .help("The ID of the Knowledge Base to list the Documents").required(true);
    deleteParser.addArgument("--documentId")
        .help("The ID of the Document you want to delete").required(true);

    try {
      Namespace namespace = parser.parseArgs(args);

      if (namespace.get("command").equals("list")) {
        listDocuments(namespace.get("projectId"), namespace.get("knowledgeBaseId"));
      } else if (namespace.get("command").equals("create")) {
        createDocument(namespace.get("projectId"), namespace.get("knowledgeBaseId"),
            namespace.get("displayName"), namespace.get("mimeType"), namespace.get("knowledgeType"),
            namespace.get("contentUri"));
      } else if (namespace.get("command").equals("get")) {
        getDocument(namespace.get("projectId"), namespace.get("knowledgeBaseId"),
            namespace.get("documentId"));
      } else if (namespace.get("command").equals("delete")) {
        deleteDocument(namespace.get("projectId"), namespace.get("knowledgeBaseId"),
            namespace.get("documentId"));
      }
    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
