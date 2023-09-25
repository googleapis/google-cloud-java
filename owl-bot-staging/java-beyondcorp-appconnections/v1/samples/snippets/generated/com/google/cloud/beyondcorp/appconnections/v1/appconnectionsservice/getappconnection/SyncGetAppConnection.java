/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.beyondcorp.appconnections.v1.samples;

// [START beyondcorp_v1_generated_AppConnectionsService_GetAppConnection_sync]
import com.google.cloud.beyondcorp.appconnections.v1.AppConnection;
import com.google.cloud.beyondcorp.appconnections.v1.AppConnectionName;
import com.google.cloud.beyondcorp.appconnections.v1.AppConnectionsServiceClient;
import com.google.cloud.beyondcorp.appconnections.v1.GetAppConnectionRequest;

public class SyncGetAppConnection {

  public static void main(String[] args) throws Exception {
    syncGetAppConnection();
  }

  public static void syncGetAppConnection() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AppConnectionsServiceClient appConnectionsServiceClient =
        AppConnectionsServiceClient.create()) {
      GetAppConnectionRequest request =
          GetAppConnectionRequest.newBuilder()
              .setName(
                  AppConnectionName.of("[PROJECT]", "[LOCATION]", "[APP_CONNECTION]").toString())
              .build();
      AppConnection response = appConnectionsServiceClient.getAppConnection(request);
    }
  }
}
// [END beyondcorp_v1_generated_AppConnectionsService_GetAppConnection_sync]
