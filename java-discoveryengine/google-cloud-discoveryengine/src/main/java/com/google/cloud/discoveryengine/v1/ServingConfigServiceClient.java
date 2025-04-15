/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.discoveryengine.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.stub.ServingConfigServiceStub;
import com.google.cloud.discoveryengine.v1.stub.ServingConfigServiceStubSettings;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for operations related to
 * [ServingConfig][google.cloud.discoveryengine.v1.ServingConfig].
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
 * try (ServingConfigServiceClient servingConfigServiceClient =
 *     ServingConfigServiceClient.create()) {
 *   ServingConfig servingConfig = ServingConfig.newBuilder().build();
 *   FieldMask updateMask = FieldMask.newBuilder().build();
 *   ServingConfig response =
 *       servingConfigServiceClient.updateServingConfig(servingConfig, updateMask);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ServingConfigServiceClient object to clean up
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
 *      <td><p> UpdateServingConfig</td>
 *      <td><p> Updates a ServingConfig.
 * <p>  Returns a NOT_FOUND error if the ServingConfig does not exist.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateServingConfig(UpdateServingConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateServingConfig(ServingConfig servingConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateServingConfigCallable()
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
 * <p>This class can be customized by passing in a custom instance of ServingConfigServiceSettings
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
 * ServingConfigServiceSettings servingConfigServiceSettings =
 *     ServingConfigServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ServingConfigServiceClient servingConfigServiceClient =
 *     ServingConfigServiceClient.create(servingConfigServiceSettings);
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
 * ServingConfigServiceSettings servingConfigServiceSettings =
 *     ServingConfigServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ServingConfigServiceClient servingConfigServiceClient =
 *     ServingConfigServiceClient.create(servingConfigServiceSettings);
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
 * ServingConfigServiceSettings servingConfigServiceSettings =
 *     ServingConfigServiceSettings.newHttpJsonBuilder().build();
 * ServingConfigServiceClient servingConfigServiceClient =
 *     ServingConfigServiceClient.create(servingConfigServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ServingConfigServiceClient implements BackgroundResource {
  private final ServingConfigServiceSettings settings;
  private final ServingConfigServiceStub stub;

  /** Constructs an instance of ServingConfigServiceClient with default settings. */
  public static final ServingConfigServiceClient create() throws IOException {
    return create(ServingConfigServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ServingConfigServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ServingConfigServiceClient create(ServingConfigServiceSettings settings)
      throws IOException {
    return new ServingConfigServiceClient(settings);
  }

  /**
   * Constructs an instance of ServingConfigServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ServingConfigServiceSettings).
   */
  public static final ServingConfigServiceClient create(ServingConfigServiceStub stub) {
    return new ServingConfigServiceClient(stub);
  }

  /**
   * Constructs an instance of ServingConfigServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ServingConfigServiceClient(ServingConfigServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ServingConfigServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ServingConfigServiceClient(ServingConfigServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ServingConfigServiceSettings getSettings() {
    return settings;
  }

  public ServingConfigServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ServingConfig.
   *
   * <p>Returns a NOT_FOUND error if the ServingConfig does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   ServingConfig servingConfig = ServingConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ServingConfig response =
   *       servingConfigServiceClient.updateServingConfig(servingConfig, updateMask);
   * }
   * }</pre>
   *
   * @param servingConfig Required. The ServingConfig to update.
   * @param updateMask Indicates which fields in the provided
   *     [ServingConfig][google.cloud.discoveryengine.v1.ServingConfig] to update. The following are
   *     NOT supported:
   *     <ul>
   *       <li>[ServingConfig.name][google.cloud.discoveryengine.v1.ServingConfig.name]
   *     </ul>
   *     <p>If not set, all supported fields are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServingConfig updateServingConfig(
      ServingConfig servingConfig, FieldMask updateMask) {
    UpdateServingConfigRequest request =
        UpdateServingConfigRequest.newBuilder()
            .setServingConfig(servingConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateServingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ServingConfig.
   *
   * <p>Returns a NOT_FOUND error if the ServingConfig does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   UpdateServingConfigRequest request =
   *       UpdateServingConfigRequest.newBuilder()
   *           .setServingConfig(ServingConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ServingConfig response = servingConfigServiceClient.updateServingConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServingConfig updateServingConfig(UpdateServingConfigRequest request) {
    return updateServingConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ServingConfig.
   *
   * <p>Returns a NOT_FOUND error if the ServingConfig does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServingConfigServiceClient servingConfigServiceClient =
   *     ServingConfigServiceClient.create()) {
   *   UpdateServingConfigRequest request =
   *       UpdateServingConfigRequest.newBuilder()
   *           .setServingConfig(ServingConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ServingConfig> future =
   *       servingConfigServiceClient.updateServingConfigCallable().futureCall(request);
   *   // Do something.
   *   ServingConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateServingConfigRequest, ServingConfig>
      updateServingConfigCallable() {
    return stub.updateServingConfigCallable();
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
