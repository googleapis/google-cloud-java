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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.accounts.v1beta.stub.UserServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.UserServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to support user API.
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
 *   UserName name = UserName.of("[ACCOUNT]", "[EMAIL]");
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
 *      <td><p> Retrieves a Merchant Center account user.</td>
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
 *    <tr>
 *      <td><p> CreateUser</td>
 *      <td><p> Creates a Merchant Center account user. Executing this method requires admin access.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createUser(CreateUserRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createUser(AccountName parent, User user)
 *           <li><p> createUser(String parent, User user)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createUserCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteUser</td>
 *      <td><p> Deletes a Merchant Center account user. Executing this method requires admin access.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteUser(DeleteUserRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteUser(UserName name)
 *           <li><p> deleteUser(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteUserCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateUser</td>
 *      <td><p> Updates a Merchant Center account user. Executing this method requires admin access.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateUser(UpdateUserRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateUser(User user, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateUserCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListUsers</td>
 *      <td><p> Lists all users of a Merchant Center account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listUsers(ListUsersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listUsers(AccountName parent)
 *           <li><p> listUsers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listUsersPagedCallable()
 *           <li><p> listUsersCallable()
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
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * UserServiceSettings userServiceSettings = UserServiceSettings.newHttpJsonBuilder().build();
 * UserServiceClient userServiceClient = UserServiceClient.create(userServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
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
   * Retrieves a Merchant Center account user.
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
   *   UserName name = UserName.of("[ACCOUNT]", "[EMAIL]");
   *   User response = userServiceClient.getUser(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the user to retrieve. Format:
   *     `accounts/{account}/users/{email}`
   *     <p>It is also possible to retrieve the user corresponding to the caller by using `me`
   *     rather than an email address as in `accounts/{account}/users/me`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final User getUser(UserName name) {
    GetUserRequest request =
        GetUserRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getUser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a Merchant Center account user.
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
   *   String name = UserName.of("[ACCOUNT]", "[EMAIL]").toString();
   *   User response = userServiceClient.getUser(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the user to retrieve. Format:
   *     `accounts/{account}/users/{email}`
   *     <p>It is also possible to retrieve the user corresponding to the caller by using `me`
   *     rather than an email address as in `accounts/{account}/users/me`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final User getUser(String name) {
    GetUserRequest request = GetUserRequest.newBuilder().setName(name).build();
    return getUser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a Merchant Center account user.
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
   *           .setName(UserName.of("[ACCOUNT]", "[EMAIL]").toString())
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
   * Retrieves a Merchant Center account user.
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
   *           .setName(UserName.of("[ACCOUNT]", "[EMAIL]").toString())
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Merchant Center account user. Executing this method requires admin access.
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
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   User user = User.newBuilder().build();
   *   User response = userServiceClient.createUser(parent, user);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the account for which a user will be created.
   *     Format: `accounts/{account}`
   * @param user Required. The user to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final User createUser(AccountName parent, User user) {
    CreateUserRequest request =
        CreateUserRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUser(user)
            .build();
    return createUser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Merchant Center account user. Executing this method requires admin access.
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
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   User user = User.newBuilder().build();
   *   User response = userServiceClient.createUser(parent, user);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the account for which a user will be created.
   *     Format: `accounts/{account}`
   * @param user Required. The user to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final User createUser(String parent, User user) {
    CreateUserRequest request =
        CreateUserRequest.newBuilder().setParent(parent).setUser(user).build();
    return createUser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Merchant Center account user. Executing this method requires admin access.
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
   *   CreateUserRequest request =
   *       CreateUserRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setUserId("userId-836030906")
   *           .setUser(User.newBuilder().build())
   *           .build();
   *   User response = userServiceClient.createUser(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final User createUser(CreateUserRequest request) {
    return createUserCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Merchant Center account user. Executing this method requires admin access.
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
   *   CreateUserRequest request =
   *       CreateUserRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setUserId("userId-836030906")
   *           .setUser(User.newBuilder().build())
   *           .build();
   *   ApiFuture<User> future = userServiceClient.createUserCallable().futureCall(request);
   *   // Do something.
   *   User response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateUserRequest, User> createUserCallable() {
    return stub.createUserCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Merchant Center account user. Executing this method requires admin access.
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
   *   UserName name = UserName.of("[ACCOUNT]", "[EMAIL]");
   *   userServiceClient.deleteUser(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the user to delete. Format:
   *     `accounts/{account}/users/{email}`
   *     <p>It is also possible to delete the user corresponding to the caller by using `me` rather
   *     than an email address as in `accounts/{account}/users/me`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUser(UserName name) {
    DeleteUserRequest request =
        DeleteUserRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteUser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Merchant Center account user. Executing this method requires admin access.
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
   *   String name = UserName.of("[ACCOUNT]", "[EMAIL]").toString();
   *   userServiceClient.deleteUser(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the user to delete. Format:
   *     `accounts/{account}/users/{email}`
   *     <p>It is also possible to delete the user corresponding to the caller by using `me` rather
   *     than an email address as in `accounts/{account}/users/me`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUser(String name) {
    DeleteUserRequest request = DeleteUserRequest.newBuilder().setName(name).build();
    deleteUser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Merchant Center account user. Executing this method requires admin access.
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
   *   DeleteUserRequest request =
   *       DeleteUserRequest.newBuilder()
   *           .setName(UserName.of("[ACCOUNT]", "[EMAIL]").toString())
   *           .build();
   *   userServiceClient.deleteUser(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUser(DeleteUserRequest request) {
    deleteUserCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Merchant Center account user. Executing this method requires admin access.
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
   *   DeleteUserRequest request =
   *       DeleteUserRequest.newBuilder()
   *           .setName(UserName.of("[ACCOUNT]", "[EMAIL]").toString())
   *           .build();
   *   ApiFuture<Empty> future = userServiceClient.deleteUserCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteUserRequest, Empty> deleteUserCallable() {
    return stub.deleteUserCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Merchant Center account user. Executing this method requires admin access.
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
   *   User user = User.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   User response = userServiceClient.updateUser(user, updateMask);
   * }
   * }</pre>
   *
   * @param user Required. The new version of the user.
   *     <p>Use `me` to refer to your own email address, for example `accounts/{account}/users/me`.
   * @param updateMask Required. List of fields being updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final User updateUser(User user, FieldMask updateMask) {
    UpdateUserRequest request =
        UpdateUserRequest.newBuilder().setUser(user).setUpdateMask(updateMask).build();
    return updateUser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Merchant Center account user. Executing this method requires admin access.
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
   *   UpdateUserRequest request =
   *       UpdateUserRequest.newBuilder()
   *           .setUser(User.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   User response = userServiceClient.updateUser(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final User updateUser(UpdateUserRequest request) {
    return updateUserCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Merchant Center account user. Executing this method requires admin access.
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
   *   UpdateUserRequest request =
   *       UpdateUserRequest.newBuilder()
   *           .setUser(User.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<User> future = userServiceClient.updateUserCallable().futureCall(request);
   *   // Do something.
   *   User response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateUserRequest, User> updateUserCallable() {
    return stub.updateUserCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all users of a Merchant Center account.
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
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (User element : userServiceClient.listUsers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of users. Format:
   *     `accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUsersPagedResponse listUsers(AccountName parent) {
    ListUsersRequest request =
        ListUsersRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listUsers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all users of a Merchant Center account.
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
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (User element : userServiceClient.listUsers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of users. Format:
   *     `accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUsersPagedResponse listUsers(String parent) {
    ListUsersRequest request = ListUsersRequest.newBuilder().setParent(parent).build();
    return listUsers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all users of a Merchant Center account.
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
   *   ListUsersRequest request =
   *       ListUsersRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (User element : userServiceClient.listUsers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUsersPagedResponse listUsers(ListUsersRequest request) {
    return listUsersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all users of a Merchant Center account.
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
   *   ListUsersRequest request =
   *       ListUsersRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<User> future = userServiceClient.listUsersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (User element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUsersRequest, ListUsersPagedResponse> listUsersPagedCallable() {
    return stub.listUsersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all users of a Merchant Center account.
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
   *   ListUsersRequest request =
   *       ListUsersRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListUsersResponse response = userServiceClient.listUsersCallable().call(request);
   *     for (User element : response.getUsersList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUsersRequest, ListUsersResponse> listUsersCallable() {
    return stub.listUsersCallable();
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

  public static class ListUsersPagedResponse
      extends AbstractPagedListResponse<
          ListUsersRequest, ListUsersResponse, User, ListUsersPage, ListUsersFixedSizeCollection> {

    public static ApiFuture<ListUsersPagedResponse> createAsync(
        PageContext<ListUsersRequest, ListUsersResponse, User> context,
        ApiFuture<ListUsersResponse> futureResponse) {
      ApiFuture<ListUsersPage> futurePage =
          ListUsersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListUsersPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListUsersPagedResponse(ListUsersPage page) {
      super(page, ListUsersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUsersPage
      extends AbstractPage<ListUsersRequest, ListUsersResponse, User, ListUsersPage> {

    private ListUsersPage(
        PageContext<ListUsersRequest, ListUsersResponse, User> context,
        ListUsersResponse response) {
      super(context, response);
    }

    private static ListUsersPage createEmptyPage() {
      return new ListUsersPage(null, null);
    }

    @Override
    protected ListUsersPage createPage(
        PageContext<ListUsersRequest, ListUsersResponse, User> context,
        ListUsersResponse response) {
      return new ListUsersPage(context, response);
    }

    @Override
    public ApiFuture<ListUsersPage> createPageAsync(
        PageContext<ListUsersRequest, ListUsersResponse, User> context,
        ApiFuture<ListUsersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUsersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUsersRequest, ListUsersResponse, User, ListUsersPage, ListUsersFixedSizeCollection> {

    private ListUsersFixedSizeCollection(List<ListUsersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUsersFixedSizeCollection createEmptyCollection() {
      return new ListUsersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUsersFixedSizeCollection createCollection(
        List<ListUsersPage> pages, int collectionSize) {
      return new ListUsersFixedSizeCollection(pages, collectionSize);
    }
  }
}
