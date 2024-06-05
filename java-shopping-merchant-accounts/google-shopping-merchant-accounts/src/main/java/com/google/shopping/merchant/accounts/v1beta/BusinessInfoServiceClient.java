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
import com.google.shopping.merchant.accounts.v1beta.stub.BusinessInfoServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.BusinessInfoServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to support business info API.
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
 * try (BusinessInfoServiceClient businessInfoServiceClient = BusinessInfoServiceClient.create()) {
 *   BusinessInfoName name = BusinessInfoName.of("[ACCOUNT]");
 *   BusinessInfo response = businessInfoServiceClient.getBusinessInfo(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BusinessInfoServiceClient object to clean up resources
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
 *      <td><p> GetBusinessInfo</td>
 *      <td><p> Retrieves the business info of an account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBusinessInfo(GetBusinessInfoRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBusinessInfo(BusinessInfoName name)
 *           <li><p> getBusinessInfo(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBusinessInfoCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBusinessInfo</td>
 *      <td><p> Updates the business info of an account. Executing this method requires admin access.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBusinessInfo(UpdateBusinessInfoRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateBusinessInfo(BusinessInfo businessInfo, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBusinessInfoCallable()
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
 * <p>This class can be customized by passing in a custom instance of BusinessInfoServiceSettings to
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
 * BusinessInfoServiceSettings businessInfoServiceSettings =
 *     BusinessInfoServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BusinessInfoServiceClient businessInfoServiceClient =
 *     BusinessInfoServiceClient.create(businessInfoServiceSettings);
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
 * BusinessInfoServiceSettings businessInfoServiceSettings =
 *     BusinessInfoServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BusinessInfoServiceClient businessInfoServiceClient =
 *     BusinessInfoServiceClient.create(businessInfoServiceSettings);
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
 * BusinessInfoServiceSettings businessInfoServiceSettings =
 *     BusinessInfoServiceSettings.newHttpJsonBuilder().build();
 * BusinessInfoServiceClient businessInfoServiceClient =
 *     BusinessInfoServiceClient.create(businessInfoServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class BusinessInfoServiceClient implements BackgroundResource {
  private final BusinessInfoServiceSettings settings;
  private final BusinessInfoServiceStub stub;

  /** Constructs an instance of BusinessInfoServiceClient with default settings. */
  public static final BusinessInfoServiceClient create() throws IOException {
    return create(BusinessInfoServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BusinessInfoServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BusinessInfoServiceClient create(BusinessInfoServiceSettings settings)
      throws IOException {
    return new BusinessInfoServiceClient(settings);
  }

  /**
   * Constructs an instance of BusinessInfoServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(BusinessInfoServiceSettings).
   */
  public static final BusinessInfoServiceClient create(BusinessInfoServiceStub stub) {
    return new BusinessInfoServiceClient(stub);
  }

  /**
   * Constructs an instance of BusinessInfoServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected BusinessInfoServiceClient(BusinessInfoServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BusinessInfoServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected BusinessInfoServiceClient(BusinessInfoServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BusinessInfoServiceSettings getSettings() {
    return settings;
  }

  public BusinessInfoServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the business info of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessInfoServiceClient businessInfoServiceClient = BusinessInfoServiceClient.create()) {
   *   BusinessInfoName name = BusinessInfoName.of("[ACCOUNT]");
   *   BusinessInfo response = businessInfoServiceClient.getBusinessInfo(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the business info. Format:
   *     `accounts/{account}/businessInfo`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BusinessInfo getBusinessInfo(BusinessInfoName name) {
    GetBusinessInfoRequest request =
        GetBusinessInfoRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBusinessInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the business info of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessInfoServiceClient businessInfoServiceClient = BusinessInfoServiceClient.create()) {
   *   String name = BusinessInfoName.of("[ACCOUNT]").toString();
   *   BusinessInfo response = businessInfoServiceClient.getBusinessInfo(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the business info. Format:
   *     `accounts/{account}/businessInfo`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BusinessInfo getBusinessInfo(String name) {
    GetBusinessInfoRequest request = GetBusinessInfoRequest.newBuilder().setName(name).build();
    return getBusinessInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the business info of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessInfoServiceClient businessInfoServiceClient = BusinessInfoServiceClient.create()) {
   *   GetBusinessInfoRequest request =
   *       GetBusinessInfoRequest.newBuilder()
   *           .setName(BusinessInfoName.of("[ACCOUNT]").toString())
   *           .build();
   *   BusinessInfo response = businessInfoServiceClient.getBusinessInfo(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BusinessInfo getBusinessInfo(GetBusinessInfoRequest request) {
    return getBusinessInfoCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the business info of an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessInfoServiceClient businessInfoServiceClient = BusinessInfoServiceClient.create()) {
   *   GetBusinessInfoRequest request =
   *       GetBusinessInfoRequest.newBuilder()
   *           .setName(BusinessInfoName.of("[ACCOUNT]").toString())
   *           .build();
   *   ApiFuture<BusinessInfo> future =
   *       businessInfoServiceClient.getBusinessInfoCallable().futureCall(request);
   *   // Do something.
   *   BusinessInfo response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBusinessInfoRequest, BusinessInfo> getBusinessInfoCallable() {
    return stub.getBusinessInfoCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the business info of an account. Executing this method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessInfoServiceClient businessInfoServiceClient = BusinessInfoServiceClient.create()) {
   *   BusinessInfo businessInfo = BusinessInfo.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BusinessInfo response =
   *       businessInfoServiceClient.updateBusinessInfo(businessInfo, updateMask);
   * }
   * }</pre>
   *
   * @param businessInfo Required. The new version of the business info.
   * @param updateMask Required. List of fields being updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BusinessInfo updateBusinessInfo(BusinessInfo businessInfo, FieldMask updateMask) {
    UpdateBusinessInfoRequest request =
        UpdateBusinessInfoRequest.newBuilder()
            .setBusinessInfo(businessInfo)
            .setUpdateMask(updateMask)
            .build();
    return updateBusinessInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the business info of an account. Executing this method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessInfoServiceClient businessInfoServiceClient = BusinessInfoServiceClient.create()) {
   *   UpdateBusinessInfoRequest request =
   *       UpdateBusinessInfoRequest.newBuilder()
   *           .setBusinessInfo(BusinessInfo.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   BusinessInfo response = businessInfoServiceClient.updateBusinessInfo(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BusinessInfo updateBusinessInfo(UpdateBusinessInfoRequest request) {
    return updateBusinessInfoCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the business info of an account. Executing this method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessInfoServiceClient businessInfoServiceClient = BusinessInfoServiceClient.create()) {
   *   UpdateBusinessInfoRequest request =
   *       UpdateBusinessInfoRequest.newBuilder()
   *           .setBusinessInfo(BusinessInfo.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<BusinessInfo> future =
   *       businessInfoServiceClient.updateBusinessInfoCallable().futureCall(request);
   *   // Do something.
   *   BusinessInfo response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBusinessInfoRequest, BusinessInfo> updateBusinessInfoCallable() {
    return stub.updateBusinessInfoCallable();
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
