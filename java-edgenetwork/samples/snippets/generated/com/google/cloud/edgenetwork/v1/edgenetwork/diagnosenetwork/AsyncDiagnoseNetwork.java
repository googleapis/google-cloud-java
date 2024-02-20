/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.edgenetwork.v1.samples;

// [START edgenetwork_v1_generated_EdgeNetwork_DiagnoseNetwork_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.edgenetwork.v1.DiagnoseNetworkRequest;
import com.google.cloud.edgenetwork.v1.DiagnoseNetworkResponse;
import com.google.cloud.edgenetwork.v1.EdgeNetworkClient;
import com.google.cloud.edgenetwork.v1.NetworkName;

public class AsyncDiagnoseNetwork {

  public static void main(String[] args) throws Exception {
    asyncDiagnoseNetwork();
  }

  public static void asyncDiagnoseNetwork() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
      DiagnoseNetworkRequest request =
          DiagnoseNetworkRequest.newBuilder()
              .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[ZONE]", "[NETWORK]").toString())
              .build();
      ApiFuture<DiagnoseNetworkResponse> future =
          edgeNetworkClient.diagnoseNetworkCallable().futureCall(request);
      // Do something.
      DiagnoseNetworkResponse response = future.get();
    }
  }
}
// [END edgenetwork_v1_generated_EdgeNetwork_DiagnoseNetwork_async]
