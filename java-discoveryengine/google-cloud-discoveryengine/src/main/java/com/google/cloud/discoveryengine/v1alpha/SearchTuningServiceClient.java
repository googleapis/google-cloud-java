/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.discoveryengine.v1alpha;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.stub.SearchTuningServiceStub;
import com.google.cloud.discoveryengine.v1alpha.stub.SearchTuningServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for search tuning.
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
 * try (SearchTuningServiceClient searchTuningServiceClient = SearchTuningServiceClient.create()) {
 *   ListCustomModelsRequest request =
 *       ListCustomModelsRequest.newBuilder()
 *           .setDataStore(
 *               DataStoreName.ofProjectLocationCollectionDataStoreName(
 *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
 *                   .toString())
 *           .build();
 *   ListCustomModelsResponse response = searchTuningServiceClient.listCustomModels(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SearchTuningServiceClient object to clean up resources
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
 *      <td><p> TrainCustomModel</td>
 *      <td><p> Trains a custom model.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> trainCustomModelAsync(TrainCustomModelRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> trainCustomModelOperationCallable()
 *           <li><p> trainCustomModelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCustomModels</td>
 *      <td><p> Gets a list of all the custom models.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCustomModels(ListCustomModelsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCustomModelsCallable()
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
 * <p>This class can be customized by passing in a custom instance of SearchTuningServiceSettings to
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
 * SearchTuningServiceSettings searchTuningServiceSettings =
 *     SearchTuningServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SearchTuningServiceClient searchTuningServiceClient =
 *     SearchTuningServiceClient.create(searchTuningServiceSettings);
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
 * SearchTuningServiceSettings searchTuningServiceSettings =
 *     SearchTuningServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SearchTuningServiceClient searchTuningServiceClient =
 *     SearchTuningServiceClient.create(searchTuningServiceSettings);
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
 * SearchTuningServiceSettings searchTuningServiceSettings =
 *     SearchTuningServiceSettings.newHttpJsonBuilder().build();
 * SearchTuningServiceClient searchTuningServiceClient =
 *     SearchTuningServiceClient.create(searchTuningServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SearchTuningServiceClient implements BackgroundResource {
  private final SearchTuningServiceSettings settings;
  private final SearchTuningServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of SearchTuningServiceClient with default settings. */
  public static final SearchTuningServiceClient create() throws IOException {
    return create(SearchTuningServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SearchTuningServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SearchTuningServiceClient create(SearchTuningServiceSettings settings)
      throws IOException {
    return new SearchTuningServiceClient(settings);
  }

  /**
   * Constructs an instance of SearchTuningServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(SearchTuningServiceSettings).
   */
  public static final SearchTuningServiceClient create(SearchTuningServiceStub stub) {
    return new SearchTuningServiceClient(stub);
  }

  /**
   * Constructs an instance of SearchTuningServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SearchTuningServiceClient(SearchTuningServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SearchTuningServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected SearchTuningServiceClient(SearchTuningServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final SearchTuningServiceSettings getSettings() {
    return settings;
  }

  public SearchTuningServiceStub getStub() {
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
   * Trains a custom model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchTuningServiceClient searchTuningServiceClient = SearchTuningServiceClient.create()) {
   *   TrainCustomModelRequest request =
   *       TrainCustomModelRequest.newBuilder()
   *           .setDataStore(
   *               DataStoreName.ofProjectLocationCollectionDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
   *                   .toString())
   *           .setModelType("modelType-2010627581")
   *           .setErrorConfig(ImportErrorConfig.newBuilder().build())
   *           .setModelId("modelId1226956324")
   *           .build();
   *   TrainCustomModelResponse response =
   *       searchTuningServiceClient.trainCustomModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TrainCustomModelResponse, TrainCustomModelMetadata>
      trainCustomModelAsync(TrainCustomModelRequest request) {
    return trainCustomModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Trains a custom model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchTuningServiceClient searchTuningServiceClient = SearchTuningServiceClient.create()) {
   *   TrainCustomModelRequest request =
   *       TrainCustomModelRequest.newBuilder()
   *           .setDataStore(
   *               DataStoreName.ofProjectLocationCollectionDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
   *                   .toString())
   *           .setModelType("modelType-2010627581")
   *           .setErrorConfig(ImportErrorConfig.newBuilder().build())
   *           .setModelId("modelId1226956324")
   *           .build();
   *   OperationFuture<TrainCustomModelResponse, TrainCustomModelMetadata> future =
   *       searchTuningServiceClient.trainCustomModelOperationCallable().futureCall(request);
   *   // Do something.
   *   TrainCustomModelResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          TrainCustomModelRequest, TrainCustomModelResponse, TrainCustomModelMetadata>
      trainCustomModelOperationCallable() {
    return stub.trainCustomModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Trains a custom model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchTuningServiceClient searchTuningServiceClient = SearchTuningServiceClient.create()) {
   *   TrainCustomModelRequest request =
   *       TrainCustomModelRequest.newBuilder()
   *           .setDataStore(
   *               DataStoreName.ofProjectLocationCollectionDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
   *                   .toString())
   *           .setModelType("modelType-2010627581")
   *           .setErrorConfig(ImportErrorConfig.newBuilder().build())
   *           .setModelId("modelId1226956324")
   *           .build();
   *   ApiFuture<Operation> future =
   *       searchTuningServiceClient.trainCustomModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TrainCustomModelRequest, Operation> trainCustomModelCallable() {
    return stub.trainCustomModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of all the custom models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchTuningServiceClient searchTuningServiceClient = SearchTuningServiceClient.create()) {
   *   ListCustomModelsRequest request =
   *       ListCustomModelsRequest.newBuilder()
   *           .setDataStore(
   *               DataStoreName.ofProjectLocationCollectionDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
   *                   .toString())
   *           .build();
   *   ListCustomModelsResponse response = searchTuningServiceClient.listCustomModels(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomModelsResponse listCustomModels(ListCustomModelsRequest request) {
    return listCustomModelsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of all the custom models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SearchTuningServiceClient searchTuningServiceClient = SearchTuningServiceClient.create()) {
   *   ListCustomModelsRequest request =
   *       ListCustomModelsRequest.newBuilder()
   *           .setDataStore(
   *               DataStoreName.ofProjectLocationCollectionDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ListCustomModelsResponse> future =
   *       searchTuningServiceClient.listCustomModelsCallable().futureCall(request);
   *   // Do something.
   *   ListCustomModelsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCustomModelsRequest, ListCustomModelsResponse>
      listCustomModelsCallable() {
    return stub.listCustomModelsCallable();
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
