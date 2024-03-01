/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.billing.budgets.v1.samples;

// [START billingbudgets_v1_generated_BudgetService_ListBudgets_Paged_async]
import com.google.cloud.billing.budgets.v1.BillingAccountName;
import com.google.cloud.billing.budgets.v1.Budget;
import com.google.cloud.billing.budgets.v1.BudgetServiceClient;
import com.google.cloud.billing.budgets.v1.ListBudgetsRequest;
import com.google.cloud.billing.budgets.v1.ListBudgetsResponse;
import com.google.common.base.Strings;

public class AsyncListBudgetsPaged {

  public static void main(String[] args) throws Exception {
    asyncListBudgetsPaged();
  }

  public static void asyncListBudgetsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
      ListBudgetsRequest request =
          ListBudgetsRequest.newBuilder()
              .setParent(BillingAccountName.of("[BILLING_ACCOUNT]").toString())
              .setScope("scope109264468")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListBudgetsResponse response = budgetServiceClient.listBudgetsCallable().call(request);
        for (Budget element : response.getBudgetsList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END billingbudgets_v1_generated_BudgetService_ListBudgets_Paged_async]
