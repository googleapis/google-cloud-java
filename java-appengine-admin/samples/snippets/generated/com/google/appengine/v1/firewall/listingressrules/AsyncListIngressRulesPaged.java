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

package com.google.appengine.v1.samples;

// [START appengine_v1_generated_Firewall_ListIngressRules_Paged_async]
import com.google.appengine.v1.FirewallClient;
import com.google.appengine.v1.ListIngressRulesRequest;
import com.google.appengine.v1.ListIngressRulesResponse;
import com.google.appengine.v1.firewall.FirewallRule;
import com.google.common.base.Strings;

public class AsyncListIngressRulesPaged {

  public static void main(String[] args) throws Exception {
    asyncListIngressRulesPaged();
  }

  public static void asyncListIngressRulesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (FirewallClient firewallClient = FirewallClient.create()) {
      ListIngressRulesRequest request =
          ListIngressRulesRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setMatchingAddress("matchingAddress861962551")
              .build();
      while (true) {
        ListIngressRulesResponse response = firewallClient.listIngressRulesCallable().call(request);
        for (FirewallRule element : response.getIngressRulesList()) {
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
// [END appengine_v1_generated_Firewall_ListIngressRules_Paged_async]
