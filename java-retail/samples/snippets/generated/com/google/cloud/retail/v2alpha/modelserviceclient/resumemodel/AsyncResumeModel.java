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

package com.google.cloud.retail.v2alpha.samples;

// [START retail_v2alpha_generated_modelserviceclient_resumemodel_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.retail.v2alpha.Model;
import com.google.cloud.retail.v2alpha.ModelServiceClient;
import com.google.cloud.retail.v2alpha.ResumeModelRequest;

public class AsyncResumeModel {

  public static void main(String[] args) throws Exception {
    asyncResumeModel();
  }

  public static void asyncResumeModel() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
      ResumeModelRequest request = ResumeModelRequest.newBuilder().setName("name3373707").build();
      ApiFuture<Model> future = modelServiceClient.resumeModelCallable().futureCall(request);
      // Do something.
      Model response = future.get();
    }
  }
}
// [END retail_v2alpha_generated_modelserviceclient_resumemodel_async]
