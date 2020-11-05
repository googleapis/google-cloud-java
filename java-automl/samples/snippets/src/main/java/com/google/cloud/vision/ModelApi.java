/*
 * Copyright 2018 Google Inc.
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

package com.google.cloud.vision;

// Imports the Google Cloud client library
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.automl.v1.AutoMlClient;
import com.google.cloud.automl.v1.ImageClassificationModelMetadata;
import com.google.cloud.automl.v1.LocationName;
import com.google.cloud.automl.v1.Model;
import com.google.cloud.automl.v1.OperationMetadata;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Google Cloud AutoML Vision API sample application. Example usage: mvn package exec:java
 * -Dexec.mainClass ='com.google.cloud.vision.samples.automl.ModelApi' -Dexec.args='create_model
 * [datasetId] test_model'
 */
public class ModelApi {

  // [START automl_vision_create_model]
  /**
   * Demonstrates using the AutoML client to create a model.
   *
   * @param projectId the Id of the project.
   * @param computeRegion the Region name.
   * @param dataSetId the Id of the dataset to which model is created.
   * @param modelName the Name of the model.
   * @param trainBudget the Budget for training the model.
   */
  static void createModel(
      String projectId,
      String computeRegion,
      String dataSetId,
      String modelName,
      String trainBudget) throws IOException, ExecutionException, InterruptedException {
    // Instantiates a client
    try (AutoMlClient client = AutoMlClient.create()) {

      // A resource that represents Google Cloud Platform location.
      LocationName projectLocation = LocationName.of(projectId, computeRegion);

      // Set model metadata.
      ImageClassificationModelMetadata imageClassificationModelMetadata =
          Long.valueOf(trainBudget) == 0
              ? ImageClassificationModelMetadata.newBuilder().build()
              : ImageClassificationModelMetadata.newBuilder()
                  .setTrainBudgetMilliNodeHours(Long.valueOf(trainBudget))
                  .build();

      // Set model name and model metadata for the image dataset.
      Model myModel =
          Model.newBuilder()
              .setDisplayName(modelName)
              .setDatasetId(dataSetId)
              .setImageClassificationModelMetadata(imageClassificationModelMetadata)
              .build();

      // Create a model with the model metadata in the region.
      OperationFuture<Model, OperationMetadata> response =
          client.createModelAsync(projectLocation, myModel);

      System.out.println(
          String.format(
              "Training operation name: %s", response.getInitialFuture().get().getName()));
      System.out.println("Training started...");
    }
  }
  // [END automl_vision_create_model]
}
