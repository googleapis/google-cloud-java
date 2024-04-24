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

package com.google.shopping.merchant.lfp.v1beta;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.merchant.lfp.v1beta.stub.LfpSaleServiceStub;
import com.google.shopping.merchant.lfp.v1beta.stub.LfpSaleServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for a [LFP
 * partner](https://support.google.com/merchants/answer/7676652) to submit sales data for a
 * merchant.
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
 * try (LfpSaleServiceClient lfpSaleServiceClient = LfpSaleServiceClient.create()) {
 *   InsertLfpSaleRequest request =
 *       InsertLfpSaleRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setLfpSale(LfpSale.newBuilder().build())
 *           .build();
 *   LfpSale response = lfpSaleServiceClient.insertLfpSale(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LfpSaleServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> InsertLfpSale</td>
 *      <td><p> Inserts a `LfpSale` for the given merchant.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertLfpSale(InsertLfpSaleRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertLfpSaleCallable()
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
 * <p>This class can be customized by passing in a custom instance of LfpSaleServiceSettings to
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
 * LfpSaleServiceSettings lfpSaleServiceSettings =
 *     LfpSaleServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LfpSaleServiceClient lfpSaleServiceClient = LfpSaleServiceClient.create(lfpSaleServiceSettings);
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
 * LfpSaleServiceSettings lfpSaleServiceSettings =
 *     LfpSaleServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LfpSaleServiceClient lfpSaleServiceClient = LfpSaleServiceClient.create(lfpSaleServiceSettings);
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
 * LfpSaleServiceSettings lfpSaleServiceSettings =
 *     LfpSaleServiceSettings.newHttpJsonBuilder().build();
 * LfpSaleServiceClient lfpSaleServiceClient = LfpSaleServiceClient.create(lfpSaleServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class LfpSaleServiceClient implements BackgroundResource {
  private final LfpSaleServiceSettings settings;
  private final LfpSaleServiceStub stub;

  /** Constructs an instance of LfpSaleServiceClient with default settings. */
  public static final LfpSaleServiceClient create() throws IOException {
    return create(LfpSaleServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LfpSaleServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LfpSaleServiceClient create(LfpSaleServiceSettings settings)
      throws IOException {
    return new LfpSaleServiceClient(settings);
  }

  /**
   * Constructs an instance of LfpSaleServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(LfpSaleServiceSettings).
   */
  public static final LfpSaleServiceClient create(LfpSaleServiceStub stub) {
    return new LfpSaleServiceClient(stub);
  }

  /**
   * Constructs an instance of LfpSaleServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected LfpSaleServiceClient(LfpSaleServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LfpSaleServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LfpSaleServiceClient(LfpSaleServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LfpSaleServiceSettings getSettings() {
    return settings;
  }

  public LfpSaleServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a `LfpSale` for the given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpSaleServiceClient lfpSaleServiceClient = LfpSaleServiceClient.create()) {
   *   InsertLfpSaleRequest request =
   *       InsertLfpSaleRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setLfpSale(LfpSale.newBuilder().build())
   *           .build();
   *   LfpSale response = lfpSaleServiceClient.insertLfpSale(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LfpSale insertLfpSale(InsertLfpSaleRequest request) {
    return insertLfpSaleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a `LfpSale` for the given merchant.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpSaleServiceClient lfpSaleServiceClient = LfpSaleServiceClient.create()) {
   *   InsertLfpSaleRequest request =
   *       InsertLfpSaleRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setLfpSale(LfpSale.newBuilder().build())
   *           .build();
   *   ApiFuture<LfpSale> future = lfpSaleServiceClient.insertLfpSaleCallable().futureCall(request);
   *   // Do something.
   *   LfpSale response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertLfpSaleRequest, LfpSale> insertLfpSaleCallable() {
    return stub.insertLfpSaleCallable();
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
