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

package com.google.cloud.automl.v1beta1.samples;

// [START automl_v1beta1_generated_automlclient_createdataset_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.CreateDatasetRequest;
import com.google.cloud.automl.v1beta1.Dataset;
import com.google.cloud.automl.v1beta1.LocationName;

public class AsyncCreateDataset {

  public static void main(String[] args) throws Exception {
    asyncCreateDataset();
  }

  public static void asyncCreateDataset() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AutoMlClient autoMlClient = AutoMlClient.create()) {
      CreateDatasetRequest request =
          CreateDatasetRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setDataset(Dataset.newBuilder().build())
              .build();
      ApiFuture<Dataset> future = autoMlClient.createDatasetCallable().futureCall(request);
      // Do something.
      Dataset response = future.get();
    }
  }
}
// [END automl_v1beta1_generated_automlclient_createdataset_async]
