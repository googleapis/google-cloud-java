/*
 * Copyright 2026 Google LLC
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
import com.google.cloud.discoveryengine.v1.stub.WidgetConfigServiceStub;
import com.google.cloud.discoveryengine.v1.stub.WidgetConfigServiceStubSettings;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing
 * [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig] configuration.
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
 * try (WidgetConfigServiceClient widgetConfigServiceClient = WidgetConfigServiceClient.create()) {
 *   WidgetConfigName name =
 *       WidgetConfigName.ofProjectLocationDataStoreWidgetConfigName(
 *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[WIDGET_CONFIG]");
 *   WidgetConfig response = widgetConfigServiceClient.getWidgetConfig(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the WidgetConfigServiceClient object to clean up resources
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
 *      <td><p> GetWidgetConfig</td>
 *      <td><p> Gets a [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getWidgetConfig(GetWidgetConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getWidgetConfig(WidgetConfigName name)
 *           <li><p> getWidgetConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getWidgetConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateWidgetConfig</td>
 *      <td><p> Update a WidgetConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateWidgetConfig(UpdateWidgetConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateWidgetConfig(WidgetConfig widgetConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateWidgetConfigCallable()
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
 * <p>This class can be customized by passing in a custom instance of WidgetConfigServiceSettings to
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
 * WidgetConfigServiceSettings widgetConfigServiceSettings =
 *     WidgetConfigServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * WidgetConfigServiceClient widgetConfigServiceClient =
 *     WidgetConfigServiceClient.create(widgetConfigServiceSettings);
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
 * WidgetConfigServiceSettings widgetConfigServiceSettings =
 *     WidgetConfigServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * WidgetConfigServiceClient widgetConfigServiceClient =
 *     WidgetConfigServiceClient.create(widgetConfigServiceSettings);
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
 * WidgetConfigServiceSettings widgetConfigServiceSettings =
 *     WidgetConfigServiceSettings.newHttpJsonBuilder().build();
 * WidgetConfigServiceClient widgetConfigServiceClient =
 *     WidgetConfigServiceClient.create(widgetConfigServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class WidgetConfigServiceClient implements BackgroundResource {
  private final @Nullable WidgetConfigServiceSettings settings;
  private final WidgetConfigServiceStub stub;

  /** Constructs an instance of WidgetConfigServiceClient with default settings. */
  public static final WidgetConfigServiceClient create() throws IOException {
    return create(WidgetConfigServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of WidgetConfigServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final WidgetConfigServiceClient create(WidgetConfigServiceSettings settings)
      throws IOException {
    return new WidgetConfigServiceClient(settings);
  }

  /**
   * Constructs an instance of WidgetConfigServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(WidgetConfigServiceSettings).
   */
  public static final WidgetConfigServiceClient create(WidgetConfigServiceStub stub) {
    return new WidgetConfigServiceClient(stub);
  }

  /**
   * Constructs an instance of WidgetConfigServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected WidgetConfigServiceClient(WidgetConfigServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((WidgetConfigServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected WidgetConfigServiceClient(WidgetConfigServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable WidgetConfigServiceSettings getSettings() {
    return settings;
  }

  public WidgetConfigServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WidgetConfigServiceClient widgetConfigServiceClient = WidgetConfigServiceClient.create()) {
   *   WidgetConfigName name =
   *       WidgetConfigName.ofProjectLocationDataStoreWidgetConfigName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[WIDGET_CONFIG]");
   *   WidgetConfig response = widgetConfigServiceClient.getWidgetConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Full WidgetConfig resource name. Format:
   *     `projects/{project}/locations/{location}/collections/{collection_id}/dataStores/{data_store_id}/widgetConfigs/{widget_config_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WidgetConfig getWidgetConfig(@Nullable WidgetConfigName name) {
    GetWidgetConfigRequest request =
        GetWidgetConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getWidgetConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WidgetConfigServiceClient widgetConfigServiceClient = WidgetConfigServiceClient.create()) {
   *   String name =
   *       WidgetConfigName.ofProjectLocationDataStoreWidgetConfigName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[WIDGET_CONFIG]")
   *           .toString();
   *   WidgetConfig response = widgetConfigServiceClient.getWidgetConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Full WidgetConfig resource name. Format:
   *     `projects/{project}/locations/{location}/collections/{collection_id}/dataStores/{data_store_id}/widgetConfigs/{widget_config_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WidgetConfig getWidgetConfig(String name) {
    GetWidgetConfigRequest request = GetWidgetConfigRequest.newBuilder().setName(name).build();
    return getWidgetConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WidgetConfigServiceClient widgetConfigServiceClient = WidgetConfigServiceClient.create()) {
   *   GetWidgetConfigRequest request =
   *       GetWidgetConfigRequest.newBuilder()
   *           .setName(
   *               WidgetConfigName.ofProjectLocationDataStoreWidgetConfigName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[WIDGET_CONFIG]")
   *                   .toString())
   *           .setAcceptCache(true)
   *           .setGetWidgetConfigRequestOption(
   *               GetWidgetConfigRequest.GetWidgetConfigRequestOption.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setModelInfoView(ModelInfoView.forNumber(0))
   *           .build();
   *   WidgetConfig response = widgetConfigServiceClient.getWidgetConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WidgetConfig getWidgetConfig(GetWidgetConfigRequest request) {
    return getWidgetConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WidgetConfigServiceClient widgetConfigServiceClient = WidgetConfigServiceClient.create()) {
   *   GetWidgetConfigRequest request =
   *       GetWidgetConfigRequest.newBuilder()
   *           .setName(
   *               WidgetConfigName.ofProjectLocationDataStoreWidgetConfigName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[WIDGET_CONFIG]")
   *                   .toString())
   *           .setAcceptCache(true)
   *           .setGetWidgetConfigRequestOption(
   *               GetWidgetConfigRequest.GetWidgetConfigRequestOption.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setModelInfoView(ModelInfoView.forNumber(0))
   *           .build();
   *   ApiFuture<WidgetConfig> future =
   *       widgetConfigServiceClient.getWidgetConfigCallable().futureCall(request);
   *   // Do something.
   *   WidgetConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWidgetConfigRequest, WidgetConfig> getWidgetConfigCallable() {
    return stub.getWidgetConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a WidgetConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WidgetConfigServiceClient widgetConfigServiceClient = WidgetConfigServiceClient.create()) {
   *   WidgetConfig widgetConfig = WidgetConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   WidgetConfig response =
   *       widgetConfigServiceClient.updateWidgetConfig(widgetConfig, updateMask);
   * }
   * }</pre>
   *
   * @param widgetConfig Required. The [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig]
   *     to update.
   *     <p>If the caller does not have permission to update the
   *     [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig], then a PERMISSION_DENIED
   *     error is returned.
   *     <p>If the [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig] to update does not
   *     exist, a NOT_FOUND error is returned.
   * @param updateMask Indicates which fields in the provided
   *     [WidgetConfig][google.cloud.discoveryengine.v1.WidgetConfig] to update. The following are
   *     the only supported fields:
   *     <ul>
   *       <li>[WidgetConfig.enable_autocomplete][google.cloud.discoveryengine.v1.WidgetConfig.enable_autocomplete]
   *     </ul>
   *     <p>If not set, all supported fields are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WidgetConfig updateWidgetConfig(WidgetConfig widgetConfig, FieldMask updateMask) {
    UpdateWidgetConfigRequest request =
        UpdateWidgetConfigRequest.newBuilder()
            .setWidgetConfig(widgetConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateWidgetConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a WidgetConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WidgetConfigServiceClient widgetConfigServiceClient = WidgetConfigServiceClient.create()) {
   *   UpdateWidgetConfigRequest request =
   *       UpdateWidgetConfigRequest.newBuilder()
   *           .setWidgetConfig(WidgetConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   WidgetConfig response = widgetConfigServiceClient.updateWidgetConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WidgetConfig updateWidgetConfig(UpdateWidgetConfigRequest request) {
    return updateWidgetConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a WidgetConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WidgetConfigServiceClient widgetConfigServiceClient = WidgetConfigServiceClient.create()) {
   *   UpdateWidgetConfigRequest request =
   *       UpdateWidgetConfigRequest.newBuilder()
   *           .setWidgetConfig(WidgetConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<WidgetConfig> future =
   *       widgetConfigServiceClient.updateWidgetConfigCallable().futureCall(request);
   *   // Do something.
   *   WidgetConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateWidgetConfigRequest, WidgetConfig> updateWidgetConfigCallable() {
    return stub.updateWidgetConfigCallable();
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
