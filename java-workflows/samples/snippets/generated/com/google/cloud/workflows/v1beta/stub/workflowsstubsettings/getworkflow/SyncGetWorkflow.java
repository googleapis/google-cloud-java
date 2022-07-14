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

package com.google.cloud.workflows.v1beta.stub.samples;

// [START workflows_v1beta_generated_workflowsstubsettings_getworkflow_sync]
import com.google.cloud.workflows.v1beta.stub.WorkflowsStubSettings;
import java.time.Duration;

public class SyncGetWorkflow {

  public static void main(String[] args) throws Exception {
    syncGetWorkflow();
  }

  public static void syncGetWorkflow() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    WorkflowsStubSettings.Builder workflowsSettingsBuilder = WorkflowsStubSettings.newBuilder();
    workflowsSettingsBuilder
        .getWorkflowSettings()
        .setRetrySettings(
            workflowsSettingsBuilder
                .getWorkflowSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    WorkflowsStubSettings workflowsSettings = workflowsSettingsBuilder.build();
  }
}
// [END workflows_v1beta_generated_workflowsstubsettings_getworkflow_sync]
