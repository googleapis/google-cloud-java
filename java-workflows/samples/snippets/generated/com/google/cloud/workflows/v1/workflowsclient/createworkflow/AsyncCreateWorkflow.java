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

// [START workflows_v1_generated_workflowsclient_createworkflow_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.workflows.v1.CreateWorkflowRequest;
import com.google.cloud.workflows.v1.LocationName;
import com.google.cloud.workflows.v1.Workflow;
import com.google.cloud.workflows.v1.WorkflowsClient;
import com.google.longrunning.Operation;

public class AsyncCreateWorkflow {

  public static void main(String[] args) throws Exception {
    asyncCreateWorkflow();
  }

  public static void asyncCreateWorkflow() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
      CreateWorkflowRequest request =
          CreateWorkflowRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setWorkflow(Workflow.newBuilder().build())
              .setWorkflowId("workflowId-360387270")
              .build();
      ApiFuture<Operation> future = workflowsClient.createWorkflowCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END workflows_v1_generated_workflowsclient_createworkflow_async]
