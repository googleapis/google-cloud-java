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

package com.google.cloud.datalabeling.v1beta1.samples;

// [START datalabeling_v1beta1_generated_datalabelingserviceclient_getexample_sync]
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient;
import com.google.cloud.datalabeling.v1beta1.Example;
import com.google.cloud.datalabeling.v1beta1.ExampleName;
import com.google.cloud.datalabeling.v1beta1.GetExampleRequest;

public class SyncGetExample {

  public static void main(String[] args) throws Exception {
    syncGetExample();
  }

  public static void syncGetExample() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (DataLabelingServiceClient dataLabelingServiceClient = DataLabelingServiceClient.create()) {
      GetExampleRequest request =
          GetExampleRequest.newBuilder()
              .setName(
                  ExampleName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]", "[EXAMPLE]")
                      .toString())
              .setFilter("filter-1274492040")
              .build();
      Example response = dataLabelingServiceClient.getExample(request);
    }
  }
}
// [END datalabeling_v1beta1_generated_datalabelingserviceclient_getexample_sync]
