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

// [START aiplatform_create_dataset_tabular_gcs_sample]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1.CreateDatasetOperationMetadata;
import com.google.cloud.aiplatform.v1.Dataset;
import com.google.cloud.aiplatform.v1.DatasetServiceClient;
import com.google.cloud.aiplatform.v1.DatasetServiceSettings;
import com.google.cloud.aiplatform.v1.LocationName;
import com.google.protobuf.Value;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CreateDatasetTabularGcsSample {

  public static void main(String[] args)
      throws InterruptedException, ExecutionException, TimeoutException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String datasetDisplayName = "YOUR_DATASET_DISPLAY_NAME";
    String gcsSourceUri = "gs://YOUR_GCS_SOURCE_BUCKET/path_to_your_gcs_table/file.csv";
    ;
    createDatasetTableGcs(project, datasetDisplayName, gcsSourceUri);
  }

  static void createDatasetTableGcs(String project, String datasetDisplayName, String gcsSourceUri)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    DatasetServiceSettings settings =
        DatasetServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DatasetServiceClient datasetServiceClient = DatasetServiceClient.create(settings)) {
      String location = "us-central1";
      String metadataSchemaUri =
          "gs://google-cloud-aiplatform/schema/dataset/metadata/tables_1.0.0.yaml";
      LocationName locationName = LocationName.of(project, location);

      String jsonString =
          "{\"input_config\": {\"gcs_source\": {\"uri\": [\"" + gcsSourceUri + "\"]}}}";
      Value.Builder metaData = Value.newBuilder();
      JsonFormat.parser().merge(jsonString, metaData);

      Dataset dataset =
          Dataset.newBuilder()
              .setDisplayName(datasetDisplayName)
              .setMetadataSchemaUri(metadataSchemaUri)
              .setMetadata(metaData)
              .build();

      OperationFuture<Dataset, CreateDatasetOperationMetadata> datasetFuture =
          datasetServiceClient.createDatasetAsync(locationName, dataset);
      System.out.format("Operation name: %s\n", datasetFuture.getInitialFuture().get().getName());
      System.out.println("Waiting for operation to finish...");
      Dataset datasetResponse = datasetFuture.get(300, TimeUnit.SECONDS);

      System.out.println("Create Dataset Table GCS sample");
      System.out.format("Name: %s\n", datasetResponse.getName());
      System.out.format("Display Name: %s\n", datasetResponse.getDisplayName());
      System.out.format("Metadata Schema Uri: %s\n", datasetResponse.getMetadataSchemaUri());
      System.out.format("Metadata: %s\n", datasetResponse.getMetadata());
    }
  }
}
// [END aiplatform_create_dataset_tabular_gcs_sample]
