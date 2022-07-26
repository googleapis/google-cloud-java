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

package com.google.cloud.datacatalog.v1beta1.samples;

// [START datacatalog_v1beta1_generated_policytagmanagerclient_deletepolicytag_sync]
import com.google.cloud.datacatalog.v1beta1.DeletePolicyTagRequest;
import com.google.cloud.datacatalog.v1beta1.PolicyTagManagerClient;
import com.google.cloud.datacatalog.v1beta1.PolicyTagName;
import com.google.protobuf.Empty;

public class SyncDeletePolicyTag {

  public static void main(String[] args) throws Exception {
    syncDeletePolicyTag();
  }

  public static void syncDeletePolicyTag() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
      DeletePolicyTagRequest request =
          DeletePolicyTagRequest.newBuilder()
              .setName(
                  PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                      .toString())
              .build();
      policyTagManagerClient.deletePolicyTag(request);
    }
  }
}
// [END datacatalog_v1beta1_generated_policytagmanagerclient_deletepolicytag_sync]
