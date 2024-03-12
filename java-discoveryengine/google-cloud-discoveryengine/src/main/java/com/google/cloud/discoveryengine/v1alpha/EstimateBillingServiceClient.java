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
import com.google.cloud.discoveryengine.v1alpha.stub.EstimateBillingServiceStub;
import com.google.cloud.discoveryengine.v1alpha.stub.EstimateBillingServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing billing estimations resources.
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
 * try (EstimateBillingServiceClient estimateBillingServiceClient =
 *     EstimateBillingServiceClient.create()) {
 *   EstimateDataSizeRequest request =
 *       EstimateDataSizeRequest.newBuilder()
 *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
 *           .build();
 *   EstimateDataSizeResponse response =
 *       estimateBillingServiceClient.estimateDataSizeAsync(request).get();
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the EstimateBillingServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> EstimateDataSize</td>
 *      <td><p> Estimates the data size to be used by a customer.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> estimateDataSizeAsync(EstimateDataSizeRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> estimateDataSizeOperationCallable()
 *           <li><p> estimateDataSizeCallable()
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
 * <p>This class can be customized by passing in a custom instance of EstimateBillingServiceSettings
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
 * EstimateBillingServiceSettings estimateBillingServiceSettings =
 *     EstimateBillingServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EstimateBillingServiceClient estimateBillingServiceClient =
 *     EstimateBillingServiceClient.create(estimateBillingServiceSettings);
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
 * EstimateBillingServiceSettings estimateBillingServiceSettings =
 *     EstimateBillingServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EstimateBillingServiceClient estimateBillingServiceClient =
 *     EstimateBillingServiceClient.create(estimateBillingServiceSettings);
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
 * EstimateBillingServiceSettings estimateBillingServiceSettings =
 *     EstimateBillingServiceSettings.newHttpJsonBuilder().build();
 * EstimateBillingServiceClient estimateBillingServiceClient =
 *     EstimateBillingServiceClient.create(estimateBillingServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class EstimateBillingServiceClient implements BackgroundResource {
  private final EstimateBillingServiceSettings settings;
  private final EstimateBillingServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of EstimateBillingServiceClient with default settings. */
  public static final EstimateBillingServiceClient create() throws IOException {
    return create(EstimateBillingServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EstimateBillingServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final EstimateBillingServiceClient create(EstimateBillingServiceSettings settings)
      throws IOException {
    return new EstimateBillingServiceClient(settings);
  }

  /**
   * Constructs an instance of EstimateBillingServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(EstimateBillingServiceSettings).
   */
  public static final EstimateBillingServiceClient create(EstimateBillingServiceStub stub) {
    return new EstimateBillingServiceClient(stub);
  }

  /**
   * Constructs an instance of EstimateBillingServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected EstimateBillingServiceClient(EstimateBillingServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((EstimateBillingServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected EstimateBillingServiceClient(EstimateBillingServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final EstimateBillingServiceSettings getSettings() {
    return settings;
  }

  public EstimateBillingServiceStub getStub() {
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
   * Estimates the data size to be used by a customer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EstimateBillingServiceClient estimateBillingServiceClient =
   *     EstimateBillingServiceClient.create()) {
   *   EstimateDataSizeRequest request =
   *       EstimateDataSizeRequest.newBuilder()
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   EstimateDataSizeResponse response =
   *       estimateBillingServiceClient.estimateDataSizeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EstimateDataSizeResponse, EstimateDataSizeMetadata>
      estimateDataSizeAsync(EstimateDataSizeRequest request) {
    return estimateDataSizeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Estimates the data size to be used by a customer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EstimateBillingServiceClient estimateBillingServiceClient =
   *     EstimateBillingServiceClient.create()) {
   *   EstimateDataSizeRequest request =
   *       EstimateDataSizeRequest.newBuilder()
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   OperationFuture<EstimateDataSizeResponse, EstimateDataSizeMetadata> future =
   *       estimateBillingServiceClient.estimateDataSizeOperationCallable().futureCall(request);
   *   // Do something.
   *   EstimateDataSizeResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          EstimateDataSizeRequest, EstimateDataSizeResponse, EstimateDataSizeMetadata>
      estimateDataSizeOperationCallable() {
    return stub.estimateDataSizeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Estimates the data size to be used by a customer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EstimateBillingServiceClient estimateBillingServiceClient =
   *     EstimateBillingServiceClient.create()) {
   *   EstimateDataSizeRequest request =
   *       EstimateDataSizeRequest.newBuilder()
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       estimateBillingServiceClient.estimateDataSizeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EstimateDataSizeRequest, Operation> estimateDataSizeCallable() {
    return stub.estimateDataSizeCallable();
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
