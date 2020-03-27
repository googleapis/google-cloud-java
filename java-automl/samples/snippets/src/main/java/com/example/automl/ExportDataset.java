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

package com.example.automl;

// [START automl_export_dataset]
import com.google.cloud.automl.v1.AutoMlClient;
import com.google.cloud.automl.v1.DatasetName;
import com.google.cloud.automl.v1.GcsDestination;
import com.google.cloud.automl.v1.OutputConfig;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

class ExportDataset {

  static void exportDataset() throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR_PROJECT_ID";
    String datasetId = "YOUR_DATASET_ID";
    String gcsUri = "gs://BUCKET_ID/path_to_export/";
    exportDataset(projectId, datasetId, gcsUri);
  }

  // Export a dataset to a GCS bucket
  static void exportDataset(String projectId, String datasetId, String gcsUri)
      throws IOException, ExecutionException, InterruptedException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AutoMlClient client = AutoMlClient.create()) {
      // Get the complete path of the dataset.
      DatasetName datasetFullId = DatasetName.of(projectId, "us-central1", datasetId);
      GcsDestination gcsDestination =
          GcsDestination.newBuilder().setOutputUriPrefix(gcsUri).build();

      // Export the dataset to the output URI.
      OutputConfig outputConfig =
          OutputConfig.newBuilder().setGcsDestination(gcsDestination).build();

      System.out.println("Processing export...");
      Empty response = client.exportDataAsync(datasetFullId, outputConfig).get();
      System.out.format("Dataset exported. %s\n", response);
    }
  }
}
// [END automl_export_dataset]
