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

package com.google.cloud.dialogflow.v2beta1.samples;

// [START dialogflow_v2beta1_generated_Intents_BatchUpdateIntents_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.dialogflow.v2beta1.AgentName;
import com.google.cloud.dialogflow.v2beta1.BatchUpdateIntentsRequest;
import com.google.cloud.dialogflow.v2beta1.BatchUpdateIntentsResponse;
import com.google.cloud.dialogflow.v2beta1.IntentView;
import com.google.cloud.dialogflow.v2beta1.IntentsClient;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Struct;

public class AsyncBatchUpdateIntentsLRO {

  public static void main(String[] args) throws Exception {
    asyncBatchUpdateIntentsLRO();
  }

  public static void asyncBatchUpdateIntentsLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (IntentsClient intentsClient = IntentsClient.create()) {
      BatchUpdateIntentsRequest request =
          BatchUpdateIntentsRequest.newBuilder()
              .setParent(AgentName.ofProjectName("[PROJECT]").toString())
              .setLanguageCode("languageCode-2092349083")
              .setUpdateMask(FieldMask.newBuilder().build())
              .setIntentView(IntentView.forNumber(0))
              .build();
      OperationFuture<BatchUpdateIntentsResponse, Struct> future =
          intentsClient.batchUpdateIntentsOperationCallable().futureCall(request);
      // Do something.
      BatchUpdateIntentsResponse response = future.get();
    }
  }
}
// [END dialogflow_v2beta1_generated_Intents_BatchUpdateIntents_LRO_async]
