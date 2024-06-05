/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.accounts.v1beta;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.accounts.v1beta.stub.BusinessIdentityServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.BusinessIdentityServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to support [business
 * identity](https://support.google.com/merchants/answer/12564247) API.
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
 * try (BusinessIdentityServiceClient businessIdentityServiceClient =
 *     BusinessIdentityServiceClient.create()) {
 *   BusinessIdentityName name = BusinessIdentityName.of("[ACCOUNT]");
 *   BusinessIdentity response = businessIdentityServiceClient.getBusinessIdentity(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BusinessIdentityServiceClient object to clean up
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
 *      <td><p> GetBusinessIdentity</td>
 *      <td><p> Retrieves the business identity of an account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBusinessIdentity(GetBusinessIdentityRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBusinessIdentity(BusinessIdentityName name)
 *           <li><p> getBusinessIdentity(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBusinessIdentityCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBusinessIdentity</td>
 *      <td><p> Updates the business identity of an account. Executing this method requires admin access.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBusinessIdentity(UpdateBusinessIdentityRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateBusinessIdentity(BusinessIdentity businessIdentity, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBusinessIdentityCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * BusinessIdentityServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BusinessIdentityServiceSettings businessIdentityServiceSettings =
 *     BusinessIdentityServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BusinessIdentityServiceClient businessIdentityServiceClient =
 *     BusinessIdentityServiceClient.create(businessIdentityServiceSettings);
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
 * BusinessIdentityServiceSettings businessIdentityServiceSettings =
 *     BusinessIdentityServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BusinessIdentityServiceClient businessIdentityServiceClient =
 *     BusinessIdentityServiceClient.create(businessIdentityServiceSettings);
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
 * BusinessIdentityServiceSettings businessIdentityServiceSettings =
 *     BusinessIdentityServiceSettings.newHttpJsonBuilder().build();
 * BusinessIdentityServiceClient businessIdentityServiceClient =
 *     BusinessIdentityServiceClient.create(businessIdentityServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class BusinessIdentityServiceClient implements BackgroundResource {
  private final BusinessIdentityServiceSettings settings;
  private final BusinessIdentityServiceStub stub;

  /** Constructs an instance of BusinessIdentityServiceClient with default settings. */
  public static final BusinessIdentityServiceClient create() throws IOException {
    return create(BusinessIdentityServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BusinessIdentityServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BusinessIdentityServiceClient create(BusinessIdentityServiceSettings settings)
      throws IOException {
    return new BusinessIdentityServiceClient(settings);
  }

  /**
   * Constructs an instance of BusinessIdentityServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(BusinessIdentityServiceSettings).
   */
  public static final BusinessIdentityServiceClient create(BusinessIdentityServiceStub stub) {
    return new BusinessIdentityServiceClient(stub);
  }

  /**
   * Constructs an instance of BusinessIdentityServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected BusinessIdentityServiceClient(BusinessIdentityServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((BusinessIdentityServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected BusinessIdentityServiceClient(BusinessIdentityServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BusinessIdentityServiceSettings getSettings() {
    return settings;
  }

  public BusinessIdentityServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the business identity of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessIdentityServiceClient businessIdentityServiceClient =
   *     BusinessIdentityServiceClient.create()) {
   *   BusinessIdentityName name = BusinessIdentityName.of("[ACCOUNT]");
   *   BusinessIdentity response = businessIdentityServiceClient.getBusinessIdentity(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the business identity. Format:
   *     `accounts/{account}/businessIdentity`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BusinessIdentity getBusinessIdentity(BusinessIdentityName name) {
    GetBusinessIdentityRequest request =
        GetBusinessIdentityRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getBusinessIdentity(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the business identity of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessIdentityServiceClient businessIdentityServiceClient =
   *     BusinessIdentityServiceClient.create()) {
   *   String name = BusinessIdentityName.of("[ACCOUNT]").toString();
   *   BusinessIdentity response = businessIdentityServiceClient.getBusinessIdentity(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the business identity. Format:
   *     `accounts/{account}/businessIdentity`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BusinessIdentity getBusinessIdentity(String name) {
    GetBusinessIdentityRequest request =
        GetBusinessIdentityRequest.newBuilder().setName(name).build();
    return getBusinessIdentity(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the business identity of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessIdentityServiceClient businessIdentityServiceClient =
   *     BusinessIdentityServiceClient.create()) {
   *   GetBusinessIdentityRequest request =
   *       GetBusinessIdentityRequest.newBuilder()
   *           .setName(BusinessIdentityName.of("[ACCOUNT]").toString())
   *           .build();
   *   BusinessIdentity response = businessIdentityServiceClient.getBusinessIdentity(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BusinessIdentity getBusinessIdentity(GetBusinessIdentityRequest request) {
    return getBusinessIdentityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the business identity of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessIdentityServiceClient businessIdentityServiceClient =
   *     BusinessIdentityServiceClient.create()) {
   *   GetBusinessIdentityRequest request =
   *       GetBusinessIdentityRequest.newBuilder()
   *           .setName(BusinessIdentityName.of("[ACCOUNT]").toString())
   *           .build();
   *   ApiFuture<BusinessIdentity> future =
   *       businessIdentityServiceClient.getBusinessIdentityCallable().futureCall(request);
   *   // Do something.
   *   BusinessIdentity response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBusinessIdentityRequest, BusinessIdentity>
      getBusinessIdentityCallable() {
    return stub.getBusinessIdentityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the business identity of an account. Executing this method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessIdentityServiceClient businessIdentityServiceClient =
   *     BusinessIdentityServiceClient.create()) {
   *   BusinessIdentity businessIdentity = BusinessIdentity.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BusinessIdentity response =
   *       businessIdentityServiceClient.updateBusinessIdentity(businessIdentity, updateMask);
   * }
   * }</pre>
   *
   * @param businessIdentity Required. The new version of the business identity.
   * @param updateMask Required. List of fields being updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BusinessIdentity updateBusinessIdentity(
      BusinessIdentity businessIdentity, FieldMask updateMask) {
    UpdateBusinessIdentityRequest request =
        UpdateBusinessIdentityRequest.newBuilder()
            .setBusinessIdentity(businessIdentity)
            .setUpdateMask(updateMask)
            .build();
    return updateBusinessIdentity(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the business identity of an account. Executing this method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessIdentityServiceClient businessIdentityServiceClient =
   *     BusinessIdentityServiceClient.create()) {
   *   UpdateBusinessIdentityRequest request =
   *       UpdateBusinessIdentityRequest.newBuilder()
   *           .setBusinessIdentity(BusinessIdentity.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   BusinessIdentity response = businessIdentityServiceClient.updateBusinessIdentity(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BusinessIdentity updateBusinessIdentity(UpdateBusinessIdentityRequest request) {
    return updateBusinessIdentityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the business identity of an account. Executing this method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessIdentityServiceClient businessIdentityServiceClient =
   *     BusinessIdentityServiceClient.create()) {
   *   UpdateBusinessIdentityRequest request =
   *       UpdateBusinessIdentityRequest.newBuilder()
   *           .setBusinessIdentity(BusinessIdentity.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<BusinessIdentity> future =
   *       businessIdentityServiceClient.updateBusinessIdentityCallable().futureCall(request);
   *   // Do something.
   *   BusinessIdentity response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBusinessIdentityRequest, BusinessIdentity>
      updateBusinessIdentityCallable() {
    return stub.updateBusinessIdentityCallable();
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
