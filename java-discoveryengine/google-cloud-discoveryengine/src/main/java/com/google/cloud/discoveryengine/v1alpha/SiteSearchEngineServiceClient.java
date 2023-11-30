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

package com.google.cloud.discoveryengine.v1alpha;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.stub.SiteSearchEngineServiceStub;
import com.google.cloud.discoveryengine.v1alpha.stub.SiteSearchEngineServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing site search related resources.
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
 * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
 *     SiteSearchEngineServiceClient.create()) {
 *   RecrawlUrisRequest request =
 *       RecrawlUrisRequest.newBuilder()
 *           .setSiteSearchEngine(
 *               SiteSearchEngineName.ofProjectLocationDataStoreName(
 *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
 *                   .toString())
 *           .addAllUris(new ArrayList<String>())
 *           .build();
 *   RecrawlUrisResponse response = siteSearchEngineServiceClient.recrawlUrisAsync(request).get();
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SiteSearchEngineServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    <tr>
 *      <td>RecrawlUris</td>
 *      <td><p>Request on-demand recrawl for a list of URIs.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>recrawlUrisAsync(RecrawlUrisRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>recrawlUrisOperationCallable()
 *           <li>recrawlUrisCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of
 * SiteSearchEngineServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SiteSearchEngineServiceSettings siteSearchEngineServiceSettings =
 *     SiteSearchEngineServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SiteSearchEngineServiceClient siteSearchEngineServiceClient =
 *     SiteSearchEngineServiceClient.create(siteSearchEngineServiceSettings);
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
 * SiteSearchEngineServiceSettings siteSearchEngineServiceSettings =
 *     SiteSearchEngineServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SiteSearchEngineServiceClient siteSearchEngineServiceClient =
 *     SiteSearchEngineServiceClient.create(siteSearchEngineServiceSettings);
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
 * SiteSearchEngineServiceSettings siteSearchEngineServiceSettings =
 *     SiteSearchEngineServiceSettings.newHttpJsonBuilder().build();
 * SiteSearchEngineServiceClient siteSearchEngineServiceClient =
 *     SiteSearchEngineServiceClient.create(siteSearchEngineServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SiteSearchEngineServiceClient implements BackgroundResource {
  private final SiteSearchEngineServiceSettings settings;
  private final SiteSearchEngineServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of SiteSearchEngineServiceClient with default settings. */
  public static final SiteSearchEngineServiceClient create() throws IOException {
    return create(SiteSearchEngineServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SiteSearchEngineServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SiteSearchEngineServiceClient create(SiteSearchEngineServiceSettings settings)
      throws IOException {
    return new SiteSearchEngineServiceClient(settings);
  }

  /**
   * Constructs an instance of SiteSearchEngineServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(SiteSearchEngineServiceSettings).
   */
  public static final SiteSearchEngineServiceClient create(SiteSearchEngineServiceStub stub) {
    return new SiteSearchEngineServiceClient(stub);
  }

  /**
   * Constructs an instance of SiteSearchEngineServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SiteSearchEngineServiceClient(SiteSearchEngineServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((SiteSearchEngineServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected SiteSearchEngineServiceClient(SiteSearchEngineServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final SiteSearchEngineServiceSettings getSettings() {
    return settings;
  }

  public SiteSearchEngineServiceStub getStub() {
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
   * Request on-demand recrawl for a list of URIs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   RecrawlUrisRequest request =
   *       RecrawlUrisRequest.newBuilder()
   *           .setSiteSearchEngine(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .addAllUris(new ArrayList<String>())
   *           .build();
   *   RecrawlUrisResponse response = siteSearchEngineServiceClient.recrawlUrisAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RecrawlUrisResponse, RecrawlUrisMetadata> recrawlUrisAsync(
      RecrawlUrisRequest request) {
    return recrawlUrisOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request on-demand recrawl for a list of URIs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   RecrawlUrisRequest request =
   *       RecrawlUrisRequest.newBuilder()
   *           .setSiteSearchEngine(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .addAllUris(new ArrayList<String>())
   *           .build();
   *   OperationFuture<RecrawlUrisResponse, RecrawlUrisMetadata> future =
   *       siteSearchEngineServiceClient.recrawlUrisOperationCallable().futureCall(request);
   *   // Do something.
   *   RecrawlUrisResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RecrawlUrisRequest, RecrawlUrisResponse, RecrawlUrisMetadata>
      recrawlUrisOperationCallable() {
    return stub.recrawlUrisOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Request on-demand recrawl for a list of URIs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
   *     SiteSearchEngineServiceClient.create()) {
   *   RecrawlUrisRequest request =
   *       RecrawlUrisRequest.newBuilder()
   *           .setSiteSearchEngine(
   *               SiteSearchEngineName.ofProjectLocationDataStoreName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
   *                   .toString())
   *           .addAllUris(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       siteSearchEngineServiceClient.recrawlUrisCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RecrawlUrisRequest, Operation> recrawlUrisCallable() {
    return stub.recrawlUrisCallable();
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
