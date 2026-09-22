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

package com.google.cloud.dlp.v2.samples;

// [START dlp_v2_generated_DlpService_UpdateContentPolicy_sync]
import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.ContentPolicy;
import com.google.privacy.dlp.v2.ContentPolicyName;
import com.google.privacy.dlp.v2.UpdateContentPolicyRequest;
import com.google.protobuf.FieldMask;

public class SyncUpdateContentPolicy {

  public static void main(String[] args) throws Exception {
    syncUpdateContentPolicy();
  }

  public static void syncUpdateContentPolicy() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
      UpdateContentPolicyRequest request =
          UpdateContentPolicyRequest.newBuilder()
              .setName(
                  ContentPolicyName.of("[PROJECT]", "[LOCATION]", "[CONTENT_POLICY]").toString())
              .setContentPolicy(ContentPolicy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      ContentPolicy response = dlpServiceClient.updateContentPolicy(request);
    }
  }
}
// [END dlp_v2_generated_DlpService_UpdateContentPolicy_sync]
