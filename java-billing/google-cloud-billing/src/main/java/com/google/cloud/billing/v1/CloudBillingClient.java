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

package com.google.cloud.billing.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.billing.v1.stub.CloudBillingStub;
import com.google.cloud.billing.v1.stub.CloudBillingStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Retrieves GCP Console billing accounts and associates them with projects.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the CloudBillingClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of CloudBillingSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * CloudBillingSettings cloudBillingSettings =
 *     CloudBillingSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudBillingClient cloudBillingClient = CloudBillingClient.create(cloudBillingSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * CloudBillingSettings cloudBillingSettings =
 *     CloudBillingSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudBillingClient cloudBillingClient = CloudBillingClient.create(cloudBillingSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class CloudBillingClient implements BackgroundResource {
  private final CloudBillingSettings settings;
  private final CloudBillingStub stub;

  /** Constructs an instance of CloudBillingClient with default settings. */
  public static final CloudBillingClient create() throws IOException {
    return create(CloudBillingSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudBillingClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CloudBillingClient create(CloudBillingSettings settings) throws IOException {
    return new CloudBillingClient(settings);
  }

  /**
   * Constructs an instance of CloudBillingClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(CloudBillingSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final CloudBillingClient create(CloudBillingStub stub) {
    return new CloudBillingClient(stub);
  }

  /**
   * Constructs an instance of CloudBillingClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CloudBillingClient(CloudBillingSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CloudBillingStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected CloudBillingClient(CloudBillingStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CloudBillingSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public CloudBillingStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a billing account. The current authenticated user must be a [viewer of
   * the billing account](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * @param name Required. The resource name of the billing account to retrieve. For example,
   *     `billingAccounts/012345-567890-ABCDEF`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BillingAccount getBillingAccount(BillingAccountName name) {
    GetBillingAccountRequest request =
        GetBillingAccountRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getBillingAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a billing account. The current authenticated user must be a [viewer of
   * the billing account](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * @param name Required. The resource name of the billing account to retrieve. For example,
   *     `billingAccounts/012345-567890-ABCDEF`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BillingAccount getBillingAccount(String name) {
    GetBillingAccountRequest request = GetBillingAccountRequest.newBuilder().setName(name).build();
    return getBillingAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a billing account. The current authenticated user must be a [viewer of
   * the billing account](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BillingAccount getBillingAccount(GetBillingAccountRequest request) {
    return getBillingAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a billing account. The current authenticated user must be a [viewer of
   * the billing account](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetBillingAccountRequest, BillingAccount> getBillingAccountCallable() {
    return stub.getBillingAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the billing accounts that the current authenticated user has permission to
   * [view](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBillingAccountsPagedResponse listBillingAccounts() {
    ListBillingAccountsRequest request = ListBillingAccountsRequest.newBuilder().build();
    return listBillingAccounts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the billing accounts that the current authenticated user has permission to
   * [view](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBillingAccountsPagedResponse listBillingAccounts(
      ListBillingAccountsRequest request) {
    return listBillingAccountsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the billing accounts that the current authenticated user has permission to
   * [view](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListBillingAccountsRequest, ListBillingAccountsPagedResponse>
      listBillingAccountsPagedCallable() {
    return stub.listBillingAccountsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the billing accounts that the current authenticated user has permission to
   * [view](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListBillingAccountsRequest, ListBillingAccountsResponse>
      listBillingAccountsCallable() {
    return stub.listBillingAccountsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a billing account's fields. Currently the only field that can be edited is
   * `display_name`. The current authenticated user must have the `billing.accounts.update` IAM
   * permission, which is typically given to the
   * [administrator](https://cloud.google.com/billing/docs/how-to/billing-access) of the billing
   * account.
   *
   * @param name Required. The name of the billing account resource to be updated.
   * @param account Required. The billing account resource to replace the resource on the server.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BillingAccount updateBillingAccount(
      BillingAccountName name, BillingAccount account) {
    UpdateBillingAccountRequest request =
        UpdateBillingAccountRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setAccount(account)
            .build();
    return updateBillingAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a billing account's fields. Currently the only field that can be edited is
   * `display_name`. The current authenticated user must have the `billing.accounts.update` IAM
   * permission, which is typically given to the
   * [administrator](https://cloud.google.com/billing/docs/how-to/billing-access) of the billing
   * account.
   *
   * @param name Required. The name of the billing account resource to be updated.
   * @param account Required. The billing account resource to replace the resource on the server.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BillingAccount updateBillingAccount(String name, BillingAccount account) {
    UpdateBillingAccountRequest request =
        UpdateBillingAccountRequest.newBuilder().setName(name).setAccount(account).build();
    return updateBillingAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a billing account's fields. Currently the only field that can be edited is
   * `display_name`. The current authenticated user must have the `billing.accounts.update` IAM
   * permission, which is typically given to the
   * [administrator](https://cloud.google.com/billing/docs/how-to/billing-access) of the billing
   * account.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BillingAccount updateBillingAccount(UpdateBillingAccountRequest request) {
    return updateBillingAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a billing account's fields. Currently the only field that can be edited is
   * `display_name`. The current authenticated user must have the `billing.accounts.update` IAM
   * permission, which is typically given to the
   * [administrator](https://cloud.google.com/billing/docs/how-to/billing-access) of the billing
   * account.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateBillingAccountRequest, BillingAccount>
      updateBillingAccountCallable() {
    return stub.updateBillingAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a billing account. This method can only be used to create [billing
   * subaccounts](https://cloud.google.com/billing/docs/concepts) by GCP resellers. When creating a
   * subaccount, the current authenticated user must have the `billing.accounts.update` IAM
   * permission on the master account, which is typically given to billing account
   * [administrators](https://cloud.google.com/billing/docs/how-to/billing-access). This method will
   * return an error if the master account has not been provisioned as a reseller account.
   *
   * @param billingAccount Required. The billing account resource to create. Currently
   *     CreateBillingAccount only supports subaccount creation, so any created billing accounts
   *     must be under a provided master billing account.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BillingAccount createBillingAccount(BillingAccount billingAccount) {
    CreateBillingAccountRequest request =
        CreateBillingAccountRequest.newBuilder().setBillingAccount(billingAccount).build();
    return createBillingAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a billing account. This method can only be used to create [billing
   * subaccounts](https://cloud.google.com/billing/docs/concepts) by GCP resellers. When creating a
   * subaccount, the current authenticated user must have the `billing.accounts.update` IAM
   * permission on the master account, which is typically given to billing account
   * [administrators](https://cloud.google.com/billing/docs/how-to/billing-access). This method will
   * return an error if the master account has not been provisioned as a reseller account.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BillingAccount createBillingAccount(CreateBillingAccountRequest request) {
    return createBillingAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a billing account. This method can only be used to create [billing
   * subaccounts](https://cloud.google.com/billing/docs/concepts) by GCP resellers. When creating a
   * subaccount, the current authenticated user must have the `billing.accounts.update` IAM
   * permission on the master account, which is typically given to billing account
   * [administrators](https://cloud.google.com/billing/docs/how-to/billing-access). This method will
   * return an error if the master account has not been provisioned as a reseller account.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateBillingAccountRequest, BillingAccount>
      createBillingAccountCallable() {
    return stub.createBillingAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the projects associated with a billing account. The current authenticated user must have
   * the `billing.resourceAssociations.list` IAM permission, which is often given to billing account
   * [viewers](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * @param name Required. The resource name of the billing account associated with the projects
   *     that you want to list. For example, `billingAccounts/012345-567890-ABCDEF`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProjectBillingInfoPagedResponse listProjectBillingInfo(BillingAccountName name) {
    ListProjectBillingInfoRequest request =
        ListProjectBillingInfoRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listProjectBillingInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the projects associated with a billing account. The current authenticated user must have
   * the `billing.resourceAssociations.list` IAM permission, which is often given to billing account
   * [viewers](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * @param name Required. The resource name of the billing account associated with the projects
   *     that you want to list. For example, `billingAccounts/012345-567890-ABCDEF`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProjectBillingInfoPagedResponse listProjectBillingInfo(String name) {
    ListProjectBillingInfoRequest request =
        ListProjectBillingInfoRequest.newBuilder().setName(name).build();
    return listProjectBillingInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the projects associated with a billing account. The current authenticated user must have
   * the `billing.resourceAssociations.list` IAM permission, which is often given to billing account
   * [viewers](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProjectBillingInfoPagedResponse listProjectBillingInfo(
      ListProjectBillingInfoRequest request) {
    return listProjectBillingInfoPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the projects associated with a billing account. The current authenticated user must have
   * the `billing.resourceAssociations.list` IAM permission, which is often given to billing account
   * [viewers](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListProjectBillingInfoRequest, ListProjectBillingInfoPagedResponse>
      listProjectBillingInfoPagedCallable() {
    return stub.listProjectBillingInfoPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the projects associated with a billing account. The current authenticated user must have
   * the `billing.resourceAssociations.list` IAM permission, which is often given to billing account
   * [viewers](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListProjectBillingInfoRequest, ListProjectBillingInfoResponse>
      listProjectBillingInfoCallable() {
    return stub.listProjectBillingInfoCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the billing information for a project. The current authenticated user must have
   * [permission to view the
   * project](https://cloud.google.com/docs/permissions-overview#h.bgs0oxofvnoo ).
   *
   * @param name Required. The resource name of the project for which billing information is
   *     retrieved. For example, `projects/tokyo-rain-123`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProjectBillingInfo getProjectBillingInfo(String name) {
    GetProjectBillingInfoRequest request =
        GetProjectBillingInfoRequest.newBuilder().setName(name).build();
    return getProjectBillingInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the billing information for a project. The current authenticated user must have
   * [permission to view the
   * project](https://cloud.google.com/docs/permissions-overview#h.bgs0oxofvnoo ).
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProjectBillingInfo getProjectBillingInfo(GetProjectBillingInfoRequest request) {
    return getProjectBillingInfoCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the billing information for a project. The current authenticated user must have
   * [permission to view the
   * project](https://cloud.google.com/docs/permissions-overview#h.bgs0oxofvnoo ).
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetProjectBillingInfoRequest, ProjectBillingInfo>
      getProjectBillingInfoCallable() {
    return stub.getProjectBillingInfoCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets or updates the billing account associated with a project. You specify the new billing
   * account by setting the `billing_account_name` in the `ProjectBillingInfo` resource to the
   * resource name of a billing account. Associating a project with an open billing account enables
   * billing on the project and allows charges for resource usage. If the project already had a
   * billing account, this method changes the billing account used for resource usage charges.
   *
   * <p>&#42;Note:&#42; Incurred charges that have not yet been reported in the transaction history
   * of the GCP Console might be billed to the new billing account, even if the charge occurred
   * before the new billing account was assigned to the project.
   *
   * <p>The current authenticated user must have ownership privileges for both the
   * [project](https://cloud.google.com/docs/permissions-overview#h.bgs0oxofvnoo ) and the [billing
   * account](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * <p>You can disable billing on the project by setting the `billing_account_name` field to empty.
   * This action disassociates the current billing account from the project. Any billable activity
   * of your in-use services will stop, and your application could stop functioning as expected. Any
   * unbilled charges to date will be billed to the previously associated account. The current
   * authenticated user must be either an owner of the project or an owner of the billing account
   * for the project.
   *
   * <p>Note that associating a project with a &#42;closed&#42; billing account will have much the
   * same effect as disabling billing on the project: any paid resources used by the project will be
   * shut down. Thus, unless you wish to disable billing, you should always call this method with
   * the name of an
   *
   * <ul>
   *   <li>open&#42; billing account.
   * </ul>
   *
   * @param name Required. The resource name of the project associated with the billing information
   *     that you want to update. For example, `projects/tokyo-rain-123`.
   * @param projectBillingInfo The new billing information for the project. Read-only fields are
   *     ignored; thus, you can leave empty all fields except `billing_account_name`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProjectBillingInfo updateProjectBillingInfo(
      String name, ProjectBillingInfo projectBillingInfo) {
    UpdateProjectBillingInfoRequest request =
        UpdateProjectBillingInfoRequest.newBuilder()
            .setName(name)
            .setProjectBillingInfo(projectBillingInfo)
            .build();
    return updateProjectBillingInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets or updates the billing account associated with a project. You specify the new billing
   * account by setting the `billing_account_name` in the `ProjectBillingInfo` resource to the
   * resource name of a billing account. Associating a project with an open billing account enables
   * billing on the project and allows charges for resource usage. If the project already had a
   * billing account, this method changes the billing account used for resource usage charges.
   *
   * <p>&#42;Note:&#42; Incurred charges that have not yet been reported in the transaction history
   * of the GCP Console might be billed to the new billing account, even if the charge occurred
   * before the new billing account was assigned to the project.
   *
   * <p>The current authenticated user must have ownership privileges for both the
   * [project](https://cloud.google.com/docs/permissions-overview#h.bgs0oxofvnoo ) and the [billing
   * account](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * <p>You can disable billing on the project by setting the `billing_account_name` field to empty.
   * This action disassociates the current billing account from the project. Any billable activity
   * of your in-use services will stop, and your application could stop functioning as expected. Any
   * unbilled charges to date will be billed to the previously associated account. The current
   * authenticated user must be either an owner of the project or an owner of the billing account
   * for the project.
   *
   * <p>Note that associating a project with a &#42;closed&#42; billing account will have much the
   * same effect as disabling billing on the project: any paid resources used by the project will be
   * shut down. Thus, unless you wish to disable billing, you should always call this method with
   * the name of an
   *
   * <ul>
   *   <li>open&#42; billing account.
   * </ul>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProjectBillingInfo updateProjectBillingInfo(
      UpdateProjectBillingInfoRequest request) {
    return updateProjectBillingInfoCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets or updates the billing account associated with a project. You specify the new billing
   * account by setting the `billing_account_name` in the `ProjectBillingInfo` resource to the
   * resource name of a billing account. Associating a project with an open billing account enables
   * billing on the project and allows charges for resource usage. If the project already had a
   * billing account, this method changes the billing account used for resource usage charges.
   *
   * <p>&#42;Note:&#42; Incurred charges that have not yet been reported in the transaction history
   * of the GCP Console might be billed to the new billing account, even if the charge occurred
   * before the new billing account was assigned to the project.
   *
   * <p>The current authenticated user must have ownership privileges for both the
   * [project](https://cloud.google.com/docs/permissions-overview#h.bgs0oxofvnoo ) and the [billing
   * account](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * <p>You can disable billing on the project by setting the `billing_account_name` field to empty.
   * This action disassociates the current billing account from the project. Any billable activity
   * of your in-use services will stop, and your application could stop functioning as expected. Any
   * unbilled charges to date will be billed to the previously associated account. The current
   * authenticated user must be either an owner of the project or an owner of the billing account
   * for the project.
   *
   * <p>Note that associating a project with a &#42;closed&#42; billing account will have much the
   * same effect as disabling billing on the project: any paid resources used by the project will be
   * shut down. Thus, unless you wish to disable billing, you should always call this method with
   * the name of an
   *
   * <ul>
   *   <li>open&#42; billing account.
   * </ul>
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateProjectBillingInfoRequest, ProjectBillingInfo>
      updateProjectBillingInfoCallable() {
    return stub.updateProjectBillingInfoCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a billing account. The caller must have the
   * `billing.accounts.getIamPolicy` permission on the account, which is often given to billing
   * account [viewers](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(ResourceName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a billing account. The caller must have the
   * `billing.accounts.getIamPolicy` permission on the account, which is often given to billing
   * account [viewers](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a billing account. The caller must have the
   * `billing.accounts.getIamPolicy` permission on the account, which is often given to billing
   * account [viewers](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a billing account. The caller must have the
   * `billing.accounts.getIamPolicy` permission on the account, which is often given to billing
   * account [viewers](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy for a billing account. Replaces any existing policy. The caller
   * must have the `billing.accounts.setIamPolicy` permission on the account, which is often given
   * to billing account
   * [administrators](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(ResourceName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy for a billing account. Replaces any existing policy. The caller
   * must have the `billing.accounts.setIamPolicy` permission on the account, which is often given
   * to billing account
   * [administrators](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy for a billing account. Replaces any existing policy. The caller
   * must have the `billing.accounts.setIamPolicy` permission on the account, which is often given
   * to billing account
   * [administrators](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy for a billing account. Replaces any existing policy. The caller
   * must have the `billing.accounts.setIamPolicy` permission on the account, which is often given
   * to billing account
   * [administrators](https://cloud.google.com/billing/docs/how-to/billing-access).
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests the access control policy for a billing account. This method takes the resource and a set
   * of permissions as input and returns the subset of the input permissions that the caller is
   * allowed for that resource.
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      ResourceName resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests the access control policy for a billing account. This method takes the resource and a set
   * of permissions as input and returns the subset of the input permissions that the caller is
   * allowed for that resource.
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests the access control policy for a billing account. This method takes the resource and a set
   * of permissions as input and returns the subset of the input permissions that the caller is
   * allowed for that resource.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tests the access control policy for a billing account. This method takes the resource and a set
   * of permissions as input and returns the subset of the input permissions that the caller is
   * allowed for that resource.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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

  public static class ListBillingAccountsPagedResponse
      extends AbstractPagedListResponse<
          ListBillingAccountsRequest,
          ListBillingAccountsResponse,
          BillingAccount,
          ListBillingAccountsPage,
          ListBillingAccountsFixedSizeCollection> {

    public static ApiFuture<ListBillingAccountsPagedResponse> createAsync(
        PageContext<ListBillingAccountsRequest, ListBillingAccountsResponse, BillingAccount>
            context,
        ApiFuture<ListBillingAccountsResponse> futureResponse) {
      ApiFuture<ListBillingAccountsPage> futurePage =
          ListBillingAccountsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListBillingAccountsPage, ListBillingAccountsPagedResponse>() {
            @Override
            public ListBillingAccountsPagedResponse apply(ListBillingAccountsPage input) {
              return new ListBillingAccountsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListBillingAccountsPagedResponse(ListBillingAccountsPage page) {
      super(page, ListBillingAccountsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBillingAccountsPage
      extends AbstractPage<
          ListBillingAccountsRequest,
          ListBillingAccountsResponse,
          BillingAccount,
          ListBillingAccountsPage> {

    private ListBillingAccountsPage(
        PageContext<ListBillingAccountsRequest, ListBillingAccountsResponse, BillingAccount>
            context,
        ListBillingAccountsResponse response) {
      super(context, response);
    }

    private static ListBillingAccountsPage createEmptyPage() {
      return new ListBillingAccountsPage(null, null);
    }

    @Override
    protected ListBillingAccountsPage createPage(
        PageContext<ListBillingAccountsRequest, ListBillingAccountsResponse, BillingAccount>
            context,
        ListBillingAccountsResponse response) {
      return new ListBillingAccountsPage(context, response);
    }

    @Override
    public ApiFuture<ListBillingAccountsPage> createPageAsync(
        PageContext<ListBillingAccountsRequest, ListBillingAccountsResponse, BillingAccount>
            context,
        ApiFuture<ListBillingAccountsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBillingAccountsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBillingAccountsRequest,
          ListBillingAccountsResponse,
          BillingAccount,
          ListBillingAccountsPage,
          ListBillingAccountsFixedSizeCollection> {

    private ListBillingAccountsFixedSizeCollection(
        List<ListBillingAccountsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBillingAccountsFixedSizeCollection createEmptyCollection() {
      return new ListBillingAccountsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBillingAccountsFixedSizeCollection createCollection(
        List<ListBillingAccountsPage> pages, int collectionSize) {
      return new ListBillingAccountsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListProjectBillingInfoPagedResponse
      extends AbstractPagedListResponse<
          ListProjectBillingInfoRequest,
          ListProjectBillingInfoResponse,
          ProjectBillingInfo,
          ListProjectBillingInfoPage,
          ListProjectBillingInfoFixedSizeCollection> {

    public static ApiFuture<ListProjectBillingInfoPagedResponse> createAsync(
        PageContext<
                ListProjectBillingInfoRequest, ListProjectBillingInfoResponse, ProjectBillingInfo>
            context,
        ApiFuture<ListProjectBillingInfoResponse> futureResponse) {
      ApiFuture<ListProjectBillingInfoPage> futurePage =
          ListProjectBillingInfoPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListProjectBillingInfoPage, ListProjectBillingInfoPagedResponse>() {
            @Override
            public ListProjectBillingInfoPagedResponse apply(ListProjectBillingInfoPage input) {
              return new ListProjectBillingInfoPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListProjectBillingInfoPagedResponse(ListProjectBillingInfoPage page) {
      super(page, ListProjectBillingInfoFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProjectBillingInfoPage
      extends AbstractPage<
          ListProjectBillingInfoRequest,
          ListProjectBillingInfoResponse,
          ProjectBillingInfo,
          ListProjectBillingInfoPage> {

    private ListProjectBillingInfoPage(
        PageContext<
                ListProjectBillingInfoRequest, ListProjectBillingInfoResponse, ProjectBillingInfo>
            context,
        ListProjectBillingInfoResponse response) {
      super(context, response);
    }

    private static ListProjectBillingInfoPage createEmptyPage() {
      return new ListProjectBillingInfoPage(null, null);
    }

    @Override
    protected ListProjectBillingInfoPage createPage(
        PageContext<
                ListProjectBillingInfoRequest, ListProjectBillingInfoResponse, ProjectBillingInfo>
            context,
        ListProjectBillingInfoResponse response) {
      return new ListProjectBillingInfoPage(context, response);
    }

    @Override
    public ApiFuture<ListProjectBillingInfoPage> createPageAsync(
        PageContext<
                ListProjectBillingInfoRequest, ListProjectBillingInfoResponse, ProjectBillingInfo>
            context,
        ApiFuture<ListProjectBillingInfoResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProjectBillingInfoFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProjectBillingInfoRequest,
          ListProjectBillingInfoResponse,
          ProjectBillingInfo,
          ListProjectBillingInfoPage,
          ListProjectBillingInfoFixedSizeCollection> {

    private ListProjectBillingInfoFixedSizeCollection(
        List<ListProjectBillingInfoPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProjectBillingInfoFixedSizeCollection createEmptyCollection() {
      return new ListProjectBillingInfoFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProjectBillingInfoFixedSizeCollection createCollection(
        List<ListProjectBillingInfoPage> pages, int collectionSize) {
      return new ListProjectBillingInfoFixedSizeCollection(pages, collectionSize);
    }
  }
}
