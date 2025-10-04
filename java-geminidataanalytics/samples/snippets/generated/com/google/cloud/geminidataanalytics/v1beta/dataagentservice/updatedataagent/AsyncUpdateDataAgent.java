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

// [START geminidataanalytics_v1beta_generated_DataAgentService_UpdateDataAgent_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.geminidataanalytics.v1beta.DataAgent;
import com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceClient;
import com.google.cloud.geminidataanalytics.v1beta.UpdateDataAgentRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;

public class AsyncUpdateDataAgent {

  public static void main(String[] args) throws Exception {
    asyncUpdateDataAgent();
  }

  public static void asyncUpdateDataAgent() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataAgentServiceClient dataAgentServiceClient = DataAgentServiceClient.create()) {
      UpdateDataAgentRequest request =
          UpdateDataAgentRequest.newBuilder()
              .setUpdateMask(FieldMask.newBuilder().build())
              .setDataAgent(DataAgent.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      ApiFuture<Operation> future =
          dataAgentServiceClient.updateDataAgentCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END geminidataanalytics_v1beta_generated_DataAgentService_UpdateDataAgent_async]
