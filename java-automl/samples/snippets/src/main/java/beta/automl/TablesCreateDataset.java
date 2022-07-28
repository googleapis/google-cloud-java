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

// [START automl_tables_create_dataset]
import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.Dataset;
import com.google.cloud.automl.v1beta1.LocationName;
import com.google.cloud.automl.v1beta1.TablesDatasetMetadata;
import java.io.IOException;

class TablesCreateDataset {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR_PROJECT_ID";
    String displayName = "YOUR_DATASET_NAME";
    createDataset(projectId, displayName);
  }

  // Create a dataset
  static void createDataset(String projectId, String displayName) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AutoMlClient client = AutoMlClient.create()) {
      // A resource that represents Google Cloud Platform location.
      LocationName projectLocation = LocationName.of(projectId, "us-central1");
      TablesDatasetMetadata metadata = TablesDatasetMetadata.newBuilder().build();
      Dataset dataset =
          Dataset.newBuilder()
              .setDisplayName(displayName)
              .setTablesDatasetMetadata(metadata)
              .build();

      Dataset createdDataset = client.createDataset(projectLocation, dataset);

      // Display the dataset information.
      System.out.format("Dataset name: %s%n", createdDataset.getName());
      // To get the dataset id, you have to parse it out of the `name` field. As dataset Ids are
      // required for other methods.
      // Name Form: `projects/{project_id}/locations/{location_id}/datasets/{dataset_id}`
      String[] names = createdDataset.getName().split("/");
      String datasetId = names[names.length - 1];
      System.out.format("Dataset id: %s%n", datasetId);
    }
  }
}
// [END automl_tables_create_dataset]
