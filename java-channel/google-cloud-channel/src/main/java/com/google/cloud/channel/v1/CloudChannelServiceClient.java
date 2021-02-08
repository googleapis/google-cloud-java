/*
 * Copyright 2020 Google LLC
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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
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
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: CloudChannelService enables Google cloud resellers and distributors to
 * manage their customers, channel partners, entitlements and reports.
 *
 * <p>Using this service: 1. Resellers or distributors can manage a customer entity. 2. Distributors
 * can register an authorized reseller in their channel and then enable delegated admin access for
 * the reseller. 3. Resellers or distributors can manage entitlements for their customers.
 *
 * <p>The service primarily exposes the following resources: -
 * [Customer][google.cloud.channel.v1.Customer]s: A Customer represents an entity managed by a
 * reseller or distributor. A customer typically represents an enterprise. In an n-tier resale
 * channel hierarchy, customers are generally represented as leaf nodes. Customers primarily have an
 * Entitlement sub-resource discussed below.
 *
 * <p>- [Entitlement][google.cloud.channel.v1.Entitlement]s: An Entitlement represents an entity
 * which provides a customer means to start using a service. Entitlements are created or updated as
 * a result of a successful fulfillment.
 *
 * <p>- [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]s: A ChannelPartnerLink is
 * an entity that identifies links between distributors and their indirect resellers in a channel.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
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
 * CloudChannelServiceSettings cloudChannelServiceSettings =
 *     CloudChannelServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
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
  private final OperationsClient operationsClient;

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
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected CloudChannelServiceClient(CloudChannelServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final CloudChannelServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public CloudChannelServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List downstream [Customer][google.cloud.channel.v1.Customer]s.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; List of [Customer][google.cloud.channel.v1.Customer]s pertaining
   * to the reseller or empty list if there are none.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCustomersPagedResponse listCustomers(ListCustomersRequest request) {
    return listCustomersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List downstream [Customer][google.cloud.channel.v1.Customer]s.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; List of [Customer][google.cloud.channel.v1.Customer]s pertaining
   * to the reseller or empty list if there are none.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListCustomersRequest, ListCustomersPagedResponse>
      listCustomersPagedCallable() {
    return stub.listCustomersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List downstream [Customer][google.cloud.channel.v1.Customer]s.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; List of [Customer][google.cloud.channel.v1.Customer]s pertaining
   * to the reseller or empty list if there are none.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListCustomersRequest, ListCustomersResponse> listCustomersCallable() {
    return stub.listCustomersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a requested [Customer][google.cloud.channel.v1.Customer] resource.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: If the customer resource doesn't exist. Usually the result of an invalid name
   *       parameter.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; [Customer][google.cloud.channel.v1.Customer] resource if found,
   * error otherwise.
   *
   * @param name Required. The resource name of the customer to retrieve. The name takes the format:
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
   * Returns a requested [Customer][google.cloud.channel.v1.Customer] resource.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: If the customer resource doesn't exist. Usually the result of an invalid name
   *       parameter.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; [Customer][google.cloud.channel.v1.Customer] resource if found,
   * error otherwise.
   *
   * @param name Required. The resource name of the customer to retrieve. The name takes the format:
   *     accounts/{account_id}/customers/{customer_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Customer getCustomer(String name) {
    GetCustomerRequest request = GetCustomerRequest.newBuilder().setName(name).build();
    return getCustomer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a requested [Customer][google.cloud.channel.v1.Customer] resource.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: If the customer resource doesn't exist. Usually the result of an invalid name
   *       parameter.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; [Customer][google.cloud.channel.v1.Customer] resource if found,
   * error otherwise.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Customer getCustomer(GetCustomerRequest request) {
    return getCustomerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a requested [Customer][google.cloud.channel.v1.Customer] resource.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: If the customer resource doesn't exist. Usually the result of an invalid name
   *       parameter.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; [Customer][google.cloud.channel.v1.Customer] resource if found,
   * error otherwise.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetCustomerRequest, Customer> getCustomerCallable() {
    return stub.getCustomerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Confirms the existence of Cloud Identity accounts, based on the domain and whether the Cloud
   * Identity accounts are owned by the reseller.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>INVALID_VALUE: Invalid domain value in the request.
   *   <li>NOT_FOUND: If there is no
   *       [CloudIdentityCustomerAccount][google.cloud.channel.v1.CloudIdentityCustomerAccount]
   *       customer for the domain specified in the request.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; List of
   * [CloudIdentityCustomerAccount][google.cloud.channel.v1.CloudIdentityCustomerAccount] resources
   * if any exist for the domain, otherwise an error is returned.
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
   * Confirms the existence of Cloud Identity accounts, based on the domain and whether the Cloud
   * Identity accounts are owned by the reseller.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>INVALID_VALUE: Invalid domain value in the request.
   *   <li>NOT_FOUND: If there is no
   *       [CloudIdentityCustomerAccount][google.cloud.channel.v1.CloudIdentityCustomerAccount]
   *       customer for the domain specified in the request.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; List of
   * [CloudIdentityCustomerAccount][google.cloud.channel.v1.CloudIdentityCustomerAccount] resources
   * if any exist for the domain, otherwise an error is returned.
   *
   * <p>Sample code:
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
   * <p>Possible Error Codes: &lt;ul&gt; &lt;li&gt;PERMISSION_DENIED: If the reseller account making
   * the request and the reseller account being queried for are different.&lt;/li&gt; &lt;li&gt;
   * INVALID_ARGUMENT: &lt;ul&gt; &lt;li&gt; Missing or invalid required parameters in the request.
   * &lt;/li&gt; &lt;li&gt; Domain field value doesn't match the domain specified in primary
   * email.&lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;/ul&gt;
   *
   * <p>Return Value: &lt;br/&gt; If successful, the newly created
   * [Customer][google.cloud.channel.v1.Customer] resource, otherwise returns an error.
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
   * <p>Possible Error Codes: &lt;ul&gt; &lt;li&gt;PERMISSION_DENIED: If the reseller account making
   * the request and the reseller account being queried for are different.&lt;/li&gt; &lt;li&gt;
   * INVALID_ARGUMENT: &lt;ul&gt; &lt;li&gt; Missing or invalid required parameters in the request.
   * &lt;/li&gt; &lt;li&gt; Domain field value doesn't match the domain specified in primary
   * email.&lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;/ul&gt;
   *
   * <p>Return Value: &lt;br/&gt; If successful, the newly created
   * [Customer][google.cloud.channel.v1.Customer] resource, otherwise returns an error.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateCustomerRequest, Customer> createCustomerCallable() {
    return stub.createCustomerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing [Customer][google.cloud.channel.v1.Customer] resource belonging to the
   * reseller or distributor.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name
   *       specified in the request.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; If successful, the updated
   * [Customer][google.cloud.channel.v1.Customer] resource, otherwise returns an error.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Customer updateCustomer(UpdateCustomerRequest request) {
    return updateCustomerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing [Customer][google.cloud.channel.v1.Customer] resource belonging to the
   * reseller or distributor.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name
   *       specified in the request.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; If successful, the updated
   * [Customer][google.cloud.channel.v1.Customer] resource, otherwise returns an error.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateCustomerRequest, Customer> updateCustomerCallable() {
    return stub.updateCustomerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the given [Customer][google.cloud.channel.v1.Customer] permanently and irreversibly.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request does not own this customer.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>FAILED_PRECONDITION: If the customer has existing entitlements.
   *   <li>NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name
   *       specified in the request.
   * </ul>
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
   * Deletes the given [Customer][google.cloud.channel.v1.Customer] permanently and irreversibly.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request does not own this customer.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>FAILED_PRECONDITION: If the customer has existing entitlements.
   *   <li>NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name
   *       specified in the request.
   * </ul>
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
   * Deletes the given [Customer][google.cloud.channel.v1.Customer] permanently and irreversibly.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request does not own this customer.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>FAILED_PRECONDITION: If the customer has existing entitlements.
   *   <li>NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name
   *       specified in the request.
   * </ul>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCustomer(DeleteCustomerRequest request) {
    deleteCustomerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the given [Customer][google.cloud.channel.v1.Customer] permanently and irreversibly.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the account making the request does not own this customer.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>FAILED_PRECONDITION: If the customer has existing entitlements.
   *   <li>NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name
   *       specified in the request.
   * </ul>
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteCustomerRequest, Empty> deleteCustomerCallable() {
    return stub.deleteCustomerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Cloud Identity for the given customer using the customer's information or the
   * information provided here, if present.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: If the customer is not found for the reseller.
   *   <li>ALREADY_EXISTS: If the customer's primary email already exists. In this case, retry after
   *       changing the customer's primary contact email.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support in this case.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support in this case.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
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
   * Creates a Cloud Identity for the given customer using the customer's information or the
   * information provided here, if present.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: If the customer is not found for the reseller.
   *   <li>ALREADY_EXISTS: If the customer's primary email already exists. In this case, retry after
   *       changing the customer's primary contact email.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support in this case.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support in this case.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final OperationCallable<ProvisionCloudIdentityRequest, Customer, OperationMetadata>
      provisionCloudIdentityOperationCallable() {
    return stub.provisionCloudIdentityOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Cloud Identity for the given customer using the customer's information or the
   * information provided here, if present.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: If the customer is not found for the reseller.
   *   <li>ALREADY_EXISTS: If the customer's primary email already exists. In this case, retry after
   *       changing the customer's primary contact email.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support in this case.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support in this case.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ProvisionCloudIdentityRequest, Operation>
      provisionCloudIdentityCallable() {
    return stub.provisionCloudIdentityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [Entitlement][google.cloud.channel.v1.Entitlement]s belonging to a customer.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; List of [Entitlement][google.cloud.channel.v1.Entitlement]s
   * belonging to the customer, or empty list if there are none.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntitlementsPagedResponse listEntitlements(ListEntitlementsRequest request) {
    return listEntitlementsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [Entitlement][google.cloud.channel.v1.Entitlement]s belonging to a customer.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; List of [Entitlement][google.cloud.channel.v1.Entitlement]s
   * belonging to the customer, or empty list if there are none.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListEntitlementsRequest, ListEntitlementsPagedResponse>
      listEntitlementsPagedCallable() {
    return stub.listEntitlementsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [Entitlement][google.cloud.channel.v1.Entitlement]s belonging to a customer.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; List of [Entitlement][google.cloud.channel.v1.Entitlement]s
   * belonging to the customer, or empty list if there are none.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsCallable() {
    return stub.listEntitlementsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [TransferableSku][google.cloud.channel.v1.TransferableSku]s of a customer based on Cloud
   * Identity ID or Customer Name in the request.
   *
   * <p>This method is used when a reseller lists the entitlements information of a customer that is
   * not owned. The reseller should provide the customer's Cloud Identity ID or Customer Name.
   *
   * <p>Possible Error Codes: &lt;ul&gt; &lt;li&gt;PERMISSION_DENIED, due to one of the following
   * reasons: &lt;ul&gt; &lt;li&gt; If the customer doesn't belong to the reseller and no auth
   * token, or an invalid auth token is supplied. &lt;/li&gt; &lt;li&gt; If the reseller account
   * making the request and the reseller account being queried for are different. &lt;/li&gt;
   * &lt;/ul&gt; &lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required parameters in
   * the request.&lt;/li&gt; &lt;/ul&gt;
   *
   * <p>Return Value: &lt;br/&gt; List of [TransferableSku][google.cloud.channel.v1.TransferableSku]
   * for the given customer.
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
   * List [TransferableSku][google.cloud.channel.v1.TransferableSku]s of a customer based on Cloud
   * Identity ID or Customer Name in the request.
   *
   * <p>This method is used when a reseller lists the entitlements information of a customer that is
   * not owned. The reseller should provide the customer's Cloud Identity ID or Customer Name.
   *
   * <p>Possible Error Codes: &lt;ul&gt; &lt;li&gt;PERMISSION_DENIED, due to one of the following
   * reasons: &lt;ul&gt; &lt;li&gt; If the customer doesn't belong to the reseller and no auth
   * token, or an invalid auth token is supplied. &lt;/li&gt; &lt;li&gt; If the reseller account
   * making the request and the reseller account being queried for are different. &lt;/li&gt;
   * &lt;/ul&gt; &lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required parameters in
   * the request.&lt;/li&gt; &lt;/ul&gt;
   *
   * <p>Return Value: &lt;br/&gt; List of [TransferableSku][google.cloud.channel.v1.TransferableSku]
   * for the given customer.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListTransferableSkusRequest, ListTransferableSkusPagedResponse>
      listTransferableSkusPagedCallable() {
    return stub.listTransferableSkusPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [TransferableSku][google.cloud.channel.v1.TransferableSku]s of a customer based on Cloud
   * Identity ID or Customer Name in the request.
   *
   * <p>This method is used when a reseller lists the entitlements information of a customer that is
   * not owned. The reseller should provide the customer's Cloud Identity ID or Customer Name.
   *
   * <p>Possible Error Codes: &lt;ul&gt; &lt;li&gt;PERMISSION_DENIED, due to one of the following
   * reasons: &lt;ul&gt; &lt;li&gt; If the customer doesn't belong to the reseller and no auth
   * token, or an invalid auth token is supplied. &lt;/li&gt; &lt;li&gt; If the reseller account
   * making the request and the reseller account being queried for are different. &lt;/li&gt;
   * &lt;/ul&gt; &lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required parameters in
   * the request.&lt;/li&gt; &lt;/ul&gt;
   *
   * <p>Return Value: &lt;br/&gt; List of [TransferableSku][google.cloud.channel.v1.TransferableSku]
   * for the given customer.
   *
   * <p>Sample code:
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
   * <p>This method is used when a reseller gets the entitlement information of a customer that is
   * not owned. The reseller should provide the customer's Cloud Identity ID or Customer Name.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED, due to one of the following reasons: (a) If the customer doesn't
   *       belong to the reseller and no auth token or invalid auth token is supplied. (b) If the
   *       reseller account making the request and the reseller account being queried for are
   *       different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Return Value: List of [TransferableOffer][google.cloud.channel.v1.TransferableOffer] for the
   * given customer and SKU.
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
   * <p>This method is used when a reseller gets the entitlement information of a customer that is
   * not owned. The reseller should provide the customer's Cloud Identity ID or Customer Name.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED, due to one of the following reasons: (a) If the customer doesn't
   *       belong to the reseller and no auth token or invalid auth token is supplied. (b) If the
   *       reseller account making the request and the reseller account being queried for are
   *       different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Return Value: List of [TransferableOffer][google.cloud.channel.v1.TransferableOffer] for the
   * given customer and SKU.
   *
   * <p>Sample code:
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
   * <p>This method is used when a reseller gets the entitlement information of a customer that is
   * not owned. The reseller should provide the customer's Cloud Identity ID or Customer Name.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED, due to one of the following reasons: (a) If the customer doesn't
   *       belong to the reseller and no auth token or invalid auth token is supplied. (b) If the
   *       reseller account making the request and the reseller account being queried for are
   *       different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Return Value: List of [TransferableOffer][google.cloud.channel.v1.TransferableOffer] for the
   * given customer and SKU.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListTransferableOffersRequest, ListTransferableOffersResponse>
      listTransferableOffersCallable() {
    return stub.listTransferableOffersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a requested [Entitlement][google.cloud.channel.v1.Entitlement] resource.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: If the entitlement is not found for the customer.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; If found, the requested
   * [Entitlement][google.cloud.channel.v1.Entitlement] resource, otherwise returns an error.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entitlement getEntitlement(GetEntitlementRequest request) {
    return getEntitlementCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a requested [Entitlement][google.cloud.channel.v1.Entitlement] resource.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: If the entitlement is not found for the customer.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; If found, the requested
   * [Entitlement][google.cloud.channel.v1.Entitlement] resource, otherwise returns an error.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetEntitlementRequest, Entitlement> getEntitlementCallable() {
    return stub.getEntitlementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entitlement for a customer.
   *
   * <p>Possible Error Codes: &lt;ul&gt; &lt;li&gt; PERMISSION_DENIED: If the customer doesn't
   * belong to the reseller. &lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: &lt;ul&gt; &lt;li&gt; Missing
   * or invalid required parameters in the request. &lt;/li&gt; &lt;li&gt; Cannot purchase an
   * entitlement if there is already an entitlement for customer, for a SKU from the same product
   * family. &lt;/li&gt; &lt;li&gt; INVALID_VALUE: Offer passed in isn't valid. Make sure OfferId is
   * valid. If it is valid, then contact Google Channel support for further troubleshooting.
   * &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;li&gt; NOT_FOUND: If the customer or offer resource is
   * not found for the reseller. &lt;/li&gt; &lt;li&gt; ALREADY_EXISTS: This failure can happen in
   * the following cases: &lt;ul&gt; &lt;li&gt;If the SKU has been already purchased for the
   * customer.&lt;/li&gt; &lt;li&gt;If the customer's primary email already exists. In this case
   * retry after changing the customer's primary contact email. &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt;
   * &lt;li&gt; CONDITION_NOT_MET or FAILED_PRECONDITION: This failure can happen in the following
   * cases: &lt;ul&gt; &lt;li&gt; Purchasing a SKU that requires domain verification and the domain
   * has not been verified. &lt;/li&gt; &lt;li&gt; Purchasing an Add-On SKU like Vault or Drive
   * without purchasing the pre-requisite SKU, such as Google Workspace Business Starter.
   * &lt;/li&gt; &lt;li&gt; Applicable only for developer accounts: reseller and resold domain. Must
   * meet the following domain naming requirements: &lt;ul&gt; &lt;li&gt; Domain names must start
   * with goog-test. &lt;/li&gt; &lt;li&gt; Resold domain names must include the reseller domain.
   * &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;li&gt; INTERNAL: Any non-user
   * error related to a technical issue in the backend. Contact Cloud Channel Support in this case.
   * &lt;/li&gt; &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the backend.
   * Contact Cloud Channel Support in this case. &lt;/li&gt; &lt;/ul&gt;
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
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
   * <p>Possible Error Codes: &lt;ul&gt; &lt;li&gt; PERMISSION_DENIED: If the customer doesn't
   * belong to the reseller. &lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: &lt;ul&gt; &lt;li&gt; Missing
   * or invalid required parameters in the request. &lt;/li&gt; &lt;li&gt; Cannot purchase an
   * entitlement if there is already an entitlement for customer, for a SKU from the same product
   * family. &lt;/li&gt; &lt;li&gt; INVALID_VALUE: Offer passed in isn't valid. Make sure OfferId is
   * valid. If it is valid, then contact Google Channel support for further troubleshooting.
   * &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;li&gt; NOT_FOUND: If the customer or offer resource is
   * not found for the reseller. &lt;/li&gt; &lt;li&gt; ALREADY_EXISTS: This failure can happen in
   * the following cases: &lt;ul&gt; &lt;li&gt;If the SKU has been already purchased for the
   * customer.&lt;/li&gt; &lt;li&gt;If the customer's primary email already exists. In this case
   * retry after changing the customer's primary contact email. &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt;
   * &lt;li&gt; CONDITION_NOT_MET or FAILED_PRECONDITION: This failure can happen in the following
   * cases: &lt;ul&gt; &lt;li&gt; Purchasing a SKU that requires domain verification and the domain
   * has not been verified. &lt;/li&gt; &lt;li&gt; Purchasing an Add-On SKU like Vault or Drive
   * without purchasing the pre-requisite SKU, such as Google Workspace Business Starter.
   * &lt;/li&gt; &lt;li&gt; Applicable only for developer accounts: reseller and resold domain. Must
   * meet the following domain naming requirements: &lt;ul&gt; &lt;li&gt; Domain names must start
   * with goog-test. &lt;/li&gt; &lt;li&gt; Resold domain names must include the reseller domain.
   * &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;li&gt; INTERNAL: Any non-user
   * error related to a technical issue in the backend. Contact Cloud Channel Support in this case.
   * &lt;/li&gt; &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the backend.
   * Contact Cloud Channel Support in this case. &lt;/li&gt; &lt;/ul&gt;
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final OperationCallable<CreateEntitlementRequest, Entitlement, OperationMetadata>
      createEntitlementOperationCallable() {
    return stub.createEntitlementOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entitlement for a customer.
   *
   * <p>Possible Error Codes: &lt;ul&gt; &lt;li&gt; PERMISSION_DENIED: If the customer doesn't
   * belong to the reseller. &lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: &lt;ul&gt; &lt;li&gt; Missing
   * or invalid required parameters in the request. &lt;/li&gt; &lt;li&gt; Cannot purchase an
   * entitlement if there is already an entitlement for customer, for a SKU from the same product
   * family. &lt;/li&gt; &lt;li&gt; INVALID_VALUE: Offer passed in isn't valid. Make sure OfferId is
   * valid. If it is valid, then contact Google Channel support for further troubleshooting.
   * &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;li&gt; NOT_FOUND: If the customer or offer resource is
   * not found for the reseller. &lt;/li&gt; &lt;li&gt; ALREADY_EXISTS: This failure can happen in
   * the following cases: &lt;ul&gt; &lt;li&gt;If the SKU has been already purchased for the
   * customer.&lt;/li&gt; &lt;li&gt;If the customer's primary email already exists. In this case
   * retry after changing the customer's primary contact email. &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt;
   * &lt;li&gt; CONDITION_NOT_MET or FAILED_PRECONDITION: This failure can happen in the following
   * cases: &lt;ul&gt; &lt;li&gt; Purchasing a SKU that requires domain verification and the domain
   * has not been verified. &lt;/li&gt; &lt;li&gt; Purchasing an Add-On SKU like Vault or Drive
   * without purchasing the pre-requisite SKU, such as Google Workspace Business Starter.
   * &lt;/li&gt; &lt;li&gt; Applicable only for developer accounts: reseller and resold domain. Must
   * meet the following domain naming requirements: &lt;ul&gt; &lt;li&gt; Domain names must start
   * with goog-test. &lt;/li&gt; &lt;li&gt; Resold domain names must include the reseller domain.
   * &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;li&gt; INTERNAL: Any non-user
   * error related to a technical issue in the backend. Contact Cloud Channel Support in this case.
   * &lt;/li&gt; &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the backend.
   * Contact Cloud Channel Support in this case. &lt;/li&gt; &lt;/ul&gt;
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateEntitlementRequest, Operation> createEntitlementCallable() {
    return stub.createEntitlementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Change parameters of the entitlement
   *
   * <p>An entitlement parameters update is a long-running operation and results in updates to the
   * entitlement as a result of fulfillment.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request. For example, if
   *       the number of seats being changed to is greater than the allowed number of max seats for
   *       the resource. Or decreasing seats for a commitment based plan.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
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
   * Change parameters of the entitlement
   *
   * <p>An entitlement parameters update is a long-running operation and results in updates to the
   * entitlement as a result of fulfillment.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request. For example, if
   *       the number of seats being changed to is greater than the allowed number of max seats for
   *       the resource. Or decreasing seats for a commitment based plan.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final OperationCallable<ChangeParametersRequest, Entitlement, OperationMetadata>
      changeParametersOperationCallable() {
    return stub.changeParametersOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Change parameters of the entitlement
   *
   * <p>An entitlement parameters update is a long-running operation and results in updates to the
   * entitlement as a result of fulfillment.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request. For example, if
   *       the number of seats being changed to is greater than the allowed number of max seats for
   *       the resource. Or decreasing seats for a commitment based plan.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ChangeParametersRequest, Operation> changeParametersCallable() {
    return stub.changeParametersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the renewal settings for an existing customer entitlement.
   *
   * <p>An entitlement update is a long-running operation and results in updates to the entitlement
   * as a result of fulfillment.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>NOT_COMMITMENT_PLAN: Renewal Settings are only applicable for a commitment plan. Can't
   *       enable or disable renewal for non-commitment plans.
   *   <li>INTERNAL: Any non user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
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
   * <p>An entitlement update is a long-running operation and results in updates to the entitlement
   * as a result of fulfillment.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>NOT_COMMITMENT_PLAN: Renewal Settings are only applicable for a commitment plan. Can't
   *       enable or disable renewal for non-commitment plans.
   *   <li>INTERNAL: Any non user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final OperationCallable<ChangeRenewalSettingsRequest, Entitlement, OperationMetadata>
      changeRenewalSettingsOperationCallable() {
    return stub.changeRenewalSettingsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the renewal settings for an existing customer entitlement.
   *
   * <p>An entitlement update is a long-running operation and results in updates to the entitlement
   * as a result of fulfillment.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>NOT_COMMITMENT_PLAN: Renewal Settings are only applicable for a commitment plan. Can't
   *       enable or disable renewal for non-commitment plans.
   *   <li>INTERNAL: Any non user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ChangeRenewalSettingsRequest, Operation>
      changeRenewalSettingsCallable() {
    return stub.changeRenewalSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Offer for an existing customer entitlement.
   *
   * <p>An entitlement update is a long-running operation and results in updates to the entitlement
   * as a result of fulfillment.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: Offer or Entitlement resource not found.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
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
   * <p>An entitlement update is a long-running operation and results in updates to the entitlement
   * as a result of fulfillment.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: Offer or Entitlement resource not found.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final OperationCallable<ChangeOfferRequest, Entitlement, OperationMetadata>
      changeOfferOperationCallable() {
    return stub.changeOfferOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Offer for an existing customer entitlement.
   *
   * <p>An entitlement update is a long-running operation and results in updates to the entitlement
   * as a result of fulfillment.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: Offer or Entitlement resource not found.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ChangeOfferRequest, Operation> changeOfferCallable() {
    return stub.changeOfferCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts paid service for a trial entitlement.
   *
   * <p>Starts paid service for a trial entitlement immediately. This method is only applicable if a
   * plan has already been set up for a trial entitlement but has some trial days remaining.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>FAILED_PRECONDITION/NOT_IN_TRIAL: This method only works for entitlement on trial plans.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
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
   * plan has already been set up for a trial entitlement but has some trial days remaining.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>FAILED_PRECONDITION/NOT_IN_TRIAL: This method only works for entitlement on trial plans.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
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
   * plan has already been set up for a trial entitlement but has some trial days remaining.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>FAILED_PRECONDITION/NOT_IN_TRIAL: This method only works for entitlement on trial plans.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<StartPaidServiceRequest, Operation> startPaidServiceCallable() {
    return stub.startPaidServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Suspends a previously fulfilled entitlement. An entitlement suspension is a long-running
   * operation.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>NOT_ACTIVE: Entitlement is not active.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
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
   * Suspends a previously fulfilled entitlement. An entitlement suspension is a long-running
   * operation.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>NOT_ACTIVE: Entitlement is not active.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final OperationCallable<SuspendEntitlementRequest, Entitlement, OperationMetadata>
      suspendEntitlementOperationCallable() {
    return stub.suspendEntitlementOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Suspends a previously fulfilled entitlement. An entitlement suspension is a long-running
   * operation.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>NOT_ACTIVE: Entitlement is not active.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SuspendEntitlementRequest, Operation> suspendEntitlementCallable() {
    return stub.suspendEntitlementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a previously fulfilled entitlement. An entitlement cancellation is a long-running
   * operation.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller or if the reseller
   *       account making the request and reseller account being queried for are different.
   *   <li>FAILED_PRECONDITION: If there are any Google Cloud projects linked to the Google Cloud
   *       entitlement's Cloud Billing subaccount.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>DELETION_TYPE_NOT_ALLOWED: Cancel is only allowed for Google Workspace add-ons or
   *       entitlements for Google Cloud's development platform.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The response will contain google.protobuf.Empty on success. The
   * Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
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
   * Cancels a previously fulfilled entitlement. An entitlement cancellation is a long-running
   * operation.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller or if the reseller
   *       account making the request and reseller account being queried for are different.
   *   <li>FAILED_PRECONDITION: If there are any Google Cloud projects linked to the Google Cloud
   *       entitlement's Cloud Billing subaccount.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>DELETION_TYPE_NOT_ALLOWED: Cancel is only allowed for Google Workspace add-ons or
   *       entitlements for Google Cloud's development platform.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The response will contain google.protobuf.Empty on success. The
   * Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final OperationCallable<CancelEntitlementRequest, Empty, OperationMetadata>
      cancelEntitlementOperationCallable() {
    return stub.cancelEntitlementOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels a previously fulfilled entitlement. An entitlement cancellation is a long-running
   * operation.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller or if the reseller
   *       account making the request and reseller account being queried for are different.
   *   <li>FAILED_PRECONDITION: If there are any Google Cloud projects linked to the Google Cloud
   *       entitlement's Cloud Billing subaccount.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>DELETION_TYPE_NOT_ALLOWED: Cancel is only allowed for Google Workspace add-ons or
   *       entitlements for Google Cloud's development platform.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The response will contain google.protobuf.Empty on success. The
   * Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CancelEntitlementRequest, Operation> cancelEntitlementCallable() {
    return stub.cancelEntitlementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a previously suspended entitlement. The entitlement must be in a suspended state for
   * it to be activated. Entitlements suspended for pending ToS acceptance can't be activated using
   * this method. An entitlement activation is a long-running operation and can result in updates to
   * the state of the customer entitlement.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller or if the reseller
   *       account making the request and reseller account being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>SUSPENSION_NOT_RESELLER_INITIATED: Can't activate an entitlement that is pending TOS
   *       acceptance. Only reseller initiated suspensions can be activated.
   *   <li>NOT_SUSPENDED: Can't activate entitlements that are already in ACTIVE state. Can only
   *       activate suspended entitlements.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
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
   * Activates a previously suspended entitlement. The entitlement must be in a suspended state for
   * it to be activated. Entitlements suspended for pending ToS acceptance can't be activated using
   * this method. An entitlement activation is a long-running operation and can result in updates to
   * the state of the customer entitlement.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller or if the reseller
   *       account making the request and reseller account being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>SUSPENSION_NOT_RESELLER_INITIATED: Can't activate an entitlement that is pending TOS
   *       acceptance. Only reseller initiated suspensions can be activated.
   *   <li>NOT_SUSPENDED: Can't activate entitlements that are already in ACTIVE state. Can only
   *       activate suspended entitlements.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final OperationCallable<ActivateEntitlementRequest, Entitlement, OperationMetadata>
      activateEntitlementOperationCallable() {
    return stub.activateEntitlementOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Activates a previously suspended entitlement. The entitlement must be in a suspended state for
   * it to be activated. Entitlements suspended for pending ToS acceptance can't be activated using
   * this method. An entitlement activation is a long-running operation and can result in updates to
   * the state of the customer entitlement.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller or if the reseller
   *       account making the request and reseller account being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: Entitlement resource not found.
   *   <li>SUSPENSION_NOT_RESELLER_INITIATED: Can't activate an entitlement that is pending TOS
   *       acceptance. Only reseller initiated suspensions can be activated.
   *   <li>NOT_SUSPENDED: Can't activate entitlements that are already in ACTIVE state. Can only
   *       activate suspended entitlements.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ActivateEntitlementRequest, Operation> activateEntitlementCallable() {
    return stub.activateEntitlementCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Transfers customer entitlements to new reseller.
   *
   * <p>Possible Error Codes: &lt;ul&gt; &lt;li&gt; PERMISSION_DENIED: If the customer doesn't
   * belong to the reseller.&lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required
   * parameters in the request. &lt;/li&gt; &lt;li&gt; NOT_FOUND: If the customer or offer resource
   * is not found for the reseller. &lt;/li&gt; &lt;li&gt; ALREADY_EXISTS: If the SKU has been
   * already transferred for the customer. &lt;/li&gt; &lt;li&gt; CONDITION_NOT_MET or
   * FAILED_PRECONDITION: This failure can happen in the following cases: &lt;ul&gt; &lt;li&gt;
   * Transferring a SKU that requires domain verification and the domain has not been verified.
   * &lt;/li&gt; &lt;li&gt; Transferring an Add-On SKU like Vault or Drive without transferring the
   * pre-requisite SKU, such as G Suite Basic &lt;/li&gt; &lt;li&gt; Applicable only for developer
   * accounts: reseller and resold domain must follow the domain naming convention as follows:
   * &lt;ul&gt; &lt;li&gt; Domain names must start with goog-test. &lt;/li&gt; &lt;li&gt; Resold
   * domain names must include the reseller domain. &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;li&gt;
   * All transferring entitlements must be specified. &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;li&gt;
   * INTERNAL: Any non-user error related to a technical issue in the backend. Please contact Cloud
   * Channel Support in this case. &lt;/li&gt; &lt;li&gt; UNKNOWN: Any non-user error related to a
   * technical issue in the backend. Please contact Cloud Channel Support in this case. &lt;/li&gt;
   * &lt;/ul&gt;
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
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
   * <p>Possible Error Codes: &lt;ul&gt; &lt;li&gt; PERMISSION_DENIED: If the customer doesn't
   * belong to the reseller.&lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required
   * parameters in the request. &lt;/li&gt; &lt;li&gt; NOT_FOUND: If the customer or offer resource
   * is not found for the reseller. &lt;/li&gt; &lt;li&gt; ALREADY_EXISTS: If the SKU has been
   * already transferred for the customer. &lt;/li&gt; &lt;li&gt; CONDITION_NOT_MET or
   * FAILED_PRECONDITION: This failure can happen in the following cases: &lt;ul&gt; &lt;li&gt;
   * Transferring a SKU that requires domain verification and the domain has not been verified.
   * &lt;/li&gt; &lt;li&gt; Transferring an Add-On SKU like Vault or Drive without transferring the
   * pre-requisite SKU, such as G Suite Basic &lt;/li&gt; &lt;li&gt; Applicable only for developer
   * accounts: reseller and resold domain must follow the domain naming convention as follows:
   * &lt;ul&gt; &lt;li&gt; Domain names must start with goog-test. &lt;/li&gt; &lt;li&gt; Resold
   * domain names must include the reseller domain. &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;li&gt;
   * All transferring entitlements must be specified. &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;li&gt;
   * INTERNAL: Any non-user error related to a technical issue in the backend. Please contact Cloud
   * Channel Support in this case. &lt;/li&gt; &lt;li&gt; UNKNOWN: Any non-user error related to a
   * technical issue in the backend. Please contact Cloud Channel Support in this case. &lt;/li&gt;
   * &lt;/ul&gt;
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
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
   * <p>Possible Error Codes: &lt;ul&gt; &lt;li&gt; PERMISSION_DENIED: If the customer doesn't
   * belong to the reseller.&lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required
   * parameters in the request. &lt;/li&gt; &lt;li&gt; NOT_FOUND: If the customer or offer resource
   * is not found for the reseller. &lt;/li&gt; &lt;li&gt; ALREADY_EXISTS: If the SKU has been
   * already transferred for the customer. &lt;/li&gt; &lt;li&gt; CONDITION_NOT_MET or
   * FAILED_PRECONDITION: This failure can happen in the following cases: &lt;ul&gt; &lt;li&gt;
   * Transferring a SKU that requires domain verification and the domain has not been verified.
   * &lt;/li&gt; &lt;li&gt; Transferring an Add-On SKU like Vault or Drive without transferring the
   * pre-requisite SKU, such as G Suite Basic &lt;/li&gt; &lt;li&gt; Applicable only for developer
   * accounts: reseller and resold domain must follow the domain naming convention as follows:
   * &lt;ul&gt; &lt;li&gt; Domain names must start with goog-test. &lt;/li&gt; &lt;li&gt; Resold
   * domain names must include the reseller domain. &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;li&gt;
   * All transferring entitlements must be specified. &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;li&gt;
   * INTERNAL: Any non-user error related to a technical issue in the backend. Please contact Cloud
   * Channel Support in this case. &lt;/li&gt; &lt;li&gt; UNKNOWN: Any non-user error related to a
   * technical issue in the backend. Please contact Cloud Channel Support in this case. &lt;/li&gt;
   * &lt;/ul&gt;
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<TransferEntitlementsRequest, Operation>
      transferEntitlementsCallable() {
    return stub.transferEntitlementsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Transfers customer entitlements from current reseller to Google.
   *
   * <p>Possible Error Codes: &lt;ul&gt; &lt;li&gt; PERMISSION_DENIED: If the customer doesn't
   * belong to the reseller. &lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required
   * parameters in the request. &lt;/li&gt; &lt;li&gt; NOT_FOUND: If the customer or offer resource
   * is not found for the reseller. &lt;/li&gt; &lt;li&gt; ALREADY_EXISTS: If the SKU has been
   * already transferred for the customer. &lt;/li&gt; &lt;li&gt; CONDITION_NOT_MET or
   * FAILED_PRECONDITION: This failure can happen in the following cases: &lt;ul&gt; &lt;li&gt;
   * Transferring a SKU that requires domain verification and the domain has not been verified.
   * &lt;/li&gt; &lt;li&gt; Transferring an Add-On SKU like Vault or Drive without purchasing the
   * pre-requisite SKU, such as G Suite Basic &lt;/li&gt; &lt;li&gt; Applicable only for developer
   * accounts: reseller and resold domain must follow the domain naming convention as follows:
   * &lt;ul&gt; &lt;li&gt; Domain names must start with goog-test. &lt;/li&gt; &lt;li&gt; Resold
   * domain names must include the reseller domain. &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;/ul&gt;
   * &lt;/li&gt; &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
   * backend. Please contact Cloud Channel Support in this case. &lt;/li&gt; &lt;li&gt; UNKNOWN: Any
   * non-user error related to a technical issue in the backend. Please contact Cloud Channel
   * Support in this case.&lt;/li&gt; &lt;/ul&gt;
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The response will contain google.protobuf.Empty on success. The
   * Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
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
   * Transfers customer entitlements from current reseller to Google.
   *
   * <p>Possible Error Codes: &lt;ul&gt; &lt;li&gt; PERMISSION_DENIED: If the customer doesn't
   * belong to the reseller. &lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required
   * parameters in the request. &lt;/li&gt; &lt;li&gt; NOT_FOUND: If the customer or offer resource
   * is not found for the reseller. &lt;/li&gt; &lt;li&gt; ALREADY_EXISTS: If the SKU has been
   * already transferred for the customer. &lt;/li&gt; &lt;li&gt; CONDITION_NOT_MET or
   * FAILED_PRECONDITION: This failure can happen in the following cases: &lt;ul&gt; &lt;li&gt;
   * Transferring a SKU that requires domain verification and the domain has not been verified.
   * &lt;/li&gt; &lt;li&gt; Transferring an Add-On SKU like Vault or Drive without purchasing the
   * pre-requisite SKU, such as G Suite Basic &lt;/li&gt; &lt;li&gt; Applicable only for developer
   * accounts: reseller and resold domain must follow the domain naming convention as follows:
   * &lt;ul&gt; &lt;li&gt; Domain names must start with goog-test. &lt;/li&gt; &lt;li&gt; Resold
   * domain names must include the reseller domain. &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;/ul&gt;
   * &lt;/li&gt; &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
   * backend. Please contact Cloud Channel Support in this case. &lt;/li&gt; &lt;li&gt; UNKNOWN: Any
   * non-user error related to a technical issue in the backend. Please contact Cloud Channel
   * Support in this case.&lt;/li&gt; &lt;/ul&gt;
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The response will contain google.protobuf.Empty on success. The
   * Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final OperationCallable<TransferEntitlementsToGoogleRequest, Empty, OperationMetadata>
      transferEntitlementsToGoogleOperationCallable() {
    return stub.transferEntitlementsToGoogleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Transfers customer entitlements from current reseller to Google.
   *
   * <p>Possible Error Codes: &lt;ul&gt; &lt;li&gt; PERMISSION_DENIED: If the customer doesn't
   * belong to the reseller. &lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required
   * parameters in the request. &lt;/li&gt; &lt;li&gt; NOT_FOUND: If the customer or offer resource
   * is not found for the reseller. &lt;/li&gt; &lt;li&gt; ALREADY_EXISTS: If the SKU has been
   * already transferred for the customer. &lt;/li&gt; &lt;li&gt; CONDITION_NOT_MET or
   * FAILED_PRECONDITION: This failure can happen in the following cases: &lt;ul&gt; &lt;li&gt;
   * Transferring a SKU that requires domain verification and the domain has not been verified.
   * &lt;/li&gt; &lt;li&gt; Transferring an Add-On SKU like Vault or Drive without purchasing the
   * pre-requisite SKU, such as G Suite Basic &lt;/li&gt; &lt;li&gt; Applicable only for developer
   * accounts: reseller and resold domain must follow the domain naming convention as follows:
   * &lt;ul&gt; &lt;li&gt; Domain names must start with goog-test. &lt;/li&gt; &lt;li&gt; Resold
   * domain names must include the reseller domain. &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;/ul&gt;
   * &lt;/li&gt; &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
   * backend. Please contact Cloud Channel Support in this case. &lt;/li&gt; &lt;li&gt; UNKNOWN: Any
   * non-user error related to a technical issue in the backend. Please contact Cloud Channel
   * Support in this case.&lt;/li&gt; &lt;/ul&gt;
   *
   * <p>Return Value: &lt;br/&gt; Long Running Operation ID.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The response will contain google.protobuf.Empty on success. The
   * Operation metadata will contain an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>Sample code:
   */
  public final UnaryCallable<TransferEntitlementsToGoogleRequest, Operation>
      transferEntitlementsToGoogleCallable() {
    return stub.transferEntitlementsToGoogleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]s belonging to a
   * distributor. To call this method, you must be a distributor.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; If successful, returns the list of
   * [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resources for the distributor
   * account, otherwise returns an error.
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
   * distributor. To call this method, you must be a distributor.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; If successful, returns the list of
   * [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resources for the distributor
   * account, otherwise returns an error.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListChannelPartnerLinksRequest, ListChannelPartnerLinksPagedResponse>
      listChannelPartnerLinksPagedCallable() {
    return stub.listChannelPartnerLinksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]s belonging to a
   * distributor. To call this method, you must be a distributor.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; If successful, returns the list of
   * [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resources for the distributor
   * account, otherwise returns an error.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListChannelPartnerLinksRequest, ListChannelPartnerLinksResponse>
      listChannelPartnerLinksCallable() {
    return stub.listChannelPartnerLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a requested [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource.
   * To call this method, you must be a distributor.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: ChannelPartnerLink resource not found. Results due invalid channel partner
   *       link name.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]
   * resource if found, otherwise returns an error.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelPartnerLink getChannelPartnerLink(GetChannelPartnerLinkRequest request) {
    return getChannelPartnerLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a requested [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource.
   * To call this method, you must be a distributor.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: ChannelPartnerLink resource not found. Results due invalid channel partner
   *       link name.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]
   * resource if found, otherwise returns an error.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetChannelPartnerLinkRequest, ChannelPartnerLink>
      getChannelPartnerLinkCallable() {
    return stub.getChannelPartnerLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates a channel partner link between a distributor and a reseller or between resellers in
   * an n-tier reseller channel. To accept the invite, the invited partner should follow the
   * invite_link_uri provided in the response. If the link creation is accepted, a valid link is set
   * up between the two involved parties. To call this method, you must be a distributor.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>ALREADY_EXISTS: If the ChannelPartnerLink sent in the request already exists.
   *   <li>NOT_FOUND: If no Cloud Identity customer exists for domain provided.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Newly created
   * [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource if successful,
   * otherwise error is returned.
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
   * Initiates a channel partner link between a distributor and a reseller or between resellers in
   * an n-tier reseller channel. To accept the invite, the invited partner should follow the
   * invite_link_uri provided in the response. If the link creation is accepted, a valid link is set
   * up between the two involved parties. To call this method, you must be a distributor.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being queried for are different.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>ALREADY_EXISTS: If the ChannelPartnerLink sent in the request already exists.
   *   <li>NOT_FOUND: If no Cloud Identity customer exists for domain provided.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: &lt;br/&gt; Newly created
   * [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource if successful,
   * otherwise error is returned.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateChannelPartnerLinkRequest, ChannelPartnerLink>
      createChannelPartnerLinkCallable() {
    return stub.createChannelPartnerLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a channel partner link. A distributor calls this method to change a link's status. For
   * example, suspend a partner link. To call this method, you must be a distributor.
   *
   * <p>Possible Error Codes: &lt;ul&gt; &lt;li&gt; PERMISSION_DENIED: If the reseller account
   * making the request and the reseller account being queried for are different. &lt;/li&gt;
   * &lt;li&gt; INVALID_ARGUMENT: &lt;ul&gt; &lt;li&gt; Missing or invalid required parameters in
   * the request. &lt;/li&gt; &lt;li&gt; Updating link state from invited to active or suspended.
   * &lt;/li&gt; &lt;li&gt; Sending reseller_cloud_identity_id, invite_url or name in update mask.
   * &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;li&gt; NOT_FOUND: ChannelPartnerLink resource not
   * found.&lt;/li&gt; &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
   * backend. In this case, contact Cloud Channel support. &lt;/li&gt; &lt;li&gt; UNKNOWN: Any
   * non-user error related to a technical issue in the backend. In this case, contact Cloud Channel
   * support.&lt;/li&gt; &lt;/ul&gt;
   *
   * <p>Return Value: &lt;br/&gt; If successful, the updated
   * [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource, otherwise returns an
   * error.
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
   * Updates a channel partner link. A distributor calls this method to change a link's status. For
   * example, suspend a partner link. To call this method, you must be a distributor.
   *
   * <p>Possible Error Codes: &lt;ul&gt; &lt;li&gt; PERMISSION_DENIED: If the reseller account
   * making the request and the reseller account being queried for are different. &lt;/li&gt;
   * &lt;li&gt; INVALID_ARGUMENT: &lt;ul&gt; &lt;li&gt; Missing or invalid required parameters in
   * the request. &lt;/li&gt; &lt;li&gt; Updating link state from invited to active or suspended.
   * &lt;/li&gt; &lt;li&gt; Sending reseller_cloud_identity_id, invite_url or name in update mask.
   * &lt;/li&gt; &lt;/ul&gt; &lt;/li&gt; &lt;li&gt; NOT_FOUND: ChannelPartnerLink resource not
   * found.&lt;/li&gt; &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
   * backend. In this case, contact Cloud Channel support. &lt;/li&gt; &lt;li&gt; UNKNOWN: Any
   * non-user error related to a technical issue in the backend. In this case, contact Cloud Channel
   * support.&lt;/li&gt; &lt;/ul&gt;
   *
   * <p>Return Value: &lt;br/&gt; If successful, the updated
   * [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource, otherwise returns an
   * error.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateChannelPartnerLinkRequest, ChannelPartnerLink>
      updateChannelPartnerLinkCallable() {
    return stub.updateChannelPartnerLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Products the reseller is authorized to sell.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
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
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListProductsRequest, ListProductsPagedResponse>
      listProductsPagedCallable() {
    return stub.listProductsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Products the reseller is authorized to sell.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable() {
    return stub.listProductsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the SKUs for a product the reseller is authorized to sell.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
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
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListSkusRequest, ListSkusPagedResponse> listSkusPagedCallable() {
    return stub.listSkusPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the SKUs for a product the reseller is authorized to sell.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListSkusRequest, ListSkusResponse> listSkusCallable() {
    return stub.listSkusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Offers the reseller can sell.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
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
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListOffersRequest, ListOffersPagedResponse> listOffersPagedCallable() {
    return stub.listOffersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Offers the reseller can sell.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListOffersRequest, ListOffersResponse> listOffersCallable() {
    return stub.listOffersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Purchasable SKUs for following cases:
   *
   * <ul>
   *   <li>SKUs that can be newly purchased for a customer
   *   <li>SKUs that can be upgraded/downgraded to, for an entitlement.
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
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
   * Lists the Purchasable SKUs for following cases:
   *
   * <ul>
   *   <li>SKUs that can be newly purchased for a customer
   *   <li>SKUs that can be upgraded/downgraded to, for an entitlement.
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListPurchasableSkusRequest, ListPurchasableSkusPagedResponse>
      listPurchasableSkusPagedCallable() {
    return stub.listPurchasableSkusPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Purchasable SKUs for following cases:
   *
   * <ul>
   *   <li>SKUs that can be newly purchased for a customer
   *   <li>SKUs that can be upgraded/downgraded to, for an entitlement.
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListPurchasableSkusRequest, ListPurchasableSkusResponse>
      listPurchasableSkusCallable() {
    return stub.listPurchasableSkusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Purchasable Offers for the following cases:
   *
   * <ul>
   *   <li>Offers that can be newly purchased for a customer
   *   <li>Offers that can be changed to, for an entitlement.
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
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
   * Lists the Purchasable Offers for the following cases:
   *
   * <ul>
   *   <li>Offers that can be newly purchased for a customer
   *   <li>Offers that can be changed to, for an entitlement.
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListPurchasableOffersRequest, ListPurchasableOffersPagedResponse>
      listPurchasableOffersPagedCallable() {
    return stub.listPurchasableOffersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Purchasable Offers for the following cases:
   *
   * <ul>
   *   <li>Offers that can be newly purchased for a customer
   *   <li>Offers that can be changed to, for an entitlement.
   * </ul>
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the customer doesn't belong to the reseller
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   * </ul>
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListPurchasableOffersRequest, ListPurchasableOffersResponse>
      listPurchasableOffersCallable() {
    return stub.listPurchasableOffersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers a service account with subscriber privileges on the Cloud Pub/Sub topic created for
   * this Channel Services account. Once you create a subscriber, you will get the events as per
   * [SubscriberEvent][google.cloud.channel.v1.SubscriberEvent]
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being provided are different, or if the impersonated user is not a super admin.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: Topic name with service email address registered if successful, otherwise
   * error is returned.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RegisterSubscriberResponse registerSubscriber(RegisterSubscriberRequest request) {
    return registerSubscriberCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers a service account with subscriber privileges on the Cloud Pub/Sub topic created for
   * this Channel Services account. Once you create a subscriber, you will get the events as per
   * [SubscriberEvent][google.cloud.channel.v1.SubscriberEvent]
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being provided are different, or if the impersonated user is not a super admin.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: Topic name with service email address registered if successful, otherwise
   * error is returned.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<RegisterSubscriberRequest, RegisterSubscriberResponse>
      registerSubscriberCallable() {
    return stub.registerSubscriberCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unregisters a service account with subscriber privileges on the Cloud Pub/Sub topic created for
   * this Channel Services account. If there are no more service account left with sunbscriber
   * privileges, the topic will be deleted. You can check this by calling ListSubscribers api.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being provided are different, or if the impersonated user is not a super admin.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: If the topic resource doesn't exist.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: Topic name from which service email address has been unregistered if
   * successful, otherwise error is returned. If the service email was already not associated with
   * the topic, the success response will be returned.
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
   * this Channel Services account. If there are no more service account left with sunbscriber
   * privileges, the topic will be deleted. You can check this by calling ListSubscribers api.
   *
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being provided are different, or if the impersonated user is not a super admin.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: If the topic resource doesn't exist.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: Topic name from which service email address has been unregistered if
   * successful, otherwise error is returned. If the service email was already not associated with
   * the topic, the success response will be returned.
   *
   * <p>Sample code:
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
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being provided are different, or if the account is not a super admin.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: If the topic resource doesn't exist.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: List of service email addresses if successful, otherwise error is returned.
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
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being provided are different, or if the account is not a super admin.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: If the topic resource doesn't exist.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: List of service email addresses if successful, otherwise error is returned.
   *
   * <p>Sample code:
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
   * <p>Possible Error Codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: If the reseller account making the request and the reseller account
   *       being provided are different, or if the account is not a super admin.
   *   <li>INVALID_ARGUMENT: Missing or invalid required parameters in the request.
   *   <li>NOT_FOUND: If the topic resource doesn't exist.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. In this case,
   *       contact Cloud Channel support.
   * </ul>
   *
   * <p>Return Value: List of service email addresses if successful, otherwise error is returned.
   *
   * <p>Sample code:
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
          new ApiFunction<ListCustomersPage, ListCustomersPagedResponse>() {
            @Override
            public ListCustomersPagedResponse apply(ListCustomersPage input) {
              return new ListCustomersPagedResponse(input);
            }
          },
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
          new ApiFunction<ListEntitlementsPage, ListEntitlementsPagedResponse>() {
            @Override
            public ListEntitlementsPagedResponse apply(ListEntitlementsPage input) {
              return new ListEntitlementsPagedResponse(input);
            }
          },
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
          new ApiFunction<ListTransferableSkusPage, ListTransferableSkusPagedResponse>() {
            @Override
            public ListTransferableSkusPagedResponse apply(ListTransferableSkusPage input) {
              return new ListTransferableSkusPagedResponse(input);
            }
          },
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
          new ApiFunction<ListTransferableOffersPage, ListTransferableOffersPagedResponse>() {
            @Override
            public ListTransferableOffersPagedResponse apply(ListTransferableOffersPage input) {
              return new ListTransferableOffersPagedResponse(input);
            }
          },
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
          new ApiFunction<ListChannelPartnerLinksPage, ListChannelPartnerLinksPagedResponse>() {
            @Override
            public ListChannelPartnerLinksPagedResponse apply(ListChannelPartnerLinksPage input) {
              return new ListChannelPartnerLinksPagedResponse(input);
            }
          },
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
          new ApiFunction<ListProductsPage, ListProductsPagedResponse>() {
            @Override
            public ListProductsPagedResponse apply(ListProductsPage input) {
              return new ListProductsPagedResponse(input);
            }
          },
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
          futurePage,
          new ApiFunction<ListSkusPage, ListSkusPagedResponse>() {
            @Override
            public ListSkusPagedResponse apply(ListSkusPage input) {
              return new ListSkusPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
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
          futurePage,
          new ApiFunction<ListOffersPage, ListOffersPagedResponse>() {
            @Override
            public ListOffersPagedResponse apply(ListOffersPage input) {
              return new ListOffersPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
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
          new ApiFunction<ListPurchasableSkusPage, ListPurchasableSkusPagedResponse>() {
            @Override
            public ListPurchasableSkusPagedResponse apply(ListPurchasableSkusPage input) {
              return new ListPurchasableSkusPagedResponse(input);
            }
          },
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
          new ApiFunction<ListPurchasableOffersPage, ListPurchasableOffersPagedResponse>() {
            @Override
            public ListPurchasableOffersPagedResponse apply(ListPurchasableOffersPage input) {
              return new ListPurchasableOffersPagedResponse(input);
            }
          },
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
          new ApiFunction<ListSubscribersPage, ListSubscribersPagedResponse>() {
            @Override
            public ListSubscribersPagedResponse apply(ListSubscribersPage input) {
              return new ListSubscribersPagedResponse(input);
            }
          },
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
