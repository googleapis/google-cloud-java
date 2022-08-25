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

// [START datacatalog_v1beta1_generated_policytagmanagerclient_updatepolicytag_sync]
import com.google.cloud.datacatalog.v1beta1.PolicyTag;
import com.google.cloud.datacatalog.v1beta1.PolicyTagManagerClient;
import com.google.cloud.datacatalog.v1beta1.UpdatePolicyTagRequest;
import com.google.protobuf.FieldMask;

public class SyncUpdatePolicyTag {

  public static void main(String[] args) throws Exception {
    syncUpdatePolicyTag();
  }

  public static void syncUpdatePolicyTag() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (PolicyTagManagerClient policyTagManagerClient = PolicyTagManagerClient.create()) {
      UpdatePolicyTagRequest request =
          UpdatePolicyTagRequest.newBuilder()
              .setPolicyTag(PolicyTag.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      PolicyTag response = policyTagManagerClient.updatePolicyTag(request);
    }
  }
}
// [END datacatalog_v1beta1_generated_policytagmanagerclient_updatepolicytag_sync]
