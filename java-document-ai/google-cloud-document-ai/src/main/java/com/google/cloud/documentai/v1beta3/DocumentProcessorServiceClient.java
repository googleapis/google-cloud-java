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

package com.google.cloud.documentai.v1beta3;

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
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.documentai.v1beta3.stub.DocumentProcessorServiceStub;
import com.google.cloud.documentai.v1beta3.stub.DocumentProcessorServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to call Cloud DocumentAI to process documents according to the
 * processor's definition. Processors are built using state-of-the-art Google AI such as natural
 * language, computer vision, and translation to extract structured information from unstructured or
 * semi-structured documents.
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
 * try (DocumentProcessorServiceClient documentProcessorServiceClient =
 *     DocumentProcessorServiceClient.create()) {
 *   ResourceName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
 *   ProcessResponse response = documentProcessorServiceClient.processDocument(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DocumentProcessorServiceClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of
 * DocumentProcessorServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DocumentProcessorServiceSettings documentProcessorServiceSettings =
 *     DocumentProcessorServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DocumentProcessorServiceClient documentProcessorServiceClient =
 *     DocumentProcessorServiceClient.create(documentProcessorServiceSettings);
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
 * DocumentProcessorServiceSettings documentProcessorServiceSettings =
 *     DocumentProcessorServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DocumentProcessorServiceClient documentProcessorServiceClient =
 *     DocumentProcessorServiceClient.create(documentProcessorServiceSettings);
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
 * DocumentProcessorServiceSettings documentProcessorServiceSettings =
 *     DocumentProcessorServiceSettings.newHttpJsonBuilder().build();
 * DocumentProcessorServiceClient documentProcessorServiceClient =
 *     DocumentProcessorServiceClient.create(documentProcessorServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DocumentProcessorServiceClient implements BackgroundResource {
  private final DocumentProcessorServiceSettings settings;
  private final DocumentProcessorServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DocumentProcessorServiceClient with default settings. */
  public static final DocumentProcessorServiceClient create() throws IOException {
    return create(DocumentProcessorServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DocumentProcessorServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final DocumentProcessorServiceClient create(
      DocumentProcessorServiceSettings settings) throws IOException {
    return new DocumentProcessorServiceClient(settings);
  }

  /**
   * Constructs an instance of DocumentProcessorServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(DocumentProcessorServiceSettings).
   */
  public static final DocumentProcessorServiceClient create(DocumentProcessorServiceStub stub) {
    return new DocumentProcessorServiceClient(stub);
  }

  /**
   * Constructs an instance of DocumentProcessorServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DocumentProcessorServiceClient(DocumentProcessorServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((DocumentProcessorServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DocumentProcessorServiceClient(DocumentProcessorServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DocumentProcessorServiceSettings getSettings() {
    return settings;
  }

  public DocumentProcessorServiceStub getStub() {
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
   * Processes a single document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ResourceName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   ProcessResponse response = documentProcessorServiceClient.processDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [Processor][google.cloud.documentai.v1beta3.Processor] or
   *     [ProcessorVersion][google.cloud.documentai.v1beta3.ProcessorVersion] to use for processing.
   *     If a [Processor][google.cloud.documentai.v1beta3.Processor] is specified, the server will
   *     use its [default
   *     version][google.cloud.documentai.v1beta3.Processor.default_processor_version]. Format:
   *     `projects/{project}/locations/{location}/processors/{processor}`, or
   *     `projects/{project}/locations/{location}/processors/{processor}/processorVersions/{processorVersion}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProcessResponse processDocument(ResourceName name) {
    ProcessRequest request =
        ProcessRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return processDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Processes a single document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String name =
   *       EvaluationName.of(
   *               "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]", "[EVALUATION]")
   *           .toString();
   *   ProcessResponse response = documentProcessorServiceClient.processDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [Processor][google.cloud.documentai.v1beta3.Processor] or
   *     [ProcessorVersion][google.cloud.documentai.v1beta3.ProcessorVersion] to use for processing.
   *     If a [Processor][google.cloud.documentai.v1beta3.Processor] is specified, the server will
   *     use its [default
   *     version][google.cloud.documentai.v1beta3.Processor.default_processor_version]. Format:
   *     `projects/{project}/locations/{location}/processors/{processor}`, or
   *     `projects/{project}/locations/{location}/processors/{processor}/processorVersions/{processorVersion}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProcessResponse processDocument(String name) {
    ProcessRequest request = ProcessRequest.newBuilder().setName(name).build();
    return processDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Processes a single document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ProcessRequest request =
   *       ProcessRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setDocument(Document.newBuilder().build())
   *           .setSkipHumanReview(true)
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .setProcessOptions(ProcessOptions.newBuilder().build())
   *           .build();
   *   ProcessResponse response = documentProcessorServiceClient.processDocument(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProcessResponse processDocument(ProcessRequest request) {
    return processDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Processes a single document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ProcessRequest request =
   *       ProcessRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setDocument(Document.newBuilder().build())
   *           .setSkipHumanReview(true)
   *           .setFieldMask(FieldMask.newBuilder().build())
   *           .setProcessOptions(ProcessOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<ProcessResponse> future =
   *       documentProcessorServiceClient.processDocumentCallable().futureCall(request);
   *   // Do something.
   *   ProcessResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ProcessRequest, ProcessResponse> processDocumentCallable() {
    return stub.processDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * LRO endpoint to batch process many documents. The output is written to Cloud Storage as JSON in
   * the [Document] format.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ResourceName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   BatchProcessResponse response =
   *       documentProcessorServiceClient.batchProcessDocumentsAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of
   *     [Processor][google.cloud.documentai.v1beta3.Processor] or
   *     [ProcessorVersion][google.cloud.documentai.v1beta3.ProcessorVersion]. Format:
   *     `projects/{project}/locations/{location}/processors/{processor}`, or
   *     `projects/{project}/locations/{location}/processors/{processor}/processorVersions/{processorVersion}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsAsync(ResourceName name) {
    BatchProcessRequest request =
        BatchProcessRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return batchProcessDocumentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * LRO endpoint to batch process many documents. The output is written to Cloud Storage as JSON in
   * the [Document] format.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String name =
   *       EvaluationName.of(
   *               "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]", "[EVALUATION]")
   *           .toString();
   *   BatchProcessResponse response =
   *       documentProcessorServiceClient.batchProcessDocumentsAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of
   *     [Processor][google.cloud.documentai.v1beta3.Processor] or
   *     [ProcessorVersion][google.cloud.documentai.v1beta3.ProcessorVersion]. Format:
   *     `projects/{project}/locations/{location}/processors/{processor}`, or
   *     `projects/{project}/locations/{location}/processors/{processor}/processorVersions/{processorVersion}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsAsync(String name) {
    BatchProcessRequest request = BatchProcessRequest.newBuilder().setName(name).build();
    return batchProcessDocumentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * LRO endpoint to batch process many documents. The output is written to Cloud Storage as JSON in
   * the [Document] format.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   BatchProcessRequest request =
   *       BatchProcessRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .addAllInputConfigs(new ArrayList<BatchProcessRequest.BatchInputConfig>())
   *           .setOutputConfig(BatchProcessRequest.BatchOutputConfig.newBuilder().build())
   *           .setInputDocuments(BatchDocumentsInputConfig.newBuilder().build())
   *           .setDocumentOutputConfig(DocumentOutputConfig.newBuilder().build())
   *           .setSkipHumanReview(true)
   *           .setProcessOptions(ProcessOptions.newBuilder().build())
   *           .build();
   *   BatchProcessResponse response =
   *       documentProcessorServiceClient.batchProcessDocumentsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsAsync(BatchProcessRequest request) {
    return batchProcessDocumentsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * LRO endpoint to batch process many documents. The output is written to Cloud Storage as JSON in
   * the [Document] format.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   BatchProcessRequest request =
   *       BatchProcessRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .addAllInputConfigs(new ArrayList<BatchProcessRequest.BatchInputConfig>())
   *           .setOutputConfig(BatchProcessRequest.BatchOutputConfig.newBuilder().build())
   *           .setInputDocuments(BatchDocumentsInputConfig.newBuilder().build())
   *           .setDocumentOutputConfig(DocumentOutputConfig.newBuilder().build())
   *           .setSkipHumanReview(true)
   *           .setProcessOptions(ProcessOptions.newBuilder().build())
   *           .build();
   *   OperationFuture<BatchProcessResponse, BatchProcessMetadata> future =
   *       documentProcessorServiceClient
   *           .batchProcessDocumentsOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchProcessResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsOperationCallable() {
    return stub.batchProcessDocumentsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * LRO endpoint to batch process many documents. The output is written to Cloud Storage as JSON in
   * the [Document] format.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   BatchProcessRequest request =
   *       BatchProcessRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .addAllInputConfigs(new ArrayList<BatchProcessRequest.BatchInputConfig>())
   *           .setOutputConfig(BatchProcessRequest.BatchOutputConfig.newBuilder().build())
   *           .setInputDocuments(BatchDocumentsInputConfig.newBuilder().build())
   *           .setDocumentOutputConfig(DocumentOutputConfig.newBuilder().build())
   *           .setSkipHumanReview(true)
   *           .setProcessOptions(ProcessOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       documentProcessorServiceClient.batchProcessDocumentsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchProcessRequest, Operation> batchProcessDocumentsCallable() {
    return stub.batchProcessDocumentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches processor types. Note that we do not use ListProcessorTypes here because it is not
   * paginated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   FetchProcessorTypesResponse response =
   *       documentProcessorServiceClient.fetchProcessorTypes(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The project of processor type to list. The available processor types
   *     may depend on the allow-listing on projects. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchProcessorTypesResponse fetchProcessorTypes(LocationName parent) {
    FetchProcessorTypesRequest request =
        FetchProcessorTypesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return fetchProcessorTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches processor types. Note that we do not use ListProcessorTypes here because it is not
   * paginated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   FetchProcessorTypesResponse response =
   *       documentProcessorServiceClient.fetchProcessorTypes(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The project of processor type to list. The available processor types
   *     may depend on the allow-listing on projects. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchProcessorTypesResponse fetchProcessorTypes(String parent) {
    FetchProcessorTypesRequest request =
        FetchProcessorTypesRequest.newBuilder().setParent(parent).build();
    return fetchProcessorTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches processor types. Note that we do not use ListProcessorTypes here because it is not
   * paginated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   FetchProcessorTypesRequest request =
   *       FetchProcessorTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   FetchProcessorTypesResponse response =
   *       documentProcessorServiceClient.fetchProcessorTypes(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchProcessorTypesResponse fetchProcessorTypes(FetchProcessorTypesRequest request) {
    return fetchProcessorTypesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches processor types. Note that we do not use ListProcessorTypes here because it is not
   * paginated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   FetchProcessorTypesRequest request =
   *       FetchProcessorTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<FetchProcessorTypesResponse> future =
   *       documentProcessorServiceClient.fetchProcessorTypesCallable().futureCall(request);
   *   // Do something.
   *   FetchProcessorTypesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchProcessorTypesRequest, FetchProcessorTypesResponse>
      fetchProcessorTypesCallable() {
    return stub.fetchProcessorTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the processor types that exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ProcessorType element :
   *       documentProcessorServiceClient.listProcessorTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location of processor type to list. The available processor types
   *     may depend on the allow-listing on projects. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProcessorTypesPagedResponse listProcessorTypes(LocationName parent) {
    ListProcessorTypesRequest request =
        ListProcessorTypesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProcessorTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the processor types that exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ProcessorType element :
   *       documentProcessorServiceClient.listProcessorTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location of processor type to list. The available processor types
   *     may depend on the allow-listing on projects. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProcessorTypesPagedResponse listProcessorTypes(String parent) {
    ListProcessorTypesRequest request =
        ListProcessorTypesRequest.newBuilder().setParent(parent).build();
    return listProcessorTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the processor types that exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ListProcessorTypesRequest request =
   *       ListProcessorTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ProcessorType element :
   *       documentProcessorServiceClient.listProcessorTypes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProcessorTypesPagedResponse listProcessorTypes(
      ListProcessorTypesRequest request) {
    return listProcessorTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the processor types that exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ListProcessorTypesRequest request =
   *       ListProcessorTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ProcessorType> future =
   *       documentProcessorServiceClient.listProcessorTypesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ProcessorType element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProcessorTypesRequest, ListProcessorTypesPagedResponse>
      listProcessorTypesPagedCallable() {
    return stub.listProcessorTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the processor types that exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ListProcessorTypesRequest request =
   *       ListProcessorTypesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListProcessorTypesResponse response =
   *         documentProcessorServiceClient.listProcessorTypesCallable().call(request);
   *     for (ProcessorType element : response.getProcessorTypesList()) {
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
  public final UnaryCallable<ListProcessorTypesRequest, ListProcessorTypesResponse>
      listProcessorTypesCallable() {
    return stub.listProcessorTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all processors which belong to this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Processor element : documentProcessorServiceClient.listProcessors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) which owns this collection of
   *     Processors. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProcessorsPagedResponse listProcessors(LocationName parent) {
    ListProcessorsRequest request =
        ListProcessorsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProcessors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all processors which belong to this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Processor element : documentProcessorServiceClient.listProcessors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) which owns this collection of
   *     Processors. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProcessorsPagedResponse listProcessors(String parent) {
    ListProcessorsRequest request = ListProcessorsRequest.newBuilder().setParent(parent).build();
    return listProcessors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all processors which belong to this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ListProcessorsRequest request =
   *       ListProcessorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Processor element :
   *       documentProcessorServiceClient.listProcessors(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProcessorsPagedResponse listProcessors(ListProcessorsRequest request) {
    return listProcessorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all processors which belong to this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ListProcessorsRequest request =
   *       ListProcessorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Processor> future =
   *       documentProcessorServiceClient.listProcessorsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Processor element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProcessorsRequest, ListProcessorsPagedResponse>
      listProcessorsPagedCallable() {
    return stub.listProcessorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all processors which belong to this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ListProcessorsRequest request =
   *       ListProcessorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListProcessorsResponse response =
   *         documentProcessorServiceClient.listProcessorsCallable().call(request);
   *     for (Processor element : response.getProcessorsList()) {
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
  public final UnaryCallable<ListProcessorsRequest, ListProcessorsResponse>
      listProcessorsCallable() {
    return stub.listProcessorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a processor detail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   Processor response = documentProcessorServiceClient.getProcessor(name);
   * }
   * }</pre>
   *
   * @param name Required. The processor resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Processor getProcessor(ProcessorName name) {
    GetProcessorRequest request =
        GetProcessorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProcessor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a processor detail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString();
   *   Processor response = documentProcessorServiceClient.getProcessor(name);
   * }
   * }</pre>
   *
   * @param name Required. The processor resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Processor getProcessor(String name) {
    GetProcessorRequest request = GetProcessorRequest.newBuilder().setName(name).build();
    return getProcessor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a processor detail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   GetProcessorRequest request =
   *       GetProcessorRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .build();
   *   Processor response = documentProcessorServiceClient.getProcessor(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Processor getProcessor(GetProcessorRequest request) {
    return getProcessorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a processor detail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   GetProcessorRequest request =
   *       GetProcessorRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .build();
   *   ApiFuture<Processor> future =
   *       documentProcessorServiceClient.getProcessorCallable().futureCall(request);
   *   // Do something.
   *   Processor response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProcessorRequest, Processor> getProcessorCallable() {
    return stub.getProcessorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Trains a new processor version. Operation metadata is returned as
   * cloud_documentai_core.TrainProcessorVersionMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ProcessorName parent = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   ProcessorVersion processorVersion = ProcessorVersion.newBuilder().build();
   *   TrainProcessorVersionResponse response =
   *       documentProcessorServiceClient.trainProcessorVersionAsync(parent, processorVersion).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project, location and processor) to create the new version
   *     for. Format: `projects/{project}/locations/{location}/processors/{processor}`.
   * @param processorVersion Required. The processor version to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TrainProcessorVersionResponse, TrainProcessorVersionMetadata>
      trainProcessorVersionAsync(ProcessorName parent, ProcessorVersion processorVersion) {
    TrainProcessorVersionRequest request =
        TrainProcessorVersionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setProcessorVersion(processorVersion)
            .build();
    return trainProcessorVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Trains a new processor version. Operation metadata is returned as
   * cloud_documentai_core.TrainProcessorVersionMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String parent = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString();
   *   ProcessorVersion processorVersion = ProcessorVersion.newBuilder().build();
   *   TrainProcessorVersionResponse response =
   *       documentProcessorServiceClient.trainProcessorVersionAsync(parent, processorVersion).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project, location and processor) to create the new version
   *     for. Format: `projects/{project}/locations/{location}/processors/{processor}`.
   * @param processorVersion Required. The processor version to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TrainProcessorVersionResponse, TrainProcessorVersionMetadata>
      trainProcessorVersionAsync(String parent, ProcessorVersion processorVersion) {
    TrainProcessorVersionRequest request =
        TrainProcessorVersionRequest.newBuilder()
            .setParent(parent)
            .setProcessorVersion(processorVersion)
            .build();
    return trainProcessorVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Trains a new processor version. Operation metadata is returned as
   * cloud_documentai_core.TrainProcessorVersionMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   TrainProcessorVersionRequest request =
   *       TrainProcessorVersionRequest.newBuilder()
   *           .setParent(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setProcessorVersion(ProcessorVersion.newBuilder().build())
   *           .setDocumentSchema(DocumentSchema.newBuilder().build())
   *           .setInputData(TrainProcessorVersionRequest.InputData.newBuilder().build())
   *           .setBaseProcessorVersion("baseProcessorVersion337709271")
   *           .build();
   *   TrainProcessorVersionResponse response =
   *       documentProcessorServiceClient.trainProcessorVersionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TrainProcessorVersionResponse, TrainProcessorVersionMetadata>
      trainProcessorVersionAsync(TrainProcessorVersionRequest request) {
    return trainProcessorVersionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Trains a new processor version. Operation metadata is returned as
   * cloud_documentai_core.TrainProcessorVersionMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   TrainProcessorVersionRequest request =
   *       TrainProcessorVersionRequest.newBuilder()
   *           .setParent(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setProcessorVersion(ProcessorVersion.newBuilder().build())
   *           .setDocumentSchema(DocumentSchema.newBuilder().build())
   *           .setInputData(TrainProcessorVersionRequest.InputData.newBuilder().build())
   *           .setBaseProcessorVersion("baseProcessorVersion337709271")
   *           .build();
   *   OperationFuture<TrainProcessorVersionResponse, TrainProcessorVersionMetadata> future =
   *       documentProcessorServiceClient
   *           .trainProcessorVersionOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   TrainProcessorVersionResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          TrainProcessorVersionRequest,
          TrainProcessorVersionResponse,
          TrainProcessorVersionMetadata>
      trainProcessorVersionOperationCallable() {
    return stub.trainProcessorVersionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Trains a new processor version. Operation metadata is returned as
   * cloud_documentai_core.TrainProcessorVersionMetadata.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   TrainProcessorVersionRequest request =
   *       TrainProcessorVersionRequest.newBuilder()
   *           .setParent(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setProcessorVersion(ProcessorVersion.newBuilder().build())
   *           .setDocumentSchema(DocumentSchema.newBuilder().build())
   *           .setInputData(TrainProcessorVersionRequest.InputData.newBuilder().build())
   *           .setBaseProcessorVersion("baseProcessorVersion337709271")
   *           .build();
   *   ApiFuture<Operation> future =
   *       documentProcessorServiceClient.trainProcessorVersionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TrainProcessorVersionRequest, Operation>
      trainProcessorVersionCallable() {
    return stub.trainProcessorVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a processor version detail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ProcessorVersionName name =
   *       ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]");
   *   ProcessorVersion response = documentProcessorServiceClient.getProcessorVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The processor resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProcessorVersion getProcessorVersion(ProcessorVersionName name) {
    GetProcessorVersionRequest request =
        GetProcessorVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getProcessorVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a processor version detail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String name =
   *       ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *           .toString();
   *   ProcessorVersion response = documentProcessorServiceClient.getProcessorVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The processor resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProcessorVersion getProcessorVersion(String name) {
    GetProcessorVersionRequest request =
        GetProcessorVersionRequest.newBuilder().setName(name).build();
    return getProcessorVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a processor version detail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   GetProcessorVersionRequest request =
   *       GetProcessorVersionRequest.newBuilder()
   *           .setName(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .build();
   *   ProcessorVersion response = documentProcessorServiceClient.getProcessorVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProcessorVersion getProcessorVersion(GetProcessorVersionRequest request) {
    return getProcessorVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a processor version detail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   GetProcessorVersionRequest request =
   *       GetProcessorVersionRequest.newBuilder()
   *           .setName(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ProcessorVersion> future =
   *       documentProcessorServiceClient.getProcessorVersionCallable().futureCall(request);
   *   // Do something.
   *   ProcessorVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProcessorVersionRequest, ProcessorVersion>
      getProcessorVersionCallable() {
    return stub.getProcessorVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all versions of a processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ProcessorName parent = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   for (ProcessorVersion element :
   *       documentProcessorServiceClient.listProcessorVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project, location and processor) to list all versions.
   *     Format: `projects/{project}/locations/{location}/processors/{processor}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProcessorVersionsPagedResponse listProcessorVersions(ProcessorName parent) {
    ListProcessorVersionsRequest request =
        ListProcessorVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProcessorVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all versions of a processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String parent = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString();
   *   for (ProcessorVersion element :
   *       documentProcessorServiceClient.listProcessorVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project, location and processor) to list all versions.
   *     Format: `projects/{project}/locations/{location}/processors/{processor}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProcessorVersionsPagedResponse listProcessorVersions(String parent) {
    ListProcessorVersionsRequest request =
        ListProcessorVersionsRequest.newBuilder().setParent(parent).build();
    return listProcessorVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all versions of a processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ListProcessorVersionsRequest request =
   *       ListProcessorVersionsRequest.newBuilder()
   *           .setParent(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ProcessorVersion element :
   *       documentProcessorServiceClient.listProcessorVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProcessorVersionsPagedResponse listProcessorVersions(
      ListProcessorVersionsRequest request) {
    return listProcessorVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all versions of a processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ListProcessorVersionsRequest request =
   *       ListProcessorVersionsRequest.newBuilder()
   *           .setParent(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ProcessorVersion> future =
   *       documentProcessorServiceClient.listProcessorVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ProcessorVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProcessorVersionsRequest, ListProcessorVersionsPagedResponse>
      listProcessorVersionsPagedCallable() {
    return stub.listProcessorVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all versions of a processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ListProcessorVersionsRequest request =
   *       ListProcessorVersionsRequest.newBuilder()
   *           .setParent(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListProcessorVersionsResponse response =
   *         documentProcessorServiceClient.listProcessorVersionsCallable().call(request);
   *     for (ProcessorVersion element : response.getProcessorVersionsList()) {
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
  public final UnaryCallable<ListProcessorVersionsRequest, ListProcessorVersionsResponse>
      listProcessorVersionsCallable() {
    return stub.listProcessorVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the processor version, all artifacts under the processor version will be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ProcessorVersionName name =
   *       ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]");
   *   documentProcessorServiceClient.deleteProcessorVersionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The processor version resource name to be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteProcessorVersionMetadata> deleteProcessorVersionAsync(
      ProcessorVersionName name) {
    DeleteProcessorVersionRequest request =
        DeleteProcessorVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteProcessorVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the processor version, all artifacts under the processor version will be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String name =
   *       ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *           .toString();
   *   documentProcessorServiceClient.deleteProcessorVersionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The processor version resource name to be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteProcessorVersionMetadata> deleteProcessorVersionAsync(
      String name) {
    DeleteProcessorVersionRequest request =
        DeleteProcessorVersionRequest.newBuilder().setName(name).build();
    return deleteProcessorVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the processor version, all artifacts under the processor version will be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   DeleteProcessorVersionRequest request =
   *       DeleteProcessorVersionRequest.newBuilder()
   *           .setName(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .build();
   *   documentProcessorServiceClient.deleteProcessorVersionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteProcessorVersionMetadata> deleteProcessorVersionAsync(
      DeleteProcessorVersionRequest request) {
    return deleteProcessorVersionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the processor version, all artifacts under the processor version will be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   DeleteProcessorVersionRequest request =
   *       DeleteProcessorVersionRequest.newBuilder()
   *           .setName(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteProcessorVersionMetadata> future =
   *       documentProcessorServiceClient
   *           .deleteProcessorVersionOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteProcessorVersionRequest, Empty, DeleteProcessorVersionMetadata>
      deleteProcessorVersionOperationCallable() {
    return stub.deleteProcessorVersionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the processor version, all artifacts under the processor version will be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   DeleteProcessorVersionRequest request =
   *       DeleteProcessorVersionRequest.newBuilder()
   *           .setName(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       documentProcessorServiceClient.deleteProcessorVersionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteProcessorVersionRequest, Operation>
      deleteProcessorVersionCallable() {
    return stub.deleteProcessorVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys the processor version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ProcessorVersionName name =
   *       ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]");
   *   DeployProcessorVersionResponse response =
   *       documentProcessorServiceClient.deployProcessorVersionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The processor version resource name to be deployed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployProcessorVersionResponse, DeployProcessorVersionMetadata>
      deployProcessorVersionAsync(ProcessorVersionName name) {
    DeployProcessorVersionRequest request =
        DeployProcessorVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deployProcessorVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys the processor version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String name =
   *       ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *           .toString();
   *   DeployProcessorVersionResponse response =
   *       documentProcessorServiceClient.deployProcessorVersionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The processor version resource name to be deployed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployProcessorVersionResponse, DeployProcessorVersionMetadata>
      deployProcessorVersionAsync(String name) {
    DeployProcessorVersionRequest request =
        DeployProcessorVersionRequest.newBuilder().setName(name).build();
    return deployProcessorVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys the processor version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   DeployProcessorVersionRequest request =
   *       DeployProcessorVersionRequest.newBuilder()
   *           .setName(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .build();
   *   DeployProcessorVersionResponse response =
   *       documentProcessorServiceClient.deployProcessorVersionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployProcessorVersionResponse, DeployProcessorVersionMetadata>
      deployProcessorVersionAsync(DeployProcessorVersionRequest request) {
    return deployProcessorVersionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys the processor version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   DeployProcessorVersionRequest request =
   *       DeployProcessorVersionRequest.newBuilder()
   *           .setName(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<DeployProcessorVersionResponse, DeployProcessorVersionMetadata> future =
   *       documentProcessorServiceClient
   *           .deployProcessorVersionOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   DeployProcessorVersionResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeployProcessorVersionRequest,
          DeployProcessorVersionResponse,
          DeployProcessorVersionMetadata>
      deployProcessorVersionOperationCallable() {
    return stub.deployProcessorVersionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys the processor version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   DeployProcessorVersionRequest request =
   *       DeployProcessorVersionRequest.newBuilder()
   *           .setName(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       documentProcessorServiceClient.deployProcessorVersionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeployProcessorVersionRequest, Operation>
      deployProcessorVersionCallable() {
    return stub.deployProcessorVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys the processor version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ProcessorVersionName name =
   *       ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]");
   *   UndeployProcessorVersionResponse response =
   *       documentProcessorServiceClient.undeployProcessorVersionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The processor version resource name to be undeployed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployProcessorVersionResponse, UndeployProcessorVersionMetadata>
      undeployProcessorVersionAsync(ProcessorVersionName name) {
    UndeployProcessorVersionRequest request =
        UndeployProcessorVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return undeployProcessorVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys the processor version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String name =
   *       ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *           .toString();
   *   UndeployProcessorVersionResponse response =
   *       documentProcessorServiceClient.undeployProcessorVersionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The processor version resource name to be undeployed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployProcessorVersionResponse, UndeployProcessorVersionMetadata>
      undeployProcessorVersionAsync(String name) {
    UndeployProcessorVersionRequest request =
        UndeployProcessorVersionRequest.newBuilder().setName(name).build();
    return undeployProcessorVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys the processor version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   UndeployProcessorVersionRequest request =
   *       UndeployProcessorVersionRequest.newBuilder()
   *           .setName(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .build();
   *   UndeployProcessorVersionResponse response =
   *       documentProcessorServiceClient.undeployProcessorVersionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<UndeployProcessorVersionResponse, UndeployProcessorVersionMetadata>
      undeployProcessorVersionAsync(UndeployProcessorVersionRequest request) {
    return undeployProcessorVersionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys the processor version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   UndeployProcessorVersionRequest request =
   *       UndeployProcessorVersionRequest.newBuilder()
   *           .setName(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<UndeployProcessorVersionResponse, UndeployProcessorVersionMetadata> future =
   *       documentProcessorServiceClient
   *           .undeployProcessorVersionOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   UndeployProcessorVersionResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UndeployProcessorVersionRequest,
          UndeployProcessorVersionResponse,
          UndeployProcessorVersionMetadata>
      undeployProcessorVersionOperationCallable() {
    return stub.undeployProcessorVersionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Undeploys the processor version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   UndeployProcessorVersionRequest request =
   *       UndeployProcessorVersionRequest.newBuilder()
   *           .setName(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       documentProcessorServiceClient.undeployProcessorVersionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeployProcessorVersionRequest, Operation>
      undeployProcessorVersionCallable() {
    return stub.undeployProcessorVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a processor from the type processor that the user chose. The processor will be at
   * "ENABLED" state by default after its creation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Processor processor = Processor.newBuilder().build();
   *   Processor response = documentProcessorServiceClient.createProcessor(parent, processor);
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) under which to create the processor.
   *     Format: `projects/{project}/locations/{location}`
   * @param processor Required. The processor to be created, requires [processor_type] and
   *     [display_name] to be set. Also, the processor is under CMEK if CMEK fields are set.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Processor createProcessor(LocationName parent, Processor processor) {
    CreateProcessorRequest request =
        CreateProcessorRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setProcessor(processor)
            .build();
    return createProcessor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a processor from the type processor that the user chose. The processor will be at
   * "ENABLED" state by default after its creation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Processor processor = Processor.newBuilder().build();
   *   Processor response = documentProcessorServiceClient.createProcessor(parent, processor);
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) under which to create the processor.
   *     Format: `projects/{project}/locations/{location}`
   * @param processor Required. The processor to be created, requires [processor_type] and
   *     [display_name] to be set. Also, the processor is under CMEK if CMEK fields are set.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Processor createProcessor(String parent, Processor processor) {
    CreateProcessorRequest request =
        CreateProcessorRequest.newBuilder().setParent(parent).setProcessor(processor).build();
    return createProcessor(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a processor from the type processor that the user chose. The processor will be at
   * "ENABLED" state by default after its creation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   CreateProcessorRequest request =
   *       CreateProcessorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setProcessor(Processor.newBuilder().build())
   *           .build();
   *   Processor response = documentProcessorServiceClient.createProcessor(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Processor createProcessor(CreateProcessorRequest request) {
    return createProcessorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a processor from the type processor that the user chose. The processor will be at
   * "ENABLED" state by default after its creation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   CreateProcessorRequest request =
   *       CreateProcessorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setProcessor(Processor.newBuilder().build())
   *           .build();
   *   ApiFuture<Processor> future =
   *       documentProcessorServiceClient.createProcessorCallable().futureCall(request);
   *   // Do something.
   *   Processor response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateProcessorRequest, Processor> createProcessorCallable() {
    return stub.createProcessorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the processor, unloads all deployed model artifacts if it was enabled and then deletes
   * all artifacts associated with this processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   documentProcessorServiceClient.deleteProcessorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The processor resource name to be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteProcessorMetadata> deleteProcessorAsync(
      ProcessorName name) {
    DeleteProcessorRequest request =
        DeleteProcessorRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteProcessorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the processor, unloads all deployed model artifacts if it was enabled and then deletes
   * all artifacts associated with this processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString();
   *   documentProcessorServiceClient.deleteProcessorAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The processor resource name to be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteProcessorMetadata> deleteProcessorAsync(String name) {
    DeleteProcessorRequest request = DeleteProcessorRequest.newBuilder().setName(name).build();
    return deleteProcessorAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the processor, unloads all deployed model artifacts if it was enabled and then deletes
   * all artifacts associated with this processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   DeleteProcessorRequest request =
   *       DeleteProcessorRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .build();
   *   documentProcessorServiceClient.deleteProcessorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteProcessorMetadata> deleteProcessorAsync(
      DeleteProcessorRequest request) {
    return deleteProcessorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the processor, unloads all deployed model artifacts if it was enabled and then deletes
   * all artifacts associated with this processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   DeleteProcessorRequest request =
   *       DeleteProcessorRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteProcessorMetadata> future =
   *       documentProcessorServiceClient.deleteProcessorOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteProcessorRequest, Empty, DeleteProcessorMetadata>
      deleteProcessorOperationCallable() {
    return stub.deleteProcessorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the processor, unloads all deployed model artifacts if it was enabled and then deletes
   * all artifacts associated with this processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   DeleteProcessorRequest request =
   *       DeleteProcessorRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       documentProcessorServiceClient.deleteProcessorCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteProcessorRequest, Operation> deleteProcessorCallable() {
    return stub.deleteProcessorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a processor
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   EnableProcessorRequest request =
   *       EnableProcessorRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .build();
   *   EnableProcessorResponse response =
   *       documentProcessorServiceClient.enableProcessorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EnableProcessorResponse, EnableProcessorMetadata>
      enableProcessorAsync(EnableProcessorRequest request) {
    return enableProcessorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a processor
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   EnableProcessorRequest request =
   *       EnableProcessorRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .build();
   *   OperationFuture<EnableProcessorResponse, EnableProcessorMetadata> future =
   *       documentProcessorServiceClient.enableProcessorOperationCallable().futureCall(request);
   *   // Do something.
   *   EnableProcessorResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          EnableProcessorRequest, EnableProcessorResponse, EnableProcessorMetadata>
      enableProcessorOperationCallable() {
    return stub.enableProcessorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a processor
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   EnableProcessorRequest request =
   *       EnableProcessorRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       documentProcessorServiceClient.enableProcessorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EnableProcessorRequest, Operation> enableProcessorCallable() {
    return stub.enableProcessorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a processor
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   DisableProcessorRequest request =
   *       DisableProcessorRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .build();
   *   DisableProcessorResponse response =
   *       documentProcessorServiceClient.disableProcessorAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DisableProcessorResponse, DisableProcessorMetadata>
      disableProcessorAsync(DisableProcessorRequest request) {
    return disableProcessorOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a processor
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   DisableProcessorRequest request =
   *       DisableProcessorRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .build();
   *   OperationFuture<DisableProcessorResponse, DisableProcessorMetadata> future =
   *       documentProcessorServiceClient.disableProcessorOperationCallable().futureCall(request);
   *   // Do something.
   *   DisableProcessorResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DisableProcessorRequest, DisableProcessorResponse, DisableProcessorMetadata>
      disableProcessorOperationCallable() {
    return stub.disableProcessorOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a processor
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   DisableProcessorRequest request =
   *       DisableProcessorRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       documentProcessorServiceClient.disableProcessorCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DisableProcessorRequest, Operation> disableProcessorCallable() {
    return stub.disableProcessorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Set the default (active) version of a [Processor][google.cloud.documentai.v1beta3.Processor]
   * that will be used in
   * [ProcessDocument][google.cloud.documentai.v1beta3.DocumentProcessorService.ProcessDocument] and
   * [BatchProcessDocuments][google.cloud.documentai.v1beta3.DocumentProcessorService.BatchProcessDocuments].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   SetDefaultProcessorVersionRequest request =
   *       SetDefaultProcessorVersionRequest.newBuilder()
   *           .setProcessor(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setDefaultProcessorVersion(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .build();
   *   SetDefaultProcessorVersionResponse response =
   *       documentProcessorServiceClient.setDefaultProcessorVersionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          SetDefaultProcessorVersionResponse, SetDefaultProcessorVersionMetadata>
      setDefaultProcessorVersionAsync(SetDefaultProcessorVersionRequest request) {
    return setDefaultProcessorVersionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Set the default (active) version of a [Processor][google.cloud.documentai.v1beta3.Processor]
   * that will be used in
   * [ProcessDocument][google.cloud.documentai.v1beta3.DocumentProcessorService.ProcessDocument] and
   * [BatchProcessDocuments][google.cloud.documentai.v1beta3.DocumentProcessorService.BatchProcessDocuments].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   SetDefaultProcessorVersionRequest request =
   *       SetDefaultProcessorVersionRequest.newBuilder()
   *           .setProcessor(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setDefaultProcessorVersion(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<SetDefaultProcessorVersionResponse, SetDefaultProcessorVersionMetadata>
   *       future =
   *           documentProcessorServiceClient
   *               .setDefaultProcessorVersionOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   SetDefaultProcessorVersionResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          SetDefaultProcessorVersionRequest,
          SetDefaultProcessorVersionResponse,
          SetDefaultProcessorVersionMetadata>
      setDefaultProcessorVersionOperationCallable() {
    return stub.setDefaultProcessorVersionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Set the default (active) version of a [Processor][google.cloud.documentai.v1beta3.Processor]
   * that will be used in
   * [ProcessDocument][google.cloud.documentai.v1beta3.DocumentProcessorService.ProcessDocument] and
   * [BatchProcessDocuments][google.cloud.documentai.v1beta3.DocumentProcessorService.BatchProcessDocuments].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   SetDefaultProcessorVersionRequest request =
   *       SetDefaultProcessorVersionRequest.newBuilder()
   *           .setProcessor(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setDefaultProcessorVersion(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       documentProcessorServiceClient.setDefaultProcessorVersionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetDefaultProcessorVersionRequest, Operation>
      setDefaultProcessorVersionCallable() {
    return stub.setDefaultProcessorVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Send a document for Human Review. The input document should be processed by the specified
   * processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   HumanReviewConfigName humanReviewConfig =
   *       HumanReviewConfigName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   ReviewDocumentResponse response =
   *       documentProcessorServiceClient.reviewDocumentAsync(humanReviewConfig).get();
   * }
   * }</pre>
   *
   * @param humanReviewConfig Required. The resource name of the HumanReviewConfig that the document
   *     will be reviewed with.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentAsync(HumanReviewConfigName humanReviewConfig) {
    ReviewDocumentRequest request =
        ReviewDocumentRequest.newBuilder()
            .setHumanReviewConfig(humanReviewConfig == null ? null : humanReviewConfig.toString())
            .build();
    return reviewDocumentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Send a document for Human Review. The input document should be processed by the specified
   * processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String humanReviewConfig =
   *       HumanReviewConfigName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString();
   *   ReviewDocumentResponse response =
   *       documentProcessorServiceClient.reviewDocumentAsync(humanReviewConfig).get();
   * }
   * }</pre>
   *
   * @param humanReviewConfig Required. The resource name of the HumanReviewConfig that the document
   *     will be reviewed with.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentAsync(String humanReviewConfig) {
    ReviewDocumentRequest request =
        ReviewDocumentRequest.newBuilder().setHumanReviewConfig(humanReviewConfig).build();
    return reviewDocumentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Send a document for Human Review. The input document should be processed by the specified
   * processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ReviewDocumentRequest request =
   *       ReviewDocumentRequest.newBuilder()
   *           .setHumanReviewConfig(
   *               HumanReviewConfigName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setDocument(Document.newBuilder().build())
   *           .setEnableSchemaValidation(true)
   *           .setDocumentSchema(DocumentSchema.newBuilder().build())
   *           .build();
   *   ReviewDocumentResponse response =
   *       documentProcessorServiceClient.reviewDocumentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentAsync(ReviewDocumentRequest request) {
    return reviewDocumentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Send a document for Human Review. The input document should be processed by the specified
   * processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ReviewDocumentRequest request =
   *       ReviewDocumentRequest.newBuilder()
   *           .setHumanReviewConfig(
   *               HumanReviewConfigName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setDocument(Document.newBuilder().build())
   *           .setEnableSchemaValidation(true)
   *           .setDocumentSchema(DocumentSchema.newBuilder().build())
   *           .build();
   *   OperationFuture<ReviewDocumentResponse, ReviewDocumentOperationMetadata> future =
   *       documentProcessorServiceClient.reviewDocumentOperationCallable().futureCall(request);
   *   // Do something.
   *   ReviewDocumentResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentOperationCallable() {
    return stub.reviewDocumentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Send a document for Human Review. The input document should be processed by the specified
   * processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ReviewDocumentRequest request =
   *       ReviewDocumentRequest.newBuilder()
   *           .setHumanReviewConfig(
   *               HumanReviewConfigName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setDocument(Document.newBuilder().build())
   *           .setEnableSchemaValidation(true)
   *           .setDocumentSchema(DocumentSchema.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       documentProcessorServiceClient.reviewDocumentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReviewDocumentRequest, Operation> reviewDocumentCallable() {
    return stub.reviewDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Evaluates a ProcessorVersion against annotated documents, producing an Evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ProcessorVersionName processorVersion =
   *       ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]");
   *   EvaluateProcessorVersionResponse response =
   *       documentProcessorServiceClient.evaluateProcessorVersionAsync(processorVersion).get();
   * }
   * }</pre>
   *
   * @param processorVersion Required. The resource name of the
   *     [ProcessorVersion][google.cloud.documentai.v1beta3.ProcessorVersion] to evaluate.
   *     `projects/{project}/locations/{location}/processors/{processor}/processorVersions/{processorVersion}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EvaluateProcessorVersionResponse, EvaluateProcessorVersionMetadata>
      evaluateProcessorVersionAsync(ProcessorVersionName processorVersion) {
    EvaluateProcessorVersionRequest request =
        EvaluateProcessorVersionRequest.newBuilder()
            .setProcessorVersion(processorVersion == null ? null : processorVersion.toString())
            .build();
    return evaluateProcessorVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Evaluates a ProcessorVersion against annotated documents, producing an Evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String processorVersion =
   *       ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *           .toString();
   *   EvaluateProcessorVersionResponse response =
   *       documentProcessorServiceClient.evaluateProcessorVersionAsync(processorVersion).get();
   * }
   * }</pre>
   *
   * @param processorVersion Required. The resource name of the
   *     [ProcessorVersion][google.cloud.documentai.v1beta3.ProcessorVersion] to evaluate.
   *     `projects/{project}/locations/{location}/processors/{processor}/processorVersions/{processorVersion}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EvaluateProcessorVersionResponse, EvaluateProcessorVersionMetadata>
      evaluateProcessorVersionAsync(String processorVersion) {
    EvaluateProcessorVersionRequest request =
        EvaluateProcessorVersionRequest.newBuilder().setProcessorVersion(processorVersion).build();
    return evaluateProcessorVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Evaluates a ProcessorVersion against annotated documents, producing an Evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   EvaluateProcessorVersionRequest request =
   *       EvaluateProcessorVersionRequest.newBuilder()
   *           .setProcessorVersion(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .setEvaluationDocuments(BatchDocumentsInputConfig.newBuilder().build())
   *           .build();
   *   EvaluateProcessorVersionResponse response =
   *       documentProcessorServiceClient.evaluateProcessorVersionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EvaluateProcessorVersionResponse, EvaluateProcessorVersionMetadata>
      evaluateProcessorVersionAsync(EvaluateProcessorVersionRequest request) {
    return evaluateProcessorVersionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Evaluates a ProcessorVersion against annotated documents, producing an Evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   EvaluateProcessorVersionRequest request =
   *       EvaluateProcessorVersionRequest.newBuilder()
   *           .setProcessorVersion(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .setEvaluationDocuments(BatchDocumentsInputConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<EvaluateProcessorVersionResponse, EvaluateProcessorVersionMetadata> future =
   *       documentProcessorServiceClient
   *           .evaluateProcessorVersionOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   EvaluateProcessorVersionResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          EvaluateProcessorVersionRequest,
          EvaluateProcessorVersionResponse,
          EvaluateProcessorVersionMetadata>
      evaluateProcessorVersionOperationCallable() {
    return stub.evaluateProcessorVersionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Evaluates a ProcessorVersion against annotated documents, producing an Evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   EvaluateProcessorVersionRequest request =
   *       EvaluateProcessorVersionRequest.newBuilder()
   *           .setProcessorVersion(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .setEvaluationDocuments(BatchDocumentsInputConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       documentProcessorServiceClient.evaluateProcessorVersionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EvaluateProcessorVersionRequest, Operation>
      evaluateProcessorVersionCallable() {
    return stub.evaluateProcessorVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   EvaluationName name =
   *       EvaluationName.of(
   *           "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]", "[EVALUATION]");
   *   Evaluation response = documentProcessorServiceClient.getEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [Evaluation][google.cloud.documentai.v1beta3.Evaluation] to get.
   *     `projects/{project}/locations/{location}/processors/{processor}/processorVersions/{processorVersion}/evaluations/{evaluation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation getEvaluation(EvaluationName name) {
    GetEvaluationRequest request =
        GetEvaluationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String name =
   *       EvaluationName.of(
   *               "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]", "[EVALUATION]")
   *           .toString();
   *   Evaluation response = documentProcessorServiceClient.getEvaluation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [Evaluation][google.cloud.documentai.v1beta3.Evaluation] to get.
   *     `projects/{project}/locations/{location}/processors/{processor}/processorVersions/{processorVersion}/evaluations/{evaluation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation getEvaluation(String name) {
    GetEvaluationRequest request = GetEvaluationRequest.newBuilder().setName(name).build();
    return getEvaluation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   GetEvaluationRequest request =
   *       GetEvaluationRequest.newBuilder()
   *           .setName(
   *               EvaluationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[PROCESSOR]",
   *                       "[PROCESSOR_VERSION]",
   *                       "[EVALUATION]")
   *                   .toString())
   *           .build();
   *   Evaluation response = documentProcessorServiceClient.getEvaluation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Evaluation getEvaluation(GetEvaluationRequest request) {
    return getEvaluationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a specific evaluation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   GetEvaluationRequest request =
   *       GetEvaluationRequest.newBuilder()
   *           .setName(
   *               EvaluationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[PROCESSOR]",
   *                       "[PROCESSOR_VERSION]",
   *                       "[EVALUATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Evaluation> future =
   *       documentProcessorServiceClient.getEvaluationCallable().futureCall(request);
   *   // Do something.
   *   Evaluation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable() {
    return stub.getEvaluationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a set of evaluations for a given processor version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ProcessorVersionName parent =
   *       ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]");
   *   for (Evaluation element :
   *       documentProcessorServiceClient.listEvaluations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the
   *     [ProcessorVersion][google.cloud.documentai.v1beta3.ProcessorVersion] to list evaluations
   *     for.
   *     `projects/{project}/locations/{location}/processors/{processor}/processorVersions/{processorVersion}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationsPagedResponse listEvaluations(ProcessorVersionName parent) {
    ListEvaluationsRequest request =
        ListEvaluationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEvaluations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a set of evaluations for a given processor version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String parent =
   *       ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *           .toString();
   *   for (Evaluation element :
   *       documentProcessorServiceClient.listEvaluations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the
   *     [ProcessorVersion][google.cloud.documentai.v1beta3.ProcessorVersion] to list evaluations
   *     for.
   *     `projects/{project}/locations/{location}/processors/{processor}/processorVersions/{processorVersion}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationsPagedResponse listEvaluations(String parent) {
    ListEvaluationsRequest request = ListEvaluationsRequest.newBuilder().setParent(parent).build();
    return listEvaluations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a set of evaluations for a given processor version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ListEvaluationsRequest request =
   *       ListEvaluationsRequest.newBuilder()
   *           .setParent(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Evaluation element :
   *       documentProcessorServiceClient.listEvaluations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEvaluationsPagedResponse listEvaluations(ListEvaluationsRequest request) {
    return listEvaluationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a set of evaluations for a given processor version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ListEvaluationsRequest request =
   *       ListEvaluationsRequest.newBuilder()
   *           .setParent(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Evaluation> future =
   *       documentProcessorServiceClient.listEvaluationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Evaluation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEvaluationsRequest, ListEvaluationsPagedResponse>
      listEvaluationsPagedCallable() {
    return stub.listEvaluationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a set of evaluations for a given processor version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ListEvaluationsRequest request =
   *       ListEvaluationsRequest.newBuilder()
   *           .setParent(
   *               ProcessorVersionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListEvaluationsResponse response =
   *         documentProcessorServiceClient.listEvaluationsCallable().call(request);
   *     for (Evaluation element : response.getEvaluationsList()) {
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
  public final UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse>
      listEvaluationsCallable() {
    return stub.listEvaluationsCallable();
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : documentProcessorServiceClient.listLocations(request).iterateAll()) {
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       documentProcessorServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         documentProcessorServiceClient.listLocationsCallable().call(request);
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = documentProcessorServiceClient.getLocation(request);
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       documentProcessorServiceClient.getLocationCallable().futureCall(request);
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

  public static class ListProcessorTypesPagedResponse
      extends AbstractPagedListResponse<
          ListProcessorTypesRequest,
          ListProcessorTypesResponse,
          ProcessorType,
          ListProcessorTypesPage,
          ListProcessorTypesFixedSizeCollection> {

    public static ApiFuture<ListProcessorTypesPagedResponse> createAsync(
        PageContext<ListProcessorTypesRequest, ListProcessorTypesResponse, ProcessorType> context,
        ApiFuture<ListProcessorTypesResponse> futureResponse) {
      ApiFuture<ListProcessorTypesPage> futurePage =
          ListProcessorTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListProcessorTypesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListProcessorTypesPagedResponse(ListProcessorTypesPage page) {
      super(page, ListProcessorTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProcessorTypesPage
      extends AbstractPage<
          ListProcessorTypesRequest,
          ListProcessorTypesResponse,
          ProcessorType,
          ListProcessorTypesPage> {

    private ListProcessorTypesPage(
        PageContext<ListProcessorTypesRequest, ListProcessorTypesResponse, ProcessorType> context,
        ListProcessorTypesResponse response) {
      super(context, response);
    }

    private static ListProcessorTypesPage createEmptyPage() {
      return new ListProcessorTypesPage(null, null);
    }

    @Override
    protected ListProcessorTypesPage createPage(
        PageContext<ListProcessorTypesRequest, ListProcessorTypesResponse, ProcessorType> context,
        ListProcessorTypesResponse response) {
      return new ListProcessorTypesPage(context, response);
    }

    @Override
    public ApiFuture<ListProcessorTypesPage> createPageAsync(
        PageContext<ListProcessorTypesRequest, ListProcessorTypesResponse, ProcessorType> context,
        ApiFuture<ListProcessorTypesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProcessorTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProcessorTypesRequest,
          ListProcessorTypesResponse,
          ProcessorType,
          ListProcessorTypesPage,
          ListProcessorTypesFixedSizeCollection> {

    private ListProcessorTypesFixedSizeCollection(
        List<ListProcessorTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProcessorTypesFixedSizeCollection createEmptyCollection() {
      return new ListProcessorTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProcessorTypesFixedSizeCollection createCollection(
        List<ListProcessorTypesPage> pages, int collectionSize) {
      return new ListProcessorTypesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListProcessorsPagedResponse
      extends AbstractPagedListResponse<
          ListProcessorsRequest,
          ListProcessorsResponse,
          Processor,
          ListProcessorsPage,
          ListProcessorsFixedSizeCollection> {

    public static ApiFuture<ListProcessorsPagedResponse> createAsync(
        PageContext<ListProcessorsRequest, ListProcessorsResponse, Processor> context,
        ApiFuture<ListProcessorsResponse> futureResponse) {
      ApiFuture<ListProcessorsPage> futurePage =
          ListProcessorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListProcessorsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListProcessorsPagedResponse(ListProcessorsPage page) {
      super(page, ListProcessorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProcessorsPage
      extends AbstractPage<
          ListProcessorsRequest, ListProcessorsResponse, Processor, ListProcessorsPage> {

    private ListProcessorsPage(
        PageContext<ListProcessorsRequest, ListProcessorsResponse, Processor> context,
        ListProcessorsResponse response) {
      super(context, response);
    }

    private static ListProcessorsPage createEmptyPage() {
      return new ListProcessorsPage(null, null);
    }

    @Override
    protected ListProcessorsPage createPage(
        PageContext<ListProcessorsRequest, ListProcessorsResponse, Processor> context,
        ListProcessorsResponse response) {
      return new ListProcessorsPage(context, response);
    }

    @Override
    public ApiFuture<ListProcessorsPage> createPageAsync(
        PageContext<ListProcessorsRequest, ListProcessorsResponse, Processor> context,
        ApiFuture<ListProcessorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProcessorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProcessorsRequest,
          ListProcessorsResponse,
          Processor,
          ListProcessorsPage,
          ListProcessorsFixedSizeCollection> {

    private ListProcessorsFixedSizeCollection(List<ListProcessorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProcessorsFixedSizeCollection createEmptyCollection() {
      return new ListProcessorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProcessorsFixedSizeCollection createCollection(
        List<ListProcessorsPage> pages, int collectionSize) {
      return new ListProcessorsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListProcessorVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListProcessorVersionsRequest,
          ListProcessorVersionsResponse,
          ProcessorVersion,
          ListProcessorVersionsPage,
          ListProcessorVersionsFixedSizeCollection> {

    public static ApiFuture<ListProcessorVersionsPagedResponse> createAsync(
        PageContext<ListProcessorVersionsRequest, ListProcessorVersionsResponse, ProcessorVersion>
            context,
        ApiFuture<ListProcessorVersionsResponse> futureResponse) {
      ApiFuture<ListProcessorVersionsPage> futurePage =
          ListProcessorVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListProcessorVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListProcessorVersionsPagedResponse(ListProcessorVersionsPage page) {
      super(page, ListProcessorVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProcessorVersionsPage
      extends AbstractPage<
          ListProcessorVersionsRequest,
          ListProcessorVersionsResponse,
          ProcessorVersion,
          ListProcessorVersionsPage> {

    private ListProcessorVersionsPage(
        PageContext<ListProcessorVersionsRequest, ListProcessorVersionsResponse, ProcessorVersion>
            context,
        ListProcessorVersionsResponse response) {
      super(context, response);
    }

    private static ListProcessorVersionsPage createEmptyPage() {
      return new ListProcessorVersionsPage(null, null);
    }

    @Override
    protected ListProcessorVersionsPage createPage(
        PageContext<ListProcessorVersionsRequest, ListProcessorVersionsResponse, ProcessorVersion>
            context,
        ListProcessorVersionsResponse response) {
      return new ListProcessorVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListProcessorVersionsPage> createPageAsync(
        PageContext<ListProcessorVersionsRequest, ListProcessorVersionsResponse, ProcessorVersion>
            context,
        ApiFuture<ListProcessorVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProcessorVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProcessorVersionsRequest,
          ListProcessorVersionsResponse,
          ProcessorVersion,
          ListProcessorVersionsPage,
          ListProcessorVersionsFixedSizeCollection> {

    private ListProcessorVersionsFixedSizeCollection(
        List<ListProcessorVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProcessorVersionsFixedSizeCollection createEmptyCollection() {
      return new ListProcessorVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProcessorVersionsFixedSizeCollection createCollection(
        List<ListProcessorVersionsPage> pages, int collectionSize) {
      return new ListProcessorVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEvaluationsPagedResponse
      extends AbstractPagedListResponse<
          ListEvaluationsRequest,
          ListEvaluationsResponse,
          Evaluation,
          ListEvaluationsPage,
          ListEvaluationsFixedSizeCollection> {

    public static ApiFuture<ListEvaluationsPagedResponse> createAsync(
        PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> context,
        ApiFuture<ListEvaluationsResponse> futureResponse) {
      ApiFuture<ListEvaluationsPage> futurePage =
          ListEvaluationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEvaluationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEvaluationsPagedResponse(ListEvaluationsPage page) {
      super(page, ListEvaluationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEvaluationsPage
      extends AbstractPage<
          ListEvaluationsRequest, ListEvaluationsResponse, Evaluation, ListEvaluationsPage> {

    private ListEvaluationsPage(
        PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> context,
        ListEvaluationsResponse response) {
      super(context, response);
    }

    private static ListEvaluationsPage createEmptyPage() {
      return new ListEvaluationsPage(null, null);
    }

    @Override
    protected ListEvaluationsPage createPage(
        PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> context,
        ListEvaluationsResponse response) {
      return new ListEvaluationsPage(context, response);
    }

    @Override
    public ApiFuture<ListEvaluationsPage> createPageAsync(
        PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> context,
        ApiFuture<ListEvaluationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEvaluationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEvaluationsRequest,
          ListEvaluationsResponse,
          Evaluation,
          ListEvaluationsPage,
          ListEvaluationsFixedSizeCollection> {

    private ListEvaluationsFixedSizeCollection(
        List<ListEvaluationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEvaluationsFixedSizeCollection createEmptyCollection() {
      return new ListEvaluationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEvaluationsFixedSizeCollection createCollection(
        List<ListEvaluationsPage> pages, int collectionSize) {
      return new ListEvaluationsFixedSizeCollection(pages, collectionSize);
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
