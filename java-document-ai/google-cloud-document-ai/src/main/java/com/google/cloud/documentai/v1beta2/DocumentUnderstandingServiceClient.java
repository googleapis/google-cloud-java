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

package com.google.cloud.documentai.v1beta2;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.documentai.v1beta2.stub.DocumentUnderstandingServiceStub;
import com.google.cloud.documentai.v1beta2.stub.DocumentUnderstandingServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to parse structured information from unstructured or semi-structured
 * documents using state-of-the-art Google AI such as natural language, computer vision, and
 * translation.
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
 * try (DocumentUnderstandingServiceClient documentUnderstandingServiceClient =
 *     DocumentUnderstandingServiceClient.create()) {
 *   ProcessDocumentRequest request =
 *       ProcessDocumentRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setInputConfig(InputConfig.newBuilder().build())
 *           .setOutputConfig(OutputConfig.newBuilder().build())
 *           .setDocumentType("documentType-1473196299")
 *           .setTableExtractionParams(TableExtractionParams.newBuilder().build())
 *           .setFormExtractionParams(FormExtractionParams.newBuilder().build())
 *           .setEntityExtractionParams(EntityExtractionParams.newBuilder().build())
 *           .setOcrParams(OcrParams.newBuilder().build())
 *           .setAutomlParams(AutoMlParams.newBuilder().build())
 *           .build();
 *   Document response = documentUnderstandingServiceClient.processDocument(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DocumentUnderstandingServiceClient object to clean up
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
 * DocumentUnderstandingServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DocumentUnderstandingServiceSettings documentUnderstandingServiceSettings =
 *     DocumentUnderstandingServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DocumentUnderstandingServiceClient documentUnderstandingServiceClient =
 *     DocumentUnderstandingServiceClient.create(documentUnderstandingServiceSettings);
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
 * DocumentUnderstandingServiceSettings documentUnderstandingServiceSettings =
 *     DocumentUnderstandingServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DocumentUnderstandingServiceClient documentUnderstandingServiceClient =
 *     DocumentUnderstandingServiceClient.create(documentUnderstandingServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DocumentUnderstandingServiceClient implements BackgroundResource {
  private final DocumentUnderstandingServiceSettings settings;
  private final DocumentUnderstandingServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of DocumentUnderstandingServiceClient with default settings. */
  public static final DocumentUnderstandingServiceClient create() throws IOException {
    return create(DocumentUnderstandingServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DocumentUnderstandingServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final DocumentUnderstandingServiceClient create(
      DocumentUnderstandingServiceSettings settings) throws IOException {
    return new DocumentUnderstandingServiceClient(settings);
  }

  /**
   * Constructs an instance of DocumentUnderstandingServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(DocumentUnderstandingServiceSettings).
   */
  public static final DocumentUnderstandingServiceClient create(
      DocumentUnderstandingServiceStub stub) {
    return new DocumentUnderstandingServiceClient(stub);
  }

  /**
   * Constructs an instance of DocumentUnderstandingServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DocumentUnderstandingServiceClient(DocumentUnderstandingServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((DocumentUnderstandingServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected DocumentUnderstandingServiceClient(DocumentUnderstandingServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final DocumentUnderstandingServiceSettings getSettings() {
    return settings;
  }

  public DocumentUnderstandingServiceStub getStub() {
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
   * try (DocumentUnderstandingServiceClient documentUnderstandingServiceClient =
   *     DocumentUnderstandingServiceClient.create()) {
   *   List<ProcessDocumentRequest> requests = new ArrayList<>();
   *   BatchProcessDocumentsResponse response =
   *       documentUnderstandingServiceClient.batchProcessDocumentsAsync(requests).get();
   * }
   * }</pre>
   *
   * @param requests Required. Individual requests for each document.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchProcessDocumentsResponse, OperationMetadata>
      batchProcessDocumentsAsync(List<ProcessDocumentRequest> requests) {
    BatchProcessDocumentsRequest request =
        BatchProcessDocumentsRequest.newBuilder().addAllRequests(requests).build();
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
   * try (DocumentUnderstandingServiceClient documentUnderstandingServiceClient =
   *     DocumentUnderstandingServiceClient.create()) {
   *   BatchProcessDocumentsRequest request =
   *       BatchProcessDocumentsRequest.newBuilder()
   *           .addAllRequests(new ArrayList<ProcessDocumentRequest>())
   *           .setParent("parent-995424086")
   *           .build();
   *   BatchProcessDocumentsResponse response =
   *       documentUnderstandingServiceClient.batchProcessDocumentsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchProcessDocumentsResponse, OperationMetadata>
      batchProcessDocumentsAsync(BatchProcessDocumentsRequest request) {
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
   * try (DocumentUnderstandingServiceClient documentUnderstandingServiceClient =
   *     DocumentUnderstandingServiceClient.create()) {
   *   BatchProcessDocumentsRequest request =
   *       BatchProcessDocumentsRequest.newBuilder()
   *           .addAllRequests(new ArrayList<ProcessDocumentRequest>())
   *           .setParent("parent-995424086")
   *           .build();
   *   OperationFuture<BatchProcessDocumentsResponse, OperationMetadata> future =
   *       documentUnderstandingServiceClient
   *           .batchProcessDocumentsOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchProcessDocumentsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchProcessDocumentsRequest, BatchProcessDocumentsResponse, OperationMetadata>
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
   * try (DocumentUnderstandingServiceClient documentUnderstandingServiceClient =
   *     DocumentUnderstandingServiceClient.create()) {
   *   BatchProcessDocumentsRequest request =
   *       BatchProcessDocumentsRequest.newBuilder()
   *           .addAllRequests(new ArrayList<ProcessDocumentRequest>())
   *           .setParent("parent-995424086")
   *           .build();
   *   ApiFuture<Operation> future =
   *       documentUnderstandingServiceClient.batchProcessDocumentsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchProcessDocumentsRequest, Operation>
      batchProcessDocumentsCallable() {
    return stub.batchProcessDocumentsCallable();
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
   * try (DocumentUnderstandingServiceClient documentUnderstandingServiceClient =
   *     DocumentUnderstandingServiceClient.create()) {
   *   ProcessDocumentRequest request =
   *       ProcessDocumentRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setInputConfig(InputConfig.newBuilder().build())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .setDocumentType("documentType-1473196299")
   *           .setTableExtractionParams(TableExtractionParams.newBuilder().build())
   *           .setFormExtractionParams(FormExtractionParams.newBuilder().build())
   *           .setEntityExtractionParams(EntityExtractionParams.newBuilder().build())
   *           .setOcrParams(OcrParams.newBuilder().build())
   *           .setAutomlParams(AutoMlParams.newBuilder().build())
   *           .build();
   *   Document response = documentUnderstandingServiceClient.processDocument(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document processDocument(ProcessDocumentRequest request) {
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
   * try (DocumentUnderstandingServiceClient documentUnderstandingServiceClient =
   *     DocumentUnderstandingServiceClient.create()) {
   *   ProcessDocumentRequest request =
   *       ProcessDocumentRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setInputConfig(InputConfig.newBuilder().build())
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .setDocumentType("documentType-1473196299")
   *           .setTableExtractionParams(TableExtractionParams.newBuilder().build())
   *           .setFormExtractionParams(FormExtractionParams.newBuilder().build())
   *           .setEntityExtractionParams(EntityExtractionParams.newBuilder().build())
   *           .setOcrParams(OcrParams.newBuilder().build())
   *           .setAutomlParams(AutoMlParams.newBuilder().build())
   *           .build();
   *   ApiFuture<Document> future =
   *       documentUnderstandingServiceClient.processDocumentCallable().futureCall(request);
   *   // Do something.
   *   Document response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ProcessDocumentRequest, Document> processDocumentCallable() {
    return stub.processDocumentCallable();
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
}
