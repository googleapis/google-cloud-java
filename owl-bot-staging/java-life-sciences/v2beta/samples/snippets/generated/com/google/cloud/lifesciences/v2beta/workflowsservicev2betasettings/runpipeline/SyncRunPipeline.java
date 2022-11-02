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

// [START lifesciences_v2beta_generated_WorkflowsServiceV2BetaSettings_RunPipeline_sync]
import com.google.cloud.lifesciences.v2beta.WorkflowsServiceV2BetaSettings;
import java.time.Duration;

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
    WorkflowsServiceV2BetaSettings.Builder workflowsServiceV2BetaSettingsBuilder =
        WorkflowsServiceV2BetaSettings.newBuilder();
    workflowsServiceV2BetaSettingsBuilder
        .runPipelineSettings()
        .setRetrySettings(
            workflowsServiceV2BetaSettingsBuilder
                .runPipelineSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    WorkflowsServiceV2BetaSettings workflowsServiceV2BetaSettings =
        workflowsServiceV2BetaSettingsBuilder.build();
  }
}
// [END lifesciences_v2beta_generated_WorkflowsServiceV2BetaSettings_RunPipeline_sync]
