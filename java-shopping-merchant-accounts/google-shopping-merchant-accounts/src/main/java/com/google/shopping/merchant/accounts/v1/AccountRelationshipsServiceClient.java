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

package com.google.shopping.merchant.accounts.v1;

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
import com.google.shopping.merchant.accounts.v1.stub.AccountRelationshipsServiceStub;
import com.google.shopping.merchant.accounts.v1.stub.AccountRelationshipsServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to support AccountRelationship API.
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
 * try (AccountRelationshipsServiceClient accountRelationshipsServiceClient =
 *     AccountRelationshipsServiceClient.create()) {
 *   AccountRelationshipName name = AccountRelationshipName.of("[ACCOUNT]", "[RELATIONSHIP]");
 *   AccountRelationship response = accountRelationshipsServiceClient.getAccountRelationship(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AccountRelationshipsServiceClient object to clean up
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
 *      <td><p> GetAccountRelationship</td>
 *      <td><p> Retrieve an account relationship.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAccountRelationship(GetAccountRelationshipRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAccountRelationship(AccountRelationshipName name)
 *           <li><p> getAccountRelationship(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAccountRelationshipCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAccountRelationship</td>
 *      <td><p> Updates the account relationship. Executing this method requires admin access.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAccountRelationship(UpdateAccountRelationshipRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAccountRelationship(AccountRelationship accountRelationship, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAccountRelationshipCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAccountRelationships</td>
 *      <td><p> List account relationships for the specified account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAccountRelationships(ListAccountRelationshipsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAccountRelationships(AccountName parent)
 *           <li><p> listAccountRelationships(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAccountRelationshipsPagedCallable()
 *           <li><p> listAccountRelationshipsCallable()
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
 * AccountRelationshipsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AccountRelationshipsServiceSettings accountRelationshipsServiceSettings =
 *     AccountRelationshipsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AccountRelationshipsServiceClient accountRelationshipsServiceClient =
 *     AccountRelationshipsServiceClient.create(accountRelationshipsServiceSettings);
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
 * AccountRelationshipsServiceSettings accountRelationshipsServiceSettings =
 *     AccountRelationshipsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AccountRelationshipsServiceClient accountRelationshipsServiceClient =
 *     AccountRelationshipsServiceClient.create(accountRelationshipsServiceSettings);
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
 * AccountRelationshipsServiceSettings accountRelationshipsServiceSettings =
 *     AccountRelationshipsServiceSettings.newHttpJsonBuilder().build();
 * AccountRelationshipsServiceClient accountRelationshipsServiceClient =
 *     AccountRelationshipsServiceClient.create(accountRelationshipsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AccountRelationshipsServiceClient implements BackgroundResource {
  private final AccountRelationshipsServiceSettings settings;
  private final AccountRelationshipsServiceStub stub;

  /** Constructs an instance of AccountRelationshipsServiceClient with default settings. */
  public static final AccountRelationshipsServiceClient create() throws IOException {
    return create(AccountRelationshipsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AccountRelationshipsServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final AccountRelationshipsServiceClient create(
      AccountRelationshipsServiceSettings settings) throws IOException {
    return new AccountRelationshipsServiceClient(settings);
  }

  /**
   * Constructs an instance of AccountRelationshipsServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(AccountRelationshipsServiceSettings).
   */
  public static final AccountRelationshipsServiceClient create(
      AccountRelationshipsServiceStub stub) {
    return new AccountRelationshipsServiceClient(stub);
  }

  /**
   * Constructs an instance of AccountRelationshipsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AccountRelationshipsServiceClient(AccountRelationshipsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((AccountRelationshipsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AccountRelationshipsServiceClient(AccountRelationshipsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AccountRelationshipsServiceSettings getSettings() {
    return settings;
  }

  public AccountRelationshipsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve an account relationship.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountRelationshipsServiceClient accountRelationshipsServiceClient =
   *     AccountRelationshipsServiceClient.create()) {
   *   AccountRelationshipName name = AccountRelationshipName.of("[ACCOUNT]", "[RELATIONSHIP]");
   *   AccountRelationship response = accountRelationshipsServiceClient.getAccountRelationship(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the account relationship to get. Format:
   *     `accounts/{account}/relationships/{relationship}`. For example,
   *     `accounts/123456/relationships/567890`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountRelationship getAccountRelationship(AccountRelationshipName name) {
    GetAccountRelationshipRequest request =
        GetAccountRelationshipRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAccountRelationship(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve an account relationship.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountRelationshipsServiceClient accountRelationshipsServiceClient =
   *     AccountRelationshipsServiceClient.create()) {
   *   String name = AccountRelationshipName.of("[ACCOUNT]", "[RELATIONSHIP]").toString();
   *   AccountRelationship response = accountRelationshipsServiceClient.getAccountRelationship(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the account relationship to get. Format:
   *     `accounts/{account}/relationships/{relationship}`. For example,
   *     `accounts/123456/relationships/567890`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountRelationship getAccountRelationship(String name) {
    GetAccountRelationshipRequest request =
        GetAccountRelationshipRequest.newBuilder().setName(name).build();
    return getAccountRelationship(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve an account relationship.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountRelationshipsServiceClient accountRelationshipsServiceClient =
   *     AccountRelationshipsServiceClient.create()) {
   *   GetAccountRelationshipRequest request =
   *       GetAccountRelationshipRequest.newBuilder()
   *           .setName(AccountRelationshipName.of("[ACCOUNT]", "[RELATIONSHIP]").toString())
   *           .build();
   *   AccountRelationship response =
   *       accountRelationshipsServiceClient.getAccountRelationship(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountRelationship getAccountRelationship(GetAccountRelationshipRequest request) {
    return getAccountRelationshipCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve an account relationship.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountRelationshipsServiceClient accountRelationshipsServiceClient =
   *     AccountRelationshipsServiceClient.create()) {
   *   GetAccountRelationshipRequest request =
   *       GetAccountRelationshipRequest.newBuilder()
   *           .setName(AccountRelationshipName.of("[ACCOUNT]", "[RELATIONSHIP]").toString())
   *           .build();
   *   ApiFuture<AccountRelationship> future =
   *       accountRelationshipsServiceClient.getAccountRelationshipCallable().futureCall(request);
   *   // Do something.
   *   AccountRelationship response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAccountRelationshipRequest, AccountRelationship>
      getAccountRelationshipCallable() {
    return stub.getAccountRelationshipCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the account relationship. Executing this method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountRelationshipsServiceClient accountRelationshipsServiceClient =
   *     AccountRelationshipsServiceClient.create()) {
   *   AccountRelationship accountRelationship = AccountRelationship.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AccountRelationship response =
   *       accountRelationshipsServiceClient.updateAccountRelationship(
   *           accountRelationship, updateMask);
   * }
   * }</pre>
   *
   * @param accountRelationship Required. The new version of the account relationship.
   * @param updateMask Optional. List of fields being updated.
   *     <p>The following fields are supported (in both `snake_case` and `lowerCamelCase`):
   *     <p>- `account_id_alias`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountRelationship updateAccountRelationship(
      AccountRelationship accountRelationship, FieldMask updateMask) {
    UpdateAccountRelationshipRequest request =
        UpdateAccountRelationshipRequest.newBuilder()
            .setAccountRelationship(accountRelationship)
            .setUpdateMask(updateMask)
            .build();
    return updateAccountRelationship(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the account relationship. Executing this method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountRelationshipsServiceClient accountRelationshipsServiceClient =
   *     AccountRelationshipsServiceClient.create()) {
   *   UpdateAccountRelationshipRequest request =
   *       UpdateAccountRelationshipRequest.newBuilder()
   *           .setAccountRelationship(AccountRelationship.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AccountRelationship response =
   *       accountRelationshipsServiceClient.updateAccountRelationship(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountRelationship updateAccountRelationship(
      UpdateAccountRelationshipRequest request) {
    return updateAccountRelationshipCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the account relationship. Executing this method requires admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountRelationshipsServiceClient accountRelationshipsServiceClient =
   *     AccountRelationshipsServiceClient.create()) {
   *   UpdateAccountRelationshipRequest request =
   *       UpdateAccountRelationshipRequest.newBuilder()
   *           .setAccountRelationship(AccountRelationship.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AccountRelationship> future =
   *       accountRelationshipsServiceClient.updateAccountRelationshipCallable().futureCall(request);
   *   // Do something.
   *   AccountRelationship response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAccountRelationshipRequest, AccountRelationship>
      updateAccountRelationshipCallable() {
    return stub.updateAccountRelationshipCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List account relationships for the specified account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountRelationshipsServiceClient accountRelationshipsServiceClient =
   *     AccountRelationshipsServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (AccountRelationship element :
   *       accountRelationshipsServiceClient.listAccountRelationships(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent account of the account relationship to filter by. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountRelationshipsPagedResponse listAccountRelationships(AccountName parent) {
    ListAccountRelationshipsRequest request =
        ListAccountRelationshipsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAccountRelationships(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List account relationships for the specified account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountRelationshipsServiceClient accountRelationshipsServiceClient =
   *     AccountRelationshipsServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (AccountRelationship element :
   *       accountRelationshipsServiceClient.listAccountRelationships(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent account of the account relationship to filter by. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountRelationshipsPagedResponse listAccountRelationships(String parent) {
    ListAccountRelationshipsRequest request =
        ListAccountRelationshipsRequest.newBuilder().setParent(parent).build();
    return listAccountRelationships(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List account relationships for the specified account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountRelationshipsServiceClient accountRelationshipsServiceClient =
   *     AccountRelationshipsServiceClient.create()) {
   *   ListAccountRelationshipsRequest request =
   *       ListAccountRelationshipsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (AccountRelationship element :
   *       accountRelationshipsServiceClient.listAccountRelationships(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountRelationshipsPagedResponse listAccountRelationships(
      ListAccountRelationshipsRequest request) {
    return listAccountRelationshipsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List account relationships for the specified account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountRelationshipsServiceClient accountRelationshipsServiceClient =
   *     AccountRelationshipsServiceClient.create()) {
   *   ListAccountRelationshipsRequest request =
   *       ListAccountRelationshipsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<AccountRelationship> future =
   *       accountRelationshipsServiceClient
   *           .listAccountRelationshipsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (AccountRelationship element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAccountRelationshipsRequest, ListAccountRelationshipsPagedResponse>
      listAccountRelationshipsPagedCallable() {
    return stub.listAccountRelationshipsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List account relationships for the specified account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountRelationshipsServiceClient accountRelationshipsServiceClient =
   *     AccountRelationshipsServiceClient.create()) {
   *   ListAccountRelationshipsRequest request =
   *       ListAccountRelationshipsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     ListAccountRelationshipsResponse response =
   *         accountRelationshipsServiceClient.listAccountRelationshipsCallable().call(request);
   *     for (AccountRelationship element : response.getAccountRelationshipsList()) {
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
  public final UnaryCallable<ListAccountRelationshipsRequest, ListAccountRelationshipsResponse>
      listAccountRelationshipsCallable() {
    return stub.listAccountRelationshipsCallable();
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

  public static class ListAccountRelationshipsPagedResponse
      extends AbstractPagedListResponse<
          ListAccountRelationshipsRequest,
          ListAccountRelationshipsResponse,
          AccountRelationship,
          ListAccountRelationshipsPage,
          ListAccountRelationshipsFixedSizeCollection> {

    public static ApiFuture<ListAccountRelationshipsPagedResponse> createAsync(
        PageContext<
                ListAccountRelationshipsRequest,
                ListAccountRelationshipsResponse,
                AccountRelationship>
            context,
        ApiFuture<ListAccountRelationshipsResponse> futureResponse) {
      ApiFuture<ListAccountRelationshipsPage> futurePage =
          ListAccountRelationshipsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAccountRelationshipsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAccountRelationshipsPagedResponse(ListAccountRelationshipsPage page) {
      super(page, ListAccountRelationshipsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAccountRelationshipsPage
      extends AbstractPage<
          ListAccountRelationshipsRequest,
          ListAccountRelationshipsResponse,
          AccountRelationship,
          ListAccountRelationshipsPage> {

    private ListAccountRelationshipsPage(
        PageContext<
                ListAccountRelationshipsRequest,
                ListAccountRelationshipsResponse,
                AccountRelationship>
            context,
        ListAccountRelationshipsResponse response) {
      super(context, response);
    }

    private static ListAccountRelationshipsPage createEmptyPage() {
      return new ListAccountRelationshipsPage(null, null);
    }

    @Override
    protected ListAccountRelationshipsPage createPage(
        PageContext<
                ListAccountRelationshipsRequest,
                ListAccountRelationshipsResponse,
                AccountRelationship>
            context,
        ListAccountRelationshipsResponse response) {
      return new ListAccountRelationshipsPage(context, response);
    }

    @Override
    public ApiFuture<ListAccountRelationshipsPage> createPageAsync(
        PageContext<
                ListAccountRelationshipsRequest,
                ListAccountRelationshipsResponse,
                AccountRelationship>
            context,
        ApiFuture<ListAccountRelationshipsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAccountRelationshipsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAccountRelationshipsRequest,
          ListAccountRelationshipsResponse,
          AccountRelationship,
          ListAccountRelationshipsPage,
          ListAccountRelationshipsFixedSizeCollection> {

    private ListAccountRelationshipsFixedSizeCollection(
        List<ListAccountRelationshipsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAccountRelationshipsFixedSizeCollection createEmptyCollection() {
      return new ListAccountRelationshipsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAccountRelationshipsFixedSizeCollection createCollection(
        List<ListAccountRelationshipsPage> pages, int collectionSize) {
      return new ListAccountRelationshipsFixedSizeCollection(pages, collectionSize);
    }
  }
}
