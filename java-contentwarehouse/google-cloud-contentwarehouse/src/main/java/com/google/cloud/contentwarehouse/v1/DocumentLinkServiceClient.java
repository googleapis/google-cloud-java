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
import com.google.cloud.contentwarehouse.v1.stub.DocumentLinkServiceStub;
import com.google.cloud.contentwarehouse.v1.stub.DocumentLinkServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This service lets you manage document-links. Document-Links are treated as
 * sub-resources under source documents.
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
 * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
 *   DocumentName parent =
 *       DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");
 *   ListLinkedTargetsResponse response = documentLinkServiceClient.listLinkedTargets(parent);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DocumentLinkServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of DocumentLinkServiceSettings to
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
 * DocumentLinkServiceSettings documentLinkServiceSettings =
 *     DocumentLinkServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DocumentLinkServiceClient documentLinkServiceClient =
 *     DocumentLinkServiceClient.create(documentLinkServiceSettings);
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
 * DocumentLinkServiceSettings documentLinkServiceSettings =
 *     DocumentLinkServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DocumentLinkServiceClient documentLinkServiceClient =
 *     DocumentLinkServiceClient.create(documentLinkServiceSettings);
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
 * DocumentLinkServiceSettings documentLinkServiceSettings =
 *     DocumentLinkServiceSettings.newHttpJsonBuilder().build();
 * DocumentLinkServiceClient documentLinkServiceClient =
 *     DocumentLinkServiceClient.create(documentLinkServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DocumentLinkServiceClient implements BackgroundResource {
  private final DocumentLinkServiceSettings settings;
  private final DocumentLinkServiceStub stub;

  /** Constructs an instance of DocumentLinkServiceClient with default settings. */
  public static final DocumentLinkServiceClient create() throws IOException {
    return create(DocumentLinkServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DocumentLinkServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DocumentLinkServiceClient create(DocumentLinkServiceSettings settings)
      throws IOException {
    return new DocumentLinkServiceClient(settings);
  }

  /**
   * Constructs an instance of DocumentLinkServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(DocumentLinkServiceSettings).
   */
  public static final DocumentLinkServiceClient create(DocumentLinkServiceStub stub) {
    return new DocumentLinkServiceClient(stub);
  }

  /**
   * Constructs an instance of DocumentLinkServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DocumentLinkServiceClient(DocumentLinkServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DocumentLinkServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DocumentLinkServiceClient(DocumentLinkServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DocumentLinkServiceSettings getSettings() {
    return settings;
  }

  public DocumentLinkServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return all target document-links from the document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
   *   DocumentName parent =
   *       DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");
   *   ListLinkedTargetsResponse response = documentLinkServiceClient.listLinkedTargets(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the document, for which all target links are returned.
   *     Format: projects/{project_number}/locations/{location}/documents/{target_document_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLinkedTargetsResponse listLinkedTargets(DocumentName parent) {
    ListLinkedTargetsRequest request =
        ListLinkedTargetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLinkedTargets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return all target document-links from the document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
   *   String parent =
   *       DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *           .toString();
   *   ListLinkedTargetsResponse response = documentLinkServiceClient.listLinkedTargets(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the document, for which all target links are returned.
   *     Format: projects/{project_number}/locations/{location}/documents/{target_document_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLinkedTargetsResponse listLinkedTargets(String parent) {
    ListLinkedTargetsRequest request =
        ListLinkedTargetsRequest.newBuilder().setParent(parent).build();
    return listLinkedTargets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return all target document-links from the document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
   *   ListLinkedTargetsRequest request =
   *       ListLinkedTargetsRequest.newBuilder()
   *           .setParent(
   *               DocumentName.ofProjectLocationDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *                   .toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .build();
   *   ListLinkedTargetsResponse response = documentLinkServiceClient.listLinkedTargets(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLinkedTargetsResponse listLinkedTargets(ListLinkedTargetsRequest request) {
    return listLinkedTargetsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return all target document-links from the document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
   *   ListLinkedTargetsRequest request =
   *       ListLinkedTargetsRequest.newBuilder()
   *           .setParent(
   *               DocumentName.ofProjectLocationDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *                   .toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .build();
   *   ApiFuture<ListLinkedTargetsResponse> future =
   *       documentLinkServiceClient.listLinkedTargetsCallable().futureCall(request);
   *   // Do something.
   *   ListLinkedTargetsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLinkedTargetsRequest, ListLinkedTargetsResponse>
      listLinkedTargetsCallable() {
    return stub.listLinkedTargetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return all source document-links from the document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
   *   DocumentName parent =
   *       DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");
   *   for (DocumentLink element :
   *       documentLinkServiceClient.listLinkedSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the document, for which all source links are returned.
   *     Format: projects/{project_number}/locations/{location}/documents/{source_document_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLinkedSourcesPagedResponse listLinkedSources(DocumentName parent) {
    ListLinkedSourcesRequest request =
        ListLinkedSourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLinkedSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return all source document-links from the document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
   *   String parent =
   *       DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *           .toString();
   *   for (DocumentLink element :
   *       documentLinkServiceClient.listLinkedSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the document, for which all source links are returned.
   *     Format: projects/{project_number}/locations/{location}/documents/{source_document_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLinkedSourcesPagedResponse listLinkedSources(String parent) {
    ListLinkedSourcesRequest request =
        ListLinkedSourcesRequest.newBuilder().setParent(parent).build();
    return listLinkedSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return all source document-links from the document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
   *   ListLinkedSourcesRequest request =
   *       ListLinkedSourcesRequest.newBuilder()
   *           .setParent(
   *               DocumentName.ofProjectLocationDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .build();
   *   for (DocumentLink element :
   *       documentLinkServiceClient.listLinkedSources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLinkedSourcesPagedResponse listLinkedSources(ListLinkedSourcesRequest request) {
    return listLinkedSourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return all source document-links from the document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
   *   ListLinkedSourcesRequest request =
   *       ListLinkedSourcesRequest.newBuilder()
   *           .setParent(
   *               DocumentName.ofProjectLocationDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .build();
   *   ApiFuture<DocumentLink> future =
   *       documentLinkServiceClient.listLinkedSourcesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DocumentLink element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLinkedSourcesRequest, ListLinkedSourcesPagedResponse>
      listLinkedSourcesPagedCallable() {
    return stub.listLinkedSourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Return all source document-links from the document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
   *   ListLinkedSourcesRequest request =
   *       ListLinkedSourcesRequest.newBuilder()
   *           .setParent(
   *               DocumentName.ofProjectLocationDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListLinkedSourcesResponse response =
   *         documentLinkServiceClient.listLinkedSourcesCallable().call(request);
   *     for (DocumentLink element : response.getDocumentLinksList()) {
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
  public final UnaryCallable<ListLinkedSourcesRequest, ListLinkedSourcesResponse>
      listLinkedSourcesCallable() {
    return stub.listLinkedSourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a link between a source document and a target document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
   *   DocumentName parent =
   *       DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");
   *   DocumentLink documentLink = DocumentLink.newBuilder().build();
   *   DocumentLink response = documentLinkServiceClient.createDocumentLink(parent, documentLink);
   * }
   * }</pre>
   *
   * @param parent Required. Parent of the document-link to be created. parent of document-link
   *     should be a document. Format:
   *     projects/{project_number}/locations/{location}/documents/{source_document_id}.
   * @param documentLink Required. Document links associated with the source documents
   *     (source_document_id).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DocumentLink createDocumentLink(DocumentName parent, DocumentLink documentLink) {
    CreateDocumentLinkRequest request =
        CreateDocumentLinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDocumentLink(documentLink)
            .build();
    return createDocumentLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a link between a source document and a target document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
   *   String parent =
   *       DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *           .toString();
   *   DocumentLink documentLink = DocumentLink.newBuilder().build();
   *   DocumentLink response = documentLinkServiceClient.createDocumentLink(parent, documentLink);
   * }
   * }</pre>
   *
   * @param parent Required. Parent of the document-link to be created. parent of document-link
   *     should be a document. Format:
   *     projects/{project_number}/locations/{location}/documents/{source_document_id}.
   * @param documentLink Required. Document links associated with the source documents
   *     (source_document_id).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DocumentLink createDocumentLink(String parent, DocumentLink documentLink) {
    CreateDocumentLinkRequest request =
        CreateDocumentLinkRequest.newBuilder()
            .setParent(parent)
            .setDocumentLink(documentLink)
            .build();
    return createDocumentLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a link between a source document and a target document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
   *   CreateDocumentLinkRequest request =
   *       CreateDocumentLinkRequest.newBuilder()
   *           .setParent(
   *               DocumentName.ofProjectLocationDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *                   .toString())
   *           .setDocumentLink(DocumentLink.newBuilder().build())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .build();
   *   DocumentLink response = documentLinkServiceClient.createDocumentLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DocumentLink createDocumentLink(CreateDocumentLinkRequest request) {
    return createDocumentLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a link between a source document and a target document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
   *   CreateDocumentLinkRequest request =
   *       CreateDocumentLinkRequest.newBuilder()
   *           .setParent(
   *               DocumentName.ofProjectLocationDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DOCUMENT]")
   *                   .toString())
   *           .setDocumentLink(DocumentLink.newBuilder().build())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .build();
   *   ApiFuture<DocumentLink> future =
   *       documentLinkServiceClient.createDocumentLinkCallable().futureCall(request);
   *   // Do something.
   *   DocumentLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDocumentLinkRequest, DocumentLink> createDocumentLinkCallable() {
    return stub.createDocumentLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove the link between the source and target documents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
   *   DocumentLinkName name =
   *       DocumentLinkName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT]", "[DOCUMENT_LINK]");
   *   documentLinkServiceClient.deleteDocumentLink(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the document-link to be deleted. Format:
   *     projects/{project_number}/locations/{location}/documents/{source_document_id}/documentLinks/{document_link_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDocumentLink(DocumentLinkName name) {
    DeleteDocumentLinkRequest request =
        DeleteDocumentLinkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteDocumentLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove the link between the source and target documents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
   *   String name =
   *       DocumentLinkName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT]", "[DOCUMENT_LINK]")
   *           .toString();
   *   documentLinkServiceClient.deleteDocumentLink(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the document-link to be deleted. Format:
   *     projects/{project_number}/locations/{location}/documents/{source_document_id}/documentLinks/{document_link_id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDocumentLink(String name) {
    DeleteDocumentLinkRequest request =
        DeleteDocumentLinkRequest.newBuilder().setName(name).build();
    deleteDocumentLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove the link between the source and target documents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
   *   DeleteDocumentLinkRequest request =
   *       DeleteDocumentLinkRequest.newBuilder()
   *           .setName(
   *               DocumentLinkName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT]", "[DOCUMENT_LINK]")
   *                   .toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .build();
   *   documentLinkServiceClient.deleteDocumentLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDocumentLink(DeleteDocumentLinkRequest request) {
    deleteDocumentLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove the link between the source and target documents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentLinkServiceClient documentLinkServiceClient = DocumentLinkServiceClient.create()) {
   *   DeleteDocumentLinkRequest request =
   *       DeleteDocumentLinkRequest.newBuilder()
   *           .setName(
   *               DocumentLinkName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT]", "[DOCUMENT_LINK]")
   *                   .toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .build();
   *   ApiFuture<Empty> future =
   *       documentLinkServiceClient.deleteDocumentLinkCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDocumentLinkRequest, Empty> deleteDocumentLinkCallable() {
    return stub.deleteDocumentLinkCallable();
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

  public static class ListLinkedSourcesPagedResponse
      extends AbstractPagedListResponse<
          ListLinkedSourcesRequest,
          ListLinkedSourcesResponse,
          DocumentLink,
          ListLinkedSourcesPage,
          ListLinkedSourcesFixedSizeCollection> {

    public static ApiFuture<ListLinkedSourcesPagedResponse> createAsync(
        PageContext<ListLinkedSourcesRequest, ListLinkedSourcesResponse, DocumentLink> context,
        ApiFuture<ListLinkedSourcesResponse> futureResponse) {
      ApiFuture<ListLinkedSourcesPage> futurePage =
          ListLinkedSourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLinkedSourcesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLinkedSourcesPagedResponse(ListLinkedSourcesPage page) {
      super(page, ListLinkedSourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLinkedSourcesPage
      extends AbstractPage<
          ListLinkedSourcesRequest,
          ListLinkedSourcesResponse,
          DocumentLink,
          ListLinkedSourcesPage> {

    private ListLinkedSourcesPage(
        PageContext<ListLinkedSourcesRequest, ListLinkedSourcesResponse, DocumentLink> context,
        ListLinkedSourcesResponse response) {
      super(context, response);
    }

    private static ListLinkedSourcesPage createEmptyPage() {
      return new ListLinkedSourcesPage(null, null);
    }

    @Override
    protected ListLinkedSourcesPage createPage(
        PageContext<ListLinkedSourcesRequest, ListLinkedSourcesResponse, DocumentLink> context,
        ListLinkedSourcesResponse response) {
      return new ListLinkedSourcesPage(context, response);
    }

    @Override
    public ApiFuture<ListLinkedSourcesPage> createPageAsync(
        PageContext<ListLinkedSourcesRequest, ListLinkedSourcesResponse, DocumentLink> context,
        ApiFuture<ListLinkedSourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLinkedSourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLinkedSourcesRequest,
          ListLinkedSourcesResponse,
          DocumentLink,
          ListLinkedSourcesPage,
          ListLinkedSourcesFixedSizeCollection> {

    private ListLinkedSourcesFixedSizeCollection(
        List<ListLinkedSourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLinkedSourcesFixedSizeCollection createEmptyCollection() {
      return new ListLinkedSourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLinkedSourcesFixedSizeCollection createCollection(
        List<ListLinkedSourcesPage> pages, int collectionSize) {
      return new ListLinkedSourcesFixedSizeCollection(pages, collectionSize);
    }
  }
}
