/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.firestore.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.firestore.v1.stub.FirestoreStub;
import com.google.cloud.firestore.v1.stub.FirestoreStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.BatchWriteRequest;
import com.google.firestore.v1.BatchWriteResponse;
import com.google.firestore.v1.BeginTransactionRequest;
import com.google.firestore.v1.BeginTransactionResponse;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.CreateDocumentRequest;
import com.google.firestore.v1.Cursor;
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
import com.google.firestore.v1.PartitionQueryRequest;
import com.google.firestore.v1.PartitionQueryResponse;
import com.google.firestore.v1.RollbackRequest;
import com.google.firestore.v1.RunAggregationQueryRequest;
import com.google.firestore.v1.RunAggregationQueryResponse;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Cloud Firestore service.
 *
 * <p>Cloud Firestore is a fast, fully managed, serverless, cloud-native NoSQL document database
 * that simplifies storing, syncing, and querying data for your mobile, web, and IoT apps at global
 * scale. Its client libraries provide live synchronization and offline support, while its security
 * features and integrations with Firebase and Google Cloud Platform accelerate building truly
 * serverless apps.
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
 * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
 *   GetDocumentRequest request =
 *       GetDocumentRequest.newBuilder()
 *           .setName("name3373707")
 *           .setMask(DocumentMask.newBuilder().build())
 *           .build();
 *   Document response = firestoreClient.getDocument(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the FirestoreClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetDocument</td>
 *      <td><p> Gets a single document.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDocument(GetDocumentRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDocumentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDocuments</td>
 *      <td><p> Lists documents.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDocuments(ListDocumentsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDocumentsPagedCallable()
 *           <li><p> listDocumentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDocument</td>
 *      <td><p> Updates or inserts a document.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDocument(UpdateDocumentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDocument(Document document, DocumentMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDocumentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDocument</td>
 *      <td><p> Deletes a document.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDocument(DeleteDocumentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteDocument(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDocumentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchGetDocuments</td>
 *      <td><p> Gets multiple documents.
 * <p>  Documents returned by this method are not guaranteed to be returned in the same order that they were requested.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchGetDocumentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BeginTransaction</td>
 *      <td><p> Starts a new transaction.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> beginTransaction(BeginTransactionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> beginTransaction(String database)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> beginTransactionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Commit</td>
 *      <td><p> Commits a transaction, while optionally updating documents.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> commit(CommitRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> commit(String database, List&lt;Write&gt; writes)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> commitCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Rollback</td>
 *      <td><p> Rolls back a transaction.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rollback(RollbackRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> rollback(String database, ByteString transaction)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rollbackCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RunQuery</td>
 *      <td><p> Runs a query.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runQueryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RunAggregationQuery</td>
 *      <td><p> Runs an aggregation query.
 * <p>  Rather than producing [Document][google.firestore.v1.Document] results like [Firestore.RunQuery][google.firestore.v1.Firestore.RunQuery], this API allows running an aggregation to produce a series of [AggregationResult][google.firestore.v1.AggregationResult] server-side.
 * <p>  High-Level Example:
 * <p>  ``` -- Return the number of documents in table given a filter. SELECT COUNT(&#42;) FROM ( SELECT &#42; FROM k where a = true ); ```</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runAggregationQueryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PartitionQuery</td>
 *      <td><p> Partitions a query by returning partition cursors that can be used to run the query in parallel. The returned partition cursors are split points that can be used by RunQuery as starting/end points for the query results.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> partitionQuery(PartitionQueryRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> partitionQueryPagedCallable()
 *           <li><p> partitionQueryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Write</td>
 *      <td><p> Streams batches of document updates and deletes, in order. This method is only available via gRPC or WebChannel (not REST).</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> writeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Listen</td>
 *      <td><p> Listens to changes. This method is only available via gRPC or WebChannel (not REST).</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listenCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCollectionIds</td>
 *      <td><p> Lists all the collection IDs underneath a document.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCollectionIds(ListCollectionIdsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCollectionIds(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCollectionIdsPagedCallable()
 *           <li><p> listCollectionIdsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchWrite</td>
 *      <td><p> Applies a batch of write operations.
 * <p>  The BatchWrite method does not apply the write operations atomically and can apply them out of order. Method does not allow more than one write per document. Each write succeeds or fails independently. See the [BatchWriteResponse][google.firestore.v1.BatchWriteResponse] for the success status of each write.
 * <p>  If you require an atomically applied set of writes, use [Commit][google.firestore.v1.Firestore.Commit] instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchWrite(BatchWriteRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchWriteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDocument</td>
 *      <td><p> Creates a new document.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDocument(CreateDocumentRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDocumentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
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
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FirestoreSettings firestoreSettings =
 *     FirestoreSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FirestoreClient firestoreClient = FirestoreClient.create(firestoreSettings);
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
 * FirestoreSettings firestoreSettings =
 *     FirestoreSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FirestoreClient firestoreClient = FirestoreClient.create(firestoreSettings);
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
 * FirestoreSettings firestoreSettings = FirestoreSettings.newHttpJsonBuilder().build();
 * FirestoreClient firestoreClient = FirestoreClient.create(firestoreSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class FirestoreClient implements BackgroundResource {
  private final FirestoreSettings settings;
  private final FirestoreStub stub;

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
   * advanced usage - prefer using create(FirestoreSettings).
   */
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

  protected FirestoreClient(FirestoreStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final FirestoreSettings getSettings() {
    return settings;
  }

  public FirestoreStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   GetDocumentRequest request =
   *       GetDocumentRequest.newBuilder()
   *           .setName("name3373707")
   *           .setMask(DocumentMask.newBuilder().build())
   *           .build();
   *   Document response = firestoreClient.getDocument(request);
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
   * Gets a single document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   GetDocumentRequest request =
   *       GetDocumentRequest.newBuilder()
   *           .setName("name3373707")
   *           .setMask(DocumentMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Document> future = firestoreClient.getDocumentCallable().futureCall(request);
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
   * Lists documents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   ListDocumentsRequest request =
   *       ListDocumentsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCollectionId("collectionId1636075609")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setMask(DocumentMask.newBuilder().build())
   *           .setShowMissing(true)
   *           .build();
   *   for (Document element : firestoreClient.listDocuments(request).iterateAll()) {
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
   * Lists documents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   ListDocumentsRequest request =
   *       ListDocumentsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCollectionId("collectionId1636075609")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setMask(DocumentMask.newBuilder().build())
   *           .setShowMissing(true)
   *           .build();
   *   ApiFuture<Document> future = firestoreClient.listDocumentsPagedCallable().futureCall(request);
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
   * Lists documents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   ListDocumentsRequest request =
   *       ListDocumentsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCollectionId("collectionId1636075609")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setMask(DocumentMask.newBuilder().build())
   *           .setShowMissing(true)
   *           .build();
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
   * }</pre>
   */
  public final UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable() {
    return stub.listDocumentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates or inserts a document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   DocumentMask updateMask = DocumentMask.newBuilder().build();
   *   Document response = firestoreClient.updateDocument(document, updateMask);
   * }
   * }</pre>
   *
   * @param document Required. The updated document. Creates the document if it does not already
   *     exist.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates or inserts a document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   UpdateDocumentRequest request =
   *       UpdateDocumentRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setUpdateMask(DocumentMask.newBuilder().build())
   *           .setMask(DocumentMask.newBuilder().build())
   *           .setCurrentDocument(Precondition.newBuilder().build())
   *           .build();
   *   Document response = firestoreClient.updateDocument(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document updateDocument(UpdateDocumentRequest request) {
    return updateDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates or inserts a document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   UpdateDocumentRequest request =
   *       UpdateDocumentRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setUpdateMask(DocumentMask.newBuilder().build())
   *           .setMask(DocumentMask.newBuilder().build())
   *           .setCurrentDocument(Precondition.newBuilder().build())
   *           .build();
   *   ApiFuture<Document> future = firestoreClient.updateDocumentCallable().futureCall(request);
   *   // Do something.
   *   Document response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDocumentRequest, Document> updateDocumentCallable() {
    return stub.updateDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String name = "name3373707";
   *   firestoreClient.deleteDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Document to delete. In the format:
   *     `projects/{project_id}/databases/{database_id}/documents/{document_path}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDocument(String name) {
    DeleteDocumentRequest request = DeleteDocumentRequest.newBuilder().setName(name).build();
    deleteDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   DeleteDocumentRequest request =
   *       DeleteDocumentRequest.newBuilder()
   *           .setName("name3373707")
   *           .setCurrentDocument(Precondition.newBuilder().build())
   *           .build();
   *   firestoreClient.deleteDocument(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDocument(DeleteDocumentRequest request) {
    deleteDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   DeleteDocumentRequest request =
   *       DeleteDocumentRequest.newBuilder()
   *           .setName("name3373707")
   *           .setCurrentDocument(Precondition.newBuilder().build())
   *           .build();
   *   ApiFuture<Empty> future = firestoreClient.deleteDocumentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDocumentRequest, Empty> deleteDocumentCallable() {
    return stub.deleteDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets multiple documents.
   *
   * <p>Documents returned by this method are not guaranteed to be returned in the same order that
   * they were requested.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   BatchGetDocumentsRequest request =
   *       BatchGetDocumentsRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .addAllDocuments(new ArrayList<String>())
   *           .setMask(DocumentMask.newBuilder().build())
   *           .build();
   *   ServerStream<BatchGetDocumentsResponse> stream =
   *       firestoreClient.batchGetDocumentsCallable().call(request);
   *   for (BatchGetDocumentsResponse response : stream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final ServerStreamingCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsCallable() {
    return stub.batchGetDocumentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a new transaction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String database = "database1789464955";
   *   BeginTransactionResponse response = firestoreClient.beginTransaction(database);
   * }
   * }</pre>
   *
   * @param database Required. The database name. In the format:
   *     `projects/{project_id}/databases/{database_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BeginTransactionResponse beginTransaction(String database) {
    BeginTransactionRequest request =
        BeginTransactionRequest.newBuilder().setDatabase(database).build();
    return beginTransaction(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a new transaction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   BeginTransactionRequest request =
   *       BeginTransactionRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .setOptions(TransactionOptions.newBuilder().build())
   *           .build();
   *   BeginTransactionResponse response = firestoreClient.beginTransaction(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BeginTransactionResponse beginTransaction(BeginTransactionRequest request) {
    return beginTransactionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a new transaction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   BeginTransactionRequest request =
   *       BeginTransactionRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .setOptions(TransactionOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<BeginTransactionResponse> future =
   *       firestoreClient.beginTransactionCallable().futureCall(request);
   *   // Do something.
   *   BeginTransactionResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionCallable() {
    return stub.beginTransactionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Commits a transaction, while optionally updating documents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String database = "database1789464955";
   *   List<Write> writes = new ArrayList<>();
   *   CommitResponse response = firestoreClient.commit(database, writes);
   * }
   * }</pre>
   *
   * @param database Required. The database name. In the format:
   *     `projects/{project_id}/databases/{database_id}`.
   * @param writes The writes to apply.
   *     <p>Always executed atomically and in order.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CommitResponse commit(String database, List<Write> writes) {
    CommitRequest request =
        CommitRequest.newBuilder().setDatabase(database).addAllWrites(writes).build();
    return commit(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Commits a transaction, while optionally updating documents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   CommitRequest request =
   *       CommitRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .addAllWrites(new ArrayList<Write>())
   *           .setTransaction(ByteString.EMPTY)
   *           .build();
   *   CommitResponse response = firestoreClient.commit(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CommitResponse commit(CommitRequest request) {
    return commitCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Commits a transaction, while optionally updating documents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   CommitRequest request =
   *       CommitRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .addAllWrites(new ArrayList<Write>())
   *           .setTransaction(ByteString.EMPTY)
   *           .build();
   *   ApiFuture<CommitResponse> future = firestoreClient.commitCallable().futureCall(request);
   *   // Do something.
   *   CommitResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CommitRequest, CommitResponse> commitCallable() {
    return stub.commitCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rolls back a transaction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String database = "database1789464955";
   *   ByteString transaction = ByteString.EMPTY;
   *   firestoreClient.rollback(database, transaction);
   * }
   * }</pre>
   *
   * @param database Required. The database name. In the format:
   *     `projects/{project_id}/databases/{database_id}`.
   * @param transaction Required. The transaction to roll back.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void rollback(String database, ByteString transaction) {
    RollbackRequest request =
        RollbackRequest.newBuilder().setDatabase(database).setTransaction(transaction).build();
    rollback(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rolls back a transaction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   RollbackRequest request =
   *       RollbackRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .setTransaction(ByteString.EMPTY)
   *           .build();
   *   firestoreClient.rollback(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void rollback(RollbackRequest request) {
    rollbackCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Rolls back a transaction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   RollbackRequest request =
   *       RollbackRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .setTransaction(ByteString.EMPTY)
   *           .build();
   *   ApiFuture<Empty> future = firestoreClient.rollbackCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RollbackRequest, Empty> rollbackCallable() {
    return stub.rollbackCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs a query.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   RunQueryRequest request =
   *       RunQueryRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setExplainOptions(ExplainOptions.newBuilder().build())
   *           .build();
   *   ServerStream<RunQueryResponse> stream = firestoreClient.runQueryCallable().call(request);
   *   for (RunQueryResponse response : stream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final ServerStreamingCallable<RunQueryRequest, RunQueryResponse> runQueryCallable() {
    return stub.runQueryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Runs an aggregation query.
   *
   * <p>Rather than producing [Document][google.firestore.v1.Document] results like
   * [Firestore.RunQuery][google.firestore.v1.Firestore.RunQuery], this API allows running an
   * aggregation to produce a series of [AggregationResult][google.firestore.v1.AggregationResult]
   * server-side.
   *
   * <p>High-Level Example:
   *
   * <p>``` -- Return the number of documents in table given a filter. SELECT COUNT(&#42;) FROM (
   * SELECT &#42; FROM k where a = true ); ```
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   RunAggregationQueryRequest request =
   *       RunAggregationQueryRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setExplainOptions(ExplainOptions.newBuilder().build())
   *           .build();
   *   ServerStream<RunAggregationQueryResponse> stream =
   *       firestoreClient.runAggregationQueryCallable().call(request);
   *   for (RunAggregationQueryResponse response : stream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final ServerStreamingCallable<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQueryCallable() {
    return stub.runAggregationQueryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Partitions a query by returning partition cursors that can be used to run the query in
   * parallel. The returned partition cursors are split points that can be used by RunQuery as
   * starting/end points for the query results.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   PartitionQueryRequest request =
   *       PartitionQueryRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPartitionCount(-1738969222)
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (Cursor element : firestoreClient.partitionQuery(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PartitionQueryPagedResponse partitionQuery(PartitionQueryRequest request) {
    return partitionQueryPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Partitions a query by returning partition cursors that can be used to run the query in
   * parallel. The returned partition cursors are split points that can be used by RunQuery as
   * starting/end points for the query results.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   PartitionQueryRequest request =
   *       PartitionQueryRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPartitionCount(-1738969222)
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<Cursor> future = firestoreClient.partitionQueryPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Cursor element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<PartitionQueryRequest, PartitionQueryPagedResponse>
      partitionQueryPagedCallable() {
    return stub.partitionQueryPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Partitions a query by returning partition cursors that can be used to run the query in
   * parallel. The returned partition cursors are split points that can be used by RunQuery as
   * starting/end points for the query results.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   PartitionQueryRequest request =
   *       PartitionQueryRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPartitionCount(-1738969222)
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     PartitionQueryResponse response = firestoreClient.partitionQueryCallable().call(request);
   *     for (Cursor element : response.getPartitionsList()) {
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
  public final UnaryCallable<PartitionQueryRequest, PartitionQueryResponse>
      partitionQueryCallable() {
    return stub.partitionQueryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Streams batches of document updates and deletes, in order. This method is only available via
   * gRPC or WebChannel (not REST).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   BidiStream<WriteRequest, WriteResponse> bidiStream = firestoreClient.writeCallable().call();
   *   WriteRequest request =
   *       WriteRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .setStreamId("streamId1790933179")
   *           .addAllWrites(new ArrayList<Write>())
   *           .setStreamToken(ByteString.EMPTY)
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   bidiStream.send(request);
   *   for (WriteResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<WriteRequest, WriteResponse> writeCallable() {
    return stub.writeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Listens to changes. This method is only available via gRPC or WebChannel (not REST).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   BidiStream<ListenRequest, ListenResponse> bidiStream =
   *       firestoreClient.listenCallable().call();
   *   ListenRequest request =
   *       ListenRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   bidiStream.send(request);
   *   for (ListenResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<ListenRequest, ListenResponse> listenCallable() {
    return stub.listenCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the collection IDs underneath a document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   String parent = "parent-995424086";
   *   for (String element : firestoreClient.listCollectionIds(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent document. In the format:
   *     `projects/{project_id}/databases/{database_id}/documents/{document_path}`. For example:
   *     `projects/my-project/databases/my-database/documents/chatrooms/my-chatroom`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCollectionIdsPagedResponse listCollectionIds(String parent) {
    ListCollectionIdsRequest request =
        ListCollectionIdsRequest.newBuilder().setParent(parent).build();
    return listCollectionIds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the collection IDs underneath a document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   ListCollectionIdsRequest request =
   *       ListCollectionIdsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (String element : firestoreClient.listCollectionIds(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCollectionIdsPagedResponse listCollectionIds(ListCollectionIdsRequest request) {
    return listCollectionIdsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the collection IDs underneath a document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   ListCollectionIdsRequest request =
   *       ListCollectionIdsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<String> future =
   *       firestoreClient.listCollectionIdsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (String element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsPagedResponse>
      listCollectionIdsPagedCallable() {
    return stub.listCollectionIdsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the collection IDs underneath a document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   ListCollectionIdsRequest request =
   *       ListCollectionIdsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListCollectionIdsResponse response =
   *         firestoreClient.listCollectionIdsCallable().call(request);
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
   * }</pre>
   */
  public final UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsResponse>
      listCollectionIdsCallable() {
    return stub.listCollectionIdsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Applies a batch of write operations.
   *
   * <p>The BatchWrite method does not apply the write operations atomically and can apply them out
   * of order. Method does not allow more than one write per document. Each write succeeds or fails
   * independently. See the [BatchWriteResponse][google.firestore.v1.BatchWriteResponse] for the
   * success status of each write.
   *
   * <p>If you require an atomically applied set of writes, use
   * [Commit][google.firestore.v1.Firestore.Commit] instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   BatchWriteRequest request =
   *       BatchWriteRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .addAllWrites(new ArrayList<Write>())
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   BatchWriteResponse response = firestoreClient.batchWrite(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchWriteResponse batchWrite(BatchWriteRequest request) {
    return batchWriteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Applies a batch of write operations.
   *
   * <p>The BatchWrite method does not apply the write operations atomically and can apply them out
   * of order. Method does not allow more than one write per document. Each write succeeds or fails
   * independently. See the [BatchWriteResponse][google.firestore.v1.BatchWriteResponse] for the
   * success status of each write.
   *
   * <p>If you require an atomically applied set of writes, use
   * [Commit][google.firestore.v1.Firestore.Commit] instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   BatchWriteRequest request =
   *       BatchWriteRequest.newBuilder()
   *           .setDatabase("database1789464955")
   *           .addAllWrites(new ArrayList<Write>())
   *           .putAllLabels(new HashMap<String, String>())
   *           .build();
   *   ApiFuture<BatchWriteResponse> future =
   *       firestoreClient.batchWriteCallable().futureCall(request);
   *   // Do something.
   *   BatchWriteResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchWriteRequest, BatchWriteResponse> batchWriteCallable() {
    return stub.batchWriteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   CreateDocumentRequest request =
   *       CreateDocumentRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCollectionId("collectionId1636075609")
   *           .setDocumentId("documentId-814940266")
   *           .setDocument(Document.newBuilder().build())
   *           .setMask(DocumentMask.newBuilder().build())
   *           .build();
   *   Document response = firestoreClient.createDocument(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document createDocument(CreateDocumentRequest request) {
    return createDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
   *   CreateDocumentRequest request =
   *       CreateDocumentRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCollectionId("collectionId1636075609")
   *           .setDocumentId("documentId-814940266")
   *           .setDocument(Document.newBuilder().build())
   *           .setMask(DocumentMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Document> future = firestoreClient.createDocumentCallable().futureCall(request);
   *   // Do something.
   *   Document response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDocumentRequest, Document> createDocumentCallable() {
    return stub.createDocumentCallable();
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

  public static class PartitionQueryPagedResponse
      extends AbstractPagedListResponse<
          PartitionQueryRequest,
          PartitionQueryResponse,
          Cursor,
          PartitionQueryPage,
          PartitionQueryFixedSizeCollection> {

    public static ApiFuture<PartitionQueryPagedResponse> createAsync(
        PageContext<PartitionQueryRequest, PartitionQueryResponse, Cursor> context,
        ApiFuture<PartitionQueryResponse> futureResponse) {
      ApiFuture<PartitionQueryPage> futurePage =
          PartitionQueryPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new PartitionQueryPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private PartitionQueryPagedResponse(PartitionQueryPage page) {
      super(page, PartitionQueryFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class PartitionQueryPage
      extends AbstractPage<
          PartitionQueryRequest, PartitionQueryResponse, Cursor, PartitionQueryPage> {

    private PartitionQueryPage(
        PageContext<PartitionQueryRequest, PartitionQueryResponse, Cursor> context,
        PartitionQueryResponse response) {
      super(context, response);
    }

    private static PartitionQueryPage createEmptyPage() {
      return new PartitionQueryPage(null, null);
    }

    @Override
    protected PartitionQueryPage createPage(
        PageContext<PartitionQueryRequest, PartitionQueryResponse, Cursor> context,
        PartitionQueryResponse response) {
      return new PartitionQueryPage(context, response);
    }

    @Override
    public ApiFuture<PartitionQueryPage> createPageAsync(
        PageContext<PartitionQueryRequest, PartitionQueryResponse, Cursor> context,
        ApiFuture<PartitionQueryResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class PartitionQueryFixedSizeCollection
      extends AbstractFixedSizeCollection<
          PartitionQueryRequest,
          PartitionQueryResponse,
          Cursor,
          PartitionQueryPage,
          PartitionQueryFixedSizeCollection> {

    private PartitionQueryFixedSizeCollection(List<PartitionQueryPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static PartitionQueryFixedSizeCollection createEmptyCollection() {
      return new PartitionQueryFixedSizeCollection(null, 0);
    }

    @Override
    protected PartitionQueryFixedSizeCollection createCollection(
        List<PartitionQueryPage> pages, int collectionSize) {
      return new PartitionQueryFixedSizeCollection(pages, collectionSize);
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
          input -> new ListCollectionIdsPagedResponse(input),
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
