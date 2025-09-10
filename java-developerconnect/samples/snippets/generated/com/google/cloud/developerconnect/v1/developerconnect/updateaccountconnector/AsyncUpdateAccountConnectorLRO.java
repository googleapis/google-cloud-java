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

package com.google.cloud.developerconnect.v1.samples;

// [START developerconnect_v1_generated_DeveloperConnect_UpdateAccountConnector_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.developerconnect.v1.AccountConnector;
import com.google.cloud.developerconnect.v1.DeveloperConnectClient;
import com.google.cloud.developerconnect.v1.OperationMetadata;
import com.google.cloud.developerconnect.v1.UpdateAccountConnectorRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateAccountConnectorLRO {

  public static void main(String[] args) throws Exception {
    asyncUpdateAccountConnectorLRO();
  }

  public static void asyncUpdateAccountConnectorLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
      UpdateAccountConnectorRequest request =
          UpdateAccountConnectorRequest.newBuilder()
              .setUpdateMask(FieldMask.newBuilder().build())
              .setAccountConnector(AccountConnector.newBuilder().build())
              .setRequestId("requestId693933066")
              .setAllowMissing(true)
              .setValidateOnly(true)
              .build();
      OperationFuture<AccountConnector, OperationMetadata> future =
          developerConnectClient.updateAccountConnectorOperationCallable().futureCall(request);
      // Do something.
      AccountConnector response = future.get();
    }
  }
}
// [END developerconnect_v1_generated_DeveloperConnect_UpdateAccountConnector_LRO_async]
