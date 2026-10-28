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

package com.google.cloud.memorystore.v1.samples;

// [START memorystore_v1_generated_Memorystore_ListAclPolicyRevisions_Paged_async]
import com.google.cloud.memorystore.v1.AclPolicyName;
import com.google.cloud.memorystore.v1.AclPolicyRevision;
import com.google.cloud.memorystore.v1.ListAclPolicyRevisionsRequest;
import com.google.cloud.memorystore.v1.ListAclPolicyRevisionsResponse;
import com.google.cloud.memorystore.v1.MemorystoreClient;
import com.google.common.base.Strings;

public class AsyncListAclPolicyRevisionsPaged {

  public static void main(String[] args) throws Exception {
    asyncListAclPolicyRevisionsPaged();
  }

  public static void asyncListAclPolicyRevisionsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
      ListAclPolicyRevisionsRequest request =
          ListAclPolicyRevisionsRequest.newBuilder()
              .setParent(AclPolicyName.of("[PROJECT]", "[LOCATION]", "[ACL_POLICY]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListAclPolicyRevisionsResponse response =
            memorystoreClient.listAclPolicyRevisionsCallable().call(request);
        for (AclPolicyRevision element : response.getAclPolicyRevisionsList()) {
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
// [END memorystore_v1_generated_Memorystore_ListAclPolicyRevisions_Paged_async]
