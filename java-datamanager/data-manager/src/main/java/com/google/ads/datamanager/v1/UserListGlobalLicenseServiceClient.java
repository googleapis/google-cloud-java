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

import com.google.ads.datamanager.v1.stub.UserListGlobalLicenseServiceStub;
import com.google.ads.datamanager.v1.stub.UserListGlobalLicenseServiceStubSettings;
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
 * Service Description: Service for managing user list global licenses. Delete is not a supported
 * operation for UserListGlobalLicenses. Callers should update the license status to DISABLED to
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
 * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
 *     UserListGlobalLicenseServiceClient.create()) {
 *   AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
 *   UserListGlobalLicense userListGlobalLicense = UserListGlobalLicense.newBuilder().build();
 *   UserListGlobalLicense response =
 *       userListGlobalLicenseServiceClient.createUserListGlobalLicense(
 *           parent, userListGlobalLicense);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the UserListGlobalLicenseServiceClient object to clean up
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
 *      <td><p> CreateUserListGlobalLicense</td>
 *      <td><p> Creates a user list global license.
 * <p>  This feature is only available to data partners.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createUserListGlobalLicense(CreateUserListGlobalLicenseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createUserListGlobalLicense(AccountName parent, UserListGlobalLicense userListGlobalLicense)
 *           <li><p> createUserListGlobalLicense(String parent, UserListGlobalLicense userListGlobalLicense)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createUserListGlobalLicenseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateUserListGlobalLicense</td>
 *      <td><p> Updates a user list global license.
 * <p>  This feature is only available to data partners.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateUserListGlobalLicense(UpdateUserListGlobalLicenseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateUserListGlobalLicense(UserListGlobalLicense userListGlobalLicense, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateUserListGlobalLicenseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetUserListGlobalLicense</td>
 *      <td><p> Retrieves a user list global license.
 * <p>  This feature is only available to data partners.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getUserListGlobalLicense(GetUserListGlobalLicenseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getUserListGlobalLicense(UserListGlobalLicenseName name)
 *           <li><p> getUserListGlobalLicense(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getUserListGlobalLicenseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListUserListGlobalLicenses</td>
 *      <td><p> Lists all user list global licenses owned by the parent account.
 * <p>  This feature is only available to data partners.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listUserListGlobalLicenses(ListUserListGlobalLicensesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listUserListGlobalLicenses(AccountName parent)
 *           <li><p> listUserListGlobalLicenses(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listUserListGlobalLicensesPagedCallable()
 *           <li><p> listUserListGlobalLicensesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListUserListGlobalLicenseCustomerInfos</td>
 *      <td><p> Lists all customer info for a user list global license.
 * <p>  This feature is only available to data partners.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listUserListGlobalLicenseCustomerInfos(ListUserListGlobalLicenseCustomerInfosRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listUserListGlobalLicenseCustomerInfos(UserListGlobalLicenseName parent)
 *           <li><p> listUserListGlobalLicenseCustomerInfos(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listUserListGlobalLicenseCustomerInfosPagedCallable()
 *           <li><p> listUserListGlobalLicenseCustomerInfosCallable()
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
 * UserListGlobalLicenseServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * UserListGlobalLicenseServiceSettings userListGlobalLicenseServiceSettings =
 *     UserListGlobalLicenseServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
 *     UserListGlobalLicenseServiceClient.create(userListGlobalLicenseServiceSettings);
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
 * UserListGlobalLicenseServiceSettings userListGlobalLicenseServiceSettings =
 *     UserListGlobalLicenseServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
 *     UserListGlobalLicenseServiceClient.create(userListGlobalLicenseServiceSettings);
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
 * UserListGlobalLicenseServiceSettings userListGlobalLicenseServiceSettings =
 *     UserListGlobalLicenseServiceSettings.newHttpJsonBuilder().build();
 * UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
 *     UserListGlobalLicenseServiceClient.create(userListGlobalLicenseServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class UserListGlobalLicenseServiceClient implements BackgroundResource {
  private final UserListGlobalLicenseServiceSettings settings;
  private final UserListGlobalLicenseServiceStub stub;

  /** Constructs an instance of UserListGlobalLicenseServiceClient with default settings. */
  public static final UserListGlobalLicenseServiceClient create() throws IOException {
    return create(UserListGlobalLicenseServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of UserListGlobalLicenseServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final UserListGlobalLicenseServiceClient create(
      UserListGlobalLicenseServiceSettings settings) throws IOException {
    return new UserListGlobalLicenseServiceClient(settings);
  }

  /**
   * Constructs an instance of UserListGlobalLicenseServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(UserListGlobalLicenseServiceSettings).
   */
  public static final UserListGlobalLicenseServiceClient create(
      UserListGlobalLicenseServiceStub stub) {
    return new UserListGlobalLicenseServiceClient(stub);
  }

  /**
   * Constructs an instance of UserListGlobalLicenseServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected UserListGlobalLicenseServiceClient(UserListGlobalLicenseServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((UserListGlobalLicenseServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected UserListGlobalLicenseServiceClient(UserListGlobalLicenseServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final UserListGlobalLicenseServiceSettings getSettings() {
    return settings;
  }

  public UserListGlobalLicenseServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user list global license.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
   *   UserListGlobalLicense userListGlobalLicense = UserListGlobalLicense.newBuilder().build();
   *   UserListGlobalLicense response =
   *       userListGlobalLicenseServiceClient.createUserListGlobalLicense(
   *           parent, userListGlobalLicense);
   * }
   * }</pre>
   *
   * @param parent Required. The account that owns the user list being licensed. Should be in the
   *     format accountTypes/{ACCOUNT_TYPE}/accounts/{ACCOUNT_ID}
   * @param userListGlobalLicense Required. The user list global license to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserListGlobalLicense createUserListGlobalLicense(
      AccountName parent, UserListGlobalLicense userListGlobalLicense) {
    CreateUserListGlobalLicenseRequest request =
        CreateUserListGlobalLicenseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUserListGlobalLicense(userListGlobalLicense)
            .build();
    return createUserListGlobalLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user list global license.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString();
   *   UserListGlobalLicense userListGlobalLicense = UserListGlobalLicense.newBuilder().build();
   *   UserListGlobalLicense response =
   *       userListGlobalLicenseServiceClient.createUserListGlobalLicense(
   *           parent, userListGlobalLicense);
   * }
   * }</pre>
   *
   * @param parent Required. The account that owns the user list being licensed. Should be in the
   *     format accountTypes/{ACCOUNT_TYPE}/accounts/{ACCOUNT_ID}
   * @param userListGlobalLicense Required. The user list global license to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserListGlobalLicense createUserListGlobalLicense(
      String parent, UserListGlobalLicense userListGlobalLicense) {
    CreateUserListGlobalLicenseRequest request =
        CreateUserListGlobalLicenseRequest.newBuilder()
            .setParent(parent)
            .setUserListGlobalLicense(userListGlobalLicense)
            .build();
    return createUserListGlobalLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user list global license.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   CreateUserListGlobalLicenseRequest request =
   *       CreateUserListGlobalLicenseRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setUserListGlobalLicense(UserListGlobalLicense.newBuilder().build())
   *           .build();
   *   UserListGlobalLicense response =
   *       userListGlobalLicenseServiceClient.createUserListGlobalLicense(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserListGlobalLicense createUserListGlobalLicense(
      CreateUserListGlobalLicenseRequest request) {
    return createUserListGlobalLicenseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a user list global license.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   CreateUserListGlobalLicenseRequest request =
   *       CreateUserListGlobalLicenseRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setUserListGlobalLicense(UserListGlobalLicense.newBuilder().build())
   *           .build();
   *   ApiFuture<UserListGlobalLicense> future =
   *       userListGlobalLicenseServiceClient
   *           .createUserListGlobalLicenseCallable()
   *           .futureCall(request);
   *   // Do something.
   *   UserListGlobalLicense response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateUserListGlobalLicenseRequest, UserListGlobalLicense>
      createUserListGlobalLicenseCallable() {
    return stub.createUserListGlobalLicenseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a user list global license.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   UserListGlobalLicense userListGlobalLicense = UserListGlobalLicense.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UserListGlobalLicense response =
   *       userListGlobalLicenseServiceClient.updateUserListGlobalLicense(
   *           userListGlobalLicense, updateMask);
   * }
   * }</pre>
   *
   * @param userListGlobalLicense Required. The licenses' `name` field is used to identify the
   *     license to update.
   * @param updateMask Optional. The list of fields to update. The special character `&#42;` is not
   *     supported and an `INVALID_UPDATE_MASK` error will be thrown if used.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserListGlobalLicense updateUserListGlobalLicense(
      UserListGlobalLicense userListGlobalLicense, FieldMask updateMask) {
    UpdateUserListGlobalLicenseRequest request =
        UpdateUserListGlobalLicenseRequest.newBuilder()
            .setUserListGlobalLicense(userListGlobalLicense)
            .setUpdateMask(updateMask)
            .build();
    return updateUserListGlobalLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a user list global license.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   UpdateUserListGlobalLicenseRequest request =
   *       UpdateUserListGlobalLicenseRequest.newBuilder()
   *           .setUserListGlobalLicense(UserListGlobalLicense.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   UserListGlobalLicense response =
   *       userListGlobalLicenseServiceClient.updateUserListGlobalLicense(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserListGlobalLicense updateUserListGlobalLicense(
      UpdateUserListGlobalLicenseRequest request) {
    return updateUserListGlobalLicenseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a user list global license.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   UpdateUserListGlobalLicenseRequest request =
   *       UpdateUserListGlobalLicenseRequest.newBuilder()
   *           .setUserListGlobalLicense(UserListGlobalLicense.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<UserListGlobalLicense> future =
   *       userListGlobalLicenseServiceClient
   *           .updateUserListGlobalLicenseCallable()
   *           .futureCall(request);
   *   // Do something.
   *   UserListGlobalLicense response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateUserListGlobalLicenseRequest, UserListGlobalLicense>
      updateUserListGlobalLicenseCallable() {
    return stub.updateUserListGlobalLicenseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a user list global license.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   UserListGlobalLicenseName name =
   *       UserListGlobalLicenseName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]");
   *   UserListGlobalLicense response =
   *       userListGlobalLicenseServiceClient.getUserListGlobalLicense(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the user list global license.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserListGlobalLicense getUserListGlobalLicense(UserListGlobalLicenseName name) {
    GetUserListGlobalLicenseRequest request =
        GetUserListGlobalLicenseRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getUserListGlobalLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a user list global license.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   String name =
   *       UserListGlobalLicenseName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]")
   *           .toString();
   *   UserListGlobalLicense response =
   *       userListGlobalLicenseServiceClient.getUserListGlobalLicense(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the user list global license.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserListGlobalLicense getUserListGlobalLicense(String name) {
    GetUserListGlobalLicenseRequest request =
        GetUserListGlobalLicenseRequest.newBuilder().setName(name).build();
    return getUserListGlobalLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a user list global license.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   GetUserListGlobalLicenseRequest request =
   *       GetUserListGlobalLicenseRequest.newBuilder()
   *           .setName(
   *               UserListGlobalLicenseName.of(
   *                       "[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]")
   *                   .toString())
   *           .build();
   *   UserListGlobalLicense response =
   *       userListGlobalLicenseServiceClient.getUserListGlobalLicense(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserListGlobalLicense getUserListGlobalLicense(
      GetUserListGlobalLicenseRequest request) {
    return getUserListGlobalLicenseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a user list global license.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   GetUserListGlobalLicenseRequest request =
   *       GetUserListGlobalLicenseRequest.newBuilder()
   *           .setName(
   *               UserListGlobalLicenseName.of(
   *                       "[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<UserListGlobalLicense> future =
   *       userListGlobalLicenseServiceClient.getUserListGlobalLicenseCallable().futureCall(request);
   *   // Do something.
   *   UserListGlobalLicense response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetUserListGlobalLicenseRequest, UserListGlobalLicense>
      getUserListGlobalLicenseCallable() {
    return stub.getUserListGlobalLicenseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user list global licenses owned by the parent account.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
   *   for (UserListGlobalLicense element :
   *       userListGlobalLicenseServiceClient.listUserListGlobalLicenses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account whose licenses are being queried. Should be in the format
   *     accountTypes/{ACCOUNT_TYPE}/accounts/{ACCOUNT_ID}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserListGlobalLicensesPagedResponse listUserListGlobalLicenses(
      AccountName parent) {
    ListUserListGlobalLicensesRequest request =
        ListUserListGlobalLicensesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUserListGlobalLicenses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user list global licenses owned by the parent account.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString();
   *   for (UserListGlobalLicense element :
   *       userListGlobalLicenseServiceClient.listUserListGlobalLicenses(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account whose licenses are being queried. Should be in the format
   *     accountTypes/{ACCOUNT_TYPE}/accounts/{ACCOUNT_ID}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserListGlobalLicensesPagedResponse listUserListGlobalLicenses(String parent) {
    ListUserListGlobalLicensesRequest request =
        ListUserListGlobalLicensesRequest.newBuilder().setParent(parent).build();
    return listUserListGlobalLicenses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user list global licenses owned by the parent account.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   ListUserListGlobalLicensesRequest request =
   *       ListUserListGlobalLicensesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (UserListGlobalLicense element :
   *       userListGlobalLicenseServiceClient.listUserListGlobalLicenses(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserListGlobalLicensesPagedResponse listUserListGlobalLicenses(
      ListUserListGlobalLicensesRequest request) {
    return listUserListGlobalLicensesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user list global licenses owned by the parent account.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   ListUserListGlobalLicensesRequest request =
   *       ListUserListGlobalLicensesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<UserListGlobalLicense> future =
   *       userListGlobalLicenseServiceClient
   *           .listUserListGlobalLicensesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (UserListGlobalLicense element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesPagedResponse>
      listUserListGlobalLicensesPagedCallable() {
    return stub.listUserListGlobalLicensesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all user list global licenses owned by the parent account.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   ListUserListGlobalLicensesRequest request =
   *       ListUserListGlobalLicensesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListUserListGlobalLicensesResponse response =
   *         userListGlobalLicenseServiceClient.listUserListGlobalLicensesCallable().call(request);
   *     for (UserListGlobalLicense element : response.getUserListGlobalLicensesList()) {
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
  public final UnaryCallable<ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesResponse>
      listUserListGlobalLicensesCallable() {
    return stub.listUserListGlobalLicensesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all customer info for a user list global license.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   UserListGlobalLicenseName parent =
   *       UserListGlobalLicenseName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]");
   *   for (UserListGlobalLicenseCustomerInfo element :
   *       userListGlobalLicenseServiceClient
   *           .listUserListGlobalLicenseCustomerInfos(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The global license whose customer info are being queried. Should be in
   *     the format
   *     `accountTypes/{ACCOUNT_TYPE}/accounts/{ACCOUNT_ID}/userListGlobalLicenses/{USER_LIST_GLOBAL_LICENSE_ID}`.
   *     To list all global license customer info under an account, replace the user list global
   *     license id with a '-' (for example,
   *     `accountTypes/DATA_PARTNER/accounts/123/userListGlobalLicenses/-`)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserListGlobalLicenseCustomerInfosPagedResponse
      listUserListGlobalLicenseCustomerInfos(UserListGlobalLicenseName parent) {
    ListUserListGlobalLicenseCustomerInfosRequest request =
        ListUserListGlobalLicenseCustomerInfosRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUserListGlobalLicenseCustomerInfos(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all customer info for a user list global license.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   String parent =
   *       UserListGlobalLicenseName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]")
   *           .toString();
   *   for (UserListGlobalLicenseCustomerInfo element :
   *       userListGlobalLicenseServiceClient
   *           .listUserListGlobalLicenseCustomerInfos(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The global license whose customer info are being queried. Should be in
   *     the format
   *     `accountTypes/{ACCOUNT_TYPE}/accounts/{ACCOUNT_ID}/userListGlobalLicenses/{USER_LIST_GLOBAL_LICENSE_ID}`.
   *     To list all global license customer info under an account, replace the user list global
   *     license id with a '-' (for example,
   *     `accountTypes/DATA_PARTNER/accounts/123/userListGlobalLicenses/-`)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserListGlobalLicenseCustomerInfosPagedResponse
      listUserListGlobalLicenseCustomerInfos(String parent) {
    ListUserListGlobalLicenseCustomerInfosRequest request =
        ListUserListGlobalLicenseCustomerInfosRequest.newBuilder().setParent(parent).build();
    return listUserListGlobalLicenseCustomerInfos(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all customer info for a user list global license.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   ListUserListGlobalLicenseCustomerInfosRequest request =
   *       ListUserListGlobalLicenseCustomerInfosRequest.newBuilder()
   *           .setParent(
   *               UserListGlobalLicenseName.of(
   *                       "[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (UserListGlobalLicenseCustomerInfo element :
   *       userListGlobalLicenseServiceClient
   *           .listUserListGlobalLicenseCustomerInfos(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserListGlobalLicenseCustomerInfosPagedResponse
      listUserListGlobalLicenseCustomerInfos(
          ListUserListGlobalLicenseCustomerInfosRequest request) {
    return listUserListGlobalLicenseCustomerInfosPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all customer info for a user list global license.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   ListUserListGlobalLicenseCustomerInfosRequest request =
   *       ListUserListGlobalLicenseCustomerInfosRequest.newBuilder()
   *           .setParent(
   *               UserListGlobalLicenseName.of(
   *                       "[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<UserListGlobalLicenseCustomerInfo> future =
   *       userListGlobalLicenseServiceClient
   *           .listUserListGlobalLicenseCustomerInfosPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (UserListGlobalLicenseCustomerInfo element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosPagedResponse>
      listUserListGlobalLicenseCustomerInfosPagedCallable() {
    return stub.listUserListGlobalLicenseCustomerInfosPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all customer info for a user list global license.
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
   * try (UserListGlobalLicenseServiceClient userListGlobalLicenseServiceClient =
   *     UserListGlobalLicenseServiceClient.create()) {
   *   ListUserListGlobalLicenseCustomerInfosRequest request =
   *       ListUserListGlobalLicenseCustomerInfosRequest.newBuilder()
   *           .setParent(
   *               UserListGlobalLicenseName.of(
   *                       "[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST_GLOBAL_LICENSE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListUserListGlobalLicenseCustomerInfosResponse response =
   *         userListGlobalLicenseServiceClient
   *             .listUserListGlobalLicenseCustomerInfosCallable()
   *             .call(request);
   *     for (UserListGlobalLicenseCustomerInfo element :
   *         response.getUserListGlobalLicenseCustomerInfosList()) {
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
  public final UnaryCallable<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosResponse>
      listUserListGlobalLicenseCustomerInfosCallable() {
    return stub.listUserListGlobalLicenseCustomerInfosCallable();
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

  public static class ListUserListGlobalLicensesPagedResponse
      extends AbstractPagedListResponse<
          ListUserListGlobalLicensesRequest,
          ListUserListGlobalLicensesResponse,
          UserListGlobalLicense,
          ListUserListGlobalLicensesPage,
          ListUserListGlobalLicensesFixedSizeCollection> {

    public static ApiFuture<ListUserListGlobalLicensesPagedResponse> createAsync(
        PageContext<
                ListUserListGlobalLicensesRequest,
                ListUserListGlobalLicensesResponse,
                UserListGlobalLicense>
            context,
        ApiFuture<ListUserListGlobalLicensesResponse> futureResponse) {
      ApiFuture<ListUserListGlobalLicensesPage> futurePage =
          ListUserListGlobalLicensesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListUserListGlobalLicensesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListUserListGlobalLicensesPagedResponse(ListUserListGlobalLicensesPage page) {
      super(page, ListUserListGlobalLicensesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUserListGlobalLicensesPage
      extends AbstractPage<
          ListUserListGlobalLicensesRequest,
          ListUserListGlobalLicensesResponse,
          UserListGlobalLicense,
          ListUserListGlobalLicensesPage> {

    private ListUserListGlobalLicensesPage(
        PageContext<
                ListUserListGlobalLicensesRequest,
                ListUserListGlobalLicensesResponse,
                UserListGlobalLicense>
            context,
        ListUserListGlobalLicensesResponse response) {
      super(context, response);
    }

    private static ListUserListGlobalLicensesPage createEmptyPage() {
      return new ListUserListGlobalLicensesPage(null, null);
    }

    @Override
    protected ListUserListGlobalLicensesPage createPage(
        PageContext<
                ListUserListGlobalLicensesRequest,
                ListUserListGlobalLicensesResponse,
                UserListGlobalLicense>
            context,
        ListUserListGlobalLicensesResponse response) {
      return new ListUserListGlobalLicensesPage(context, response);
    }

    @Override
    public ApiFuture<ListUserListGlobalLicensesPage> createPageAsync(
        PageContext<
                ListUserListGlobalLicensesRequest,
                ListUserListGlobalLicensesResponse,
                UserListGlobalLicense>
            context,
        ApiFuture<ListUserListGlobalLicensesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUserListGlobalLicensesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUserListGlobalLicensesRequest,
          ListUserListGlobalLicensesResponse,
          UserListGlobalLicense,
          ListUserListGlobalLicensesPage,
          ListUserListGlobalLicensesFixedSizeCollection> {

    private ListUserListGlobalLicensesFixedSizeCollection(
        List<ListUserListGlobalLicensesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUserListGlobalLicensesFixedSizeCollection createEmptyCollection() {
      return new ListUserListGlobalLicensesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUserListGlobalLicensesFixedSizeCollection createCollection(
        List<ListUserListGlobalLicensesPage> pages, int collectionSize) {
      return new ListUserListGlobalLicensesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListUserListGlobalLicenseCustomerInfosPagedResponse
      extends AbstractPagedListResponse<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosResponse,
          UserListGlobalLicenseCustomerInfo,
          ListUserListGlobalLicenseCustomerInfosPage,
          ListUserListGlobalLicenseCustomerInfosFixedSizeCollection> {

    public static ApiFuture<ListUserListGlobalLicenseCustomerInfosPagedResponse> createAsync(
        PageContext<
                ListUserListGlobalLicenseCustomerInfosRequest,
                ListUserListGlobalLicenseCustomerInfosResponse,
                UserListGlobalLicenseCustomerInfo>
            context,
        ApiFuture<ListUserListGlobalLicenseCustomerInfosResponse> futureResponse) {
      ApiFuture<ListUserListGlobalLicenseCustomerInfosPage> futurePage =
          ListUserListGlobalLicenseCustomerInfosPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListUserListGlobalLicenseCustomerInfosPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListUserListGlobalLicenseCustomerInfosPagedResponse(
        ListUserListGlobalLicenseCustomerInfosPage page) {
      super(
          page, ListUserListGlobalLicenseCustomerInfosFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUserListGlobalLicenseCustomerInfosPage
      extends AbstractPage<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosResponse,
          UserListGlobalLicenseCustomerInfo,
          ListUserListGlobalLicenseCustomerInfosPage> {

    private ListUserListGlobalLicenseCustomerInfosPage(
        PageContext<
                ListUserListGlobalLicenseCustomerInfosRequest,
                ListUserListGlobalLicenseCustomerInfosResponse,
                UserListGlobalLicenseCustomerInfo>
            context,
        ListUserListGlobalLicenseCustomerInfosResponse response) {
      super(context, response);
    }

    private static ListUserListGlobalLicenseCustomerInfosPage createEmptyPage() {
      return new ListUserListGlobalLicenseCustomerInfosPage(null, null);
    }

    @Override
    protected ListUserListGlobalLicenseCustomerInfosPage createPage(
        PageContext<
                ListUserListGlobalLicenseCustomerInfosRequest,
                ListUserListGlobalLicenseCustomerInfosResponse,
                UserListGlobalLicenseCustomerInfo>
            context,
        ListUserListGlobalLicenseCustomerInfosResponse response) {
      return new ListUserListGlobalLicenseCustomerInfosPage(context, response);
    }

    @Override
    public ApiFuture<ListUserListGlobalLicenseCustomerInfosPage> createPageAsync(
        PageContext<
                ListUserListGlobalLicenseCustomerInfosRequest,
                ListUserListGlobalLicenseCustomerInfosResponse,
                UserListGlobalLicenseCustomerInfo>
            context,
        ApiFuture<ListUserListGlobalLicenseCustomerInfosResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUserListGlobalLicenseCustomerInfosFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosResponse,
          UserListGlobalLicenseCustomerInfo,
          ListUserListGlobalLicenseCustomerInfosPage,
          ListUserListGlobalLicenseCustomerInfosFixedSizeCollection> {

    private ListUserListGlobalLicenseCustomerInfosFixedSizeCollection(
        List<ListUserListGlobalLicenseCustomerInfosPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUserListGlobalLicenseCustomerInfosFixedSizeCollection
        createEmptyCollection() {
      return new ListUserListGlobalLicenseCustomerInfosFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUserListGlobalLicenseCustomerInfosFixedSizeCollection createCollection(
        List<ListUserListGlobalLicenseCustomerInfosPage> pages, int collectionSize) {
      return new ListUserListGlobalLicenseCustomerInfosFixedSizeCollection(pages, collectionSize);
    }
  }
}
