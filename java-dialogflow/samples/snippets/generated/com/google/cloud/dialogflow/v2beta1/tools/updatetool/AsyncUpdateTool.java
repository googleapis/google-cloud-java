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

package com.google.cloud.dialogflow.v2beta1.samples;

// [START dialogflow_v2beta1_generated_Tools_UpdateTool_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.dialogflow.v2beta1.Tool;
import com.google.cloud.dialogflow.v2beta1.ToolsClient;
import com.google.cloud.dialogflow.v2beta1.UpdateToolRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateTool {

  public static void main(String[] args) throws Exception {
    asyncUpdateTool();
  }

  public static void asyncUpdateTool() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ToolsClient toolsClient = ToolsClient.create()) {
      UpdateToolRequest request =
          UpdateToolRequest.newBuilder()
              .setTool(Tool.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      ApiFuture<Tool> future = toolsClient.updateToolCallable().futureCall(request);
      // Do something.
      Tool response = future.get();
    }
  }
}
// [END dialogflow_v2beta1_generated_Tools_UpdateTool_async]
