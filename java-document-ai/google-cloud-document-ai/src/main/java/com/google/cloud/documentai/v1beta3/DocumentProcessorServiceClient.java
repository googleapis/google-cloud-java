/*
 * Copyright 2021 Google LLC
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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.documentai.v1beta3.stub.DocumentProcessorServiceStub;
import com.google.cloud.documentai.v1beta3.stub.DocumentProcessorServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
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
 * try (DocumentProcessorServiceClient documentProcessorServiceClient =
 *     DocumentProcessorServiceClient.create()) {
 *   ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
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
 * DocumentProcessorServiceSettings documentProcessorServiceSettings =
 *     DocumentProcessorServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
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
   * calls. This is for advanced usage - prefer using create(DocumentProcessorServiceSettings).
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
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Processes a single document.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   ProcessResponse response = documentProcessorServiceClient.processDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. The processor resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProcessResponse processDocument(ProcessorName name) {
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString();
   *   ProcessResponse response = documentProcessorServiceClient.processDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. The processor resource name.
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ProcessRequest request =
   *       ProcessRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setDocument(Document.newBuilder().build())
   *           .setSkipHumanReview(true)
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ProcessRequest request =
   *       ProcessRequest.newBuilder()
   *           .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setDocument(Document.newBuilder().build())
   *           .setSkipHumanReview(true)
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   BatchProcessResponse response =
   *       documentProcessorServiceClient.batchProcessDocumentsAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The processor resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsAsync(ProcessorName name) {
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString();
   *   BatchProcessResponse response =
   *       documentProcessorServiceClient.batchProcessDocumentsAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The processor resource name.
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
   * Fetches processor types.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   FetchProcessorTypesResponse response =
   *       documentProcessorServiceClient.fetchProcessorTypes(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The project of processor type to list. Format:
   *     projects/{project}/locations/{location}
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
   * Fetches processor types.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String parent =
   *       ProcessorTypeName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR_TYPE]").toString();
   *   FetchProcessorTypesResponse response =
   *       documentProcessorServiceClient.fetchProcessorTypes(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The project of processor type to list. Format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchProcessorTypesResponse fetchProcessorTypes(String parent) {
    FetchProcessorTypesRequest request =
        FetchProcessorTypesRequest.newBuilder().setParent(parent).build();
    return fetchProcessorTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches processor types.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   FetchProcessorTypesRequest request =
   *       FetchProcessorTypesRequest.newBuilder()
   *           .setParent(
   *               ProcessorTypeName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR_TYPE]").toString())
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
   * Fetches processor types.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   FetchProcessorTypesRequest request =
   *       FetchProcessorTypesRequest.newBuilder()
   *           .setParent(
   *               ProcessorTypeName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR_TYPE]").toString())
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
   * Lists all processors which belong to this project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
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
   *     Processors. Format: projects/{project}/locations/{location}
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String parent = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString();
   *   for (Processor element : documentProcessorServiceClient.listProcessors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) which owns this collection of
   *     Processors. Format: projects/{project}/locations/{location}
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ListProcessorsRequest request =
   *       ListProcessorsRequest.newBuilder()
   *           .setParent(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ListProcessorsRequest request =
   *       ListProcessorsRequest.newBuilder()
   *           .setParent(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ListProcessorsRequest request =
   *       ListProcessorsRequest.newBuilder()
   *           .setParent(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListProcessorsResponse response =
   *         documentProcessorServiceClient.listProcessorsCallable().call(request);
   *     for (Processor element : response.getResponsesList()) {
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
   * Creates a processor from the type processor that the user chose. The processor will be at
   * "ENABLED" state by default after its creation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Processor processor = Processor.newBuilder().build();
   *   Processor response = documentProcessorServiceClient.createProcessor(parent, processor);
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) under which to create the processor.
   *     Format: projects/{project}/locations/{location}
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   String parent = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString();
   *   Processor processor = Processor.newBuilder().build();
   *   Processor response = documentProcessorServiceClient.createProcessor(parent, processor);
   * }
   * }</pre>
   *
   * @param parent Required. The parent (project and location) under which to create the processor.
   *     Format: projects/{project}/locations/{location}
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   CreateProcessorRequest request =
   *       CreateProcessorRequest.newBuilder()
   *           .setParent(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   CreateProcessorRequest request =
   *       CreateProcessorRequest.newBuilder()
   *           .setParent(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
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
   * Send a document for Human Review. The input document should be processed by the specified
   * processor.
   *
   * <p>Sample code:
   *
   * <pre>{@code
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ReviewDocumentRequest request =
   *       ReviewDocumentRequest.newBuilder()
   *           .setHumanReviewConfig(
   *               HumanReviewConfigName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setDocument(Document.newBuilder().build())
   *           .setEnableSchemaValidation(true)
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ReviewDocumentRequest request =
   *       ReviewDocumentRequest.newBuilder()
   *           .setHumanReviewConfig(
   *               HumanReviewConfigName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setDocument(Document.newBuilder().build())
   *           .setEnableSchemaValidation(true)
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
   * try (DocumentProcessorServiceClient documentProcessorServiceClient =
   *     DocumentProcessorServiceClient.create()) {
   *   ReviewDocumentRequest request =
   *       ReviewDocumentRequest.newBuilder()
   *           .setHumanReviewConfig(
   *               HumanReviewConfigName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setDocument(Document.newBuilder().build())
   *           .setEnableSchemaValidation(true)
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
          new ApiFunction<ListProcessorsPage, ListProcessorsPagedResponse>() {
            @Override
            public ListProcessorsPagedResponse apply(ListProcessorsPage input) {
              return new ListProcessorsPagedResponse(input);
            }
          },
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
}
