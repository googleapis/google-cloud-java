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

package com.google.cloud.translate.automl;

// [START automl_translate_list_dataset]
import com.google.cloud.automl.v1.AutoMlClient;
import com.google.cloud.automl.v1.Dataset;
import com.google.cloud.automl.v1.ListDatasetsRequest;
import com.google.cloud.automl.v1.LocationName;

import java.io.IOException;

class ListDatasets {

  // List the datasets
  static void listDatasets(String projectId) {
    // String projectId = "YOUR_PROJECT_ID";

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AutoMlClient client = AutoMlClient.create()) {
      // A resource that represents Google Cloud Platform location.
      LocationName projectLocation = LocationName.of(projectId, "us-central1");
      ListDatasetsRequest request =
          ListDatasetsRequest.newBuilder()
              .setParent(projectLocation.toString())
              .setFilter("translation_dataset_metadata:*")
              .build();

      // List all the datasets available in the region by applying filter.
      System.out.println("List of datasets:");
      for (Dataset dataset : client.listDatasets(request).iterateAll()) {
        // Display the dataset information
        System.out.format("\nDataset name: %s\n", dataset.getName());
        // To get the dataset id, you have to parse it out of the `name` field. As dataset Ids are
        // required for other methods.
        // Name Form: `projects/{project_id}/locations/{location_id}/datasets/{dataset_id}`
        String[] names = dataset.getName().split("/");
        String retrievedDatasetId = names[names.length - 1];
        System.out.format("Dataset id: %s\n", retrievedDatasetId);
        System.out.format("Dataset display name: %s\n", dataset.getDisplayName());
        System.out.println("Translation dataset metadata:");
        System.out.format(
            "\tSource language code: %s\n",
            dataset.getTranslationDatasetMetadata().getSourceLanguageCode());
        System.out.format(
            "\tTarget language code: %s\n",
            dataset.getTranslationDatasetMetadata().getTargetLanguageCode());
        System.out.println("Dataset create time:");
        System.out.format("\tseconds: %s\n", dataset.getCreateTime().getSeconds());
        System.out.format("\tnanos: %s\n", dataset.getCreateTime().getNanos());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
// [END automl_translate_list_dataset]
