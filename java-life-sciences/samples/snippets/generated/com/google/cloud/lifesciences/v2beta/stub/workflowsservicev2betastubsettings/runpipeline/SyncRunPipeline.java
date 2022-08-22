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

package com.google.cloud.lifesciences.v2beta.stub.samples;

// [START lifesciences_v2beta_generated_workflowsservicev2betastubsettings_runpipeline_sync]
import com.google.cloud.lifesciences.v2beta.stub.WorkflowsServiceV2BetaStubSettings;
import java.time.Duration;

public class SyncRunPipeline {

  public static void main(String[] args) throws Exception {
    syncRunPipeline();
  }

  public static void syncRunPipeline() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    WorkflowsServiceV2BetaStubSettings.Builder workflowsServiceV2BetaSettingsBuilder =
        WorkflowsServiceV2BetaStubSettings.newBuilder();
    workflowsServiceV2BetaSettingsBuilder
        .runPipelineSettings()
        .setRetrySettings(
            workflowsServiceV2BetaSettingsBuilder
                .runPipelineSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    WorkflowsServiceV2BetaStubSettings workflowsServiceV2BetaSettings =
        workflowsServiceV2BetaSettingsBuilder.build();
  }
}
// [END lifesciences_v2beta_generated_workflowsservicev2betastubsettings_runpipeline_sync]
