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

package com.google.api.servicecontrol.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.servicecontrol.v1.stub.QuotaControllerStub;
import com.google.api.servicecontrol.v1.stub.QuotaControllerStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: [Google Quota Control API](/service-control/overview)
 *
 * <p>Allows clients to allocate and release quota against a [managed
 * service](https://cloud.google.com/service-management/reference/rpc/google.api/servicemanagement.v1#google.api.servicemanagement.v1.ManagedService).
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
 * try (QuotaControllerClient quotaControllerClient = QuotaControllerClient.create()) {
 *   AllocateQuotaRequest request =
 *       AllocateQuotaRequest.newBuilder()
 *           .setServiceName("serviceName-1928572192")
 *           .setAllocateOperation(QuotaOperation.newBuilder().build())
 *           .setServiceConfigId("serviceConfigId650537426")
 *           .build();
 *   AllocateQuotaResponse response = quotaControllerClient.allocateQuota(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the QuotaControllerClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of QuotaControllerSettings to
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
 * QuotaControllerSettings quotaControllerSettings =
 *     QuotaControllerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * QuotaControllerClient quotaControllerClient =
 *     QuotaControllerClient.create(quotaControllerSettings);
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
 * QuotaControllerSettings quotaControllerSettings =
 *     QuotaControllerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * QuotaControllerClient quotaControllerClient =
 *     QuotaControllerClient.create(quotaControllerSettings);
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
 * QuotaControllerSettings quotaControllerSettings =
 *     QuotaControllerSettings.newHttpJsonBuilder().build();
 * QuotaControllerClient quotaControllerClient =
 *     QuotaControllerClient.create(quotaControllerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class QuotaControllerClient implements BackgroundResource {
  private final QuotaControllerSettings settings;
  private final QuotaControllerStub stub;

  /** Constructs an instance of QuotaControllerClient with default settings. */
  public static final QuotaControllerClient create() throws IOException {
    return create(QuotaControllerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of QuotaControllerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final QuotaControllerClient create(QuotaControllerSettings settings)
      throws IOException {
    return new QuotaControllerClient(settings);
  }

  /**
   * Constructs an instance of QuotaControllerClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(QuotaControllerSettings).
   */
  public static final QuotaControllerClient create(QuotaControllerStub stub) {
    return new QuotaControllerClient(stub);
  }

  /**
   * Constructs an instance of QuotaControllerClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected QuotaControllerClient(QuotaControllerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((QuotaControllerStubSettings) settings.getStubSettings()).createStub();
  }

  protected QuotaControllerClient(QuotaControllerStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final QuotaControllerSettings getSettings() {
    return settings;
  }

  public QuotaControllerStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attempts to allocate quota for the specified consumer. It should be called before the operation
   * is executed.
   *
   * <p>This method requires the `servicemanagement.services.quota` permission on the specified
   * service. For more information, see [Cloud IAM](https://cloud.google.com/iam).
   *
   * <p>&#42;&#42;NOTE:&#42;&#42; The client &#42;&#42;must&#42;&#42; fail-open on server errors
   * `INTERNAL`, `UNKNOWN`, `DEADLINE_EXCEEDED`, and `UNAVAILABLE`. To ensure system reliability,
   * the server may inject these errors to prohibit any hard dependency on the quota functionality.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (QuotaControllerClient quotaControllerClient = QuotaControllerClient.create()) {
   *   AllocateQuotaRequest request =
   *       AllocateQuotaRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setAllocateOperation(QuotaOperation.newBuilder().build())
   *           .setServiceConfigId("serviceConfigId650537426")
   *           .build();
   *   AllocateQuotaResponse response = quotaControllerClient.allocateQuota(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AllocateQuotaResponse allocateQuota(AllocateQuotaRequest request) {
    return allocateQuotaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Attempts to allocate quota for the specified consumer. It should be called before the operation
   * is executed.
   *
   * <p>This method requires the `servicemanagement.services.quota` permission on the specified
   * service. For more information, see [Cloud IAM](https://cloud.google.com/iam).
   *
   * <p>&#42;&#42;NOTE:&#42;&#42; The client &#42;&#42;must&#42;&#42; fail-open on server errors
   * `INTERNAL`, `UNKNOWN`, `DEADLINE_EXCEEDED`, and `UNAVAILABLE`. To ensure system reliability,
   * the server may inject these errors to prohibit any hard dependency on the quota functionality.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (QuotaControllerClient quotaControllerClient = QuotaControllerClient.create()) {
   *   AllocateQuotaRequest request =
   *       AllocateQuotaRequest.newBuilder()
   *           .setServiceName("serviceName-1928572192")
   *           .setAllocateOperation(QuotaOperation.newBuilder().build())
   *           .setServiceConfigId("serviceConfigId650537426")
   *           .build();
   *   ApiFuture<AllocateQuotaResponse> future =
   *       quotaControllerClient.allocateQuotaCallable().futureCall(request);
   *   // Do something.
   *   AllocateQuotaResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AllocateQuotaRequest, AllocateQuotaResponse> allocateQuotaCallable() {
    return stub.allocateQuotaCallable();
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
