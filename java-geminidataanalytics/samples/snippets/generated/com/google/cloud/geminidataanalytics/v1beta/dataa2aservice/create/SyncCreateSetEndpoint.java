/*
 * Copyright 2026 Google LLC
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

// [START geminidataanalytics_v1beta_generated_DataA2AService_Create_SetEndpoint_sync]
import com.google.cloud.geminidataanalytics.v1beta.DataA2AServiceClient;
import com.google.cloud.geminidataanalytics.v1beta.DataA2AServiceSettings;
import com.google.cloud.geminidataanalytics.v1beta.myEndpoint;

public class SyncCreateSetEndpoint {

  public static void main(String[] args) throws Exception {
    syncCreateSetEndpoint();
  }

  public static void syncCreateSetEndpoint() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    DataA2AServiceSettings dataA2AServiceSettings =
        DataA2AServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
    DataA2AServiceClient dataA2AServiceClient = DataA2AServiceClient.create(dataA2AServiceSettings);
  }
}
// [END geminidataanalytics_v1beta_generated_DataA2AService_Create_SetEndpoint_sync]
