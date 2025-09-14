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

package com.google.cloud.compute.v1.samples;

// [START compute_v1_generated_Instances_AddNetworkInterface_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.compute.v1.AddNetworkInterfaceInstanceRequest;
import com.google.cloud.compute.v1.InstancesClient;
import com.google.cloud.compute.v1.NetworkInterface;
import com.google.longrunning.Operation;

public class AsyncAddNetworkInterface {

  public static void main(String[] args) throws Exception {
    asyncAddNetworkInterface();
  }

  public static void asyncAddNetworkInterface() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (InstancesClient instancesClient = InstancesClient.create()) {
      AddNetworkInterfaceInstanceRequest request =
          AddNetworkInterfaceInstanceRequest.newBuilder()
              .setInstance("instance555127957")
              .setNetworkInterfaceResource(NetworkInterface.newBuilder().build())
              .setProject("project-309310695")
              .setRequestId("requestId693933066")
              .setZone("zone3744684")
              .build();
      ApiFuture<Operation> future =
          instancesClient.addNetworkInterfaceCallable().futureCall(request);
      // Do something.
      com.google.cloud.compute.v1.Operation response = future.get();
    }
  }
}
// [END compute_v1_generated_Instances_AddNetworkInterface_async]
