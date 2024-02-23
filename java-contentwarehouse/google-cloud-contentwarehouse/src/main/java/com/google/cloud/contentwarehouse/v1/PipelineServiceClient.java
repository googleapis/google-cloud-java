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

package com.google.cloud.contentwarehouse.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.contentwarehouse.v1.stub.PipelineServiceStub;
import com.google.cloud.contentwarehouse.v1.stub.PipelineServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This service lets you manage pipelines.
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
 * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
 *   LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");
 *   RunPipelineResponse response = pipelineServiceClient.runPipelineAsync(name).get();
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PipelineServiceClient object to clean up resources
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
 *      <td><p> RunPipeline</td>
 *      <td><p> Run a predefined pipeline.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> runPipelineAsync(RunPipelineRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> runPipelineAsync(LocationName name)
 *           <li><p> runPipelineAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runPipelineOperationCallable()
 *           <li><p> runPipelineCallable()
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
 * <p>This class can be customized by passing in a custom instance of PipelineServiceSettings to
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
 * PipelineServiceSettings pipelineServiceSettings =
 *     PipelineServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PipelineServiceClient pipelineServiceClient =
 *     PipelineServiceClient.create(pipelineServiceSettings);
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
 * PipelineServiceSettings pipelineServiceSettings =
 *     PipelineServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PipelineServiceClient pipelineServiceClient =
 *     PipelineServiceClient.create(pipelineServiceSettings);
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
 * PipelineServiceSettings pipelineServiceSettings =
 *     PipelineServiceSettings.newHttpJsonBuilder().build();
 * PipelineServiceClient pipelineServiceClient =
 *     PipelineServiceClient.create(pipelineServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class PipelineServiceClient implements BackgroundResource {
  private final PipelineServiceSettings settings;
  private final PipelineServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of PipelineServiceClient with default settings. */
  public static final PipelineServiceClient create() throws IOException {
    return create(PipelineServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PipelineServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PipelineServiceClient create(PipelineServiceSettings settings)
      throws IOException {
    return new PipelineServiceClient(settings);
  }

  /**
   * Constructs an instance of PipelineServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(PipelineServiceSettings).
   */
  public static final PipelineServiceClient create(PipelineServiceStub stub) {
    return new PipelineServiceClient(stub);
  }

  /**
   * Constructs an instance of PipelineServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PipelineServiceClient(PipelineServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PipelineServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected PipelineServiceClient(PipelineServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final PipelineServiceSettings getSettings() {
    return settings;
  }

  public PipelineServiceStub getStub() {
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
   * Run a predefined pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   LocationName name = LocationName.of("[PROJECT]", "[LOCATION]");
   *   RunPipelineResponse response = pipelineServiceClient.runPipelineAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name which owns the resources of the pipeline. Format:
   *     projects/{project_number}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RunPipelineResponse, RunPipelineMetadata> runPipelineAsync(
      LocationName name) {
    RunPipelineRequest request =
        RunPipelineRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return runPipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Run a predefined pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   String name = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   RunPipelineResponse response = pipelineServiceClient.runPipelineAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name which owns the resources of the pipeline. Format:
   *     projects/{project_number}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RunPipelineResponse, RunPipelineMetadata> runPipelineAsync(
      String name) {
    RunPipelineRequest request = RunPipelineRequest.newBuilder().setName(name).build();
    return runPipelineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Run a predefined pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   RunPipelineRequest request =
   *       RunPipelineRequest.newBuilder()
   *           .setName(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .build();
   *   RunPipelineResponse response = pipelineServiceClient.runPipelineAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RunPipelineResponse, RunPipelineMetadata> runPipelineAsync(
      RunPipelineRequest request) {
    return runPipelineOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Run a predefined pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   RunPipelineRequest request =
   *       RunPipelineRequest.newBuilder()
   *           .setName(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .build();
   *   OperationFuture<RunPipelineResponse, RunPipelineMetadata> future =
   *       pipelineServiceClient.runPipelineOperationCallable().futureCall(request);
   *   // Do something.
   *   RunPipelineResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RunPipelineRequest, RunPipelineResponse, RunPipelineMetadata>
      runPipelineOperationCallable() {
    return stub.runPipelineOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Run a predefined pipeline.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PipelineServiceClient pipelineServiceClient = PipelineServiceClient.create()) {
   *   RunPipelineRequest request =
   *       RunPipelineRequest.newBuilder()
   *           .setName(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRequestMetadata(RequestMetadata.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = pipelineServiceClient.runPipelineCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunPipelineRequest, Operation> runPipelineCallable() {
    return stub.runPipelineCallable();
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
