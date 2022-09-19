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

package com.google.cloud.networkmanagement.v1.samples;

// [START networkmanagement_v1_generated_reachabilityserviceclient_updateconnectivitytest_fieldmaskconnectivitytest_sync]
import com.google.cloud.networkmanagement.v1.ConnectivityTest;
import com.google.cloud.networkmanagement.v1.ReachabilityServiceClient;
import com.google.protobuf.FieldMask;

public class SyncUpdateConnectivityTestFieldmaskConnectivitytest {

  public static void main(String[] args) throws Exception {
    syncUpdateConnectivityTestFieldmaskConnectivitytest();
  }

  public static void syncUpdateConnectivityTestFieldmaskConnectivitytest() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
      FieldMask updateMask = FieldMask.newBuilder().build();
      ConnectivityTest resource = ConnectivityTest.newBuilder().build();
      ConnectivityTest response =
          reachabilityServiceClient.updateConnectivityTestAsync(updateMask, resource).get();
    }
  }
}
// [END networkmanagement_v1_generated_reachabilityserviceclient_updateconnectivitytest_fieldmaskconnectivitytest_sync]
