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

package com.google.cloud.contentwarehouse.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.contentwarehouse.v1.stub.DocumentServiceStub;
import com.google.cloud.contentwarehouse.v1.stub.DocumentServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.Policy;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This service lets you manage document.
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
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Document document = Document.newBuilder().build();
 *   CreateDocumentResponse response = documentServiceClient.createDocument(parent, document);
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
 *     DocumentServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             DocumentServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
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
  }

  protected DocumentServiceClient(DocumentServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DocumentServiceSettings getSettings() {
    return settings;
  }

  public DocumentServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a document.
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
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Document document = Document.newBuilder().build();
   *   CreateDocumentResponse response = documentServiceClient.createDocument(parent, document);
   * }
   * }</pre>
   *
   * @param parent Required. The parent name. Format:
   *     projects/{project_number}/locations/{location}.
   * @param document Required. The document to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreateDocumentResponse createDocument(LocationName parent, Document document) {
    CreateDocumentRequest request =
        CreateDocumentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDocument(document)
            .build();
    return createDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a document.
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
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Document document = Document.newBuilder().build();
   *   CreateDocumentResponse response = documentServiceClient.createDocument(parent, document);
   * }
   * }</pre>
   *
   * @param parent Required. The parent name. Format:
   *     projects/{project_number}/locations/{location}.
   * @param document Required. The document to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreateDocumentResponse createDocument(String parent, Document document) {
    CreateDocumentRequest request =
        CreateDocumentRequest.newBuilder().setParent(parent).setDocument(document).build();
    return createDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a document.
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
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDocument(Document.newBuilder().build())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setCloudAiDocumentOption(CloudAIDocumentOption.newBuilder().build())
   *           .setCreateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CreateDocumentResponse response = documentServiceClient.createDocument(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreateDocumentResponse createDocument(CreateDocumentRequest request) {
    return createDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a document.
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
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDocument(Document.newBuilder().build())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setCloudAiDocumentOption(CloudAIDocumentOption.newBuilder().build())
   *           .setCreateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CreateDocumentResponse> future =
   *       documentServiceClient.createDocumentCallable().futureCall(request);
   *   // Do something.
   *   CreateDocumentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDocumentRequest, CreateDocumentResponse>
      createDocumentCallable() {
    return stub.createDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a document. Returns NOT_FOUND if the document does not exist.
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
   *       DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");
   *   Document response = documentServiceClient.getDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the document to retrieve. Format:
   *     projects/{project_number}/locations/{location}/documents/{document_id} or
   *     projects/{project_number}/locations/{location}/documents/referenceId/{reference_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document getDocument(DocumentName name) {
    GetDocumentRequest request =
        GetDocumentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a document. Returns NOT_FOUND if the document does not exist.
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
   *       DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *           .toString();
   *   Document response = documentServiceClient.getDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the document to retrieve. Format:
   *     projects/{project_number}/locations/{location}/documents/{document_id} or
   *     projects/{project_number}/locations/{location}/documents/referenceId/{reference_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document getDocument(String name) {
    GetDocumentRequest request = GetDocumentRequest.newBuilder().setName(name).build();
    return getDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a document. Returns NOT_FOUND if the document does not exist.
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
   *               DocumentName.ofProjectLocationDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *                   .toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
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
   * Gets a document. Returns NOT_FOUND if the document does not exist.
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
   *               DocumentName.ofProjectLocationDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *                   .toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
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
   * Updates a document. Returns INVALID_ARGUMENT if the name of the document is non-empty and does
   * not equal the existing name.
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
   *       DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");
   *   Document document = Document.newBuilder().build();
   *   UpdateDocumentResponse response = documentServiceClient.updateDocument(name, document);
   * }
   * }</pre>
   *
   * @param name Required. The name of the document to update. Format:
   *     projects/{project_number}/locations/{location}/documents/{document_id} or
   *     projects/{project_number}/locations/{location}/documents/referenceId/{reference_id}.
   * @param document Required. The document to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UpdateDocumentResponse updateDocument(DocumentName name, Document document) {
    UpdateDocumentRequest request =
        UpdateDocumentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDocument(document)
            .build();
    return updateDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a document. Returns INVALID_ARGUMENT if the name of the document is non-empty and does
   * not equal the existing name.
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
   *       DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *           .toString();
   *   Document document = Document.newBuilder().build();
   *   UpdateDocumentResponse response = documentServiceClient.updateDocument(name, document);
   * }
   * }</pre>
   *
   * @param name Required. The name of the document to update. Format:
   *     projects/{project_number}/locations/{location}/documents/{document_id} or
   *     projects/{project_number}/locations/{location}/documents/referenceId/{reference_id}.
   * @param document Required. The document to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UpdateDocumentResponse updateDocument(String name, Document document) {
    UpdateDocumentRequest request =
        UpdateDocumentRequest.newBuilder().setName(name).setDocument(document).build();
    return updateDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a document. Returns INVALID_ARGUMENT if the name of the document is non-empty and does
   * not equal the existing name.
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
   *           .setName(
   *               DocumentName.ofProjectLocationDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *                   .toString())
   *           .setDocument(Document.newBuilder().build())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .setCloudAiDocumentOption(CloudAIDocumentOption.newBuilder().build())
   *           .setUpdateOptions(UpdateOptions.newBuilder().build())
   *           .build();
   *   UpdateDocumentResponse response = documentServiceClient.updateDocument(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UpdateDocumentResponse updateDocument(UpdateDocumentRequest request) {
    return updateDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a document. Returns INVALID_ARGUMENT if the name of the document is non-empty and does
   * not equal the existing name.
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
   *           .setName(
   *               DocumentName.ofProjectLocationDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *                   .toString())
   *           .setDocument(Document.newBuilder().build())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .setCloudAiDocumentOption(CloudAIDocumentOption.newBuilder().build())
   *           .setUpdateOptions(UpdateOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<UpdateDocumentResponse> future =
   *       documentServiceClient.updateDocumentCallable().futureCall(request);
   *   // Do something.
   *   UpdateDocumentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDocumentRequest, UpdateDocumentResponse>
      updateDocumentCallable() {
    return stub.updateDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a document. Returns NOT_FOUND if the document does not exist.
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
   *       DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");
   *   documentServiceClient.deleteDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the document to delete. Format:
   *     projects/{project_number}/locations/{location}/documents/{document_id} or
   *     projects/{project_number}/locations/{location}/documents/referenceId/{reference_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDocument(DocumentName name) {
    DeleteDocumentRequest request =
        DeleteDocumentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a document. Returns NOT_FOUND if the document does not exist.
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
   *       DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *           .toString();
   *   documentServiceClient.deleteDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the document to delete. Format:
   *     projects/{project_number}/locations/{location}/documents/{document_id} or
   *     projects/{project_number}/locations/{location}/documents/referenceId/{reference_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDocument(String name) {
    DeleteDocumentRequest request = DeleteDocumentRequest.newBuilder().setName(name).build();
    deleteDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a document. Returns NOT_FOUND if the document does not exist.
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
   *               DocumentName.ofProjectLocationDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *                   .toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
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
   * Deletes a document. Returns NOT_FOUND if the document does not exist.
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
   *               DocumentName.ofProjectLocationDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *                   .toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
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
   * Searches for documents using provided
   * [SearchDocumentsRequest][google.cloud.contentwarehouse.v1.SearchDocumentsRequest]. This call
   * only returns documents that the caller has permission to search against.
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
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (SearchDocumentsResponse.MatchingDocument element :
   *       documentServiceClient.searchDocuments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of documents. Format:
   *     projects/{project_number}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchDocumentsPagedResponse searchDocuments(LocationName parent) {
    SearchDocumentsRequest request =
        SearchDocumentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return searchDocuments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for documents using provided
   * [SearchDocumentsRequest][google.cloud.contentwarehouse.v1.SearchDocumentsRequest]. This call
   * only returns documents that the caller has permission to search against.
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
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (SearchDocumentsResponse.MatchingDocument element :
   *       documentServiceClient.searchDocuments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of documents. Format:
   *     projects/{project_number}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchDocumentsPagedResponse searchDocuments(String parent) {
    SearchDocumentsRequest request = SearchDocumentsRequest.newBuilder().setParent(parent).build();
    return searchDocuments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for documents using provided
   * [SearchDocumentsRequest][google.cloud.contentwarehouse.v1.SearchDocumentsRequest]. This call
   * only returns documents that the caller has permission to search against.
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
   *   SearchDocumentsRequest request =
   *       SearchDocumentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .setDocumentQuery(DocumentQuery.newBuilder().build())
   *           .setOffset(-1019779949)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .addAllHistogramQueries(new ArrayList<HistogramQuery>())
   *           .setRequireTotalSize(true)
   *           .setQaSizeLimit(142059404)
   *           .build();
   *   for (SearchDocumentsResponse.MatchingDocument element :
   *       documentServiceClient.searchDocuments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchDocumentsPagedResponse searchDocuments(SearchDocumentsRequest request) {
    return searchDocumentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for documents using provided
   * [SearchDocumentsRequest][google.cloud.contentwarehouse.v1.SearchDocumentsRequest]. This call
   * only returns documents that the caller has permission to search against.
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
   *   SearchDocumentsRequest request =
   *       SearchDocumentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .setDocumentQuery(DocumentQuery.newBuilder().build())
   *           .setOffset(-1019779949)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .addAllHistogramQueries(new ArrayList<HistogramQuery>())
   *           .setRequireTotalSize(true)
   *           .setQaSizeLimit(142059404)
   *           .build();
   *   ApiFuture<SearchDocumentsResponse.MatchingDocument> future =
   *       documentServiceClient.searchDocumentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SearchDocumentsResponse.MatchingDocument element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchDocumentsRequest, SearchDocumentsPagedResponse>
      searchDocumentsPagedCallable() {
    return stub.searchDocumentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for documents using provided
   * [SearchDocumentsRequest][google.cloud.contentwarehouse.v1.SearchDocumentsRequest]. This call
   * only returns documents that the caller has permission to search against.
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
   *   SearchDocumentsRequest request =
   *       SearchDocumentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .setDocumentQuery(DocumentQuery.newBuilder().build())
   *           .setOffset(-1019779949)
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .addAllHistogramQueries(new ArrayList<HistogramQuery>())
   *           .setRequireTotalSize(true)
   *           .setQaSizeLimit(142059404)
   *           .build();
   *   while (true) {
   *     SearchDocumentsResponse response =
   *         documentServiceClient.searchDocumentsCallable().call(request);
   *     for (SearchDocumentsResponse.MatchingDocument element :
   *         response.getMatchingDocumentsList()) {
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
  public final UnaryCallable<SearchDocumentsRequest, SearchDocumentsResponse>
      searchDocumentsCallable() {
    return stub.searchDocumentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns NOT_FOUND error if the resource does not
   * exist. Returns an empty policy if the resource exists but does not have a policy set.
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
   *   String resource = "resource-341064690";
   *   FetchAclResponse response = documentServiceClient.fetchAcl(resource);
   * }
   * }</pre>
   *
   * @param resource Required. REQUIRED: The resource for which the policy is being requested.
   *     Format for document:
   *     projects/{project_number}/locations/{location}/documents/{document_id}. Format for project:
   *     projects/{project_number}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchAclResponse fetchAcl(String resource) {
    FetchAclRequest request = FetchAclRequest.newBuilder().setResource(resource).build();
    return fetchAcl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns NOT_FOUND error if the resource does not
   * exist. Returns an empty policy if the resource exists but does not have a policy set.
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
   *   FetchAclRequest request =
   *       FetchAclRequest.newBuilder()
   *           .setResource("resource-341064690")
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .setProjectOwner(true)
   *           .build();
   *   FetchAclResponse response = documentServiceClient.fetchAcl(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchAclResponse fetchAcl(FetchAclRequest request) {
    return fetchAclCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns NOT_FOUND error if the resource does not
   * exist. Returns an empty policy if the resource exists but does not have a policy set.
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
   *   FetchAclRequest request =
   *       FetchAclRequest.newBuilder()
   *           .setResource("resource-341064690")
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .setProjectOwner(true)
   *           .build();
   *   ApiFuture<FetchAclResponse> future =
   *       documentServiceClient.fetchAclCallable().futureCall(request);
   *   // Do something.
   *   FetchAclResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchAclRequest, FetchAclResponse> fetchAclCallable() {
    return stub.fetchAclCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy for a resource. Replaces any existing policy.
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
   *   String resource = "resource-341064690";
   *   Policy policy = Policy.newBuilder().build();
   *   SetAclResponse response = documentServiceClient.setAcl(resource, policy);
   * }
   * }</pre>
   *
   * @param resource Required. REQUIRED: The resource for which the policy is being requested.
   *     Format for document:
   *     projects/{project_number}/locations/{location}/documents/{document_id}. Format for project:
   *     projects/{project_number}.
   * @param policy Required. REQUIRED: The complete policy to be applied to the `resource`. The size
   *     of the policy is limited to a few 10s of KB.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SetAclResponse setAcl(String resource, Policy policy) {
    SetAclRequest request =
        SetAclRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setAcl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy for a resource. Replaces any existing policy.
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
   *   SetAclRequest request =
   *       SetAclRequest.newBuilder()
   *           .setResource("resource-341064690")
   *           .setPolicy(Policy.newBuilder().build())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .setProjectOwner(true)
   *           .build();
   *   SetAclResponse response = documentServiceClient.setAcl(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SetAclResponse setAcl(SetAclRequest request) {
    return setAclCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy for a resource. Replaces any existing policy.
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
   *   SetAclRequest request =
   *       SetAclRequest.newBuilder()
   *           .setResource("resource-341064690")
   *           .setPolicy(Policy.newBuilder().build())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .setProjectOwner(true)
   *           .build();
   *   ApiFuture<SetAclResponse> future = documentServiceClient.setAclCallable().futureCall(request);
   *   // Do something.
   *   SetAclResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetAclRequest, SetAclResponse> setAclCallable() {
    return stub.setAclCallable();
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

  public static class SearchDocumentsPagedResponse
      extends AbstractPagedListResponse<
          SearchDocumentsRequest,
          SearchDocumentsResponse,
          SearchDocumentsResponse.MatchingDocument,
          SearchDocumentsPage,
          SearchDocumentsFixedSizeCollection> {

    public static ApiFuture<SearchDocumentsPagedResponse> createAsync(
        PageContext<
                SearchDocumentsRequest,
                SearchDocumentsResponse,
                SearchDocumentsResponse.MatchingDocument>
            context,
        ApiFuture<SearchDocumentsResponse> futureResponse) {
      ApiFuture<SearchDocumentsPage> futurePage =
          SearchDocumentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchDocumentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchDocumentsPagedResponse(SearchDocumentsPage page) {
      super(page, SearchDocumentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchDocumentsPage
      extends AbstractPage<
          SearchDocumentsRequest,
          SearchDocumentsResponse,
          SearchDocumentsResponse.MatchingDocument,
          SearchDocumentsPage> {

    private SearchDocumentsPage(
        PageContext<
                SearchDocumentsRequest,
                SearchDocumentsResponse,
                SearchDocumentsResponse.MatchingDocument>
            context,
        SearchDocumentsResponse response) {
      super(context, response);
    }

    private static SearchDocumentsPage createEmptyPage() {
      return new SearchDocumentsPage(null, null);
    }

    @Override
    protected SearchDocumentsPage createPage(
        PageContext<
                SearchDocumentsRequest,
                SearchDocumentsResponse,
                SearchDocumentsResponse.MatchingDocument>
            context,
        SearchDocumentsResponse response) {
      return new SearchDocumentsPage(context, response);
    }

    @Override
    public ApiFuture<SearchDocumentsPage> createPageAsync(
        PageContext<
                SearchDocumentsRequest,
                SearchDocumentsResponse,
                SearchDocumentsResponse.MatchingDocument>
            context,
        ApiFuture<SearchDocumentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchDocumentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchDocumentsRequest,
          SearchDocumentsResponse,
          SearchDocumentsResponse.MatchingDocument,
          SearchDocumentsPage,
          SearchDocumentsFixedSizeCollection> {

    private SearchDocumentsFixedSizeCollection(
        List<SearchDocumentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchDocumentsFixedSizeCollection createEmptyCollection() {
      return new SearchDocumentsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchDocumentsFixedSizeCollection createCollection(
        List<SearchDocumentsPage> pages, int collectionSize) {
      return new SearchDocumentsFixedSizeCollection(pages, collectionSize);
    }
  }
}
