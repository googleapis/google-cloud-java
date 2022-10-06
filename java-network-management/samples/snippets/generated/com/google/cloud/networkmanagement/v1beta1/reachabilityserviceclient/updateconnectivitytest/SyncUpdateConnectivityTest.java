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

// [START networkmanagement_v1beta1_generated_reachabilityserviceclient_updateconnectivitytest_sync]
import com.google.cloud.networkmanagement.v1beta1.ConnectivityTest;
import com.google.cloud.networkmanagement.v1beta1.ReachabilityServiceClient;
import com.google.cloud.networkmanagement.v1beta1.UpdateConnectivityTestRequest;
import com.google.protobuf.FieldMask;

public class SyncUpdateConnectivityTest {

  public static void main(String[] args) throws Exception {
    syncUpdateConnectivityTest();
  }

  public static void syncUpdateConnectivityTest() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
      UpdateConnectivityTestRequest request =
          UpdateConnectivityTestRequest.newBuilder()
              .setUpdateMask(FieldMask.newBuilder().build())
              .setResource(ConnectivityTest.newBuilder().build())
              .build();
      ConnectivityTest response =
          reachabilityServiceClient.updateConnectivityTestAsync(request).get();
    }
  }
}
// [END networkmanagement_v1beta1_generated_reachabilityserviceclient_updateconnectivitytest_sync]
