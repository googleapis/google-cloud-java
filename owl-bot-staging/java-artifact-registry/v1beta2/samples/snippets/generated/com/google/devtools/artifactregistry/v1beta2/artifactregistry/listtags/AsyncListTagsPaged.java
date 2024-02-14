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

package com.google.devtools.artifactregistry.v1beta2.samples;

// [START artifactregistry_v1beta2_generated_ArtifactRegistry_ListTags_Paged_async]
import com.google.common.base.Strings;
import com.google.devtools.artifactregistry.v1beta2.ArtifactRegistryClient;
import com.google.devtools.artifactregistry.v1beta2.ListTagsRequest;
import com.google.devtools.artifactregistry.v1beta2.ListTagsResponse;
import com.google.devtools.artifactregistry.v1beta2.Tag;

public class AsyncListTagsPaged {

  public static void main(String[] args) throws Exception {
    asyncListTagsPaged();
  }

  public static void asyncListTagsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
      ListTagsRequest request =
          ListTagsRequest.newBuilder()
              .setParent("parent-995424086")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListTagsResponse response = artifactRegistryClient.listTagsCallable().call(request);
        for (Tag element : response.getTagsList()) {
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
// [END artifactregistry_v1beta2_generated_ArtifactRegistry_ListTags_Paged_async]
