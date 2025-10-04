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

package com.google.shopping.merchant.accounts.v1.samples;

// [START merchantapi_v1_generated_AccountsService_ListSubAccounts_Paged_async]
import com.google.common.base.Strings;
import com.google.shopping.merchant.accounts.v1.Account;
import com.google.shopping.merchant.accounts.v1.AccountName;
import com.google.shopping.merchant.accounts.v1.AccountsServiceClient;
import com.google.shopping.merchant.accounts.v1.ListSubAccountsRequest;
import com.google.shopping.merchant.accounts.v1.ListSubAccountsResponse;

public class AsyncListSubAccountsPaged {

  public static void main(String[] args) throws Exception {
    asyncListSubAccountsPaged();
  }

  public static void asyncListSubAccountsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
      ListSubAccountsRequest request =
          ListSubAccountsRequest.newBuilder()
              .setProvider(AccountName.of("[ACCOUNT]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListSubAccountsResponse response =
            accountsServiceClient.listSubAccountsCallable().call(request);
        for (Account element : response.getAccountsList()) {
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
// [END merchantapi_v1_generated_AccountsService_ListSubAccounts_Paged_async]
