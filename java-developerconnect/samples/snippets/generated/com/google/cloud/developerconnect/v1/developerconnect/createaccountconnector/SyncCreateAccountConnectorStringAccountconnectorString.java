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

// [START developerconnect_v1_generated_DeveloperConnect_CreateAccountConnector_StringAccountconnectorString_sync]
import com.google.cloud.developerconnect.v1.AccountConnector;
import com.google.cloud.developerconnect.v1.DeveloperConnectClient;
import com.google.cloud.developerconnect.v1.LocationName;

public class SyncCreateAccountConnectorStringAccountconnectorString {

  public static void main(String[] args) throws Exception {
    syncCreateAccountConnectorStringAccountconnectorString();
  }

  public static void syncCreateAccountConnectorStringAccountconnectorString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
      String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
      AccountConnector accountConnector = AccountConnector.newBuilder().build();
      String accountConnectorId = "accountConnectorId-605811237";
      AccountConnector response =
          developerConnectClient
              .createAccountConnectorAsync(parent, accountConnector, accountConnectorId)
              .get();
    }
  }
}
// [END developerconnect_v1_generated_DeveloperConnect_CreateAccountConnector_StringAccountconnectorString_sync]
