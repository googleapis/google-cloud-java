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

package com.google.cloud.translate.automl;

// Imports the Google Cloud client library
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.ListModelEvaluationsRequest;
import com.google.cloud.automl.v1beta1.ListModelsRequest;
import com.google.cloud.automl.v1beta1.LocationName;
import com.google.cloud.automl.v1beta1.Model;
import com.google.cloud.automl.v1beta1.ModelEvaluation;
import com.google.cloud.automl.v1beta1.ModelEvaluationName;
import com.google.cloud.automl.v1beta1.ModelName;
import com.google.cloud.automl.v1beta1.OperationMetadata;
import com.google.cloud.automl.v1beta1.TranslationModelMetadata;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;

import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;

/**
 * Google Cloud AutoML Translate API sample application. Example usage: mvn package exec:java
 * -Dexec.mainClass ='com.example.translate.ModelApi' -Dexec.args='create_model [datasetId]
 * test_model'
 */
public class ModelApi {

  // [START automl_translate_create_model]
  /**
   * Demonstrates using the AutoML client to create a model.
   *
   * @param projectId the Id of the project.
   * @param computeRegion the Region name.
   * @param dataSetId the Id of the dataset to which model is created.
   * @param modelName the Name of the model.
   * @throws Exception on AutoML Client errors
   */
  public static void createModel(
      String projectId, String computeRegion, String dataSetId, String modelName) throws Exception {
    // Instantiates a client
    AutoMlClient client = AutoMlClient.create();

    // A resource that represents Google Cloud Platform location.
    LocationName projectLocation = LocationName.of(projectId, computeRegion);

    // Set model metadata.
    TranslationModelMetadata translationModelMetadata =
        TranslationModelMetadata.newBuilder().setBaseModel("").build();

    // Set model name, dataset and metadata.
    Model myModel =
        Model.newBuilder()
            .setDisplayName(modelName)
            .setDatasetId(dataSetId)
            .setTranslationModelMetadata(translationModelMetadata)
            .build();

    // Create a model with the model metadata in the region.
    OperationFuture<Model, OperationMetadata> response =
        client.createModelAsync(projectLocation, myModel);

    System.out.println(
        String.format("Training operation name: %s", response.getInitialFuture().get().getName()));
    System.out.println("Training started...");
  }
  // [END automl_translate_create_model]

  // [START automl_translate_list_models]
  /**
   * Demonstrates using the AutoML client to list all models.
   *
   * @param projectId the Id of the project.
   * @param computeRegion the Region name.
   * @param filter the filter expression.
   * @throws IOException on Input/Output errors.
   */
  public static void listModels(String projectId, String computeRegion, String filter)
      throws IOException {
    // Instantiates a client
    AutoMlClient client = AutoMlClient.create();

    // A resource that represents Google Cloud Platform location.
    LocationName projectLocation = LocationName.of(projectId, computeRegion);

    // Create list models request.
    ListModelsRequest listModlesRequest =
        ListModelsRequest.newBuilder()
            .setParent(projectLocation.toString())
            .setFilter(filter)
            .build();

    // List all the models available in the region by applying filter.
    System.out.println("List of models:");
    for (Model model : client.listModels(listModlesRequest).iterateAll()) {
      // Display the model information.
      System.out.println(String.format("Model name: %s", model.getName()));
      System.out.println(
          String.format(
              "Model id: %s", model.getName().split("/")[model.getName().split("/").length - 1]));
      System.out.println(String.format("Model display name: %s", model.getDisplayName()));
      System.out.println("Model create time:");
      System.out.println(String.format("\tseconds: %s", model.getCreateTime().getSeconds()));
      System.out.println(String.format("\tnanos: %s", model.getCreateTime().getNanos()));
      System.out.println(String.format("Model deployment state: %s", model.getDeploymentState()));
    }
  }
  // [END automl_translate_list_models]

  // [START automl_translate_get_model]
  /**
   * Demonstrates using the AutoML client to get model details.
   *
   * @param projectId the Id of the project.
   * @param computeRegion the Region name.
   * @param modelId the Id of the model.
   * @throws IOException on Input/Output errors.
   */
  public static void getModel(String projectId, String computeRegion, String modelId)
      throws IOException {
    // Instantiates a client
    AutoMlClient client = AutoMlClient.create();

    // Get the full path of the model.
    ModelName modelFullId = ModelName.of(projectId, computeRegion, modelId);

    // Get complete detail of the model.
    Model model = client.getModel(modelFullId);

    // Display the model information.
    System.out.println(String.format("Model name: %s", model.getName()));
    System.out.println(
        String.format(
            "Model id: %s", model.getName().split("/")[model.getName().split("/").length - 1]));
    System.out.println(String.format("Model display name: %s", model.getDisplayName()));
    System.out.println("Model create time:");
    System.out.println(String.format("\tseconds: %s", model.getCreateTime().getSeconds()));
    System.out.println(String.format("\tnanos: %s", model.getCreateTime().getNanos()));
    System.out.println(String.format("Model deployment state: %s", model.getDeploymentState()));
  }
  // [END automl_translate_get_model]

  // [START automl_translate_list_model_evaluations]
  /**
   * Demonstrates using the AutoML client to list model evaluations.
   *
   * @param projectId the Id of the project.
   * @param computeRegion the Region name.
   * @param modelId the Id of the model.
   * @param filter the filter expression.
   * @throws IOException on Input/Output errors.
   */
  public static void listModelEvaluations(
      String projectId, String computeRegion, String modelId, String filter) throws IOException {
    // Instantiates a client
    AutoMlClient client = AutoMlClient.create();

    // Get the full path of the model.
    ModelName modelFullId = ModelName.of(projectId, computeRegion, modelId);

    // Create list model evaluations request
    ListModelEvaluationsRequest modelEvaluationsrequest =
        ListModelEvaluationsRequest.newBuilder()
            .setParent(modelFullId.toString())
            .setFilter(filter)
            .build();

    // List all the model evaluations in the model by applying filter.
    System.out.println("List of model evaluations:");
    for (ModelEvaluation element :
        client.listModelEvaluations(modelEvaluationsrequest).iterateAll()) {
      System.out.println(element);
    }
  }
  // [END automl_translate_list_model_evaluations]

  // [START automl_translate_get_model_evaluation]
  /**
   * Demonstrates using the AutoML client to get model evaluations.
   *
   * @param projectId the Id of the project.
   * @param computeRegion the Region name.
   * @param modelId the Id of the model.
   * @param modelEvaluationId the Id of your model evaluation.
   * @throws IOException on Input/Output errors.
   */
  public static void getModelEvaluation(
      String projectId, String computeRegion, String modelId, String modelEvaluationId)
      throws IOException {
    // Instantiates a client
    AutoMlClient client = AutoMlClient.create();

    // Get the full path of the model evaluation.
    ModelEvaluationName modelEvaluationFullId =
        ModelEvaluationName.of(projectId, computeRegion, modelId, modelEvaluationId);

    // Get complete detail of the model evaluation.
    ModelEvaluation response = client.getModelEvaluation(modelEvaluationFullId);

    System.out.println(response);
  }
  // [END automl_translate_get_model_evaluation]

  // [START automl_translate_delete_model]
  /**
   * Demonstrates using the AutoML client to delete a model.
   *
   * @param projectId the Id of the project.
   * @param computeRegion the Region name.
   * @param modelId the Id of the model.
   * @throws Exception on AutoML Client errors
   */
  public static void deleteModel(String projectId, String computeRegion, String modelId)
      throws InterruptedException, ExecutionException, IOException {
    // Instantiates a client
    AutoMlClient client = AutoMlClient.create();

    // Get the full path of the model.
    ModelName modelFullId = ModelName.of(projectId, computeRegion, modelId);

    // Delete a model.
    Empty response = client.deleteModelAsync(modelFullId).get();

    System.out.println("Model deletion started...");
  }
  // [END automl_translate_delete_model]

  // [START automl_translate_get_operation_status]
  /**
   * Demonstrates using the AutoML client to get operation status.
   *
   * @param operationFullId Full name of a operation. For example, the name of your operation is
   *     projects/[projectId]/locations/us-central1/operations/[operationId].
   * @throws IOException on Input/Output errors.
   */
  private static void getOperationStatus(String operationFullId) throws IOException {
    // Instantiates a client
    AutoMlClient client = AutoMlClient.create();

    // Get the latest state of a long-running operation.
    Operation response = client.getOperationsClient().getOperation(operationFullId);

    System.out.println(String.format("Operation status: %s", response));
  }
  // [END automl_translate_get_operation_status]

  public static void main(String[] args) throws Exception {
    ModelApi modelApi = new ModelApi();
    modelApi.argsHelper(args, System.out);
  }

  public static void argsHelper(String[] args, PrintStream out) throws Exception {

    ArgumentParser parser =
        ArgumentParsers.newFor("ModelApi")
            .build()
            .defaultHelp(true)
            .description("Model API operations");
    Subparsers subparsers = parser.addSubparsers().dest("command");

    Subparser createModelParser = subparsers.addParser("create_model");
    createModelParser.addArgument("datasetId");
    createModelParser.addArgument("modelName");

    Subparser listModelParser = subparsers.addParser("list_models");
    listModelParser.addArgument("filter").nargs("?").setDefault("");

    Subparser getModelParser = subparsers.addParser("get_model");
    getModelParser.addArgument("modelId");

    Subparser listModelEvaluationsParser = subparsers.addParser("list_model_evaluations");
    listModelEvaluationsParser.addArgument("modelId");
    listModelEvaluationsParser.addArgument("filter").nargs("?").setDefault("");

    Subparser getModelEvaluationParser = subparsers.addParser("get_model_evaluation");
    getModelEvaluationParser.addArgument("modelId");
    getModelEvaluationParser.addArgument("modelEvaluationId");

    Subparser deleteModelParser = subparsers.addParser("delete_model");
    deleteModelParser.addArgument("modelId");

    Subparser getOperationStatusParser = subparsers.addParser("get_operation_status");
    getOperationStatusParser.addArgument("operationFullId");

    String projectId = System.getenv("PROJECT_ID");
    String computeRegion = System.getenv("REGION_NAME");

    Namespace ns = null;
    try {
      ns = parser.parseArgs(args);
      if (ns.get("command").equals("create_model")) {
        createModel(projectId, computeRegion, ns.getString("datasetId"), ns.getString("modelName"));
      }
      if (ns.get("command").equals("list_models")) {
        listModels(projectId, computeRegion, ns.getString("filter"));
      }
      if (ns.get("command").equals("get_model")) {
        getModel(projectId, computeRegion, ns.getString("modelId"));
      }
      if (ns.get("command").equals("list_model_evaluations")) {
        listModelEvaluations(
            projectId, computeRegion, ns.getString("modelId"), ns.getString("filter"));
      }
      if (ns.get("command").equals("get_model_evaluation")) {
        getModelEvaluation(
            projectId, computeRegion, ns.getString("modelId"), ns.getString("modelEvaluationId"));
      }
      if (ns.get("command").equals("delete_model")) {
        deleteModel(projectId, computeRegion, ns.getString("modelId"));
      }
      if (ns.get("command").equals("get_operation_status")) {
        getOperationStatus(ns.getString("operationFullId"));
      }
    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
