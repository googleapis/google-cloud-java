/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.aiplatform.v1beta1.samples;

// [START aiplatform_v1beta1_generated_MemoryBankService_GetMemory_String_sync]
import com.google.cloud.aiplatform.v1beta1.Memory;
import com.google.cloud.aiplatform.v1beta1.MemoryBankServiceClient;
import com.google.cloud.aiplatform.v1beta1.MemoryName;

public class SyncGetMemoryString {

  public static void main(String[] args) throws Exception {
    syncGetMemoryString();
  }

  public static void syncGetMemoryString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
      String name =
          MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]").toString();
      Memory response = memoryBankServiceClient.getMemory(name);
    }
  }
}
// [END aiplatform_v1beta1_generated_MemoryBankService_GetMemory_String_sync]
