/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.channel.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.channel.v1.stub.CloudChannelServiceStub;
import com.google.cloud.channel.v1.stub.CloudChannelServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: CloudChannelService lets Google cloud resellers and distributors manage
 * their customers, channel partners, entitlements, and reports.
 *
 * <p>Using this service: 1. Resellers and distributors can manage a customer entity. 2.
 * Distributors can register an authorized reseller in their channel and provide them with delegated
 * admin access. 3. Resellers and distributors can manage customer entitlements.
 *
 * <p>CloudChannelService exposes the following resources: -
 * [Customer][google.cloud.channel.v1.Customer]s: An entity—usually an enterprise—managed by a
 * reseller or distributor.
 *
 * <p>- [Entitlement][google.cloud.channel.v1.Entitlement]s: An entity that provides a customer with
 * the means to use a service. Entitlements are created or updated as a result of a successful
 * fulfillment.
 *
 * <p>- [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]s: An entity that identifies
 * links between distributors and their indirect resellers in a channel.
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
 * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
 *   CustomerName name = CustomerName.of("[ACCOUNT]", "[CUSTOMER]");
 *   Customer response = cloudChannelServiceClient.getCustomer(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CloudChannelServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of CloudChannelServiceSettings to
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
 * CloudChannelServiceSettings cloudChannelServiceSettings =
 *     CloudChannelServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudChannelServiceClient cloudChannelServiceClient =
 *     CloudChannelServiceClient.create(cloudChannelServiceSettings);
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
 * CloudChannelServiceSettings cloudChannelServiceSettings =
 *     CloudChannelServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudChannelServiceClient cloudChannelServiceClient =
 *     CloudChannelServiceClient.create(cloudChannelServiceSettings);
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
 * CloudChannelServiceSettings cloudChannelServiceSettings =
 *     CloudChannelServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             CloudChannelServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * CloudChannelServiceClient cloudChannelServiceClient =
 *     CloudChannelServiceClient.create(cloudChannelServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CloudChannelServiceClient implements BackgroundResource {
  private final CloudChannelServiceSettings settings;
  private final CloudChannelServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of CloudChannelServiceClient with default settings. */
  public static final CloudChannelServiceClient create() throws IOException {
    return create(CloudChannelServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudChannelServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CloudChannelServiceClient create(CloudChannelServiceSettings settings)
      throws IOException {
    return new CloudChannelServiceClient(settings);
  }

  /**
   * Constructs an instance of CloudChannelServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(CloudChannelServiceSettings).
   */
  public static final CloudChannelServiceClient create(CloudChannelServiceStub stub) {
    return new CloudChannelServiceClient(stub);
  }

  /**
   * Constructs an instance of CloudChannelServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CloudChannelServiceClient(CloudChannelServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CloudChannelServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected CloudChannelServiceClient(CloudChannelServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final CloudChannelServiceSettings getSettings() {
    return settings;
  }

  public CloudChannelServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [Customer][google.cloud.channel.v1.Customer]s.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   * </ul>
   *
   * <p>Return value: List of [Customer][google.cloud.channel.v1.Customer]s, or an empty list if
   * there are no customers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListCustomersRequest request =
   *       ListCustomersRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Customer element : cloudChannelServiceClient.listCustomers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomersPagedResponse listCustomers(ListCustomersRequest request) {
    return listCustomersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [Customer][google.cloud.channel.v1.Customer]s.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   * </ul>
   *
   * <p>Return value: List of [Customer][google.cloud.channel.v1.Customer]s, or an empty list if
   * there are no customers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListCustomersRequest request =
   *       ListCustomersRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Customer> future =
   *       cloudChannelServiceClient.listCustomersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Customer element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCustomersRequest, ListCustomersPagedResponse>
      listCustomersPagedCallable() {
    return stub.listCustomersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [Customer][google.cloud.channel.v1.Customer]s.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   * </ul>
   *
   * <p>Return value: List of [Customer][google.cloud.channel.v1.Customer]s, or an empty list if
   * there are no customers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListCustomersRequest request =
   *       ListCustomersRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListCustomersResponse response =
   *         cloudChannelServiceClient.listCustomersCallable().call(request);
   *     for (Customer element : response.getCustomersList()) {
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
  public final UnaryCallable<ListCustomersRequest, ListCustomersResponse> listCustomersCallable() {
    return stub.listCustomersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [Customer][google.cloud.channel.v1.Customer] resource.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The customer resource doesn't exist. Usually the result of an invalid name
   *       parameter.
   * </ul>
   *
   * <p>Return value: The [Customer][google.cloud.channel.v1.Customer] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CustomerName name = CustomerName.of("[ACCOUNT]", "[CUSTOMER]");
   *   Customer response = cloudChannelServiceClient.getCustomer(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the customer to retrieve. Name uses the format:
   *     accounts/{account_id}/customers/{customer_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Customer getCustomer(CustomerName name) {
    GetCustomerRequest request =
        GetCustomerRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCustomer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [Customer][google.cloud.channel.v1.Customer] resource.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The customer resource doesn't exist. Usually the result of an invalid name
   *       parameter.
   * </ul>
   *
   * <p>Return value: The [Customer][google.cloud.channel.v1.Customer] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   String name = CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString();
   *   Customer response = cloudChannelServiceClient.getCustomer(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the customer to retrieve. Name uses the format:
   *     accounts/{account_id}/customers/{customer_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Customer getCustomer(String name) {
    GetCustomerRequest request = GetCustomerRequest.newBuilder().setName(name).build();
    return getCustomer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [Customer][google.cloud.channel.v1.Customer] resource.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The customer resource doesn't exist. Usually the result of an invalid name
   *       parameter.
   * </ul>
   *
   * <p>Return value: The [Customer][google.cloud.channel.v1.Customer] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   GetCustomerRequest request =
   *       GetCustomerRequest.newBuilder()
   *           .setName(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .build();
   *   Customer response = cloudChannelServiceClient.getCustomer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Customer getCustomer(GetCustomerRequest request) {
    return getCustomerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [Customer][google.cloud.channel.v1.Customer] resource.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The customer resource doesn't exist. Usually the result of an invalid name
   *       parameter.
   * </ul>
   *
   * <p>Return value: The [Customer][google.cloud.channel.v1.Customer] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   GetCustomerRequest request =
   *       GetCustomerRequest.newBuilder()
   *           .setName(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .build();
   *   ApiFuture<Customer> future =
   *       cloudChannelServiceClient.getCustomerCallable().futureCall(request);
   *   // Do something.
   *   Customer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCustomerRequest, Customer> getCustomerCallable() {
    return stub.getCustomerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Confirms the existence of Cloud Identity accounts based on the domain and if the Cloud Identity
   * accounts are owned by the reseller.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>INVALID_VALUE: Invalid domain value in the request.
   * </ul>
   *
   * <p>Return value: A list of
   * [CloudIdentityCustomerAccount][google.cloud.channel.v1.CloudIdentityCustomerAccount] resources
   * for the domain (may be empty)
   *
   * <p>Note: in the v1alpha1 version of the API, a NOT_FOUND error returns if no
   * [CloudIdentityCustomerAccount][google.cloud.channel.v1.CloudIdentityCustomerAccount] resources
   * match the domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CheckCloudIdentityAccountsExistRequest request =
   *       CheckCloudIdentityAccountsExistRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setDomain("domain-1326197564")
   *           .build();
   *   CheckCloudIdentityAccountsExistResponse response =
   *       cloudChannelServiceClient.checkCloudIdentityAccountsExist(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckCloudIdentityAccountsExistResponse checkCloudIdentityAccountsExist(
      CheckCloudIdentityAccountsExistRequest request) {
    return checkCloudIdentityAccountsExistCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Confirms the existence of Cloud Identity accounts based on the domain and if the Cloud Identity
   * accounts are owned by the reseller.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>INVALID_VALUE: Invalid domain value in the request.
   * </ul>
   *
   * <p>Return value: A list of
   * [CloudIdentityCustomerAccount][google.cloud.channel.v1.CloudIdentityCustomerAccount] resources
   * for the domain (may be empty)
   *
   * <p>Note: in the v1alpha1 version of the API, a NOT_FOUND error returns if no
   * [CloudIdentityCustomerAccount][google.cloud.channel.v1.CloudIdentityCustomerAccount] resources
   * match the domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CheckCloudIdentityAccountsExistRequest request =
   *       CheckCloudIdentityAccountsExistRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setDomain("domain-1326197564")
   *           .build();
   *   ApiFuture<CheckCloudIdentityAccountsExistResponse> future =
   *       cloudChannelServiceClient.checkCloudIdentityAccountsExistCallable().futureCall(request);
   *   // Do something.
   *   CheckCloudIdentityAccountsExistResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          CheckCloudIdentityAccountsExistRequest, CheckCloudIdentityAccountsExistResponse>
      checkCloudIdentityAccountsExistCallable() {
    return stub.checkCloudIdentityAccountsExistCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [Customer][google.cloud.channel.v1.Customer] resource under the reseller or
   * distributor account.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: &#42; Required request parameters are missing or invalid. &#42; Domain
   *       field value doesn't match the primary email domain.
   * </ul>
   *
   * <p>Return value: The newly created [Customer][google.cloud.channel.v1.Customer] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CreateCustomerRequest request =
   *       CreateCustomerRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCustomer(Customer.newBuilder().build())
   *           .build();
   *   Customer response = cloudChannelServiceClient.createCustomer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Customer createCustomer(CreateCustomerRequest request) {
    return createCustomerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [Customer][google.cloud.channel.v1.Customer] resource under the reseller or
   * distributor account.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: &#42; Required request parameters are missing or invalid. &#42; Domain
   *       field value doesn't match the primary email domain.
   * </ul>
   *
   * <p>Return value: The newly created [Customer][google.cloud.channel.v1.Customer] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CreateCustomerRequest request =
   *       CreateCustomerRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCustomer(Customer.newBuilder().build())
   *           .build();
   *   ApiFuture<Customer> future =
   *       cloudChannelServiceClient.createCustomerCallable().futureCall(request);
   *   // Do something.
   *   Customer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCustomerRequest, Customer> createCustomerCallable() {
    return stub.createCustomerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing [Customer][google.cloud.channel.v1.Customer] resource for the reseller or
   * distributor.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name in
   *       the request.
   * </ul>
   *
   * <p>Return value: The updated [Customer][google.cloud.channel.v1.Customer] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   UpdateCustomerRequest request =
   *       UpdateCustomerRequest.newBuilder()
   *           .setCustomer(Customer.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Customer response = cloudChannelServiceClient.updateCustomer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Customer updateCustomer(UpdateCustomerRequest request) {
    return updateCustomerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing [Customer][google.cloud.channel.v1.Customer] resource for the reseller or
   * distributor.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name in
   *       the request.
   * </ul>
   *
   * <p>Return value: The updated [Customer][google.cloud.channel.v1.Customer] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   UpdateCustomerRequest request =
   *       UpdateCustomerRequest.newBuilder()
   *           .setCustomer(Customer.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Customer> future =
   *       cloudChannelServiceClient.updateCustomerCallable().futureCall(request);
   *   // Do something.
   *   Customer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCustomerRequest, Customer> updateCustomerCallable() {
    return stub.updateCustomerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the given [Customer][google.cloud.channel.v1.Customer] permanently.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The account making the request does not own this customer.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>FAILED_PRECONDITION: The customer has existing entitlements.
   *   <li>NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name in
   *       the request.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CustomerName name = CustomerName.of("[ACCOUNT]", "[CUSTOMER]");
   *   cloudChannelServiceClient.deleteCustomer(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the customer to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCustomer(CustomerName name) {
    DeleteCustomerRequest request =
        DeleteCustomerRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteCustomer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the given [Customer][google.cloud.channel.v1.Customer] permanently.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The account making the request does not own this customer.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>FAILED_PRECONDITION: The customer has existing entitlements.
   *   <li>NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name in
   *       the request.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   String name = CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString();
   *   cloudChannelServiceClient.deleteCustomer(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the customer to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCustomer(String name) {
    DeleteCustomerRequest request = DeleteCustomerRequest.newBuilder().setName(name).build();
    deleteCustomer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the given [Customer][google.cloud.channel.v1.Customer] permanently.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The account making the request does not own this customer.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>FAILED_PRECONDITION: The customer has existing entitlements.
   *   <li>NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name in
   *       the request.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   DeleteCustomerRequest request =
   *       DeleteCustomerRequest.newBuilder()
   *           .setName(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .build();
   *   cloudChannelServiceClient.deleteCustomer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCustomer(DeleteCustomerRequest request) {
    deleteCustomerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the given [Customer][google.cloud.channel.v1.Customer] permanently.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The account making the request does not own this customer.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>FAILED_PRECONDITION: The customer has existing entitlements.
   *   <li>NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name in
   *       the request.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   DeleteCustomerRequest request =
   *       DeleteCustomerRequest.newBuilder()
   *           .setName(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       cloudChannelServiceClient.deleteCustomerCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCustomerRequest, Empty> deleteCustomerCallable() {
    return stub.deleteCustomerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports a [Customer][google.cloud.channel.v1.Customer] from the Cloud Identity associated with
   * the provided Cloud Identity ID or domain before a TransferEntitlements call. If a linked
   * Customer already exists and overwrite_if_exists is true, it will update that Customer's data.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>NOT_FOUND: Cloud Identity doesn't exist or was deleted.
   *   <li>INVALID_ARGUMENT: Required parameters are missing, or the auth_token is expired or
   *       invalid.
   *   <li>ALREADY_EXISTS: A customer already exists and has conflicting critical fields. Requires
   *       an overwrite.
   * </ul>
   *
   * <p>Return value: The [Customer][google.cloud.channel.v1.Customer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ImportCustomerRequest request =
   *       ImportCustomerRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setAuthToken("authToken1450587441")
   *           .setOverwriteIfExists(true)
   *           .setChannelPartnerId("channelPartnerId-170366400")
   *           .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .build();
   *   Customer response = cloudChannelServiceClient.importCustomer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Customer importCustomer(ImportCustomerRequest request) {
    return importCustomerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports a [Customer][google.cloud.channel.v1.Customer] from the Cloud Identity associated with
   * the provided Cloud Identity ID or domain before a TransferEntitlements call. If a linked
   * Customer already exists and overwrite_if_exists is true, it will update that Customer's data.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>NOT_FOUND: Cloud Identity doesn't exist or was deleted.
   *   <li>INVALID_ARGUMENT: Required parameters are missing, or the auth_token is expired or
   *       invalid.
   *   <li>ALREADY_EXISTS: A customer already exists and has conflicting critical fields. Requires
   *       an overwrite.
   * </ul>
   *
   * <p>Return value: The [Customer][google.cloud.channel.v1.Customer].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ImportCustomerRequest request =
   *       ImportCustomerRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setAuthToken("authToken1450587441")
   *           .setOverwriteIfExists(true)
   *           .setChannelPartnerId("channelPartnerId-170366400")
   *           .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .build();
   *   ApiFuture<Customer> future =
   *       cloudChannelServiceClient.importCustomerCallable().futureCall(request);
   *   // Do something.
   *   Customer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportCustomerRequest, Customer> importCustomerCallable() {
    return stub.importCustomerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Cloud Identity for the given customer using the customer's information, or the
   * information provided here.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The customer was not found.
   *   <li>ALREADY_EXISTS: The customer's primary email already exists. Retry after changing the
   *       customer's primary contact email.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata contains an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ProvisionCloudIdentityRequest request =
   *       ProvisionCloudIdentityRequest.newBuilder()
   *           .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setCloudIdentityInfo(CloudIdentityInfo.newBuilder().build())
   *           .setUser(AdminUser.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Customer response = cloudChannelServiceClient.provisionCloudIdentityAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Customer, OperationMetadata> provisionCloudIdentityAsync(
      ProvisionCloudIdentityRequest request) {
    return provisionCloudIdentityOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Cloud Identity for the given customer using the customer's information, or the
   * information provided here.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The customer was not found.
   *   <li>ALREADY_EXISTS: The customer's primary email already exists. Retry after changing the
   *       customer's primary contact email.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata contains an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ProvisionCloudIdentityRequest request =
   *       ProvisionCloudIdentityRequest.newBuilder()
   *           .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setCloudIdentityInfo(CloudIdentityInfo.newBuilder().build())
   *           .setUser(AdminUser.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Customer, OperationMetadata> future =
   *       cloudChannelServiceClient.provisionCloudIdentityOperationCallable().futureCall(request);
   *   // Do something.
   *   Customer response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ProvisionCloudIdentityRequest, Customer, OperationMetadata>
      provisionCloudIdentityOperationCallable() {
    return stub.provisionCloudIdentityOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Cloud Identity for the given customer using the customer's information, or the
   * information provided here.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The customer was not found.
   *   <li>ALREADY_EXISTS: The customer's primary email already exists. Retry after changing the
   *       customer's primary contact email.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata contains an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ProvisionCloudIdentityRequest request =
   *       ProvisionCloudIdentityRequest.newBuilder()
   *           .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setCloudIdentityInfo(CloudIdentityInfo.newBuilder().build())
   *           .setUser(AdminUser.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudChannelServiceClient.provisionCloudIdentityCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ProvisionCloudIdentityRequest, Operation>
      provisionCloudIdentityCallable() {
    return stub.provisionCloudIdentityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Entitlement][google.cloud.channel.v1.Entitlement]s belonging to a customer.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   * </ul>
   *
   * <p>Return value: A list of the customer's [Entitlement][google.cloud.channel.v1.Entitlement]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListEntitlementsRequest request =
   *       ListEntitlementsRequest.newBuilder()
   *           .setParent(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Entitlement element : cloudChannelServiceClient.listEntitlements(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntitlementsPagedResponse listEntitlements(ListEntitlementsRequest request) {
    return listEntitlementsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Entitlement][google.cloud.channel.v1.Entitlement]s belonging to a customer.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   * </ul>
   *
   * <p>Return value: A list of the customer's [Entitlement][google.cloud.channel.v1.Entitlement]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListEntitlementsRequest request =
   *       ListEntitlementsRequest.newBuilder()
   *           .setParent(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Entitlement> future =
   *       cloudChannelServiceClient.listEntitlementsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Entitlement element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEntitlementsRequest, ListEntitlementsPagedResponse>
      listEntitlementsPagedCallable() {
    return stub.listEntitlementsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Entitlement][google.cloud.channel.v1.Entitlement]s belonging to a customer.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   * </ul>
   *
   * <p>Return value: A list of the customer's [Entitlement][google.cloud.channel.v1.Entitlement]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListEntitlementsRequest request =
   *       ListEntitlementsRequest.newBuilder()
   *           .setParent(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListEntitlementsResponse response =
   *         cloudChannelServiceClient.listEntitlementsCallable().call(request);
   *     for (Entitlement element : response.getEntitlementsList()) {
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
  public final UnaryCallable<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsCallable() {
    return stub.listEntitlementsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [TransferableSku][google.cloud.channel.v1.TransferableSku]s of a customer based on the
   * Cloud Identity ID or Customer Name in the request.
   *
   * <p>Use this method to list the entitlements information of an unowned customer. You should
   * provide the customer's Cloud Identity ID or Customer Name.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: &#42; The customer doesn't belong to the reseller and has no auth
   *       token. &#42; The supplied auth token is invalid. &#42; The reseller account making the
   *       request is different from the reseller account in the query.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   * </ul>
   *
   * <p>Return value: A list of the customer's
   * [TransferableSku][google.cloud.channel.v1.TransferableSku].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListTransferableSkusRequest request =
   *       ListTransferableSkusRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setAuthToken("authToken1450587441")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   for (TransferableSku element :
   *       cloudChannelServiceClient.listTransferableSkus(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTransferableSkusPagedResponse listTransferableSkus(
      ListTransferableSkusRequest request) {
    return listTransferableSkusPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [TransferableSku][google.cloud.channel.v1.TransferableSku]s of a customer based on the
   * Cloud Identity ID or Customer Name in the request.
   *
   * <p>Use this method to list the entitlements information of an unowned customer. You should
   * provide the customer's Cloud Identity ID or Customer Name.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: &#42; The customer doesn't belong to the reseller and has no auth
   *       token. &#42; The supplied auth token is invalid. &#42; The reseller account making the
   *       request is different from the reseller account in the query.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   * </ul>
   *
   * <p>Return value: A list of the customer's
   * [TransferableSku][google.cloud.channel.v1.TransferableSku].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListTransferableSkusRequest request =
   *       ListTransferableSkusRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setAuthToken("authToken1450587441")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<TransferableSku> future =
   *       cloudChannelServiceClient.listTransferableSkusPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TransferableSku element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTransferableSkusRequest, ListTransferableSkusPagedResponse>
      listTransferableSkusPagedCallable() {
    return stub.listTransferableSkusPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [TransferableSku][google.cloud.channel.v1.TransferableSku]s of a customer based on the
   * Cloud Identity ID or Customer Name in the request.
   *
   * <p>Use this method to list the entitlements information of an unowned customer. You should
   * provide the customer's Cloud Identity ID or Customer Name.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: &#42; The customer doesn't belong to the reseller and has no auth
   *       token. &#42; The supplied auth token is invalid. &#42; The reseller account making the
   *       request is different from the reseller account in the query.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   * </ul>
   *
   * <p>Return value: A list of the customer's
   * [TransferableSku][google.cloud.channel.v1.TransferableSku].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListTransferableSkusRequest request =
   *       ListTransferableSkusRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setAuthToken("authToken1450587441")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   while (true) {
   *     ListTransferableSkusResponse response =
   *         cloudChannelServiceClient.listTransferableSkusCallable().call(request);
   *     for (TransferableSku element : response.getTransferableSkusList()) {
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
  public final UnaryCallable<ListTransferableSkusRequest, ListTransferableSkusResponse>
      listTransferableSkusCallable() {
    return stub.listTransferableSkusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [TransferableOffer][google.cloud.channel.v1.TransferableOffer]s of a customer based on
   * Cloud Identity ID or Customer Name in the request.
   *
   * <p>Use this method when a reseller gets the entitlement information of an unowned customer. The
   * reseller should provide the customer's Cloud Identity ID or Customer Name.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: &#42; The customer doesn't belong to the reseller and has no auth
   *       token. &#42; The supplied auth token is invalid. &#42; The reseller account making the
   *       request is different from the reseller account in the query.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   * </ul>
   *
   * <p>Return value: List of [TransferableOffer][google.cloud.channel.v1.TransferableOffer] for the
   * given customer and SKU.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListTransferableOffersRequest request =
   *       ListTransferableOffersRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setSku("sku113949")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   for (TransferableOffer element :
   *       cloudChannelServiceClient.listTransferableOffers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTransferableOffersPagedResponse listTransferableOffers(
      ListTransferableOffersRequest request) {
    return listTransferableOffersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [TransferableOffer][google.cloud.channel.v1.TransferableOffer]s of a customer based on
   * Cloud Identity ID or Customer Name in the request.
   *
   * <p>Use this method when a reseller gets the entitlement information of an unowned customer. The
   * reseller should provide the customer's Cloud Identity ID or Customer Name.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: &#42; The customer doesn't belong to the reseller and has no auth
   *       token. &#42; The supplied auth token is invalid. &#42; The reseller account making the
   *       request is different from the reseller account in the query.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   * </ul>
   *
   * <p>Return value: List of [TransferableOffer][google.cloud.channel.v1.TransferableOffer] for the
   * given customer and SKU.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListTransferableOffersRequest request =
   *       ListTransferableOffersRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setSku("sku113949")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<TransferableOffer> future =
   *       cloudChannelServiceClient.listTransferableOffersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TransferableOffer element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTransferableOffersRequest, ListTransferableOffersPagedResponse>
      listTransferableOffersPagedCallable() {
    return stub.listTransferableOffersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [TransferableOffer][google.cloud.channel.v1.TransferableOffer]s of a customer based on
   * Cloud Identity ID or Customer Name in the request.
   *
   * <p>Use this method when a reseller gets the entitlement information of an unowned customer. The
   * reseller should provide the customer's Cloud Identity ID or Customer Name.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: &#42; The customer doesn't belong to the reseller and has no auth
   *       token. &#42; The supplied auth token is invalid. &#42; The reseller account making the
   *       request is different from the reseller account in the query.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   * </ul>
   *
   * <p>Return value: List of [TransferableOffer][google.cloud.channel.v1.TransferableOffer] for the
   * given customer and SKU.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListTransferableOffersRequest request =
   *       ListTransferableOffersRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setSku("sku113949")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   while (true) {
   *     ListTransferableOffersResponse response =
   *         cloudChannelServiceClient.listTransferableOffersCallable().call(request);
   *     for (TransferableOffer element : response.getTransferableOffersList()) {
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
  public final UnaryCallable<ListTransferableOffersRequest, ListTransferableOffersResponse>
      listTransferableOffersCallable() {
    return stub.listTransferableOffersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [Entitlement][google.cloud.channel.v1.Entitlement] resource.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The customer entitlement was not found.
   * </ul>
   *
   * <p>Return value: The requested [Entitlement][google.cloud.channel.v1.Entitlement] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   GetEntitlementRequest request =
   *       GetEntitlementRequest.newBuilder()
   *           .setName(EntitlementName.of("[ACCOUNT]", "[CUSTOMER]", "[ENTITLEMENT]").toString())
   *           .build();
   *   Entitlement response = cloudChannelServiceClient.getEntitlement(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entitlement getEntitlement(GetEntitlementRequest request) {
    return getEntitlementCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [Entitlement][google.cloud.channel.v1.Entitlement] resource.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The customer entitlement was not found.
   * </ul>
   *
   * <p>Return value: The requested [Entitlement][google.cloud.channel.v1.Entitlement] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   GetEntitlementRequest request =
   *       GetEntitlementRequest.newBuilder()
   *           .setName(EntitlementName.of("[ACCOUNT]", "[CUSTOMER]", "[ENTITLEMENT]").toString())
   *           .build();
   *   ApiFuture<Entitlement> future =
   *       cloudChannelServiceClient.getEntitlementCallable().futureCall(request);
   *   // Do something.
   *   Entitlement response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEntitlementRequest, Entitlement> getEntitlementCallable() {
    return stub.getEntitlementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entitlement for a customer.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: &#42; Required request parameters are missing or invalid. &#42; There
   *       is already a customer entitlement for a SKU from the same product family.
   *   <li>INVALID_VALUE: Make sure the OfferId is valid. If it is, contact Google Channel support
   *       for further troubleshooting.
   *   <li>NOT_FOUND: The customer or offer resource was not found.
   *   <li>ALREADY_EXISTS: &#42; The SKU was already purchased for the customer. &#42; The
   *       customer's primary email already exists. Retry after changing the customer's primary
   *       contact email.
   *   <li>CONDITION_NOT_MET or FAILED_PRECONDITION: &#42; The domain required for purchasing a SKU
   *       has not been verified. &#42; A pre-requisite SKU required to purchase an Add-On SKU is
   *       missing. For example, Google Workspace Business Starter is required to purchase Vault or
   *       Drive. &#42; (Developer accounts only) Reseller and resold domain must meet the following
   *       naming requirements: &#42; Domain names must start with goog-test. &#42; Domain names
   *       must include the reseller domain.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CreateEntitlementRequest request =
   *       CreateEntitlementRequest.newBuilder()
   *           .setParent(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setEntitlement(Entitlement.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Entitlement response = cloudChannelServiceClient.createEntitlementAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Entitlement, OperationMetadata> createEntitlementAsync(
      CreateEntitlementRequest request) {
    return createEntitlementOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entitlement for a customer.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: &#42; Required request parameters are missing or invalid. &#42; There
   *       is already a customer entitlement for a SKU from the same product family.
   *   <li>INVALID_VALUE: Make sure the OfferId is valid. If it is, contact Google Channel support
   *       for further troubleshooting.
   *   <li>NOT_FOUND: The customer or offer resource was not found.
   *   <li>ALREADY_EXISTS: &#42; The SKU was already purchased for the customer. &#42; The
   *       customer's primary email already exists. Retry after changing the customer's primary
   *       contact email.
   *   <li>CONDITION_NOT_MET or FAILED_PRECONDITION: &#42; The domain required for purchasing a SKU
   *       has not been verified. &#42; A pre-requisite SKU required to purchase an Add-On SKU is
   *       missing. For example, Google Workspace Business Starter is required to purchase Vault or
   *       Drive. &#42; (Developer accounts only) Reseller and resold domain must meet the following
   *       naming requirements: &#42; Domain names must start with goog-test. &#42; Domain names
   *       must include the reseller domain.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CreateEntitlementRequest request =
   *       CreateEntitlementRequest.newBuilder()
   *           .setParent(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setEntitlement(Entitlement.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Entitlement, OperationMetadata> future =
   *       cloudChannelServiceClient.createEntitlementOperationCallable().futureCall(request);
   *   // Do something.
   *   Entitlement response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEntitlementRequest, Entitlement, OperationMetadata>
      createEntitlementOperationCallable() {
    return stub.createEntitlementOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entitlement for a customer.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: &#42; Required request parameters are missing or invalid. &#42; There
   *       is already a customer entitlement for a SKU from the same product family.
   *   <li>INVALID_VALUE: Make sure the OfferId is valid. If it is, contact Google Channel support
   *       for further troubleshooting.
   *   <li>NOT_FOUND: The customer or offer resource was not found.
   *   <li>ALREADY_EXISTS: &#42; The SKU was already purchased for the customer. &#42; The
   *       customer's primary email already exists. Retry after changing the customer's primary
   *       contact email.
   *   <li>CONDITION_NOT_MET or FAILED_PRECONDITION: &#42; The domain required for purchasing a SKU
   *       has not been verified. &#42; A pre-requisite SKU required to purchase an Add-On SKU is
   *       missing. For example, Google Workspace Business Starter is required to purchase Vault or
   *       Drive. &#42; (Developer accounts only) Reseller and resold domain must meet the following
   *       naming requirements: &#42; Domain names must start with goog-test. &#42; Domain names
   *       must include the reseller domain.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CreateEntitlementRequest request =
   *       CreateEntitlementRequest.newBuilder()
   *           .setParent(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setEntitlement(Entitlement.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudChannelServiceClient.createEntitlementCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEntitlementRequest, Operation> createEntitlementCallable() {
    return stub.createEntitlementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Change parameters of the entitlement.
   *
   * <p>An entitlement update is a long-running operation and it updates the entitlement as a result
   * of fulfillment.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid. For example, the
   *       number of seats being changed is greater than the allowed number of max seats, or
   *       decreasing seats for a commitment based plan.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ChangeParametersRequest request =
   *       ChangeParametersRequest.newBuilder()
   *           .setName("name3373707")
   *           .addAllParameters(new ArrayList<Parameter>())
   *           .setRequestId("requestId693933066")
   *           .setPurchaseOrderId("purchaseOrderId2029917384")
   *           .build();
   *   Entitlement response = cloudChannelServiceClient.changeParametersAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Entitlement, OperationMetadata> changeParametersAsync(
      ChangeParametersRequest request) {
    return changeParametersOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Change parameters of the entitlement.
   *
   * <p>An entitlement update is a long-running operation and it updates the entitlement as a result
   * of fulfillment.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid. For example, the
   *       number of seats being changed is greater than the allowed number of max seats, or
   *       decreasing seats for a commitment based plan.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ChangeParametersRequest request =
   *       ChangeParametersRequest.newBuilder()
   *           .setName("name3373707")
   *           .addAllParameters(new ArrayList<Parameter>())
   *           .setRequestId("requestId693933066")
   *           .setPurchaseOrderId("purchaseOrderId2029917384")
   *           .build();
   *   OperationFuture<Entitlement, OperationMetadata> future =
   *       cloudChannelServiceClient.changeParametersOperationCallable().futureCall(request);
   *   // Do something.
   *   Entitlement response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ChangeParametersRequest, Entitlement, OperationMetadata>
      changeParametersOperationCallable() {
    return stub.changeParametersOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Change parameters of the entitlement.
   *
   * <p>An entitlement update is a long-running operation and it updates the entitlement as a result
   * of fulfillment.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid. For example, the
   *       number of seats being changed is greater than the allowed number of max seats, or
   *       decreasing seats for a commitment based plan.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ChangeParametersRequest request =
   *       ChangeParametersRequest.newBuilder()
   *           .setName("name3373707")
   *           .addAllParameters(new ArrayList<Parameter>())
   *           .setRequestId("requestId693933066")
   *           .setPurchaseOrderId("purchaseOrderId2029917384")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudChannelServiceClient.changeParametersCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ChangeParametersRequest, Operation> changeParametersCallable() {
    return stub.changeParametersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the renewal settings for an existing customer entitlement.
   *
   * <p>An entitlement update is a long-running operation and it updates the entitlement as a result
   * of fulfillment.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>NOT_COMMITMENT_PLAN: Renewal Settings are only applicable for a commitment plan. Can't
   *       enable or disable renewals for non-commitment plans.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ChangeRenewalSettingsRequest request =
   *       ChangeRenewalSettingsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRenewalSettings(RenewalSettings.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Entitlement response = cloudChannelServiceClient.changeRenewalSettingsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Entitlement, OperationMetadata> changeRenewalSettingsAsync(
      ChangeRenewalSettingsRequest request) {
    return changeRenewalSettingsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the renewal settings for an existing customer entitlement.
   *
   * <p>An entitlement update is a long-running operation and it updates the entitlement as a result
   * of fulfillment.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>NOT_COMMITMENT_PLAN: Renewal Settings are only applicable for a commitment plan. Can't
   *       enable or disable renewals for non-commitment plans.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ChangeRenewalSettingsRequest request =
   *       ChangeRenewalSettingsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRenewalSettings(RenewalSettings.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Entitlement, OperationMetadata> future =
   *       cloudChannelServiceClient.changeRenewalSettingsOperationCallable().futureCall(request);
   *   // Do something.
   *   Entitlement response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ChangeRenewalSettingsRequest, Entitlement, OperationMetadata>
      changeRenewalSettingsOperationCallable() {
    return stub.changeRenewalSettingsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the renewal settings for an existing customer entitlement.
   *
   * <p>An entitlement update is a long-running operation and it updates the entitlement as a result
   * of fulfillment.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>NOT_COMMITMENT_PLAN: Renewal Settings are only applicable for a commitment plan. Can't
   *       enable or disable renewals for non-commitment plans.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ChangeRenewalSettingsRequest request =
   *       ChangeRenewalSettingsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRenewalSettings(RenewalSettings.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudChannelServiceClient.changeRenewalSettingsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ChangeRenewalSettingsRequest, Operation>
      changeRenewalSettingsCallable() {
    return stub.changeRenewalSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Offer for an existing customer entitlement.
   *
   * <p>An entitlement update is a long-running operation and it updates the entitlement as a result
   * of fulfillment.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Offer or Entitlement resource not found.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ChangeOfferRequest request =
   *       ChangeOfferRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOffer(OfferName.of("[ACCOUNT]", "[OFFER]").toString())
   *           .addAllParameters(new ArrayList<Parameter>())
   *           .setPurchaseOrderId("purchaseOrderId2029917384")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Entitlement response = cloudChannelServiceClient.changeOfferAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Entitlement, OperationMetadata> changeOfferAsync(
      ChangeOfferRequest request) {
    return changeOfferOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Offer for an existing customer entitlement.
   *
   * <p>An entitlement update is a long-running operation and it updates the entitlement as a result
   * of fulfillment.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Offer or Entitlement resource not found.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ChangeOfferRequest request =
   *       ChangeOfferRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOffer(OfferName.of("[ACCOUNT]", "[OFFER]").toString())
   *           .addAllParameters(new ArrayList<Parameter>())
   *           .setPurchaseOrderId("purchaseOrderId2029917384")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Entitlement, OperationMetadata> future =
   *       cloudChannelServiceClient.changeOfferOperationCallable().futureCall(request);
   *   // Do something.
   *   Entitlement response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ChangeOfferRequest, Entitlement, OperationMetadata>
      changeOfferOperationCallable() {
    return stub.changeOfferOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Offer for an existing customer entitlement.
   *
   * <p>An entitlement update is a long-running operation and it updates the entitlement as a result
   * of fulfillment.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Offer or Entitlement resource not found.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ChangeOfferRequest request =
   *       ChangeOfferRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOffer(OfferName.of("[ACCOUNT]", "[OFFER]").toString())
   *           .addAllParameters(new ArrayList<Parameter>())
   *           .setPurchaseOrderId("purchaseOrderId2029917384")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudChannelServiceClient.changeOfferCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ChangeOfferRequest, Operation> changeOfferCallable() {
    return stub.changeOfferCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts paid service for a trial entitlement.
   *
   * <p>Starts paid service for a trial entitlement immediately. This method is only applicable if a
   * plan is set up for a trial entitlement but has some trial days remaining.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>FAILED_PRECONDITION/NOT_IN_TRIAL: This method only works for entitlement on trial plans.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   StartPaidServiceRequest request =
   *       StartPaidServiceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Entitlement response = cloudChannelServiceClient.startPaidServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Entitlement, OperationMetadata> startPaidServiceAsync(
      StartPaidServiceRequest request) {
    return startPaidServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts paid service for a trial entitlement.
   *
   * <p>Starts paid service for a trial entitlement immediately. This method is only applicable if a
   * plan is set up for a trial entitlement but has some trial days remaining.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>FAILED_PRECONDITION/NOT_IN_TRIAL: This method only works for entitlement on trial plans.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   StartPaidServiceRequest request =
   *       StartPaidServiceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Entitlement, OperationMetadata> future =
   *       cloudChannelServiceClient.startPaidServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   Entitlement response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StartPaidServiceRequest, Entitlement, OperationMetadata>
      startPaidServiceOperationCallable() {
    return stub.startPaidServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts paid service for a trial entitlement.
   *
   * <p>Starts paid service for a trial entitlement immediately. This method is only applicable if a
   * plan is set up for a trial entitlement but has some trial days remaining.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>FAILED_PRECONDITION/NOT_IN_TRIAL: This method only works for entitlement on trial plans.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   StartPaidServiceRequest request =
   *       StartPaidServiceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudChannelServiceClient.startPaidServiceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartPaidServiceRequest, Operation> startPaidServiceCallable() {
    return stub.startPaidServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Suspends a previously fulfilled entitlement.
   *
   * <p>An entitlement suspension is a long-running operation.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>NOT_ACTIVE: Entitlement is not active.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   SuspendEntitlementRequest request =
   *       SuspendEntitlementRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Entitlement response = cloudChannelServiceClient.suspendEntitlementAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Entitlement, OperationMetadata> suspendEntitlementAsync(
      SuspendEntitlementRequest request) {
    return suspendEntitlementOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Suspends a previously fulfilled entitlement.
   *
   * <p>An entitlement suspension is a long-running operation.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>NOT_ACTIVE: Entitlement is not active.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   SuspendEntitlementRequest request =
   *       SuspendEntitlementRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Entitlement, OperationMetadata> future =
   *       cloudChannelServiceClient.suspendEntitlementOperationCallable().futureCall(request);
   *   // Do something.
   *   Entitlement response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SuspendEntitlementRequest, Entitlement, OperationMetadata>
      suspendEntitlementOperationCallable() {
    return stub.suspendEntitlementOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Suspends a previously fulfilled entitlement.
   *
   * <p>An entitlement suspension is a long-running operation.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>NOT_ACTIVE: Entitlement is not active.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   SuspendEntitlementRequest request =
   *       SuspendEntitlementRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudChannelServiceClient.suspendEntitlementCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SuspendEntitlementRequest, Operation> suspendEntitlementCallable() {
    return stub.suspendEntitlementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a previously fulfilled entitlement.
   *
   * <p>An entitlement cancellation is a long-running operation.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>FAILED_PRECONDITION: There are Google Cloud projects linked to the Google Cloud
   *       entitlement's Cloud Billing subaccount.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>DELETION_TYPE_NOT_ALLOWED: Cancel is only allowed for Google Workspace add-ons, or
   *       entitlements for Google Cloud's development platform.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The response will contain google.protobuf.Empty on success. The
   * Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CancelEntitlementRequest request =
   *       CancelEntitlementRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   cloudChannelServiceClient.cancelEntitlementAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> cancelEntitlementAsync(
      CancelEntitlementRequest request) {
    return cancelEntitlementOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a previously fulfilled entitlement.
   *
   * <p>An entitlement cancellation is a long-running operation.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>FAILED_PRECONDITION: There are Google Cloud projects linked to the Google Cloud
   *       entitlement's Cloud Billing subaccount.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>DELETION_TYPE_NOT_ALLOWED: Cancel is only allowed for Google Workspace add-ons, or
   *       entitlements for Google Cloud's development platform.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The response will contain google.protobuf.Empty on success. The
   * Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CancelEntitlementRequest request =
   *       CancelEntitlementRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       cloudChannelServiceClient.cancelEntitlementOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CancelEntitlementRequest, Empty, OperationMetadata>
      cancelEntitlementOperationCallable() {
    return stub.cancelEntitlementOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a previously fulfilled entitlement.
   *
   * <p>An entitlement cancellation is a long-running operation.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>FAILED_PRECONDITION: There are Google Cloud projects linked to the Google Cloud
   *       entitlement's Cloud Billing subaccount.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>DELETION_TYPE_NOT_ALLOWED: Cancel is only allowed for Google Workspace add-ons, or
   *       entitlements for Google Cloud's development platform.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The response will contain google.protobuf.Empty on success. The
   * Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CancelEntitlementRequest request =
   *       CancelEntitlementRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudChannelServiceClient.cancelEntitlementCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelEntitlementRequest, Operation> cancelEntitlementCallable() {
    return stub.cancelEntitlementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a previously suspended entitlement. Entitlements suspended for pending ToS acceptance
   * can't be activated using this method.
   *
   * <p>An entitlement activation is a long-running operation and it updates the state of the
   * customer entitlement.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>SUSPENSION_NOT_RESELLER_INITIATED: Can only activate reseller-initiated suspensions and
   *       entitlements that have accepted the TOS.
   *   <li>NOT_SUSPENDED: Can only activate suspended entitlements not in an ACTIVE state.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ActivateEntitlementRequest request =
   *       ActivateEntitlementRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Entitlement response = cloudChannelServiceClient.activateEntitlementAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Entitlement, OperationMetadata> activateEntitlementAsync(
      ActivateEntitlementRequest request) {
    return activateEntitlementOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a previously suspended entitlement. Entitlements suspended for pending ToS acceptance
   * can't be activated using this method.
   *
   * <p>An entitlement activation is a long-running operation and it updates the state of the
   * customer entitlement.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>SUSPENSION_NOT_RESELLER_INITIATED: Can only activate reseller-initiated suspensions and
   *       entitlements that have accepted the TOS.
   *   <li>NOT_SUSPENDED: Can only activate suspended entitlements not in an ACTIVE state.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ActivateEntitlementRequest request =
   *       ActivateEntitlementRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Entitlement, OperationMetadata> future =
   *       cloudChannelServiceClient.activateEntitlementOperationCallable().futureCall(request);
   *   // Do something.
   *   Entitlement response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ActivateEntitlementRequest, Entitlement, OperationMetadata>
      activateEntitlementOperationCallable() {
    return stub.activateEntitlementOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a previously suspended entitlement. Entitlements suspended for pending ToS acceptance
   * can't be activated using this method.
   *
   * <p>An entitlement activation is a long-running operation and it updates the state of the
   * customer entitlement.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>SUSPENSION_NOT_RESELLER_INITIATED: Can only activate reseller-initiated suspensions and
   *       entitlements that have accepted the TOS.
   *   <li>NOT_SUSPENDED: Can only activate suspended entitlements not in an ACTIVE state.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ActivateEntitlementRequest request =
   *       ActivateEntitlementRequest.newBuilder()
   *           .setName("name3373707")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudChannelServiceClient.activateEntitlementCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ActivateEntitlementRequest, Operation> activateEntitlementCallable() {
    return stub.activateEntitlementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Transfers customer entitlements to new reseller.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The customer or offer resource was not found.
   *   <li>ALREADY_EXISTS: The SKU was already transferred for the customer.
   *   <li>CONDITION_NOT_MET or FAILED_PRECONDITION: &#42; The SKU requires domain verification to
   *       transfer, but the domain is not verified. &#42; An Add-On SKU (example, Vault or Drive)
   *       is missing the pre-requisite SKU (example, G Suite Basic). &#42; (Developer accounts
   *       only) Reseller and resold domain must meet the following naming requirements: &#42;
   *       Domain names must start with goog-test. &#42; Domain names must include the reseller
   *       domain. &#42; Specify all transferring entitlements.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   TransferEntitlementsRequest request =
   *       TransferEntitlementsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllEntitlements(new ArrayList<Entitlement>())
   *           .setAuthToken("authToken1450587441")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   TransferEntitlementsResponse response =
   *       cloudChannelServiceClient.transferEntitlementsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TransferEntitlementsResponse, OperationMetadata>
      transferEntitlementsAsync(TransferEntitlementsRequest request) {
    return transferEntitlementsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Transfers customer entitlements to new reseller.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The customer or offer resource was not found.
   *   <li>ALREADY_EXISTS: The SKU was already transferred for the customer.
   *   <li>CONDITION_NOT_MET or FAILED_PRECONDITION: &#42; The SKU requires domain verification to
   *       transfer, but the domain is not verified. &#42; An Add-On SKU (example, Vault or Drive)
   *       is missing the pre-requisite SKU (example, G Suite Basic). &#42; (Developer accounts
   *       only) Reseller and resold domain must meet the following naming requirements: &#42;
   *       Domain names must start with goog-test. &#42; Domain names must include the reseller
   *       domain. &#42; Specify all transferring entitlements.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   TransferEntitlementsRequest request =
   *       TransferEntitlementsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllEntitlements(new ArrayList<Entitlement>())
   *           .setAuthToken("authToken1450587441")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<TransferEntitlementsResponse, OperationMetadata> future =
   *       cloudChannelServiceClient.transferEntitlementsOperationCallable().futureCall(request);
   *   // Do something.
   *   TransferEntitlementsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          TransferEntitlementsRequest, TransferEntitlementsResponse, OperationMetadata>
      transferEntitlementsOperationCallable() {
    return stub.transferEntitlementsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Transfers customer entitlements to new reseller.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The customer or offer resource was not found.
   *   <li>ALREADY_EXISTS: The SKU was already transferred for the customer.
   *   <li>CONDITION_NOT_MET or FAILED_PRECONDITION: &#42; The SKU requires domain verification to
   *       transfer, but the domain is not verified. &#42; An Add-On SKU (example, Vault or Drive)
   *       is missing the pre-requisite SKU (example, G Suite Basic). &#42; (Developer accounts
   *       only) Reseller and resold domain must meet the following naming requirements: &#42;
   *       Domain names must start with goog-test. &#42; Domain names must include the reseller
   *       domain. &#42; Specify all transferring entitlements.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   TransferEntitlementsRequest request =
   *       TransferEntitlementsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllEntitlements(new ArrayList<Entitlement>())
   *           .setAuthToken("authToken1450587441")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudChannelServiceClient.transferEntitlementsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TransferEntitlementsRequest, Operation>
      transferEntitlementsCallable() {
    return stub.transferEntitlementsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Transfers customer entitlements from their current reseller to Google.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The customer or offer resource was not found.
   *   <li>ALREADY_EXISTS: The SKU was already transferred for the customer.
   *   <li>CONDITION_NOT_MET or FAILED_PRECONDITION: &#42; The SKU requires domain verification to
   *       transfer, but the domain is not verified. &#42; An Add-On SKU (example, Vault or Drive)
   *       is missing the pre-requisite SKU (example, G Suite Basic). &#42; (Developer accounts
   *       only) Reseller and resold domain must meet the following naming requirements: &#42;
   *       Domain names must start with goog-test. &#42; Domain names must include the reseller
   *       domain.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The response will contain google.protobuf.Empty on success. The
   * Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   TransferEntitlementsToGoogleRequest request =
   *       TransferEntitlementsToGoogleRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllEntitlements(new ArrayList<Entitlement>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   cloudChannelServiceClient.transferEntitlementsToGoogleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> transferEntitlementsToGoogleAsync(
      TransferEntitlementsToGoogleRequest request) {
    return transferEntitlementsToGoogleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Transfers customer entitlements from their current reseller to Google.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The customer or offer resource was not found.
   *   <li>ALREADY_EXISTS: The SKU was already transferred for the customer.
   *   <li>CONDITION_NOT_MET or FAILED_PRECONDITION: &#42; The SKU requires domain verification to
   *       transfer, but the domain is not verified. &#42; An Add-On SKU (example, Vault or Drive)
   *       is missing the pre-requisite SKU (example, G Suite Basic). &#42; (Developer accounts
   *       only) Reseller and resold domain must meet the following naming requirements: &#42;
   *       Domain names must start with goog-test. &#42; Domain names must include the reseller
   *       domain.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The response will contain google.protobuf.Empty on success. The
   * Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   TransferEntitlementsToGoogleRequest request =
   *       TransferEntitlementsToGoogleRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllEntitlements(new ArrayList<Entitlement>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       cloudChannelServiceClient
   *           .transferEntitlementsToGoogleOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<TransferEntitlementsToGoogleRequest, Empty, OperationMetadata>
      transferEntitlementsToGoogleOperationCallable() {
    return stub.transferEntitlementsToGoogleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Transfers customer entitlements from their current reseller to Google.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The customer or offer resource was not found.
   *   <li>ALREADY_EXISTS: The SKU was already transferred for the customer.
   *   <li>CONDITION_NOT_MET or FAILED_PRECONDITION: &#42; The SKU requires domain verification to
   *       transfer, but the domain is not verified. &#42; An Add-On SKU (example, Vault or Drive)
   *       is missing the pre-requisite SKU (example, G Suite Basic). &#42; (Developer accounts
   *       only) Reseller and resold domain must meet the following naming requirements: &#42;
   *       Domain names must start with goog-test. &#42; Domain names must include the reseller
   *       domain.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The response will contain google.protobuf.Empty on success. The
   * Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   TransferEntitlementsToGoogleRequest request =
   *       TransferEntitlementsToGoogleRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllEntitlements(new ArrayList<Entitlement>())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudChannelServiceClient.transferEntitlementsToGoogleCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TransferEntitlementsToGoogleRequest, Operation>
      transferEntitlementsToGoogleCallable() {
    return stub.transferEntitlementsToGoogleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]s belonging to a
   * distributor. You must be a distributor to call this method.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   * </ul>
   *
   * <p>Return value: The list of the distributor account's
   * [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListChannelPartnerLinksRequest request =
   *       ListChannelPartnerLinksRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(ChannelPartnerLinkView.forNumber(0))
   *           .build();
   *   for (ChannelPartnerLink element :
   *       cloudChannelServiceClient.listChannelPartnerLinks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelPartnerLinksPagedResponse listChannelPartnerLinks(
      ListChannelPartnerLinksRequest request) {
    return listChannelPartnerLinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]s belonging to a
   * distributor. You must be a distributor to call this method.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   * </ul>
   *
   * <p>Return value: The list of the distributor account's
   * [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListChannelPartnerLinksRequest request =
   *       ListChannelPartnerLinksRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(ChannelPartnerLinkView.forNumber(0))
   *           .build();
   *   ApiFuture<ChannelPartnerLink> future =
   *       cloudChannelServiceClient.listChannelPartnerLinksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ChannelPartnerLink element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListChannelPartnerLinksRequest, ListChannelPartnerLinksPagedResponse>
      listChannelPartnerLinksPagedCallable() {
    return stub.listChannelPartnerLinksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]s belonging to a
   * distributor. You must be a distributor to call this method.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   * </ul>
   *
   * <p>Return value: The list of the distributor account's
   * [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListChannelPartnerLinksRequest request =
   *       ListChannelPartnerLinksRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(ChannelPartnerLinkView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListChannelPartnerLinksResponse response =
   *         cloudChannelServiceClient.listChannelPartnerLinksCallable().call(request);
   *     for (ChannelPartnerLink element : response.getChannelPartnerLinksList()) {
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
  public final UnaryCallable<ListChannelPartnerLinksRequest, ListChannelPartnerLinksResponse>
      listChannelPartnerLinksCallable() {
    return stub.listChannelPartnerLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]
   * resource. You must be a distributor to call this method.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: ChannelPartnerLink resource not found because of an invalid channel partner
   *       link name.
   * </ul>
   *
   * <p>Return value: The [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   GetChannelPartnerLinkRequest request =
   *       GetChannelPartnerLinkRequest.newBuilder()
   *           .setName("name3373707")
   *           .setView(ChannelPartnerLinkView.forNumber(0))
   *           .build();
   *   ChannelPartnerLink response = cloudChannelServiceClient.getChannelPartnerLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelPartnerLink getChannelPartnerLink(GetChannelPartnerLinkRequest request) {
    return getChannelPartnerLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]
   * resource. You must be a distributor to call this method.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: ChannelPartnerLink resource not found because of an invalid channel partner
   *       link name.
   * </ul>
   *
   * <p>Return value: The [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   GetChannelPartnerLinkRequest request =
   *       GetChannelPartnerLinkRequest.newBuilder()
   *           .setName("name3373707")
   *           .setView(ChannelPartnerLinkView.forNumber(0))
   *           .build();
   *   ApiFuture<ChannelPartnerLink> future =
   *       cloudChannelServiceClient.getChannelPartnerLinkCallable().futureCall(request);
   *   // Do something.
   *   ChannelPartnerLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetChannelPartnerLinkRequest, ChannelPartnerLink>
      getChannelPartnerLinkCallable() {
    return stub.getChannelPartnerLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a channel partner link between a distributor and a reseller, or between resellers in
   * an n-tier reseller channel. Invited partners need to follow the invite_link_uri provided in the
   * response to accept. After accepting the invitation, a link is set up between the two parties.
   * You must be a distributor to call this method.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>ALREADY_EXISTS: The ChannelPartnerLink sent in the request already exists.
   *   <li>NOT_FOUND: No Cloud Identity customer exists for provided domain.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The new [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]
   * resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CreateChannelPartnerLinkRequest request =
   *       CreateChannelPartnerLinkRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setChannelPartnerLink(ChannelPartnerLink.newBuilder().build())
   *           .build();
   *   ChannelPartnerLink response = cloudChannelServiceClient.createChannelPartnerLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelPartnerLink createChannelPartnerLink(
      CreateChannelPartnerLinkRequest request) {
    return createChannelPartnerLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a channel partner link between a distributor and a reseller, or between resellers in
   * an n-tier reseller channel. Invited partners need to follow the invite_link_uri provided in the
   * response to accept. After accepting the invitation, a link is set up between the two parties.
   * You must be a distributor to call this method.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>ALREADY_EXISTS: The ChannelPartnerLink sent in the request already exists.
   *   <li>NOT_FOUND: No Cloud Identity customer exists for provided domain.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The new [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]
   * resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CreateChannelPartnerLinkRequest request =
   *       CreateChannelPartnerLinkRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setChannelPartnerLink(ChannelPartnerLink.newBuilder().build())
   *           .build();
   *   ApiFuture<ChannelPartnerLink> future =
   *       cloudChannelServiceClient.createChannelPartnerLinkCallable().futureCall(request);
   *   // Do something.
   *   ChannelPartnerLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateChannelPartnerLinkRequest, ChannelPartnerLink>
      createChannelPartnerLinkCallable() {
    return stub.createChannelPartnerLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a channel partner link. Distributors call this method to change a link's status. For
   * example, to suspend a partner link. You must be a distributor to call this method.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: &#42; Required request parameters are missing or invalid. &#42; Link
   *       state cannot change from invited to active or suspended. &#42; Cannot send
   *       reseller_cloud_identity_id, invite_url, or name in update mask.
   *   <li>NOT_FOUND: ChannelPartnerLink resource not found.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The updated [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]
   * resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   UpdateChannelPartnerLinkRequest request =
   *       UpdateChannelPartnerLinkRequest.newBuilder()
   *           .setName("name3373707")
   *           .setChannelPartnerLink(ChannelPartnerLink.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ChannelPartnerLink response = cloudChannelServiceClient.updateChannelPartnerLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelPartnerLink updateChannelPartnerLink(
      UpdateChannelPartnerLinkRequest request) {
    return updateChannelPartnerLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a channel partner link. Distributors call this method to change a link's status. For
   * example, to suspend a partner link. You must be a distributor to call this method.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request is different from the reseller
   *       account in the API request.
   *   <li>INVALID_ARGUMENT: &#42; Required request parameters are missing or invalid. &#42; Link
   *       state cannot change from invited to active or suspended. &#42; Cannot send
   *       reseller_cloud_identity_id, invite_url, or name in update mask.
   *   <li>NOT_FOUND: ChannelPartnerLink resource not found.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The updated [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]
   * resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   UpdateChannelPartnerLinkRequest request =
   *       UpdateChannelPartnerLinkRequest.newBuilder()
   *           .setName("name3373707")
   *           .setChannelPartnerLink(ChannelPartnerLink.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ChannelPartnerLink> future =
   *       cloudChannelServiceClient.updateChannelPartnerLinkCallable().futureCall(request);
   *   // Do something.
   *   ChannelPartnerLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateChannelPartnerLinkRequest, ChannelPartnerLink>
      updateChannelPartnerLinkCallable() {
    return stub.updateChannelPartnerLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about how a Reseller modifies their bill before sending it to a Customer.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>NOT_FOUND: The [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       was not found.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the
   * [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] resource, otherwise
   * returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CustomerRepricingConfigName name =
   *       CustomerRepricingConfigName.of("[ACCOUNT]", "[CUSTOMER]", "[CUSTOMER_REPRICING_CONFIG]");
   *   CustomerRepricingConfig response = cloudChannelServiceClient.getCustomerRepricingConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomerRepricingConfig. Format:
   *     accounts/{account_id}/customers/{customer_id}/customerRepricingConfigs/{id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomerRepricingConfig getCustomerRepricingConfig(
      CustomerRepricingConfigName name) {
    GetCustomerRepricingConfigRequest request =
        GetCustomerRepricingConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCustomerRepricingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about how a Reseller modifies their bill before sending it to a Customer.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>NOT_FOUND: The [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       was not found.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the
   * [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] resource, otherwise
   * returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   String name =
   *       CustomerRepricingConfigName.of("[ACCOUNT]", "[CUSTOMER]", "[CUSTOMER_REPRICING_CONFIG]")
   *           .toString();
   *   CustomerRepricingConfig response = cloudChannelServiceClient.getCustomerRepricingConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CustomerRepricingConfig. Format:
   *     accounts/{account_id}/customers/{customer_id}/customerRepricingConfigs/{id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomerRepricingConfig getCustomerRepricingConfig(String name) {
    GetCustomerRepricingConfigRequest request =
        GetCustomerRepricingConfigRequest.newBuilder().setName(name).build();
    return getCustomerRepricingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about how a Reseller modifies their bill before sending it to a Customer.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>NOT_FOUND: The [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       was not found.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the
   * [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] resource, otherwise
   * returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   GetCustomerRepricingConfigRequest request =
   *       GetCustomerRepricingConfigRequest.newBuilder()
   *           .setName(
   *               CustomerRepricingConfigName.of(
   *                       "[ACCOUNT]", "[CUSTOMER]", "[CUSTOMER_REPRICING_CONFIG]")
   *                   .toString())
   *           .build();
   *   CustomerRepricingConfig response =
   *       cloudChannelServiceClient.getCustomerRepricingConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomerRepricingConfig getCustomerRepricingConfig(
      GetCustomerRepricingConfigRequest request) {
    return getCustomerRepricingConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about how a Reseller modifies their bill before sending it to a Customer.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>NOT_FOUND: The [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       was not found.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the
   * [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] resource, otherwise
   * returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   GetCustomerRepricingConfigRequest request =
   *       GetCustomerRepricingConfigRequest.newBuilder()
   *           .setName(
   *               CustomerRepricingConfigName.of(
   *                       "[ACCOUNT]", "[CUSTOMER]", "[CUSTOMER_REPRICING_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CustomerRepricingConfig> future =
   *       cloudChannelServiceClient.getCustomerRepricingConfigCallable().futureCall(request);
   *   // Do something.
   *   CustomerRepricingConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCustomerRepricingConfigRequest, CustomerRepricingConfig>
      getCustomerRepricingConfigCallable() {
    return stub.getCustomerRepricingConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about how a Reseller modifies their bill before sending it to a Customer.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>NOT_FOUND: The [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the
   * [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] resources. The data
   * for each resource is displayed in the ascending order of:
   *
   * <ul>
   *   <li>customer ID
   *   <li>[RepricingConfig.EntitlementGranularity.entitlement][google.cloud.channel.v1.RepricingConfig.EntitlementGranularity.entitlement]
   *   <li>[RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   *   <li>[CustomerRepricingConfig.update_time][google.cloud.channel.v1.CustomerRepricingConfig.update_time]
   * </ul>
   *
   * <p>If unsuccessful, returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CustomerName parent = CustomerName.of("[ACCOUNT]", "[CUSTOMER]");
   *   for (CustomerRepricingConfig element :
   *       cloudChannelServiceClient.listCustomerRepricingConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the customer. Parent uses the format:
   *     accounts/{account_id}/customers/{customer_id}. Supports accounts/{account_id}/customers/-
   *     to retrieve configs for all customers.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomerRepricingConfigsPagedResponse listCustomerRepricingConfigs(
      CustomerName parent) {
    ListCustomerRepricingConfigsRequest request =
        ListCustomerRepricingConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCustomerRepricingConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about how a Reseller modifies their bill before sending it to a Customer.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>NOT_FOUND: The [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the
   * [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] resources. The data
   * for each resource is displayed in the ascending order of:
   *
   * <ul>
   *   <li>customer ID
   *   <li>[RepricingConfig.EntitlementGranularity.entitlement][google.cloud.channel.v1.RepricingConfig.EntitlementGranularity.entitlement]
   *   <li>[RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   *   <li>[CustomerRepricingConfig.update_time][google.cloud.channel.v1.CustomerRepricingConfig.update_time]
   * </ul>
   *
   * <p>If unsuccessful, returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   String parent = CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString();
   *   for (CustomerRepricingConfig element :
   *       cloudChannelServiceClient.listCustomerRepricingConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the customer. Parent uses the format:
   *     accounts/{account_id}/customers/{customer_id}. Supports accounts/{account_id}/customers/-
   *     to retrieve configs for all customers.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomerRepricingConfigsPagedResponse listCustomerRepricingConfigs(
      String parent) {
    ListCustomerRepricingConfigsRequest request =
        ListCustomerRepricingConfigsRequest.newBuilder().setParent(parent).build();
    return listCustomerRepricingConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about how a Reseller modifies their bill before sending it to a Customer.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>NOT_FOUND: The [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the
   * [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] resources. The data
   * for each resource is displayed in the ascending order of:
   *
   * <ul>
   *   <li>customer ID
   *   <li>[RepricingConfig.EntitlementGranularity.entitlement][google.cloud.channel.v1.RepricingConfig.EntitlementGranularity.entitlement]
   *   <li>[RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   *   <li>[CustomerRepricingConfig.update_time][google.cloud.channel.v1.CustomerRepricingConfig.update_time]
   * </ul>
   *
   * <p>If unsuccessful, returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListCustomerRepricingConfigsRequest request =
   *       ListCustomerRepricingConfigsRequest.newBuilder()
   *           .setParent(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (CustomerRepricingConfig element :
   *       cloudChannelServiceClient.listCustomerRepricingConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomerRepricingConfigsPagedResponse listCustomerRepricingConfigs(
      ListCustomerRepricingConfigsRequest request) {
    return listCustomerRepricingConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about how a Reseller modifies their bill before sending it to a Customer.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>NOT_FOUND: The [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the
   * [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] resources. The data
   * for each resource is displayed in the ascending order of:
   *
   * <ul>
   *   <li>customer ID
   *   <li>[RepricingConfig.EntitlementGranularity.entitlement][google.cloud.channel.v1.RepricingConfig.EntitlementGranularity.entitlement]
   *   <li>[RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   *   <li>[CustomerRepricingConfig.update_time][google.cloud.channel.v1.CustomerRepricingConfig.update_time]
   * </ul>
   *
   * <p>If unsuccessful, returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListCustomerRepricingConfigsRequest request =
   *       ListCustomerRepricingConfigsRequest.newBuilder()
   *           .setParent(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<CustomerRepricingConfig> future =
   *       cloudChannelServiceClient.listCustomerRepricingConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CustomerRepricingConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListCustomerRepricingConfigsRequest, ListCustomerRepricingConfigsPagedResponse>
      listCustomerRepricingConfigsPagedCallable() {
    return stub.listCustomerRepricingConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about how a Reseller modifies their bill before sending it to a Customer.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>NOT_FOUND: The [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the
   * [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] resources. The data
   * for each resource is displayed in the ascending order of:
   *
   * <ul>
   *   <li>customer ID
   *   <li>[RepricingConfig.EntitlementGranularity.entitlement][google.cloud.channel.v1.RepricingConfig.EntitlementGranularity.entitlement]
   *   <li>[RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   *   <li>[CustomerRepricingConfig.update_time][google.cloud.channel.v1.CustomerRepricingConfig.update_time]
   * </ul>
   *
   * <p>If unsuccessful, returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListCustomerRepricingConfigsRequest request =
   *       ListCustomerRepricingConfigsRequest.newBuilder()
   *           .setParent(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListCustomerRepricingConfigsResponse response =
   *         cloudChannelServiceClient.listCustomerRepricingConfigsCallable().call(request);
   *     for (CustomerRepricingConfig element : response.getCustomerRepricingConfigsList()) {
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
          ListCustomerRepricingConfigsRequest, ListCustomerRepricingConfigsResponse>
      listCustomerRepricingConfigsCallable() {
    return stub.listCustomerRepricingConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a CustomerRepricingConfig. Call this method to set modifications for a specific
   * customer's bill. You can only create configs if the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is a future month. If needed, you can create a config for the current month, with some
   * restrictions.
   *
   * <p>When creating a config for a future month, make sure there are no existing configs for that
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *
   * <p>The following restrictions are for creating configs in the current month.
   *
   * <ul>
   *   <li>This functionality is reserved for recovering from an erroneous config, and should not be
   *       used for regular business cases.
   *   <li>The new config will not modify exports used with other configs. Changes to the config may
   *       be immediate, but may take up to 24 hours.
   *   <li>There is a limit of ten configs for any
   *       [RepricingConfig.EntitlementGranularity.entitlement][google.cloud.channel.v1.RepricingConfig.EntitlementGranularity.entitlement]
   *       or
   *       [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *   <li>The contained
   *       [CustomerRepricingConfig.repricing_config][google.cloud.channel.v1.CustomerRepricingConfig.repricing_config]
   *       vaule must be different from the value used in the current config for a
   *       [RepricingConfig.EntitlementGranularity.entitlement][google.cloud.channel.v1.RepricingConfig.EntitlementGranularity.entitlement].
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request. Also displays if
   *       the updated config is for the current month or past months.
   *   <li>NOT_FOUND: The [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the updated
   * [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] resource, otherwise
   * returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CustomerName parent = CustomerName.of("[ACCOUNT]", "[CUSTOMER]");
   *   CustomerRepricingConfig customerRepricingConfig =
   *       CustomerRepricingConfig.newBuilder().build();
   *   CustomerRepricingConfig response =
   *       cloudChannelServiceClient.createCustomerRepricingConfig(parent, customerRepricingConfig);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the customer that will receive this repricing
   *     config. Parent uses the format: accounts/{account_id}/customers/{customer_id}
   * @param customerRepricingConfig Required. The CustomerRepricingConfig object to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomerRepricingConfig createCustomerRepricingConfig(
      CustomerName parent, CustomerRepricingConfig customerRepricingConfig) {
    CreateCustomerRepricingConfigRequest request =
        CreateCustomerRepricingConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCustomerRepricingConfig(customerRepricingConfig)
            .build();
    return createCustomerRepricingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a CustomerRepricingConfig. Call this method to set modifications for a specific
   * customer's bill. You can only create configs if the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is a future month. If needed, you can create a config for the current month, with some
   * restrictions.
   *
   * <p>When creating a config for a future month, make sure there are no existing configs for that
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *
   * <p>The following restrictions are for creating configs in the current month.
   *
   * <ul>
   *   <li>This functionality is reserved for recovering from an erroneous config, and should not be
   *       used for regular business cases.
   *   <li>The new config will not modify exports used with other configs. Changes to the config may
   *       be immediate, but may take up to 24 hours.
   *   <li>There is a limit of ten configs for any
   *       [RepricingConfig.EntitlementGranularity.entitlement][google.cloud.channel.v1.RepricingConfig.EntitlementGranularity.entitlement]
   *       or
   *       [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *   <li>The contained
   *       [CustomerRepricingConfig.repricing_config][google.cloud.channel.v1.CustomerRepricingConfig.repricing_config]
   *       vaule must be different from the value used in the current config for a
   *       [RepricingConfig.EntitlementGranularity.entitlement][google.cloud.channel.v1.RepricingConfig.EntitlementGranularity.entitlement].
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request. Also displays if
   *       the updated config is for the current month or past months.
   *   <li>NOT_FOUND: The [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the updated
   * [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] resource, otherwise
   * returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   String parent = CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString();
   *   CustomerRepricingConfig customerRepricingConfig =
   *       CustomerRepricingConfig.newBuilder().build();
   *   CustomerRepricingConfig response =
   *       cloudChannelServiceClient.createCustomerRepricingConfig(parent, customerRepricingConfig);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the customer that will receive this repricing
   *     config. Parent uses the format: accounts/{account_id}/customers/{customer_id}
   * @param customerRepricingConfig Required. The CustomerRepricingConfig object to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomerRepricingConfig createCustomerRepricingConfig(
      String parent, CustomerRepricingConfig customerRepricingConfig) {
    CreateCustomerRepricingConfigRequest request =
        CreateCustomerRepricingConfigRequest.newBuilder()
            .setParent(parent)
            .setCustomerRepricingConfig(customerRepricingConfig)
            .build();
    return createCustomerRepricingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a CustomerRepricingConfig. Call this method to set modifications for a specific
   * customer's bill. You can only create configs if the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is a future month. If needed, you can create a config for the current month, with some
   * restrictions.
   *
   * <p>When creating a config for a future month, make sure there are no existing configs for that
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *
   * <p>The following restrictions are for creating configs in the current month.
   *
   * <ul>
   *   <li>This functionality is reserved for recovering from an erroneous config, and should not be
   *       used for regular business cases.
   *   <li>The new config will not modify exports used with other configs. Changes to the config may
   *       be immediate, but may take up to 24 hours.
   *   <li>There is a limit of ten configs for any
   *       [RepricingConfig.EntitlementGranularity.entitlement][google.cloud.channel.v1.RepricingConfig.EntitlementGranularity.entitlement]
   *       or
   *       [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *   <li>The contained
   *       [CustomerRepricingConfig.repricing_config][google.cloud.channel.v1.CustomerRepricingConfig.repricing_config]
   *       vaule must be different from the value used in the current config for a
   *       [RepricingConfig.EntitlementGranularity.entitlement][google.cloud.channel.v1.RepricingConfig.EntitlementGranularity.entitlement].
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request. Also displays if
   *       the updated config is for the current month or past months.
   *   <li>NOT_FOUND: The [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the updated
   * [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] resource, otherwise
   * returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CreateCustomerRepricingConfigRequest request =
   *       CreateCustomerRepricingConfigRequest.newBuilder()
   *           .setParent(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setCustomerRepricingConfig(CustomerRepricingConfig.newBuilder().build())
   *           .build();
   *   CustomerRepricingConfig response =
   *       cloudChannelServiceClient.createCustomerRepricingConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomerRepricingConfig createCustomerRepricingConfig(
      CreateCustomerRepricingConfigRequest request) {
    return createCustomerRepricingConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a CustomerRepricingConfig. Call this method to set modifications for a specific
   * customer's bill. You can only create configs if the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is a future month. If needed, you can create a config for the current month, with some
   * restrictions.
   *
   * <p>When creating a config for a future month, make sure there are no existing configs for that
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *
   * <p>The following restrictions are for creating configs in the current month.
   *
   * <ul>
   *   <li>This functionality is reserved for recovering from an erroneous config, and should not be
   *       used for regular business cases.
   *   <li>The new config will not modify exports used with other configs. Changes to the config may
   *       be immediate, but may take up to 24 hours.
   *   <li>There is a limit of ten configs for any
   *       [RepricingConfig.EntitlementGranularity.entitlement][google.cloud.channel.v1.RepricingConfig.EntitlementGranularity.entitlement]
   *       or
   *       [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *   <li>The contained
   *       [CustomerRepricingConfig.repricing_config][google.cloud.channel.v1.CustomerRepricingConfig.repricing_config]
   *       vaule must be different from the value used in the current config for a
   *       [RepricingConfig.EntitlementGranularity.entitlement][google.cloud.channel.v1.RepricingConfig.EntitlementGranularity.entitlement].
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request. Also displays if
   *       the updated config is for the current month or past months.
   *   <li>NOT_FOUND: The [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the updated
   * [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] resource, otherwise
   * returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CreateCustomerRepricingConfigRequest request =
   *       CreateCustomerRepricingConfigRequest.newBuilder()
   *           .setParent(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setCustomerRepricingConfig(CustomerRepricingConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<CustomerRepricingConfig> future =
   *       cloudChannelServiceClient.createCustomerRepricingConfigCallable().futureCall(request);
   *   // Do something.
   *   CustomerRepricingConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCustomerRepricingConfigRequest, CustomerRepricingConfig>
      createCustomerRepricingConfigCallable() {
    return stub.createCustomerRepricingConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a CustomerRepricingConfig. Call this method to set modifications for a specific
   * customer's bill. This method overwrites the existing CustomerRepricingConfig.
   *
   * <p>You can only update configs if the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is a future month. To make changes to configs for the current month, use
   * [CreateCustomerRepricingConfig][google.cloud.channel.v1.CloudChannelService.CreateCustomerRepricingConfig],
   * taking note of its restrictions. You cannot update the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *
   * <p>When updating a config in the future:
   *
   * <ul>
   *   <li>This config must already exist.
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request. Also displays if
   *       the updated config is for the current month or past months.
   *   <li>NOT_FOUND: The [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the updated
   * [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] resource, otherwise
   * returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CustomerRepricingConfig customerRepricingConfig =
   *       CustomerRepricingConfig.newBuilder().build();
   *   CustomerRepricingConfig response =
   *       cloudChannelServiceClient.updateCustomerRepricingConfig(customerRepricingConfig);
   * }
   * }</pre>
   *
   * @param customerRepricingConfig Required. The CustomerRepricingConfig object to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomerRepricingConfig updateCustomerRepricingConfig(
      CustomerRepricingConfig customerRepricingConfig) {
    UpdateCustomerRepricingConfigRequest request =
        UpdateCustomerRepricingConfigRequest.newBuilder()
            .setCustomerRepricingConfig(customerRepricingConfig)
            .build();
    return updateCustomerRepricingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a CustomerRepricingConfig. Call this method to set modifications for a specific
   * customer's bill. This method overwrites the existing CustomerRepricingConfig.
   *
   * <p>You can only update configs if the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is a future month. To make changes to configs for the current month, use
   * [CreateCustomerRepricingConfig][google.cloud.channel.v1.CloudChannelService.CreateCustomerRepricingConfig],
   * taking note of its restrictions. You cannot update the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *
   * <p>When updating a config in the future:
   *
   * <ul>
   *   <li>This config must already exist.
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request. Also displays if
   *       the updated config is for the current month or past months.
   *   <li>NOT_FOUND: The [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the updated
   * [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] resource, otherwise
   * returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   UpdateCustomerRepricingConfigRequest request =
   *       UpdateCustomerRepricingConfigRequest.newBuilder()
   *           .setCustomerRepricingConfig(CustomerRepricingConfig.newBuilder().build())
   *           .build();
   *   CustomerRepricingConfig response =
   *       cloudChannelServiceClient.updateCustomerRepricingConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CustomerRepricingConfig updateCustomerRepricingConfig(
      UpdateCustomerRepricingConfigRequest request) {
    return updateCustomerRepricingConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a CustomerRepricingConfig. Call this method to set modifications for a specific
   * customer's bill. This method overwrites the existing CustomerRepricingConfig.
   *
   * <p>You can only update configs if the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is a future month. To make changes to configs for the current month, use
   * [CreateCustomerRepricingConfig][google.cloud.channel.v1.CloudChannelService.CreateCustomerRepricingConfig],
   * taking note of its restrictions. You cannot update the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *
   * <p>When updating a config in the future:
   *
   * <ul>
   *   <li>This config must already exist.
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request. Also displays if
   *       the updated config is for the current month or past months.
   *   <li>NOT_FOUND: The [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the updated
   * [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] resource, otherwise
   * returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   UpdateCustomerRepricingConfigRequest request =
   *       UpdateCustomerRepricingConfigRequest.newBuilder()
   *           .setCustomerRepricingConfig(CustomerRepricingConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<CustomerRepricingConfig> future =
   *       cloudChannelServiceClient.updateCustomerRepricingConfigCallable().futureCall(request);
   *   // Do something.
   *   CustomerRepricingConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCustomerRepricingConfigRequest, CustomerRepricingConfig>
      updateCustomerRepricingConfigCallable() {
    return stub.updateCustomerRepricingConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the given [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   * permanently. You can only delete configs if their
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is set to a date after the current month.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The account making the request does not own this customer.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>FAILED_PRECONDITION: The
   *       [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] is active or
   *       in the past.
   *   <li>NOT_FOUND: No [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       found for the name in the request.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CustomerRepricingConfigName name =
   *       CustomerRepricingConfigName.of("[ACCOUNT]", "[CUSTOMER]", "[CUSTOMER_REPRICING_CONFIG]");
   *   cloudChannelServiceClient.deleteCustomerRepricingConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the customer repricing config rule to delete.
   *     Format: accounts/{account_id}/customers/{customer_id}/customerRepricingConfigs/{id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCustomerRepricingConfig(CustomerRepricingConfigName name) {
    DeleteCustomerRepricingConfigRequest request =
        DeleteCustomerRepricingConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteCustomerRepricingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the given [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   * permanently. You can only delete configs if their
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is set to a date after the current month.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The account making the request does not own this customer.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>FAILED_PRECONDITION: The
   *       [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] is active or
   *       in the past.
   *   <li>NOT_FOUND: No [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       found for the name in the request.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   String name =
   *       CustomerRepricingConfigName.of("[ACCOUNT]", "[CUSTOMER]", "[CUSTOMER_REPRICING_CONFIG]")
   *           .toString();
   *   cloudChannelServiceClient.deleteCustomerRepricingConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the customer repricing config rule to delete.
   *     Format: accounts/{account_id}/customers/{customer_id}/customerRepricingConfigs/{id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCustomerRepricingConfig(String name) {
    DeleteCustomerRepricingConfigRequest request =
        DeleteCustomerRepricingConfigRequest.newBuilder().setName(name).build();
    deleteCustomerRepricingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the given [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   * permanently. You can only delete configs if their
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is set to a date after the current month.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The account making the request does not own this customer.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>FAILED_PRECONDITION: The
   *       [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] is active or
   *       in the past.
   *   <li>NOT_FOUND: No [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       found for the name in the request.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   DeleteCustomerRepricingConfigRequest request =
   *       DeleteCustomerRepricingConfigRequest.newBuilder()
   *           .setName(
   *               CustomerRepricingConfigName.of(
   *                       "[ACCOUNT]", "[CUSTOMER]", "[CUSTOMER_REPRICING_CONFIG]")
   *                   .toString())
   *           .build();
   *   cloudChannelServiceClient.deleteCustomerRepricingConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCustomerRepricingConfig(DeleteCustomerRepricingConfigRequest request) {
    deleteCustomerRepricingConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the given [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   * permanently. You can only delete configs if their
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is set to a date after the current month.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The account making the request does not own this customer.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>FAILED_PRECONDITION: The
   *       [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig] is active or
   *       in the past.
   *   <li>NOT_FOUND: No [CustomerRepricingConfig][google.cloud.channel.v1.CustomerRepricingConfig]
   *       found for the name in the request.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   DeleteCustomerRepricingConfigRequest request =
   *       DeleteCustomerRepricingConfigRequest.newBuilder()
   *           .setName(
   *               CustomerRepricingConfigName.of(
   *                       "[ACCOUNT]", "[CUSTOMER]", "[CUSTOMER_REPRICING_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       cloudChannelServiceClient.deleteCustomerRepricingConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCustomerRepricingConfigRequest, Empty>
      deleteCustomerRepricingConfigCallable() {
    return stub.deleteCustomerRepricingConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about how a Distributor modifies their bill before sending it to a
   * ChannelPartner.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>NOT_FOUND: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       was not found.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * resource, otherwise returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ChannelPartnerRepricingConfigName name =
   *       ChannelPartnerRepricingConfigName.of(
   *           "[ACCOUNT]", "[CHANNEL_PARTNER]", "[CHANNEL_PARTNER_REPRICING_CONFIG]");
   *   ChannelPartnerRepricingConfig response =
   *       cloudChannelServiceClient.getChannelPartnerRepricingConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ChannelPartnerRepricingConfig Format:
   *     accounts/{account_id}/channelPartnerLinks/{channel_partner_id}/channelPartnerRepricingConfigs/{id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelPartnerRepricingConfig getChannelPartnerRepricingConfig(
      ChannelPartnerRepricingConfigName name) {
    GetChannelPartnerRepricingConfigRequest request =
        GetChannelPartnerRepricingConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getChannelPartnerRepricingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about how a Distributor modifies their bill before sending it to a
   * ChannelPartner.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>NOT_FOUND: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       was not found.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * resource, otherwise returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   String name =
   *       ChannelPartnerRepricingConfigName.of(
   *               "[ACCOUNT]", "[CHANNEL_PARTNER]", "[CHANNEL_PARTNER_REPRICING_CONFIG]")
   *           .toString();
   *   ChannelPartnerRepricingConfig response =
   *       cloudChannelServiceClient.getChannelPartnerRepricingConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ChannelPartnerRepricingConfig Format:
   *     accounts/{account_id}/channelPartnerLinks/{channel_partner_id}/channelPartnerRepricingConfigs/{id}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelPartnerRepricingConfig getChannelPartnerRepricingConfig(String name) {
    GetChannelPartnerRepricingConfigRequest request =
        GetChannelPartnerRepricingConfigRequest.newBuilder().setName(name).build();
    return getChannelPartnerRepricingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about how a Distributor modifies their bill before sending it to a
   * ChannelPartner.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>NOT_FOUND: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       was not found.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * resource, otherwise returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   GetChannelPartnerRepricingConfigRequest request =
   *       GetChannelPartnerRepricingConfigRequest.newBuilder()
   *           .setName(
   *               ChannelPartnerRepricingConfigName.of(
   *                       "[ACCOUNT]", "[CHANNEL_PARTNER]", "[CHANNEL_PARTNER_REPRICING_CONFIG]")
   *                   .toString())
   *           .build();
   *   ChannelPartnerRepricingConfig response =
   *       cloudChannelServiceClient.getChannelPartnerRepricingConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelPartnerRepricingConfig getChannelPartnerRepricingConfig(
      GetChannelPartnerRepricingConfigRequest request) {
    return getChannelPartnerRepricingConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about how a Distributor modifies their bill before sending it to a
   * ChannelPartner.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>NOT_FOUND: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       was not found.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * resource, otherwise returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   GetChannelPartnerRepricingConfigRequest request =
   *       GetChannelPartnerRepricingConfigRequest.newBuilder()
   *           .setName(
   *               ChannelPartnerRepricingConfigName.of(
   *                       "[ACCOUNT]", "[CHANNEL_PARTNER]", "[CHANNEL_PARTNER_REPRICING_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ChannelPartnerRepricingConfig> future =
   *       cloudChannelServiceClient.getChannelPartnerRepricingConfigCallable().futureCall(request);
   *   // Do something.
   *   ChannelPartnerRepricingConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
      getChannelPartnerRepricingConfigCallable() {
    return stub.getChannelPartnerRepricingConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about how a Reseller modifies their bill before sending it to a
   * ChannelPartner.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>NOT_FOUND: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * resources. The data for each resource is displayed in the ascending order of:
   *
   * <ul>
   *   <li>channel partner ID
   *   <li>[RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   *   <li>[ChannelPartnerRepricingConfig.update_time][google.cloud.channel.v1.ChannelPartnerRepricingConfig.update_time]
   * </ul>
   *
   * <p>If unsuccessful, returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ChannelPartnerLinkName parent =
   *       ChannelPartnerLinkName.of("[ACCOUNT]", "[CHANNEL_PARTNER_LINK]");
   *   for (ChannelPartnerRepricingConfig element :
   *       cloudChannelServiceClient.listChannelPartnerRepricingConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the account's
   *     [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]. Parent uses the format:
   *     accounts/{account_id}/channelPartnerLinks/{channel_partner_id}. Supports
   *     accounts/{account_id}/channelPartnerLinks/- to retrieve configs for all channel partners.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelPartnerRepricingConfigsPagedResponse listChannelPartnerRepricingConfigs(
      ChannelPartnerLinkName parent) {
    ListChannelPartnerRepricingConfigsRequest request =
        ListChannelPartnerRepricingConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listChannelPartnerRepricingConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about how a Reseller modifies their bill before sending it to a
   * ChannelPartner.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>NOT_FOUND: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * resources. The data for each resource is displayed in the ascending order of:
   *
   * <ul>
   *   <li>channel partner ID
   *   <li>[RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   *   <li>[ChannelPartnerRepricingConfig.update_time][google.cloud.channel.v1.ChannelPartnerRepricingConfig.update_time]
   * </ul>
   *
   * <p>If unsuccessful, returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   String parent = ChannelPartnerLinkName.of("[ACCOUNT]", "[CHANNEL_PARTNER_LINK]").toString();
   *   for (ChannelPartnerRepricingConfig element :
   *       cloudChannelServiceClient.listChannelPartnerRepricingConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the account's
   *     [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]. Parent uses the format:
   *     accounts/{account_id}/channelPartnerLinks/{channel_partner_id}. Supports
   *     accounts/{account_id}/channelPartnerLinks/- to retrieve configs for all channel partners.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelPartnerRepricingConfigsPagedResponse listChannelPartnerRepricingConfigs(
      String parent) {
    ListChannelPartnerRepricingConfigsRequest request =
        ListChannelPartnerRepricingConfigsRequest.newBuilder().setParent(parent).build();
    return listChannelPartnerRepricingConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about how a Reseller modifies their bill before sending it to a
   * ChannelPartner.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>NOT_FOUND: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * resources. The data for each resource is displayed in the ascending order of:
   *
   * <ul>
   *   <li>channel partner ID
   *   <li>[RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   *   <li>[ChannelPartnerRepricingConfig.update_time][google.cloud.channel.v1.ChannelPartnerRepricingConfig.update_time]
   * </ul>
   *
   * <p>If unsuccessful, returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListChannelPartnerRepricingConfigsRequest request =
   *       ListChannelPartnerRepricingConfigsRequest.newBuilder()
   *           .setParent(
   *               ChannelPartnerLinkName.of("[ACCOUNT]", "[CHANNEL_PARTNER_LINK]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (ChannelPartnerRepricingConfig element :
   *       cloudChannelServiceClient.listChannelPartnerRepricingConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelPartnerRepricingConfigsPagedResponse listChannelPartnerRepricingConfigs(
      ListChannelPartnerRepricingConfigsRequest request) {
    return listChannelPartnerRepricingConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about how a Reseller modifies their bill before sending it to a
   * ChannelPartner.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>NOT_FOUND: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * resources. The data for each resource is displayed in the ascending order of:
   *
   * <ul>
   *   <li>channel partner ID
   *   <li>[RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   *   <li>[ChannelPartnerRepricingConfig.update_time][google.cloud.channel.v1.ChannelPartnerRepricingConfig.update_time]
   * </ul>
   *
   * <p>If unsuccessful, returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListChannelPartnerRepricingConfigsRequest request =
   *       ListChannelPartnerRepricingConfigsRequest.newBuilder()
   *           .setParent(
   *               ChannelPartnerLinkName.of("[ACCOUNT]", "[CHANNEL_PARTNER_LINK]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<ChannelPartnerRepricingConfig> future =
   *       cloudChannelServiceClient
   *           .listChannelPartnerRepricingConfigsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (ChannelPartnerRepricingConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListChannelPartnerRepricingConfigsRequest,
          ListChannelPartnerRepricingConfigsPagedResponse>
      listChannelPartnerRepricingConfigsPagedCallable() {
    return stub.listChannelPartnerRepricingConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about how a Reseller modifies their bill before sending it to a
   * ChannelPartner.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>NOT_FOUND: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * resources. The data for each resource is displayed in the ascending order of:
   *
   * <ul>
   *   <li>channel partner ID
   *   <li>[RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   *   <li>[ChannelPartnerRepricingConfig.update_time][google.cloud.channel.v1.ChannelPartnerRepricingConfig.update_time]
   * </ul>
   *
   * <p>If unsuccessful, returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListChannelPartnerRepricingConfigsRequest request =
   *       ListChannelPartnerRepricingConfigsRequest.newBuilder()
   *           .setParent(
   *               ChannelPartnerLinkName.of("[ACCOUNT]", "[CHANNEL_PARTNER_LINK]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListChannelPartnerRepricingConfigsResponse response =
   *         cloudChannelServiceClient.listChannelPartnerRepricingConfigsCallable().call(request);
   *     for (ChannelPartnerRepricingConfig element :
   *         response.getChannelPartnerRepricingConfigsList()) {
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
          ListChannelPartnerRepricingConfigsRequest, ListChannelPartnerRepricingConfigsResponse>
      listChannelPartnerRepricingConfigsCallable() {
    return stub.listChannelPartnerRepricingConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ChannelPartnerRepricingConfig. Call this method to set modifications for a specific
   * ChannelPartner's bill. You can only create configs if the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is a future month. If needed, you can create a config for the current month, with some
   * restrictions.
   *
   * <p>When creating a config for a future month, make sure there are no existing configs for that
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *
   * <p>The following restrictions are for creating configs in the current month.
   *
   * <ul>
   *   <li>This functionality is reserved for recovering from an erroneous config, and should not be
   *       used for regular business cases.
   *   <li>The new config will not modify exports used with other configs. Changes to the config may
   *       be immediate, but may take up to 24 hours.
   *   <li>There is a limit of ten configs for any ChannelPartner or
   *       [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *   <li>The contained
   *       [ChannelPartnerRepricingConfig.repricing_config][google.cloud.channel.v1.ChannelPartnerRepricingConfig.repricing_config]
   *       vaule must be different from the value used in the current config for a ChannelPartner.
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request. Also displays if
   *       the updated config is for the current month or past months.
   *   <li>NOT_FOUND: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the updated
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * resource, otherwise returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ChannelPartnerLinkName parent =
   *       ChannelPartnerLinkName.of("[ACCOUNT]", "[CHANNEL_PARTNER_LINK]");
   *   ChannelPartnerRepricingConfig channelPartnerRepricingConfig =
   *       ChannelPartnerRepricingConfig.newBuilder().build();
   *   ChannelPartnerRepricingConfig response =
   *       cloudChannelServiceClient.createChannelPartnerRepricingConfig(
   *           parent, channelPartnerRepricingConfig);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the ChannelPartner that will receive the repricing
   *     config. Parent uses the format:
   *     accounts/{account_id}/channelPartnerLinks/{channel_partner_id}
   * @param channelPartnerRepricingConfig Required. The ChannelPartnerRepricingConfig object to
   *     update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelPartnerRepricingConfig createChannelPartnerRepricingConfig(
      ChannelPartnerLinkName parent, ChannelPartnerRepricingConfig channelPartnerRepricingConfig) {
    CreateChannelPartnerRepricingConfigRequest request =
        CreateChannelPartnerRepricingConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setChannelPartnerRepricingConfig(channelPartnerRepricingConfig)
            .build();
    return createChannelPartnerRepricingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ChannelPartnerRepricingConfig. Call this method to set modifications for a specific
   * ChannelPartner's bill. You can only create configs if the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is a future month. If needed, you can create a config for the current month, with some
   * restrictions.
   *
   * <p>When creating a config for a future month, make sure there are no existing configs for that
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *
   * <p>The following restrictions are for creating configs in the current month.
   *
   * <ul>
   *   <li>This functionality is reserved for recovering from an erroneous config, and should not be
   *       used for regular business cases.
   *   <li>The new config will not modify exports used with other configs. Changes to the config may
   *       be immediate, but may take up to 24 hours.
   *   <li>There is a limit of ten configs for any ChannelPartner or
   *       [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *   <li>The contained
   *       [ChannelPartnerRepricingConfig.repricing_config][google.cloud.channel.v1.ChannelPartnerRepricingConfig.repricing_config]
   *       vaule must be different from the value used in the current config for a ChannelPartner.
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request. Also displays if
   *       the updated config is for the current month or past months.
   *   <li>NOT_FOUND: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the updated
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * resource, otherwise returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   String parent = ChannelPartnerLinkName.of("[ACCOUNT]", "[CHANNEL_PARTNER_LINK]").toString();
   *   ChannelPartnerRepricingConfig channelPartnerRepricingConfig =
   *       ChannelPartnerRepricingConfig.newBuilder().build();
   *   ChannelPartnerRepricingConfig response =
   *       cloudChannelServiceClient.createChannelPartnerRepricingConfig(
   *           parent, channelPartnerRepricingConfig);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the ChannelPartner that will receive the repricing
   *     config. Parent uses the format:
   *     accounts/{account_id}/channelPartnerLinks/{channel_partner_id}
   * @param channelPartnerRepricingConfig Required. The ChannelPartnerRepricingConfig object to
   *     update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelPartnerRepricingConfig createChannelPartnerRepricingConfig(
      String parent, ChannelPartnerRepricingConfig channelPartnerRepricingConfig) {
    CreateChannelPartnerRepricingConfigRequest request =
        CreateChannelPartnerRepricingConfigRequest.newBuilder()
            .setParent(parent)
            .setChannelPartnerRepricingConfig(channelPartnerRepricingConfig)
            .build();
    return createChannelPartnerRepricingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ChannelPartnerRepricingConfig. Call this method to set modifications for a specific
   * ChannelPartner's bill. You can only create configs if the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is a future month. If needed, you can create a config for the current month, with some
   * restrictions.
   *
   * <p>When creating a config for a future month, make sure there are no existing configs for that
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *
   * <p>The following restrictions are for creating configs in the current month.
   *
   * <ul>
   *   <li>This functionality is reserved for recovering from an erroneous config, and should not be
   *       used for regular business cases.
   *   <li>The new config will not modify exports used with other configs. Changes to the config may
   *       be immediate, but may take up to 24 hours.
   *   <li>There is a limit of ten configs for any ChannelPartner or
   *       [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *   <li>The contained
   *       [ChannelPartnerRepricingConfig.repricing_config][google.cloud.channel.v1.ChannelPartnerRepricingConfig.repricing_config]
   *       vaule must be different from the value used in the current config for a ChannelPartner.
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request. Also displays if
   *       the updated config is for the current month or past months.
   *   <li>NOT_FOUND: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the updated
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * resource, otherwise returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CreateChannelPartnerRepricingConfigRequest request =
   *       CreateChannelPartnerRepricingConfigRequest.newBuilder()
   *           .setParent(
   *               ChannelPartnerLinkName.of("[ACCOUNT]", "[CHANNEL_PARTNER_LINK]").toString())
   *           .setChannelPartnerRepricingConfig(ChannelPartnerRepricingConfig.newBuilder().build())
   *           .build();
   *   ChannelPartnerRepricingConfig response =
   *       cloudChannelServiceClient.createChannelPartnerRepricingConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelPartnerRepricingConfig createChannelPartnerRepricingConfig(
      CreateChannelPartnerRepricingConfigRequest request) {
    return createChannelPartnerRepricingConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a ChannelPartnerRepricingConfig. Call this method to set modifications for a specific
   * ChannelPartner's bill. You can only create configs if the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is a future month. If needed, you can create a config for the current month, with some
   * restrictions.
   *
   * <p>When creating a config for a future month, make sure there are no existing configs for that
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *
   * <p>The following restrictions are for creating configs in the current month.
   *
   * <ul>
   *   <li>This functionality is reserved for recovering from an erroneous config, and should not be
   *       used for regular business cases.
   *   <li>The new config will not modify exports used with other configs. Changes to the config may
   *       be immediate, but may take up to 24 hours.
   *   <li>There is a limit of ten configs for any ChannelPartner or
   *       [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *   <li>The contained
   *       [ChannelPartnerRepricingConfig.repricing_config][google.cloud.channel.v1.ChannelPartnerRepricingConfig.repricing_config]
   *       vaule must be different from the value used in the current config for a ChannelPartner.
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request. Also displays if
   *       the updated config is for the current month or past months.
   *   <li>NOT_FOUND: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the updated
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * resource, otherwise returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   CreateChannelPartnerRepricingConfigRequest request =
   *       CreateChannelPartnerRepricingConfigRequest.newBuilder()
   *           .setParent(
   *               ChannelPartnerLinkName.of("[ACCOUNT]", "[CHANNEL_PARTNER_LINK]").toString())
   *           .setChannelPartnerRepricingConfig(ChannelPartnerRepricingConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<ChannelPartnerRepricingConfig> future =
   *       cloudChannelServiceClient
   *           .createChannelPartnerRepricingConfigCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ChannelPartnerRepricingConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          CreateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
      createChannelPartnerRepricingConfigCallable() {
    return stub.createChannelPartnerRepricingConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ChannelPartnerRepricingConfig. Call this method to set modifications for a specific
   * ChannelPartner's bill. This method overwrites the existing CustomerRepricingConfig.
   *
   * <p>You can only update configs if the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is a future month. To make changes to configs for the current month, use
   * [CreateChannelPartnerRepricingConfig][google.cloud.channel.v1.CloudChannelService.CreateChannelPartnerRepricingConfig],
   * taking note of its restrictions. You cannot update the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *
   * <p>When updating a config in the future:
   *
   * <ul>
   *   <li>This config must already exist.
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request. Also displays if
   *       the updated config is for the current month or past months.
   *   <li>NOT_FOUND: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the updated
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * resource, otherwise returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ChannelPartnerRepricingConfig channelPartnerRepricingConfig =
   *       ChannelPartnerRepricingConfig.newBuilder().build();
   *   ChannelPartnerRepricingConfig response =
   *       cloudChannelServiceClient.updateChannelPartnerRepricingConfig(
   *           channelPartnerRepricingConfig);
   * }
   * }</pre>
   *
   * @param channelPartnerRepricingConfig Required. The ChannelPartnerRepricingConfig object to
   *     update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelPartnerRepricingConfig updateChannelPartnerRepricingConfig(
      ChannelPartnerRepricingConfig channelPartnerRepricingConfig) {
    UpdateChannelPartnerRepricingConfigRequest request =
        UpdateChannelPartnerRepricingConfigRequest.newBuilder()
            .setChannelPartnerRepricingConfig(channelPartnerRepricingConfig)
            .build();
    return updateChannelPartnerRepricingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ChannelPartnerRepricingConfig. Call this method to set modifications for a specific
   * ChannelPartner's bill. This method overwrites the existing CustomerRepricingConfig.
   *
   * <p>You can only update configs if the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is a future month. To make changes to configs for the current month, use
   * [CreateChannelPartnerRepricingConfig][google.cloud.channel.v1.CloudChannelService.CreateChannelPartnerRepricingConfig],
   * taking note of its restrictions. You cannot update the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *
   * <p>When updating a config in the future:
   *
   * <ul>
   *   <li>This config must already exist.
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request. Also displays if
   *       the updated config is for the current month or past months.
   *   <li>NOT_FOUND: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the updated
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * resource, otherwise returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   UpdateChannelPartnerRepricingConfigRequest request =
   *       UpdateChannelPartnerRepricingConfigRequest.newBuilder()
   *           .setChannelPartnerRepricingConfig(ChannelPartnerRepricingConfig.newBuilder().build())
   *           .build();
   *   ChannelPartnerRepricingConfig response =
   *       cloudChannelServiceClient.updateChannelPartnerRepricingConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelPartnerRepricingConfig updateChannelPartnerRepricingConfig(
      UpdateChannelPartnerRepricingConfigRequest request) {
    return updateChannelPartnerRepricingConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ChannelPartnerRepricingConfig. Call this method to set modifications for a specific
   * ChannelPartner's bill. This method overwrites the existing CustomerRepricingConfig.
   *
   * <p>You can only update configs if the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is a future month. To make changes to configs for the current month, use
   * [CreateChannelPartnerRepricingConfig][google.cloud.channel.v1.CloudChannelService.CreateChannelPartnerRepricingConfig],
   * taking note of its restrictions. You cannot update the
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month].
   *
   * <p>When updating a config in the future:
   *
   * <ul>
   *   <li>This config must already exist.
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request and the account being queried are
   *       different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request. Also displays if
   *       the updated config is for the current month or past months.
   *   <li>NOT_FOUND: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       specified does not exist or is not associated with the given account.
   *   <li>INTERNAL: Any non-user error related to technical issues in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: If successful, the updated
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * resource, otherwise returns an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   UpdateChannelPartnerRepricingConfigRequest request =
   *       UpdateChannelPartnerRepricingConfigRequest.newBuilder()
   *           .setChannelPartnerRepricingConfig(ChannelPartnerRepricingConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<ChannelPartnerRepricingConfig> future =
   *       cloudChannelServiceClient
   *           .updateChannelPartnerRepricingConfigCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ChannelPartnerRepricingConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          UpdateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
      updateChannelPartnerRepricingConfigCallable() {
    return stub.updateChannelPartnerRepricingConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the given
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * permanently. You can only delete configs if their
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is set to a date after the current month.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The account making the request does not own this customer.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>FAILED_PRECONDITION: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig] is
   *       active or in the past.
   *   <li>NOT_FOUND: No
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       found for the name in the request.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ChannelPartnerRepricingConfigName name =
   *       ChannelPartnerRepricingConfigName.of(
   *           "[ACCOUNT]", "[CHANNEL_PARTNER]", "[CHANNEL_PARTNER_REPRICING_CONFIG]");
   *   cloudChannelServiceClient.deleteChannelPartnerRepricingConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the channel partner repricing config rule to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteChannelPartnerRepricingConfig(ChannelPartnerRepricingConfigName name) {
    DeleteChannelPartnerRepricingConfigRequest request =
        DeleteChannelPartnerRepricingConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteChannelPartnerRepricingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the given
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * permanently. You can only delete configs if their
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is set to a date after the current month.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The account making the request does not own this customer.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>FAILED_PRECONDITION: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig] is
   *       active or in the past.
   *   <li>NOT_FOUND: No
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       found for the name in the request.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   String name =
   *       ChannelPartnerRepricingConfigName.of(
   *               "[ACCOUNT]", "[CHANNEL_PARTNER]", "[CHANNEL_PARTNER_REPRICING_CONFIG]")
   *           .toString();
   *   cloudChannelServiceClient.deleteChannelPartnerRepricingConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the channel partner repricing config rule to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteChannelPartnerRepricingConfig(String name) {
    DeleteChannelPartnerRepricingConfigRequest request =
        DeleteChannelPartnerRepricingConfigRequest.newBuilder().setName(name).build();
    deleteChannelPartnerRepricingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the given
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * permanently. You can only delete configs if their
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is set to a date after the current month.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The account making the request does not own this customer.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>FAILED_PRECONDITION: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig] is
   *       active or in the past.
   *   <li>NOT_FOUND: No
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       found for the name in the request.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   DeleteChannelPartnerRepricingConfigRequest request =
   *       DeleteChannelPartnerRepricingConfigRequest.newBuilder()
   *           .setName(
   *               ChannelPartnerRepricingConfigName.of(
   *                       "[ACCOUNT]", "[CHANNEL_PARTNER]", "[CHANNEL_PARTNER_REPRICING_CONFIG]")
   *                   .toString())
   *           .build();
   *   cloudChannelServiceClient.deleteChannelPartnerRepricingConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteChannelPartnerRepricingConfig(
      DeleteChannelPartnerRepricingConfigRequest request) {
    deleteChannelPartnerRepricingConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the given
   * [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   * permanently. You can only delete configs if their
   * [RepricingConfig.effective_invoice_month][google.cloud.channel.v1.RepricingConfig.effective_invoice_month]
   * is set to a date after the current month.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The account making the request does not own this customer.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>FAILED_PRECONDITION: The
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig] is
   *       active or in the past.
   *   <li>NOT_FOUND: No
   *       [ChannelPartnerRepricingConfig][google.cloud.channel.v1.ChannelPartnerRepricingConfig]
   *       found for the name in the request.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   DeleteChannelPartnerRepricingConfigRequest request =
   *       DeleteChannelPartnerRepricingConfigRequest.newBuilder()
   *           .setName(
   *               ChannelPartnerRepricingConfigName.of(
   *                       "[ACCOUNT]", "[CHANNEL_PARTNER]", "[CHANNEL_PARTNER_REPRICING_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       cloudChannelServiceClient
   *           .deleteChannelPartnerRepricingConfigCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteChannelPartnerRepricingConfigRequest, Empty>
      deleteChannelPartnerRepricingConfigCallable() {
    return stub.deleteChannelPartnerRepricingConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [Offer][google.cloud.channel.v1.Offer] resource.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The entitlement doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Entitlement or offer was not found.
   * </ul>
   *
   * <p>Return value: The [Offer][google.cloud.channel.v1.Offer] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   LookupOfferRequest request =
   *       LookupOfferRequest.newBuilder()
   *           .setEntitlement(
   *               EntitlementName.of("[ACCOUNT]", "[CUSTOMER]", "[ENTITLEMENT]").toString())
   *           .build();
   *   Offer response = cloudChannelServiceClient.lookupOffer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Offer lookupOffer(LookupOfferRequest request) {
    return lookupOfferCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the requested [Offer][google.cloud.channel.v1.Offer] resource.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The entitlement doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: Entitlement or offer was not found.
   * </ul>
   *
   * <p>Return value: The [Offer][google.cloud.channel.v1.Offer] resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   LookupOfferRequest request =
   *       LookupOfferRequest.newBuilder()
   *           .setEntitlement(
   *               EntitlementName.of("[ACCOUNT]", "[CUSTOMER]", "[ENTITLEMENT]").toString())
   *           .build();
   *   ApiFuture<Offer> future = cloudChannelServiceClient.lookupOfferCallable().futureCall(request);
   *   // Do something.
   *   Offer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LookupOfferRequest, Offer> lookupOfferCallable() {
    return stub.lookupOfferCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Products the reseller is authorized to sell.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListProductsRequest request =
   *       ListProductsRequest.newBuilder()
   *           .setAccount("account-1177318867")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   for (Product element : cloudChannelServiceClient.listProducts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsPagedResponse listProducts(ListProductsRequest request) {
    return listProductsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Products the reseller is authorized to sell.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListProductsRequest request =
   *       ListProductsRequest.newBuilder()
   *           .setAccount("account-1177318867")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<Product> future =
   *       cloudChannelServiceClient.listProductsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Product element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProductsRequest, ListProductsPagedResponse>
      listProductsPagedCallable() {
    return stub.listProductsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Products the reseller is authorized to sell.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListProductsRequest request =
   *       ListProductsRequest.newBuilder()
   *           .setAccount("account-1177318867")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   while (true) {
   *     ListProductsResponse response =
   *         cloudChannelServiceClient.listProductsCallable().call(request);
   *     for (Product element : response.getProductsList()) {
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
  public final UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable() {
    return stub.listProductsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the SKUs for a product the reseller is authorized to sell.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListSkusRequest request =
   *       ListSkusRequest.newBuilder()
   *           .setParent(ProductName.of("[PRODUCT]").toString())
   *           .setAccount("account-1177318867")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   for (Sku element : cloudChannelServiceClient.listSkus(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSkusPagedResponse listSkus(ListSkusRequest request) {
    return listSkusPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the SKUs for a product the reseller is authorized to sell.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListSkusRequest request =
   *       ListSkusRequest.newBuilder()
   *           .setParent(ProductName.of("[PRODUCT]").toString())
   *           .setAccount("account-1177318867")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<Sku> future = cloudChannelServiceClient.listSkusPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Sku element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSkusRequest, ListSkusPagedResponse> listSkusPagedCallable() {
    return stub.listSkusPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the SKUs for a product the reseller is authorized to sell.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListSkusRequest request =
   *       ListSkusRequest.newBuilder()
   *           .setParent(ProductName.of("[PRODUCT]").toString())
   *           .setAccount("account-1177318867")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   while (true) {
   *     ListSkusResponse response = cloudChannelServiceClient.listSkusCallable().call(request);
   *     for (Sku element : response.getSkusList()) {
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
  public final UnaryCallable<ListSkusRequest, ListSkusResponse> listSkusCallable() {
    return stub.listSkusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Offers the reseller can sell.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListOffersRequest request =
   *       ListOffersRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   for (Offer element : cloudChannelServiceClient.listOffers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOffersPagedResponse listOffers(ListOffersRequest request) {
    return listOffersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Offers the reseller can sell.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListOffersRequest request =
   *       ListOffersRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<Offer> future =
   *       cloudChannelServiceClient.listOffersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Offer element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOffersRequest, ListOffersPagedResponse> listOffersPagedCallable() {
    return stub.listOffersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Offers the reseller can sell.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListOffersRequest request =
   *       ListOffersRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   while (true) {
   *     ListOffersResponse response = cloudChannelServiceClient.listOffersCallable().call(request);
   *     for (Offer element : response.getOffersList()) {
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
  public final UnaryCallable<ListOffersRequest, ListOffersResponse> listOffersCallable() {
    return stub.listOffersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the following:
   *
   * <ul>
   *   <li>SKUs that you can purchase for a customer
   *   <li>SKUs that you can upgrade or downgrade for an entitlement.
   * </ul>
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListPurchasableSkusRequest request =
   *       ListPurchasableSkusRequest.newBuilder()
   *           .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   for (PurchasableSku element :
   *       cloudChannelServiceClient.listPurchasableSkus(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPurchasableSkusPagedResponse listPurchasableSkus(
      ListPurchasableSkusRequest request) {
    return listPurchasableSkusPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the following:
   *
   * <ul>
   *   <li>SKUs that you can purchase for a customer
   *   <li>SKUs that you can upgrade or downgrade for an entitlement.
   * </ul>
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListPurchasableSkusRequest request =
   *       ListPurchasableSkusRequest.newBuilder()
   *           .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<PurchasableSku> future =
   *       cloudChannelServiceClient.listPurchasableSkusPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PurchasableSku element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPurchasableSkusRequest, ListPurchasableSkusPagedResponse>
      listPurchasableSkusPagedCallable() {
    return stub.listPurchasableSkusPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the following:
   *
   * <ul>
   *   <li>SKUs that you can purchase for a customer
   *   <li>SKUs that you can upgrade or downgrade for an entitlement.
   * </ul>
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListPurchasableSkusRequest request =
   *       ListPurchasableSkusRequest.newBuilder()
   *           .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   while (true) {
   *     ListPurchasableSkusResponse response =
   *         cloudChannelServiceClient.listPurchasableSkusCallable().call(request);
   *     for (PurchasableSku element : response.getPurchasableSkusList()) {
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
  public final UnaryCallable<ListPurchasableSkusRequest, ListPurchasableSkusResponse>
      listPurchasableSkusCallable() {
    return stub.listPurchasableSkusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the following:
   *
   * <ul>
   *   <li>Offers that you can purchase for a customer.
   *   <li>Offers that you can change for an entitlement.
   * </ul>
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListPurchasableOffersRequest request =
   *       ListPurchasableOffersRequest.newBuilder()
   *           .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   for (PurchasableOffer element :
   *       cloudChannelServiceClient.listPurchasableOffers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPurchasableOffersPagedResponse listPurchasableOffers(
      ListPurchasableOffersRequest request) {
    return listPurchasableOffersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the following:
   *
   * <ul>
   *   <li>Offers that you can purchase for a customer.
   *   <li>Offers that you can change for an entitlement.
   * </ul>
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListPurchasableOffersRequest request =
   *       ListPurchasableOffersRequest.newBuilder()
   *           .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<PurchasableOffer> future =
   *       cloudChannelServiceClient.listPurchasableOffersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PurchasableOffer element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPurchasableOffersRequest, ListPurchasableOffersPagedResponse>
      listPurchasableOffersPagedCallable() {
    return stub.listPurchasableOffersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the following:
   *
   * <ul>
   *   <li>Offers that you can purchase for a customer.
   *   <li>Offers that you can change for an entitlement.
   * </ul>
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The customer doesn't belong to the reseller
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
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
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListPurchasableOffersRequest request =
   *       ListPurchasableOffersRequest.newBuilder()
   *           .setCustomer(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   while (true) {
   *     ListPurchasableOffersResponse response =
   *         cloudChannelServiceClient.listPurchasableOffersCallable().call(request);
   *     for (PurchasableOffer element : response.getPurchasableOffersList()) {
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
  public final UnaryCallable<ListPurchasableOffersRequest, ListPurchasableOffersResponse>
      listPurchasableOffersCallable() {
    return stub.listPurchasableOffersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers a service account with subscriber privileges on the Cloud Pub/Sub topic for this
   * Channel Services account. After you create a subscriber, you get the events through
   * [SubscriberEvent][google.cloud.channel.v1.SubscriberEvent]
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request and the provided reseller
   *       account are different, or the impersonated user is not a super admin.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The topic name with the registered service email address.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   RegisterSubscriberRequest request =
   *       RegisterSubscriberRequest.newBuilder()
   *           .setAccount("account-1177318867")
   *           .setServiceAccount("serviceAccount1079137720")
   *           .build();
   *   RegisterSubscriberResponse response = cloudChannelServiceClient.registerSubscriber(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RegisterSubscriberResponse registerSubscriber(RegisterSubscriberRequest request) {
    return registerSubscriberCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers a service account with subscriber privileges on the Cloud Pub/Sub topic for this
   * Channel Services account. After you create a subscriber, you get the events through
   * [SubscriberEvent][google.cloud.channel.v1.SubscriberEvent]
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request and the provided reseller
   *       account are different, or the impersonated user is not a super admin.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The topic name with the registered service email address.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   RegisterSubscriberRequest request =
   *       RegisterSubscriberRequest.newBuilder()
   *           .setAccount("account-1177318867")
   *           .setServiceAccount("serviceAccount1079137720")
   *           .build();
   *   ApiFuture<RegisterSubscriberResponse> future =
   *       cloudChannelServiceClient.registerSubscriberCallable().futureCall(request);
   *   // Do something.
   *   RegisterSubscriberResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RegisterSubscriberRequest, RegisterSubscriberResponse>
      registerSubscriberCallable() {
    return stub.registerSubscriberCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unregisters a service account with subscriber privileges on the Cloud Pub/Sub topic created for
   * this Channel Services account. If there are no service accounts left with subscriber
   * privileges, this deletes the topic. You can call ListSubscribers to check for these accounts.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request and the provided reseller
   *       account are different, or the impersonated user is not a super admin.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The topic resource doesn't exist.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The topic name that unregistered the service email address. Returns a success
   * response if the service email address wasn't registered with the topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   UnregisterSubscriberRequest request =
   *       UnregisterSubscriberRequest.newBuilder()
   *           .setAccount("account-1177318867")
   *           .setServiceAccount("serviceAccount1079137720")
   *           .build();
   *   UnregisterSubscriberResponse response =
   *       cloudChannelServiceClient.unregisterSubscriber(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnregisterSubscriberResponse unregisterSubscriber(
      UnregisterSubscriberRequest request) {
    return unregisterSubscriberCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unregisters a service account with subscriber privileges on the Cloud Pub/Sub topic created for
   * this Channel Services account. If there are no service accounts left with subscriber
   * privileges, this deletes the topic. You can call ListSubscribers to check for these accounts.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request and the provided reseller
   *       account are different, or the impersonated user is not a super admin.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The topic resource doesn't exist.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The topic name that unregistered the service email address. Returns a success
   * response if the service email address wasn't registered with the topic.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   UnregisterSubscriberRequest request =
   *       UnregisterSubscriberRequest.newBuilder()
   *           .setAccount("account-1177318867")
   *           .setServiceAccount("serviceAccount1079137720")
   *           .build();
   *   ApiFuture<UnregisterSubscriberResponse> future =
   *       cloudChannelServiceClient.unregisterSubscriberCallable().futureCall(request);
   *   // Do something.
   *   UnregisterSubscriberResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UnregisterSubscriberRequest, UnregisterSubscriberResponse>
      unregisterSubscriberCallable() {
    return stub.unregisterSubscriberCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists service accounts with subscriber privileges on the Cloud Pub/Sub topic created for this
   * Channel Services account.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request and the provided reseller
   *       account are different, or the impersonated user is not a super admin.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The topic resource doesn't exist.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: A list of service email addresses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListSubscribersRequest request =
   *       ListSubscribersRequest.newBuilder()
   *           .setAccount("account-1177318867")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (String element : cloudChannelServiceClient.listSubscribers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSubscribersPagedResponse listSubscribers(ListSubscribersRequest request) {
    return listSubscribersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists service accounts with subscriber privileges on the Cloud Pub/Sub topic created for this
   * Channel Services account.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request and the provided reseller
   *       account are different, or the impersonated user is not a super admin.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The topic resource doesn't exist.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: A list of service email addresses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListSubscribersRequest request =
   *       ListSubscribersRequest.newBuilder()
   *           .setAccount("account-1177318867")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<String> future =
   *       cloudChannelServiceClient.listSubscribersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (String element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSubscribersRequest, ListSubscribersPagedResponse>
      listSubscribersPagedCallable() {
    return stub.listSubscribersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists service accounts with subscriber privileges on the Cloud Pub/Sub topic created for this
   * Channel Services account.
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The reseller account making the request and the provided reseller
   *       account are different, or the impersonated user is not a super admin.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The topic resource doesn't exist.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: A list of service email addresses.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
   *   ListSubscribersRequest request =
   *       ListSubscribersRequest.newBuilder()
   *           .setAccount("account-1177318867")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSubscribersResponse response =
   *         cloudChannelServiceClient.listSubscribersCallable().call(request);
   *     for (String element : response.getServiceAccountsList()) {
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
  public final UnaryCallable<ListSubscribersRequest, ListSubscribersResponse>
      listSubscribersCallable() {
    return stub.listSubscribersCallable();
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

  public static class ListCustomersPagedResponse
      extends AbstractPagedListResponse<
          ListCustomersRequest,
          ListCustomersResponse,
          Customer,
          ListCustomersPage,
          ListCustomersFixedSizeCollection> {

    public static ApiFuture<ListCustomersPagedResponse> createAsync(
        PageContext<ListCustomersRequest, ListCustomersResponse, Customer> context,
        ApiFuture<ListCustomersResponse> futureResponse) {
      ApiFuture<ListCustomersPage> futurePage =
          ListCustomersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCustomersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCustomersPagedResponse(ListCustomersPage page) {
      super(page, ListCustomersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCustomersPage
      extends AbstractPage<
          ListCustomersRequest, ListCustomersResponse, Customer, ListCustomersPage> {

    private ListCustomersPage(
        PageContext<ListCustomersRequest, ListCustomersResponse, Customer> context,
        ListCustomersResponse response) {
      super(context, response);
    }

    private static ListCustomersPage createEmptyPage() {
      return new ListCustomersPage(null, null);
    }

    @Override
    protected ListCustomersPage createPage(
        PageContext<ListCustomersRequest, ListCustomersResponse, Customer> context,
        ListCustomersResponse response) {
      return new ListCustomersPage(context, response);
    }

    @Override
    public ApiFuture<ListCustomersPage> createPageAsync(
        PageContext<ListCustomersRequest, ListCustomersResponse, Customer> context,
        ApiFuture<ListCustomersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCustomersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCustomersRequest,
          ListCustomersResponse,
          Customer,
          ListCustomersPage,
          ListCustomersFixedSizeCollection> {

    private ListCustomersFixedSizeCollection(List<ListCustomersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCustomersFixedSizeCollection createEmptyCollection() {
      return new ListCustomersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCustomersFixedSizeCollection createCollection(
        List<ListCustomersPage> pages, int collectionSize) {
      return new ListCustomersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEntitlementsPagedResponse
      extends AbstractPagedListResponse<
          ListEntitlementsRequest,
          ListEntitlementsResponse,
          Entitlement,
          ListEntitlementsPage,
          ListEntitlementsFixedSizeCollection> {

    public static ApiFuture<ListEntitlementsPagedResponse> createAsync(
        PageContext<ListEntitlementsRequest, ListEntitlementsResponse, Entitlement> context,
        ApiFuture<ListEntitlementsResponse> futureResponse) {
      ApiFuture<ListEntitlementsPage> futurePage =
          ListEntitlementsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEntitlementsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEntitlementsPagedResponse(ListEntitlementsPage page) {
      super(page, ListEntitlementsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEntitlementsPage
      extends AbstractPage<
          ListEntitlementsRequest, ListEntitlementsResponse, Entitlement, ListEntitlementsPage> {

    private ListEntitlementsPage(
        PageContext<ListEntitlementsRequest, ListEntitlementsResponse, Entitlement> context,
        ListEntitlementsResponse response) {
      super(context, response);
    }

    private static ListEntitlementsPage createEmptyPage() {
      return new ListEntitlementsPage(null, null);
    }

    @Override
    protected ListEntitlementsPage createPage(
        PageContext<ListEntitlementsRequest, ListEntitlementsResponse, Entitlement> context,
        ListEntitlementsResponse response) {
      return new ListEntitlementsPage(context, response);
    }

    @Override
    public ApiFuture<ListEntitlementsPage> createPageAsync(
        PageContext<ListEntitlementsRequest, ListEntitlementsResponse, Entitlement> context,
        ApiFuture<ListEntitlementsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEntitlementsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEntitlementsRequest,
          ListEntitlementsResponse,
          Entitlement,
          ListEntitlementsPage,
          ListEntitlementsFixedSizeCollection> {

    private ListEntitlementsFixedSizeCollection(
        List<ListEntitlementsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEntitlementsFixedSizeCollection createEmptyCollection() {
      return new ListEntitlementsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEntitlementsFixedSizeCollection createCollection(
        List<ListEntitlementsPage> pages, int collectionSize) {
      return new ListEntitlementsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTransferableSkusPagedResponse
      extends AbstractPagedListResponse<
          ListTransferableSkusRequest,
          ListTransferableSkusResponse,
          TransferableSku,
          ListTransferableSkusPage,
          ListTransferableSkusFixedSizeCollection> {

    public static ApiFuture<ListTransferableSkusPagedResponse> createAsync(
        PageContext<ListTransferableSkusRequest, ListTransferableSkusResponse, TransferableSku>
            context,
        ApiFuture<ListTransferableSkusResponse> futureResponse) {
      ApiFuture<ListTransferableSkusPage> futurePage =
          ListTransferableSkusPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTransferableSkusPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTransferableSkusPagedResponse(ListTransferableSkusPage page) {
      super(page, ListTransferableSkusFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTransferableSkusPage
      extends AbstractPage<
          ListTransferableSkusRequest,
          ListTransferableSkusResponse,
          TransferableSku,
          ListTransferableSkusPage> {

    private ListTransferableSkusPage(
        PageContext<ListTransferableSkusRequest, ListTransferableSkusResponse, TransferableSku>
            context,
        ListTransferableSkusResponse response) {
      super(context, response);
    }

    private static ListTransferableSkusPage createEmptyPage() {
      return new ListTransferableSkusPage(null, null);
    }

    @Override
    protected ListTransferableSkusPage createPage(
        PageContext<ListTransferableSkusRequest, ListTransferableSkusResponse, TransferableSku>
            context,
        ListTransferableSkusResponse response) {
      return new ListTransferableSkusPage(context, response);
    }

    @Override
    public ApiFuture<ListTransferableSkusPage> createPageAsync(
        PageContext<ListTransferableSkusRequest, ListTransferableSkusResponse, TransferableSku>
            context,
        ApiFuture<ListTransferableSkusResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTransferableSkusFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTransferableSkusRequest,
          ListTransferableSkusResponse,
          TransferableSku,
          ListTransferableSkusPage,
          ListTransferableSkusFixedSizeCollection> {

    private ListTransferableSkusFixedSizeCollection(
        List<ListTransferableSkusPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTransferableSkusFixedSizeCollection createEmptyCollection() {
      return new ListTransferableSkusFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTransferableSkusFixedSizeCollection createCollection(
        List<ListTransferableSkusPage> pages, int collectionSize) {
      return new ListTransferableSkusFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTransferableOffersPagedResponse
      extends AbstractPagedListResponse<
          ListTransferableOffersRequest,
          ListTransferableOffersResponse,
          TransferableOffer,
          ListTransferableOffersPage,
          ListTransferableOffersFixedSizeCollection> {

    public static ApiFuture<ListTransferableOffersPagedResponse> createAsync(
        PageContext<
                ListTransferableOffersRequest, ListTransferableOffersResponse, TransferableOffer>
            context,
        ApiFuture<ListTransferableOffersResponse> futureResponse) {
      ApiFuture<ListTransferableOffersPage> futurePage =
          ListTransferableOffersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTransferableOffersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTransferableOffersPagedResponse(ListTransferableOffersPage page) {
      super(page, ListTransferableOffersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTransferableOffersPage
      extends AbstractPage<
          ListTransferableOffersRequest,
          ListTransferableOffersResponse,
          TransferableOffer,
          ListTransferableOffersPage> {

    private ListTransferableOffersPage(
        PageContext<
                ListTransferableOffersRequest, ListTransferableOffersResponse, TransferableOffer>
            context,
        ListTransferableOffersResponse response) {
      super(context, response);
    }

    private static ListTransferableOffersPage createEmptyPage() {
      return new ListTransferableOffersPage(null, null);
    }

    @Override
    protected ListTransferableOffersPage createPage(
        PageContext<
                ListTransferableOffersRequest, ListTransferableOffersResponse, TransferableOffer>
            context,
        ListTransferableOffersResponse response) {
      return new ListTransferableOffersPage(context, response);
    }

    @Override
    public ApiFuture<ListTransferableOffersPage> createPageAsync(
        PageContext<
                ListTransferableOffersRequest, ListTransferableOffersResponse, TransferableOffer>
            context,
        ApiFuture<ListTransferableOffersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTransferableOffersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTransferableOffersRequest,
          ListTransferableOffersResponse,
          TransferableOffer,
          ListTransferableOffersPage,
          ListTransferableOffersFixedSizeCollection> {

    private ListTransferableOffersFixedSizeCollection(
        List<ListTransferableOffersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTransferableOffersFixedSizeCollection createEmptyCollection() {
      return new ListTransferableOffersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTransferableOffersFixedSizeCollection createCollection(
        List<ListTransferableOffersPage> pages, int collectionSize) {
      return new ListTransferableOffersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListChannelPartnerLinksPagedResponse
      extends AbstractPagedListResponse<
          ListChannelPartnerLinksRequest,
          ListChannelPartnerLinksResponse,
          ChannelPartnerLink,
          ListChannelPartnerLinksPage,
          ListChannelPartnerLinksFixedSizeCollection> {

    public static ApiFuture<ListChannelPartnerLinksPagedResponse> createAsync(
        PageContext<
                ListChannelPartnerLinksRequest, ListChannelPartnerLinksResponse, ChannelPartnerLink>
            context,
        ApiFuture<ListChannelPartnerLinksResponse> futureResponse) {
      ApiFuture<ListChannelPartnerLinksPage> futurePage =
          ListChannelPartnerLinksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListChannelPartnerLinksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListChannelPartnerLinksPagedResponse(ListChannelPartnerLinksPage page) {
      super(page, ListChannelPartnerLinksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListChannelPartnerLinksPage
      extends AbstractPage<
          ListChannelPartnerLinksRequest,
          ListChannelPartnerLinksResponse,
          ChannelPartnerLink,
          ListChannelPartnerLinksPage> {

    private ListChannelPartnerLinksPage(
        PageContext<
                ListChannelPartnerLinksRequest, ListChannelPartnerLinksResponse, ChannelPartnerLink>
            context,
        ListChannelPartnerLinksResponse response) {
      super(context, response);
    }

    private static ListChannelPartnerLinksPage createEmptyPage() {
      return new ListChannelPartnerLinksPage(null, null);
    }

    @Override
    protected ListChannelPartnerLinksPage createPage(
        PageContext<
                ListChannelPartnerLinksRequest, ListChannelPartnerLinksResponse, ChannelPartnerLink>
            context,
        ListChannelPartnerLinksResponse response) {
      return new ListChannelPartnerLinksPage(context, response);
    }

    @Override
    public ApiFuture<ListChannelPartnerLinksPage> createPageAsync(
        PageContext<
                ListChannelPartnerLinksRequest, ListChannelPartnerLinksResponse, ChannelPartnerLink>
            context,
        ApiFuture<ListChannelPartnerLinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListChannelPartnerLinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListChannelPartnerLinksRequest,
          ListChannelPartnerLinksResponse,
          ChannelPartnerLink,
          ListChannelPartnerLinksPage,
          ListChannelPartnerLinksFixedSizeCollection> {

    private ListChannelPartnerLinksFixedSizeCollection(
        List<ListChannelPartnerLinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListChannelPartnerLinksFixedSizeCollection createEmptyCollection() {
      return new ListChannelPartnerLinksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListChannelPartnerLinksFixedSizeCollection createCollection(
        List<ListChannelPartnerLinksPage> pages, int collectionSize) {
      return new ListChannelPartnerLinksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCustomerRepricingConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListCustomerRepricingConfigsRequest,
          ListCustomerRepricingConfigsResponse,
          CustomerRepricingConfig,
          ListCustomerRepricingConfigsPage,
          ListCustomerRepricingConfigsFixedSizeCollection> {

    public static ApiFuture<ListCustomerRepricingConfigsPagedResponse> createAsync(
        PageContext<
                ListCustomerRepricingConfigsRequest,
                ListCustomerRepricingConfigsResponse,
                CustomerRepricingConfig>
            context,
        ApiFuture<ListCustomerRepricingConfigsResponse> futureResponse) {
      ApiFuture<ListCustomerRepricingConfigsPage> futurePage =
          ListCustomerRepricingConfigsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCustomerRepricingConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCustomerRepricingConfigsPagedResponse(ListCustomerRepricingConfigsPage page) {
      super(page, ListCustomerRepricingConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCustomerRepricingConfigsPage
      extends AbstractPage<
          ListCustomerRepricingConfigsRequest,
          ListCustomerRepricingConfigsResponse,
          CustomerRepricingConfig,
          ListCustomerRepricingConfigsPage> {

    private ListCustomerRepricingConfigsPage(
        PageContext<
                ListCustomerRepricingConfigsRequest,
                ListCustomerRepricingConfigsResponse,
                CustomerRepricingConfig>
            context,
        ListCustomerRepricingConfigsResponse response) {
      super(context, response);
    }

    private static ListCustomerRepricingConfigsPage createEmptyPage() {
      return new ListCustomerRepricingConfigsPage(null, null);
    }

    @Override
    protected ListCustomerRepricingConfigsPage createPage(
        PageContext<
                ListCustomerRepricingConfigsRequest,
                ListCustomerRepricingConfigsResponse,
                CustomerRepricingConfig>
            context,
        ListCustomerRepricingConfigsResponse response) {
      return new ListCustomerRepricingConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListCustomerRepricingConfigsPage> createPageAsync(
        PageContext<
                ListCustomerRepricingConfigsRequest,
                ListCustomerRepricingConfigsResponse,
                CustomerRepricingConfig>
            context,
        ApiFuture<ListCustomerRepricingConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCustomerRepricingConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCustomerRepricingConfigsRequest,
          ListCustomerRepricingConfigsResponse,
          CustomerRepricingConfig,
          ListCustomerRepricingConfigsPage,
          ListCustomerRepricingConfigsFixedSizeCollection> {

    private ListCustomerRepricingConfigsFixedSizeCollection(
        List<ListCustomerRepricingConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCustomerRepricingConfigsFixedSizeCollection createEmptyCollection() {
      return new ListCustomerRepricingConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCustomerRepricingConfigsFixedSizeCollection createCollection(
        List<ListCustomerRepricingConfigsPage> pages, int collectionSize) {
      return new ListCustomerRepricingConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListChannelPartnerRepricingConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListChannelPartnerRepricingConfigsRequest,
          ListChannelPartnerRepricingConfigsResponse,
          ChannelPartnerRepricingConfig,
          ListChannelPartnerRepricingConfigsPage,
          ListChannelPartnerRepricingConfigsFixedSizeCollection> {

    public static ApiFuture<ListChannelPartnerRepricingConfigsPagedResponse> createAsync(
        PageContext<
                ListChannelPartnerRepricingConfigsRequest,
                ListChannelPartnerRepricingConfigsResponse,
                ChannelPartnerRepricingConfig>
            context,
        ApiFuture<ListChannelPartnerRepricingConfigsResponse> futureResponse) {
      ApiFuture<ListChannelPartnerRepricingConfigsPage> futurePage =
          ListChannelPartnerRepricingConfigsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListChannelPartnerRepricingConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListChannelPartnerRepricingConfigsPagedResponse(
        ListChannelPartnerRepricingConfigsPage page) {
      super(page, ListChannelPartnerRepricingConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListChannelPartnerRepricingConfigsPage
      extends AbstractPage<
          ListChannelPartnerRepricingConfigsRequest,
          ListChannelPartnerRepricingConfigsResponse,
          ChannelPartnerRepricingConfig,
          ListChannelPartnerRepricingConfigsPage> {

    private ListChannelPartnerRepricingConfigsPage(
        PageContext<
                ListChannelPartnerRepricingConfigsRequest,
                ListChannelPartnerRepricingConfigsResponse,
                ChannelPartnerRepricingConfig>
            context,
        ListChannelPartnerRepricingConfigsResponse response) {
      super(context, response);
    }

    private static ListChannelPartnerRepricingConfigsPage createEmptyPage() {
      return new ListChannelPartnerRepricingConfigsPage(null, null);
    }

    @Override
    protected ListChannelPartnerRepricingConfigsPage createPage(
        PageContext<
                ListChannelPartnerRepricingConfigsRequest,
                ListChannelPartnerRepricingConfigsResponse,
                ChannelPartnerRepricingConfig>
            context,
        ListChannelPartnerRepricingConfigsResponse response) {
      return new ListChannelPartnerRepricingConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListChannelPartnerRepricingConfigsPage> createPageAsync(
        PageContext<
                ListChannelPartnerRepricingConfigsRequest,
                ListChannelPartnerRepricingConfigsResponse,
                ChannelPartnerRepricingConfig>
            context,
        ApiFuture<ListChannelPartnerRepricingConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListChannelPartnerRepricingConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListChannelPartnerRepricingConfigsRequest,
          ListChannelPartnerRepricingConfigsResponse,
          ChannelPartnerRepricingConfig,
          ListChannelPartnerRepricingConfigsPage,
          ListChannelPartnerRepricingConfigsFixedSizeCollection> {

    private ListChannelPartnerRepricingConfigsFixedSizeCollection(
        List<ListChannelPartnerRepricingConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListChannelPartnerRepricingConfigsFixedSizeCollection createEmptyCollection() {
      return new ListChannelPartnerRepricingConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListChannelPartnerRepricingConfigsFixedSizeCollection createCollection(
        List<ListChannelPartnerRepricingConfigsPage> pages, int collectionSize) {
      return new ListChannelPartnerRepricingConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListProductsPagedResponse
      extends AbstractPagedListResponse<
          ListProductsRequest,
          ListProductsResponse,
          Product,
          ListProductsPage,
          ListProductsFixedSizeCollection> {

    public static ApiFuture<ListProductsPagedResponse> createAsync(
        PageContext<ListProductsRequest, ListProductsResponse, Product> context,
        ApiFuture<ListProductsResponse> futureResponse) {
      ApiFuture<ListProductsPage> futurePage =
          ListProductsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListProductsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListProductsPagedResponse(ListProductsPage page) {
      super(page, ListProductsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProductsPage
      extends AbstractPage<ListProductsRequest, ListProductsResponse, Product, ListProductsPage> {

    private ListProductsPage(
        PageContext<ListProductsRequest, ListProductsResponse, Product> context,
        ListProductsResponse response) {
      super(context, response);
    }

    private static ListProductsPage createEmptyPage() {
      return new ListProductsPage(null, null);
    }

    @Override
    protected ListProductsPage createPage(
        PageContext<ListProductsRequest, ListProductsResponse, Product> context,
        ListProductsResponse response) {
      return new ListProductsPage(context, response);
    }

    @Override
    public ApiFuture<ListProductsPage> createPageAsync(
        PageContext<ListProductsRequest, ListProductsResponse, Product> context,
        ApiFuture<ListProductsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProductsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProductsRequest,
          ListProductsResponse,
          Product,
          ListProductsPage,
          ListProductsFixedSizeCollection> {

    private ListProductsFixedSizeCollection(List<ListProductsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProductsFixedSizeCollection createEmptyCollection() {
      return new ListProductsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProductsFixedSizeCollection createCollection(
        List<ListProductsPage> pages, int collectionSize) {
      return new ListProductsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSkusPagedResponse
      extends AbstractPagedListResponse<
          ListSkusRequest, ListSkusResponse, Sku, ListSkusPage, ListSkusFixedSizeCollection> {

    public static ApiFuture<ListSkusPagedResponse> createAsync(
        PageContext<ListSkusRequest, ListSkusResponse, Sku> context,
        ApiFuture<ListSkusResponse> futureResponse) {
      ApiFuture<ListSkusPage> futurePage =
          ListSkusPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSkusPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSkusPagedResponse(ListSkusPage page) {
      super(page, ListSkusFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSkusPage
      extends AbstractPage<ListSkusRequest, ListSkusResponse, Sku, ListSkusPage> {

    private ListSkusPage(
        PageContext<ListSkusRequest, ListSkusResponse, Sku> context, ListSkusResponse response) {
      super(context, response);
    }

    private static ListSkusPage createEmptyPage() {
      return new ListSkusPage(null, null);
    }

    @Override
    protected ListSkusPage createPage(
        PageContext<ListSkusRequest, ListSkusResponse, Sku> context, ListSkusResponse response) {
      return new ListSkusPage(context, response);
    }

    @Override
    public ApiFuture<ListSkusPage> createPageAsync(
        PageContext<ListSkusRequest, ListSkusResponse, Sku> context,
        ApiFuture<ListSkusResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSkusFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSkusRequest, ListSkusResponse, Sku, ListSkusPage, ListSkusFixedSizeCollection> {

    private ListSkusFixedSizeCollection(List<ListSkusPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSkusFixedSizeCollection createEmptyCollection() {
      return new ListSkusFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSkusFixedSizeCollection createCollection(
        List<ListSkusPage> pages, int collectionSize) {
      return new ListSkusFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListOffersPagedResponse
      extends AbstractPagedListResponse<
          ListOffersRequest,
          ListOffersResponse,
          Offer,
          ListOffersPage,
          ListOffersFixedSizeCollection> {

    public static ApiFuture<ListOffersPagedResponse> createAsync(
        PageContext<ListOffersRequest, ListOffersResponse, Offer> context,
        ApiFuture<ListOffersResponse> futureResponse) {
      ApiFuture<ListOffersPage> futurePage =
          ListOffersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListOffersPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListOffersPagedResponse(ListOffersPage page) {
      super(page, ListOffersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOffersPage
      extends AbstractPage<ListOffersRequest, ListOffersResponse, Offer, ListOffersPage> {

    private ListOffersPage(
        PageContext<ListOffersRequest, ListOffersResponse, Offer> context,
        ListOffersResponse response) {
      super(context, response);
    }

    private static ListOffersPage createEmptyPage() {
      return new ListOffersPage(null, null);
    }

    @Override
    protected ListOffersPage createPage(
        PageContext<ListOffersRequest, ListOffersResponse, Offer> context,
        ListOffersResponse response) {
      return new ListOffersPage(context, response);
    }

    @Override
    public ApiFuture<ListOffersPage> createPageAsync(
        PageContext<ListOffersRequest, ListOffersResponse, Offer> context,
        ApiFuture<ListOffersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOffersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOffersRequest,
          ListOffersResponse,
          Offer,
          ListOffersPage,
          ListOffersFixedSizeCollection> {

    private ListOffersFixedSizeCollection(List<ListOffersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOffersFixedSizeCollection createEmptyCollection() {
      return new ListOffersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOffersFixedSizeCollection createCollection(
        List<ListOffersPage> pages, int collectionSize) {
      return new ListOffersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPurchasableSkusPagedResponse
      extends AbstractPagedListResponse<
          ListPurchasableSkusRequest,
          ListPurchasableSkusResponse,
          PurchasableSku,
          ListPurchasableSkusPage,
          ListPurchasableSkusFixedSizeCollection> {

    public static ApiFuture<ListPurchasableSkusPagedResponse> createAsync(
        PageContext<ListPurchasableSkusRequest, ListPurchasableSkusResponse, PurchasableSku>
            context,
        ApiFuture<ListPurchasableSkusResponse> futureResponse) {
      ApiFuture<ListPurchasableSkusPage> futurePage =
          ListPurchasableSkusPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPurchasableSkusPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPurchasableSkusPagedResponse(ListPurchasableSkusPage page) {
      super(page, ListPurchasableSkusFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPurchasableSkusPage
      extends AbstractPage<
          ListPurchasableSkusRequest,
          ListPurchasableSkusResponse,
          PurchasableSku,
          ListPurchasableSkusPage> {

    private ListPurchasableSkusPage(
        PageContext<ListPurchasableSkusRequest, ListPurchasableSkusResponse, PurchasableSku>
            context,
        ListPurchasableSkusResponse response) {
      super(context, response);
    }

    private static ListPurchasableSkusPage createEmptyPage() {
      return new ListPurchasableSkusPage(null, null);
    }

    @Override
    protected ListPurchasableSkusPage createPage(
        PageContext<ListPurchasableSkusRequest, ListPurchasableSkusResponse, PurchasableSku>
            context,
        ListPurchasableSkusResponse response) {
      return new ListPurchasableSkusPage(context, response);
    }

    @Override
    public ApiFuture<ListPurchasableSkusPage> createPageAsync(
        PageContext<ListPurchasableSkusRequest, ListPurchasableSkusResponse, PurchasableSku>
            context,
        ApiFuture<ListPurchasableSkusResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPurchasableSkusFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPurchasableSkusRequest,
          ListPurchasableSkusResponse,
          PurchasableSku,
          ListPurchasableSkusPage,
          ListPurchasableSkusFixedSizeCollection> {

    private ListPurchasableSkusFixedSizeCollection(
        List<ListPurchasableSkusPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPurchasableSkusFixedSizeCollection createEmptyCollection() {
      return new ListPurchasableSkusFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPurchasableSkusFixedSizeCollection createCollection(
        List<ListPurchasableSkusPage> pages, int collectionSize) {
      return new ListPurchasableSkusFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPurchasableOffersPagedResponse
      extends AbstractPagedListResponse<
          ListPurchasableOffersRequest,
          ListPurchasableOffersResponse,
          PurchasableOffer,
          ListPurchasableOffersPage,
          ListPurchasableOffersFixedSizeCollection> {

    public static ApiFuture<ListPurchasableOffersPagedResponse> createAsync(
        PageContext<ListPurchasableOffersRequest, ListPurchasableOffersResponse, PurchasableOffer>
            context,
        ApiFuture<ListPurchasableOffersResponse> futureResponse) {
      ApiFuture<ListPurchasableOffersPage> futurePage =
          ListPurchasableOffersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPurchasableOffersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPurchasableOffersPagedResponse(ListPurchasableOffersPage page) {
      super(page, ListPurchasableOffersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPurchasableOffersPage
      extends AbstractPage<
          ListPurchasableOffersRequest,
          ListPurchasableOffersResponse,
          PurchasableOffer,
          ListPurchasableOffersPage> {

    private ListPurchasableOffersPage(
        PageContext<ListPurchasableOffersRequest, ListPurchasableOffersResponse, PurchasableOffer>
            context,
        ListPurchasableOffersResponse response) {
      super(context, response);
    }

    private static ListPurchasableOffersPage createEmptyPage() {
      return new ListPurchasableOffersPage(null, null);
    }

    @Override
    protected ListPurchasableOffersPage createPage(
        PageContext<ListPurchasableOffersRequest, ListPurchasableOffersResponse, PurchasableOffer>
            context,
        ListPurchasableOffersResponse response) {
      return new ListPurchasableOffersPage(context, response);
    }

    @Override
    public ApiFuture<ListPurchasableOffersPage> createPageAsync(
        PageContext<ListPurchasableOffersRequest, ListPurchasableOffersResponse, PurchasableOffer>
            context,
        ApiFuture<ListPurchasableOffersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPurchasableOffersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPurchasableOffersRequest,
          ListPurchasableOffersResponse,
          PurchasableOffer,
          ListPurchasableOffersPage,
          ListPurchasableOffersFixedSizeCollection> {

    private ListPurchasableOffersFixedSizeCollection(
        List<ListPurchasableOffersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPurchasableOffersFixedSizeCollection createEmptyCollection() {
      return new ListPurchasableOffersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPurchasableOffersFixedSizeCollection createCollection(
        List<ListPurchasableOffersPage> pages, int collectionSize) {
      return new ListPurchasableOffersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSubscribersPagedResponse
      extends AbstractPagedListResponse<
          ListSubscribersRequest,
          ListSubscribersResponse,
          String,
          ListSubscribersPage,
          ListSubscribersFixedSizeCollection> {

    public static ApiFuture<ListSubscribersPagedResponse> createAsync(
        PageContext<ListSubscribersRequest, ListSubscribersResponse, String> context,
        ApiFuture<ListSubscribersResponse> futureResponse) {
      ApiFuture<ListSubscribersPage> futurePage =
          ListSubscribersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSubscribersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSubscribersPagedResponse(ListSubscribersPage page) {
      super(page, ListSubscribersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSubscribersPage
      extends AbstractPage<
          ListSubscribersRequest, ListSubscribersResponse, String, ListSubscribersPage> {

    private ListSubscribersPage(
        PageContext<ListSubscribersRequest, ListSubscribersResponse, String> context,
        ListSubscribersResponse response) {
      super(context, response);
    }

    private static ListSubscribersPage createEmptyPage() {
      return new ListSubscribersPage(null, null);
    }

    @Override
    protected ListSubscribersPage createPage(
        PageContext<ListSubscribersRequest, ListSubscribersResponse, String> context,
        ListSubscribersResponse response) {
      return new ListSubscribersPage(context, response);
    }

    @Override
    public ApiFuture<ListSubscribersPage> createPageAsync(
        PageContext<ListSubscribersRequest, ListSubscribersResponse, String> context,
        ApiFuture<ListSubscribersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSubscribersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSubscribersRequest,
          ListSubscribersResponse,
          String,
          ListSubscribersPage,
          ListSubscribersFixedSizeCollection> {

    private ListSubscribersFixedSizeCollection(
        List<ListSubscribersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSubscribersFixedSizeCollection createEmptyCollection() {
      return new ListSubscribersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSubscribersFixedSizeCollection createCollection(
        List<ListSubscribersPage> pages, int collectionSize) {
      return new ListSubscribersFixedSizeCollection(pages, collectionSize);
    }
  }
}
