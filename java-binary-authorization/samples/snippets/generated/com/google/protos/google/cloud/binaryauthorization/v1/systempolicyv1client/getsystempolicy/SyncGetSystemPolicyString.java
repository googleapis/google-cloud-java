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

package com.google.protos.google.cloud.binaryauthorization.v1.samples;

// [START binaryauthorization_v1_generated_systempolicyv1client_getsystempolicy_string_sync]
import com.google.protos.google.cloud.binaryauthorization.v1.PolicyName;
import com.google.protos.google.cloud.binaryauthorization.v1.Resources;
import com.google.protos.google.cloud.binaryauthorization.v1.SystemPolicyV1Client;

public class SyncGetSystemPolicyString {

  public static void main(String[] args) throws Exception {
    syncGetSystemPolicyString();
  }

  public static void syncGetSystemPolicyString() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (SystemPolicyV1Client systemPolicyV1Client = SystemPolicyV1Client.create()) {
      String name = PolicyName.ofProjectName("[PROJECT]").toString();
      Resources.Policy response = systemPolicyV1Client.getSystemPolicy(name);
    }
  }
}
// [END binaryauthorization_v1_generated_systempolicyv1client_getsystempolicy_string_sync]
