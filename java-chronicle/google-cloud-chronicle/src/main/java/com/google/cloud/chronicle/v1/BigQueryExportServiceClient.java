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

package com.google.cloud.chronicle.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.stub.BigQueryExportServiceStub;
import com.google.cloud.chronicle.v1.stub.BigQueryExportServiceStubSettings;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing BigQuery export configurations for Chronicle instances.
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
 * try (BigQueryExportServiceClient bigQueryExportServiceClient =
 *     BigQueryExportServiceClient.create()) {
 *   BigQueryExportName name = BigQueryExportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   BigQueryExport response = bigQueryExportServiceClient.getBigQueryExport(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BigQueryExportServiceClient object to clean up
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
 *      <td><p> GetBigQueryExport</td>
 *      <td><p> Get the BigQuery export configuration for a Chronicle instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBigQueryExport(GetBigQueryExportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBigQueryExport(BigQueryExportName name)
 *           <li><p> getBigQueryExport(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBigQueryExportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBigQueryExport</td>
 *      <td><p> Update the BigQuery export configuration for a Chronicle instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBigQueryExport(UpdateBigQueryExportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateBigQueryExport(BigQueryExport bigQueryExport, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBigQueryExportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ProvisionBigQueryExport</td>
 *      <td><p> Provision the BigQuery export for a Chronicle instance. This will create {{gcp_name}} resources like {{storage_name}} buckets, BigQuery datasets and set default export settings for each data source.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> provisionBigQueryExport(ProvisionBigQueryExportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> provisionBigQueryExport(InstanceName parent)
 *           <li><p> provisionBigQueryExport(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> provisionBigQueryExportCallable()
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
 * <p>This class can be customized by passing in a custom instance of BigQueryExportServiceSettings
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
 * BigQueryExportServiceSettings bigQueryExportServiceSettings =
 *     BigQueryExportServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BigQueryExportServiceClient bigQueryExportServiceClient =
 *     BigQueryExportServiceClient.create(bigQueryExportServiceSettings);
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
 * BigQueryExportServiceSettings bigQueryExportServiceSettings =
 *     BigQueryExportServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BigQueryExportServiceClient bigQueryExportServiceClient =
 *     BigQueryExportServiceClient.create(bigQueryExportServiceSettings);
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
 * BigQueryExportServiceSettings bigQueryExportServiceSettings =
 *     BigQueryExportServiceSettings.newHttpJsonBuilder().build();
 * BigQueryExportServiceClient bigQueryExportServiceClient =
 *     BigQueryExportServiceClient.create(bigQueryExportServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class BigQueryExportServiceClient implements BackgroundResource {
  private final @Nullable BigQueryExportServiceSettings settings;
  private final BigQueryExportServiceStub stub;

  /** Constructs an instance of BigQueryExportServiceClient with default settings. */
  public static final BigQueryExportServiceClient create() throws IOException {
    return create(BigQueryExportServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BigQueryExportServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BigQueryExportServiceClient create(BigQueryExportServiceSettings settings)
      throws IOException {
    return new BigQueryExportServiceClient(settings);
  }

  /**
   * Constructs an instance of BigQueryExportServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(BigQueryExportServiceSettings).
   */
  public static final BigQueryExportServiceClient create(BigQueryExportServiceStub stub) {
    return new BigQueryExportServiceClient(stub);
  }

  /**
   * Constructs an instance of BigQueryExportServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected BigQueryExportServiceClient(BigQueryExportServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BigQueryExportServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected BigQueryExportServiceClient(BigQueryExportServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable BigQueryExportServiceSettings getSettings() {
    return settings;
  }

  public BigQueryExportServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the BigQuery export configuration for a Chronicle instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BigQueryExportServiceClient bigQueryExportServiceClient =
   *     BigQueryExportServiceClient.create()) {
   *   BigQueryExportName name = BigQueryExportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   BigQueryExport response = bigQueryExportServiceClient.getBigQueryExport(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the BigqueryExport to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/bigQueryExport
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport getBigQueryExport(@Nullable BigQueryExportName name) {
    GetBigQueryExportRequest request =
        GetBigQueryExportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getBigQueryExport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the BigQuery export configuration for a Chronicle instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BigQueryExportServiceClient bigQueryExportServiceClient =
   *     BigQueryExportServiceClient.create()) {
   *   String name = BigQueryExportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   BigQueryExport response = bigQueryExportServiceClient.getBigQueryExport(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the BigqueryExport to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/bigQueryExport
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport getBigQueryExport(String name) {
    GetBigQueryExportRequest request = GetBigQueryExportRequest.newBuilder().setName(name).build();
    return getBigQueryExport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the BigQuery export configuration for a Chronicle instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BigQueryExportServiceClient bigQueryExportServiceClient =
   *     BigQueryExportServiceClient.create()) {
   *   GetBigQueryExportRequest request =
   *       GetBigQueryExportRequest.newBuilder()
   *           .setName(BigQueryExportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   BigQueryExport response = bigQueryExportServiceClient.getBigQueryExport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport getBigQueryExport(GetBigQueryExportRequest request) {
    return getBigQueryExportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the BigQuery export configuration for a Chronicle instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BigQueryExportServiceClient bigQueryExportServiceClient =
   *     BigQueryExportServiceClient.create()) {
   *   GetBigQueryExportRequest request =
   *       GetBigQueryExportRequest.newBuilder()
   *           .setName(BigQueryExportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<BigQueryExport> future =
   *       bigQueryExportServiceClient.getBigQueryExportCallable().futureCall(request);
   *   // Do something.
   *   BigQueryExport response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBigQueryExportRequest, BigQueryExport> getBigQueryExportCallable() {
    return stub.getBigQueryExportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the BigQuery export configuration for a Chronicle instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BigQueryExportServiceClient bigQueryExportServiceClient =
   *     BigQueryExportServiceClient.create()) {
   *   BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BigQueryExport response =
   *       bigQueryExportServiceClient.updateBigQueryExport(bigQueryExport, updateMask);
   * }
   * }</pre>
   *
   * @param bigQueryExport Required. The BigQueryExport settings to update. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/bigQueryExport
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport updateBigQueryExport(
      BigQueryExport bigQueryExport, FieldMask updateMask) {
    UpdateBigQueryExportRequest request =
        UpdateBigQueryExportRequest.newBuilder()
            .setBigQueryExport(bigQueryExport)
            .setUpdateMask(updateMask)
            .build();
    return updateBigQueryExport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the BigQuery export configuration for a Chronicle instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BigQueryExportServiceClient bigQueryExportServiceClient =
   *     BigQueryExportServiceClient.create()) {
   *   UpdateBigQueryExportRequest request =
   *       UpdateBigQueryExportRequest.newBuilder()
   *           .setBigQueryExport(BigQueryExport.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   BigQueryExport response = bigQueryExportServiceClient.updateBigQueryExport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport updateBigQueryExport(UpdateBigQueryExportRequest request) {
    return updateBigQueryExportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the BigQuery export configuration for a Chronicle instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BigQueryExportServiceClient bigQueryExportServiceClient =
   *     BigQueryExportServiceClient.create()) {
   *   UpdateBigQueryExportRequest request =
   *       UpdateBigQueryExportRequest.newBuilder()
   *           .setBigQueryExport(BigQueryExport.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<BigQueryExport> future =
   *       bigQueryExportServiceClient.updateBigQueryExportCallable().futureCall(request);
   *   // Do something.
   *   BigQueryExport response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBigQueryExportRequest, BigQueryExport>
      updateBigQueryExportCallable() {
    return stub.updateBigQueryExportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provision the BigQuery export for a Chronicle instance. This will create {{gcp_name}} resources
   * like {{storage_name}} buckets, BigQuery datasets and set default export settings for each data
   * source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BigQueryExportServiceClient bigQueryExportServiceClient =
   *     BigQueryExportServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   BigQueryExport response = bigQueryExportServiceClient.provisionBigQueryExport(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The instance for which BigQuery export is being provisioned. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport provisionBigQueryExport(@Nullable InstanceName parent) {
    ProvisionBigQueryExportRequest request =
        ProvisionBigQueryExportRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return provisionBigQueryExport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provision the BigQuery export for a Chronicle instance. This will create {{gcp_name}} resources
   * like {{storage_name}} buckets, BigQuery datasets and set default export settings for each data
   * source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BigQueryExportServiceClient bigQueryExportServiceClient =
   *     BigQueryExportServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   BigQueryExport response = bigQueryExportServiceClient.provisionBigQueryExport(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The instance for which BigQuery export is being provisioned. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport provisionBigQueryExport(String parent) {
    ProvisionBigQueryExportRequest request =
        ProvisionBigQueryExportRequest.newBuilder().setParent(parent).build();
    return provisionBigQueryExport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provision the BigQuery export for a Chronicle instance. This will create {{gcp_name}} resources
   * like {{storage_name}} buckets, BigQuery datasets and set default export settings for each data
   * source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BigQueryExportServiceClient bigQueryExportServiceClient =
   *     BigQueryExportServiceClient.create()) {
   *   ProvisionBigQueryExportRequest request =
   *       ProvisionBigQueryExportRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   BigQueryExport response = bigQueryExportServiceClient.provisionBigQueryExport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BigQueryExport provisionBigQueryExport(ProvisionBigQueryExportRequest request) {
    return provisionBigQueryExportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provision the BigQuery export for a Chronicle instance. This will create {{gcp_name}} resources
   * like {{storage_name}} buckets, BigQuery datasets and set default export settings for each data
   * source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BigQueryExportServiceClient bigQueryExportServiceClient =
   *     BigQueryExportServiceClient.create()) {
   *   ProvisionBigQueryExportRequest request =
   *       ProvisionBigQueryExportRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<BigQueryExport> future =
   *       bigQueryExportServiceClient.provisionBigQueryExportCallable().futureCall(request);
   *   // Do something.
   *   BigQueryExport response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ProvisionBigQueryExportRequest, BigQueryExport>
      provisionBigQueryExportCallable() {
    return stub.provisionBigQueryExportCallable();
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
