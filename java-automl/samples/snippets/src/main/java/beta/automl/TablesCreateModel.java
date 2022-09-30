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

// [START automl_tables_create_model]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.ColumnSpec;
import com.google.cloud.automl.v1beta1.ColumnSpecName;
import com.google.cloud.automl.v1beta1.LocationName;
import com.google.cloud.automl.v1beta1.Model;
import com.google.cloud.automl.v1beta1.OperationMetadata;
import com.google.cloud.automl.v1beta1.TablesModelMetadata;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

class TablesCreateModel {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR_PROJECT_ID";
    String datasetId = "YOUR_DATASET_ID";
    String tableSpecId = "YOUR_TABLE_SPEC_ID";
    String columnSpecId = "YOUR_COLUMN_SPEC_ID";
    String displayName = "YOUR_DATASET_NAME";
    createModel(projectId, datasetId, tableSpecId, columnSpecId, displayName);
  }

  // Create a model
  static void createModel(
      String projectId,
      String datasetId,
      String tableSpecId,
      String columnSpecId,
      String displayName)
      throws IOException, ExecutionException, InterruptedException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AutoMlClient client = AutoMlClient.create()) {
      // A resource that represents Google Cloud Platform location.
      LocationName projectLocation = LocationName.of(projectId, "us-central1");

      // Get the complete path of the column.
      ColumnSpecName columnSpecName =
          ColumnSpecName.of(projectId, "us-central1", datasetId, tableSpecId, columnSpecId);

      // Build the get column spec.
      ColumnSpec targetColumnSpec =
          ColumnSpec.newBuilder().setName(columnSpecName.toString()).build();

      // Set model metadata.
      TablesModelMetadata metadata =
          TablesModelMetadata.newBuilder()
              .setTargetColumnSpec(targetColumnSpec)
              .setTrainBudgetMilliNodeHours(24000)
              .build();

      Model model =
          Model.newBuilder()
              .setDisplayName(displayName)
              .setDatasetId(datasetId)
              .setTablesModelMetadata(metadata)
              .build();

      // Create a model with the model metadata in the region.
      OperationFuture<Model, OperationMetadata> future =
          client.createModelAsync(projectLocation, model);
      // OperationFuture.get() will block until the model is created, which may take several hours.
      // You can use OperationFuture.getInitialFuture to get a future representing the initial
      // response to the request, which contains information while the operation is in progress.
      System.out.format("Training operation name: %s%n", future.getInitialFuture().get().getName());
      System.out.println("Training started...");
    }
  }
}
// [END automl_tables_create_model]
