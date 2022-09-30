/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.datalabeling;

// [START datalabeling_export_data_beta]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceSettings;
import com.google.cloud.datalabeling.v1beta1.ExportDataOperationMetadata;
import com.google.cloud.datalabeling.v1beta1.ExportDataOperationResponse;
import com.google.cloud.datalabeling.v1beta1.ExportDataRequest;
import com.google.cloud.datalabeling.v1beta1.GcsDestination;
import com.google.cloud.datalabeling.v1beta1.LabelStats;
import com.google.cloud.datalabeling.v1beta1.OutputConfig;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutionException;

class ExportData {

  // Export data from an annotated dataset.
  static void exportData(String datasetName, String annotatedDatasetName, String gcsOutputUri)
      throws IOException {
    // String datasetName = DataLabelingServiceClient.formatDatasetName(
    //     "YOUR_PROJECT_ID", "YOUR_DATASETS_UUID");
    // String annotatedDatasetName = DataLabelingServiceClient.formatAnnotatedDatasetName(
    //     "YOUR_PROJECT_ID",
    //     "YOUR_DATASET_UUID",
    //     "YOUR_ANNOTATED_DATASET_UUID");
    // String gcsOutputUri = "gs://YOUR_BUCKET_ID/export_path";

    // [END datalabeling_export_data_beta]
    String endpoint = System.getenv("DATALABELING_ENDPOINT");
    if (endpoint == null) {
      endpoint = DataLabelingServiceSettings.getDefaultEndpoint();
    }
    // [START datalabeling_export_data_beta]

    DataLabelingServiceSettings settings =
        DataLabelingServiceSettings.newBuilder()
            // [END datalabeling_export_data_beta]
            .setEndpoint(endpoint)
            // [START datalabeling_export_data_beta]
            .build();
    try (DataLabelingServiceClient dataLabelingServiceClient =
        DataLabelingServiceClient.create(settings)) {
      GcsDestination gcsDestination =
          GcsDestination.newBuilder().setOutputUri(gcsOutputUri).setMimeType("text/csv").build();

      OutputConfig outputConfig =
          OutputConfig.newBuilder().setGcsDestination(gcsDestination).build();

      ExportDataRequest exportDataRequest =
          ExportDataRequest.newBuilder()
              .setName(datasetName)
              .setOutputConfig(outputConfig)
              .setAnnotatedDataset(annotatedDatasetName)
              .build();

      OperationFuture<ExportDataOperationResponse, ExportDataOperationMetadata> operation =
          dataLabelingServiceClient.exportDataAsync(exportDataRequest);

      ExportDataOperationResponse response = operation.get();

      System.out.format("Exported item count: %d\n", response.getExportCount());
      LabelStats labelStats = response.getLabelStats();
      Set<Entry<String, Long>> entries = labelStats.getExampleCountMap().entrySet();
      for (Entry<String, Long> entry : entries) {
        System.out.format("\tLabel: %s\n", entry.getKey());
        System.out.format("\tCount: %d\n\n", entry.getValue());
      }
    } catch (IOException | InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}
// [END datalabeling_export_data_beta]
