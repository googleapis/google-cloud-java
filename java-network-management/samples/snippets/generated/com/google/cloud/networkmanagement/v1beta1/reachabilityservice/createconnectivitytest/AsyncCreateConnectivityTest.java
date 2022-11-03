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

package com.google.cloud.networkmanagement.v1beta1.samples;

// [START networkmanagement_v1beta1_generated_ReachabilityService_CreateConnectivityTest_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.networkmanagement.v1beta1.ConnectivityTest;
import com.google.cloud.networkmanagement.v1beta1.CreateConnectivityTestRequest;
import com.google.cloud.networkmanagement.v1beta1.ReachabilityServiceClient;
import com.google.longrunning.Operation;

public class AsyncCreateConnectivityTest {

  public static void main(String[] args) throws Exception {
    asyncCreateConnectivityTest();
  }

  public static void asyncCreateConnectivityTest() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
      CreateConnectivityTestRequest request =
          CreateConnectivityTestRequest.newBuilder()
              .setParent("parent-995424086")
              .setTestId("testId-877170355")
              .setResource(ConnectivityTest.newBuilder().build())
              .build();
      ApiFuture<Operation> future =
          reachabilityServiceClient.createConnectivityTestCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END networkmanagement_v1beta1_generated_ReachabilityService_CreateConnectivityTest_async]
