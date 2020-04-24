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

// [START automl_import_dataset]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.automl.v1.AutoMlClient;
import com.google.cloud.automl.v1.DatasetName;
import com.google.cloud.automl.v1.GcsSource;
import com.google.cloud.automl.v1.InputConfig;
import com.google.cloud.automl.v1.OperationMetadata;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class ImportDataset {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR_PROJECT_ID";
    String datasetId = "YOUR_DATASET_ID";
    String path = "gs://BUCKET_ID/path_to_training_data.csv";
    importDataset(projectId, datasetId, path);
  }

  // Import a dataset
  static void importDataset(String projectId, String datasetId, String path)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AutoMlClient client = AutoMlClient.create()) {
      // Get the complete path of the dataset.
      DatasetName datasetFullId = DatasetName.of(projectId, "us-central1", datasetId);

      // Get multiple Google Cloud Storage URIs to import data from
      GcsSource gcsSource =
          GcsSource.newBuilder().addAllInputUris(Arrays.asList(path.split(","))).build();

      // Import data from the input URI
      InputConfig inputConfig = InputConfig.newBuilder().setGcsSource(gcsSource).build();
      System.out.println("Processing import...");

      // Start the import job
      OperationFuture<Empty, OperationMetadata> operation =
          client.importDataAsync(datasetFullId, inputConfig);

      System.out.format("Operation name: %s%n", operation.getName());

      // If you want to wait for the operation to finish, adjust the timeout appropriately. The
      // operation will still run if you choose not to wait for it to complete. You can check the
      // status of your operation using the operation's name.
      Empty response = operation.get(45, TimeUnit.MINUTES);
      System.out.format("Dataset imported. %s%n", response);
    } catch (TimeoutException e) {
      System.out.println("The operation's polling period was not long enough.");
      System.out.println("You can use the Operation's name to get the current status.");
      System.out.println("The import job is still running and will complete as expected.");
      throw e;
    }
  }
}
// [END automl_import_dataset]
