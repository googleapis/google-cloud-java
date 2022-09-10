/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.dialogflow.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.stub.DocumentsStub;
import com.google.cloud.dialogflow.v2.stub.DocumentsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing knowledge
 * [Documents][google.cloud.dialogflow.v2.Document].
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DocumentsClient documentsClient = DocumentsClient.create()) {
 *   DocumentName name =
 *       DocumentName.ofProjectKnowledgeBaseDocumentName(
 *           "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]");
 *   Document response = documentsClient.getDocument(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DocumentsClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of DocumentsSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DocumentsSettings documentsSettings =
 *     DocumentsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DocumentsClient documentsClient = DocumentsClient.create(documentsSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DocumentsSettings documentsSettings =
 *     DocumentsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DocumentsClient documentsClient = DocumentsClient.create(documentsSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DocumentsSettings documentsSettings =
 *     DocumentsSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             DocumentsSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * DocumentsClient documentsClient = DocumentsClient.create(documentsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DocumentsClient implements BackgroundResource {
  private final DocumentsSettings settings;
  private final DocumentsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DocumentsClient with default settings. */
  public static final DocumentsClient create() throws IOException {
    return create(DocumentsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DocumentsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DocumentsClient create(DocumentsSettings settings) throws IOException {
    return new DocumentsClient(settings);
  }

  /**
   * Constructs an instance of DocumentsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(DocumentsSettings).
   */
  public static final DocumentsClient create(DocumentsStub stub) {
    return new DocumentsClient(stub);
  }

  /**
   * Constructs an instance of DocumentsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected DocumentsClient(DocumentsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DocumentsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DocumentsClient(DocumentsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DocumentsSettings getSettings() {
    return settings;
  }

  public DocumentsStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all documents of the knowledge base.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   KnowledgeBaseName parent =
   *       KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]");
   *   for (Document element : documentsClient.listDocuments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The knowledge base to list all documents for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge
   *     Base ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDocumentsPagedResponse listDocuments(KnowledgeBaseName parent) {
    ListDocumentsRequest request =
        ListDocumentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDocuments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all documents of the knowledge base.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   String parent =
   *       KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]").toString();
   *   for (Document element : documentsClient.listDocuments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The knowledge base to list all documents for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge
   *     Base ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDocumentsPagedResponse listDocuments(String parent) {
    ListDocumentsRequest request = ListDocumentsRequest.newBuilder().setParent(parent).build();
    return listDocuments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all documents of the knowledge base.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   ListDocumentsRequest request =
   *       ListDocumentsRequest.newBuilder()
   *           .setParent(
   *               KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Document element : documentsClient.listDocuments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDocumentsPagedResponse listDocuments(ListDocumentsRequest request) {
    return listDocumentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all documents of the knowledge base.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   ListDocumentsRequest request =
   *       ListDocumentsRequest.newBuilder()
   *           .setParent(
   *               KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Document> future = documentsClient.listDocumentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Document element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable() {
    return stub.listDocumentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all documents of the knowledge base.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   ListDocumentsRequest request =
   *       ListDocumentsRequest.newBuilder()
   *           .setParent(
   *               KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListDocumentsResponse response = documentsClient.listDocumentsCallable().call(request);
   *     for (Document element : response.getDocumentsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable() {
    return stub.listDocumentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   DocumentName name =
   *       DocumentName.ofProjectKnowledgeBaseDocumentName(
   *           "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]");
   *   Document response = documentsClient.getDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the document to retrieve. Format `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge Base
   *     ID&gt;/documents/&lt;Document ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document getDocument(DocumentName name) {
    GetDocumentRequest request =
        GetDocumentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   String name =
   *       DocumentName.ofProjectKnowledgeBaseDocumentName(
   *               "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
   *           .toString();
   *   Document response = documentsClient.getDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the document to retrieve. Format `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge Base
   *     ID&gt;/documents/&lt;Document ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document getDocument(String name) {
    GetDocumentRequest request = GetDocumentRequest.newBuilder().setName(name).build();
    return getDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   GetDocumentRequest request =
   *       GetDocumentRequest.newBuilder()
   *           .setName(
   *               DocumentName.ofProjectKnowledgeBaseDocumentName(
   *                       "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
   *                   .toString())
   *           .build();
   *   Document response = documentsClient.getDocument(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document getDocument(GetDocumentRequest request) {
    return getDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   GetDocumentRequest request =
   *       GetDocumentRequest.newBuilder()
   *           .setName(
   *               DocumentName.ofProjectKnowledgeBaseDocumentName(
   *                       "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Document> future = documentsClient.getDocumentCallable().futureCall(request);
   *   // Do something.
   *   Document response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDocumentRequest, Document> getDocumentCallable() {
    return stub.getDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new document.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [Document][google.cloud.dialogflow.v2.Document]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   KnowledgeBaseName parent =
   *       KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]");
   *   Document document = Document.newBuilder().build();
   *   Document response = documentsClient.createDocumentAsync(parent, document).get();
   * }
   * }</pre>
   *
   * @param parent Required. The knowledge base to create a document for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge
   *     Base ID&gt;`.
   * @param document Required. The document to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Document, KnowledgeOperationMetadata> createDocumentAsync(
      KnowledgeBaseName parent, Document document) {
    CreateDocumentRequest request =
        CreateDocumentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDocument(document)
            .build();
    return createDocumentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new document.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [Document][google.cloud.dialogflow.v2.Document]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   String parent =
   *       KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]").toString();
   *   Document document = Document.newBuilder().build();
   *   Document response = documentsClient.createDocumentAsync(parent, document).get();
   * }
   * }</pre>
   *
   * @param parent Required. The knowledge base to create a document for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge
   *     Base ID&gt;`.
   * @param document Required. The document to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Document, KnowledgeOperationMetadata> createDocumentAsync(
      String parent, Document document) {
    CreateDocumentRequest request =
        CreateDocumentRequest.newBuilder().setParent(parent).setDocument(document).build();
    return createDocumentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new document.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [Document][google.cloud.dialogflow.v2.Document]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   CreateDocumentRequest request =
   *       CreateDocumentRequest.newBuilder()
   *           .setParent(
   *               KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
   *                   .toString())
   *           .setDocument(Document.newBuilder().build())
   *           .build();
   *   Document response = documentsClient.createDocumentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Document, KnowledgeOperationMetadata> createDocumentAsync(
      CreateDocumentRequest request) {
    return createDocumentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new document.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [Document][google.cloud.dialogflow.v2.Document]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   CreateDocumentRequest request =
   *       CreateDocumentRequest.newBuilder()
   *           .setParent(
   *               KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
   *                   .toString())
   *           .setDocument(Document.newBuilder().build())
   *           .build();
   *   OperationFuture<Document, KnowledgeOperationMetadata> future =
   *       documentsClient.createDocumentOperationCallable().futureCall(request);
   *   // Do something.
   *   Document response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDocumentRequest, Document, KnowledgeOperationMetadata>
      createDocumentOperationCallable() {
    return stub.createDocumentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new document.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [Document][google.cloud.dialogflow.v2.Document]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   CreateDocumentRequest request =
   *       CreateDocumentRequest.newBuilder()
   *           .setParent(
   *               KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
   *                   .toString())
   *           .setDocument(Document.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = documentsClient.createDocumentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDocumentRequest, Operation> createDocumentCallable() {
    return stub.createDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates documents by importing data from external sources. Dialogflow supports up to 350
   * documents in each request. If you try to import more, Dialogflow will return an error.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [ImportDocumentsResponse][google.cloud.dialogflow.v2.ImportDocumentsResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   ImportDocumentsRequest request =
   *       ImportDocumentsRequest.newBuilder()
   *           .setParent(
   *               KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
   *                   .toString())
   *           .setDocumentTemplate(ImportDocumentTemplate.newBuilder().build())
   *           .setImportGcsCustomMetadata(true)
   *           .build();
   *   ImportDocumentsResponse response = documentsClient.importDocumentsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportDocumentsResponse, KnowledgeOperationMetadata>
      importDocumentsAsync(ImportDocumentsRequest request) {
    return importDocumentsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates documents by importing data from external sources. Dialogflow supports up to 350
   * documents in each request. If you try to import more, Dialogflow will return an error.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [ImportDocumentsResponse][google.cloud.dialogflow.v2.ImportDocumentsResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   ImportDocumentsRequest request =
   *       ImportDocumentsRequest.newBuilder()
   *           .setParent(
   *               KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
   *                   .toString())
   *           .setDocumentTemplate(ImportDocumentTemplate.newBuilder().build())
   *           .setImportGcsCustomMetadata(true)
   *           .build();
   *   OperationFuture<ImportDocumentsResponse, KnowledgeOperationMetadata> future =
   *       documentsClient.importDocumentsOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportDocumentsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ImportDocumentsRequest, ImportDocumentsResponse, KnowledgeOperationMetadata>
      importDocumentsOperationCallable() {
    return stub.importDocumentsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates documents by importing data from external sources. Dialogflow supports up to 350
   * documents in each request. If you try to import more, Dialogflow will return an error.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [ImportDocumentsResponse][google.cloud.dialogflow.v2.ImportDocumentsResponse]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   ImportDocumentsRequest request =
   *       ImportDocumentsRequest.newBuilder()
   *           .setParent(
   *               KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
   *                   .toString())
   *           .setDocumentTemplate(ImportDocumentTemplate.newBuilder().build())
   *           .setImportGcsCustomMetadata(true)
   *           .build();
   *   ApiFuture<Operation> future = documentsClient.importDocumentsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable() {
    return stub.importDocumentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified document.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: An [Empty
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   DocumentName name =
   *       DocumentName.ofProjectKnowledgeBaseDocumentName(
   *           "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]");
   *   documentsClient.deleteDocumentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the document to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge Base
   *     ID&gt;/documents/&lt;Document ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, KnowledgeOperationMetadata> deleteDocumentAsync(
      DocumentName name) {
    DeleteDocumentRequest request =
        DeleteDocumentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteDocumentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified document.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: An [Empty
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   String name =
   *       DocumentName.ofProjectKnowledgeBaseDocumentName(
   *               "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
   *           .toString();
   *   documentsClient.deleteDocumentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the document to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge Base
   *     ID&gt;/documents/&lt;Document ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, KnowledgeOperationMetadata> deleteDocumentAsync(String name) {
    DeleteDocumentRequest request = DeleteDocumentRequest.newBuilder().setName(name).build();
    return deleteDocumentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified document.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: An [Empty
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   DeleteDocumentRequest request =
   *       DeleteDocumentRequest.newBuilder()
   *           .setName(
   *               DocumentName.ofProjectKnowledgeBaseDocumentName(
   *                       "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
   *                   .toString())
   *           .build();
   *   documentsClient.deleteDocumentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, KnowledgeOperationMetadata> deleteDocumentAsync(
      DeleteDocumentRequest request) {
    return deleteDocumentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified document.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: An [Empty
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   DeleteDocumentRequest request =
   *       DeleteDocumentRequest.newBuilder()
   *           .setName(
   *               DocumentName.ofProjectKnowledgeBaseDocumentName(
   *                       "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, KnowledgeOperationMetadata> future =
   *       documentsClient.deleteDocumentOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDocumentRequest, Empty, KnowledgeOperationMetadata>
      deleteDocumentOperationCallable() {
    return stub.deleteDocumentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified document.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: An [Empty
   * message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   DeleteDocumentRequest request =
   *       DeleteDocumentRequest.newBuilder()
   *           .setName(
   *               DocumentName.ofProjectKnowledgeBaseDocumentName(
   *                       "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = documentsClient.deleteDocumentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDocumentRequest, Operation> deleteDocumentCallable() {
    return stub.deleteDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified document.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [Document][google.cloud.dialogflow.v2.Document]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Document response = documentsClient.updateDocumentAsync(document, updateMask).get();
   * }
   * }</pre>
   *
   * @param document Required. The document to update.
   * @param updateMask Optional. Not specified means `update all`. Currently, only `display_name`
   *     can be updated, an InvalidArgument will be returned for attempting to update other fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Document, KnowledgeOperationMetadata> updateDocumentAsync(
      Document document, FieldMask updateMask) {
    UpdateDocumentRequest request =
        UpdateDocumentRequest.newBuilder().setDocument(document).setUpdateMask(updateMask).build();
    return updateDocumentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified document.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [Document][google.cloud.dialogflow.v2.Document]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   UpdateDocumentRequest request =
   *       UpdateDocumentRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Document response = documentsClient.updateDocumentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Document, KnowledgeOperationMetadata> updateDocumentAsync(
      UpdateDocumentRequest request) {
    return updateDocumentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified document.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [Document][google.cloud.dialogflow.v2.Document]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   UpdateDocumentRequest request =
   *       UpdateDocumentRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Document, KnowledgeOperationMetadata> future =
   *       documentsClient.updateDocumentOperationCallable().futureCall(request);
   *   // Do something.
   *   Document response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDocumentRequest, Document, KnowledgeOperationMetadata>
      updateDocumentOperationCallable() {
    return stub.updateDocumentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified document.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [Document][google.cloud.dialogflow.v2.Document]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   UpdateDocumentRequest request =
   *       UpdateDocumentRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = documentsClient.updateDocumentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDocumentRequest, Operation> updateDocumentCallable() {
    return stub.updateDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reloads the specified document from its specified source, content_uri or content. The
   * previously loaded content of the document will be deleted. Note: Even when the content of the
   * document has not changed, there still may be side effects because of internal implementation
   * changes.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [Document][google.cloud.dialogflow.v2.Document]
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   DocumentName name =
   *       DocumentName.ofProjectKnowledgeBaseDocumentName(
   *           "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]");
   *   String contentUri = "contentUri264542771";
   *   Document response = documentsClient.reloadDocumentAsync(name, contentUri).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the document to reload. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge Base
   *     ID&gt;/documents/&lt;Document ID&gt;`
   * @param contentUri Optional. The path of gcs source file for reloading document content. For
   *     now, only gcs uri is supported.
   *     <p>For documents stored in Google Cloud Storage, these URIs must have the form
   *     `gs://&lt;bucket-name&gt;/&lt;object-name&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Document, KnowledgeOperationMetadata> reloadDocumentAsync(
      DocumentName name, String contentUri) {
    ReloadDocumentRequest request =
        ReloadDocumentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setContentUri(contentUri)
            .build();
    return reloadDocumentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reloads the specified document from its specified source, content_uri or content. The
   * previously loaded content of the document will be deleted. Note: Even when the content of the
   * document has not changed, there still may be side effects because of internal implementation
   * changes.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [Document][google.cloud.dialogflow.v2.Document]
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   String name =
   *       DocumentName.ofProjectKnowledgeBaseDocumentName(
   *               "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
   *           .toString();
   *   String contentUri = "contentUri264542771";
   *   Document response = documentsClient.reloadDocumentAsync(name, contentUri).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the document to reload. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge Base
   *     ID&gt;/documents/&lt;Document ID&gt;`
   * @param contentUri Optional. The path of gcs source file for reloading document content. For
   *     now, only gcs uri is supported.
   *     <p>For documents stored in Google Cloud Storage, these URIs must have the form
   *     `gs://&lt;bucket-name&gt;/&lt;object-name&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Document, KnowledgeOperationMetadata> reloadDocumentAsync(
      String name, String contentUri) {
    ReloadDocumentRequest request =
        ReloadDocumentRequest.newBuilder().setName(name).setContentUri(contentUri).build();
    return reloadDocumentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reloads the specified document from its specified source, content_uri or content. The
   * previously loaded content of the document will be deleted. Note: Even when the content of the
   * document has not changed, there still may be side effects because of internal implementation
   * changes.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [Document][google.cloud.dialogflow.v2.Document]
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   ReloadDocumentRequest request =
   *       ReloadDocumentRequest.newBuilder()
   *           .setName(
   *               DocumentName.ofProjectKnowledgeBaseDocumentName(
   *                       "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
   *                   .toString())
   *           .setImportGcsCustomMetadata(true)
   *           .setSmartMessagingPartialUpdate(true)
   *           .build();
   *   Document response = documentsClient.reloadDocumentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Document, KnowledgeOperationMetadata> reloadDocumentAsync(
      ReloadDocumentRequest request) {
    return reloadDocumentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reloads the specified document from its specified source, content_uri or content. The
   * previously loaded content of the document will be deleted. Note: Even when the content of the
   * document has not changed, there still may be side effects because of internal implementation
   * changes.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [Document][google.cloud.dialogflow.v2.Document]
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   ReloadDocumentRequest request =
   *       ReloadDocumentRequest.newBuilder()
   *           .setName(
   *               DocumentName.ofProjectKnowledgeBaseDocumentName(
   *                       "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
   *                   .toString())
   *           .setImportGcsCustomMetadata(true)
   *           .setSmartMessagingPartialUpdate(true)
   *           .build();
   *   OperationFuture<Document, KnowledgeOperationMetadata> future =
   *       documentsClient.reloadDocumentOperationCallable().futureCall(request);
   *   // Do something.
   *   Document response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ReloadDocumentRequest, Document, KnowledgeOperationMetadata>
      reloadDocumentOperationCallable() {
    return stub.reloadDocumentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reloads the specified document from its specified source, content_uri or content. The
   * previously loaded content of the document will be deleted. Note: Even when the content of the
   * document has not changed, there still may be side effects because of internal implementation
   * changes.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [Document][google.cloud.dialogflow.v2.Document]
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   ReloadDocumentRequest request =
   *       ReloadDocumentRequest.newBuilder()
   *           .setName(
   *               DocumentName.ofProjectKnowledgeBaseDocumentName(
   *                       "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
   *                   .toString())
   *           .setImportGcsCustomMetadata(true)
   *           .setSmartMessagingPartialUpdate(true)
   *           .build();
   *   ApiFuture<Operation> future = documentsClient.reloadDocumentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReloadDocumentRequest, Operation> reloadDocumentCallable() {
    return stub.reloadDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a smart messaging candidate document into the specified destination.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [Document][google.cloud.dialogflow.v2.Document]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   ExportDocumentRequest request =
   *       ExportDocumentRequest.newBuilder()
   *           .setName(
   *               DocumentName.ofProjectKnowledgeBaseDocumentName(
   *                       "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
   *                   .toString())
   *           .setExportFullContent(true)
   *           .setSmartMessagingPartialUpdate(true)
   *           .build();
   *   Document response = documentsClient.exportDocumentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Document, KnowledgeOperationMetadata> exportDocumentAsync(
      ExportDocumentRequest request) {
    return exportDocumentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a smart messaging candidate document into the specified destination.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [Document][google.cloud.dialogflow.v2.Document]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   ExportDocumentRequest request =
   *       ExportDocumentRequest.newBuilder()
   *           .setName(
   *               DocumentName.ofProjectKnowledgeBaseDocumentName(
   *                       "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
   *                   .toString())
   *           .setExportFullContent(true)
   *           .setSmartMessagingPartialUpdate(true)
   *           .build();
   *   OperationFuture<Document, KnowledgeOperationMetadata> future =
   *       documentsClient.exportDocumentOperationCallable().futureCall(request);
   *   // Do something.
   *   Document response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ExportDocumentRequest, Document, KnowledgeOperationMetadata>
      exportDocumentOperationCallable() {
    return stub.exportDocumentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a smart messaging candidate document into the specified destination.
   *
   * <p>This method is a [long-running
   * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The
   * returned `Operation` type has the following method-specific fields:
   *
   * <p>- `metadata`:
   * [KnowledgeOperationMetadata][google.cloud.dialogflow.v2.KnowledgeOperationMetadata] -
   * `response`: [Document][google.cloud.dialogflow.v2.Document]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   ExportDocumentRequest request =
   *       ExportDocumentRequest.newBuilder()
   *           .setName(
   *               DocumentName.ofProjectKnowledgeBaseDocumentName(
   *                       "[PROJECT]", "[KNOWLEDGE_BASE]", "[DOCUMENT]")
   *                   .toString())
   *           .setExportFullContent(true)
   *           .setSmartMessagingPartialUpdate(true)
   *           .build();
   *   ApiFuture<Operation> future = documentsClient.exportDocumentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportDocumentRequest, Operation> exportDocumentCallable() {
    return stub.exportDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : documentsClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = documentsClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = documentsClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = documentsClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentsClient documentsClient = DocumentsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = documentsClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListDocumentsPagedResponse
      extends AbstractPagedListResponse<
          ListDocumentsRequest,
          ListDocumentsResponse,
          Document,
          ListDocumentsPage,
          ListDocumentsFixedSizeCollection> {

    public static ApiFuture<ListDocumentsPagedResponse> createAsync(
        PageContext<ListDocumentsRequest, ListDocumentsResponse, Document> context,
        ApiFuture<ListDocumentsResponse> futureResponse) {
      ApiFuture<ListDocumentsPage> futurePage =
          ListDocumentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDocumentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDocumentsPagedResponse(ListDocumentsPage page) {
      super(page, ListDocumentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDocumentsPage
      extends AbstractPage<
          ListDocumentsRequest, ListDocumentsResponse, Document, ListDocumentsPage> {

    private ListDocumentsPage(
        PageContext<ListDocumentsRequest, ListDocumentsResponse, Document> context,
        ListDocumentsResponse response) {
      super(context, response);
    }

    private static ListDocumentsPage createEmptyPage() {
      return new ListDocumentsPage(null, null);
    }

    @Override
    protected ListDocumentsPage createPage(
        PageContext<ListDocumentsRequest, ListDocumentsResponse, Document> context,
        ListDocumentsResponse response) {
      return new ListDocumentsPage(context, response);
    }

    @Override
    public ApiFuture<ListDocumentsPage> createPageAsync(
        PageContext<ListDocumentsRequest, ListDocumentsResponse, Document> context,
        ApiFuture<ListDocumentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDocumentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDocumentsRequest,
          ListDocumentsResponse,
          Document,
          ListDocumentsPage,
          ListDocumentsFixedSizeCollection> {

    private ListDocumentsFixedSizeCollection(List<ListDocumentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDocumentsFixedSizeCollection createEmptyCollection() {
      return new ListDocumentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDocumentsFixedSizeCollection createCollection(
        List<ListDocumentsPage> pages, int collectionSize) {
      return new ListDocumentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
