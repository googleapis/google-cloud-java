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

package com.google.cloud.workflows.v1.samples;

// [START workflows_v1_generated_workflowsclient_updateworkflow_workflowfieldmask_sync]
import com.google.cloud.workflows.v1.Workflow;
import com.google.cloud.workflows.v1.WorkflowsClient;
import com.google.protobuf.FieldMask;

public class SyncUpdateWorkflowWorkflowFieldmask {

  public static void main(String[] args) throws Exception {
    syncUpdateWorkflowWorkflowFieldmask();
  }

  public static void syncUpdateWorkflowWorkflowFieldmask() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
      Workflow workflow = Workflow.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      Workflow response = workflowsClient.updateWorkflowAsync(workflow, updateMask).get();
    }
  }
}
// [END workflows_v1_generated_workflowsclient_updateworkflow_workflowfieldmask_sync]
