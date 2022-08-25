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

// [START datalabeling_v1beta1_generated_datalabelingserviceclient_exportdata_lro_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.datalabeling.v1beta1.AnnotatedDatasetName;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient;
import com.google.cloud.datalabeling.v1beta1.DatasetName;
import com.google.cloud.datalabeling.v1beta1.ExportDataOperationMetadata;
import com.google.cloud.datalabeling.v1beta1.ExportDataOperationResponse;
import com.google.cloud.datalabeling.v1beta1.ExportDataRequest;
import com.google.cloud.datalabeling.v1beta1.OutputConfig;

public class AsyncExportDataLRO {

  public static void main(String[] args) throws Exception {
    asyncExportDataLRO();
  }

  public static void asyncExportDataLRO() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (DataLabelingServiceClient dataLabelingServiceClient = DataLabelingServiceClient.create()) {
      ExportDataRequest request =
          ExportDataRequest.newBuilder()
              .setName(DatasetName.of("[PROJECT]", "[DATASET]").toString())
              .setAnnotatedDataset(
                  AnnotatedDatasetName.of("[PROJECT]", "[DATASET]", "[ANNOTATED_DATASET]")
                      .toString())
              .setFilter("filter-1274492040")
              .setOutputConfig(OutputConfig.newBuilder().build())
              .setUserEmailAddress("userEmailAddress-1844787165")
              .build();
      OperationFuture<ExportDataOperationResponse, ExportDataOperationMetadata> future =
          dataLabelingServiceClient.exportDataOperationCallable().futureCall(request);
      // Do something.
      ExportDataOperationResponse response = future.get();
    }
  }
}
// [END datalabeling_v1beta1_generated_datalabelingserviceclient_exportdata_lro_async]
