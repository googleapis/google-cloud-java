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

package com.google.shopping.css.v1.samples;

// [START css_v1_generated_QuotaService_ListQuotaGroups_sync]
import com.google.shopping.css.v1.AccountName;
import com.google.shopping.css.v1.ListQuotaGroupsRequest;
import com.google.shopping.css.v1.QuotaGroup;
import com.google.shopping.css.v1.QuotaServiceClient;

public class SyncListQuotaGroups {

  public static void main(String[] args) throws Exception {
    syncListQuotaGroups();
  }

  public static void syncListQuotaGroups() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (QuotaServiceClient quotaServiceClient = QuotaServiceClient.create()) {
      ListQuotaGroupsRequest request =
          ListQuotaGroupsRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      for (QuotaGroup element : quotaServiceClient.listQuotaGroups(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END css_v1_generated_QuotaService_ListQuotaGroups_sync]
