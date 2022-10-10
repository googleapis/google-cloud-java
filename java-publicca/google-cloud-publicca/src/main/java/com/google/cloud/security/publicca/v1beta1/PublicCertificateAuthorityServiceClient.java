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

package com.google.cloud.security.publicca.v1beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.security.publicca.v1beta1.stub.PublicCertificateAuthorityServiceStub;
import com.google.cloud.security.publicca.v1beta1.stub.PublicCertificateAuthorityServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages the resources required for ACME [external account
 * binding](https://tools.ietf.org/html/rfc8555#section-7.3.4) for the public certificate authority
 * service.
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
 * try (PublicCertificateAuthorityServiceClient publicCertificateAuthorityServiceClient =
 *     PublicCertificateAuthorityServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   ExternalAccountKey externalAccountKey = ExternalAccountKey.newBuilder().build();
 *   ExternalAccountKey response =
 *       publicCertificateAuthorityServiceClient.createExternalAccountKey(
 *           parent, externalAccountKey);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PublicCertificateAuthorityServiceClient object to
 * clean up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of
 * PublicCertificateAuthorityServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PublicCertificateAuthorityServiceSettings publicCertificateAuthorityServiceSettings =
 *     PublicCertificateAuthorityServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PublicCertificateAuthorityServiceClient publicCertificateAuthorityServiceClient =
 *     PublicCertificateAuthorityServiceClient.create(publicCertificateAuthorityServiceSettings);
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
 * PublicCertificateAuthorityServiceSettings publicCertificateAuthorityServiceSettings =
 *     PublicCertificateAuthorityServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PublicCertificateAuthorityServiceClient publicCertificateAuthorityServiceClient =
 *     PublicCertificateAuthorityServiceClient.create(publicCertificateAuthorityServiceSettings);
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
 * PublicCertificateAuthorityServiceSettings publicCertificateAuthorityServiceSettings =
 *     PublicCertificateAuthorityServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             PublicCertificateAuthorityServiceSettings.defaultHttpJsonTransportProviderBuilder()
 *                 .build())
 *         .build();
 * PublicCertificateAuthorityServiceClient publicCertificateAuthorityServiceClient =
 *     PublicCertificateAuthorityServiceClient.create(publicCertificateAuthorityServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PublicCertificateAuthorityServiceClient implements BackgroundResource {
  private final PublicCertificateAuthorityServiceSettings settings;
  private final PublicCertificateAuthorityServiceStub stub;

  /** Constructs an instance of PublicCertificateAuthorityServiceClient with default settings. */
  public static final PublicCertificateAuthorityServiceClient create() throws IOException {
    return create(PublicCertificateAuthorityServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PublicCertificateAuthorityServiceClient, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any settings that are
   * not set.
   */
  public static final PublicCertificateAuthorityServiceClient create(
      PublicCertificateAuthorityServiceSettings settings) throws IOException {
    return new PublicCertificateAuthorityServiceClient(settings);
  }

  /**
   * Constructs an instance of PublicCertificateAuthorityServiceClient, using the given stub for
   * making calls. This is for advanced usage - prefer using
   * create(PublicCertificateAuthorityServiceSettings).
   */
  public static final PublicCertificateAuthorityServiceClient create(
      PublicCertificateAuthorityServiceStub stub) {
    return new PublicCertificateAuthorityServiceClient(stub);
  }

  /**
   * Constructs an instance of PublicCertificateAuthorityServiceClient, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected PublicCertificateAuthorityServiceClient(
      PublicCertificateAuthorityServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub =
        ((PublicCertificateAuthorityServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected PublicCertificateAuthorityServiceClient(PublicCertificateAuthorityServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PublicCertificateAuthorityServiceSettings getSettings() {
    return settings;
  }

  public PublicCertificateAuthorityServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [ExternalAccountKey][google.cloud.security.publicca.v1beta1.ExternalAccountKey]
   * bound to the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PublicCertificateAuthorityServiceClient publicCertificateAuthorityServiceClient =
   *     PublicCertificateAuthorityServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ExternalAccountKey externalAccountKey = ExternalAccountKey.newBuilder().build();
   *   ExternalAccountKey response =
   *       publicCertificateAuthorityServiceClient.createExternalAccountKey(
   *           parent, externalAccountKey);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this external_account_key will be created.
   *     Format: projects/[project_id]/locations/[location]. At present only the "global" location
   *     is supported.
   * @param externalAccountKey Required. The external account key to create. This field only exists
   *     to future-proof the API. At present, all fields in ExternalAccountKey are output only and
   *     all values are ignored. For the purpose of the CreateExternalAccountKeyRequest, set it to a
   *     default/empty value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalAccountKey createExternalAccountKey(
      LocationName parent, ExternalAccountKey externalAccountKey) {
    CreateExternalAccountKeyRequest request =
        CreateExternalAccountKeyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExternalAccountKey(externalAccountKey)
            .build();
    return createExternalAccountKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [ExternalAccountKey][google.cloud.security.publicca.v1beta1.ExternalAccountKey]
   * bound to the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PublicCertificateAuthorityServiceClient publicCertificateAuthorityServiceClient =
   *     PublicCertificateAuthorityServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ExternalAccountKey externalAccountKey = ExternalAccountKey.newBuilder().build();
   *   ExternalAccountKey response =
   *       publicCertificateAuthorityServiceClient.createExternalAccountKey(
   *           parent, externalAccountKey);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this external_account_key will be created.
   *     Format: projects/[project_id]/locations/[location]. At present only the "global" location
   *     is supported.
   * @param externalAccountKey Required. The external account key to create. This field only exists
   *     to future-proof the API. At present, all fields in ExternalAccountKey are output only and
   *     all values are ignored. For the purpose of the CreateExternalAccountKeyRequest, set it to a
   *     default/empty value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalAccountKey createExternalAccountKey(
      String parent, ExternalAccountKey externalAccountKey) {
    CreateExternalAccountKeyRequest request =
        CreateExternalAccountKeyRequest.newBuilder()
            .setParent(parent)
            .setExternalAccountKey(externalAccountKey)
            .build();
    return createExternalAccountKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [ExternalAccountKey][google.cloud.security.publicca.v1beta1.ExternalAccountKey]
   * bound to the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PublicCertificateAuthorityServiceClient publicCertificateAuthorityServiceClient =
   *     PublicCertificateAuthorityServiceClient.create()) {
   *   CreateExternalAccountKeyRequest request =
   *       CreateExternalAccountKeyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setExternalAccountKey(ExternalAccountKey.newBuilder().build())
   *           .build();
   *   ExternalAccountKey response =
   *       publicCertificateAuthorityServiceClient.createExternalAccountKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExternalAccountKey createExternalAccountKey(
      CreateExternalAccountKeyRequest request) {
    return createExternalAccountKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [ExternalAccountKey][google.cloud.security.publicca.v1beta1.ExternalAccountKey]
   * bound to the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PublicCertificateAuthorityServiceClient publicCertificateAuthorityServiceClient =
   *     PublicCertificateAuthorityServiceClient.create()) {
   *   CreateExternalAccountKeyRequest request =
   *       CreateExternalAccountKeyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setExternalAccountKey(ExternalAccountKey.newBuilder().build())
   *           .build();
   *   ApiFuture<ExternalAccountKey> future =
   *       publicCertificateAuthorityServiceClient
   *           .createExternalAccountKeyCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ExternalAccountKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateExternalAccountKeyRequest, ExternalAccountKey>
      createExternalAccountKeyCallable() {
    return stub.createExternalAccountKeyCallable();
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
