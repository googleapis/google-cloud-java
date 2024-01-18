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

// [START cloudresourcemanager_v3_generated_TagHolds_ListTagHolds_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.resourcemanager.v3.ListTagHoldsRequest;
import com.google.cloud.resourcemanager.v3.TagHold;
import com.google.cloud.resourcemanager.v3.TagHoldsClient;
import com.google.cloud.resourcemanager.v3.TagValueName;

public class AsyncListTagHolds {

  public static void main(String[] args) throws Exception {
    asyncListTagHolds();
  }

  public static void asyncListTagHolds() throws Exception {
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
      ApiFuture<TagHold> future = tagHoldsClient.listTagHoldsPagedCallable().futureCall(request);
      // Do something.
      for (TagHold element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END cloudresourcemanager_v3_generated_TagHolds_ListTagHolds_async]
