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

import com.google.ads.datamanager.v1.stub.UserListServiceStub;
import com.google.ads.datamanager.v1.stub.UserListServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing UserList resources.
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
 * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
 *   UserListName name = UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]");
 *   UserList response = userListServiceClient.getUserList(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the UserListServiceClient object to clean up resources
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
 *      <td><p> GetUserList</td>
 *      <td><p> Gets a UserList.
 * <p>  Authorization Headers:
 * <p>  This method supports the following optional headers to define how the API authorizes access for the request:
 * <ul>
 * <li>  `login-account`: (Optional) The resource name of the account where the   Google Account of the credentials is a user. If not set, defaults to the   account of the request. Format:   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
 * <li>  `linked-account`: (Optional) The resource name of the account with an    established product link to the `login-account`. Format:    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
 * </ul></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getUserList(GetUserListRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getUserList(UserListName name)
 *           <li><p> getUserList(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getUserListCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListUserLists</td>
 *      <td><p> Lists UserLists.
 * <p>  Authorization Headers:
 * <p>  This method supports the following optional headers to define how the API authorizes access for the request:
 * <ul>
 * <li>  `login-account`: (Optional) The resource name of the account where the   Google Account of the credentials is a user. If not set, defaults to the   account of the request. Format:   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
 * <li>  `linked-account`: (Optional) The resource name of the account with an    established product link to the `login-account`. Format:    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
 * </ul></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listUserLists(ListUserListsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listUserLists(AccountName parent)
 *           <li><p> listUserLists(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listUserListsPagedCallable()
 *           <li><p> listUserListsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateUserList</td>
 *      <td><p> Creates a UserList.
 * <p>  Authorization Headers:
 * <p>  This method supports the following optional headers to define how the API authorizes access for the request:
 * <ul>
 * <li>  `login-account`: (Optional) The resource name of the account where the   Google Account of the credentials is a user. If not set, defaults to the   account of the request. Format:   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
 * <li>  `linked-account`: (Optional) The resource name of the account with an    established product link to the `login-account`. Format:    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
 * </ul></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createUserList(CreateUserListRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createUserList(AccountName parent, UserList userList)
 *           <li><p> createUserList(String parent, UserList userList)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createUserListCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateUserList</td>
 *      <td><p> Updates a UserList.
 * <p>  Authorization Headers:
 * <p>  This method supports the following optional headers to define how the API authorizes access for the request:
 * <ul>
 * <li>  `login-account`: (Optional) The resource name of the account where the   Google Account of the credentials is a user. If not set, defaults to the   account of the request. Format:   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
 * <li>  `linked-account`: (Optional) The resource name of the account with an    established product link to the `login-account`. Format:    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
 * </ul></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateUserList(UpdateUserListRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateUserList(UserList userList, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateUserListCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteUserList</td>
 *      <td><p> Deletes a UserList.
 * <p>  Authorization Headers:
 * <p>  This method supports the following optional headers to define how the API authorizes access for the request:
 * <ul>
 * <li>  `login-account`: (Optional) The resource name of the account where the   Google Account of the credentials is a user. If not set, defaults to the   account of the request. Format:   `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
 * <li>  `linked-account`: (Optional) The resource name of the account with an    established product link to the `login-account`. Format:    `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
 * </ul></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteUserList(DeleteUserListRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteUserList(UserListName name)
 *           <li><p> deleteUserList(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteUserListCallable()
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
 * <p>This class can be customized by passing in a custom instance of UserListServiceSettings to
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
 * UserListServiceSettings userListServiceSettings =
 *     UserListServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * UserListServiceClient userListServiceClient =
 *     UserListServiceClient.create(userListServiceSettings);
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
 * UserListServiceSettings userListServiceSettings =
 *     UserListServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * UserListServiceClient userListServiceClient =
 *     UserListServiceClient.create(userListServiceSettings);
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
 * UserListServiceSettings userListServiceSettings =
 *     UserListServiceSettings.newHttpJsonBuilder().build();
 * UserListServiceClient userListServiceClient =
 *     UserListServiceClient.create(userListServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class UserListServiceClient implements BackgroundResource {
  private final UserListServiceSettings settings;
  private final UserListServiceStub stub;

  /** Constructs an instance of UserListServiceClient with default settings. */
  public static final UserListServiceClient create() throws IOException {
    return create(UserListServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of UserListServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final UserListServiceClient create(UserListServiceSettings settings)
      throws IOException {
    return new UserListServiceClient(settings);
  }

  /**
   * Constructs an instance of UserListServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(UserListServiceSettings).
   */
  public static final UserListServiceClient create(UserListServiceStub stub) {
    return new UserListServiceClient(stub);
  }

  /**
   * Constructs an instance of UserListServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected UserListServiceClient(UserListServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((UserListServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected UserListServiceClient(UserListServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final UserListServiceSettings getSettings() {
    return settings;
  }

  public UserListServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a UserList.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   UserListName name = UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]");
   *   UserList response = userListServiceClient.getUserList(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the UserList to retrieve. Format:
   *     accountTypes/{account_type}/accounts/{account}/userLists/{user_list}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserList getUserList(UserListName name) {
    GetUserListRequest request =
        GetUserListRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getUserList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a UserList.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   String name = UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]").toString();
   *   UserList response = userListServiceClient.getUserList(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the UserList to retrieve. Format:
   *     accountTypes/{account_type}/accounts/{account}/userLists/{user_list}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserList getUserList(String name) {
    GetUserListRequest request = GetUserListRequest.newBuilder().setName(name).build();
    return getUserList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a UserList.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   GetUserListRequest request =
   *       GetUserListRequest.newBuilder()
   *           .setName(UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]").toString())
   *           .build();
   *   UserList response = userListServiceClient.getUserList(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserList getUserList(GetUserListRequest request) {
    return getUserListCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a UserList.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   GetUserListRequest request =
   *       GetUserListRequest.newBuilder()
   *           .setName(UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]").toString())
   *           .build();
   *   ApiFuture<UserList> future = userListServiceClient.getUserListCallable().futureCall(request);
   *   // Do something.
   *   UserList response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetUserListRequest, UserList> getUserListCallable() {
    return stub.getUserListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists UserLists.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
   *   for (UserList element : userListServiceClient.listUserLists(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent account which owns this collection of user lists. Format:
   *     accountTypes/{account_type}/accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserListsPagedResponse listUserLists(AccountName parent) {
    ListUserListsRequest request =
        ListUserListsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUserLists(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists UserLists.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString();
   *   for (UserList element : userListServiceClient.listUserLists(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent account which owns this collection of user lists. Format:
   *     accountTypes/{account_type}/accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserListsPagedResponse listUserLists(String parent) {
    ListUserListsRequest request = ListUserListsRequest.newBuilder().setParent(parent).build();
    return listUserLists(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists UserLists.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   ListUserListsRequest request =
   *       ListUserListsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (UserList element : userListServiceClient.listUserLists(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserListsPagedResponse listUserLists(ListUserListsRequest request) {
    return listUserListsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists UserLists.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   ListUserListsRequest request =
   *       ListUserListsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<UserList> future =
   *       userListServiceClient.listUserListsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (UserList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUserListsRequest, ListUserListsPagedResponse>
      listUserListsPagedCallable() {
    return stub.listUserListsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists UserLists.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   ListUserListsRequest request =
   *       ListUserListsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListUserListsResponse response =
   *         userListServiceClient.listUserListsCallable().call(request);
   *     for (UserList element : response.getUserListsList()) {
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
  public final UnaryCallable<ListUserListsRequest, ListUserListsResponse> listUserListsCallable() {
    return stub.listUserListsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a UserList.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]");
   *   UserList userList = UserList.newBuilder().build();
   *   UserList response = userListServiceClient.createUserList(parent, userList);
   * }
   * }</pre>
   *
   * @param parent Required. The parent account where this user list will be created. Format:
   *     accountTypes/{account_type}/accounts/{account}
   * @param userList Required. The user list to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserList createUserList(AccountName parent, UserList userList) {
    CreateUserListRequest request =
        CreateUserListRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUserList(userList)
            .build();
    return createUserList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a UserList.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString();
   *   UserList userList = UserList.newBuilder().build();
   *   UserList response = userListServiceClient.createUserList(parent, userList);
   * }
   * }</pre>
   *
   * @param parent Required. The parent account where this user list will be created. Format:
   *     accountTypes/{account_type}/accounts/{account}
   * @param userList Required. The user list to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserList createUserList(String parent, UserList userList) {
    CreateUserListRequest request =
        CreateUserListRequest.newBuilder().setParent(parent).setUserList(userList).build();
    return createUserList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a UserList.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   CreateUserListRequest request =
   *       CreateUserListRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setUserList(UserList.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   UserList response = userListServiceClient.createUserList(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserList createUserList(CreateUserListRequest request) {
    return createUserListCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a UserList.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   CreateUserListRequest request =
   *       CreateUserListRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
   *           .setUserList(UserList.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<UserList> future =
   *       userListServiceClient.createUserListCallable().futureCall(request);
   *   // Do something.
   *   UserList response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateUserListRequest, UserList> createUserListCallable() {
    return stub.createUserListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a UserList.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   UserList userList = UserList.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UserList response = userListServiceClient.updateUserList(userList, updateMask);
   * }
   * }</pre>
   *
   * @param userList Required. The user list to update.
   *     <p>The user list's `name` field is used to identify the user list to update. Format:
   *     accountTypes/{account_type}/accounts/{account}/userLists/{user_list}
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserList updateUserList(UserList userList, FieldMask updateMask) {
    UpdateUserListRequest request =
        UpdateUserListRequest.newBuilder().setUserList(userList).setUpdateMask(updateMask).build();
    return updateUserList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a UserList.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   UpdateUserListRequest request =
   *       UpdateUserListRequest.newBuilder()
   *           .setUserList(UserList.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   UserList response = userListServiceClient.updateUserList(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserList updateUserList(UpdateUserListRequest request) {
    return updateUserListCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a UserList.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   UpdateUserListRequest request =
   *       UpdateUserListRequest.newBuilder()
   *           .setUserList(UserList.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<UserList> future =
   *       userListServiceClient.updateUserListCallable().futureCall(request);
   *   // Do something.
   *   UserList response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateUserListRequest, UserList> updateUserListCallable() {
    return stub.updateUserListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a UserList.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   UserListName name = UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]");
   *   userListServiceClient.deleteUserList(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the user list to delete. Format:
   *     accountTypes/{account_type}/accounts/{account}/userLists/{user_list}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUserList(UserListName name) {
    DeleteUserListRequest request =
        DeleteUserListRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteUserList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a UserList.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   String name = UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]").toString();
   *   userListServiceClient.deleteUserList(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the user list to delete. Format:
   *     accountTypes/{account_type}/accounts/{account}/userLists/{user_list}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUserList(String name) {
    DeleteUserListRequest request = DeleteUserListRequest.newBuilder().setName(name).build();
    deleteUserList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a UserList.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   DeleteUserListRequest request =
   *       DeleteUserListRequest.newBuilder()
   *           .setName(UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]").toString())
   *           .setValidateOnly(true)
   *           .build();
   *   userListServiceClient.deleteUserList(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUserList(DeleteUserListRequest request) {
    deleteUserListCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a UserList.
   *
   * <p>Authorization Headers:
   *
   * <p>This method supports the following optional headers to define how the API authorizes access
   * for the request:
   *
   * <ul>
   *   <li>`login-account`: (Optional) The resource name of the account where the Google Account of
   *       the credentials is a user. If not set, defaults to the account of the request. Format:
   *       `accountTypes/{loginAccountType}/accounts/{loginAccountId}`
   *   <li>`linked-account`: (Optional) The resource name of the account with an established product
   *       link to the `login-account`. Format:
   *       `accountTypes/{linkedAccountType}/accounts/{linkedAccountId}`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserListServiceClient userListServiceClient = UserListServiceClient.create()) {
   *   DeleteUserListRequest request =
   *       DeleteUserListRequest.newBuilder()
   *           .setName(UserListName.of("[ACCOUNT_TYPE]", "[ACCOUNT]", "[USER_LIST]").toString())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Empty> future = userListServiceClient.deleteUserListCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteUserListRequest, Empty> deleteUserListCallable() {
    return stub.deleteUserListCallable();
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

  public static class ListUserListsPagedResponse
      extends AbstractPagedListResponse<
          ListUserListsRequest,
          ListUserListsResponse,
          UserList,
          ListUserListsPage,
          ListUserListsFixedSizeCollection> {

    public static ApiFuture<ListUserListsPagedResponse> createAsync(
        PageContext<ListUserListsRequest, ListUserListsResponse, UserList> context,
        ApiFuture<ListUserListsResponse> futureResponse) {
      ApiFuture<ListUserListsPage> futurePage =
          ListUserListsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListUserListsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListUserListsPagedResponse(ListUserListsPage page) {
      super(page, ListUserListsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUserListsPage
      extends AbstractPage<
          ListUserListsRequest, ListUserListsResponse, UserList, ListUserListsPage> {

    private ListUserListsPage(
        PageContext<ListUserListsRequest, ListUserListsResponse, UserList> context,
        ListUserListsResponse response) {
      super(context, response);
    }

    private static ListUserListsPage createEmptyPage() {
      return new ListUserListsPage(null, null);
    }

    @Override
    protected ListUserListsPage createPage(
        PageContext<ListUserListsRequest, ListUserListsResponse, UserList> context,
        ListUserListsResponse response) {
      return new ListUserListsPage(context, response);
    }

    @Override
    public ApiFuture<ListUserListsPage> createPageAsync(
        PageContext<ListUserListsRequest, ListUserListsResponse, UserList> context,
        ApiFuture<ListUserListsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUserListsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUserListsRequest,
          ListUserListsResponse,
          UserList,
          ListUserListsPage,
          ListUserListsFixedSizeCollection> {

    private ListUserListsFixedSizeCollection(List<ListUserListsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUserListsFixedSizeCollection createEmptyCollection() {
      return new ListUserListsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUserListsFixedSizeCollection createCollection(
        List<ListUserListsPage> pages, int collectionSize) {
      return new ListUserListsFixedSizeCollection(pages, collectionSize);
    }
  }
}
