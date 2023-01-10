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

package com.google.cloud.discoveryengine.v1beta;

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
import com.google.cloud.discoveryengine.v1beta.stub.DocumentServiceStub;
import com.google.cloud.discoveryengine.v1beta.stub.DocumentServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for ingesting
 * [Document][google.cloud.discoveryengine.v1beta.Document] information of the customer's website.
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
 *       DocumentName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");
 *   Document response = documentServiceClient.getDocument(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DocumentServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
@BetaApi
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
   * Gets a [Document][google.cloud.discoveryengine.v1beta.Document].
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
   *       DocumentName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");
   *   Document response = documentServiceClient.getDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [Document][google.cloud.discoveryengine.v1beta.Document], such as
   *     `projects/{project}/locations/{location}/dataStores/{data_store}/branches/{branch}/documents/{document}`.
   *     <p>If the caller does not have permission to access the
   *     [Document][google.cloud.discoveryengine.v1beta.Document], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the requested [Document][google.cloud.discoveryengine.v1beta.Document] does not
   *     exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document getDocument(DocumentName name) {
    GetDocumentRequest request =
        GetDocumentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [Document][google.cloud.discoveryengine.v1beta.Document].
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
   *       DocumentName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
   *           .toString();
   *   Document response = documentServiceClient.getDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [Document][google.cloud.discoveryengine.v1beta.Document], such as
   *     `projects/{project}/locations/{location}/dataStores/{data_store}/branches/{branch}/documents/{document}`.
   *     <p>If the caller does not have permission to access the
   *     [Document][google.cloud.discoveryengine.v1beta.Document], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the requested [Document][google.cloud.discoveryengine.v1beta.Document] does not
   *     exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document getDocument(String name) {
    GetDocumentRequest request = GetDocumentRequest.newBuilder().setName(name).build();
    return getDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [Document][google.cloud.discoveryengine.v1beta.Document].
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
   *               DocumentName.of(
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
   * Gets a [Document][google.cloud.discoveryengine.v1beta.Document].
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
   *               DocumentName.of(
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
   * Gets a list of [Document][google.cloud.discoveryengine.v1beta.Document]s.
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
   *   BranchName parent = BranchName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]");
   *   for (Document element : documentServiceClient.listDocuments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent branch resource name, such as
   *     `projects/{project}/locations/{location}/dataStores/{data_store}/branches/{branch}`. Use
   *     `default_branch` as the branch ID, to list documents under the default branch.
   *     <p>If the caller does not have permission to list [Documents][]s under this branch,
   *     regardless of whether or not this branch exists, a PERMISSION_DENIED error is returned.
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
   * Gets a list of [Document][google.cloud.discoveryengine.v1beta.Document]s.
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
   *       BranchName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]").toString();
   *   for (Document element : documentServiceClient.listDocuments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent branch resource name, such as
   *     `projects/{project}/locations/{location}/dataStores/{data_store}/branches/{branch}`. Use
   *     `default_branch` as the branch ID, to list documents under the default branch.
   *     <p>If the caller does not have permission to list [Documents][]s under this branch,
   *     regardless of whether or not this branch exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDocumentsPagedResponse listDocuments(String parent) {
    ListDocumentsRequest request = ListDocumentsRequest.newBuilder().setParent(parent).build();
    return listDocuments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Document][google.cloud.discoveryengine.v1beta.Document]s.
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
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]").toString())
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
   * Gets a list of [Document][google.cloud.discoveryengine.v1beta.Document]s.
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
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]").toString())
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
   * Gets a list of [Document][google.cloud.discoveryengine.v1beta.Document]s.
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
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]").toString())
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
   * Creates a [Document][google.cloud.discoveryengine.v1beta.Document].
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
   *   BranchName parent = BranchName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]");
   *   Document document = Document.newBuilder().build();
   *   String documentId = "documentId-814940266";
   *   Document response = documentServiceClient.createDocument(parent, document, documentId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, such as
   *     `projects/{project}/locations/{location}/dataStores/{data_store}/branches/{branch}`.
   * @param document Required. The [Document][google.cloud.discoveryengine.v1beta.Document] to
   *     create.
   * @param documentId Required. The ID to use for the
   *     [Document][google.cloud.discoveryengine.v1beta.Document], which will become the final
   *     component of the [Document.name][google.cloud.discoveryengine.v1beta.Document.name].
   *     <p>If the caller does not have permission to create the
   *     [Document][google.cloud.discoveryengine.v1beta.Document], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>This field must be unique among all
   *     [Document][google.cloud.discoveryengine.v1beta.Document]s with the same
   *     [parent][google.cloud.discoveryengine.v1beta.CreateDocumentRequest.parent]. Otherwise, an
   *     ALREADY_EXISTS error is returned.
   *     <p>This field must conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with
   *     a length limit of 63 characters. Otherwise, an INVALID_ARGUMENT error is returned.
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
   * Creates a [Document][google.cloud.discoveryengine.v1beta.Document].
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
   *       BranchName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]").toString();
   *   Document document = Document.newBuilder().build();
   *   String documentId = "documentId-814940266";
   *   Document response = documentServiceClient.createDocument(parent, document, documentId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, such as
   *     `projects/{project}/locations/{location}/dataStores/{data_store}/branches/{branch}`.
   * @param document Required. The [Document][google.cloud.discoveryengine.v1beta.Document] to
   *     create.
   * @param documentId Required. The ID to use for the
   *     [Document][google.cloud.discoveryengine.v1beta.Document], which will become the final
   *     component of the [Document.name][google.cloud.discoveryengine.v1beta.Document.name].
   *     <p>If the caller does not have permission to create the
   *     [Document][google.cloud.discoveryengine.v1beta.Document], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>This field must be unique among all
   *     [Document][google.cloud.discoveryengine.v1beta.Document]s with the same
   *     [parent][google.cloud.discoveryengine.v1beta.CreateDocumentRequest.parent]. Otherwise, an
   *     ALREADY_EXISTS error is returned.
   *     <p>This field must conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with
   *     a length limit of 63 characters. Otherwise, an INVALID_ARGUMENT error is returned.
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
   * Creates a [Document][google.cloud.discoveryengine.v1beta.Document].
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
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]").toString())
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
   * Creates a [Document][google.cloud.discoveryengine.v1beta.Document].
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
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]").toString())
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
   * Updates a [Document][google.cloud.discoveryengine.v1beta.Document].
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
   * Updates a [Document][google.cloud.discoveryengine.v1beta.Document].
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
   * Deletes a [Document][google.cloud.discoveryengine.v1beta.Document].
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
   *       DocumentName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");
   *   documentServiceClient.deleteDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [Document][google.cloud.discoveryengine.v1beta.Document], such as
   *     `projects/{project}/locations/{location}/dataStores/{data_store}/branches/{branch}/documents/{document}`.
   *     <p>If the caller does not have permission to delete the
   *     [Document][google.cloud.discoveryengine.v1beta.Document], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the [Document][google.cloud.discoveryengine.v1beta.Document] to delete does not
   *     exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDocument(DocumentName name) {
    DeleteDocumentRequest request =
        DeleteDocumentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Document][google.cloud.discoveryengine.v1beta.Document].
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
   *       DocumentName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
   *           .toString();
   *   documentServiceClient.deleteDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [Document][google.cloud.discoveryengine.v1beta.Document], such as
   *     `projects/{project}/locations/{location}/dataStores/{data_store}/branches/{branch}/documents/{document}`.
   *     <p>If the caller does not have permission to delete the
   *     [Document][google.cloud.discoveryengine.v1beta.Document], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the [Document][google.cloud.discoveryengine.v1beta.Document] to delete does not
   *     exist, a NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDocument(String name) {
    DeleteDocumentRequest request = DeleteDocumentRequest.newBuilder().setName(name).build();
    deleteDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Document][google.cloud.discoveryengine.v1beta.Document].
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
   *               DocumentName.of(
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
   * Deletes a [Document][google.cloud.discoveryengine.v1beta.Document].
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
   *               DocumentName.of(
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
   * Bulk import of multiple [Document][google.cloud.discoveryengine.v1beta.Document]s. Request
   * processing may be synchronous. Non-existing items will be created.
   *
   * <p>Note: It is possible for a subset of the
   * [Document][google.cloud.discoveryengine.v1beta.Document]s to be successfully updated.
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
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]").toString())
   *           .setErrorConfig(ImportErrorConfig.newBuilder().build())
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
   * Bulk import of multiple [Document][google.cloud.discoveryengine.v1beta.Document]s. Request
   * processing may be synchronous. Non-existing items will be created.
   *
   * <p>Note: It is possible for a subset of the
   * [Document][google.cloud.discoveryengine.v1beta.Document]s to be successfully updated.
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
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]").toString())
   *           .setErrorConfig(ImportErrorConfig.newBuilder().build())
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
   * Bulk import of multiple [Document][google.cloud.discoveryengine.v1beta.Document]s. Request
   * processing may be synchronous. Non-existing items will be created.
   *
   * <p>Note: It is possible for a subset of the
   * [Document][google.cloud.discoveryengine.v1beta.Document]s to be successfully updated.
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
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]").toString())
   *           .setErrorConfig(ImportErrorConfig.newBuilder().build())
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
