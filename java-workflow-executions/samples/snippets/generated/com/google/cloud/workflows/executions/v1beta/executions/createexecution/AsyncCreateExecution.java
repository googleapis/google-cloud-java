/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.workflows.executions.v1beta.samples;

// [START workflowexecutions_v1beta_generated_Executions_CreateExecution_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.workflows.executions.v1beta.CreateExecutionRequest;
import com.google.cloud.workflows.executions.v1beta.Execution;
import com.google.cloud.workflows.executions.v1beta.ExecutionsClient;
import com.google.cloud.workflows.executions.v1beta.WorkflowName;

public class AsyncCreateExecution {

  public static void main(String[] args) throws Exception {
    asyncCreateExecution();
  }

  public static void asyncCreateExecution() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
      CreateExecutionRequest request =
          CreateExecutionRequest.newBuilder()
              .setParent(WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
              .setExecution(Execution.newBuilder().build())
              .build();
      ApiFuture<Execution> future = executionsClient.createExecutionCallable().futureCall(request);
      // Do something.
      Execution response = future.get();
    }
  }
}
// [END workflowexecutions_v1beta_generated_Executions_CreateExecution_async]
