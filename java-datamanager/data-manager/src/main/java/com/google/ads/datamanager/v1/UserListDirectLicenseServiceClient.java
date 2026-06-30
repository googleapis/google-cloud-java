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

package com.google.ads.datamanager.v1;

import com.google.ads.datamanager.v1.stub.UserListDirectLicenseServiceStub;
import com.google.ads.datamanager.v1.stub.UserListDirectLicenseServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing user list direct licenses. Delete is not a supported
 * operation for UserListDirectLicenses. Callers should update the license status to DISABLED to
 * instead to deactivate a license.
 *
 * <p>This feature is only available to data partners.
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
 * try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
 *     UserListDirectLicenseServiceClient.create()) {
 *   AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
 *   UserListDirectLicense userListDirectLicense = UserListDirectLicense.newBuilder().build();
 *   UserListDirectLicense response =
 *       userListDirectLicenseServiceClient.createUserListDirectLicense(
 *           parent, userListDirectLicense);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the UserListDirectLicenseServiceClient object to clean up
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
 *      <td><p> CreateUserListDirectLicense</td>
 *      <td><p> Creates a user list direct license.
 * <p>  This feature is only available to data partners.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createUserListDirectLicense(CreateUserListDirectLicenseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createUserListDirectLicense(AccountName parent, UserListDirectLicense userListDirectLicense)
 *           <li><p> createUserListDirectLicense(String parent, UserListDirectLicense userListDirectLicense)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createUserListDirectLicenseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetUserListDirectLicense</td>
 *      <td><p> Retrieves a user list direct license.
 * <p>  This feature is only available to data partners.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getUserListDirectLicense(GetUserListDirectLicenseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getUserListDirectLicense(UserListDirectLicenseName name)
 *           <li><p> getUserListDirectLicense(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getUserListDirectLicenseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateUserListDirectLicense</td>
 *      <td><p> Updates a user list direct license.
 * <p>  This feature is only available to data partners.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateUserListDirectLicense(UpdateUserListDirectLicenseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateUserListDirectLicense(UserListDirectLicense userListDirectLicense, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateUserListDirectLicenseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListUserListDirectLicenses</td>
 *      <td><p> Lists all user list direct licenses owned by the parent account.
 * <p>  This feature is only available to data partners.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listUserListDirectLicenses(ListUserListDirectLicensesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listUserListDirectLicenses(AccountName parent)
 *           <li><p> listUserListDirectLicenses(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listUserListDirectLicensesPagedCallable()
 *           <li><p> listUserListDirectLicensesCallable()
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
 * UserListDirectLicenseServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * UserListDirectLicenseServiceSettings userListDirectLicenseServiceSettings =
 *     UserListDirectLicenseServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
 *     UserListDirectLicenseServiceClient.create(userListDirectLicenseServiceSettings);
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
 * UserListDirectLicenseServiceSettings userListDirectLicenseServiceSettings =
 *     UserListDirectLicenseServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
 *     UserListDirectLicenseServiceClient.create(userListDirectLicenseServiceSettings);
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
 * UserListDirectLicenseServiceSettings userListDirectLicenseServiceSettings =
 *     UserListDirectLicenseServiceSettings.newHttpJsonBuilder().build();
 * UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
 *     UserListDirectLicenseServiceClient.create(userListDirectLicenseServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class UserListDirectLicenseServiceClient implements BackgroundResource {
  private final UserListDirectLicenseServiceSettings settings;
  private final UserListDirectLicenseServiceStub stub;

  /** Constructs an instance of UserListDirectLicenseServiceClient with default settings. */
  public static final UserListDirectLicenseServiceClient create() throws IOException {
    return create(UserListDirectLicenseServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of UserListDirectLicenseServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final UserListDirectLicenseServiceClient create(
      UserListDirectLicenseServiceSettings settings) throws IOException {
    return new UserListDirectLicenseServiceClient(settings);
  }

  /**
   * Constructs an instance of UserListDirectLicenseServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(UserListDirectLicenseServiceSettings).
   */
  public static final UserListDirectLicenseServiceClient create(
      UserListDirectLicenseServiceStub stub) {
    return new UserListDirectLicenseServiceClient(stub);
  }

  /**
   * Constructs an instance of UserListDirectLicenseServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected UserListDirectLicenseServiceClient(UserListDirectLicenseServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((UserListDirectLicenseServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected UserListDirectLicenseServiceClient(UserListDirectLicenseServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final UserListDirectLicenseServiceSettings getSettings() {
    return settings;
  }

  public UserListDirectLicenseServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user list direct license.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
   *     UserListDirectLicenseServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
   *   UserListDirectLicense userListDirectLicense = UserListDirectLicense.newBuilder().build();
   *   UserListDirectLicense response =
   *       userListDirectLicenseServiceClient.createUserListDirectLicense(
   *           parent, userListDirectLicense);
   * }
   * }</pre>
   *
   * @param parent Required. The account that owns the user list being licensed. Should be in the
   *     format accountTypes/{ACCOUNT_TYPE}/accounts/{ACCOUNT_ID}
   * @param userListDirectLicense Required. The user list direct license to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserListDirectLicense createUserListDirectLicense(
      AccountName parent, UserListDirectLicense userListDirectLicense) {
    CreateUserListDirectLicenseRequest request =
        CreateUserListDirectLicenseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUserListDirectLicense(userListDirectLicense)
            .build();
    return createUserListDirectLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user list direct license.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
   *     UserListDirectLicenseServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString();
   *   UserListDirectLicense userListDirectLicense = UserListDirectLicense.newBuilder().build();
   *   UserListDirectLicense response =
   *       userListDirectLicenseServiceClient.createUserListDirectLicense(
   *           parent, userListDirectLicense);
   * }
   * }</pre>
   *
   * @param parent Required. The account that owns the user list being licensed. Should be in the
   *     format accountTypes/{ACCOUNT_TYPE}/accounts/{ACCOUNT_ID}
   * @param userListDirectLicense Required. The user list direct license to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserListDirectLicense createUserListDirectLicense(
      String parent, UserListDirectLicense userListDirectLicense) {
    CreateUserListDirectLicenseRequest request =
        CreateUserListDirectLicenseRequest.newBuilder()
            .setParent(parent)
            .setUserListDirectLicense(userListDirectLicense)
            .build();
    return createUserListDirectLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user list direct license.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
   *     UserListDirectLicenseServiceClient.create()) {
   *   CreateUserListDirectLicenseRequest request =
   *       CreateUserListDirectLicenseRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setUserListDirectLicense(UserListDirectLicense.newBuilder().build())
   *           .build();
   *   UserListDirectLicense response =
   *       userListDirectLicenseServiceClient.createUserListDirectLicense(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserListDirectLicense createUserListDirectLicense(
      CreateUserListDirectLicenseRequest request) {
    return createUserListDirectLicenseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user list direct license.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
   *     UserListDirectLicenseServiceClient.create()) {
   *   CreateUserListDirectLicenseRequest request =
   *       CreateUserListDirectLicenseRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setUserListDirectLicense(UserListDirectLicense.newBuilder().build())
   *           .build();
   *   ApiFuture<UserListDirectLicense> future =
   *       userListDirectLicenseServiceClient
   *           .createUserListDirectLicenseCallable()
   *           .futureCall(request);
   *   // Do something.
   *   UserListDirectLicense response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateUserListDirectLicenseRequest, UserListDirectLicense>
      createUserListDirectLicenseCallable() {
    return stub.createUserListDirectLicenseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a user list direct license.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
   *     UserListDirectLicenseServiceClient.create()) {
   *   UserListDirectLicenseName name =
   *       UserListDirectLicenseName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_DIRECT_LICENSE]");
   *   UserListDirectLicense response =
   *       userListDirectLicenseServiceClient.getUserListDirectLicense(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the user list direct license.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserListDirectLicense getUserListDirectLicense(UserListDirectLicenseName name) {
    GetUserListDirectLicenseRequest request =
        GetUserListDirectLicenseRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getUserListDirectLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a user list direct license.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
   *     UserListDirectLicenseServiceClient.create()) {
   *   String name =
   *       UserListDirectLicenseName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_DIRECT_LICENSE]")
   *           .toString();
   *   UserListDirectLicense response =
   *       userListDirectLicenseServiceClient.getUserListDirectLicense(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the user list direct license.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserListDirectLicense getUserListDirectLicense(String name) {
    GetUserListDirectLicenseRequest request =
        GetUserListDirectLicenseRequest.newBuilder().setName(name).build();
    return getUserListDirectLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a user list direct license.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
   *     UserListDirectLicenseServiceClient.create()) {
   *   GetUserListDirectLicenseRequest request =
   *       GetUserListDirectLicenseRequest.newBuilder()
   *           .setName(
   *               UserListDirectLicenseName.of(
   *                       "[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_DIRECT_LICENSE]")
   *                   .toString())
   *           .build();
   *   UserListDirectLicense response =
   *       userListDirectLicenseServiceClient.getUserListDirectLicense(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserListDirectLicense getUserListDirectLicense(
      GetUserListDirectLicenseRequest request) {
    return getUserListDirectLicenseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a user list direct license.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
   *     UserListDirectLicenseServiceClient.create()) {
   *   GetUserListDirectLicenseRequest request =
   *       GetUserListDirectLicenseRequest.newBuilder()
   *           .setName(
   *               UserListDirectLicenseName.of(
   *                       "[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_DIRECT_LICENSE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<UserListDirectLicense> future =
   *       userListDirectLicenseServiceClient.getUserListDirectLicenseCallable().futureCall(request);
   *   // Do something.
   *   UserListDirectLicense response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetUserListDirectLicenseRequest, UserListDirectLicense>
      getUserListDirectLicenseCallable() {
    return stub.getUserListDirectLicenseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a user list direct license.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
   *     UserListDirectLicenseServiceClient.create()) {
   *   UserListDirectLicense userListDirectLicense = UserListDirectLicense.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UserListDirectLicense response =
   *       userListDirectLicenseServiceClient.updateUserListDirectLicense(
   *           userListDirectLicense, updateMask);
   * }
   * }</pre>
   *
   * @param userListDirectLicense Required. The licenses' `name` field is used to identify the
   *     license to update.
   * @param updateMask Optional. The list of fields to update. The special character `&#42;` is not
   *     supported and an `INVALID_UPDATE_MASK` error will be thrown if used.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserListDirectLicense updateUserListDirectLicense(
      UserListDirectLicense userListDirectLicense, FieldMask updateMask) {
    UpdateUserListDirectLicenseRequest request =
        UpdateUserListDirectLicenseRequest.newBuilder()
            .setUserListDirectLicense(userListDirectLicense)
            .setUpdateMask(updateMask)
            .build();
    return updateUserListDirectLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a user list direct license.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
   *     UserListDirectLicenseServiceClient.create()) {
   *   UpdateUserListDirectLicenseRequest request =
   *       UpdateUserListDirectLicenseRequest.newBuilder()
   *           .setUserListDirectLicense(UserListDirectLicense.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   UserListDirectLicense response =
   *       userListDirectLicenseServiceClient.updateUserListDirectLicense(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserListDirectLicense updateUserListDirectLicense(
      UpdateUserListDirectLicenseRequest request) {
    return updateUserListDirectLicenseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a user list direct license.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
   *     UserListDirectLicenseServiceClient.create()) {
   *   UpdateUserListDirectLicenseRequest request =
   *       UpdateUserListDirectLicenseRequest.newBuilder()
   *           .setUserListDirectLicense(UserListDirectLicense.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<UserListDirectLicense> future =
   *       userListDirectLicenseServiceClient
   *           .updateUserListDirectLicenseCallable()
   *           .futureCall(request);
   *   // Do something.
   *   UserListDirectLicense response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateUserListDirectLicenseRequest, UserListDirectLicense>
      updateUserListDirectLicenseCallable() {
    return stub.updateUserListDirectLicenseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user list direct licenses owned by the parent account.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
   *     UserListDirectLicenseServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
   *   for (UserListDirectLicense element :
   *       userListDirectLicenseServiceClient.listUserListDirectLicenses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account whose licenses are being queried. Should be in the format
   *     accountTypes/{ACCOUNT_TYPE}/accounts/{ACCOUNT_ID}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserListDirectLicensesPagedResponse listUserListDirectLicenses(
      AccountName parent) {
    ListUserListDirectLicensesRequest request =
        ListUserListDirectLicensesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUserListDirectLicenses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user list direct licenses owned by the parent account.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
   *     UserListDirectLicenseServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString();
   *   for (UserListDirectLicense element :
   *       userListDirectLicenseServiceClient.listUserListDirectLicenses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account whose licenses are being queried. Should be in the format
   *     accountTypes/{ACCOUNT_TYPE}/accounts/{ACCOUNT_ID}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserListDirectLicensesPagedResponse listUserListDirectLicenses(String parent) {
    ListUserListDirectLicensesRequest request =
        ListUserListDirectLicensesRequest.newBuilder().setParent(parent).build();
    return listUserListDirectLicenses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user list direct licenses owned by the parent account.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
   *     UserListDirectLicenseServiceClient.create()) {
   *   ListUserListDirectLicensesRequest request =
   *       ListUserListDirectLicensesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (UserListDirectLicense element :
   *       userListDirectLicenseServiceClient.listUserListDirectLicenses(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserListDirectLicensesPagedResponse listUserListDirectLicenses(
      ListUserListDirectLicensesRequest request) {
    return listUserListDirectLicensesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user list direct licenses owned by the parent account.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
   *     UserListDirectLicenseServiceClient.create()) {
   *   ListUserListDirectLicensesRequest request =
   *       ListUserListDirectLicensesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<UserListDirectLicense> future =
   *       userListDirectLicenseServiceClient
   *           .listUserListDirectLicensesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (UserListDirectLicense element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListUserListDirectLicensesRequest, ListUserListDirectLicensesPagedResponse>
      listUserListDirectLicensesPagedCallable() {
    return stub.listUserListDirectLicensesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user list direct licenses owned by the parent account.
   *
   * <p>This feature is only available to data partners.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListDirectLicenseServiceClient userListDirectLicenseServiceClient =
   *     UserListDirectLicenseServiceClient.create()) {
   *   ListUserListDirectLicensesRequest request =
   *       ListUserListDirectLicensesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListUserListDirectLicensesResponse response =
   *         userListDirectLicenseServiceClient.listUserListDirectLicensesCallable().call(request);
   *     for (UserListDirectLicense element : response.getUserListDirectLicensesList()) {
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
  public final UnaryCallable<ListUserListDirectLicensesRequest, ListUserListDirectLicensesResponse>
      listUserListDirectLicensesCallable() {
    return stub.listUserListDirectLicensesCallable();
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

  public static class ListUserListDirectLicensesPagedResponse
      extends AbstractPagedListResponse<
          ListUserListDirectLicensesRequest,
          ListUserListDirectLicensesResponse,
          UserListDirectLicense,
          ListUserListDirectLicensesPage,
          ListUserListDirectLicensesFixedSizeCollection> {

    public static ApiFuture<ListUserListDirectLicensesPagedResponse> createAsync(
        PageContext<
                ListUserListDirectLicensesRequest,
                ListUserListDirectLicensesResponse,
                UserListDirectLicense>
            context,
        ApiFuture<ListUserListDirectLicensesResponse> futureResponse) {
      ApiFuture<ListUserListDirectLicensesPage> futurePage =
          ListUserListDirectLicensesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListUserListDirectLicensesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListUserListDirectLicensesPagedResponse(ListUserListDirectLicensesPage page) {
      super(page, ListUserListDirectLicensesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUserListDirectLicensesPage
      extends AbstractPage<
          ListUserListDirectLicensesRequest,
          ListUserListDirectLicensesResponse,
          UserListDirectLicense,
          ListUserListDirectLicensesPage> {

    private ListUserListDirectLicensesPage(
        PageContext<
                ListUserListDirectLicensesRequest,
                ListUserListDirectLicensesResponse,
                UserListDirectLicense>
            context,
        ListUserListDirectLicensesResponse response) {
      super(context, response);
    }

    private static ListUserListDirectLicensesPage createEmptyPage() {
      return new ListUserListDirectLicensesPage(null, null);
    }

    @Override
    protected ListUserListDirectLicensesPage createPage(
        PageContext<
                ListUserListDirectLicensesRequest,
                ListUserListDirectLicensesResponse,
                UserListDirectLicense>
            context,
        ListUserListDirectLicensesResponse response) {
      return new ListUserListDirectLicensesPage(context, response);
    }

    @Override
    public ApiFuture<ListUserListDirectLicensesPage> createPageAsync(
        PageContext<
                ListUserListDirectLicensesRequest,
                ListUserListDirectLicensesResponse,
                UserListDirectLicense>
            context,
        ApiFuture<ListUserListDirectLicensesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUserListDirectLicensesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUserListDirectLicensesRequest,
          ListUserListDirectLicensesResponse,
          UserListDirectLicense,
          ListUserListDirectLicensesPage,
          ListUserListDirectLicensesFixedSizeCollection> {

    private ListUserListDirectLicensesFixedSizeCollection(
        List<ListUserListDirectLicensesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUserListDirectLicensesFixedSizeCollection createEmptyCollection() {
      return new ListUserListDirectLicensesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUserListDirectLicensesFixedSizeCollection createCollection(
        List<ListUserListDirectLicensesPage> pages, int collectionSize) {
      return new ListUserListDirectLicensesFixedSizeCollection(pages, collectionSize);
    }
  }
}
