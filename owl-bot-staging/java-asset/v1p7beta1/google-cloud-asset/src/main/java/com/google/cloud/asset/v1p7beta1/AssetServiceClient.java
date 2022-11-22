/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.asset.v1p7beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.asset.v1p7beta1.stub.AssetServiceStub;
import com.google.cloud.asset.v1p7beta1.stub.AssetServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Asset service definition.
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
 * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
 *   ExportAssetsRequest request =
 *       ExportAssetsRequest.newBuilder()
 *           .setParent("ExportAssetsRequest-846449128".toString())
 *           .setReadTime(Timestamp.newBuilder().build())
 *           .addAllAssetTypes(new ArrayList<String>())
 *           .setContentType(ContentType.forNumber(0))
 *           .setOutputConfig(OutputConfig.newBuilder().build())
 *           .addAllRelationshipTypes(new ArrayList<String>())
 *           .build();
 *   ExportAssetsResponse response = assetServiceClient.exportAssetsAsync(request).get();
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AssetServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of AssetServiceSettings to
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
 * AssetServiceSettings assetServiceSettings =
 *     AssetServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AssetServiceClient assetServiceClient = AssetServiceClient.create(assetServiceSettings);
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
 * AssetServiceSettings assetServiceSettings =
 *     AssetServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AssetServiceClient assetServiceClient = AssetServiceClient.create(assetServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AssetServiceClient implements BackgroundResource {
  private final AssetServiceSettings settings;
  private final AssetServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of AssetServiceClient with default settings. */
  public static final AssetServiceClient create() throws IOException {
    return create(AssetServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AssetServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AssetServiceClient create(AssetServiceSettings settings) throws IOException {
    return new AssetServiceClient(settings);
  }

  /**
   * Constructs an instance of AssetServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(AssetServiceSettings).
   */
  public static final AssetServiceClient create(AssetServiceStub stub) {
    return new AssetServiceClient(stub);
  }

  /**
   * Constructs an instance of AssetServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AssetServiceClient(AssetServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AssetServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected AssetServiceClient(AssetServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final AssetServiceSettings getSettings() {
    return settings;
  }

  public AssetServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports assets with time and resource types to a given Cloud Storage location/BigQuery table.
   * For Cloud Storage location destinations, the output format is newline-delimited JSON. Each line
   * represents a [google.cloud.asset.v1p7beta1.Asset][google.cloud.asset.v1p7beta1.Asset] in the
   * JSON format; for BigQuery table destinations, the output table stores the fields in asset proto
   * as columns. This API implements the
   * [google.longrunning.Operation][google.longrunning.Operation] API , which allows you to keep
   * track of the export. We recommend intervals of at least 2 seconds with exponential retry to
   * poll the export operation result. For regular-size resource parent, the export operation
   * usually finishes within 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   ExportAssetsRequest request =
   *       ExportAssetsRequest.newBuilder()
   *           .setParent("ExportAssetsRequest-846449128".toString())
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .addAllAssetTypes(new ArrayList<String>())
   *           .setContentType(ContentType.forNumber(0))
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .addAllRelationshipTypes(new ArrayList<String>())
   *           .build();
   *   ExportAssetsResponse response = assetServiceClient.exportAssetsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportAssetsResponse, ExportAssetsRequest> exportAssetsAsync(
      ExportAssetsRequest request) {
    return exportAssetsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports assets with time and resource types to a given Cloud Storage location/BigQuery table.
   * For Cloud Storage location destinations, the output format is newline-delimited JSON. Each line
   * represents a [google.cloud.asset.v1p7beta1.Asset][google.cloud.asset.v1p7beta1.Asset] in the
   * JSON format; for BigQuery table destinations, the output table stores the fields in asset proto
   * as columns. This API implements the
   * [google.longrunning.Operation][google.longrunning.Operation] API , which allows you to keep
   * track of the export. We recommend intervals of at least 2 seconds with exponential retry to
   * poll the export operation result. For regular-size resource parent, the export operation
   * usually finishes within 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   ExportAssetsRequest request =
   *       ExportAssetsRequest.newBuilder()
   *           .setParent("ExportAssetsRequest-846449128".toString())
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .addAllAssetTypes(new ArrayList<String>())
   *           .setContentType(ContentType.forNumber(0))
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .addAllRelationshipTypes(new ArrayList<String>())
   *           .build();
   *   OperationFuture<ExportAssetsResponse, ExportAssetsRequest> future =
   *       assetServiceClient.exportAssetsOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportAssetsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ExportAssetsRequest, ExportAssetsResponse, ExportAssetsRequest>
      exportAssetsOperationCallable() {
    return stub.exportAssetsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports assets with time and resource types to a given Cloud Storage location/BigQuery table.
   * For Cloud Storage location destinations, the output format is newline-delimited JSON. Each line
   * represents a [google.cloud.asset.v1p7beta1.Asset][google.cloud.asset.v1p7beta1.Asset] in the
   * JSON format; for BigQuery table destinations, the output table stores the fields in asset proto
   * as columns. This API implements the
   * [google.longrunning.Operation][google.longrunning.Operation] API , which allows you to keep
   * track of the export. We recommend intervals of at least 2 seconds with exponential retry to
   * poll the export operation result. For regular-size resource parent, the export operation
   * usually finishes within 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   ExportAssetsRequest request =
   *       ExportAssetsRequest.newBuilder()
   *           .setParent("ExportAssetsRequest-846449128".toString())
   *           .setReadTime(Timestamp.newBuilder().build())
   *           .addAllAssetTypes(new ArrayList<String>())
   *           .setContentType(ContentType.forNumber(0))
   *           .setOutputConfig(OutputConfig.newBuilder().build())
   *           .addAllRelationshipTypes(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future = assetServiceClient.exportAssetsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportAssetsRequest, Operation> exportAssetsCallable() {
    return stub.exportAssetsCallable();
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
