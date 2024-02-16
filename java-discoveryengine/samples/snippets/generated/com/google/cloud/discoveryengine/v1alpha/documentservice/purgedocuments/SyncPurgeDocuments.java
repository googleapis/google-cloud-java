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

package com.google.cloud.discoveryengine.v1alpha.samples;

// [START discoveryengine_v1alpha_generated_DocumentService_PurgeDocuments_sync]
import com.google.cloud.discoveryengine.v1alpha.BranchName;
import com.google.cloud.discoveryengine.v1alpha.DocumentServiceClient;
import com.google.cloud.discoveryengine.v1alpha.PurgeDocumentsRequest;
import com.google.cloud.discoveryengine.v1alpha.PurgeDocumentsResponse;

public class SyncPurgeDocuments {

  public static void main(String[] args) throws Exception {
    syncPurgeDocuments();
  }

  public static void syncPurgeDocuments() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
      PurgeDocumentsRequest request =
          PurgeDocumentsRequest.newBuilder()
              .setParent(
                  BranchName.ofProjectLocationDataStoreBranchName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]")
                      .toString())
              .setFilter("filter-1274492040")
              .setForce(true)
              .build();
      PurgeDocumentsResponse response = documentServiceClient.purgeDocumentsAsync(request).get();
    }
  }
}
// [END discoveryengine_v1alpha_generated_DocumentService_PurgeDocuments_sync]
