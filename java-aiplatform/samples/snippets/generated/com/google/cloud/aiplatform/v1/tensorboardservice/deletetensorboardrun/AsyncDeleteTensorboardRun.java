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

package com.google.cloud.aiplatform.v1.samples;

// [START aiplatform_v1_generated_TensorboardService_DeleteTensorboardRun_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.aiplatform.v1.DeleteTensorboardRunRequest;
import com.google.cloud.aiplatform.v1.TensorboardRunName;
import com.google.cloud.aiplatform.v1.TensorboardServiceClient;
import com.google.longrunning.Operation;

public class AsyncDeleteTensorboardRun {

  public static void main(String[] args) throws Exception {
    asyncDeleteTensorboardRun();
  }

  public static void asyncDeleteTensorboardRun() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TensorboardServiceClient tensorboardServiceClient = TensorboardServiceClient.create()) {
      DeleteTensorboardRunRequest request =
          DeleteTensorboardRunRequest.newBuilder()
              .setName(
                  TensorboardRunName.of(
                          "[PROJECT]", "[LOCATION]", "[TENSORBOARD]", "[EXPERIMENT]", "[RUN]")
                      .toString())
              .build();
      ApiFuture<Operation> future =
          tensorboardServiceClient.deleteTensorboardRunCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END aiplatform_v1_generated_TensorboardService_DeleteTensorboardRun_async]
