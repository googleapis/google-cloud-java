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

package com.google.cloud.agentregistry.v1.samples;

// [START agentregistry_v1_generated_AgentRegistry_GetService_String_sync]
import com.google.cloud.agentregistry.v1.AgentRegistryClient;
import com.google.cloud.agentregistry.v1.Service;
import com.google.cloud.agentregistry.v1.ServiceName;

public class SyncGetServiceString {

  public static void main(String[] args) throws Exception {
    syncGetServiceString();
  }

  public static void syncGetServiceString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
      String name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString();
      Service response = agentRegistryClient.getService(name);
    }
  }
}
// [END agentregistry_v1_generated_AgentRegistry_GetService_String_sync]
