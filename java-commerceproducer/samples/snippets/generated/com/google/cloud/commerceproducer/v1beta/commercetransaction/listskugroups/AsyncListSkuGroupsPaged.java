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

package com.google.cloud.commerceproducer.v1beta.samples;

// [START commerceproducer_v1beta_generated_CommerceTransaction_ListSkuGroups_Paged_async]
import com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient;
import com.google.cloud.commerceproducer.v1beta.ListSkuGroupsRequest;
import com.google.cloud.commerceproducer.v1beta.ListSkuGroupsResponse;
import com.google.cloud.commerceproducer.v1beta.LocationName;
import com.google.cloud.commerceproducer.v1beta.SkuGroup;
import com.google.common.base.Strings;

public class AsyncListSkuGroupsPaged {

  public static void main(String[] args) throws Exception {
    asyncListSkuGroupsPaged();
  }

  public static void asyncListSkuGroupsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CommerceTransactionClient commerceTransactionClient = CommerceTransactionClient.create()) {
      ListSkuGroupsRequest request =
          ListSkuGroupsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListSkuGroupsResponse response =
            commerceTransactionClient.listSkuGroupsCallable().call(request);
        for (SkuGroup element : response.getSkuGroupsList()) {
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
// [END commerceproducer_v1beta_generated_CommerceTransaction_ListSkuGroups_Paged_async]
