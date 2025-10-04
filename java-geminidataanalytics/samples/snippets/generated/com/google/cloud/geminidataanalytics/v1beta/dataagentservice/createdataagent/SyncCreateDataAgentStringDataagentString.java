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

package com.google.cloud.geminidataanalytics.v1beta.samples;

// [START geminidataanalytics_v1beta_generated_DataAgentService_CreateDataAgent_StringDataagentString_sync]
import com.google.cloud.geminidataanalytics.v1beta.DataAgent;
import com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceClient;
import com.google.cloud.geminidataanalytics.v1beta.LocationName;

public class SyncCreateDataAgentStringDataagentString {

  public static void main(String[] args) throws Exception {
    syncCreateDataAgentStringDataagentString();
  }

  public static void syncCreateDataAgentStringDataagentString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
      String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
      DataAgent dataAgent = DataAgent.newBuilder().build();
      String dataAgentId = "dataAgentId1752773622";
      DataAgent response =
          dataAgentServiceClient.createDataAgentAsync(parent, dataAgent, dataAgentId).get();
    }
  }
}
// [END geminidataanalytics_v1beta_generated_DataAgentService_CreateDataAgent_StringDataagentString_sync]
