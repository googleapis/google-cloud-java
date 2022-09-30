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

package com.google.protos.google.cloud.binaryauthorization.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protos.google.cloud.binaryauthorization.v1.stub.ValidationHelperV1Stub;
import com.google.protos.google.cloud.binaryauthorization.v1.stub.ValidationHelperV1StubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: BinAuthz Attestor verification
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
 * try (ValidationHelperV1Client validationHelperV1Client = ValidationHelperV1Client.create()) {
 *   Service.ValidateAttestationOccurrenceRequest request =
 *       Service.ValidateAttestationOccurrenceRequest.newBuilder()
 *           .setAttestor("attestor542920680")
 *           .setAttestation(AttestationOccurrence.newBuilder().build())
 *           .setOccurrenceNote("occurrenceNote1722072419")
 *           .setOccurrenceResourceUri("occurrenceResourceUri1001424877")
 *           .build();
 *   Service.ValidateAttestationOccurrenceResponse response =
 *       validationHelperV1Client.validateAttestationOccurrence(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ValidationHelperV1Client object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of ValidationHelperV1Settings to
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
 * ValidationHelperV1Settings validationHelperV1Settings =
 *     ValidationHelperV1Settings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ValidationHelperV1Client validationHelperV1Client =
 *     ValidationHelperV1Client.create(validationHelperV1Settings);
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
 * ValidationHelperV1Settings validationHelperV1Settings =
 *     ValidationHelperV1Settings.newBuilder().setEndpoint(myEndpoint).build();
 * ValidationHelperV1Client validationHelperV1Client =
 *     ValidationHelperV1Client.create(validationHelperV1Settings);
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
 * ValidationHelperV1Settings validationHelperV1Settings =
 *     ValidationHelperV1Settings.newBuilder()
 *         .setTransportChannelProvider(
 *             ValidationHelperV1Settings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * ValidationHelperV1Client validationHelperV1Client =
 *     ValidationHelperV1Client.create(validationHelperV1Settings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ValidationHelperV1Client implements BackgroundResource {
  private final ValidationHelperV1Settings settings;
  private final ValidationHelperV1Stub stub;

  /** Constructs an instance of ValidationHelperV1Client with default settings. */
  public static final ValidationHelperV1Client create() throws IOException {
    return create(ValidationHelperV1Settings.newBuilder().build());
  }

  /**
   * Constructs an instance of ValidationHelperV1Client, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ValidationHelperV1Client create(ValidationHelperV1Settings settings)
      throws IOException {
    return new ValidationHelperV1Client(settings);
  }

  /**
   * Constructs an instance of ValidationHelperV1Client, using the given stub for making calls. This
   * is for advanced usage - prefer using create(ValidationHelperV1Settings).
   */
  public static final ValidationHelperV1Client create(ValidationHelperV1Stub stub) {
    return new ValidationHelperV1Client(stub);
  }

  /**
   * Constructs an instance of ValidationHelperV1Client, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ValidationHelperV1Client(ValidationHelperV1Settings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ValidationHelperV1StubSettings) settings.getStubSettings()).createStub();
  }

  protected ValidationHelperV1Client(ValidationHelperV1Stub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ValidationHelperV1Settings getSettings() {
    return settings;
  }

  public ValidationHelperV1Stub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns whether the given Attestation for the given image URI was signed by the given Attestor
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ValidationHelperV1Client validationHelperV1Client = ValidationHelperV1Client.create()) {
   *   Service.ValidateAttestationOccurrenceRequest request =
   *       Service.ValidateAttestationOccurrenceRequest.newBuilder()
   *           .setAttestor("attestor542920680")
   *           .setAttestation(AttestationOccurrence.newBuilder().build())
   *           .setOccurrenceNote("occurrenceNote1722072419")
   *           .setOccurrenceResourceUri("occurrenceResourceUri1001424877")
   *           .build();
   *   Service.ValidateAttestationOccurrenceResponse response =
   *       validationHelperV1Client.validateAttestationOccurrence(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Service.ValidateAttestationOccurrenceResponse validateAttestationOccurrence(
      Service.ValidateAttestationOccurrenceRequest request) {
    return validateAttestationOccurrenceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns whether the given Attestation for the given image URI was signed by the given Attestor
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ValidationHelperV1Client validationHelperV1Client = ValidationHelperV1Client.create()) {
   *   Service.ValidateAttestationOccurrenceRequest request =
   *       Service.ValidateAttestationOccurrenceRequest.newBuilder()
   *           .setAttestor("attestor542920680")
   *           .setAttestation(AttestationOccurrence.newBuilder().build())
   *           .setOccurrenceNote("occurrenceNote1722072419")
   *           .setOccurrenceResourceUri("occurrenceResourceUri1001424877")
   *           .build();
   *   ApiFuture<Service.ValidateAttestationOccurrenceResponse> future =
   *       validationHelperV1Client.validateAttestationOccurrenceCallable().futureCall(request);
   *   // Do something.
   *   Service.ValidateAttestationOccurrenceResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          Service.ValidateAttestationOccurrenceRequest,
          Service.ValidateAttestationOccurrenceResponse>
      validateAttestationOccurrenceCallable() {
    return stub.validateAttestationOccurrenceCallable();
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
