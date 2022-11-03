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

package com.google.cloud.speech.v1.samples;

// [START speech_v1_generated_Adaptation_GetCustomClass_Customclassname_sync]
import com.google.cloud.speech.v1.AdaptationClient;
import com.google.cloud.speech.v1.CustomClass;
import com.google.cloud.speech.v1.CustomClassName;

public class SyncGetCustomClassCustomclassname {

  public static void main(String[] args) throws Exception {
    syncGetCustomClassCustomclassname();
  }

  public static void syncGetCustomClassCustomclassname() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AdaptationClient adaptationClient = AdaptationClient.create()) {
      CustomClassName name = CustomClassName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_CLASS]");
      CustomClass response = adaptationClient.getCustomClass(name);
    }
  }
}
// [END speech_v1_generated_Adaptation_GetCustomClass_Customclassname_sync]
