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

package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.RegionInstancesStub;
import com.google.cloud.compute.v1.stub.RegionInstancesStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionInstances API.
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
 * try (RegionInstancesClient regionInstancesClient = RegionInstancesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   BulkInsertInstanceResource bulkInsertInstanceResourceResource =
 *       BulkInsertInstanceResource.newBuilder().build();
 *   Operation response =
 *       regionInstancesClient
 *           .bulkInsertAsync(project, region, bulkInsertInstanceResourceResource)
 *           .get();
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionInstancesClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of RegionInstancesSettings to
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
 * RegionInstancesSettings regionInstancesSettings =
 *     RegionInstancesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionInstancesClient regionInstancesClient =
 *     RegionInstancesClient.create(regionInstancesSettings);
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
 * RegionInstancesSettings regionInstancesSettings =
 *     RegionInstancesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionInstancesClient regionInstancesClient =
 *     RegionInstancesClient.create(regionInstancesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionInstancesClient implements BackgroundResource {
  private final RegionInstancesSettings settings;
  private final RegionInstancesStub stub;

  /** Constructs an instance of RegionInstancesClient with default settings. */
  public static final RegionInstancesClient create() throws IOException {
    return create(RegionInstancesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionInstancesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionInstancesClient create(RegionInstancesSettings settings)
      throws IOException {
    return new RegionInstancesClient(settings);
  }

  /**
   * Constructs an instance of RegionInstancesClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(RegionInstancesSettings).
   */
  public static final RegionInstancesClient create(RegionInstancesStub stub) {
    return new RegionInstancesClient(stub);
  }

  /**
   * Constructs an instance of RegionInstancesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected RegionInstancesClient(RegionInstancesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionInstancesStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionInstancesClient(RegionInstancesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionInstancesSettings getSettings() {
    return settings;
  }

  public RegionInstancesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates multiple instances in a given region. Count specifies the number of instances to
   * create.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstancesClient regionInstancesClient = RegionInstancesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   BulkInsertInstanceResource bulkInsertInstanceResourceResource =
   *       BulkInsertInstanceResource.newBuilder().build();
   *   Operation response =
   *       regionInstancesClient
   *           .bulkInsertAsync(project, region, bulkInsertInstanceResourceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param bulkInsertInstanceResourceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> bulkInsertAsync(
      String project,
      String region,
      BulkInsertInstanceResource bulkInsertInstanceResourceResource) {
    BulkInsertRegionInstanceRequest request =
        BulkInsertRegionInstanceRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setBulkInsertInstanceResourceResource(bulkInsertInstanceResourceResource)
            .build();
    return bulkInsertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates multiple instances in a given region. Count specifies the number of instances to
   * create.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstancesClient regionInstancesClient = RegionInstancesClient.create()) {
   *   BulkInsertRegionInstanceRequest request =
   *       BulkInsertRegionInstanceRequest.newBuilder()
   *           .setBulkInsertInstanceResourceResource(
   *               BulkInsertInstanceResource.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionInstancesClient.bulkInsertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> bulkInsertAsync(
      BulkInsertRegionInstanceRequest request) {
    return bulkInsertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates multiple instances in a given region. Count specifies the number of instances to
   * create.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstancesClient regionInstancesClient = RegionInstancesClient.create()) {
   *   BulkInsertRegionInstanceRequest request =
   *       BulkInsertRegionInstanceRequest.newBuilder()
   *           .setBulkInsertInstanceResourceResource(
   *               BulkInsertInstanceResource.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionInstancesClient.bulkInsertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<BulkInsertRegionInstanceRequest, Operation, Operation>
      bulkInsertOperationCallable() {
    return stub.bulkInsertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates multiple instances in a given region. Count specifies the number of instances to
   * create.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstancesClient regionInstancesClient = RegionInstancesClient.create()) {
   *   BulkInsertRegionInstanceRequest request =
   *       BulkInsertRegionInstanceRequest.newBuilder()
   *           .setBulkInsertInstanceResourceResource(
   *               BulkInsertInstanceResource.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = regionInstancesClient.bulkInsertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BulkInsertRegionInstanceRequest, Operation> bulkInsertCallable() {
    return stub.bulkInsertCallable();
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
