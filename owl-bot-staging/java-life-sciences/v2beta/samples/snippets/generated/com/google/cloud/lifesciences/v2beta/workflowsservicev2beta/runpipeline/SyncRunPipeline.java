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

package com.google.cloud.lifesciences.v2beta.samples;

// [START lifesciences_v2beta_generated_WorkflowsServiceV2Beta_RunPipeline_sync]
import com.google.cloud.lifesciences.v2beta.Pipeline;
import com.google.cloud.lifesciences.v2beta.RunPipelineRequest;
import com.google.cloud.lifesciences.v2beta.RunPipelineResponse;
import com.google.cloud.lifesciences.v2beta.WorkflowsServiceV2BetaClient;
import java.util.HashMap;

public class SyncRunPipeline {

  public static void main(String[] args) throws Exception {
    syncRunPipeline();
  }

  public static void syncRunPipeline() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (WorkflowsServiceV2BetaClient workflowsServiceV2BetaClient =
        WorkflowsServiceV2BetaClient.create()) {
      RunPipelineRequest request =
          RunPipelineRequest.newBuilder()
              .setParent("parent-995424086")
              .setPipeline(Pipeline.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setPubSubTopic("pubSubTopic320524524")
              .build();
      RunPipelineResponse response = workflowsServiceV2BetaClient.runPipelineAsync(request).get();
    }
  }
}
// [END lifesciences_v2beta_generated_WorkflowsServiceV2Beta_RunPipeline_sync]
