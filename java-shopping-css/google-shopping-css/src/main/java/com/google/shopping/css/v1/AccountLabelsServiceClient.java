/*
 * Copyright 2023 Google LLC
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

package com.google.shopping.css.v1;

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
import com.google.shopping.css.v1.stub.AccountLabelsServiceStub;
import com.google.shopping.css.v1.stub.AccountLabelsServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages Merchant Center and CSS accounts labels.
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
 * try (AccountLabelsServiceClient accountLabelsServiceClient =
 *     AccountLabelsServiceClient.create()) {
 *   AccountName parent = AccountName.of("[ACCOUNT]");
 *   AccountLabel accountLabel = AccountLabel.newBuilder().build();
 *   AccountLabel response = accountLabelsServiceClient.createAccountLabel(parent, accountLabel);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AccountLabelsServiceClient object to clean up
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
 *      <td><p> ListAccountLabels</td>
 *      <td><p> Lists the labels assigned to an account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAccountLabels(ListAccountLabelsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAccountLabels(AccountName parent)
 *           <li><p> listAccountLabels(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAccountLabelsPagedCallable()
 *           <li><p> listAccountLabelsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAccountLabel</td>
 *      <td><p> Creates a new label, not assigned to any account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAccountLabel(CreateAccountLabelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAccountLabel(AccountName parent, AccountLabel accountLabel)
 *           <li><p> createAccountLabel(String parent, AccountLabel accountLabel)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAccountLabelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAccountLabel</td>
 *      <td><p> Updates a label.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAccountLabel(UpdateAccountLabelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAccountLabel(AccountLabel accountLabel)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAccountLabelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAccountLabel</td>
 *      <td><p> Deletes a label and removes it from all accounts to which it was assigned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAccountLabel(DeleteAccountLabelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAccountLabel(AccountLabelName name)
 *           <li><p> deleteAccountLabel(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAccountLabelCallable()
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
 * <p>This class can be customized by passing in a custom instance of AccountLabelsServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AccountLabelsServiceSettings accountLabelsServiceSettings =
 *     AccountLabelsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AccountLabelsServiceClient accountLabelsServiceClient =
 *     AccountLabelsServiceClient.create(accountLabelsServiceSettings);
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
 * AccountLabelsServiceSettings accountLabelsServiceSettings =
 *     AccountLabelsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AccountLabelsServiceClient accountLabelsServiceClient =
 *     AccountLabelsServiceClient.create(accountLabelsServiceSettings);
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
 * AccountLabelsServiceSettings accountLabelsServiceSettings =
 *     AccountLabelsServiceSettings.newHttpJsonBuilder().build();
 * AccountLabelsServiceClient accountLabelsServiceClient =
 *     AccountLabelsServiceClient.create(accountLabelsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AccountLabelsServiceClient implements BackgroundResource {
  private final AccountLabelsServiceSettings settings;
  private final AccountLabelsServiceStub stub;

  /** Constructs an instance of AccountLabelsServiceClient with default settings. */
  public static final AccountLabelsServiceClient create() throws IOException {
    return create(AccountLabelsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AccountLabelsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AccountLabelsServiceClient create(AccountLabelsServiceSettings settings)
      throws IOException {
    return new AccountLabelsServiceClient(settings);
  }

  /**
   * Constructs an instance of AccountLabelsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(AccountLabelsServiceSettings).
   */
  public static final AccountLabelsServiceClient create(AccountLabelsServiceStub stub) {
    return new AccountLabelsServiceClient(stub);
  }

  /**
   * Constructs an instance of AccountLabelsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AccountLabelsServiceClient(AccountLabelsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AccountLabelsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AccountLabelsServiceClient(AccountLabelsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AccountLabelsServiceSettings getSettings() {
    return settings;
  }

  public AccountLabelsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the labels assigned to an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLabelsServiceClient accountLabelsServiceClient =
   *     AccountLabelsServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (AccountLabel element :
   *       accountLabelsServiceClient.listAccountLabels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent account. Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountLabelsPagedResponse listAccountLabels(AccountName parent) {
    ListAccountLabelsRequest request =
        ListAccountLabelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAccountLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the labels assigned to an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLabelsServiceClient accountLabelsServiceClient =
   *     AccountLabelsServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (AccountLabel element :
   *       accountLabelsServiceClient.listAccountLabels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent account. Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountLabelsPagedResponse listAccountLabels(String parent) {
    ListAccountLabelsRequest request =
        ListAccountLabelsRequest.newBuilder().setParent(parent).build();
    return listAccountLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the labels assigned to an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLabelsServiceClient accountLabelsServiceClient =
   *     AccountLabelsServiceClient.create()) {
   *   ListAccountLabelsRequest request =
   *       ListAccountLabelsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AccountLabel element :
   *       accountLabelsServiceClient.listAccountLabels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountLabelsPagedResponse listAccountLabels(ListAccountLabelsRequest request) {
    return listAccountLabelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the labels assigned to an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLabelsServiceClient accountLabelsServiceClient =
   *     AccountLabelsServiceClient.create()) {
   *   ListAccountLabelsRequest request =
   *       ListAccountLabelsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AccountLabel> future =
   *       accountLabelsServiceClient.listAccountLabelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AccountLabel element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAccountLabelsRequest, ListAccountLabelsPagedResponse>
      listAccountLabelsPagedCallable() {
    return stub.listAccountLabelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the labels assigned to an account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLabelsServiceClient accountLabelsServiceClient =
   *     AccountLabelsServiceClient.create()) {
   *   ListAccountLabelsRequest request =
   *       ListAccountLabelsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAccountLabelsResponse response =
   *         accountLabelsServiceClient.listAccountLabelsCallable().call(request);
   *     for (AccountLabel element : response.getAccountLabelsList()) {
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
  public final UnaryCallable<ListAccountLabelsRequest, ListAccountLabelsResponse>
      listAccountLabelsCallable() {
    return stub.listAccountLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new label, not assigned to any account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLabelsServiceClient accountLabelsServiceClient =
   *     AccountLabelsServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   AccountLabel accountLabel = AccountLabel.newBuilder().build();
   *   AccountLabel response = accountLabelsServiceClient.createAccountLabel(parent, accountLabel);
   * }
   * }</pre>
   *
   * @param parent Required. The parent account. Format: accounts/{account}
   * @param accountLabel Required. The label to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountLabel createAccountLabel(AccountName parent, AccountLabel accountLabel) {
    CreateAccountLabelRequest request =
        CreateAccountLabelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAccountLabel(accountLabel)
            .build();
    return createAccountLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new label, not assigned to any account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLabelsServiceClient accountLabelsServiceClient =
   *     AccountLabelsServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   AccountLabel accountLabel = AccountLabel.newBuilder().build();
   *   AccountLabel response = accountLabelsServiceClient.createAccountLabel(parent, accountLabel);
   * }
   * }</pre>
   *
   * @param parent Required. The parent account. Format: accounts/{account}
   * @param accountLabel Required. The label to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountLabel createAccountLabel(String parent, AccountLabel accountLabel) {
    CreateAccountLabelRequest request =
        CreateAccountLabelRequest.newBuilder()
            .setParent(parent)
            .setAccountLabel(accountLabel)
            .build();
    return createAccountLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new label, not assigned to any account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLabelsServiceClient accountLabelsServiceClient =
   *     AccountLabelsServiceClient.create()) {
   *   CreateAccountLabelRequest request =
   *       CreateAccountLabelRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setAccountLabel(AccountLabel.newBuilder().build())
   *           .build();
   *   AccountLabel response = accountLabelsServiceClient.createAccountLabel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountLabel createAccountLabel(CreateAccountLabelRequest request) {
    return createAccountLabelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new label, not assigned to any account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLabelsServiceClient accountLabelsServiceClient =
   *     AccountLabelsServiceClient.create()) {
   *   CreateAccountLabelRequest request =
   *       CreateAccountLabelRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setAccountLabel(AccountLabel.newBuilder().build())
   *           .build();
   *   ApiFuture<AccountLabel> future =
   *       accountLabelsServiceClient.createAccountLabelCallable().futureCall(request);
   *   // Do something.
   *   AccountLabel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAccountLabelRequest, AccountLabel> createAccountLabelCallable() {
    return stub.createAccountLabelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLabelsServiceClient accountLabelsServiceClient =
   *     AccountLabelsServiceClient.create()) {
   *   AccountLabel accountLabel = AccountLabel.newBuilder().build();
   *   AccountLabel response = accountLabelsServiceClient.updateAccountLabel(accountLabel);
   * }
   * }</pre>
   *
   * @param accountLabel Required. The updated label. All fields must be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountLabel updateAccountLabel(AccountLabel accountLabel) {
    UpdateAccountLabelRequest request =
        UpdateAccountLabelRequest.newBuilder().setAccountLabel(accountLabel).build();
    return updateAccountLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLabelsServiceClient accountLabelsServiceClient =
   *     AccountLabelsServiceClient.create()) {
   *   UpdateAccountLabelRequest request =
   *       UpdateAccountLabelRequest.newBuilder()
   *           .setAccountLabel(AccountLabel.newBuilder().build())
   *           .build();
   *   AccountLabel response = accountLabelsServiceClient.updateAccountLabel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountLabel updateAccountLabel(UpdateAccountLabelRequest request) {
    return updateAccountLabelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLabelsServiceClient accountLabelsServiceClient =
   *     AccountLabelsServiceClient.create()) {
   *   UpdateAccountLabelRequest request =
   *       UpdateAccountLabelRequest.newBuilder()
   *           .setAccountLabel(AccountLabel.newBuilder().build())
   *           .build();
   *   ApiFuture<AccountLabel> future =
   *       accountLabelsServiceClient.updateAccountLabelCallable().futureCall(request);
   *   // Do something.
   *   AccountLabel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAccountLabelRequest, AccountLabel> updateAccountLabelCallable() {
    return stub.updateAccountLabelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a label and removes it from all accounts to which it was assigned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLabelsServiceClient accountLabelsServiceClient =
   *     AccountLabelsServiceClient.create()) {
   *   AccountLabelName name = AccountLabelName.of("[ACCOUNT]", "[LABEL]");
   *   accountLabelsServiceClient.deleteAccountLabel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the label to delete. Format:
   *     accounts/{account}/labels/{label}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAccountLabel(AccountLabelName name) {
    DeleteAccountLabelRequest request =
        DeleteAccountLabelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteAccountLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a label and removes it from all accounts to which it was assigned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLabelsServiceClient accountLabelsServiceClient =
   *     AccountLabelsServiceClient.create()) {
   *   String name = AccountLabelName.of("[ACCOUNT]", "[LABEL]").toString();
   *   accountLabelsServiceClient.deleteAccountLabel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the label to delete. Format:
   *     accounts/{account}/labels/{label}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAccountLabel(String name) {
    DeleteAccountLabelRequest request =
        DeleteAccountLabelRequest.newBuilder().setName(name).build();
    deleteAccountLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a label and removes it from all accounts to which it was assigned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLabelsServiceClient accountLabelsServiceClient =
   *     AccountLabelsServiceClient.create()) {
   *   DeleteAccountLabelRequest request =
   *       DeleteAccountLabelRequest.newBuilder()
   *           .setName(AccountLabelName.of("[ACCOUNT]", "[LABEL]").toString())
   *           .build();
   *   accountLabelsServiceClient.deleteAccountLabel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAccountLabel(DeleteAccountLabelRequest request) {
    deleteAccountLabelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a label and removes it from all accounts to which it was assigned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountLabelsServiceClient accountLabelsServiceClient =
   *     AccountLabelsServiceClient.create()) {
   *   DeleteAccountLabelRequest request =
   *       DeleteAccountLabelRequest.newBuilder()
   *           .setName(AccountLabelName.of("[ACCOUNT]", "[LABEL]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       accountLabelsServiceClient.deleteAccountLabelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAccountLabelRequest, Empty> deleteAccountLabelCallable() {
    return stub.deleteAccountLabelCallable();
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

  public static class ListAccountLabelsPagedResponse
      extends AbstractPagedListResponse<
          ListAccountLabelsRequest,
          ListAccountLabelsResponse,
          AccountLabel,
          ListAccountLabelsPage,
          ListAccountLabelsFixedSizeCollection> {

    public static ApiFuture<ListAccountLabelsPagedResponse> createAsync(
        PageContext<ListAccountLabelsRequest, ListAccountLabelsResponse, AccountLabel> context,
        ApiFuture<ListAccountLabelsResponse> futureResponse) {
      ApiFuture<ListAccountLabelsPage> futurePage =
          ListAccountLabelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAccountLabelsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAccountLabelsPagedResponse(ListAccountLabelsPage page) {
      super(page, ListAccountLabelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAccountLabelsPage
      extends AbstractPage<
          ListAccountLabelsRequest,
          ListAccountLabelsResponse,
          AccountLabel,
          ListAccountLabelsPage> {

    private ListAccountLabelsPage(
        PageContext<ListAccountLabelsRequest, ListAccountLabelsResponse, AccountLabel> context,
        ListAccountLabelsResponse response) {
      super(context, response);
    }

    private static ListAccountLabelsPage createEmptyPage() {
      return new ListAccountLabelsPage(null, null);
    }

    @Override
    protected ListAccountLabelsPage createPage(
        PageContext<ListAccountLabelsRequest, ListAccountLabelsResponse, AccountLabel> context,
        ListAccountLabelsResponse response) {
      return new ListAccountLabelsPage(context, response);
    }

    @Override
    public ApiFuture<ListAccountLabelsPage> createPageAsync(
        PageContext<ListAccountLabelsRequest, ListAccountLabelsResponse, AccountLabel> context,
        ApiFuture<ListAccountLabelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAccountLabelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAccountLabelsRequest,
          ListAccountLabelsResponse,
          AccountLabel,
          ListAccountLabelsPage,
          ListAccountLabelsFixedSizeCollection> {

    private ListAccountLabelsFixedSizeCollection(
        List<ListAccountLabelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAccountLabelsFixedSizeCollection createEmptyCollection() {
      return new ListAccountLabelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAccountLabelsFixedSizeCollection createCollection(
        List<ListAccountLabelsPage> pages, int collectionSize) {
      return new ListAccountLabelsFixedSizeCollection(pages, collectionSize);
    }
  }
}
