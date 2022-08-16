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

package com.google.cloud.dataproc.v1.samples;

// [START dataproc_v1_generated_workflowtemplateserviceclient_listworkflowtemplates_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.dataproc.v1.ListWorkflowTemplatesRequest;
import com.google.cloud.dataproc.v1.RegionName;
import com.google.cloud.dataproc.v1.WorkflowTemplate;
import com.google.cloud.dataproc.v1.WorkflowTemplateServiceClient;

public class AsyncListWorkflowTemplates {

  public static void main(String[] args) throws Exception {
    asyncListWorkflowTemplates();
  }

  public static void asyncListWorkflowTemplates() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (WorkflowTemplateServiceClient workflowTemplateServiceClient =
        WorkflowTemplateServiceClient.create()) {
      ListWorkflowTemplatesRequest request =
          ListWorkflowTemplatesRequest.newBuilder()
              .setParent(RegionName.of("[PROJECT]", "[REGION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<WorkflowTemplate> future =
          workflowTemplateServiceClient.listWorkflowTemplatesPagedCallable().futureCall(request);
      // Do something.
      for (WorkflowTemplate element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END dataproc_v1_generated_workflowtemplateserviceclient_listworkflowtemplates_async]
