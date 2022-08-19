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

// [START datalabeling_v1beta1_generated_datalabelingserviceclient_getexample_examplenamestring_sync]
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient;
import com.google.cloud.datalabeling.v1beta1.Example;
import com.google.cloud.datalabeling.v1beta1.ExampleName;

public class SyncGetExampleExamplenameString {

  public static void main(String[] args) throws Exception {
    syncGetExampleExamplenameString();
  }

  public static void syncGetExampleExamplenameString() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (DataLabelingServiceClient dataLabelingServiceClient = DataLabelingServiceClient.create()) {
      ExampleName name =
          ExampleName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]", "[EXAMPLE]");
      String filter = "filter-1274492040";
      Example response = dataLabelingServiceClient.getExample(name, filter);
    }
  }
}
// [END datalabeling_v1beta1_generated_datalabelingserviceclient_getexample_examplenamestring_sync]
