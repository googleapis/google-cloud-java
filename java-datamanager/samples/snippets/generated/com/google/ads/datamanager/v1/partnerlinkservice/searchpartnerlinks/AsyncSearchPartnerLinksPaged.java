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

package com.google.ads.datamanager.v1.samples;

// [START datamanager_v1_generated_PartnerLinkService_SearchPartnerLinks_Paged_async]
import com.google.ads.datamanager.v1.AccountName;
import com.google.ads.datamanager.v1.PartnerLink;
import com.google.ads.datamanager.v1.PartnerLinkServiceClient;
import com.google.ads.datamanager.v1.SearchPartnerLinksRequest;
import com.google.ads.datamanager.v1.SearchPartnerLinksResponse;
import com.google.common.base.Strings;

public class AsyncSearchPartnerLinksPaged {

  public static void main(String[] args) throws Exception {
    asyncSearchPartnerLinksPaged();
  }

  public static void asyncSearchPartnerLinksPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PartnerLinkServiceClient partnerLinkServiceClient = PartnerLinkServiceClient.create()) {
      SearchPartnerLinksRequest request =
          SearchPartnerLinksRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT_TYPE]", "[ACCOUNT]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      while (true) {
        SearchPartnerLinksResponse response =
            partnerLinkServiceClient.searchPartnerLinksCallable().call(request);
        for (PartnerLink element : response.getPartnerLinksList()) {
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
// [END datamanager_v1_generated_PartnerLinkService_SearchPartnerLinks_Paged_async]
