/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.resourcemanager.v3.samples;

// [START cloudresourcemanager_v3_generated_TagHolds_ListTagHolds_Paged_async]
import com.google.cloud.resourcemanager.v3.ListTagHoldsRequest;
import com.google.cloud.resourcemanager.v3.ListTagHoldsResponse;
import com.google.cloud.resourcemanager.v3.TagHold;
import com.google.cloud.resourcemanager.v3.TagHoldsClient;
import com.google.cloud.resourcemanager.v3.TagValueName;
import com.google.common.base.Strings;

public class AsyncListTagHoldsPaged {

  public static void main(String[] args) throws Exception {
    asyncListTagHoldsPaged();
  }

  public static void asyncListTagHoldsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TagHoldsClient tagHoldsClient = TagHoldsClient.create()) {
      ListTagHoldsRequest request =
          ListTagHoldsRequest.newBuilder()
              .setParent(TagValueName.of("[TAG_VALUE]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      while (true) {
        ListTagHoldsResponse response = tagHoldsClient.listTagHoldsCallable().call(request);
        for (TagHold element : response.getTagHoldsList()) {
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
// [END cloudresourcemanager_v3_generated_TagHolds_ListTagHolds_Paged_async]
