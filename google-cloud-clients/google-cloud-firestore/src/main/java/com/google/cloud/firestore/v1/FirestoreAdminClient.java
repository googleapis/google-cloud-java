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
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.firestore.v1.stub.FirestoreAdminStub;
import com.google.cloud.firestore.v1.stub.FirestoreAdminStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.firestore.admin.v1.CreateIndexRequest;
import com.google.firestore.admin.v1.DatabaseName;
import com.google.firestore.admin.v1.DeleteIndexRequest;
import com.google.firestore.admin.v1.ExportDocumentsRequest;
import com.google.firestore.admin.v1.Field;
import com.google.firestore.admin.v1.FieldName;
import com.google.firestore.admin.v1.GetFieldRequest;
import com.google.firestore.admin.v1.GetIndexRequest;
import com.google.firestore.admin.v1.ImportDocumentsRequest;
import com.google.firestore.admin.v1.Index;
import com.google.firestore.admin.v1.IndexName;
import com.google.firestore.admin.v1.ListFieldsRequest;
import com.google.firestore.admin.v1.ListFieldsResponse;
import com.google.firestore.admin.v1.ListIndexesRequest;
import com.google.firestore.admin.v1.ListIndexesResponse;
import com.google.firestore.admin.v1.ParentName;
import com.google.firestore.admin.v1.UpdateFieldRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Operations are created by service `FirestoreAdmin`, but are accessed via
 * service `google.longrunning.Operations`.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
 *   ParentName parent = ParentName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");
 *   Index index = Index.newBuilder().build();
 *   Operation response = firestoreAdminClient.createIndex(parent, index);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the firestoreAdminClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of FirestoreAdminSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * FirestoreAdminSettings firestoreAdminSettings =
 *     FirestoreAdminSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FirestoreAdminClient firestoreAdminClient =
 *     FirestoreAdminClient.create(firestoreAdminSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * FirestoreAdminSettings firestoreAdminSettings =
 *     FirestoreAdminSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FirestoreAdminClient firestoreAdminClient =
 *     FirestoreAdminClient.create(firestoreAdminSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class FirestoreAdminClient implements BackgroundResource {
  private final FirestoreAdminSettings settings;
  private final FirestoreAdminStub stub;

  /** Constructs an instance of FirestoreAdminClient with default settings. */
  public static final FirestoreAdminClient create() throws IOException {
    return create(FirestoreAdminSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FirestoreAdminClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final FirestoreAdminClient create(FirestoreAdminSettings settings)
      throws IOException {
    return new FirestoreAdminClient(settings);
  }

  /**
   * Constructs an instance of FirestoreAdminClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use FirestoreAdminSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final FirestoreAdminClient create(FirestoreAdminStub stub) {
    return new FirestoreAdminClient(stub);
  }

  /**
   * Constructs an instance of FirestoreAdminClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected FirestoreAdminClient(FirestoreAdminSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((FirestoreAdminStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected FirestoreAdminClient(FirestoreAdminStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final FirestoreAdminSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public FirestoreAdminStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a composite index. This returns a
   * [google.longrunning.Operation][google.longrunning.Operation] which may be used to track the
   * status of the creation. The metadata for the operation will be the type
   * [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ParentName parent = ParentName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");
   *   Index index = Index.newBuilder().build();
   *   Operation response = firestoreAdminClient.createIndex(parent, index);
   * }
   * </code></pre>
   *
   * @param parent A parent name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}`
   * @param index The composite index to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createIndex(ParentName parent, Index index) {

    CreateIndexRequest request =
        CreateIndexRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setIndex(index)
            .build();
    return createIndex(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a composite index. This returns a
   * [google.longrunning.Operation][google.longrunning.Operation] which may be used to track the
   * status of the creation. The metadata for the operation will be the type
   * [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ParentName parent = ParentName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");
   *   Index index = Index.newBuilder().build();
   *   Operation response = firestoreAdminClient.createIndex(parent.toString(), index);
   * }
   * </code></pre>
   *
   * @param parent A parent name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}`
   * @param index The composite index to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createIndex(String parent, Index index) {

    CreateIndexRequest request =
        CreateIndexRequest.newBuilder().setParent(parent).setIndex(index).build();
    return createIndex(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a composite index. This returns a
   * [google.longrunning.Operation][google.longrunning.Operation] which may be used to track the
   * status of the creation. The metadata for the operation will be the type
   * [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ParentName parent = ParentName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");
   *   Index index = Index.newBuilder().build();
   *   CreateIndexRequest request = CreateIndexRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setIndex(index)
   *     .build();
   *   Operation response = firestoreAdminClient.createIndex(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation createIndex(CreateIndexRequest request) {
    return createIndexCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a composite index. This returns a
   * [google.longrunning.Operation][google.longrunning.Operation] which may be used to track the
   * status of the creation. The metadata for the operation will be the type
   * [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ParentName parent = ParentName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");
   *   Index index = Index.newBuilder().build();
   *   CreateIndexRequest request = CreateIndexRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setIndex(index)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = firestoreAdminClient.createIndexCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateIndexRequest, Operation> createIndexCallable() {
    return stub.createIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists composite indexes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ParentName parent = ParentName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");
   *   for (Index element : firestoreAdminClient.listIndexes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent A parent name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexesPagedResponse listIndexes(ParentName parent) {
    ListIndexesRequest request =
        ListIndexesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listIndexes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists composite indexes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ParentName parent = ParentName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");
   *   for (Index element : firestoreAdminClient.listIndexes(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent A parent name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexesPagedResponse listIndexes(String parent) {
    ListIndexesRequest request = ListIndexesRequest.newBuilder().setParent(parent).build();
    return listIndexes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists composite indexes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ParentName parent = ParentName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");
   *   ListIndexesRequest request = ListIndexesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (Index element : firestoreAdminClient.listIndexes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexesPagedResponse listIndexes(ListIndexesRequest request) {
    return listIndexesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists composite indexes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ParentName parent = ParentName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");
   *   ListIndexesRequest request = ListIndexesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListIndexesPagedResponse&gt; future = firestoreAdminClient.listIndexesPagedCallable().futureCall(request);
   *   // Do something
   *   for (Index element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse>
      listIndexesPagedCallable() {
    return stub.listIndexesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists composite indexes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ParentName parent = ParentName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");
   *   ListIndexesRequest request = ListIndexesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListIndexesResponse response = firestoreAdminClient.listIndexesCallable().call(request);
   *     for (Index element : response.getIndexesList()) {
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
  public final UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable() {
    return stub.listIndexesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a composite index.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   IndexName name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]", "[INDEX_ID]");
   *   Index response = firestoreAdminClient.getIndex(name);
   * }
   * </code></pre>
   *
   * @param name A name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}/indexes/{index_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Index getIndex(IndexName name) {

    GetIndexRequest request =
        GetIndexRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getIndex(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a composite index.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   IndexName name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]", "[INDEX_ID]");
   *   Index response = firestoreAdminClient.getIndex(name.toString());
   * }
   * </code></pre>
   *
   * @param name A name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}/indexes/{index_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Index getIndex(String name) {

    GetIndexRequest request = GetIndexRequest.newBuilder().setName(name).build();
    return getIndex(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a composite index.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   IndexName name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]", "[INDEX_ID]");
   *   GetIndexRequest request = GetIndexRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Index response = firestoreAdminClient.getIndex(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Index getIndex(GetIndexRequest request) {
    return getIndexCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a composite index.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   IndexName name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]", "[INDEX_ID]");
   *   GetIndexRequest request = GetIndexRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Index&gt; future = firestoreAdminClient.getIndexCallable().futureCall(request);
   *   // Do something
   *   Index response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetIndexRequest, Index> getIndexCallable() {
    return stub.getIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a composite index.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   IndexName name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]", "[INDEX_ID]");
   *   firestoreAdminClient.deleteIndex(name);
   * }
   * </code></pre>
   *
   * @param name A name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}/indexes/{index_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteIndex(IndexName name) {

    DeleteIndexRequest request =
        DeleteIndexRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteIndex(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a composite index.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   IndexName name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]", "[INDEX_ID]");
   *   firestoreAdminClient.deleteIndex(name.toString());
   * }
   * </code></pre>
   *
   * @param name A name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}/indexes/{index_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteIndex(String name) {

    DeleteIndexRequest request = DeleteIndexRequest.newBuilder().setName(name).build();
    deleteIndex(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a composite index.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   IndexName name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]", "[INDEX_ID]");
   *   DeleteIndexRequest request = DeleteIndexRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   firestoreAdminClient.deleteIndex(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteIndex(DeleteIndexRequest request) {
    deleteIndexCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a composite index.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   IndexName name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]", "[INDEX_ID]");
   *   DeleteIndexRequest request = DeleteIndexRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = firestoreAdminClient.deleteIndexCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteIndexRequest, Empty> deleteIndexCallable() {
    return stub.deleteIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Imports documents into Google Cloud Firestore. Existing documents with the same name are
   * overwritten. The import occurs in the background and its progress can be monitored and managed
   * via the Operation resource that is created. If an ImportDocuments operation is cancelled, it is
   * possible that a subset of the data has already been imported to Cloud Firestore.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
   *   Operation response = firestoreAdminClient.importDocuments(name);
   * }
   * </code></pre>
   *
   * @param name Database to import into. Should be of the form:
   *     `projects/{project_id}/databases/{database_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation importDocuments(DatabaseName name) {

    ImportDocumentsRequest request =
        ImportDocumentsRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return importDocuments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Imports documents into Google Cloud Firestore. Existing documents with the same name are
   * overwritten. The import occurs in the background and its progress can be monitored and managed
   * via the Operation resource that is created. If an ImportDocuments operation is cancelled, it is
   * possible that a subset of the data has already been imported to Cloud Firestore.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
   *   Operation response = firestoreAdminClient.importDocuments(name.toString());
   * }
   * </code></pre>
   *
   * @param name Database to import into. Should be of the form:
   *     `projects/{project_id}/databases/{database_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation importDocuments(String name) {

    ImportDocumentsRequest request = ImportDocumentsRequest.newBuilder().setName(name).build();
    return importDocuments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Imports documents into Google Cloud Firestore. Existing documents with the same name are
   * overwritten. The import occurs in the background and its progress can be monitored and managed
   * via the Operation resource that is created. If an ImportDocuments operation is cancelled, it is
   * possible that a subset of the data has already been imported to Cloud Firestore.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
   *   ImportDocumentsRequest request = ImportDocumentsRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Operation response = firestoreAdminClient.importDocuments(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation importDocuments(ImportDocumentsRequest request) {
    return importDocumentsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Imports documents into Google Cloud Firestore. Existing documents with the same name are
   * overwritten. The import occurs in the background and its progress can be monitored and managed
   * via the Operation resource that is created. If an ImportDocuments operation is cancelled, it is
   * possible that a subset of the data has already been imported to Cloud Firestore.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
   *   ImportDocumentsRequest request = ImportDocumentsRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = firestoreAdminClient.importDocumentsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable() {
    return stub.importDocumentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Exports a copy of all or a subset of documents from Google Cloud Firestore to another storage
   * system, such as Google Cloud Storage. Recent updates to documents may not be reflected in the
   * export. The export occurs in the background and its progress can be monitored and managed via
   * the Operation resource that is created. The output of an export may only be used once the
   * associated operation is done. If an export operation is cancelled before completion it may
   * leave partial data behind in Google Cloud Storage.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
   *   Operation response = firestoreAdminClient.exportDocuments(name);
   * }
   * </code></pre>
   *
   * @param name Database to export. Should be of the form:
   *     `projects/{project_id}/databases/{database_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation exportDocuments(DatabaseName name) {

    ExportDocumentsRequest request =
        ExportDocumentsRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return exportDocuments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Exports a copy of all or a subset of documents from Google Cloud Firestore to another storage
   * system, such as Google Cloud Storage. Recent updates to documents may not be reflected in the
   * export. The export occurs in the background and its progress can be monitored and managed via
   * the Operation resource that is created. The output of an export may only be used once the
   * associated operation is done. If an export operation is cancelled before completion it may
   * leave partial data behind in Google Cloud Storage.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
   *   Operation response = firestoreAdminClient.exportDocuments(name.toString());
   * }
   * </code></pre>
   *
   * @param name Database to export. Should be of the form:
   *     `projects/{project_id}/databases/{database_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation exportDocuments(String name) {

    ExportDocumentsRequest request = ExportDocumentsRequest.newBuilder().setName(name).build();
    return exportDocuments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Exports a copy of all or a subset of documents from Google Cloud Firestore to another storage
   * system, such as Google Cloud Storage. Recent updates to documents may not be reflected in the
   * export. The export occurs in the background and its progress can be monitored and managed via
   * the Operation resource that is created. The output of an export may only be used once the
   * associated operation is done. If an export operation is cancelled before completion it may
   * leave partial data behind in Google Cloud Storage.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
   *   ExportDocumentsRequest request = ExportDocumentsRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Operation response = firestoreAdminClient.exportDocuments(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation exportDocuments(ExportDocumentsRequest request) {
    return exportDocumentsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Exports a copy of all or a subset of documents from Google Cloud Firestore to another storage
   * system, such as Google Cloud Storage. Recent updates to documents may not be reflected in the
   * export. The export occurs in the background and its progress can be monitored and managed via
   * the Operation resource that is created. The output of an export may only be used once the
   * associated operation is done. If an export operation is cancelled before completion it may
   * leave partial data behind in Google Cloud Storage.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
   *   ExportDocumentsRequest request = ExportDocumentsRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = firestoreAdminClient.exportDocumentsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ExportDocumentsRequest, Operation> exportDocumentsCallable() {
    return stub.exportDocumentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the metadata and configuration for a Field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   FieldName name = FieldName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]", "[FIELD_ID]");
   *   Field response = firestoreAdminClient.getField(name);
   * }
   * </code></pre>
   *
   * @param name A name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}/fields/{field_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Field getField(FieldName name) {

    GetFieldRequest request =
        GetFieldRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the metadata and configuration for a Field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   FieldName name = FieldName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]", "[FIELD_ID]");
   *   Field response = firestoreAdminClient.getField(name.toString());
   * }
   * </code></pre>
   *
   * @param name A name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}/fields/{field_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Field getField(String name) {

    GetFieldRequest request = GetFieldRequest.newBuilder().setName(name).build();
    return getField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the metadata and configuration for a Field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   FieldName name = FieldName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]", "[FIELD_ID]");
   *   GetFieldRequest request = GetFieldRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Field response = firestoreAdminClient.getField(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Field getField(GetFieldRequest request) {
    return getFieldCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the metadata and configuration for a Field.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   FieldName name = FieldName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]", "[FIELD_ID]");
   *   GetFieldRequest request = GetFieldRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Field&gt; future = firestoreAdminClient.getFieldCallable().futureCall(request);
   *   // Do something
   *   Field response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetFieldRequest, Field> getFieldCallable() {
    return stub.getFieldCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the field configuration and metadata for this database.
   *
   * <p>Currently, [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
   * only supports listing fields that have been explicitly overridden. To issue this query, call
   * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] with the
   * filter set to `indexConfig.usesAncestorConfig:false`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ParentName parent = ParentName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");
   *   for (Field element : firestoreAdminClient.listFields(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent A parent name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFieldsPagedResponse listFields(ParentName parent) {
    ListFieldsRequest request =
        ListFieldsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listFields(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the field configuration and metadata for this database.
   *
   * <p>Currently, [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
   * only supports listing fields that have been explicitly overridden. To issue this query, call
   * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] with the
   * filter set to `indexConfig.usesAncestorConfig:false`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ParentName parent = ParentName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");
   *   for (Field element : firestoreAdminClient.listFields(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent A parent name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFieldsPagedResponse listFields(String parent) {
    ListFieldsRequest request = ListFieldsRequest.newBuilder().setParent(parent).build();
    return listFields(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the field configuration and metadata for this database.
   *
   * <p>Currently, [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
   * only supports listing fields that have been explicitly overridden. To issue this query, call
   * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] with the
   * filter set to `indexConfig.usesAncestorConfig:false`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ParentName parent = ParentName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");
   *   ListFieldsRequest request = ListFieldsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (Field element : firestoreAdminClient.listFields(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFieldsPagedResponse listFields(ListFieldsRequest request) {
    return listFieldsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the field configuration and metadata for this database.
   *
   * <p>Currently, [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
   * only supports listing fields that have been explicitly overridden. To issue this query, call
   * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] with the
   * filter set to `indexConfig.usesAncestorConfig:false`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ParentName parent = ParentName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");
   *   ListFieldsRequest request = ListFieldsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListFieldsPagedResponse&gt; future = firestoreAdminClient.listFieldsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Field element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListFieldsRequest, ListFieldsPagedResponse> listFieldsPagedCallable() {
    return stub.listFieldsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the field configuration and metadata for this database.
   *
   * <p>Currently, [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
   * only supports listing fields that have been explicitly overridden. To issue this query, call
   * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] with the
   * filter set to `indexConfig.usesAncestorConfig:false`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ParentName parent = ParentName.of("[PROJECT]", "[DATABASE]", "[COLLECTION_ID]");
   *   ListFieldsRequest request = ListFieldsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListFieldsResponse response = firestoreAdminClient.listFieldsCallable().call(request);
   *     for (Field element : response.getFieldsList()) {
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
  public final UnaryCallable<ListFieldsRequest, ListFieldsResponse> listFieldsCallable() {
    return stub.listFieldsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a field configuration. Currently, field updates apply only to single field index
   * configuration. However, calls to
   * [FirestoreAdmin.UpdateField][google.firestore.admin.v1.FirestoreAdmin.UpdateField] should
   * provide a field mask to avoid changing any configuration that the caller isn't aware of. The
   * field mask should be specified as: `{ paths: "index_config" }`.
   *
   * <p>This call returns a [google.longrunning.Operation][google.longrunning.Operation] which may
   * be used to track the status of the field update. The metadata for the operation will be the
   * type [FieldOperationMetadata][google.firestore.admin.v1.FieldOperationMetadata].
   *
   * <p>To configure the default field settings for the database, use the special `Field` with
   * resource name:
   * `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/&#42;`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   Field field = Field.newBuilder().build();
   *   Operation response = firestoreAdminClient.updateField(field);
   * }
   * </code></pre>
   *
   * @param field The field to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateField(Field field) {

    UpdateFieldRequest request = UpdateFieldRequest.newBuilder().setField(field).build();
    return updateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a field configuration. Currently, field updates apply only to single field index
   * configuration. However, calls to
   * [FirestoreAdmin.UpdateField][google.firestore.admin.v1.FirestoreAdmin.UpdateField] should
   * provide a field mask to avoid changing any configuration that the caller isn't aware of. The
   * field mask should be specified as: `{ paths: "index_config" }`.
   *
   * <p>This call returns a [google.longrunning.Operation][google.longrunning.Operation] which may
   * be used to track the status of the field update. The metadata for the operation will be the
   * type [FieldOperationMetadata][google.firestore.admin.v1.FieldOperationMetadata].
   *
   * <p>To configure the default field settings for the database, use the special `Field` with
   * resource name:
   * `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/&#42;`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   Field field = Field.newBuilder().build();
   *   UpdateFieldRequest request = UpdateFieldRequest.newBuilder()
   *     .setField(field)
   *     .build();
   *   Operation response = firestoreAdminClient.updateField(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation updateField(UpdateFieldRequest request) {
    return updateFieldCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a field configuration. Currently, field updates apply only to single field index
   * configuration. However, calls to
   * [FirestoreAdmin.UpdateField][google.firestore.admin.v1.FirestoreAdmin.UpdateField] should
   * provide a field mask to avoid changing any configuration that the caller isn't aware of. The
   * field mask should be specified as: `{ paths: "index_config" }`.
   *
   * <p>This call returns a [google.longrunning.Operation][google.longrunning.Operation] which may
   * be used to track the status of the field update. The metadata for the operation will be the
   * type [FieldOperationMetadata][google.firestore.admin.v1.FieldOperationMetadata].
   *
   * <p>To configure the default field settings for the database, use the special `Field` with
   * resource name:
   * `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/&#42;`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   Field field = Field.newBuilder().build();
   *   UpdateFieldRequest request = UpdateFieldRequest.newBuilder()
   *     .setField(field)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = firestoreAdminClient.updateFieldCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateFieldRequest, Operation> updateFieldCallable() {
    return stub.updateFieldCallable();
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

  public static class ListIndexesPagedResponse
      extends AbstractPagedListResponse<
          ListIndexesRequest,
          ListIndexesResponse,
          Index,
          ListIndexesPage,
          ListIndexesFixedSizeCollection> {

    public static ApiFuture<ListIndexesPagedResponse> createAsync(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ApiFuture<ListIndexesResponse> futureResponse) {
      ApiFuture<ListIndexesPage> futurePage =
          ListIndexesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListIndexesPage, ListIndexesPagedResponse>() {
            @Override
            public ListIndexesPagedResponse apply(ListIndexesPage input) {
              return new ListIndexesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListIndexesPagedResponse(ListIndexesPage page) {
      super(page, ListIndexesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListIndexesPage
      extends AbstractPage<ListIndexesRequest, ListIndexesResponse, Index, ListIndexesPage> {

    private ListIndexesPage(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ListIndexesResponse response) {
      super(context, response);
    }

    private static ListIndexesPage createEmptyPage() {
      return new ListIndexesPage(null, null);
    }

    @Override
    protected ListIndexesPage createPage(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ListIndexesResponse response) {
      return new ListIndexesPage(context, response);
    }

    @Override
    public ApiFuture<ListIndexesPage> createPageAsync(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ApiFuture<ListIndexesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListIndexesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListIndexesRequest,
          ListIndexesResponse,
          Index,
          ListIndexesPage,
          ListIndexesFixedSizeCollection> {

    private ListIndexesFixedSizeCollection(List<ListIndexesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIndexesFixedSizeCollection createEmptyCollection() {
      return new ListIndexesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListIndexesFixedSizeCollection createCollection(
        List<ListIndexesPage> pages, int collectionSize) {
      return new ListIndexesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFieldsPagedResponse
      extends AbstractPagedListResponse<
          ListFieldsRequest,
          ListFieldsResponse,
          Field,
          ListFieldsPage,
          ListFieldsFixedSizeCollection> {

    public static ApiFuture<ListFieldsPagedResponse> createAsync(
        PageContext<ListFieldsRequest, ListFieldsResponse, Field> context,
        ApiFuture<ListFieldsResponse> futureResponse) {
      ApiFuture<ListFieldsPage> futurePage =
          ListFieldsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListFieldsPage, ListFieldsPagedResponse>() {
            @Override
            public ListFieldsPagedResponse apply(ListFieldsPage input) {
              return new ListFieldsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListFieldsPagedResponse(ListFieldsPage page) {
      super(page, ListFieldsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFieldsPage
      extends AbstractPage<ListFieldsRequest, ListFieldsResponse, Field, ListFieldsPage> {

    private ListFieldsPage(
        PageContext<ListFieldsRequest, ListFieldsResponse, Field> context,
        ListFieldsResponse response) {
      super(context, response);
    }

    private static ListFieldsPage createEmptyPage() {
      return new ListFieldsPage(null, null);
    }

    @Override
    protected ListFieldsPage createPage(
        PageContext<ListFieldsRequest, ListFieldsResponse, Field> context,
        ListFieldsResponse response) {
      return new ListFieldsPage(context, response);
    }

    @Override
    public ApiFuture<ListFieldsPage> createPageAsync(
        PageContext<ListFieldsRequest, ListFieldsResponse, Field> context,
        ApiFuture<ListFieldsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFieldsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFieldsRequest,
          ListFieldsResponse,
          Field,
          ListFieldsPage,
          ListFieldsFixedSizeCollection> {

    private ListFieldsFixedSizeCollection(List<ListFieldsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFieldsFixedSizeCollection createEmptyCollection() {
      return new ListFieldsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFieldsFixedSizeCollection createCollection(
        List<ListFieldsPage> pages, int collectionSize) {
      return new ListFieldsFixedSizeCollection(pages, collectionSize);
    }
  }
}
