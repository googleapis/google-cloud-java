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
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1.stub.AccountServicesServiceStub;
import com.google.shopping.merchant.accounts.v1.stub.AccountServicesServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to support AccountService API.
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
 * try (AccountServicesServiceClient accountServicesServiceClient =
 *     AccountServicesServiceClient.create()) {
 *   AccountServiceName name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]");
 *   AccountService response = accountServicesServiceClient.getAccountService(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AccountServicesServiceClient object to clean up
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
 *      <td><p> GetAccountService</td>
 *      <td><p> Retrieve an account service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAccountService(GetAccountServiceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAccountService(AccountServiceName name)
 *           <li><p> getAccountService(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAccountServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAccountServices</td>
 *      <td><p> List account services for the specified accounts. Supports filtering.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAccountServices(ListAccountServicesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAccountServices(AccountName parent)
 *           <li><p> listAccountServices(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAccountServicesPagedCallable()
 *           <li><p> listAccountServicesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ProposeAccountService</td>
 *      <td><p> Propose an account service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> proposeAccountService(ProposeAccountServiceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> proposeAccountService(AccountName parent, String provider, AccountService accountService)
 *           <li><p> proposeAccountService(String parent, String provider, AccountService accountService)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> proposeAccountServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ApproveAccountService</td>
 *      <td><p> Approve an account service proposal.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> approveAccountService(ApproveAccountServiceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> approveAccountService(AccountServiceName name)
 *           <li><p> approveAccountService(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> approveAccountServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RejectAccountService</td>
 *      <td><p> Reject an account service (both proposed and approve services can be rejected).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rejectAccountService(RejectAccountServiceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> rejectAccountService(AccountServiceName name)
 *           <li><p> rejectAccountService(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rejectAccountServiceCallable()
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
 * <p>This class can be customized by passing in a custom instance of AccountServicesServiceSettings
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
 * AccountServicesServiceSettings accountServicesServiceSettings =
 *     AccountServicesServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AccountServicesServiceClient accountServicesServiceClient =
 *     AccountServicesServiceClient.create(accountServicesServiceSettings);
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
 * AccountServicesServiceSettings accountServicesServiceSettings =
 *     AccountServicesServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AccountServicesServiceClient accountServicesServiceClient =
 *     AccountServicesServiceClient.create(accountServicesServiceSettings);
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
 * AccountServicesServiceSettings accountServicesServiceSettings =
 *     AccountServicesServiceSettings.newHttpJsonBuilder().build();
 * AccountServicesServiceClient accountServicesServiceClient =
 *     AccountServicesServiceClient.create(accountServicesServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AccountServicesServiceClient implements BackgroundResource {
  private final AccountServicesServiceSettings settings;
  private final AccountServicesServiceStub stub;

  /** Constructs an instance of AccountServicesServiceClient with default settings. */
  public static final AccountServicesServiceClient create() throws IOException {
    return create(AccountServicesServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AccountServicesServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AccountServicesServiceClient create(AccountServicesServiceSettings settings)
      throws IOException {
    return new AccountServicesServiceClient(settings);
  }

  /**
   * Constructs an instance of AccountServicesServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(AccountServicesServiceSettings).
   */
  public static final AccountServicesServiceClient create(AccountServicesServiceStub stub) {
    return new AccountServicesServiceClient(stub);
  }

  /**
   * Constructs an instance of AccountServicesServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AccountServicesServiceClient(AccountServicesServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((AccountServicesServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AccountServicesServiceClient(AccountServicesServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AccountServicesServiceSettings getSettings() {
    return settings;
  }

  public AccountServicesServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve an account service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   AccountServiceName name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]");
   *   AccountService response = accountServicesServiceClient.getAccountService(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the account service to get. Format:
   *     `accounts/{account}/services/{service}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountService getAccountService(AccountServiceName name) {
    GetAccountServiceRequest request =
        GetAccountServiceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAccountService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve an account service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   String name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString();
   *   AccountService response = accountServicesServiceClient.getAccountService(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the account service to get. Format:
   *     `accounts/{account}/services/{service}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountService getAccountService(String name) {
    GetAccountServiceRequest request = GetAccountServiceRequest.newBuilder().setName(name).build();
    return getAccountService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve an account service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   GetAccountServiceRequest request =
   *       GetAccountServiceRequest.newBuilder()
   *           .setName(AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString())
   *           .build();
   *   AccountService response = accountServicesServiceClient.getAccountService(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountService getAccountService(GetAccountServiceRequest request) {
    return getAccountServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve an account service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   GetAccountServiceRequest request =
   *       GetAccountServiceRequest.newBuilder()
   *           .setName(AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString())
   *           .build();
   *   ApiFuture<AccountService> future =
   *       accountServicesServiceClient.getAccountServiceCallable().futureCall(request);
   *   // Do something.
   *   AccountService response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAccountServiceRequest, AccountService> getAccountServiceCallable() {
    return stub.getAccountServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List account services for the specified accounts. Supports filtering.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (AccountService element :
   *       accountServicesServiceClient.listAccountServices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent account of the account service to filter by. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountServicesPagedResponse listAccountServices(AccountName parent) {
    ListAccountServicesRequest request =
        ListAccountServicesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAccountServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List account services for the specified accounts. Supports filtering.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (AccountService element :
   *       accountServicesServiceClient.listAccountServices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent account of the account service to filter by. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountServicesPagedResponse listAccountServices(String parent) {
    ListAccountServicesRequest request =
        ListAccountServicesRequest.newBuilder().setParent(parent).build();
    return listAccountServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List account services for the specified accounts. Supports filtering.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   ListAccountServicesRequest request =
   *       ListAccountServicesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   for (AccountService element :
   *       accountServicesServiceClient.listAccountServices(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAccountServicesPagedResponse listAccountServices(
      ListAccountServicesRequest request) {
    return listAccountServicesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List account services for the specified accounts. Supports filtering.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   ListAccountServicesRequest request =
   *       ListAccountServicesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   ApiFuture<AccountService> future =
   *       accountServicesServiceClient.listAccountServicesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AccountService element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAccountServicesRequest, ListAccountServicesPagedResponse>
      listAccountServicesPagedCallable() {
    return stub.listAccountServicesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List account services for the specified accounts. Supports filtering.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   ListAccountServicesRequest request =
   *       ListAccountServicesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageToken("pageToken873572522")
   *           .setPageSize(883849137)
   *           .build();
   *   while (true) {
   *     ListAccountServicesResponse response =
   *         accountServicesServiceClient.listAccountServicesCallable().call(request);
   *     for (AccountService element : response.getAccountServicesList()) {
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
  public final UnaryCallable<ListAccountServicesRequest, ListAccountServicesResponse>
      listAccountServicesCallable() {
    return stub.listAccountServicesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Propose an account service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   String provider = "provider-987494927";
   *   AccountService accountService = AccountService.newBuilder().build();
   *   AccountService response =
   *       accountServicesServiceClient.proposeAccountService(parent, provider, accountService);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent account for the service. Format:
   *     `accounts/{account}`
   * @param provider Required. The provider of the service. Either the reference to an account such
   *     as `providers/123` or a well-known service provider (one of `providers/GOOGLE_ADS` or
   *     `providers/GOOGLE_BUSINESS_PROFILE`).
   * @param accountService Required. The account service to propose.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountService proposeAccountService(
      AccountName parent, String provider, AccountService accountService) {
    ProposeAccountServiceRequest request =
        ProposeAccountServiceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setProvider(provider)
            .setAccountService(accountService)
            .build();
    return proposeAccountService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Propose an account service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   String provider = "provider-987494927";
   *   AccountService accountService = AccountService.newBuilder().build();
   *   AccountService response =
   *       accountServicesServiceClient.proposeAccountService(parent, provider, accountService);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the parent account for the service. Format:
   *     `accounts/{account}`
   * @param provider Required. The provider of the service. Either the reference to an account such
   *     as `providers/123` or a well-known service provider (one of `providers/GOOGLE_ADS` or
   *     `providers/GOOGLE_BUSINESS_PROFILE`).
   * @param accountService Required. The account service to propose.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountService proposeAccountService(
      String parent, String provider, AccountService accountService) {
    ProposeAccountServiceRequest request =
        ProposeAccountServiceRequest.newBuilder()
            .setParent(parent)
            .setProvider(provider)
            .setAccountService(accountService)
            .build();
    return proposeAccountService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Propose an account service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   ProposeAccountServiceRequest request =
   *       ProposeAccountServiceRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setProvider("provider-987494927")
   *           .setAccountService(AccountService.newBuilder().build())
   *           .build();
   *   AccountService response = accountServicesServiceClient.proposeAccountService(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountService proposeAccountService(ProposeAccountServiceRequest request) {
    return proposeAccountServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Propose an account service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   ProposeAccountServiceRequest request =
   *       ProposeAccountServiceRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setProvider("provider-987494927")
   *           .setAccountService(AccountService.newBuilder().build())
   *           .build();
   *   ApiFuture<AccountService> future =
   *       accountServicesServiceClient.proposeAccountServiceCallable().futureCall(request);
   *   // Do something.
   *   AccountService response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ProposeAccountServiceRequest, AccountService>
      proposeAccountServiceCallable() {
    return stub.proposeAccountServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approve an account service proposal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   AccountServiceName name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]");
   *   AccountService response = accountServicesServiceClient.approveAccountService(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the account service to approve. Format:
   *     `accounts/{account}/services/{service}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountService approveAccountService(AccountServiceName name) {
    ApproveAccountServiceRequest request =
        ApproveAccountServiceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return approveAccountService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approve an account service proposal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   String name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString();
   *   AccountService response = accountServicesServiceClient.approveAccountService(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the account service to approve. Format:
   *     `accounts/{account}/services/{service}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountService approveAccountService(String name) {
    ApproveAccountServiceRequest request =
        ApproveAccountServiceRequest.newBuilder().setName(name).build();
    return approveAccountService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approve an account service proposal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   ApproveAccountServiceRequest request =
   *       ApproveAccountServiceRequest.newBuilder()
   *           .setName(AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString())
   *           .build();
   *   AccountService response = accountServicesServiceClient.approveAccountService(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccountService approveAccountService(ApproveAccountServiceRequest request) {
    return approveAccountServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Approve an account service proposal.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   ApproveAccountServiceRequest request =
   *       ApproveAccountServiceRequest.newBuilder()
   *           .setName(AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString())
   *           .build();
   *   ApiFuture<AccountService> future =
   *       accountServicesServiceClient.approveAccountServiceCallable().futureCall(request);
   *   // Do something.
   *   AccountService response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ApproveAccountServiceRequest, AccountService>
      approveAccountServiceCallable() {
    return stub.approveAccountServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reject an account service (both proposed and approve services can be rejected).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   AccountServiceName name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]");
   *   accountServicesServiceClient.rejectAccountService(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the account service to reject. Format:
   *     `accounts/{account}/services/{service}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void rejectAccountService(AccountServiceName name) {
    RejectAccountServiceRequest request =
        RejectAccountServiceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    rejectAccountService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reject an account service (both proposed and approve services can be rejected).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   String name = AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString();
   *   accountServicesServiceClient.rejectAccountService(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the account service to reject. Format:
   *     `accounts/{account}/services/{service}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void rejectAccountService(String name) {
    RejectAccountServiceRequest request =
        RejectAccountServiceRequest.newBuilder().setName(name).build();
    rejectAccountService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reject an account service (both proposed and approve services can be rejected).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   RejectAccountServiceRequest request =
   *       RejectAccountServiceRequest.newBuilder()
   *           .setName(AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString())
   *           .build();
   *   accountServicesServiceClient.rejectAccountService(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void rejectAccountService(RejectAccountServiceRequest request) {
    rejectAccountServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reject an account service (both proposed and approve services can be rejected).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AccountServicesServiceClient accountServicesServiceClient =
   *     AccountServicesServiceClient.create()) {
   *   RejectAccountServiceRequest request =
   *       RejectAccountServiceRequest.newBuilder()
   *           .setName(AccountServiceName.of("[ACCOUNT]", "[SERVICE]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       accountServicesServiceClient.rejectAccountServiceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RejectAccountServiceRequest, Empty> rejectAccountServiceCallable() {
    return stub.rejectAccountServiceCallable();
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

  public static class ListAccountServicesPagedResponse
      extends AbstractPagedListResponse<
          ListAccountServicesRequest,
          ListAccountServicesResponse,
          AccountService,
          ListAccountServicesPage,
          ListAccountServicesFixedSizeCollection> {

    public static ApiFuture<ListAccountServicesPagedResponse> createAsync(
        PageContext<ListAccountServicesRequest, ListAccountServicesResponse, AccountService>
            context,
        ApiFuture<ListAccountServicesResponse> futureResponse) {
      ApiFuture<ListAccountServicesPage> futurePage =
          ListAccountServicesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAccountServicesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAccountServicesPagedResponse(ListAccountServicesPage page) {
      super(page, ListAccountServicesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAccountServicesPage
      extends AbstractPage<
          ListAccountServicesRequest,
          ListAccountServicesResponse,
          AccountService,
          ListAccountServicesPage> {

    private ListAccountServicesPage(
        PageContext<ListAccountServicesRequest, ListAccountServicesResponse, AccountService>
            context,
        ListAccountServicesResponse response) {
      super(context, response);
    }

    private static ListAccountServicesPage createEmptyPage() {
      return new ListAccountServicesPage(null, null);
    }

    @Override
    protected ListAccountServicesPage createPage(
        PageContext<ListAccountServicesRequest, ListAccountServicesResponse, AccountService>
            context,
        ListAccountServicesResponse response) {
      return new ListAccountServicesPage(context, response);
    }

    @Override
    public ApiFuture<ListAccountServicesPage> createPageAsync(
        PageContext<ListAccountServicesRequest, ListAccountServicesResponse, AccountService>
            context,
        ApiFuture<ListAccountServicesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAccountServicesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAccountServicesRequest,
          ListAccountServicesResponse,
          AccountService,
          ListAccountServicesPage,
          ListAccountServicesFixedSizeCollection> {

    private ListAccountServicesFixedSizeCollection(
        List<ListAccountServicesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAccountServicesFixedSizeCollection createEmptyCollection() {
      return new ListAccountServicesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAccountServicesFixedSizeCollection createCollection(
        List<ListAccountServicesPage> pages, int collectionSize) {
      return new ListAccountServicesFixedSizeCollection(pages, collectionSize);
    }
  }
}
