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

package com.google.showcase.v1beta1.samples;

// [START localhost7469_v1beta1_generated_Compliance_RepeatDataSimplePath_sync]
import com.google.showcase.v1beta1.ComplianceClient;
import com.google.showcase.v1beta1.ComplianceData;
import com.google.showcase.v1beta1.RepeatRequest;
import com.google.showcase.v1beta1.RepeatResponse;

public class SyncRepeatDataSimplePath {

  public static void main(String[] args) throws Exception {
    syncRepeatDataSimplePath();
  }

  public static void syncRepeatDataSimplePath() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ComplianceClient complianceClient = ComplianceClient.create()) {
      RepeatRequest request =
          RepeatRequest.newBuilder()
              .setName("name3373707")
              .setInfo(ComplianceData.newBuilder().build())
              .setServerVerify(true)
              .setIntendedBindingUri("intendedBindingUri780142386")
              .setFInt32(-1143775883)
              .setFInt64(-1143775788)
              .setFDouble(-1239459382)
              .setPInt32(-858673665)
              .setPInt64(-858673570)
              .setPDouble(-991225216)
              .build();
      RepeatResponse response = complianceClient.repeatDataSimplePath(request);
    }
  }
}
// [END localhost7469_v1beta1_generated_Compliance_RepeatDataSimplePath_sync]
