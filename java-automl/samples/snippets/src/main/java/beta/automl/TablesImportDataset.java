/*
 * Copyright 2020 Google LLC
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

package beta.automl;

// [START automl_tables_import_data]
import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.BigQuerySource;
import com.google.cloud.automl.v1beta1.DatasetName;
import com.google.cloud.automl.v1beta1.GcsSource;
import com.google.cloud.automl.v1beta1.InputConfig;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

class TablesImportDataset {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR_PROJECT_ID";
    String datasetId = "YOUR_DATASET_ID";
    String path = "gs://BUCKET_ID/path/to//data.csv or bq://project_id.dataset_id.table_id";
    importDataset(projectId, datasetId, path);
  }

  // Import a dataset via BigQuery or Google Cloud Storage
  static void importDataset(String projectId, String datasetId, String path)
      throws IOException, ExecutionException, InterruptedException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AutoMlClient client = AutoMlClient.create()) {
      // Get the complete path of the dataset.
      DatasetName datasetFullId = DatasetName.of(projectId, "us-central1", datasetId);

      InputConfig.Builder inputConfigBuilder = InputConfig.newBuilder();

      // Determine which source type was used for the input path (BigQuery or GCS)
      if (path.startsWith("bq")) {
        // Get training data file to be imported from a BigQuery source.
        BigQuerySource.Builder bigQuerySource = BigQuerySource.newBuilder();
        bigQuerySource.setInputUri(path);
        inputConfigBuilder.setBigquerySource(bigQuerySource);
      } else {
        // Get multiple Google Cloud Storage URIs to import data from
        GcsSource gcsSource =
            GcsSource.newBuilder().addAllInputUris(Arrays.asList(path.split(","))).build();
        inputConfigBuilder.setGcsSource(gcsSource);
      }

      // Import data from the input URI
      System.out.println("Processing import...");

      Empty response = client.importDataAsync(datasetFullId, inputConfigBuilder.build()).get();
      System.out.format("Dataset imported. %s%n", response);
    }
  }
}
// [END automl_tables_import_data]
