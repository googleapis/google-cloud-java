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

// [START
// dataproc_v1_generated_workflowtemplateserviceclient_instantiateworkflowtemplate_stringmapstringstring_sync]
import com.google.cloud.dataproc.v1.WorkflowTemplateName;
import com.google.cloud.dataproc.v1.WorkflowTemplateServiceClient;
import java.util.HashMap;
import java.util.Map;

public class SyncInstantiateWorkflowTemplateStringMapstringstring {

  public static void main(String[] args) throws Exception {
    syncInstantiateWorkflowTemplateStringMapstringstring();
  }

  public static void syncInstantiateWorkflowTemplateStringMapstringstring() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (WorkflowTemplateServiceClient workflowTemplateServiceClient =
        WorkflowTemplateServiceClient.create()) {
      String name =
          WorkflowTemplateName.ofProjectRegionWorkflowTemplateName(
                  "[PROJECT]", "[REGION]", "[WORKFLOW_TEMPLATE]")
              .toString();
      Map<String, String> parameters = new HashMap<>();
      workflowTemplateServiceClient.instantiateWorkflowTemplateAsync(name, parameters).get();
    }
  }
}
// [END
// dataproc_v1_generated_workflowtemplateserviceclient_instantiateworkflowtemplate_stringmapstringstring_sync]
