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

package com.google.cloud.billing.budgets.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.billing.budgets.v1.stub.BudgetServiceStub;
import com.google.cloud.billing.budgets.v1.stub.BudgetServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: BudgetService stores Cloud Billing budgets, which define a budget plan and
 * rules to execute as we track spend against that plan.
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
 * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
 *   BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
 *   Budget budget = Budget.newBuilder().build();
 *   Budget response = budgetServiceClient.createBudget(parent, budget);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BudgetServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of BudgetServiceSettings to
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
 * BudgetServiceSettings budgetServiceSettings =
 *     BudgetServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BudgetServiceClient budgetServiceClient = BudgetServiceClient.create(budgetServiceSettings);
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
 * BudgetServiceSettings budgetServiceSettings =
 *     BudgetServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BudgetServiceClient budgetServiceClient = BudgetServiceClient.create(budgetServiceSettings);
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
 * BudgetServiceSettings budgetServiceSettings =
 *     BudgetServiceSettings.newHttpJsonBuilder().build();
 * BudgetServiceClient budgetServiceClient = BudgetServiceClient.create(budgetServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class BudgetServiceClient implements BackgroundResource {
  private final BudgetServiceSettings settings;
  private final BudgetServiceStub stub;

  /** Constructs an instance of BudgetServiceClient with default settings. */
  public static final BudgetServiceClient create() throws IOException {
    return create(BudgetServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BudgetServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BudgetServiceClient create(BudgetServiceSettings settings)
      throws IOException {
    return new BudgetServiceClient(settings);
  }

  /**
   * Constructs an instance of BudgetServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(BudgetServiceSettings).
   */
  public static final BudgetServiceClient create(BudgetServiceStub stub) {
    return new BudgetServiceClient(stub);
  }

  /**
   * Constructs an instance of BudgetServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected BudgetServiceClient(BudgetServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BudgetServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected BudgetServiceClient(BudgetServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BudgetServiceSettings getSettings() {
    return settings;
  }

  public BudgetServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new budget. See [Quotas and limits](https://cloud.google.com/billing/quotas) for more
   * information on the limits of the number of budgets you can create.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
   *   Budget budget = Budget.newBuilder().build();
   *   Budget response = budgetServiceClient.createBudget(parent, budget);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the billing account to create the budget in. Values are of
   *     the form `billingAccounts/{billingAccountId}`.
   * @param budget Required. Budget to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Budget createBudget(BillingAccountName parent, Budget budget) {
    CreateBudgetRequest request =
        CreateBudgetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBudget(budget)
            .build();
    return createBudget(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new budget. See [Quotas and limits](https://cloud.google.com/billing/quotas) for more
   * information on the limits of the number of budgets you can create.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   String parent = BillingAccountName.of("[BILLING_ACCOUNT]").toString();
   *   Budget budget = Budget.newBuilder().build();
   *   Budget response = budgetServiceClient.createBudget(parent, budget);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the billing account to create the budget in. Values are of
   *     the form `billingAccounts/{billingAccountId}`.
   * @param budget Required. Budget to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Budget createBudget(String parent, Budget budget) {
    CreateBudgetRequest request =
        CreateBudgetRequest.newBuilder().setParent(parent).setBudget(budget).build();
    return createBudget(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new budget. See [Quotas and limits](https://cloud.google.com/billing/quotas) for more
   * information on the limits of the number of budgets you can create.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   CreateBudgetRequest request =
   *       CreateBudgetRequest.newBuilder()
   *           .setParent(BillingAccountName.of("[BILLING_ACCOUNT]").toString())
   *           .setBudget(Budget.newBuilder().build())
   *           .build();
   *   Budget response = budgetServiceClient.createBudget(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Budget createBudget(CreateBudgetRequest request) {
    return createBudgetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new budget. See [Quotas and limits](https://cloud.google.com/billing/quotas) for more
   * information on the limits of the number of budgets you can create.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   CreateBudgetRequest request =
   *       CreateBudgetRequest.newBuilder()
   *           .setParent(BillingAccountName.of("[BILLING_ACCOUNT]").toString())
   *           .setBudget(Budget.newBuilder().build())
   *           .build();
   *   ApiFuture<Budget> future = budgetServiceClient.createBudgetCallable().futureCall(request);
   *   // Do something.
   *   Budget response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBudgetRequest, Budget> createBudgetCallable() {
    return stub.createBudgetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a budget and returns the updated budget.
   *
   * <p>WARNING: There are some fields exposed on the Google Cloud Console that aren't available on
   * this API. Budget fields that are not exposed in this API will not be changed by this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   Budget budget = Budget.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Budget response = budgetServiceClient.updateBudget(budget, updateMask);
   * }
   * }</pre>
   *
   * @param budget Required. The updated budget object. The budget to update is specified by the
   *     budget name in the budget.
   * @param updateMask Optional. Indicates which fields in the provided budget to update. Read-only
   *     fields (such as `name`) cannot be changed. If this is not provided, then only fields with
   *     non-default values from the request are updated. See
   *     https://developers.google.com/protocol-buffers/docs/proto3#default for more details about
   *     default values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Budget updateBudget(Budget budget, FieldMask updateMask) {
    UpdateBudgetRequest request =
        UpdateBudgetRequest.newBuilder().setBudget(budget).setUpdateMask(updateMask).build();
    return updateBudget(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a budget and returns the updated budget.
   *
   * <p>WARNING: There are some fields exposed on the Google Cloud Console that aren't available on
   * this API. Budget fields that are not exposed in this API will not be changed by this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   UpdateBudgetRequest request =
   *       UpdateBudgetRequest.newBuilder()
   *           .setBudget(Budget.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Budget response = budgetServiceClient.updateBudget(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Budget updateBudget(UpdateBudgetRequest request) {
    return updateBudgetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a budget and returns the updated budget.
   *
   * <p>WARNING: There are some fields exposed on the Google Cloud Console that aren't available on
   * this API. Budget fields that are not exposed in this API will not be changed by this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   UpdateBudgetRequest request =
   *       UpdateBudgetRequest.newBuilder()
   *           .setBudget(Budget.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Budget> future = budgetServiceClient.updateBudgetCallable().futureCall(request);
   *   // Do something.
   *   Budget response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBudgetRequest, Budget> updateBudgetCallable() {
    return stub.updateBudgetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a budget.
   *
   * <p>WARNING: There are some fields exposed on the Google Cloud Console that aren't available on
   * this API. When reading from the API, you will not see these fields in the return value, though
   * they may have been set in the Cloud Console.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   BudgetName name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");
   *   Budget response = budgetServiceClient.getBudget(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of budget to get. Values are of the form
   *     `billingAccounts/{billingAccountId}/budgets/{budgetId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Budget getBudget(BudgetName name) {
    GetBudgetRequest request =
        GetBudgetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBudget(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a budget.
   *
   * <p>WARNING: There are some fields exposed on the Google Cloud Console that aren't available on
   * this API. When reading from the API, you will not see these fields in the return value, though
   * they may have been set in the Cloud Console.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   String name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]").toString();
   *   Budget response = budgetServiceClient.getBudget(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of budget to get. Values are of the form
   *     `billingAccounts/{billingAccountId}/budgets/{budgetId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Budget getBudget(String name) {
    GetBudgetRequest request = GetBudgetRequest.newBuilder().setName(name).build();
    return getBudget(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a budget.
   *
   * <p>WARNING: There are some fields exposed on the Google Cloud Console that aren't available on
   * this API. When reading from the API, you will not see these fields in the return value, though
   * they may have been set in the Cloud Console.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   GetBudgetRequest request =
   *       GetBudgetRequest.newBuilder()
   *           .setName(BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]").toString())
   *           .build();
   *   Budget response = budgetServiceClient.getBudget(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Budget getBudget(GetBudgetRequest request) {
    return getBudgetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a budget.
   *
   * <p>WARNING: There are some fields exposed on the Google Cloud Console that aren't available on
   * this API. When reading from the API, you will not see these fields in the return value, though
   * they may have been set in the Cloud Console.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   GetBudgetRequest request =
   *       GetBudgetRequest.newBuilder()
   *           .setName(BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]").toString())
   *           .build();
   *   ApiFuture<Budget> future = budgetServiceClient.getBudgetCallable().futureCall(request);
   *   // Do something.
   *   Budget response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBudgetRequest, Budget> getBudgetCallable() {
    return stub.getBudgetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of budgets for a billing account.
   *
   * <p>WARNING: There are some fields exposed on the Google Cloud Console that aren't available on
   * this API. When reading from the API, you will not see these fields in the return value, though
   * they may have been set in the Cloud Console.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
   *   for (Budget element : budgetServiceClient.listBudgets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of billing account to list budgets under. Values are of the form
   *     `billingAccounts/{billingAccountId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBudgetsPagedResponse listBudgets(BillingAccountName parent) {
    ListBudgetsRequest request =
        ListBudgetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBudgets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of budgets for a billing account.
   *
   * <p>WARNING: There are some fields exposed on the Google Cloud Console that aren't available on
   * this API. When reading from the API, you will not see these fields in the return value, though
   * they may have been set in the Cloud Console.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   String parent = BillingAccountName.of("[BILLING_ACCOUNT]").toString();
   *   for (Budget element : budgetServiceClient.listBudgets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of billing account to list budgets under. Values are of the form
   *     `billingAccounts/{billingAccountId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBudgetsPagedResponse listBudgets(String parent) {
    ListBudgetsRequest request = ListBudgetsRequest.newBuilder().setParent(parent).build();
    return listBudgets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of budgets for a billing account.
   *
   * <p>WARNING: There are some fields exposed on the Google Cloud Console that aren't available on
   * this API. When reading from the API, you will not see these fields in the return value, though
   * they may have been set in the Cloud Console.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   ListBudgetsRequest request =
   *       ListBudgetsRequest.newBuilder()
   *           .setParent(BillingAccountName.of("[BILLING_ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Budget element : budgetServiceClient.listBudgets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBudgetsPagedResponse listBudgets(ListBudgetsRequest request) {
    return listBudgetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of budgets for a billing account.
   *
   * <p>WARNING: There are some fields exposed on the Google Cloud Console that aren't available on
   * this API. When reading from the API, you will not see these fields in the return value, though
   * they may have been set in the Cloud Console.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   ListBudgetsRequest request =
   *       ListBudgetsRequest.newBuilder()
   *           .setParent(BillingAccountName.of("[BILLING_ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Budget> future = budgetServiceClient.listBudgetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Budget element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBudgetsRequest, ListBudgetsPagedResponse>
      listBudgetsPagedCallable() {
    return stub.listBudgetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of budgets for a billing account.
   *
   * <p>WARNING: There are some fields exposed on the Google Cloud Console that aren't available on
   * this API. When reading from the API, you will not see these fields in the return value, though
   * they may have been set in the Cloud Console.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   ListBudgetsRequest request =
   *       ListBudgetsRequest.newBuilder()
   *           .setParent(BillingAccountName.of("[BILLING_ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListBudgetsResponse response = budgetServiceClient.listBudgetsCallable().call(request);
   *     for (Budget element : response.getBudgetsList()) {
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
  public final UnaryCallable<ListBudgetsRequest, ListBudgetsResponse> listBudgetsCallable() {
    return stub.listBudgetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a budget. Returns successfully if already deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   BudgetName name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");
   *   budgetServiceClient.deleteBudget(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the budget to delete. Values are of the form
   *     `billingAccounts/{billingAccountId}/budgets/{budgetId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBudget(BudgetName name) {
    DeleteBudgetRequest request =
        DeleteBudgetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteBudget(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a budget. Returns successfully if already deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   String name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]").toString();
   *   budgetServiceClient.deleteBudget(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the budget to delete. Values are of the form
   *     `billingAccounts/{billingAccountId}/budgets/{budgetId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBudget(String name) {
    DeleteBudgetRequest request = DeleteBudgetRequest.newBuilder().setName(name).build();
    deleteBudget(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a budget. Returns successfully if already deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   DeleteBudgetRequest request =
   *       DeleteBudgetRequest.newBuilder()
   *           .setName(BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]").toString())
   *           .build();
   *   budgetServiceClient.deleteBudget(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBudget(DeleteBudgetRequest request) {
    deleteBudgetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a budget. Returns successfully if already deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   DeleteBudgetRequest request =
   *       DeleteBudgetRequest.newBuilder()
   *           .setName(BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]").toString())
   *           .build();
   *   ApiFuture<Empty> future = budgetServiceClient.deleteBudgetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBudgetRequest, Empty> deleteBudgetCallable() {
    return stub.deleteBudgetCallable();
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

  public static class ListBudgetsPagedResponse
      extends AbstractPagedListResponse<
          ListBudgetsRequest,
          ListBudgetsResponse,
          Budget,
          ListBudgetsPage,
          ListBudgetsFixedSizeCollection> {

    public static ApiFuture<ListBudgetsPagedResponse> createAsync(
        PageContext<ListBudgetsRequest, ListBudgetsResponse, Budget> context,
        ApiFuture<ListBudgetsResponse> futureResponse) {
      ApiFuture<ListBudgetsPage> futurePage =
          ListBudgetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListBudgetsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListBudgetsPagedResponse(ListBudgetsPage page) {
      super(page, ListBudgetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBudgetsPage
      extends AbstractPage<ListBudgetsRequest, ListBudgetsResponse, Budget, ListBudgetsPage> {

    private ListBudgetsPage(
        PageContext<ListBudgetsRequest, ListBudgetsResponse, Budget> context,
        ListBudgetsResponse response) {
      super(context, response);
    }

    private static ListBudgetsPage createEmptyPage() {
      return new ListBudgetsPage(null, null);
    }

    @Override
    protected ListBudgetsPage createPage(
        PageContext<ListBudgetsRequest, ListBudgetsResponse, Budget> context,
        ListBudgetsResponse response) {
      return new ListBudgetsPage(context, response);
    }

    @Override
    public ApiFuture<ListBudgetsPage> createPageAsync(
        PageContext<ListBudgetsRequest, ListBudgetsResponse, Budget> context,
        ApiFuture<ListBudgetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBudgetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBudgetsRequest,
          ListBudgetsResponse,
          Budget,
          ListBudgetsPage,
          ListBudgetsFixedSizeCollection> {

    private ListBudgetsFixedSizeCollection(List<ListBudgetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBudgetsFixedSizeCollection createEmptyCollection() {
      return new ListBudgetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBudgetsFixedSizeCollection createCollection(
        List<ListBudgetsPage> pages, int collectionSize) {
      return new ListBudgetsFixedSizeCollection(pages, collectionSize);
    }
  }
}
