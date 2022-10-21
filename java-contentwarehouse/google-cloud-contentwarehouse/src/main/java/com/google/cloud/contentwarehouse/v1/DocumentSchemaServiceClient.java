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
import com.google.cloud.contentwarehouse.v1.stub.DocumentSchemaServiceStub;
import com.google.cloud.contentwarehouse.v1.stub.DocumentSchemaServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This service lets you manage document schema.
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
 * try (DocumentSchemaServiceClient documentSchemaServiceClient =
 *     DocumentSchemaServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   DocumentSchema documentSchema = DocumentSchema.newBuilder().build();
 *   DocumentSchema response =
 *       documentSchemaServiceClient.createDocumentSchema(parent, documentSchema);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DocumentSchemaServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of DocumentSchemaServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DocumentSchemaServiceSettings documentSchemaServiceSettings =
 *     DocumentSchemaServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DocumentSchemaServiceClient documentSchemaServiceClient =
 *     DocumentSchemaServiceClient.create(documentSchemaServiceSettings);
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
 * DocumentSchemaServiceSettings documentSchemaServiceSettings =
 *     DocumentSchemaServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DocumentSchemaServiceClient documentSchemaServiceClient =
 *     DocumentSchemaServiceClient.create(documentSchemaServiceSettings);
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
 * DocumentSchemaServiceSettings documentSchemaServiceSettings =
 *     DocumentSchemaServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             DocumentSchemaServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * DocumentSchemaServiceClient documentSchemaServiceClient =
 *     DocumentSchemaServiceClient.create(documentSchemaServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DocumentSchemaServiceClient implements BackgroundResource {
  private final DocumentSchemaServiceSettings settings;
  private final DocumentSchemaServiceStub stub;

  /** Constructs an instance of DocumentSchemaServiceClient with default settings. */
  public static final DocumentSchemaServiceClient create() throws IOException {
    return create(DocumentSchemaServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DocumentSchemaServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DocumentSchemaServiceClient create(DocumentSchemaServiceSettings settings)
      throws IOException {
    return new DocumentSchemaServiceClient(settings);
  }

  /**
   * Constructs an instance of DocumentSchemaServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(DocumentSchemaServiceSettings).
   */
  public static final DocumentSchemaServiceClient create(DocumentSchemaServiceStub stub) {
    return new DocumentSchemaServiceClient(stub);
  }

  /**
   * Constructs an instance of DocumentSchemaServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DocumentSchemaServiceClient(DocumentSchemaServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DocumentSchemaServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DocumentSchemaServiceClient(DocumentSchemaServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DocumentSchemaServiceSettings getSettings() {
    return settings;
  }

  public DocumentSchemaServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a document schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   DocumentSchema documentSchema = DocumentSchema.newBuilder().build();
   *   DocumentSchema response =
   *       documentSchemaServiceClient.createDocumentSchema(parent, documentSchema);
   * }
   * }</pre>
   *
   * @param parent Required. The parent name.
   * @param documentSchema Required. The document schema to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DocumentSchema createDocumentSchema(
      LocationName parent, DocumentSchema documentSchema) {
    CreateDocumentSchemaRequest request =
        CreateDocumentSchemaRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDocumentSchema(documentSchema)
            .build();
    return createDocumentSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a document schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   DocumentSchema documentSchema = DocumentSchema.newBuilder().build();
   *   DocumentSchema response =
   *       documentSchemaServiceClient.createDocumentSchema(parent, documentSchema);
   * }
   * }</pre>
   *
   * @param parent Required. The parent name.
   * @param documentSchema Required. The document schema to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DocumentSchema createDocumentSchema(String parent, DocumentSchema documentSchema) {
    CreateDocumentSchemaRequest request =
        CreateDocumentSchemaRequest.newBuilder()
            .setParent(parent)
            .setDocumentSchema(documentSchema)
            .build();
    return createDocumentSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a document schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   CreateDocumentSchemaRequest request =
   *       CreateDocumentSchemaRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDocumentSchema(DocumentSchema.newBuilder().build())
   *           .build();
   *   DocumentSchema response = documentSchemaServiceClient.createDocumentSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DocumentSchema createDocumentSchema(CreateDocumentSchemaRequest request) {
    return createDocumentSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a document schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   CreateDocumentSchemaRequest request =
   *       CreateDocumentSchemaRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDocumentSchema(DocumentSchema.newBuilder().build())
   *           .build();
   *   ApiFuture<DocumentSchema> future =
   *       documentSchemaServiceClient.createDocumentSchemaCallable().futureCall(request);
   *   // Do something.
   *   DocumentSchema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDocumentSchemaRequest, DocumentSchema>
      createDocumentSchemaCallable() {
    return stub.createDocumentSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Document Schema. Returns INVALID_ARGUMENT if the name of the Document Schema is
   * non-empty and does not equal the existing name. Supports only appending new properties, adding
   * new ENUM possible values, and updating the
   * [EnumTypeOptions.validation_check_disabled][google.cloud.contentwarehouse.v1.EnumTypeOptions.validation_check_disabled]
   * flag for ENUM possible values. Updating existing properties will result into INVALID_ARGUMENT.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   DocumentSchemaName name =
   *       DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]");
   *   DocumentSchema documentSchema = DocumentSchema.newBuilder().build();
   *   DocumentSchema response =
   *       documentSchemaServiceClient.updateDocumentSchema(name, documentSchema);
   * }
   * }</pre>
   *
   * @param name Required. The name of the document schema to update. Format:
   *     projects/{project_number}/locations/{location}/documentSchemas/{document_schema_id}.
   * @param documentSchema Required. The document schema to update with.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DocumentSchema updateDocumentSchema(
      DocumentSchemaName name, DocumentSchema documentSchema) {
    UpdateDocumentSchemaRequest request =
        UpdateDocumentSchemaRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDocumentSchema(documentSchema)
            .build();
    return updateDocumentSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Document Schema. Returns INVALID_ARGUMENT if the name of the Document Schema is
   * non-empty and does not equal the existing name. Supports only appending new properties, adding
   * new ENUM possible values, and updating the
   * [EnumTypeOptions.validation_check_disabled][google.cloud.contentwarehouse.v1.EnumTypeOptions.validation_check_disabled]
   * flag for ENUM possible values. Updating existing properties will result into INVALID_ARGUMENT.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   String name =
   *       DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]").toString();
   *   DocumentSchema documentSchema = DocumentSchema.newBuilder().build();
   *   DocumentSchema response =
   *       documentSchemaServiceClient.updateDocumentSchema(name, documentSchema);
   * }
   * }</pre>
   *
   * @param name Required. The name of the document schema to update. Format:
   *     projects/{project_number}/locations/{location}/documentSchemas/{document_schema_id}.
   * @param documentSchema Required. The document schema to update with.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DocumentSchema updateDocumentSchema(String name, DocumentSchema documentSchema) {
    UpdateDocumentSchemaRequest request =
        UpdateDocumentSchemaRequest.newBuilder()
            .setName(name)
            .setDocumentSchema(documentSchema)
            .build();
    return updateDocumentSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Document Schema. Returns INVALID_ARGUMENT if the name of the Document Schema is
   * non-empty and does not equal the existing name. Supports only appending new properties, adding
   * new ENUM possible values, and updating the
   * [EnumTypeOptions.validation_check_disabled][google.cloud.contentwarehouse.v1.EnumTypeOptions.validation_check_disabled]
   * flag for ENUM possible values. Updating existing properties will result into INVALID_ARGUMENT.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   UpdateDocumentSchemaRequest request =
   *       UpdateDocumentSchemaRequest.newBuilder()
   *           .setName(
   *               DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]").toString())
   *           .setDocumentSchema(DocumentSchema.newBuilder().build())
   *           .build();
   *   DocumentSchema response = documentSchemaServiceClient.updateDocumentSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DocumentSchema updateDocumentSchema(UpdateDocumentSchemaRequest request) {
    return updateDocumentSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Document Schema. Returns INVALID_ARGUMENT if the name of the Document Schema is
   * non-empty and does not equal the existing name. Supports only appending new properties, adding
   * new ENUM possible values, and updating the
   * [EnumTypeOptions.validation_check_disabled][google.cloud.contentwarehouse.v1.EnumTypeOptions.validation_check_disabled]
   * flag for ENUM possible values. Updating existing properties will result into INVALID_ARGUMENT.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   UpdateDocumentSchemaRequest request =
   *       UpdateDocumentSchemaRequest.newBuilder()
   *           .setName(
   *               DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]").toString())
   *           .setDocumentSchema(DocumentSchema.newBuilder().build())
   *           .build();
   *   ApiFuture<DocumentSchema> future =
   *       documentSchemaServiceClient.updateDocumentSchemaCallable().futureCall(request);
   *   // Do something.
   *   DocumentSchema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDocumentSchemaRequest, DocumentSchema>
      updateDocumentSchemaCallable() {
    return stub.updateDocumentSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a document schema. Returns NOT_FOUND if the document schema does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   DocumentSchemaName name =
   *       DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]");
   *   DocumentSchema response = documentSchemaServiceClient.getDocumentSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the document schema to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DocumentSchema getDocumentSchema(DocumentSchemaName name) {
    GetDocumentSchemaRequest request =
        GetDocumentSchemaRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDocumentSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a document schema. Returns NOT_FOUND if the document schema does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   String name =
   *       DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]").toString();
   *   DocumentSchema response = documentSchemaServiceClient.getDocumentSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the document schema to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DocumentSchema getDocumentSchema(String name) {
    GetDocumentSchemaRequest request = GetDocumentSchemaRequest.newBuilder().setName(name).build();
    return getDocumentSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a document schema. Returns NOT_FOUND if the document schema does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   GetDocumentSchemaRequest request =
   *       GetDocumentSchemaRequest.newBuilder()
   *           .setName(
   *               DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]").toString())
   *           .build();
   *   DocumentSchema response = documentSchemaServiceClient.getDocumentSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DocumentSchema getDocumentSchema(GetDocumentSchemaRequest request) {
    return getDocumentSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a document schema. Returns NOT_FOUND if the document schema does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   GetDocumentSchemaRequest request =
   *       GetDocumentSchemaRequest.newBuilder()
   *           .setName(
   *               DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]").toString())
   *           .build();
   *   ApiFuture<DocumentSchema> future =
   *       documentSchemaServiceClient.getDocumentSchemaCallable().futureCall(request);
   *   // Do something.
   *   DocumentSchema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDocumentSchemaRequest, DocumentSchema> getDocumentSchemaCallable() {
    return stub.getDocumentSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a document schema. Returns NOT_FOUND if the document schema does not exist. Returns
   * BAD_REQUEST if the document schema has documents depending on it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   DocumentSchemaName name =
   *       DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]");
   *   documentSchemaServiceClient.deleteDocumentSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the document schema to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDocumentSchema(DocumentSchemaName name) {
    DeleteDocumentSchemaRequest request =
        DeleteDocumentSchemaRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteDocumentSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a document schema. Returns NOT_FOUND if the document schema does not exist. Returns
   * BAD_REQUEST if the document schema has documents depending on it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   String name =
   *       DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]").toString();
   *   documentSchemaServiceClient.deleteDocumentSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the document schema to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDocumentSchema(String name) {
    DeleteDocumentSchemaRequest request =
        DeleteDocumentSchemaRequest.newBuilder().setName(name).build();
    deleteDocumentSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a document schema. Returns NOT_FOUND if the document schema does not exist. Returns
   * BAD_REQUEST if the document schema has documents depending on it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   DeleteDocumentSchemaRequest request =
   *       DeleteDocumentSchemaRequest.newBuilder()
   *           .setName(
   *               DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]").toString())
   *           .build();
   *   documentSchemaServiceClient.deleteDocumentSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDocumentSchema(DeleteDocumentSchemaRequest request) {
    deleteDocumentSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a document schema. Returns NOT_FOUND if the document schema does not exist. Returns
   * BAD_REQUEST if the document schema has documents depending on it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   DeleteDocumentSchemaRequest request =
   *       DeleteDocumentSchemaRequest.newBuilder()
   *           .setName(
   *               DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       documentSchemaServiceClient.deleteDocumentSchemaCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDocumentSchemaRequest, Empty> deleteDocumentSchemaCallable() {
    return stub.deleteDocumentSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists document schemas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DocumentSchema element :
   *       documentSchemaServiceClient.listDocumentSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of document schemas. Format:
   *     projects/{project_number}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDocumentSchemasPagedResponse listDocumentSchemas(LocationName parent) {
    ListDocumentSchemasRequest request =
        ListDocumentSchemasRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDocumentSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists document schemas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DocumentSchema element :
   *       documentSchemaServiceClient.listDocumentSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of document schemas. Format:
   *     projects/{project_number}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDocumentSchemasPagedResponse listDocumentSchemas(String parent) {
    ListDocumentSchemasRequest request =
        ListDocumentSchemasRequest.newBuilder().setParent(parent).build();
    return listDocumentSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists document schemas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   ListDocumentSchemasRequest request =
   *       ListDocumentSchemasRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DocumentSchema element :
   *       documentSchemaServiceClient.listDocumentSchemas(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDocumentSchemasPagedResponse listDocumentSchemas(
      ListDocumentSchemasRequest request) {
    return listDocumentSchemasPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists document schemas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   ListDocumentSchemasRequest request =
   *       ListDocumentSchemasRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DocumentSchema> future =
   *       documentSchemaServiceClient.listDocumentSchemasPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DocumentSchema element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDocumentSchemasRequest, ListDocumentSchemasPagedResponse>
      listDocumentSchemasPagedCallable() {
    return stub.listDocumentSchemasPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists document schemas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentSchemaServiceClient documentSchemaServiceClient =
   *     DocumentSchemaServiceClient.create()) {
   *   ListDocumentSchemasRequest request =
   *       ListDocumentSchemasRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDocumentSchemasResponse response =
   *         documentSchemaServiceClient.listDocumentSchemasCallable().call(request);
   *     for (DocumentSchema element : response.getDocumentSchemasList()) {
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
  public final UnaryCallable<ListDocumentSchemasRequest, ListDocumentSchemasResponse>
      listDocumentSchemasCallable() {
    return stub.listDocumentSchemasCallable();
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

  public static class ListDocumentSchemasPagedResponse
      extends AbstractPagedListResponse<
          ListDocumentSchemasRequest,
          ListDocumentSchemasResponse,
          DocumentSchema,
          ListDocumentSchemasPage,
          ListDocumentSchemasFixedSizeCollection> {

    public static ApiFuture<ListDocumentSchemasPagedResponse> createAsync(
        PageContext<ListDocumentSchemasRequest, ListDocumentSchemasResponse, DocumentSchema>
            context,
        ApiFuture<ListDocumentSchemasResponse> futureResponse) {
      ApiFuture<ListDocumentSchemasPage> futurePage =
          ListDocumentSchemasPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDocumentSchemasPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDocumentSchemasPagedResponse(ListDocumentSchemasPage page) {
      super(page, ListDocumentSchemasFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDocumentSchemasPage
      extends AbstractPage<
          ListDocumentSchemasRequest,
          ListDocumentSchemasResponse,
          DocumentSchema,
          ListDocumentSchemasPage> {

    private ListDocumentSchemasPage(
        PageContext<ListDocumentSchemasRequest, ListDocumentSchemasResponse, DocumentSchema>
            context,
        ListDocumentSchemasResponse response) {
      super(context, response);
    }

    private static ListDocumentSchemasPage createEmptyPage() {
      return new ListDocumentSchemasPage(null, null);
    }

    @Override
    protected ListDocumentSchemasPage createPage(
        PageContext<ListDocumentSchemasRequest, ListDocumentSchemasResponse, DocumentSchema>
            context,
        ListDocumentSchemasResponse response) {
      return new ListDocumentSchemasPage(context, response);
    }

    @Override
    public ApiFuture<ListDocumentSchemasPage> createPageAsync(
        PageContext<ListDocumentSchemasRequest, ListDocumentSchemasResponse, DocumentSchema>
            context,
        ApiFuture<ListDocumentSchemasResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDocumentSchemasFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDocumentSchemasRequest,
          ListDocumentSchemasResponse,
          DocumentSchema,
          ListDocumentSchemasPage,
          ListDocumentSchemasFixedSizeCollection> {

    private ListDocumentSchemasFixedSizeCollection(
        List<ListDocumentSchemasPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDocumentSchemasFixedSizeCollection createEmptyCollection() {
      return new ListDocumentSchemasFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDocumentSchemasFixedSizeCollection createCollection(
        List<ListDocumentSchemasPage> pages, int collectionSize) {
      return new ListDocumentSchemasFixedSizeCollection(pages, collectionSize);
    }
  }
}
