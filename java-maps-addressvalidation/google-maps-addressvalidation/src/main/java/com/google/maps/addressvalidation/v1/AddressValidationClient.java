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

package com.google.maps.addressvalidation.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.maps.addressvalidation.v1.stub.AddressValidationStub;
import com.google.maps.addressvalidation.v1.stub.AddressValidationStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The service for validating addresses.
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
 * try (AddressValidationClient addressValidationClient = AddressValidationClient.create()) {
 *   ValidateAddressRequest request =
 *       ValidateAddressRequest.newBuilder()
 *           .setAddress(PostalAddress.newBuilder().build())
 *           .setPreviousResponseId("previousResponseId468754323")
 *           .setEnableUspsCass(true)
 *           .build();
 *   ValidateAddressResponse response = addressValidationClient.validateAddress(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AddressValidationClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of AddressValidationSettings to
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
 * AddressValidationSettings addressValidationSettings =
 *     AddressValidationSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AddressValidationClient addressValidationClient =
 *     AddressValidationClient.create(addressValidationSettings);
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
 * AddressValidationSettings addressValidationSettings =
 *     AddressValidationSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AddressValidationClient addressValidationClient =
 *     AddressValidationClient.create(addressValidationSettings);
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
 * AddressValidationSettings addressValidationSettings =
 *     AddressValidationSettings.newHttpJsonBuilder().build();
 * AddressValidationClient addressValidationClient =
 *     AddressValidationClient.create(addressValidationSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AddressValidationClient implements BackgroundResource {
  private final AddressValidationSettings settings;
  private final AddressValidationStub stub;

  /** Constructs an instance of AddressValidationClient with default settings. */
  public static final AddressValidationClient create() throws IOException {
    return create(AddressValidationSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AddressValidationClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AddressValidationClient create(AddressValidationSettings settings)
      throws IOException {
    return new AddressValidationClient(settings);
  }

  /**
   * Constructs an instance of AddressValidationClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(AddressValidationSettings).
   */
  public static final AddressValidationClient create(AddressValidationStub stub) {
    return new AddressValidationClient(stub);
  }

  /**
   * Constructs an instance of AddressValidationClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AddressValidationClient(AddressValidationSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AddressValidationStubSettings) settings.getStubSettings()).createStub();
  }

  protected AddressValidationClient(AddressValidationStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AddressValidationSettings getSettings() {
    return settings;
  }

  public AddressValidationStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates an address.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressValidationClient addressValidationClient = AddressValidationClient.create()) {
   *   ValidateAddressRequest request =
   *       ValidateAddressRequest.newBuilder()
   *           .setAddress(PostalAddress.newBuilder().build())
   *           .setPreviousResponseId("previousResponseId468754323")
   *           .setEnableUspsCass(true)
   *           .build();
   *   ValidateAddressResponse response = addressValidationClient.validateAddress(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ValidateAddressResponse validateAddress(ValidateAddressRequest request) {
    return validateAddressCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates an address.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressValidationClient addressValidationClient = AddressValidationClient.create()) {
   *   ValidateAddressRequest request =
   *       ValidateAddressRequest.newBuilder()
   *           .setAddress(PostalAddress.newBuilder().build())
   *           .setPreviousResponseId("previousResponseId468754323")
   *           .setEnableUspsCass(true)
   *           .build();
   *   ApiFuture<ValidateAddressResponse> future =
   *       addressValidationClient.validateAddressCallable().futureCall(request);
   *   // Do something.
   *   ValidateAddressResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ValidateAddressRequest, ValidateAddressResponse>
      validateAddressCallable() {
    return stub.validateAddressCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Feedback about the outcome of the sequence of validation attempts. This should be the last call
   * made after a sequence of validation calls for the same address, and should be called once the
   * transaction is concluded. This should only be sent once for the sequence of `ValidateAddress`
   * requests needed to validate an address fully.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressValidationClient addressValidationClient = AddressValidationClient.create()) {
   *   ProvideValidationFeedbackRequest request =
   *       ProvideValidationFeedbackRequest.newBuilder()
   *           .setResponseId("responseId-633138884")
   *           .build();
   *   ProvideValidationFeedbackResponse response =
   *       addressValidationClient.provideValidationFeedback(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProvideValidationFeedbackResponse provideValidationFeedback(
      ProvideValidationFeedbackRequest request) {
    return provideValidationFeedbackCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Feedback about the outcome of the sequence of validation attempts. This should be the last call
   * made after a sequence of validation calls for the same address, and should be called once the
   * transaction is concluded. This should only be sent once for the sequence of `ValidateAddress`
   * requests needed to validate an address fully.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AddressValidationClient addressValidationClient = AddressValidationClient.create()) {
   *   ProvideValidationFeedbackRequest request =
   *       ProvideValidationFeedbackRequest.newBuilder()
   *           .setResponseId("responseId-633138884")
   *           .build();
   *   ApiFuture<ProvideValidationFeedbackResponse> future =
   *       addressValidationClient.provideValidationFeedbackCallable().futureCall(request);
   *   // Do something.
   *   ProvideValidationFeedbackResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ProvideValidationFeedbackRequest, ProvideValidationFeedbackResponse>
      provideValidationFeedbackCallable() {
    return stub.provideValidationFeedbackCallable();
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
