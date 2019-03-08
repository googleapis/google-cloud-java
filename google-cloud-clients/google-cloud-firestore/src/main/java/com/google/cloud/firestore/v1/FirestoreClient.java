/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.firestore.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.firestore.v1.stub.FirestoreStub;
import com.google.cloud.firestore.v1.stub.FirestoreStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.BeginTransactionRequest;
import com.google.firestore.v1.BeginTransactionResponse;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.CreateDocumentRequest;
import com.google.firestore.v1.DeleteDocumentRequest;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentMask;
import com.google.firestore.v1.GetDocumentRequest;
import com.google.firestore.v1.ListCollectionIdsRequest;
import com.google.firestore.v1.ListCollectionIdsResponse;
import com.google.firestore.v1.ListDocumentsRequest;
import com.google.firestore.v1.ListDocumentsResponse;
import com.google.firestore.v1.ListenRequest;
import com.google.firestore.v1.ListenResponse;
import com.google.firestore.v1.RollbackRequest;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.firestore.v1.UpdateDocumentRequest;
import com.google.firestore.v1.Write;
import com.google.firestore.v1.WriteRequest;
import com.google.firestore.v1.WriteResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The Cloud Firestore service.
 *
 * <p>This service exposes several types of comparable timestamps:
 *
 * <p>&#42; `create_time` - The time at which a document was created. Changes only when a document
 * is deleted, then re-created. Increases in a strict monotonic fashion. &#42; `update_time` - The
 * time at which a document was last updated. Changes every time a document is modified. Does not
 * change when a write results in no modifications. Increases in a strict monotonic fashion. &#42;
 * `read_time` - The time at which a particular state was observed. Used to denote a consistent
 * snapshot of the database or the time at which a Document was observed to not exist. &#42;
 * `commit_time` - The time at which the writes in a transaction were committed. Any read with an
 * equal or greater `read_time` is guaranteed to see the effects of the transaction.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
 *   Document document = Document.newBuilder().build();
 *   DocumentMask updateMask = DocumentMask.newBuilder().build();
 *   Document response = firestoreClient.updateDocument(document, updateMask);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the firestoreClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of FirestoreSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * FirestoreSettings firestoreSettings =
 *     FirestoreSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FirestoreClient firestoreClient =
 *     FirestoreClient.create(firestoreSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * FirestoreSettings firestoreSettings =
 *     FirestoreSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FirestoreClient firestoreClient =
 *     FirestoreClient.create(firestoreSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class FirestoreClient implements BackgroundResource {
  private final FirestoreSettings settings;
  private final FirestoreStub stub;

  private static final PathTemplate DATABASE_ROOT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/databases/{database}");

  private static final PathTemplate DOCUMENT_ROOT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/databases/{database}/documents");

  private static final PathTemplate DOCUMENT_PATH_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/databases/{database}/documents/{document_path=**}");

  private static final PathTemplate ANY_PATH_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/databases/{database}/documents/{document}/{any_path=**}");

  /** Formats a string containing the fully-qualified path to represent a database_root resource. */
  public static final String formatDatabaseRootName(String project, String database) {
    return DATABASE_ROOT_PATH_TEMPLATE.instantiate(
        "project", project,
        "database", database);
  }

  /** Formats a string containing the fully-qualified path to represent a document_root resource. */
  public static final String formatDocumentRootName(String project, String database) {
    return DOCUMENT_ROOT_PATH_TEMPLATE.instantiate(
        "project", project,
        "database", database);
  }

  /** Formats a string containing the fully-qualified path to represent a document_path resource. */
  public static final String formatDocumentPathName(
      String project, String database, String documentPath) {
    return DOCUMENT_PATH_PATH_TEMPLATE.instantiate(
        "project", project,
        "database", database,
        "document_path", documentPath);
  }

  /** Formats a string containing the fully-qualified path to represent a any_path resource. */
  public static final String formatAnyPathName(
      String project, String database, String document, String anyPath) {
    return ANY_PATH_PATH_TEMPLATE.instantiate(
        "project", project,
        "database", database,
        "document", document,
        "any_path", anyPath);
  }

  /**
   * Parses the project from the given fully-qualified path which represents a database_root
   * resource.
   */
  public static final String parseProjectFromDatabaseRootName(String databaseRootName) {
    return DATABASE_ROOT_PATH_TEMPLATE.parse(databaseRootName).get("project");
  }

  /**
   * Parses the database from the given fully-qualified path which represents a database_root
   * resource.
   */
  public static final String parseDatabaseFromDatabaseRootName(String databaseRootName) {
    return DATABASE_ROOT_PATH_TEMPLATE.parse(databaseRootName).get("database");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a document_root
   * resource.
   */
  public static final String parseProjectFromDocumentRootName(String documentRootName) {
    return DOCUMENT_ROOT_PATH_TEMPLATE.parse(documentRootName).get("project");
  }

  /**
   * Parses the database from the given fully-qualified path which represents a document_root
   * resource.
   */
  public static final String parseDatabaseFromDocumentRootName(String documentRootName) {
    return DOCUMENT_ROOT_PATH_TEMPLATE.parse(documentRootName).get("database");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a document_path
   * resource.
   */
  public static final String parseProjectFromDocumentPathName(String documentPathName) {
    return DOCUMENT_PATH_PATH_TEMPLATE.parse(documentPathName).get("project");
  }

  /**
   * Parses the database from the given fully-qualified path which represents a document_path
   * resource.
   */
  public static final String parseDatabaseFromDocumentPathName(String documentPathName) {
    return DOCUMENT_PATH_PATH_TEMPLATE.parse(documentPathName).get("database");
  }

  /**
   * Parses the document_path from the given fully-qualified path which represents a document_path
   * resource.
   */
  public static final String parseDocumentPathFromDocumentPathName(String documentPathName) {
    return DOCUMENT_PATH_PATH_TEMPLATE.parse(documentPathName).get("document_path");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a any_path resource.
   */
  public static final String parseProjectFromAnyPathName(String anyPathName) {
    return ANY_PATH_PATH_TEMPLATE.parse(anyPathName).get("project");
  }

  /**
   * Parses the database from the given fully-qualified path which represents a any_path resource.
   */
  public static final String parseDatabaseFromAnyPathName(String anyPathName) {
    return ANY_PATH_PATH_TEMPLATE.parse(anyPathName).get("database");
  }

  /**
   * Parses the document from the given fully-qualified path which represents a any_path resource.
   */
  public static final String parseDocumentFromAnyPathName(String anyPathName) {
    return ANY_PATH_PATH_TEMPLATE.parse(anyPathName).get("document");
  }

  /**
   * Parses the any_path from the given fully-qualified path which represents a any_path resource.
   */
  public static final String parseAnyPathFromAnyPathName(String anyPathName) {
    return ANY_PATH_PATH_TEMPLATE.parse(anyPathName).get("any_path");
  }

  /** Constructs an instance of FirestoreClient with default settings. */
  public static final FirestoreClient create() throws IOException {
    return create(FirestoreSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FirestoreClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final FirestoreClient create(FirestoreSettings settings) throws IOException {
    return new FirestoreClient(settings);
  }

  /**
   * Constructs an instance of FirestoreClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use FirestoreSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final FirestoreClient create(FirestoreStub stub) {
    return new FirestoreClient(stub);
  }

  /**
   * Constructs an instance of FirestoreClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected FirestoreClient(FirestoreSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((FirestoreStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected FirestoreClient(FirestoreStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final FirestoreSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public FirestoreStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single document.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedName = FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");
   *   GetDocumentRequest request = GetDocumentRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Document response = firestoreClient.getDocument(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document getDocument(GetDocumentRequest request) {
    return getDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single document.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedName = FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");
   *   GetDocumentRequest request = GetDocumentRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Document&gt; future = firestoreClient.getDocumentCallable().futureCall(request);
   *   // Do something
   *   Document response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetDocumentRequest, Document> getDocumentCallable() {
    return stub.getDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists documents.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedParent = FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");
   *   String collectionId = "";
   *   ListDocumentsRequest request = ListDocumentsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setCollectionId(collectionId)
   *     .build();
   *   for (Document element : firestoreClient.listDocuments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDocumentsPagedResponse listDocuments(ListDocumentsRequest request) {
    return listDocumentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists documents.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedParent = FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");
   *   String collectionId = "";
   *   ListDocumentsRequest request = ListDocumentsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setCollectionId(collectionId)
   *     .build();
   *   ApiFuture&lt;ListDocumentsPagedResponse&gt; future = firestoreClient.listDocumentsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Document element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable() {
    return stub.listDocumentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists documents.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedParent = FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");
   *   String collectionId = "";
   *   ListDocumentsRequest request = ListDocumentsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setCollectionId(collectionId)
   *     .build();
   *   while (true) {
   *     ListDocumentsResponse response = firestoreClient.listDocumentsCallable().call(request);
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
   * </code></pre>
   */
  public final UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable() {
    return stub.listDocumentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new document.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedParent = FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");
   *   String collectionId = "";
   *   String documentId = "";
   *   Document document = Document.newBuilder().build();
   *   CreateDocumentRequest request = CreateDocumentRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setCollectionId(collectionId)
   *     .setDocumentId(documentId)
   *     .setDocument(document)
   *     .build();
   *   Document response = firestoreClient.createDocument(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document createDocument(CreateDocumentRequest request) {
    return createDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new document.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedParent = FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");
   *   String collectionId = "";
   *   String documentId = "";
   *   Document document = Document.newBuilder().build();
   *   CreateDocumentRequest request = CreateDocumentRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setCollectionId(collectionId)
   *     .setDocumentId(documentId)
   *     .setDocument(document)
   *     .build();
   *   ApiFuture&lt;Document&gt; future = firestoreClient.createDocumentCallable().futureCall(request);
   *   // Do something
   *   Document response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateDocumentRequest, Document> createDocumentCallable() {
    return stub.createDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates or inserts a document.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   DocumentMask updateMask = DocumentMask.newBuilder().build();
   *   Document response = firestoreClient.updateDocument(document, updateMask);
   * }
   * </code></pre>
   *
   * @param document The updated document. Creates the document if it does not already exist.
   * @param updateMask The fields to update. None of the field paths in the mask may contain a
   *     reserved name.
   *     <p>If the document exists on the server and has fields not referenced in the mask, they are
   *     left unchanged. Fields referenced in the mask, but not present in the input document, are
   *     deleted from the document on the server.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document updateDocument(Document document, DocumentMask updateMask) {

    UpdateDocumentRequest request =
        UpdateDocumentRequest.newBuilder().setDocument(document).setUpdateMask(updateMask).build();
    return updateDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates or inserts a document.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   DocumentMask updateMask = DocumentMask.newBuilder().build();
   *   UpdateDocumentRequest request = UpdateDocumentRequest.newBuilder()
   *     .setDocument(document)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   Document response = firestoreClient.updateDocument(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document updateDocument(UpdateDocumentRequest request) {
    return updateDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates or inserts a document.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   DocumentMask updateMask = DocumentMask.newBuilder().build();
   *   UpdateDocumentRequest request = UpdateDocumentRequest.newBuilder()
   *     .setDocument(document)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;Document&gt; future = firestoreClient.updateDocumentCallable().futureCall(request);
   *   // Do something
   *   Document response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateDocumentRequest, Document> updateDocumentCallable() {
    return stub.updateDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a document.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedName = FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");
   *   firestoreClient.deleteDocument(formattedName);
   * }
   * </code></pre>
   *
   * @param name The resource name of the Document to delete. In the format:
   *     `projects/{project_id}/databases/{database_id}/documents/{document_path}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDocument(String name) {
    ANY_PATH_PATH_TEMPLATE.validate(name, "deleteDocument");
    DeleteDocumentRequest request = DeleteDocumentRequest.newBuilder().setName(name).build();
    deleteDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a document.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedName = FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");
   *   DeleteDocumentRequest request = DeleteDocumentRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   firestoreClient.deleteDocument(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDocument(DeleteDocumentRequest request) {
    deleteDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a document.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedName = FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");
   *   DeleteDocumentRequest request = DeleteDocumentRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = firestoreClient.deleteDocumentCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteDocumentRequest, Empty> deleteDocumentCallable() {
    return stub.deleteDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets multiple documents.
   *
   * <p>Documents returned by this method are not guaranteed to be returned in the same order that
   * they were requested.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
   *   List&lt;String&gt; documents = new ArrayList&lt;&gt;();
   *   BatchGetDocumentsRequest request = BatchGetDocumentsRequest.newBuilder()
   *     .setDatabase(formattedDatabase)
   *     .addAllDocuments(documents)
   *     .build();
   *
   *   ServerStream&lt;BatchGetDocumentsResponse&gt; stream = firestoreClient.batchGetDocumentsCallable().call(request);
   *   for (BatchGetDocumentsResponse response : stream) {
   *     // Do something when receive a response
   *   }
   * }
   * </code></pre>
   */
  public final ServerStreamingCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsCallable() {
    return stub.batchGetDocumentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts a new transaction.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
   *   BeginTransactionResponse response = firestoreClient.beginTransaction(formattedDatabase);
   * }
   * </code></pre>
   *
   * @param database The database name. In the format:
   *     `projects/{project_id}/databases/{database_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BeginTransactionResponse beginTransaction(String database) {
    DATABASE_ROOT_PATH_TEMPLATE.validate(database, "beginTransaction");
    BeginTransactionRequest request =
        BeginTransactionRequest.newBuilder().setDatabase(database).build();
    return beginTransaction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts a new transaction.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
   *   BeginTransactionRequest request = BeginTransactionRequest.newBuilder()
   *     .setDatabase(formattedDatabase)
   *     .build();
   *   BeginTransactionResponse response = firestoreClient.beginTransaction(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BeginTransactionResponse beginTransaction(BeginTransactionRequest request) {
    return beginTransactionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts a new transaction.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
   *   BeginTransactionRequest request = BeginTransactionRequest.newBuilder()
   *     .setDatabase(formattedDatabase)
   *     .build();
   *   ApiFuture&lt;BeginTransactionResponse&gt; future = firestoreClient.beginTransactionCallable().futureCall(request);
   *   // Do something
   *   BeginTransactionResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionCallable() {
    return stub.beginTransactionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Commits a transaction, while optionally updating documents.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
   *   List&lt;Write&gt; writes = new ArrayList&lt;&gt;();
   *   CommitResponse response = firestoreClient.commit(formattedDatabase, writes);
   * }
   * </code></pre>
   *
   * @param database The database name. In the format:
   *     `projects/{project_id}/databases/{database_id}`.
   * @param writes The writes to apply.
   *     <p>Always executed atomically and in order.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CommitResponse commit(String database, List<Write> writes) {
    DATABASE_ROOT_PATH_TEMPLATE.validate(database, "commit");
    CommitRequest request =
        CommitRequest.newBuilder().setDatabase(database).addAllWrites(writes).build();
    return commit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Commits a transaction, while optionally updating documents.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
   *   List&lt;Write&gt; writes = new ArrayList&lt;&gt;();
   *   CommitRequest request = CommitRequest.newBuilder()
   *     .setDatabase(formattedDatabase)
   *     .addAllWrites(writes)
   *     .build();
   *   CommitResponse response = firestoreClient.commit(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CommitResponse commit(CommitRequest request) {
    return commitCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Commits a transaction, while optionally updating documents.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
   *   List&lt;Write&gt; writes = new ArrayList&lt;&gt;();
   *   CommitRequest request = CommitRequest.newBuilder()
   *     .setDatabase(formattedDatabase)
   *     .addAllWrites(writes)
   *     .build();
   *   ApiFuture&lt;CommitResponse&gt; future = firestoreClient.commitCallable().futureCall(request);
   *   // Do something
   *   CommitResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CommitRequest, CommitResponse> commitCallable() {
    return stub.commitCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Rolls back a transaction.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
   *   ByteString transaction = ByteString.copyFromUtf8("");
   *   firestoreClient.rollback(formattedDatabase, transaction);
   * }
   * </code></pre>
   *
   * @param database The database name. In the format:
   *     `projects/{project_id}/databases/{database_id}`.
   * @param transaction The transaction to roll back.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void rollback(String database, ByteString transaction) {
    DATABASE_ROOT_PATH_TEMPLATE.validate(database, "rollback");
    RollbackRequest request =
        RollbackRequest.newBuilder().setDatabase(database).setTransaction(transaction).build();
    rollback(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Rolls back a transaction.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
   *   ByteString transaction = ByteString.copyFromUtf8("");
   *   RollbackRequest request = RollbackRequest.newBuilder()
   *     .setDatabase(formattedDatabase)
   *     .setTransaction(transaction)
   *     .build();
   *   firestoreClient.rollback(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void rollback(RollbackRequest request) {
    rollbackCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Rolls back a transaction.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
   *   ByteString transaction = ByteString.copyFromUtf8("");
   *   RollbackRequest request = RollbackRequest.newBuilder()
   *     .setDatabase(formattedDatabase)
   *     .setTransaction(transaction)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = firestoreClient.rollbackCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RollbackRequest, Empty> rollbackCallable() {
    return stub.rollbackCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Runs a query.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedParent = FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");
   *   RunQueryRequest request = RunQueryRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *
   *   ServerStream&lt;RunQueryResponse&gt; stream = firestoreClient.runQueryCallable().call(request);
   *   for (RunQueryResponse response : stream) {
   *     // Do something when receive a response
   *   }
   * }
   * </code></pre>
   */
  public final ServerStreamingCallable<RunQueryRequest, RunQueryResponse> runQueryCallable() {
    return stub.runQueryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Streams batches of document updates and deletes, in order.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   BidiStream&lt;WriteRequest, WriteResponse&gt; bidiStream =
   *       firestoreClient.writeCallable().call();
   *
   *   String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
   *   WriteRequest request = WriteRequest.newBuilder()
   *     .setDatabase(formattedDatabase)
   *     .build();
   *   bidiStream.send(request);
   *   for (WriteResponse response : bidiStream) {
   *     // Do something when receive a response
   *   }
   * }
   * </code></pre>
   */
  public final BidiStreamingCallable<WriteRequest, WriteResponse> writeCallable() {
    return stub.writeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Listens to changes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   BidiStream&lt;ListenRequest, ListenResponse&gt; bidiStream =
   *       firestoreClient.listenCallable().call();
   *
   *   String formattedDatabase = FirestoreClient.formatDatabaseRootName("[PROJECT]", "[DATABASE]");
   *   ListenRequest request = ListenRequest.newBuilder()
   *     .setDatabase(formattedDatabase)
   *     .build();
   *   bidiStream.send(request);
   *   for (ListenResponse response : bidiStream) {
   *     // Do something when receive a response
   *   }
   * }
   * </code></pre>
   */
  public final BidiStreamingCallable<ListenRequest, ListenResponse> listenCallable() {
    return stub.listenCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the collection IDs underneath a document.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedParent = FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");
   *   for (String element : firestoreClient.listCollectionIds(formattedParent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent The parent document. In the format:
   *     `projects/{project_id}/databases/{database_id}/documents/{document_path}`. For example:
   *     `projects/my-project/databases/my-database/documents/chatrooms/my-chatroom`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCollectionIdsPagedResponse listCollectionIds(String parent) {
    ANY_PATH_PATH_TEMPLATE.validate(parent, "listCollectionIds");
    ListCollectionIdsRequest request =
        ListCollectionIdsRequest.newBuilder().setParent(parent).build();
    return listCollectionIds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the collection IDs underneath a document.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedParent = FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");
   *   ListCollectionIdsRequest request = ListCollectionIdsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   for (String element : firestoreClient.listCollectionIds(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCollectionIdsPagedResponse listCollectionIds(ListCollectionIdsRequest request) {
    return listCollectionIdsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the collection IDs underneath a document.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedParent = FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");
   *   ListCollectionIdsRequest request = ListCollectionIdsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;ListCollectionIdsPagedResponse&gt; future = firestoreClient.listCollectionIdsPagedCallable().futureCall(request);
   *   // Do something
   *   for (String element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsPagedResponse>
      listCollectionIdsPagedCallable() {
    return stub.listCollectionIdsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the collection IDs underneath a document.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String formattedParent = FirestoreClient.formatAnyPathName("[PROJECT]", "[DATABASE]", "[DOCUMENT]", "[ANY_PATH]");
   *   ListCollectionIdsRequest request = ListCollectionIdsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   while (true) {
   *     ListCollectionIdsResponse response = firestoreClient.listCollectionIdsCallable().call(request);
   *     for (String element : response.getCollectionIdsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsResponse>
      listCollectionIdsCallable() {
    return stub.listCollectionIdsCallable();
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

  public static class ListCollectionIdsPagedResponse
      extends AbstractPagedListResponse<
          ListCollectionIdsRequest,
          ListCollectionIdsResponse,
          String,
          ListCollectionIdsPage,
          ListCollectionIdsFixedSizeCollection> {

    public static ApiFuture<ListCollectionIdsPagedResponse> createAsync(
        PageContext<ListCollectionIdsRequest, ListCollectionIdsResponse, String> context,
        ApiFuture<ListCollectionIdsResponse> futureResponse) {
      ApiFuture<ListCollectionIdsPage> futurePage =
          ListCollectionIdsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListCollectionIdsPage, ListCollectionIdsPagedResponse>() {
            @Override
            public ListCollectionIdsPagedResponse apply(ListCollectionIdsPage input) {
              return new ListCollectionIdsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListCollectionIdsPagedResponse(ListCollectionIdsPage page) {
      super(page, ListCollectionIdsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCollectionIdsPage
      extends AbstractPage<
          ListCollectionIdsRequest, ListCollectionIdsResponse, String, ListCollectionIdsPage> {

    private ListCollectionIdsPage(
        PageContext<ListCollectionIdsRequest, ListCollectionIdsResponse, String> context,
        ListCollectionIdsResponse response) {
      super(context, response);
    }

    private static ListCollectionIdsPage createEmptyPage() {
      return new ListCollectionIdsPage(null, null);
    }

    @Override
    protected ListCollectionIdsPage createPage(
        PageContext<ListCollectionIdsRequest, ListCollectionIdsResponse, String> context,
        ListCollectionIdsResponse response) {
      return new ListCollectionIdsPage(context, response);
    }

    @Override
    public ApiFuture<ListCollectionIdsPage> createPageAsync(
        PageContext<ListCollectionIdsRequest, ListCollectionIdsResponse, String> context,
        ApiFuture<ListCollectionIdsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCollectionIdsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCollectionIdsRequest,
          ListCollectionIdsResponse,
          String,
          ListCollectionIdsPage,
          ListCollectionIdsFixedSizeCollection> {

    private ListCollectionIdsFixedSizeCollection(
        List<ListCollectionIdsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCollectionIdsFixedSizeCollection createEmptyCollection() {
      return new ListCollectionIdsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCollectionIdsFixedSizeCollection createCollection(
        List<ListCollectionIdsPage> pages, int collectionSize) {
      return new ListCollectionIdsFixedSizeCollection(pages, collectionSize);
    }
  }
}
