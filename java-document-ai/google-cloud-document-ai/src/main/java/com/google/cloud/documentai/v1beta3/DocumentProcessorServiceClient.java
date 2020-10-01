/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.documentai.v1beta3;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.documentai.v1beta3.stub.DocumentProcessorServiceStub;
import com.google.cloud.documentai.v1beta3.stub.DocumentProcessorServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service to call Cloud DocumentAI to process documents according to the
 * processor's definition. Processors are built using state-of-the-art Google AI such as natural
 * language, computer vision, and translation to extract structured information from unstructured or
 * semi-structured documents.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (DocumentProcessorServiceClient documentProcessorServiceClient = DocumentProcessorServiceClient.create()) {
 *   ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
 *   ProcessResponse response = documentProcessorServiceClient.processDocument(name);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the documentProcessorServiceClient object to clean up
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
 * <pre>
 * <code>
 * DocumentProcessorServiceSettings documentProcessorServiceSettings =
 *     DocumentProcessorServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DocumentProcessorServiceClient documentProcessorServiceClient =
 *     DocumentProcessorServiceClient.create(documentProcessorServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * DocumentProcessorServiceSettings documentProcessorServiceSettings =
 *     DocumentProcessorServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DocumentProcessorServiceClient documentProcessorServiceClient =
 *     DocumentProcessorServiceClient.create(documentProcessorServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class DocumentProcessorServiceClient implements BackgroundResource {
  private final DocumentProcessorServiceSettings settings;
  private final DocumentProcessorServiceStub stub;
  private final OperationsClient operationsClient;

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
   * calls. This is for advanced usage - prefer to use DocumentProcessorServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected DocumentProcessorServiceClient(DocumentProcessorServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final DocumentProcessorServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DocumentProcessorServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Processes a single document.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DocumentProcessorServiceClient documentProcessorServiceClient = DocumentProcessorServiceClient.create()) {
   *   ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   ProcessResponse response = documentProcessorServiceClient.processDocument(name);
   * }
   * </code></pre>
   *
   * @param name Required. The processor resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProcessResponse processDocument(ProcessorName name) {
    ProcessRequest request =
        ProcessRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return processDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Processes a single document.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DocumentProcessorServiceClient documentProcessorServiceClient = DocumentProcessorServiceClient.create()) {
   *   ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   ProcessResponse response = documentProcessorServiceClient.processDocument(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. The processor resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProcessResponse processDocument(String name) {
    ProcessRequest request = ProcessRequest.newBuilder().setName(name).build();
    return processDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Processes a single document.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DocumentProcessorServiceClient documentProcessorServiceClient = DocumentProcessorServiceClient.create()) {
   *   ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   ProcessRequest request = ProcessRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ProcessResponse response = documentProcessorServiceClient.processDocument(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProcessResponse processDocument(ProcessRequest request) {
    return processDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Processes a single document.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DocumentProcessorServiceClient documentProcessorServiceClient = DocumentProcessorServiceClient.create()) {
   *   ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   ProcessRequest request = ProcessRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;ProcessResponse&gt; future = documentProcessorServiceClient.processDocumentCallable().futureCall(request);
   *   // Do something
   *   ProcessResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ProcessRequest, ProcessResponse> processDocumentCallable() {
    return stub.processDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * LRO endpoint to batch process many documents. The output is written to Cloud Storage as JSON in
   * the [Document] format.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DocumentProcessorServiceClient documentProcessorServiceClient = DocumentProcessorServiceClient.create()) {
   *   ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   BatchProcessResponse response = documentProcessorServiceClient.batchProcessDocumentsAsync(name).get();
   * }
   * </code></pre>
   *
   * @param name Required. The processor resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsAsync(ProcessorName name) {
    BatchProcessRequest request =
        BatchProcessRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return batchProcessDocumentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * LRO endpoint to batch process many documents. The output is written to Cloud Storage as JSON in
   * the [Document] format.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DocumentProcessorServiceClient documentProcessorServiceClient = DocumentProcessorServiceClient.create()) {
   *   ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   BatchProcessResponse response = documentProcessorServiceClient.batchProcessDocumentsAsync(name.toString()).get();
   * }
   * </code></pre>
   *
   * @param name Required. The processor resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsAsync(String name) {
    BatchProcessRequest request = BatchProcessRequest.newBuilder().setName(name).build();
    return batchProcessDocumentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * LRO endpoint to batch process many documents. The output is written to Cloud Storage as JSON in
   * the [Document] format.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DocumentProcessorServiceClient documentProcessorServiceClient = DocumentProcessorServiceClient.create()) {
   *   ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   BatchProcessRequest request = BatchProcessRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   BatchProcessResponse response = documentProcessorServiceClient.batchProcessDocumentsAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsAsync(BatchProcessRequest request) {
    return batchProcessDocumentsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * LRO endpoint to batch process many documents. The output is written to Cloud Storage as JSON in
   * the [Document] format.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DocumentProcessorServiceClient documentProcessorServiceClient = DocumentProcessorServiceClient.create()) {
   *   ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   BatchProcessRequest request = BatchProcessRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   OperationFuture&lt;BatchProcessResponse, BatchProcessMetadata&gt; future = documentProcessorServiceClient.batchProcessDocumentsOperationCallable().futureCall(request);
   *   // Do something
   *   BatchProcessResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsOperationCallable() {
    return stub.batchProcessDocumentsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * LRO endpoint to batch process many documents. The output is written to Cloud Storage as JSON in
   * the [Document] format.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DocumentProcessorServiceClient documentProcessorServiceClient = DocumentProcessorServiceClient.create()) {
   *   ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   BatchProcessRequest request = BatchProcessRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = documentProcessorServiceClient.batchProcessDocumentsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchProcessRequest, Operation> batchProcessDocumentsCallable() {
    return stub.batchProcessDocumentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Send a document for Human Review. The input document should be processed by the specified
   * processor.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DocumentProcessorServiceClient documentProcessorServiceClient = DocumentProcessorServiceClient.create()) {
   *   HumanReviewConfigName humanReviewConfig = HumanReviewConfigName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   ReviewDocumentResponse response = documentProcessorServiceClient.reviewDocumentAsync(humanReviewConfig).get();
   * }
   * </code></pre>
   *
   * @param humanReviewConfig Required. The resource name of the HumanReviewConfig that the document
   *     will be reviewed with.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentAsync(HumanReviewConfigName humanReviewConfig) {
    ReviewDocumentRequest request =
        ReviewDocumentRequest.newBuilder()
            .setHumanReviewConfig(humanReviewConfig == null ? null : humanReviewConfig.toString())
            .build();
    return reviewDocumentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Send a document for Human Review. The input document should be processed by the specified
   * processor.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DocumentProcessorServiceClient documentProcessorServiceClient = DocumentProcessorServiceClient.create()) {
   *   HumanReviewConfigName humanReviewConfig = HumanReviewConfigName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   ReviewDocumentResponse response = documentProcessorServiceClient.reviewDocumentAsync(humanReviewConfig.toString()).get();
   * }
   * </code></pre>
   *
   * @param humanReviewConfig Required. The resource name of the HumanReviewConfig that the document
   *     will be reviewed with.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentAsync(String humanReviewConfig) {
    ReviewDocumentRequest request =
        ReviewDocumentRequest.newBuilder().setHumanReviewConfig(humanReviewConfig).build();
    return reviewDocumentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Send a document for Human Review. The input document should be processed by the specified
   * processor.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DocumentProcessorServiceClient documentProcessorServiceClient = DocumentProcessorServiceClient.create()) {
   *   HumanReviewConfigName humanReviewConfig = HumanReviewConfigName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   ReviewDocumentRequest request = ReviewDocumentRequest.newBuilder()
   *     .setHumanReviewConfig(humanReviewConfig.toString())
   *     .build();
   *   ReviewDocumentResponse response = documentProcessorServiceClient.reviewDocumentAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentAsync(ReviewDocumentRequest request) {
    return reviewDocumentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Send a document for Human Review. The input document should be processed by the specified
   * processor.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DocumentProcessorServiceClient documentProcessorServiceClient = DocumentProcessorServiceClient.create()) {
   *   HumanReviewConfigName humanReviewConfig = HumanReviewConfigName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   ReviewDocumentRequest request = ReviewDocumentRequest.newBuilder()
   *     .setHumanReviewConfig(humanReviewConfig.toString())
   *     .build();
   *   OperationFuture&lt;ReviewDocumentResponse, ReviewDocumentOperationMetadata&gt; future = documentProcessorServiceClient.reviewDocumentOperationCallable().futureCall(request);
   *   // Do something
   *   ReviewDocumentResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<
          ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentOperationCallable() {
    return stub.reviewDocumentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Send a document for Human Review. The input document should be processed by the specified
   * processor.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DocumentProcessorServiceClient documentProcessorServiceClient = DocumentProcessorServiceClient.create()) {
   *   HumanReviewConfigName humanReviewConfig = HumanReviewConfigName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   ReviewDocumentRequest request = ReviewDocumentRequest.newBuilder()
   *     .setHumanReviewConfig(humanReviewConfig.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = documentProcessorServiceClient.reviewDocumentCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ReviewDocumentRequest, Operation> reviewDocumentCallable() {
    return stub.reviewDocumentCallable();
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
