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
import com.google.shopping.merchant.lfp.v1beta.stub.LfpInventoryServiceStub;
import com.google.shopping.merchant.lfp.v1beta.stub.LfpInventoryServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for a [LFP
 * partner](https://support.google.com/merchants/answer/7676652) to submit local inventories for a
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
 * try (LfpInventoryServiceClient lfpInventoryServiceClient = LfpInventoryServiceClient.create()) {
 *   InsertLfpInventoryRequest request =
 *       InsertLfpInventoryRequest.newBuilder()
 *           .setParent(AccountName.of("[ACCOUNT]").toString())
 *           .setLfpInventory(LfpInventory.newBuilder().build())
 *           .build();
 *   LfpInventory response = lfpInventoryServiceClient.insertLfpInventory(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LfpInventoryServiceClient object to clean up resources
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
 *      <td><p> InsertLfpInventory</td>
 *      <td><p> Inserts a `LfpInventory` resource for the given target merchant account. If the resource already exists, it will be replaced. The inventory automatically expires after 30 days.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertLfpInventory(InsertLfpInventoryRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertLfpInventoryCallable()
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
 * <p>This class can be customized by passing in a custom instance of LfpInventoryServiceSettings to
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
 * LfpInventoryServiceSettings lfpInventoryServiceSettings =
 *     LfpInventoryServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LfpInventoryServiceClient lfpInventoryServiceClient =
 *     LfpInventoryServiceClient.create(lfpInventoryServiceSettings);
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
 * LfpInventoryServiceSettings lfpInventoryServiceSettings =
 *     LfpInventoryServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LfpInventoryServiceClient lfpInventoryServiceClient =
 *     LfpInventoryServiceClient.create(lfpInventoryServiceSettings);
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
 * LfpInventoryServiceSettings lfpInventoryServiceSettings =
 *     LfpInventoryServiceSettings.newHttpJsonBuilder().build();
 * LfpInventoryServiceClient lfpInventoryServiceClient =
 *     LfpInventoryServiceClient.create(lfpInventoryServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class LfpInventoryServiceClient implements BackgroundResource {
  private final LfpInventoryServiceSettings settings;
  private final LfpInventoryServiceStub stub;

  /** Constructs an instance of LfpInventoryServiceClient with default settings. */
  public static final LfpInventoryServiceClient create() throws IOException {
    return create(LfpInventoryServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LfpInventoryServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LfpInventoryServiceClient create(LfpInventoryServiceSettings settings)
      throws IOException {
    return new LfpInventoryServiceClient(settings);
  }

  /**
   * Constructs an instance of LfpInventoryServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(LfpInventoryServiceSettings).
   */
  public static final LfpInventoryServiceClient create(LfpInventoryServiceStub stub) {
    return new LfpInventoryServiceClient(stub);
  }

  /**
   * Constructs an instance of LfpInventoryServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected LfpInventoryServiceClient(LfpInventoryServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LfpInventoryServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LfpInventoryServiceClient(LfpInventoryServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LfpInventoryServiceSettings getSettings() {
    return settings;
  }

  public LfpInventoryServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a `LfpInventory` resource for the given target merchant account. If the resource
   * already exists, it will be replaced. The inventory automatically expires after 30 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpInventoryServiceClient lfpInventoryServiceClient = LfpInventoryServiceClient.create()) {
   *   InsertLfpInventoryRequest request =
   *       InsertLfpInventoryRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setLfpInventory(LfpInventory.newBuilder().build())
   *           .build();
   *   LfpInventory response = lfpInventoryServiceClient.insertLfpInventory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LfpInventory insertLfpInventory(InsertLfpInventoryRequest request) {
    return insertLfpInventoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a `LfpInventory` resource for the given target merchant account. If the resource
   * already exists, it will be replaced. The inventory automatically expires after 30 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LfpInventoryServiceClient lfpInventoryServiceClient = LfpInventoryServiceClient.create()) {
   *   InsertLfpInventoryRequest request =
   *       InsertLfpInventoryRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setLfpInventory(LfpInventory.newBuilder().build())
   *           .build();
   *   ApiFuture<LfpInventory> future =
   *       lfpInventoryServiceClient.insertLfpInventoryCallable().futureCall(request);
   *   // Do something.
   *   LfpInventory response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertLfpInventoryRequest, LfpInventory> insertLfpInventoryCallable() {
    return stub.insertLfpInventoryCallable();
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
