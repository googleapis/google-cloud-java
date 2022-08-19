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

// [START datalabeling_v1beta1_generated_datalabelingserviceclient_labelimage_lro_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.datalabeling.v1beta1.AnnotatedDataset;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient;
import com.google.cloud.datalabeling.v1beta1.DatasetName;
import com.google.cloud.datalabeling.v1beta1.HumanAnnotationConfig;
import com.google.cloud.datalabeling.v1beta1.LabelImageRequest;
import com.google.cloud.datalabeling.v1beta1.LabelOperationMetadata;

public class AsyncLabelImageLRO {

  public static void main(String[] args) throws Exception {
    asyncLabelImageLRO();
  }

  public static void asyncLabelImageLRO() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (DataLabelingServiceClient dataLabelingServiceClient = DataLabelingServiceClient.create()) {
      LabelImageRequest request =
          LabelImageRequest.newBuilder()
              .setParent(DatasetName.of("[PROJECT]", "[DATASET]").toString())
              .setBasicConfig(HumanAnnotationConfig.newBuilder().build())
              .build();
      OperationFuture<AnnotatedDataset, LabelOperationMetadata> future =
          dataLabelingServiceClient.labelImageOperationCallable().futureCall(request);
      // Do something.
      AnnotatedDataset response = future.get();
    }
  }
}
// [END datalabeling_v1beta1_generated_datalabelingserviceclient_labelimage_lro_async]
