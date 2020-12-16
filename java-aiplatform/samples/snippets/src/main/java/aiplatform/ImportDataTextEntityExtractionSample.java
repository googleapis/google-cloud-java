/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package aiplatform;

// [START aiplatform_import_data_text_entity_extraction_sample]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1beta1.DatasetName;
import com.google.cloud.aiplatform.v1beta1.DatasetServiceClient;
import com.google.cloud.aiplatform.v1beta1.DatasetServiceSettings;
import com.google.cloud.aiplatform.v1beta1.GcsSource;
import com.google.cloud.aiplatform.v1beta1.ImportDataConfig;
import com.google.cloud.aiplatform.v1beta1.ImportDataOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ImportDataResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ImportDataTextEntityExtractionSample {

  public static void main(String[] args)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String datasetId = "YOUR_DATASET_ID";
    String gcsSourceUri = "gs://YOUR_GCS_SOURCE_BUCKET/path_to_your_text_source/[file.jsonl]";

    importDataTextEntityExtractionSample(project, datasetId, gcsSourceUri);
  }

  static void importDataTextEntityExtractionSample(
      String project, String datasetId, String gcsSourceUri)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    DatasetServiceSettings datasetServiceSettings =
        DatasetServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DatasetServiceClient datasetServiceClient =
        DatasetServiceClient.create(datasetServiceSettings)) {
      String location = "us-central1";
      String importSchemaUri =
          "gs://google-cloud-aiplatform/schema/dataset/ioformat/"
              + "text_extraction_io_format_1.0.0.yaml";

      GcsSource.Builder gcsSource = GcsSource.newBuilder();
      gcsSource.addUris(gcsSourceUri);
      DatasetName datasetName = DatasetName.of(project, location, datasetId);

      List<ImportDataConfig> importDataConfigList =
          Collections.singletonList(
              ImportDataConfig.newBuilder()
                  .setGcsSource(gcsSource)
                  .setImportSchemaUri(importSchemaUri)
                  .build());

      OperationFuture<ImportDataResponse, ImportDataOperationMetadata> importDataResponseFuture =
          datasetServiceClient.importDataAsync(datasetName, importDataConfigList);
      System.out.format(
          "Operation name: %s\n", importDataResponseFuture.getInitialFuture().get().getName());

      System.out.println("Waiting for operation to finish...");
      ImportDataResponse importDataResponse = importDataResponseFuture.get(300, TimeUnit.SECONDS);
      System.out.format(
          "Import Data Text Entity Extraction Response: %s\n", importDataResponse.toString());
    }
  }
}
// [END aiplatform_import_data_text_entity_extraction_sample]
