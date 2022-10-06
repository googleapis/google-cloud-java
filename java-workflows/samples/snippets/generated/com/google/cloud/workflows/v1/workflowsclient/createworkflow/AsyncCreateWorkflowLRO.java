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

// [START workflows_v1_generated_workflowsclient_createworkflow_lro_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.workflows.v1.CreateWorkflowRequest;
import com.google.cloud.workflows.v1.LocationName;
import com.google.cloud.workflows.v1.OperationMetadata;
import com.google.cloud.workflows.v1.Workflow;
import com.google.cloud.workflows.v1.WorkflowsClient;

public class AsyncCreateWorkflowLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateWorkflowLRO();
  }

  public static void asyncCreateWorkflowLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
      CreateWorkflowRequest request =
          CreateWorkflowRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setWorkflow(Workflow.newBuilder().build())
              .setWorkflowId("workflowId-360387270")
              .build();
      OperationFuture<Workflow, OperationMetadata> future =
          workflowsClient.createWorkflowOperationCallable().futureCall(request);
      // Do something.
      Workflow response = future.get();
    }
  }
}
// [END workflows_v1_generated_workflowsclient_createworkflow_lro_async]
