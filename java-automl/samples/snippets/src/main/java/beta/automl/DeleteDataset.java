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

// [START automl_delete_dataset_beta]
// [START automl_tables_delete_dataset]
import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.DatasetName;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

class DeleteDataset {

  static void deleteDataset() throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR_PROJECT_ID";
    String datasetId = "YOUR_DATASET_ID";
    deleteDataset(projectId, datasetId);
  }

  // Delete a dataset
  static void deleteDataset(String projectId, String datasetId)
      throws IOException, ExecutionException, InterruptedException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AutoMlClient client = AutoMlClient.create()) {
      // Get the full path of the dataset.
      DatasetName datasetFullId = DatasetName.of(projectId, "us-central1", datasetId);
      Empty response = client.deleteDatasetAsync(datasetFullId).get();
      System.out.format("Dataset deleted. %s%n", response);
    }
  }
}
// [END automl_tables_delete_dataset]
// [END automl_delete_dataset_beta]
