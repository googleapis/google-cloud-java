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

// [START automl_language_sentiment_analysis_create_dataset]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.automl.v1.AutoMlClient;
import com.google.cloud.automl.v1.Dataset;
import com.google.cloud.automl.v1.LocationName;
import com.google.cloud.automl.v1.OperationMetadata;
import com.google.cloud.automl.v1.TextSentimentDatasetMetadata;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

class LanguageSentimentAnalysisCreateDataset {

  static void createDataset() throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR_PROJECT_ID";
    String displayName = "YOUR_DATASET_NAME";
    createDataset(projectId, displayName);
  }

  // Create a dataset
  static void createDataset(String projectId, String displayName)
      throws IOException, ExecutionException, InterruptedException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AutoMlClient client = AutoMlClient.create()) {
      // A resource that represents Google Cloud Platform location.
      LocationName projectLocation = LocationName.of(projectId, "us-central1");
      // Specify the text classification type for the dataset.
      TextSentimentDatasetMetadata metadata =
          TextSentimentDatasetMetadata.newBuilder()
              .setSentimentMax(4) // Possible max sentiment score: 1-10
              .build();
      Dataset dataset =
          Dataset.newBuilder()
              .setDisplayName(displayName)
              .setTextSentimentDatasetMetadata(metadata)
              .build();
      OperationFuture<Dataset, OperationMetadata> future =
          client.createDatasetAsync(projectLocation, dataset);

      Dataset createdDataset = future.get();

      // Display the dataset information.
      System.out.format("Dataset name: %s\n", createdDataset.getName());
      // To get the dataset id, you have to parse it out of the `name` field. As dataset Ids are
      // required for other methods.
      // Name Form: `projects/{project_id}/locations/{location_id}/datasets/{dataset_id}`
      String[] names = createdDataset.getName().split("/");
      String datasetId = names[names.length - 1];
      System.out.format("Dataset id: %s\n", datasetId);
    }
  }
}
// [END automl_language_sentiment_analysis_create_dataset]
