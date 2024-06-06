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
import com.google.shopping.merchant.accounts.v1beta.stub.HomepageServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.HomepageServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to support an API for a store's homepage.
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
 * try (HomepageServiceClient homepageServiceClient = HomepageServiceClient.create()) {
 *   HomepageName name = HomepageName.of("[ACCOUNT]");
 *   Homepage response = homepageServiceClient.getHomepage(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the HomepageServiceClient object to clean up resources
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
 *      <td><p> GetHomepage</td>
 *      <td><p> Retrieves a store's homepage.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getHomepage(GetHomepageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getHomepage(HomepageName name)
 *           <li><p> getHomepage(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getHomepageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateHomepage</td>
 *      <td><p> Updates a store's homepage. Executing this method requires admin access.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateHomepage(UpdateHomepageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateHomepage(Homepage homepage, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateHomepageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ClaimHomepage</td>
 *      <td><p> Claims a store's homepage. Executing this method requires admin access.
 * <p>  If the homepage is already claimed, this will recheck the verification (unless the merchant is exempted from claiming, which also exempts from verification) and return a successful response. If ownership can no longer be verified, it will return an error, but it won't clear the claim. In case of failure, a canonical error message will be returned:    &#42; PERMISSION_DENIED: user doesn't have the necessary permissions on this    MC account;    &#42; FAILED_PRECONDITION:      - The account is not a Merchant Center account;      - MC account doesn't have a homepage;      - claiming failed (in this case the error message will contain more      details).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> claimHomepage(ClaimHomepageRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> claimHomepageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UnclaimHomepage</td>
 *      <td><p> Unclaims a store's homepage. Executing this method requires admin access.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> unclaimHomepage(UnclaimHomepageRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> unclaimHomepageCallable()
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
 * <p>This class can be customized by passing in a custom instance of HomepageServiceSettings to
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
 * HomepageServiceSettings homepageServiceSettings =
 *     HomepageServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * HomepageServiceClient homepageServiceClient =
 *     HomepageServiceClient.create(homepageServiceSettings);
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
 * HomepageServiceSettings homepageServiceSettings =
 *     HomepageServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * HomepageServiceClient homepageServiceClient =
 *     HomepageServiceClient.create(homepageServiceSettings);
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
 * HomepageServiceSettings homepageServiceSettings =
 *     HomepageServiceSettings.newHttpJsonBuilder().build();
 * HomepageServiceClient homepageServiceClient =
 *     HomepageServiceClient.create(homepageServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HomepageServiceClient implements BackgroundResource {
  private final HomepageServiceSettings settings;
  private final HomepageServiceStub stub;

  /** Constructs an instance of HomepageServiceClient with default settings. */
  public static final HomepageServiceClient create() throws IOException {
    return create(HomepageServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of HomepageServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final HomepageServiceClient create(HomepageServiceSettings settings)
      throws IOException {
    return new HomepageServiceClient(settings);
  }

  /**
   * Constructs an instance of HomepageServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(HomepageServiceSettings).
   */
  public static final HomepageServiceClient create(HomepageServiceStub stub) {
    return new HomepageServiceClient(stub);
  }

  /**
   * Constructs an instance of HomepageServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HomepageServiceClient(HomepageServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((HomepageServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected HomepageServiceClient(HomepageServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final HomepageServiceSettings getSettings() {
    return settings;
  }

  public HomepageServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a store's homepage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HomepageServiceClient homepageServiceClient = HomepageServiceClient.create()) {
   *   HomepageName name = HomepageName.of("[ACCOUNT]");
   *   Homepage response = homepageServiceClient.getHomepage(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the homepage to retrieve. Format:
   *     `accounts/{account}/homepage`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Homepage getHomepage(HomepageName name) {
    GetHomepageRequest request =
        GetHomepageRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getHomepage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a store's homepage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HomepageServiceClient homepageServiceClient = HomepageServiceClient.create()) {
   *   String name = HomepageName.of("[ACCOUNT]").toString();
   *   Homepage response = homepageServiceClient.getHomepage(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the homepage to retrieve. Format:
   *     `accounts/{account}/homepage`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Homepage getHomepage(String name) {
    GetHomepageRequest request = GetHomepageRequest.newBuilder().setName(name).build();
    return getHomepage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a store's homepage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HomepageServiceClient homepageServiceClient = HomepageServiceClient.create()) {
   *   GetHomepageRequest request =
   *       GetHomepageRequest.newBuilder().setName(HomepageName.of("[ACCOUNT]").toString()).build();
   *   Homepage response = homepageServiceClient.getHomepage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Homepage getHomepage(GetHomepageRequest request) {
    return getHomepageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a store's homepage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HomepageServiceClient homepageServiceClient = HomepageServiceClient.create()) {
   *   GetHomepageRequest request =
   *       GetHomepageRequest.newBuilder().setName(HomepageName.of("[ACCOUNT]").toString()).build();
   *   ApiFuture<Homepage> future = homepageServiceClient.getHomepageCallable().futureCall(request);
   *   // Do something.
   *   Homepage response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHomepageRequest, Homepage> getHomepageCallable() {
    return stub.getHomepageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a store's homepage. Executing this method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HomepageServiceClient homepageServiceClient = HomepageServiceClient.create()) {
   *   Homepage homepage = Homepage.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Homepage response = homepageServiceClient.updateHomepage(homepage, updateMask);
   * }
   * }</pre>
   *
   * @param homepage Required. The new version of the homepage.
   * @param updateMask Required. List of fields being updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Homepage updateHomepage(Homepage homepage, FieldMask updateMask) {
    UpdateHomepageRequest request =
        UpdateHomepageRequest.newBuilder().setHomepage(homepage).setUpdateMask(updateMask).build();
    return updateHomepage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a store's homepage. Executing this method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HomepageServiceClient homepageServiceClient = HomepageServiceClient.create()) {
   *   UpdateHomepageRequest request =
   *       UpdateHomepageRequest.newBuilder()
   *           .setHomepage(Homepage.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Homepage response = homepageServiceClient.updateHomepage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Homepage updateHomepage(UpdateHomepageRequest request) {
    return updateHomepageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a store's homepage. Executing this method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HomepageServiceClient homepageServiceClient = HomepageServiceClient.create()) {
   *   UpdateHomepageRequest request =
   *       UpdateHomepageRequest.newBuilder()
   *           .setHomepage(Homepage.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Homepage> future =
   *       homepageServiceClient.updateHomepageCallable().futureCall(request);
   *   // Do something.
   *   Homepage response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateHomepageRequest, Homepage> updateHomepageCallable() {
    return stub.updateHomepageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Claims a store's homepage. Executing this method requires admin access.
   *
   * <p>If the homepage is already claimed, this will recheck the verification (unless the merchant
   * is exempted from claiming, which also exempts from verification) and return a successful
   * response. If ownership can no longer be verified, it will return an error, but it won't clear
   * the claim. In case of failure, a canonical error message will be returned: &#42;
   * PERMISSION_DENIED: user doesn't have the necessary permissions on this MC account; &#42;
   * FAILED_PRECONDITION: - The account is not a Merchant Center account; - MC account doesn't have
   * a homepage; - claiming failed (in this case the error message will contain more details).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HomepageServiceClient homepageServiceClient = HomepageServiceClient.create()) {
   *   ClaimHomepageRequest request =
   *       ClaimHomepageRequest.newBuilder()
   *           .setName(HomepageName.of("[ACCOUNT]").toString())
   *           .build();
   *   Homepage response = homepageServiceClient.claimHomepage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Homepage claimHomepage(ClaimHomepageRequest request) {
    return claimHomepageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Claims a store's homepage. Executing this method requires admin access.
   *
   * <p>If the homepage is already claimed, this will recheck the verification (unless the merchant
   * is exempted from claiming, which also exempts from verification) and return a successful
   * response. If ownership can no longer be verified, it will return an error, but it won't clear
   * the claim. In case of failure, a canonical error message will be returned: &#42;
   * PERMISSION_DENIED: user doesn't have the necessary permissions on this MC account; &#42;
   * FAILED_PRECONDITION: - The account is not a Merchant Center account; - MC account doesn't have
   * a homepage; - claiming failed (in this case the error message will contain more details).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HomepageServiceClient homepageServiceClient = HomepageServiceClient.create()) {
   *   ClaimHomepageRequest request =
   *       ClaimHomepageRequest.newBuilder()
   *           .setName(HomepageName.of("[ACCOUNT]").toString())
   *           .build();
   *   ApiFuture<Homepage> future =
   *       homepageServiceClient.claimHomepageCallable().futureCall(request);
   *   // Do something.
   *   Homepage response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ClaimHomepageRequest, Homepage> claimHomepageCallable() {
    return stub.claimHomepageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unclaims a store's homepage. Executing this method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HomepageServiceClient homepageServiceClient = HomepageServiceClient.create()) {
   *   UnclaimHomepageRequest request =
   *       UnclaimHomepageRequest.newBuilder()
   *           .setName(HomepageName.of("[ACCOUNT]").toString())
   *           .build();
   *   Homepage response = homepageServiceClient.unclaimHomepage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Homepage unclaimHomepage(UnclaimHomepageRequest request) {
    return unclaimHomepageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unclaims a store's homepage. Executing this method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HomepageServiceClient homepageServiceClient = HomepageServiceClient.create()) {
   *   UnclaimHomepageRequest request =
   *       UnclaimHomepageRequest.newBuilder()
   *           .setName(HomepageName.of("[ACCOUNT]").toString())
   *           .build();
   *   ApiFuture<Homepage> future =
   *       homepageServiceClient.unclaimHomepageCallable().futureCall(request);
   *   // Do something.
   *   Homepage response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UnclaimHomepageRequest, Homepage> unclaimHomepageCallable() {
    return stub.unclaimHomepageCallable();
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
