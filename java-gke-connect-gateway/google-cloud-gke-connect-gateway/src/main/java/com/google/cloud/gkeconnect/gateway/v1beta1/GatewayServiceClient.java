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

package com.google.cloud.gkeconnect.gateway.v1beta1;

import com.google.api.HttpBody;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkeconnect.gateway.v1beta1.stub.GatewayServiceStub;
import com.google.cloud.gkeconnect.gateway.v1beta1.stub.GatewayServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Gateway service is a public API which works as a Kubernetes resource model
 * proxy between end users and registered Kubernetes clusters. Each RPC in this service matches with
 * an HTTP verb. End user will initiate kubectl commands against the Gateway service, and Gateway
 * service will forward user requests to clusters.
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
 * try (GatewayServiceClient gatewayServiceClient = GatewayServiceClient.create()) {
 *   HttpBody request =
 *       HttpBody.newBuilder()
 *           .setContentType("contentType-389131437")
 *           .setData(ByteString.EMPTY)
 *           .addAllExtensions(new ArrayList<Any>())
 *           .build();
 *   HttpBody response = gatewayServiceClient.getResource(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GatewayServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of GatewayServiceSettings to
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
 * GatewayServiceSettings gatewayServiceSettings =
 *     GatewayServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GatewayServiceClient gatewayServiceClient = GatewayServiceClient.create(gatewayServiceSettings);
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
 * GatewayServiceSettings gatewayServiceSettings =
 *     GatewayServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GatewayServiceClient gatewayServiceClient = GatewayServiceClient.create(gatewayServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GatewayServiceClient implements BackgroundResource {
  private final GatewayServiceSettings settings;
  private final GatewayServiceStub stub;

  /** Constructs an instance of GatewayServiceClient with default settings. */
  public static final GatewayServiceClient create() throws IOException {
    return create(GatewayServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GatewayServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GatewayServiceClient create(GatewayServiceSettings settings)
      throws IOException {
    return new GatewayServiceClient(settings);
  }

  /**
   * Constructs an instance of GatewayServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(GatewayServiceSettings).
   */
  public static final GatewayServiceClient create(GatewayServiceStub stub) {
    return new GatewayServiceClient(stub);
  }

  /**
   * Constructs an instance of GatewayServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GatewayServiceClient(GatewayServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GatewayServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected GatewayServiceClient(GatewayServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GatewayServiceSettings getSettings() {
    return settings;
  }

  public GatewayServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GetResource performs an HTTP GET request on the Kubernetes API Server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GatewayServiceClient gatewayServiceClient = GatewayServiceClient.create()) {
   *   HttpBody request =
   *       HttpBody.newBuilder()
   *           .setContentType("contentType-389131437")
   *           .setData(ByteString.EMPTY)
   *           .addAllExtensions(new ArrayList<Any>())
   *           .build();
   *   HttpBody response = gatewayServiceClient.getResource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody getResource(HttpBody request) {
    return getResourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GetResource performs an HTTP GET request on the Kubernetes API Server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GatewayServiceClient gatewayServiceClient = GatewayServiceClient.create()) {
   *   HttpBody request =
   *       HttpBody.newBuilder()
   *           .setContentType("contentType-389131437")
   *           .setData(ByteString.EMPTY)
   *           .addAllExtensions(new ArrayList<Any>())
   *           .build();
   *   ApiFuture<HttpBody> future = gatewayServiceClient.getResourceCallable().futureCall(request);
   *   // Do something.
   *   HttpBody response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<HttpBody, HttpBody> getResourceCallable() {
    return stub.getResourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * PostResource performs an HTTP POST on the Kubernetes API Server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GatewayServiceClient gatewayServiceClient = GatewayServiceClient.create()) {
   *   HttpBody request =
   *       HttpBody.newBuilder()
   *           .setContentType("contentType-389131437")
   *           .setData(ByteString.EMPTY)
   *           .addAllExtensions(new ArrayList<Any>())
   *           .build();
   *   HttpBody response = gatewayServiceClient.postResource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody postResource(HttpBody request) {
    return postResourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * PostResource performs an HTTP POST on the Kubernetes API Server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GatewayServiceClient gatewayServiceClient = GatewayServiceClient.create()) {
   *   HttpBody request =
   *       HttpBody.newBuilder()
   *           .setContentType("contentType-389131437")
   *           .setData(ByteString.EMPTY)
   *           .addAllExtensions(new ArrayList<Any>())
   *           .build();
   *   ApiFuture<HttpBody> future = gatewayServiceClient.postResourceCallable().futureCall(request);
   *   // Do something.
   *   HttpBody response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<HttpBody, HttpBody> postResourceCallable() {
    return stub.postResourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * DeleteResource performs an HTTP DELETE on the Kubernetes API Server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GatewayServiceClient gatewayServiceClient = GatewayServiceClient.create()) {
   *   HttpBody request =
   *       HttpBody.newBuilder()
   *           .setContentType("contentType-389131437")
   *           .setData(ByteString.EMPTY)
   *           .addAllExtensions(new ArrayList<Any>())
   *           .build();
   *   HttpBody response = gatewayServiceClient.deleteResource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody deleteResource(HttpBody request) {
    return deleteResourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * DeleteResource performs an HTTP DELETE on the Kubernetes API Server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GatewayServiceClient gatewayServiceClient = GatewayServiceClient.create()) {
   *   HttpBody request =
   *       HttpBody.newBuilder()
   *           .setContentType("contentType-389131437")
   *           .setData(ByteString.EMPTY)
   *           .addAllExtensions(new ArrayList<Any>())
   *           .build();
   *   ApiFuture<HttpBody> future =
   *       gatewayServiceClient.deleteResourceCallable().futureCall(request);
   *   // Do something.
   *   HttpBody response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<HttpBody, HttpBody> deleteResourceCallable() {
    return stub.deleteResourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * PutResource performs an HTTP PUT on the Kubernetes API Server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GatewayServiceClient gatewayServiceClient = GatewayServiceClient.create()) {
   *   HttpBody request =
   *       HttpBody.newBuilder()
   *           .setContentType("contentType-389131437")
   *           .setData(ByteString.EMPTY)
   *           .addAllExtensions(new ArrayList<Any>())
   *           .build();
   *   HttpBody response = gatewayServiceClient.putResource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody putResource(HttpBody request) {
    return putResourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * PutResource performs an HTTP PUT on the Kubernetes API Server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GatewayServiceClient gatewayServiceClient = GatewayServiceClient.create()) {
   *   HttpBody request =
   *       HttpBody.newBuilder()
   *           .setContentType("contentType-389131437")
   *           .setData(ByteString.EMPTY)
   *           .addAllExtensions(new ArrayList<Any>())
   *           .build();
   *   ApiFuture<HttpBody> future = gatewayServiceClient.putResourceCallable().futureCall(request);
   *   // Do something.
   *   HttpBody response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<HttpBody, HttpBody> putResourceCallable() {
    return stub.putResourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * PatchResource performs an HTTP PATCH on the Kubernetes API Server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GatewayServiceClient gatewayServiceClient = GatewayServiceClient.create()) {
   *   HttpBody request =
   *       HttpBody.newBuilder()
   *           .setContentType("contentType-389131437")
   *           .setData(ByteString.EMPTY)
   *           .addAllExtensions(new ArrayList<Any>())
   *           .build();
   *   HttpBody response = gatewayServiceClient.patchResource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody patchResource(HttpBody request) {
    return patchResourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * PatchResource performs an HTTP PATCH on the Kubernetes API Server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GatewayServiceClient gatewayServiceClient = GatewayServiceClient.create()) {
   *   HttpBody request =
   *       HttpBody.newBuilder()
   *           .setContentType("contentType-389131437")
   *           .setData(ByteString.EMPTY)
   *           .addAllExtensions(new ArrayList<Any>())
   *           .build();
   *   ApiFuture<HttpBody> future = gatewayServiceClient.patchResourceCallable().futureCall(request);
   *   // Do something.
   *   HttpBody response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<HttpBody, HttpBody> patchResourceCallable() {
    return stub.patchResourceCallable();
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
