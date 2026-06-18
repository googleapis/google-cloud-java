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

// [START agentregistry_v1_generated_AgentRegistry_DeleteBinding_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.agentregistry.v1.AgentRegistryClient;
import com.google.cloud.agentregistry.v1.BindingName;
import com.google.cloud.agentregistry.v1.DeleteBindingRequest;
import com.google.longrunning.Operation;

public class AsyncDeleteBinding {

  public static void main(String[] args) throws Exception {
    asyncDeleteBinding();
  }

  public static void asyncDeleteBinding() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
      DeleteBindingRequest request =
          DeleteBindingRequest.newBuilder()
              .setName(BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]").toString())
              .setRequestId("requestId693933066")
              .build();
      ApiFuture<Operation> future = agentRegistryClient.deleteBindingCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END agentregistry_v1_generated_AgentRegistry_DeleteBinding_async]
