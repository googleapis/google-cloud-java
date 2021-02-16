/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.dialogflow.v2beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.stub.DocumentsStub;
import com.google.cloud.dialogflow.v2beta1.stub.DocumentsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing knowledge
 * [Documents][google.cloud.dialogflow.v2beta1.Document].
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
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
 * DocumentsSettings documentsSettings =
 *     DocumentsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DocumentsClient documentsClient = DocumentsClient.create(documentsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class DocumentsClient implements BackgroundResource {
  private final DocumentsSettings settings;
  private final DocumentsStub stub;
  private final OperationsClient operationsClient;

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
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected DocumentsClient(DocumentsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final DocumentsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DocumentsStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all documents of the knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
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
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
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
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
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
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable() {
    return stub.listDocumentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all documents of the knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable() {
    return stub.listDocumentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified document.
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
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
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
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
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
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
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetDocumentRequest, Document> getDocumentCallable() {
    return stub.getDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new document.
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
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
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
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
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
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
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * <p>Sample code:
   */
  public final OperationCallable<CreateDocumentRequest, Document, KnowledgeOperationMetadata>
      createDocumentOperationCallable() {
    return stub.createDocumentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new document.
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateDocumentRequest, Operation> createDocumentCallable() {
    return stub.createDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified document.
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
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
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
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
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
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
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * <p>Sample code:
   */
  public final OperationCallable<DeleteDocumentRequest, Empty, KnowledgeOperationMetadata>
      deleteDocumentOperationCallable() {
    return stub.deleteDocumentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified document.
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteDocumentRequest, Operation> deleteDocumentCallable() {
    return stub.deleteDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified document.
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * @param document Required. The document to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Document, KnowledgeOperationMetadata> updateDocumentAsync(
      Document document) {
    UpdateDocumentRequest request =
        UpdateDocumentRequest.newBuilder().setDocument(document).build();
    return updateDocumentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified document.
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
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
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
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
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * <p>Sample code:
   */
  public final OperationCallable<UpdateDocumentRequest, Document, KnowledgeOperationMetadata>
      updateDocumentOperationCallable() {
    return stub.updateDocumentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified document.
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateDocumentRequest, Operation> updateDocumentCallable() {
    return stub.updateDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reloads the specified document from its specified source, content_uri or content. The
   * previously loaded content of the document will be deleted. Note: Even when the content of the
   * document has not changed, there still may be side effects because of internal implementation
   * changes. Note: If the document source is Google Cloud Storage URI, its metadata will be
   * replaced with the custom metadata from Google Cloud Storage if the `import_gcs_custom_metadata`
   * field is set to true in the request.
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * @param name Required. The name of the document to reload. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge Base
   *     ID&gt;/documents/&lt;Document ID&gt;`
   * @param gcsSource The path for a Cloud Storage source file for reloading document content. If
   *     not provided, the Document's existing source will be reloaded.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Document, KnowledgeOperationMetadata> reloadDocumentAsync(
      DocumentName name, GcsSource gcsSource) {
    ReloadDocumentRequest request =
        ReloadDocumentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setGcsSource(gcsSource)
            .build();
    return reloadDocumentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reloads the specified document from its specified source, content_uri or content. The
   * previously loaded content of the document will be deleted. Note: Even when the content of the
   * document has not changed, there still may be side effects because of internal implementation
   * changes. Note: If the document source is Google Cloud Storage URI, its metadata will be
   * replaced with the custom metadata from Google Cloud Storage if the `import_gcs_custom_metadata`
   * field is set to true in the request.
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * @param name Required. The name of the document to reload. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge Base
   *     ID&gt;/documents/&lt;Document ID&gt;`
   * @param gcsSource The path for a Cloud Storage source file for reloading document content. If
   *     not provided, the Document's existing source will be reloaded.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Document, KnowledgeOperationMetadata> reloadDocumentAsync(
      String name, GcsSource gcsSource) {
    ReloadDocumentRequest request =
        ReloadDocumentRequest.newBuilder().setName(name).setGcsSource(gcsSource).build();
    return reloadDocumentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reloads the specified document from its specified source, content_uri or content. The
   * previously loaded content of the document will be deleted. Note: Even when the content of the
   * document has not changed, there still may be side effects because of internal implementation
   * changes. Note: If the document source is Google Cloud Storage URI, its metadata will be
   * replaced with the custom metadata from Google Cloud Storage if the `import_gcs_custom_metadata`
   * field is set to true in the request.
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
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
   * changes. Note: If the document source is Google Cloud Storage URI, its metadata will be
   * replaced with the custom metadata from Google Cloud Storage if the `import_gcs_custom_metadata`
   * field is set to true in the request.
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * <p>Sample code:
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
   * changes. Note: If the document source is Google Cloud Storage URI, its metadata will be
   * replaced with the custom metadata from Google Cloud Storage if the `import_gcs_custom_metadata`
   * field is set to true in the request.
   *
   * <p>Note: The `projects.agent.knowledgeBases.documents` resource is deprecated; only use
   * `projects.knowledgeBases.documents`.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ReloadDocumentRequest, Operation> reloadDocumentCallable() {
    return stub.reloadDocumentCallable();
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
          new ApiFunction<ListDocumentsPage, ListDocumentsPagedResponse>() {
            @Override
            public ListDocumentsPagedResponse apply(ListDocumentsPage input) {
              return new ListDocumentsPagedResponse(input);
            }
          },
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
}
