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
import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.Dataset;
import com.google.cloud.automl.v1beta1.DatasetName;
import com.google.cloud.automl.v1beta1.GcsSource;
import com.google.cloud.automl.v1beta1.GcsSource.Builder;
import com.google.cloud.automl.v1beta1.InputConfig;
import com.google.cloud.automl.v1beta1.ListDatasetsRequest;
import com.google.cloud.automl.v1beta1.LocationName;
import com.google.cloud.automl.v1beta1.TranslationDatasetMetadata;
import com.google.protobuf.Empty;

import java.io.IOException;
import java.io.PrintStream;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;

/**
 * Google Cloud AutoML Translate API sample application. Example usage: mvn package exec:java
 * -Dexec.mainClass ='com.google.cloud.translate.samples.DatasetAPI' -Dexec.args='create_dataset
 * test_dataset'
 */
public class DatasetApi {

  // [START automl_translate_create_dataset]
  /**
   * Demonstrates using the AutoML client to create a dataset
   *
   * @param projectId the Google Cloud Project ID.
   * @param computeRegion the Region name. (e.g., "us-central1").
   * @param datasetName the name of the dataset to be created.
   * @param source the Source language
   * @param target the Target language
   * @throws IOException on Input/Output errors.
   */
  public static void createDataset(
      String projectId, String computeRegion, String datasetName, String source, String target)
      throws IOException {
    // Instantiates a client
    AutoMlClient client = AutoMlClient.create();

    // A resource that represents Google Cloud Platform location.
    LocationName projectLocation = LocationName.of(projectId, computeRegion);

    // Specify the source and target language.
    TranslationDatasetMetadata translationDatasetMetadata =
        TranslationDatasetMetadata.newBuilder()
            .setSourceLanguageCode(source)
            .setTargetLanguageCode(target)
            .build();

    // Set dataset name and dataset metadata.
    Dataset myDataset =
        Dataset.newBuilder()
            .setDisplayName(datasetName)
            .setTranslationDatasetMetadata(translationDatasetMetadata)
            .build();

    // Create a dataset with the dataset metadata in the region.
    Dataset dataset = client.createDataset(projectLocation, myDataset);

    // Display the dataset information.
    System.out.println(String.format("Dataset name: %s", dataset.getName()));
    System.out.println(
        String.format(
            "Dataset id: %s",
            dataset.getName().split("/")[dataset.getName().split("/").length - 1]));
    System.out.println(String.format("Dataset display name: %s", dataset.getDisplayName()));
    System.out.println("Translation dataset Metadata:");
    System.out.println(
        String.format(
            "\tSource language code: %s",
            dataset.getTranslationDatasetMetadata().getSourceLanguageCode()));
    System.out.println(
        String.format(
            "\tTarget language code: %s",
            dataset.getTranslationDatasetMetadata().getTargetLanguageCode()));
    System.out.println("Dataset create time:");
    System.out.println(String.format("\tseconds: %s", dataset.getCreateTime().getSeconds()));
    System.out.println(String.format("\tnanos: %s", dataset.getCreateTime().getNanos()));
  }
  // [END automl_translate_create_dataset]

  // [START automl_translate_list_datasets]
  /**
   * Demonstrates using the AutoML client to list all datasets.
   *
   * @param projectId the Google Cloud Project ID.
   * @param computeRegion the Region name. (e.g., "us-central1").
   * @param filter the Filter expression.
   * @throws Exception on AutoML Client errors
   */
  public static void listDatasets(String projectId, String computeRegion, String filter)
      throws IOException {
    // Instantiates a client
    AutoMlClient client = AutoMlClient.create();

    // A resource that represents Google Cloud Platform location.
    LocationName projectLocation = LocationName.of(projectId, computeRegion);

    ListDatasetsRequest request =
        ListDatasetsRequest.newBuilder()
            .setParent(projectLocation.toString())
            .setFilter(filter)
            .build();

    // List all the datasets available in the region by applying filter.
    System.out.println("List of datasets:");
    for (Dataset dataset : client.listDatasets(request).iterateAll()) {
      // Display the dataset information
      System.out.println(String.format("\nDataset name: %s", dataset.getName()));
      System.out.println(
          String.format(
              "Dataset id: %s",
              dataset.getName().split("/")[dataset.getName().split("/").length - 1]));
      System.out.println(String.format("Dataset display name: %s", dataset.getDisplayName()));
      System.out.println("Translation dataset metadata:");
      System.out.println(
          String.format(
              "\tSource language code: %s",
              dataset.getTranslationDatasetMetadata().getSourceLanguageCode()));
      System.out.println(
          String.format(
              "\tTarget language code: %s",
              dataset.getTranslationDatasetMetadata().getTargetLanguageCode()));
      System.out.println("Dataset create time:");
      System.out.println(String.format("\tseconds: %s", dataset.getCreateTime().getSeconds()));
      System.out.println(String.format("\tnanos: %s", dataset.getCreateTime().getNanos()));
    }
  }
  // [END automl_translate_list_datasets]

  // [START automl_translate_get_dataset]
  /**
   * Demonstrates using the AutoML client to get a dataset by ID.
   *
   * @param projectId the Google Cloud Project ID.
   * @param computeRegion the Region name. (e.g., "us-central1").
   * @param datasetId the Id of the dataset.
   * @throws Exception on AutoML Client errors
   */
  public static void getDataset(String projectId, String computeRegion, String datasetId)
      throws Exception {
    // Instantiates a client
    AutoMlClient client = AutoMlClient.create();

    // Get the complete path of the dataset.
    DatasetName datasetFullId = DatasetName.of(projectId, computeRegion, datasetId);

    // Get all the information about a given dataset.
    Dataset dataset = client.getDataset(datasetFullId);

    // Display the dataset information
    System.out.println(String.format("Dataset name: %s", dataset.getName()));
    System.out.println(
        String.format(
            "Dataset id: %s",
            dataset.getName().split("/")[dataset.getName().split("/").length - 1]));
    System.out.println(String.format("Dataset display name: %s", dataset.getDisplayName()));
    System.out.println("Translation dataset metadata:");
    System.out.println(
        String.format(
            "\tSource language code: %s",
            dataset.getTranslationDatasetMetadata().getSourceLanguageCode()));
    System.out.println(
        String.format(
            "\tTarget language code: %s",
            dataset.getTranslationDatasetMetadata().getTargetLanguageCode()));
    System.out.println("Dataset create time:");
    System.out.println(String.format("\tseconds: %s", dataset.getCreateTime().getSeconds()));
    System.out.println(String.format("\tnanos: %s", dataset.getCreateTime().getNanos()));
  }
  // [END automl_translate_get_dataset]

  // [START automl_translate_import_data]
  /**
   * Import sentence pairs to the dataset.
   *
   * @param projectId the Google Cloud Project ID.
   * @param computeRegion the Region name. (e.g., "us-central1").
   * @param datasetId the Id of the dataset.
   * @param path the remote Path of the training data csv file.
   * @throws Exception on AutoML Client errors
   */
  public static void importData(
      String projectId, String computeRegion, String datasetId, String path) throws Exception {
    // Instantiates a client
    AutoMlClient client = AutoMlClient.create();

    // Get the complete path of the dataset.
    DatasetName datasetFullId = DatasetName.of(projectId, computeRegion, datasetId);

    Builder gcsSource = GcsSource.newBuilder();

    // Get multiple Google Cloud Storage URIs to import data from
    String[] inputUris = path.split(",");
    for (String inputUri : inputUris) {
      gcsSource.addInputUris(inputUri);
    }

    // Import data from the input URI
    InputConfig inputConfig = InputConfig.newBuilder().setGcsSource(gcsSource).build();
    System.out.println("Processing import...");

    Empty response = client.importDataAsync(datasetFullId, inputConfig).get();
    System.out.println(String.format("Dataset imported. %s", response));
  }
  // [END automl_translate_import_data]

  // [START automl_translate_delete_dataset]
  /**
   * Delete a dataset.
   *
   * @param projectId the Google Cloud Project ID.
   * @param computeRegion the Region name. (e.g., "us-central1").
   * @param datasetId the Id of the dataset.
   * @throws Exception on AutoML Client errors
   */
  public static void deleteDataset(String projectId, String computeRegion, String datasetId)
      throws Exception {
    // Instantiates a client
    AutoMlClient client = AutoMlClient.create();

    // Get the full path of the dataset.
    DatasetName datasetFullId = DatasetName.of(projectId, computeRegion, datasetId);

    // Delete a dataset.
    Empty response = client.deleteDatasetAsync(datasetFullId).get();

    System.out.println(String.format("Dataset deleted. %s", response));
  }
  // [END automl_translate_delete_dataset]

  public static void main(String[] args) throws Exception {
    DatasetApi datasetApi = new DatasetApi();
    datasetApi.argsHelper(args, System.out);
  }

  public static void argsHelper(String[] args, PrintStream out) throws Exception {
    ArgumentParser parser = ArgumentParsers.newFor("").build();
    Subparsers subparsers = parser.addSubparsers().dest("command");

    Subparser createDatasetParser = subparsers.addParser("create_dataset");
    createDatasetParser.addArgument("datasetName");
    createDatasetParser.addArgument("source");
    createDatasetParser.addArgument("target");

    Subparser listDatasetParser = subparsers.addParser("list_datasets");
    listDatasetParser.addArgument("filter").nargs("?").setDefault("translation_dataset_metadata:*");

    Subparser getDatasetParser = subparsers.addParser("get_dataset");
    getDatasetParser.addArgument("datasetId");

    Subparser importDataParser = subparsers.addParser("import_data");
    importDataParser.addArgument("datasetId");
    importDataParser.addArgument("path");

    Subparser deleteDatasetParser = subparsers.addParser("delete_dataset");
    deleteDatasetParser.addArgument("datasetId");

    String projectId = System.getenv("PROJECT_ID");
    String computeRegion = System.getenv("REGION_NAME");

    Namespace ns = null;
    try {
      ns = parser.parseArgs(args);
      if (ns.get("command").equals("create_dataset")) {
        createDataset(
            projectId,
            computeRegion,
            ns.getString("datasetName"),
            ns.getString("source"),
            ns.getString("target"));
      }
      if (ns.get("command").equals("list_datasets")) {
        listDatasets(projectId, computeRegion, ns.getString("filter"));
      }
      if (ns.get("command").equals("get_dataset")) {
        getDataset(projectId, computeRegion, ns.getString("datasetId"));
      }
      if (ns.get("command").equals("import_data")) {
        importData(projectId, computeRegion, ns.getString("datasetId"), ns.getString("path"));
      }
      if (ns.get("command").equals("delete_dataset")) {
        deleteDataset(projectId, computeRegion, ns.getString("datasetId"));
      }
    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
