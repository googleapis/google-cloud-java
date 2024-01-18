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

package com.google.dataflow.v1beta3.samples;

// [START dataflow_v1beta3_generated_TemplatesService_GetTemplate_async]
import com.google.api.core.ApiFuture;
import com.google.dataflow.v1beta3.GetTemplateRequest;
import com.google.dataflow.v1beta3.GetTemplateResponse;
import com.google.dataflow.v1beta3.TemplatesServiceClient;

public class AsyncGetTemplate {

  public static void main(String[] args) throws Exception {
    asyncGetTemplate();
  }

  public static void asyncGetTemplate() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TemplatesServiceClient templatesServiceClient = TemplatesServiceClient.create()) {
      GetTemplateRequest request =
          GetTemplateRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setLocation("location1901043637")
              .build();
      ApiFuture<GetTemplateResponse> future =
          templatesServiceClient.getTemplateCallable().futureCall(request);
      // Do something.
      GetTemplateResponse response = future.get();
    }
  }
}
// [END dataflow_v1beta3_generated_TemplatesService_GetTemplate_async]
