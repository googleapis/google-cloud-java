/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1.samples;

// [START admanager_v1_generated_AdRuleService_ListAdRules_Paged_async]
import com.google.ads.admanager.v1.AdRule;
import com.google.ads.admanager.v1.AdRuleServiceClient;
import com.google.ads.admanager.v1.ListAdRulesRequest;
import com.google.ads.admanager.v1.ListAdRulesResponse;
import com.google.ads.admanager.v1.NetworkName;
import com.google.common.base.Strings;

public class AsyncListAdRulesPaged {

  public static void main(String[] args) throws Exception {
    asyncListAdRulesPaged();
  }

  public static void asyncListAdRulesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AdRuleServiceClient adRuleServiceClient = AdRuleServiceClient.create()) {
      ListAdRulesRequest request =
          ListAdRulesRequest.newBuilder()
              .setParent(NetworkName.of("[NETWORK_CODE]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .setSkip(3532159)
              .build();
      while (true) {
        ListAdRulesResponse response = adRuleServiceClient.listAdRulesCallable().call(request);
        for (AdRule element : response.getAdRulesList()) {
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
// [END admanager_v1_generated_AdRuleService_ListAdRules_Paged_async]
