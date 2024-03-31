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

package com.google.cloud.aiplatform.v1beta1.samples;

// [START aiplatform_v1beta1_generated_NotebookService_DeleteNotebookRuntimeTemplate_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeTemplateRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.NotebookRuntimeTemplateName;
import com.google.cloud.aiplatform.v1beta1.NotebookServiceClient;
import com.google.protobuf.Empty;

public class AsyncDeleteNotebookRuntimeTemplateLRO {

  public static void main(String[] args) throws Exception {
    asyncDeleteNotebookRuntimeTemplateLRO();
  }

  public static void asyncDeleteNotebookRuntimeTemplateLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
      DeleteNotebookRuntimeTemplateRequest request =
          DeleteNotebookRuntimeTemplateRequest.newBuilder()
              .setName(
                  NotebookRuntimeTemplateName.of(
                          "[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]")
                      .toString())
              .build();
      OperationFuture<Empty, DeleteOperationMetadata> future =
          notebookServiceClient
              .deleteNotebookRuntimeTemplateOperationCallable()
              .futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END aiplatform_v1beta1_generated_NotebookService_DeleteNotebookRuntimeTemplate_LRO_async]
