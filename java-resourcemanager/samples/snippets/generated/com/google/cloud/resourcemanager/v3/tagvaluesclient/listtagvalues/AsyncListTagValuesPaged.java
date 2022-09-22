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

package com.google.cloud.resourcemanager.v3.samples;

// [START resourcemanager_v3_generated_tagvaluesclient_listtagvalues_paged_async]
import com.google.cloud.resourcemanager.v3.FolderName;
import com.google.cloud.resourcemanager.v3.ListTagValuesRequest;
import com.google.cloud.resourcemanager.v3.ListTagValuesResponse;
import com.google.cloud.resourcemanager.v3.TagValue;
import com.google.cloud.resourcemanager.v3.TagValuesClient;
import com.google.common.base.Strings;

public class AsyncListTagValuesPaged {

  public static void main(String[] args) throws Exception {
    asyncListTagValuesPaged();
  }

  public static void asyncListTagValuesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
      ListTagValuesRequest request =
          ListTagValuesRequest.newBuilder()
              .setParent(FolderName.of("[FOLDER]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListTagValuesResponse response = tagValuesClient.listTagValuesCallable().call(request);
        for (TagValue element : response.getTagValuesList()) {
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
// [END resourcemanager_v3_generated_tagvaluesclient_listtagvalues_paged_async]
