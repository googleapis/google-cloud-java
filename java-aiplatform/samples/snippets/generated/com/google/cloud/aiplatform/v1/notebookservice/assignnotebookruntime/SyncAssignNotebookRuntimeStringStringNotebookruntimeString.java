/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.aiplatform.v1.samples;

// [START aiplatform_v1_generated_NotebookService_AssignNotebookRuntime_StringStringNotebookruntimeString_sync]
import com.google.cloud.aiplatform.v1.LocationName;
import com.google.cloud.aiplatform.v1.NotebookRuntime;
import com.google.cloud.aiplatform.v1.NotebookRuntimeTemplateName;
import com.google.cloud.aiplatform.v1.NotebookServiceClient;

public class SyncAssignNotebookRuntimeStringStringNotebookruntimeString {

  public static void main(String[] args) throws Exception {
    syncAssignNotebookRuntimeStringStringNotebookruntimeString();
  }

  public static void syncAssignNotebookRuntimeStringStringNotebookruntimeString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
      String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
      String notebookRuntimeTemplate =
          NotebookRuntimeTemplateName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]")
              .toString();
      NotebookRuntime notebookRuntime = NotebookRuntime.newBuilder().build();
      String notebookRuntimeId = "notebookRuntimeId400795512";
      NotebookRuntime response =
          notebookServiceClient
              .assignNotebookRuntimeAsync(
                  parent, notebookRuntimeTemplate, notebookRuntime, notebookRuntimeId)
              .get();
    }
  }
}
// [END aiplatform_v1_generated_NotebookService_AssignNotebookRuntime_StringStringNotebookruntimeString_sync]
