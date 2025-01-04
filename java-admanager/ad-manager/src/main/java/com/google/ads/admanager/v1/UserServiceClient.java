/*
 * Copyright 2025 Google LLC
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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.UserServiceStub;
import com.google.ads.admanager.v1.stub.UserServiceStubSettings;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling User objects.
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
 * try (UserServiceClient userServiceClient = UserServiceClient.create()) {
 *   UserName name = UserName.of("[NETWORK_CODE]", "[USER]");
 *   User response = userServiceClient.getUser(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the UserServiceClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetUser</td>
 *      <td><p> API to retrieve a User object.
 * <p>  To get the current user, the resource name `networks/{networkCode}/users/me` can be used.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getUser(GetUserRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getUser(UserName name)
 *           <li><p> getUser(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getUserCallable()
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
 * <p>This class can be customized by passing in a custom instance of UserServiceSettings to
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
 * UserServiceSettings userServiceSettings =
 *     UserServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * UserServiceClient userServiceClient = UserServiceClient.create(userServiceSettings);
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
 * UserServiceSettings userServiceSettings =
 *     UserServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * UserServiceClient userServiceClient = UserServiceClient.create(userServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class UserServiceClient implements BackgroundResource {
  private final UserServiceSettings settings;
  private final UserServiceStub stub;

  /** Constructs an instance of UserServiceClient with default settings. */
  public static final UserServiceClient create() throws IOException {
    return create(UserServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of UserServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final UserServiceClient create(UserServiceSettings settings) throws IOException {
    return new UserServiceClient(settings);
  }

  /**
   * Constructs an instance of UserServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(UserServiceSettings).
   */
  public static final UserServiceClient create(UserServiceStub stub) {
    return new UserServiceClient(stub);
  }

  /**
   * Constructs an instance of UserServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected UserServiceClient(UserServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((UserServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected UserServiceClient(UserServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final UserServiceSettings getSettings() {
    return settings;
  }

  public UserServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a User object.
   *
   * <p>To get the current user, the resource name `networks/{networkCode}/users/me` can be used.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserServiceClient userServiceClient = UserServiceClient.create()) {
   *   UserName name = UserName.of("[NETWORK_CODE]", "[USER]");
   *   User response = userServiceClient.getUser(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the User. Format:
   *     `networks/{network_code}/users/{user_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final User getUser(UserName name) {
    GetUserRequest request =
        GetUserRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getUser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a User object.
   *
   * <p>To get the current user, the resource name `networks/{networkCode}/users/me` can be used.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserServiceClient userServiceClient = UserServiceClient.create()) {
   *   String name = UserName.of("[NETWORK_CODE]", "[USER]").toString();
   *   User response = userServiceClient.getUser(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the User. Format:
   *     `networks/{network_code}/users/{user_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final User getUser(String name) {
    GetUserRequest request = GetUserRequest.newBuilder().setName(name).build();
    return getUser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a User object.
   *
   * <p>To get the current user, the resource name `networks/{networkCode}/users/me` can be used.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserServiceClient userServiceClient = UserServiceClient.create()) {
   *   GetUserRequest request =
   *       GetUserRequest.newBuilder()
   *           .setName(UserName.of("[NETWORK_CODE]", "[USER]").toString())
   *           .build();
   *   User response = userServiceClient.getUser(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final User getUser(GetUserRequest request) {
    return getUserCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a User object.
   *
   * <p>To get the current user, the resource name `networks/{networkCode}/users/me` can be used.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserServiceClient userServiceClient = UserServiceClient.create()) {
   *   GetUserRequest request =
   *       GetUserRequest.newBuilder()
   *           .setName(UserName.of("[NETWORK_CODE]", "[USER]").toString())
   *           .build();
   *   ApiFuture<User> future = userServiceClient.getUserCallable().futureCall(request);
   *   // Do something.
   *   User response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetUserRequest, User> getUserCallable() {
    return stub.getUserCallable();
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
