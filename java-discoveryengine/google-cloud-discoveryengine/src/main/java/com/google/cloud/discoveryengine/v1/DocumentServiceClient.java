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

package com.google.cloud.discoveryengine.v1;

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
import com.google.cloud.discoveryengine.v1.stub.DocumentServiceStub;
import com.google.cloud.discoveryengine.v1.stub.DocumentServiceStubSettings;
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
 * Service Description: Service for ingesting [Document][google.cloud.discoveryengine.v1.Document]
 * information of the customer's website.
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
 * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
 *   DocumentName name =
 *       DocumentName.ofProjectLocationDataStoreBranchDocumentName(
 *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");
 *   Document response = documentServiceClient.getDocument(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DocumentServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 *      <td><p> Gets a [Document][google.cloud.discoveryengine.v1.Document].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDocument(GetDocumentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDocument(DocumentName name)
 *           <li><p> getDocument(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDocumentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDocuments</td>
 *      <td><p> Gets a list of [Document][google.cloud.discoveryengine.v1.Document]s.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDocuments(ListDocumentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDocuments(BranchName parent)
 *           <li><p> listDocuments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDocumentsPagedCallable()
 *           <li><p> listDocumentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDocument</td>
 *      <td><p> Creates a [Document][google.cloud.discoveryengine.v1.Document].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDocument(CreateDocumentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDocument(BranchName parent, Document document, String documentId)
 *           <li><p> createDocument(String parent, Document document, String documentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDocumentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDocument</td>
 *      <td><p> Updates a [Document][google.cloud.discoveryengine.v1.Document].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDocument(UpdateDocumentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDocument(Document document, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDocumentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDocument</td>
 *      <td><p> Deletes a [Document][google.cloud.discoveryengine.v1.Document].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDocument(DeleteDocumentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteDocument(DocumentName name)
 *           <li><p> deleteDocument(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDocumentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportDocuments</td>
 *      <td><p> Bulk import of multiple [Document][google.cloud.discoveryengine.v1.Document]s. Request processing may be synchronous. Non-existing items are created.
 * <p>  Note: It is possible for a subset of the [Document][google.cloud.discoveryengine.v1.Document]s to be successfully updated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importDocumentsAsync(ImportDocumentsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importDocumentsOperationCallable()
 *           <li><p> importDocumentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PurgeDocuments</td>
 *      <td><p> Permanently deletes all selected [Document][google.cloud.discoveryengine.v1.Document]s in a branch.
 * <p>  This process is asynchronous. Depending on the number of [Document][google.cloud.discoveryengine.v1.Document]s to be deleted, this operation can take hours to complete. Before the delete operation completes, some [Document][google.cloud.discoveryengine.v1.Document]s might still be returned by [DocumentService.GetDocument][google.cloud.discoveryengine.v1.DocumentService.GetDocument] or [DocumentService.ListDocuments][google.cloud.discoveryengine.v1.DocumentService.ListDocuments].
 * <p>  To get a list of the [Document][google.cloud.discoveryengine.v1.Document]s to be deleted, set [PurgeDocumentsRequest.force][google.cloud.discoveryengine.v1.PurgeDocumentsRequest.force] to false.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> purgeDocumentsAsync(PurgeDocumentsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> purgeDocumentsOperationCallable()
 *           <li><p> purgeDocumentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchGetDocumentsMetadata</td>
 *      <td><p> Gets index freshness metadata for [Document][google.cloud.discoveryengine.v1.Document]s. Supported for website search only.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchGetDocumentsMetadata(BatchGetDocumentsMetadataRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchGetDocumentsMetadata(BranchName parent)
 *           <li><p> batchGetDocumentsMetadata(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchGetDocumentsMetadataCallable()
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
 * <p>This class can be customized by passing in a custom instance of DocumentServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DocumentServiceSettings documentServiceSettings =
 *     DocumentServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DocumentServiceClient documentServiceClient =
 *     DocumentServiceClient.create(documentServiceSettings);
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
 * DocumentServiceSettings documentServiceSettings =
 *     DocumentServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DocumentServiceClient documentServiceClient =
 *     DocumentServiceClient.create(documentServiceSettings);
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
 * DocumentServiceSettings documentServiceSettings =
 *     DocumentServiceSettings.newHttpJsonBuilder().build();
 * DocumentServiceClient documentServiceClient =
 *     DocumentServiceClient.create(documentServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DocumentServiceClient implements BackgroundResource {
  private final DocumentServiceSettings settings;
  private final DocumentServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DocumentServiceClient with default settings. */
  public static final DocumentServiceClient create() throws IOException {
    return create(DocumentServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DocumentServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DocumentServiceClient create(DocumentServiceSettings settings)
      throws IOException {
    return new DocumentServiceClient(settings);
  }

  /**
   * Constructs an instance of DocumentServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(DocumentServiceSettings).
   */
  public static final DocumentServiceClient create(DocumentServiceStub stub) {
    return new DocumentServiceClient(stub);
  }

  /**
   * Constructs an instance of DocumentServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DocumentServiceClient(DocumentServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DocumentServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DocumentServiceClient(DocumentServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DocumentServiceSettings getSettings() {
    return settings;
  }

  public DocumentServiceStub getStub() {
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
   * Gets a [Document][google.cloud.discoveryengine.v1.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   DocumentName name =
   *       DocumentName.ofProjectLocationDataStoreBranchDocumentName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");
   *   Document response = documentServiceClient.getDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [Document][google.cloud.discoveryengine.v1.Document], such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}/documents/{document}`.
   *     <p>If the caller does not have permission to access the
   *     [Document][google.cloud.discoveryengine.v1.Document], regardless of whether or not it
   *     exists, a `PERMISSION_DENIED` error is returned.
   *     <p>If the requested [Document][google.cloud.discoveryengine.v1.Document] does not exist, a
   *     `NOT_FOUND` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document getDocument(DocumentName name) {
    GetDocumentRequest request =
        GetDocumentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [Document][google.cloud.discoveryengine.v1.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   String name =
   *       DocumentName.ofProjectLocationDataStoreBranchDocumentName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
   *           .toString();
   *   Document response = documentServiceClient.getDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [Document][google.cloud.discoveryengine.v1.Document], such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}/documents/{document}`.
   *     <p>If the caller does not have permission to access the
   *     [Document][google.cloud.discoveryengine.v1.Document], regardless of whether or not it
   *     exists, a `PERMISSION_DENIED` error is returned.
   *     <p>If the requested [Document][google.cloud.discoveryengine.v1.Document] does not exist, a
   *     `NOT_FOUND` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document getDocument(String name) {
    GetDocumentRequest request = GetDocumentRequest.newBuilder().setName(name).build();
    return getDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [Document][google.cloud.discoveryengine.v1.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   GetDocumentRequest request =
   *       GetDocumentRequest.newBuilder()
   *           .setName(
   *               DocumentName.ofProjectLocationDataStoreBranchDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
   *                   .toString())
   *           .build();
   *   Document response = documentServiceClient.getDocument(request);
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
   * Gets a [Document][google.cloud.discoveryengine.v1.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   GetDocumentRequest request =
   *       GetDocumentRequest.newBuilder()
   *           .setName(
   *               DocumentName.ofProjectLocationDataStoreBranchDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Document> future = documentServiceClient.getDocumentCallable().futureCall(request);
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
   * Gets a list of [Document][google.cloud.discoveryengine.v1.Document]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   BranchName parent =
   *       BranchName.ofProjectLocationDataStoreBranchName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]");
   *   for (Document element : documentServiceClient.listDocuments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent branch resource name, such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}`.
   *     Use `default_branch` as the branch ID, to list documents under the default branch.
   *     <p>If the caller does not have permission to list
   *     [Document][google.cloud.discoveryengine.v1.Document]s under this branch, regardless of
   *     whether or not this branch exists, a `PERMISSION_DENIED` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDocumentsPagedResponse listDocuments(BranchName parent) {
    ListDocumentsRequest request =
        ListDocumentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDocuments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Document][google.cloud.discoveryengine.v1.Document]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   String parent =
   *       BranchName.ofProjectLocationDataStoreBranchName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *           .toString();
   *   for (Document element : documentServiceClient.listDocuments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent branch resource name, such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}`.
   *     Use `default_branch` as the branch ID, to list documents under the default branch.
   *     <p>If the caller does not have permission to list
   *     [Document][google.cloud.discoveryengine.v1.Document]s under this branch, regardless of
   *     whether or not this branch exists, a `PERMISSION_DENIED` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDocumentsPagedResponse listDocuments(String parent) {
    ListDocumentsRequest request = ListDocumentsRequest.newBuilder().setParent(parent).build();
    return listDocuments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Document][google.cloud.discoveryengine.v1.Document]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   ListDocumentsRequest request =
   *       ListDocumentsRequest.newBuilder()
   *           .setParent(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Document element : documentServiceClient.listDocuments(request).iterateAll()) {
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
   * Gets a list of [Document][google.cloud.discoveryengine.v1.Document]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   ListDocumentsRequest request =
   *       ListDocumentsRequest.newBuilder()
   *           .setParent(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Document> future =
   *       documentServiceClient.listDocumentsPagedCallable().futureCall(request);
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
   * Gets a list of [Document][google.cloud.discoveryengine.v1.Document]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   ListDocumentsRequest request =
   *       ListDocumentsRequest.newBuilder()
   *           .setParent(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDocumentsResponse response =
   *         documentServiceClient.listDocumentsCallable().call(request);
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
   * Creates a [Document][google.cloud.discoveryengine.v1.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   BranchName parent =
   *       BranchName.ofProjectLocationDataStoreBranchName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]");
   *   Document document = Document.newBuilder().build();
   *   String documentId = "documentId-814940266";
   *   Document response = documentServiceClient.createDocument(parent, document, documentId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}`.
   * @param document Required. The [Document][google.cloud.discoveryengine.v1.Document] to create.
   * @param documentId Required. The ID to use for the
   *     [Document][google.cloud.discoveryengine.v1.Document], which becomes the final component of
   *     the [Document.name][google.cloud.discoveryengine.v1.Document.name].
   *     <p>If the caller does not have permission to create the
   *     [Document][google.cloud.discoveryengine.v1.Document], regardless of whether or not it
   *     exists, a `PERMISSION_DENIED` error is returned.
   *     <p>This field must be unique among all
   *     [Document][google.cloud.discoveryengine.v1.Document]s with the same
   *     [parent][google.cloud.discoveryengine.v1.CreateDocumentRequest.parent]. Otherwise, an
   *     `ALREADY_EXISTS` error is returned.
   *     <p>This field must conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with
   *     a length limit of 128 characters. Otherwise, an `INVALID_ARGUMENT` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document createDocument(BranchName parent, Document document, String documentId) {
    CreateDocumentRequest request =
        CreateDocumentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDocument(document)
            .setDocumentId(documentId)
            .build();
    return createDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Document][google.cloud.discoveryengine.v1.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   String parent =
   *       BranchName.ofProjectLocationDataStoreBranchName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *           .toString();
   *   Document document = Document.newBuilder().build();
   *   String documentId = "documentId-814940266";
   *   Document response = documentServiceClient.createDocument(parent, document, documentId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}`.
   * @param document Required. The [Document][google.cloud.discoveryengine.v1.Document] to create.
   * @param documentId Required. The ID to use for the
   *     [Document][google.cloud.discoveryengine.v1.Document], which becomes the final component of
   *     the [Document.name][google.cloud.discoveryengine.v1.Document.name].
   *     <p>If the caller does not have permission to create the
   *     [Document][google.cloud.discoveryengine.v1.Document], regardless of whether or not it
   *     exists, a `PERMISSION_DENIED` error is returned.
   *     <p>This field must be unique among all
   *     [Document][google.cloud.discoveryengine.v1.Document]s with the same
   *     [parent][google.cloud.discoveryengine.v1.CreateDocumentRequest.parent]. Otherwise, an
   *     `ALREADY_EXISTS` error is returned.
   *     <p>This field must conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with
   *     a length limit of 128 characters. Otherwise, an `INVALID_ARGUMENT` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document createDocument(String parent, Document document, String documentId) {
    CreateDocumentRequest request =
        CreateDocumentRequest.newBuilder()
            .setParent(parent)
            .setDocument(document)
            .setDocumentId(documentId)
            .build();
    return createDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Document][google.cloud.discoveryengine.v1.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   CreateDocumentRequest request =
   *       CreateDocumentRequest.newBuilder()
   *           .setParent(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setDocument(Document.newBuilder().build())
   *           .setDocumentId("documentId-814940266")
   *           .build();
   *   Document response = documentServiceClient.createDocument(request);
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
   * Creates a [Document][google.cloud.discoveryengine.v1.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   CreateDocumentRequest request =
   *       CreateDocumentRequest.newBuilder()
   *           .setParent(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setDocument(Document.newBuilder().build())
   *           .setDocumentId("documentId-814940266")
   *           .build();
   *   ApiFuture<Document> future =
   *       documentServiceClient.createDocumentCallable().futureCall(request);
   *   // Do something.
   *   Document response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDocumentRequest, Document> createDocumentCallable() {
    return stub.createDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Document][google.cloud.discoveryengine.v1.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   Document document = Document.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Document response = documentServiceClient.updateDocument(document, updateMask);
   * }
   * }</pre>
   *
   * @param document Required. The document to update/create.
   *     <p>If the caller does not have permission to update the
   *     [Document][google.cloud.discoveryengine.v1.Document], regardless of whether or not it
   *     exists, a `PERMISSION_DENIED` error is returned.
   *     <p>If the [Document][google.cloud.discoveryengine.v1.Document] to update does not exist and
   *     [allow_missing][google.cloud.discoveryengine.v1.UpdateDocumentRequest.allow_missing] is not
   *     set, a `NOT_FOUND` error is returned.
   * @param updateMask Indicates which fields in the provided imported 'document' to update. If not
   *     set, by default updates all fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document updateDocument(Document document, FieldMask updateMask) {
    UpdateDocumentRequest request =
        UpdateDocumentRequest.newBuilder().setDocument(document).setUpdateMask(updateMask).build();
    return updateDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Document][google.cloud.discoveryengine.v1.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   UpdateDocumentRequest request =
   *       UpdateDocumentRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Document response = documentServiceClient.updateDocument(request);
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
   * Updates a [Document][google.cloud.discoveryengine.v1.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   UpdateDocumentRequest request =
   *       UpdateDocumentRequest.newBuilder()
   *           .setDocument(Document.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Document> future =
   *       documentServiceClient.updateDocumentCallable().futureCall(request);
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
   * Deletes a [Document][google.cloud.discoveryengine.v1.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   DocumentName name =
   *       DocumentName.ofProjectLocationDataStoreBranchDocumentName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");
   *   documentServiceClient.deleteDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [Document][google.cloud.discoveryengine.v1.Document], such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}/documents/{document}`.
   *     <p>If the caller does not have permission to delete the
   *     [Document][google.cloud.discoveryengine.v1.Document], regardless of whether or not it
   *     exists, a `PERMISSION_DENIED` error is returned.
   *     <p>If the [Document][google.cloud.discoveryengine.v1.Document] to delete does not exist, a
   *     `NOT_FOUND` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDocument(DocumentName name) {
    DeleteDocumentRequest request =
        DeleteDocumentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Document][google.cloud.discoveryengine.v1.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   String name =
   *       DocumentName.ofProjectLocationDataStoreBranchDocumentName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
   *           .toString();
   *   documentServiceClient.deleteDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [Document][google.cloud.discoveryengine.v1.Document], such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}/documents/{document}`.
   *     <p>If the caller does not have permission to delete the
   *     [Document][google.cloud.discoveryengine.v1.Document], regardless of whether or not it
   *     exists, a `PERMISSION_DENIED` error is returned.
   *     <p>If the [Document][google.cloud.discoveryengine.v1.Document] to delete does not exist, a
   *     `NOT_FOUND` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDocument(String name) {
    DeleteDocumentRequest request = DeleteDocumentRequest.newBuilder().setName(name).build();
    deleteDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Document][google.cloud.discoveryengine.v1.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   DeleteDocumentRequest request =
   *       DeleteDocumentRequest.newBuilder()
   *           .setName(
   *               DocumentName.ofProjectLocationDataStoreBranchDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
   *                   .toString())
   *           .build();
   *   documentServiceClient.deleteDocument(request);
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
   * Deletes a [Document][google.cloud.discoveryengine.v1.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   DeleteDocumentRequest request =
   *       DeleteDocumentRequest.newBuilder()
   *           .setName(
   *               DocumentName.ofProjectLocationDataStoreBranchDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = documentServiceClient.deleteDocumentCallable().futureCall(request);
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
   * Bulk import of multiple [Document][google.cloud.discoveryengine.v1.Document]s. Request
   * processing may be synchronous. Non-existing items are created.
   *
   * <p>Note: It is possible for a subset of the
   * [Document][google.cloud.discoveryengine.v1.Document]s to be successfully updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   ImportDocumentsRequest request =
   *       ImportDocumentsRequest.newBuilder()
   *           .setParent(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setErrorConfig(ImportErrorConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAutoGenerateIds(true)
   *           .setIdField("idField1629396127")
   *           .setForceRefreshContent(true)
   *           .build();
   *   ImportDocumentsResponse response = documentServiceClient.importDocumentsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportDocumentsResponse, ImportDocumentsMetadata>
      importDocumentsAsync(ImportDocumentsRequest request) {
    return importDocumentsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk import of multiple [Document][google.cloud.discoveryengine.v1.Document]s. Request
   * processing may be synchronous. Non-existing items are created.
   *
   * <p>Note: It is possible for a subset of the
   * [Document][google.cloud.discoveryengine.v1.Document]s to be successfully updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   ImportDocumentsRequest request =
   *       ImportDocumentsRequest.newBuilder()
   *           .setParent(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setErrorConfig(ImportErrorConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAutoGenerateIds(true)
   *           .setIdField("idField1629396127")
   *           .setForceRefreshContent(true)
   *           .build();
   *   OperationFuture<ImportDocumentsResponse, ImportDocumentsMetadata> future =
   *       documentServiceClient.importDocumentsOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportDocumentsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ImportDocumentsRequest, ImportDocumentsResponse, ImportDocumentsMetadata>
      importDocumentsOperationCallable() {
    return stub.importDocumentsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk import of multiple [Document][google.cloud.discoveryengine.v1.Document]s. Request
   * processing may be synchronous. Non-existing items are created.
   *
   * <p>Note: It is possible for a subset of the
   * [Document][google.cloud.discoveryengine.v1.Document]s to be successfully updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   ImportDocumentsRequest request =
   *       ImportDocumentsRequest.newBuilder()
   *           .setParent(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setErrorConfig(ImportErrorConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAutoGenerateIds(true)
   *           .setIdField("idField1629396127")
   *           .setForceRefreshContent(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       documentServiceClient.importDocumentsCallable().futureCall(request);
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
   * Permanently deletes all selected [Document][google.cloud.discoveryengine.v1.Document]s in a
   * branch.
   *
   * <p>This process is asynchronous. Depending on the number of
   * [Document][google.cloud.discoveryengine.v1.Document]s to be deleted, this operation can take
   * hours to complete. Before the delete operation completes, some
   * [Document][google.cloud.discoveryengine.v1.Document]s might still be returned by
   * [DocumentService.GetDocument][google.cloud.discoveryengine.v1.DocumentService.GetDocument] or
   * [DocumentService.ListDocuments][google.cloud.discoveryengine.v1.DocumentService.ListDocuments].
   *
   * <p>To get a list of the [Document][google.cloud.discoveryengine.v1.Document]s to be deleted,
   * set [PurgeDocumentsRequest.force][google.cloud.discoveryengine.v1.PurgeDocumentsRequest.force]
   * to false.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   PurgeDocumentsRequest request =
   *       PurgeDocumentsRequest.newBuilder()
   *           .setParent(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setErrorConfig(PurgeErrorConfig.newBuilder().build())
   *           .setForce(true)
   *           .build();
   *   PurgeDocumentsResponse response = documentServiceClient.purgeDocumentsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PurgeDocumentsResponse, PurgeDocumentsMetadata> purgeDocumentsAsync(
      PurgeDocumentsRequest request) {
    return purgeDocumentsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes all selected [Document][google.cloud.discoveryengine.v1.Document]s in a
   * branch.
   *
   * <p>This process is asynchronous. Depending on the number of
   * [Document][google.cloud.discoveryengine.v1.Document]s to be deleted, this operation can take
   * hours to complete. Before the delete operation completes, some
   * [Document][google.cloud.discoveryengine.v1.Document]s might still be returned by
   * [DocumentService.GetDocument][google.cloud.discoveryengine.v1.DocumentService.GetDocument] or
   * [DocumentService.ListDocuments][google.cloud.discoveryengine.v1.DocumentService.ListDocuments].
   *
   * <p>To get a list of the [Document][google.cloud.discoveryengine.v1.Document]s to be deleted,
   * set [PurgeDocumentsRequest.force][google.cloud.discoveryengine.v1.PurgeDocumentsRequest.force]
   * to false.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   PurgeDocumentsRequest request =
   *       PurgeDocumentsRequest.newBuilder()
   *           .setParent(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setErrorConfig(PurgeErrorConfig.newBuilder().build())
   *           .setForce(true)
   *           .build();
   *   OperationFuture<PurgeDocumentsResponse, PurgeDocumentsMetadata> future =
   *       documentServiceClient.purgeDocumentsOperationCallable().futureCall(request);
   *   // Do something.
   *   PurgeDocumentsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          PurgeDocumentsRequest, PurgeDocumentsResponse, PurgeDocumentsMetadata>
      purgeDocumentsOperationCallable() {
    return stub.purgeDocumentsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes all selected [Document][google.cloud.discoveryengine.v1.Document]s in a
   * branch.
   *
   * <p>This process is asynchronous. Depending on the number of
   * [Document][google.cloud.discoveryengine.v1.Document]s to be deleted, this operation can take
   * hours to complete. Before the delete operation completes, some
   * [Document][google.cloud.discoveryengine.v1.Document]s might still be returned by
   * [DocumentService.GetDocument][google.cloud.discoveryengine.v1.DocumentService.GetDocument] or
   * [DocumentService.ListDocuments][google.cloud.discoveryengine.v1.DocumentService.ListDocuments].
   *
   * <p>To get a list of the [Document][google.cloud.discoveryengine.v1.Document]s to be deleted,
   * set [PurgeDocumentsRequest.force][google.cloud.discoveryengine.v1.PurgeDocumentsRequest.force]
   * to false.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   PurgeDocumentsRequest request =
   *       PurgeDocumentsRequest.newBuilder()
   *           .setParent(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setErrorConfig(PurgeErrorConfig.newBuilder().build())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       documentServiceClient.purgeDocumentsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PurgeDocumentsRequest, Operation> purgeDocumentsCallable() {
    return stub.purgeDocumentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets index freshness metadata for [Document][google.cloud.discoveryengine.v1.Document]s.
   * Supported for website search only.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   BranchName parent =
   *       BranchName.ofProjectLocationDataStoreBranchName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]");
   *   BatchGetDocumentsMetadataResponse response =
   *       documentServiceClient.batchGetDocumentsMetadata(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent branch resource name, such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchGetDocumentsMetadataResponse batchGetDocumentsMetadata(BranchName parent) {
    BatchGetDocumentsMetadataRequest request =
        BatchGetDocumentsMetadataRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return batchGetDocumentsMetadata(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets index freshness metadata for [Document][google.cloud.discoveryengine.v1.Document]s.
   * Supported for website search only.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   String parent =
   *       BranchName.ofProjectLocationDataStoreBranchName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *           .toString();
   *   BatchGetDocumentsMetadataResponse response =
   *       documentServiceClient.batchGetDocumentsMetadata(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent branch resource name, such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchGetDocumentsMetadataResponse batchGetDocumentsMetadata(String parent) {
    BatchGetDocumentsMetadataRequest request =
        BatchGetDocumentsMetadataRequest.newBuilder().setParent(parent).build();
    return batchGetDocumentsMetadata(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets index freshness metadata for [Document][google.cloud.discoveryengine.v1.Document]s.
   * Supported for website search only.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   BatchGetDocumentsMetadataRequest request =
   *       BatchGetDocumentsMetadataRequest.newBuilder()
   *           .setParent(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setMatcher(BatchGetDocumentsMetadataRequest.Matcher.newBuilder().build())
   *           .build();
   *   BatchGetDocumentsMetadataResponse response =
   *       documentServiceClient.batchGetDocumentsMetadata(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchGetDocumentsMetadataResponse batchGetDocumentsMetadata(
      BatchGetDocumentsMetadataRequest request) {
    return batchGetDocumentsMetadataCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets index freshness metadata for [Document][google.cloud.discoveryengine.v1.Document]s.
   * Supported for website search only.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   BatchGetDocumentsMetadataRequest request =
   *       BatchGetDocumentsMetadataRequest.newBuilder()
   *           .setParent(
   *               BranchName.ofProjectLocationDataStoreBranchName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
   *                   .toString())
   *           .setMatcher(BatchGetDocumentsMetadataRequest.Matcher.newBuilder().build())
   *           .build();
   *   ApiFuture<BatchGetDocumentsMetadataResponse> future =
   *       documentServiceClient.batchGetDocumentsMetadataCallable().futureCall(request);
   *   // Do something.
   *   BatchGetDocumentsMetadataResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchGetDocumentsMetadataRequest, BatchGetDocumentsMetadataResponse>
      batchGetDocumentsMetadataCallable() {
    return stub.batchGetDocumentsMetadataCallable();
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
}
