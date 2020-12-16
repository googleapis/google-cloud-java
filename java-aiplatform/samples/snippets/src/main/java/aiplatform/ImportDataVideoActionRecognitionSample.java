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

package aiplatform;

// [START aiplatform_import_data_video_action_recognition_sample]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1beta1.DatasetName;
import com.google.cloud.aiplatform.v1beta1.DatasetServiceClient;
import com.google.cloud.aiplatform.v1beta1.DatasetServiceSettings;
import com.google.cloud.aiplatform.v1beta1.GcsSource;
import com.google.cloud.aiplatform.v1beta1.ImportDataConfig;
import com.google.cloud.aiplatform.v1beta1.ImportDataOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ImportDataResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ImportDataVideoActionRecognitionSample {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "PROJECT";
    String datasetId = "DATASET_ID";
    String gcsSourceUri = "GCS_SOURCE_URI";
    importDataVideoActionRecognitionSample(project, datasetId, gcsSourceUri);
  }

  static void importDataVideoActionRecognitionSample(
      String project, String datasetId, String gcsSourceUri)
      throws IOException, ExecutionException, InterruptedException {
    DatasetServiceSettings settings =
        DatasetServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();
    String location = "us-central1";

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DatasetServiceClient client = DatasetServiceClient.create(settings)) {
      GcsSource gcsSource = GcsSource.newBuilder().addUris(gcsSourceUri).build();
      ImportDataConfig importConfig0 =
          ImportDataConfig.newBuilder()
              .setGcsSource(gcsSource)
              .setImportSchemaUri(
                  "gs://google-cloud-aiplatform/schema/dataset/ioformat/"
                      + "video_action_recognition_io_format_1.0.0.yaml")
              .build();
      List<ImportDataConfig> importConfigs = new ArrayList<>();
      importConfigs.add(importConfig0);
      DatasetName name = DatasetName.of(project, location, datasetId);
      OperationFuture<ImportDataResponse, ImportDataOperationMetadata> response =
          client.importDataAsync(name, importConfigs);

      // You can use OperationFuture.getInitialFuture to get a future representing the initial
      // response to the request, which contains information while the operation is in progress.
      System.out.format("Operation name: %s\n", response.getInitialFuture().get().getName());

      // OperationFuture.get() will block until the operation is finished.
      ImportDataResponse importDataResponse = response.get();
      System.out.format("importDataResponse: %s\n", importDataResponse);
    }
  }
}

// [END aiplatform_import_data_video_action_recognition_sample]
