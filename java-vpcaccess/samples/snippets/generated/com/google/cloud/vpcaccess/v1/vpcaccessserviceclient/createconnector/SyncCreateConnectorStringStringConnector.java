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

package com.google.cloud.vpcaccess.v1.samples;

// [START vpcaccess_v1_generated_vpcaccessserviceclient_createconnector_stringstringconnector_sync]
import com.google.cloud.vpcaccess.v1.Connector;
import com.google.cloud.vpcaccess.v1.LocationName;
import com.google.cloud.vpcaccess.v1.VpcAccessServiceClient;

public class SyncCreateConnectorStringStringConnector {

  public static void main(String[] args) throws Exception {
    syncCreateConnectorStringStringConnector();
  }

  public static void syncCreateConnectorStringStringConnector() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (VpcAccessServiceClient vpcAccessServiceClient = VpcAccessServiceClient.create()) {
      String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
      String connectorId = "connectorId1724784200";
      Connector connector = Connector.newBuilder().build();
      Connector response =
          vpcAccessServiceClient.createConnectorAsync(parent, connectorId, connector).get();
    }
  }
}
// [END vpcaccess_v1_generated_vpcaccessserviceclient_createconnector_stringstringconnector_sync]
