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

// [START datalabeling_import_data_beta]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceSettings;
import com.google.cloud.datalabeling.v1beta1.DataType;
import com.google.cloud.datalabeling.v1beta1.GcsSource;
import com.google.cloud.datalabeling.v1beta1.ImportDataOperationMetadata;
import com.google.cloud.datalabeling.v1beta1.ImportDataOperationResponse;
import com.google.cloud.datalabeling.v1beta1.ImportDataRequest;
import com.google.cloud.datalabeling.v1beta1.InputConfig;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

class ImportData {

  // Import data to an existing dataset.
  static void importData(String datasetName, String gcsSourceUri) throws IOException {
    // String datasetName = DataLabelingServiceClient.formatDatasetName(
    //     "YOUR_PROJECT_ID", "YOUR_DATASETS_UUID");
    // String gcsSourceUri = "gs://YOUR_BUCKET_ID/path_to_data";

    // [END datalabeling_import_data_beta]
    String endpoint = System.getenv("DATALABELING_ENDPOINT");
    if (endpoint == null) {
      endpoint = DataLabelingServiceSettings.getDefaultEndpoint();
    }
    // [START datalabeling_import_data_beta]

    DataLabelingServiceSettings settings =
        DataLabelingServiceSettings.newBuilder()
            // [END datalabeling_import_data_beta]
            .setEndpoint(endpoint)
            // [START datalabeling_import_data_beta]
            .build();
    try (DataLabelingServiceClient dataLabelingServiceClient =
        DataLabelingServiceClient.create(settings)) {
      GcsSource gcsSource =
          GcsSource.newBuilder().setInputUri(gcsSourceUri).setMimeType("text/csv").build();

      InputConfig inputConfig =
          InputConfig.newBuilder()
              .setDataType(DataType.IMAGE) // DataTypes: AUDIO, IMAGE, VIDEO, TEXT
              .setGcsSource(gcsSource)
              .build();

      ImportDataRequest importDataRequest =
          ImportDataRequest.newBuilder().setName(datasetName).setInputConfig(inputConfig).build();

      OperationFuture<ImportDataOperationResponse, ImportDataOperationMetadata> operation =
          dataLabelingServiceClient.importDataAsync(importDataRequest);

      ImportDataOperationResponse response = operation.get();

      System.out.format("Imported items: %d\n", response.getImportCount());
    } catch (IOException | InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}
// [END datalabeling_import_data_beta]
