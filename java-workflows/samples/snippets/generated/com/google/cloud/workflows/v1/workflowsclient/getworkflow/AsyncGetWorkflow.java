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

// [START workflows_v1_generated_workflowsclient_getworkflow_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.workflows.v1.GetWorkflowRequest;
import com.google.cloud.workflows.v1.Workflow;
import com.google.cloud.workflows.v1.WorkflowName;
import com.google.cloud.workflows.v1.WorkflowsClient;

public class AsyncGetWorkflow {

  public static void main(String[] args) throws Exception {
    asyncGetWorkflow();
  }

  public static void asyncGetWorkflow() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (WorkflowsClient workflowsClient = WorkflowsClient.create()) {
      GetWorkflowRequest request =
          GetWorkflowRequest.newBuilder()
              .setName(WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
              .build();
      ApiFuture<Workflow> future = workflowsClient.getWorkflowCallable().futureCall(request);
      // Do something.
      Workflow response = future.get();
    }
  }
}
// [END workflows_v1_generated_workflowsclient_getworkflow_async]
