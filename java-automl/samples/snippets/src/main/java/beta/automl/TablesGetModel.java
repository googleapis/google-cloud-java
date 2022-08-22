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

// [START automl_tables_get_model]

import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.Model;
import com.google.cloud.automl.v1beta1.ModelName;
import com.google.cloud.automl.v1beta1.TablesModelColumnInfo;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TablesGetModel {

  public static void main(String[] args) throws IOException, StatusRuntimeException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR_PROJECT_ID";
    String region = "YOUR_REGION";
    String modelId = "YOUR_MODEL_ID";
    getModel(projectId, region, modelId);
  }

  // Demonstrates using the AutoML client to get model details.
  public static void getModel(String projectId, String computeRegion, String modelId)
      throws IOException, StatusRuntimeException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AutoMlClient client = AutoMlClient.create()) {

      // Get the full path of the model.
      ModelName modelFullId = ModelName.of(projectId, computeRegion, modelId);

      // Get complete detail of the model.
      Model model = client.getModel(modelFullId);

      // Display the model information.
      System.out.format("Model name: %s%n", model.getName());
      System.out.format(
          "Model Id: %s\n", model.getName().split("/")[model.getName().split("/").length - 1]);
      System.out.format("Model display name: %s%n", model.getDisplayName());
      System.out.format("Dataset Id: %s%n", model.getDatasetId());
      System.out.println("Tables Model Metadata: ");
      System.out.format(
          "\tTraining budget: %s%n", model.getTablesModelMetadata().getTrainBudgetMilliNodeHours());
      System.out.format(
          "\tTraining cost: %s%n", model.getTablesModelMetadata().getTrainBudgetMilliNodeHours());

      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
      String createTime =
          dateFormat.format(new java.util.Date(model.getCreateTime().getSeconds() * 1000));
      System.out.format("Model create time: %s%n", createTime);

      System.out.format("Model deployment state: %s%n", model.getDeploymentState());

      // Get features of top importance
      for (TablesModelColumnInfo info :
          model.getTablesModelMetadata().getTablesModelColumnInfoList()) {
        System.out.format(
            "Column: %s - Importance: %.2f%n",
            info.getColumnDisplayName(), info.getFeatureImportance());
      }
    }
  }
}
// [END automl_tables_get_model]
