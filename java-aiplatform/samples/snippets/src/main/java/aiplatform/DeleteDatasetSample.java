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

// [START aiplatform_delete_dataset_sample]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1beta1.DatasetName;
import com.google.cloud.aiplatform.v1beta1.DatasetServiceClient;
import com.google.cloud.aiplatform.v1beta1.DatasetServiceSettings;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class DeleteDatasetSample {

  public static void main(String[] args)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String datasetId = "YOUR_DATASET_ID";
    deleteDatasetSample(project, datasetId);
  }

  static void deleteDatasetSample(String project, String datasetId)
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
      DatasetName datasetName = DatasetName.of(project, location, datasetId);

      OperationFuture<Empty, DeleteOperationMetadata> operationFuture =
          datasetServiceClient.deleteDatasetAsync(datasetName);
      System.out.format("Operation name: %s\n", operationFuture.getInitialFuture().get().getName());
      System.out.println("Waiting for operation to finish...");
      operationFuture.get(300, TimeUnit.SECONDS);

      System.out.format("Deleted Dataset.");
    }
  }
}
// [END aiplatform_delete_dataset_sample]
