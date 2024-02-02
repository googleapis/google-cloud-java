/*
 * Copyright 2023 Google LLC
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
import com.google.cloud.documentai.v1beta3.stub.DocumentServiceStub;
import com.google.cloud.documentai.v1beta3.stub.DocumentServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to call Cloud DocumentAI to manage document collection (dataset).
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
 *   DatasetName dataset = DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
 *   GetDocumentResponse response = documentServiceClient.getDocument(dataset);
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
 *      <td><p> UpdateDataset</td>
 *      <td><p> Updates metadata associated with a dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDatasetAsync(UpdateDatasetRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateDatasetAsync(Dataset dataset, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDatasetOperationCallable()
 *           <li><p> updateDatasetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportDocuments</td>
 *      <td><p> Import documents into a dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importDocumentsAsync(ImportDocumentsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> importDocumentsAsync(DatasetName dataset)
 *           <li><p> importDocumentsAsync(String dataset)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importDocumentsOperationCallable()
 *           <li><p> importDocumentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDocument</td>
 *      <td><p> Returns relevant fields present in the requested document.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDocument(GetDocumentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDocument(DatasetName dataset)
 *           <li><p> getDocument(String dataset)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDocumentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDocuments</td>
 *      <td><p> Returns a list of documents present in the dataset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDocuments(ListDocumentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDocuments(DatasetName dataset)
 *           <li><p> listDocuments(String dataset)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDocumentsPagedCallable()
 *           <li><p> listDocumentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeleteDocuments</td>
 *      <td><p> Deletes a set of documents.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeleteDocumentsAsync(BatchDeleteDocumentsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> batchDeleteDocumentsAsync(String dataset)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeleteDocumentsOperationCallable()
 *           <li><p> batchDeleteDocumentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDatasetSchema</td>
 *      <td><p> Gets the `DatasetSchema` of a `Dataset`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDatasetSchema(GetDatasetSchemaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDatasetSchema(DatasetSchemaName name)
 *           <li><p> getDatasetSchema(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDatasetSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDatasetSchema</td>
 *      <td><p> Updates a `DatasetSchema`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDatasetSchema(UpdateDatasetSchemaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDatasetSchema(DatasetSchema datasetSchema, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDatasetSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
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
   * Updates metadata associated with a dataset.
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
   *   Dataset dataset = Dataset.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Dataset response = documentServiceClient.updateDatasetAsync(dataset, updateMask).get();
   * }
   * }</pre>
   *
   * @param dataset Required. The `name` field of the `Dataset` is used to identify the resource to
   *     be updated.
   * @param updateMask The update mask applies to the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Dataset, UpdateDatasetOperationMetadata> updateDatasetAsync(
      Dataset dataset, FieldMask updateMask) {
    UpdateDatasetRequest request =
        UpdateDatasetRequest.newBuilder().setDataset(dataset).setUpdateMask(updateMask).build();
    return updateDatasetAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates metadata associated with a dataset.
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
   *   UpdateDatasetRequest request =
   *       UpdateDatasetRequest.newBuilder()
   *           .setDataset(Dataset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Dataset response = documentServiceClient.updateDatasetAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Dataset, UpdateDatasetOperationMetadata> updateDatasetAsync(
      UpdateDatasetRequest request) {
    return updateDatasetOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates metadata associated with a dataset.
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
   *   UpdateDatasetRequest request =
   *       UpdateDatasetRequest.newBuilder()
   *           .setDataset(Dataset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Dataset, UpdateDatasetOperationMetadata> future =
   *       documentServiceClient.updateDatasetOperationCallable().futureCall(request);
   *   // Do something.
   *   Dataset response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDatasetRequest, Dataset, UpdateDatasetOperationMetadata>
      updateDatasetOperationCallable() {
    return stub.updateDatasetOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates metadata associated with a dataset.
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
   *   UpdateDatasetRequest request =
   *       UpdateDatasetRequest.newBuilder()
   *           .setDataset(Dataset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       documentServiceClient.updateDatasetCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDatasetRequest, Operation> updateDatasetCallable() {
    return stub.updateDatasetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import documents into a dataset.
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
   *   DatasetName dataset = DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   ImportDocumentsResponse response = documentServiceClient.importDocumentsAsync(dataset).get();
   * }
   * }</pre>
   *
   * @param dataset Required. The dataset resource name. Format:
   *     projects/{project}/locations/{location}/processors/{processor}/dataset
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportDocumentsResponse, ImportDocumentsMetadata>
      importDocumentsAsync(DatasetName dataset) {
    ImportDocumentsRequest request =
        ImportDocumentsRequest.newBuilder()
            .setDataset(dataset == null ? null : dataset.toString())
            .build();
    return importDocumentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import documents into a dataset.
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
   *   String dataset = DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString();
   *   ImportDocumentsResponse response = documentServiceClient.importDocumentsAsync(dataset).get();
   * }
   * }</pre>
   *
   * @param dataset Required. The dataset resource name. Format:
   *     projects/{project}/locations/{location}/processors/{processor}/dataset
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportDocumentsResponse, ImportDocumentsMetadata>
      importDocumentsAsync(String dataset) {
    ImportDocumentsRequest request =
        ImportDocumentsRequest.newBuilder().setDataset(dataset).build();
    return importDocumentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import documents into a dataset.
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
   *           .setDataset(DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .addAllBatchDocumentsImportConfigs(
   *               new ArrayList<ImportDocumentsRequest.BatchDocumentsImportConfig>())
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
   * Import documents into a dataset.
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
   *           .setDataset(DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .addAllBatchDocumentsImportConfigs(
   *               new ArrayList<ImportDocumentsRequest.BatchDocumentsImportConfig>())
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
   * Import documents into a dataset.
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
   *           .setDataset(DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .addAllBatchDocumentsImportConfigs(
   *               new ArrayList<ImportDocumentsRequest.BatchDocumentsImportConfig>())
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
   * Returns relevant fields present in the requested document.
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
   *   DatasetName dataset = DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   GetDocumentResponse response = documentServiceClient.getDocument(dataset);
   * }
   * }</pre>
   *
   * @param dataset Required. The resource name of the dataset that the document belongs to .
   *     Format: projects/{project}/locations/{location}/processors/{processor}/dataset
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetDocumentResponse getDocument(DatasetName dataset) {
    GetDocumentRequest request =
        GetDocumentRequest.newBuilder()
            .setDataset(dataset == null ? null : dataset.toString())
            .build();
    return getDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns relevant fields present in the requested document.
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
   *   String dataset = DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString();
   *   GetDocumentResponse response = documentServiceClient.getDocument(dataset);
   * }
   * }</pre>
   *
   * @param dataset Required. The resource name of the dataset that the document belongs to .
   *     Format: projects/{project}/locations/{location}/processors/{processor}/dataset
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetDocumentResponse getDocument(String dataset) {
    GetDocumentRequest request = GetDocumentRequest.newBuilder().setDataset(dataset).build();
    return getDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns relevant fields present in the requested document.
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
   *           .setDataset(DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setDocumentId(DocumentId.newBuilder().build())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setPageRange(DocumentPageRange.newBuilder().build())
   *           .build();
   *   GetDocumentResponse response = documentServiceClient.getDocument(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetDocumentResponse getDocument(GetDocumentRequest request) {
    return getDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns relevant fields present in the requested document.
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
   *           .setDataset(DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setDocumentId(DocumentId.newBuilder().build())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setPageRange(DocumentPageRange.newBuilder().build())
   *           .build();
   *   ApiFuture<GetDocumentResponse> future =
   *       documentServiceClient.getDocumentCallable().futureCall(request);
   *   // Do something.
   *   GetDocumentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDocumentRequest, GetDocumentResponse> getDocumentCallable() {
    return stub.getDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of documents present in the dataset.
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
   *   DatasetName dataset = DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   for (DocumentMetadata element : documentServiceClient.listDocuments(dataset).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param dataset Required. The resource name of the dataset to be listed. Format:
   *     projects/{project}/locations/{location}/processors/{processor}/dataset
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDocumentsPagedResponse listDocuments(DatasetName dataset) {
    ListDocumentsRequest request =
        ListDocumentsRequest.newBuilder()
            .setDataset(dataset == null ? null : dataset.toString())
            .build();
    return listDocuments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of documents present in the dataset.
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
   *   String dataset = DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString();
   *   for (DocumentMetadata element : documentServiceClient.listDocuments(dataset).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param dataset Required. The resource name of the dataset to be listed. Format:
   *     projects/{project}/locations/{location}/processors/{processor}/dataset
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDocumentsPagedResponse listDocuments(String dataset) {
    ListDocumentsRequest request = ListDocumentsRequest.newBuilder().setDataset(dataset).build();
    return listDocuments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of documents present in the dataset.
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
   *           .setDataset(DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setReturnTotalSize(true)
   *           .setSkip(3532159)
   *           .build();
   *   for (DocumentMetadata element : documentServiceClient.listDocuments(request).iterateAll()) {
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
   * Returns a list of documents present in the dataset.
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
   *           .setDataset(DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setReturnTotalSize(true)
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<DocumentMetadata> future =
   *       documentServiceClient.listDocumentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DocumentMetadata element : future.get().iterateAll()) {
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
   * Returns a list of documents present in the dataset.
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
   *           .setDataset(DatasetName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setReturnTotalSize(true)
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListDocumentsResponse response =
   *         documentServiceClient.listDocumentsCallable().call(request);
   *     for (DocumentMetadata element : response.getDocumentMetadataList()) {
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
   * Deletes a set of documents.
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
   *   String dataset = "dataset1443214456";
   *   BatchDeleteDocumentsResponse response =
   *       documentServiceClient.batchDeleteDocumentsAsync(dataset).get();
   * }
   * }</pre>
   *
   * @param dataset Required. The dataset resource name. Format:
   *     projects/{project}/locations/{location}/processors/{processor}/dataset
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchDeleteDocumentsResponse, BatchDeleteDocumentsMetadata>
      batchDeleteDocumentsAsync(String dataset) {
    BatchDeleteDocumentsRequest request =
        BatchDeleteDocumentsRequest.newBuilder().setDataset(dataset).build();
    return batchDeleteDocumentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a set of documents.
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
   *   BatchDeleteDocumentsRequest request =
   *       BatchDeleteDocumentsRequest.newBuilder()
   *           .setDataset("dataset1443214456")
   *           .setDatasetDocuments(BatchDatasetDocuments.newBuilder().build())
   *           .build();
   *   BatchDeleteDocumentsResponse response =
   *       documentServiceClient.batchDeleteDocumentsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchDeleteDocumentsResponse, BatchDeleteDocumentsMetadata>
      batchDeleteDocumentsAsync(BatchDeleteDocumentsRequest request) {
    return batchDeleteDocumentsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a set of documents.
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
   *   BatchDeleteDocumentsRequest request =
   *       BatchDeleteDocumentsRequest.newBuilder()
   *           .setDataset("dataset1443214456")
   *           .setDatasetDocuments(BatchDatasetDocuments.newBuilder().build())
   *           .build();
   *   OperationFuture<BatchDeleteDocumentsResponse, BatchDeleteDocumentsMetadata> future =
   *       documentServiceClient.batchDeleteDocumentsOperationCallable().futureCall(request);
   *   // Do something.
   *   BatchDeleteDocumentsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchDeleteDocumentsRequest, BatchDeleteDocumentsResponse, BatchDeleteDocumentsMetadata>
      batchDeleteDocumentsOperationCallable() {
    return stub.batchDeleteDocumentsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a set of documents.
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
   *   BatchDeleteDocumentsRequest request =
   *       BatchDeleteDocumentsRequest.newBuilder()
   *           .setDataset("dataset1443214456")
   *           .setDatasetDocuments(BatchDatasetDocuments.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       documentServiceClient.batchDeleteDocumentsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeleteDocumentsRequest, Operation>
      batchDeleteDocumentsCallable() {
    return stub.batchDeleteDocumentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the `DatasetSchema` of a `Dataset`.
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
   *   DatasetSchemaName name = DatasetSchemaName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
   *   DatasetSchema response = documentServiceClient.getDatasetSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The dataset schema resource name. Format:
   *     projects/{project}/locations/{location}/processors/{processor}/dataset/datasetSchema
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DatasetSchema getDatasetSchema(DatasetSchemaName name) {
    GetDatasetSchemaRequest request =
        GetDatasetSchemaRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDatasetSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the `DatasetSchema` of a `Dataset`.
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
   *   String name = DatasetSchemaName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString();
   *   DatasetSchema response = documentServiceClient.getDatasetSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The dataset schema resource name. Format:
   *     projects/{project}/locations/{location}/processors/{processor}/dataset/datasetSchema
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DatasetSchema getDatasetSchema(String name) {
    GetDatasetSchemaRequest request = GetDatasetSchemaRequest.newBuilder().setName(name).build();
    return getDatasetSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the `DatasetSchema` of a `Dataset`.
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
   *   GetDatasetSchemaRequest request =
   *       GetDatasetSchemaRequest.newBuilder()
   *           .setName(DatasetSchemaName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setVisibleFieldsOnly(true)
   *           .build();
   *   DatasetSchema response = documentServiceClient.getDatasetSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DatasetSchema getDatasetSchema(GetDatasetSchemaRequest request) {
    return getDatasetSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the `DatasetSchema` of a `Dataset`.
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
   *   GetDatasetSchemaRequest request =
   *       GetDatasetSchemaRequest.newBuilder()
   *           .setName(DatasetSchemaName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
   *           .setVisibleFieldsOnly(true)
   *           .build();
   *   ApiFuture<DatasetSchema> future =
   *       documentServiceClient.getDatasetSchemaCallable().futureCall(request);
   *   // Do something.
   *   DatasetSchema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDatasetSchemaRequest, DatasetSchema> getDatasetSchemaCallable() {
    return stub.getDatasetSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `DatasetSchema`.
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
   *   DatasetSchema datasetSchema = DatasetSchema.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DatasetSchema response = documentServiceClient.updateDatasetSchema(datasetSchema, updateMask);
   * }
   * }</pre>
   *
   * @param datasetSchema Required. The name field of the `DatasetSchema` is used to identify the
   *     resource to be updated.
   * @param updateMask The update mask applies to the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DatasetSchema updateDatasetSchema(
      DatasetSchema datasetSchema, FieldMask updateMask) {
    UpdateDatasetSchemaRequest request =
        UpdateDatasetSchemaRequest.newBuilder()
            .setDatasetSchema(datasetSchema)
            .setUpdateMask(updateMask)
            .build();
    return updateDatasetSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `DatasetSchema`.
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
   *   UpdateDatasetSchemaRequest request =
   *       UpdateDatasetSchemaRequest.newBuilder()
   *           .setDatasetSchema(DatasetSchema.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DatasetSchema response = documentServiceClient.updateDatasetSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DatasetSchema updateDatasetSchema(UpdateDatasetSchemaRequest request) {
    return updateDatasetSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `DatasetSchema`.
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
   *   UpdateDatasetSchemaRequest request =
   *       UpdateDatasetSchemaRequest.newBuilder()
   *           .setDatasetSchema(DatasetSchema.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DatasetSchema> future =
   *       documentServiceClient.updateDatasetSchemaCallable().futureCall(request);
   *   // Do something.
   *   DatasetSchema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDatasetSchemaRequest, DatasetSchema>
      updateDatasetSchemaCallable() {
    return stub.updateDatasetSchemaCallable();
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
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : documentServiceClient.listLocations(request).iterateAll()) {
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
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       documentServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         documentServiceClient.listLocationsCallable().call(request);
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
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = documentServiceClient.getLocation(request);
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
   * try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = documentServiceClient.getLocationCallable().futureCall(request);
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

  public static class ListDocumentsPagedResponse
      extends AbstractPagedListResponse<
          ListDocumentsRequest,
          ListDocumentsResponse,
          DocumentMetadata,
          ListDocumentsPage,
          ListDocumentsFixedSizeCollection> {

    public static ApiFuture<ListDocumentsPagedResponse> createAsync(
        PageContext<ListDocumentsRequest, ListDocumentsResponse, DocumentMetadata> context,
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
          ListDocumentsRequest, ListDocumentsResponse, DocumentMetadata, ListDocumentsPage> {

    private ListDocumentsPage(
        PageContext<ListDocumentsRequest, ListDocumentsResponse, DocumentMetadata> context,
        ListDocumentsResponse response) {
      super(context, response);
    }

    private static ListDocumentsPage createEmptyPage() {
      return new ListDocumentsPage(null, null);
    }

    @Override
    protected ListDocumentsPage createPage(
        PageContext<ListDocumentsRequest, ListDocumentsResponse, DocumentMetadata> context,
        ListDocumentsResponse response) {
      return new ListDocumentsPage(context, response);
    }

    @Override
    public ApiFuture<ListDocumentsPage> createPageAsync(
        PageContext<ListDocumentsRequest, ListDocumentsResponse, DocumentMetadata> context,
        ApiFuture<ListDocumentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDocumentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDocumentsRequest,
          ListDocumentsResponse,
          DocumentMetadata,
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
