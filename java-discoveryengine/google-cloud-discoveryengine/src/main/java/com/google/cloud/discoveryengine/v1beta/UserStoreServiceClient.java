/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.discoveryengine.v1beta;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.stub.UserStoreServiceStub;
import com.google.cloud.discoveryengine.v1beta.stub.UserStoreServiceStubSettings;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing User Stores.
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
 * try (UserStoreServiceClient userStoreServiceClient = UserStoreServiceClient.create()) {
 *   UserStoreName name = UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]");
 *   UserStore response = userStoreServiceClient.getUserStore(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the UserStoreServiceClient object to clean up resources
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
 *      <td><p> GetUserStore</td>
 *      <td><p> Gets the User Store.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getUserStore(GetUserStoreRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getUserStore(UserStoreName name)
 *           <li><p> getUserStore(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getUserStoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateUserStore</td>
 *      <td><p> Updates the User Store.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateUserStore(UpdateUserStoreRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateUserStore(UserStore userStore, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateUserStoreCallable()
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
 * <p>This class can be customized by passing in a custom instance of UserStoreServiceSettings to
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
 * UserStoreServiceSettings userStoreServiceSettings =
 *     UserStoreServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * UserStoreServiceClient userStoreServiceClient =
 *     UserStoreServiceClient.create(userStoreServiceSettings);
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
 * UserStoreServiceSettings userStoreServiceSettings =
 *     UserStoreServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * UserStoreServiceClient userStoreServiceClient =
 *     UserStoreServiceClient.create(userStoreServiceSettings);
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
 * UserStoreServiceSettings userStoreServiceSettings =
 *     UserStoreServiceSettings.newHttpJsonBuilder().build();
 * UserStoreServiceClient userStoreServiceClient =
 *     UserStoreServiceClient.create(userStoreServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class UserStoreServiceClient implements BackgroundResource {
  private final UserStoreServiceSettings settings;
  private final UserStoreServiceStub stub;

  /** Constructs an instance of UserStoreServiceClient with default settings. */
  public static final UserStoreServiceClient create() throws IOException {
    return create(UserStoreServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of UserStoreServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final UserStoreServiceClient create(UserStoreServiceSettings settings)
      throws IOException {
    return new UserStoreServiceClient(settings);
  }

  /**
   * Constructs an instance of UserStoreServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(UserStoreServiceSettings).
   */
  public static final UserStoreServiceClient create(UserStoreServiceStub stub) {
    return new UserStoreServiceClient(stub);
  }

  /**
   * Constructs an instance of UserStoreServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected UserStoreServiceClient(UserStoreServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((UserStoreServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected UserStoreServiceClient(UserStoreServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final UserStoreServiceSettings getSettings() {
    return settings;
  }

  public UserStoreServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the User Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserStoreServiceClient userStoreServiceClient = UserStoreServiceClient.create()) {
   *   UserStoreName name = UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]");
   *   UserStore response = userStoreServiceClient.getUserStore(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the User Store to get. Format:
   *     `projects/{project}/locations/{location}/userStores/{user_store_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserStore getUserStore(UserStoreName name) {
    GetUserStoreRequest request =
        GetUserStoreRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getUserStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the User Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserStoreServiceClient userStoreServiceClient = UserStoreServiceClient.create()) {
   *   String name = UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString();
   *   UserStore response = userStoreServiceClient.getUserStore(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the User Store to get. Format:
   *     `projects/{project}/locations/{location}/userStores/{user_store_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserStore getUserStore(String name) {
    GetUserStoreRequest request = GetUserStoreRequest.newBuilder().setName(name).build();
    return getUserStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the User Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserStoreServiceClient userStoreServiceClient = UserStoreServiceClient.create()) {
   *   GetUserStoreRequest request =
   *       GetUserStoreRequest.newBuilder()
   *           .setName(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
   *           .build();
   *   UserStore response = userStoreServiceClient.getUserStore(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserStore getUserStore(GetUserStoreRequest request) {
    return getUserStoreCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the User Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserStoreServiceClient userStoreServiceClient = UserStoreServiceClient.create()) {
   *   GetUserStoreRequest request =
   *       GetUserStoreRequest.newBuilder()
   *           .setName(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
   *           .build();
   *   ApiFuture<UserStore> future =
   *       userStoreServiceClient.getUserStoreCallable().futureCall(request);
   *   // Do something.
   *   UserStore response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetUserStoreRequest, UserStore> getUserStoreCallable() {
    return stub.getUserStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the User Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserStoreServiceClient userStoreServiceClient = UserStoreServiceClient.create()) {
   *   UserStore userStore = UserStore.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UserStore response = userStoreServiceClient.updateUserStore(userStore, updateMask);
   * }
   * }</pre>
   *
   * @param userStore Required. The User Store to update. Format:
   *     `projects/{project}/locations/{location}/userStores/{user_store_id}`
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserStore updateUserStore(UserStore userStore, FieldMask updateMask) {
    UpdateUserStoreRequest request =
        UpdateUserStoreRequest.newBuilder()
            .setUserStore(userStore)
            .setUpdateMask(updateMask)
            .build();
    return updateUserStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the User Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserStoreServiceClient userStoreServiceClient = UserStoreServiceClient.create()) {
   *   UpdateUserStoreRequest request =
   *       UpdateUserStoreRequest.newBuilder()
   *           .setUserStore(UserStore.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   UserStore response = userStoreServiceClient.updateUserStore(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserStore updateUserStore(UpdateUserStoreRequest request) {
    return updateUserStoreCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the User Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserStoreServiceClient userStoreServiceClient = UserStoreServiceClient.create()) {
   *   UpdateUserStoreRequest request =
   *       UpdateUserStoreRequest.newBuilder()
   *           .setUserStore(UserStore.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<UserStore> future =
   *       userStoreServiceClient.updateUserStoreCallable().futureCall(request);
   *   // Do something.
   *   UserStore response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateUserStoreRequest, UserStore> updateUserStoreCallable() {
    return stub.updateUserStoreCallable();
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
