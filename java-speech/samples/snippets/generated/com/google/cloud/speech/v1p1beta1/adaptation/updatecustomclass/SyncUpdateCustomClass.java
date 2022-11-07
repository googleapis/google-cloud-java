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

package com.google.cloud.speech.v1p1beta1.samples;

// [START speech_v1p1beta1_generated_Adaptation_UpdateCustomClass_sync]
import com.google.cloud.speech.v1p1beta1.AdaptationClient;
import com.google.cloud.speech.v1p1beta1.CustomClass;
import com.google.cloud.speech.v1p1beta1.UpdateCustomClassRequest;
import com.google.protobuf.FieldMask;

public class SyncUpdateCustomClass {

  public static void main(String[] args) throws Exception {
    syncUpdateCustomClass();
  }

  public static void syncUpdateCustomClass() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AdaptationClient adaptationClient = AdaptationClient.create()) {
      UpdateCustomClassRequest request =
          UpdateCustomClassRequest.newBuilder()
              .setCustomClass(CustomClass.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      CustomClass response = adaptationClient.updateCustomClass(request);
    }
  }
}
// [END speech_v1p1beta1_generated_Adaptation_UpdateCustomClass_sync]
